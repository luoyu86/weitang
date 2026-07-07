package com.tom_roush.fontbox.cff;

import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public class CFFDataInput extends DataInput {
    public CFFDataInput(byte[] bArr) {
        super(bArr);
    }

    public int readCard16() throws IOException {
        return readUnsignedShort();
    }

    public int readCard8() throws IOException {
        return readUnsignedByte();
    }

    public int readOffSize() throws IOException {
        int unsignedByte = readUnsignedByte();
        if (unsignedByte >= 1 && unsignedByte <= 4) {
            return unsignedByte;
        }
        throw new IOException("Illegal (< 1 or > 4) offSize value " + unsignedByte + " in CFF font at position " + (getPosition() - 1));
    }

    public int readOffset(int i2) throws IOException {
        int unsignedByte = 0;
        for (int i3 = 0; i3 < i2; i3++) {
            unsignedByte = (unsignedByte << 8) | readUnsignedByte();
        }
        return unsignedByte;
    }

    public int readSID() throws IOException {
        return readUnsignedShort();
    }
}
