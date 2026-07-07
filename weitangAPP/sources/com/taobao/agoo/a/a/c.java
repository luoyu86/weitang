package com.taobao.agoo.a.a;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.taobao.accs.client.GlobalClientInfo;
import com.taobao.accs.common.Constants;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.AdapterUtilityImpl;
import com.taobao.accs.utl.JsonUtility;
import com.taobao.accs.utl.RomInfoCollector;
import com.taobao.accs.utl.UtilityImpl;

/* JADX INFO: loaded from: classes2.dex */
public class c extends b {
    public static final String JSON_CMD_REGISTER = "register";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f10506a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f10507b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f10508c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f10509d = String.valueOf(Constants.SDK_VERSION_CODE);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f10510f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f10511g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f10512h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f10513i;
    public String j;
    public String k;
    public String l;
    public String m;
    public String n;
    public String o;
    public String p;

    public byte[] a() {
        try {
            String string = new JsonUtility.JsonObjectBuilder().put(b.JSON_CMD, this.f10505e).put(Constants.KEY_APP_KEY, this.f10506a).put("utdid", this.f10507b).put("appVersion", this.f10508c).put(Constants.KEY_SDK_VERSION, this.f10509d).put(Constants.KEY_TTID, this.f10510f).put("packageName", this.f10511g).put("notifyEnable", this.f10512h).put("romInfo", this.f10513i).put("c0", this.j).put("c1", this.k).put("c2", this.l).put("c3", this.m).put("c4", this.n).put("c5", this.o).put("c6", this.p).build().toString();
            ALog.i("RegisterDO", "buildData", "data", string);
            return string.getBytes("utf-8");
        } catch (Throwable th) {
            ALog.e("RegisterDO", "buildData", th, new Object[0]);
            return null;
        }
    }

    public static byte[] a(Context context, String str, String str2) {
        c cVar;
        String deviceId;
        String packageName;
        String str3;
        try {
            deviceId = UtilityImpl.getDeviceId(context);
            packageName = context.getPackageName();
            str3 = GlobalClientInfo.getInstance(context).getPackageInfo().versionName;
        } catch (Throwable th) {
            th = th;
            cVar = null;
        }
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(deviceId) && !TextUtils.isEmpty(str3)) {
            cVar = new c();
            try {
                cVar.f10505e = JSON_CMD_REGISTER;
                cVar.f10506a = str;
                cVar.f10507b = deviceId;
                cVar.f10508c = str3;
                cVar.f10510f = str2;
                cVar.f10511g = packageName;
                cVar.j = Build.BRAND;
                cVar.k = Build.MODEL;
                cVar.l = null;
                cVar.m = null;
                cVar.f10512h = AdapterUtilityImpl.isNotificationEnabled(context);
                cVar.f10513i = RomInfoCollector.getCollector().collect();
            } catch (Throwable th2) {
                th = th2;
                try {
                    ALog.w("RegisterDO", "buildRegister", th.getMessage());
                    if (cVar == null) {
                        return null;
                    }
                } finally {
                    if (cVar != null) {
                        cVar.a();
                    }
                }
            }
            return cVar.a();
        }
        ALog.e("RegisterDO", "buildRegister param null", Constants.KEY_APP_KEY, str, "utdid", deviceId, "appVersion", str3);
        return null;
    }
}
