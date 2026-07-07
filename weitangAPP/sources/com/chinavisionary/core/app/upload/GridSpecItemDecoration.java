package com.chinavisionary.core.app.upload;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes.dex */
public class GridSpecItemDecoration extends RecyclerView.ItemDecoration {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f6513a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f6514b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f6515c = -1;

    public GridSpecItemDecoration(int i2, int i3) {
        this.f6513a = 2;
        this.f6514b = 5;
        this.f6513a = i2;
        this.f6514b = i3;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
        if (childAdapterPosition != this.f6515c) {
            if (childAdapterPosition < this.f6513a) {
                rect.top = this.f6514b;
            }
            int i2 = this.f6514b;
            rect.bottom = i2;
            rect.right = i2;
        }
    }
}
