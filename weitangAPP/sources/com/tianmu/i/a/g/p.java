package com.tianmu.i.a.g;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;

/* JADX INFO: loaded from: classes2.dex */
public class p implements com.tianmu.i.a.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f12234a;

    public p(Context context) {
        this.f12234a = context;
    }

    @Override // com.tianmu.i.a.c
    public boolean a() {
        if (Build.VERSION.SDK_INT < 28) {
            return false;
        }
        return com.tianmu.i.a.f.a(com.alipay.sdk.m.p0.c.f5588c, "0").equals("1");
    }

    @Override // com.tianmu.i.a.c
    public void a(com.tianmu.i.a.b bVar) {
        if (this.f12234a == null || bVar == null) {
            return;
        }
        try {
            Cursor cursorQuery = this.f12234a.getContentResolver().query(Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/OAID"), null, null, null, null);
            if (cursorQuery != null) {
                cursorQuery.moveToFirst();
                String string = cursorQuery.getString(cursorQuery.getColumnIndex(com.alipay.sdk.m.p0.b.f5579d));
                if (string != null && string.length() != 0) {
                    com.tianmu.i.a.e.a("OAID query success: " + string);
                    bVar.a(string);
                    return;
                }
                throw new com.tianmu.i.a.d("OAID query failed");
            }
        } catch (Exception e2) {
            com.tianmu.i.a.e.a(e2);
            bVar.a(e2);
        }
    }
}
