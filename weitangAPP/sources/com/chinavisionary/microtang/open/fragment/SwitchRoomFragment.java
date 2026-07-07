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
import butterknife.BindView;
import butterknife.OnClick;
import c.e.a.d.o;
import c.e.a.d.q;
import c.e.a.d.w;
import c.e.a.d.x;
import c.e.a.d.y;
import c.e.c.a0.i.c;
import c.e.c.m0.j;
import c.e.e.a.s.d;
import c.e.e.a.s.e;
import com.alibaba.fastjson.JSON;
import com.chinavisionary.core.app.base.CoreBaseFragment;
import com.chinavisionary.core.app.config.bo.AppConfigExtVo;
import com.chinavisionary.core.app.event.EventUpdateSelectRoom;
import com.chinavisionary.core.app.net.base.dto.NewResponseRowsVo;
import com.chinavisionary.core.app.net.base.dto.RequestErrDto;
import com.chinavisionary.core.app.net.base.dto.ResponseRowsVo;
import com.chinavisionary.core.app.net.base.dto.ResponseStateVo;
import com.chinavisionary.core.weight.BaseRecyclerView;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.base.BaseFragment;
import com.chinavisionary.microtang.me.vo.EventSwitchRoomVo;
import com.chinavisionary.microtang.open.adapter.SwitchRootAdapter;
import com.chinavisionary.twlib.open.OpenDoorActivity;
import com.chinavisionary.twlib.open.bo.ResponseOpenDoorVo;
import com.chinavisionary.twlib.open.model.NewOpenDoorModel;
import com.chinavisionary.twlib.open.model.OpenDoorModel;
import com.chinavisionary.twlib.open.model.OpenDoorPwdModel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class SwitchRoomFragment extends BaseFragment<e> {
    public OpenDoorModel B;
    public NewOpenDoorModel C;
    public OpenDoorPwdModel D;
    public e E;
    public e F;
    public List<e> G;
    public List<e> H;
    public ResponseOpenDoorVo M;
    public boolean P;
    public String Q;
    public c R;
    public c.e.c.a0.f.b S;

    @BindView(R.id.btn_retry_load_page)
    public AppCompatButton mAppCompatButton;

    @BindView(R.id.tv_custom_sort)
    public TextView mCustomSortTv;

    @BindView(R.id.recycler_room_list)
    public BaseRecyclerView mRoomRecyclerList;

    @BindView(R.id.edt_search_room)
    public EditText mSearchRoomEdt;

    @BindView(R.id.tv_title_split_line)
    public TextView mSplitLineTv;

    @BindView(R.id.tv_tip_msg)
    public TextView mTipMsgTv;

    @BindView(R.id.tv_tip_room_list_title)
    public TextView mTipRoomTitleTv;

    @BindView(R.id.tv_title)
    public TextView mTitleTv;
    public boolean I = false;
    public boolean J = false;
    public String K = null;
    public String L = null;
    public Map<String, ResponseOpenDoorVo> N = new HashMap();
    public LinkedHashMap<String, e> O = new LinkedHashMap<>();
    public final c.e.a.a.c.c.a T = new a();
    public final TextWatcher U = new b();
    public c.e.c.a0.i.b V = new c.e.c.a0.i.b() { // from class: c.e.c.a0.h.k0
        @Override // c.e.c.a0.i.b
        public final void sortResult(List list) {
            this.f1350a.c2(list);
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
            SwitchRoomFragment switchRoomFragment = SwitchRoomFragment.this;
            switchRoomFragment.k2((e) switchRoomFragment.t.getList().get(i2));
        }
    }

    public class b implements TextWatcher {
        public b() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            SwitchRoomFragment.this.p2(SwitchRoomFragment.this.mSearchRoomEdt.getText().toString());
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: W1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void X1(RequestErrDto requestErrDto) {
        C(requestErrDto);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: Y1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void Z1(final RequestErrDto requestErrDto) {
        e eVar;
        String pwdToAssetKey;
        boolean z = true;
        if (requestErrDto != null && x.isNotNull(requestErrDto.getUrl())) {
            q.d(getClass().getSimpleName(), "handleGetBlePwdErr code = " + requestErrDto.getCode());
            if (requestErrDto.getCode() >= 500 && requestErrDto.getCode() <= 505 && (eVar = this.E) != null) {
                String assetInstanceKey = eVar.getAssetInstanceKey();
                if (x.isNotNull(assetInstanceKey) && (pwdToAssetKey = c.e.e.a.t.b.getInstance().getPwdToAssetKey(assetInstanceKey)) != null) {
                    try {
                        final ResponseOpenDoorVo responseOpenDoorVo = (ResponseOpenDoorVo) JSON.parseObject(pwdToAssetKey, ResponseOpenDoorVo.class);
                        if (responseOpenDoorVo != null) {
                            z = false;
                            this.mTipRoomTitleTv.post(new Runnable() { // from class: c.e.c.a0.h.m0
                                @Override // java.lang.Runnable
                                public final void run() {
                                    this.f1354a.V1(responseOpenDoorVo);
                                }
                            });
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                    q.d(getClass().getSimpleName(), "getDoorPassword cache data : " + pwdToAssetKey);
                }
            }
        }
        if (!z || this.P) {
            return;
        }
        this.mTipRoomTitleTv.post(new Runnable() { // from class: c.e.c.a0.h.b0
            @Override // java.lang.Runnable
            public final void run() {
                this.f1328a.X1(requestErrDto);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: b2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void c2(List list) {
        if (o.isNotEmpty(list)) {
            this.J = true;
            this.L = null;
            this.mSearchRoomEdt.setText("");
            u2(list, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: d2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void e2(List list) {
        List<e> listQueryLockSortListToPhone = c.e.c.p.b.getInstance().queryLockSortListToPhone(s());
        boolean zListIsEmpty = o.listIsEmpty(listQueryLockSortListToPhone);
        if (zListIsEmpty) {
            this.R.roomOrder(list);
        }
        List<e> listLockSort = this.R.lockSort(listQueryLockSortListToPhone, list);
        if (zListIsEmpty) {
            this.F = null;
            listLockSort = this.R.filterAllRoomList(listLockSort);
        }
        this.H.clear();
        this.H.addAll(listLockSort);
        this.G.clear();
        this.G.addAll(listLockSort);
        s2(listLockSort);
        CoreBaseFragment.c cVar = this.f6488f;
        if (cVar != null) {
            cVar.obtainMessage(1).sendToTarget();
        }
    }

    public static SwitchRoomFragment getInstance(String str, c.e.c.a0.f.b bVar) {
        SwitchRoomFragment switchRoomFragment = new SwitchRoomFragment();
        switchRoomFragment.S = bVar;
        switchRoomFragment.f6484b = str;
        return switchRoomFragment;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: h2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void i2(NewResponseRowsVo newResponseRowsVo) {
        H();
        if (newResponseRowsVo == null || newResponseRowsVo.getRows() == null) {
            return;
        }
        List<e> rows = newResponseRowsVo.getRows();
        c.e.e.a.t.b.getInstance().insertRoomList(rows);
        this.mTipMsgTv.setVisibility(rows.isEmpty() ? 0 : 8);
        this.I = true;
        l2(rows);
    }

    private void o0() {
        this.H = new ArrayList();
        this.G = new ArrayList();
        this.r = this.mRoomRecyclerList;
        SwitchRootAdapter switchRootAdapter = new SwitchRootAdapter();
        this.t = switchRootAdapter;
        switchRootAdapter.setSelectRoomKey(this.Q);
        this.t.setOnItemClickListener(this.T);
    }

    public final void H1(View view) {
        k2((e) view.getTag());
    }

    /* JADX INFO: renamed from: I1, reason: merged with bridge method [inline-methods] */
    public final void V1(ResponseOpenDoorVo responseOpenDoorVo) {
        H();
        if (responseOpenDoorVo == null || !responseOpenDoorVo.isSuccess()) {
            return;
        }
        if (this.P) {
            this.N.put(responseOpenDoorVo.getBaseKey(), responseOpenDoorVo);
        } else {
            n2(responseOpenDoorVo);
        }
    }

    public final void J1(RequestErrDto requestErrDto) {
        H();
        if (requestErrDto != null) {
            String url = requestErrDto.getUrl();
            if (x.isNotNull(url) && this.t.getItemCount() == 0) {
                C(requestErrDto);
                this.mAppCompatButton.setVisibility(url.contains("business/house/access/controls?source=1") || url.contains("houses/list") ? 0 : 8);
            }
        }
    }

    public final void K1() {
        this.P = false;
        if (this.E == null || v2()) {
            return;
        }
        m2();
    }

    public final void L1(final RequestErrDto requestErrDto) {
        new Thread(new Runnable() { // from class: c.e.c.a0.h.e0
            @Override // java.lang.Runnable
            public final void run() {
                this.f1335a.Z1(requestErrDto);
            }
        }).start();
    }

    public final void M1(NewResponseRowsVo<d> newResponseRowsVo) {
        H();
        if (newResponseRowsVo == null) {
            c.e.c.x.c.a.getInstance().setShowWallet(false);
            return;
        }
        this.I = true;
        c.e.c.x.c.a.getInstance().setShowWallet(o.isNotEmpty(newResponseRowsVo.getRows()));
        u2(j.getInstance().signLockSetupDefault(newResponseRowsVo.getRows()), false);
    }

    public final void N1(ResponseStateVo responseStateVo) {
        if (responseStateVo == null || !responseStateVo.isSuccess()) {
            F0(R.string.data_error);
            H();
            return;
        }
        this.I = true;
        k(new EventSwitchRoomVo());
        e eVar = this.E;
        if (eVar != null) {
            q2(eVar, true);
            w.getInstance().putString("current_room_key", this.E.getAssetInstanceName());
            w.getInstance().putString("room_key", this.E.getAssetInstanceKey());
            c.e.c.m0.c.getInstance().setRoomKey(this.E.getAssetInstanceKey());
        }
        g0();
    }

    public final void O1(ResponseRowsVo<d> responseRowsVo) {
        H();
        if (responseRowsVo == null) {
            c.e.c.x.c.a.getInstance().setShowWallet(false);
            return;
        }
        this.I = true;
        c.e.c.x.c.a.getInstance().setShowWallet(o.isNotEmpty(responseRowsVo.getRows()));
        u2(j.getInstance().signLockSetupDefault(responseRowsVo.getRows()), false);
    }

    public final void P1() {
        this.f6488f = new CoreBaseFragment.c(this);
        this.mSearchRoomEdt.setVisibility(8);
        this.mSearchRoomEdt.setRawInputType(2);
        this.mSearchRoomEdt.addTextChangedListener(this.U);
        this.mAppCompatButton.setOnClickListener(this.y);
        this.mTitleTv.setText(R.string.tip_switch_room);
        if (R1()) {
            this.mTitleTv.setText(R.string.title_select_room_door);
        }
        this.mSplitLineTv.setVisibility(0);
        AppConfigExtVo appConfigExtVoO = o();
        if (appConfigExtVoO != null) {
            this.mTipMsgTv.setText(x.getNotNullStr(appConfigExtVoO.getCheckinTip(), x.getString(R.string.title_default_chckin_tip)));
        }
        this.R = new c();
        if (Q1()) {
            this.K = w.getInstance().getString("cache_search_key", null);
        }
    }

    public final boolean Q1() {
        return this.f6484b.equals("1");
    }

    public final boolean R1() {
        return this.f6484b.equals("3");
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void V(View view) {
        int id = view.getId();
        if (id == R.id.btn_retry_load_page) {
            I1();
            view.setVisibility(8);
        } else if (id == R.id.tv_alert_confirm) {
            z0(R.string.tip_open_locking);
            m2();
        } else {
            if (id != R.id.view_open_room) {
                return;
            }
            H1(view);
        }
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void W() {
        P1();
        o0();
        r2();
        t2();
        o2();
        z0(R.string.loading_text);
        I1();
    }

    @OnClick({R.id.tv_back})
    public void backClick(View view) {
        g0();
    }

    @OnClick({R.id.tv_custom_sort})
    public void customSortClick() {
        if (!o.isNotEmpty(this.G)) {
            F0(R.string.tip_room_list_is_empty);
        } else {
            b1();
            d(LockSortFragment.getInstance(this.G, this.V), R.id.constraint_main_content);
        }
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public int getLayoutId() {
        return R.layout.fragment_switch_room_list;
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    /* JADX INFO: renamed from: j0 */
    public void I1() {
        this.F = null;
        if (o.listIsEmpty(c.e.e.a.u.d.getInstance().getLockResponseVoList())) {
            z0(R.string.loading_text);
        }
        if (Q1()) {
            this.B.getLockList();
            return;
        }
        if (this.C == null) {
            this.B.getSignLockList();
        } else if (R1()) {
            this.C.getRoomList("SwitchFragment-requestData");
        } else {
            this.C.getSignLockList("SwitchFragment-requestData");
        }
    }

    public final void k2(e eVar) {
        this.E = eVar;
        z0(Q1() ? R.string.tip_open_locking : R.string.tip_switch_rooming);
        if (Q1()) {
            K1();
            return;
        }
        if (R1()) {
            c.e.c.a0.f.b bVar = this.S;
            if (bVar != null) {
                bVar.onSelectRoomCallback(eVar);
            }
            n();
            return;
        }
        NewOpenDoorModel newOpenDoorModel = this.C;
        if (newOpenDoorModel != null) {
            newOpenDoorModel.postSelectRoom(this.E);
        }
    }

    public final void l2(final List<e> list) {
        if (o.isNotEmpty(list)) {
            this.mCustomSortTv.setVisibility(Q1() ? 0 : 8);
        }
        if (Q1()) {
            this.mSearchRoomEdt.setVisibility(list.size() < 5 ? 8 : 0);
        }
        y.get().addRunnable(new Runnable() { // from class: c.e.c.a0.h.h0
            @Override // java.lang.Runnable
            public final void run() {
                this.f1343a.e2(list);
            }
        });
    }

    public final void m2() {
        e eVar = this.E;
        if (eVar != null) {
            String assetInstanceKey = eVar.getAssetInstanceKey();
            if (!this.N.containsKey(assetInstanceKey)) {
                this.D.getDoorPwd(assetInstanceKey, this.f6485c + " performGetPwd mLockResponseVo is null");
                return;
            }
            ResponseOpenDoorVo responseOpenDoorVo = this.N.get(assetInstanceKey);
            if (responseOpenDoorVo != null) {
                U1(responseOpenDoorVo);
                return;
            }
            this.D.getDoorPwd(assetInstanceKey, this.f6485c + " performGetPwd");
        }
    }

    public final void n2(ResponseOpenDoorVo responseOpenDoorVo) {
        e eVar = this.E;
        if (eVar != null) {
            w2(eVar.getAssetInstanceKey(), responseOpenDoorVo);
        }
    }

    public final void o2() {
        List<e> lockResponseVoList = c.e.e.a.u.d.getInstance().getLockResponseVoList();
        Map<String, ResponseOpenDoorVo> assetKeyPwsMap = c.e.e.a.u.d.getInstance().getAssetKeyPwsMap();
        if (assetKeyPwsMap != null) {
            this.N = new HashMap(assetKeyPwsMap);
        }
        if (Q1() && o.isNotEmpty(lockResponseVoList)) {
            l2(lockResponseVoList);
        }
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (Q1()) {
            if (x.isNotNull(this.L)) {
                w.getInstance().putString("cache_search_key", this.L.trim());
            } else {
                w.getInstance().remove("cache_search_key");
            }
        }
        this.N.clear();
        this.M = null;
        this.P = false;
        this.O.clear();
    }

    public final void p2(String str) {
        if (this.J) {
            this.J = false;
            return;
        }
        ArrayList arrayList = new ArrayList();
        LinkedHashMap<String, e> linkedHashMap = this.O;
        if (linkedHashMap != null && !linkedHashMap.isEmpty()) {
            for (Map.Entry<String, e> entry : this.O.entrySet()) {
                if (!x.isNotNull(str)) {
                    arrayList.add(entry.getValue());
                } else if (entry.getKey().contains(str.trim().toUpperCase())) {
                    arrayList.add(entry.getValue());
                }
            }
        }
        this.L = str;
        if (x.isNullStr(str)) {
            l2(arrayList);
        } else {
            u2(arrayList, false);
        }
    }

    public final void q2(e eVar, boolean z) {
        EventUpdateSelectRoom eventUpdateSelectRoom = new EventUpdateSelectRoom();
        eventUpdateSelectRoom.setKey(eVar.getAssetInstanceKey());
        eventUpdateSelectRoom.setName(eVar.getAssetInstanceName());
        eventUpdateSelectRoom.setShowMore(z);
        g.b.a.c.getDefault().post(eventUpdateSelectRoom);
    }

    public final void r2() {
        OpenDoorPwdModel openDoorPwdModel = (OpenDoorPwdModel) h(OpenDoorPwdModel.class);
        this.D = openDoorPwdModel;
        openDoorPwdModel.getDoorVoMutableLiveData().observe(this, new Observer() { // from class: c.e.c.a0.h.f0
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f1339a.U1((ResponseOpenDoorVo) obj);
            }
        });
        this.D.getErrRequestLiveData().observe(this, new Observer() { // from class: c.e.c.a0.h.l0
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f1352a.L1((RequestErrDto) obj);
            }
        });
    }

    public final void s2(List<e> list) {
        if (this.O == null || !o.isNotEmpty(list)) {
            return;
        }
        try {
            this.O.clear();
            for (e eVar : list) {
                if (eVar != null && x.isNotNull(eVar.getAssetInstanceName())) {
                    this.O.put(eVar.getAssetInstanceName(), eVar);
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void setSelectRoomKey(String str) {
        this.Q = str;
    }

    public final void t2() {
        OpenDoorModel openDoorModel = (OpenDoorModel) h(OpenDoorModel.class);
        this.B = openDoorModel;
        openDoorModel.getLockListLiveData().observe(this, new Observer() { // from class: c.e.c.a0.h.c0
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f1331a.i2((NewResponseRowsVo) obj);
            }
        });
        this.B.getSignLockListLiveData().observe(this, new Observer() { // from class: c.e.c.a0.h.j0
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f1348a.O1((ResponseRowsVo) obj);
            }
        });
        this.B.getRoomSelectLiveData().observe(this, new Observer() { // from class: c.e.c.a0.h.i0
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f1346a.N1((ResponseStateVo) obj);
            }
        });
        this.B.getErrRequestLiveData().observe(this, new Observer() { // from class: c.e.c.a0.h.d0
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f1333a.J1((RequestErrDto) obj);
            }
        });
        if (c.e.a.a.a.getInstance().isH5Model()) {
            NewOpenDoorModel newOpenDoorModel = (NewOpenDoorModel) h(NewOpenDoorModel.class);
            this.C = newOpenDoorModel;
            newOpenDoorModel.getSignLockListLiveData().observe(this, new Observer() { // from class: c.e.c.a0.h.j0
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    this.f1348a.O1((ResponseRowsVo) obj);
                }
            });
            this.C.getRoomList().observe(this, new Observer() { // from class: c.e.c.a0.h.g0
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    this.f1341a.M1((NewResponseRowsVo) obj);
                }
            });
            this.C.getRoomSelectLiveData().observe(this, new Observer() { // from class: c.e.c.a0.h.i0
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    this.f1346a.N1((ResponseStateVo) obj);
                }
            });
            this.C.getErrRequestLiveData().observe(this, new Observer() { // from class: c.e.c.a0.h.d0
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    this.f1333a.J1((RequestErrDto) obj);
                }
            });
        }
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    public final void u2(List<e> list, boolean z) {
        H();
        this.t.initListData((List<T>) list);
    }

    public final boolean v2() {
        AppConfigExtVo appConfigExtVoO;
        e eVar = this.E;
        if (eVar == null || eVar.getSocLevel() == null || 1 != this.E.getSocLevel().intValue() || (appConfigExtVoO = o()) == null) {
            return false;
        }
        D0(appConfigExtVoO.getLowBattery(), false);
        return true;
    }

    public final void w2(String str, ResponseOpenDoorVo responseOpenDoorVo) {
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

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void z(Message message) {
        super.z(message);
        if (message.what == 1) {
            u2(this.H, false);
            if (x.isNotNull(this.K)) {
                this.mSearchRoomEdt.setText(this.K);
                if (this.I) {
                    this.I = false;
                    this.K = null;
                }
            }
        }
    }
}
