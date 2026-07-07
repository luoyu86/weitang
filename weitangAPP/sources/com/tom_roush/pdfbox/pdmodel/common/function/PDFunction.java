package com.tom_roush.pdfbox.pdmodel.common.function;

import com.tom_roush.pdfbox.cos.COSArray;
import com.tom_roush.pdfbox.cos.COSBase;
import com.tom_roush.pdfbox.cos.COSDictionary;
import com.tom_roush.pdfbox.cos.COSName;
import com.tom_roush.pdfbox.cos.COSObject;
import com.tom_roush.pdfbox.cos.COSStream;
import com.tom_roush.pdfbox.pdmodel.common.COSObjectable;
import com.tom_roush.pdfbox.pdmodel.common.PDRange;
import com.tom_roush.pdfbox.pdmodel.common.PDStream;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public abstract class PDFunction implements COSObjectable {
    private COSDictionary functionDictionary;
    private PDStream functionStream;
    private COSArray domain = null;
    private COSArray range = null;
    private int numberOfInputValues = -1;
    private int numberOfOutputValues = -1;

    public PDFunction(COSBase cOSBase) {
        this.functionStream = null;
        this.functionDictionary = null;
        if (cOSBase instanceof COSStream) {
            PDStream pDStream = new PDStream((COSStream) cOSBase);
            this.functionStream = pDStream;
            pDStream.getCOSObject().setItem(COSName.TYPE, (COSBase) COSName.FUNCTION);
        } else if (cOSBase instanceof COSDictionary) {
            this.functionDictionary = (COSDictionary) cOSBase;
        }
    }

    public static PDFunction create(COSBase cOSBase) throws IOException {
        if (cOSBase == COSName.IDENTITY) {
            return new PDFunctionTypeIdentity(null);
        }
        if (cOSBase instanceof COSObject) {
            cOSBase = ((COSObject) cOSBase).getObject();
        }
        if (!(cOSBase instanceof COSDictionary)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Error: Function must be a Dictionary, but is ");
            sb.append(cOSBase == null ? "(null)" : cOSBase.getClass().getSimpleName());
            throw new IOException(sb.toString());
        }
        COSDictionary cOSDictionary = (COSDictionary) cOSBase;
        int i2 = cOSDictionary.getInt(COSName.FUNCTION_TYPE);
        if (i2 == 0) {
            return new PDFunctionType0(cOSDictionary);
        }
        if (i2 == 2) {
            return new PDFunctionType2(cOSDictionary);
        }
        if (i2 == 3) {
            return new PDFunctionType3(cOSDictionary);
        }
        if (i2 == 4) {
            return new PDFunctionType4(cOSDictionary);
        }
        throw new IOException("Error: Unknown function type " + i2);
    }

    private COSArray getDomainValues() {
        if (this.domain == null) {
            this.domain = (COSArray) getCOSObject().getDictionaryObject(COSName.DOMAIN);
        }
        return this.domain;
    }

    public float clipToRange(float f2, float f3, float f4) {
        return f2 < f3 ? f3 : f2 > f4 ? f4 : f2;
    }

    public float[] clipToRange(float[] fArr) {
        COSArray rangeValues = getRangeValues();
        if (rangeValues == null || rangeValues.size() <= 0) {
            return fArr;
        }
        float[] floatArray = rangeValues.toFloatArray();
        int length = floatArray.length / 2;
        float[] fArr2 = new float[length];
        for (int i2 = 0; i2 < length; i2++) {
            int i3 = i2 << 1;
            fArr2[i2] = clipToRange(fArr[i2], floatArray[i3], floatArray[i3 + 1]);
        }
        return fArr2;
    }

    @Deprecated
    public COSArray eval(COSArray cOSArray) throws IOException {
        float[] fArrEval = eval(cOSArray.toFloatArray());
        COSArray cOSArray2 = new COSArray();
        cOSArray2.setFloatArray(fArrEval);
        return cOSArray2;
    }

    public abstract float[] eval(float[] fArr) throws IOException;

    public PDRange getDomainForInput(int i2) {
        return new PDRange(getDomainValues(), i2);
    }

    public abstract int getFunctionType();

    public int getNumberOfInputParameters() {
        if (this.numberOfInputValues == -1) {
            this.numberOfInputValues = getDomainValues().size() / 2;
        }
        return this.numberOfInputValues;
    }

    public int getNumberOfOutputParameters() {
        if (this.numberOfOutputValues == -1) {
            this.numberOfOutputValues = getRangeValues().size() / 2;
        }
        return this.numberOfOutputValues;
    }

    public PDStream getPDStream() {
        return this.functionStream;
    }

    public PDRange getRangeForOutput(int i2) {
        return new PDRange(getRangeValues(), i2);
    }

    public COSArray getRangeValues() {
        if (this.range == null) {
            this.range = (COSArray) getCOSObject().getDictionaryObject(COSName.RANGE);
        }
        return this.range;
    }

    public float interpolate(float f2, float f3, float f4, float f5, float f6) {
        return f5 + (((f2 - f3) * (f6 - f5)) / (f4 - f3));
    }

    public void setDomainValues(COSArray cOSArray) {
        this.domain = cOSArray;
        getCOSObject().setItem(COSName.DOMAIN, (COSBase) cOSArray);
    }

    public void setRangeValues(COSArray cOSArray) {
        this.range = cOSArray;
        getCOSObject().setItem(COSName.RANGE, (COSBase) cOSArray);
    }

    public String toString() {
        return "FunctionType" + getFunctionType();
    }

    @Override // com.tom_roush.pdfbox.pdmodel.common.COSObjectable
    public COSDictionary getCOSObject() {
        PDStream pDStream = this.functionStream;
        return pDStream != null ? pDStream.getCOSObject() : this.functionDictionary;
    }
}
