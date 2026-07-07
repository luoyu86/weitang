package c.h.a.a.a;

/* JADX INFO: loaded from: classes2.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Character f2536a = 'c';

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Character f2537b = 'M';

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final StringBuilder f2538c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Integer f2539d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final e f2540e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public e f2541f;

    public d(e eVar, Integer num) {
        this.f2539d = num;
        this.f2540e = eVar;
        this.f2541f = eVar;
        StringBuilder sb = new StringBuilder();
        this.f2538c = sb;
        sb.append(f2536a);
    }

    public final String a(e eVar, e eVar2, e eVar3) {
        String str = eVar.toRelativeCoordinates(this.f2541f) + " " + eVar2.toRelativeCoordinates(this.f2541f) + " " + eVar3.toRelativeCoordinates(this.f2541f) + " ";
        return "c0 0 0 0 0 0".equals(str) ? "" : str;
    }

    public d append(e eVar, e eVar2, e eVar3) {
        this.f2538c.append(a(eVar, eVar2, eVar3));
        this.f2541f = eVar3;
        return this;
    }

    public final e getLastPoint() {
        return this.f2541f;
    }

    public final Integer getStrokeWidth() {
        return this.f2539d;
    }

    public String toString() {
        return "<path stroke-width=\"" + this.f2539d + "\" d=\"" + f2537b + this.f2540e + ((CharSequence) this.f2538c) + "\"/>";
    }
}
