package com.ss.android.downloadlib.guide.install;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.ImageView;

/* JADX INFO: loaded from: classes2.dex */
public class ClipImageView extends ImageView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Path f9861a;
    private RectF bl;
    private float[] n;
    private boolean ok;
    private Paint s;

    public ClipImageView(Context context) {
        super(context);
        this.ok = true;
        ok(context);
    }

    public void ok(Context context) {
        this.f9861a = new Path();
        this.bl = new RectF();
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        if (this.ok) {
            this.f9861a.reset();
            this.bl.set(0.0f, 0.0f, getWidth(), getHeight());
            float[] fArr = this.n;
            if (fArr != null) {
                this.f9861a.addRoundRect(this.bl, fArr, Path.Direction.CW);
            }
            canvas.setDrawFilter(new PaintFlagsDrawFilter(0, 3));
            canvas.clipPath(this.f9861a);
            Paint paint = this.s;
            if (paint != null) {
                canvas.drawPath(this.f9861a, paint);
            }
        }
        super.onDraw(canvas);
    }

    @Override // android.view.View
    public void setBackgroundColor(int i2) {
        Paint paint = new Paint(1);
        this.s = paint;
        paint.setStyle(Paint.Style.FILL);
        this.s.setColor(i2);
    }

    public void setClip(boolean z) {
        this.ok = z;
    }

    public void setRadius(float[] fArr) {
        if (fArr == null || fArr.length != 8) {
            return;
        }
        this.n = fArr;
    }

    public void setRoundRadius(int i2) {
        if (i2 > 0) {
            float f2 = i2;
            setRadius(new float[]{f2, f2, f2, f2, f2, f2, f2, f2});
        }
    }

    public ClipImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ok = true;
        ok(context);
    }

    public ClipImageView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.ok = true;
        ok(context);
    }
}
