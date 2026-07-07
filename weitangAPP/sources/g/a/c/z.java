package g.a.c;

import g.a.a.v1;

/* JADX INFO: loaded from: classes2.dex */
public interface z extends c0 {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f13707a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f13708b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final a f13709c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final a f13710d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final a f13711e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final String f13712f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final g.a.a.y3.a f13713g;

        static {
            g.a.a.v vVar = g.a.a.t3.a.e1;
            v1 v1Var = v1.f13368b;
            f13707a = new a("HMacSHA1", new g.a.a.y3.a(vVar, v1Var));
            f13708b = new a("HMacSHA224", new g.a.a.y3.a(g.a.a.t3.a.f1, v1Var));
            f13709c = new a("HMacSHA256", new g.a.a.y3.a(g.a.a.t3.a.g1, v1Var));
            f13710d = new a("HMacSHA384", new g.a.a.y3.a(g.a.a.t3.a.h1, v1Var));
            f13711e = new a("HMacSHA512", new g.a.a.y3.a(g.a.a.t3.a.i1, v1Var));
        }

        public a(String str, g.a.a.y3.a aVar) {
            this.f13712f = str;
            this.f13713g = aVar;
        }

        public g.a.a.y3.a getAlgorithmID() {
            return this.f13713g;
        }

        public String getName() {
            return this.f13712f;
        }
    }

    byte[] calculateDerivedKey(int i2, g.a.a.y3.a aVar, int i3) throws h;

    char[] getPassword();

    int getPasswordConversionScheme();

    h0 getRecipientOperator(g.a.a.y3.a aVar, g.a.a.y3.a aVar2, byte[] bArr, byte[] bArr2) throws h;
}
