package com.tom_roush.pdfbox.pdmodel.font;

/* JADX INFO: loaded from: classes2.dex */
public final class FontMappers {
    private static FontMapper instance;

    public static class DefaultFontMapper {
        private static final FontMapper INSTANCE = new FontMapperImpl();

        private DefaultFontMapper() {
        }
    }

    private FontMappers() {
    }

    public static FontMapper instance() {
        if (instance == null) {
            instance = DefaultFontMapper.INSTANCE;
        }
        return instance;
    }

    public static synchronized void set(FontMapper fontMapper) {
        instance = fontMapper;
    }
}
