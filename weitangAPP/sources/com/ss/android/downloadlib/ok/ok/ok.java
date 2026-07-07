package com.ss.android.downloadlib.ok.ok;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.IBinder;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Pair;
import com.ss.android.downloadlib.addownload.r;
import com.ss.android.downloadlib.ok.ok.bl;
import com.tom_roush.pdfbox.contentstream.operator.OperatorName;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class ok {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static volatile ok f9893h = null;
    private static String kf = "";
    private static String n = "";
    private static String s = "";
    public bl ok;
    private Context r;
    private boolean p = true;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private boolean f9895q = false;
    private volatile boolean k = false;
    private final List<Pair<a, s>> j = new ArrayList();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<InterfaceC0139ok> f9894a = new ArrayList();
    private final ServiceConnection z = new ServiceConnection() { // from class: com.ss.android.downloadlib.ok.ok.ok.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            synchronized (ok.this.bl) {
                ok.this.ok(false);
                ok.this.ok = bl.ok.ok(iBinder);
                ok.this.bl();
                Iterator<InterfaceC0139ok> it = ok.this.f9894a.iterator();
                while (it.hasNext()) {
                    it.next().ok();
                }
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            synchronized (ok.this.bl) {
                ok.this.ok(false);
                ok okVar = ok.this;
                okVar.ok = null;
                Iterator<InterfaceC0139ok> it = okVar.f9894a.iterator();
                while (it.hasNext()) {
                    it.next().a();
                }
            }
        }
    };
    private String rh = "";
    public final Object bl = new Object();

    /* JADX INFO: renamed from: com.ss.android.downloadlib.ok.ok.ok$ok, reason: collision with other inner class name */
    public interface InterfaceC0139ok {
        void a();

        void ok();
    }

    private ok() {
    }

    public static ok ok() {
        if (f9893h == null) {
            synchronized (ok.class) {
                if (f9893h == null) {
                    f9893h = new ok();
                }
            }
        }
        return f9893h;
    }

    public void a() {
        if (this.ok != null) {
            this.r.unbindService(this.z);
            this.ok = null;
        }
        this.f9894a.clear();
        this.j.clear();
    }

    public void bl() {
        for (Pair<a, s> pair : this.j) {
            try {
                this.ok.ok((a) pair.first, (s) pair.second);
            } catch (RemoteException e2) {
                e2.printStackTrace();
            }
        }
        this.j.clear();
    }

    public boolean s() {
        return this.k;
    }

    public boolean ok(Context context, boolean z) {
        if (TextUtils.isEmpty(s)) {
            JSONObject jSONObjectQ = r.q();
            String strOptString = jSONObjectQ.optString(OperatorName.CLOSE_AND_STROKE);
            s = com.ss.android.socialbase.appdownloader.kf.bl.ok(jSONObjectQ.optString(OperatorName.SAVE), strOptString);
            n = com.ss.android.socialbase.appdownloader.kf.bl.ok(jSONObjectQ.optString("u"), strOptString);
            kf = com.ss.android.socialbase.appdownloader.kf.bl.ok(jSONObjectQ.optString(OperatorName.SET_LINE_WIDTH), strOptString);
        }
        this.f9895q = z;
        if (context == null) {
            return true;
        }
        this.r = context.getApplicationContext();
        if (TextUtils.isEmpty(kf)) {
            kf = this.r.getPackageName();
        }
        if (this.ok != null || s()) {
            return true;
        }
        return this.r.bindService(ok(context), this.z, 33);
    }

    public Intent ok(Context context) {
        Intent intent = new Intent();
        intent.setAction(s);
        List<ResolveInfo> listQueryIntentServices = context.getPackageManager().queryIntentServices(intent, 0);
        if (listQueryIntentServices == null || listQueryIntentServices.size() != 1) {
            return null;
        }
        Iterator<ResolveInfo> it = listQueryIntentServices.iterator();
        while (it.hasNext()) {
            ServiceInfo serviceInfo = it.next().serviceInfo;
            String str = serviceInfo.packageName;
            String str2 = serviceInfo.name;
            if (n.equals(str)) {
                ComponentName componentName = new ComponentName(str, str2);
                Intent intent2 = new Intent(intent);
                intent2.setComponent(componentName);
                return intent2;
            }
        }
        return null;
    }

    public void ok(a aVar, s sVar) {
        synchronized (this.bl) {
            aVar.n = kf;
            if (TextUtils.isEmpty(aVar.kf)) {
                aVar.kf = this.rh;
            }
            bl blVar = this.ok;
            if (blVar != null) {
                try {
                    blVar.ok(aVar, sVar);
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                }
            } else if (s() || ok(this.r, this.f9895q)) {
                this.j.add(Pair.create(aVar, sVar));
            }
        }
    }

    public void ok(boolean z) {
        this.k = z;
    }
}
