package com.tianmu.biz.widget.roundimage;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.tianmu.utils.TianmuDisplayUtil;

/* JADX INFO: loaded from: classes2.dex */
public class RoundImageView extends ImageView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f11160a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Paint f11161b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Matrix f11162c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private BitmapShader f11163d;

    public RoundImageView(Context context) {
        this(context, null);
    }

    public void a(int i2) {
        this.f11160a = i2;
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        if (getDrawable() == null) {
            return;
        }
        Bitmap bitmapA = a(getDrawable());
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        this.f11163d = new BitmapShader(bitmapA, tileMode, tileMode);
        float fMax = (bitmapA.getWidth() == getWidth() && bitmapA.getHeight() == getHeight()) ? 1.0f : Math.max((getWidth() * 1.0f) / bitmapA.getWidth(), (getHeight() * 1.0f) / bitmapA.getHeight());
        this.f11162c.setScale(fMax, fMax);
        this.f11163d.setLocalMatrix(this.f11162c);
        this.f11161b.setShader(this.f11163d);
        RectF rectF = new RectF(0.0f, 0.0f, getWidth(), getHeight());
        float f2 = this.f11160a;
        canvas.drawRoundRect(rectF, f2, f2, this.f11161b);
    }

    public RoundImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private Bitmap a(Drawable drawable) {
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        int width = drawable.getIntrinsicWidth() <= 0 ? getWidth() : drawable.getIntrinsicWidth();
        int height = drawable.getIntrinsicHeight() <= 0 ? getHeight() : drawable.getIntrinsicHeight();
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        drawable.setBounds(0, 0, width, height);
        drawable.draw(canvas);
        return bitmapCreateBitmap;
    }

    public RoundImageView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f11160a = TianmuDisplayUtil.dp2px(20);
        this.f11162c = new Matrix();
        Paint paint = new Paint();
        this.f11161b = paint;
        paint.setAntiAlias(true);
    }
}
