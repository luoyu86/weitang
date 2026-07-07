package com.bumptech.glide.load.engine.bitmap_recycle;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.os.Build;
import android.util.Log;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class LruBitmapPool implements BitmapPool {
    private static final Bitmap.Config DEFAULT_CONFIG = Bitmap.Config.ARGB_8888;
    private static final String TAG = "LruBitmapPool";
    private final Set<Bitmap.Config> allowedConfigs;
    private int currentSize;
    private int evictions;
    private int hits;
    private final int initialMaxSize;
    private int maxSize;
    private int misses;
    private int puts;
    private final LruPoolStrategy strategy;
    private final BitmapTracker tracker;

    public interface BitmapTracker {
        void add(Bitmap bitmap);

        void remove(Bitmap bitmap);
    }

    public static class NullBitmapTracker implements BitmapTracker {
        private NullBitmapTracker() {
        }

        @Override // com.bumptech.glide.load.engine.bitmap_recycle.LruBitmapPool.BitmapTracker
        public void add(Bitmap bitmap) {
        }

        @Override // com.bumptech.glide.load.engine.bitmap_recycle.LruBitmapPool.BitmapTracker
        public void remove(Bitmap bitmap) {
        }
    }

    public static class ThrowingBitmapTracker implements BitmapTracker {
        private final Set<Bitmap> bitmaps = Collections.synchronizedSet(new HashSet());

        private ThrowingBitmapTracker() {
        }

        @Override // com.bumptech.glide.load.engine.bitmap_recycle.LruBitmapPool.BitmapTracker
        public void add(Bitmap bitmap) {
            if (!this.bitmaps.contains(bitmap)) {
                this.bitmaps.add(bitmap);
                return;
            }
            throw new IllegalStateException("Can't add already added bitmap: " + bitmap + " [" + bitmap.getWidth() + "x" + bitmap.getHeight() + "]");
        }

        @Override // com.bumptech.glide.load.engine.bitmap_recycle.LruBitmapPool.BitmapTracker
        public void remove(Bitmap bitmap) {
            if (!this.bitmaps.contains(bitmap)) {
                throw new IllegalStateException("Cannot remove bitmap not in tracker");
            }
            this.bitmaps.remove(bitmap);
        }
    }

    public LruBitmapPool(int i2, LruPoolStrategy lruPoolStrategy, Set<Bitmap.Config> set) {
        this.initialMaxSize = i2;
        this.maxSize = i2;
        this.strategy = lruPoolStrategy;
        this.allowedConfigs = set;
        this.tracker = new NullBitmapTracker();
    }

    private void dump() {
        if (Log.isLoggable(TAG, 2)) {
            dumpUnchecked();
        }
    }

    private void dumpUnchecked() {
        Log.v(TAG, "Hits=" + this.hits + ", misses=" + this.misses + ", puts=" + this.puts + ", evictions=" + this.evictions + ", currentSize=" + this.currentSize + ", maxSize=" + this.maxSize + "\nStrategy=" + this.strategy);
    }

    private void evict() {
        trimToSize(this.maxSize);
    }

    private static Set<Bitmap.Config> getDefaultAllowedConfigs() {
        HashSet hashSet = new HashSet();
        hashSet.addAll(Arrays.asList(Bitmap.Config.values()));
        if (Build.VERSION.SDK_INT >= 19) {
            hashSet.add(null);
        }
        return Collections.unmodifiableSet(hashSet);
    }

    private static LruPoolStrategy getDefaultStrategy() {
        return Build.VERSION.SDK_INT >= 19 ? new SizeConfigStrategy() : new AttributeStrategy();
    }

    private synchronized void trimToSize(int i2) {
        while (this.currentSize > i2) {
            Bitmap bitmapRemoveLast = this.strategy.removeLast();
            if (bitmapRemoveLast == null) {
                if (Log.isLoggable(TAG, 5)) {
                    Log.w(TAG, "Size mismatch, resetting");
                    dumpUnchecked();
                }
                this.currentSize = 0;
                return;
            }
            this.tracker.remove(bitmapRemoveLast);
            this.currentSize -= this.strategy.getSize(bitmapRemoveLast);
            bitmapRemoveLast.recycle();
            this.evictions++;
            if (Log.isLoggable(TAG, 3)) {
                Log.d(TAG, "Evicting bitmap=" + this.strategy.logBitmap(bitmapRemoveLast));
            }
            dump();
        }
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool
    public void clearMemory() {
        if (Log.isLoggable(TAG, 3)) {
            Log.d(TAG, "clearMemory");
        }
        trimToSize(0);
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool
    public synchronized Bitmap get(int i2, int i3, Bitmap.Config config) {
        Bitmap dirty;
        dirty = getDirty(i2, i3, config);
        if (dirty != null) {
            dirty.eraseColor(0);
        }
        return dirty;
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool
    @TargetApi(12)
    public synchronized Bitmap getDirty(int i2, int i3, Bitmap.Config config) {
        Bitmap bitmap;
        bitmap = this.strategy.get(i2, i3, config != null ? config : DEFAULT_CONFIG);
        if (bitmap == null) {
            if (Log.isLoggable(TAG, 3)) {
                Log.d(TAG, "Missing bitmap=" + this.strategy.logBitmap(i2, i3, config));
            }
            this.misses++;
        } else {
            this.hits++;
            this.currentSize -= this.strategy.getSize(bitmap);
            this.tracker.remove(bitmap);
            if (Build.VERSION.SDK_INT >= 12) {
                bitmap.setHasAlpha(true);
            }
        }
        if (Log.isLoggable(TAG, 2)) {
            Log.v(TAG, "Get bitmap=" + this.strategy.logBitmap(i2, i3, config));
        }
        dump();
        return bitmap;
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool
    public int getMaxSize() {
        return this.maxSize;
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool
    public synchronized boolean put(Bitmap bitmap) {
        if (bitmap == null) {
            throw new NullPointerException("Bitmap must not be null");
        }
        if (bitmap.isMutable() && this.strategy.getSize(bitmap) <= this.maxSize && this.allowedConfigs.contains(bitmap.getConfig())) {
            int size = this.strategy.getSize(bitmap);
            this.strategy.put(bitmap);
            this.tracker.add(bitmap);
            this.puts++;
            this.currentSize += size;
            if (Log.isLoggable(TAG, 2)) {
                Log.v(TAG, "Put bitmap in pool=" + this.strategy.logBitmap(bitmap));
            }
            dump();
            evict();
            return true;
        }
        if (Log.isLoggable(TAG, 2)) {
            Log.v(TAG, "Reject bitmap from pool, bitmap: " + this.strategy.logBitmap(bitmap) + ", is mutable: " + bitmap.isMutable() + ", is allowed config: " + this.allowedConfigs.contains(bitmap.getConfig()));
        }
        return false;
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool
    public synchronized void setSizeMultiplier(float f2) {
        this.maxSize = Math.round(this.initialMaxSize * f2);
        evict();
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool
    @SuppressLint({"InlinedApi"})
    public void trimMemory(int i2) {
        if (Log.isLoggable(TAG, 3)) {
            Log.d(TAG, "trimMemory, level=" + i2);
        }
        if (i2 >= 60) {
            clearMemory();
        } else if (i2 >= 40) {
            trimToSize(this.maxSize / 2);
        }
    }

    public LruBitmapPool(int i2) {
        this(i2, getDefaultStrategy(), getDefaultAllowedConfigs());
    }

    public LruBitmapPool(int i2, Set<Bitmap.Config> set) {
        this(i2, getDefaultStrategy(), set);
    }
}
