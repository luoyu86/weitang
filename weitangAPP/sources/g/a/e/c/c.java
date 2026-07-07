package g.a.e.c;

import g.a.a.z3.k;
import java.security.spec.AlgorithmParameterSpec;

/* JADX INFO: loaded from: classes2.dex */
public class c implements AlgorithmParameterSpec {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f13846a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f13847b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AlgorithmParameterSpec f13848c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final g.a.a.y3.a f13849d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public byte[] f13850e;

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f13851a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f13852b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public AlgorithmParameterSpec f13853c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public g.a.a.y3.a f13854d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public byte[] f13855e;

        public b(String str, int i2) {
            this(str, i2, null);
        }

        public b(String str, int i2, byte[] bArr) {
            this.f13851a = str;
            this.f13852b = i2;
            this.f13854d = new g.a.a.y3.a(k.j5, new g.a.a.y3.a(g.a.a.q3.b.f13301c));
            this.f13855e = bArr == null ? new byte[0] : g.a.j.a.clone(bArr);
        }

        public c build() {
            return new c(this.f13851a, this.f13852b, this.f13853c, this.f13854d, this.f13855e);
        }

        public b withKdfAlgorithm(g.a.a.y3.a aVar) {
            this.f13854d = aVar;
            return this;
        }

        public b withParameterSpec(AlgorithmParameterSpec algorithmParameterSpec) {
            this.f13853c = algorithmParameterSpec;
            return this;
        }
    }

    public c(String str, int i2, AlgorithmParameterSpec algorithmParameterSpec, g.a.a.y3.a aVar, byte[] bArr) {
        this.f13846a = str;
        this.f13847b = i2;
        this.f13848c = algorithmParameterSpec;
        this.f13849d = aVar;
        this.f13850e = bArr;
    }

    public g.a.a.y3.a getKdfAlgorithm() {
        return this.f13849d;
    }

    public String getKeyAlgorithmName() {
        return this.f13846a;
    }

    public int getKeySize() {
        return this.f13847b;
    }

    public byte[] getOtherInfo() {
        return g.a.j.a.clone(this.f13850e);
    }

    public AlgorithmParameterSpec getParameterSpec() {
        return this.f13848c;
    }
}
