package com.chinavisionary.core.weight;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes.dex */
public class GridSpacingItemDecoration extends RecyclerView.ItemDecoration {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f6703a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f6704b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f6705c;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f6708f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f6709g;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f6706d = -1;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f6707e = -1;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f6710h = -1;

    public GridSpacingItemDecoration(int i2, int i3, boolean z) {
        this.f6703a = i2;
        this.f6704b = i3;
        this.f6705c = z;
        setMinPadding(i3 / 2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
        if (childAdapterPosition <= this.f6706d) {
            int i2 = this.f6709g;
            rect.left = i2;
            rect.right = i2;
            return;
        }
        int i3 = this.f6703a;
        int i4 = childAdapterPosition % i3;
        if (!this.f6705c) {
            int i5 = this.f6708f;
            rect.left = i4 == i5 ? this.f6704b : this.f6709g;
            rect.right = i4 == i5 ? this.f6709g : this.f6704b;
        } else {
            int i6 = this.f6704b;
            rect.left = i6 - ((i4 * i6) / i3);
            rect.right = ((i4 + 1) * i6) / i3;
            if (childAdapterPosition < i3) {
                rect.top = i6;
            }
            rect.bottom = i6;
        }
    }

    public void setFooterPosition(int i2) {
        this.f6707e = i2;
    }

    public void setMinPadding(int i2) {
        this.f6709g = i2;
    }

    public void setStartPosition(int i2) {
        this.f6706d = i2;
    }
}
