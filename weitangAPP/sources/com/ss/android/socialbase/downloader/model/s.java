package com.ss.android.socialbase.downloader.model;

import android.text.TextUtils;
import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import com.ss.android.socialbase.downloader.network.h;
import com.ss.android.socialbase.downloader.q.kf;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final h f10118a;
    public final int bl;
    private long n;
    public final String ok;
    private long s;

    public s(String str, h hVar) throws IOException {
        this.ok = str;
        this.bl = hVar.a();
        this.f10118a = hVar;
    }

    public boolean a() {
        return kf.ok(this.bl, this.f10118a.ok("Accept-Ranges"));
    }

    public String bl() {
        return this.f10118a.ok("Etag");
    }

    public String h() {
        return kf.a(this.f10118a, "Cache-Control");
    }

    public long k() {
        if (this.n <= 0) {
            if (q()) {
                this.n = -1L;
            } else {
                String strN = n();
                if (!TextUtils.isEmpty(strN)) {
                    this.n = kf.a(strN);
                }
            }
        }
        return this.n;
    }

    public String kf() {
        String strA = kf.a(this.f10118a, "last-modified");
        return TextUtils.isEmpty(strA) ? kf.a(this.f10118a, HttpHeaders.LAST_MODIFIED) : strA;
    }

    public String n() {
        return kf.a(this.f10118a, "Content-Range");
    }

    public boolean ok() {
        return kf.bl(this.bl);
    }

    public long p() {
        if (this.s <= 0) {
            this.s = kf.ok(this.f10118a);
        }
        return this.s;
    }

    public boolean q() {
        return com.ss.android.socialbase.downloader.q.ok.ok(8) ? kf.bl(this.f10118a) : kf.a(p());
    }

    public long r() {
        return kf.q(h());
    }

    public String s() {
        return this.f10118a.ok("Content-Type");
    }
}
