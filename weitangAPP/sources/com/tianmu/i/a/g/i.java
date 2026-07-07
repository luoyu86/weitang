package com.tianmu.i.a.g;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public class i implements com.tianmu.i.a.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f12223a;

    public i(Context context) {
        this.f12223a = context;
    }

    @Override // com.tianmu.i.a.c
    public boolean a() {
        Context context = this.f12223a;
        if (context == null) {
            return false;
        }
        try {
            return context.getPackageManager().resolveContentProvider("com.meizu.flyme.openidsdk", 0) != null;
        } catch (Exception e2) {
            com.tianmu.i.a.e.a(e2);
            return false;
        }
    }

    @Override // com.tianmu.i.a.c
    public void a(com.tianmu.i.a.b bVar) {
        if (this.f12223a == null || bVar == null) {
            return;
        }
        try {
            Cursor cursorQuery = this.f12223a.getContentResolver().query(Uri.parse("content://com.meizu.flyme.openidsdk/"), null, null, new String[]{"oaid"}, null);
            try {
                Objects.requireNonNull(cursorQuery);
                cursorQuery.moveToFirst();
                String string = cursorQuery.getString(cursorQuery.getColumnIndex(com.alipay.sdk.m.p0.b.f5579d));
                if (string != null && string.length() != 0) {
                    com.tianmu.i.a.e.a("OAID query success: " + string);
                    bVar.a(string);
                    cursorQuery.close();
                    return;
                }
                throw new com.tianmu.i.a.d("OAID query failed");
            } finally {
            }
        } catch (Exception e2) {
            com.tianmu.i.a.e.a(e2);
            bVar.a(e2);
        }
    }
}
