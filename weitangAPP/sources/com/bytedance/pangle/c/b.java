package com.bytedance.pangle.c;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static String f5958b = "request_finish";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static String f5959c = "download_start";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static String f5960d = "download_finish";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static String f5961e = "install_start";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static String f5962f = "install_finish";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static String f5963g = "7z_unzip_start";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static String f5964h = "7z_unzip_finish";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static String f5965i = "load_start";
    public static String j = "load_finish";
    public static String k = "rm_entry_finish";
    private static volatile b l;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<com.bytedance.pangle.c.a> f5966a = new ArrayList();

    public static class a {
        public static int A = 32007;
        public static int B = 32008;
        public static int C = 32999;
        public static int D = 40000;
        public static int E = 41000;
        public static int F = 42000;
        public static int G = 50000;
        public static int H = 50004;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static int f5967a = 1;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static int f5968b = 2;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static int f5969c = -1;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static int f5970d = -2;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static int f5971e = 12000;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static int f5972f = 12001;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static int f5973g = 12002;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static int f5974h = 12003;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static int f5975i = 12004;
        public static int j = 20000;
        public static int k = 21000;
        public static int l = 21001;
        public static int m = 21002;
        public static int n = 22000;
        public static int o = 22001;
        public static int p = 22002;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public static int f5976q = 22999;
        public static int r = 30000;
        public static int s = 31000;
        public static int t = 32000;
        public static int u = 32001;
        public static int v = 32002;
        public static int w = 32003;
        public static int x = 32004;
        public static int y = 32005;
        public static int z = 32006;
    }

    private b() {
    }

    public static b a() {
        if (l == null) {
            synchronized (b.class) {
                l = new b();
            }
        }
        return l;
    }

    public final void a(String str, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3) {
        synchronized (this.f5966a) {
            Iterator<com.bytedance.pangle.c.a> it = this.f5966a.iterator();
            while (it.hasNext()) {
                try {
                    it.next().a(str, jSONObject, jSONObject2, jSONObject3);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }
    }
}
