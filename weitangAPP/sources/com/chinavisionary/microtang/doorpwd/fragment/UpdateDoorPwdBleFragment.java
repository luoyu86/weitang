package com.chinavisionary.microtang.doorpwd.fragment;

import android.bluetooth.BluetoothDevice;
import android.content.Intent;
import android.os.Build;
import android.os.Message;
import android.view.KeyEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.lifecycle.Observer;
import butterknife.BindView;
import butterknife.OnClick;
import c.e.a.d.q;
import c.e.a.d.x;
import c.e.c.q.b.a;
import c.e.c.q.d.d;
import c.e.c.q.d.e;
import c.e.e.a.u.c;
import c.p.a.a.j;
import c.p.a.a.k;
import c.p.a.a.l;
import com.chinavisionary.core.app.base.CoreBaseFragment;
import com.chinavisionary.core.app.net.base.dto.NewResponseStateVo;
import com.chinavisionary.core.app.net.base.dto.RequestErrDto;
import com.chinavisionary.core.weight.CoreRoundedImageView;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.base.BaseFragment;
import com.chinavisionary.microtang.doorpwd.model.DoorPasswordModel;
import com.chinavisionary.microtang.doorpwd.vo.ResponseDoorPasswordBleCommandBo;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class UpdateDoorPwdBleFragment extends BaseFragment<String> implements j {
    public ResponseDoorPasswordBleCommandBo C;
    public l D;
    public DoorPasswordModel H;
    public c I;

    @BindView(R.id.img_ble_connect_state)
    public CoreRoundedImageView mConnectStateImg;

    @BindView(R.id.tv_ble_connect_timer)
    public TextView mConnectTimerTv;

    @BindView(R.id.tv_mt_tip_msg)
    public TextView mMtTipMsgTv;

    @BindView(R.id.tv_operation_state)
    public TextView mOperationStateTv;

    @BindView(R.id.tv_pwd_value_title)
    public TextView mPwdValueTitleTv;

    @BindView(R.id.tv_pwd_value)
    public TextView mPwdValueTv;

    @BindView(R.id.tv_room_name)
    public TextView mRoomNameTv;

    @BindView(R.id.ll_state)
    public LinearLayout mStateLLayout;

    @BindView(R.id.tv_title)
    public TextView mTitleTv;
    public int B = 30;
    public boolean E = false;
    public boolean F = false;
    public volatile boolean G = true;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: W1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void X1() {
        this.mConnectTimerTv.setVisibility(0);
        this.mConnectTimerTv.setEnabled(true);
        this.mConnectTimerTv.setText("重新扫描");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: Y1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void Z1(String str) {
        this.mConnectTimerTv.setText(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void b2() {
        this.mStateLLayout.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: c2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void d2() {
        this.mStateLLayout.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: e2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void f2(String str) {
        this.mOperationStateTv.setText(str);
    }

    public static UpdateDoorPwdBleFragment getInstance(ResponseDoorPasswordBleCommandBo responseDoorPasswordBleCommandBo) {
        UpdateDoorPwdBleFragment updateDoorPwdBleFragment = new UpdateDoorPwdBleFragment();
        updateDoorPwdBleFragment.C = responseDoorPasswordBleCommandBo;
        return updateDoorPwdBleFragment;
    }

    public final void E1() {
        F0(R.string.tw_lib_tip_ble_un_enable);
        if (!this.I.getAllPermission(this.f6487e)) {
            i2();
            return;
        }
        Intent intent = new Intent("android.bluetooth.adapter.action.REQUEST_ENABLE");
        intent.setFlags(268435456);
        startActivityForResult(intent, 2);
    }

    public final void F1(String str) {
        q.d(this.f6485c, "handleBleResult result = " + str);
        if (e.MA_TAI.equals(this.C.getModelName())) {
            String[] mtCommandAndResultCode = a.getMtCommandAndResultCode(str);
            String str2 = mtCommandAndResultCode[0];
            String str3 = mtCommandAndResultCode[1];
            q.d(this.f6485c, "handleBleResult command = " + str2 + ", resultCode = " + str3);
            K1(str2, str3);
            return;
        }
        if (e.ZISNOO_ROUTE.equals(this.C.getModelName())) {
            String[] gMCommandAndResultCode = a.getGMCommandAndResultCode(str);
            String str4 = gMCommandAndResultCode[0];
            String str5 = gMCommandAndResultCode[1];
            q.d(this.f6485c, "handleBleResult ZISNOO_ROUTE command = " + str4 + ", resultCode = " + str5);
            J1(str4, str5);
        }
    }

    public final void G1() {
        if (this.I.isEnableBle()) {
            i2();
        } else {
            E1();
        }
    }

    public final void H1() {
        u2(x.getString(R.string.title_bel_communication));
        k2(0);
        q2();
    }

    public final String I1(String str, String str2) {
        String str3;
        this.mConnectTimerTv.setEnabled(false);
        if (str2.equals(str)) {
            this.E = true;
            str3 = "密码删除成功";
        } else {
            this.E = false;
            str3 = "密码删除失败，请重试。" + a.parseOpenDoorResult(str);
        }
        this.G = false;
        n2(str3);
        t2();
        return str3;
    }

    public final void J1(String str, String str2) {
        String strN1;
        str.hashCode();
        switch (str) {
            case "BA0A":
                strN1 = N1(str2, "EE08");
                break;
            case "BA34":
                if (str2.equals("EE13")) {
                    str2 = "EE08";
                }
                strN1 = M1(str2, "EE08");
                break;
            case "BA35":
                strN1 = I1(str2, "EE08");
                break;
            default:
                strN1 = "";
                break;
        }
        q.d(this.f6485c, "onReadResult operationResult = " + strN1);
    }

    public final void K1(String str, String str2) {
        String strN1 = "0A".equals(str) ? N1(str2, "00") : "03".equals(str) ? M1(str2, "00") : "04".equals(str) ? I1(str2, "00") : "05".equals(str) ? P1(str2, "00") : "06".equals(str) ? O1(str2, "00") : "";
        q.d(this.f6485c, "onReadResult operationResult = " + strN1);
    }

    public final void L1(NewResponseStateVo newResponseStateVo) {
        q.d(this.f6485c, "handleResult");
    }

    public final String M1(String str, String str2) {
        String str3;
        this.mConnectTimerTv.setEnabled(false);
        long j = (x.isNotNull(this.C.getFreezeOnlinePassword()) || x.isNotNull(this.C.getUnfreezeOnlinePassword())) ? 1500L : 500L;
        boolean zEquals = str2.equals(str);
        if (zEquals) {
            str3 = "密码设置成功";
            this.f6488f.sendEmptyMessageDelayed(2, j);
            this.f6488f.sendMessageDelayed(this.f6488f.obtainMessage(3, "密码设置成功"), j);
        } else {
            str3 = "密码设置失败，请重试。" + a.parseOpenDoorResult(str);
            n2(str3);
        }
        s2();
        h2(zEquals, str3, str, this.C.getCommandId());
        if (!zEquals) {
            t2();
        } else if (!x.isNotNull(this.C.getFreezeOnlinePassword()) && !x.isNotNull(this.C.getUnfreezeOnlinePassword())) {
            t2();
        } else if (x.isNotNull(this.C.getFreezeOnlinePassword())) {
            this.D.writerData(this.C.getFreezeOnlinePassword(), false);
        } else {
            this.D.writerData(this.C.getUnfreezeOnlinePassword(), false);
        }
        return str3;
    }

    public final String N1(String str, String str2) {
        boolean zEquals = str2.equals(str);
        this.mConnectTimerTv.setEnabled(false);
        if (zEquals) {
            this.E = true;
            if (this.F) {
                this.D.writerData(a.getUpdatePwdCommand(), false);
            } else {
                this.D.writerData(this.C.getCommand(), false);
            }
            return "时间设置成功,设置密码";
        }
        this.E = false;
        String str3 = "时间设置失败，请重试。" + a.parseOpenDoorResult(str);
        n2(str3);
        t2();
        h2(false, str3, str, this.C.getSetupCommandId());
        return str3;
    }

    public final String O1(String str, String str2) {
        String str3;
        if (str2.equals(str)) {
            this.E = true;
            str3 = "操作成功";
        } else {
            this.E = false;
            str3 = "操作成功，请重试。" + a.parseOpenDoorResult(str);
        }
        q.d(this.f6485c, "handleUpdateFreePwdResult tipMsg = " + str3);
        t2();
        return str3;
    }

    public final String P1(String str, String str2) {
        String str3;
        long j = (x.isNotNull(this.C.getFreezeOnlinePassword()) || x.isNotNull(this.C.getUnfreezeOnlinePassword())) ? 1500L : 500L;
        boolean zEquals = str2.equals(str);
        this.mConnectTimerTv.setEnabled(false);
        if (zEquals) {
            this.E = true;
            str3 = "密码修改成功";
            this.f6488f.sendEmptyMessageDelayed(2, j);
            this.f6488f.sendMessageDelayed(this.f6488f.obtainMessage(3, "密码修改成功"), j);
        } else {
            this.E = false;
            str3 = "密码修改失败，请重试。" + a.parseOpenDoorResult(str);
            n2(str3);
        }
        s2();
        h2(zEquals, str3, str, this.C.getCommandId());
        if (!zEquals) {
            t2();
        } else if (!x.isNotNull(this.C.getFreezeOnlinePassword()) && !x.isNotNull(this.C.getUnfreezeOnlinePassword())) {
            t2();
        } else if (x.isNotNull(this.C.getFreezeOnlinePassword())) {
            this.D.writerData(this.C.getFreezeOnlinePassword(), false);
        } else {
            this.D.writerData(this.C.getUnfreezeOnlinePassword(), false);
        }
        return str3;
    }

    public final void Q1() {
        this.mPwdValueTv.setVisibility(0);
        this.mPwdValueTitleTv.setVisibility(0);
    }

    public final void R1() {
        this.mPwdValueTv.setText(this.C.getDoorPwd());
        this.mPwdValueTitleTv.setText(R.string.title_open_door_number_pwd);
        this.mTitleTv.setText(R.string.title_door_pwd);
        this.mRoomNameTv.setText(this.C.getRoomName());
        this.mConnectTimerTv.setEnabled(false);
        this.mConnectTimerTv.setOnClickListener(this.y);
        this.f6488f = new CoreBaseFragment.c(this);
        o2();
        this.D = new l(this);
    }

    public final void S1() {
        DoorPasswordModel doorPasswordModel = (DoorPasswordModel) h(DoorPasswordModel.class);
        this.H = doorPasswordModel;
        doorPasswordModel.getDoorPasswordCommandResult().observeForever(new Observer() { // from class: c.e.c.q.c.f
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f1816a.L1((NewResponseStateVo) obj);
            }
        });
        this.H.getErrRequestLiveData().observeForever(new Observer() { // from class: c.e.c.q.c.i
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f1819a.C((RequestErrDto) obj);
            }
        });
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void V(View view) {
        if (view.getId() == R.id.tv_ble_connect_timer) {
            r2(false);
        } else if (view.getId() == R.id.tv_alert_confirm) {
            this.I.performOpenGPS(this.f6487e, 1);
        }
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void W() {
        S1();
        m2();
        R1();
        G1();
    }

    @OnClick({R.id.btn_add_pwd})
    public void addPwd() {
        r2(false);
    }

    @OnClick({R.id.tv_back})
    public void backFinish() {
        if (this.G) {
            F0(R.string.tip_setup_pwd_not_exit);
        } else {
            n();
        }
    }

    @OnClick({R.id.btn_del_pwd})
    public void delPwd() {
        this.E = true;
        r2(true);
    }

    public final void g2() {
        if (!this.I.checkGPSIsOpen(this.f6487e)) {
            u0(x.getString(R.string.tw_lib_tip_ble_scan_need_open_location));
        } else if (this.I.isEnableBle()) {
            r2(false);
        } else {
            E1();
        }
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public int getLayoutId() {
        return R.layout.fragment_update_door_pwd_ble;
    }

    public final void h2(boolean z, String str, String str2, String str3) {
        d dVar = new d();
        dVar.setSuccess(z);
        dVar.setAssetKey(this.C.getAssetKey());
        dVar.setMessage(str);
        dVar.setCode(str2);
        ArrayList arrayList = new ArrayList();
        arrayList.add(str3);
        dVar.setCommandIds(arrayList);
        this.G = false;
        this.H.postDoorPasswordResult(dVar);
    }

    public final void i2() {
        if (Build.VERSION.SDK_INT < 23) {
            g2();
            return;
        }
        List<String> allMustPermission = this.I.getAllMustPermission();
        if (this.I.checkAllMustPermission(allMustPermission, this.f6487e)) {
            g2();
            return;
        }
        String[] strArr = new String[allMustPermission.size()];
        allMustPermission.toArray(strArr);
        ActivityCompat.requestPermissions(this.f6487e, strArr, 18);
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void j0() {
    }

    public final void j2() {
        this.mMtTipMsgTv.post(new Runnable() { // from class: c.e.c.q.c.h
            @Override // java.lang.Runnable
            public final void run() {
                this.f1818a.X1();
            }
        });
    }

    public final void k2(int i2) {
        this.mConnectTimerTv.setVisibility(i2);
        this.mConnectStateImg.setVisibility(i2);
    }

    public final void l2() {
        this.mMtTipMsgTv.setVisibility(0);
        a.setupMtUuid();
    }

    public final void m2() {
        this.I = new c();
    }

    public final void n2(final String str) {
        this.mMtTipMsgTv.post(new Runnable() { // from class: c.e.c.q.c.d
            @Override // java.lang.Runnable
            public final void run() {
                this.f1813a.Z1(str);
            }
        });
    }

    public final void o2() {
        k.getInstance().setReadDataToDisconnect(false);
        if (e.MA_TAI.equals(this.C.getModelName())) {
            l2();
        } else if (e.ZISNOO_ROUTE.equals(this.C.getModelName())) {
            p2();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == 1 && this.I.checkGPSIsOpen(this.f6487e)) {
            G1();
        } else if (i2 == 2) {
            G1();
        }
    }

    @Override // c.p.a.a.j
    public void onConnect() {
    }

    @Override // c.p.a.a.j
    public void onConnectError(String str) {
        u2(str);
        h2(false, str, null, this.C.getSetupCommandId());
        j2();
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.D.release();
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (!this.G) {
            return false;
        }
        F0(R.string.tip_setup_pwd_not_exit);
        return true;
    }

    @Override // c.p.a.a.j
    public void onReadResult(String str) {
        String strReplace = str.replace("#", "");
        q.d(this.f6485c, "onReadResult result = " + strReplace);
        F1(strReplace);
    }

    @Override // androidx.fragment.app.Fragment
    public void onRequestPermissionsResult(int i2, @NonNull String[] strArr, @NonNull int[] iArr) {
        if (18 == i2) {
            if (this.I.isAuthPermission(strArr, iArr)) {
                g2();
            } else {
                F0(R.string.tw_lib_tip_open_location_permission);
            }
        }
    }

    @Override // c.p.a.a.j
    public void onScanEnd() {
    }

    @Override // c.p.a.a.j
    public void onScanError(String str) {
        u2(str);
        h2(false, str, null, this.C.getSetupCommandId());
        j2();
    }

    @Override // c.p.a.a.j
    public void onScanResult(BluetoothDevice bluetoothDevice) {
    }

    @Override // c.p.a.a.j
    public void onScanStart() {
        u2(x.getString(R.string.tip_ble_scaning));
    }

    @Override // c.p.a.a.j
    public void onUnlockFailed(String str) {
    }

    @Override // c.p.a.a.j
    public void onUnlockPwdFailed(String str) {
    }

    @Override // c.p.a.a.j
    public void onUnlockSuccess() {
    }

    @Override // c.p.a.a.j
    public void onUnlocking() {
        this.mMtTipMsgTv.post(new Runnable() { // from class: c.e.c.q.c.g
            @Override // java.lang.Runnable
            public final void run() {
                this.f1817a.H1();
            }
        });
    }

    public final void p2() {
        this.mMtTipMsgTv.setVisibility(8);
        a.setupZiSnooUuid();
    }

    public final void q2() {
        if (this.G) {
            int i2 = this.B - 1;
            this.B = i2;
            if (i2 <= 0) {
                j2();
                return;
            }
            this.mConnectTimerTv.setText("密码修改中(" + this.B + ")");
            this.f6488f.sendEmptyMessageDelayed(1, 1000L);
        }
    }

    public final void r2(boolean z) {
        this.G = true;
        k2(8);
        this.mPwdValueTitleTv.setVisibility(8);
        this.mPwdValueTv.setVisibility(8);
        this.mStateLLayout.setVisibility(0);
        c.p.a.b.a aVar = new c.p.a.b.a();
        aVar.setBluetoothMac(this.C.getMacAddress());
        if (!this.E) {
            aVar.setBluetoothPassword(this.C.getSetupCommand());
        } else if (!z) {
            aVar.setBluetoothPassword(this.C.getCommand());
        } else if (this.C.getModelName().equals(e.ZISNOO_ROUTE)) {
            aVar.setBluetoothPassword(a.getGMDelPwdCommand());
        } else {
            aVar.setBluetoothPassword(a.getDelPwdCommand());
        }
        this.D.openDoor(aVar, getActivity());
    }

    public final void s2() {
        this.F = false;
        this.f6488f.removeMessages(1);
        this.f6488f.post(new Runnable() { // from class: c.e.c.q.c.j
            @Override // java.lang.Runnable
            public final void run() {
                this.f1820a.b2();
            }
        });
    }

    public final void t2() {
        this.F = false;
        this.f6488f.removeMessages(1);
        this.f6488f.post(new Runnable() { // from class: c.e.c.q.c.e
            @Override // java.lang.Runnable
            public final void run() {
                this.f1815a.d2();
            }
        });
        this.D.release();
    }

    public final void u2(final String str) {
        q.d(this.f6485c, "updateLoad msg = " + str);
        this.mMtTipMsgTv.post(new Runnable() { // from class: c.e.c.q.c.k
            @Override // java.lang.Runnable
            public final void run() {
                this.f1821a.f2(str);
            }
        });
    }

    @OnClick({R.id.btn_update_pwd})
    public void updatePwd() {
        this.F = true;
        this.E = false;
        r2(false);
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void z(Message message) {
        super.z(message);
        int i2 = message.what;
        if (i2 == 1) {
            q2();
            return;
        }
        if (i2 == 2) {
            Q1();
        } else {
            if (i2 != 3) {
                return;
            }
            Object obj = message.obj;
            n2(obj instanceof String ? (String) obj : "");
        }
    }
}
