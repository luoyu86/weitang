package com.tom_roush.pdfbox.pdmodel.graphics.color;

import com.alipay.sdk.m.u.i;
import com.tom_roush.pdfbox.cos.COSArray;
import com.tom_roush.pdfbox.cos.COSBase;
import com.tom_roush.pdfbox.cos.COSName;
import com.tom_roush.pdfbox.cos.COSNumber;
import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
public final class PDColor {
    private final PDColorSpace colorSpace;
    private final float[] components;
    private final COSName patternName;

    public PDColor(COSArray cOSArray, PDColorSpace pDColorSpace) {
        int i2 = 0;
        if (cOSArray.size() <= 0 || !(cOSArray.get(cOSArray.size() - 1) instanceof COSName)) {
            this.components = new float[cOSArray.size()];
            while (i2 < cOSArray.size()) {
                this.components[i2] = ((COSNumber) cOSArray.get(i2)).floatValue();
                i2++;
            }
            this.patternName = null;
        } else {
            this.components = new float[cOSArray.size() - 1];
            while (true) {
                float[] fArr = this.components;
                if (i2 >= fArr.length) {
                    break;
                }
                fArr[i2] = ((COSNumber) cOSArray.get(i2)).floatValue();
                i2++;
            }
            this.patternName = (COSName) cOSArray.get(cOSArray.size() - 1);
        }
        this.colorSpace = pDColorSpace;
    }

    public PDColorSpace getColorSpace() {
        return this.colorSpace;
    }

    public float[] getComponents() {
        PDColorSpace pDColorSpace = this.colorSpace;
        return pDColorSpace == null ? (float[]) this.components.clone() : Arrays.copyOf(this.components, pDColorSpace.getNumberOfComponents());
    }

    public COSName getPatternName() {
        return this.patternName;
    }

    public boolean isPattern() {
        return this.patternName != null;
    }

    public COSArray toCOSArray() {
        COSArray cOSArray = new COSArray();
        cOSArray.setFloatArray(this.components);
        COSName cOSName = this.patternName;
        if (cOSName != null) {
            cOSArray.add((COSBase) cOSName);
        }
        return cOSArray;
    }

    public int toRGB() throws IOException {
        float[] rgb = this.colorSpace.toRGB(this.components);
        int iRound = Math.round(rgb[0] * 255.0f);
        return (((iRound << 8) + Math.round(rgb[1] * 255.0f)) << 8) + Math.round(rgb[2] * 255.0f);
    }

    public String toString() {
        return "PDColor{components=" + Arrays.toString(this.components) + ", patternName=" + this.patternName + i.f5699d;
    }

    public PDColor(float[] fArr, PDColorSpace pDColorSpace) {
        this.components = (float[]) fArr.clone();
        this.patternName = null;
        this.colorSpace = pDColorSpace;
    }

    public PDColor(COSName cOSName, PDColorSpace pDColorSpace) {
        this.components = new float[0];
        this.patternName = cOSName;
        this.colorSpace = pDColorSpace;
    }

    public PDColor(float[] fArr, COSName cOSName, PDColorSpace pDColorSpace) {
        this.components = (float[]) fArr.clone();
        this.patternName = cOSName;
        this.colorSpace = pDColorSpace;
    }
}
