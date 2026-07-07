package com.ss.android.downloadlib.addownload.ok;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.ss.android.downloadlib.addownload.r;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class a {
    public void a(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        r.getContext().getSharedPreferences(str, 0).edit().putString(str2, "").apply();
    }

    @NonNull
    public CopyOnWriteArrayList<com.ss.android.downloadlib.addownload.a.ok> ok(String str, String str2) {
        CopyOnWriteArrayList<com.ss.android.downloadlib.addownload.a.ok> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
        try {
            String string = r.getContext().getSharedPreferences(str, 0).getString(str2, "");
            if (!TextUtils.isEmpty(string)) {
                JSONObject jSONObject = new JSONObject(string);
                Iterator<String> itKeys = jSONObject.keys();
                while (itKeys.hasNext()) {
                    com.ss.android.downloadlib.addownload.a.ok okVarOk = com.ss.android.downloadlib.addownload.a.ok.ok(jSONObject.optJSONObject(itKeys.next()));
                    if (okVarOk != null) {
                        copyOnWriteArrayList.add(okVarOk);
                    }
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return copyOnWriteArrayList;
    }

    public void ok(String str, String str2, CopyOnWriteArrayList<com.ss.android.downloadlib.addownload.a.ok> copyOnWriteArrayList) {
        if (copyOnWriteArrayList == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            for (com.ss.android.downloadlib.addownload.a.ok okVar : copyOnWriteArrayList) {
                if (okVar != null) {
                    jSONObject.put(String.valueOf(okVar.f9776a), okVar.ok());
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        r.getContext().getSharedPreferences(str, 0).edit().putString(str2, jSONObject.toString()).apply();
    }
}
