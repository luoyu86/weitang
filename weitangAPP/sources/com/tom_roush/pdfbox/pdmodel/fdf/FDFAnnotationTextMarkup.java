package com.tom_roush.pdfbox.pdmodel.fdf;

import com.tom_roush.pdfbox.cos.COSArray;
import com.tom_roush.pdfbox.cos.COSBase;
import com.tom_roush.pdfbox.cos.COSDictionary;
import com.tom_roush.pdfbox.cos.COSName;
import java.io.IOException;
import org.w3c.dom.Element;

/* JADX INFO: loaded from: classes2.dex */
public abstract class FDFAnnotationTextMarkup extends FDFAnnotation {
    public FDFAnnotationTextMarkup() {
    }

    public float[] getCoords() {
        COSArray cOSArray = (COSArray) this.annot.getItem(COSName.QUADPOINTS);
        if (cOSArray != null) {
            return cOSArray.toFloatArray();
        }
        return null;
    }

    public void setCoords(float[] fArr) {
        COSArray cOSArray = new COSArray();
        cOSArray.setFloatArray(fArr);
        this.annot.setItem(COSName.QUADPOINTS, (COSBase) cOSArray);
    }

    public FDFAnnotationTextMarkup(COSDictionary cOSDictionary) {
        super(cOSDictionary);
    }

    public FDFAnnotationTextMarkup(Element element) throws IOException {
        super(element);
        String attribute = element.getAttribute("coords");
        if (attribute != null && !attribute.isEmpty()) {
            String[] strArrSplit = attribute.split(",");
            if (strArrSplit.length >= 8) {
                float[] fArr = new float[strArrSplit.length];
                for (int i2 = 0; i2 < strArrSplit.length; i2++) {
                    fArr[i2] = Float.parseFloat(strArrSplit[i2]);
                }
                setCoords(fArr);
                return;
            }
            throw new IOException("Error: too little numbers in attribute 'coords'");
        }
        throw new IOException("Error: missing attribute 'coords'");
    }
}
