package c.e.e.a.r;

import android.app.Activity;
import android.bluetooth.BluetoothDevice;
import androidx.annotation.NonNull;
import c.e.a.d.o;
import c.e.a.d.q;
import c.p.a.a.j;
import c.p.a.a.k;
import c.p.a.a.l;
import com.alibaba.fastjson.JSON;
import com.chinavisionary.twlib.R;
import com.chinavisionary.twlib.open.OpenDoorActivity;
import java.util.List;
import org.android.agoo.common.AgooConstants;

/* JADX INFO: loaded from: classes2.dex */
public class f extends c.e.e.a.r.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public l f2399c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public c.e.e.a.s.f f2400d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public c.m.a.e.b f2401e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f2402f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Activity f2403g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f2404h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f2405i;
    public j j;

    public class a implements j {
        public a() {
        }

        @Override // c.p.a.a.j
        public void onConnect() {
            f.this.f2383a.onConnect();
        }

        @Override // c.p.a.a.j
        public void onConnectError(String str) {
            f.this.f2383a.onConnectError(str);
        }

        @Override // c.p.a.a.j
        public void onReadResult(String str) {
            boolean z;
            String strReplace = str.replace("#", "");
            c.e.e.a.x.i.d(a.class.getSimpleName(), "openDoorBlueStatus onReadResult =" + strReplace);
            String[] mtCommandAndResultCode = f.this.getMtCommandAndResultCode(strReplace);
            if ((strReplace.indexOf("9A") == 0 && f.this.f2405i == 1) || mtCommandAndResultCode[0].equals("0A")) {
                f.this.f2401e.setSetTime(null);
                f.this.f2405i = 2;
                f.this.o();
                return;
            }
            f.this.f2400d.setOpenDoorEndTime(Long.valueOf(System.currentTimeMillis()));
            if (strReplace.indexOf("9A") == 0 && f.this.f2405i == 2 && strReplace.length() > 50) {
                String strK = f.this.k(strReplace);
                z = "00".equals(strK) || "35".equals(strK);
                c.e.e.a.x.i.d(a.class.getSimpleName(), "openDoorBlueStatus open door oldMtOpenDoorResult =" + strK);
            } else {
                z = false;
            }
            if (z) {
                f.this.f2400d.setStatus(1);
                f.this.l();
                return;
            }
            String str2 = mtCommandAndResultCode[1];
            c.e.e.a.x.i.d(a.class.getSimpleName(), "openDoorBlueStatus open door resultCode =" + str2);
            if (str2 == null) {
                c.e.e.a.x.i.d(a.class.getSimpleName(), "openDoorBlueStatus open door resultCode is empty");
                return;
            }
            if ("00".equals(str2) || "35".equals(str2)) {
                f.this.f2400d.setStatus(1);
                f.this.l();
                c.e.e.a.x.i.d(a.class.getSimpleName(), "openDoorBlueStatus open door handleLockSuccess");
                return;
            }
            f.this.f2400d.setStatus(0);
            f.this.f2400d.setFailReason(c.e.e.a.x.l.getInstance().getFailedMessage("code=" + str2));
            onUnlockFailed(f.this.j(str2));
            c.e.e.a.x.i.d(a.class.getSimpleName(), "openDoorBlueStatus open door onUnlockFailed");
        }

        @Override // c.p.a.a.j
        public void onScanEnd() {
            f.this.f2383a.onScanEnd();
        }

        @Override // c.p.a.a.j
        public void onScanError(String str) {
            f.this.f2383a.onScanError(str);
        }

        @Override // c.p.a.a.j
        public void onScanResult(BluetoothDevice bluetoothDevice) {
        }

        @Override // c.p.a.a.j
        public void onScanStart() {
            f.this.f2383a.onScanStart();
        }

        @Override // c.p.a.a.j
        public void onUnlockFailed(String str) {
            f.this.f2383a.onUnlockFailed(str);
        }

        @Override // c.p.a.a.j
        public void onUnlockPwdFailed(String str) {
        }

        @Override // c.p.a.a.j
        public void onUnlockSuccess() {
        }

        @Override // c.p.a.a.j
        public void onUnlocking() {
            f.this.f2383a.onUnlocking();
        }
    }

    public f(d dVar) {
        super(dVar);
        this.f2401e = null;
        this.f2402f = null;
        this.f2405i = 0;
        this.j = new a();
        k.getInstance().setReadDataToDisconnect(false);
        p();
        this.f2399c = new l(this.j);
    }

    public String getBleCommandToJsonString(List<String> list) {
        c.p.a.b.b bVar = new c.p.a.b.b();
        bVar.setCommand(list);
        return JSON.toJSONString(bVar);
    }

    public String[] getMtCommandAndResultCode(String str) {
        int length = str.length() - 10;
        String strSubstring = str.substring(length, length + 2);
        int length2 = str.length() - 8;
        String strSubstring2 = str.substring(length2, length2 + 2);
        c.e.e.a.x.i.d(f.class.getSimpleName(), "getMtCommandAndResultCode command = " + strSubstring + ", resultCode =" + strSubstring2);
        return new String[]{strSubstring, strSubstring2};
    }

    public final String j(String str) {
        return ("03".equals(str) ? c.e.e.a.x.k.getString(R.string.title_tw_lib_auth_err) : "06".equals(str) ? c.e.e.a.x.k.getString(R.string.title_tw_lib_auth_invalide) : "0E".equals(str) ? c.e.e.a.x.k.getString(R.string.title_tw_lib_auth_unavailable) : "0F".equals(str) ? c.e.e.a.x.k.getString(R.string.title_tw_lib_auth_expire) : AgooConstants.ACK_REMOVE_PACKAGE.equals(str) ? c.e.e.a.x.k.getString(R.string.title_tw_lib_auth_frozen) : "19".equals(str) ? c.e.e.a.x.k.getString(R.string.title_tw_lib_auth_value_err) : "") + ",code=" + str;
    }

    public final String k(String str) {
        return str.contains("AAAA") ? str.substring(str.length() - 6).replaceAll("AAAA", "") : "35";
    }

    public final void l() {
        d dVar = this.f2383a;
        if (dVar != null) {
            dVar.onUnlockSuccess();
        }
    }

    public final void m(String str, c.m.a.e.b bVar) {
        c.p.a.b.a aVar = new c.p.a.b.a();
        aVar.setBluetoothMac(str);
        if (bVar.getSetTime() != null) {
            if (o.isNotEmpty(bVar.getSetTime().getCommand())) {
                this.f2405i = 1;
                c.e.e.a.x.i.d(f.class.getSimpleName(), "openDoorBlueStatus set time");
                aVar.setBluetoothPassword(getBleCommandToJsonString(bVar.getSetTime().getCommand()));
            }
        } else if (bVar.getOpenDoor() != null && o.isNotEmpty(bVar.getOpenDoor().getCommand())) {
            this.f2405i = 2;
            c.e.e.a.x.i.d(f.class.getSimpleName(), "openDoorBlueStatus set open door");
            aVar.setBluetoothPassword(getBleCommandToJsonString(bVar.getOpenDoor().getCommand()));
        }
        this.f2399c.openDoor(aVar, this.f2403g);
    }

    public final void n(String str) {
        d dVar = this.f2383a;
        if (dVar != null) {
            dVar.onUnlockFailed(str);
        }
    }

    public final void o() {
        if (this.f2401e.getOpenDoor() == null) {
            n("密码数据为空");
        } else {
            if (!o.isNotEmpty(this.f2401e.getOpenDoor().getCommand())) {
                n("密码数据为空");
                return;
            }
            c.e.e.a.x.i.d(f.class.getSimpleName(), "openDoorBlueStatus set open door");
            this.f2399c.writerData(getBleCommandToJsonString(this.f2401e.getOpenDoor().getCommand()), false);
        }
    }

    @Override // c.e.e.a.r.a
    public void openDoor(@NonNull c.e.e.a.x.d dVar, @NonNull Activity activity, c.e.e.a.s.f fVar) {
        this.f2400d = fVar;
        this.f2403g = activity;
        fVar.setOpenDoorStartTime(Long.valueOf(System.currentTimeMillis()));
        if (!c.e.e.a.x.k.isNotNull(dVar.getBluetoothMac())) {
            n(c.e.e.a.x.k.getString(R.string.title_tw_lib_mac_empty_open_failed));
            return;
        }
        this.f2402f = dVar.getBluetoothMac();
        if (c.e.e.a.x.k.isNotNull(dVar.getBluetoothPassword())) {
            try {
                this.f2401e = (c.m.a.e.b) JSON.parseObject(dVar.getBluetoothPassword(), c.m.a.e.b.class);
                if (fVar.getUserCacheOpenDoor() != null) {
                    this.f2404h = fVar.getUserCacheOpenDoor().booleanValue();
                    if (fVar.getUserCacheOpenDoor().booleanValue()) {
                        this.f2401e.setSetTime(null);
                        q.d(OpenDoorActivity.class.getSimpleName(), "openDoor getUserCacheOpenDoor set time is null");
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                n(c.e.e.a.x.k.getString(R.string.title_tw_lib_json_invalid_open_failed));
            }
        }
        if (this.f2401e != null) {
            m(dVar.getBluetoothMac(), this.f2401e);
        }
    }

    public final void p() {
        k.getInstance().setReadDataToDisconnect(false);
        k.getInstance().setServiceUuid("0000FFF0-0000-1000-8000-00805F9B34FB");
        k.getInstance().setNotifyUuid("0000fff3-0000-1000-8000-00805f9b34fb");
        k.getInstance().setWriterUuid("0000fff2-0000-1000-8000-00805f9b34fb");
    }

    @Override // c.e.e.a.r.a
    public void release() {
        this.f2399c.release();
        this.f2403g = null;
    }
}
