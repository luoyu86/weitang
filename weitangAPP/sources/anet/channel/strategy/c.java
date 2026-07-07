package anet.channel.strategy;

import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ConcurrentHashMap<String, String> f632a = new ConcurrentHashMap<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f633b = true;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static c f634a = new c();

        private a() {
        }
    }

    public void a(boolean z) {
        this.f633b = z;
    }

    public void b(String str) {
        this.f632a.put(str, "http");
    }

    public String a(String str) {
        if (!this.f633b) {
            return null;
        }
        String str2 = this.f632a.get(str);
        if (str2 != null) {
            return str2;
        }
        this.f632a.put(str, "https");
        return "https";
    }
}
