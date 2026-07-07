package com.tom_roush.pdfbox.util;

import android.graphics.PointF;
import com.tom_roush.harmony.awt.geom.AffineTransform;
import com.tom_roush.pdfbox.cos.COSArray;
import com.tom_roush.pdfbox.cos.COSBase;
import com.tom_roush.pdfbox.cos.COSFloat;
import com.tom_roush.pdfbox.cos.COSNumber;
import java.lang.reflect.Array;
import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
public final class Matrix implements Cloneable {
    private static final float MAX_FLOAT_VALUE = Float.MAX_VALUE;
    public static final int SIZE = 9;
    private float[] single;

    public Matrix() {
        this.single = new float[]{1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f};
    }

    public static Matrix createMatrix(COSBase cOSBase) {
        if (!(cOSBase instanceof COSArray)) {
            return new Matrix();
        }
        COSArray cOSArray = (COSArray) cOSBase;
        if (cOSArray.size() < 6) {
            return new Matrix();
        }
        for (int i2 = 0; i2 < 6; i2++) {
            if (!(cOSArray.getObject(i2) instanceof COSNumber)) {
                return new Matrix();
            }
        }
        return new Matrix(cOSArray);
    }

    public static Matrix getRotateInstance(double d2, float f2, float f3) {
        float fCos = (float) Math.cos(d2);
        float fSin = (float) Math.sin(d2);
        return new Matrix(fCos, fSin, -fSin, fCos, f2, f3);
    }

    public static Matrix getScaleInstance(float f2, float f3) {
        return new Matrix(f2, 0.0f, 0.0f, f3, 0.0f, 0.0f);
    }

    public static Matrix getTranslateInstance(float f2, float f3) {
        return new Matrix(1.0f, 0.0f, 0.0f, 1.0f, f2, f3);
    }

    @Deprecated
    public static Matrix getTranslatingInstance(float f2, float f3) {
        return new Matrix(1.0f, 0.0f, 0.0f, 1.0f, f2, f3);
    }

    private static boolean isFinite(float f2) {
        return Math.abs(f2) <= Float.MAX_VALUE;
    }

    private void multiplyArrays(float[] fArr, float[] fArr2, float[] fArr3) {
        fArr3[0] = (fArr[0] * fArr2[0]) + (fArr[1] * fArr2[3]) + (fArr[2] * fArr2[6]);
        fArr3[1] = (fArr[0] * fArr2[1]) + (fArr[1] * fArr2[4]) + (fArr[2] * fArr2[7]);
        fArr3[2] = (fArr[0] * fArr2[2]) + (fArr[1] * fArr2[5]) + (fArr[2] * fArr2[8]);
        fArr3[3] = (fArr[3] * fArr2[0]) + (fArr[4] * fArr2[3]) + (fArr[5] * fArr2[6]);
        fArr3[4] = (fArr[3] * fArr2[1]) + (fArr[4] * fArr2[4]) + (fArr[5] * fArr2[7]);
        fArr3[5] = (fArr[3] * fArr2[2]) + (fArr[4] * fArr2[5]) + (fArr[5] * fArr2[8]);
        fArr3[6] = (fArr[6] * fArr2[0]) + (fArr[7] * fArr2[3]) + (fArr[8] * fArr2[6]);
        fArr3[7] = (fArr[6] * fArr2[1]) + (fArr[7] * fArr2[4]) + (fArr[8] * fArr2[7]);
        fArr3[8] = (fArr[6] * fArr2[2]) + (fArr[7] * fArr2[5]) + (fArr[8] * fArr2[8]);
    }

    public void concatenate(Matrix matrix) {
        matrix.multiply(this, this);
    }

