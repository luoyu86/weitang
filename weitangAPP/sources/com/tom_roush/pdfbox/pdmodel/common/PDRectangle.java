package com.tom_roush.pdfbox.pdmodel.common;

import android.graphics.Path;
import android.graphics.PointF;
import com.tom_roush.fontbox.util.BoundingBox;
import com.tom_roush.pdfbox.cos.COSArray;
import com.tom_roush.pdfbox.cos.COSBase;
import com.tom_roush.pdfbox.cos.COSFloat;
import com.tom_roush.pdfbox.cos.COSNumber;
import com.tom_roush.pdfbox.util.Matrix;
import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
public class PDRectangle implements COSObjectable {
    private static final float POINTS_PER_INCH = 72.0f;
    private static final float POINTS_PER_MM = 2.8346457f;
    private final COSArray rectArray;
    public static final PDRectangle LETTER = new PDRectangle(612.0f, 792.0f);
    public static final PDRectangle LEGAL = new PDRectangle(612.0f, 1008.0f);
    public static final PDRectangle A0 = new PDRectangle(2383.937f, 3370.3938f);
    public static final PDRectangle A1 = new PDRectangle(1683.7795f, 2383.937f);
    public static final PDRectangle A2 = new PDRectangle(1190.5513f, 1683.7795f);
    public static final PDRectangle A3 = new PDRectangle(841.8898f, 1190.5513f);
    public static final PDRectangle A4 = new PDRectangle(595.27563f, 841.8898f);
    public static final PDRectangle A5 = new PDRectangle(419.52756f, 595.27563f);
    public static final PDRectangle A6 = new PDRectangle(297.63782f, 419.52756f);

    public PDRectangle() {
        this(0.0f, 0.0f, 0.0f, 0.0f);
    }

    public boolean contains(float f2, float f3) {
        return f2 >= getLowerLeftX() && f2 <= getUpperRightX() && f3 >= getLowerLeftY() && f3 <= getUpperRightY();
    }

    public PDRectangle createRetranslatedRectangle() {
        PDRectangle pDRectangle = new PDRectangle();
        pDRectangle.setUpperRightX(getWidth());
        pDRectangle.setUpperRightY(getHeight());
        return pDRectangle;
    }

    public COSArray getCOSArray() {
        return this.rectArray;
    }

    @Override // com.tom_roush.pdfbox.pdmodel.common.COSObjectable
    public COSBase getCOSObject() {
        return this.rectArray;
    }

    public float getHeight() {
        return getUpperRightY() - getLowerLeftY();
    }

    public float getLowerLeftX() {
        return ((COSNumber) this.rectArray.get(0)).floatValue();
    }

    public float getLowerLeftY() {
        return ((COSNumber) this.rectArray.get(1)).floatValue();
    }

    public float getUpperRightX() {
        return ((COSNumber) this.rectArray.get(2)).floatValue();
    }

    public float getUpperRightY() {
        return ((COSNumber) this.rectArray.get(3)).floatValue();
    }

    public float getWidth() {
        return getUpperRightX() - getLowerLeftX();
    }

    public void setLowerLeftX(float f2) {
        this.rectArray.set(0, (COSBase) new COSFloat(f2));
    }

    public void setLowerLeftY(float f2) {
        this.rectArray.set(1, (COSBase) new COSFloat(f2));
    }

    public void setUpperRightX(float f2) {
        this.rectArray.set(2, (COSBase) new COSFloat(f2));
    }

    public void setUpperRightY(float f2) {
        this.rectArray.set(3, (COSBase) new COSFloat(f2));
    }

    public Path toGeneralPath() {
        float lowerLeftX = getLowerLeftX();
        float lowerLeftY = getLowerLeftY();
        float upperRightX = getUpperRightX();
        float upperRightY = getUpperRightY();
        Path path = new Path();
        path.moveTo(lowerLeftX, lowerLeftY);
        path.lineTo(upperRightX, lowerLeftY);
        path.lineTo(upperRightX, upperRightY);
        path.lineTo(lowerLeftX, upperRightY);
        path.close();
        return path;
    }

    public String toString() {
        return "[" + getLowerLeftX() + "," + getLowerLeftY() + "," + getUpperRightX() + "," + getUpperRightY() + "]";
    }

    public Path transform(Matrix matrix) {
        float lowerLeftX = getLowerLeftX();
        float lowerLeftY = getLowerLeftY();
        float upperRightX = getUpperRightX();
        float upperRightY = getUpperRightY();
        PointF pointFTransformPoint = matrix.transformPoint(lowerLeftX, lowerLeftY);
        PointF pointFTransformPoint2 = matrix.transformPoint(upperRightX, lowerLeftY);
        PointF pointFTransformPoint3 = matrix.transformPoint(upperRightX, upperRightY);
        PointF pointFTransformPoint4 = matrix.transformPoint(lowerLeftX, upperRightY);
        Path path = new Path();
        path.moveTo(pointFTransformPoint.x, pointFTransformPoint.y);
        path.lineTo(pointFTransformPoint2.x, pointFTransformPoint2.y);
        path.lineTo(pointFTransformPoint3.x, pointFTransformPoint3.y);
        path.lineTo(pointFTransformPoint4.x, pointFTransformPoint4.y);
        path.close();
        return path;
    }

    public PDRectangle(float f2, float f3) {
        this(0.0f, 0.0f, f2, f3);
    }

    public PDRectangle(float f2, float f3, float f4, float f5) {
        COSArray cOSArray = new COSArray();
        this.rectArray = cOSArray;
        cOSArray.add((COSBase) new COSFloat(f2));
        cOSArray.add((COSBase) new COSFloat(f3));
        cOSArray.add((COSBase) new COSFloat(f2 + f4));
        cOSArray.add((COSBase) new COSFloat(f3 + f5));
    }

    public PDRectangle(BoundingBox boundingBox) {
        COSArray cOSArray = new COSArray();
        this.rectArray = cOSArray;
        cOSArray.add((COSBase) new COSFloat(boundingBox.getLowerLeftX()));
        cOSArray.add((COSBase) new COSFloat(boundingBox.getLowerLeftY()));
        cOSArray.add((COSBase) new COSFloat(boundingBox.getUpperRightX()));
        cOSArray.add((COSBase) new COSFloat(boundingBox.getUpperRightY()));
    }

    public PDRectangle(COSArray cOSArray) {
        float[] fArrCopyOf = Arrays.copyOf(cOSArray.toFloatArray(), 4);
        COSArray cOSArray2 = new COSArray();
        this.rectArray = cOSArray2;
        cOSArray2.add((COSBase) new COSFloat(Math.min(fArrCopyOf[0], fArrCopyOf[2])));
        cOSArray2.add((COSBase) new COSFloat(Math.min(fArrCopyOf[1], fArrCopyOf[3])));
        cOSArray2.add((COSBase) new COSFloat(Math.max(fArrCopyOf[0], fArrCopyOf[2])));
        cOSArray2.add((COSBase) new COSFloat(Math.max(fArrCopyOf[1], fArrCopyOf[3])));
    }
}
