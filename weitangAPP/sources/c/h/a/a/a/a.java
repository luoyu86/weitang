package c.h.a.a.a;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public f f2528a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public f f2529b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public f f2530c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public f f2531d;

    public float length() {
        double d2 = 0.0d;
        double d3 = 0.0d;
        float fSqrt = 0.0f;
        int i2 = 0;
        while (i2 <= 10) {
            float f2 = i2 / 10;
            double dPoint = point(f2, this.f2528a.f2544a, this.f2529b.f2544a, this.f2530c.f2544a, this.f2531d.f2544a);
            double dPoint2 = point(f2, this.f2528a.f2545b, this.f2529b.f2545b, this.f2530c.f2545b, this.f2531d.f2545b);
            if (i2 > 0) {
                double d4 = dPoint - d2;
                double d5 = dPoint2 - d3;
                fSqrt = (float) (((double) fSqrt) + Math.sqrt((d4 * d4) + (d5 * d5)));
            }
            i2++;
            d3 = dPoint2;
            d2 = dPoint;
        }
        return fSqrt;
    }

    public double point(float f2, float f3, float f4, float f5, float f6) {
        double d2 = f2;
        double d3 = 1.0d - d2;
        return (((double) f3) * d3 * d3 * d3) + (((double) f4) * 3.0d * d3 * d3 * d2) + (((double) f5) * 3.0d * d3 * d2 * d2) + ((double) (f6 * f2 * f2 * f2));
    }

    public a set(f fVar, f fVar2, f fVar3, f fVar4) {
        this.f2528a = fVar;
        this.f2529b = fVar2;
        this.f2530c = fVar3;
        this.f2531d = fVar4;
        return this;
    }
}
