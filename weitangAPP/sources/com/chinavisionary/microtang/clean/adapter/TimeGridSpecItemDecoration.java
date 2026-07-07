package com.chinavisionary.microtang.clean.adapter;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes.dex */
public class TimeGridSpecItemDecoration extends RecyclerView.ItemDecoration {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f6934a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f6935b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f6936c = -1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Rect f6937d = new Rect();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Paint f6938e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Drawable f6939f;

    public TimeGridSpecItemDecoration(int i2, int i3) {
        this.f6934a = 2;
        this.f6935b = 5;
        this.f6934a = i2;
        this.f6935b = i3;
    }

    public final void drawHorizontal(Canvas canvas, RecyclerView recyclerView) {
        int childCount = recyclerView.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = recyclerView.getChildAt(i2);
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) childAt.getLayoutParams();
            int left = childAt.getLeft() - ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin;
            int right = childAt.getRight() + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin + this.f6935b;
            int bottom = childAt.getBottom() + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
            this.f6939f.setBounds(left, bottom, right, this.f6935b + bottom);
            this.f6939f.draw(canvas);
        }
    }

    public final void drawVertical(Canvas canvas, RecyclerView recyclerView) {
        int childCount = recyclerView.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            if (i2 != this.f6936c) {
                View childAt = recyclerView.getChildAt(i2);
                RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) childAt.getLayoutParams();
                int top = childAt.getTop() - ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
                int bottom = childAt.getBottom() + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
                int right = childAt.getRight() + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
                this.f6939f.setBounds(right, top, this.f6935b + right, bottom);
                this.f6939f.draw(canvas);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
        if (childAdapterPosition != this.f6936c) {
            int i2 = this.f6934a;
            if (childAdapterPosition < i2) {
                int i3 = this.f6935b;
                rect.top = i3;
                rect.bottom = i3;
            } else {
                rect.bottom = this.f6935b;
            }
            if ((childAdapterPosition + 1) % i2 == 0) {
                rect.right = this.f6935b;
            } else {
                rect.left = this.f6935b;
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        if (this.f6939f == null) {
            super.onDraw(canvas, recyclerView, state);
        } else {
            drawHorizontal(canvas, recyclerView);
            drawVertical(canvas, recyclerView);
        }
    }

    public void setDivider(Drawable drawable) {
        this.f6939f = drawable;
    }

    public void setDividerPaint(Paint paint) {
        this.f6938e = paint;
    }

    public void setSkipPosition(int i2) {
        this.f6936c = i2;
    }
}
