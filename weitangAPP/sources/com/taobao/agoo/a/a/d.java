package com.taobao.agoo.a.a;

import android.text.TextUtils;
import com.taobao.accs.common.Constants;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.JsonUtility;

/* JADX INFO: loaded from: classes2.dex */
public class d extends b {
    public static final String JSON_CMD_DISABLEPUSH = "disablePush";
    public static final String JSON_CMD_ENABLEPUSH = "enablePush";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f10514a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f10515b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f10516c;

    public byte[] a() {
        try {
            JsonUtility.JsonObjectBuilder jsonObjectBuilder = new JsonUtility.JsonObjectBuilder();
            jsonObjectBuilder.put(b.JSON_CMD, this.f10505e).put(Constants.KEY_APP_KEY, this.f10514a);
            if (TextUtils.isEmpty(this.f10515b)) {
                jsonObjectBuilder.put("utdid", this.f10516c);
            } else {
                jsonObjectBuilder.put("deviceId", this.f10515b);
            }
            String string = jsonObjectBuilder.build().toString();
            ALog.i("SwitchDO", "buildData", "data", string);
            return string.getBytes("utf-8");
        } catch (Throwable th) {
            ALog.e("SwitchDO", "buildData", th, new Object[0]);
            return null;
        }
    }

    public static byte[] a(String str, String str2, String str3, boolean z) {
        d dVar = new d();
        dVar.f10514a = str;
        dVar.f10515b = str2;
        dVar.f10516c = str3;
        if (z) {
            dVar.f10505e = JSON_CMD_ENABLEPUSH;
        } else {
            dVar.f10505e = JSON_CMD_DISABLEPUSH;
        }
        return dVar.a();
    }
}
