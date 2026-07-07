package com.tom_roush.pdfbox.pdmodel.interactive.annotation.handlers;

import com.tom_roush.pdfbox.cos.COSArray;
import com.tom_roush.pdfbox.cos.COSBase;
import com.tom_roush.pdfbox.cos.COSNumber;
import com.tom_roush.pdfbox.pdmodel.interactive.annotation.PDAnnotation;
import com.tom_roush.pdfbox.pdmodel.interactive.annotation.PDBorderStyleDictionary;

/* JADX INFO: loaded from: classes2.dex */
public class AnnotationBorder {
    public float[] dashArray = null;
    public boolean underline = false;
    public float width = 0.0f;

    public static AnnotationBorder getAnnotationBorder(PDAnnotation pDAnnotation, PDBorderStyleDictionary pDBorderStyleDictionary) {
        AnnotationBorder annotationBorder = new AnnotationBorder();
        boolean z = true;
        if (pDBorderStyleDictionary == null) {
            COSArray border = pDAnnotation.getBorder();
            if (border.size() >= 3 && (border.getObject(2) instanceof COSNumber)) {
                annotationBorder.width = ((COSNumber) border.getObject(2)).floatValue();
            }
            if (border.size() > 3) {
                COSBase object = border.getObject(3);
                if (object instanceof COSArray) {
                    annotationBorder.dashArray = ((COSArray) object).toFloatArray();
                }
            }
        } else {
            annotationBorder.width = pDBorderStyleDictionary.getWidth();
            if (pDBorderStyleDictionary.getStyle().equals("D")) {
                annotationBorder.dashArray = pDBorderStyleDictionary.getDashStyle().getDashArray();
            }
            if (pDBorderStyleDictionary.getStyle().equals(PDBorderStyleDictionary.STYLE_UNDERLINE)) {
                annotationBorder.underline = true;
            }
        }
        float[] fArr = annotationBorder.dashArray;
        if (fArr != null) {
            int length = fArr.length;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    break;
                }
                if (Float.compare(fArr[i2], 0.0f) != 0) {
                    z = false;
                    break;
                }
                i2++;
            }
            if (z) {
                annotationBorder.dashArray = null;
            }
        }
        return annotationBorder;
    }
}
