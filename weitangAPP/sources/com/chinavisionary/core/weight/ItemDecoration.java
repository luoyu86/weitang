package com.chinavisionary.core.weight;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes.dex */
public class ItemDecoration extends RecyclerView.ItemDecoration {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f6711a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Drawable f6712b;

    public ItemDecoration(int i2, Drawable drawable) {
        this.f6711a = i2;
        this.f6712b = drawable;
    }

    public final void drawHorizontal(Canvas canvas, RecyclerView recyclerView) {
        int childCount = recyclerView.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = recyclerView.getChildAt(i2);
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) childAt.getLayoutParams();
            int left = childAt.getLeft() - ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin;
            int right = childAt.getRight() + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
            int bottom = childAt.getBottom() + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
            this.f6712b.setBounds(left, bottom, right, this.f6711a + bottom);
            this.f6712b.draw(canvas);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        super.getItemOffsets(rect, view, recyclerView, state);
        rect.bottom = this.f6711a;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        super.onDraw(canvas, recyclerView, state);
        if (this.f6712b != null) {
            drawHorizontal(canvas, recyclerView);
        }
    }
}
