package com.alibaba.mtl.appmonitor.d;

import android.text.TextUtils;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private a f4498a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Set<String> f4499c;

    public enum a {
        IN,
        NOT_IN
    }

    public boolean b(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        boolean zContains = this.f4499c.contains(str);
        return this.f4498a == a.IN ? zContains : !zContains;
    }
}
