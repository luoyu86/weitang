package com.ss.android.socialbase.appdownloader.ok;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.taobao.accs.common.Constants;
import java.util.Iterator;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class bl extends ok {
    private final JSONObject s;

    public bl(Context context, com.ss.android.socialbase.downloader.h.ok okVar, String str, JSONObject jSONObject) {
        super(context, okVar, str);
        this.s = jSONObject;
    }

    private static void ok(@NonNull Intent intent, JSONObject jSONObject, JSONObject jSONObject2) {
        Iterator<String> itKeys;
        if (jSONObject == null || jSONObject2 == null || jSONObject.length() != jSONObject2.length() || intent == null || (itKeys = jSONObject.keys()) == null) {
            return;
        }
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            String strOptString = jSONObject2.optString(next);
            if (strOptString != null) {
                ok(jSONObject, next, strOptString, intent);
            }
        }
    }

    @Override // com.ss.android.socialbase.appdownloader.ok.n
    public Intent a() {
        String strOptString = this.s.optString("action");
        String strOptString2 = this.s.optString("category");
        int iOptInt = this.s.optInt(Constants.KEY_FLAGS, 1342210048);
        String strOptString3 = this.s.optString("path_extra_key");
        String strOptString4 = this.s.optString("path_data_key");
        JSONObject jSONObjectOptJSONObject = this.s.optJSONObject("extra");
        JSONObject jSONObjectOptJSONObject2 = this.s.optJSONObject("extra_type");
        if (TextUtils.isEmpty(strOptString)) {
            return null;
        }
        Intent intent = new Intent(strOptString);
        if (!TextUtils.isEmpty(strOptString2)) {
            intent.addCategory(strOptString2);
        }
        if (!TextUtils.isEmpty(strOptString4)) {
            try {
                intent.setData(Uri.parse(String.format(strOptString4, this.bl)));
            } catch (Throwable unused) {
            }
        }
        intent.setFlags(iOptInt);
        if (!TextUtils.isEmpty(strOptString3)) {
            intent.putExtra(strOptString3, this.bl);
        }
        ok(intent, jSONObjectOptJSONObject, jSONObjectOptJSONObject2);
        return intent;
    }

    private static void ok(JSONObject jSONObject, String str, String str2, Intent intent) {
        str2.hashCode();
        switch (str2) {
            case "double":
                intent.putExtra(str, jSONObject.optDouble(str));
                break;
            case "string":
                intent.putExtra(str, jSONObject.optString(str));
                break;
            case "int":
                intent.putExtra(str, jSONObject.optInt(str));
                break;
            case "long":
                intent.putExtra(str, jSONObject.optLong(str));
                break;
            case "boolean":
                intent.putExtra(str, jSONObject.optBoolean(str));
                break;
        }
    }
}
