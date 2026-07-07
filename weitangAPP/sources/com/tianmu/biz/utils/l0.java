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
public class l0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f10869a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private float f10870b = 0.0f;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private float f10871c = 0.0f;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private float f10872d = 0.0f;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f10873e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private SensorManager f10874f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Vibrator f10875g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private SensorEventListener f10876h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private Sensor f10877i;
    private b j;
    private double k;

    public class a implements SensorEventListener {
        public a() {
        }

        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int i2) {
        }

        @Override // android.hardware.SensorEventListener
        @SuppressLint({"MissingPermission"})
        public void onSensorChanged(SensorEvent sensorEvent) {
            if (l0.this.f10873e) {
                return;
            }
            try {
                float[] fArr = sensorEvent.values;
                float f2 = fArr[0];
                float f3 = fArr[1];
                float f4 = fArr[2];
                if (l0.this.f10870b == 0.0f && l0.this.f10871c == 0.0f && l0.this.f10872d == 0.0f) {
                    l0.this.f10870b = f2;
                    l0.this.f10871c = f3;
                    l0.this.f10872d = f4;
                    return;
                }
                float f5 = f2 - l0.this.f10870b;
                float f6 = f3 - l0.this.f10871c;
                float f7 = f4 - l0.this.f10872d;
                l0.this.f10870b = f2;
                l0.this.f10871c = f3;
                l0.this.f10872d = f4;
                if (Math.sqrt((f5 * f5) + (f6 * f6) + (f7 * f7)) > l0.this.f()) {
                    l0.this.g();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public interface b {
        void a();
    }

    public l0(Context context, double d2, b bVar) {
        this.f10869a = context;
        this.k = d2;
        this.j = bVar;
    }

    public static double a(double d2) {
        if (d2 < 6.5d || d2 > 26.0d) {
            return 13.0d;
        }
        return d2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        this.f10873e = true;
        b bVar = this.j;
        if (bVar != null) {
            bVar.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public double f() {
        double d2 = this.k;
        if (d2 > 0.0d) {
            return d2;
        }
        return 13.0d;
    }

    public void d() {
        Vibrator vibrator;
        Context context = this.f10869a;
        if (context == null || context.checkCallingOrSelfPermission("android.permission.VIBRATE") != 0 || (vibrator = this.f10875g) == null || !this.f10873e) {
            return;
        }
        vibrator.vibrate(new long[]{200, 300}, -1);
    }

    public void e() {
        this.f10873e = true;
    }

    public void a() {
        SensorEventListener sensorEventListener;
        SensorManager sensorManager = this.f10874f;
        if (sensorManager != null && (sensorEventListener = this.f10876h) != null) {
            sensorManager.unregisterListener(sensorEventListener, this.f10877i);
        }
        this.f10874f = null;
        this.f10876h = null;
        this.f10877i = null;
        Vibrator vibrator = this.f10875g;
        if (vibrator != null) {
            vibrator.cancel();
            this.f10875g = null;
        }
    }

    public void b() {
        this.f10870b = 0.0f;
        this.f10871c = 0.0f;
        this.f10872d = 0.0f;
        this.f10873e = false;
    }

    public void c() {
        this.f10876h = new a();
        if (this.f10874f == null) {
            this.f10874f = (SensorManager) this.f10869a.getSystemService("sensor");
        }
        if (this.f10869a.checkCallingOrSelfPermission("android.permission.VIBRATE") == 0 && this.f10875g == null) {
            this.f10875g = (Vibrator) this.f10869a.getSystemService("vibrator");
        }
        Sensor defaultSensor = this.f10874f.getDefaultSensor(1);
        this.f10877i = defaultSensor;
        if (Build.VERSION.SDK_INT >= 19) {
            this.f10874f.registerListener(this.f10876h, defaultSensor, 3, 50000);
        } else {
            this.f10874f.registerListener(this.f10876h, defaultSensor, 3);
        }
    }
}
