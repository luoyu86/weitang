package com.ss.android.downloadlib.s;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.ss.android.downloadlib.addownload.r;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class bl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile bl f9906a;
    private SQLiteDatabase ok;

    private bl() {
        try {
            this.ok = new a(r.getContext()).getWritableDatabase();
        } catch (Throwable th) {
            com.ss.android.downloadlib.n.bl.ok().ok(th, "ClickEventHelper");
        }
    }

    public static bl ok() {
        if (f9906a == null) {
            synchronized (bl.class) {
                if (f9906a == null) {
                    f9906a = new bl();
                }
            }
        }
        return f9906a;
    }

    public boolean a() {
        return com.ss.android.socialbase.downloader.h.ok.bl().ok("click_event_switch", 0) == 1;
    }

    public boolean bl() {
        return com.ss.android.socialbase.downloader.h.ok.bl().ok("click_event_switch", 0) == 2;
    }

    private void bl(long j, String str) {
        SQLiteDatabase sQLiteDatabase = this.ok;
        if (sQLiteDatabase == null || !sQLiteDatabase.isOpen() || j <= 0 || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            String strOptString = new JSONObject(str).optString("req_id");
            if (TextUtils.isEmpty(strOptString)) {
                return;
            }
            this.ok.delete("click_event", "time < ? AND ad_id = ? AND req_id = ?", new String[]{String.valueOf(System.currentTimeMillis() - 1209600000), String.valueOf(j), strOptString});
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public boolean a(long j, String str) {
        SQLiteDatabase sQLiteDatabase = this.ok;
        if (sQLiteDatabase == null || !sQLiteDatabase.isOpen() || j <= 0 || TextUtils.isEmpty(str)) {
            return false;
        }
        Cursor cursorQuery = null;
        try {
            try {
                String strOptString = new JSONObject(str).optString("req_id");
                if (TextUtils.isEmpty(strOptString)) {
                    return false;
                }
                cursorQuery = this.ok.query("click_event", a.ok, "time > ? AND ad_id = ? AND req_id = ?", new String[]{String.valueOf(System.currentTimeMillis() - 1209600000), String.valueOf(j), strOptString}, null, null, null, null);
                boolean z = cursorQuery.getCount() > 0;
                cursorQuery.close();
                return z;
            } catch (Exception e2) {
                e2.printStackTrace();
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                return false;
            }
        } catch (Throwable th) {
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            throw th;
        }
    }

    public void ok(long j, String str) {
        SQLiteDatabase sQLiteDatabase = this.ok;
        if (sQLiteDatabase == null || !sQLiteDatabase.isOpen() || j <= 0 || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            String strOptString = new JSONObject(str).optString("req_id");
            if (TextUtils.isEmpty(strOptString)) {
                return;
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put(MediationConstant.EXTRA_ADID, Long.valueOf(j));
            contentValues.put("req_id", strOptString);
            contentValues.put("time", Long.valueOf(System.currentTimeMillis()));
            this.ok.insert("click_event", null, contentValues);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        bl(j, str);
    }
}
