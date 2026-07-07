package com.google.android.flexbox;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import c.i.a.a.a;
import c.i.a.a.b;
import c.i.a.a.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class FlexboxLayout extends ViewGroup implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f8921a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f8922b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f8923c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f8924d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f8925e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f8926f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @Nullable
    public Drawable f8927g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @Nullable
    public Drawable f8928h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f8929i;
    public int j;
    public int k;
    public int l;
    public int[] m;
    public SparseIntArray n;
    public c o;
    public List<b> p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public c.b f8930q;

    public FlexboxLayout(Context context) {
        this(context, null);
    }

    public final boolean a(int i2) {
        for (int i3 = 0; i3 < i2; i3++) {
            if (this.p.get(i3).getItemCountNotGone() > 0) {
                return false;
            }
        }
        return true;
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i2, ViewGroup.LayoutParams layoutParams) {
        if (this.n == null) {
            this.n = new SparseIntArray(getChildCount());
        }
        this.m = this.o.n(view, i2, layoutParams, this.n);
        super.addView(view, i2, layoutParams);
    }

    public final boolean b(int i2, int i3) {
        for (int i4 = 1; i4 <= i3; i4++) {
            View reorderedChildAt = getReorderedChildAt(i2 - i4);
            if (reorderedChildAt != null && reorderedChildAt.getVisibility() != 8) {
                return false;
            }
        }
        return true;
    }

    public final void c(Canvas canvas, boolean z, boolean z2) {
        int paddingLeft = getPaddingLeft();
        int iMax = Math.max(0, (getWidth() - getPaddingRight()) - paddingLeft);
        int size = this.p.size();
        for (int i2 = 0; i2 < size; i2++) {
            b bVar = this.p.get(i2);
            for (int i3 = 0; i3 < bVar.f2554h; i3++) {
                int i4 = bVar.o + i3;
                View reorderedChildAt = getReorderedChildAt(i4);
                if (reorderedChildAt != null && reorderedChildAt.getVisibility() != 8) {
                    LayoutParams layoutParams = (LayoutParams) reorderedChildAt.getLayoutParams();
                    if (g(i4, i3)) {
                        f(canvas, z ? reorderedChildAt.getRight() + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin : (reorderedChildAt.getLeft() - ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin) - this.l, bVar.f2548b, bVar.f2553g);
                    }
                    if (i3 == bVar.f2554h - 1 && (this.j & 4) > 0) {
                        f(canvas, z ? (reorderedChildAt.getLeft() - ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin) - this.l : reorderedChildAt.getRight() + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin, bVar.f2548b, bVar.f2553g);
                    }
                }
            }
            if (h(i2)) {
                e(canvas, paddingLeft, z2 ? bVar.f2550d : bVar.f2548b - this.k, iMax);
            }
            if (i(i2) && (this.f8929i & 4) > 0) {
                e(canvas, paddingLeft, z2 ? bVar.f2548b - this.k : bVar.f2550d, iMax);
            }
        }
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    public final void d(Canvas canvas, boolean z, boolean z2) {
        int paddingTop = getPaddingTop();
        int iMax = Math.max(0, (getHeight() - getPaddingBottom()) - paddingTop);
        int size = this.p.size();
        for (int i2 = 0; i2 < size; i2++) {
            b bVar = this.p.get(i2);
            for (int i3 = 0; i3 < bVar.f2554h; i3++) {
                int i4 = bVar.o + i3;
                View reorderedChildAt = getReorderedChildAt(i4);
                if (reorderedChildAt != null && reorderedChildAt.getVisibility() != 8) {
                    LayoutParams layoutParams = (LayoutParams) reorderedChildAt.getLayoutParams();
                    if (g(i4, i3)) {
                        e(canvas, bVar.f2547a, z2 ? reorderedChildAt.getBottom() + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin : (reorderedChildAt.getTop() - ((ViewGroup.MarginLayoutParams) layoutParams).topMargin) - this.k, bVar.f2553g);
                    }
                    if (i3 == bVar.f2554h - 1 && (this.f8929i & 4) > 0) {
                        e(canvas, bVar.f2547a, z2 ? (reorderedChildAt.getTop() - ((ViewGroup.MarginLayoutParams) layoutParams).topMargin) - this.k : reorderedChildAt.getBottom() + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin, bVar.f2553g);
                    }
                }
            }
            if (h(i2)) {
                f(canvas, z ? bVar.f2549c : bVar.f2547a - this.l, paddingTop, iMax);
            }
            if (i(i2) && (this.j & 4) > 0) {
                f(canvas, z ? bVar.f2547a - this.l : bVar.f2549c, paddingTop, iMax);
            }
        }
    }

    public final void e(Canvas canvas, int i2, int i3, int i4) {
        Drawable drawable = this.f8927g;
        if (drawable == null) {
            return;
        }
        drawable.setBounds(i2, i3, i4 + i2, this.k + i3);
        this.f8927g.draw(canvas);
    }

    public final void f(Canvas canvas, int i2, int i3, int i4) {
        Drawable drawable = this.f8928h;
        if (drawable == null) {
            return;
        }
        drawable.setBounds(i2, i3, this.l + i2, i4 + i3);
        this.f8928h.draw(canvas);
    }

    public final boolean g(int i2, int i3) {
        return b(i2, i3) ? isMainAxisDirectionHorizontal() ? (this.j & 1) != 0 : (this.f8929i & 1) != 0 : isMainAxisDirectionHorizontal() ? (this.j & 2) != 0 : (this.f8929i & 2) != 0;
    }

    @Override // c.i.a.a.a
    public int getAlignContent() {
        return this.f8925e;
    }

    @Override // c.i.a.a.a
    public int getAlignItems() {
        return this.f8924d;
    }

    @Override // c.i.a.a.a
    public int getChildHeightMeasureSpec(int i2, int i3, int i4) {
        return ViewGroup.getChildMeasureSpec(i2, i3, i4);
    }

    @Override // c.i.a.a.a
    public int getChildWidthMeasureSpec(int i2, int i3, int i4) {
        return ViewGroup.getChildMeasureSpec(i2, i3, i4);
    }

    @Override // c.i.a.a.a
    public int getDecorationLengthCrossAxis(View view) {
        return 0;
    }

    @Override // c.i.a.a.a
    public int getDecorationLengthMainAxis(View view, int i2, int i3) {
        int i4;
        int i5;
        if (isMainAxisDirectionHorizontal()) {
            i4 = g(i2, i3) ? 0 + this.l : 0;
            if ((this.j & 4) <= 0) {
                return i4;
            }
            i5 = this.l;
        } else {
            i4 = g(i2, i3) ? 0 + this.k : 0;
            if ((this.f8929i & 4) <= 0) {
                return i4;
            }
            i5 = this.k;
        }
        return i4 + i5;
    }

    @Nullable
    public Drawable getDividerDrawableHorizontal() {
        return this.f8927g;
    }

    @Nullable
    public Drawable getDividerDrawableVertical() {
        return this.f8928h;
    }

    @Override // c.i.a.a.a
    public int getFlexDirection() {
        return this.f8921a;
    }

    @Override // c.i.a.a.a
    public View getFlexItemAt(int i2) {
        return getChildAt(i2);
    }

    @Override // c.i.a.a.a
    public int getFlexItemCount() {
        return getChildCount();
    }

    @Override // c.i.a.a.a
    public List<b> getFlexLines() {
        ArrayList arrayList = new ArrayList(this.p.size());
        for (b bVar : this.p) {
            if (bVar.getItemCountNotGone() != 0) {
                arrayList.add(bVar);
            }
        }
        return arrayList;
    }

    @Override // c.i.a.a.a
    public List<b> getFlexLinesInternal() {
        return this.p;
    }

    @Override // c.i.a.a.a
    public int getFlexWrap() {
        return this.f8922b;
    }

    @Override // c.i.a.a.a
    public int getJustifyContent() {
        return this.f8923c;
    }

    @Override // c.i.a.a.a
    public int getLargestMainSize() {
        Iterator<b> it = this.p.iterator();
        int iMax = Integer.MIN_VALUE;
        while (it.hasNext()) {
            iMax = Math.max(iMax, it.next().f2551e);
        }
        return iMax;
    }

    @Override // c.i.a.a.a
    public int getMaxLine() {
        return this.f8926f;
    }

    public View getReorderedChildAt(int i2) {
        if (i2 < 0) {
            return null;
        }
        int[] iArr = this.m;
        if (i2 >= iArr.length) {
            return null;
        }
        return getChildAt(iArr[i2]);
    }

    @Override // c.i.a.a.a
    public View getReorderedFlexItemAt(int i2) {
        return getReorderedChildAt(i2);
    }

    public int getShowDividerHorizontal() {
        return this.f8929i;
    }

    public int getShowDividerVertical() {
        return this.j;
    }

    @Override // c.i.a.a.a
    public int getSumOfCrossSize() {
        int size = this.p.size();
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            b bVar = this.p.get(i3);
            if (h(i3)) {
                i2 += isMainAxisDirectionHorizontal() ? this.k : this.l;
            }
            if (i(i3)) {
                i2 += isMainAxisDirectionHorizontal() ? this.k : this.l;
            }
            i2 += bVar.f2553g;
        }
        return i2;
    }

    public final boolean h(int i2) {
        if (i2 < 0 || i2 >= this.p.size()) {
            return false;
        }
        return a(i2) ? isMainAxisDirectionHorizontal() ? (this.f8929i & 1) != 0 : (this.j & 1) != 0 : isMainAxisDirectionHorizontal() ? (this.f8929i & 2) != 0 : (this.j & 2) != 0;
    }

    public final boolean i(int i2) {
        if (i2 < 0 || i2 >= this.p.size()) {
            return false;
        }
        for (int i3 = i2 + 1; i3 < this.p.size(); i3++) {
            if (this.p.get(i3).getItemCountNotGone() > 0) {
                return false;
            }
        }
        return isMainAxisDirectionHorizontal() ? (this.f8929i & 4) != 0 : (this.j & 4) != 0;
    }

    @Override // c.i.a.a.a
    public boolean isMainAxisDirectionHorizontal() {
        int i2 = this.f8921a;
        return i2 == 0 || i2 == 1;
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x00d4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void j(boolean r29, int r30, int r31, int r32, int r33) {
        /*
            Method dump skipped, instruction units count: 544
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.flexbox.FlexboxLayout.j(boolean, int, int, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x00d2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void k(boolean r30, boolean r31, int r32, int r33, int r34, int r35) {
        /*
            Method dump skipped, instruction units count: 532
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.flexbox.FlexboxLayout.k(boolean, boolean, int, int, int, int):void");
    }

    public final void l(int i2, int i3) {
        this.p.clear();
        this.f8930q.a();
        this.o.c(this.f8930q, i2, i3);
        this.p = this.f8930q.f2562a;
        this.o.p(i2, i3);
        if (this.f8924d == 3) {
            for (b bVar : this.p) {
                int iMax = Integer.MIN_VALUE;
                for (int i4 = 0; i4 < bVar.f2554h; i4++) {
                    View reorderedChildAt = getReorderedChildAt(bVar.o + i4);
                    if (reorderedChildAt != null && reorderedChildAt.getVisibility() != 8) {
                        LayoutParams layoutParams = (LayoutParams) reorderedChildAt.getLayoutParams();
                        iMax = this.f8922b != 2 ? Math.max(iMax, reorderedChildAt.getMeasuredHeight() + Math.max(bVar.l - reorderedChildAt.getBaseline(), ((ViewGroup.MarginLayoutParams) layoutParams).topMargin) + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin) : Math.max(iMax, reorderedChildAt.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + Math.max((bVar.l - reorderedChildAt.getMeasuredHeight()) + reorderedChildAt.getBaseline(), ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin));
                    }
                }
                bVar.f2553g = iMax;
            }
        }
        this.o.o(i2, i3, getPaddingTop() + getPaddingBottom());
        this.o.X();
        n(this.f8921a, i2, i3, this.f8930q.f2563b);
    }

    public final void m(int i2, int i3) {
        this.p.clear();
        this.f8930q.a();
        this.o.f(this.f8930q, i2, i3);
        this.p = this.f8930q.f2562a;
        this.o.p(i2, i3);
        this.o.o(i2, i3, getPaddingLeft() + getPaddingRight());
        this.o.X();
        n(this.f8921a, i2, i3, this.f8930q.f2563b);
    }

    public final void n(int i2, int i3, int i4, int i5) {
        int sumOfCrossSize;
        int largestMainSize;
        int iResolveSizeAndState;
        int iResolveSizeAndState2;
        int mode = View.MeasureSpec.getMode(i3);
        int size = View.MeasureSpec.getSize(i3);
        int mode2 = View.MeasureSpec.getMode(i4);
        int size2 = View.MeasureSpec.getSize(i4);
        if (i2 == 0 || i2 == 1) {
            sumOfCrossSize = getSumOfCrossSize() + getPaddingTop() + getPaddingBottom();
            largestMainSize = getLargestMainSize();
        } else {
            if (i2 != 2 && i2 != 3) {
                throw new IllegalArgumentException("Invalid flex direction: " + i2);
            }
            sumOfCrossSize = getLargestMainSize();
            largestMainSize = getSumOfCrossSize() + getPaddingLeft() + getPaddingRight();
        }
        if (mode == Integer.MIN_VALUE) {
            if (size < largestMainSize) {
                i5 = View.combineMeasuredStates(i5, 16777216);
            } else {
                size = largestMainSize;
            }
            iResolveSizeAndState = View.resolveSizeAndState(size, i3, i5);
        } else if (mode == 0) {
            iResolveSizeAndState = View.resolveSizeAndState(largestMainSize, i3, i5);
        } else {
            if (mode != 1073741824) {
                throw new IllegalStateException("Unknown width mode is set: " + mode);
            }
            if (size < largestMainSize) {
                i5 = View.combineMeasuredStates(i5, 16777216);
            }
            iResolveSizeAndState = View.resolveSizeAndState(size, i3, i5);
        }
        if (mode2 == Integer.MIN_VALUE) {
            if (size2 < sumOfCrossSize) {
                i5 = View.combineMeasuredStates(i5, 256);
            } else {
                size2 = sumOfCrossSize;
            }
            iResolveSizeAndState2 = View.resolveSizeAndState(size2, i4, i5);
        } else if (mode2 == 0) {
            iResolveSizeAndState2 = View.resolveSizeAndState(sumOfCrossSize, i4, i5);
        } else {
            if (mode2 != 1073741824) {
                throw new IllegalStateException("Unknown height mode is set: " + mode2);
            }
            if (size2 < sumOfCrossSize) {
                i5 = View.combineMeasuredStates(i5, 256);
            }
            iResolveSizeAndState2 = View.resolveSizeAndState(size2, i4, i5);
        }
        setMeasuredDimension(iResolveSizeAndState, iResolveSizeAndState2);
    }

    public final void o() {
        if (this.f8927g == null && this.f8928h == null) {
            setWillNotDraw(true);
        } else {
            setWillNotDraw(false);
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        if (this.f8928h == null && this.f8927g == null) {
            return;
        }
        if (this.f8929i == 0 && this.j == 0) {
            return;
        }
        int layoutDirection = ViewCompat.getLayoutDirection(this);
        int i2 = this.f8921a;
        if (i2 == 0) {
            c(canvas, layoutDirection == 1, this.f8922b == 2);
            return;
        }
        if (i2 == 1) {
            c(canvas, layoutDirection != 1, this.f8922b == 2);
            return;
        }
        if (i2 == 2) {
            boolean z = layoutDirection == 1;
            if (this.f8922b == 2) {
                z = !z;
            }
            d(canvas, z, false);
            return;
        }
        if (i2 != 3) {
            return;
        }
        boolean z2 = layoutDirection == 1;
        if (this.f8922b == 2) {
            z2 = !z2;
        }
        d(canvas, z2, true);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        boolean z2;
        int layoutDirection = ViewCompat.getLayoutDirection(this);
        int i6 = this.f8921a;
        if (i6 == 0) {
            j(layoutDirection == 1, i2, i3, i4, i5);
            return;
        }
        if (i6 == 1) {
            j(layoutDirection != 1, i2, i3, i4, i5);
            return;
        }
        if (i6 == 2) {
            z2 = layoutDirection == 1;
            k(this.f8922b == 2 ? !z2 : z2, false, i2, i3, i4, i5);
        } else if (i6 == 3) {
            z2 = layoutDirection == 1;
            k(this.f8922b == 2 ? !z2 : z2, true, i2, i3, i4, i5);
        } else {
            throw new IllegalStateException("Invalid flex direction is set: " + this.f8921a);
        }
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        if (this.n == null) {
            this.n = new SparseIntArray(getChildCount());
        }
        if (this.o.O(this.n)) {
            this.m = this.o.m(this.n);
        }
        int i4 = this.f8921a;
        if (i4 == 0 || i4 == 1) {
            l(i2, i3);
            return;
        }
        if (i4 == 2 || i4 == 3) {
            m(i2, i3);
            return;
        }
        throw new IllegalStateException("Invalid value for the flex direction is set: " + this.f8921a);
    }

    @Override // c.i.a.a.a
    public void onNewFlexItemAdded(View view, int i2, int i3, b bVar) {
        if (g(i2, i3)) {
            if (isMainAxisDirectionHorizontal()) {
                int i4 = bVar.f2551e;
                int i5 = this.l;
                bVar.f2551e = i4 + i5;
                bVar.f2552f += i5;
                return;
            }
            int i6 = bVar.f2551e;
            int i7 = this.k;
            bVar.f2551e = i6 + i7;
            bVar.f2552f += i7;
        }
    }

    @Override // c.i.a.a.a
    public void onNewFlexLineAdded(b bVar) {
        if (isMainAxisDirectionHorizontal()) {
            if ((this.j & 4) > 0) {
                int i2 = bVar.f2551e;
                int i3 = this.l;
                bVar.f2551e = i2 + i3;
                bVar.f2552f += i3;
                return;
            }
            return;
        }
        if ((this.f8929i & 4) > 0) {
            int i4 = bVar.f2551e;
            int i5 = this.k;
            bVar.f2551e = i4 + i5;
            bVar.f2552f += i5;
        }
    }

    @Override // c.i.a.a.a
    public void setAlignContent(int i2) {
        if (this.f8925e != i2) {
            this.f8925e = i2;
            requestLayout();
        }
    }

    @Override // c.i.a.a.a
    public void setAlignItems(int i2) {
        if (this.f8924d != i2) {
            this.f8924d = i2;
            requestLayout();
        }
    }

    public void setDividerDrawable(Drawable drawable) {
        setDividerDrawableHorizontal(drawable);
        setDividerDrawableVertical(drawable);
    }

    public void setDividerDrawableHorizontal(@Nullable Drawable drawable) {
        if (drawable == this.f8927g) {
            return;
        }
        this.f8927g = drawable;
        if (drawable != null) {
            this.k = drawable.getIntrinsicHeight();
        } else {
            this.k = 0;
        }
        o();
        requestLayout();
    }

    public void setDividerDrawableVertical(@Nullable Drawable drawable) {
        if (drawable == this.f8928h) {
            return;
        }
        this.f8928h = drawable;
        if (drawable != null) {
            this.l = drawable.getIntrinsicWidth();
        } else {
            this.l = 0;
        }
        o();
        requestLayout();
    }

    @Override // c.i.a.a.a
    public void setFlexDirection(int i2) {
        if (this.f8921a != i2) {
            this.f8921a = i2;
            requestLayout();
        }
    }

    @Override // c.i.a.a.a
    public void setFlexLines(List<b> list) {
        this.p = list;
    }

    @Override // c.i.a.a.a
    public void setFlexWrap(int i2) {
        if (this.f8922b != i2) {
            this.f8922b = i2;
            requestLayout();
        }
    }

    @Override // c.i.a.a.a
    public void setJustifyContent(int i2) {
        if (this.f8923c != i2) {
            this.f8923c = i2;
            requestLayout();
        }
    }

    @Override // c.i.a.a.a
    public void setMaxLine(int i2) {
        if (this.f8926f != i2) {
            this.f8926f = i2;
            requestLayout();
        }
    }

    public void setShowDivider(int i2) {
        setShowDividerVertical(i2);
        setShowDividerHorizontal(i2);
    }

    public void setShowDividerHorizontal(int i2) {
        if (i2 != this.f8929i) {
            this.f8929i = i2;
            requestLayout();
        }
    }

    public void setShowDividerVertical(int i2) {
        if (i2 != this.j) {
            this.j = i2;
            requestLayout();
        }
    }

    @Override // c.i.a.a.a
    public void updateViewCache(int i2, View view) {
    }

    public FlexboxLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override // android.view.ViewGroup
    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    public FlexboxLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f8926f = -1;
        this.o = new c(this);
        this.p = new ArrayList();
        this.f8930q = new c.b();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.FlexboxLayout, i2, 0);
        this.f8921a = typedArrayObtainStyledAttributes.getInt(R.styleable.FlexboxLayout_flexDirection, 0);
        this.f8922b = typedArrayObtainStyledAttributes.getInt(R.styleable.FlexboxLayout_flexWrap, 0);
        this.f8923c = typedArrayObtainStyledAttributes.getInt(R.styleable.FlexboxLayout_justifyContent, 0);
        this.f8924d = typedArrayObtainStyledAttributes.getInt(R.styleable.FlexboxLayout_alignItems, 0);
        this.f8925e = typedArrayObtainStyledAttributes.getInt(R.styleable.FlexboxLayout_alignContent, 0);
        this.f8926f = typedArrayObtainStyledAttributes.getInt(R.styleable.FlexboxLayout_maxLine, -1);
        Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(R.styleable.FlexboxLayout_dividerDrawable);
        if (drawable != null) {
            setDividerDrawableHorizontal(drawable);
            setDividerDrawableVertical(drawable);
        }
        Drawable drawable2 = typedArrayObtainStyledAttributes.getDrawable(R.styleable.FlexboxLayout_dividerDrawableHorizontal);
        if (drawable2 != null) {
            setDividerDrawableHorizontal(drawable2);
        }
        Drawable drawable3 = typedArrayObtainStyledAttributes.getDrawable(R.styleable.FlexboxLayout_dividerDrawableVertical);
        if (drawable3 != null) {
            setDividerDrawableVertical(drawable3);
        }
        int i3 = typedArrayObtainStyledAttributes.getInt(R.styleable.FlexboxLayout_showDivider, 0);
        if (i3 != 0) {
            this.j = i3;
            this.f8929i = i3;
        }
        int i4 = typedArrayObtainStyledAttributes.getInt(R.styleable.FlexboxLayout_showDividerVertical, 0);
        if (i4 != 0) {
            this.j = i4;
        }
        int i5 = typedArrayObtainStyledAttributes.getInt(R.styleable.FlexboxLayout_showDividerHorizontal, 0);
        if (i5 != 0) {
            this.f8929i = i5;
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof LayoutParams) {
            return new LayoutParams((LayoutParams) layoutParams);
        }
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new LayoutParams(layoutParams);
    }

    public static class LayoutParams extends ViewGroup.MarginLayoutParams implements FlexItem {
        public static final Parcelable.Creator<LayoutParams> CREATOR = new a();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f8931a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public float f8932b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public float f8933c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f8934d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public float f8935e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f8936f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f8937g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f8938h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f8939i;
        public boolean j;

        public class a implements Parcelable.Creator<LayoutParams> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public LayoutParams createFromParcel(Parcel parcel) {
                return new LayoutParams(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public LayoutParams[] newArray(int i2) {
                return new LayoutParams[i2];
            }
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f8931a = 1;
            this.f8932b = 0.0f;
            this.f8933c = 1.0f;
            this.f8934d = -1;
            this.f8935e = -1.0f;
            this.f8936f = -1;
            this.f8937g = -1;
            this.f8938h = ViewCompat.MEASURED_SIZE_MASK;
            this.f8939i = ViewCompat.MEASURED_SIZE_MASK;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.FlexboxLayout_Layout);
            this.f8931a = typedArrayObtainStyledAttributes.getInt(R.styleable.FlexboxLayout_Layout_layout_order, 1);
            this.f8932b = typedArrayObtainStyledAttributes.getFloat(R.styleable.FlexboxLayout_Layout_layout_flexGrow, 0.0f);
            this.f8933c = typedArrayObtainStyledAttributes.getFloat(R.styleable.FlexboxLayout_Layout_layout_flexShrink, 1.0f);
            this.f8934d = typedArrayObtainStyledAttributes.getInt(R.styleable.FlexboxLayout_Layout_layout_alignSelf, -1);
            this.f8935e = typedArrayObtainStyledAttributes.getFraction(R.styleable.FlexboxLayout_Layout_layout_flexBasisPercent, 1, 1, -1.0f);
            this.f8936f = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.FlexboxLayout_Layout_layout_minWidth, -1);
            this.f8937g = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.FlexboxLayout_Layout_layout_minHeight, -1);
            this.f8938h = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.FlexboxLayout_Layout_layout_maxWidth, ViewCompat.MEASURED_SIZE_MASK);
            this.f8939i = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.FlexboxLayout_Layout_layout_maxHeight, ViewCompat.MEASURED_SIZE_MASK);
            this.j = typedArrayObtainStyledAttributes.getBoolean(R.styleable.FlexboxLayout_Layout_layout_wrapBefore, false);
            typedArrayObtainStyledAttributes.recycle();
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getAlignSelf() {
            return this.f8934d;
        }

        @Override // com.google.android.flexbox.FlexItem
        public float getFlexBasisPercent() {
            return this.f8935e;
        }

        @Override // com.google.android.flexbox.FlexItem
        public float getFlexGrow() {
            return this.f8932b;
        }

        @Override // com.google.android.flexbox.FlexItem
        public float getFlexShrink() {
            return this.f8933c;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getHeight() {
            return ((ViewGroup.MarginLayoutParams) this).height;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getMarginBottom() {
            return ((ViewGroup.MarginLayoutParams) this).bottomMargin;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getMarginLeft() {
            return ((ViewGroup.MarginLayoutParams) this).leftMargin;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getMarginRight() {
            return ((ViewGroup.MarginLayoutParams) this).rightMargin;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getMarginTop() {
            return ((ViewGroup.MarginLayoutParams) this).topMargin;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getMaxHeight() {
            return this.f8939i;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getMaxWidth() {
            return this.f8938h;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getMinHeight() {
            return this.f8937g;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getMinWidth() {
            return this.f8936f;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getOrder() {
            return this.f8931a;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getWidth() {
            return ((ViewGroup.MarginLayoutParams) this).width;
        }

        @Override // com.google.android.flexbox.FlexItem
        public boolean isWrapBefore() {
            return this.j;
        }

        @Override // com.google.android.flexbox.FlexItem
        public void setAlignSelf(int i2) {
            this.f8934d = i2;
        }

        @Override // com.google.android.flexbox.FlexItem
        public void setFlexBasisPercent(float f2) {
            this.f8935e = f2;
        }

        @Override // com.google.android.flexbox.FlexItem
        public void setFlexGrow(float f2) {
            this.f8932b = f2;
        }

        @Override // com.google.android.flexbox.FlexItem
        public void setFlexShrink(float f2) {
            this.f8933c = f2;
        }

        @Override // com.google.android.flexbox.FlexItem
        public void setHeight(int i2) {
            ((ViewGroup.MarginLayoutParams) this).height = i2;
        }

        @Override // com.google.android.flexbox.FlexItem
        public void setMaxHeight(int i2) {
            this.f8939i = i2;
        }

        @Override // com.google.android.flexbox.FlexItem
        public void setMaxWidth(int i2) {
            this.f8938h = i2;
        }

        @Override // com.google.android.flexbox.FlexItem
        public void setMinHeight(int i2) {
            this.f8937g = i2;
        }

        @Override // com.google.android.flexbox.FlexItem
        public void setMinWidth(int i2) {
            this.f8936f = i2;
        }

        @Override // com.google.android.flexbox.FlexItem
        public void setOrder(int i2) {
            this.f8931a = i2;
        }

        @Override // com.google.android.flexbox.FlexItem
        public void setWidth(int i2) {
            ((ViewGroup.MarginLayoutParams) this).width = i2;
        }

        @Override // com.google.android.flexbox.FlexItem
        public void setWrapBefore(boolean z) {
            this.j = z;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            parcel.writeInt(this.f8931a);
            parcel.writeFloat(this.f8932b);
            parcel.writeFloat(this.f8933c);
            parcel.writeInt(this.f8934d);
            parcel.writeFloat(this.f8935e);
            parcel.writeInt(this.f8936f);
            parcel.writeInt(this.f8937g);
            parcel.writeInt(this.f8938h);
            parcel.writeInt(this.f8939i);
            parcel.writeByte(this.j ? (byte) 1 : (byte) 0);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).bottomMargin);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).leftMargin);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).rightMargin);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).topMargin);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).height);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).width);
        }

        public LayoutParams(LayoutParams layoutParams) {
            super((ViewGroup.MarginLayoutParams) layoutParams);
            this.f8931a = 1;
            this.f8932b = 0.0f;
            this.f8933c = 1.0f;
            this.f8934d = -1;
            this.f8935e = -1.0f;
            this.f8936f = -1;
            this.f8937g = -1;
            this.f8938h = ViewCompat.MEASURED_SIZE_MASK;
            this.f8939i = ViewCompat.MEASURED_SIZE_MASK;
            this.f8931a = layoutParams.f8931a;
            this.f8932b = layoutParams.f8932b;
            this.f8933c = layoutParams.f8933c;
            this.f8934d = layoutParams.f8934d;
            this.f8935e = layoutParams.f8935e;
            this.f8936f = layoutParams.f8936f;
            this.f8937g = layoutParams.f8937g;
            this.f8938h = layoutParams.f8938h;
            this.f8939i = layoutParams.f8939i;
            this.j = layoutParams.j;
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f8931a = 1;
            this.f8932b = 0.0f;
            this.f8933c = 1.0f;
            this.f8934d = -1;
            this.f8935e = -1.0f;
            this.f8936f = -1;
            this.f8937g = -1;
            this.f8938h = ViewCompat.MEASURED_SIZE_MASK;
            this.f8939i = ViewCompat.MEASURED_SIZE_MASK;
        }

        public LayoutParams(int i2, int i3) {
            super(new ViewGroup.LayoutParams(i2, i3));
            this.f8931a = 1;
            this.f8932b = 0.0f;
            this.f8933c = 1.0f;
            this.f8934d = -1;
            this.f8935e = -1.0f;
            this.f8936f = -1;
            this.f8937g = -1;
            this.f8938h = ViewCompat.MEASURED_SIZE_MASK;
            this.f8939i = ViewCompat.MEASURED_SIZE_MASK;
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f8931a = 1;
            this.f8932b = 0.0f;
            this.f8933c = 1.0f;
            this.f8934d = -1;
            this.f8935e = -1.0f;
            this.f8936f = -1;
            this.f8937g = -1;
            this.f8938h = ViewCompat.MEASURED_SIZE_MASK;
            this.f8939i = ViewCompat.MEASURED_SIZE_MASK;
        }

        public LayoutParams(Parcel parcel) {
            super(0, 0);
            this.f8931a = 1;
            this.f8932b = 0.0f;
            this.f8933c = 1.0f;
            this.f8934d = -1;
            this.f8935e = -1.0f;
            this.f8936f = -1;
            this.f8937g = -1;
            this.f8938h = ViewCompat.MEASURED_SIZE_MASK;
            this.f8939i = ViewCompat.MEASURED_SIZE_MASK;
            this.f8931a = parcel.readInt();
            this.f8932b = parcel.readFloat();
            this.f8933c = parcel.readFloat();
            this.f8934d = parcel.readInt();
            this.f8935e = parcel.readFloat();
            this.f8936f = parcel.readInt();
            this.f8937g = parcel.readInt();
            this.f8938h = parcel.readInt();
            this.f8939i = parcel.readInt();
            this.j = parcel.readByte() != 0;
            ((ViewGroup.MarginLayoutParams) this).bottomMargin = parcel.readInt();
            ((ViewGroup.MarginLayoutParams) this).leftMargin = parcel.readInt();
            ((ViewGroup.MarginLayoutParams) this).rightMargin = parcel.readInt();
            ((ViewGroup.MarginLayoutParams) this).topMargin = parcel.readInt();
            ((ViewGroup.MarginLayoutParams) this).height = parcel.readInt();
            ((ViewGroup.MarginLayoutParams) this).width = parcel.readInt();
        }
    }
}
