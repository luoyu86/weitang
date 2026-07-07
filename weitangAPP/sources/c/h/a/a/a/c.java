package c.h.a.a.a;

/* JADX INFO: loaded from: classes2.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final StringBuilder f2534a = new StringBuilder();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public d f2535b = null;

    public final void a() {
        this.f2534a.append(this.f2535b);
    }

    public c append(a aVar, float f2) {
        Integer numValueOf = Integer.valueOf(Math.round(f2));
        e eVar = new e(aVar.f2528a);
        e eVar2 = new e(aVar.f2529b);
        e eVar3 = new e(aVar.f2530c);
        e eVar4 = new e(aVar.f2531d);
        if (!b()) {
            c(numValueOf, eVar);
        }
        if (!eVar.equals(this.f2535b.getLastPoint()) || !numValueOf.equals(this.f2535b.getStrokeWidth())) {
            a();
            c(numValueOf, eVar);
        }
        this.f2535b.append(eVar2, eVar3, eVar4);
        return this;
    }

    public final boolean b() {
        return this.f2535b != null;
    }

    public String build(int i2, int i3) {
        if (b()) {
            a();
        }
        return "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>\n<svg xmlns=\"http://www.w3.org/2000/svg\" version=\"1.2\" baseProfile=\"tiny\" height=\"" + i3 + "\" width=\"" + i2 + "\"><g stroke-linejoin=\"round\" stroke-linecap=\"round\" fill=\"none\" stroke=\"black\">" + ((CharSequence) this.f2534a) + "</g></svg>";
    }

    public final void c(Integer num, e eVar) {
        this.f2535b = new d(eVar, num);
    }

    public void clear() {
        this.f2534a.setLength(0);
        this.f2535b = null;
    }
}
