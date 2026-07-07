package cn.admobiletop.adsuyi.a.g;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes.dex */
public class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f3311a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f3312b;

    public j(String str, String str2) {
        this.f3311a = str;
        this.f3312b = str2;
    }

    public long a() {
        if (TextUtils.isEmpty(this.f3312b)) {
            return 0L;
        }
        return Long.parseLong(this.f3312b);
    }

    public long b() {
        if (TextUtils.isEmpty(this.f3311a)) {
            return 0L;
        }
        return Long.parseLong(this.f3311a);
    }
}
