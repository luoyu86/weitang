package com.tom_roush.pdfbox.pdmodel.font;

import android.util.Log;
import com.tom_roush.pdfbox.cos.COSArray;
import com.tom_roush.pdfbox.cos.COSBase;
import com.tom_roush.pdfbox.cos.COSDictionary;
import com.tom_roush.pdfbox.cos.COSInputStream;
import com.tom_roush.pdfbox.cos.COSName;
import com.tom_roush.pdfbox.cos.COSNumber;
import com.tom_roush.pdfbox.cos.COSStream;
import com.tom_roush.pdfbox.io.IOUtils;
import com.tom_roush.pdfbox.pdmodel.common.COSObjectable;
import com.tom_roush.pdfbox.util.Vector;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public abstract class PDCIDFont implements COSObjectable, PDFontLike, PDVectorFont {
    private float averageWidth;
    private float defaultWidth;
    public final COSDictionary dict;
    private PDFontDescriptor fontDescriptor;
    public final PDType0Font parent;
    private Map<Integer, Float> widths;
    private final Map<Integer, Float> verticalDisplacementY = new HashMap();
    private final Map<Integer, Vector> positionVectors = new HashMap();
    private float[] dw2 = {880.0f, -1000.0f};

    public PDCIDFont(COSDictionary cOSDictionary, PDType0Font pDType0Font) {
        this.dict = cOSDictionary;
        this.parent = pDType0Font;
        readWidths();
        readVerticalDisplacements();
    }

    private Vector getDefaultPositionVector(int i2) {
        return new Vector(getWidthForCID(i2) / 2.0f, this.dw2[0]);
    }

    private float getDefaultWidth() {
        if (this.defaultWidth == 0.0f) {
            COSBase dictionaryObject = this.dict.getDictionaryObject(COSName.DW);
            if (dictionaryObject instanceof COSNumber) {
                this.defaultWidth = ((COSNumber) dictionaryObject).floatValue();
            } else {
                this.defaultWidth = 1000.0f;
            }
        }
        return this.defaultWidth;
    }

    private float getWidthForCID(int i2) {
        Float fValueOf = this.widths.get(Integer.valueOf(i2));
        if (fValueOf == null) {
            fValueOf = Float.valueOf(getDefaultWidth());
        }
        return fValueOf.floatValue();
    }

    private void readVerticalDisplacements() {
        COSBase dictionaryObject = this.dict.getDictionaryObject(COSName.DW2);
        if (dictionaryObject instanceof COSArray) {
            COSArray cOSArray = (COSArray) dictionaryObject;
            COSBase object = cOSArray.getObject(0);
            COSBase object2 = cOSArray.getObject(1);
            if ((object instanceof COSNumber) && (object2 instanceof COSNumber)) {
                this.dw2[0] = ((COSNumber) object).floatValue();
                this.dw2[1] = ((COSNumber) object2).floatValue();
            }
        }
        COSBase dictionaryObject2 = this.dict.getDictionaryObject(COSName.W2);
        if (dictionaryObject2 instanceof COSArray) {
            COSArray cOSArray2 = (COSArray) dictionaryObject2;
            int i2 = 0;
            while (i2 < cOSArray2.size()) {
                COSNumber cOSNumber = (COSNumber) cOSArray2.getObject(i2);
                int i3 = i2 + 1;
                COSBase object3 = cOSArray2.getObject(i3);
                if (object3 instanceof COSArray) {
                    COSArray cOSArray3 = (COSArray) object3;
                    int i4 = 0;
                    while (i4 < cOSArray3.size()) {
                        int iIntValue = cOSNumber.intValue() + (i4 / 3);
                        COSNumber cOSNumber2 = (COSNumber) cOSArray3.getObject(i4);
                        int i5 = i4 + 1;
                        COSNumber cOSNumber3 = (COSNumber) cOSArray3.getObject(i5);
                        int i6 = i5 + 1;
                        COSNumber cOSNumber4 = (COSNumber) cOSArray3.getObject(i6);
                        this.verticalDisplacementY.put(Integer.valueOf(iIntValue), Float.valueOf(cOSNumber2.floatValue()));
                        this.positionVectors.put(Integer.valueOf(iIntValue), new Vector(cOSNumber3.floatValue(), cOSNumber4.floatValue()));
                        i4 = i6 + 1;
                    }
                } else {
                    int iIntValue2 = ((COSNumber) object3).intValue();
                    int i7 = i3 + 1;
                    COSNumber cOSNumber5 = (COSNumber) cOSArray2.getObject(i7);
                    int i8 = i7 + 1;
                    COSNumber cOSNumber6 = (COSNumber) cOSArray2.getObject(i8);
                    i3 = i8 + 1;
                    COSNumber cOSNumber7 = (COSNumber) cOSArray2.getObject(i3);
                    for (int iIntValue3 = cOSNumber.intValue(); iIntValue3 <= iIntValue2; iIntValue3++) {
                        this.verticalDisplacementY.put(Integer.valueOf(iIntValue3), Float.valueOf(cOSNumber5.floatValue()));
                        this.positionVectors.put(Integer.valueOf(iIntValue3), new Vector(cOSNumber6.floatValue(), cOSNumber7.floatValue()));
                    }
                }
                i2 = i3 + 1;
            }
        }
    }

    private void readWidths() {
        this.widths = new HashMap();
        COSBase dictionaryObject = this.dict.getDictionaryObject(COSName.W);
        if (dictionaryObject instanceof COSArray) {
            COSArray cOSArray = (COSArray) dictionaryObject;
            int size = cOSArray.size();
            int i2 = 0;
            while (i2 < size) {
                int i3 = i2 + 1;
                COSBase object = cOSArray.getObject(i2);
                if (object instanceof COSNumber) {
                    COSNumber cOSNumber = (COSNumber) object;
                    int i4 = i3 + 1;
                    COSBase object2 = cOSArray.getObject(i3);
                    if (object2 instanceof COSArray) {
                        COSArray cOSArray2 = (COSArray) object2;
                        int iIntValue = cOSNumber.intValue();
                        int size2 = cOSArray2.size();
                        for (int i5 = 0; i5 < size2; i5++) {
                            COSBase object3 = cOSArray2.getObject(i5);
                            if (object3 instanceof COSNumber) {
                                this.widths.put(Integer.valueOf(iIntValue + i5), Float.valueOf(((COSNumber) object3).floatValue()));
                            } else {
                                Log.w("PdfBox-Android", "Expected a number array member, got " + object3);
                            }
                        }
                        i2 = i4;
                    } else {
                        int i6 = i4 + 1;
                        COSBase object4 = cOSArray.getObject(i4);
                        if ((object2 instanceof COSNumber) && (object4 instanceof COSNumber)) {
                            int iIntValue2 = ((COSNumber) object2).intValue();
                            float fFloatValue = ((COSNumber) object4).floatValue();
                            for (int iIntValue3 = cOSNumber.intValue(); iIntValue3 <= iIntValue2; iIntValue3++) {
                                this.widths.put(Integer.valueOf(iIntValue3), Float.valueOf(fFloatValue));
                            }
                        } else {
                            Log.w("PdfBox-Android", "Expected two numbers, got " + object2 + " and " + object4);
                        }
                        i2 = i6;
                    }
                } else {
                    Log.w("PdfBox-Android", "Expected a number array member, got " + object);
                    i2 = i3;
                }
            }
        }
    }

    public abstract int codeToCID(int i2);

    public abstract int codeToGID(int i2) throws IOException;

    public abstract byte[] encode(int i2) throws IOException;

    @Override // com.tom_roush.pdfbox.pdmodel.font.PDFontLike
    public float getAverageFontWidth() {
        float fFloatValue;
        if (this.averageWidth == 0.0f) {
            int i2 = 0;
            Map<Integer, Float> map = this.widths;
            if (map != null) {
                fFloatValue = 0.0f;
                for (Float f2 : map.values()) {
                    if (f2.floatValue() > 0.0f) {
                        fFloatValue += f2.floatValue();
                        i2++;
                    }
                }
            } else {
                fFloatValue = 0.0f;
            }
            if (i2 != 0) {
                this.averageWidth = fFloatValue / i2;
            }
            float f3 = this.averageWidth;
            if (f3 <= 0.0f || Float.isNaN(f3)) {
                this.averageWidth = getDefaultWidth();
            }
        }
        return this.averageWidth;
    }

    public String getBaseFont() {
        return this.dict.getNameAsString(COSName.BASE_FONT);
    }

    public PDCIDSystemInfo getCIDSystemInfo() {
        COSBase dictionaryObject = this.dict.getDictionaryObject(COSName.CIDSYSTEMINFO);
        if (dictionaryObject instanceof COSDictionary) {
            return new PDCIDSystemInfo((COSDictionary) dictionaryObject);
        }
        return null;
    }

    @Override // com.tom_roush.pdfbox.pdmodel.font.PDFontLike
    public PDFontDescriptor getFontDescriptor() {
        COSDictionary cOSDictionary;
        if (this.fontDescriptor == null && (cOSDictionary = (COSDictionary) this.dict.getDictionaryObject(COSName.FONT_DESC)) != null) {
            this.fontDescriptor = new PDFontDescriptor(cOSDictionary);
        }
        return this.fontDescriptor;
    }

    @Override // com.tom_roush.pdfbox.pdmodel.font.PDFontLike
    public String getName() {
        return getBaseFont();
    }

    public final PDType0Font getParent() {
        return this.parent;
    }

    @Override // com.tom_roush.pdfbox.pdmodel.font.PDFontLike
    public Vector getPositionVector(int i2) {
        int iCodeToCID = codeToCID(i2);
        Vector vector = this.positionVectors.get(Integer.valueOf(iCodeToCID));
        return vector == null ? getDefaultPositionVector(iCodeToCID) : vector;
    }

    public float getVerticalDisplacementVectorY(int i2) {
        Float fValueOf = this.verticalDisplacementY.get(Integer.valueOf(codeToCID(i2)));
        if (fValueOf == null) {
            fValueOf = Float.valueOf(this.dw2[1]);
        }
        return fValueOf.floatValue();
    }

    @Override // com.tom_roush.pdfbox.pdmodel.font.PDFontLike
    public float getWidth(int i2) throws IOException {
        return getWidthForCID(codeToCID(i2));
    }

    @Override // com.tom_roush.pdfbox.pdmodel.font.PDFontLike
    public boolean hasExplicitWidth(int i2) throws IOException {
        return this.widths.get(Integer.valueOf(codeToCID(i2))) != null;
    }

    public final int[] readCIDToGIDMap() throws IOException {
        COSBase dictionaryObject = this.dict.getDictionaryObject(COSName.CID_TO_GID_MAP);
        if (!(dictionaryObject instanceof COSStream)) {
            return null;
        }
        COSInputStream cOSInputStreamCreateInputStream = ((COSStream) dictionaryObject).createInputStream();
        byte[] byteArray = IOUtils.toByteArray(cOSInputStreamCreateInputStream);
        IOUtils.closeQuietly(cOSInputStreamCreateInputStream);
        int length = byteArray.length / 2;
        int[] iArr = new int[length];
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            iArr[i3] = ((byteArray[i2] & 255) << 8) | (byteArray[i2 + 1] & 255);
            i2 += 2;
        }
        return iArr;
    }

    @Override // com.tom_roush.pdfbox.pdmodel.common.COSObjectable
    public COSDictionary getCOSObject() {
        return this.dict;
    }
}
