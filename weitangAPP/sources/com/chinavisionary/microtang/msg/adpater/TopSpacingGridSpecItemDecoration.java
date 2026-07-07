package com.chinavisionary.microtang.msg.adpater;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes.dex */
public class TopSpacingGridSpecItemDecoration extends RecyclerView.ItemDecoration {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f7948a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f7949b = -1;

    public TopSpacingGridSpecItemDecoration(int i2) {
        this.f7948a = 5;
        this.f7948a = i2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        if (recyclerView.getChildAdapterPosition(view) != 0) {
            rect.bottom = this.f7948a;
            return;
        }
        int i2 = this.f7948a;
        rect.top = i2;
        rect.bottom = i2;
    }
}
