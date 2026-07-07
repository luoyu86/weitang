package com.tianmu.biz.widget.m;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.view.MotionEvent;
import android.view.View;
import androidx.core.internal.view.SupportMenu;
import com.tianmu.utils.TianmuViewUtil;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public class a extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f11085a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f11086b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Bitmap f11087c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Bitmap f11088d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Paint f11089e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Canvas f11090f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private HashMap<Integer, b> f11091g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private Boolean f11092h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private InterfaceC0195a f11093i;
    private int j;
    private int k;

    /* JADX INFO: renamed from: com.tianmu.biz.widget.m.a$a, reason: collision with other inner class name */
    public interface InterfaceC0195a {
        void a();

        void b();

        void c();
    }

    public class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f11094a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f11095b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f11096c;

        public b(a aVar, int i2, int i3, long j) {
            this.f11095b = i2;
            this.f11096c = i3;
            this.f11094a = j;
        }
    }

    public a(Context context) {
        super(context);
        this.f11091g = new HashMap<>();
        this.f11092h = Boolean.TRUE;
    }

    private void d() {
        int width = this.f11088d.getWidth() * this.f11088d.getHeight();
        int[] iArr = new int[width];
        Bitmap bitmap = this.f11088d;
        bitmap.getPixels(iArr, 0, bitmap.getWidth(), 0, 0, this.f11088d.getWidth(), this.f11088d.getHeight());
        int i2 = 0;
        for (int i3 = 0; i3 < width; i3++) {
            if (iArr[i3] == 0) {
                i2++;
            }
        }
        if ((((double) i2) / ((double) width)) * 100.0d >= 8.0d) {
            InterfaceC0195a interfaceC0195a = this.f11093i;
            if (interfaceC0195a != null) {
                interfaceC0195a.b();
                return;
            }
            return;
        }
        InterfaceC0195a interfaceC0195a2 = this.f11093i;
        if (interfaceC0195a2 != null) {
            interfaceC0195a2.c();
        }
    }

    private boolean e() {
        return true;
    }

    public void a(Bitmap bitmap, int i2, int i3) {
        this.f11086b = i2;
        this.f11085a = i3;
        this.f11087c = Bitmap.createScaledBitmap(bitmap, i2, i3, true);
        b();
        a();
    }

    public void b() {
        Paint paint = new Paint();
        this.f11089e = paint;
        paint.setColor(SupportMenu.CATEGORY_MASK);
        this.f11089e.setStrokeWidth(100.0f);
        this.f11089e.setMaskFilter(new BlurMaskFilter(1.0f, BlurMaskFilter.Blur.NORMAL));
        this.f11089e.setStyle(Paint.Style.FILL);
        this.f11089e.setStrokeJoin(Paint.Join.ROUND);
        this.f11089e.setStrokeCap(Paint.Cap.ROUND);
        this.f11089e.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
    }

    public void c() {
        TianmuViewUtil.removeSelfFromParent(this);
        Bitmap bitmap = this.f11087c;
        if (bitmap != null) {
            bitmap.recycle();
            this.f11087c = null;
        }
        Bitmap bitmap2 = this.f11088d;
        if (bitmap2 != null) {
            bitmap2.recycle();
            this.f11088d = null;
        }
        HashMap<Integer, b> map = this.f11091g;
        if (map != null) {
            map.clear();
            this.f11091g = null;
        }
        this.f11089e = null;
        this.f11090f = null;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Bitmap bitmap;
        super.onDraw(canvas);
        if (!this.f11092h.booleanValue() || (bitmap = this.f11088d) == null) {
            return;
        }
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        MotionEvent motionEvent2 = motionEvent;
        if (!this.f11092h.booleanValue()) {
            return true;
        }
        int pointerCount = motionEvent.getPointerCount();
        HashMap<Integer, b> map = new HashMap<>();
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (this.f11090f != null) {
            int action = motionEvent.getAction();
            if (action == 0) {
                if (e()) {
                    getParent().requestDisallowInterceptTouchEvent(true);
                }
                this.j = (int) motionEvent.getX();
                this.k = (int) motionEvent.getY();
            } else if (action == 1) {
                getParent().requestDisallowInterceptTouchEvent(false);
                d();
                if (this.f11093i != null && Math.abs(this.j - motionEvent.getX()) < 10.0f && Math.abs(this.k - motionEvent.getY()) < 10.0f) {
                    this.f11093i.a();
                }
            } else if (action == 2) {
                int i2 = 0;
                while (i2 < pointerCount) {
                    int pointerId = motionEvent2.getPointerId(i2);
                    int x = (int) motionEvent2.getX(i2);
                    int y = (int) motionEvent2.getY(i2);
                    int i3 = pointerCount;
                    map.put(Integer.valueOf(pointerId), new b(this, x, y, jCurrentTimeMillis));
                    if (this.f11091g.containsKey(Integer.valueOf(pointerId))) {
                        if (jCurrentTimeMillis - this.f11091g.get(Integer.valueOf(pointerId)).f11094a < 150) {
                            this.f11090f.drawLine(r0.f11095b, r0.f11096c, x, y, this.f11089e);
                        }
                    }
                    i2++;
                    motionEvent2 = motionEvent;
                    pointerCount = i3;
                }
                this.f11091g = map;
            }
        }
        postInvalidate();
        return true;
    }

    public void a(InterfaceC0195a interfaceC0195a) {
        this.f11093i = interfaceC0195a;
    }

    public void a() {
        this.f11088d = Bitmap.createBitmap(this.f11086b, this.f11085a, Bitmap.Config.ARGB_4444);
        Canvas canvas = new Canvas(this.f11088d);
        this.f11090f = canvas;
        canvas.drawColor(0);
        this.f11090f.drawBitmap(this.f11087c, 0.0f, 0.0f, (Paint) null);
        Paint paint = new Paint();
        paint.setColor(Color.parseColor("#33000000"));
        this.f11090f.drawRect(0.0f, 0.0f, this.f11086b, this.f11085a, paint);
        this.f11090f.save();
        this.f11092h = Boolean.TRUE;
    }
}
