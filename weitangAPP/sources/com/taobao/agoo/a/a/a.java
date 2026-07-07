package com.taobao.agoo.a.a;

import com.taobao.accs.common.Constants;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.JsonUtility;

/* JADX INFO: loaded from: classes2.dex */
public class a extends b {
    public static final String INVALID_TOKEN = "deprecated_alias_token_should_be_ignored";
    public static final String JSON_ALIAS_TOKEN_MAP = "aliasTokenMap";
    public static final String JSON_CMD_ADDALIAS = "setAlias";
    public static final String JSON_CMD_LISTALIAS = "getAliasTokenMap";
    public static final String JSON_CMD_REMOVEALIAS = "removeAlias";
    public static final String JSON_CMD_REMOVEALLALIAS = "unbindAllAliasByDeviceId";
    public static final String JSON_CMD_REMOVEALLALIASANDADDALIAS = "resetDeviceAndBindCurrentAlias";
    public static final String JSON_CMD_RESETALIASDEVICEONE2ONE = "resetDeviceAndAliasToSingleBind";
    public static final String JSON_CMD_RESETAlIASANDBINDCURRENT = "resetAliasAndBindCurrentDevice";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f10501a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f10502b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f10503c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f10504d;

    public static byte[] b(String str, String str2, String str3) {
        a aVar = new a();
        aVar.f10501a = str;
        aVar.f10502b = str2;
        aVar.f10503c = str3;
        aVar.f10505e = JSON_CMD_ADDALIAS;
        return aVar.a();
    }

    public static byte[] c(String str, String str2, String str3) {
        a aVar = new a();
        aVar.f10501a = str;
        aVar.f10502b = str2;
        aVar.f10503c = str3;
        aVar.f10505e = JSON_CMD_REMOVEALLALIASANDADDALIAS;
        return aVar.a();
    }

    public static byte[] d(String str, String str2, String str3) {
        a aVar = new a();
        aVar.f10501a = str;
        aVar.f10502b = str2;
        aVar.f10503c = str3;
        aVar.f10505e = JSON_CMD_RESETALIASDEVICEONE2ONE;
        return aVar.a();
    }

    public byte[] a() {
        try {
            String string = new JsonUtility.JsonObjectBuilder().put(b.JSON_CMD, this.f10505e).put(Constants.KEY_APP_KEY, this.f10501a).put("deviceId", this.f10502b).put("alias", this.f10503c).put("pushAliasToken", this.f10504d).build().toString();
            ALog.i("AliasDO", "buildData", "data", string);
            return string.getBytes("utf-8");
        } catch (Throwable th) {
            ALog.e("AliasDO", "buildData", th, new Object[0]);
            return null;
        }
    }

    public static byte[] b(String str, String str2) {
        a aVar = new a();
        aVar.f10501a = str;
        aVar.f10502b = str2;
        aVar.f10505e = JSON_CMD_LISTALIAS;
        return aVar.a();
    }

    public static byte[] a(String str, String str2, String str3) {
        a aVar = new a();
        aVar.f10501a = str;
        aVar.f10502b = str2;
        aVar.f10503c = str3;
        aVar.f10505e = JSON_CMD_RESETAlIASANDBINDCURRENT;
        return aVar.a();
    }

    public static byte[] a(String str, String str2, String str3, String str4) {
        a aVar = new a();
        aVar.f10501a = str;
        aVar.f10502b = str2;
        aVar.f10503c = str3;
        aVar.f10504d = str4;
        aVar.f10505e = JSON_CMD_REMOVEALIAS;
        return aVar.a();
    }

    public static byte[] a(String str, String str2) {
        a aVar = new a();
        aVar.f10501a = str;
        aVar.f10502b = str2;
        aVar.f10505e = JSON_CMD_REMOVEALLALIAS;
        return aVar.a();
    }
}
