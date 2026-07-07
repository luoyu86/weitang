package com.chinavisionary.microtang.room.adapter;

import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes2.dex */
public class GridSpecItemDecoration extends RecyclerView.ItemDecoration {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f8291a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f8292b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f8293c = -1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Paint f8294d;

    public GridSpecItemDecoration(int i2, int i3) {
        this.f8291a = 2;
        this.f8292b = 5;
        this.f8291a = i2;
        this.f8292b = i3;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
        if (childAdapterPosition != this.f8293c) {
            int i2 = this.f8292b;
            rect.top = i2;
            if (childAdapterPosition % this.f8291a == 0) {
                rect.right = i2;
                rect.left = i2 / 2;
            } else {
                rect.left = i2;
                rect.right = i2 / 2;
            }
        }
    }

    public void setDividerPaint(Paint paint) {
        this.f8294d = paint;
    }

    public void setSkipPosition(int i2) {
        this.f8293c = i2;
    }
}
