package com.bumptech.glide.load.resource.bitmap;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.util.Log;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.ImageHeaderParser;
import com.bumptech.glide.util.ByteArrayPool;
import com.bumptech.glide.util.ExceptionCatchingInputStream;
import com.bumptech.glide.util.MarkEnforcingInputStream;
import com.bumptech.glide.util.Util;
import java.io.IOException;
import java.io.InputStream;
import java.util.EnumSet;
import java.util.Queue;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public abstract class Downsampler implements BitmapDecoder<InputStream> {
    private static final int MARK_POSITION = 5242880;
    private static final String TAG = "Downsampler";
    private static final Set<ImageHeaderParser.ImageType> TYPES_THAT_USE_POOL = EnumSet.of(ImageHeaderParser.ImageType.JPEG, ImageHeaderParser.ImageType.PNG_A, ImageHeaderParser.ImageType.PNG);
    private static final Queue<BitmapFactory.Options> OPTIONS_QUEUE = Util.createQueue(0);
    public static final Downsampler AT_LEAST = new Downsampler() { // from class: com.bumptech.glide.load.resource.bitmap.Downsampler.1
        @Override // com.bumptech.glide.load.resource.bitmap.Downsampler, com.bumptech.glide.load.resource.bitmap.BitmapDecoder
        public /* bridge */ /* synthetic */ Bitmap decode(InputStream inputStream, BitmapPool bitmapPool, int i2, int i3, DecodeFormat decodeFormat) throws Exception {
            return super.decode(inputStream, bitmapPool, i2, i3, decodeFormat);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.BitmapDecoder
        public String getId() {
            return "AT_LEAST.com.bumptech.glide.load.data.bitmap";
        }

        @Override // com.bumptech.glide.load.resource.bitmap.Downsampler
        public int getSampleSize(int i2, int i3, int i4, int i5) {
            return Math.min(i3 / i5, i2 / i4);
        }
    };
    public static final Downsampler AT_MOST = new Downsampler() { // from class: com.bumptech.glide.load.resource.bitmap.Downsampler.2
        @Override // com.bumptech.glide.load.resource.bitmap.Downsampler, com.bumptech.glide.load.resource.bitmap.BitmapDecoder
        public /* bridge */ /* synthetic */ Bitmap decode(InputStream inputStream, BitmapPool bitmapPool, int i2, int i3, DecodeFormat decodeFormat) throws Exception {
            return super.decode(inputStream, bitmapPool, i2, i3, decodeFormat);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.BitmapDecoder
        public String getId() {
            return "AT_MOST.com.bumptech.glide.load.data.bitmap";
        }

        @Override // com.bumptech.glide.load.resource.bitmap.Downsampler
        public int getSampleSize(int i2, int i3, int i4, int i5) {
            int iCeil = (int) Math.ceil(Math.max(i3 / i5, i2 / i4));
            int iMax = Math.max(1, Integer.highestOneBit(iCeil));
            return iMax << (iMax >= iCeil ? 0 : 1);
        }
    };
    public static final Downsampler NONE = new Downsampler() { // from class: com.bumptech.glide.load.resource.bitmap.Downsampler.3
        @Override // com.bumptech.glide.load.resource.bitmap.Downsampler, com.bumptech.glide.load.resource.bitmap.BitmapDecoder
        public /* bridge */ /* synthetic */ Bitmap decode(InputStream inputStream, BitmapPool bitmapPool, int i2, int i3, DecodeFormat decodeFormat) throws Exception {
            return super.decode(inputStream, bitmapPool, i2, i3, decodeFormat);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.BitmapDecoder
        public String getId() {
            return "NONE.com.bumptech.glide.load.data.bitmap";
        }

        @Override // com.bumptech.glide.load.resource.bitmap.Downsampler
        public int getSampleSize(int i2, int i3, int i4, int i5) {
            return 0;
        }
    };

    private static Bitmap decodeStream(MarkEnforcingInputStream markEnforcingInputStream, RecyclableBufferedInputStream recyclableBufferedInputStream, BitmapFactory.Options options) {
        if (options.inJustDecodeBounds) {
            markEnforcingInputStream.mark(5242880);
        } else {
            recyclableBufferedInputStream.fixMarkLimit();
        }
        Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(markEnforcingInputStream, null, options);
        try {
            if (options.inJustDecodeBounds) {
                markEnforcingInputStream.reset();
            }
        } catch (IOException e2) {
            if (Log.isLoggable(TAG, 6)) {
                Log.e(TAG, "Exception loading inDecodeBounds=" + options.inJustDecodeBounds + " sample=" + options.inSampleSize, e2);
            }
        }
        return bitmapDecodeStream;
    }

    private Bitmap downsampleWithSize(MarkEnforcingInputStream markEnforcingInputStream, RecyclableBufferedInputStream recyclableBufferedInputStream, BitmapFactory.Options options, BitmapPool bitmapPool, int i2, int i3, int i4, DecodeFormat decodeFormat) {
        Bitmap.Config config = getConfig(markEnforcingInputStream, decodeFormat);
        options.inSampleSize = i4;
        options.inPreferredConfig = config;
        if ((i4 == 1 || 19 <= Build.VERSION.SDK_INT) && shouldUsePool(markEnforcingInputStream)) {
            double d2 = i4;
            setInBitmap(options, bitmapPool.getDirty((int) Math.ceil(((double) i2) / d2), (int) Math.ceil(((double) i3) / d2), config));
        }
        return decodeStream(markEnforcingInputStream, recyclableBufferedInputStream, options);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x002e A[PHI: r2 r7
  0x002e: PHI (r2v6 boolean) = (r2v3 boolean), (r2v8 boolean) binds: [B:27:0x0058, B:15:0x002c] A[DONT_GENERATE, DONT_INLINE]
  0x002e: PHI (r7v4 'e' java.io.IOException) = (r7v2 'e' java.io.IOException), (r7v7 'e' java.io.IOException) binds: [B:27:0x0058, B:15:0x002c] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static android.graphics.Bitmap.Config getConfig(java.io.InputStream r7, com.bumptech.glide.load.DecodeFormat r8) {
        /*
            java.lang.String r0 = "Cannot reset the input stream"
            java.lang.String r1 = "Downsampler"
            com.bumptech.glide.load.DecodeFormat r2 = com.bumptech.glide.load.DecodeFormat.ALWAYS_ARGB_8888
            if (r8 == r2) goto L72
            com.bumptech.glide.load.DecodeFormat r2 = com.bumptech.glide.load.DecodeFormat.PREFER_ARGB_8888
            if (r8 == r2) goto L72
            int r2 = android.os.Build.VERSION.SDK_INT
            r3 = 16
            if (r2 != r3) goto L13
            goto L72
        L13:
            r2 = 0
            r3 = 1024(0x400, float:1.435E-42)
            r7.mark(r3)
            r3 = 5
            com.bumptech.glide.load.resource.bitmap.ImageHeaderParser r4 = new com.bumptech.glide.load.resource.bitmap.ImageHeaderParser     // Catch: java.lang.Throwable -> L32 java.io.IOException -> L34
            r4.<init>(r7)     // Catch: java.lang.Throwable -> L32 java.io.IOException -> L34
            boolean r2 = r4.hasAlpha()     // Catch: java.lang.Throwable -> L32 java.io.IOException -> L34
            r7.reset()     // Catch: java.io.IOException -> L27
            goto L5b
        L27:
            r7 = move-exception
            boolean r8 = android.util.Log.isLoggable(r1, r3)
            if (r8 == 0) goto L5b
        L2e:
            android.util.Log.w(r1, r0, r7)
            goto L5b
        L32:
            r8 = move-exception
            goto L63
        L34:
            r4 = move-exception
            boolean r5 = android.util.Log.isLoggable(r1, r3)     // Catch: java.lang.Throwable -> L32
            if (r5 == 0) goto L4f
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L32
            r5.<init>()     // Catch: java.lang.Throwable -> L32
            java.lang.String r6 = "Cannot determine whether the image has alpha or not from header for format "
            r5.append(r6)     // Catch: java.lang.Throwable -> L32
            r5.append(r8)     // Catch: java.lang.Throwable -> L32
            java.lang.String r8 = r5.toString()     // Catch: java.lang.Throwable -> L32
            android.util.Log.w(r1, r8, r4)     // Catch: java.lang.Throwable -> L32
        L4f:
            r7.reset()     // Catch: java.io.IOException -> L53
            goto L5b
        L53:
            r7 = move-exception
            boolean r8 = android.util.Log.isLoggable(r1, r3)
            if (r8 == 0) goto L5b
            goto L2e
        L5b:
            if (r2 == 0) goto L60
            android.graphics.Bitmap$Config r7 = android.graphics.Bitmap.Config.ARGB_8888
            goto L62
        L60:
            android.graphics.Bitmap$Config r7 = android.graphics.Bitmap.Config.RGB_565
        L62:
            return r7
        L63:
            r7.reset()     // Catch: java.io.IOException -> L67
            goto L71
        L67:
            r7 = move-exception
            boolean r2 = android.util.Log.isLoggable(r1, r3)
            if (r2 == 0) goto L71
            android.util.Log.w(r1, r0, r7)
        L71:
            throw r8
        L72:
            android.graphics.Bitmap$Config r7 = android.graphics.Bitmap.Config.ARGB_8888
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.resource.bitmap.Downsampler.getConfig(java.io.InputStream, com.bumptech.glide.load.DecodeFormat):android.graphics.Bitmap$Config");
    }

    @TargetApi(11)
    private static synchronized BitmapFactory.Options getDefaultOptions() {
        BitmapFactory.Options optionsPoll;
        Queue<BitmapFactory.Options> queue = OPTIONS_QUEUE;
        synchronized (queue) {
            optionsPoll = queue.poll();
        }
        if (optionsPoll == null) {
            optionsPoll = new BitmapFactory.Options();
            resetOptions(optionsPoll);
        }
        return optionsPoll;
    }

    private int getRoundedSampleSize(int i2, int i3, int i4, int i5, int i6) {
        if (i6 == Integer.MIN_VALUE) {
            i6 = i4;
        }
        if (i5 == Integer.MIN_VALUE) {
            i5 = i3;
        }
        int sampleSize = (i2 == 90 || i2 == 270) ? getSampleSize(i4, i3, i5, i6) : getSampleSize(i3, i4, i5, i6);
        return Math.max(1, sampleSize == 0 ? 0 : Integer.highestOneBit(sampleSize));
    }

    private static void releaseOptions(BitmapFactory.Options options) {
        resetOptions(options);
        Queue<BitmapFactory.Options> queue = OPTIONS_QUEUE;
        synchronized (queue) {
            queue.offer(options);
        }
    }

    @TargetApi(11)
    private static void resetOptions(BitmapFactory.Options options) {
        options.inTempStorage = null;
        options.inDither = false;
        options.inScaled = false;
        options.inSampleSize = 1;
        options.inPreferredConfig = null;
        options.inJustDecodeBounds = false;
        options.outWidth = 0;
        options.outHeight = 0;
        options.outMimeType = null;
        if (11 <= Build.VERSION.SDK_INT) {
            options.inBitmap = null;
            options.inMutable = true;
        }
    }

    @TargetApi(11)
    private static void setInBitmap(BitmapFactory.Options options, Bitmap bitmap) {
        if (11 <= Build.VERSION.SDK_INT) {
            options.inBitmap = bitmap;
        }
    }

    private static boolean shouldUsePool(InputStream inputStream) {
        if (19 <= Build.VERSION.SDK_INT) {
            return true;
        }
        inputStream.mark(1024);
        try {
            try {
                return TYPES_THAT_USE_POOL.contains(new ImageHeaderParser(inputStream).getType());
            } catch (IOException e2) {
                if (Log.isLoggable(TAG, 5)) {
                    Log.w(TAG, "Cannot determine the image type from header", e2);
                }
                try {
                    inputStream.reset();
                    return false;
                } catch (IOException e3) {
                    if (!Log.isLoggable(TAG, 5)) {
                        return false;
                    }
                    Log.w(TAG, "Cannot reset the input stream", e3);
                    return false;
                }
            }
        } finally {
            try {
                inputStream.reset();
            } catch (IOException e4) {
                if (Log.isLoggable(TAG, 5)) {
                    Log.w(TAG, "Cannot reset the input stream", e4);
                }
            }
        }
    }

    public int[] getDimensions(MarkEnforcingInputStream markEnforcingInputStream, RecyclableBufferedInputStream recyclableBufferedInputStream, BitmapFactory.Options options) {
        options.inJustDecodeBounds = true;
        decodeStream(markEnforcingInputStream, recyclableBufferedInputStream, options);
        options.inJustDecodeBounds = false;
        return new int[]{options.outWidth, options.outHeight};
    }

    public abstract int getSampleSize(int i2, int i3, int i4, int i5);

    @Override // com.bumptech.glide.load.resource.bitmap.BitmapDecoder
    public Bitmap decode(InputStream inputStream, BitmapPool bitmapPool, int i2, int i3, DecodeFormat decodeFormat) {
        int i4;
        ByteArrayPool byteArrayPool = ByteArrayPool.get();
        byte[] bytes = byteArrayPool.getBytes();
        byte[] bytes2 = byteArrayPool.getBytes();
        BitmapFactory.Options defaultOptions = getDefaultOptions();
        RecyclableBufferedInputStream recyclableBufferedInputStream = new RecyclableBufferedInputStream(inputStream, bytes2);
        ExceptionCatchingInputStream exceptionCatchingInputStreamObtain = ExceptionCatchingInputStream.obtain(recyclableBufferedInputStream);
        MarkEnforcingInputStream markEnforcingInputStream = new MarkEnforcingInputStream(exceptionCatchingInputStreamObtain);
        try {
            exceptionCatchingInputStreamObtain.mark(5242880);
            try {
                try {
                    int orientation = new ImageHeaderParser(exceptionCatchingInputStreamObtain).getOrientation();
                    try {
                        exceptionCatchingInputStreamObtain.reset();
                    } catch (IOException e2) {
                        if (Log.isLoggable(TAG, 5)) {
                            Log.w(TAG, "Cannot reset the input stream", e2);
                        }
                    }
                    i4 = orientation;
                } catch (IOException e3) {
                    if (Log.isLoggable(TAG, 5)) {
                        Log.w(TAG, "Cannot determine the image orientation from header", e3);
                    }
                    try {
                        exceptionCatchingInputStreamObtain.reset();
                    } catch (IOException e4) {
                        if (Log.isLoggable(TAG, 5)) {
                            Log.w(TAG, "Cannot reset the input stream", e4);
                        }
                    }
                    i4 = 0;
                }
                defaultOptions.inTempStorage = bytes;
                int[] dimensions = getDimensions(markEnforcingInputStream, recyclableBufferedInputStream, defaultOptions);
                int i5 = dimensions[0];
                int i6 = dimensions[1];
                Bitmap bitmapDownsampleWithSize = downsampleWithSize(markEnforcingInputStream, recyclableBufferedInputStream, defaultOptions, bitmapPool, i5, i6, getRoundedSampleSize(TransformationUtils.getExifOrientationDegrees(i4), i5, i6, i2, i3), decodeFormat);
                IOException exception = exceptionCatchingInputStreamObtain.getException();
                if (exception != null) {
                    throw new RuntimeException(exception);
                }
                Bitmap bitmapRotateImageExif = null;
                if (bitmapDownsampleWithSize != null) {
                    bitmapRotateImageExif = TransformationUtils.rotateImageExif(bitmapDownsampleWithSize, bitmapPool, i4);
                    if (!bitmapDownsampleWithSize.equals(bitmapRotateImageExif) && !bitmapPool.put(bitmapDownsampleWithSize)) {
                        bitmapDownsampleWithSize.recycle();
                    }
                }
                return bitmapRotateImageExif;
            } finally {
            }
        } finally {
            byteArrayPool.releaseBytes(bytes);
            byteArrayPool.releaseBytes(bytes2);
            exceptionCatchingInputStreamObtain.release();
            releaseOptions(defaultOptions);
        }
    }
}
