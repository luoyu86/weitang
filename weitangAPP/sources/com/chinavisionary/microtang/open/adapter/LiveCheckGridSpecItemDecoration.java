package com.chinavisionary.microtang.open.adapter;

import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes.dex */
public class LiveCheckGridSpecItemDecoration extends RecyclerView.ItemDecoration {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f7965a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f7966b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f7967c = -1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Rect f7968d = new Rect();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Paint f7969e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Drawable f7970f;

    public LiveCheckGridSpecItemDecoration(int i2, int i3) {
        this.f7965a = 2;
        this.f7966b = 5;
        this.f7965a = i2;
        this.f7966b = i3;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
        if (childAdapterPosition != this.f7967c) {
            if (childAdapterPosition < this.f7965a) {
                int i2 = this.f7966b;
                rect.top = i2;
                rect.bottom = i2;
            } else {
                rect.bottom = this.f7966b;
            }
            rect.left = this.f7966b;
        }
    }

    public void setDivider(Drawable drawable) {
        this.f7970f = drawable;
    }

    public void setDividerPaint(Paint paint) {
        this.f7969e = paint;
    }

    public void setSkipPosition(int i2) {
        this.f7967c = i2;
    }
}
