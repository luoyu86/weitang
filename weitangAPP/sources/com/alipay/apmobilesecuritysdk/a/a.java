package com.alipay.apmobilesecuritysdk.a;

import android.content.Context;
import android.os.Environment;
import anet.channel.strategy.dispatch.DispatchConstants;
import com.alipay.apmobilesecuritysdk.d.e;
import com.alipay.apmobilesecuritysdk.e.b;
import com.alipay.apmobilesecuritysdk.e.g;
import com.alipay.apmobilesecuritysdk.e.h;
import com.alipay.apmobilesecuritysdk.e.i;
import com.alipay.apmobilesecuritysdk.otherid.UmidSdkWrapper;
import com.alipay.sdk.m.f0.c;
import com.alipay.sdk.m.f0.d;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f5137a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public com.alipay.apmobilesecuritysdk.b.a f5138b = com.alipay.apmobilesecuritysdk.b.a.a();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f5139c = 4;

    public a(Context context) {
        this.f5137a = context;
    }

    public static String a(Context context) {
        String strB = b(context);
        return com.alipay.sdk.m.z.a.a(strB) ? h.f(context) : strB;
    }

    public static String a(Context context, String str) {
        try {
            b();
            String strA = i.a(str);
            if (!com.alipay.sdk.m.z.a.a(strA)) {
                return strA;
            }
            String strA2 = g.a(context, str);
            i.a(str, strA2);
            return !com.alipay.sdk.m.z.a.a(strA2) ? strA2 : "";
        } catch (Throwable unused) {
            return "";
        }
    }

    public static boolean a() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String[] strArr = {"2017-01-27 2017-01-28", "2017-11-10 2017-11-11", "2017-12-11 2017-12-12"};
        int iRandom = ((int) (Math.random() * 24.0d * 60.0d * 60.0d)) * 1;
        for (int i2 = 0; i2 < 3; i2++) {
            try {
                String[] strArrSplit = strArr[i2].split(" ");
                if (strArrSplit != null && strArrSplit.length == 2) {
                    Date date = new Date();
                    Date date2 = simpleDateFormat.parse(strArrSplit[0] + " 00:00:00");
                    Date date3 = simpleDateFormat.parse(strArrSplit[1] + " 23:59:59");
                    Calendar calendar = Calendar.getInstance();
                    calendar.setTime(date3);
                    calendar.add(13, iRandom);
                    Date time = calendar.getTime();
                    if (date.after(date2) && date.before(time)) {
                        return true;
                    }
                }
            } catch (Exception unused) {
            }
        }
        return false;
    }

    private c b(Map<String, String> map) {
        String str;
        String str2;
        String str3;
        b bVarB;
        b bVarC;
        String str4 = "";
        try {
            Context context = this.f5137a;
            d dVar = new d();
            String strA = com.alipay.sdk.m.z.a.a(map, "appName", "");
            String strA2 = com.alipay.sdk.m.z.a.a(map, "sessionId", "");
            String strA3 = com.alipay.sdk.m.z.a.a(map, "rpcVersion", "");
            String strA4 = a(context, strA);
            String securityToken = UmidSdkWrapper.getSecurityToken(context);
            String strD = h.d(context);
            if (com.alipay.sdk.m.z.a.b(strA2)) {
                dVar.f5328c = strA2;
            } else {
                dVar.f5328c = strA4;
            }
            dVar.f5329d = securityToken;
            dVar.f5330e = strD;
            dVar.f5326a = DispatchConstants.ANDROID;
            com.alipay.apmobilesecuritysdk.e.c cVarC = com.alipay.apmobilesecuritysdk.e.d.c(context);
            if (cVarC != null) {
                str2 = cVarC.f5147a;
                str = cVarC.f5149c;
            } else {
                str = "";
                str2 = str;
            }
            if (com.alipay.sdk.m.z.a.a(str2) && (bVarC = com.alipay.apmobilesecuritysdk.e.a.c(context)) != null) {
                str2 = bVarC.f5144a;
                str = bVarC.f5146c;
            }
            com.alipay.apmobilesecuritysdk.e.c cVarB = com.alipay.apmobilesecuritysdk.e.d.b();
            if (cVarB != null) {
                str4 = cVarB.f5147a;
                str3 = cVarB.f5149c;
            } else {
                str3 = "";
            }
            if (com.alipay.sdk.m.z.a.a(str4) && (bVarB = com.alipay.apmobilesecuritysdk.e.a.b()) != null) {
                str4 = bVarB.f5144a;
                str3 = bVarB.f5146c;
            }
            dVar.f5333h = str2;
            dVar.f5332g = str4;
            dVar.j = strA3;
            if (com.alipay.sdk.m.z.a.a(str2)) {
                dVar.f5327b = str4;
                str = str3;
            } else {
                dVar.f5327b = str2;
            }
            dVar.f5334i = str;
            dVar.f5331f = e.a(context, map);
            return com.alipay.sdk.m.d0.d.b(this.f5137a, this.f5138b.c()).a(dVar);
        } catch (Throwable th) {
            th.printStackTrace();
            com.alipay.apmobilesecuritysdk.c.a.a(th);
            return null;
        }
    }

    public static String b(Context context) {
        try {
            String strB = i.b();
            if (!com.alipay.sdk.m.z.a.a(strB)) {
                return strB;
            }
            com.alipay.apmobilesecuritysdk.e.c cVarB = com.alipay.apmobilesecuritysdk.e.d.b(context);
            if (cVarB != null) {
                i.a(cVarB);
                String str = cVarB.f5147a;
                if (com.alipay.sdk.m.z.a.b(str)) {
                    return str;
                }
            }
            b bVarB = com.alipay.apmobilesecuritysdk.e.a.b(context);
            if (bVarB == null) {
                return "";
            }
            i.a(bVarB);
            String str2 = bVarB.f5144a;
            return com.alipay.sdk.m.z.a.b(str2) ? str2 : "";
        } catch (Throwable unused) {
            return "";
        }
    }

    public static void b() {
        try {
            String[] strArr = {"device_feature_file_name", "wallet_times", "wxcasxx_v3", "wxcasxx_v4", "wxxzyy_v1"};
            for (int i2 = 0; i2 < 5; i2++) {
                String str = strArr[i2];
                File file = new File(Environment.getExternalStorageDirectory(), ".SystemConfig/" + str);
                if (file.exists() && file.canWrite()) {
                    file.delete();
                }
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:71:0x0201 A[Catch: Exception -> 0x023e, TryCatch #0 {Exception -> 0x023e, blocks: (B:3:0x0006, B:5:0x0037, B:8:0x0040, B:37:0x00be, B:69:0x01e6, B:71:0x0201, B:73:0x0207, B:75:0x020d, B:79:0x0216, B:81:0x021c, B:40:0x00d6, B:42:0x00ee, B:48:0x00fb, B:49:0x010b, B:51:0x0112, B:55:0x0124, B:57:0x0174, B:59:0x017e, B:61:0x0186, B:63:0x0193, B:65:0x019d, B:67:0x01a5, B:66:0x01a1, B:60:0x0182, B:11:0x0055, B:13:0x0063, B:16:0x006e, B:18:0x0074, B:21:0x007f, B:24:0x0088, B:27:0x0095, B:30:0x00a2, B:33:0x00af), top: B:87:0x0006 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int a(java.util.Map<java.lang.String, java.lang.String> r10) {
        /*
            Method dump skipped, instruction units count: 581
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.apmobilesecuritysdk.a.a.a(java.util.Map):int");
    }
}
