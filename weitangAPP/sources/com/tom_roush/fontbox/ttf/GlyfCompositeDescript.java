package com.tom_roush.fontbox.ttf;

import android.util.Log;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class GlyfCompositeDescript extends GlyfDescript {
    private boolean beingResolved;
    private final List<GlyfCompositeComp> components;
    private int contourCount;
    private final Map<Integer, GlyphDescription> descriptions;
    private GlyphTable glyphTable;
    private int pointCount;
    private boolean resolved;

    public GlyfCompositeDescript(TTFDataStream tTFDataStream, GlyphTable glyphTable) throws IOException {
        GlyfCompositeComp glyfCompositeComp;
        super((short) -1, tTFDataStream);
        this.components = new ArrayList();
        this.descriptions = new HashMap();
        this.glyphTable = null;
        this.beingResolved = false;
        this.resolved = false;
        this.pointCount = -1;
        this.contourCount = -1;
        this.glyphTable = glyphTable;
        do {
            glyfCompositeComp = new GlyfCompositeComp(tTFDataStream);
            this.components.add(glyfCompositeComp);
        } while ((glyfCompositeComp.getFlags() & 32) != 0);
        if ((glyfCompositeComp.getFlags() & 256) != 0) {
            readInstructions(tTFDataStream, tTFDataStream.readUnsignedShort());
        }
        initDescriptions();
    }

    private GlyfCompositeComp getCompositeComp(int i2) {
        for (GlyfCompositeComp glyfCompositeComp : this.components) {
            GlyphDescription glyphDescription = this.descriptions.get(Integer.valueOf(glyfCompositeComp.getGlyphIndex()));
            if (glyfCompositeComp.getFirstIndex() <= i2 && glyphDescription != null && i2 < glyfCompositeComp.getFirstIndex() + glyphDescription.getPointCount()) {
                return glyfCompositeComp;
            }
        }
        return null;
    }

    private GlyfCompositeComp getCompositeCompEndPt(int i2) {
        for (GlyfCompositeComp glyfCompositeComp : this.components) {
            GlyphDescription glyphDescription = this.descriptions.get(Integer.valueOf(glyfCompositeComp.getGlyphIndex()));
            if (glyfCompositeComp.getFirstContour() <= i2 && glyphDescription != null && i2 < glyfCompositeComp.getFirstContour() + glyphDescription.getContourCount()) {
                return glyfCompositeComp;
            }
        }
        return null;
    }

    private void initDescriptions() {
        Iterator<GlyfCompositeComp> it = this.components.iterator();
        while (it.hasNext()) {
            try {
                int glyphIndex = it.next().getGlyphIndex();
                GlyphData glyph = this.glyphTable.getGlyph(glyphIndex);
                if (glyph != null) {
                    this.descriptions.put(Integer.valueOf(glyphIndex), glyph.getDescription());
                }
            } catch (IOException e2) {
                Log.e("PdfBox-Android", e2.getMessage(), e2);
            }
        }
    }

    public int getComponentCount() {
        return this.components.size();
    }

    @Override // com.tom_roush.fontbox.ttf.GlyfDescript, com.tom_roush.fontbox.ttf.GlyphDescription
    public int getContourCount() {
        if (!this.resolved) {
            Log.e("PdfBox-Android", "getContourCount called on unresolved GlyfCompositeDescript");
        }
        if (this.contourCount < 0) {
            GlyfCompositeComp glyfCompositeComp = this.components.get(r0.size() - 1);
            this.contourCount = glyfCompositeComp.getFirstContour() + this.descriptions.get(Integer.valueOf(glyfCompositeComp.getGlyphIndex())).getContourCount();
        }
        return this.contourCount;
    }

    @Override // com.tom_roush.fontbox.ttf.GlyphDescription
    public int getEndPtOfContours(int i2) {
        GlyfCompositeComp compositeCompEndPt = getCompositeCompEndPt(i2);
        if (compositeCompEndPt != null) {
            return this.descriptions.get(Integer.valueOf(compositeCompEndPt.getGlyphIndex())).getEndPtOfContours(i2 - compositeCompEndPt.getFirstContour()) + compositeCompEndPt.getFirstIndex();
        }
        return 0;
    }

    @Override // com.tom_roush.fontbox.ttf.GlyphDescription
    public byte getFlags(int i2) {
        GlyfCompositeComp compositeComp = getCompositeComp(i2);
        if (compositeComp != null) {
            return this.descriptions.get(Integer.valueOf(compositeComp.getGlyphIndex())).getFlags(i2 - compositeComp.getFirstIndex());
        }
        return (byte) 0;
    }

    @Override // com.tom_roush.fontbox.ttf.GlyphDescription
    public int getPointCount() {
        if (!this.resolved) {
            Log.e("PdfBox-Android", "getPointCount called on unresolved GlyfCompositeDescript");
        }
        if (this.pointCount < 0) {
            GlyfCompositeComp glyfCompositeComp = this.components.get(r0.size() - 1);
            GlyphDescription glyphDescription = this.descriptions.get(Integer.valueOf(glyfCompositeComp.getGlyphIndex()));
            if (glyphDescription == null) {
                Log.e("PdfBox-Android", "GlyphDescription for index " + glyfCompositeComp.getGlyphIndex() + " is null, returning 0");
                this.pointCount = 0;
            } else {
                this.pointCount = glyfCompositeComp.getFirstIndex() + glyphDescription.getPointCount();
            }
        }
        return this.pointCount;
    }

    @Override // com.tom_roush.fontbox.ttf.GlyphDescription
    public short getXCoordinate(int i2) {
        GlyfCompositeComp compositeComp = getCompositeComp(i2);
        if (compositeComp == null) {
            return (short) 0;
        }
        GlyphDescription glyphDescription = this.descriptions.get(Integer.valueOf(compositeComp.getGlyphIndex()));
        int firstIndex = i2 - compositeComp.getFirstIndex();
        return (short) (((short) compositeComp.scaleX(glyphDescription.getXCoordinate(firstIndex), glyphDescription.getYCoordinate(firstIndex))) + compositeComp.getXTranslate());
    }

    @Override // com.tom_roush.fontbox.ttf.GlyphDescription
    public short getYCoordinate(int i2) {
        GlyfCompositeComp compositeComp = getCompositeComp(i2);
        if (compositeComp == null) {
            return (short) 0;
        }
        GlyphDescription glyphDescription = this.descriptions.get(Integer.valueOf(compositeComp.getGlyphIndex()));
        int firstIndex = i2 - compositeComp.getFirstIndex();
        return (short) (((short) compositeComp.scaleY(glyphDescription.getXCoordinate(firstIndex), glyphDescription.getYCoordinate(firstIndex))) + compositeComp.getYTranslate());
    }

    @Override // com.tom_roush.fontbox.ttf.GlyphDescription
    public boolean isComposite() {
        return true;
    }

    @Override // com.tom_roush.fontbox.ttf.GlyfDescript, com.tom_roush.fontbox.ttf.GlyphDescription
    public void resolve() {
        if (this.resolved) {
            return;
        }
        if (this.beingResolved) {
            Log.e("PdfBox-Android", "Circular reference in GlyfCompositeDesc");
            return;
        }
        this.beingResolved = true;
        int pointCount = 0;
        int contourCount = 0;
        for (GlyfCompositeComp glyfCompositeComp : this.components) {
            glyfCompositeComp.setFirstIndex(pointCount);
            glyfCompositeComp.setFirstContour(contourCount);
            GlyphDescription glyphDescription = this.descriptions.get(Integer.valueOf(glyfCompositeComp.getGlyphIndex()));
            if (glyphDescription != null) {
                glyphDescription.resolve();
                pointCount += glyphDescription.getPointCount();
                contourCount += glyphDescription.getContourCount();
            }
        }
        this.resolved = true;
        this.beingResolved = false;
    }
}
