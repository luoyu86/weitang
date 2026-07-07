package com.tom_roush.pdfbox.pdmodel.interactive.measurement;

import com.tom_roush.pdfbox.cos.COSArray;
import com.tom_roush.pdfbox.cos.COSBase;
import com.tom_roush.pdfbox.cos.COSDictionary;
import com.tom_roush.pdfbox.cos.COSName;
import com.tom_roush.pdfbox.pdmodel.interactive.annotation.PDAnnotationLink;

/* JADX INFO: loaded from: classes2.dex */
public class PDRectlinearMeasureDictionary extends PDMeasureDictionary {
    public static final String SUBTYPE = "RL";

    public PDRectlinearMeasureDictionary() {
        setSubtype(SUBTYPE);
    }

    public PDNumberFormatDictionary[] getAngles() {
        COSArray cOSArray = (COSArray) getCOSObject().getDictionaryObject(PDNumberFormatDictionary.FRACTIONAL_DISPLAY_TRUNCATE);
        if (cOSArray == null) {
            return null;
        }
        PDNumberFormatDictionary[] pDNumberFormatDictionaryArr = new PDNumberFormatDictionary[cOSArray.size()];
        for (int i2 = 0; i2 < cOSArray.size(); i2++) {
            pDNumberFormatDictionaryArr[i2] = new PDNumberFormatDictionary((COSDictionary) cOSArray.get(i2));
        }
        return pDNumberFormatDictionaryArr;
    }

    public PDNumberFormatDictionary[] getAreas() {
        COSArray cOSArray = (COSArray) getCOSObject().getDictionaryObject(COSName.A);
        if (cOSArray == null) {
            return null;
        }
        PDNumberFormatDictionary[] pDNumberFormatDictionaryArr = new PDNumberFormatDictionary[cOSArray.size()];
        for (int i2 = 0; i2 < cOSArray.size(); i2++) {
            pDNumberFormatDictionaryArr[i2] = new PDNumberFormatDictionary((COSDictionary) cOSArray.get(i2));
        }
        return pDNumberFormatDictionaryArr;
    }

    public float getCYX() {
        return getCOSObject().getFloat("CYX");
    }

    public PDNumberFormatDictionary[] getChangeXs() {
        COSArray cOSArray = (COSArray) getCOSObject().getDictionaryObject("X");
        if (cOSArray == null) {
            return null;
        }
        PDNumberFormatDictionary[] pDNumberFormatDictionaryArr = new PDNumberFormatDictionary[cOSArray.size()];
        for (int i2 = 0; i2 < cOSArray.size(); i2++) {
            pDNumberFormatDictionaryArr[i2] = new PDNumberFormatDictionary((COSDictionary) cOSArray.get(i2));
        }
        return pDNumberFormatDictionaryArr;
    }

    public PDNumberFormatDictionary[] getChangeYs() {
        COSArray cOSArray = (COSArray) getCOSObject().getDictionaryObject("Y");
        if (cOSArray == null) {
            return null;
        }
        PDNumberFormatDictionary[] pDNumberFormatDictionaryArr = new PDNumberFormatDictionary[cOSArray.size()];
        for (int i2 = 0; i2 < cOSArray.size(); i2++) {
            pDNumberFormatDictionaryArr[i2] = new PDNumberFormatDictionary((COSDictionary) cOSArray.get(i2));
        }
        return pDNumberFormatDictionaryArr;
    }

    public float[] getCoordSystemOrigin() {
        COSArray cOSArray = (COSArray) getCOSObject().getDictionaryObject(PDAnnotationLink.HIGHLIGHT_MODE_OUTLINE);
        if (cOSArray != null) {
            return cOSArray.toFloatArray();
        }
        return null;
    }

    public PDNumberFormatDictionary[] getDistances() {
        COSArray cOSArray = (COSArray) getCOSObject().getDictionaryObject("D");
        if (cOSArray == null) {
            return null;
        }
        PDNumberFormatDictionary[] pDNumberFormatDictionaryArr = new PDNumberFormatDictionary[cOSArray.size()];
        for (int i2 = 0; i2 < cOSArray.size(); i2++) {
            pDNumberFormatDictionaryArr[i2] = new PDNumberFormatDictionary((COSDictionary) cOSArray.get(i2));
        }
        return pDNumberFormatDictionaryArr;
    }

