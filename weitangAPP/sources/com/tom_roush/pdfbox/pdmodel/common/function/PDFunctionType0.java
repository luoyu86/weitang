package com.tom_roush.pdfbox.pdmodel.common.function;

import android.util.Log;
import com.tom_roush.harmony.javax.imageio.stream.MemoryCacheImageInputStream;
import com.tom_roush.pdfbox.cos.COSArray;
import com.tom_roush.pdfbox.cos.COSBase;
import com.tom_roush.pdfbox.cos.COSInputStream;
import com.tom_roush.pdfbox.cos.COSInteger;
import com.tom_roush.pdfbox.cos.COSName;
import com.tom_roush.pdfbox.pdmodel.common.PDRange;
import java.io.IOException;
import java.lang.reflect.Array;

/* JADX INFO: loaded from: classes2.dex */
public class PDFunctionType0 extends PDFunction {
    private COSArray decode;
    private COSArray encode;
    private int[][] samples;
    private COSArray size;

    public class Rinterpol {
        private final float[] in;
        private final int[] inNext;
        private final int[] inPrev;
        private final int numberOfInputValues;
        private final int numberOfOutputValues;

        public Rinterpol(float[] fArr, int[] iArr, int[] iArr2) {
            this.numberOfOutputValues = PDFunctionType0.this.getNumberOfOutputParameters();
            this.in = fArr;
            this.inPrev = iArr;
            this.inNext = iArr2;
            this.numberOfInputValues = fArr.length;
        }

        private int calcSampleIndex(int[] iArr) {
            float[] floatArray = PDFunctionType0.this.getSize().toFloatArray();
            int length = iArr.length;
            int i2 = 1;
            for (int i3 = length - 2; i3 >= 0; i3--) {
                i2 = (int) (i2 * floatArray[i3]);
            }
            int i4 = 0;
            for (int i5 = length - 1; i5 >= 0; i5--) {
                i4 += iArr[i5] * i2;
                int i6 = i5 - 1;
                if (i6 >= 0) {
                    i2 = (int) (i2 / floatArray[i6]);
                }
            }
            return i4;
        }

        private int[][] getSamples() {
            if (PDFunctionType0.this.samples == null) {
                int numberOfInputParameters = PDFunctionType0.this.getNumberOfInputParameters();
                int numberOfOutputParameters = PDFunctionType0.this.getNumberOfOutputParameters();
                COSArray size = PDFunctionType0.this.getSize();
                int i2 = 1;
                for (int i3 = 0; i3 < numberOfInputParameters; i3++) {
                    i2 *= size.getInt(i3);
                }
                PDFunctionType0.this.samples = (int[][]) Array.newInstance((Class<?>) int.class, i2, numberOfOutputParameters);
                int bitsPerSample = PDFunctionType0.this.getBitsPerSample();
                try {
                    COSInputStream cOSInputStreamCreateInputStream = PDFunctionType0.this.getPDStream().createInputStream();
                    MemoryCacheImageInputStream memoryCacheImageInputStream = new MemoryCacheImageInputStream(cOSInputStreamCreateInputStream);
                    int i4 = 0;
                    for (int i5 = 0; i5 < i2; i5++) {
                        for (int i6 = 0; i6 < numberOfOutputParameters; i6++) {
                            PDFunctionType0.this.samples[i4][i6] = (int) memoryCacheImageInputStream.readBits(bitsPerSample);
                        }
                        i4++;
                    }
                    memoryCacheImageInputStream.close();
                    cOSInputStreamCreateInputStream.close();
                } catch (IOException e2) {
                    Log.e("PdfBox-Android", "IOException while reading the sample values of this function.", e2);
                }
            }
            return PDFunctionType0.this.samples;
        }

        private float[] rinterpol(int[] iArr, int i2) {
            float[] fArr = new float[this.numberOfOutputValues];
            int i3 = 0;
            if (i2 != this.in.length - 1) {
                int[] iArr2 = this.inPrev;
                if (iArr2[i2] == this.inNext[i2]) {
                    iArr[i2] = iArr2[i2];
                    return rinterpol(iArr, i2 + 1);
                }
                iArr[i2] = iArr2[i2];
                int i4 = i2 + 1;
                float[] fArrRinterpol = rinterpol(iArr, i4);
                iArr[i2] = this.inNext[i2];
                float[] fArrRinterpol2 = rinterpol(iArr, i4);
                while (i3 < this.numberOfOutputValues) {
                    fArr[i3] = PDFunctionType0.this.interpolate(this.in[i2], this.inPrev[i2], this.inNext[i2], fArrRinterpol[i3], fArrRinterpol2[i3]);
                    i3++;
                }
                return fArr;
            }
            int[] iArr3 = this.inPrev;
            if (iArr3[i2] == this.inNext[i2]) {
                iArr[i2] = iArr3[i2];
                int[] iArr4 = getSamples()[calcSampleIndex(iArr)];
                while (i3 < this.numberOfOutputValues) {
                    fArr[i3] = iArr4[i3];
                    i3++;
                }
                return fArr;
            }
            iArr[i2] = iArr3[i2];
            int[] iArr5 = getSamples()[calcSampleIndex(iArr)];
            iArr[i2] = this.inNext[i2];
            int[] iArr6 = getSamples()[calcSampleIndex(iArr)];
            while (i3 < this.numberOfOutputValues) {
                fArr[i3] = PDFunctionType0.this.interpolate(this.in[i2], this.inPrev[i2], this.inNext[i2], iArr5[i3], iArr6[i3]);
                i3++;
            }
            return fArr;
        }

