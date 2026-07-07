package cn.admobiletop.adsuyi.oaid.a;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import cn.admobiletop.adsuyi.oaid.IGetter;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public class p implements cn.admobiletop.adsuyi.oaid.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f4324a;

    public p(Context context) {
        this.f4324a = context;
    }

    @Override // cn.admobiletop.adsuyi.oaid.b
    public boolean a() {
        Context context = this.f4324a;
        if (context == null) {
            return false;
        }
        try {
            return context.getPackageManager().resolveContentProvider("com.meizu.flyme.openidsdk", 0) != null;
        } catch (Exception e2) {
            cn.admobiletop.adsuyi.oaid.d.a(e2);
            return false;
        }
    }

    @Override // cn.admobiletop.adsuyi.oaid.b
    public void a(IGetter iGetter) {
        if (this.f4324a == null || iGetter == null) {
            return;
        }
        try {
            Cursor cursorQuery = this.f4324a.getContentResolver().query(Uri.parse("content://com.meizu.flyme.openidsdk/"), null, null, new String[]{"oaid"}, null);
            try {
                Objects.requireNonNull(cursorQuery);
                cursorQuery.moveToFirst();
                String string = cursorQuery.getString(cursorQuery.getColumnIndex(com.alipay.sdk.m.p0.b.f5579d));
                if (string != null && string.length() != 0) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("OAID query success: ");
                    sb.append(string);
                    cn.admobiletop.adsuyi.oaid.d.a(sb.toString());
                    iGetter.onOAIDGetComplete(string);
                    cursorQuery.close();
                    return;
                }
                throw new cn.admobiletop.adsuyi.oaid.c("OAID query failed");
            } finally {
            }
        } catch (Exception e2) {
            cn.admobiletop.adsuyi.oaid.d.a(e2);
            iGetter.onOAIDGetError(e2);
        }
    }
}
