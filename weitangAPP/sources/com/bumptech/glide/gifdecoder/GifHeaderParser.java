package com.bumptech.glide.gifdecoder;

import android.util.Log;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class GifHeaderParser {
    public static final int DEFAULT_FRAME_DELAY = 10;
    private static final int MAX_BLOCK_SIZE = 256;
    public static final int MIN_FRAME_DELAY = 3;
    public static final String TAG = "GifHeaderParser";
    private final byte[] block = new byte[256];
    private int blockSize = 0;
    private GifHeader header;
    private ByteBuffer rawData;

    private boolean err() {
        return this.header.status != 0;
    }

    private int read() {
        try {
            return this.rawData.get() & 255;
        } catch (Exception unused) {
            this.header.status = 1;
            return 0;
        }
    }

    private void readBitmap() {
        this.header.currentFrame.ix = readShort();
        this.header.currentFrame.iy = readShort();
        this.header.currentFrame.iw = readShort();
        this.header.currentFrame.ih = readShort();
        int i2 = read();
        boolean z = (i2 & 128) != 0;
        int iPow = (int) Math.pow(2.0d, (i2 & 7) + 1);
        GifFrame gifFrame = this.header.currentFrame;
        gifFrame.interlace = (i2 & 64) != 0;
        if (z) {
            gifFrame.lct = readColorTable(iPow);
        } else {
            gifFrame.lct = null;
        }
        this.header.currentFrame.bufferFrameStart = this.rawData.position();
        skipImageData();
        if (err()) {
            return;
        }
        GifHeader gifHeader = this.header;
        gifHeader.frameCount++;
        gifHeader.frames.add(gifHeader.currentFrame);
    }

    private int readBlock() {
        int i2 = read();
        this.blockSize = i2;
        int i3 = 0;
        if (i2 > 0) {
            int i4 = 0;
            while (true) {
                try {
                    i4 = this.blockSize;
                    if (i3 >= i4) {
                        break;
                    }
                    i4 -= i3;
                    this.rawData.get(this.block, i3, i4);
                    i3 += i4;
                } catch (Exception e2) {
                    if (Log.isLoggable(TAG, 3)) {
                        Log.d(TAG, "Error Reading Block n: " + i3 + " count: " + i4 + " blockSize: " + this.blockSize, e2);
                    }
                    this.header.status = 1;
                }
            }
        }
        return i3;
    }

    private int[] readColorTable(int i2) {
        byte[] bArr = new byte[i2 * 3];
        int[] iArr = null;
        try {
            this.rawData.get(bArr);
            iArr = new int[256];
            int i3 = 0;
            int i4 = 0;
            while (i3 < i2) {
                int i5 = i4 + 1;
                int i6 = i5 + 1;
                int i7 = i6 + 1;
                int i8 = i3 + 1;
                iArr[i3] = ((bArr[i4] & 255) << 16) | (-16777216) | ((bArr[i5] & 255) << 8) | (bArr[i6] & 255);
                i4 = i7;
                i3 = i8;
            }
        } catch (BufferUnderflowException e2) {
            if (Log.isLoggable(TAG, 3)) {
                Log.d(TAG, "Format Error Reading Color Table", e2);
            }
            this.header.status = 1;
        }
        return iArr;
    }

    private void readContents() {
        boolean z = false;
        while (!z && !err()) {
            int i2 = read();
            if (i2 == 33) {
                int i3 = read();
                if (i3 == 1) {
                    skip();
                } else if (i3 == 249) {
                    this.header.currentFrame = new GifFrame();
                    readGraphicControlExt();
                } else if (i3 == 254) {
                    skip();
                } else if (i3 != 255) {
                    skip();
                } else {
                    readBlock();
                    String str = "";
                    for (int i4 = 0; i4 < 11; i4++) {
                        str = str + ((char) this.block[i4]);
                    }
                    if (str.equals("NETSCAPE2.0")) {
                        readNetscapeExt();
                    } else {
                        skip();
                    }
                }
            } else if (i2 == 44) {
                GifHeader gifHeader = this.header;
                if (gifHeader.currentFrame == null) {
                    gifHeader.currentFrame = new GifFrame();
                }
                readBitmap();
            } else if (i2 != 59) {
                this.header.status = 1;
            } else {
                z = true;
            }
        }
    }

    private void readGraphicControlExt() {
        read();
        int i2 = read();
        GifFrame gifFrame = this.header.currentFrame;
        int i3 = (i2 & 28) >> 2;
        gifFrame.dispose = i3;
        if (i3 == 0) {
            gifFrame.dispose = 1;
        }
        gifFrame.transparency = (i2 & 1) != 0;
        int i4 = readShort();
        if (i4 < 3) {
            i4 = 10;
        }
        GifFrame gifFrame2 = this.header.currentFrame;
        gifFrame2.delay = i4 * 10;
        gifFrame2.transIndex = read();
        read();
    }

    private void readHeader() {
        String str = "";
        for (int i2 = 0; i2 < 6; i2++) {
            str = str + ((char) read());
        }
        if (!str.startsWith("GIF")) {
            this.header.status = 1;
            return;
        }
        readLSD();
        if (!this.header.gctFlag || err()) {
            return;
        }
        GifHeader gifHeader = this.header;
        gifHeader.gct = readColorTable(gifHeader.gctSize);
        GifHeader gifHeader2 = this.header;
        gifHeader2.bgColor = gifHeader2.gct[gifHeader2.bgIndex];
    }

    private void readLSD() {
        this.header.width = readShort();
        this.header.height = readShort();
        int i2 = read();
        GifHeader gifHeader = this.header;
        gifHeader.gctFlag = (i2 & 128) != 0;
        gifHeader.gctSize = 2 << (i2 & 7);
        gifHeader.bgIndex = read();
        this.header.pixelAspect = read();
    }

    private void readNetscapeExt() {
        do {
            readBlock();
            byte[] bArr = this.block;
            if (bArr[0] == 1) {
                this.header.loopCount = ((bArr[2] & 255) << 8) | (bArr[1] & 255);
            }
            if (this.blockSize <= 0) {
                return;
            }
        } while (!err());
    }

    private int readShort() {
        return this.rawData.getShort();
    }

    private void reset() {
        this.rawData = null;
        Arrays.fill(this.block, (byte) 0);
        this.header = new GifHeader();
        this.blockSize = 0;
    }

    private void skip() {
        int i2;
        do {
            i2 = read();
            ByteBuffer byteBuffer = this.rawData;
            byteBuffer.position(byteBuffer.position() + i2);
        } while (i2 > 0);
    }

    private void skipImageData() {
        read();
        skip();
    }

    public void clear() {
        this.rawData = null;
        this.header = null;
    }

    public GifHeader parseHeader() {
        if (this.rawData == null) {
            throw new IllegalStateException("You must call setData() before parseHeader()");
        }
        if (err()) {
            return this.header;
        }
        readHeader();
        if (!err()) {
            readContents();
            GifHeader gifHeader = this.header;
            if (gifHeader.frameCount < 0) {
                gifHeader.status = 1;
            }
        }
        return this.header;
    }

    public GifHeaderParser setData(byte[] bArr) {
        reset();
        if (bArr != null) {
            ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr);
            this.rawData = byteBufferWrap;
            byteBufferWrap.rewind();
            this.rawData.order(ByteOrder.LITTLE_ENDIAN);
        } else {
            this.rawData = null;
            this.header.status = 2;
        }
        return this;
    }
}
