package com.ut.mini.internal;

/* JADX INFO: loaded from: classes2.dex */
public class CustomDNS {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private IDnsResolver f12364a;

    public interface IDnsResolver {
        String[] resolveUrl(String str);
    }

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final CustomDNS f12365a = new CustomDNS();
    }

    public static CustomDNS instance() {
        return a.f12365a;
    }

    public String[] resolveUrl(String str) {
        IDnsResolver iDnsResolver = this.f12364a;
        if (iDnsResolver != null) {
            return iDnsResolver.resolveUrl(str);
        }
        return null;
    }

    public void setDnsResolver(IDnsResolver iDnsResolver) {
        this.f12364a = iDnsResolver;
    }

    private CustomDNS() {
        this.f12364a = null;
    }
}
