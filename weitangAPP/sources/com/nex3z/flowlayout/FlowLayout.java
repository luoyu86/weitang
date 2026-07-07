package com.nex3z.flowlayout;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ViewGroup;
import androidx.appcompat.widget.ActivityChooserView;
import androidx.core.internal.view.SupportMenu;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class FlowLayout extends ViewGroup {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f9504a = FlowLayout.class.getSimpleName();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f9505b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f9506c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f9507d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f9508e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f9509f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f9510g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f9511h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f9512i;
    public int j;
    public int k;
    public int l;
    public List<Float> m;
    public List<Integer> n;
    public List<Integer> o;
    public List<Integer> p;

    public FlowLayout(Context context) {
        this(context, null);
    }

    public final float a(float f2) {
        return TypedValue.applyDimension(1, f2, getResources().getDisplayMetrics());
    }

    public final int b(int i2, int i3, int i4, int i5) {
        if (this.f9506c == -65536 || i5 >= this.o.size() || i5 >= this.p.size() || this.p.get(i5).intValue() <= 0) {
            return 0;
        }
        if (i2 == 1) {
            return ((i3 - i4) - this.o.get(i5).intValue()) / 2;
        }
        if (i2 != 5) {
            return 0;
        }
        return (i3 - i4) - this.o.get(i5).intValue();
    }

    public final float c(int i2, int i3, int i4, int i5) {
        if (i2 != -65536) {
            return i2;
        }
        if (i5 > 1) {
            return (i3 - i4) / (i5 - 1);
        }
        return 0.0f;
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new ViewGroup.MarginLayoutParams(layoutParams);
    }

    public int getChildSpacing() {
        return this.f9506c;
    }

    public int getChildSpacingForLastRow() {
        return this.f9508e;
    }

    public int getMaxRows() {
        return this.f9512i;
    }

    public int getMinChildSpacing() {
        return this.f9507d;
    }

    public float getRowSpacing() {
        return this.f9509f;
    }

    public int getRowsCount() {
        return this.p.size();
    }

    public boolean isFlow() {
        return this.f9505b;
    }

    public boolean isRtl() {
        return this.f9511h;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0056  */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onLayout(boolean r23, int r24, int r25, int r26, int r27) {
        /*
            Method dump skipped, instruction units count: 360
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nex3z.flowlayout.FlowLayout.onLayout(boolean, int, int, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:71:0x0266 A[PHI: r2
  0x0266: PHI (r2v5 int) = (r2v4 int), (r2v8 int) binds: [B:66:0x0253, B:68:0x025c] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onMeasure(int r27, int r28) {
        /*
            Method dump skipped, instruction units count: 638
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nex3z.flowlayout.FlowLayout.onMeasure(int, int):void");
    }

    public void setChildSpacing(int i2) {
        this.f9506c = i2;
        requestLayout();
    }

    public void setChildSpacingForLastRow(int i2) {
        this.f9508e = i2;
        requestLayout();
    }

    public void setFlow(boolean z) {
        this.f9505b = z;
        requestLayout();
    }

    public void setGravity(int i2) {
        if (this.j != i2) {
            this.j = i2;
            requestLayout();
        }
    }

    public void setMaxRows(int i2) {
        this.f9512i = i2;
        requestLayout();
    }

    public void setMinChildSpacing(int i2) {
        this.f9507d = i2;
        requestLayout();
    }

    public void setRowSpacing(float f2) {
        this.f9509f = f2;
        requestLayout();
    }

    public void setRowVerticalGravity(int i2) {
        if (this.k != i2) {
            this.k = i2;
            requestLayout();
        }
    }

    public void setRtl(boolean z) {
        this.f9511h = z;
        requestLayout();
    }

    public FlowLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f9505b = true;
        this.f9506c = 0;
        this.f9507d = 0;
        this.f9508e = -65538;
        this.f9509f = 0.0f;
        this.f9510g = 0.0f;
        this.f9511h = false;
        this.f9512i = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        this.j = -1;
        this.k = SupportMenu.CATEGORY_MASK;
        this.m = new ArrayList();
        this.n = new ArrayList();
        this.o = new ArrayList();
        this.p = new ArrayList();
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.FlowLayout, 0, 0);
        try {
            this.f9505b = typedArrayObtainStyledAttributes.getBoolean(R.styleable.FlowLayout_flFlow, true);
            try {
                this.f9506c = typedArrayObtainStyledAttributes.getInt(R.styleable.FlowLayout_flChildSpacing, 0);
            } catch (NumberFormatException unused) {
                this.f9506c = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.FlowLayout_flChildSpacing, (int) a(0.0f));
            }
            try {
                this.f9507d = typedArrayObtainStyledAttributes.getInt(R.styleable.FlowLayout_flMinChildSpacing, 0);
            } catch (NumberFormatException unused2) {
                this.f9507d = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.FlowLayout_flMinChildSpacing, (int) a(0.0f));
            }
            try {
                this.f9508e = typedArrayObtainStyledAttributes.getInt(R.styleable.FlowLayout_flChildSpacingForLastRow, -65538);
            } catch (NumberFormatException unused3) {
                this.f9508e = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.FlowLayout_flChildSpacingForLastRow, (int) a(0.0f));
            }
            try {
                this.f9509f = typedArrayObtainStyledAttributes.getInt(R.styleable.FlowLayout_flRowSpacing, 0);
            } catch (NumberFormatException unused4) {
                this.f9509f = typedArrayObtainStyledAttributes.getDimension(R.styleable.FlowLayout_flRowSpacing, a(0.0f));
            }
            this.f9512i = typedArrayObtainStyledAttributes.getInt(R.styleable.FlowLayout_flMaxRows, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
            this.f9511h = typedArrayObtainStyledAttributes.getBoolean(R.styleable.FlowLayout_flRtl, false);
            this.j = typedArrayObtainStyledAttributes.getInt(R.styleable.FlowLayout_android_gravity, -1);
            this.k = typedArrayObtainStyledAttributes.getInt(R.styleable.FlowLayout_flRowVerticalGravity, SupportMenu.CATEGORY_MASK);
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new ViewGroup.MarginLayoutParams(getContext(), attributeSet);
    }
}
