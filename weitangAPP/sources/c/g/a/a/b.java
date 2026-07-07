package c.g.a.a;

import android.graphics.PointF;
import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public class b implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f2521a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f2522b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f2523c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f2524d;

    public b(float f2, PointF pointF, int i2) {
        this.f2521a = f2;
        this.f2522b = pointF.x;
        this.f2523c = pointF.y;
        this.f2524d = i2;
    }

    public PointF getCenter() {
        return new PointF(this.f2522b, this.f2523c);
    }

    public int getOrientation() {
        return this.f2524d;
    }

    public float getScale() {
        return this.f2521a;
    }
}
