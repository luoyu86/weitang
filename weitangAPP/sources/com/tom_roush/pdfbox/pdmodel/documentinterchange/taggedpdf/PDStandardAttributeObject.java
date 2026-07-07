package com.tom_roush.pdfbox.pdmodel.documentinterchange.taggedpdf;

import com.tom_roush.pdfbox.cos.COSArray;
import com.tom_roush.pdfbox.cos.COSBase;
import com.tom_roush.pdfbox.cos.COSDictionary;
import com.tom_roush.pdfbox.cos.COSFloat;
import com.tom_roush.pdfbox.cos.COSName;
import com.tom_roush.pdfbox.cos.COSNumber;
import com.tom_roush.pdfbox.cos.COSString;
import com.tom_roush.pdfbox.pdmodel.documentinterchange.logicalstructure.PDAttributeObject;
import com.tom_roush.pdfbox.pdmodel.graphics.color.PDGamma;

/* JADX INFO: loaded from: classes2.dex */
public abstract class PDStandardAttributeObject extends PDAttributeObject {
    public static final float UNSPECIFIED = -1.0f;

    public PDStandardAttributeObject() {
    }

    public String[] getArrayOfString(String str) {
        COSBase dictionaryObject = getCOSObject().getDictionaryObject(str);
        if (!(dictionaryObject instanceof COSArray)) {
            return null;
        }
        COSArray cOSArray = (COSArray) dictionaryObject;
        String[] strArr = new String[cOSArray.size()];
        for (int i2 = 0; i2 < cOSArray.size(); i2++) {
            strArr[i2] = ((COSName) cOSArray.getObject(i2)).getName();
        }
        return strArr;
    }

    public PDGamma getColor(String str) {
        COSArray cOSArray = (COSArray) getCOSObject().getDictionaryObject(str);
        if (cOSArray != null) {
            return new PDGamma(cOSArray);
        }
        return null;
    }

    public Object getColorOrFourColors(String str) {
        COSArray cOSArray = (COSArray) getCOSObject().getDictionaryObject(str);
        if (cOSArray == null) {
            return null;
        }
        if (cOSArray.size() == 3) {
            return new PDGamma(cOSArray);
        }
        if (cOSArray.size() == 4) {
            return new PDFourColours(cOSArray);
        }
        return null;
    }

    public int getInteger(String str, int i2) {
        return getCOSObject().getInt(str, i2);
    }

    public String getName(String str) {
        return getCOSObject().getNameAsString(str);
    }

    public Object getNameOrArrayOfName(String str, String str2) {
        COSBase dictionaryObject = getCOSObject().getDictionaryObject(str);
        if (!(dictionaryObject instanceof COSArray)) {
            return dictionaryObject instanceof COSName ? ((COSName) dictionaryObject).getName() : str2;
        }
        COSArray cOSArray = (COSArray) dictionaryObject;
        String[] strArr = new String[cOSArray.size()];
        for (int i2 = 0; i2 < cOSArray.size(); i2++) {
            COSBase object = cOSArray.getObject(i2);
            if (object instanceof COSName) {
                strArr[i2] = ((COSName) object).getName();
            }
        }
        return strArr;
    }

    public float getNumber(String str, float f2) {
        return getCOSObject().getFloat(str, f2);
    }

    public Object getNumberOrArrayOfNumber(String str, float f2) {
        COSBase dictionaryObject = getCOSObject().getDictionaryObject(str);
        if (!(dictionaryObject instanceof COSArray)) {
            if (dictionaryObject instanceof COSNumber) {
                return Float.valueOf(((COSNumber) dictionaryObject).floatValue());
            }
            if (f2 == -1.0f) {
                return null;
            }
            return Float.valueOf(f2);
        }
        COSArray cOSArray = (COSArray) dictionaryObject;
        float[] fArr = new float[cOSArray.size()];
        for (int i2 = 0; i2 < cOSArray.size(); i2++) {
            COSBase object = cOSArray.getObject(i2);
            if (object instanceof COSNumber) {
                fArr[i2] = ((COSNumber) object).floatValue();
            }
        }
        return fArr;
    }

