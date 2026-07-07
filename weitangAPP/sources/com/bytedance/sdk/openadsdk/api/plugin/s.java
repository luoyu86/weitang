package com.bytedance.sdk.openadsdk.api.plugin;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import c.d.a.a.a.a.b;
import com.alibaba.android.arouter.utils.Consts;
import com.bykv.vk.openvk.api.proto.EventListener;
import com.bykv.vk.openvk.api.proto.Result;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.pangle.GlobalParam;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.ZeusPluginInstallListener;
import com.bytedance.pangle.ZeusPluginStateListener;
import com.bytedance.pangle.download.PluginDownloadBean;
import com.bytedance.pangle.log.IZeusLogger;
import com.bytedance.pangle.log.IZeusReporter;
import com.bytedance.pangle.plugin.Plugin;
import com.bytedance.sdk.openadsdk.TTAdManager;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import com.bytedance.sdk.openadsdk.TTAppContextHolder;
import com.bytedance.sdk.openadsdk.TTPluginListener;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.taobao.accs.common.Constants;
import dalvik.system.BaseDexClassLoader;
import java.io.File;
import java.io.Serializable;
import java.util.HashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class s {
    private static volatile TTPluginListener j;
    private static volatile BaseDexClassLoader s;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final Context f6350q;
    private static final String ok = "next" + File.separator;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final HashMap<String, TTPluginListener> f6348a = new HashMap<>();
    private static final HashMap<String, Handler> bl = new HashMap<>();
    private static volatile s n = null;
    private final CountDownLatch kf = new CountDownLatch(1);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private volatile boolean f6349h = false;
    private volatile String p = "none";
    private JSONObject k = new JSONObject();
    private EventListener r = null;

    public static final class a implements IZeusLogger {
        private a() {
        }

        @Override // com.bytedance.pangle.log.IZeusLogger
        public void e(String str, String str2, Throwable th) {
            com.bytedance.sdk.openadsdk.api.bl.bl(str, str2, th);
        }

        @Override // com.bytedance.pangle.log.IZeusLogger
        public void i(String str, String str2) {
            com.bytedance.sdk.openadsdk.api.bl.bl(str, str2);
        }

        @Override // com.bytedance.pangle.log.IZeusLogger
        public void v(String str, String str2) {
            com.bytedance.sdk.openadsdk.api.bl.ok(str, str2);
        }

        @Override // com.bytedance.pangle.log.IZeusLogger
        public void w(String str, String str2) {
            com.bytedance.sdk.openadsdk.api.bl.s(str, str2);
        }

        @Override // com.bytedance.pangle.log.IZeusLogger
        public void w(String str, String str2, Throwable th) {
            com.bytedance.sdk.openadsdk.api.bl.a(str, str2, th);
        }
    }

    public static final class bl implements EventListener, Serializable {
        private void ok(ok okVar) {
            try {
                if (TextUtils.isEmpty(okVar.mPackageName) || !okVar.mPackageName.equals("com.byted.pangle.m")) {
                    return;
                }
                s.ok(TTAppContextHolder.getContext()).a();
            } catch (Exception unused) {
            }
        }

        @Override // com.bykv.vk.openvk.api.proto.EventListener
        public ValueSet onEvent(int i2, Result result) {
            c.d.a.a.a.a.a aVarOk = c.d.a.a.a.a.a.ok();
            if (i2 == 1) {
                ValueSet valueSetValues = result.values();
                if (valueSetValues == null) {
                    return null;
                }
                String strStringValue = valueSetValues.stringValue(3);
                int iCode = result.code();
                if (!result.isSuccess()) {
                    com.bytedance.sdk.openadsdk.api.bl.s("TTPluginManager", "plugin update received failed");
                    s.bl(strStringValue, iCode);
                    return null;
                }
                ok okVarS = s.s(valueSetValues.stringValue(2));
                if (okVarS == null || TextUtils.isEmpty(okVarS.mPackageName)) {
                    com.bytedance.sdk.openadsdk.api.bl.s("TTPluginManager", "plugin update received with invalid config");
                    return null;
                }
                com.bytedance.sdk.openadsdk.api.bl.s("TTPluginManager", "plugin update received: " + okVarS.mPackageName);
                if (okVarS.isRevert()) {
                    Zeus.unInstallPlugin(okVarS.mPackageName);
                } else {
                    ok(okVarS);
                    if (s.a(okVarS)) {
                        aVarOk.ok(4, true);
                    }
                }
            }
            return aVarOk.a();
        }
    }

    public static final class ok extends PluginDownloadBean {
        public String ok = "";

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public File f6353a = null;

        public ok() {
            this.mBackupUrlList = null;
        }
    }

    private s(Context context) {
        this.f6350q = context.getApplicationContext();
        GlobalParam.getInstance().closeHookHuaweiOnInit(true);
        a(context.getApplicationContext());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static ok s(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return ok(new JSONObject(str));
        } catch (JSONException unused) {
            com.bytedance.sdk.openadsdk.api.bl.n("TTPluginManager", "Invalid plugin info:" + str);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bl(String str) {
        Plugin plugin = Zeus.getPlugin(str, false);
        try {
            if (plugin.mClassLoader != null) {
                TTAdSdk.getAdManager().register(c.d.a.a.a.a.a.ok(3).ok(0, 1).ok(1, str).ok(2, plugin.mClassLoader).a());
            }
        } catch (Throwable th) {
            com.bytedance.sdk.openadsdk.api.bl.ok("TTPluginManager", "initPluginService failed in " + str, th);
        }
    }

    private void a(Context context) {
        try {
            IZeusReporter iZeusReporter = new IZeusReporter() { // from class: com.bytedance.sdk.openadsdk.api.plugin.s.1
                @Override // com.bytedance.pangle.log.IZeusReporter
                public void report(String str, JSONObject jSONObject) {
                    if ("load_finish".equals(str) && jSONObject != null && "com.byted.pangle.m".endsWith(jSONObject.optString("plugin_package_name"))) {
                        try {
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject2.put(MediationConstant.EXTRA_DURATION, jSONObject.opt(MediationConstant.EXTRA_DURATION));
                            jSONObject2.put(Constants.SHARED_MESSAGE_ID_FILE, jSONObject.opt(Constants.SHARED_MESSAGE_ID_FILE));
                            s.this.k.put("zeus", jSONObject2);
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    }
                    if (TTAdSdk.isInitSuccess()) {
                        com.bytedance.sdk.openadsdk.api.plugin.a.ok(str, jSONObject);
                    } else {
                        com.bytedance.sdk.openadsdk.api.plugin.a.a(str, jSONObject);
                    }
                }
            };
            GlobalParam globalParam = GlobalParam.getInstance();
            globalParam.setReporter(iZeusReporter);
            globalParam.setCheckPermission(false);
            globalParam.setDownloadDir(bl(context));
            globalParam.setLogger(new a());
            globalParam.setSignature("com.byted.pangle.m", "MIIDfTCCAmWgAwIBAgIEfRwYPjANBgkqhkiG9w0BAQsFADBvMQswCQYDVQQGEwJDTjEQMA4GA1UECBMHQmVpamluZzEQMA4GA1UEBxMHQmVpamluZzESMBAGA1UEChMJQnl0ZURhbmNlMQ8wDQYDVQQLEwZQYW5nbGUxFzAVBgNVBAMTDkNodWFuIFNoYW4gSmlhMB4XDTIxMTEwODA2MjQzOVoXDTQ2MTEwMjA2MjQzOVowbzELMAkGA1UEBhMCQ04xEDAOBgNVBAgTB0JlaWppbmcxEDAOBgNVBAcTB0JlaWppbmcxEjAQBgNVBAoTCUJ5dGVEYW5jZTEPMA0GA1UECxMGUGFuZ2xlMRcwFQYDVQQDEw5DaHVhbiBTaGFuIEppYTCCASIwDQYJKoZIhvcNAQEBBQADggEPADCCAQoCggEBAIBKeRL+4mfCn1SLYv6OemfwwItkjlLPyqOEugkV6lanFTcZgLwEl5LIkL0y28UncPtMX1Mii6DzCdJ/plw7S9+RT/hYDneu339IKWojaU2qai/5FokHlQ0MMnYl5yry00ghVPsl1u+03cQA2ZnjIMiFhrBJpQzHt7IYvq2aEEMBcY8uT7iFoBI848e1mL1joVS2z02C3NliP7ZNARkXH+rTQAlCJulT5IZk+V/PTaKqzgNrkhsKh0/tBmU7m8u79x/xpgGsE19H18AgS4P/9/MDCRe2Z35boZeccaUy2MXCwv3djzUcDk3rRzQPYzdpyyRnrFMuhiKesc5VHgUMs9kCAwEAAaMhMB8wHQYDVR0OBBYEFENENrNWGzc2WhxdvhoMDs57U70zMA0GCSqGSIb3DQEBCwUAA4IBAQAHqDCrmvyBBmIGXwuL1rwS/Qv9ZJIZykBIaNMm+H1IfitCl4yXd9N2n+PjE0UZtxZ21UZOt9wAr+RFiSl5YRXqpt7WLARTy4YW3RiQ+wiL7bshzeSYBoSiC427Bfeq0WjwY0/jHlr8uouppyJOz++6U9hrYX2EW/6UjH5XlWiKQJ6b2ZzPcP8Xpg/TJn4tWvXJP6jw9kRRP2GmMttY78leWQst2QEZILmWJubXRLPj9O+qx2uP9oGTD4sc1vb9hzkOHBIHzGaalqLFbbGaeFpLFHoGTsnOfPTwUVKDZYmxbkcmR1bp7eYOW+nSQNMLn0FjDewZl5l37Sa/gz0WVHon");
            globalParam.setSignature("com.byted.csj.ext", "MIIDezCCAmOgAwIBAgIENkE1KDANBgkqhkiG9w0BAQsFADBtMQswCQYDVQQGEwI4NjEQMA4GA1UECBMHYmVpamluZzEQMA4GA1UEBxMHYmVpamluZzESMBAGA1UEChMJYnl0ZWRhbmNlMRIwEAYDVQQLEwlieXRlZGFuY2UxEjAQBgNVBAMTCWJ5dGVkYW5jZTAgFw0yMjExMDIwODI3MzlaGA8yMDUwMDMyMDA4MjczOVowbTELMAkGA1UEBhMCODYxEDAOBgNVBAgTB2JlaWppbmcxEDAOBgNVBAcTB2JlaWppbmcxEjAQBgNVBAoTCWJ5dGVkYW5jZTESMBAGA1UECxMJYnl0ZWRhbmNlMRIwEAYDVQQDEwlieXRlZGFuY2UwggEiMA0GCSqGSIb3DQEBAQUAA4IBDwAwggEKAoIBAQCc9Z2F3xxOMX1qTXMy2aPmS9OSkqrp8C8bHwS1hkNVR4umKREuqOn73INNo+R706jaCVnlPwxDwWjtX6H74DE4CveivyM9f2wNC3yIyDW+5j7lW/keTQcOlGLDEJQv4O/6FbB/jNU6epjyNaNIZhgZcvTpgaSixbdyHzRTFmvMh+WovdVK/J9LnHOQ+pmPZj7NB6MQRGMUrPEotLHQca3cmnLrnPAaZQaVoaFE9lOt9syyqEuf361SprNIGDtbkJuX3EqV/QOKWFwZX94IS7ZGSvfyCojcD4kaUSbaSoZC7zEuBb7l69g+ZMrJ/v6wkm01wxsNNssUwF7k6Sp0zubbAgMBAAGjITAfMB0GA1UdDgQWBBSxk+gVdDco1dP65hP67qoKNlMEYDANBgkqhkiG9w0BAQsFAAOCAQEAfosExl/AYEbS2xqHBTHa28cvnp/SElUQuzW6aWLqkfk9cxmFSI/euUV3/eB8RN+U2X47Y05u6+XUxTv0tSSEtyXNawm0qWH8jkR4gZY38YqBChKjhea668oT5X3Uocrw7SYXO/BfI8SKPa0uI/U8Cyl3uctbmmq/pPUkd3mKAy+HgyJoThD6K0oyiADlygngUMVTv6Uvid4qPj/bBnxI+LvVeX4l1dxGqWkiafQW9sz+RbFdge3X2XsSH4eo01BsCwOYEv1lHO2FrbAtFNpnIsSqrERdFaAJZ3tlJmg9bA03png8A2AajEjkhaOhduJB8zkSlvHNpoQMIAS9WtkG/w==");
            globalParam.setSignature("com.byted.live.lite", "MIIDSTCCAjGgAwIBAgIEaLy5tzANBgkqhkiG9w0BAQsFADBVMQswCQYDVQQGEwIxMTEMMAoGA1UECBMDMTExMQ4wDAYDVQQHEwUxMTExMTEMMAoGA1UEChMDMTExMQwwCgYDVQQLEwMxMTExDDAKBgNVBAMTAzExMTAeFw0yMDEyMDMxMjQyMTJaFw00NTExMjcxMjQyMTJaMFUxCzAJBgNVBAYTAjExMQwwCgYDVQQIEwMxMTExDjAMBgNVBAcTBTExMTExMQwwCgYDVQQKEwMxMTExDDAKBgNVBAsTAzExMTEMMAoGA1UEAxMDMTExMIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA45E52YdkJm4gPCXZq7KDoM1h6pgSswllC/CwDOmh8pDGvX4ROaYP1vr2biRlXMHg7G0iXpxWVdlTtx+4QFd3dC+cGJQk0f6apGo2n2RpMA0zIsSf0VO1a3GjWLei5INo+4RDdciqJ4jfsoqBIjZETRkky+UU4eO/oyrAwOu4KdMln3Bg3u7eHWU4kMFrXxrRruT3Q/9gzlO90yQa0CZPWVDrk6cGJtJwJGhWm+62S3U8D26HE++eGP7ve83QBDGtKqx7HpCAFWUiYBgXGq12H0amQDkKcPcr/EFCaBlombSgkN0t6zBX80m+wcUPC75IBTmMV/DT2dXcgjZ2I1JSCQIDAQABoyEwHzAdBgNVHQ4EFgQUPDyIeKI0KhZFPHyn36gMMIYrpukwDQYJKoZIhvcNAQELBQADggEBAHkl0DoCRwn+XKsDJE+wGMpBBqUDzL6DSOnJx4SNqb7YZZU0ThcDK7jY4If3QRkvMio6ODrVZc2U/m/Tc3VeMk5h2W2UZRUWHNH3k9Xe0720uL20ZeH2Y6IG4L5HG8kIbTbFtX3gJpPG/xAcez+CzyCFLWQAZt1N+csG0syWkXJ0Nryq8VrgSCyCXD1KzFxrOe+65wtu50Vi68Vlbk7BZe/G8Qm0RhKmxq5BPMBJ4uY3be+03Ba5qC//o1XQHOEAjrJKXcN5wqHdFZTkmuxVyIPogZOzx4JlNl0zOrYGDJxp7aZfKF9FkXQyF7x0Ns3mZEtjx/+flXRzAAU9MDhPr/0=");
            Zeus.registerPluginStateListener(new ZeusPluginStateListener() { // from class: com.bytedance.sdk.openadsdk.api.plugin.s.2
                @Override // com.bytedance.pangle.ZeusPluginStateListener
                public void onPluginStateChange(String str, int i2, Object... objArr) {
                    com.bytedance.sdk.openadsdk.api.bl.a("TTPluginManager", str + " state changed, " + i2);
                    if (i2 != 9 || TextUtils.equals(str, "com.byted.pangle.m")) {
                        return;
                    }
                    s.this.bl(str);
                }
            });
            globalParam.closeBgDex2oat(true);
            Zeus.init((Application) context, true);
            Zeus.registerPluginInstallListener(new ZeusPluginInstallListener() { // from class: com.bytedance.sdk.openadsdk.api.plugin.s.3
                @Override // com.bytedance.pangle.ZeusPluginInstallListener
                public void onPluginInstall(String str, int i2, String str2) {
                    if (i2 == 7) {
                        s.this.a(str, i2);
                        return;
                    }
                    if (i2 == 6) {
                        s.this.a(str, i2);
                        if (s.this.r == null || !"com.byted.pangle.m".equals(str)) {
                            com.bytedance.sdk.openadsdk.api.bl.a("TTPluginManager", "no main pl");
                        } else {
                            s.this.r.onEvent(0, b.ok().ok(true).a());
                        }
                    }
                }
            });
            this.f6349h = true;
        } catch (Throwable th) {
            com.bytedance.sdk.openadsdk.api.bl.a("TTPluginManager", "Unexpected error for init zeus.", th);
            this.p = th.getMessage();
        }
    }

    public static s ok(Context context) {
        if (n == null) {
            synchronized (s.class) {
                if (n == null) {
                    n = new s(context);
                }
            }
        }
        return n;
    }

    private static File bl(Context context) {
        return new File(new File(context.getDir("tt_pangle_bykv_file", 0), "pangle_com.byted.pangle.m"), ok);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void bl(String str, int i2) {
        com.bytedance.sdk.openadsdk.api.bl.s("TTPluginManager", "plugin update failed");
        Bundle bundle = new Bundle();
        bundle.putInt("code", i2);
        TTPluginListener tTPluginListener = f6348a.get(str);
        if (tTPluginListener != null) {
            tTPluginListener.onPluginListener(1001, null, null, bundle);
        }
    }

    public JSONObject ok() {
        return this.k;
    }

    public BaseDexClassLoader ok(com.bytedance.sdk.openadsdk.api.plugin.bl blVar) throws Exception {
        return ok(blVar, 60000);
    }

    public BaseDexClassLoader ok(com.bytedance.sdk.openadsdk.api.plugin.bl blVar, int i2) throws Exception {
        if (this.f6349h) {
            if (!Zeus.isPluginInstalled("com.byted.pangle.m")) {
                try {
                    com.bytedance.sdk.openadsdk.api.bl.a("TTPluginManager", "wait start");
                    this.kf.await(i2, TimeUnit.MILLISECONDS);
                    com.bytedance.sdk.openadsdk.api.bl.a("TTPluginManager", "wait done");
                    blVar.a("wait_install_cost");
                } catch (Exception unused) {
                    com.bytedance.sdk.openadsdk.api.bl.a("TTPluginManager", "Install wait time out");
                    throw new com.bytedance.sdk.openadsdk.api.plugin.ok(8, "install wait timeout");
                }
            }
            boolean z = false;
            if (Zeus.isPluginLoaded("com.byted.pangle.m") || Zeus.loadPlugin("com.byted.pangle.m")) {
                s = Zeus.getPlugin("com.byted.pangle.m").mClassLoader;
                z = true;
            }
            blVar.a("get_classloader_cost");
            Zeus.installFromDownloadDir();
            if (s == null) {
                if (this.kf.getCount() != 0) {
                    com.bytedance.sdk.openadsdk.api.bl.s("TTPluginManager", "Install wait time out");
                    throw new com.bytedance.sdk.openadsdk.api.plugin.ok(8, "install wait timeout");
                }
                if (z) {
                    com.bytedance.sdk.openadsdk.api.bl.s("TTPluginManager", "Get null after load");
                    throw new com.bytedance.sdk.openadsdk.api.plugin.ok(9, "Get null after load");
                }
            }
            blVar.a("get_classloader_done");
            return s;
        }
        com.bytedance.sdk.openadsdk.api.bl.s("TTPluginManager", "Zeus init failed.");
        throw new com.bytedance.sdk.openadsdk.api.plugin.ok(4, this.p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, int i2) {
        if ("com.byted.pangle.m".equals(str) && i2 == 6) {
            com.bytedance.sdk.openadsdk.api.bl.s("TTPluginManager", "notify to end wait");
            this.kf.countDown();
        }
        ok(i2 == 6, str);
    }

    public void a(final TTPluginListener tTPluginListener) {
        com.bytedance.sdk.openadsdk.n.ok.ok().a(new Runnable() { // from class: com.bytedance.sdk.openadsdk.api.plugin.s.5
            @Override // java.lang.Runnable
            public void run() {
                String strPackageName = tTPluginListener.packageName();
                Plugin plugin = (Zeus.isPluginInstalled(strPackageName) && (Zeus.isPluginLoaded(strPackageName) || Zeus.loadPlugin(strPackageName))) ? Zeus.getPlugin(strPackageName) : null;
                StringBuilder sb = new StringBuilder();
                sb.append("Find plugin:");
                sb.append(plugin != null);
                com.bytedance.sdk.openadsdk.api.bl.a("TTPluginManager", sb.toString());
                if (plugin == null) {
                    TTPluginListener unused = s.j = tTPluginListener;
                } else {
                    s.a(plugin);
                    tTPluginListener.onPluginListener(1000, plugin.mClassLoader, plugin.mResources, null);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(Plugin plugin) {
        if (plugin == null) {
            com.bytedance.sdk.openadsdk.api.bl.s("TTPluginManager", "plugin is null.");
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("action", 0);
        bundle.putString("plugin_pkg_name", plugin.mPkgName);
        bundle.putString(PluginConstants.KEY_PLUGIN_VERSION, ok(plugin.getVersion()));
        TTAdManager adManager = TTAdSdk.getAdManager();
        if (adManager != null) {
            adManager.getExtra(Bundle.class, bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean a(ok okVar) {
        File file;
        if (okVar != null && (file = okVar.f6353a) != null) {
            boolean zSyncInstallPlugin = Zeus.syncInstallPlugin(okVar.mPackageName, file.getAbsolutePath());
            ok(zSyncInstallPlugin, okVar.mPackageName);
            return zSyncInstallPlugin;
        }
        com.bytedance.sdk.openadsdk.api.bl.s("TTPluginManager", "plugin config is null");
        return false;
    }

    public void a() {
        EventListener eventListener = this.r;
        if (eventListener != null) {
            eventListener.onEvent(1, b.ok().ok(true).a());
        }
    }

    public Bundle ok(String str, Bundle bundle) {
        String strOk = ok(str);
        if (!TextUtils.isEmpty(strOk)) {
            bundle.putString(PluginConstants.KEY_PLUGIN_VERSION, strOk);
        }
        Bundle bundle2 = new Bundle();
        bundle2.putBundle(str, bundle);
        Bundle bundle3 = new Bundle();
        bundle3.putBundle(PluginConstants.KEY_PL_CONFIG_INFO, bundle2);
        return bundle3;
    }

    public static String ok(String str) {
        Plugin plugin;
        try {
            if (!Zeus.isPluginInstalled(str) || (plugin = Zeus.getPlugin(str)) == null) {
                return null;
            }
            return ok(plugin.getVersion());
        } catch (Throwable unused) {
            com.bytedance.sdk.openadsdk.api.bl.s("TTPluginManager", "Get local version failed");
            return null;
        }
    }

    public void ok(final TTPluginListener tTPluginListener) {
        if (!this.f6349h) {
            com.bytedance.sdk.openadsdk.api.bl.s("TTPluginManager", "Zeus init failed.");
            if (tTPluginListener != null) {
                tTPluginListener.onPluginListener(1002, null, null, null);
                return;
            }
            return;
        }
        Handler handler = new Handler(Looper.getMainLooper());
        handler.postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.api.plugin.s.4
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.sdk.openadsdk.api.bl.a("TTPluginManager", "Load plugin failed, caused by timeout.");
                tTPluginListener.onPluginListener(1001, null, null, null);
            }
        }, 180000L);
        String strPackageName = tTPluginListener.packageName();
        Plugin plugin = (Zeus.isPluginInstalled(strPackageName) && (Zeus.isPluginLoaded(strPackageName) || Zeus.loadPlugin(strPackageName))) ? Zeus.getPlugin(strPackageName) : null;
        StringBuilder sb = new StringBuilder();
        sb.append("Find plugin:");
        sb.append(plugin != null);
        com.bytedance.sdk.openadsdk.api.bl.a("TTPluginManager", sb.toString());
        if (plugin != null) {
            a(plugin);
            handler.removeCallbacksAndMessages(null);
            tTPluginListener.onPluginListener(1000, plugin.mClassLoader, plugin.mResources, null);
        } else {
            f6348a.put(strPackageName, tTPluginListener);
            bl.put(strPackageName, handler);
        }
    }

    private static ok ok(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        ok okVar = new ok();
        okVar.mPackageName = jSONObject.optString("package_name");
        okVar.mVersionCode = jSONObject.optInt("version_code");
        okVar.mUrl = jSONObject.optString("download_url");
        okVar.mMd5 = jSONObject.optString(TTDownloadField.TT_MD5);
        okVar.mApiVersionMin = jSONObject.optInt("min_version");
        okVar.mApiVersionMax = jSONObject.optInt("max_version");
        okVar.ok = jSONObject.optString("sign");
        okVar.mFlag = jSONObject.optBoolean("is_revert") ? 3 : 2;
        okVar.f6353a = new File(jSONObject.optString("plugin_file"));
        return okVar;
    }

    public static String ok(int i2) {
        char[] charArray = String.valueOf(i2).toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i3 = 0; i3 < charArray.length; i3++) {
            sb.append(charArray[i3]);
            if (i3 < charArray.length - 1) {
                sb.append(Consts.DOT);
            }
        }
        return sb.toString();
    }

    private static boolean ok(TTPluginListener tTPluginListener, String str) {
        if (tTPluginListener == null || tTPluginListener.packageName() == null) {
            return false;
        }
        return tTPluginListener.packageName().equals(str);
    }

    private static void ok(boolean z, String str) {
        HashMap<String, TTPluginListener> map = f6348a;
        TTPluginListener tTPluginListener = map.get(str);
        StringBuilder sb = new StringBuilder();
        sb.append("Install dl plugin ");
        sb.append(str);
        sb.append(z ? " success" : " failed");
        sb.append(", need notify: ");
        sb.append(tTPluginListener != null);
        com.bytedance.sdk.openadsdk.api.bl.a("TTPluginManager", sb.toString());
        HashMap<String, Handler> map2 = bl;
        Handler handler = map2.get(str);
        if (z) {
            TTPluginListener tTPluginListener2 = j;
            if (!ok(tTPluginListener2, str) && (tTPluginListener == null || handler == null)) {
                return;
            }
            if (Zeus.loadPlugin(str)) {
                Plugin plugin = Zeus.getPlugin(str);
                a(plugin);
                if (handler != null) {
                    handler.removeCallbacksAndMessages(null);
                }
                if (tTPluginListener != null) {
                    tTPluginListener.onPluginListener(1000, plugin.mClassLoader, plugin.mResources, null);
                }
                if (ok(tTPluginListener2, str)) {
                    tTPluginListener2.onPluginListener(1000, plugin.mClassLoader, plugin.mResources, null);
                    j = null;
                }
            } else {
                com.bytedance.sdk.openadsdk.api.bl.a("TTPluginManager", "handle installed, load failed");
                bl(str, 1002);
            }
        } else {
            com.bytedance.sdk.openadsdk.api.bl.a("TTPluginManager", "handle installed failed");
            bl(str, 1003);
        }
        map.remove(str);
        map2.remove(str);
    }

    public static void ok(Throwable th) {
        if (th instanceof AbstractMethodError) {
            Zeus.unInstallPlugin("com.byted.pangle.m");
            com.bytedance.sdk.openadsdk.api.bl.s("TTPluginManager", "AbstractMethodError, rollback to builtin version.");
        }
    }
}
