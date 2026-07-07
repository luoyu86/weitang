package com.bumptech.glide.load.resource.gif;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.Gravity;
import com.bumptech.glide.gifdecoder.GifDecoder;
import com.bumptech.glide.gifdecoder.GifHeader;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.load.resource.gif.GifFrameLoader;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public class GifDrawable extends GlideDrawable implements GifFrameLoader.FrameCallback {
    private boolean applyGravity;
    private final GifDecoder decoder;
    private final Rect destRect;
    private final GifFrameLoader frameLoader;
    private boolean isRecycled;
    private boolean isRunning;
    private boolean isStarted;
    private boolean isVisible;
    private int loopCount;
    private int maxLoopCount;
    private final Paint paint;
    private final GifState state;

    public static class GifState extends Drawable.ConstantState {
        private static final int GRAVITY = 119;
        public BitmapPool bitmapPool;
        public GifDecoder.BitmapProvider bitmapProvider;
        public Context context;
        public byte[] data;
        public Bitmap firstFrame;
        public Transformation<Bitmap> frameTransformation;
        public GifHeader gifHeader;
        public int targetHeight;
        public int targetWidth;

        public GifState(GifHeader gifHeader, byte[] bArr, Context context, Transformation<Bitmap> transformation, int i2, int i3, GifDecoder.BitmapProvider bitmapProvider, BitmapPool bitmapPool, Bitmap bitmap) {
            Objects.requireNonNull(bitmap, "The first frame of the GIF must not be null");
            this.gifHeader = gifHeader;
            this.data = bArr;
            this.bitmapPool = bitmapPool;
            this.firstFrame = bitmap;
            this.context = context.getApplicationContext();
            this.frameTransformation = transformation;
            this.targetWidth = i2;
            this.targetHeight = i3;
            this.bitmapProvider = bitmapProvider;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return 0;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            return newDrawable();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            return new GifDrawable(this);
        }

        public GifState(GifState gifState) {
            if (gifState != null) {
                this.gifHeader = gifState.gifHeader;
                this.data = gifState.data;
                this.context = gifState.context;
                this.frameTransformation = gifState.frameTransformation;
                this.targetWidth = gifState.targetWidth;
                this.targetHeight = gifState.targetHeight;
                this.bitmapProvider = gifState.bitmapProvider;
                this.bitmapPool = gifState.bitmapPool;
                this.firstFrame = gifState.firstFrame;
            }
        }
    }

    public GifDrawable(Context context, GifDecoder.BitmapProvider bitmapProvider, BitmapPool bitmapPool, Transformation<Bitmap> transformation, int i2, int i3, GifHeader gifHeader, byte[] bArr, Bitmap bitmap) {
        this(new GifState(gifHeader, bArr, context, transformation, i2, i3, bitmapProvider, bitmapPool, bitmap));
    }

    private void reset() {
        this.frameLoader.clear();
        invalidateSelf();
    }

    private void resetLoopCount() {
        this.loopCount = 0;
    }

    private void startRunning() {
        if (this.decoder.getFrameCount() == 1) {
            invalidateSelf();
        } else {
            if (this.isRunning) {
                return;
            }
            this.isRunning = true;
            this.frameLoader.start();
            invalidateSelf();
        }
    }

    private void stopRunning() {
        this.isRunning = false;
        this.frameLoader.stop();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.isRecycled) {
            return;
        }
        if (this.applyGravity) {
            Gravity.apply(119, getIntrinsicWidth(), getIntrinsicHeight(), getBounds(), this.destRect);
            this.applyGravity = false;
        }
        Bitmap currentFrame = this.frameLoader.getCurrentFrame();
        if (currentFrame == null) {
            currentFrame = this.state.firstFrame;
        }
        canvas.drawBitmap(currentFrame, (Rect) null, this.destRect, this.paint);
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        return this.state;
    }

    public byte[] getData() {
        return this.state.data;
    }

    public GifDecoder getDecoder() {
        return this.decoder;
    }

    public Bitmap getFirstFrame() {
        return this.state.firstFrame;
    }

    public int getFrameCount() {
        return this.decoder.getFrameCount();
    }

    public Transformation<Bitmap> getFrameTransformation() {
        return this.state.frameTransformation;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.state.firstFrame.getHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.state.firstFrame.getWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -2;
    }

    @Override // com.bumptech.glide.load.resource.drawable.GlideDrawable
    public boolean isAnimated() {
        return true;
    }

    public boolean isRecycled() {
        return this.isRecycled;
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.isRunning;
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.applyGravity = true;
    }

    @Override // com.bumptech.glide.load.resource.gif.GifFrameLoader.FrameCallback
    @TargetApi(11)
    public void onFrameReady(int i2) {
        if (Build.VERSION.SDK_INT >= 11 && getCallback() == null) {
            stop();
            reset();
            return;
        }
        invalidateSelf();
        if (i2 == this.decoder.getFrameCount() - 1) {
            this.loopCount++;
        }
        int i3 = this.maxLoopCount;
        if (i3 == -1 || this.loopCount < i3) {
            return;
        }
        stop();
    }

    public void recycle() {
        this.isRecycled = true;
        GifState gifState = this.state;
        gifState.bitmapPool.put(gifState.firstFrame);
        this.frameLoader.clear();
        this.frameLoader.stop();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i2) {
        this.paint.setAlpha(i2);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.paint.setColorFilter(colorFilter);
    }

    public void setFrameTransformation(Transformation<Bitmap> transformation, Bitmap bitmap) {
        Objects.requireNonNull(bitmap, "The first frame of the GIF must not be null");
        Objects.requireNonNull(transformation, "The frame transformation must not be null");
        GifState gifState = this.state;
        gifState.frameTransformation = transformation;
        gifState.firstFrame = bitmap;
        this.frameLoader.setFrameTransformation(transformation);
    }

    public void setIsRunning(boolean z) {
        this.isRunning = z;
    }

    @Override // com.bumptech.glide.load.resource.drawable.GlideDrawable
    public void setLoopCount(int i2) {
        if (i2 <= 0 && i2 != -1 && i2 != 0) {
            throw new IllegalArgumentException("Loop count must be greater than 0, or equal to GlideDrawable.LOOP_FOREVER, or equal to GlideDrawable.LOOP_INTRINSIC");
        }
        if (i2 == 0) {
            this.maxLoopCount = this.decoder.getLoopCount();
        } else {
            this.maxLoopCount = i2;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        this.isVisible = z;
        if (!z) {
            stopRunning();
        } else if (this.isStarted) {
            startRunning();
        }
        return super.setVisible(z, z2);
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        this.isStarted = true;
        resetLoopCount();
        if (this.isVisible) {
            startRunning();
        }
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        this.isStarted = false;
        stopRunning();
        if (Build.VERSION.SDK_INT < 11) {
            reset();
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public GifDrawable(GifDrawable gifDrawable, Bitmap bitmap, Transformation<Bitmap> transformation) {
        GifState gifState = gifDrawable.state;
        this(new GifState(gifState.gifHeader, gifState.data, gifState.context, transformation, gifState.targetWidth, gifState.targetHeight, gifState.bitmapProvider, gifState.bitmapPool, bitmap));
    }

    public GifDrawable(GifState gifState) {
        this.destRect = new Rect();
        this.isVisible = true;
        this.maxLoopCount = -1;
        Objects.requireNonNull(gifState, "GifState must not be null");
        this.state = gifState;
        GifDecoder gifDecoder = new GifDecoder(gifState.bitmapProvider);
        this.decoder = gifDecoder;
        this.paint = new Paint();
        gifDecoder.setData(gifState.gifHeader, gifState.data);
        GifFrameLoader gifFrameLoader = new GifFrameLoader(gifState.context, this, gifDecoder, gifState.targetWidth, gifState.targetHeight);
        this.frameLoader = gifFrameLoader;
        gifFrameLoader.setFrameTransformation(gifState.frameTransformation);
    }

    public GifDrawable(GifDecoder gifDecoder, GifFrameLoader gifFrameLoader, Bitmap bitmap, BitmapPool bitmapPool, Paint paint) {
        this.destRect = new Rect();
        this.isVisible = true;
        this.maxLoopCount = -1;
        this.decoder = gifDecoder;
        this.frameLoader = gifFrameLoader;
        GifState gifState = new GifState(null);
        this.state = gifState;
        this.paint = paint;
        gifState.bitmapPool = bitmapPool;
        gifState.firstFrame = bitmap;
    }
}
