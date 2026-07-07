package com.google.zxing.oned;

/* JADX INFO: loaded from: classes2.dex */
public abstract class UPCEANWriter extends OneDimensionalCodeWriter {
    public UPCEANWriter() {
        super(UPCEANReader.START_END_PATTERN.length << 1);
    }
}
