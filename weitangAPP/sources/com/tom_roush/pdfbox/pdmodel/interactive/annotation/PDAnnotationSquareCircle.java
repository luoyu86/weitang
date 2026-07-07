package com.tom_roush.pdfbox.pdmodel.interactive.annotation;

import com.tom_roush.pdfbox.cos.COSArray;
import com.tom_roush.pdfbox.cos.COSBase;
import com.tom_roush.pdfbox.cos.COSDictionary;
import com.tom_roush.pdfbox.cos.COSFloat;
import com.tom_roush.pdfbox.cos.COSName;
import com.tom_roush.pdfbox.pdmodel.PDDocument;
import com.tom_roush.pdfbox.pdmodel.common.PDRectangle;
import com.tom_roush.pdfbox.pdmodel.graphics.color.PDColor;
import com.tom_roush.pdfbox.pdmodel.interactive.annotation.handlers.PDAppearanceHandler;
import com.tom_roush.pdfbox.pdmodel.interactive.annotation.handlers.PDCircleAppearanceHandler;
import com.tom_roush.pdfbox.pdmodel.interactive.annotation.handlers.PDSquareAppearanceHandler;

/* JADX INFO: loaded from: classes2.dex */
public class PDAnnotationSquareCircle extends PDAnnotationMarkup {
    public static final String SUB_TYPE_CIRCLE = "Circle";
    public static final String SUB_TYPE_SQUARE = "Square";
    private PDAppearanceHandler customAppearanceHandler;

    public PDAnnotationSquareCircle(String str) {
        setSubtype(str);
    }

    @Override // com.tom_roush.pdfbox.pdmodel.interactive.annotation.PDAnnotationMarkup, com.tom_roush.pdfbox.pdmodel.interactive.annotation.PDAnnotation
    public void constructAppearances() {
        constructAppearances(null);
    }

    @Override // com.tom_roush.pdfbox.pdmodel.interactive.annotation.PDAnnotationMarkup
    public PDBorderEffectDictionary getBorderEffect() {
        COSDictionary cOSDictionary = (COSDictionary) getCOSObject().getDictionaryObject(COSName.BE);
        if (cOSDictionary != null) {
            return new PDBorderEffectDictionary(cOSDictionary);
        }
        return null;
    }

    @Override // com.tom_roush.pdfbox.pdmodel.interactive.annotation.PDAnnotationMarkup
    public PDBorderStyleDictionary getBorderStyle() {
        COSBase dictionaryObject = getCOSObject().getDictionaryObject(COSName.BS);
        if (dictionaryObject instanceof COSDictionary) {
            return new PDBorderStyleDictionary((COSDictionary) dictionaryObject);
        }
        return null;
    }

    @Override // com.tom_roush.pdfbox.pdmodel.interactive.annotation.PDAnnotationMarkup
    public PDColor getInteriorColor() {
        return getColor(COSName.IC);
    }

    @Override // com.tom_roush.pdfbox.pdmodel.interactive.annotation.PDAnnotationMarkup
    public PDRectangle getRectDifference() {
        COSArray cOSArray = (COSArray) getCOSObject().getDictionaryObject(COSName.RD);
        if (cOSArray != null) {
            return new PDRectangle(cOSArray);
        }
        return null;
    }

    @Override // com.tom_roush.pdfbox.pdmodel.interactive.annotation.PDAnnotationMarkup
    public float[] getRectDifferences() {
        COSBase item = getCOSObject().getItem(COSName.RD);
        return item instanceof COSArray ? ((COSArray) item).toFloatArray() : new float[0];
    }

    @Override // com.tom_roush.pdfbox.pdmodel.interactive.annotation.PDAnnotation
    public String getSubtype() {
        return getCOSObject().getNameAsString(COSName.SUBTYPE);
    }

    @Override // com.tom_roush.pdfbox.pdmodel.interactive.annotation.PDAnnotationMarkup
    public void setBorderEffect(PDBorderEffectDictionary pDBorderEffectDictionary) {
        getCOSObject().setItem(COSName.BE, pDBorderEffectDictionary);
    }

    @Override // com.tom_roush.pdfbox.pdmodel.interactive.annotation.PDAnnotationMarkup
    public void setBorderStyle(PDBorderStyleDictionary pDBorderStyleDictionary) {
        getCOSObject().setItem(COSName.BS, pDBorderStyleDictionary);
    }

    @Override // com.tom_roush.pdfbox.pdmodel.interactive.annotation.PDAnnotationMarkup
    public void setCustomAppearanceHandler(PDAppearanceHandler pDAppearanceHandler) {
        this.customAppearanceHandler = pDAppearanceHandler;
    }

    @Override // com.tom_roush.pdfbox.pdmodel.interactive.annotation.PDAnnotationMarkup
    public void setInteriorColor(PDColor pDColor) {
        getCOSObject().setItem(COSName.IC, (COSBase) pDColor.toCOSArray());
    }

    @Override // com.tom_roush.pdfbox.pdmodel.interactive.annotation.PDAnnotationMarkup
    public void setRectDifference(PDRectangle pDRectangle) {
        getCOSObject().setItem(COSName.RD, pDRectangle);
    }

    @Override // com.tom_roush.pdfbox.pdmodel.interactive.annotation.PDAnnotationMarkup
    public void setRectDifferences(float f2) {
        setRectDifferences(f2, f2, f2, f2);
    }

    public void setSubtype(String str) {
        getCOSObject().setName(COSName.SUBTYPE, str);
    }

    @Override // com.tom_roush.pdfbox.pdmodel.interactive.annotation.PDAnnotationMarkup, com.tom_roush.pdfbox.pdmodel.interactive.annotation.PDAnnotation
    public void constructAppearances(PDDocument pDDocument) {
        PDAppearanceHandler pDAppearanceHandler = this.customAppearanceHandler;
        if (pDAppearanceHandler != null) {
            pDAppearanceHandler.generateAppearanceStreams();
        } else if ("Circle".equals(getSubtype())) {
            new PDCircleAppearanceHandler(this, pDDocument).generateAppearanceStreams();
        } else if ("Square".equals(getSubtype())) {
            new PDSquareAppearanceHandler(this, pDDocument).generateAppearanceStreams();
        }
    }

    @Override // com.tom_roush.pdfbox.pdmodel.interactive.annotation.PDAnnotationMarkup
    public void setRectDifferences(float f2, float f3, float f4, float f5) {
        COSArray cOSArray = new COSArray();
        cOSArray.add((COSBase) new COSFloat(f2));
        cOSArray.add((COSBase) new COSFloat(f3));
        cOSArray.add((COSBase) new COSFloat(f4));
        cOSArray.add((COSBase) new COSFloat(f5));
        getCOSObject().setItem(COSName.RD, (COSBase) cOSArray);
    }

    public PDAnnotationSquareCircle(COSDictionary cOSDictionary) {
        super(cOSDictionary);
    }
}
