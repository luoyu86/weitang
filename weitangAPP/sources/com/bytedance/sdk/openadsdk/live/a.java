package com.bytedance.sdk.openadsdk.live;

import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.android.live.base.api.ILiveHostContextParam;
import com.bytedance.android.live.base.api.ILiveInitCallback;
import com.bytedance.android.live.base.api.IOuterLiveService;
import com.bytedance.android.live.base.api.MethodChannelService;
import com.bytedance.android.openliveplugin.LivePluginHelper;
import com.bytedance.sdk.openadsdk.TTAppContextHolder;
import com.bytedance.sdk.openadsdk.TTCustomController;
import com.bytedance.sdk.openadsdk.TTPluginListener;
import com.bytedance.sdk.openadsdk.api.bl;
import com.bytedance.sdk.openadsdk.bl.ok.ok.q;
import com.bytedance.sdk.openadsdk.live.core.TTHostPermissionInner;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class a implements Bridge {
    private static final a ok = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ITTLiveTokenInjectionAuth f6387a;
    private Bridge bl;

    public static final class ok implements Bridge {
        private ILiveAdCustomConfig ok;

        public ok(ILiveAdCustomConfig iLiveAdCustomConfig) {
            this.ok = iLiveAdCustomConfig;
        }

        @Override // com.bykv.vk.openvk.api.proto.Caller
        public <T> T call(int i2, ValueSet valueSet, Class<T> cls) {
            if (i2 == 0) {
                return (T) Integer.valueOf(this.ok.openLR(valueSet.stringValue(0)));
            }
            if (i2 == 1) {
                return (T) this.ok.convertToEnterFromMerge(valueSet.intValue(0));
            }
            if (i2 == 2) {
                return (T) this.ok.convertToEnterMethod(valueSet.intValue(0), valueSet.booleanValue(1));
            }
            if (i2 == 3) {
                return (T) this.ok.invoke(valueSet.intValue(0), (Bundle) valueSet.objectValue(1, Bundle.class));
            }
            if (i2 != 4) {
                return null;
            }
            this.ok.onEventV3(valueSet.stringValue(0), (JSONObject) valueSet.objectValue(1, JSONObject.class));
            return null;
        }

        @Override // com.bykv.vk.openvk.api.proto.Bridge
        public ValueSet values() {
            return c.d.a.a.a.a.a.ok().ok(10000, 1).a();
        }
    }

    private a() {
    }

    private TTCustomController a(Map map) {
        Object obj = map.get(TTLiveConstants.INIT_CUSTOM_CONTROLLER);
        if (obj instanceof Bridge) {
            return new q((Bridge) obj);
        }
        return null;
    }

    private Object bl(Map<String, Object> map) {
        try {
            String str = (String) map.get(TTLiveConstants.EXPAND_METHOD_NAME_KEY);
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            IOuterLiveService liveRoomService = LivePluginHelper.getLiveRoomService();
            Object[] objArr = (Object[]) map.get(TTLiveConstants.EXPAND_METHOD_PARAM_KEY);
            return objArr != null ? liveRoomService.callExpandMethod(str, objArr) : liveRoomService.callExpandMethod(str, new Object[0]);
        } catch (Throwable th) {
            bl.a("TTLiveSDkBridge", th);
            return null;
        }
    }

    private Context getContext(Object obj) {
        if (obj instanceof Context) {
            return (Context) obj;
        }
        return null;
    }

    private Boolean s(Map<String, Object> map) {
        try {
            String str = (String) map.get(TTLiveConstants.SCHEME_URI_KEY);
            if (TextUtils.isEmpty(str)) {
                return Boolean.FALSE;
            }
            Context context = getContext(map.get(TTLiveConstants.CONTEXT_KEY));
            Uri uri = Uri.parse(str);
            if (uri != null && context != null) {
                return Boolean.valueOf(com.bytedance.sdk.openadsdk.live.ok.ok(context, uri));
            }
            return Boolean.FALSE;
        } catch (Throwable th) {
            bl.a("TTLiveSDkBridge", th);
            return Boolean.FALSE;
        }
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i2, ValueSet valueSet, Class<T> cls) {
        if (i2 == 5) {
            ok((Map) valueSet.objectValue(0, Map.class));
            return null;
        }
        if (i2 != 9) {
            return (T) ok(cls, i2, (Map<String, Object>) valueSet.objectValue(0, Map.class));
        }
        this.bl = (Bridge) valueSet.objectValue(0, Bridge.class);
        Bridge bridge = (Bridge) com.bytedance.sdk.openadsdk.ok.bl.ok().call(10, c.d.a.a.a.a.a.ok(1).ok(0, 4).a(), Bridge.class);
        if (bridge != null) {
            bridge.call(106, c.d.a.a.a.a.a.ok(1).ok(0, new TTPluginListener() { // from class: com.bytedance.sdk.openadsdk.live.a.1
                @Override // com.bytedance.sdk.openadsdk.TTPluginListener
                public Bundle config() {
                    return null;
                }

                @Override // com.bytedance.sdk.openadsdk.TTPluginListener
                public void onPluginListener(int i3, ClassLoader classLoader, Resources resources, Bundle bundle) {
                    if (a.this.bl != null) {
                        a.this.bl.call(3, c.d.a.a.a.a.a.ok().ok(0, i3).ok(1, classLoader).ok(2, resources).ok(3, bundle).a(), null);
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.TTPluginListener
                public String packageName() {
                    return "com.byted.live.lite";
                }
            }).a(), Void.class);
        }
        return null;
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return c.d.a.a.a.a.a.ok().ok(10000, 2).a();
    }

    public static a ok() {
        return ok;
    }

    public static Bridge ok(ILiveAdCustomConfig iLiveAdCustomConfig) {
        return new ok(iLiveAdCustomConfig);
    }

    public void ok(ITTLiveTokenInjectionAuth iTTLiveTokenInjectionAuth) {
        this.f6387a = iTTLiveTokenInjectionAuth;
    }

    private void ok(Map map) {
        ILiveHostContextParam.Builder hostActionParam = new ILiveHostContextParam.Builder().setAppName(String.valueOf(map.get("app_name"))).setChannel(String.valueOf(map.get("channel"))).setIsDebug(Boolean.valueOf(String.valueOf(map.get(TTLiveConstants.INIT_DEBUG))).booleanValue()).setECHostAppId(String.valueOf(map.get(TTLiveConstants.INIT_EC_HOST_APPID))).setPartner(String.valueOf(map.get("partner"))).provideMethodChannel(new MethodChannelService() { // from class: com.bytedance.sdk.openadsdk.live.a.2
            @Override // com.bytedance.android.live.base.api.MethodChannelService
            public String identity() {
                return MediationConstant.ADN_PANGLE;
            }

            @Override // com.bytedance.android.live.base.api.MethodChannelService
            public Object invokeMethod(String str, Map<String, String> map2) {
                if (a.this.bl != null) {
                    return a.this.bl.call(0, c.d.a.a.a.a.a.ok().ok(0, str).ok(1, map2).a(), Object.class);
                }
                return null;
            }
        }).setPartnerSecret(TTLiveConstants.INIT_PARTENER_SECERET).setHostPermission(new TTHostPermissionInner(a(map))).setHostActionParam(new com.bytedance.sdk.openadsdk.live.core.ok(this.bl));
        ITTLiveTokenInjectionAuth iTTLiveTokenInjectionAuth = this.f6387a;
        if (iTTLiveTokenInjectionAuth != null) {
            hostActionParam.setInjectionAuth(new com.bytedance.sdk.openadsdk.live.core.a(iTTLiveTokenInjectionAuth));
        }
        ILiveInitCallback iLiveInitCallback = new ILiveInitCallback() { // from class: com.bytedance.sdk.openadsdk.live.a.3
            @Override // com.bytedance.android.live.base.api.ILiveInitCallback
            public void onLiveInitFailed(String str) {
                bl.ok("TTLiveSDkBridge", "onLiveInitFailed! ", str);
                a.this.ok(-3, str);
            }

            @Override // com.bytedance.android.live.base.api.ILiveInitCallback
            public void onLiveInitFinish() {
                bl.a("TTLiveSDkBridge", "onLiveInitFinish!");
                com.bytedance.sdk.openadsdk.live.ok.ok();
                a.this.ok(2, null);
            }
        };
        if (TTAppContextHolder.getContext() instanceof Application) {
            hostActionParam.setContext((Application) TTAppContextHolder.getContext());
        }
        boolean zBooleanValue = Boolean.valueOf(String.valueOf(map.get(TTLiveConstants.INIT_SUB_PROCESS))).booleanValue();
        bl.ok("TTLiveSDkBridge", "execute live sdk initLive method end, (方法顺利执行结果)result: ", Boolean.valueOf(com.bytedance.sdk.openadsdk.live.ok.ok(TTAppContextHolder.getContext(), String.valueOf(map.get(TTLiveConstants.INIT_GENERATE_APPID)), hostActionParam, iLiveInitCallback, zBooleanValue)), " subProcess=", Boolean.valueOf(zBooleanValue));
    }

    public <T> T ok(Class<T> cls, int i2, Map<String, Object> map) {
        if (i2 == 0) {
            if (!com.bytedance.sdk.openadsdk.live.ok.ok(getContext(map.get(TTLiveConstants.CONTEXT_KEY)), ok(map.get(TTLiveConstants.BUNDLE_KEY)))) {
                return (T) 2;
            }
            return (T) 0;
        }
        if (i2 == 7) {
            return (T) bl(map);
        }
        if (i2 != 8) {
            return null;
        }
        return (T) s(map);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ok(int i2, String str) {
        if (this.bl != null) {
            c.d.a.a.a.a.a aVarOk = c.d.a.a.a.a.a.ok().ok(0, i2);
            if (str != null) {
                aVarOk.ok(1, str);
            }
            this.bl.call(2, aVarOk.a(), null);
        }
    }

    private Bundle ok(Object obj) {
        if (obj instanceof Bundle) {
            return (Bundle) obj;
        }
        return null;
    }
}
