package com.tianmu.biz.widget.gravityrotation;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Build;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Sensor f11006a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Sensor f11007b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private float[] f11008c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private float[] f11009d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private GravityRotationView f11010e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private GravityRotationView f11011f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private SensorManager f11012g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private SensorEventListener f11013h = new C0191a();

    /* JADX INFO: renamed from: com.tianmu.biz.widget.gravityrotation.a$a, reason: collision with other inner class name */
    public class C0191a implements SensorEventListener {
        public C0191a() {
        }

        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int i2) {
        }

        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(SensorEvent sensorEvent) {
            int type = sensorEvent.sensor.getType();
            if (type == 1) {
                a.this.f11008c = sensorEvent.values;
                a.this.d();
            } else {
                if (type != 2) {
                    return;
                }
                a.this.f11009d = sensorEvent.values;
                a.this.d();
            }
        }
    }

    public a(Context context) {
        if (context != null) {
            SensorManager sensorManager = (SensorManager) context.getSystemService("sensor");
            this.f11012g = sensorManager;
            this.f11006a = sensorManager.getDefaultSensor(1);
            this.f11007b = this.f11012g.getDefaultSensor(2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        float[] fArr;
        float[] fArr2 = this.f11008c;
        if (fArr2 == null || (fArr = this.f11009d) == null) {
            return;
        }
        GravityRotationView gravityRotationView = this.f11010e;
        if (gravityRotationView != null) {
            gravityRotationView.a(fArr2, fArr);
        }
        GravityRotationView gravityRotationView2 = this.f11011f;
        if (gravityRotationView2 != null) {
            gravityRotationView2.a(this.f11008c, this.f11009d);
        }
    }

    public void c() {
        SensorManager sensorManager = this.f11012g;
        if (sensorManager != null) {
            sensorManager.unregisterListener(this.f11013h);
        }
    }

    public void b() {
        c();
        if (this.f11010e != null) {
            this.f11010e = null;
        }
        if (this.f11011f != null) {
            this.f11011f = null;
        }
    }

    public void a() {
        Sensor sensor;
        SensorManager sensorManager = this.f11012g;
        if (sensorManager == null || (sensor = this.f11006a) == null || this.f11007b == null) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 19) {
            sensorManager.registerListener(this.f11013h, sensor, 1, 1000);
            this.f11012g.registerListener(this.f11013h, this.f11007b, 1, 1000);
        } else {
            sensorManager.registerListener(this.f11013h, sensor, 1);
            this.f11012g.registerListener(this.f11013h, this.f11007b, 1);
        }
    }

    public void a(GravityRotationView gravityRotationView, GravityRotationView gravityRotationView2) {
        GravityRotationView gravityRotationView3 = this.f11010e;
        int scrollX = gravityRotationView3 != null ? gravityRotationView3.getScrollX() : 0;
        GravityRotationView gravityRotationView4 = this.f11010e;
        int scrollY = gravityRotationView4 != null ? gravityRotationView4.getScrollY() : 0;
        GravityRotationView gravityRotationView5 = this.f11011f;
        int scrollX2 = gravityRotationView5 != null ? gravityRotationView5.getScrollX() : 0;
        GravityRotationView gravityRotationView6 = this.f11011f;
        int scrollY2 = gravityRotationView6 != null ? gravityRotationView6.getScrollY() : 0;
        GravityRotationView gravityRotationView7 = this.f11010e;
        int iA = gravityRotationView7 != null ? gravityRotationView7.a() : 0;
        GravityRotationView gravityRotationView8 = this.f11010e;
        int iB = gravityRotationView8 != null ? gravityRotationView8.b() : 0;
        this.f11010e = gravityRotationView;
        this.f11011f = gravityRotationView2;
        if (gravityRotationView != null) {
            gravityRotationView.a(iA);
        }
        GravityRotationView gravityRotationView9 = this.f11010e;
        if (gravityRotationView9 != null) {
            gravityRotationView9.b(iB);
        }
        GravityRotationView gravityRotationView10 = this.f11011f;
        if (gravityRotationView10 != null) {
            gravityRotationView10.a(iA);
        }
        GravityRotationView gravityRotationView11 = this.f11011f;
        if (gravityRotationView11 != null) {
            gravityRotationView11.b(iB);
        }
        GravityRotationView gravityRotationView12 = this.f11010e;
        if (gravityRotationView12 != null) {
            gravityRotationView12.scrollTo(scrollX, scrollY);
        }
        GravityRotationView gravityRotationView13 = this.f11011f;
        if (gravityRotationView13 != null) {
            gravityRotationView13.scrollTo(scrollX2, scrollY2);
        }
    }
}
