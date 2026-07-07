package com.chinavisionary.microtang.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.vo.StateVo;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class ExitStateView extends AppCompatTextView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Paint f8649a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Paint f8650b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f8651c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f8652d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f8653e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f8654f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public List<StateVo> f8655g;

    public ExitStateView(Context context) {
        super(context);
        b();
    }

    public final void a(Canvas canvas) {
        int i2;
        int i3;
        int i4;
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.dp_8);
        int i5 = (this.f8651c / 2) - dimensionPixelSize;
        int i6 = i5 + (dimensionPixelSize * 3);
        int size = this.f8655g.size();
        int i7 = this.f8652d;
        int i8 = dimensionPixelSize * 2 * size;
        int i9 = (i7 - i8) / size;
        int i10 = size - 1;
        int i11 = ((i7 / 2) - ((i8 + (i10 * i9)) / 2)) + dimensionPixelSize;
        int i12 = 0;
        int i13 = 0;
        while (i13 < size) {
            StateVo stateVo = this.f8655g.get(i13);
            boolean zIsOver = stateVo.isOver();
            this.f8649a.setColor(zIsOver ? this.f8653e : this.f8654f);
            this.f8650b.setColor(zIsOver ? this.f8653e : this.f8654f);
            int i14 = i13 == 0 ? i11 : i12 + dimensionPixelSize;
            float f2 = i5;
            canvas.drawCircle(i14, f2, dimensionPixelSize, this.f8649a);
            int i15 = i14 + dimensionPixelSize;
            int i16 = i15 + i9;
            if (i13 < i10) {
                i3 = i14;
                this.f8649a.setColor(this.f8655g.get(i13 + 1).isOver() ? this.f8653e : this.f8654f);
                i2 = i16;
                i4 = i13;
                canvas.drawLine(i15, f2, i16, f2, this.f8649a);
            } else {
                i2 = i16;
                i3 = i14;
                i4 = i13;
            }
            String title = stateVo.getTitle();
            this.f8650b.getTextBounds(title, 0, title.length(), new Rect());
            canvas.drawText(title, i3 - ((r2.right - r2.left) / 2), i6, this.f8650b);
            i13 = i4 + 1;
            i12 = i2;
        }
    }

    public final void b() {
        this.f8654f = getResources().getColor(R.color.colore757575);
        this.f8653e = getResources().getColor(R.color.tab_item_select_color);
        Paint paint = new Paint();
        this.f8649a = paint;
        paint.setColor(this.f8654f);
        this.f8649a.setAntiAlias(true);
        this.f8649a.setStyle(Paint.Style.STROKE);
        this.f8649a.setStrokeWidth(getResources().getDimensionPixelSize(R.dimen.dp_1));
        Paint paint2 = new Paint();
        this.f8650b = paint2;
        paint2.setColor(this.f8654f);
        this.f8650b.setAntiAlias(true);
        this.f8650b.setStyle(Paint.Style.FILL);
        this.f8650b.setTextSize(c(getContext(), 12.0f));
    }

    public final int c(Context context, float f2) {
        return (int) ((f2 * context.getResources().getDisplayMetrics().scaledDensity) + 0.5f);
    }

    @Override // android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f8655g != null) {
            a(canvas);
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        this.f8651c = i3;
        this.f8652d = i2;
    }

    public void setStateVoList(List<StateVo> list) {
        this.f8655g = list;
        postInvalidate();
    }

    public ExitStateView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        b();
    }

    public ExitStateView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        b();
    }
}
