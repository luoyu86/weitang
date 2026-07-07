package com.alipay.apmobilesecuritysdk.face;

import android.content.Context;
import com.alipay.apmobilesecuritysdk.a.a;
import com.alipay.apmobilesecuritysdk.e.d;
import com.alipay.apmobilesecuritysdk.e.g;
import com.alipay.apmobilesecuritysdk.e.h;
import com.alipay.apmobilesecuritysdk.e.i;
import com.alipay.apmobilesecuritysdk.f.b;
import com.alipay.apmobilesecuritysdk.otherid.UmidSdkWrapper;
import com.alipay.apmobilesecuritysdk.otherid.UtdidWrapper;
import com.alipay.sdk.m.a0.f;
import java.util.HashMap;
import java.util.Map;
import org.android.agoo.message.MessageService;

/* JADX INFO: loaded from: classes.dex */
public class APSecuritySdk implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static APSecuritySdk f5168a;
    public static APSecBgCheckerInterface bgChecker;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static IDeviceInfo f5169c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static Object f5170d = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Context f5171b;

    public interface InitResultListener {
        void onResult(TokenResult tokenResult);
    }

    public class TokenResult {
        public String apdid;
        public String apdidToken;
        public String clientKey;
        public String umidToken;

        public TokenResult() {
        }
    }

    public APSecuritySdk(Context context) {
        this.f5171b = context;
    }

    public static IDeviceInfo getDeviceInfo() {
        return f5169c;
    }

    public static APSecuritySdk getInstance(Context context) {
        if (f5168a == null) {
            synchronized (f5170d) {
                if (f5168a == null) {
                    f5168a = new APSecuritySdk(context);
                }
            }
        }
        return f5168a;
    }

    public static String getUtdid(Context context) {
        return UtdidWrapper.getUtdid(context);
    }

    public static void registerBgChecker(APSecBgCheckerInterface aPSecBgCheckerInterface) {
        bgChecker = aPSecBgCheckerInterface;
    }

    public static void registerDeviceInfo(IDeviceInfo iDeviceInfo) {
        f5169c = iDeviceInfo;
    }

    @Override // com.alipay.sdk.m.a0.f
    public String getAndroidId() {
        IDeviceInfo iDeviceInfo = f5169c;
        if (iDeviceInfo != null) {
            return iDeviceInfo.getAndroidId();
        }
        return null;
    }

    public String getApdidToken() {
        String strA = a.a(this.f5171b, "");
        if (com.alipay.sdk.m.z.a.a(strA)) {
            initToken(0, new HashMap(), null);
        }
        return strA;
    }

    public String getSdkName() {
        return "APPSecuritySDK-ALIPAYSDK";
    }

    public String getSdkVersion() {
        return "3.4.0.202303020703";
    }

    @Override // com.alipay.sdk.m.a0.f
    public String getSubscriberId() {
        IDeviceInfo iDeviceInfo = f5169c;
        if (iDeviceInfo != null) {
            return iDeviceInfo.getSubscriberId();
        }
        return null;
    }

    public synchronized TokenResult getTokenResult() {
        TokenResult tokenResult;
        tokenResult = new TokenResult();
        try {
            tokenResult.apdidToken = a.a(this.f5171b, "");
            tokenResult.clientKey = h.f(this.f5171b);
            tokenResult.apdid = a.a(this.f5171b);
            tokenResult.umidToken = UmidSdkWrapper.getSecurityToken(this.f5171b);
            if (com.alipay.sdk.m.z.a.a(tokenResult.apdid) || com.alipay.sdk.m.z.a.a(tokenResult.apdidToken) || com.alipay.sdk.m.z.a.a(tokenResult.clientKey)) {
                initToken(0, new HashMap(), null);
            }
        } catch (Throwable unused) {
        }
        return tokenResult;
    }

    public void initToken(int i2, Map<String, String> map, final InitResultListener initResultListener) {
        com.alipay.apmobilesecuritysdk.b.a.a().a(i2);
        String strB = h.b(this.f5171b);
        String strC = com.alipay.apmobilesecuritysdk.b.a.a().c();
        if (com.alipay.sdk.m.z.a.b(strB) && !com.alipay.sdk.m.z.a.a(strB, strC)) {
            com.alipay.apmobilesecuritysdk.e.a.a(this.f5171b);
            d.a(this.f5171b);
            g.a(this.f5171b);
            i.h();
        }
        if (!com.alipay.sdk.m.z.a.a(strB, strC)) {
            h.c(this.f5171b, strC);
        }
        String strA = com.alipay.sdk.m.z.a.a(map, "utdid", "");
        String strA2 = com.alipay.sdk.m.z.a.a(map, "tid", "");
        String strA3 = com.alipay.sdk.m.z.a.a(map, "userId", "");
        if (com.alipay.sdk.m.z.a.a(strA)) {
            strA = UtdidWrapper.getUtdid(this.f5171b);
        }
        final HashMap map2 = new HashMap();
        map2.put("utdid", strA);
        map2.put("tid", strA2);
        map2.put("userId", strA3);
        map2.put("appName", "");
        map2.put("appKeyClient", "");
        map2.put("appchannel", "");
        map2.put("rpcVersion", MessageService.MSG_ACCS_NOTIFY_CLICK);
        b.a().a(new Runnable() { // from class: com.alipay.apmobilesecuritysdk.face.APSecuritySdk.1
            @Override // java.lang.Runnable
            public void run() {
                new a(APSecuritySdk.this.f5171b).a(map2);
                InitResultListener initResultListener2 = initResultListener;
                if (initResultListener2 != null) {
                    initResultListener2.onResult(APSecuritySdk.this.getTokenResult());
                }
            }
        });
    }

    @Override // com.alipay.sdk.m.a0.f
    public boolean isBackgroundRunning() {
        APSecBgCheckerInterface aPSecBgCheckerInterface = bgChecker;
        if (aPSecBgCheckerInterface != null) {
            return aPSecBgCheckerInterface.isBackgroundRunning();
        }
        return false;
    }
}
