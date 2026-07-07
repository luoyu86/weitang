package androidx.transition;

import android.graphics.Matrix;
import android.view.View;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes.dex */
public class ViewUtilsBase {
    private float[] mMatrixValues;

    public void clearNonTransitionAlpha(@NonNull View view) {
        if (view.getVisibility() == 0) {
            view.setTag(R.id.save_non_transition_alpha, null);
        }
    }

    public float getTransitionAlpha(@NonNull View view) {
        Float f2 = (Float) view.getTag(R.id.save_non_transition_alpha);
        return f2 != null ? view.getAlpha() / f2.floatValue() : view.getAlpha();
    }

    public void saveNonTransitionAlpha(@NonNull View view) {
        int i2 = R.id.save_non_transition_alpha;
        if (view.getTag(i2) == null) {
            view.setTag(i2, Float.valueOf(view.getAlpha()));
        }
    }

    public void setAnimationMatrix(@NonNull View view, Matrix matrix) {
        if (matrix == null || matrix.isIdentity()) {
            view.setPivotX(view.getWidth() / 2);
            view.setPivotY(view.getHeight() / 2);
            view.setTranslationX(0.0f);
            view.setTranslationY(0.0f);
            view.setScaleX(1.0f);
            view.setScaleY(1.0f);
            view.setRotation(0.0f);
            return;
        }
        float[] fArr = this.mMatrixValues;
        if (fArr == null) {
            fArr = new float[9];
            this.mMatrixValues = fArr;
        }
        matrix.getValues(fArr);
        float f2 = fArr[3];
        float fSqrt = ((float) Math.sqrt(1.0f - (f2 * f2))) * (fArr[0] < 0.0f ? -1 : 1);
        float degrees = (float) Math.toDegrees(Math.atan2(f2, fSqrt));
        float f3 = fArr[0] / fSqrt;
        float f4 = fArr[4] / fSqrt;
        float f5 = fArr[2];
        float f6 = fArr[5];
        view.setPivotX(0.0f);
        view.setPivotY(0.0f);
        view.setTranslationX(f5);
        view.setTranslationY(f6);
        view.setRotation(degrees);
        view.setScaleX(f3);
        view.setScaleY(f4);
    }

    public void setLeftTopRightBottom(View view, int i2, int i3, int i4, int i5) {
        view.setLeft(i2);
        view.setTop(i3);
        view.setRight(i4);
        view.setBottom(i5);
    }

    public void setTransitionAlpha(@NonNull View view, float f2) {
        Float f3 = (Float) view.getTag(R.id.save_non_transition_alpha);
        if (f3 != null) {
            view.setAlpha(f3.floatValue() * f2);
        } else {
            view.setAlpha(f2);
        }
    }

    public void transformMatrixToGlobal(@NonNull View view, @NonNull Matrix matrix) {
        Object parent = view.getParent();
        if (parent instanceof View) {
            transformMatrixToGlobal((View) parent, matrix);
            matrix.preTranslate(-r0.getScrollX(), -r0.getScrollY());
        }
        matrix.preTranslate(view.getLeft(), view.getTop());
        Matrix matrix2 = view.getMatrix();
        if (matrix2.isIdentity()) {
            return;
        }
        matrix.preConcat(matrix2);
    }

    public void transformMatrixToLocal(@NonNull View view, @NonNull Matrix matrix) {
        Object parent = view.getParent();
        if (parent instanceof View) {
            transformMatrixToLocal((View) parent, matrix);
            matrix.postTranslate(r0.getScrollX(), r0.getScrollY());
        }
        matrix.postTranslate(view.getLeft(), view.getTop());
        Matrix matrix2 = view.getMatrix();
        if (matrix2.isIdentity()) {
            return;
        }
        Matrix matrix3 = new Matrix();
        if (matrix2.invert(matrix3)) {
            matrix.postConcat(matrix3);
        }
    }
}
