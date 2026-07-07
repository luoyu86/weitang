package anet.channel.security;

/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile ISecurityFactory f558a;

    public static ISecurityFactory a() {
        if (f558a == null) {
            f558a = new d();
        }
        return f558a;
    }
}
