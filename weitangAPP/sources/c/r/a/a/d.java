package c.r.a.a;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.util.Log;
import java.util.Calendar;

/* JADX INFO: loaded from: classes2.dex */
public class d implements SensorEventListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static d f3144a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public SensorManager f3145b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Sensor f3146c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f3147d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f3148e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f3149f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Calendar f3151h;
    public a n;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f3150g = 0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f3152i = 1;
    public boolean j = false;
    public boolean k = false;
    public boolean l = false;
    public int m = 0;

    public interface a {
        void onFocus();
    }

    public d(Context context) {
        SensorManager sensorManager = (SensorManager) context.getSystemService("sensor");
        this.f3145b = sensorManager;
        this.f3146c = sensorManager.getDefaultSensor(1);
    }

    public static d getInstance(Context context) {
        if (f3144a == null) {
            f3144a = new d(context);
        }
        return f3144a;
    }

    public final void a() {
        this.m = 0;
        this.k = false;
        this.f3147d = 0;
        this.f3148e = 0;
        this.f3149f = 0;
    }

    public boolean isFocusLocked() {
        return this.l && this.f3152i <= 0;
    }

    public void lockFocus() {
        this.j = true;
        this.f3152i--;
        Log.i("SensorControler", "lockFocus");
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i2) {
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        Sensor sensor = sensorEvent.sensor;
        if (sensor == null) {
            return;
        }
        if (this.j) {
            a();
            return;
        }
        if (sensor.getType() == 1) {
            float[] fArr = sensorEvent.values;
            int i2 = (int) fArr[0];
            int i3 = (int) fArr[1];
            int i4 = (int) fArr[2];
            Calendar calendar = Calendar.getInstance();
            this.f3151h = calendar;
            long timeInMillis = calendar.getTimeInMillis();
            this.f3151h.get(13);
            if (this.m != 0) {
                int iAbs = Math.abs(this.f3147d - i2);
                int iAbs2 = Math.abs(this.f3148e - i3);
                int iAbs3 = Math.abs(this.f3149f - i4);
                if (Math.sqrt((iAbs * iAbs) + (iAbs2 * iAbs2) + (iAbs3 * iAbs3)) > 1.4d) {
                    this.m = 2;
                } else {
                    if (this.m == 2) {
                        this.f3150g = timeInMillis;
                        this.k = true;
                    }
                    if (this.k && timeInMillis - this.f3150g > 500 && !this.j) {
                        this.k = false;
                        a aVar = this.n;
                        if (aVar != null) {
                            aVar.onFocus();
                        }
                    }
                    this.m = 1;
                }
            } else {
                this.f3150g = timeInMillis;
                this.m = 1;
            }
            this.f3147d = i2;
            this.f3148e = i3;
            this.f3149f = i4;
        }
    }

    public void onStart() {
        a();
        this.l = true;
        this.f3145b.registerListener(this, this.f3146c, 3);
    }

    public void onStop() {
        this.n = null;
        this.f3145b.unregisterListener(this, this.f3146c);
        this.l = false;
    }

    public void restFoucs() {
        this.f3152i = 1;
    }

    public void setCameraFocusListener(a aVar) {
        this.n = aVar;
    }

    public void unlockFocus() {
        this.j = false;
        this.f3152i++;
        Log.i("SensorControler", "unlockFocus");
    }
}
