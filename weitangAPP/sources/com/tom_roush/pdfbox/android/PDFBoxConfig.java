package com.tom_roush.pdfbox.android;

/* JADX INFO: loaded from: classes2.dex */
public class PDFBoxConfig {
    public static FontLoadLevel FONT_LOAD_LEVEL = FontLoadLevel.MINIMUM;
    private static boolean debugLoggingEnabled = false;

    public enum FontLoadLevel {
        FULL,
        MINIMUM,
        NONE
    }

    public static FontLoadLevel getFontLoadLevel() {
        return FONT_LOAD_LEVEL;
    }

    public static boolean isDebugEnabled() {
        return debugLoggingEnabled;
    }

    public static void setDebugLoggingEnabled(boolean z) {
        debugLoggingEnabled = z;
    }

    public static void setFontLoadLevel(FontLoadLevel fontLoadLevel) {
        FONT_LOAD_LEVEL = fontLoadLevel;
    }
}
