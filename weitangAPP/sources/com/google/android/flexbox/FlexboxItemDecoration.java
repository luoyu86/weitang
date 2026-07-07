package com.google.android.flexbox;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import c.i.a.a.b;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class FlexboxItemDecoration extends RecyclerView.ItemDecoration {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int[] f8918a = {android.R.attr.listDivider};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Drawable f8919b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f8920c;

    public FlexboxItemDecoration(Context context) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(f8918a);
        this.f8919b = typedArrayObtainStyledAttributes.getDrawable(0);
        typedArrayObtainStyledAttributes.recycle();
        setOrientation(3);
    }

    public final void a(Canvas canvas, RecyclerView recyclerView) {
        int top;
        int intrinsicHeight;
        int left;
        int right;
        int i2;
        int iMin;
        int left2;
        if (d()) {
            FlexboxLayoutManager flexboxLayoutManager = (FlexboxLayoutManager) recyclerView.getLayoutManager();
            int flexDirection = flexboxLayoutManager.getFlexDirection();
            int left3 = recyclerView.getLeft() - recyclerView.getPaddingLeft();
            int right2 = recyclerView.getRight() + recyclerView.getPaddingRight();
            int childCount = recyclerView.getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = recyclerView.getChildAt(i3);
                RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) childAt.getLayoutParams();
                if (flexDirection == 3) {
                    intrinsicHeight = childAt.getBottom() + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
                    top = this.f8919b.getIntrinsicHeight() + intrinsicHeight;
                } else {
                    top = childAt.getTop() - ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
                    intrinsicHeight = top - this.f8919b.getIntrinsicHeight();
                }
                if (!flexboxLayoutManager.isMainAxisDirectionHorizontal()) {
                    left = childAt.getLeft() - ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin;
                    right = childAt.getRight();
                    i2 = ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
                } else if (flexboxLayoutManager.z()) {
                    iMin = Math.min(childAt.getRight() + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin + this.f8919b.getIntrinsicWidth(), right2);
                    left2 = childAt.getLeft() - ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin;
                    this.f8919b.setBounds(left2, intrinsicHeight, iMin, top);
                    this.f8919b.draw(canvas);
                } else {
                    left = Math.max((childAt.getLeft() - ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin) - this.f8919b.getIntrinsicWidth(), left3);
                    right = childAt.getRight();
                    i2 = ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
                }
                int i4 = left;
                iMin = right + i2;
                left2 = i4;
                this.f8919b.setBounds(left2, intrinsicHeight, iMin, top);
                this.f8919b.draw(canvas);
            }
        }
    }

    public final void b(Canvas canvas, RecyclerView recyclerView) {
        int left;
        int intrinsicWidth;
        int iMax;
        int bottom;
        int i2;
        int i3;
        if (e()) {
            FlexboxLayoutManager flexboxLayoutManager = (FlexboxLayoutManager) recyclerView.getLayoutManager();
            int top = recyclerView.getTop() - recyclerView.getPaddingTop();
            int bottom2 = recyclerView.getBottom() + recyclerView.getPaddingBottom();
            int childCount = recyclerView.getChildCount();
            int flexDirection = flexboxLayoutManager.getFlexDirection();
            for (int i4 = 0; i4 < childCount; i4++) {
                View childAt = recyclerView.getChildAt(i4);
                RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) childAt.getLayoutParams();
                if (flexboxLayoutManager.z()) {
                    intrinsicWidth = childAt.getRight() + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
                    left = this.f8919b.getIntrinsicWidth() + intrinsicWidth;
                } else {
                    left = childAt.getLeft() - ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin;
                    intrinsicWidth = left - this.f8919b.getIntrinsicWidth();
                }
                if (flexboxLayoutManager.isMainAxisDirectionHorizontal()) {
                    iMax = childAt.getTop() - ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
                    bottom = childAt.getBottom();
                    i2 = ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
                } else if (flexDirection == 3) {
                    int iMin = Math.min(childAt.getBottom() + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin + this.f8919b.getIntrinsicHeight(), bottom2);
                    iMax = childAt.getTop() - ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
                    i3 = iMin;
                    this.f8919b.setBounds(intrinsicWidth, iMax, left, i3);
                    this.f8919b.draw(canvas);
                } else {
                    iMax = Math.max((childAt.getTop() - ((ViewGroup.MarginLayoutParams) layoutParams).topMargin) - this.f8919b.getIntrinsicHeight(), top);
                    bottom = childAt.getBottom();
                    i2 = ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
                }
                i3 = bottom + i2;
                this.f8919b.setBounds(intrinsicWidth, iMax, left, i3);
                this.f8919b.draw(canvas);
            }
        }
    }

    public final boolean c(int i2, List<b> list, FlexboxLayoutManager flexboxLayoutManager) {
        int iW = flexboxLayoutManager.w(i2);
        if ((iW == -1 || iW >= flexboxLayoutManager.getFlexLinesInternal().size() || flexboxLayoutManager.getFlexLinesInternal().get(iW).o != i2) && i2 != 0) {
            return list.size() != 0 && list.get(list.size() - 1).p == i2 - 1;
        }
        return true;
    }

    public final boolean d() {
        return (this.f8920c & 1) > 0;
    }

    public final boolean e() {
        return (this.f8920c & 2) > 0;
    }

    public final void f(Rect rect, int i2, FlexboxLayoutManager flexboxLayoutManager, List<b> list) {
        if (list.size() == 0 || flexboxLayoutManager.w(i2) == 0) {
            return;
        }
        if (flexboxLayoutManager.isMainAxisDirectionHorizontal()) {
            if (d()) {
                rect.top = this.f8919b.getIntrinsicHeight();
                rect.bottom = 0;
                return;
            } else {
                rect.top = 0;
                rect.bottom = 0;
                return;
            }
        }
        if (e()) {
            if (flexboxLayoutManager.z()) {
                rect.right = this.f8919b.getIntrinsicWidth();
                rect.left = 0;
            } else {
                rect.left = this.f8919b.getIntrinsicWidth();
                rect.right = 0;
            }
        }
    }

    public final void g(Rect rect, int i2, FlexboxLayoutManager flexboxLayoutManager, List<b> list, int i3) {
        if (c(i2, list, flexboxLayoutManager)) {
            return;
        }
        if (flexboxLayoutManager.isMainAxisDirectionHorizontal()) {
            if (!e()) {
                rect.left = 0;
                rect.right = 0;
                return;
            } else if (flexboxLayoutManager.z()) {
                rect.right = this.f8919b.getIntrinsicWidth();
                rect.left = 0;
                return;
            } else {
                rect.left = this.f8919b.getIntrinsicWidth();
                rect.right = 0;
                return;
            }
        }
        if (!d()) {
            rect.top = 0;
            rect.bottom = 0;
        } else if (i3 == 3) {
            rect.bottom = this.f8919b.getIntrinsicHeight();
            rect.top = 0;
        } else {
            rect.top = this.f8919b.getIntrinsicHeight();
            rect.bottom = 0;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(@NonNull Rect rect, @NonNull View view, RecyclerView recyclerView, @NonNull RecyclerView.State state) {
        int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
        if (childAdapterPosition == 0) {
            return;
        }
        if (!d() && !e()) {
            rect.set(0, 0, 0, 0);
            return;
        }
        FlexboxLayoutManager flexboxLayoutManager = (FlexboxLayoutManager) recyclerView.getLayoutManager();
        List<b> flexLines = flexboxLayoutManager.getFlexLines();
        g(rect, childAdapterPosition, flexboxLayoutManager, flexLines, flexboxLayoutManager.getFlexDirection());
        f(rect, childAdapterPosition, flexboxLayoutManager, flexLines);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void onDraw(@NonNull Canvas canvas, @NonNull RecyclerView recyclerView, @NonNull RecyclerView.State state) {
        a(canvas, recyclerView);
        b(canvas, recyclerView);
    }

    public void setDrawable(Drawable drawable) {
        if (drawable == null) {
            throw new IllegalArgumentException("Drawable cannot be null.");
        }
        this.f8919b = drawable;
    }

    public void setOrientation(int i2) {
        this.f8920c = i2;
    }
}
