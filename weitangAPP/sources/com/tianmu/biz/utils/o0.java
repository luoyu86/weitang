package com.tianmu.biz.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Build;
import android.os.Vibrator;

/* JADX INFO: loaded from: classes2.dex */
public class o0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f10883a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f10884b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private SensorManager f10885c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Vibrator f10886d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private SensorEventListener f10887e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Sensor f10888f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private b f10890h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private double f10891i;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f10889g = 1;
    private float j = 0.0f;
    private float k = -361.0f;
    private float l = -361.0f;

    public class a implements SensorEventListener {
        public a() {
        }

        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int i2) {
        }

        @Override // android.hardware.SensorEventListener
        @SuppressLint({"MissingPermission"})
        public void onSensorChanged(SensorEvent sensorEvent) {
            if (o0.this.f10884b) {
                return;
            }
            if (o0.this.f10889g <= 3 && o0.this.k == -361.0f) {
                o0.c(o0.this);
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
                    float fA = o0.this.a();
                    if (o0.this.k == -361.0f && o0.this.l == -361.0f) {
                        o0.this.k = f2;
                        if (f2 > 360.0f - fA || f2 < fA) {
                            o0.this.j = fA * 2.0f;
                            o0 o0Var = o0.this;
                            o0Var.k = (o0Var.k + o0.this.j) % 360.0f;
                        }
                        o0.this.l = f4;
                        return;
                    }
                    if (o0.this.j > 0.0f) {
                        f2 = (f2 + o0.this.j) % 360.0f;
                    }
                    float f5 = o0.this.k - f2;
                    float f6 = o0.this.l - f4;
                    if (Math.abs(f5) > Math.abs(f6)) {
                        f6 = f5;
                    }
                    if (f6 == f5) {
                        f6 = -f6;
                    }
                    if (Math.abs(f6) <= fA) {
                        if (o0.this.f10890h != null) {
                            o0.this.f10890h.a(f6);
                        }
                    } else if (f6 > fA) {
                        if (o0.this.f10890h != null) {
                            o0.this.f10890h.a(o0.this.a());
                        }
                        o0.this.g();
                    } else {
                        if (o0.this.f10890h != null) {
                            o0.this.f10890h.a(-o0.this.a());
                        }
                        o0.this.g();
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public interface b {
        void a();

        void a(float f2);
    }

    public o0(Context context, double d2, b bVar) {
        this.f10883a = context;
        this.f10891i = d2;
        this.f10890h = bVar;
    }

    public static double a(double d2) {
        double d3 = (d2 / 13.0d) * 24.0d;
        if (d3 < 12.0d || d3 > 48.0d) {
            return 24.0d;
        }
        return d3;
    }

    public static /* synthetic */ int c(o0 o0Var) {
        int i2 = o0Var.f10889g;
        o0Var.f10889g = i2 + 1;
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        this.f10884b = true;
        b bVar = this.f10890h;
        if (bVar != null) {
            bVar.a();
        }
    }

    public void d() {
        this.f10887e = new a();
        if (this.f10885c == null) {
            this.f10885c = (SensorManager) this.f10883a.getSystemService("sensor");
        }
        if (this.f10883a.checkCallingOrSelfPermission("android.permission.VIBRATE") == 0 && this.f10886d == null) {
            this.f10886d = (Vibrator) this.f10883a.getSystemService("vibrator");
        }
        Sensor defaultSensor = this.f10885c.getDefaultSensor(3);
        this.f10888f = defaultSensor;
        if (Build.VERSION.SDK_INT >= 19) {
            this.f10885c.registerListener(this.f10887e, defaultSensor, 3, 50000);
        } else {
            this.f10885c.registerListener(this.f10887e, defaultSensor, 3);
        }
    }

    public void e() {
        Vibrator vibrator;
        Context context = this.f10883a;
        if (context == null || context.checkCallingOrSelfPermission("android.permission.VIBRATE") != 0 || (vibrator = this.f10886d) == null || !this.f10884b) {
            return;
        }
        vibrator.vibrate(new long[]{200, 300}, -1);
    }

    public void f() {
        this.f10884b = true;
    }

    public float a() {
        double d2 = this.f10891i;
        if (d2 > 0.0d) {
            return (float) d2;
        }
        return 24.0f;
    }

    public void b() {
        SensorEventListener sensorEventListener;
        SensorManager sensorManager = this.f10885c;
        if (sensorManager != null && (sensorEventListener = this.f10887e) != null) {
            sensorManager.unregisterListener(sensorEventListener, this.f10888f);
        }
        this.f10885c = null;
        this.f10887e = null;
        this.f10888f = null;
        Vibrator vibrator = this.f10886d;
        if (vibrator != null) {
            vibrator.cancel();
            this.f10886d = null;
        }
    }

    public void c() {
        this.j = 0.0f;
        this.k = -361.0f;
        this.l = -361.0f;
        this.f10889g = 1;
        this.f10884b = false;
    }
}
