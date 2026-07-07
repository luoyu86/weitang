package com.tom_roush.pdfbox.rendering;

import android.graphics.Path;
import android.util.Log;
import com.tom_roush.pdfbox.pdmodel.font.PDCIDFontType0;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class CIDType0Glyph2D implements Glyph2D {
    private final Map<Integer, Path> cache = new HashMap();
    private final PDCIDFontType0 font;
    private final String fontName;

    public CIDType0Glyph2D(PDCIDFontType0 pDCIDFontType0) {
        this.font = pDCIDFontType0;
        this.fontName = pDCIDFontType0.getBaseFont();
    }

    @Override // com.tom_roush.pdfbox.rendering.Glyph2D
    public void dispose() {
        this.cache.clear();
    }

    @Override // com.tom_roush.pdfbox.rendering.Glyph2D
    public Path getPathForCharacterCode(int i2) {
        Path path = this.cache.get(Integer.valueOf(i2));
        if (path != null) {
            return path;
        }
        try {
            if (!this.font.hasGlyph(i2)) {
                Log.w("PdfBox-Android", "No glyph for " + i2 + " (CID " + String.format("%04x", Integer.valueOf(this.font.getParent().codeToCID(i2))) + ") in font " + this.fontName);
            }
            Path path2 = this.font.getPath(i2);
            this.cache.put(Integer.valueOf(i2), path2);
            return path2;
        } catch (IOException e2) {
            Log.e("PdfBox-Android", "Glyph rendering failed", e2);
            return new Path();
        }
    }
}
