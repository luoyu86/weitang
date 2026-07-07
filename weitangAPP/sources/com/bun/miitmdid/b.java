package com.bun.miitmdid;

import android.content.Context;
import com.bun.miitmdid.interfaces.IIdConfig;
import org.android.agoo.common.AgooConstants;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class b implements IIdConfig {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f5817a = "";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public a f5818b = new a();

    public class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public z f5819a;

        public a() {
        }
    }

    public static native b a(Context context);

    public static boolean a(b bVar, JSONObject jSONObject) {
        if (jSONObject == null || bVar == null) {
            return false;
        }
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(AgooConstants.MESSAGE_SYSTEM_SOURCE_VIVO);
        z zVar = new z();
        if (jSONObjectOptJSONObject != null) {
            String strOptString = jSONObjectOptJSONObject.optString("appid");
            zVar.f5923a = strOptString;
            f5817a = strOptString;
            bVar.f5818b.f5819a = zVar;
        }
        return bVar.f5818b.f5819a != null;
    }

    @Override // com.bun.miitmdid.interfaces.IIdConfig
    public native String getVivoAppID();
}
