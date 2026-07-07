package com.tom_roush.fontbox.ttf;

import android.util.Log;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public class GlyfSimpleDescript extends GlyfDescript {
    private int[] endPtsOfContours;
    private byte[] flags;
    private final int pointCount;
    private short[] xCoordinates;
    private short[] yCoordinates;

    public GlyfSimpleDescript() throws IOException {
        super((short) 0, null);
        this.pointCount = 0;
    }

    private void readCoords(int i2, TTFDataStream tTFDataStream, short s) throws IOException {
        short signedShort;
        int unsignedByte;
        short signedShort2;
        int unsignedByte2;
        for (int i3 = 0; i3 < i2; i3++) {
            byte[] bArr = this.flags;
            if ((bArr[i3] & GlyfDescript.X_DUAL) != 0) {
                if ((bArr[i3] & 2) != 0) {
                    signedShort2 = (short) tTFDataStream.readUnsignedByte();
                } else {
                    this.xCoordinates[i3] = s;
                }
            } else if ((bArr[i3] & 2) != 0) {
                unsignedByte2 = s - ((short) tTFDataStream.readUnsignedByte());
                s = (short) unsignedByte2;
                this.xCoordinates[i3] = s;
            } else {
                signedShort2 = tTFDataStream.readSignedShort();
            }
            unsignedByte2 = s + signedShort2;
            s = (short) unsignedByte2;
            this.xCoordinates[i3] = s;
        }
        short s2 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            byte[] bArr2 = this.flags;
            if ((bArr2[i4] & 32) != 0) {
                if ((bArr2[i4] & 4) != 0) {
                    signedShort = (short) tTFDataStream.readUnsignedByte();
                } else {
                    this.yCoordinates[i4] = s2;
                }
            } else if ((bArr2[i4] & 4) != 0) {
                unsignedByte = s2 - ((short) tTFDataStream.readUnsignedByte());
                s2 = (short) unsignedByte;
                this.yCoordinates[i4] = s2;
            } else {
                signedShort = tTFDataStream.readSignedShort();
            }
            unsignedByte = s2 + signedShort;
            s2 = (short) unsignedByte;
            this.yCoordinates[i4] = s2;
        }
    }

    private void readFlags(int i2, TTFDataStream tTFDataStream) throws IOException {
        int i3 = 0;
        while (i3 < i2) {
            this.flags[i3] = (byte) tTFDataStream.readUnsignedByte();
            if ((this.flags[i3] & 8) != 0) {
                int unsignedByte = tTFDataStream.readUnsignedByte();
                for (int i4 = 1; i4 <= unsignedByte; i4++) {
                    int i5 = i3 + i4;
                    byte[] bArr = this.flags;
                    if (i5 >= bArr.length) {
                        Log.e("PdfBox-Android", "repeat count (" + unsignedByte + ") higher than remaining space");
                        return;
                    }
                    bArr[i5] = bArr[i3];
                }
                i3 += unsignedByte;
            }
            i3++;
        }
    }

    @Override // com.tom_roush.fontbox.ttf.GlyphDescription
    public int getEndPtOfContours(int i2) {
        return this.endPtsOfContours[i2];
    }

    @Override // com.tom_roush.fontbox.ttf.GlyphDescription
    public byte getFlags(int i2) {
        return this.flags[i2];
    }

    @Override // com.tom_roush.fontbox.ttf.GlyphDescription
    public int getPointCount() {
        return this.pointCount;
    }

    @Override // com.tom_roush.fontbox.ttf.GlyphDescription
    public short getXCoordinate(int i2) {
        return this.xCoordinates[i2];
    }

    @Override // com.tom_roush.fontbox.ttf.GlyphDescription
    public short getYCoordinate(int i2) {
        return this.yCoordinates[i2];
    }

    @Override // com.tom_roush.fontbox.ttf.GlyphDescription
    public boolean isComposite() {
        return false;
    }

    public GlyfSimpleDescript(short s, TTFDataStream tTFDataStream, short s2) throws IOException {
        super(s, tTFDataStream);
        if (s == 0) {
            this.pointCount = 0;
            return;
        }
        int[] unsignedShortArray = tTFDataStream.readUnsignedShortArray(s);
        this.endPtsOfContours = unsignedShortArray;
        int i2 = unsignedShortArray[s - 1];
        if (s == 1 && i2 == 65535) {
            this.pointCount = 0;
            return;
        }
        int i3 = i2 + 1;
        this.pointCount = i3;
        this.flags = new byte[i3];
        this.xCoordinates = new short[i3];
        this.yCoordinates = new short[i3];
        readInstructions(tTFDataStream, tTFDataStream.readUnsignedShort());
        readFlags(i3, tTFDataStream);
        readCoords(i3, tTFDataStream, s2);
    }
}
