package com.bytedance.sdk.openadsdk.api;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Pair;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.EventListener;
import com.bykv.vk.openvk.api.proto.Loader;
import com.bykv.vk.openvk.api.proto.Manager;
import com.bykv.vk.openvk.api.proto.Result;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.AdConfig;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdConfig;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.TTAdManager;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import com.bytedance.sdk.openadsdk.TTAppContextHolder;
import com.bytedance.sdk.openadsdk.downloadnew.core.DownloadBridgeFactory;
import com.bytedance.sdk.openadsdk.downloadnew.core.ExitInstallListener;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.bytedance.sdk.openadsdk.mediation.MediationApiLog;
import com.bytedance.sdk.openadsdk.mediation.MediationTTLiveTokenInjectionAuthImpl;
import com.bytedance.sdk.openadsdk.mediation.bridge.init.MediationInitCLassLoader;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes.dex */
public abstract class ok {
    private TTAdSdk.InitCallback ok;

    public interface a<T> {
        void ok(T t);
    }

    public static abstract class bl implements TTAdManager {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private volatile boolean f6322a;
        private List<WeakReference<a<Manager>>> bl = new CopyOnWriteArrayList();
        private volatile Manager ok;

        /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.api.ok$bl$1, reason: invalid class name */
        public class AnonymousClass1 extends AbstractC0110ok<Loader> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final a<Manager> f6323a;
            public final /* synthetic */ SoftReference bl;
            public Loader ok;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(SoftReference softReference) {
                super();
                this.bl = softReference;
                this.f6323a = new a<Manager>() { // from class: com.bytedance.sdk.openadsdk.api.ok.bl.1.1
                    @Override // com.bytedance.sdk.openadsdk.api.ok.a
                    public void ok(Manager manager) {
                        AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                        anonymousClass1.ok = manager.createLoader((Context) anonymousClass1.bl.get());
                    }
                };
            }

