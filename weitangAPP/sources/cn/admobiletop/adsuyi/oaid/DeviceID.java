package cn.admobiletop.adsuyi.oaid;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import cn.admobiletop.adsuyi.oaid.a.t;

/* JADX INFO: loaded from: classes.dex */
public final class DeviceID implements IGetter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Application f4301a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f4302b;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final DeviceID f4303a = new DeviceID();
    }

    public static String getOAID() {
        String str = a.f4303a.f4302b;
        return str == null ? "" : str;
    }

    public static void register(Application application) {
        if (application == null) {
            return;
        }
        DeviceID deviceID = a.f4303a;
        deviceID.f4301a = application;
        getOAID(application, deviceID);
    }

    public static boolean supportedOAID(Context context) {
        return t.a(context).a();
    }

    @Override // cn.admobiletop.adsuyi.oaid.IGetter
    public void onOAIDGetComplete(String str) {
        if (TextUtils.isEmpty(str)) {
            onOAIDGetError(new c("OAID is empty"));
        } else {
            this.f4302b = str;
        }
    }

    @Override // cn.admobiletop.adsuyi.oaid.IGetter
    public void onOAIDGetError(Exception exc) {
    }

    public DeviceID() {
    }

    public static void getOAID(Context context, IGetter iGetter) {
        t.a(context).a(iGetter);
    }
}
