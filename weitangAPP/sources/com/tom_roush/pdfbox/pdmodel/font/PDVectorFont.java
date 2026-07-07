package com.tom_roush.pdfbox.pdmodel.font;

import android.graphics.Path;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public interface PDVectorFont {
    Path getPath(int i2) throws IOException;

    boolean hasGlyph(int i2) throws IOException;
}
