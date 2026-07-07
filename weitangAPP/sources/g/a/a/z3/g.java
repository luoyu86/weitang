package g.a.a.z3;

import g.a.a.a0;
import g.a.a.t;
import g.a.a.w;
import g.a.a.x1;

/* JADX INFO: loaded from: classes2.dex */
public class g extends t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final w f13585a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public g.a.g.a.e f13586b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public g.a.g.a.i f13587c;

    public g(g.a.g.a.e eVar, w wVar) {
        this(eVar, wVar.getOctets());
    }

    public g(g.a.g.a.e eVar, byte[] bArr) {
        this.f13586b = eVar;
        this.f13585a = new x1(g.a.j.a.clone(bArr));
    }

    public g(g.a.g.a.i iVar, boolean z) {
        this.f13587c = iVar.normalize();
        this.f13585a = new x1(iVar.getEncoded(z));
    }

    public synchronized g.a.g.a.i getPoint() {
        if (this.f13587c == null) {
            this.f13587c = this.f13586b.decodePoint(this.f13585a.getOctets()).normalize();
        }
        return this.f13587c;
    }

    public byte[] getPointEncoding() {
        return g.a.j.a.clone(this.f13585a.getOctets());
    }

    public boolean isPointCompressed() {
        byte[] octets = this.f13585a.getOctets();
        if (octets == null || octets.length <= 0) {
            return false;
        }
        return octets[0] == 2 || octets[0] == 3;
    }

    @Override // g.a.a.t, g.a.a.g
    public a0 toASN1Primitive() {
        return this.f13585a;
    }
}
