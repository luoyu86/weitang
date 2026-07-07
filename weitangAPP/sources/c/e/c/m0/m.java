package c.e.c.m0;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import c.e.a.d.a0;
import c.e.a.d.q;
import c.e.a.d.x;
import com.tencent.mm.opensdk.modelbiz.WXLaunchMiniProgram;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import org.android.agoo.common.AgooConstants;

/* JADX INFO: loaded from: classes2.dex */
public class m {
    public static String getEMUI() {
        try {
            String str = Build.BRAND;
            return getSystemProperty(str.equals("Xiaomi") ? "ro.miui.ui.version.code" : str.equals("HUAWEI") ? com.alipay.sdk.m.c.a.f5275a : str.equals(AgooConstants.MESSAGE_SYSTEM_SOURCE_VIVO) ? "ro.vivo.os.version" : null);
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    /* JADX WARN: Not initialized variable reg: 4, insn: 0x0064: MOVE (r2 I:??[OBJECT, ARRAY]) = (r4 I:??[OBJECT, ARRAY]), block:B:24:0x0064 */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0067 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String getSystemProperty(java.lang.String r7) throws java.lang.Throwable {
        /*
            java.lang.String r0 = "Exception while closing InputStream"
            java.lang.String r1 = "SysUtils"
            r2 = 0
            java.lang.Runtime r3 = java.lang.Runtime.getRuntime()     // Catch: java.lang.Throwable -> L40 java.io.IOException -> L42
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L40 java.io.IOException -> L42
            r4.<init>()     // Catch: java.lang.Throwable -> L40 java.io.IOException -> L42
            java.lang.String r5 = "getprop "
            r4.append(r5)     // Catch: java.lang.Throwable -> L40 java.io.IOException -> L42
            r4.append(r7)     // Catch: java.lang.Throwable -> L40 java.io.IOException -> L42
            java.lang.String r4 = r4.toString()     // Catch: java.lang.Throwable -> L40 java.io.IOException -> L42
            java.lang.Process r3 = r3.exec(r4)     // Catch: java.lang.Throwable -> L40 java.io.IOException -> L42
            java.io.BufferedReader r4 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L40 java.io.IOException -> L42
            java.io.InputStreamReader r5 = new java.io.InputStreamReader     // Catch: java.lang.Throwable -> L40 java.io.IOException -> L42
            java.io.InputStream r3 = r3.getInputStream()     // Catch: java.lang.Throwable -> L40 java.io.IOException -> L42
            r5.<init>(r3)     // Catch: java.lang.Throwable -> L40 java.io.IOException -> L42
            r3 = 1024(0x400, float:1.435E-42)
            r4.<init>(r5, r3)     // Catch: java.lang.Throwable -> L40 java.io.IOException -> L42
            java.lang.String r3 = r4.readLine()     // Catch: java.io.IOException -> L3e java.lang.Throwable -> L63
            r4.close()     // Catch: java.io.IOException -> L3e java.lang.Throwable -> L63
            r4.close()     // Catch: java.io.IOException -> L39
            goto L3d
        L39:
            r7 = move-exception
            c.e.a.d.q.e(r1, r0, r7)
        L3d:
            return r3
        L3e:
            r3 = move-exception
            goto L44
        L40:
            r7 = move-exception
            goto L65
        L42:
            r3 = move-exception
            r4 = r2
        L44:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L63
            r5.<init>()     // Catch: java.lang.Throwable -> L63
            java.lang.String r6 = "Unable to read sysprop "
            r5.append(r6)     // Catch: java.lang.Throwable -> L63
            r5.append(r7)     // Catch: java.lang.Throwable -> L63
            java.lang.String r7 = r5.toString()     // Catch: java.lang.Throwable -> L63
            c.e.a.d.q.e(r1, r7, r3)     // Catch: java.lang.Throwable -> L63
            if (r4 == 0) goto L62
            r4.close()     // Catch: java.io.IOException -> L5e
            goto L62
        L5e:
            r7 = move-exception
            c.e.a.d.q.e(r1, r0, r7)
        L62:
            return r2
        L63:
            r7 = move-exception
            r2 = r4
        L65:
            if (r2 == 0) goto L6f
            r2.close()     // Catch: java.io.IOException -> L6b
            goto L6f
        L6b:
            r2 = move-exception
            c.e.a.d.q.e(r1, r0, r2)
        L6f:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: c.e.c.m0.m.getSystemProperty(java.lang.String):java.lang.String");
    }

    public static boolean openAliPayMiniApp(String str, String str2, Activity activity) {
        try {
            Intent intent = new Intent();
            intent.setFlags(268435456);
            intent.setAction("android.intent.action.VIEW");
            if (x.isNotNull(str) && x.isNotNull(str2)) {
                intent.setData(Uri.parse("alipays://platformapi/startapp?appId=" + str + "&page=" + str2));
            } else if (x.isNotNull(str)) {
                intent.setData(Uri.parse("alipays://platformapi/startapp?appId=" + str));
            }
            q.d("SysUtils", "openAliPayMiniApp appId = " + str + ", page = " + str2);
            activity.startActivity(intent);
            return true;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public void openAliPlay(Activity activity, String str, String str2) {
        try {
            Intent intent = new Intent();
            intent.setFlags(268435456);
            intent.setAction("android.intent.action.VIEW");
            if (x.isNotNull(str) && x.isNotNull(str2)) {
                intent.setData(Uri.parse("alipays://platformapi/startapp?appId=" + str + "&page=" + str2));
            } else if (x.isNotNull(str)) {
                intent.setData(Uri.parse("alipays://platformapi/startapp?appId=" + str));
            }
            activity.startActivity(intent);
        } catch (Exception e2) {
            e2.printStackTrace();
            a0.showToast(activity, "打开失败，您未安装支付宝，请下载安装支付宝。");
        }
    }

    public boolean openWXProgram(Context context, String str, String str2) {
        if (!x.isNotNull(str)) {
            return false;
        }
        try {
            IWXAPI iwxapiCreateWXAPI = WXAPIFactory.createWXAPI(context, "wx566d59045c104e04");
            WXLaunchMiniProgram.Req req = new WXLaunchMiniProgram.Req();
            req.userName = str;
            req.path = str2;
            req.miniprogramType = 0;
            iwxapiCreateWXAPI.sendReq(req);
            return true;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }
}
