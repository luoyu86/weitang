package anet.channel.monitor;

/* JADX INFO: loaded from: classes.dex */
public class e {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private double f516b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private double f517c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private double f518d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private double f519e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private double f520f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private double f521g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private double f522h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f515a = 0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private double f523i = 0.0d;
    private double j = 0.0d;
    private double k = 0.0d;

    public double a(double d2, double d3) {
        double d4 = d2 / d3;
        if (d4 < 8.0d) {
            if (this.f515a != 0) {
                return this.k;
            }
            this.k = d4;
            return d4;
        }
        long j = this.f515a;
        if (j == 0) {
            this.f523i = d4;
            this.f522h = d4;
            this.f518d = d4 * 0.1d;
            this.f517c = 0.02d * d4;
            this.f519e = 0.1d * d4 * d4;
        } else if (j == 1) {
            this.j = d4;
            this.f522h = d4;
        } else {
            double d5 = this.j;
            double d6 = d4 - d5;
            this.f523i = d5;
            this.j = d4;
            double d7 = d4 / 0.95d;
            this.f516b = d7;
            this.f521g = d7 - (this.f522h * 0.95d);
            char c2 = 0;
            double dSqrt = Math.sqrt(this.f518d);
            double d8 = this.f521g;
            if (d8 >= 4.0d * dSqrt) {
                this.f521g = (d8 * 0.75d) + (dSqrt * 2.0d);
                c2 = 1;
            } else if (d8 <= (-4.0d) * dSqrt) {
                this.f521g = (dSqrt * (-1.0d)) + (d8 * 0.75d);
                c2 = 2;
            }
            double d9 = this.f518d * 1.05d;
            double d10 = this.f521g;
            double dMin = Math.min(Math.max(Math.abs(d9 - ((0.0025d * d10) * d10)), this.f518d * 0.8d), this.f518d * 1.25d);
            this.f518d = dMin;
            double d11 = this.f519e;
            double d12 = d11 / ((0.9025d * d11) + dMin);
            this.f520f = d12;
            double d13 = this.f522h + (1.0526315789473684d * d6) + (d12 * this.f521g);
            this.f522h = d13;
            if (c2 == 1) {
                this.f522h = Math.min(d13, this.f516b);
            } else if (c2 == 2) {
                this.f522h = Math.max(d13, this.f516b);
            }
            this.f519e = (1.0d - (0.95d * this.f520f)) * (this.f519e + this.f517c);
        }
        double d14 = this.f522h;
        if (d14 < 0.0d) {
            double d15 = this.j * 0.7d;
            this.k = d15;
            this.f522h = d15;
        } else {
            this.k = d14;
        }
        return this.k;
    }

    public void a() {
        this.f515a = 0L;
        this.k = 0.0d;
    }
}
