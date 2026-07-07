package anet.channel.util;

import android.util.Base64;
import java.net.InetSocketAddress;
import java.net.Proxy;

/* JADX INFO: loaded from: classes.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static g f726a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Proxy f727b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f728c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f729d;

    public g(String str, int i2, String str2, String str3) {
        this.f727b = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(str, i2));
        this.f728c = str2;
        this.f729d = str3;
    }

    public static g a() {
        return f726a;
    }

    public Proxy b() {
        return this.f727b;
    }

    public String c() {
        StringBuilder sb = new StringBuilder(32);
        sb.append(this.f728c);
        sb.append(":");
        sb.append(this.f729d);
        String strEncodeToString = Base64.encodeToString(sb.toString().getBytes(), 0);
        StringBuilder sb2 = new StringBuilder(64);
        sb2.append("Basic ");
        sb2.append(strEncodeToString);
        return sb2.toString();
    }
}
