package com.tom_roush.pdfbox.pdmodel.graphics.pattern;

import com.tom_roush.harmony.awt.geom.AffineTransform;
import com.tom_roush.pdfbox.cos.COSArray;
import com.tom_roush.pdfbox.cos.COSBase;
import com.tom_roush.pdfbox.cos.COSDictionary;
import com.tom_roush.pdfbox.cos.COSFloat;
import com.tom_roush.pdfbox.cos.COSName;
import com.tom_roush.pdfbox.pdmodel.ResourceCache;
import com.tom_roush.pdfbox.pdmodel.common.COSObjectable;
import com.tom_roush.pdfbox.util.Matrix;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public abstract class PDAbstractPattern implements COSObjectable {
    public static final int TYPE_SHADING_PATTERN = 2;
    public static final int TYPE_TILING_PATTERN = 1;
    private final COSDictionary patternDictionary;

    public PDAbstractPattern() {
        COSDictionary cOSDictionary = new COSDictionary();
        this.patternDictionary = cOSDictionary;
        cOSDictionary.setName(COSName.TYPE, COSName.PATTERN.getName());
    }

    public static PDAbstractPattern create(COSDictionary cOSDictionary) throws IOException {
        return create(cOSDictionary, null);
    }

    public Matrix getMatrix() {
        return Matrix.createMatrix(getCOSObject().getDictionaryObject(COSName.MATRIX));
    }

    public abstract int getPatternType();

    public String getType() {
        return COSName.PATTERN.getName();
    }

    public void setMatrix(AffineTransform affineTransform) {
        COSArray cOSArray = new COSArray();
        double[] dArr = new double[6];
        affineTransform.getMatrix(dArr);
        for (int i2 = 0; i2 < 6; i2++) {
            cOSArray.add((COSBase) new COSFloat((float) dArr[i2]));
        }
        getCOSObject().setItem(COSName.MATRIX, (COSBase) cOSArray);
    }

    public void setPaintType(int i2) {
        this.patternDictionary.setInt(COSName.PAINT_TYPE, i2);
    }

    public void setPatternType(int i2) {
        this.patternDictionary.setInt(COSName.PATTERN_TYPE, i2);
    }

    public static PDAbstractPattern create(COSDictionary cOSDictionary, ResourceCache resourceCache) throws IOException {
        int i2 = cOSDictionary.getInt(COSName.PATTERN_TYPE, 0);
        if (i2 == 1) {
            return new PDTilingPattern(cOSDictionary, resourceCache);
        }
        if (i2 == 2) {
            return new PDShadingPattern(cOSDictionary);
        }
        throw new IOException("Error: Unknown pattern type " + i2);
    }

    @Override // com.tom_roush.pdfbox.pdmodel.common.COSObjectable
    public COSDictionary getCOSObject() {
        return this.patternDictionary;
    }

    public PDAbstractPattern(COSDictionary cOSDictionary) {
        this.patternDictionary = cOSDictionary;
    }
}