    public AffineTransform createAffineTransform() {
        float[] fArr = this.single;
        return new AffineTransform(fArr[0], fArr[1], fArr[3], fArr[4], fArr[6], fArr[7]);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && Matrix.class == obj.getClass()) {
            return Arrays.equals(this.single, ((Matrix) obj).single);
        }
        return false;
    }

    @Deprecated
    public Matrix extractScaling() {
        Matrix matrix = new Matrix();
        float[] fArr = matrix.single;
        float[] fArr2 = this.single;
        fArr[0] = fArr2[0];
        fArr[4] = fArr2[4];
        return matrix;
    }

    @Deprecated
    public Matrix extractTranslating() {
        Matrix matrix = new Matrix();
        float[] fArr = matrix.single;
        float[] fArr2 = this.single;
        fArr[6] = fArr2[6];
        fArr[7] = fArr2[7];
        return matrix;
    }

    public float getScaleX() {
        return this.single[0];
    }

    public float getScaleY() {
        return this.single[4];
    }

    public float getScalingFactorX() {
        float[] fArr = this.single;
        return fArr[1] != 0.0f ? (float) Math.sqrt(Math.pow(fArr[0], 2.0d) + Math.pow(this.single[1], 2.0d)) : fArr[0];
    }

    public float getScalingFactorY() {
        float[] fArr = this.single;
        return fArr[3] != 0.0f ? (float) Math.sqrt(Math.pow(fArr[3], 2.0d) + Math.pow(this.single[4], 2.0d)) : fArr[4];
    }

    public float getShearX() {
        return this.single[3];
    }

    public float getShearY() {
        return this.single[1];
    }

    public float getTranslateX() {
        return this.single[6];
    }

    public float getTranslateY() {
        return this.single[7];
    }

    public float getValue(int i2, int i3) {
        return this.single[(i2 * 3) + i3];
    }

    public float[][] getValues() {
        float[][] fArr = (float[][]) Array.newInstance((Class<?>) float.class, 3, 3);
        float[] fArr2 = fArr[0];
        float[] fArr3 = this.single;
        fArr2[0] = fArr3[0];
        fArr[0][1] = fArr3[1];
        fArr[0][2] = fArr3[2];
        fArr[1][0] = fArr3[3];
        fArr[1][1] = fArr3[4];
        fArr[1][2] = fArr3[5];
        fArr[2][0] = fArr3[6];
        fArr[2][1] = fArr3[7];
        fArr[2][2] = fArr3[8];
        return fArr;
    }

    @Deprecated
    public double[][] getValuesAsDouble() {
        double[][] dArr = (double[][]) Array.newInstance((Class<?>) double.class, 3, 3);
        double[] dArr2 = dArr[0];
        float[] fArr = this.single;
        dArr2[0] = fArr[0];
        dArr[0][1] = fArr[1];
        dArr[0][2] = fArr[2];
        dArr[1][0] = fArr[3];
        dArr[1][1] = fArr[4];
        dArr[1][2] = fArr[5];
        dArr[2][0] = fArr[6];
        dArr[2][1] = fArr[7];
        dArr[2][2] = fArr[8];
        return dArr;
    }

    @Deprecated
    public float getXPosition() {
        return this.single[6];
    }

    @Deprecated
    public float getYPosition() {
        return this.single[7];
    }

    public int hashCode() {
        return Arrays.hashCode(this.single);
    }

    public Matrix multiply(Matrix matrix) {
        return multiply(matrix, new Matrix());
    }

    @Deprecated
    public void reset() {
        Arrays.fill(this.single, 0.0f);
        float[] fArr = this.single;
        fArr[0] = 1.0f;
        fArr[4] = 1.0f;
        fArr[8] = 1.0f;
    }

    public void rotate(double d2) {
        concatenate(getRotateInstance(d2, 0.0f, 0.0f));
    }

    public void scale(float f2, float f3) {
        concatenate(getScaleInstance(f2, f3));
    }

    @Deprecated
    public void setFromAffineTransform(AffineTransform affineTransform) {
        this.single[0] = (float) affineTransform.getScaleX();
        this.single[1] = (float) affineTransform.getShearY();
        this.single[3] = (float) affineTransform.getShearX();
        this.single[4] = (float) affineTransform.getScaleY();
        this.single[6] = (float) affineTransform.getTranslateX();
        this.single[7] = (float) affineTransform.getTranslateY();
    }

    public void setValue(int i2, int i3, float f2) {
        this.single[(i2 * 3) + i3] = f2;
    }

    public COSArray toCOSArray() {
        COSArray cOSArray = new COSArray();
        cOSArray.add((COSBase) new COSFloat(this.single[0]));
        cOSArray.add((COSBase) new COSFloat(this.single[1]));
        cOSArray.add((COSBase) new COSFloat(this.single[3]));
        cOSArray.add((COSBase) new COSFloat(this.single[4]));
        cOSArray.add((COSBase) new COSFloat(this.single[6]));
        cOSArray.add((COSBase) new COSFloat(this.single[7]));
        return cOSArray;
    }

    public String toString() {
        return "[" + this.single[0] + "," + this.single[1] + "," + this.single[3] + "," + this.single[4] + "," + this.single[6] + "," + this.single[7] + "]";
    }

    public void transform(PointF pointF) {
        float f2 = pointF.x;
        float f3 = pointF.y;
        float[] fArr = this.single;
        float f4 = fArr[0];
        float f5 = fArr[1];
        float f6 = fArr[3];
        float f7 = fArr[4];
        pointF.set((f4 * f2) + (f6 * f3) + fArr[6], (f2 * f5) + (f3 * f7) + fArr[7]);
    }

    public PointF transformPoint(float f2, float f3) {
        float[] fArr = this.single;
        float f4 = fArr[0];
        float f5 = fArr[1];
        float f6 = fArr[3];
        float f7 = fArr[4];
        return new PointF((f4 * f2) + (f6 * f3) + fArr[6], (f2 * f5) + (f3 * f7) + fArr[7]);
    }

    public void translate(Vector vector) {
        concatenate(getTranslateInstance(vector.getX(), vector.getY()));
    }

    public static Matrix concatenate(Matrix matrix, Matrix matrix2) {
        return matrix2.multiply(matrix);
    }

    /* JADX INFO: renamed from: clone, reason: merged with bridge method [inline-methods] */
    public Matrix m87clone() {
        return new Matrix((float[]) this.single.clone());
    }

    @Deprecated
    public Matrix multiply(Matrix matrix, Matrix matrix2) {
        float[] fArr = (matrix2 == null || matrix2 == matrix || matrix2 == this) ? new float[9] : matrix2.single;
        multiplyArrays(this.single, matrix.single, fArr);
        if (!isFinite(fArr[0]) || !isFinite(fArr[1]) || !isFinite(fArr[2]) || !isFinite(fArr[3]) || !isFinite(fArr[4]) || !isFinite(fArr[5]) || !isFinite(fArr[6]) || !isFinite(fArr[7]) || !isFinite(fArr[8])) {
            throw new IllegalArgumentException("Multiplying two matrices produces illegal values");
        }
        if (matrix2 == null) {
            return new Matrix(fArr);
        }
        matrix2.single = fArr;
        return matrix2;
    }

    public void translate(float f2, float f3) {
        concatenate(getTranslateInstance(f2, f3));
    }

    private Matrix(float[] fArr) {
        this.single = fArr;
    }

    public Matrix(COSArray cOSArray) {
        float[] fArr = new float[9];
        this.single = fArr;
        fArr[0] = ((COSNumber) cOSArray.getObject(0)).floatValue();
        this.single[1] = ((COSNumber) cOSArray.getObject(1)).floatValue();
        this.single[3] = ((COSNumber) cOSArray.getObject(2)).floatValue();
        this.single[4] = ((COSNumber) cOSArray.getObject(3)).floatValue();
        this.single[6] = ((COSNumber) cOSArray.getObject(4)).floatValue();
        this.single[7] = ((COSNumber) cOSArray.getObject(5)).floatValue();
        this.single[8] = 1.0f;
    }

    public Vector transform(Vector vector) {
        float[] fArr = this.single;
        float f2 = fArr[0];
        float f3 = fArr[1];
        float f4 = fArr[3];
        float f5 = fArr[4];
        float f6 = fArr[6];
        float f7 = fArr[7];
        float x = vector.getX();
        float y = vector.getY();
        return new Vector((f2 * x) + (f4 * y) + f6, (x * f3) + (y * f5) + f7);
    }

    public Matrix(float f2, float f3, float f4, float f5, float f6, float f7) {
        this.single = new float[]{f2, f3, 0.0f, f4, f5, 0.0f, f6, f7, 1.0f};
    }

    public Matrix(AffineTransform affineTransform) {
        float[] fArr = new float[9];
        this.single = fArr;
        fArr[0] = (float) affineTransform.getScaleX();
        this.single[1] = (float) affineTransform.getShearY();
        this.single[3] = (float) affineTransform.getShearX();
        this.single[4] = (float) affineTransform.getScaleY();
        this.single[6] = (float) affineTransform.getTranslateX();
        this.single[7] = (float) affineTransform.getTranslateY();
        this.single[8] = 1.0f;
    }
}
