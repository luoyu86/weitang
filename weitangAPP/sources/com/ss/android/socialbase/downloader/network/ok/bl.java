package com.ss.android.socialbase.downloader.network.ok;

import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import com.ss.android.socialbase.downloader.network.h;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class bl implements h {
    private static final ArrayList<String> n;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f10133a;
    public List<com.ss.android.socialbase.downloader.model.bl> bl;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f10134h;
    private boolean k;
    public final String ok;
    private long p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private boolean f10135q;
    private h r;
    private Map<String, String> kf = null;
    public final Object s = new Object();

    static {
        ArrayList<String> arrayList = new ArrayList<>(6);
        n = arrayList;
        arrayList.add("Content-Length");
        arrayList.add("Content-Range");
        arrayList.add("Transfer-Encoding");
        arrayList.add("Accept-Ranges");
        arrayList.add("Etag");
        arrayList.add(HttpHeaders.CONTENT_DISPOSITION);
    }

    public bl(String str, List<com.ss.android.socialbase.downloader.model.bl> list, long j) {
        this.ok = str;
        this.bl = list;
        this.f10133a = j;
    }

    @Override // com.ss.android.socialbase.downloader.network.h
    public int a() throws IOException {
        return this.f10134h;
    }

    @Override // com.ss.android.socialbase.downloader.network.h
    public void bl() {
        h hVar = this.r;
        if (hVar != null) {
            hVar.bl();
        }
    }

    public boolean h() {
        return this.k;
    }

    public boolean kf() {
        return System.currentTimeMillis() - this.p < a.f10131a;
    }

    public boolean n() {
        return this.f10135q;
    }

    public void ok() throws Exception {
        if (this.kf != null) {
            return;
        }
        try {
            this.k = true;
            this.r = com.ss.android.socialbase.downloader.downloader.bl.ok(this.ok, this.bl);
            synchronized (this.s) {
                if (this.r != null) {
                    HashMap map = new HashMap();
                    this.kf = map;
                    ok(this.r, map);
                    this.f10134h = this.r.a();
                    this.p = System.currentTimeMillis();
                    this.f10135q = ok(this.f10134h);
                }
                this.k = false;
                this.s.notifyAll();
            }
        } catch (Throwable th) {
            synchronized (this.s) {
                if (this.r != null) {
                    HashMap map2 = new HashMap();
                    this.kf = map2;
                    ok(this.r, map2);
                    this.f10134h = this.r.a();
                    this.p = System.currentTimeMillis();
                    this.f10135q = ok(this.f10134h);
                }
                this.k = false;
                this.s.notifyAll();
                throw th;
            }
        }
    }

    public boolean ok(int i2) {
        return i2 >= 200 && i2 < 300;
    }

    public List<com.ss.android.socialbase.downloader.model.bl> p() {
        return this.bl;
    }

    public Map<String, String> q() {
        return this.kf;
    }

    public void s() throws InterruptedException {
        synchronized (this.s) {
            if (this.k && this.kf == null) {
                this.s.wait();
            }
        }
    }

    private void ok(h hVar, Map<String, String> map) {
        if (hVar == null || map == null) {
            return;
        }
        for (String str : n) {
            map.put(str, hVar.ok(str));
        }
    }

    @Override // com.ss.android.socialbase.downloader.network.h
    public String ok(String str) {
        Map<String, String> map = this.kf;
        if (map != null) {
            return map.get(str);
        }
        h hVar = this.r;
        if (hVar != null) {
            return hVar.ok(str);
        }
        return null;
    }
}
