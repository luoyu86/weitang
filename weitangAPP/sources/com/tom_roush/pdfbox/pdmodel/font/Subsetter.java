package com.tom_roush.pdfbox.pdmodel.font;

import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public interface Subsetter {
    void addToSubset(int i2);

    void subset() throws IOException;
}
