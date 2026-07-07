package com.chinavisionary.microtang.open.fragment;

import android.content.Intent;
import android.os.Message;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import butterknife.BindView;
import butterknife.OnClick;
import c.e.a.d.o;
import c.e.a.d.q;
import c.e.a.d.u;
import c.e.a.d.w;
import c.e.a.d.x;
import c.e.a.d.y;
import c.e.c.m0.j;
import c.e.e.a.s.h;
import c.e.e.a.x.k;
import c.e.e.a.x.l;
import com.alibaba.fastjson.JSON;
import com.chinavisionary.core.app.base.CoreBaseFragment;
import com.chinavisionary.core.app.config.bo.AppConfigExtVo;
import com.chinavisionary.core.app.event.EventUpdateSelectRoom;
import com.chinavisionary.core.app.net.base.dto.NewResponseRowsVo;
import com.chinavisionary.core.app.net.base.dto.NewResponseStateVo;
import com.chinavisionary.core.app.net.base.dto.RequestErrDto;
import com.chinavisionary.core.app.net.base.dto.ResponseRowsVo;
import com.chinavisionary.core.app.net.base.dto.ResponseStateVo;
import com.chinavisionary.core.weight.BaseRecyclerView;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.base.BaseFragment;
import com.chinavisionary.microtang.main.fragments.AppAlertFragment;
import com.chinavisionary.microtang.me.vo.EventSwitchRoomVo;
import com.chinavisionary.microtang.open.adapter.LockAdapter;
import com.chinavisionary.microtang.open.adapter.OftenUseRoomAdapter;
import com.chinavisionary.microtang.open.event.EventOpenDoorList;
import com.chinavisionary.microtang.open.event.EventUpdateRoomCache;
import com.chinavisionary.twlib.open.OpenDoorActivity;
import com.chinavisionary.twlib.open.bo.AlertMessageVo;
import com.chinavisionary.twlib.open.bo.ResponseOpenDoorVo;
import com.chinavisionary.twlib.open.model.NewOpenDoorModel;
import com.chinavisionary.twlib.open.model.OpenDoorModel;
import com.chinavisionary.twlib.open.model.OpenDoorPwdModel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: loaded from: classes.dex */
public class OpenRoomListFragment extends BaseFragment<c.e.e.a.s.e> {
    public OpenDoorModel B;
    public NewOpenDoorModel C;
    public OpenDoorPwdModel D;
    public c.e.e.a.s.e E;
    public c.e.e.a.s.e F;
    public List<c.e.e.a.s.e> G;
    public List<c.e.e.a.s.e> H;
    public OftenUseRoomAdapter I;
    public c.e.e.a.s.f O;
    public ResponseOpenDoorVo P;
    public boolean S;
    public c.e.c.a0.i.c T;

    @BindView(R.id.btn_retry_load_page)
    public AppCompatButton mAppCompatButton;

    @BindView(R.id.tv_custom_sort)
    public TextView mCustomSortTv;

    @BindView(R.id.recycler_often_use)
    public BaseRecyclerView mOftenUseRoomRecyclerList;

    @BindView(R.id.recycler_room_list)
    public BaseRecyclerView mRoomRecyclerList;

    @BindView(R.id.edt_search_room)
    public EditText mSearchRoomEdt;

    @BindView(R.id.tv_tip_msg)
    public TextView mTipMsgTv;

    @BindView(R.id.tv_tip_room_list_title)
    public TextView mTipRoomTitleTv;
    public boolean J = false;
    public boolean K = false;
    public String L = null;
    public String M = null;
    public ReentrantLock N = new ReentrantLock();
    public Map<String, ResponseOpenDoorVo> Q = new HashMap();
    public LinkedHashMap<String, c.e.e.a.s.e> R = new LinkedHashMap<>();
    public final c.e.a.a.c.c.a U = new a();
    public final TextWatcher V = new b();
    public final c.e.c.a0.f.a W = new c.e.c.a0.f.a() { // from class: c.e.c.a0.h.v
        @Override // c.e.c.a0.f.a
        public final void onOftenUseDevice(List list) {
            this.f1366a.p2(list);
        }
    };
    public c.e.c.a0.i.b c0 = new c.e.c.a0.i.b() { // from class: c.e.c.a0.h.k
        @Override // c.e.c.a0.i.b
        public final void sortResult(List list) {
            this.f1349a.r2(list);
        }
    };

    public class a implements c.e.a.a.c.c.a {
        public a() {
        }

        @Override // c.e.a.a.c.c.a
        public void onItemClickListener(View view, int i2) {
            if (i2 < 0) {
                i2 = 0;
            }
            OpenRoomListFragment openRoomListFragment = OpenRoomListFragment.this;
            openRoomListFragment.H2((c.e.e.a.s.e) openRoomListFragment.t.getList().get(i2));
        }
    }

