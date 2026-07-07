package com.chinavisionary.microtang.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.GravityCompat;
import com.chinavisionary.core.R;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class FlowLayout extends ViewGroup {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f8660a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f8661b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<List<View>> f8662c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<Integer> f8663d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<Integer> f8664e;

    public FlowLayout(Context context) {
        this(context, null);
    }

    public static boolean c() {
        return Build.VERSION.SDK_INT >= 14;
    }

    @Override // android.view.ViewGroup
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-1, -1);
    }

    @Override // android.view.ViewGroup
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return super.checkLayoutParams(layoutParams) && (layoutParams instanceof LayoutParams);
    }

    public int getGravity() {
        return this.f8660a;
    }

    /* JADX WARN: Removed duplicated region for block: B:54:0x017c  */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onLayout(boolean r20, int r21, int r22, int r23, int r24) {
        /*
            Method dump skipped, instruction units count: 453
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.chinavisionary.microtang.view.FlowLayout.onLayout(boolean, int, int, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00dc A[SYNTHETIC] */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onMeasure(int r20, int r21) {
        /*
            Method dump skipped, instruction units count: 254
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.chinavisionary.microtang.view.FlowLayout.onMeasure(int, int):void");
    }

    @TargetApi(14)
    public void setGravity(int i2) {
        if (this.f8660a != i2) {
            if ((8388615 & i2) == 0) {
                i2 |= c() ? GravityCompat.START : 3;
            }
            if ((i2 & 112) == 0) {
                i2 |= 48;
            }
            this.f8660a = i2;
            requestLayout();
        }
    }

    public FlowLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FlowLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f8660a = (c() ? GravityCompat.START : 3) | 48;
        this.f8661b = 0;
        this.f8662c = new ArrayList();
        this.f8663d = new ArrayList();
        this.f8664e = new ArrayList();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.FlowLayout, i2, 0);
        try {
            int i3 = typedArrayObtainStyledAttributes.getInt(0, -1);
            if (i3 > 0) {
                setGravity(i3);
            }
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    @Override // android.view.ViewGroup
    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    public static class LayoutParams extends ViewGroup.MarginLayoutParams {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f8665a;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f8665a = -1;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.FlowLayout_Layout);
            try {
                this.f8665a = typedArrayObtainStyledAttributes.getInt(0, -1);
            } finally {
                typedArrayObtainStyledAttributes.recycle();
            }
        }

        public LayoutParams(int i2, int i3) {
            super(i2, i3);
            this.f8665a = -1;
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f8665a = -1;
        }
    }
}