            @Override // com.bytedance.sdk.openadsdk.api.ok.AbstractC0110ok
            public void ok(final a<Loader> aVar, int i2) {
                Loader loader = this.ok;
                if (loader != null) {
                    aVar.ok(loader);
                } else {
                    bl.this.call(new a<Manager>() { // from class: com.bytedance.sdk.openadsdk.api.ok.bl.1.2
                        @Override // com.bytedance.sdk.openadsdk.api.ok.a
                        public void ok(Manager manager) {
                            AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                            bl.this.ok(anonymousClass1.f6323a);
                            AnonymousClass1 anonymousClass12 = AnonymousClass1.this;
                            anonymousClass12.ok = manager.createLoader((Context) anonymousClass12.bl.get());
                            aVar.ok(AnonymousClass1.this.ok);
                        }
                    }, i2 + 10000);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static <T> T a(Manager manager, Class<T> cls, Bundle bundle) {
            return (T) manager.getBridge(1).call(6, c.d.a.a.a.a.a.ok(2).ok(9, cls).ok(10, bundle).a(), cls);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void call(final a<Manager> aVar, final int i2) {
            if (this.ok == null) {
                if (!this.f6322a && i2 > 10000) {
                    throw new IllegalStateException("广告SDK未Ready, 请在load(请求广告）之前，先调用init and start方法，以避免无法请求广告");
                }
                com.bytedance.sdk.openadsdk.n.ok.ok().ok(new Runnable() { // from class: com.bytedance.sdk.openadsdk.api.ok.bl.7
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            if (bl.this.ok != null) {
                                aVar.ok(bl.this.ok);
                            } else {
                                com.bytedance.sdk.openadsdk.api.bl.s("_tt_ad_sdk_", "Not ready, no manager: " + i2);
                            }
                        } catch (Throwable th) {
                            com.bytedance.sdk.openadsdk.api.bl.s("_tt_ad_sdk_", "Unexpected manager call error: " + th.getMessage());
                            bl.this.ok(th);
                        }
                    }
                });
                return;
            }
            try {
                aVar.ok(this.ok);
            } catch (Throwable th) {
                com.bytedance.sdk.openadsdk.api.bl.s("_tt_ad_sdk_", "Unexpected manager call error: " + th.getMessage());
                ok(th);
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdManager
        public TTAdNative createAdNative(Context context) {
            return new n(new AnonymousClass1(new SoftReference(context))).ok();
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdManager
        public String getBiddingToken(AdSlot adSlot) {
            return getBiddingToken(adSlot, false, adSlot.getAdType() > 0 ? adSlot.getAdType() : adSlot.getNativeAdType());
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdManager
        public <T> T getExtra(final Class<T> cls, final Bundle bundle) {
            if (this.ok != null) {
                return (T) a(this.ok, cls, bundle);
            }
            call(new a<Manager>() { // from class: com.bytedance.sdk.openadsdk.api.ok.bl.4
                @Override // com.bytedance.sdk.openadsdk.api.ok.a
                public void ok(Manager manager) {
                    bl.a(bl.this.ok, cls, bundle);
                }
            }, 6);
            return null;
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdManager
        public String getPluginVersion() {
            return this.ok != null ? this.ok.values().stringValue(12) : "";
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdManager
        public String getSDKVersion() {
            return "5.9.0.8";
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdManager
        public int getThemeStatus() {
            if (this.ok != null) {
                return this.ok.values().intValue(11);
            }
            return 0;
        }

        public Object ok(Object obj) {
            return obj;
        }

        public void ok(Throwable th) {
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdManager
        public void register(final Object obj) {
            call(new a<Manager>() { // from class: com.bytedance.sdk.openadsdk.api.ok.bl.2
                @Override // com.bytedance.sdk.openadsdk.api.ok.a
                public void ok(Manager manager) {
                    manager.getBridge(1).call(4, c.d.a.a.a.a.a.ok(1).ok(8, bl.this.ok(obj)).a(), Void.class);
                }
            }, 4);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdManager
        public void requestPermissionIfNecessary(final Context context) {
            call(new a<Manager>() { // from class: com.bytedance.sdk.openadsdk.api.ok.bl.5
                @Override // com.bytedance.sdk.openadsdk.api.ok.a
                public void ok(Manager manager) {
                    manager.getBridge(1).call(3, c.d.a.a.a.a.a.ok(1).ok(7, context).a(), Void.class);
                }
            }, 3);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdManager
        public void setThemeStatus(final int i2) {
            call(new a<Manager>() { // from class: com.bytedance.sdk.openadsdk.api.ok.bl.6
                @Override // com.bytedance.sdk.openadsdk.api.ok.a
                public void ok(Manager manager) {
                    manager.getBridge(1).call(1, c.d.a.a.a.a.a.ok().ok(11, i2).a(), Void.class);
                }
            }, 1);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdManager
        public boolean tryShowInstallDialogWhenExit(Activity activity, ExitInstallListener exitInstallListener) {
            HashMap map = new HashMap();
            map.put("activity", activity);
            map.put(TTDownloadField.TT_EXIT_INSTALL_LISTENER, exitInstallListener);
            return ((Boolean) DownloadBridgeFactory.getDownloadBridge(TTAppContextHolder.getContext()).call(0, c.d.a.a.a.a.a.ok(1).ok(0, map).a(), Boolean.class)).booleanValue();
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdManager
        public void unregister(final Object obj) {
            call(new a<Manager>() { // from class: com.bytedance.sdk.openadsdk.api.ok.bl.3
                @Override // com.bytedance.sdk.openadsdk.api.ok.a
                public void ok(Manager manager) {
                    manager.getBridge(1).call(5, c.d.a.a.a.a.a.ok(1).ok(8, obj).a(), Void.class);
                }
            }, 5);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdManager
        public String getBiddingToken(AdSlot adSlot, boolean z, int i2) {
            if (i2 <= 0) {
                i2 = adSlot.getAdType() > 0 ? adSlot.getAdType() : adSlot.getNativeAdType();
            }
            ValueSet valueSetA = c.d.a.a.a.a.a.ok(com.bytedance.sdk.openadsdk.bl.ok.bl.a.a(adSlot)).ok(13, z).ok(14, i2).a();
            if (this.ok != null) {
                return (String) this.ok.getBridge(1).call(2, valueSetA, String.class);
            }
            return null;
        }

        public void ok(boolean z) {
            this.f6322a = z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void ok(Manager manager) {
            this.ok = manager;
            if (this.ok != null) {
                Iterator<WeakReference<a<Manager>>> it = this.bl.iterator();
                while (it.hasNext()) {
                    WeakReference<a<Manager>> next = it.next();
                    a<Manager> aVar = next != null ? next.get() : null;
                    if (aVar != null) {
                        aVar.ok(manager);
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void ok(a<Manager> aVar) {
            this.bl.add(new WeakReference<>(aVar));
        }
    }

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.api.ok$ok, reason: collision with other inner class name */
    public static abstract class AbstractC0110ok<T> {
        private AbstractC0110ok() {
        }

        public abstract void ok(a<T> aVar, int i2);

        public void ok(Throwable th) {
        }
    }

    public class s implements EventListener {
        private s() {
        }

        @Override // com.bykv.vk.openvk.api.proto.EventListener
        public ValueSet onEvent(int i2, Result result) {
            ok.this.a(result);
            return null;
        }
    }

    public abstract bl a();

    public abstract void a(Context context, c.d.a.a.a.a.a aVar);

    public void a(Result result) {
        ok(result);
        if (result.isSuccess()) {
            com.bytedance.sdk.openadsdk.api.bl.a("_tt_ad_sdk_", "init sdk success ");
            TTAdSdk.InitCallback initCallback = this.ok;
            if (initCallback != null) {
                initCallback.success();
            }
        } else {
            com.bytedance.sdk.openadsdk.api.bl.n("_tt_ad_sdk_", "int sdk failed, code: " + result.code() + ", message: " + result.message());
            TTAdSdk.InitCallback initCallback2 = this.ok;
            if (initCallback2 != null) {
                initCallback2.fail(result.code(), result.message() != null ? result.message() : "");
            }
        }
        this.ok = null;
    }

    public boolean a(Context context, AdConfig adConfig, TTAdSdk.InitCallback initCallback) {
        return false;
    }

    public abstract com.bytedance.sdk.openadsdk.ok.a bl();

    public void ok(final Context context, AdConfig adConfig, TTAdSdk.InitCallback initCallback) {
        com.bytedance.sdk.openadsdk.ok.bl.ok().ok(bl());
        if (a(context, adConfig, initCallback)) {
            this.ok = initCallback;
            final c.d.a.a.a.a.a aVarOk = c.d.a.a.a.a.a.ok(com.bytedance.sdk.openadsdk.bl.ok.bl.ok.ok(adConfig));
            aVarOk.ok(1, SystemClock.elapsedRealtime());
            aVarOk.ok(5, "main");
            aVarOk.ok(4, true);
            aVarOk.ok(6, 999);
            aVarOk.ok(10, 5908);
            aVarOk.ok(11, "5.9.0.8");
            aVarOk.ok(12, "com.byted.pangle.m");
            aVarOk.ok(14, false);
            aVarOk.ok(16, com.bytedance.sdk.openadsdk.ok.bl.ok());
            Thread threadCurrentThread = Thread.currentThread();
            aVarOk.ok(2, threadCurrentThread.getName());
            aVarOk.ok(3, threadCurrentThread.getPriority());
            aVarOk.ok(15, new s());
            aVarOk.ok(8301, new MediationInitCLassLoader());
            if (adConfig instanceof TTAdConfig) {
                aVarOk.ok(8318, new MediationTTLiveTokenInjectionAuthImpl(((TTAdConfig) adConfig).getInjectionAuth()));
            }
            if (adConfig != null) {
                MediationApiLog.setDebug(Boolean.valueOf(adConfig.isDebug()));
            }
            if (!ok(context, aVarOk)) {
                com.bytedance.sdk.openadsdk.n.ok.ok().ok(new Runnable() { // from class: com.bytedance.sdk.openadsdk.api.ok.1
                    @Override // java.lang.Runnable
                    public void run() {
                        ok.this.a(context, aVarOk);
                    }
                });
            }
            a().ok(true);
        }
    }

    public void ok(Result result) {
    }

    public abstract boolean ok();

    public abstract boolean ok(Context context, c.d.a.a.a.a.a aVar);

    public static class n extends com.bytedance.sdk.openadsdk.bl.ok.ok {
        private AbstractC0110ok<Loader> ok;

        public n(AbstractC0110ok<Loader> abstractC0110ok) {
            this.ok = abstractC0110ok;
        }

        private void ok(a<Loader> aVar, int i2) {
            try {
                com.bytedance.sdk.openadsdk.api.bl.a("_tt_ad_sdk_", "load ad slot type: " + i2);
                this.ok.ok(aVar, i2);
            } catch (Throwable th) {
                this.ok.ok(th);
                throw th;
            }
        }

        @Override // com.bytedance.sdk.openadsdk.bl.ok.ok
        public void a(final ValueSet valueSet, final Bridge bridge) {
            ok(new a<Loader>() { // from class: com.bytedance.sdk.openadsdk.api.ok.n.3
                @Override // com.bytedance.sdk.openadsdk.api.ok.a
                public void ok(Loader loader) {
                    loader.load(6, c.d.a.a.a.a.a.ok(valueSet).ok(1, bridge).a(), null);
                }
            }, 6);
        }

        @Override // com.bytedance.sdk.openadsdk.bl.ok.ok
        public void bl(final ValueSet valueSet, final Bridge bridge) {
            ok(new a<Loader>() { // from class: com.bytedance.sdk.openadsdk.api.ok.n.4
                @Override // com.bytedance.sdk.openadsdk.api.ok.a
                public void ok(Loader loader) {
                    loader.load(9, c.d.a.a.a.a.a.ok(valueSet).ok(1, bridge).a(), null);
                }
            }, 9);
        }

        @Override // com.bytedance.sdk.openadsdk.bl.ok.ok
        public void h(final ValueSet valueSet, final Bridge bridge) {
            ok(new a<Loader>() { // from class: com.bytedance.sdk.openadsdk.api.ok.n.9
                @Override // com.bytedance.sdk.openadsdk.api.ok.a
                public void ok(Loader loader) {
                    loader.load(5, c.d.a.a.a.a.a.ok(valueSet).ok(2, true).ok(1, bridge).a(), null);
                }
            }, 5);
        }

        @Override // com.bytedance.sdk.openadsdk.bl.ok.ok
        public void kf(final ValueSet valueSet, final Bridge bridge) {
            ok(new a<Loader>() { // from class: com.bytedance.sdk.openadsdk.api.ok.n.8
                @Override // com.bytedance.sdk.openadsdk.api.ok.a
                public void ok(Loader loader) {
                    loader.load(8, c.d.a.a.a.a.a.ok(valueSet).ok(1, bridge).a(), null);
                }
            }, 8);
        }

        @Override // com.bytedance.sdk.openadsdk.bl.ok.ok
        public void n(final ValueSet valueSet, final Bridge bridge) {
            ok(new a<Loader>() { // from class: com.bytedance.sdk.openadsdk.api.ok.n.7
                @Override // com.bytedance.sdk.openadsdk.api.ok.a
                public void ok(Loader loader) {
                    loader.load(7, c.d.a.a.a.a.a.ok(valueSet).ok(1, bridge).a(), null);
                }
            }, 7);
        }

        @Override // com.bytedance.sdk.openadsdk.bl.ok.ok
        public void p(final ValueSet valueSet, final Bridge bridge) {
            ok(new a<Loader>() { // from class: com.bytedance.sdk.openadsdk.api.ok.n.10
                @Override // com.bytedance.sdk.openadsdk.api.ok.a
                public void ok(Loader loader) {
                    loader.load(9, c.d.a.a.a.a.a.ok(valueSet).ok(2, true).ok(1, bridge).a(), null);
                }
            }, 9);
        }

        @Override // com.bytedance.sdk.openadsdk.bl.ok.ok
        public void q(final ValueSet valueSet, final Bridge bridge) {
            ok(new a<Loader>() { // from class: com.bytedance.sdk.openadsdk.api.ok.n.2
                @Override // com.bytedance.sdk.openadsdk.api.ok.a
                public void ok(Loader loader) {
                    loader.load(1, c.d.a.a.a.a.a.ok(valueSet).ok(2, true).ok(1, bridge).a(), null);
                }
            }, 1);
        }

        @Override // com.bytedance.sdk.openadsdk.bl.ok.ok
        public void s(final ValueSet valueSet, final Bridge bridge) {
            ok(new a<Loader>() { // from class: com.bytedance.sdk.openadsdk.api.ok.n.5
                @Override // com.bytedance.sdk.openadsdk.api.ok.a
                public void ok(Loader loader) {
                    loader.load(1, c.d.a.a.a.a.a.ok(valueSet).ok(1, bridge).a(), null);
                }
            }, 1);
        }

        @Override // com.bytedance.sdk.openadsdk.bl.ok.ok
        public void ok(final ValueSet valueSet, final Bridge bridge) {
            ok(new a<Loader>() { // from class: com.bytedance.sdk.openadsdk.api.ok.n.1
                @Override // com.bytedance.sdk.openadsdk.api.ok.a
                public void ok(Loader loader) {
                    loader.load(5, c.d.a.a.a.a.a.ok(valueSet).ok(1, bridge).a(), null);
                }
            }, 5);
        }

        @Override // com.bytedance.sdk.openadsdk.bl.ok.ok
        public void ok(final ValueSet valueSet, final Bridge bridge, final int i2) {
            ok(new a<Loader>() { // from class: com.bytedance.sdk.openadsdk.api.ok.n.6
                @Override // com.bytedance.sdk.openadsdk.api.ok.a
                public void ok(Loader loader) {
                    loader.load(3, c.d.a.a.a.a.a.ok(valueSet).ok(3, i2).ok(1, bridge).a(), null);
                }
            }, 3);
        }

        @Override // com.bytedance.sdk.openadsdk.bl.ok.ok
        public Pair<Integer, String> ok(Exception exc) {
            com.bytedance.sdk.openadsdk.api.bl.s("_tt_ad_sdk_", "Load ad failed: " + exc.getMessage());
            if ((exc instanceof IllegalStateException) && "广告SDK未Ready, 请在load(请求广告）之前，先调用init and start方法，以避免无法请求广告".equals(exc.getMessage())) {
                return new Pair<>(4208, exc.getMessage());
            }
            return new Pair<>(Integer.valueOf(TTAdConstant.INIT_FAILED_CREATE_INVOKE_FAILED), "Load ad failed: " + exc.getMessage());
        }
    }

    public void ok(Manager manager) {
        com.bytedance.sdk.openadsdk.api.bl.a("_tt_ad_sdk_", "update manager");
        a().ok(manager);
        a().register(com.bytedance.sdk.openadsdk.ok.bl.ok());
    }
}
