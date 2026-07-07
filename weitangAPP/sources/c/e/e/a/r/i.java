package c.e.e.a.r;

import android.app.Activity;
import android.bluetooth.BluetoothDevice;
import c.e.e.a.x.l;
import c.q.a.a.k;
import com.alibaba.fastjson.JSON;
import com.vtown.doorlibrary.bo.BleUnlockResponse;
import com.vtown.doorlibrary.bo.ResponseBlePwdBo;

/* JADX INFO: loaded from: classes2.dex */
public class i extends c.e.e.a.r.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final k f2408c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final c.q.a.a.i f2409d;

    public class a implements c.q.a.a.i {
        public a() {
        }

        @Override // c.q.a.a.i
        public void onConnect() {
            d dVar = i.this.f2383a;
            if (dVar != null) {
                dVar.onConnect();
            }
        }

        @Override // c.q.a.a.i
        public void onConnectError(String str) {
            l.getInstance().addFailed();
            d dVar = i.this.f2383a;
            if (dVar != null) {
                dVar.onConnectError(str);
            }
        }

        @Override // c.q.a.a.i
        public void onReadResult(String str) {
        }

        @Override // c.q.a.a.i
        public void onScanEnd() {
            d dVar = i.this.f2383a;
            if (dVar != null) {
                dVar.onScanEnd();
            }
        }

        @Override // c.q.a.a.i
        public void onScanError(String str) {
            l.getInstance().addFailed();
            d dVar = i.this.f2383a;
            if (dVar != null) {
                dVar.onScanError(str);
            }
        }

        @Override // c.q.a.a.i
        public void onScanResult(BluetoothDevice bluetoothDevice) {
        }

        @Override // c.q.a.a.i
        public void onScanStart() {
            d dVar = i.this.f2383a;
            if (dVar != null) {
                dVar.onScanStart();
            }
        }

        @Override // c.q.a.a.i
        public void onUnlockFailed(String str) {
            d dVar = i.this.f2383a;
            if (dVar != null) {
                dVar.onUnlockFailed(str);
            }
        }

        @Override // c.q.a.a.i
        public void onUnlockPwdFailed(String str) {
            onUnlockFailed(str);
        }

        @Override // c.q.a.a.i
        public void onUnlockSuccess() {
            d dVar = i.this.f2383a;
            if (dVar != null) {
                dVar.onUnlockSuccess();
            }
        }

        @Override // c.q.a.a.i
        public void onUnlocking() {
            d dVar = i.this.f2383a;
            if (dVar != null) {
                dVar.onUnlocking();
            }
        }
    }

    public i(d dVar) {
        super(dVar);
        a aVar = new a();
        this.f2409d = aVar;
        this.f2408c = new k(aVar);
    }

    public final void b(c.e.e.a.x.d dVar, Activity activity, c.e.e.a.s.f fVar) {
        fVar.setOpenDoorStartTime(Long.valueOf(System.currentTimeMillis()));
        BleUnlockResponse bleUnlockResponse = new BleUnlockResponse();
        try {
            bleUnlockResponse.setBluetoothMac(dVar.getBluetoothMac());
            bleUnlockResponse.setBluetoothPassword(JSON.toJSONString(((ResponseBlePwdBo) JSON.parseObject(dVar.getBluetoothPassword(), ResponseBlePwdBo.class)).getOpenDoor()));
            bleUnlockResponse.setBluetoothCookie(dVar.getBluetoothCookie());
            this.f2408c.openDoor(bleUnlockResponse, activity);
        } catch (Exception e2) {
            e2.printStackTrace();
            d dVar2 = this.f2383a;
            if (dVar2 != null) {
                dVar2.onUnlockFailed("开锁失败,数据解析错误!");
            }
        }
    }

    @Override // c.e.e.a.r.a
    public void openDoor(c.e.e.a.x.d dVar, Activity activity, c.e.e.a.s.f fVar) {
        b(dVar, activity, fVar);
    }

    @Override // c.e.e.a.r.a
    public void release() {
        this.f2408c.release();
    }
}
