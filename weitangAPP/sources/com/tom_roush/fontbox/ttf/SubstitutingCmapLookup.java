package com.tom_roush.fontbox.ttf;

import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class SubstitutingCmapLookup implements CmapLookup {
    private final CmapSubtable cmap;
    private final List<String> enabledFeatures;
    private final GlyphSubstitutionTable gsub;

    public SubstitutingCmapLookup(CmapSubtable cmapSubtable, GlyphSubstitutionTable glyphSubstitutionTable, List<String> list) {
        this.cmap = cmapSubtable;
        this.gsub = glyphSubstitutionTable;
        this.enabledFeatures = list;
    }

    @Override // com.tom_roush.fontbox.ttf.CmapLookup
    public List<Integer> getCharCodes(int i2) {
        return this.cmap.getCharCodes(this.gsub.getUnsubstitution(i2));
    }

    @Override // com.tom_roush.fontbox.ttf.CmapLookup
    public int getGlyphId(int i2) {
        return this.gsub.getSubstitution(this.cmap.getGlyphId(i2), OpenTypeScript.getScriptTags(i2), this.enabledFeatures);
    }
}
