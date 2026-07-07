package com.tom_roush.pdfbox.pdmodel.font;

import com.tom_roush.fontbox.util.BoundingBox;
import com.tom_roush.pdfbox.util.Matrix;
import com.tom_roush.pdfbox.util.Vector;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public interface PDFontLike {
    float getAverageFontWidth();

    BoundingBox getBoundingBox() throws IOException;

    PDFontDescriptor getFontDescriptor();

    Matrix getFontMatrix();

    @Deprecated
    float getHeight(int i2) throws IOException;

    String getName();

    Vector getPositionVector(int i2);

    float getWidth(int i2) throws IOException;

    float getWidthFromFont(int i2) throws IOException;

    boolean hasExplicitWidth(int i2) throws IOException;

    boolean isDamaged();

    boolean isEmbedded();
}
