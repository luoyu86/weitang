package com.ss.android.socialbase.downloader.kf;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.alibaba.android.arouter.utils.Consts;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes2.dex */
public class x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f10094a;
    public final String bl;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f10095h;
    private final AtomicLong k;
    private int kf;
    private final List<z> n;
    public final String ok;
    private int p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private String f10096q;
    public final boolean s;

    public x(String str, boolean z) {
        this.n = new ArrayList();
        this.k = new AtomicLong();
        this.ok = str;
        this.s = z;
        this.f10094a = null;
        this.bl = null;
    }

    private String n() {
        if (this.f10096q == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(this.ok);
            sb.append("_");
            String str = this.f10094a;
            if (str == null) {
                str = "";
            }
            sb.append(str);
            sb.append("_");
            sb.append(this.s);
            this.f10096q = sb.toString();
        }
        return this.f10096q;
    }

    private String ok(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            int iLastIndexOf = str.lastIndexOf(Consts.DOT);
            if (iLastIndexOf <= 0 || iLastIndexOf >= str.length()) {
                return null;
            }
            return str.substring(0, iLastIndexOf);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public synchronized void a(z zVar) {
        try {
            this.n.remove(zVar);
        } catch (Throwable unused) {
        }
    }

    public synchronized void bl() {
        this.f10095h = false;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof x) {
            return n().equals(((x) obj).n());
        }
        return false;
    }

    public int hashCode() {
        if (this.p == 0) {
            this.p = n().hashCode();
        }
        return this.p;
    }

    public synchronized boolean s() {
        return this.f10095h;
    }

    public String toString() {
        return "UrlRecord{url='" + this.ok + "', ip='" + this.f10094a + "', ipFamily='" + this.bl + "', isMainUrl=" + this.s + ", failedTimes=" + this.kf + ", isCurrentFailed=" + this.f10095h + '}';
    }

    public synchronized void a() {
        this.kf++;
        this.f10095h = true;
    }

    public synchronized void ok(z zVar) {
        this.n.add(zVar);
    }

    public x(String str, String str2) {
        this.n = new ArrayList();
        this.k = new AtomicLong();
        this.ok = str;
        this.s = false;
        this.f10094a = str2;
        this.bl = ok(str2);
    }

    public synchronized int ok() {
        return this.n.size();
    }

    public void ok(long j) {
        this.k.addAndGet(j);
    }
}
