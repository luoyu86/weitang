package com.tianmu.i.a.g;

import android.annotation.SuppressLint;
import android.content.ContentProviderClient;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import com.taobao.accs.common.Constants;

/* JADX INFO: loaded from: classes2.dex */
public class k implements com.tianmu.i.a.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f12225a;

    public k(Context context) {
        this.f12225a = context;
    }

    @Override // com.tianmu.i.a.c
    @SuppressLint({"AnnotateVersionCheck"})
    public boolean a() {
        return Build.VERSION.SDK_INT >= 29;
    }

    @Override // com.tianmu.i.a.c
    public void a(com.tianmu.i.a.b bVar) {
        if (this.f12225a == null || bVar == null) {
            return;
        }
        if (!a()) {
            com.tianmu.i.a.e.a("Only supports Android 10.0 and above for Nubia");
            bVar.a(new com.tianmu.i.a.d("Only supports Android 10.0 and above for Nubia"));
            return;
        }
        try {
            ContentProviderClient contentProviderClientAcquireContentProviderClient = this.f12225a.getContentResolver().acquireContentProviderClient(Uri.parse("content://cn.nubia.identity/identity"));
            if (contentProviderClientAcquireContentProviderClient == null) {
                return;
            }
            Bundle bundleCall = contentProviderClientAcquireContentProviderClient.call("getOAID", null, null);
            if (Build.VERSION.SDK_INT >= 24) {
                contentProviderClientAcquireContentProviderClient.close();
            } else {
                contentProviderClientAcquireContentProviderClient.release();
            }
            if (bundleCall == null) {
                throw new com.tianmu.i.a.d("OAID query failed: bundle is null");
            }
            String string = bundleCall.getInt("code", -1) == 0 ? bundleCall.getString("id") : null;
            if (string == null || string.length() == 0) {
                throw new com.tianmu.i.a.d("OAID query failed: " + bundleCall.getString(Constants.SHARED_MESSAGE_ID_FILE));
            }
            com.tianmu.i.a.e.a("OAID query success: " + string);
            bVar.a(string);
        } catch (Exception e2) {
            com.tianmu.i.a.e.a(e2);
            bVar.a(e2);
        }
    }
}