    public PDNumberFormatDictionary[] getLineSloaps() {
        COSArray cOSArray = (COSArray) getCOSObject().getDictionaryObject("S");
        if (cOSArray == null) {
            return null;
        }
        PDNumberFormatDictionary[] pDNumberFormatDictionaryArr = new PDNumberFormatDictionary[cOSArray.size()];
        for (int i2 = 0; i2 < cOSArray.size(); i2++) {
            pDNumberFormatDictionaryArr[i2] = new PDNumberFormatDictionary((COSDictionary) cOSArray.get(i2));
        }
        return pDNumberFormatDictionaryArr;
    }

    public String getScaleRatio() {
        return getCOSObject().getString(COSName.R);
    }

    public void setAngles(PDNumberFormatDictionary[] pDNumberFormatDictionaryArr) {
        COSArray cOSArray = new COSArray();
        for (PDNumberFormatDictionary pDNumberFormatDictionary : pDNumberFormatDictionaryArr) {
            cOSArray.add(pDNumberFormatDictionary);
        }
        getCOSObject().setItem(PDNumberFormatDictionary.FRACTIONAL_DISPLAY_TRUNCATE, (COSBase) cOSArray);
    }

    public void setAreas(PDNumberFormatDictionary[] pDNumberFormatDictionaryArr) {
        COSArray cOSArray = new COSArray();
        for (PDNumberFormatDictionary pDNumberFormatDictionary : pDNumberFormatDictionaryArr) {
            cOSArray.add(pDNumberFormatDictionary);
        }
        getCOSObject().setItem(COSName.A, (COSBase) cOSArray);
    }

    public void setCYX(float f2) {
        getCOSObject().setFloat("CYX", f2);
    }

    public void setChangeXs(PDNumberFormatDictionary[] pDNumberFormatDictionaryArr) {
        COSArray cOSArray = new COSArray();
        for (PDNumberFormatDictionary pDNumberFormatDictionary : pDNumberFormatDictionaryArr) {
            cOSArray.add(pDNumberFormatDictionary);
        }
        getCOSObject().setItem("X", (COSBase) cOSArray);
    }

    public void setChangeYs(PDNumberFormatDictionary[] pDNumberFormatDictionaryArr) {
        COSArray cOSArray = new COSArray();
        for (PDNumberFormatDictionary pDNumberFormatDictionary : pDNumberFormatDictionaryArr) {
            cOSArray.add(pDNumberFormatDictionary);
        }
        getCOSObject().setItem("Y", (COSBase) cOSArray);
    }

    public void setCoordSystemOrigin(float[] fArr) {
        COSArray cOSArray = new COSArray();
        cOSArray.setFloatArray(fArr);
        getCOSObject().setItem(PDAnnotationLink.HIGHLIGHT_MODE_OUTLINE, (COSBase) cOSArray);
    }

    public void setDistances(PDNumberFormatDictionary[] pDNumberFormatDictionaryArr) {
        COSArray cOSArray = new COSArray();
        for (PDNumberFormatDictionary pDNumberFormatDictionary : pDNumberFormatDictionaryArr) {
            cOSArray.add(pDNumberFormatDictionary);
        }
        getCOSObject().setItem("D", (COSBase) cOSArray);
    }

    public void setLineSloaps(PDNumberFormatDictionary[] pDNumberFormatDictionaryArr) {
        COSArray cOSArray = new COSArray();
        for (PDNumberFormatDictionary pDNumberFormatDictionary : pDNumberFormatDictionaryArr) {
            cOSArray.add(pDNumberFormatDictionary);
        }
        getCOSObject().setItem("S", (COSBase) cOSArray);
    }

    public void setScaleRatio(String str) {
        getCOSObject().setString(COSName.R, str);
    }

    public PDRectlinearMeasureDictionary(COSDictionary cOSDictionary) {
        super(cOSDictionary);
    }
}
