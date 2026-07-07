package com.tom_roush.pdfbox.rendering;

import android.graphics.Path;
import android.util.Log;
import com.tom_roush.fontbox.ttf.HeaderTable;
import com.tom_roush.fontbox.ttf.TrueTypeFont;
import com.tom_roush.harmony.awt.geom.AffineTransform;
import com.tom_roush.pdfbox.pdmodel.font.PDCIDFontType2;
import com.tom_roush.pdfbox.pdmodel.font.PDFont;
import com.tom_roush.pdfbox.pdmodel.font.PDTrueTypeFont;
import com.tom_roush.pdfbox.pdmodel.font.PDType0Font;
import com.tom_roush.pdfbox.pdmodel.font.PDVectorFont;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class TTFGlyph2D implements Glyph2D {
    private final PDFont font;
    private final Map<Integer, Path> glyphs;
    private boolean hasScaling;
    private final boolean isCIDFont;
    private float scale;
    private final TrueTypeFont ttf;
    private PDVectorFont vectorFont;

    public TTFGlyph2D(PDTrueTypeFont pDTrueTypeFont) throws IOException {
        this(pDTrueTypeFont.getTrueTypeFont(), pDTrueTypeFont, false);
        this.vectorFont = pDTrueTypeFont;
    }

    private int getGIDForCharacterCode(int i2) throws IOException {
        return this.isCIDFont ? ((PDType0Font) this.font).codeToGID(i2) : ((PDTrueTypeFont) this.font).codeToGID(i2);
    }

    @Override // com.tom_roush.pdfbox.rendering.Glyph2D
    public void dispose() {
        this.glyphs.clear();
    }

    @Override // com.tom_roush.pdfbox.rendering.Glyph2D
    public Path getPathForCharacterCode(int i2) throws IOException {
        return getPathForGID(getGIDForCharacterCode(i2), i2);
    }

    public Path getPathForGID(int i2, int i3) throws IOException {
        if (i2 == 0 && !this.isCIDFont && i3 == 10 && this.font.isStandard14()) {
            Log.w("PdfBox-Android", "No glyph for code " + i3 + " in font " + this.font.getName());
            return new Path();
        }
        Path path = this.glyphs.get(Integer.valueOf(i2));
        if (path == null) {
            if (i2 == 0 || i2 >= this.ttf.getMaximumProfile().getNumGlyphs()) {
                if (this.isCIDFont) {
                    Log.w("PdfBox-Android", "No glyph for code " + i3 + " (CID " + String.format("%04x", Integer.valueOf(((PDType0Font) this.font).codeToCID(i3))) + ") in font " + this.font.getName());
                } else {
                    Log.w("PdfBox-Android", "No glyph for " + i3 + " in font " + this.font.getName());
                }
            }
            path = (i2 != 0 || this.font.isEmbedded() || this.font.isStandard14()) ? this.vectorFont.getPath(i3) : null;
            if (path == null) {
                path = new Path();
            } else if (this.hasScaling) {
                float f2 = this.scale;
                path.transform(AffineTransform.getScaleInstance(f2, f2).toMatrix());
            }
        }
        return new Path(path);
    }

    public TTFGlyph2D(PDType0Font pDType0Font) throws IOException {
        this(((PDCIDFontType2) pDType0Font.getDescendantFont()).getTrueTypeFont(), pDType0Font, true);
        this.vectorFont = pDType0Font;
    }

    private TTFGlyph2D(TrueTypeFont trueTypeFont, PDFont pDFont, boolean z) throws IOException {
        this.scale = 1.0f;
        this.glyphs = new HashMap();
        this.font = pDFont;
        this.ttf = trueTypeFont;
        this.isCIDFont = z;
        HeaderTable header = trueTypeFont.getHeader();
        if (header == null || header.getUnitsPerEm() == 1000) {
            return;
        }
        this.scale = 1000.0f / header.getUnitsPerEm();
        this.hasScaling = true;
    }
}
