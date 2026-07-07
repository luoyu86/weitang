package com.tom_roush.fontbox.ttf;

import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public interface CmapLookup {
    List<Integer> getCharCodes(int i2);

    int getGlyphId(int i2);
}
