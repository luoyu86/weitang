package com.tom_roush.fontbox.cff;

/* JADX INFO: loaded from: classes2.dex */
public abstract class FDSelect {
    public final CFFCIDFont owner;

    public FDSelect(CFFCIDFont cFFCIDFont) {
        this.owner = cFFCIDFont;
    }

    public abstract int getFDIndex(int i2);
}
