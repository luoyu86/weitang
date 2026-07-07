package com.bytedance.sdk.openadsdk.api.plugin;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import c.d.a.a.a.a.b;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.Initializer;
import com.bykv.vk.openvk.api.proto.Result;
import com.bytedance.android.openliveplugin.process.LiveProcessUtils;
import com.bytedance.pangle.Zeus;
import com.bytedance.sdk.openadsdk.AdConfig;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import com.bytedance.sdk.openadsdk.TTAppContextHolder;
import com.bytedance.sdk.openadsdk.TTPluginListener;
import com.bytedance.sdk.openadsdk.api.ok;
import com.bytedance.sdk.openadsdk.api.plugin.s;
import com.bytedance.sdk.openadsdk.live.ILiveAdCustomConfig;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import dalvik.system.BaseDexClassLoader;
import java.lang.reflect.Method;
import java.util.concurrent.ExecutorService;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class n extends com.bytedance.sdk.openadsdk.api.ok {
    private static final ok ok = new ok();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private volatile Initializer f6347a;
    private bl bl;
    private com.bytedance.sdk.openadsdk.ok.a s = new com.bytedance.sdk.openadsdk.ok.a() { // from class: com.bytedance.sdk.openadsdk.api.plugin.n.1
        @Override // com.bytedance.sdk.openadsdk.ok.a
        public Bridge ok(int i2) {
            return n.this.ok(i2);
        }
    };

    public static final class ok extends ok.bl {
        private ok() {
        }

        @Override // com.bytedance.sdk.openadsdk.api.ok.bl
        public void ok(Throwable th) {
            s.ok(th);
        }

        @Override // com.bytedance.sdk.openadsdk.api.ok.bl
        public Object ok(Object obj) {
            boolean z = obj instanceof TTPluginListener;
            if (z) {
                s.ok(TTAppContextHolder.getContext()).ok((TTPluginListener) obj);
            }
            if (!z) {
                return obj instanceof ILiveAdCustomConfig ? com.bytedance.sdk.openadsdk.live.a.ok((ILiveAdCustomConfig) obj) : obj;
            }
            TTPluginListener tTPluginListener = (TTPluginListener) obj;
            return s.ok(TTAppContextHolder.getContext()).ok(tTPluginListener.packageName(), tTPluginListener.config());
        }
    }

    @Override // com.bytedance.sdk.openadsdk.api.ok
    public boolean a(Context context, AdConfig adConfig, TTAdSdk.InitCallback initCallback) {
        super.a(context, adConfig, initCallback);
        this.bl = bl.ok(MediationConstant.EXTRA_DURATION);
        if (LiveProcessUtils.inLiveProcess(TTAppContextHolder.getContext()).booleanValue()) {
            return false;
        }
        a.ok(adConfig);
        if (Build.VERSION.SDK_INT >= 21) {
            return true;
        }
        a(b.ok().ok(false).ok(4204).ok("Only support >= 5.0").a());
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.api.ok
    public com.bytedance.sdk.openadsdk.ok.a bl() {
        return this.s;
    }

    @Override // com.bytedance.sdk.openadsdk.api.ok
    public void ok(Result result) {
        if (!result.isSuccess()) {
            a.ok(result.code(), result.message(), 0L);
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("action", 0);
        ExecutorService executorService = (ExecutorService) TTAdSdk.getAdManager().getExtra(ExecutorService.class, bundle);
        if (executorService != null) {
            com.bytedance.sdk.openadsdk.n.ok.ok().ok(executorService);
        }
        a.ok();
    }

    @Override // com.bytedance.sdk.openadsdk.api.ok
    public void a(Context context, c.d.a.a.a.a.a aVar) {
        bl blVarOk = this.bl;
        if (blVarOk == null) {
            blVarOk = bl.ok(MediationConstant.EXTRA_DURATION);
        }
        blVarOk.a("wait_asyn_cost");
        try {
            Initializer initializerOk = ok(blVarOk);
            try {
                if (initializerOk != null) {
                    ok(initializerOk.getManager());
                    try {
                        blVarOk.ok();
                        JSONObject jSONObject = new JSONObject();
                        blVarOk.ok(jSONObject, 20L);
                        jSONObject.put("zeus", s.ok(TTAppContextHolder.getContext()).ok());
                        initializerOk.init(context, aVar.ok(9, jSONObject).a());
                        if (context != null) {
                            Zeus.hookHuaWeiVerifier((Application) context.getApplicationContext());
                            return;
                        }
                        return;
                    } catch (Exception e2) {
                        Zeus.unInstallPlugin("com.byted.pangle.m");
                        a(b.ok().ok(false).ok(4207).ok("Init error").a());
                        throw e2;
                    }
                }
                a(b.ok().ok(false).ok(TTAdConstant.INIT_FAILED_CREATE_INITIALIZER_FAILED).ok("Init error").a());
            } catch (Throwable th) {
                th.printStackTrace();
                a(b.ok().ok(false).ok(4203).ok("UnExpected initializer error :" + th.getMessage()).a());
            }
        } catch (com.bytedance.sdk.openadsdk.api.plugin.ok e3) {
            e3.printStackTrace();
            a(b.ok().ok(false).ok(e3.ok()).ok(e3.getMessage()).a());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Bridge ok(int i2) {
        if (i2 == 2) {
            return com.bytedance.sdk.openadsdk.live.a.ok();
        }
        if (i2 == 3) {
            return com.bytedance.sdk.openadsdk.downloadnew.s.ok(TTAppContextHolder.getContext());
        }
        if (i2 != 4) {
            return null;
        }
        return com.bytedance.sdk.openadsdk.api.plugin.ok.ok.ok();
    }

    @Override // com.bytedance.sdk.openadsdk.api.ok
    public boolean ok(Context context, c.d.a.a.a.a.a aVar) {
        if (this.f6347a == null) {
            return false;
        }
        this.f6347a.init(context, aVar.a());
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.api.ok
    public boolean ok() {
        if (this.f6347a != null) {
            return this.f6347a.isInitSuccess();
        }
        return false;
    }

    private Initializer ok(bl blVar) throws com.bytedance.sdk.openadsdk.api.plugin.ok {
        if (this.f6347a == null) {
            synchronized (this) {
                if (this.f6347a == null) {
                    com.bytedance.sdk.openadsdk.api.bl.a("TTPluginManager", "Create initializer");
                    this.f6347a = a(blVar);
                }
            }
        }
        return this.f6347a;
    }

    @Override // com.bytedance.sdk.openadsdk.api.ok
    public ok.bl a() {
        return ok;
    }

    private static Initializer a(bl blVar) throws com.bytedance.sdk.openadsdk.api.plugin.ok {
        try {
            blVar.a("call_create_initializer");
            BaseDexClassLoader baseDexClassLoaderOk = s.ok(TTAppContextHolder.getContext()).ok(blVar);
            if (baseDexClassLoaderOk != null) {
                Class<?> clsLoadClass = baseDexClassLoaderOk.loadClass(TTAdSdk.INITIALIZER_CLASS_NAME);
                blVar.a("get_init_class_cost");
                Bundle bundle = new Bundle();
                bundle.putLong("call_init_time", blVar.a());
                bundle.putSerializable(PluginConstants.KEY_PL_UPDATE_EVENT_LISTENER, new s.bl());
                blVar.a("create_bundle_cost");
                Method declaredMethod = clsLoadClass.getDeclaredMethod("getNewInstance", Bundle.class);
                blVar.a("get_init_method_cost");
                try {
                    Initializer initializer = (Initializer) declaredMethod.invoke(null, bundle);
                    blVar.a("get_init_instance_cost");
                    com.bytedance.sdk.openadsdk.api.bl.a("TTPluginManager", "Create initializer success");
                    return initializer;
                } catch (Throwable th) {
                    Zeus.unInstallPlugin("com.byted.pangle.m");
                    throw th;
                }
            }
            throw new com.bytedance.sdk.openadsdk.api.plugin.ok(4205, "Get initializer failed");
        } catch (Throwable th2) {
            if (th2 instanceof com.bytedance.sdk.openadsdk.api.plugin.ok) {
                throw new com.bytedance.sdk.openadsdk.api.plugin.ok(4205, "(" + th2.ok() + ", " + th2.getMessage() + ")");
            }
            throw new com.bytedance.sdk.openadsdk.api.plugin.ok(4206, th2.getMessage());
        }
    }
}
