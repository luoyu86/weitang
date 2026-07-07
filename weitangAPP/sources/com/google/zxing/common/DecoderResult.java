package com.google.zxing.common;

import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class DecoderResult {
    private final List<byte[]> byteSegments;
    private final String ecLevel;
    private final byte[] rawBytes;
    private final String text;

    public DecoderResult(byte[] bArr, String str, List<byte[]> list, String str2) {
        this.rawBytes = bArr;
        this.text = str;
        this.byteSegments = list;
        this.ecLevel = str2;
    }

    public List<byte[]> getByteSegments() {
        return this.byteSegments;
    }

    public String getECLevel() {
        return this.ecLevel;
    }

    public byte[] getRawBytes() {
        return this.rawBytes;
    }

    public String getText() {
        return this.text;
    }
}
