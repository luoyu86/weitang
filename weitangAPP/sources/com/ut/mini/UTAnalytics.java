package com.ut.mini;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.alibaba.mtl.appmonitor.AppMonitor;
import com.alibaba.mtl.log.b;
import com.alibaba.mtl.log.c;
import com.alibaba.mtl.log.d.i;
import com.ut.mini.base.UTMIVariables;
import com.ut.mini.core.appstatus.UTMCAppStatusRegHelper;
import com.ut.mini.core.sign.IUTRequestAuthentication;
import com.ut.mini.core.sign.UTBaseRequestAuthentication;
import com.ut.mini.core.sign.UTSecuritySDKRequestAuthentication;
import com.ut.mini.internal.UTOriginalCustomHitBuilder;
import com.ut.mini.internal.UTTeamWork;
import com.ut.mini.plugin.UTPluginMgr;
import com.ut.mini.sdkevents.UTMI1010_2001Event;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class UTAnalytics {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static UTAnalytics f12346a;
    private boolean M;
    private boolean N;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private UTTracker f151a;
    private Map<String, UTTracker> w = new HashMap();
    private Map<String, UTTracker> x = new HashMap();

    private UTAnalytics() {
        if (Build.VERSION.SDK_INT < 14) {
            UTMI1010_2001Event uTMI1010_2001Event = new UTMI1010_2001Event();
            UTPluginMgr.getInstance().registerPlugin(uTMI1010_2001Event, false);
            UTMIVariables.getInstance().setUTMI1010_2001EventInstance(uTMI1010_2001Event);
        } else {
            UTMI1010_2001Event uTMI1010_2001Event2 = new UTMI1010_2001Event();
            UTMCAppStatusRegHelper.registerAppStatusCallbacks(uTMI1010_2001Event2);
            UTMIVariables.getInstance().setUTMI1010_2001EventInstance(uTMI1010_2001Event2);
        }
    }

    public static synchronized UTAnalytics getInstance() {
        if (f12346a == null) {
            f12346a = new UTAnalytics();
        }
        return f12346a;
    }

    public synchronized UTTracker getDefaultTracker() {
        if (this.f151a == null) {
            this.f151a = new UTTracker();
        }
        if (this.f151a == null) {
            i.a("getDefaultTracker error", "Fatal Error,must call setRequestAuthentication method first.");
        }
        return this.f151a;
    }

    public synchronized UTTracker getTracker(String str) {
        if (TextUtils.isEmpty(str)) {
            i.a("getTracker", "TrackId is null.");
            return null;
        }
        if (this.w.containsKey(str)) {
            return this.w.get(str);
        }
        UTTracker uTTracker = new UTTracker();
        uTTracker.q(str);
        this.w.put(str, uTTracker);
        return uTTracker;
    }

    public synchronized UTTracker getTrackerByAppkey(String str) {
        if (TextUtils.isEmpty(str)) {
            i.a("getTracker", "TrackId is null.");
            return null;
        }
        if (this.x.containsKey(str)) {
            return this.x.get(str);
        }
        UTTracker uTTracker = new UTTracker();
        uTTracker.r(str);
        this.x.put(str, uTTracker);
        return uTTracker;
    }

    @Deprecated
    public void setAppApplicationInstance(Application application) {
        b.a().setAppApplicationInstance(application);
        AppMonitor.init(application);
    }

    public void setAppApplicationInstance4sdk(Application application, IUTApplication iUTApplication) {
        try {
            if (this.N) {
                return;
            }
            if (application == null || iUTApplication == null || application.getApplicationContext() == null) {
                throw new IllegalArgumentException("application and callback must not be null");
            }
            getInstance().setContext(application.getApplicationContext());
            getInstance().setAppApplicationInstance(application);
            if (iUTApplication.isUTLogEnable()) {
                getInstance().turnOnDebug();
            }
            getInstance().setChannel(iUTApplication.getUTChannel());
            getInstance().setAppVersion(iUTApplication.getUTAppVersion());
            getInstance().setRequestAuthentication(iUTApplication.getUTRequestAuthInstance());
            this.N = true;
        } catch (Throwable th) {
            try {
                i.a((String) null, th);
            } catch (Throwable unused) {
            }
        }
    }

    @Deprecated
    public void setAppVersion(String str) {
        b.a().setAppVersion(str);
    }

    @Deprecated
    public void setChannel(String str) {
        AppMonitor.setChannel(str);
    }

    @Deprecated
    public void setContext(Context context) {
        b.a().setContext(context);
        if (context != null) {
            UTTeamWork.getInstance().initialized();
        }
    }

    @Deprecated
    public void setRequestAuthentication(IUTRequestAuthentication iUTRequestAuthentication) {
        if (iUTRequestAuthentication == null) {
            i.a("setRequestAuthentication", "Fatal Error,pRequestAuth must not be null.");
        }
        if (!(iUTRequestAuthentication instanceof UTBaseRequestAuthentication)) {
            AppMonitor.setRequestAuthInfo(true, iUTRequestAuthentication.getAppkey(), null, ((UTSecuritySDKRequestAuthentication) iUTRequestAuthentication).getAuthCode());
            return;
        }
        String appkey = iUTRequestAuthentication.getAppkey();
        UTBaseRequestAuthentication uTBaseRequestAuthentication = (UTBaseRequestAuthentication) iUTRequestAuthentication;
        AppMonitor.setRequestAuthInfo(false, appkey, uTBaseRequestAuthentication.getAppSecret(), uTBaseRequestAuthentication.isEncode() ? "1" : "0");
    }

    public void turnOffAutoPageTrack() {
        UTPageHitHelper.getInstance().turnOffAutoPageTrack();
    }

    @Deprecated
    public void turnOnDebug() {
        b.a().turnOnDebug();
    }

    public void updateSessionProperties(Map<String, String> map) {
        Map<String, String> mapM26a = c.a().m26a();
        HashMap map2 = new HashMap();
        if (mapM26a != null) {
            map2.putAll(mapM26a);
        }
        map2.putAll(map);
        c.a().c(map2);
    }

    public void updateUserAccount(String str, String str2) {
        b.a().updateUserAccount(str, str2);
    }

    public void userRegister(String str) {
        if (TextUtils.isEmpty(str)) {
            i.a("userRegister", "Fatal Error,usernick can not be null or empty!");
            return;
        }
        UTTracker defaultTracker = getDefaultTracker();
        if (defaultTracker != null) {
            defaultTracker.send(new UTOriginalCustomHitBuilder("UT", 1006, str, null, null, null).build());
        } else {
            i.a("Record userRegister event error", "Fatal Error,must call setRequestAuthentication method first.");
        }
    }

    public void setAppApplicationInstance(Application application, IUTApplication iUTApplication) {
        try {
            if (this.M) {
                return;
            }
            if (application != null && iUTApplication != null && application.getApplicationContext() != null) {
                getInstance().setContext(application.getApplicationContext());
                getInstance().setAppApplicationInstance(application);
                if (iUTApplication.isUTLogEnable()) {
                    getInstance().turnOnDebug();
                }
                getInstance().setChannel(iUTApplication.getUTChannel());
                getInstance().setAppVersion(iUTApplication.getUTAppVersion());
                getInstance().setRequestAuthentication(iUTApplication.getUTRequestAuthInstance());
                this.N = true;
                this.M = true;
                return;
            }
            throw new IllegalArgumentException("application and callback must not be null");
        } catch (Throwable th) {
            try {
                i.a((String) null, th);
            } catch (Throwable unused) {
            }
        }
    }
}