        public float[] rinterpolate() {
            return rinterpol(new int[this.numberOfInputValues], 0);
        }
    }

    public PDFunctionType0(COSBase cOSBase) {
        super(cOSBase);
        this.encode = null;
        this.decode = null;
        this.size = null;
        this.samples = null;
    }

    private COSArray getDecodeValues() {
        if (this.decode == null) {
            COSArray cOSArray = (COSArray) getCOSObject().getDictionaryObject(COSName.DECODE);
            this.decode = cOSArray;
            if (cOSArray == null) {
                this.decode = getRangeValues();
            }
        }
        return this.decode;
    }

    private COSArray getEncodeValues() {
        if (this.encode == null) {
            COSArray cOSArray = (COSArray) getCOSObject().getDictionaryObject(COSName.ENCODE);
            this.encode = cOSArray;
            if (cOSArray == null) {
                this.encode = new COSArray();
                int size = getSize().size();
                for (int i2 = 0; i2 < size; i2++) {
                    this.encode.add((COSBase) COSInteger.ZERO);
                    this.encode.add((COSBase) COSInteger.get(r0.getInt(i2) - 1));
                }
            }
        }
        return this.encode;
    }

    @Override // com.tom_roush.pdfbox.pdmodel.common.function.PDFunction
    public float[] eval(float[] fArr) throws IOException {
        float[] floatArray = getSize().toFloatArray();
        float fPow = (float) (Math.pow(2.0d, getBitsPerSample()) - 1.0d);
        int length = fArr.length;
        int numberOfOutputParameters = getNumberOfOutputParameters();
        int[] iArr = new int[length];
        int[] iArr2 = new int[length];
        float[] fArr2 = (float[]) fArr.clone();
        for (int i2 = 0; i2 < length; i2++) {
            PDRange domainForInput = getDomainForInput(i2);
            PDRange encodeForParameter = getEncodeForParameter(i2);
            fArr2[i2] = clipToRange(fArr2[i2], domainForInput.getMin(), domainForInput.getMax());
            fArr2[i2] = interpolate(fArr2[i2], domainForInput.getMin(), domainForInput.getMax(), encodeForParameter.getMin(), encodeForParameter.getMax());
            fArr2[i2] = clipToRange(fArr2[i2], 0.0f, floatArray[i2] - 1.0f);
            iArr[i2] = (int) Math.floor(fArr2[i2]);
            iArr2[i2] = (int) Math.ceil(fArr2[i2]);
        }
        float[] fArrRinterpolate = new Rinterpol(fArr2, iArr, iArr2).rinterpolate();
        for (int i3 = 0; i3 < numberOfOutputParameters; i3++) {
            PDRange rangeForOutput = getRangeForOutput(i3);
            PDRange decodeForParameter = getDecodeForParameter(i3);
            fArrRinterpolate[i3] = interpolate(fArrRinterpolate[i3], 0.0f, fPow, decodeForParameter.getMin(), decodeForParameter.getMax());
            fArrRinterpolate[i3] = clipToRange(fArrRinterpolate[i3], rangeForOutput.getMin(), rangeForOutput.getMax());
        }
        return fArrRinterpolate;
    }

    public int getBitsPerSample() {
        return getCOSObject().getInt(COSName.BITS_PER_SAMPLE);
    }

    public PDRange getDecodeForParameter(int i2) {
        COSArray decodeValues = getDecodeValues();
        if (decodeValues == null || decodeValues.size() < (i2 * 2) + 1) {
            return null;
        }
        return new PDRange(decodeValues, i2);
    }

    public PDRange getEncodeForParameter(int i2) {
        COSArray encodeValues = getEncodeValues();
        if (encodeValues == null || encodeValues.size() < (i2 * 2) + 1) {
            return null;
        }
        return new PDRange(encodeValues, i2);
    }

    @Override // com.tom_roush.pdfbox.pdmodel.common.function.PDFunction
    public int getFunctionType() {
        return 0;
    }

    public int getOrder() {
        return getCOSObject().getInt(COSName.ORDER, 1);
    }

    public COSArray getSize() {
        if (this.size == null) {
            this.size = (COSArray) getCOSObject().getDictionaryObject(COSName.SIZE);
        }
        return this.size;
    }

    public void setBitsPerSample(int i2) {
        getCOSObject().setInt(COSName.BITS_PER_SAMPLE, i2);
    }

    public void setDecodeValues(COSArray cOSArray) {
        this.decode = cOSArray;
        getCOSObject().setItem(COSName.DECODE, (COSBase) cOSArray);
    }

    public void setEncodeValues(COSArray cOSArray) {
        this.encode = cOSArray;
        getCOSObject().setItem(COSName.ENCODE, (COSBase) cOSArray);
    }
}
