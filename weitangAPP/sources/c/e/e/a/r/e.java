package c.e.e.a.r;

import android.app.Activity;
import androidx.annotation.NonNull;
import c.e.a.d.q;
import c.e.e.a.x.k;
import c.e.e.a.x.l;
import c.m.a.d;
import com.alibaba.fastjson.JSON;
import com.chinavisionary.twlib.R;
import com.chinavisionary.twlib.open.OpenDoorActivity;
import java.util.List;
import java.util.Locale;
import org.android.agoo.common.AgooConstants;

/* JADX INFO: loaded from: classes2.dex */
public class e extends c.e.e.a.r.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public c.e.e.a.s.f f2394c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Activity f2395d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f2396e;

    public e(d dVar) {
        super(dVar);
    }

    public final void h(List<c.m.a.e.a> list) {
        d dVar = this.f2383a;
        if (dVar != null) {
            dVar.uploadDoorCommands(list);
        }
    }

    public final String i(String str) {
        return ("03".equals(str) ? k.getString(R.string.title_tw_lib_auth_err) : "06".equals(str) ? k.getString(R.string.title_tw_lib_auth_invalide) : "0E".equals(str) ? k.getString(R.string.title_tw_lib_auth_unavailable) : "0F".equals(str) ? k.getString(R.string.title_tw_lib_auth_expire) : AgooConstants.ACK_REMOVE_PACKAGE.equals(str) ? k.getString(R.string.title_tw_lib_auth_frozen) : "19".equals(str) ? k.getString(R.string.title_tw_lib_auth_value_err) : "") + ",code=" + str;
    }

    public final void j() {
        d dVar = this.f2383a;
        if (dVar != null) {
            dVar.onUnlockSuccess();
        }
    }

    public final void k(Activity activity, String str, c.m.a.e.b bVar) {
        l();
        c.m.a.d.getInstance().startOpenLock(activity, str, new a(bVar));
    }

    public final void l() {
        d dVar = this.f2383a;
        if (dVar != null) {
            dVar.onScanStart();
        }
    }

    public final void m(String str) {
        d dVar = this.f2383a;
        if (dVar != null) {
            dVar.onUnlockFailed(str);
        }
    }

    @Override // c.e.e.a.r.a
    public void openDoor(@NonNull c.e.e.a.x.d dVar, @NonNull Activity activity, c.e.e.a.s.f fVar) {
        this.f2394c = fVar;
        this.f2395d = activity;
        fVar.setOpenDoorStartTime(Long.valueOf(System.currentTimeMillis()));
        if (!k.isNotNull(dVar.getBluetoothMac())) {
            m(k.getString(R.string.title_tw_lib_mac_empty_open_failed));
            return;
        }
        c.m.a.e.b bVar = null;
        if (k.isNotNull(dVar.getBluetoothPassword())) {
            try {
                c.m.a.e.b bVar2 = (c.m.a.e.b) JSON.parseObject(dVar.getBluetoothPassword(), c.m.a.e.b.class);
                try {
                    if (fVar.getUserCacheOpenDoor() != null) {
                        this.f2396e = fVar.getUserCacheOpenDoor().booleanValue();
                        if (fVar.getUserCacheOpenDoor().booleanValue()) {
                            bVar2.setSetTime(null);
                            q.d(OpenDoorActivity.class.getSimpleName(), "openDoor getUserCacheOpenDoor set time is null");
                        }
                    }
                    bVar = bVar2;
                } catch (Exception e2) {
                    e = e2;
                    bVar = bVar2;
                    e.printStackTrace();
                    m(k.getString(R.string.title_tw_lib_json_invalid_open_failed));
                }
            } catch (Exception e3) {
                e = e3;
            }
        }
        if (bVar != null) {
            k(activity, dVar.getBluetoothMac(), bVar);
        }
    }

    @Override // c.e.e.a.r.a
    public void release() {
        c.m.a.d.getInstance().onDestroy(this.f2395d);
        this.f2395d = null;
    }

    public class a implements d.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c.m.a.e.b f2397a;

        public a(c.m.a.e.b bVar) {
            this.f2397a = bVar;
        }

        @Override // c.m.a.d.f
        public void getDoorMsg() {
            if (e.this.f2396e) {
                c.e.e.a.x.i.d(a.class.getSimpleName(), "getDoorMsg onlyOpenDoor");
                c.m.a.d.getInstance().onlyOpenDoor(this.f2397a);
            } else {
                c.e.e.a.x.i.d(a.class.getSimpleName(), "getDoorMsg sendDoorMsg");
                c.m.a.d.getInstance().sendDoorMsg(this.f2397a);
            }
        }

        @Override // c.m.a.d.f
        public void openDoorBlueStatus(int i2, String str) {
            if (i2 == 21) {
                e.this.f2383a.onScanEnd();
            } else if (i2 == 31) {
                e.this.f2383a.onConnect();
            }
            c.e.e.a.x.i.d(a.class.getSimpleName(), "openDoorStatus status =" + i2 + ",msg=" + str);
        }

        @Override // c.m.a.d.f
        public void uploadDoorCommands(List<c.m.a.e.a> list) {
            e.this.h(list);
            if (list != null) {
                c.e.e.a.x.i.d(a.class.getSimpleName(), "uploadDoorCommands =" + JSON.toJSONString(list));
            }
        }

        @Override // c.m.a.d.f
        public void openDoorBlueStatus(String str) {
            c.e.e.a.x.i.d(a.class.getSimpleName(), "openDoorBlueStatus resultCode =" + str);
            e.this.f2394c.setOpenDoorEndTime(Long.valueOf(System.currentTimeMillis()));
            if (str != null) {
                String upperCase = str.toUpperCase(Locale.ROOT);
                if ("00".equals(upperCase) || "35".equals(upperCase)) {
                    e.this.f2394c.setStatus(1);
                    e.this.j();
                    return;
                }
                e.this.f2394c.setStatus(0);
                e.this.f2394c.setFailReason(l.getInstance().getFailedMessage("code=" + upperCase));
                e eVar = e.this;
                eVar.m(eVar.i(upperCase));
            }
        }
    }
}
