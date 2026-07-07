package c.e.c.x.e;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.fastjson.JSON;
import com.chinavisionary.core.app.config.bo.AppConfigExtVo;
import com.chinavisionary.core.app.net.base.dto.NewResponseRowsVo;
import com.chinavisionary.core.app.net.base.dto.NewResponseStateVo;
import com.chinavisionary.core.app.net.base.dto.RequestErrDto;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.main.fragments.AppAlertFragment;
import com.chinavisionary.microtang.me.fragment.WaterAndElectricRecordTabFragment;
import com.chinavisionary.microtang.open.adapter.OftenUseRoomAdapter;
import com.chinavisionary.microtang.open.event.EventUpdateRoomCache;
import com.chinavisionary.microtang.open.fragment.OftenUseDeviceSetupFragment;
import com.chinavisionary.microtang.open.fragment.SwitchRoomFragment;
import com.chinavisionary.twlib.open.OpenDoorActivity;
import com.chinavisionary.twlib.open.bo.AlertMessageVo;
import com.chinavisionary.twlib.open.bo.ResponseOpenDoorVo;
import com.chinavisionary.twlib.open.model.OpenDoorModel;
import com.chinavisionary.twlib.open.model.OpenDoorPwdModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: loaded from: classes.dex */
public class n0 extends b0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TextView f2185b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public TextView f2186c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public TextView f2187d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public AppConfigExtVo f2188e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Drawable f2189f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Drawable f2190g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public TextView f2191h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public TextView f2192i;
    public RecyclerView j;
    public OftenUseRoomAdapter k;
    public c.e.e.a.s.f l;
    public c.e.e.a.s.e m;
    public OpenDoorPwdModel n;
    public OpenDoorModel o;
    public ReentrantLock p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final c.e.c.a0.f.a f2193q;
    public final View.OnClickListener r;

    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getTag() == null || !n0.this.f2124a.isLoginApp()) {
                return;
            }
            try {
                int iIntValue = ((Integer) view.getTag()).intValue();
                if (iIntValue >= 0) {
                    n0 n0Var = n0.this;
                    n0Var.m = n0Var.k.getList().get(iIntValue);
                    int openDoorModel = n0.this.m.getOpenDoorModel();
                    String assetInstanceKey = n0.this.m.getAssetInstanceKey();
                    if (openDoorModel == 1) {
                        c.e.a.d.u.getInstance().updateRemoteOpenDoorData(assetInstanceKey, false);
                        n0.this.m.setOpenDoorModel(0);
                    } else {
                        c.e.a.d.u.getInstance().updateRemoteOpenDoorData(assetInstanceKey, true);
                        n0.this.m.setOpenDoorModel(1);
                    }
                    n0.this.k.notifyItemChanged(iIntValue);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public class b implements c.e.a.a.c.c.a {
        public b() {
        }

        @Override // c.e.a.a.c.c.a
        public void onItemClickListener(View view, int i2) {
            if (i2 >= 0) {
                if (!n0.this.f2124a.isLoginApp()) {
                    n0.this.b0(false);
                    return;
                }
                n0 n0Var = n0.this;
                n0Var.m = n0Var.k.getList().get(i2);
                if (n0.this.m != null) {
                    if (n0.this.m.getItemType() != 8) {
                        if (n0.this.Z()) {
                            return;
                        }
                        n0.this.Q();
                    } else if (n0.this.f2124a.userIsRent()) {
                        n0 n0Var2 = n0.this;
                        n0Var2.f2124a.addFragment(OftenUseDeviceSetupFragment.getInstance(null, n0Var2.f2193q));
                    }
                }
            }
        }
    }

    public n0(g0 g0Var) {
        super(g0Var);
        this.f2188e = null;
        this.m = null;
        this.p = new ReentrantLock();
        this.f2193q = new c.e.c.a0.f.a() { // from class: c.e.c.x.e.q
            @Override // c.e.c.a0.f.a
            public final void onOftenUseDevice(List list) {
                this.f2209a.F(list);
            }
        };
        this.r = new View.OnClickListener() { // from class: c.e.c.x.e.t
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f2213a.H(view);
            }
        };
        FragmentActivity currentActivity = g0Var.getCurrentActivity();
        OpenDoorPwdModel openDoorPwdModel = (OpenDoorPwdModel) ViewModelProviders.of(currentActivity).get(OpenDoorPwdModel.class);
        this.n = openDoorPwdModel;
        openDoorPwdModel.getDoorVoMutableLiveData().observeForever(new Observer() { // from class: c.e.c.x.e.k
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f2159a.y((ResponseOpenDoorVo) obj);
            }
        });
        this.n.getmNetworkOpenDoorResult().observeForever(new Observer() { // from class: c.e.c.x.e.l
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f2168a.o((NewResponseStateVo) obj);
            }
        });
        this.n.getErrRequestLiveData().observeForever(new Observer() { // from class: c.e.c.x.e.v
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f2216a.q((RequestErrDto) obj);
            }
        });
        OpenDoorModel openDoorModel = (OpenDoorModel) ViewModelProviders.of(currentActivity).get(OpenDoorModel.class);
        this.o = openDoorModel;
        openDoorModel.getLockListLiveData().observeForever(new Observer() { // from class: c.e.c.x.e.m
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f2175a.l((NewResponseRowsVo) obj);
            }
        });
        this.o.getLockPowerListLiveData().observeForever(new Observer() { // from class: c.e.c.x.e.p
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f2202a.m((NewResponseRowsVo) obj);
            }
        });
        this.o.getLockStateListLiveData().observeForever(new Observer() { // from class: c.e.c.x.e.n
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f2184a.n((NewResponseRowsVo) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: A, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void B(RequestErrDto requestErrDto) {
        this.f2124a.hideAlertLoading();
        this.f2124a.showToast(requestErrDto.getErrMsg());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: C, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void D(final RequestErrDto requestErrDto) {
        c.e.e.a.s.e eVar;
        String pwdToAssetKey;
        Exception e2;
        boolean z = false;
        boolean z2 = true;
        if (requestErrDto != null && c.e.a.d.x.isNotNull(requestErrDto.getUrl())) {
            boolean zContains = requestErrDto.getUrl().contains("business/get/secretkey");
            c.e.a.d.q.d(n0.class.getSimpleName(), "handleGetBlePwdErr getUrl = " + requestErrDto.getUrl());
            if (zContains && requestErrDto.getCode() >= 500 && requestErrDto.getCode() <= 505 && (eVar = this.m) != null) {
                String assetInstanceKey = eVar.getAssetInstanceKey();
                if (c.e.a.d.x.isNotNull(assetInstanceKey) && (pwdToAssetKey = c.e.e.a.t.b.getInstance().getPwdToAssetKey(assetInstanceKey)) != null) {
                    try {
                        final ResponseOpenDoorVo responseOpenDoorVo = (ResponseOpenDoorVo) JSON.parseObject(pwdToAssetKey, ResponseOpenDoorVo.class);
                        if (responseOpenDoorVo != null) {
                            try {
                                responseOpenDoorVo.getBluetoothPassword();
                                this.f2185b.post(new Runnable() { // from class: c.e.c.x.e.w
                                    @Override // java.lang.Runnable
                                    public final void run() {
                                        this.f2217a.z(responseOpenDoorVo);
                                    }
                                });
                            } catch (Exception e3) {
                                e2 = e3;
                                e2.printStackTrace();
                            }
                        } else {
                            z = true;
                        }
                    } catch (Exception e4) {
                        e2 = e4;
                        z = true;
                    }
                    z2 = z;
                    c.e.a.d.q.d(n0.class.getSimpleName(), "getDoorPassword cache data : " + pwdToAssetKey);
                }
            }
            z = zContains;
        }
        if (z2) {
            if (z) {
                T(requestErrDto);
            }
            if (requestErrDto != null) {
                this.f2185b.post(new Runnable() { // from class: c.e.c.x.e.o
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f2196a.B(requestErrDto);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: E, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void F(List list) {
        i(list);
        if (this.k != null) {
            c.e.c.m0.j.updateRemoteOpenDoor(list);
            this.k.initListData(list);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: G, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void H(View view) {
        g0 g0Var = this.f2124a;
        if (g0Var == null || !g0Var.isLoginApp()) {
            return;
        }
        switch (view.getId()) {
            case R.id.tv_cat_device_record /* 2131232001 */:
                P();
                break;
            case R.id.tv_edit_often_use /* 2131232084 */:
                if (this.f2124a.userIsRent()) {
                    this.f2124a.addFragment(OftenUseDeviceSetupFragment.getInstance(null, this.f2193q));
                }
                break;
            case R.id.tv_room_name /* 2131232350 */:
            case R.id.tv_switch_room /* 2131232444 */:
                O();
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: I, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void J(List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            c.e.e.a.s.e eVar = (c.e.e.a.s.e) it.next();
            if (eVar != null && eVar.getLockType() != null && eVar.getLockType().intValue() != 1 && c.e.a.d.x.isNotNull(eVar.getAssetInstanceKey()) && c.e.a.d.x.isNotNull(eVar.getContractKey())) {
                this.o.getLockRoomStateList(eVar.getAssetInstanceKey(), eVar.getContractKey());
                this.o.getLockPowerList(eVar.getAssetInstanceKey(), eVar.getContractKey());
                try {
                    Thread.sleep(200L);
                } catch (InterruptedException e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: K, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void L(View view) {
        if (view.getId() == R.id.tv_alert_confirm) {
            Q();
        }
    }

    public final void N(boolean z, String str) {
        c.e.a.d.q.d("MeRoomInfoManager", "loadOftenUseRoom method = " + str);
        List<c.e.e.a.s.e> oftenDeviceList = c.e.c.x.c.a.getInstance().getOftenDeviceList();
        this.p.lock();
        try {
            i(oftenDeviceList);
            if (this.k != null) {
                c.e.c.m0.j.updateRemoteOpenDoor(oftenDeviceList);
                this.k.initListData(oftenDeviceList);
            }
            if (z) {
                V(oftenDeviceList);
            }
        } finally {
            this.p.unlock();
        }
    }

    public final void O() {
        this.f2124a.addFragment(SwitchRoomFragment.getInstance("2", null));
    }

    public final void P() {
        if (this.f2124a.userIsRent()) {
            this.f2124a.addFragment(WaterAndElectricRecordTabFragment.getInstance());
        }
    }

    public final void Q() {
        List<AlertMessageVo> lateFeeAlertMessageVo = c.e.c.m0.c.getInstance().getLateFeeAlertMessageVo();
        if (c.e.a.d.o.isNotEmpty(lateFeeAlertMessageVo)) {
            Iterator<AlertMessageVo> it = lateFeeAlertMessageVo.iterator();
            while (it.hasNext()) {
                this.f2124a.addFragment(AppAlertFragment.getInstance(it.next()));
            }
            return;
        }
        if (this.m != null) {
            U();
            String assetInstanceKey = this.m.getAssetInstanceKey();
            boolean z = true;
            if (this.m.getLockType().intValue() == 1 && this.m.getOpenDoorModel() != 0) {
                z = false;
            }
            if (!z) {
                this.f2124a.showAlertLoading(R.string.tip_open_door_network);
                c.e.e.a.s.f fVar = new c.e.e.a.s.f();
                this.l = fVar;
                fVar.setAssetInstanceKey(assetInstanceKey);
                this.l.setOpenDoorStartTime(Long.valueOf(System.currentTimeMillis()));
                this.l.setAppVersion(c.e.a.a.b.getInstance().getAppVersionName());
                c.e.e.a.s.h hVar = new c.e.e.a.s.h();
                hVar.setAssetKey(assetInstanceKey);
                this.n.postNetworkOpenDoor(hVar, "MeRoomInfoManager performGetPwd");
            } else if (c.e.e.a.x.l.getInstance().isUseCache(assetInstanceKey)) {
                String pwdToAssetKey = c.e.e.a.t.b.getInstance().getPwdToAssetKey(assetInstanceKey);
                if (pwdToAssetKey != null) {
                    try {
                        ResponseOpenDoorVo responseOpenDoorVo = (ResponseOpenDoorVo) JSON.parseObject(pwdToAssetKey, ResponseOpenDoorVo.class);
                        if (responseOpenDoorVo != null) {
                            responseOpenDoorVo.getBluetoothPassword();
                            y(responseOpenDoorVo);
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                    c.e.a.d.q.d(n0.class.getSimpleName(), "getDoorPassword cache data : " + pwdToAssetKey);
                }
            } else {
                this.f2124a.showAlertLoading(R.string.tip_load_get_pwding);
                c.e.e.a.s.f fVar2 = new c.e.e.a.s.f();
                this.l = fVar2;
                fVar2.setAssetInstanceKey(assetInstanceKey);
                this.l.setOpenDoorStartTime(Long.valueOf(System.currentTimeMillis()));
                this.l.setAppVersion(c.e.a.a.b.getInstance().getAppVersionName());
                this.n.getDoorPwd(assetInstanceKey, "MeRoomInfoManager performGetPwd");
            }
            g0 g0Var = this.f2124a;
            if (g0Var != null) {
                g0Var.handleOftenUseRoomEventMonitor(this.m.getAssetInstanceName());
            }
        }
    }

    public final void R(ResponseOpenDoorVo responseOpenDoorVo) {
        c.e.e.a.s.e eVar = this.m;
        if (eVar != null) {
            a0(eVar.getAssetInstanceKey(), responseOpenDoorVo);
        }
    }

    public final void S(NewResponseStateVo newResponseStateVo) {
        try {
            if (this.l == null) {
                c.e.e.a.s.f fVar = new c.e.e.a.s.f();
                this.l = fVar;
                fVar.setOpenDoorStartTime(Long.valueOf(System.currentTimeMillis()));
                this.l.setAppVersion(c.e.a.a.b.getInstance().getAppVersionName());
                c.e.e.a.s.e eVar = this.m;
                if (eVar != null) {
                    this.l.setAssetInstanceKey(eVar.getAssetInstanceKey());
                }
            }
            this.l.setRemark(c.e.a.d.x.getString(R.string.title_open_door_network));
            this.l.setStatus(Integer.valueOf(newResponseStateVo.isSuccess() ? 1 : 0));
            if (!newResponseStateVo.isSuccess()) {
                this.l.setFailReason(newResponseStateVo.getMessage());
            }
            this.l.setOpenDoorEndTime(Long.valueOf(System.currentTimeMillis()));
            this.n.postDoorPwdRecordLog(this.l);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final void T(RequestErrDto requestErrDto) {
        try {
            if (this.l == null) {
                c.e.e.a.s.f fVar = new c.e.e.a.s.f();
                this.l = fVar;
                fVar.setOpenDoorStartTime(Long.valueOf(System.currentTimeMillis()));
                this.l.setAppVersion(c.e.a.a.b.getInstance().getAppVersionName());
                c.e.e.a.s.e eVar = this.m;
                if (eVar != null) {
                    this.l.setAssetInstanceKey(eVar.getAssetInstanceKey());
                }
            }
            this.l.setRemark(c.e.a.d.x.getString(R.string.title_get_pwd_failed));
            this.l.setStatus(0);
            if (requestErrDto != null) {
                this.l.setFailReason(c.e.e.a.x.l.getInstance().getFailedMessage(requestErrDto.getErrMsg()));
                this.l.setRemark(this.l.getRemark() + "," + requestErrDto.getErrMsg());
            }
            this.l.setOpenDoorEndTime(Long.valueOf(System.currentTimeMillis()));
            this.n.postDoorPwdRecordLog(this.l);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final void U() {
        if (this.m.getLockType() == null || 1 != this.m.getLockType().intValue()) {
            return;
        }
        g.b.a.c.getDefault().post(new EventUpdateRoomCache());
    }

    public final void V(final List<c.e.e.a.s.e> list) {
        if (!c.e.a.d.o.isNotEmpty(list) || this.o == null) {
            return;
        }
        new Thread(new Runnable() { // from class: c.e.c.x.e.u
            @Override // java.lang.Runnable
            public final void run() {
                this.f2214a.J(list);
            }
        }).start();
    }

    public void W(AppConfigExtVo appConfigExtVo) {
        this.f2188e = appConfigExtVo;
    }

    public void X(boolean z) {
    }

    public void Y(String str) {
        this.f2185b.setText(c.e.a.d.x.getNotNullStr(str, c.e.a.d.x.getString(R.string.title_un_rent)));
        c.e.a.d.w.getInstance().putString("current_room_key", str);
        if (c.e.a.d.x.isNullStr(str)) {
            c.e.a.d.w.getInstance().putString("room_key", null);
        }
        s(c.e.a.d.x.isNotNull(str));
    }

    public final boolean Z() {
        AppConfigExtVo appConfigExtVoJ;
        c.e.e.a.s.e eVar = this.m;
        if (eVar == null || eVar.getSocLevel() == null || 1 != this.m.getSocLevel().intValue() || (appConfigExtVoJ = j()) == null) {
            return false;
        }
        this.f2124a.showAlertDialog(c.e.a.d.x.getString(R.string.title_alert_tip), appConfigExtVoJ.getLowBattery(), true, new View.OnClickListener() { // from class: c.e.c.x.e.r
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f2210a.L(view);
            }
        });
        return true;
    }

    public final void a0(String str, ResponseOpenDoorVo responseOpenDoorVo) {
        if (!c.e.a.d.x.isNotNull(str) || responseOpenDoorVo == null) {
            this.f2124a.showToast(R.string.tip_room_key_is_empty);
            return;
        }
        Intent intent = new Intent(this.f2124a.getCurrentActivity(), (Class<?>) OpenDoorActivity.class);
        intent.setFlags(268435456);
        intent.putExtra("key", str);
        intent.putExtra("isFirstOpenDoor", this.m.isAssetConfirmStatus());
        if (this.m.getAssetConfirmDeadline() != null) {
            intent.putExtra("assetConfirmDeadline", this.m.getAssetConfirmDeadline());
        }
        if (this.m.getLockType() != null) {
            intent.putExtra("open_type", this.m.getLockType());
        }
        intent.putExtra("contractKey", this.m.getContractKey());
        intent.putExtra("roomNameKey", this.m.getAssetInstanceName());
        intent.putExtra("responseOpenDoorVo", JSON.toJSONString(responseOpenDoorVo));
        this.f2124a.getCurrentActivity().startActivity(intent);
    }

    public void b0(boolean z) {
        if (!z || c.e.c.x.c.a.getInstance().getMaxCount() <= 0) {
            this.j.setVisibility(8);
            this.f2191h.setVisibility(8);
            this.f2192i.setVisibility(8);
        } else {
            if (this.j.getVisibility() == 8) {
                this.j.setVisibility(0);
            }
            if (this.f2191h.getVisibility() == 8) {
                this.f2191h.setVisibility(0);
                this.f2192i.setVisibility(0);
            }
            updateOftenRoomCache(true);
        }
    }

    public void c0() {
        List<c.e.e.a.s.e> list = this.k.getList();
        if (c.e.a.d.o.isNotEmpty(list)) {
            c.e.c.m0.j.updateRemoteOpenDoor(list);
            this.k.notifyDataSetChanged();
        }
    }

    public final void i(List<c.e.e.a.s.e> list) {
        c.e.e.a.s.e eVar = new c.e.e.a.s.e();
        eVar.setItemType(8);
        if (list == null || list.size() > c.e.c.x.c.a.getInstance().getMaxCount() - 1) {
            return;
        }
        list.add(eVar);
    }

    public final AppConfigExtVo j() {
        if (this.f2188e == null) {
            String string = c.e.a.d.w.getInstance().getString("app_config_info", null);
            if (c.e.a.d.x.isNotNull(string)) {
                try {
                    this.f2188e = (AppConfigExtVo) JSON.parseObject(string, AppConfigExtVo.class);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
        return this.f2188e;
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0055, code lost:
    
        c.e.a.d.q.d(getClass().getSimpleName(), "getDefaultRentRoom room name = " + r3.getAssetInstanceName());
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0075, code lost:
    
        r1 = r3;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public c.e.e.a.s.e k(com.chinavisionary.core.app.net.base.dto.ResponseRowsVo<c.e.e.a.s.d> r7, java.lang.String r8) {
        /*
            r6 = this;
            r0 = 0
            r1 = 0
            if (r7 == 0) goto L96
            c.e.c.x.c.a r2 = c.e.c.x.c.a.getInstance()
            java.util.List r3 = r7.getRows()
            boolean r3 = c.e.a.d.o.isNotEmpty(r3)
            r2.setShowWallet(r3)
            c.e.c.m0.j r2 = c.e.c.m0.j.getInstance()
            java.util.List r7 = r7.getRows()
            java.util.List r7 = r2.signLockToLock(r7)
            if (r7 == 0) goto L92
            boolean r2 = r7.isEmpty()
            if (r2 != 0) goto L92
            boolean r2 = c.e.a.d.x.isNotNull(r8)
            if (r2 == 0) goto L89
            boolean r2 = c.e.a.d.o.isNotEmpty(r7)     // Catch: java.lang.Exception -> L84
            if (r2 == 0) goto La0
            java.util.Iterator r2 = r7.iterator()     // Catch: java.lang.Exception -> L84
        L37:
            boolean r3 = r2.hasNext()     // Catch: java.lang.Exception -> L84
            if (r3 == 0) goto L7a
            java.lang.Object r3 = r2.next()     // Catch: java.lang.Exception -> L84
            c.e.e.a.s.e r3 = (c.e.e.a.s.e) r3     // Catch: java.lang.Exception -> L84
            if (r3 == 0) goto L37
            java.lang.String r4 = r3.getAssetInstanceKey()     // Catch: java.lang.Exception -> L84
            boolean r5 = c.e.a.d.x.isNotNull(r4)     // Catch: java.lang.Exception -> L84
            if (r5 == 0) goto L37
            boolean r4 = r8.equals(r4)     // Catch: java.lang.Exception -> L84
            if (r4 == 0) goto L37
            java.lang.Class r8 = r6.getClass()     // Catch: java.lang.Exception -> L77
            java.lang.String r8 = r8.getSimpleName()     // Catch: java.lang.Exception -> L77
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L77
            r1.<init>()     // Catch: java.lang.Exception -> L77
            java.lang.String r2 = "getDefaultRentRoom room name = "
            r1.append(r2)     // Catch: java.lang.Exception -> L77
            java.lang.String r2 = r3.getAssetInstanceName()     // Catch: java.lang.Exception -> L77
            r1.append(r2)     // Catch: java.lang.Exception -> L77
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Exception -> L77
            c.e.a.d.q.d(r8, r1)     // Catch: java.lang.Exception -> L77
            r1 = r3
            goto L7a
        L77:
            r7 = move-exception
            r1 = r3
            goto L85
        L7a:
            if (r1 != 0) goto La0
            java.lang.Object r7 = r7.get(r0)     // Catch: java.lang.Exception -> L84
            c.e.e.a.s.e r7 = (c.e.e.a.s.e) r7     // Catch: java.lang.Exception -> L84
        L82:
            r1 = r7
            goto La0
        L84:
            r7 = move-exception
        L85:
            r7.printStackTrace()
            goto La0
        L89:
            java.lang.Object r7 = r7.get(r0)
            c.e.e.a.s.e r7 = (c.e.e.a.s.e) r7
            if (r7 == 0) goto La0
            goto L82
        L92:
            r6.Y(r1)
            goto La0
        L96:
            c.e.c.x.c.a r7 = c.e.c.x.c.a.getInstance()
            r7.setShowWallet(r0)
            r6.Y(r1)
        La0:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: c.e.c.x.e.n0.k(com.chinavisionary.core.app.net.base.dto.ResponseRowsVo, java.lang.String):c.e.e.a.s.e");
    }

    public final void l(NewResponseRowsVo<c.e.e.a.s.e> newResponseRowsVo) {
        List<String> oftenDeviceKeyList = c.e.c.x.c.a.getInstance().getOftenDeviceKeyList();
        ArrayList arrayList = new ArrayList();
        if (newResponseRowsVo != null) {
            List<c.e.e.a.s.e> rows = newResponseRowsVo.getRows();
            if (c.e.a.d.o.isNotEmpty(rows)) {
                for (c.e.e.a.s.e eVar : rows) {
                    if (eVar != null && oftenDeviceKeyList.contains(eVar.getAssetInstanceKey())) {
                        arrayList.add(eVar);
                    }
                }
            }
        }
        c.e.c.x.c.a.getInstance().setOftenDeviceList(arrayList);
        N(true, "handleLockList");
    }

    public final void m(NewResponseRowsVo<c.e.e.a.s.e> newResponseRowsVo) {
        if (newResponseRowsVo == null || !c.e.a.d.o.isNotEmpty(newResponseRowsVo.getRows())) {
            return;
        }
        boolean z = false;
        for (c.e.e.a.s.e eVar : newResponseRowsVo.getRows()) {
            if (eVar != null && c.e.a.d.x.isNotNull(eVar.getAssetInstanceKey())) {
                c.e.c.x.c.a.getInstance().updateLockPower(eVar);
                z = true;
            }
        }
        if (z) {
            N(false, "handleLockPowerList");
        }
    }

    public final void n(NewResponseRowsVo<c.e.e.a.s.e> newResponseRowsVo) {
        if (newResponseRowsVo == null || !c.e.a.d.o.isNotEmpty(newResponseRowsVo.getRows())) {
            return;
        }
        boolean z = false;
        for (c.e.e.a.s.e eVar : newResponseRowsVo.getRows()) {
            if (eVar != null && c.e.a.d.x.isNotNull(eVar.getAssetInstanceKey())) {
                c.e.c.x.c.a.getInstance().updateAssetConfirmStatus(eVar);
                z = true;
            }
        }
        if (z) {
            N(false, "handleLockStateList");
        }
    }

    public final void o(NewResponseStateVo newResponseStateVo) {
        this.f2124a.hideAlertLoading();
        if (newResponseStateVo != null) {
            this.f2124a.showToast(newResponseStateVo.isSuccess() ? c.e.a.d.x.getString(R.string.title_open_door_success) : newResponseStateVo.getMessage());
            if (newResponseStateVo.isSuccess()) {
                this.f2124a.showOpenDoorSuccessAlert();
            }
            S(newResponseStateVo);
        }
    }

    /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
    public final void z(ResponseOpenDoorVo responseOpenDoorVo) {
        this.f2124a.hideAlertLoading();
        if (responseOpenDoorVo == null || !responseOpenDoorVo.isSuccess()) {
            return;
        }
        R(responseOpenDoorVo);
    }

    public final void q(final RequestErrDto requestErrDto) {
        new Thread(new Runnable() { // from class: c.e.c.x.e.s
            @Override // java.lang.Runnable
            public final void run() {
                this.f2211a.D(requestErrDto);
            }
        }).start();
    }

    public void r(View view) {
        OftenUseRoomAdapter oftenUseRoomAdapter = new OftenUseRoomAdapter();
        this.k = oftenUseRoomAdapter;
        oftenUseRoomAdapter.setHasBackground(true);
        this.k.setOnClickListener(new a());
        this.k.setOnItemClickListener(new b());
        this.j = (RecyclerView) view.findViewById(R.id.recycler_often_use);
        this.f2191h = (TextView) view.findViewById(R.id.tv_edit_often_use_title);
        this.f2192i = (TextView) view.findViewById(R.id.tv_edit_often_use);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(view.getContext());
        linearLayoutManager.setOrientation(0);
        this.j.setItemAnimator(null);
        this.j.setLayoutManager(linearLayoutManager);
        this.j.setAdapter(this.k);
        this.f2189f = view.getResources().getDrawable(R.mipmap.ic_room_location);
        this.f2190g = view.getResources().getDrawable(R.mipmap.ic_switch_room);
        this.f2185b = (TextView) view.findViewById(R.id.tv_room_name);
        this.f2186c = (TextView) view.findViewById(R.id.tv_switch_room);
        this.f2187d = (TextView) view.findViewById(R.id.tv_clean_title);
        this.f2185b.setOnClickListener(this.r);
        this.f2186c.setOnClickListener(this.r);
        this.f2192i.setOnClickListener(this.r);
        N(true, "initRoomInfoView");
    }

    public void s(boolean z) {
        if (z) {
            TextView textView = this.f2185b;
            textView.setTextColor(textView.getResources().getColor(R.color.color000000));
            this.f2185b.setCompoundDrawablesWithIntrinsicBounds(this.f2189f, (Drawable) null, this.f2190g, (Drawable) null);
        } else {
            TextView textView2 = this.f2185b;
            textView2.setTextColor(textView2.getResources().getColor(R.color.colore757575));
            this.f2185b.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
        }
    }

    public void updateOftenRoomCache(boolean z) {
        if (z) {
            this.o.getLockList();
        }
        N(true, "updateOftenRoomCache");
    }
}
