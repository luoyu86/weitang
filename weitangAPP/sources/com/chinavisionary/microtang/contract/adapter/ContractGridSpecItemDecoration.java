package com.chinavisionary.microtang.contract.adapter;

import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes.dex */
public class ContractGridSpecItemDecoration extends RecyclerView.ItemDecoration {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f7091b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Paint f7093d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f7090a = 2;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f7092c = -1;

    public ContractGridSpecItemDecoration(int i2) {
        this.f7091b = 5;
        this.f7091b = i2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
        if (childAdapterPosition != this.f7092c) {
            if (childAdapterPosition != 0) {
                rect.bottom = this.f7091b;
                return;
            }
            int i2 = this.f7091b;
            rect.top = i2;
            rect.bottom = i2;
        }
    }

    public void setDividerPaint(Paint paint) {
        this.f7093d = paint;
    }

    public void setSkipPosition(int i2) {
        this.f7092c = i2;
    }
}
