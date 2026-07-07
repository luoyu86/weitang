package com.tom_roush.pdfbox.pdmodel.common.function;

import com.tom_roush.pdfbox.cos.COSArray;
import com.tom_roush.pdfbox.cos.COSBase;
import com.tom_roush.pdfbox.cos.COSName;
import com.tom_roush.pdfbox.pdmodel.common.PDRange;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public class PDFunctionType3 extends PDFunction {
    private COSArray bounds;
    private float[] boundsValues;
    private COSArray encode;
    private COSArray functions;
    private PDFunction[] functionsArray;

    public PDFunctionType3(COSBase cOSBase) {
        super(cOSBase);
        this.functions = null;
        this.encode = null;
        this.bounds = null;
        this.functionsArray = null;
        this.boundsValues = null;
    }

    private PDRange getEncodeForParameter(int i2) {
        return new PDRange(getEncode(), i2);
    }

    @Override // com.tom_roush.pdfbox.pdmodel.common.function.PDFunction
    public float[] eval(float[] fArr) throws IOException {
        PDFunction pDFunction;
        float fInterpolate;
        float f2 = fArr[0];
        PDRange domainForInput = getDomainForInput(0);
        float fClipToRange = clipToRange(f2, domainForInput.getMin(), domainForInput.getMax());
        if (this.functionsArray == null) {
            COSArray functions = getFunctions();
            this.functionsArray = new PDFunction[functions.size()];
            for (int i2 = 0; i2 < functions.size(); i2++) {
                this.functionsArray[i2] = PDFunction.create(functions.getObject(i2));
            }
        }
        PDFunction[] pDFunctionArr = this.functionsArray;
        if (pDFunctionArr.length == 1) {
            pDFunction = pDFunctionArr[0];
            PDRange encodeForParameter = getEncodeForParameter(0);
            fInterpolate = interpolate(fClipToRange, domainForInput.getMin(), domainForInput.getMax(), encodeForParameter.getMin(), encodeForParameter.getMax());
        } else {
            if (this.boundsValues == null) {
                this.boundsValues = getBounds().toFloatArray();
            }
            int length = this.boundsValues.length;
            int i3 = length + 2;
            float[] fArr2 = new float[i3];
            fArr2[0] = domainForInput.getMin();
            int i4 = i3 - 1;
            fArr2[i4] = domainForInput.getMax();
            System.arraycopy(this.boundsValues, 0, fArr2, 1, length);
            for (int i5 = 0; i5 < i4; i5++) {
                if (fClipToRange >= fArr2[i5]) {
                    int i6 = i5 + 1;
                    if (fClipToRange < fArr2[i6] || (i5 == i3 - 2 && fClipToRange == fArr2[i6])) {
                        PDFunction pDFunction2 = this.functionsArray[i5];
                        PDRange encodeForParameter2 = getEncodeForParameter(i5);
                        fClipToRange = interpolate(fClipToRange, fArr2[i5], fArr2[i6], encodeForParameter2.getMin(), encodeForParameter2.getMax());
                        pDFunction = pDFunction2;
                        break;
                    }
                }
            }
            pDFunction = null;
            if (pDFunction == null) {
                throw new IOException("partition not found in type 3 function");
            }
            fInterpolate = fClipToRange;
        }
        return clipToRange(pDFunction.eval(new float[]{fInterpolate}));
    }

    public COSArray getBounds() {
        if (this.bounds == null) {
            this.bounds = (COSArray) getCOSObject().getDictionaryObject(COSName.BOUNDS);
        }
        return this.bounds;
    }

    public COSArray getEncode() {
        if (this.encode == null) {
            this.encode = (COSArray) getCOSObject().getDictionaryObject(COSName.ENCODE);
        }
        return this.encode;
    }

    @Override // com.tom_roush.pdfbox.pdmodel.common.function.PDFunction
    public int getFunctionType() {
        return 3;
    }

    public COSArray getFunctions() {
        if (this.functions == null) {
            this.functions = (COSArray) getCOSObject().getDictionaryObject(COSName.FUNCTIONS);
        }
        return this.functions;
    }
}
