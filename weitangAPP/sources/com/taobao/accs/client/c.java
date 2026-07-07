package com.taobao.accs.client;

import android.content.Context;
import com.taobao.accs.utl.ALog;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: loaded from: classes2.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ConcurrentMap<String, Integer> f10260a = new ConcurrentHashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f10261b = "ClientManager_";

    public c(Context context, String str, String str2, String str3) {
        if (context == null) {
            throw new RuntimeException("Context is null!!");
        }
        this.f10261b += str;
    }

    public void a(String str) {
        Integer num = this.f10260a.get(str);
        if (num == null || num.intValue() != 2) {
            this.f10260a.put(str, 2);
        }
    }

    public void b(String str) {
        Integer num = this.f10260a.get(str);
        if (num == null || num.intValue() != 4) {
            this.f10260a.put(str, 4);
        }
    }

    public void c(String str) {
        Integer num = this.f10260a.get(str);
        if (num == null || num.intValue() != 1) {
            this.f10260a.put(str, 1);
        }
    }

    public boolean d(String str) {
        Integer num = this.f10260a.get(str);
        ALog.i(this.f10261b, "isAppBound", "appStatus", num, "mBindStatus", this.f10260a);
        return num != null && num.intValue() == 2;
    }

    public boolean e(String str) {
        Integer num = this.f10260a.get(str);
        return num != null && num.intValue() == 4;
    }

    public boolean f(String str) {
        Integer num = this.f10260a.get(str);
        return num != null && num.intValue() == 1;
    }

    public void a() {
        try {
            this.f10260a.clear();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
