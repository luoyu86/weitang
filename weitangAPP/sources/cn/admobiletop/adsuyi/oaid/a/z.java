package cn.admobiletop.adsuyi.oaid.a;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import cn.admobiletop.adsuyi.oaid.IGetter;

/* JADX INFO: loaded from: classes.dex */
public class z implements cn.admobiletop.adsuyi.oaid.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f4337a;

    public z(Context context) {
        this.f4337a = context;
    }

    @Override // cn.admobiletop.adsuyi.oaid.b
    public boolean a() {
        if (Build.VERSION.SDK_INT < 28) {
            return false;
        }
        return cn.admobiletop.adsuyi.oaid.e.a(com.alipay.sdk.m.p0.c.f5588c, "0").equals("1");
    }

    @Override // cn.admobiletop.adsuyi.oaid.b
    public void a(IGetter iGetter) {
        if (this.f4337a == null || iGetter == null) {
            return;
        }
        try {
            Cursor cursorQuery = this.f4337a.getContentResolver().query(Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/OAID"), null, null, null, null);
            if (cursorQuery != null) {
                cursorQuery.moveToFirst();
                String string = cursorQuery.getString(cursorQuery.getColumnIndex(com.alipay.sdk.m.p0.b.f5579d));
                if (string != null && string.length() != 0) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("OAID query success: ");
                    sb.append(string);
                    cn.admobiletop.adsuyi.oaid.d.a(sb.toString());
                    iGetter.onOAIDGetComplete(string);
                    return;
                }
                throw new cn.admobiletop.adsuyi.oaid.c("OAID query failed");
            }
        } catch (Exception e2) {
            cn.admobiletop.adsuyi.oaid.d.a(e2);
            iGetter.onOAIDGetError(e2);
        }
    }
}
