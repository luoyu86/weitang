package com.bumptech.glide.gifdecoder;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.os.Build;
import android.util.Log;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class GifDecoder {
    private static final Bitmap.Config BITMAP_CONFIG = Bitmap.Config.ARGB_8888;
    private static final int DISPOSAL_BACKGROUND = 2;
    private static final int DISPOSAL_NONE = 1;
    private static final int DISPOSAL_PREVIOUS = 3;
    private static final int DISPOSAL_UNSPECIFIED = 0;
    private static final int INITIAL_FRAME_POINTER = -1;
    private static final int MAX_STACK_SIZE = 4096;
    private static final int NULL_CODE = -1;
    public static final int STATUS_FORMAT_ERROR = 1;
    public static final int STATUS_OK = 0;
    public static final int STATUS_OPEN_ERROR = 2;
    public static final int STATUS_PARTIAL_DECODE = 3;
    private static final String TAG = "GifDecoder";
    private int[] act;
    private BitmapProvider bitmapProvider;
    private byte[] data;
    private int framePointer;
    private byte[] mainPixels;
    private int[] mainScratch;
    private GifHeaderParser parser;
    private byte[] pixelStack;
    private short[] prefix;
    private Bitmap previousImage;
    private ByteBuffer rawData;
    private boolean savePrevious;
    private int status;
    private byte[] suffix;
    private final byte[] block = new byte[256];
    private GifHeader header = new GifHeader();

    public interface BitmapProvider {
        Bitmap obtain(int i2, int i3, Bitmap.Config config);

        void release(Bitmap bitmap);
    }

    public GifDecoder(BitmapProvider bitmapProvider) {
        this.bitmapProvider = bitmapProvider;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:58:0x012e A[PHI: r3
  0x012e: PHI (r3v11 int) = (r3v7 int), (r3v13 int) binds: [B:52:0x0116, B:54:0x0123] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Type inference failed for: r1v24 */
    /* JADX WARN: Type inference failed for: r1v25 */
    /* JADX WARN: Type inference failed for: r1v26 */
    /* JADX WARN: Type inference failed for: r1v30, types: [short] */
    /* JADX WARN: Type inference failed for: r1v32 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void decodeBitmapData(com.bumptech.glide.gifdecoder.GifFrame r27) {
        /*
            Method dump skipped, instruction units count: 373
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.gifdecoder.GifDecoder.decodeBitmapData(com.bumptech.glide.gifdecoder.GifFrame):void");
    }

    private GifHeaderParser getHeaderParser() {
        if (this.parser == null) {
            this.parser = new GifHeaderParser();
        }
        return this.parser;
    }

    private Bitmap getNextBitmap() {
        BitmapProvider bitmapProvider = this.bitmapProvider;
        GifHeader gifHeader = this.header;
        int i2 = gifHeader.width;
        int i3 = gifHeader.height;
        Bitmap.Config config = BITMAP_CONFIG;
        Bitmap bitmapObtain = bitmapProvider.obtain(i2, i3, config);
        if (bitmapObtain == null) {
            GifHeader gifHeader2 = this.header;
            bitmapObtain = Bitmap.createBitmap(gifHeader2.width, gifHeader2.height, config);
        }
        setAlpha(bitmapObtain);
        return bitmapObtain;
    }

    private int readBlock() {
        int i2 = read();
        int i3 = 0;
        if (i2 > 0) {
            while (i3 < i2) {
                int i4 = i2 - i3;
                try {
                    this.rawData.get(this.block, i3, i4);
                    i3 += i4;
                } catch (Exception e2) {
                    Log.w(TAG, "Error Reading Block", e2);
                    this.status = 1;
                }
            }
        }
        return i3;
    }

    @TargetApi(12)
    private static void setAlpha(Bitmap bitmap) {
        if (Build.VERSION.SDK_INT >= 12) {
            bitmap.setHasAlpha(true);
        }
    }

    private Bitmap setPixels(GifFrame gifFrame, GifFrame gifFrame2) {
        int i2;
        int i3;
        int i4;
        int i5;
        Bitmap bitmap;
        GifHeader gifHeader = this.header;
        int i6 = gifHeader.width;
        int i7 = gifHeader.height;
        int[] iArr = this.mainScratch;
        int i8 = 3;
        if (gifFrame2 == null || (i5 = gifFrame2.dispose) <= 0) {
            i2 = 2;
        } else {
            if (i5 == 2) {
                Arrays.fill(iArr, !gifFrame.transparency ? gifHeader.bgColor : 0);
            } else if (i5 == 3 && (bitmap = this.previousImage) != null) {
                i2 = 2;
                bitmap.getPixels(iArr, 0, i6, 0, 0, i6, i7);
            }
            i2 = 2;
        }
        decodeBitmapData(gifFrame);
        int i9 = 8;
        int i10 = 0;
        int i11 = 0;
        int i12 = 1;
        while (true) {
            int i13 = gifFrame.ih;
            if (i10 >= i13) {
                break;
            }
            if (gifFrame.interlace) {
                if (i11 >= i13) {
                    i12++;
                    if (i12 == i2) {
                        i11 = 4;
                    } else if (i12 == i8) {
                        i9 = 4;
                        i11 = 2;
                    } else if (i12 == 4) {
                        i9 = 2;
                        i11 = 1;
                    }
                }
                i4 = i11 + i9;
            } else {
                i4 = i11;
                i11 = i10;
            }
            int i14 = i11 + gifFrame.iy;
            GifHeader gifHeader2 = this.header;
            if (i14 < gifHeader2.height) {
                int i15 = gifHeader2.width;
                int i16 = i14 * i15;
                int i17 = gifFrame.ix + i16;
                int i18 = gifFrame.iw;
                int i19 = i17 + i18;
                if (i16 + i15 < i19) {
                    i19 = i16 + i15;
                }
                int i20 = i18 * i10;
                while (i17 < i19) {
                    int i21 = i20 + 1;
                    int i22 = this.act[this.mainPixels[i20] & 255];
                    if (i22 != 0) {
                        iArr[i17] = i22;
                    }
                    i17++;
                    i20 = i21;
                }
            }
            i10++;
            i11 = i4;
            i2 = 2;
            i8 = 3;
        }
        if (this.savePrevious && ((i3 = gifFrame.dispose) == 0 || i3 == 1)) {
            if (this.previousImage == null) {
                this.previousImage = getNextBitmap();
            }
            this.previousImage.setPixels(iArr, 0, i6, 0, 0, i6, i7);
        }
        Bitmap nextBitmap = getNextBitmap();
        nextBitmap.setPixels(iArr, 0, i6, 0, 0, i6, i7);
        return nextBitmap;
    }

    public void advance() {
        this.framePointer = (this.framePointer + 1) % this.header.frameCount;
    }

    public void clear() {
        this.header = null;
        this.data = null;
        this.mainPixels = null;
        this.mainScratch = null;
        Bitmap bitmap = this.previousImage;
        if (bitmap != null) {
            this.bitmapProvider.release(bitmap);
        }
        this.previousImage = null;
        this.rawData = null;
    }

    public int getCurrentFrameIndex() {
        return this.framePointer;
    }

    public byte[] getData() {
        return this.data;
    }

    public int getDelay(int i2) {
        if (i2 >= 0) {
            GifHeader gifHeader = this.header;
            if (i2 < gifHeader.frameCount) {
                return gifHeader.frames.get(i2).delay;
            }
        }
        return -1;
    }

    public int getFrameCount() {
        return this.header.frameCount;
    }

    public int getHeight() {
        return this.header.height;
    }

    public int getLoopCount() {
        return this.header.loopCount;
    }

    public int getNextDelay() {
        int i2;
        if (this.header.frameCount <= 0 || (i2 = this.framePointer) < 0) {
            return -1;
        }
        return getDelay(i2);
    }

    public synchronized Bitmap getNextFrame() {
        if (this.header.frameCount <= 0 || this.framePointer < 0) {
            String str = TAG;
            if (Log.isLoggable(str, 3)) {
                Log.d(str, "unable to decode frame, frameCount=" + this.header.frameCount + " framePointer=" + this.framePointer);
            }
            this.status = 1;
        }
        int i2 = this.status;
        if (i2 != 1 && i2 != 2) {
            int i3 = 0;
            this.status = 0;
            GifFrame gifFrame = this.header.frames.get(this.framePointer);
            int i4 = this.framePointer - 1;
            GifFrame gifFrame2 = i4 >= 0 ? this.header.frames.get(i4) : null;
            int[] iArr = gifFrame.lct;
            if (iArr == null) {
                this.act = this.header.gct;
            } else {
                this.act = iArr;
                GifHeader gifHeader = this.header;
                if (gifHeader.bgIndex == gifFrame.transIndex) {
                    gifHeader.bgColor = 0;
                }
            }
            if (gifFrame.transparency) {
                int[] iArr2 = this.act;
                int i5 = gifFrame.transIndex;
                int i6 = iArr2[i5];
                iArr2[i5] = 0;
                i3 = i6;
            }
            if (this.act != null) {
                Bitmap pixels = setPixels(gifFrame, gifFrame2);
                if (gifFrame.transparency) {
                    this.act[gifFrame.transIndex] = i3;
                }
                return pixels;
            }
            String str2 = TAG;
            if (Log.isLoggable(str2, 3)) {
                Log.d(str2, "No Valid Color Table");
            }
            this.status = 1;
            return null;
        }
        String str3 = TAG;
        if (Log.isLoggable(str3, 3)) {
            Log.d(str3, "Unable to decode frame, status=" + this.status);
        }
        return null;
    }

    public int getStatus() {
        return this.status;
    }

    public int getWidth() {
        return this.header.width;
    }

    public int read(InputStream inputStream, int i2) {
        if (inputStream != null) {
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(i2 > 0 ? i2 + 4096 : 16384);
                byte[] bArr = new byte[16384];
                while (true) {
                    int i3 = inputStream.read(bArr, 0, 16384);
                    if (i3 == -1) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr, 0, i3);
                }
                byteArrayOutputStream.flush();
                read(byteArrayOutputStream.toByteArray());
            } catch (IOException e2) {
                Log.w(TAG, "Error reading data from stream", e2);
            }
        } else {
            this.status = 2;
        }
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e3) {
                Log.w(TAG, "Error closing stream", e3);
            }
        }
        return this.status;
    }

    public void resetFrameIndex() {
        this.framePointer = -1;
    }

    public void setData(GifHeader gifHeader, byte[] bArr) {
        this.header = gifHeader;
        this.data = bArr;
        this.status = 0;
        this.framePointer = -1;
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr);
        this.rawData = byteBufferWrap;
        byteBufferWrap.rewind();
        this.rawData.order(ByteOrder.LITTLE_ENDIAN);
        this.savePrevious = false;
        Iterator<GifFrame> it = gifHeader.frames.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            } else if (it.next().dispose == 3) {
                this.savePrevious = true;
                break;
            }
        }
        int i2 = gifHeader.width;
        int i3 = gifHeader.height;
        this.mainPixels = new byte[i2 * i3];
        this.mainScratch = new int[i2 * i3];
    }

    public int read(byte[] bArr) {
        this.data = bArr;
        this.header = getHeaderParser().setData(bArr).parseHeader();
        if (bArr != null) {
            ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr);
            this.rawData = byteBufferWrap;
            byteBufferWrap.rewind();
            this.rawData.order(ByteOrder.LITTLE_ENDIAN);
            GifHeader gifHeader = this.header;
            int i2 = gifHeader.width;
            int i3 = gifHeader.height;
            this.mainPixels = new byte[i2 * i3];
            this.mainScratch = new int[i2 * i3];
            this.savePrevious = false;
            Iterator<GifFrame> it = gifHeader.frames.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                if (it.next().dispose == 3) {
                    this.savePrevious = true;
                    break;
                }
            }
        }
        return this.status;
    }

    private int read() {
        try {
            return this.rawData.get() & 255;
        } catch (Exception unused) {
            this.status = 1;
            return 0;
        }
    }
}
