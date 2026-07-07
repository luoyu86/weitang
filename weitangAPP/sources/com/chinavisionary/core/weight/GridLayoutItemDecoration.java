package com.chinavisionary.core.weight;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

/* JADX INFO: loaded from: classes.dex */
public class GridLayoutItemDecoration extends RecyclerView.ItemDecoration {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f6699a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f6700b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f6701c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f6702d;

    public GridLayoutItemDecoration(int i2) {
        this.f6699a = i2;
        setDivideParams(20, 20);
        this.f6702d = 1;
    }

    public final boolean a(RecyclerView recyclerView, int i2, int i3, int i4) {
        return c(recyclerView) ? (i2 + 1) % i3 == 0 : i2 >= i4 - (i4 % i3);
    }

    public final boolean b(RecyclerView recyclerView, int i2, int i3, int i4) {
        return c(recyclerView) ? (i2 - (i2 % i3)) + i3 >= i4 : (i2 + 1) % i3 == 0;
    }

    public final boolean c(RecyclerView recyclerView) {
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        return layoutManager instanceof GridLayoutManager ? ((GridLayoutManager) layoutManager).getOrientation() == 1 : (layoutManager instanceof StaggeredGridLayoutManager) && ((StaggeredGridLayoutManager) layoutManager).getOrientation() == 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
        int itemCount = recyclerView.getAdapter().getItemCount();
        int i2 = this.f6699a;
        int i3 = childAdapterPosition % i2 == 0 ? 0 : this.f6700b;
        int i4 = (childAdapterPosition + 1) % i2 == 0 ? 0 : this.f6701c;
        if (c(recyclerView)) {
            if (b(recyclerView, childAdapterPosition, this.f6699a, itemCount)) {
                rect.set(i3, 0, 0, 0);
                return;
            } else {
                rect.set(i3, 0, 0, this.f6701c);
                return;
            }
        }
        if (a(recyclerView, childAdapterPosition, this.f6699a, itemCount)) {
            rect.set(0, 0, 0, i4);
        } else {
            rect.set(0, 0, this.f6700b, i4);
        }
    }

    public void setDivideParams(int i2, int i3) {
        this.f6700b = i2;
        this.f6701c = i3;
    }

    public void setOrientation(int i2) {
        if (i2 != 0 && i2 != 1) {
            throw new IllegalArgumentException("invalid orientation");
        }
        this.f6702d = i2;
    }

    public GridLayoutItemDecoration(int i2, int i3) {
        this.f6699a = i2;
        setDivideParams(20, 20);
        setOrientation(i3);
    }

    public GridLayoutItemDecoration(int i2, int i3, int i4, int i5) {
        this(i2);
        setDivideParams(i4, i5);
        setOrientation(i3);
    }
}
