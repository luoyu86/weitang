package com.tom_roush.pdfbox.rendering;

import android.graphics.Path;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public interface Glyph2D {
    void dispose();

    Path getPathForCharacterCode(int i2) throws IOException;
}
