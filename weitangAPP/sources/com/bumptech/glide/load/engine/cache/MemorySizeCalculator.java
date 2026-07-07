package com.bumptech.glide.load.engine.cache;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.text.format.Formatter;
import android.util.DisplayMetrics;
import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
public class MemorySizeCalculator {
    public static final int BITMAP_POOL_TARGET_SCREENS = 4;
    public static final int BYTES_PER_ARGB_8888_PIXEL = 4;
    public static final float LOW_MEMORY_MAX_SIZE_MULTIPLIER = 0.33f;
    public static final float MAX_SIZE_MULTIPLIER = 0.4f;
    public static final int MEMORY_CACHE_TARGET_SCREENS = 2;
    private static final String TAG = "MemorySizeCalculator";
    private final int bitmapPoolSize;
    private final Context context;
    private final int memoryCacheSize;

    public static class DisplayMetricsScreenDimensions implements ScreenDimensions {
        private final DisplayMetrics displayMetrics;

        public DisplayMetricsScreenDimensions(DisplayMetrics displayMetrics) {
            this.displayMetrics = displayMetrics;
        }

        @Override // com.bumptech.glide.load.engine.cache.MemorySizeCalculator.ScreenDimensions
        public int getHeightPixels() {
            return this.displayMetrics.heightPixels;
        }

        @Override // com.bumptech.glide.load.engine.cache.MemorySizeCalculator.ScreenDimensions
        public int getWidthPixels() {
            return this.displayMetrics.widthPixels;
        }
    }

    public interface ScreenDimensions {
        int getHeightPixels();

        int getWidthPixels();
    }

    public MemorySizeCalculator(Context context) {
        this(context, (ActivityManager) context.getSystemService("activity"), new DisplayMetricsScreenDimensions(context.getResources().getDisplayMetrics()));
    }

    private static int getMaxSize(ActivityManager activityManager) {
        return Math.round(activityManager.getMemoryClass() * 1024 * 1024 * (isLowMemoryDevice(activityManager) ? 0.33f : 0.4f));
    }

    @TargetApi(19)
    private static boolean isLowMemoryDevice(ActivityManager activityManager) {
        int i2 = Build.VERSION.SDK_INT;
        return i2 >= 19 ? activityManager.isLowRamDevice() : i2 < 11;
    }

    private String toMb(int i2) {
        return Formatter.formatFileSize(this.context, i2);
    }

    public int getBitmapPoolSize() {
        return this.bitmapPoolSize;
    }

    public int getMemoryCacheSize() {
        return this.memoryCacheSize;
    }

    public MemorySizeCalculator(Context context, ActivityManager activityManager, ScreenDimensions screenDimensions) {
        this.context = context;
        int maxSize = getMaxSize(activityManager);
        int widthPixels = screenDimensions.getWidthPixels() * screenDimensions.getHeightPixels() * 4;
        int i2 = widthPixels * 4;
        int i3 = widthPixels * 2;
        int i4 = i3 + i2;
        if (i4 <= maxSize) {
            this.memoryCacheSize = i3;
            this.bitmapPoolSize = i2;
        } else {
            int iRound = Math.round(maxSize / 6.0f);
            this.memoryCacheSize = iRound * 2;
            this.bitmapPoolSize = iRound * 4;
        }
        if (Log.isLoggable(TAG, 3)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Calculated memory cache size: ");
            sb.append(toMb(this.memoryCacheSize));
            sb.append(" pool size: ");
            sb.append(toMb(this.bitmapPoolSize));
            sb.append(" memory class limited? ");
            sb.append(i4 > maxSize);
            sb.append(" max size: ");
            sb.append(toMb(maxSize));
            sb.append(" memoryClass: ");
            sb.append(activityManager.getMemoryClass());
            sb.append(" isLowMemoryDevice: ");
            sb.append(isLowMemoryDevice(activityManager));
            Log.d(TAG, sb.toString());
        }
    }
}
