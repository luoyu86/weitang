package g.a.f.d;

import g.a.g.a.e;
import g.a.g.a.i;
import java.math.BigInteger;
import java.security.spec.AlgorithmParameterSpec;

/* JADX INFO: loaded from: classes2.dex */
public class c implements AlgorithmParameterSpec {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public e f13882a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public byte[] f13883b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public i f13884c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public BigInteger f13885d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public BigInteger f13886e;

    public c(e eVar, i iVar, BigInteger bigInteger) {
        this.f13882a = eVar;
        this.f13884c = iVar.normalize();
        this.f13885d = bigInteger;
        this.f13886e = BigInteger.valueOf(1L);
        this.f13883b = null;
    }

    public c(e eVar, i iVar, BigInteger bigInteger, BigInteger bigInteger2) {
        this.f13882a = eVar;
        this.f13884c = iVar.normalize();
        this.f13885d = bigInteger;
        this.f13886e = bigInteger2;
        this.f13883b = null;
    }

    public c(e eVar, i iVar, BigInteger bigInteger, BigInteger bigInteger2, byte[] bArr) {
        this.f13882a = eVar;
        this.f13884c = iVar.normalize();
        this.f13885d = bigInteger;
        this.f13886e = bigInteger2;
        this.f13883b = bArr;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return getCurve().equals(cVar.getCurve()) && getG().equals(cVar.getG());
    }

    public e getCurve() {
        return this.f13882a;
    }

    public i getG() {
        return this.f13884c;
    }

    public BigInteger getH() {
        return this.f13886e;
    }

    public BigInteger getN() {
        return this.f13885d;
    }

    public byte[] getSeed() {
        return this.f13883b;
    }

    public int hashCode() {
        return getCurve().hashCode() ^ getG().hashCode();
    }
}
