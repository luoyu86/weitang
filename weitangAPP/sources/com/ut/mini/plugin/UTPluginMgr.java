package com.ut.mini.plugin;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.text.TextUtils;
import com.alibaba.mtl.log.b;
import com.alibaba.mtl.log.d.i;
import com.ut.mini.core.appstatus.UTMCAppStatusCallbacks;
import com.ut.mini.core.appstatus.UTMCAppStatusRegHelper;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class UTPluginMgr implements UTMCAppStatusCallbacks {
    public static final String PARTNERPLUGIN_UTPREF = "com.ut.mini.perf.UTPerfPlugin";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static UTPluginMgr f12368a = new UTPluginMgr();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private HandlerThread f12369b = null;
    private Handler mHandler = null;
    private List<UTPlugin> n = new LinkedList();
    private List<String> o = new ArrayList();
    private List<String> p = new ArrayList<String>() { // from class: com.ut.mini.plugin.UTPluginMgr.1
        {
            add(UTPluginMgr.PARTNERPLUGIN_UTPREF);
        }
    };

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private List<UTPlugin> f12370q = new LinkedList();

    public static class a {
        private int L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private UTPlugin f12374a;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private Object f12375g;

        private a() {
            this.L = 0;
            this.f12375g = null;
            this.f12374a = null;
        }

        public UTPlugin a() {
            return this.f12374a;
        }

        public void c(Object obj) {
            this.f12375g = obj;
        }

        public void g(int i2) {
            this.L = i2;
        }

        public Object getMsgObj() {
            return this.f12375g;
        }

        public int i() {
            return this.L;
        }

        public void a(UTPlugin uTPlugin) {
            this.f12374a = uTPlugin;
        }
    }

    private UTPluginMgr() {
        if (Build.VERSION.SDK_INT >= 14) {
            UTMCAppStatusRegHelper.registerAppStatusCallbacks(this);
        }
    }

    private void K() {
        HandlerThread handlerThread = new HandlerThread("UT-PLUGIN-ASYNC");
        this.f12369b = handlerThread;
        handlerThread.start();
        this.mHandler = new Handler(this.f12369b.getLooper()) { // from class: com.ut.mini.plugin.UTPluginMgr.2
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.what == 1) {
                    Object obj = message.obj;
                    if (obj instanceof a) {
                        a aVar = (a) obj;
                        UTPlugin uTPluginA = aVar.a();
                        int i2 = aVar.i();
                        Object msgObj = aVar.getMsgObj();
                        if (uTPluginA != null) {
                            try {
                                if (msgObj instanceof UTPluginMsgDispatchDelegate) {
                                    UTPluginMsgDispatchDelegate uTPluginMsgDispatchDelegate = (UTPluginMsgDispatchDelegate) msgObj;
                                    if (uTPluginMsgDispatchDelegate.isMatchPlugin(uTPluginA)) {
                                        uTPluginA.onPluginMsgArrivedFromSDK(i2, uTPluginMsgDispatchDelegate.getDispatchObject(uTPluginA));
                                    }
                                } else {
                                    uTPluginA.onPluginMsgArrivedFromSDK(i2, msgObj);
                                }
                            } catch (Throwable th) {
                                th.printStackTrace();
                            }
                        }
                    }
                }
            }
        };
    }

    private synchronized void a(int i2, UTPluginContextValueDispatchDelegate uTPluginContextValueDispatchDelegate) {
        if (uTPluginContextValueDispatchDelegate == null) {
            return;
        }
        for (UTPlugin uTPlugin : this.f12370q) {
            uTPluginContextValueDispatchDelegate.onPluginContextValueChange(uTPlugin.getPluginContext());
            uTPlugin.onPluginContextValueUpdate(i2);
        }
    }

    public static UTPluginMgr getInstance() {
        return f12368a;
    }

    public synchronized boolean dispatchPluginMsg(int i2, Object obj) {
        boolean z;
        List<UTPlugin> list;
        if (this.mHandler == null) {
            K();
        }
        z = false;
        if (this.f12370q.size() > 0) {
            for (UTPlugin uTPlugin : this.f12370q) {
                int[] iArrReturnRequiredMsgIds = uTPlugin.returnRequiredMsgIds();
                if (iArrReturnRequiredMsgIds != null && a(i2, iArrReturnRequiredMsgIds)) {
                    try {
                        if (i2 != 1 && ((list = this.n) == null || !list.contains(uTPlugin))) {
                            a aVar = new a();
                            aVar.g(i2);
                            aVar.c(obj);
                            aVar.a(uTPlugin);
                            Message messageObtain = Message.obtain();
                            messageObtain.what = 1;
                            messageObtain.obj = aVar;
                            this.mHandler.sendMessage(messageObtain);
                            z = true;
                        }
                        if (obj instanceof UTPluginMsgDispatchDelegate) {
                            UTPluginMsgDispatchDelegate uTPluginMsgDispatchDelegate = (UTPluginMsgDispatchDelegate) obj;
                            if (uTPluginMsgDispatchDelegate.isMatchPlugin(uTPlugin)) {
                                uTPlugin.onPluginMsgArrivedFromSDK(i2, uTPluginMsgDispatchDelegate.getDispatchObject(uTPlugin));
                            }
                        } else {
                            uTPlugin.onPluginMsgArrivedFromSDK(i2, obj);
                        }
                        z = true;
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            }
        }
        return z;
    }

    public boolean isPartnerPluginExist(String str) {
        return this.o.contains(str);
    }

    @Override // com.ut.mini.core.appstatus.UTMCAppStatusCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // com.ut.mini.core.appstatus.UTMCAppStatusCallbacks
    public void onActivityDestroyed(Activity activity) {
    }

    @Override // com.ut.mini.core.appstatus.UTMCAppStatusCallbacks
    public void onActivityPaused(Activity activity) {
    }

    @Override // com.ut.mini.core.appstatus.UTMCAppStatusCallbacks
    public void onActivityResumed(Activity activity) {
    }

    @Override // com.ut.mini.core.appstatus.UTMCAppStatusCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // com.ut.mini.core.appstatus.UTMCAppStatusCallbacks
    public void onActivityStarted(Activity activity) {
    }

    @Override // com.ut.mini.core.appstatus.UTMCAppStatusCallbacks
    public void onActivityStopped(Activity activity) {
    }

    @Override // com.ut.mini.core.appstatus.UTMCAppStatusCallbacks
    public void onSwitchBackground() {
        dispatchPluginMsg(2, null);
    }

    @Override // com.ut.mini.core.appstatus.UTMCAppStatusCallbacks
    public void onSwitchForeground() {
        dispatchPluginMsg(8, null);
    }

    public synchronized void registerPlugin(UTPlugin uTPlugin, boolean z) {
        if (uTPlugin != null) {
            if (!this.f12370q.contains(uTPlugin)) {
                uTPlugin.a(a());
                this.f12370q.add(uTPlugin);
                if (!z) {
                    this.n.add(uTPlugin);
                }
                uTPlugin.onRegistered();
            }
        }
    }

    public void runPartnerPlugin() {
        List<String> list = this.p;
        if (list == null || list.size() <= 0) {
            return;
        }
        for (String str : this.p) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    Object objNewInstance = Class.forName(str).newInstance();
                    if (objNewInstance instanceof UTPlugin) {
                        registerPlugin((UTPlugin) objNewInstance, true);
                        i.a("runPartnerPlugin[OK]:" + str, new String[0]);
                        this.o.add(str);
                    }
                } catch (ClassNotFoundException unused) {
                } catch (IllegalAccessException e2) {
                    e2.printStackTrace();
                } catch (InstantiationException e3) {
                    e3.printStackTrace();
                }
            }
        }
    }

    public synchronized void unregisterPlugin(UTPlugin uTPlugin) {
        List<UTPlugin> list;
        if (uTPlugin != null) {
            if (this.f12370q.contains(uTPlugin)) {
                this.f12370q.remove(uTPlugin);
                uTPlugin.onUnRegistered();
                uTPlugin.a(null);
            }
            list = this.n;
            if (list != null && list.contains(uTPlugin)) {
                this.n.remove(uTPlugin);
            }
        } else {
            list = this.n;
            if (list != null) {
                this.n.remove(uTPlugin);
            }
        }
    }

    public void updatePluginContextValue(int i2) {
        if (i2 != 1) {
            return;
        }
        a(i2, new UTPluginContextValueDispatchDelegate() { // from class: com.ut.mini.plugin.UTPluginMgr.3
            @Override // com.ut.mini.plugin.UTPluginContextValueDispatchDelegate
            public void onPluginContextValueChange(UTPluginContext uTPluginContext) {
                uTPluginContext.setDebugLogFlag(i.l());
            }
        });
    }

    private UTPluginContext a() {
        UTPluginContext uTPluginContext = new UTPluginContext();
        uTPluginContext.setContext(b.a().getContext());
        if (i.l()) {
            uTPluginContext.setDebugLogFlag(i.l());
        }
        return uTPluginContext;
    }

    private boolean a(int i2, int[] iArr) {
        if (iArr == null) {
            return false;
        }
        boolean z = false;
        for (int i3 : iArr) {
            if (i3 == i2) {
                z = true;
            }
        }
        return z;
    }
}
