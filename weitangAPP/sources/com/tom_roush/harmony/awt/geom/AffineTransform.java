package com.tom_roush.harmony.awt.geom;

import android.graphics.Matrix;
import android.graphics.PointF;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public class AffineTransform implements Cloneable, Serializable {
    public static final int TYPE_FLIP = 64;
    public static final int TYPE_GENERAL_ROTATION = 16;
    public static final int TYPE_GENERAL_SCALE = 4;
    public static final int TYPE_GENERAL_TRANSFORM = 32;
    public static final int TYPE_IDENTITY = 0;
    public static final int TYPE_MASK_ROTATION = 24;
    public static final int TYPE_MASK_SCALE = 6;
    public static final int TYPE_QUADRANT_ROTATION = 8;
    public static final int TYPE_TRANSLATION = 1;
    public static final int TYPE_UNIFORM_SCALE = 2;
    public static final int TYPE_UNKNOWN = -1;
    public static final double ZERO = 1.0E-10d;
    private static final long serialVersionUID = 1330973210523860834L;
    public double m00;
    public double m01;
    public double m02;
    public double m10;
    public double m11;
    public double m12;
    public transient int type;

    public class NoninvertibleTransformException extends Exception {
        private static final long serialVersionUID = 6137225240503990466L;

        public NoninvertibleTransformException(String str) {
            super(str);
        }
    }

    public AffineTransform() {
        this.type = 0;
        this.m11 = 1.0d;
        this.m00 = 1.0d;
        this.m12 = 0.0d;
        this.m02 = 0.0d;
        this.m01 = 0.0d;
        this.m10 = 0.0d;
    }

    public static AffineTransform getRotateInstance(double d2) {
        AffineTransform affineTransform = new AffineTransform();
        affineTransform.setToRotation(d2);
        return affineTransform;
    }

    public static AffineTransform getScaleInstance(double d2, double d3) {
        AffineTransform affineTransform = new AffineTransform();
        affineTransform.setToScale(d2, d3);
        return affineTransform;
    }

    public static AffineTransform getShearInstance(double d2, double d3) {
        AffineTransform affineTransform = new AffineTransform();
        affineTransform.setToShear(d2, d3);
        return affineTransform;
    }

    public static AffineTransform getTranslateInstance(double d2, double d3) {
        AffineTransform affineTransform = new AffineTransform();
        affineTransform.setToTranslation(d2, d3);
        return affineTransform;
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        this.type = -1;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException unused) {
            throw new InternalError();
        }
    }

    public void concatenate(AffineTransform affineTransform) {
        setTransform(multiply(affineTransform, this));
    }

    public AffineTransform createInverse() throws NoninvertibleTransformException {
        double determinant = getDeterminant();
        if (Math.abs(determinant) < 1.0E-10d) {
            throw new NoninvertibleTransformException("Determinant is zero");
        }
        double d2 = this.m11;
        double d3 = this.m10;
        double d4 = (-d3) / determinant;
        double d5 = this.m01;
        double d6 = (-d5) / determinant;
        double d7 = this.m00;
        double d8 = this.m12;
        double d9 = d5 * d8;
        double d10 = this.m02;
        return new AffineTransform(d2 / determinant, d4, d6, d7 / determinant, (d9 - (d2 * d10)) / determinant, ((d3 * d10) - (d7 * d8)) / determinant);
    }

    public PointF deltaTransform(PointF pointF, PointF pointF2) {
        if (pointF2 == null) {
            pointF2 = new PointF();
        }
        float f2 = pointF.x;
        double d2 = ((double) f2) * this.m00;
        float f3 = pointF.y;
        pointF2.set((float) (d2 + (((double) f3) * this.m01)), (float) ((((double) f2) * this.m10) + (((double) f3) * this.m11)));
        return pointF2;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AffineTransform)) {
            return false;
        }
        AffineTransform affineTransform = (AffineTransform) obj;
        return this.m00 == affineTransform.m00 && this.m01 == affineTransform.m01 && this.m02 == affineTransform.m02 && this.m10 == affineTransform.m10 && this.m11 == affineTransform.m11 && this.m12 == affineTransform.m12;
    }

    public double getDeterminant() {
        return (this.m00 * this.m11) - (this.m01 * this.m10);
    }

    public void getMatrix(double[] dArr) {
        dArr[0] = this.m00;
        dArr[1] = this.m10;
        dArr[2] = this.m01;
        dArr[3] = this.m11;
        if (dArr.length > 4) {
            dArr[4] = this.m02;
            dArr[5] = this.m12;
        }
    }

    public double getScaleX() {
        return this.m00;
    }

    public double getScaleY() {
        return this.m11;
    }

    public double getShearX() {
        return this.m01;
    }

    public double getShearY() {
        return this.m10;
    }

    public double getTranslateX() {
        return this.m02;
    }

    public double getTranslateY() {
        return this.m12;
    }

    public int getType() {
        int i2 = this.type;
        if (i2 != -1) {
            return i2;
        }
        double d2 = this.m00;
        double d3 = this.m01;
        double d4 = this.m10;
        double d5 = this.m11;
        if ((d2 * d3) + (d4 * d5) != 0.0d) {
            return 32;
        }
        int i3 = 0;
        if (this.m02 != 0.0d || this.m12 != 0.0d) {
            i3 = 1;
        } else if (d2 == 1.0d && d5 == 1.0d && d3 == 0.0d && d4 == 0.0d) {
            return 0;
        }
        if ((d2 * d5) - (d3 * d4) < 0.0d) {
            i3 |= 64;
        }
        double d6 = (d2 * d2) + (d4 * d4);
        if (d6 != (d3 * d3) + (d5 * d5)) {
            i3 |= 4;
        } else if (d6 != 1.0d) {
            i3 |= 2;
        }
        return ((d2 == 0.0d && d5 == 0.0d) || (d4 == 0.0d && d3 == 0.0d && (d2 < 0.0d || d5 < 0.0d))) ? i3 | 8 : (d3 == 0.0d && d4 == 0.0d) ? i3 : i3 | 16;
    }

    public PointF inverseTransform(PointF pointF, PointF pointF2) throws NoninvertibleTransformException {
        double determinant = getDeterminant();
        if (Math.abs(determinant) < 1.0E-10d) {
            throw new NoninvertibleTransformException("Determinant is zero");
        }
        if (pointF2 == null) {
            pointF2 = new PointF();
        }
        double d2 = (float) (((double) pointF.x) - this.m02);
        double d3 = (float) (((double) pointF.y) - this.m12);
        pointF2.set((float) (((this.m11 * d2) - (this.m01 * d3)) / determinant), (float) (((d3 * this.m00) - (d2 * this.m10)) / determinant));
        return pointF2;
    }

    public boolean isIdentity() {
        return getType() == 0;
    }

    public AffineTransform multiply(AffineTransform affineTransform, AffineTransform affineTransform2) {
        double d2 = affineTransform.m00;
        double d3 = affineTransform2.m00;
        double d4 = affineTransform.m10;
        double d5 = affineTransform2.m01;
        double d6 = (d2 * d3) + (d4 * d5);
        double d7 = affineTransform2.m10;
        double d8 = affineTransform2.m11;
        double d9 = (d4 * d8) + (d2 * d7);
        double d10 = affineTransform.m01;
        double d11 = affineTransform.m11;
        double d12 = (d10 * d3) + (d11 * d5);
        double d13 = (d11 * d8) + (d10 * d7);
        double d14 = affineTransform.m02;
        double d15 = affineTransform.m12;
        return new AffineTransform(d6, d9, d12, d13, affineTransform2.m02 + (d3 * d14) + (d5 * d15), (d14 * d7) + (d15 * d8) + affineTransform2.m12);
    }

    public void preConcatenate(AffineTransform affineTransform) {
        setTransform(multiply(this, affineTransform));
    }

    public void rotate(double d2) {
        concatenate(getRotateInstance(d2));
    }

    public void scale(double d2, double d3) {
        concatenate(getScaleInstance(d2, d3));
    }

    public void setToIdentity() {
        this.type = 0;
        this.m11 = 1.0d;
        this.m00 = 1.0d;
        this.m12 = 0.0d;
        this.m02 = 0.0d;
        this.m01 = 0.0d;
        this.m10 = 0.0d;
    }

    public void setToRotation(double d2) {
        double dSin = Math.sin(d2);
        double dCos = Math.cos(d2);
        if (Math.abs(dCos) < 1.0E-10d) {
            dSin = dSin > 0.0d ? 1.0d : -1.0d;
            dCos = 0.0d;
        } else if (Math.abs(dSin) < 1.0E-10d) {
            dCos = dCos > 0.0d ? 1.0d : -1.0d;
            dSin = 0.0d;
        }
        this.m11 = dCos;
        this.m00 = dCos;
        this.m01 = -dSin;
        this.m10 = dSin;
        this.m12 = 0.0d;
        this.m02 = 0.0d;
        this.type = -1;
    }

    public void setToScale(double d2, double d3) {
        this.m00 = d2;
        this.m11 = d3;
        this.m12 = 0.0d;
        this.m02 = 0.0d;
        this.m01 = 0.0d;
        this.m10 = 0.0d;
        if (d2 == 1.0d && d3 == 1.0d) {
            this.type = 0;
        } else {
            this.type = -1;
        }
    }

    public void setToShear(double d2, double d3) {
        this.m11 = 1.0d;
        this.m00 = 1.0d;
        this.m12 = 0.0d;
        this.m02 = 0.0d;
        this.m01 = d2;
        this.m10 = d3;
        if (d2 == 0.0d && d3 == 0.0d) {
            this.type = 0;
        } else {
            this.type = -1;
        }
    }

    public void setToTranslation(double d2, double d3) {
        this.m11 = 1.0d;
        this.m00 = 1.0d;
        this.m10 = 0.0d;
        this.m01 = 0.0d;
        this.m02 = d2;
        this.m12 = d3;
        if (d2 == 0.0d && d3 == 0.0d) {
            this.type = 0;
        } else {
            this.type = 1;
        }
    }

    public void setTransform(double d2, double d3, double d4, double d5, double d6, double d7) {
        this.type = -1;
        this.m00 = d2;
        this.m10 = d3;
        this.m01 = d4;
        this.m11 = d5;
        this.m02 = d6;
        this.m12 = d7;
    }

    public void shear(double d2, double d3) {
        concatenate(getShearInstance(d2, d3));
    }

    public Matrix toMatrix() {
        Matrix matrix = new Matrix();
        matrix.setValues(new float[]{(float) this.m00, (float) this.m01, (float) this.m02, (float) this.m10, (float) this.m11, (float) this.m12, 0.0f, 0.0f, 1.0f});
        return matrix;
    }

    public String toString() {
        return getClass().getName() + "[[" + this.m00 + ", " + this.m01 + ", " + this.m02 + "], [" + this.m10 + ", " + this.m11 + ", " + this.m12 + "]]";
    }

    public PointF transform(PointF pointF, PointF pointF2) {
        float f2 = pointF.x;
        double d2 = ((double) f2) * this.m00;
        float f3 = pointF.y;
        pointF2.set((float) (d2 + (((double) f3) * this.m01) + this.m02), (float) ((((double) f2) * this.m10) + (((double) f3) * this.m11) + this.m12));
        return pointF2;
    }

    public void translate(double d2, double d3) {
        concatenate(getTranslateInstance(d2, d3));
    }

    public void rotate(double d2, double d3, double d4) {
        concatenate(getRotateInstance(d2, d3, d4));
    }

    public void transform(PointF[] pointFArr, int i2, PointF[] pointFArr2, int i3, int i4) {
        while (true) {
            i4--;
            if (i4 < 0) {
                return;
            }
            int i5 = i2 + 1;
            PointF pointF = pointFArr[i2];
            PointF pointF2 = pointFArr2[i3];
            if (pointF2 == null) {
                pointF2 = new PointF();
            }
            float f2 = pointF.x;
            double d2 = ((double) f2) * this.m00;
            float f3 = pointF.y;
            pointF2.set((float) (d2 + (((double) f3) * this.m01) + this.m02), (float) ((((double) f2) * this.m10) + (((double) f3) * this.m11) + this.m12));
            pointFArr2[i3] = pointF2;
            i3++;
            i2 = i5;
        }
    }

    public static AffineTransform getRotateInstance(double d2, double d3, double d4) {
        AffineTransform affineTransform = new AffineTransform();
        affineTransform.setToRotation(d2, d3, d4);
        return affineTransform;
    }

    public void deltaTransform(double[] dArr, int i2, double[] dArr2, int i3, int i4) {
        while (true) {
            i4--;
            if (i4 < 0) {
                return;
            }
            int i5 = i2 + 1;
            double d2 = dArr[i2];
            i2 = i5 + 1;
            double d3 = dArr[i5];
            int i6 = i3 + 1;
            dArr2[i3] = (this.m00 * d2) + (this.m01 * d3);
            i3 = i6 + 1;
            dArr2[i6] = (d2 * this.m10) + (d3 * this.m11);
        }
    }

    public AffineTransform(AffineTransform affineTransform) {
        this.type = affineTransform.type;
        this.m00 = affineTransform.m00;
        this.m10 = affineTransform.m10;
        this.m01 = affineTransform.m01;
        this.m11 = affineTransform.m11;
        this.m02 = affineTransform.m02;
        this.m12 = affineTransform.m12;
    }

    public void transform(double[] dArr, int i2, double[] dArr2, int i3, int i4) {
        int i5;
        int i6;
        int i7 = 2;
        if (dArr == dArr2 && i2 < i3 && i3 < (i6 = i2 + (i5 = i4 * 2))) {
            i2 = i6 - 2;
            i3 = (i3 + i5) - 2;
            i7 = -2;
        }
        while (true) {
            i4--;
            if (i4 < 0) {
                return;
            }
            double d2 = dArr[i2 + 0];
            double d3 = dArr[i2 + 1];
            dArr2[i3 + 0] = (this.m00 * d2) + (this.m01 * d3) + this.m02;
            dArr2[i3 + 1] = (d2 * this.m10) + (d3 * this.m11) + this.m12;
            i2 += i7;
            i3 += i7;
        }
    }

    public void inverseTransform(double[] dArr, int i2, double[] dArr2, int i3, int i4) throws NoninvertibleTransformException {
        double determinant = getDeterminant();
        if (Math.abs(determinant) < 1.0E-10d) {
            throw new NoninvertibleTransformException("Determinant is zero");
        }
        int i5 = i2;
        int i6 = i3;
        int i7 = i4;
        while (true) {
            i7--;
            if (i7 < 0) {
                return;
            }
            int i8 = i5 + 1;
            double d2 = dArr[i5] - this.m02;
            i5 = i8 + 1;
            double d3 = dArr[i8] - this.m12;
            int i9 = i6 + 1;
            dArr2[i6] = ((this.m11 * d2) - (this.m01 * d3)) / determinant;
            i6 = i9 + 1;
            dArr2[i9] = ((d3 * this.m00) - (d2 * this.m10)) / determinant;
        }
    }

    public void setTransform(AffineTransform affineTransform) {
        this.type = affineTransform.type;
        setTransform(affineTransform.m00, affineTransform.m10, affineTransform.m01, affineTransform.m11, affineTransform.m02, affineTransform.m12);
    }

    public void setToRotation(double d2, double d3, double d4) {
        setToRotation(d2);
        double d5 = this.m00;
        double d6 = this.m10;
        this.m02 = ((1.0d - d5) * d3) + (d4 * d6);
        this.m12 = (d4 * (1.0d - d5)) - (d3 * d6);
        this.type = -1;
    }

    public void transform(float[] fArr, int i2, float[] fArr2, int i3, int i4) {
        int i5;
        int i6;
        int i7 = 2;
        if (fArr == fArr2 && i2 < i3 && i3 < (i6 = i2 + (i5 = i4 * 2))) {
            i2 = i6 - 2;
            i3 = (i3 + i5) - 2;
            i7 = -2;
        }
        while (true) {
            i4--;
            if (i4 < 0) {
                return;
            }
            double d2 = fArr[i2 + 0];
            double d3 = fArr[i2 + 1];
            fArr2[i3 + 0] = (float) ((this.m00 * d2) + (this.m01 * d3) + this.m02);
            fArr2[i3 + 1] = (float) ((d2 * this.m10) + (d3 * this.m11) + this.m12);
            i2 += i7;
            i3 += i7;
        }
    }

    public AffineTransform(float f2, float f3, float f4, float f5, float f6, float f7) {
        this.type = -1;
        this.m00 = f2;
        this.m10 = f3;
        this.m01 = f4;
        this.m11 = f5;
        this.m02 = f6;
        this.m12 = f7;
    }

    public void transform(float[] fArr, int i2, double[] dArr, int i3, int i4) {
        int i5 = i2;
        int i6 = i3;
        int i7 = i4;
        while (true) {
            i7--;
            if (i7 < 0) {
                return;
            }
            int i8 = i5 + 1;
            int i9 = i6 + 1;
            double d2 = fArr[i5];
            double d3 = fArr[i8];
            dArr[i6] = (this.m00 * d2) + (this.m01 * d3) + this.m02;
            i6 = i9 + 1;
            dArr[i9] = (d2 * this.m10) + (d3 * this.m11) + this.m12;
            i5 = i8 + 1;
        }
    }

    public void transform(double[] dArr, int i2, float[] fArr, int i3, int i4) {
        while (true) {
            i4--;
            if (i4 < 0) {
                return;
            }
            int i5 = i2 + 1;
            double d2 = dArr[i2];
            i2 = i5 + 1;
            double d3 = dArr[i5];
            int i6 = i3 + 1;
            fArr[i3] = (float) ((this.m00 * d2) + (this.m01 * d3) + this.m02);
            i3 = i6 + 1;
            fArr[i6] = (float) ((d2 * this.m10) + (d3 * this.m11) + this.m12);
        }
    }

    public AffineTransform(double d2, double d3, double d4, double d5, double d6, double d7) {
        this.type = -1;
        this.m00 = d2;
        this.m10 = d3;
        this.m01 = d4;
        this.m11 = d5;
        this.m02 = d6;
        this.m12 = d7;
    }

    public AffineTransform(float[] fArr) {
        this.type = -1;
        this.m00 = fArr[0];
        this.m10 = fArr[1];
        this.m01 = fArr[2];
        this.m11 = fArr[3];
        if (fArr.length > 4) {
            this.m02 = fArr[4];
            this.m12 = fArr[5];
        }
    }

    public AffineTransform(double[] dArr) {
        this.type = -1;
        this.m00 = dArr[0];
        this.m10 = dArr[1];
        this.m01 = dArr[2];
        this.m11 = dArr[3];
        if (dArr.length > 4) {
            this.m02 = dArr[4];
            this.m12 = dArr[5];
        }
    }

    public AffineTransform(Matrix matrix) {
        matrix.getValues(new float[9]);
        this.m00 = r0[0];
        this.m01 = r0[1];
        this.m02 = r0[2];
        this.m10 = r0[3];
        this.m11 = r0[4];
        this.m12 = r0[5];
    }
}
