package com.tom_roush.pdfbox.rendering;

import android.graphics.Path;
import android.util.Log;
import com.tom_roush.pdfbox.pdmodel.font.PDSimpleFont;
import java.io.IOException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class Type1Glyph2D implements Glyph2D {
    private final Map<Integer, Path> cache = new HashMap();
    private final PDSimpleFont font;

    public Type1Glyph2D(PDSimpleFont pDSimpleFont) {
        this.font = pDSimpleFont;
    }

    private static String getUniNameOfCodePoint(int i2) {
        String upperCase = Integer.toString(i2, 16).toUpperCase(Locale.US);
        int length = upperCase.length();
        if (length == 1) {
            return "uni000" + upperCase;
        }
        if (length == 2) {
            return "uni00" + upperCase;
        }
        if (length != 3) {
            return "uni" + upperCase;
        }
        return "uni0" + upperCase;
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
            String name = this.font.getEncoding().getName(i2);
            if (!this.font.hasGlyph(name)) {
                Log.w("PdfBox-Android", "No glyph for code " + i2 + " (" + name + ") in font " + this.font.getName());
                if (i2 == 10 && this.font.isStandard14()) {
                    Path path2 = new Path();
                    this.cache.put(Integer.valueOf(i2), path2);
                    return path2;
                }
                String unicode = this.font.getGlyphList().toUnicode(name);
                if (unicode != null && unicode.length() == 1) {
                    String uniNameOfCodePoint = getUniNameOfCodePoint(unicode.codePointAt(0));
                    if (this.font.hasGlyph(uniNameOfCodePoint)) {
                        name = uniNameOfCodePoint;
                    }
                }
            }
            Path path3 = this.font.getPath(name);
            return path3 == null ? this.font.getPath(".notdef") : path3;
        } catch (IOException e2) {
            Log.e("PdfBox-Android", "Glyph rendering failed", e2);
            return new Path();
        }
    }
}
