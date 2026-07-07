package com.lzy.imagepicker.view;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes2.dex */
public class GridSpacingItemDecoration extends RecyclerView.ItemDecoration {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f9423a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f9424b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f9425c;

    public GridSpacingItemDecoration(int i2, int i3, boolean z) {
        this.f9423a = i2;
        this.f9424b = i3;
        this.f9425c = z;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
        int i2 = this.f9423a;
        int i3 = childAdapterPosition % i2;
        if (this.f9425c) {
            int i4 = this.f9424b;
            rect.left = i4 - ((i3 * i4) / i2);
            rect.right = ((i3 + 1) * i4) / i2;
            if (childAdapterPosition < i2) {
                rect.top = i4;
            }
            rect.bottom = i4;
            return;
        }
        int i5 = this.f9424b;
        rect.left = (i3 * i5) / i2;
        rect.right = i5 - (((i3 + 1) * i5) / i2);
        if (childAdapterPosition >= i2) {
            rect.top = i5;
        }
    }
}
