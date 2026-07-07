package cn.admobiletop.adsuyi.a.l;

import android.text.TextUtils;
import cn.admobiletop.adsuyi.ADSuyiSdk;
import cn.admobiletop.adsuyi.adapter.oaid.OAIDManager;
import cn.admobiletop.adsuyi.config.ADSuyiInitConfig;
import cn.admobiletop.adsuyi.oaid.DeviceID;
import cn.admobiletop.adsuyi.util.ADSuyiLogUtil;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile b f3366a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static String f3367b = "cn.admobiletop.adsuyi.adapter.oaid.OAIDManager";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f3368c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f3369d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f3370e = false;

    public b() {
        if (cn.admobiletop.adsuyi.a.m.b.a(f3367b)) {
            this.f3368c = true;
        }
    }

    public String a() {
        return !this.f3368c ? "" : OAIDManager.getInstance().getAAID();
    }

    public String c() {
        if (this.f3368c) {
            try {
                if (!TextUtils.isEmpty(OAIDManager.getInstance().getOAID())) {
                    return OAIDManager.getInstance().getOAID();
                }
            } catch (Exception unused) {
            }
        }
        return !TextUtils.isEmpty(this.f3369d) ? this.f3369d : "";
    }

    public String d() {
        return !this.f3368c ? "" : OAIDManager.getInstance().getVAID();
    }

    public void e() {
        ADSuyiInitConfig config = ADSuyiSdk.getInstance().getConfig();
        if (config == null) {
            return;
        }
        if (this.f3368c) {
            OAIDManager.getInstance().setCertPath(config.getOaidCertPath());
            OAIDManager.getInstance().init(ADSuyiSdk.getInstance().getContext(), config.isCanUseOaid(), config.isDebug());
        }
        try {
            DeviceID.getOAID(ADSuyiSdk.getInstance().getContext(), new a(this));
        } catch (Throwable unused) {
        }
    }

    public void f() {
        if (this.f3370e) {
            return;
        }
        this.f3370e = true;
        ADSuyiInitConfig config = ADSuyiSdk.getInstance().getConfig();
        if (config == null || !config.isCanUseOaid()) {
            ADSuyiLogUtil.d("Oaid同步获取失败 : 不允许SDK使用oaid信息，不进行oaid初始化");
        } else if (this.f3368c) {
            try {
                OAIDManager.class.getMethod("initOaid", new Class[0]).invoke(OAIDManager.getInstance(), new Object[0]);
            } catch (Exception unused) {
            }
        }
    }

    public static b b() {
        if (f3366a == null) {
            synchronized (b.class) {
                if (f3366a == null) {
                    f3366a = new b();
                }
            }
        }
        return f3366a;
    }
}
