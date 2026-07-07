package c.h.a.a.a;

/* JADX INFO: loaded from: classes2.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f2544a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f2545b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f2546c;

    public float distanceTo(f fVar) {
        return (float) Math.sqrt(Math.pow(fVar.f2544a - this.f2544a, 2.0d) + Math.pow(fVar.f2545b - this.f2545b, 2.0d));
    }

    public f set(float f2, float f3) {
        this.f2544a = f2;
        this.f2545b = f3;
        this.f2546c = System.currentTimeMillis();
        return this;
    }

    public float velocityFrom(f fVar) {
        float fDistanceTo = distanceTo(fVar) / (this.f2546c - fVar.f2546c);
        if (fDistanceTo != fDistanceTo) {
            return 0.0f;
        }
        return fDistanceTo;
    }
}
