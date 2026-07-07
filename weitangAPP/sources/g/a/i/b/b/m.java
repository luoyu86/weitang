package g.a.i.b.b;

/* JADX INFO: loaded from: classes3.dex */
public class m implements g.a.d.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f14325a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final i f14326b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final u f14327c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final byte[][] f14328d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final j f14329e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Object f14330f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public t[] f14331g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public volatile g.a.d.e f14332h;

    public m(i iVar, u uVar, g.a.d.e eVar, byte[] bArr, byte[][] bArr2) {
        this.f14326b = iVar;
        this.f14327c = uVar;
        this.f14332h = eVar;
        this.f14325a = bArr;
        this.f14328d = bArr2;
        this.f14329e = null;
        this.f14330f = null;
    }

    public m(j jVar, Object obj, g.a.d.e eVar) {
        this.f14329e = jVar;
        this.f14330f = obj;
        this.f14332h = eVar;
        this.f14325a = null;
        this.f14326b = null;
        this.f14327c = null;
        this.f14328d = null;
    }

    public byte[] a() {
        return this.f14325a;
    }

    public byte[][] b() {
        return this.f14328d;
    }

    public i c() {
        return this.f14326b;
    }

    public byte[] d() {
        byte[] bArr = new byte[34];
        this.f14332h.doFinal(bArr, 0);
        this.f14332h = null;
        return bArr;
    }

    @Override // g.a.d.e
    public int doFinal(byte[] bArr, int i2) {
        return this.f14332h.doFinal(bArr, i2);
    }

    public u e() {
        return this.f14327c;
    }

    public t[] f() {
        return this.f14331g;
    }

    public m g(t[] tVarArr) {
        this.f14331g = tVarArr;
        return this;
    }

    @Override // g.a.d.e
    public String getAlgorithmName() {
        return this.f14332h.getAlgorithmName();
    }

    @Override // g.a.d.e
    public int getDigestSize() {
        return this.f14332h.getDigestSize();
    }

    public j getPublicKey() {
        return this.f14329e;
    }

    public Object getSignature() {
        return this.f14330f;
    }

    @Override // g.a.d.e
    public void reset() {
        this.f14332h.reset();
    }

    @Override // g.a.d.e
    public void update(byte b2) {
        this.f14332h.update(b2);
    }

    @Override // g.a.d.e
    public void update(byte[] bArr, int i2, int i3) {
        this.f14332h.update(bArr, i2, i3);
    }
}
