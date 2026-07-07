package com.chinavisionary.core.weight;

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

/* JADX INFO: loaded from: classes.dex */
@TargetApi(14)
public class FlowLayout extends ViewGroup {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f6694a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<List<View>> f6695b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<Integer> f6696c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<Integer> f6697d;

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
        return this.f6694a;
    }

    /* JADX WARN: Removed duplicated region for block: B:54:0x0179  */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onLayout(boolean r20, int r21, int r22, int r23, int r24) {
        /*
            Method dump skipped, instruction units count: 450
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.chinavisionary.core.weight.FlowLayout.onLayout(boolean, int, int, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00d9 A[SYNTHETIC] */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onMeasure(int r20, int r21) {
        /*
            Method dump skipped, instruction units count: 251
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.chinavisionary.core.weight.FlowLayout.onMeasure(int, int):void");
    }

    @TargetApi(14)
    public void setGravity(int i2) {
        if (this.f6694a != i2) {
            if ((8388615 & i2) == 0) {
                i2 |= c() ? GravityCompat.START : 3;
            }
            if ((i2 & 112) == 0) {
                i2 |= 48;
            }
            this.f6694a = i2;
            requestLayout();
        }
    }

    public FlowLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FlowLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f6694a = (c() ? GravityCompat.START : 3) | 48;
        this.f6695b = new ArrayList();
        this.f6696c = new ArrayList();
        this.f6697d = new ArrayList();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.FlowLayout, i2, 0);
        try {
            int i3 = typedArrayObtainStyledAttributes.getInt(R.styleable.FlowLayout_android_gravity, -1);
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
        public int f6698a;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f6698a = -1;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.FlowLayout_Layout);
            try {
                this.f6698a = typedArrayObtainStyledAttributes.getInt(R.styleable.FlowLayout_Layout_android_layout_gravity, -1);
            } finally {
                typedArrayObtainStyledAttributes.recycle();
            }
        }

        public LayoutParams(int i2, int i3) {
            super(i2, i3);
            this.f6698a = -1;
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f6698a = -1;
        }
    }
}
