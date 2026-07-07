package anet.channel.util;

import java.net.Inet6Address;

/* JADX INFO: loaded from: classes.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f724a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Inet6Address f725b;

    public f(Inet6Address inet6Address, int i2) {
        this.f724a = i2;
        this.f725b = inet6Address;
    }

    public String toString() {
        return this.f725b.getHostAddress() + "/" + this.f724a;
    }
}
