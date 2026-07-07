package c.e.e.a.r;

import android.app.Activity;
import android.content.Context;
import c.e.e.a.x.k;
import cn.com.heaton.blelibrary.ble.Ble;
import cn.com.heaton.blelibrary.ble.BluetoothOperation;
import cn.com.heaton.blelibrary.ble.L;
import cn.com.heaton.blelibrary.ble.event.CommandResultEvent;
import cn.com.heaton.blelibrary.ble.event.ConnectionChangedEvent;
import com.chinavisionary.twlib.R;

/* JADX INFO: loaded from: classes2.dex */
public class c extends a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile c f2388c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f2389d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f2390e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public c.e.e.a.x.d f2391f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Activity f2392g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f2393h;

    public c() {
        super(null);
        this.f2393h = 1;
        Ble.Options options = new Ble.Options();
        options.logBleExceptions = true;
        L.init(options);
    }

    public static synchronized c getInstance() {
        if (f2388c == null) {
            synchronized (c.class) {
                if (f2388c == null) {
                    f2388c = new c();
                }
            }
        }
        return f2388c;
    }

    public final void b(int i2) {
        if (!this.f2389d) {
            e(k.getString(R.string.tw_lib_title_pwd_and_cookie_err) + ",code=" + i2);
            return;
        }
        this.f2389d = false;
        f(k.getString(R.string.tw_lib_title_pwd_err_use_cookie) + ",code=" + i2);
        c.e.e.a.x.d dVar = this.f2391f;
        if (dVar != null) {
            BluetoothOperation.openLockSuper3(null, dVar.getBluetoothMac(), this.f2391f.getBluetoothCookie(), true);
            return;
        }
        e(k.getString(R.string.tw_lib_title_pwd_err_unlock_failed) + ",code=" + i2);
    }

    public final void c(c.e.e.a.x.d dVar) {
        this.f2390e = true;
        this.f2389d = true;
        this.f2391f = dVar;
        d();
    }

    public final void d() {
        d dVar = this.f2383a;
        if (dVar != null) {
            dVar.onScanStart();
        }
    }

    public final void e(String str) {
        d dVar = this.f2383a;
        if (dVar != null) {
            dVar.onUnlockFailed(str);
        }
    }

    public final void f(String str) {
        d dVar = this.f2383a;
        if (dVar != null) {
            dVar.onUnlockPwdFailed(str);
        }
    }

    public final void g(c.e.e.a.x.d dVar, Context context) {
        if (dVar != null) {
            c(dVar);
            i(context);
        }
    }

    public final void h() {
        this.f2384b = false;
        this.f2392g = null;
        this.f2393h = 1;
        if (this.f2390e) {
            try {
                BluetoothOperation.release();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public final void i(Context context) {
        BluetoothOperation.openLock3(context, this.f2391f.getBluetoothMac(), this.f2391f.getBluetoothPassword(), true);
    }

    @Override // c.e.e.a.r.a
    public void onCommandResult(CommandResultEvent commandResultEvent) {
        String method = commandResultEvent.getMethod();
        int resultCode = commandResultEvent.getResultCode();
        c.e.e.a.x.i.d(c.class.getSimpleName(), "unlock result method :" + method + ",result code :" + resultCode);
        if (this.f2383a != null && k.isNotNull(method) && "openLock".equals(method)) {
            if (resultCode != 1) {
                b(resultCode);
            } else {
                this.f2383a.onUnlockSuccess();
            }
        }
    }

    @Override // c.e.e.a.r.a
    public void onConnectionChanged(ConnectionChangedEvent connectionChangedEvent) {
        int status = connectionChangedEvent.getStatus();
        c.e.e.a.x.i.d(c.class.getSimpleName(), "connect status :" + status);
        d dVar = this.f2383a;
        if (dVar != null) {
            if (status == 1) {
                dVar.onUnlocking();
                return;
            }
            if (status == 2) {
                dVar.onScanEnd();
                this.f2383a.onConnect();
            } else if (status == 3) {
                dVar.onConnectError(k.getString(R.string.tw_lib_title_connect_time_out));
            } else {
                if (status != 4) {
                    return;
                }
                dVar.onConnectError(k.getString(R.string.tw_lib_title_connect_failed));
            }
        }
    }

    @Override // c.e.e.a.r.a
    public void openDoor(c.e.e.a.x.d dVar, Activity activity, c.e.e.a.s.f fVar) {
        this.f2392g = activity;
        this.f2393h = 1;
        g(dVar, activity);
    }

    @Override // c.e.e.a.r.a
    public void release() {
        h();
    }

    public c setScanOnly(boolean z) {
        this.f2384b = z;
        return this;
    }
}
