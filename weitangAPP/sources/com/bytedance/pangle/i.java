package com.bytedance.pangle;

import android.app.Application;
import android.content.pm.PackageInfo;
import android.content.pm.ProviderInfo;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.bytedance.pangle.apm.ApmUtils;
import com.bytedance.pangle.log.IZeusReporter;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.plugin.Plugin;
import com.bytedance.pangle.provider.ContentProviderManager;
import com.bytedance.pangle.servermanager.MainServerManager;
import com.bytedance.pangle.util.FieldUtils;
import com.bytedance.pangle.util.MethodUtils;
import com.bytedance.pangle.util.j;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class i {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static volatile i f6114d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f6115a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<ZeusPluginStateListener> f6116b = new CopyOnWriteArrayList();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<ZeusPluginEventCallback> f6117c = new ArrayList();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Handler f6118e = new Handler(Looper.getMainLooper());

    public static i a() {
        if (f6114d == null) {
            synchronized (i.class) {
                if (f6114d == null) {
                    f6114d = new i();
                }
            }
        }
        return f6114d;
    }

    private static void b() {
        ProviderInfo[] providerInfoArr;
        try {
            PackageInfo packageInfo = Zeus.getAppApplication().getPackageManager().getPackageInfo(Zeus.getAppApplication().getPackageName(), 8);
            if (packageInfo != null && (providerInfoArr = packageInfo.providers) != null) {
                for (ProviderInfo providerInfo : providerInfoArr) {
                    if (!TextUtils.isEmpty(providerInfo.authority)) {
                        if (providerInfo.authority.contains(Zeus.getAppApplication().getPackageName() + ".pangle.servermanager.")) {
                            String str = (TextUtils.isEmpty(providerInfo.processName) || !providerInfo.processName.contains(":")) ? "main" : providerInfo.processName.split(":")[1];
                            if (Zeus.getServerManagerHashMap().get(str) == null || !TextUtils.equals(str, "main") || !TextUtils.equals(providerInfo.name, MainServerManager.class.getName())) {
                                Zeus.getServerManagerHashMap().put(str, providerInfo);
                            }
                        }
                    }
                }
                return;
            }
            ZeusLogger.errReport(ZeusLogger.TAG_INIT, "initServerManager failed. packageInfo:".concat(String.valueOf(packageInfo)));
        } catch (Exception e2) {
            throw new RuntimeException(e2);
        }
    }

    private Object[] c() {
        Object[] array;
        synchronized (this.f6117c) {
            array = !this.f6117c.isEmpty() ? this.f6117c.toArray() : null;
        }
        return array == null ? new Object[0] : array;
    }

    public final synchronized void a(Application application, boolean z) {
        if (this.f6115a) {
            ZeusLogger.w(ZeusLogger.TAG_INIT, "ZeusManager zeus has been inited!");
            return;
        }
        a(3000, 0, null, -1, null);
        Zeus.setAppContext(application);
        GlobalParam globalParam = GlobalParam.getInstance();
        globalParam.init();
        if (application != null) {
            ZeusLogger.setDebug(globalParam.isDebug());
            ZeusLogger.i(ZeusLogger.TAG_INIT, "ZeusManager init, context = " + application + ", hParam = " + globalParam);
            com.bytedance.pangle.d.e.a(new Runnable() { // from class: com.bytedance.pangle.i.1
                @Override // java.lang.Runnable
                public final void run() {
                    j.b();
                }
            });
            if (GlobalParam.getInstance().isPostBgDexOptByInit()) {
                com.bytedance.pangle.e.f.a();
            }
            if (z) {
                Zeus.onPrivacyAgreed();
            }
            com.bytedance.pangle.c.b bVarA = com.bytedance.pangle.c.b.a();
            com.bytedance.pangle.c.a aVar = new com.bytedance.pangle.c.a() { // from class: com.bytedance.pangle.i.2
                @Override // com.bytedance.pangle.c.a
                public final void a(String str, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3) {
                    if (jSONObject == null) {
                        jSONObject = new JSONObject();
                    }
                    if (jSONObject2 == null) {
                        jSONObject2 = new JSONObject();
                    }
                    if (jSONObject3 == null) {
                        jSONObject3 = new JSONObject();
                    }
                    String strA = null;
                    if (Zeus.getAppApplication() != null) {
                        Zeus.getAppApplication();
                        strA = com.bytedance.pangle.d.d.a(com.bytedance.pangle.d.d.a());
                    }
                    String packageName = Zeus.getAppApplication() != null ? Zeus.getAppApplication().getPackageName() : "";
                    if (strA == null) {
                        strA = "unknown";
                    }
                    try {
                        jSONObject.putOpt(ContentProviderManager.PLUGIN_PROCESS_NAME, com.bytedance.pangle.log.b.a(strA));
                        jSONObject.putOpt("host_package_name", packageName);
                        Plugin plugin = Zeus.getPlugin(jSONObject.optString("plugin_package_name", ""), false);
                        jSONObject.putOpt("plugin_api_version", com.bytedance.pangle.log.b.a(Integer.valueOf(plugin != null ? plugin.getApiVersionCode() : -1)));
                        jSONObject.putOpt("zeus_sdk_version", com.bytedance.pangle.log.b.a("0.0.1-beta.4200.115-bugfix.16-pangle"));
                        ZeusLogger.v(ZeusLogger.TAG_REPORTER, "eventName: " + str + "\ncategoryData:" + jSONObject.toString(1) + "\nmetricData:" + jSONObject2.toString(1) + "\nlogExtrData:" + jSONObject3.toString(1));
                        IZeusReporter reporter = GlobalParam.getInstance().getReporter();
                        if (reporter != null) {
                            JSONObject jSONObject4 = new JSONObject();
                            Iterator<String> itKeys = jSONObject.keys();
                            while (itKeys.hasNext()) {
                                String next = itKeys.next();
                                jSONObject4.putOpt(next, jSONObject.opt(next));
                            }
                            Iterator<String> itKeys2 = jSONObject2.keys();
                            while (itKeys2.hasNext()) {
                                String next2 = itKeys2.next();
                                jSONObject4.putOpt(next2, jSONObject2.opt(next2));
                            }
                            Iterator<String> itKeys3 = jSONObject3.keys();
                            while (itKeys3.hasNext()) {
                                String next3 = itKeys3.next();
                                jSONObject4.putOpt(next3, jSONObject3.opt(next3));
                            }
                            reporter.report(str, jSONObject4);
                        }
                        ApmUtils.getApmInstance().monitorEvent(str, jSONObject, jSONObject2, jSONObject3);
                    } catch (JSONException e2) {
                        ZeusLogger.w(ZeusLogger.TAG_REPORTER, e2.getMessage(), e2);
                    }
                }
            };
            synchronized (bVarA.f5966a) {
                bVarA.f5966a.add(aVar);
            }
            if (!globalParam.isCloseFlipped()) {
                b.a();
            }
            if (Build.VERSION.SDK_INT == 29) {
                com.bytedance.pangle.d.e.a(new Runnable() { // from class: com.bytedance.pangle.i.3
                    @Override // java.lang.Runnable
                    public final void run() {
                        try {
                            MethodUtils.invokeStaticMethod(Class.forName("com.android.server.SystemConfig"), "getInstance", new Object[0]);
                        } catch (Throwable unused) {
                        }
                    }
                });
            }
            if (com.bytedance.pangle.util.i.j()) {
                try {
                    FieldUtils.writeField(com.bytedance.pangle.d.a.a(), "mHiddenApiWarningShown", Boolean.TRUE);
                    ZeusLogger.w(ZeusLogger.TAG_INIT, "ZeusManager disableApiWarningShownForAndroidP, true");
                } catch (Exception e2) {
                    ZeusLogger.errReport(ZeusLogger.TAG_INIT, "disableApiWarningShownForAndroidP failed", e2);
                }
            }
            b();
            ContentProviderManager.getInstance().initSystemContentProviderInfo();
            if (!globalParam.closeHookHuaweiOnInit()) {
                Zeus.hookHuaWeiVerifier(application);
            }
            this.f6115a = true;
            a(ZeusPluginEventCallback.EVENT_FINISH_INITIALIZATION, 0, null, -1, null);
            return;
        }
        throw new IllegalArgumentException("context must be not null !!!");
    }

    public final void a(final int i2, final int i3, @Nullable final String str, final int i4, @Nullable final Throwable th) {
        for (final Object obj : c()) {
            this.f6118e.post(new Runnable() { // from class: com.bytedance.pangle.i.4
                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        ((ZeusPluginEventCallback) obj).onPluginEvent(i2, i3, str, i4, th);
                    } catch (Throwable unused) {
                    }
                }
            });
        }
    }
}
