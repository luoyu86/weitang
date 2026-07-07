package g.a.c;

import java.util.ArrayList;
import java.util.Enumeration;

/* JADX INFO: loaded from: classes2.dex */
public class y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public g.a.a.i3.p f13706a;

    public y(g.a.a.i3.p pVar) {
        this.f13706a = pVar;
    }

    public g.a.j.n getCRLs() {
        g.a.a.f0 cRLs = this.f13706a.getCRLs();
        if (cRLs == null) {
            return new g.a.j.c(new ArrayList());
        }
        ArrayList arrayList = new ArrayList(cRLs.size());
        Enumeration objects = cRLs.getObjects();
        while (objects.hasMoreElements()) {
            g.a.a.a0 aSN1Primitive = ((g.a.a.g) objects.nextElement()).toASN1Primitive();
            if (aSN1Primitive instanceof g.a.a.d0) {
                arrayList.add(new g.a.b.e(g.a.a.y3.c.getInstance(aSN1Primitive)));
            }
        }
        return new g.a.j.c(arrayList);
    }

    public g.a.j.n getCertificates() {
        g.a.a.f0 certificates = this.f13706a.getCertificates();
        if (certificates == null) {
            return new g.a.j.c(new ArrayList());
        }
        ArrayList arrayList = new ArrayList(certificates.size());
        Enumeration objects = certificates.getObjects();
        while (objects.hasMoreElements()) {
            g.a.a.a0 aSN1Primitive = ((g.a.a.g) objects.nextElement()).toASN1Primitive();
            if (aSN1Primitive instanceof g.a.a.d0) {
                arrayList.add(new g.a.b.f(g.a.a.y3.b.getInstance(aSN1Primitive)));
            }
        }
        return new g.a.j.c(arrayList);
    }

    public g.a.a.i3.p toASN1Structure() {
        return this.f13706a;
    }
}
