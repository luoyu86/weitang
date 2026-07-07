package com.chinavisionary.microtang.repair.adapter;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes2.dex */
public class RepairGridSpecItemDecoration extends RecyclerView.ItemDecoration {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f8219a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f8220b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f8221c = -1;

    public RepairGridSpecItemDecoration(int i2, int i3) {
        this.f8219a = 2;
        this.f8220b = 5;
        this.f8219a = i2;
        this.f8220b = i3;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
        if (childAdapterPosition != this.f8221c) {
            if (childAdapterPosition < this.f8219a) {
                rect.top = this.f8220b;
            }
            int i2 = this.f8220b;
            rect.bottom = i2;
            rect.right = i2;
        }
    }
}
