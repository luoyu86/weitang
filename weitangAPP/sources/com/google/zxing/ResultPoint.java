package com.google.zxing;

/* JADX INFO: loaded from: classes2.dex */
public class ResultPoint {
    private final float x;
    private final float y;

    public ResultPoint(float f2, float f3) {
        this.x = f2;
        this.y = f3;
    }

    private static float crossProductZ(ResultPoint resultPoint, ResultPoint resultPoint2, ResultPoint resultPoint3) {
        float f2 = resultPoint2.x;
        float f3 = resultPoint2.y;
        return ((resultPoint3.x - f2) * (resultPoint.y - f3)) - ((resultPoint3.y - f3) * (resultPoint.x - f2));
    }

    public static float distance(ResultPoint resultPoint, ResultPoint resultPoint2) {
        float f2 = resultPoint.x - resultPoint2.x;
        float f3 = resultPoint.y - resultPoint2.y;
        return (float) Math.sqrt((f2 * f2) + (f3 * f3));
    }

    public static void orderBestPatterns(ResultPoint[] resultPointArr) {
        ResultPoint resultPoint;
        ResultPoint resultPoint2;
        ResultPoint resultPoint3;
        float fDistance = distance(resultPointArr[0], resultPointArr[1]);
        float fDistance2 = distance(resultPointArr[1], resultPointArr[2]);
        float fDistance3 = distance(resultPointArr[0], resultPointArr[2]);
        if (fDistance2 >= fDistance && fDistance2 >= fDistance3) {
            resultPoint = resultPointArr[0];
            resultPoint2 = resultPointArr[1];
            resultPoint3 = resultPointArr[2];
        } else if (fDistance3 < fDistance2 || fDistance3 < fDistance) {
            resultPoint = resultPointArr[2];
            resultPoint2 = resultPointArr[0];
            resultPoint3 = resultPointArr[1];
        } else {
            resultPoint = resultPointArr[1];
            resultPoint2 = resultPointArr[0];
            resultPoint3 = resultPointArr[2];
        }
        if (crossProductZ(resultPoint2, resultPoint, resultPoint3) < 0.0f) {
            ResultPoint resultPoint4 = resultPoint3;
            resultPoint3 = resultPoint2;
            resultPoint2 = resultPoint4;
        }
        resultPointArr[0] = resultPoint2;
        resultPointArr[1] = resultPoint;
        resultPointArr[2] = resultPoint3;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof ResultPoint)) {
            return false;
        }
        ResultPoint resultPoint = (ResultPoint) obj;
        return this.x == resultPoint.x && this.y == resultPoint.y;
    }

    public final float getX() {
        return this.x;
    }

    public final float getY() {
        return this.y;
    }

    public int hashCode() {
        return (Float.floatToIntBits(this.x) * 31) + Float.floatToIntBits(this.y);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(25);
        sb.append('(');
        sb.append(this.x);
        sb.append(',');
        sb.append(this.y);
        sb.append(')');
        return sb.toString();
    }
}