    public class b implements TextWatcher {
        public b() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            OpenRoomListFragment.this.Q2(OpenRoomListFragment.this.mSearchRoomEdt.getText().toString());
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }
    }

    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getTag() != null) {
                try {
                    int iIntValue = ((Integer) view.getTag()).intValue();
                    if (iIntValue >= 0) {
                        c.e.e.a.s.e eVar = (c.e.e.a.s.e) OpenRoomListFragment.this.t.getList().get(iIntValue);
                        int openDoorModel = eVar.getOpenDoorModel();
                        String assetInstanceKey = eVar.getAssetInstanceKey();
                        if (openDoorModel == 1) {
                            u.getInstance().updateRemoteOpenDoorData(assetInstanceKey, false);
                            eVar.setOpenDoorModel(0);
                        } else {
                            u.getInstance().updateRemoteOpenDoorData(assetInstanceKey, true);
                            eVar.setOpenDoorModel(1);
                        }
                        j.updateRemoteOpenDoor(OpenRoomListFragment.this.I.getList());
                        OpenRoomListFragment.this.I.notifyDataSetChanged();
                        OpenRoomListFragment.this.t.notifyItemChanged(iIntValue);
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getTag() != null) {
                try {
                    int iIntValue = ((Integer) view.getTag()).intValue();
                    if (iIntValue >= 0) {
                        c.e.e.a.s.e eVar = OpenRoomListFragment.this.I.getList().get(iIntValue);
                        int openDoorModel = eVar.getOpenDoorModel();
                        String assetInstanceKey = eVar.getAssetInstanceKey();
                        if (openDoorModel == 1) {
                            u.getInstance().updateRemoteOpenDoorData(assetInstanceKey, false);
                            eVar.setOpenDoorModel(0);
                        } else {
                            u.getInstance().updateRemoteOpenDoorData(assetInstanceKey, true);
                            eVar.setOpenDoorModel(1);
                        }
                        OpenRoomListFragment.this.I.notifyItemChanged(iIntValue);
                        j.updateRemoteOpenDoor(OpenRoomListFragment.this.t.getList());
                        OpenRoomListFragment.this.t.notifyDataSetChanged();
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public class e implements c.e.a.a.c.c.a {
        public e() {
        }

        @Override // c.e.a.a.c.c.a
        public void onItemClickListener(View view, int i2) {
            if (i2 < 0) {
                i2 = 0;
            }
            c.e.e.a.s.e eVar = OpenRoomListFragment.this.I.getList().get(i2);
            if (eVar != null) {
                OpenRoomListFragment.this.h1("List-" + eVar.getAssetInstanceName());
            }
            OpenRoomListFragment.this.H2(eVar);
        }
    }

    public class f implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ List f8009a;

        public f(List list) {
            this.f8009a = list;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                OpenRoomListFragment.this.W2(this.f8009a, false);
                if (OpenRoomListFragment.this.L != null) {
                    OpenRoomListFragment openRoomListFragment = OpenRoomListFragment.this;
                    openRoomListFragment.Q2(openRoomListFragment.L);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: A2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void B2(NewResponseRowsVo newResponseRowsVo) {
        if (newResponseRowsVo == null || newResponseRowsVo.getRows() == null) {
            return;
        }
        Z2(newResponseRowsVo.getRows());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: D2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void E2() {
        this.t.notifyDataSetChanged();
        P2();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: F2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void G2() {
        this.t.notifyDataSetChanged();
        P2();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: d2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void e2() {
        try {
            List<c.e.e.a.s.e> roomList = c.e.e.a.t.b.getInstance().getRoomList();
            if (o.isNotEmpty(roomList)) {
                this.mAppCompatButton.post(new f(this.T.filterAllRoomList(roomList)));
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static OpenRoomListFragment getInstance(String str) {
        OpenRoomListFragment openRoomListFragment = new OpenRoomListFragment();
        openRoomListFragment.setArguments(CoreBaseFragment.q(str));
        return openRoomListFragment;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: h2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void i2(RequestErrDto requestErrDto) {
        C(requestErrDto);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: j2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void k2(final RequestErrDto requestErrDto) {
        c.e.e.a.s.e eVar;
        String pwdToAssetKey;
        Exception e2;
        boolean z = false;
        boolean z2 = true;
        if (requestErrDto != null && x.isNotNull(requestErrDto.getUrl())) {
            boolean zContains = requestErrDto.getUrl().contains("business/get/secretkey");
            q.d(getClass().getSimpleName(), "handleGetBlePwdErr getUrl = " + requestErrDto.getUrl());
            if (zContains && requestErrDto.getCode() >= 500 && requestErrDto.getCode() <= 505 && (eVar = this.E) != null) {
                String assetInstanceKey = eVar.getAssetInstanceKey();
                if (x.isNotNull(assetInstanceKey) && (pwdToAssetKey = c.e.e.a.t.b.getInstance().getPwdToAssetKey(assetInstanceKey)) != null) {
                    try {
                        final ResponseOpenDoorVo responseOpenDoorVo = (ResponseOpenDoorVo) JSON.parseObject(pwdToAssetKey, ResponseOpenDoorVo.class);
                        if (responseOpenDoorVo != null) {
                            try {
                                responseOpenDoorVo.getBluetoothPassword();
                                this.mTipRoomTitleTv.post(new Runnable() { // from class: c.e.c.a0.h.n
                                    @Override // java.lang.Runnable
                                    public final void run() {
                                        this.f1356a.g2(responseOpenDoorVo);
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
                    q.d(getClass().getSimpleName(), "getDoorPassword cache data : " + pwdToAssetKey);
                }
            }
            z = zContains;
        }
        if (!z2 || this.S) {
            return;
        }
        if (z) {
            M2(requestErrDto);
        }
        this.mTipRoomTitleTv.post(new Runnable() { // from class: c.e.c.a0.h.a0
            @Override // java.lang.Runnable
            public final void run() {
                this.f1325a.i2(requestErrDto);
            }
        });
    }

    private void o0() {
        this.H = new ArrayList();
        this.G = new ArrayList();
        this.r = this.mRoomRecyclerList;
        LockAdapter lockAdapter = new LockAdapter();
        this.t = lockAdapter;
        lockAdapter.setOnClickListener(new c());
        this.t.setOnItemClickListener(this.U);
        OftenUseRoomAdapter oftenUseRoomAdapter = new OftenUseRoomAdapter();
        this.I = oftenUseRoomAdapter;
        oftenUseRoomAdapter.setOnClickListener(new d());
        this.I.setOnItemClickListener(new e());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.f6487e);
        linearLayoutManager.setOrientation(0);
        this.mOftenUseRoomRecyclerList.setLayoutManager(linearLayoutManager);
        this.mOftenUseRoomRecyclerList.setAdapter(this.I);
        P2();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: o2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void p2(List list) {
        j.updateRemoteOpenDoor(list);
        this.I.initListData(list);
        if (o.isNotEmpty(list)) {
            this.mOftenUseRoomRecyclerList.setVisibility(0);
        } else {
            this.mOftenUseRoomRecyclerList.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: q2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void r2(List list) {
        if (o.isNotEmpty(list)) {
            this.K = true;
            this.M = null;
            this.mSearchRoomEdt.setText("");
            W2(list, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: s2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void t2(List list) {
        List<c.e.e.a.s.e> listQueryLockSortListToPhone = c.e.c.p.b.getInstance().queryLockSortListToPhone(s());
        boolean zListIsEmpty = o.listIsEmpty(listQueryLockSortListToPhone);
        if (zListIsEmpty) {
            this.T.roomOrder(list);
        }
        List<c.e.e.a.s.e> listLockSort = this.T.lockSort(listQueryLockSortListToPhone, list);
        if (zListIsEmpty) {
            this.F = null;
            listLockSort = this.T.filterAllRoomList(listLockSort);
        }
        this.H.clear();
        this.H.addAll(listLockSort);
        this.G.clear();
        this.G.addAll(listLockSort);
        U2(listLockSort);
        CoreBaseFragment.c cVar = this.f6488f;
        if (cVar != null) {
            cVar.obtainMessage(1).sendToTarget();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: u2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void v2(List list) {
        try {
            Thread.sleep(300L);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        int i2 = 0;
        try {
            ArrayList<c.e.e.a.s.e> arrayList = new ArrayList();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                c.e.e.a.s.e eVar = (c.e.e.a.s.e) it.next();
                if (eVar != null && eVar.getLockType() != null && 1 != eVar.getLockType().intValue() && (i2 = i2 + 1) <= 5) {
                    arrayList.add(eVar);
                }
            }
            if (o.isNotEmpty(arrayList)) {
                for (c.e.e.a.s.e eVar2 : arrayList) {
                    if (eVar2 != null) {
                        this.B.getLockPowerList(eVar2.getAssetInstanceKey(), eVar2.getContractKey());
                        this.B.getLockRoomStateList(eVar2.getAssetInstanceKey(), eVar2.getContractKey());
                        try {
                            Thread.sleep(100L);
                        } catch (InterruptedException e3) {
                            e3.printStackTrace();
                        }
                    }
                }
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: w2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void x2(NewResponseRowsVo newResponseRowsVo) {
        H();
        if (newResponseRowsVo == null || newResponseRowsVo.getRows() == null) {
            return;
        }
        List<c.e.e.a.s.e> rows = newResponseRowsVo.getRows();
        c.e.e.a.t.b.getInstance().insertRoomList(rows);
        this.mTipMsgTv.setVisibility(rows.isEmpty() ? 0 : 8);
        this.J = true;
        I2(rows);
        try {
            final List array = JSON.parseArray(JSON.toJSONString(rows), c.e.e.a.s.e.class);
            new Thread(new Runnable() { // from class: c.e.c.a0.h.y
                @Override // java.lang.Runnable
                public final void run() {
                    this.f1370a.v2(array);
                }
            }).start();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: y2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void z2(NewResponseRowsVo newResponseRowsVo) {
        if (newResponseRowsVo == null || newResponseRowsVo.getRows() == null) {
            return;
        }
        a3(newResponseRowsVo.getRows());
    }

    public final void H2(c.e.e.a.s.e eVar) {
        this.E = eVar;
        z0(Y1() ? R.string.tip_open_locking : R.string.tip_switch_rooming);
        if (Y1()) {
            T1();
            return;
        }
        NewOpenDoorModel newOpenDoorModel = this.C;
        if (newOpenDoorModel != null) {
            newOpenDoorModel.postSelectRoom(this.E);
        } else {
            this.B.postSelectRoom(this.E);
        }
    }

    public final void I2(final List<c.e.e.a.s.e> list) {
        if (o.isNotEmpty(list)) {
            this.mCustomSortTv.setVisibility(Y1() ? 0 : 8);
        }
        if (Y1()) {
            this.mSearchRoomEdt.setVisibility(list.size() < 5 ? 8 : 0);
        }
        y.get().addRunnable(new Runnable() { // from class: c.e.c.a0.h.x
            @Override // java.lang.Runnable
            public final void run() {
                this.f1368a.t2(list);
            }
        });
    }

    public final void J2() {
        List<AlertMessageVo> lateFeeAlertMessageVo = c.e.c.m0.c.getInstance().getLateFeeAlertMessageVo();
        if (o.isNotEmpty(lateFeeAlertMessageVo)) {
            H();
            Iterator<AlertMessageVo> it = lateFeeAlertMessageVo.iterator();
            while (it.hasNext()) {
                d(AppAlertFragment.getInstance(it.next()), R.id.constraint_main_content);
            }
            return;
        }
        if (this.E != null) {
            O2();
            String assetInstanceKey = this.E.getAssetInstanceKey();
            boolean z = true;
            if (this.E.getLockType().intValue() == 1 && this.E.getOpenDoorModel() != 0) {
                z = false;
            }
            if (!z) {
                z0(R.string.tip_open_door_network);
                c.e.e.a.s.f fVar = new c.e.e.a.s.f();
                this.O = fVar;
                fVar.setAssetInstanceKey(assetInstanceKey);
                this.O.setOpenDoorStartTime(Long.valueOf(System.currentTimeMillis()));
                this.O.setAppVersion(c.e.a.a.b.getInstance().getAppVersionName());
                h hVar = new h();
                hVar.setAssetKey(assetInstanceKey);
                this.D.postNetworkOpenDoor(hVar, this.f6485c + " performGetPwd");
                return;
            }
            if (l.getInstance().isUseCache(assetInstanceKey)) {
                String pwdToAssetKey = c.e.e.a.t.b.getInstance().getPwdToAssetKey(assetInstanceKey);
                if (pwdToAssetKey != null) {
                    try {
                        ResponseOpenDoorVo responseOpenDoorVo = (ResponseOpenDoorVo) JSON.parseObject(pwdToAssetKey, ResponseOpenDoorVo.class);
                        if (responseOpenDoorVo != null) {
                            responseOpenDoorVo.getBluetoothPassword();
                            f2(responseOpenDoorVo);
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                    q.d(getClass().getSimpleName(), "getDoorPassword cache data : " + pwdToAssetKey);
                    return;
                }
                return;
            }
            c.e.e.a.s.f fVar2 = new c.e.e.a.s.f();
            this.O = fVar2;
            fVar2.setAssetInstanceKey(assetInstanceKey);
            this.O.setOpenDoorStartTime(Long.valueOf(System.currentTimeMillis()));
            this.O.setAppVersion(c.e.a.a.b.getInstance().getAppVersionName());
            if (!this.Q.containsKey(assetInstanceKey)) {
                this.D.getDoorPwd(assetInstanceKey, this.f6485c + " performGetPwd");
                return;
            }
            ResponseOpenDoorVo responseOpenDoorVo2 = this.Q.get(assetInstanceKey);
            if (responseOpenDoorVo2 != null) {
                f2(responseOpenDoorVo2);
                return;
            }
            this.D.getDoorPwd(assetInstanceKey, this.f6485c + " performGetPwd containsKey");
        }
    }

    public final void K2(ResponseOpenDoorVo responseOpenDoorVo) {
        c.e.e.a.s.e eVar = this.E;
        if (eVar != null) {
            Y2(eVar.getAssetInstanceKey(), responseOpenDoorVo);
        }
    }

    public final void L2(NewResponseStateVo newResponseStateVo) {
        try {
            if (this.O == null) {
                c.e.e.a.s.f fVar = new c.e.e.a.s.f();
                this.O = fVar;
                fVar.setOpenDoorStartTime(Long.valueOf(System.currentTimeMillis()));
                this.O.setAppVersion(c.e.a.a.b.getInstance().getAppVersionName());
                c.e.e.a.s.e eVar = this.E;
                if (eVar != null) {
                    this.O.setAssetInstanceKey(eVar.getAssetInstanceKey());
                }
            }
            this.O.setRemark(x.getString(R.string.title_open_door_network));
            this.O.setStatus(Integer.valueOf(newResponseStateVo.isSuccess() ? 1 : 0));
            if (!newResponseStateVo.isSuccess()) {
                this.O.setFailReason(newResponseStateVo.getMessage());
            }
            this.O.setOpenDoorEndTime(Long.valueOf(System.currentTimeMillis()));
            this.D.postDoorPwdRecordLog(this.O);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final void M2(RequestErrDto requestErrDto) {
        try {
            if (this.O == null) {
                c.e.e.a.s.f fVar = new c.e.e.a.s.f();
                this.O = fVar;
                fVar.setOpenDoorStartTime(Long.valueOf(System.currentTimeMillis()));
                this.O.setAppVersion(c.e.a.a.b.getInstance().getAppVersionName());
                c.e.e.a.s.e eVar = this.E;
                if (eVar != null) {
                    this.O.setAssetInstanceKey(eVar.getAssetInstanceKey());
                }
            }
            this.O.setRemark(x.getString(R.string.title_get_pwd_failed));
            this.O.setStatus(0);
            if (requestErrDto != null) {
                this.O.setFailReason(l.getInstance().getFailedMessage(requestErrDto.getErrMsg()));
                this.O.setRemark(this.O.getRemark() + "," + requestErrDto.getErrMsg());
            }
            this.O.setOpenDoorEndTime(Long.valueOf(System.currentTimeMillis()));
            this.D.postDoorPwdRecordLog(this.O);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final void N2() {
        List<c.e.e.a.s.e> lockResponseVoList = c.e.e.a.u.d.getInstance().getLockResponseVoList();
        Map<String, ResponseOpenDoorVo> assetKeyPwsMap = c.e.e.a.u.d.getInstance().getAssetKeyPwsMap();
        if (assetKeyPwsMap != null) {
            this.Q = new HashMap(assetKeyPwsMap);
        }
        if (Y1() && o.isNotEmpty(lockResponseVoList)) {
            I2(lockResponseVoList);
        }
    }

    public final void O2() {
        if (this.E.getLockType() == null || 1 != this.E.getLockType().intValue()) {
            return;
        }
        g.b.a.c.getDefault().post(new EventUpdateRoomCache());
    }

    public final void P1(View view) {
        H2((c.e.e.a.s.e) view.getTag());
    }

    public final void P2() {
        q.d(this.f6485c, "refreshOftenUse");
        List<c.e.e.a.s.e> oftenDeviceList = c.e.c.x.c.a.getInstance().getOftenDeviceList();
        if (!o.isNotEmpty(oftenDeviceList)) {
            if (this.mOftenUseRoomRecyclerList.getVisibility() != 8) {
                this.mOftenUseRoomRecyclerList.setVisibility(8);
            }
        } else {
            if (this.mOftenUseRoomRecyclerList.getVisibility() != 0) {
                this.mOftenUseRoomRecyclerList.setVisibility(0);
            }
            j.updateRemoteOpenDoor(oftenDeviceList);
            this.I.initListData(oftenDeviceList);
        }
    }

    public final void Q1(NewResponseStateVo newResponseStateVo) {
        H();
        if (newResponseStateVo != null) {
            G0(newResponseStateVo.isSuccess() ? x.getString(R.string.title_open_door_success) : newResponseStateVo.getMessage());
            if (newResponseStateVo.isSuccess()) {
                showOpenDoorSuccessAlert();
            }
            L2(newResponseStateVo);
        }
    }

    public final void Q2(String str) {
        if (this.K) {
            this.K = false;
            return;
        }
        try {
            ArrayList arrayList = new ArrayList();
            LinkedHashMap<String, c.e.e.a.s.e> linkedHashMap = this.R;
            if (linkedHashMap != null && !linkedHashMap.isEmpty()) {
                for (Map.Entry<String, c.e.e.a.s.e> entry : this.R.entrySet()) {
                    if (!x.isNotNull(str)) {
                        arrayList.add(entry.getValue());
                    } else if (entry.getKey().contains(str.trim().toUpperCase())) {
                        arrayList.add(entry.getValue());
                    }
                }
            }
            this.M = str;
            q.d(this.f6485c, "requestSearch mCacheSearchResult = " + this.M);
            if (!x.isNullStr(str)) {
                W2(arrayList, false);
            } else {
                this.L = null;
                I2(arrayList);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX INFO: renamed from: R1, reason: merged with bridge method [inline-methods] */
    public final void g2(ResponseOpenDoorVo responseOpenDoorVo) {
        H();
        if (responseOpenDoorVo == null || !responseOpenDoorVo.isSuccess()) {
            return;
        }
        if (this.S) {
            this.Q.put(responseOpenDoorVo.getBaseKey(), responseOpenDoorVo);
        } else {
            K2(responseOpenDoorVo);
        }
    }

    public final void R2() {
        k(new EventOpenDoorList());
    }

    public final void S1(RequestErrDto requestErrDto) {
        H();
        if (requestErrDto != null) {
            String url = requestErrDto.getUrl();
            if (requestErrDto.getCode() >= 500 && requestErrDto.getCode() <= 505 && Z1(url)) {
                new Thread(new Runnable() { // from class: c.e.c.a0.h.l
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f1351a.e2();
                    }
                }).start();
            } else if (x.isNotNull(url) && this.t.getItemCount() == 0) {
                C(requestErrDto);
                this.mAppCompatButton.setVisibility(url.contains("business/house/access/controls?source=1") || url.contains("houses/list") ? 0 : 8);
            }
        }
    }

    public final void S2(c.e.e.a.s.e eVar, boolean z) {
        EventUpdateSelectRoom eventUpdateSelectRoom = new EventUpdateSelectRoom();
        eventUpdateSelectRoom.setKey(eVar.getAssetInstanceKey());
        eventUpdateSelectRoom.setName(eVar.getAssetInstanceName());
        eventUpdateSelectRoom.setShowMore(z);
        g.b.a.c.getDefault().post(eventUpdateSelectRoom);
    }

    public final void T1() {
        this.S = false;
        if (this.E == null || X2()) {
            return;
        }
        J2();
    }

    public final void T2() {
        OpenDoorPwdModel openDoorPwdModel = (OpenDoorPwdModel) h(OpenDoorPwdModel.class);
        this.D = openDoorPwdModel;
        openDoorPwdModel.getDoorVoMutableLiveData().observe(this, new Observer() { // from class: c.e.c.a0.h.i
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f1345a.f2((ResponseOpenDoorVo) obj);
            }
        });
        this.D.getmNetworkOpenDoorResult().observeForever(new Observer() { // from class: c.e.c.a0.h.o
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f1358a.Q1((NewResponseStateVo) obj);
            }
        });
        this.D.getErrRequestLiveData().observe(this, new Observer() { // from class: c.e.c.a0.h.t
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f1364a.U1((RequestErrDto) obj);
            }
        });
    }

    public final void U1(final RequestErrDto requestErrDto) {
        new Thread(new Runnable() { // from class: c.e.c.a0.h.p
            @Override // java.lang.Runnable
            public final void run() {
                this.f1359a.k2(requestErrDto);
            }
        }).start();
    }

    public final void U2(List<c.e.e.a.s.e> list) {
        if (this.R == null || !o.isNotEmpty(list)) {
            return;
        }
        try {
            this.R.clear();
            for (c.e.e.a.s.e eVar : list) {
                if (eVar != null && x.isNotNull(eVar.getAssetInstanceName())) {
                    this.R.put(eVar.getAssetInstanceName(), eVar);
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void V(View view) {
        int id = view.getId();
        if (id == R.id.btn_retry_load_page) {
            I1();
            view.setVisibility(8);
        } else if (id == R.id.tv_alert_confirm) {
            z0(R.string.tip_open_locking);
            J2();
        } else {
            if (id != R.id.view_open_room) {
                return;
            }
            P1(view);
        }
    }

    public final void V1(ResponseStateVo responseStateVo) {
        if (responseStateVo == null || !responseStateVo.isSuccess()) {
            F0(R.string.data_error);
            H();
            return;
        }
        this.J = true;
        k(new EventSwitchRoomVo());
        S2(this.E, true);
        w.getInstance().putString("current_room_key", this.E.getAssetInstanceName());
        w.getInstance().putString("room_key", this.E.getAssetInstanceKey());
        g0();
    }

    public final void V2() {
        OpenDoorModel openDoorModel = (OpenDoorModel) h(OpenDoorModel.class);
        this.B = openDoorModel;
        openDoorModel.getLockListLiveData().observe(this, new Observer() { // from class: c.e.c.a0.h.u
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f1365a.x2((NewResponseRowsVo) obj);
            }
        });
        this.B.getLockPowerListLiveData().observe(getViewLifecycleOwner(), new Observer() { // from class: c.e.c.a0.h.r
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f1362a.z2((NewResponseRowsVo) obj);
            }
        });
        this.B.getLockStateListLiveData().observe(getViewLifecycleOwner(), new Observer() { // from class: c.e.c.a0.h.j
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f1347a.B2((NewResponseRowsVo) obj);
            }
        });
        this.B.getSignLockListLiveData().observe(this, new Observer() { // from class: c.e.c.a0.h.s
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f1363a.W1((ResponseRowsVo) obj);
            }
        });
        this.B.getRoomSelectLiveData().observe(this, new Observer() { // from class: c.e.c.a0.h.w
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f1367a.V1((ResponseStateVo) obj);
            }
        });
        this.B.getErrRequestLiveData().observe(this, new Observer() { // from class: c.e.c.a0.h.h
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f1342a.S1((RequestErrDto) obj);
            }
        });
        if (c.e.a.a.a.getInstance().isH5Model()) {
            NewOpenDoorModel newOpenDoorModel = (NewOpenDoorModel) h(NewOpenDoorModel.class);
            this.C = newOpenDoorModel;
            newOpenDoorModel.getSignLockListLiveData().observe(this, new Observer() { // from class: c.e.c.a0.h.s
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    this.f1363a.W1((ResponseRowsVo) obj);
                }
            });
            this.C.getRoomSelectLiveData().observe(this, new Observer() { // from class: c.e.c.a0.h.w
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    this.f1367a.V1((ResponseStateVo) obj);
                }
            });
            this.C.getErrRequestLiveData().observe(this, new Observer() { // from class: c.e.c.a0.h.h
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    this.f1342a.S1((RequestErrDto) obj);
                }
            });
        }
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void W() {
        X1();
        o0();
        T2();
        V2();
        N2();
        z0(R.string.loading_text);
        I1();
        R2();
    }

    public final void W1(ResponseRowsVo<c.e.e.a.s.d> responseRowsVo) {
        H();
        if (responseRowsVo != null) {
            this.J = true;
            final List<c.e.e.a.s.e> listSignLockToLock = j.getInstance().signLockToLock(responseRowsVo.getRows());
            new Thread(new Runnable() { // from class: c.e.c.a0.h.q
                @Override // java.lang.Runnable
                public final void run() {
                    c.e.e.a.t.b.getInstance().insertRoomList(listSignLockToLock);
                }
            }).start();
            W2(listSignLockToLock, false);
        }
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    public final void W2(List<c.e.e.a.s.e> list, boolean z) {
        H();
        j.updateRemoteOpenDoor(list);
        this.t.initListData((List<T>) list);
    }

    public final void X1() {
        this.f6488f = new CoreBaseFragment.c(this);
        this.mSearchRoomEdt.setVisibility(8);
        this.mSearchRoomEdt.setRawInputType(2);
        this.mSearchRoomEdt.addTextChangedListener(this.V);
        this.mAppCompatButton.setOnClickListener(this.y);
        AppConfigExtVo appConfigExtVoO = o();
        if (appConfigExtVoO != null) {
            this.mTipMsgTv.setText(x.getNotNullStr(appConfigExtVoO.getCheckinTip(), x.getString(R.string.title_default_chckin_tip)));
        }
        this.T = new c.e.c.a0.i.c();
        if (Y1()) {
            this.L = w.getInstance().getString("cache_search_key", null);
        }
    }

    public final boolean X2() {
        AppConfigExtVo appConfigExtVoO;
        c.e.e.a.s.e eVar = this.E;
        if (eVar == null || eVar.getSocLevel() == null || 1 != this.E.getSocLevel().intValue() || (appConfigExtVoO = o()) == null) {
            return false;
        }
        D0(appConfigExtVoO.getLowBattery(), false);
        return true;
    }

    public final boolean Y1() {
        return this.f6484b.equals("1");
    }

    public final void Y2(String str, ResponseOpenDoorVo responseOpenDoorVo) {
        if (!x.isNotNull(str) || responseOpenDoorVo == null) {
            F0(R.string.tip_room_key_is_empty);
            return;
        }
        Intent intent = new Intent(this.f6487e, (Class<?>) OpenDoorActivity.class);
        intent.setFlags(268435456);
        intent.putExtra("key", str);
        intent.putExtra("isFirstOpenDoor", this.E.isAssetConfirmStatus());
        if (this.E.getAssetConfirmDeadline() != null) {
            intent.putExtra("assetConfirmDeadline", this.E.getAssetConfirmDeadline());
        }
        if (this.E.getLockType() != null) {
            intent.putExtra("open_type", this.E.getLockType());
        }
        intent.putExtra("contractKey", this.E.getContractKey());
        intent.putExtra("roomNameKey", this.E.getAssetInstanceName());
        intent.putExtra("responseOpenDoorVo", JSON.toJSONString(responseOpenDoorVo));
        startActivity(intent);
        g0();
    }

    public final boolean Z1(String str) {
        if (!x.isNotNull(str)) {
            return false;
        }
        boolean zContains = str.contains("house/access/controls?source=1");
        q.d(this.f6485c, "handleOpenDoorModelErr url = " + str + ",result = " + zContains);
        return zContains;
    }

    public final void Z2(List<c.e.e.a.s.e> list) {
        c.e.e.a.s.e eVar;
        q.d(this.f6485c, "updateLockConfirmState");
        this.N.lock();
        try {
            if (o.isNotEmpty(list)) {
                List<c.e.e.a.s.e> list2 = this.t.getList();
                HashMap map = new HashMap();
                for (c.e.e.a.s.e eVar2 : list) {
                    if (eVar2 != null && x.isNotNull(eVar2.getAssetInstanceKey())) {
                        map.put(eVar2.getAssetInstanceKey(), eVar2);
                    }
                }
                for (c.e.e.a.s.e eVar3 : list2) {
                    if (eVar3 != null && x.isNotNull(eVar3.getAssetInstanceKey()) && (eVar = (c.e.e.a.s.e) map.get(eVar3.getAssetInstanceKey())) != null) {
                        eVar3.setAssetConfirmStatus(eVar.isAssetConfirmStatus());
                        eVar3.setAssetConfirmDeadline(eVar.getAssetConfirmDeadline());
                        c.e.c.x.c.a.getInstance().updateAssetConfirmStatus(eVar3);
                    }
                }
            }
            CoreBaseFragment.c cVar = this.f6488f;
            if (cVar != null) {
                cVar.post(new Runnable() { // from class: c.e.c.a0.h.m
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f1353a.E2();
                    }
                });
            }
        } finally {
            this.N.unlock();
        }
    }

    public final void a3(List<c.e.e.a.s.e> list) {
        c.e.e.a.s.e eVar;
        q.d(this.f6485c, "updateLockPower");
        this.N.lock();
        try {
            if (o.isNotEmpty(list)) {
                List<c.e.e.a.s.e> list2 = this.t.getList();
                HashMap map = new HashMap();
                for (c.e.e.a.s.e eVar2 : list) {
                    if (eVar2 != null && x.isNotNull(eVar2.getAssetInstanceKey())) {
                        map.put(eVar2.getAssetInstanceKey(), eVar2);
                    }
                }
                for (c.e.e.a.s.e eVar3 : list2) {
                    if (eVar3 != null && x.isNotNull(eVar3.getAssetInstanceKey()) && (eVar = (c.e.e.a.s.e) map.get(eVar3.getAssetInstanceKey())) != null) {
                        eVar3.setSoc(eVar.getSoc());
                        eVar3.setSocLevel(eVar.getSocLevel());
                        eVar3.setSocLevelName(eVar.getSocLevelName());
                        c.e.c.x.c.a.getInstance().updateLockPower(eVar3);
                    }
                }
            }
            CoreBaseFragment.c cVar = this.f6488f;
            if (cVar != null) {
                cVar.post(new Runnable() { // from class: c.e.c.a0.h.z
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f1372a.G2();
                    }
                });
            }
        } finally {
            this.N.unlock();
        }
    }

    @OnClick({R.id.view_bg})
    public void backClick(View view) {
        g0();
    }

    @OnClick({R.id.view_bg_bottom})
    public void clickBack() {
        n();
    }

    @OnClick({R.id.tv_device_often_use_edit})
    public void clickEditOftenUse() {
        if (o.isNotEmpty(this.G)) {
            d(OftenUseDeviceSetupFragment.getInstance(this.G, this.W), R.id.constraint_main_content);
        } else {
            F0(R.string.tip_room_list_is_empty);
        }
    }

    @OnClick({R.id.tv_custom_sort})
    public void customSortClick() {
        if (!o.isNotEmpty(this.G)) {
            F0(R.string.tip_room_list_is_empty);
        } else {
            b1();
            d(LockSortFragment.getInstance(this.G, this.c0), R.id.constraint_main_content);
        }
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public int getLayoutId() {
        return R.layout.fragment_open_room_list;
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    /* JADX INFO: renamed from: j0 */
    public void I1() {
        this.F = null;
        if (o.listIsEmpty(c.e.e.a.u.d.getInstance().getLockResponseVoList())) {
            z0(R.string.loading_text);
        }
        if (Y1()) {
            this.B.getLockList();
            return;
        }
        NewOpenDoorModel newOpenDoorModel = this.C;
        if (newOpenDoorModel != null) {
            newOpenDoorModel.getSignLockList("OpenRoomListFragment-requestData");
        } else {
            this.B.getSignLockList();
        }
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (Y1()) {
            if (x.isNotNull(this.M)) {
                w.getInstance().putString("cache_search_key", this.M.trim());
            } else {
                w.getInstance().remove("cache_search_key");
            }
        }
        this.Q.clear();
        this.P = null;
        this.S = false;
        this.R.clear();
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment, androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        if (isRemoving()) {
            k(new c.e.c.a0.g.a());
        }
    }

    public void showOpenDoorSuccessAlert() {
        List<AlertMessageVo> billAlertMessageVo = l.getInstance().getBillAlertMessageVo();
        if (o.isNotEmpty(billAlertMessageVo)) {
            for (AlertMessageVo alertMessageVo : billAlertMessageVo) {
                String href = alertMessageVo.getHref();
                if (k.isNotNull(href) && href.contains("http")) {
                    alertMessageVo.setMessageType(5);
                    alertMessageVo.setForwardType(1);
                }
                d(AppAlertFragment.getInstance(alertMessageVo), R.id.constraint_main_content);
            }
        }
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void z(Message message) {
        super.z(message);
        if (message.what == 1) {
            W2(this.H, false);
            if (x.isNotNull(this.L)) {
                this.mSearchRoomEdt.setText(this.L);
                if (this.J) {
                    this.J = false;
                    this.L = null;
                }
            }
        }
    }
}