    public Object getNumberOrName(String str, String str2) {
        COSBase dictionaryObject = getCOSObject().getDictionaryObject(str);
        return dictionaryObject instanceof COSNumber ? Float.valueOf(((COSNumber) dictionaryObject).floatValue()) : dictionaryObject instanceof COSName ? ((COSName) dictionaryObject).getName() : str2;
    }

    public String getString(String str) {
        return getCOSObject().getString(str);
    }

    public boolean isSpecified(String str) {
        return getCOSObject().getDictionaryObject(str) != null;
    }

    public void setArrayOfName(String str, String[] strArr) {
        COSBase dictionaryObject = getCOSObject().getDictionaryObject(str);
        COSArray cOSArray = new COSArray();
        for (String str2 : strArr) {
            cOSArray.add((COSBase) COSName.getPDFName(str2));
        }
        getCOSObject().setItem(str, (COSBase) cOSArray);
        potentiallyNotifyChanged(dictionaryObject, getCOSObject().getDictionaryObject(str));
    }

    public void setArrayOfNumber(String str, float[] fArr) {
        COSArray cOSArray = new COSArray();
        for (float f2 : fArr) {
            cOSArray.add((COSBase) new COSFloat(f2));
        }
        COSBase dictionaryObject = getCOSObject().getDictionaryObject(str);
        getCOSObject().setItem(str, (COSBase) cOSArray);
        potentiallyNotifyChanged(dictionaryObject, getCOSObject().getDictionaryObject(str));
    }

    public void setArrayOfString(String str, String[] strArr) {
        COSBase dictionaryObject = getCOSObject().getDictionaryObject(str);
        COSArray cOSArray = new COSArray();
        for (String str2 : strArr) {
            cOSArray.add((COSBase) new COSString(str2));
        }
        getCOSObject().setItem(str, (COSBase) cOSArray);
        potentiallyNotifyChanged(dictionaryObject, getCOSObject().getDictionaryObject(str));
    }

    public void setColor(String str, PDGamma pDGamma) {
        COSBase dictionaryObject = getCOSObject().getDictionaryObject(str);
        getCOSObject().setItem(str, pDGamma);
        potentiallyNotifyChanged(dictionaryObject, pDGamma == null ? null : pDGamma.getCOSObject());
    }

    public void setFourColors(String str, PDFourColours pDFourColours) {
        COSBase dictionaryObject = getCOSObject().getDictionaryObject(str);
        getCOSObject().setItem(str, pDFourColours);
        potentiallyNotifyChanged(dictionaryObject, pDFourColours == null ? null : pDFourColours.getCOSObject());
    }

    public void setInteger(String str, int i2) {
        COSBase dictionaryObject = getCOSObject().getDictionaryObject(str);
        getCOSObject().setInt(str, i2);
        potentiallyNotifyChanged(dictionaryObject, getCOSObject().getDictionaryObject(str));
    }

    public void setName(String str, String str2) {
        COSBase dictionaryObject = getCOSObject().getDictionaryObject(str);
        getCOSObject().setName(str, str2);
        potentiallyNotifyChanged(dictionaryObject, getCOSObject().getDictionaryObject(str));
    }

    public void setNumber(String str, float f2) {
        COSBase dictionaryObject = getCOSObject().getDictionaryObject(str);
        getCOSObject().setFloat(str, f2);
        potentiallyNotifyChanged(dictionaryObject, getCOSObject().getDictionaryObject(str));
    }

    public void setString(String str, String str2) {
        COSBase dictionaryObject = getCOSObject().getDictionaryObject(str);
        getCOSObject().setString(str, str2);
        potentiallyNotifyChanged(dictionaryObject, getCOSObject().getDictionaryObject(str));
    }

    public PDStandardAttributeObject(COSDictionary cOSDictionary) {
        super(cOSDictionary);
    }

    public String getName(String str, String str2) {
        return getCOSObject().getNameAsString(str, str2);
    }

    public float getNumber(String str) {
        return getCOSObject().getFloat(str);
    }

    public void setNumber(String str, int i2) {
        COSBase dictionaryObject = getCOSObject().getDictionaryObject(str);
        getCOSObject().setInt(str, i2);
        potentiallyNotifyChanged(dictionaryObject, getCOSObject().getDictionaryObject(str));
    }
}
