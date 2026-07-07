package com.chinavisionary.microtang.me.adapter;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes.dex */
public class RoomGridSpecItemDecoration extends RecyclerView.ItemDecoration {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f7543a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f7544b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f7545c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f7546d = -1;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f7547e = -1;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Rect f7548f = new Rect();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Paint f7549g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Paint f7550h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Drawable f7551i;

    public RoomGridSpecItemDecoration(int i2, int i3, int i4) {
        this.f7543a = 2;
        this.f7544b = 5;
        this.f7545c = 5;
        this.f7543a = i2;
        this.f7544b = i3;
        this.f7545c = i4;
        Paint paint = new Paint(1);
        this.f7550h = paint;
        paint.setStrokeWidth(i3);
        this.f7550h.setStyle(Paint.Style.FILL);
        this.f7550h.setColor(-1);
        Paint paint2 = new Paint(1);
        this.f7549g = paint2;
        paint2.setStyle(Paint.Style.FILL);
        this.f7549g.setStrokeWidth(this.f7545c);
        this.f7549g.setColor(-1);
    }

    public final void drawHorizontal(Canvas canvas, RecyclerView recyclerView) {
        int childCount = recyclerView.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = recyclerView.getChildAt(i2);
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) childAt.getLayoutParams();
            int left = childAt.getLeft();
            int right = childAt.getRight();
            canvas.drawRect(left, childAt.getBottom() + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin, right, (this.f7545c * 2) + r8, this.f7549g);
            int top = childAt.getTop();
            int bottom = childAt.getBottom() + (this.f7545c * 2);
            float f2 = top;
            float f3 = bottom;
            canvas.drawRect(childAt.getRight() + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin, f2, this.f7544b + r8, f3, this.f7550h);
            canvas.drawRect((childAt.getLeft() - ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin) - this.f7544b, f2, r5 + r4, f3, this.f7550h);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
        int i2 = this.f7546d;
        if (childAdapterPosition < i2 || childAdapterPosition == this.f7547e) {
            return;
        }
        int i3 = this.f7545c;
        rect.top = i3;
        rect.bottom = i3;
        if (i2 % 2 == 0) {
            if (childAdapterPosition % this.f7543a == 0) {
                int i4 = this.f7544b;
                rect.left = i4;
                rect.right = i4 / 2;
                return;
            } else {
                int i5 = this.f7544b;
                rect.left = i5 / 2;
                rect.right = i5;
                return;
            }
        }
        if (childAdapterPosition % 2 != 0) {
            int i6 = this.f7544b;
            rect.left = i6;
            rect.right = i6 / 2;
        } else {
            int i7 = this.f7544b;
            rect.left = i7 / 2;
            rect.right = i7;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        if (this.f7551i != null) {
            drawHorizontal(canvas, recyclerView);
        }
    }

    public void setDivider(Drawable drawable) {
        this.f7551i = drawable;
    }

    public void setDividerPaint(Paint paint) {
        this.f7549g = paint;
    }

    public void setOtherPosition(int i2) {
        this.f7547e = i2;
    }

    public void setSkipPosition(int i2) {
        this.f7546d = i2;
    }
}
