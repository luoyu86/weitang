package com.tianmu.biz.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.internal.view.SupportMenu;
import com.tianmu.utils.TianmuDisplayUtil;

/* JADX INFO: loaded from: classes2.dex */
public class EnvelopeView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f10947a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f10948b;

    public EnvelopeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f10947a = Color.parseColor("#FDE1C9");
        this.f10948b = Color.parseColor("#B1865D");
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float width = getWidth() / 2;
        float height = getHeight() / 2;
        float width2 = getWidth();
        float height2 = getHeight();
        float fDp2px = TianmuDisplayUtil.dp2px(20);
        Path path = new Path();
        path.moveTo(0.0f, 0.0f);
        float f2 = height - 50.0f;
        path.lineTo(width, f2);
        path.lineTo(width2, 0.0f);
        path.quadTo(width2, 0.0f, width2, 0.0f);
        float f3 = height2 - fDp2px;
        path.lineTo(width2, f3);
        path.quadTo(width2, height2, width2 - fDp2px, height2);
        float f4 = fDp2px + 0.0f;
        path.lineTo(f4, height2);
        path.quadTo(0.0f, height2, 0.0f, f3);
        path.lineTo(0.0f, f4);
        path.lineTo(0.0f, 0.0f);
        path.close();
        Paint paint = new Paint();
        paint.setShader(new LinearGradient(0.0f, 0.0f, 0.0f, getHeight(), this.f10947a, this.f10948b, Shader.TileMode.CLAMP));
        paint.setStyle(Paint.Style.FILL);
        paint.setAntiAlias(true);
        paint.setColor(SupportMenu.CATEGORY_MASK);
        paint.setStrokeWidth(5.0f);
        canvas.drawPath(path, paint);
        path.reset();
        path.moveTo(0.0f, 0.0f);
        path.lineTo(width, f2);
        path.lineTo(width2, 0.0f);
        Paint paint2 = new Paint();
        paint2.setAntiAlias(true);
        paint2.setColor(-1);
        paint2.setStyle(Paint.Style.STROKE);
        paint2.setStrokeWidth(5.0f);
        canvas.drawPath(path, paint2);
    }
}
