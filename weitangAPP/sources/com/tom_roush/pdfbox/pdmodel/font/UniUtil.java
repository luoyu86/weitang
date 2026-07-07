package com.tom_roush.pdfbox.pdmodel.font;

import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
public final class UniUtil {
    private UniUtil() {
    }

    public static String getUniNameOfCodePoint(int i2) {
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
}
