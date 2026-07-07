package com.taobao.accs.messenger;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import com.taobao.accs.utl.ALog;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f10329a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final HashMap<String, d> f10330b = new HashMap<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f10331c;

    public a(Context context) {
        this.f10329a = context;
    }

    public d a(String str) {
        d dVar = this.f10330b.get(str);
        if (dVar == null || !dVar.a()) {
            return null;
        }
        return dVar;
    }

    public void b(String str, d dVar) {
        if (Build.VERSION.SDK_INT >= 24) {
            this.f10330b.remove(str, dVar);
        } else if (this.f10330b.get(str) == dVar) {
            this.f10330b.remove(str);
        }
    }

    public void a(String str, d dVar) {
        b(str, dVar);
        if (this.f10331c) {
            try {
                this.f10329a.unbindService(dVar);
            } catch (Exception e2) {
                ALog.e("ConnectionManager", "disconnect error: " + e2.getMessage(), new Object[0]);
            }
        }
    }

    public void a(String str, Intent intent) {
        d dVar = this.f10330b.get(str);
        if (dVar != null) {
            if (dVar.b()) {
                if (!dVar.c()) {
                    return;
                } else {
                    a(str, dVar);
                }
            } else {
                this.f10330b.remove(str);
            }
            dVar = null;
        }
        if (dVar == null) {
            d dVar2 = new d(this.f10329a, str, this);
            this.f10330b.put(str, dVar2);
            this.f10331c = this.f10329a.bindService(a(intent), dVar2, 1);
        }
    }

    private static Intent a(Intent intent) {
        Intent intent2 = (Intent) intent.clone();
        intent2.replaceExtras(new Bundle());
        return intent2;
    }
}
