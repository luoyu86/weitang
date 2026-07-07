package a.a.r;

import a.a.o.b;
import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import anet.channel.AwcnConfig;
import anet.channel.GlobalAppRuntimeInfo;
import anet.channel.SessionCenter;
import anet.channel.entity.ENV;
import anet.channel.util.ALog;
import anet.channel.util.Utils;
import com.taobao.accs.common.Constants;
import java.io.Serializable;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
public class a implements Serializable {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Context f224b;
    public static ENV CURRENT_ENV = ENV.ONLINE;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static AtomicBoolean f223a = new AtomicBoolean(false);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static HashMap<String, Object> f225c = null;

    public static void a() {
        try {
            Utils.invokeStaticMethodThrowException("anet.channel.TaobaoNetworkAdapter", "init", new Class[]{Context.class, HashMap.class}, f224b, f225c);
            ALog.i("anet.NetworkSdkSetting", "init taobao adapter success", null, new Object[0]);
        } catch (Exception e2) {
            ALog.i("anet.NetworkSdkSetting", "initTaobaoAdapter failed. maybe not taobao app", null, e2);
        }
    }

    public static Context getContext() {
        return f224b;
    }

    public static void init(Context context) {
        if (context == null) {
            return;
        }
        try {
            if (f223a.compareAndSet(false, true)) {
                ALog.e("anet.NetworkSdkSetting", "NetworkSdkSetting init", null, new Object[0]);
                f224b = context;
                GlobalAppRuntimeInfo.setInitTime(System.currentTimeMillis());
                GlobalAppRuntimeInfo.setContext(context);
                b.init();
                a();
                a.a.t.a.init();
                if (!AwcnConfig.isTbNextLaunch()) {
                    a.a.p.a.setup(context);
                }
                SessionCenter.init(context);
            }
        } catch (Throwable th) {
            ALog.e("anet.NetworkSdkSetting", "Network SDK initial failed!", null, th, new Object[0]);
        }
    }

    public static void setTtid(String str) {
        GlobalAppRuntimeInfo.setTtid(str);
    }

    public static void init(Application application, HashMap<String, Object> map) {
        try {
            GlobalAppRuntimeInfo.setTtid((String) map.get(Constants.KEY_TTID));
            GlobalAppRuntimeInfo.setUtdid((String) map.get("deviceId"));
            String str = (String) map.get("process");
            if (!TextUtils.isEmpty(str)) {
                GlobalAppRuntimeInfo.setCurrentProcess(str);
            }
            f225c = new HashMap<>(map);
            init(application.getApplicationContext());
            f225c = null;
        } catch (Exception e2) {
            ALog.e("anet.NetworkSdkSetting", "Network SDK initial failed!", null, e2, new Object[0]);
        }
    }
}
