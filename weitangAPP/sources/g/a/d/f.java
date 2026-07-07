package g.a.d;

import java.security.SecureRandom;

/* JADX INFO: loaded from: classes2.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public SecureRandom f13729a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f13730b;

    public f(SecureRandom secureRandom, int i2) {
        this.f13729a = c.getSecureRandom(secureRandom);
        this.f13730b = i2;
    }

    public SecureRandom getRandom() {
        return this.f13729a;
    }

    public int getStrength() {
        return this.f13730b;
    }
}
