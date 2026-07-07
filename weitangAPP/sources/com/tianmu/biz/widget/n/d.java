package com.tianmu.biz.widget.n;

import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Vibrator;
import android.util.Property;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.tianmu.biz.widget.n.a;
import com.tianmu.c.f.c1;
import com.tianmu.c.f.y0;
import com.tianmu.utils.TianmuDisplayUtil;

/* JADX INFO: loaded from: classes2.dex */
public class d extends com.tianmu.biz.widget.n.a {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private SensorManager f11125g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private Vibrator f11126h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f11127i;
    private SensorEventListener j;
    private Sensor k;
    private float l;
    private float m;
    private float n;
    private double o;
    private RelativeLayout p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private ImageView f11128q;
    private ObjectAnimator r;
    private ObjectAnimator s;
    private ObjectAnimator t;
    private int u;
    private int v;
    private int w;
    private int x;
    private boolean y;
    private Handler z;

    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            d dVar;
            a.InterfaceC0198a interfaceC0198a;
            if (message.what == 2 && (interfaceC0198a = (dVar = d.this).f11110b) != null) {
                interfaceC0198a.onClick(dVar, 5);
            }
            super.handleMessage(message);
        }
    }

    public class b implements SensorEventListener {
        public b() {
        }

        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int i2) {
        }

        @Override // android.hardware.SensorEventListener
        @SuppressLint({"MissingPermission"})
        public void onSensorChanged(SensorEvent sensorEvent) {
            if (d.this.f11127i) {
                return;
            }
            if (d.this.u <= 3 && d.this.m == -361.0f) {
                d.c(d.this);
                return;
            }
            try {
                float[] fArr = sensorEvent.values;
                if (sensorEvent.sensor.getType() == 3) {
                    float f2 = fArr[0];
                    float f3 = fArr[1];
                    float f4 = fArr[2];
                    if (f2 == 0.0f && f3 == 0.0f && f4 == 0.0f) {
                        return;
                    }
                    float f5 = d.this.f();
                    if (d.this.m == -361.0f && d.this.n == -361.0f) {
                        d.this.m = f2;
                        if (f2 > 360.0f - f5 || f2 < f5) {
                            d.this.l = f5 * 2.0f;
                            d dVar = d.this;
                            dVar.m = (dVar.m + d.this.l) % 360.0f;
                        }
                        d.this.n = f4;
                        return;
                    }
                    if (d.this.l > 0.0f) {
                        f2 = (f2 + d.this.l) % 360.0f;
                    }
                    float f6 = d.this.m - f2;
                    float f7 = d.this.n - f4;
                    if (Math.abs(f6) > Math.abs(f7)) {
                        f7 = f6;
                    }
                    if (f7 == f6) {
                        f7 = -f7;
                    }
                    if (Math.abs(f7) <= f5) {
                        d.this.a(f7);
                        return;
                    }
                    if (f7 > f5) {
                        d dVar2 = d.this;
                        dVar2.a(dVar2.f());
                        d.this.i();
                    } else {
                        d dVar3 = d.this;
                        dVar3.a(-dVar3.f());
                        d.this.i();
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public d(Context context, boolean z, boolean z2, String str) {
        super(context, z2);
        this.l = 0.0f;
        this.m = -361.0f;
        this.n = -361.0f;
        this.o = 0.0d;
        this.u = 1;
        this.v = 102;
        this.w = 64;
        this.x = 102;
        this.y = true;
        this.z = new a(Looper.getMainLooper());
        this.f11113e = TTDownloadField.CALL_DOWNLOAD_MODEL_SET_VERSION_NAME;
        this.f11114f = str;
        this.y = z;
        if (z) {
            this.x = this.v;
        } else {
            this.x = this.w;
        }
        e();
    }

    public static /* synthetic */ int c(d dVar) {
        int i2 = dVar.u;
        dVar.u = i2 + 1;
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        Vibrator vibrator;
        Handler handler = this.z;
        if (handler != null) {
            this.f11127i = true;
            handler.sendEmptyMessageDelayed(2, 100L);
            if (getContext().checkCallingOrSelfPermission("android.permission.VIBRATE") != 0 || (vibrator = this.f11126h) == null || this.z == null || !this.f11127i) {
                return;
            }
            vibrator.vibrate(new long[]{200, 300}, -1);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        h();
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (!z) {
            this.f11127i = true;
        } else if (this.f11127i) {
            this.f11127i = false;
            g();
        }
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i2) {
        super.onWindowVisibilityChanged(i2);
        if (i2 == 8) {
            this.f11127i = true;
        } else if (this.f11127i) {
            this.f11127i = false;
            g();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float f() {
        double d2 = this.o;
        if (d2 > 0.0d) {
            return (float) d2;
        }
        return 24.0f;
    }

    private void g() {
        this.l = 0.0f;
        this.m = -361.0f;
        this.n = -361.0f;
        this.u = 1;
        d();
        this.p.setRotation(0.0f);
        this.f11128q.setRotation(0.0f);
        this.f11128q.setTranslationX(0.0f);
    }

    private void h() {
        if (this.j == null) {
            this.j = new b();
        }
        if (this.f11125g == null) {
            Context context = getContext();
            getContext();
            this.f11125g = (SensorManager) context.getSystemService("sensor");
        }
        if (getContext().checkCallingOrSelfPermission("android.permission.VIBRATE") == 0 && this.f11126h == null) {
            this.f11126h = (Vibrator) getContext().getSystemService("vibrator");
        }
        Sensor defaultSensor = this.f11125g.getDefaultSensor(3);
        this.k = defaultSensor;
        if (Build.VERSION.SDK_INT >= 19) {
            this.f11125g.registerListener(this.j, defaultSensor, 3, 50000);
        } else {
            this.f11125g.registerListener(this.j, defaultSensor, 3);
        }
    }

    public void e() {
        LayoutInflater layoutInflater = (LayoutInflater) getContext().getSystemService("layout_inflater");
        if (this.y) {
            this.f11109a = layoutInflater.inflate(y0.f11554a, (ViewGroup) this, true);
        } else {
            this.f11109a = layoutInflater.inflate(y0.f11555b, (ViewGroup) this, true);
        }
        this.p = (RelativeLayout) this.f11109a.findViewById(y0.f11556c);
        this.f11128q = (ImageView) this.f11109a.findViewById(y0.f11557d);
        a(a(5, 0, this.f11114f, c1.f11295c));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(float f2) {
        if (Math.abs(f2) <= 0.8d) {
            return;
        }
        float fAbs = Math.abs(f2) / f();
        float fFloatValue = 0.0f;
        float f3 = 12.0f * fAbs;
        float fDp2px = TianmuDisplayUtil.dp2px(this.x) * fAbs;
        float f4 = fAbs * 360.0f;
        if (!(f2 > 0.0f)) {
            f3 = -f3;
            fDp2px = -fDp2px;
            f4 = -f4;
        }
        ObjectAnimator objectAnimator = this.r;
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.p, (Property<RelativeLayout, Float>) View.ROTATION, (objectAnimator == null || !(objectAnimator.getAnimatedValue() instanceof Float)) ? 0.0f : ((Float) this.r.getAnimatedValue()).floatValue(), f3);
        this.r = objectAnimatorOfFloat;
        objectAnimatorOfFloat.setInterpolator(new LinearInterpolator());
        this.r.setDuration(200L);
        this.r.start();
        ObjectAnimator objectAnimator2 = this.s;
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.f11128q, (Property<ImageView, Float>) View.TRANSLATION_X, (objectAnimator2 == null || !(objectAnimator2.getAnimatedValue() instanceof Float)) ? 0.0f : ((Float) this.s.getAnimatedValue()).floatValue(), fDp2px);
        this.s = objectAnimatorOfFloat2;
        objectAnimatorOfFloat2.setInterpolator(new LinearInterpolator());
        this.s.setDuration(200L);
        this.s.start();
        ObjectAnimator objectAnimator3 = this.t;
        if (objectAnimator3 != null && (objectAnimator3.getAnimatedValue() instanceof Float)) {
            fFloatValue = ((Float) this.t.getAnimatedValue()).floatValue();
        }
        ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(this.f11128q, (Property<ImageView, Float>) View.ROTATION, fFloatValue, f4);
        this.t = objectAnimatorOfFloat3;
        objectAnimatorOfFloat3.setInterpolator(new LinearInterpolator());
        this.t.setDuration(200L);
        this.t.start();
    }

    @Override // com.tianmu.biz.widget.n.a
    public void b(boolean z) {
        if (z) {
            this.f11113e = TTDownloadField.CALL_DOWNLOAD_MODEL_SET_VERSION_NAME;
        } else {
            this.f11113e = 130;
        }
    }

    @Override // com.tianmu.biz.widget.n.a
    public void c() {
        try {
            this.f11113e = 90;
            TextView textView = this.f11111c;
            if (textView != null) {
                textView.setTextSize(17.0f);
            }
        } catch (Exception unused) {
        }
    }

    @Override // com.tianmu.biz.widget.n.a
    public void d() {
        ObjectAnimator objectAnimator = this.r;
        if (objectAnimator != null && objectAnimator.isRunning()) {
            this.r.end();
        }
        ObjectAnimator objectAnimator2 = this.s;
        if (objectAnimator2 != null && objectAnimator2.isRunning()) {
            this.s.end();
        }
        ObjectAnimator objectAnimator3 = this.t;
        if (objectAnimator3 != null && objectAnimator3.isRunning()) {
            this.t.end();
        }
        this.p.clearAnimation();
        this.f11128q.clearAnimation();
        this.r = null;
        this.s = null;
        this.t = null;
    }

    @Override // com.tianmu.biz.widget.n.a
    public void b() {
        SensorEventListener sensorEventListener;
        super.b();
        Handler handler = this.z;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.z = null;
        }
        SensorManager sensorManager = this.f11125g;
        if (sensorManager != null && (sensorEventListener = this.j) != null) {
            sensorManager.unregisterListener(sensorEventListener, this.k);
        }
        this.f11125g = null;
        this.j = null;
        this.k = null;
        d();
        Vibrator vibrator = this.f11126h;
        if (vibrator != null) {
            vibrator.cancel();
            this.f11126h = null;
        }
    }

    @Override // com.tianmu.biz.widget.n.a
    public void a(double d2) {
        double d3 = (d2 / 13.0d) * 24.0d;
        if (d3 >= 12.0d && d3 <= 48.0d) {
            this.o = d3;
        } else {
            this.o = 24.0d;
        }
    }
}
