package com.chinavisionary.microtang.me.fragment;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import butterknife.BindView;
import butterknife.OnClick;
import c.e.a.d.c0.d;
import c.e.a.d.o;
import c.e.a.d.q;
import c.e.a.d.w;
import c.e.a.d.x;
import c.e.c.x.e.g0;
import c.e.c.x.e.k0;
import c.e.c.x.e.p0;
import c.e.e.a.s.e;
import c.e.e.a.x.k;
import c.e.e.a.x.l;
import com.alibaba.fastjson.JSON;
import com.chinavisionary.core.app.base.CoreBaseFragment;
import com.chinavisionary.core.app.config.bo.AppConfigExtVo;
import com.chinavisionary.core.app.config.bo.UserInfoVo;
import com.chinavisionary.core.app.event.EventUpdateSelectRoom;
import com.chinavisionary.core.app.event.EventUpdateUserInfoVo;
import com.chinavisionary.core.app.net.base.dto.RequestErrDto;
import com.chinavisionary.core.app.net.base.dto.ResponseRowsVo;
import com.chinavisionary.core.app.net.base.dto.ResponseStateVo;
import com.chinavisionary.core.scan.view.ScanCodeActivity;
import com.chinavisionary.core.weight.BaseSwipeRefreshLayout;
import com.chinavisionary.framework.mobile.common.vo.ResourceVo;
import com.chinavisionary.framework.mobile.login.dto.UserSimpleDto;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.base.BaseFragment;
import com.chinavisionary.microtang.clean.model.CleanModel;
import com.chinavisionary.microtang.contract.adapter.ContractListAdapter;
import com.chinavisionary.microtang.contract.model.ContractModel;
import com.chinavisionary.microtang.contract.vo.ContractListVo;
import com.chinavisionary.microtang.contract.vo.UpdateContractEventVo;
import com.chinavisionary.microtang.main.event.EventUpdateProject;
import com.chinavisionary.microtang.main.fragments.AppAlertFragment;
import com.chinavisionary.microtang.me.adapter.IncrementProductAdapter;
import com.chinavisionary.microtang.me.model.UserOperateModel;
import com.chinavisionary.microtang.me.vo.CleanProductVo;
import com.chinavisionary.microtang.me.vo.EventContract;
import com.chinavisionary.microtang.me.vo.EventSwitchRoomVo;
import com.chinavisionary.microtang.me.vo.EventUpdateWallet;
import com.chinavisionary.microtang.me.vo.OrderVo;
import com.chinavisionary.microtang.msg.MsgActivity;
import com.chinavisionary.microtang.room.KeepRentActivity;
import com.chinavisionary.microtang.service.CustomerServiceActivity;
import com.chinavisionary.microtang.vo.EventUpdateRentState;
import com.chinavisionary.paymentlibrary.vo.EventPayStateVo;
import com.chinavisionary.twlib.open.bo.AlertMessageVo;
import com.chinavisionary.twlib.open.model.OpenDoorModel;
import g.b.a.m;
import g.b.a.r;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class NewMeFragment extends BaseFragment<CleanProductVo> {
    public CleanModel B;
    public UserOperateModel C;
    public OpenDoorModel D;
    public ContractModel E;
    public e H;
    public ContractListVo J;
    public String K;
    public k0 L;
    public p0 M;

    @BindView(R.id.recycler_clean)
    public BaseSwipeRefreshLayout mBaseSwipeRefreshLayout;

    @BindView(R.id.tv_title)
    public TextView mTitleTv;
    public boolean F = true;
    public boolean G = true;
    public boolean I = true;
    public c.e.a.a.c.c.a N = new c.e.a.a.c.c.a() { // from class: c.e.c.x.d.h1
        @Override // c.e.a.a.c.c.a
        public final void onItemClickListener(View view, int i2) {
            this.f2051a.g2(view, i2);
        }
    };
    public g0 O = new a();

    public class a implements g0 {
        public a() {
        }

        @Override // c.e.c.x.e.g0
        public void addFragment(BaseFragment baseFragment) {
            NewMeFragment.this.P1(baseFragment);
        }

        @Override // c.e.c.x.e.g0
        public void addFragment(BaseFragment baseFragment, boolean z) {
        }

        @Override // c.e.c.x.e.g0
        public void clickBannerItem(View view) {
        }

        @Override // c.e.c.x.e.g0
        public void clickForward(OrderVo orderVo) {
        }

        @Override // c.e.c.x.e.g0
        public void clickFunction(String str) {
        }

        @Override // c.e.c.x.e.g0
        public void clickFunctionType(String str) {
        }

        @Override // c.e.c.x.e.g0
        public void clickWxMiniAppManager() {
        }

        @Override // c.e.c.x.e.g0
        public FragmentActivity getCurrentActivity() {
            return NewMeFragment.this.getActivity();
        }

        @Override // c.e.c.x.e.g0
        public void handleOftenUseRoomEventMonitor(String str) {
            NewMeFragment.this.h1(str);
        }

        @Override // c.e.c.x.e.g0
        public void hideAlertLoading() {
            NewMeFragment.this.H();
        }

        @Override // c.e.c.x.e.g0
        public boolean isLoginApp() {
            return NewMeFragment.this.N();
        }

        @Override // c.e.c.x.e.g0
        public void showAlertDialog(String str, String str2, boolean z, View.OnClickListener onClickListener) {
        }

        @Override // c.e.c.x.e.g0
        public void showAlertLoading(int i2) {
            NewMeFragment.this.z0(i2);
        }

        @Override // c.e.c.x.e.g0
        public void showAlertLoading(String str) {
        }

        @Override // c.e.c.x.e.g0
        public void showOpenDoorSuccessAlert() {
            List<AlertMessageVo> billAlertMessageVo = l.getInstance().getBillAlertMessageVo();
            if (o.isNotEmpty(billAlertMessageVo)) {
                for (AlertMessageVo alertMessageVo : billAlertMessageVo) {
                    String href = alertMessageVo.getHref();
                    if (k.isNotNull(href) && href.contains("http")) {
                        alertMessageVo.setMessageType(5);
                        alertMessageVo.setForwardType(1);
                    }
                    NewMeFragment.this.P1(AppAlertFragment.getInstance(alertMessageVo));
                }
            }
        }

        @Override // c.e.c.x.e.g0
        public void showToast(int i2) {
            NewMeFragment.this.F0(i2);
        }

        @Override // c.e.c.x.e.g0
        public void showToast(String str) {
        }

        @Override // c.e.c.x.e.g0
        public boolean userIsAuth() {
            return NewMeFragment.this.L();
        }

        @Override // c.e.c.x.e.g0
        public boolean userIsRent() {
            return NewMeFragment.this.Q();
        }
    }

    public class b implements CoreBaseFragment.d {
        public b() {
        }

        @Override // com.chinavisionary.core.app.base.CoreBaseFragment.d
        public void updatePosition(int i2, int i3) {
            NewMeFragment.this.t.setFirstLastPosition(i2, i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: f2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void g2(View view, int i2) {
        if (view.getTag() instanceof IncrementProductAdapter.IncrementProductVH) {
            this.L.openCleanDetails((CleanProductVo) this.t.getList().get(i2));
        } else if (view.getTag() instanceof ContractListAdapter.ContractListVh) {
            this.L.openContractDetails((CleanProductVo) this.t.getList().get(i2));
        }
    }

    public static NewMeFragment getInstance() {
        return new NewMeFragment();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: h2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void i2() {
        this.I = true;
        I1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: l2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void m2(RequestErrDto requestErrDto) {
        W1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    /* JADX INFO: renamed from: n2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void o2(ResponseRowsVo responseRowsVo) {
        if (responseRowsVo != null) {
            this.L.updateContract(responseRowsVo, this.t, this.r);
        }
    }

    private void o0() {
        this.l = false;
        IncrementProductAdapter incrementProductAdapter = new IncrementProductAdapter();
        this.t = incrementProductAdapter;
        incrementProductAdapter.setOnClickListener(this.y);
        this.t.setOnItemClickListener(this.N);
        View viewInflate = LayoutInflater.from(this.f6487e).inflate(R.layout.item_clean_head_layout, (ViewGroup) null);
        this.L.initUserView(viewInflate);
        this.M.initWalletView(viewInflate);
        this.t.addHeadView(viewInflate);
        this.r = this.mBaseSwipeRefreshLayout.getBaseRecyclerView();
        this.v = new b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: p2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void q2(RequestErrDto requestErrDto) {
        C2();
    }

    public final void A2(String str, ResourceVo resourceVo) {
        this.L.setupUserInfo(str, d.getInstance().getUrlToResourceVo(resourceVo));
        this.M.setupIsShowWallet(O());
    }

    public final void B2() {
        UserOperateModel userOperateModel = (UserOperateModel) h(UserOperateModel.class);
        this.C = userOperateModel;
        userOperateModel.getUserInfoVoResult().observe(this, new Observer() { // from class: c.e.c.x.d.j1
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f2059a.Y1((UserInfoVo) obj);
            }
        });
        this.C.getAppConfigLiveData().observe(this, new Observer() { // from class: c.e.c.x.d.f1
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f2043a.T1((AppConfigExtVo) obj);
            }
        });
        this.C.getErrRequestLiveData().observe(this, new Observer() { // from class: c.e.c.x.d.l1
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f2067a.q2((RequestErrDto) obj);
            }
        });
    }

    public final void C2() {
        H();
        this.mBaseSwipeRefreshLayout.setRefreshing(false);
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void D2() {
        Q1(false);
        this.L.removeContractList(this.t, this.r);
        this.L.unLoginState();
        this.M.setupIsShowWallet(false);
        m0(null);
    }

    public final void E2(boolean z) {
        if (z) {
            z2(R1());
        }
        if (this.I) {
            this.D.getSignLockList();
        }
    }

    public final void F2(UserInfoVo userInfoVo) {
        if (userInfoVo == null) {
            D2();
            return;
        }
        this.L.handlerIsAuth(Boolean.valueOf(userInfoVo.isValidate()));
        Q1(userInfoVo.isCheckIn());
        A2(userInfoVo.getNickname(), userInfoVo.getAvatar());
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void N1() {
        if (this.F) {
            this.F = false;
            this.L.addAboutDataToList(this.t, this.r);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference incomplete: some casts might be missing */
    public final void O1(List list) {
        if (list.isEmpty() && this.f6483a == 1) {
            CleanProductVo cleanProductVo = new CleanProductVo();
            cleanProductVo.setType(34952);
            this.t.addDataToList((T) cleanProductVo);
        } else if (this.f6483a == 1) {
            w2();
        }
    }

    public final void P1(BaseFragment baseFragment) {
        e(baseFragment, R.id.constraint_main_content, true);
    }

    public final void Q1(boolean z) {
        this.L.addMenuItemToIsRent(z);
    }

    public final String R1() {
        return w.getInstance().getString("current_room_key", null);
    }

    public final void S1(ResponseRowsVo<c.e.e.a.s.d> responseRowsVo) {
        e defaultRentRoom = this.L.getDefaultRentRoom(responseRowsVo, null);
        if (defaultRentRoom != null) {
            this.H = defaultRentRoom;
            this.D.postSelectRoom(defaultRentRoom);
        }
    }

    public final void T1(AppConfigExtVo appConfigExtVo) {
        if (appConfigExtVo != null) {
            q.d(getClass().getSimpleName(), "handleAppConfigResult :" + appConfigExtVo.getTestConfig());
            this.L.setAppConfigVo(appConfigExtVo);
            k0(appConfigExtVo);
        }
    }

    public final void U1(ResponseRowsVo<CleanProductVo> responseRowsVo) {
        C2();
        if (responseRowsVo != null) {
            this.F = true;
            D(responseRowsVo.getRows());
            O1(responseRowsVo.getRows());
        }
        N1();
        if (O() && c.e.a.a.a.getInstance().isDebug()) {
            this.E.getContractList(r(), 1);
        }
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void V(View view) {
        int id = view.getId();
        if (id == R.id.btn_action) {
            handlerAction(view);
        } else if (id == R.id.btn_keep_rent) {
            V1(view);
        } else {
            if (id != R.id.id_about_item) {
                return;
            }
            this.L.handleAboutItemClickView(view);
        }
    }

    public final void V1(View view) {
        String assetKey = ((CleanProductVo) this.t.getList().get(((Integer) view.getTag()).intValue())).getContractListVo().getAssetKey();
        if (x.isNotNull(assetKey)) {
            Intent intent = new Intent(this.f6487e, (Class<?>) KeepRentActivity.class);
            intent.putExtra("key", assetKey);
            startActivity(intent);
        }
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void W() {
        Z1();
        x2();
        a2();
        o0();
        z0(R.string.loading_text);
        F2(w());
        I1();
    }

    public final void W1() {
        C2();
        B();
        if (this.f6483a == 1 && this.t.getList().isEmpty()) {
            O1(new ArrayList());
            N1();
        }
    }

    public final void X1(ResponseStateVo responseStateVo) {
        if (responseStateVo != null) {
            this.I = false;
            e eVar = this.H;
            if (eVar != null) {
                z2(eVar.getAssetInstanceName());
            }
            t2();
            k(new EventSwitchRoomVo());
        }
    }

    public final void Y1(UserInfoVo userInfoVo) {
        C2();
        if (userInfoVo != null) {
            r2();
            F2(userInfoVo);
            m0(JSON.toJSONString(userInfoVo));
            if (userInfoVo.isCheckIn()) {
                E2(Q());
            }
            k(new EventUpdateRentState());
        }
    }

    public final void Z1() {
        h0(this);
        this.mTitleTv.setText(R.string.title_me);
        this.mTitleTv.setTextSize(18.0f);
        this.mTitleTv.setTextColor(getResources().getColor(R.color.color000000));
        this.f6488f = new CoreBaseFragment.c(this);
        this.K = w.getInstance().getString("selectProjectKey", null);
    }

    public final void a2() {
        k0 k0Var = new k0(this.O);
        this.L = k0Var;
        k0Var.setAppConfigVo(o());
        p0 p0Var = new p0(this.O);
        this.M = p0Var;
        p0Var.setUserOperateModel(this.C, null);
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public int getLayoutId() {
        return R.layout.fragment_me;
    }

    public final void handlerAction(View view) {
        CleanProductVo cleanProductVo = (CleanProductVo) this.t.getList().get(((Integer) view.getTag()).intValue());
        this.J = cleanProductVo.getContractListVo();
        this.L.openContractDetails(cleanProductVo);
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    /* JADX INFO: renamed from: j0 */
    public void I1() {
        this.B.getCleanList(r(), this.K, v(), "");
        this.C.getAppConfig();
        if (O()) {
            t2();
        }
    }

    @OnClick({R.id.rlayout_notify})
    public void msgClickView(View view) {
        if (N()) {
            d0(MsgActivity.class);
        }
    }

    @m(threadMode = r.MAIN)
    public void newContract(EventContract eventContract) {
        i("newContract");
        CoreBaseFragment.c cVar = this.f6488f;
        if (cVar != null) {
            cVar.postDelayed(new Runnable() { // from class: c.e.c.x.d.c1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f2031a.i2();
                }
            }, 1000L);
        }
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        L0(this);
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        q.d(getClass().getSimpleName(), "on resume");
        if (!O() || !Q()) {
            z2(null);
            return;
        }
        String strR1 = R1();
        if (x.isNullStr(strR1)) {
            s2();
        } else {
            z2(strR1);
        }
    }

    @OnClick({R.id.rlayout_scan})
    public void openScan(View view) {
        d0(ScanCodeActivity.class);
    }

    @m(threadMode = r.MAIN)
    public void payStateEvent(EventPayStateVo eventPayStateVo) {
        if (O() && eventPayStateVo.isSuccess()) {
            r2();
        }
    }

    public final void r2() {
        this.C.getWalletBalance();
    }

    @m(threadMode = r.MAIN)
    public void registerEventUpdateProject(EventUpdateProject eventUpdateProject) {
        this.K = eventUpdateProject.getKey();
        I1();
    }

    public final void s2() {
        this.D.getSignLockList();
    }

    @OnClick({R.id.rlayout_server})
    public void serverClick(View view) {
        if (c.e.a.a.a.getInstance().isIMModel()) {
            d0(CustomerServiceActivity.class);
        } else if (N()) {
            d0(CustomerServiceActivity.class);
        }
    }

    public final void t2() {
        this.C.getUserInfo();
    }

    public final void u2() {
        CleanModel cleanModel = (CleanModel) h(CleanModel.class);
        this.B = cleanModel;
        cleanModel.getListMutableLiveData().observe(this, new Observer() { // from class: c.e.c.x.d.i1
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f2055a.U1((ResponseRowsVo) obj);
            }
        });
        this.B.getErrRequestLiveData().observe(this, new Observer() { // from class: c.e.c.x.d.d1
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f2035a.m2((RequestErrDto) obj);
            }
        });
    }

    @m(threadMode = r.MAIN)
    public void updateContractState(UpdateContractEventVo updateContractEventVo) {
        this.I = true;
        I1();
    }

    @m(threadMode = r.MAIN)
    public void updateSelectRoom(EventUpdateSelectRoom eventUpdateSelectRoom) {
        this.I = false;
        t2();
        z2(eventUpdateSelectRoom.getName());
    }

    @m(threadMode = r.MAIN)
    public void updateUser(UserSimpleDto userSimpleDto) {
        if (x.isNullStr(userSimpleDto.getNickname())) {
            D2();
            return;
        }
        this.I = false;
        t2();
        A2(userSimpleDto.getNickname(), userSimpleDto.getAvatar());
    }

    @m(threadMode = r.MAIN)
    public void updateUserInfo(EventUpdateUserInfoVo eventUpdateUserInfoVo) {
        int whatMsg = eventUpdateUserInfoVo.getWhatMsg();
        if (whatMsg == 0) {
            I1();
        } else if (whatMsg != 2) {
            F2(w());
        } else {
            I1();
            r2();
        }
    }

    @m(threadMode = r.MAIN)
    public void updateWalletEvent(EventUpdateWallet eventUpdateWallet) {
        if (O()) {
            r2();
        }
    }

    public final void v2() {
        ContractModel contractModel = (ContractModel) h(ContractModel.class);
        this.E = contractModel;
        contractModel.getContactList().observe(this, new Observer() { // from class: c.e.c.x.d.k1
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f2063a.o2((ResponseRowsVo) obj);
            }
        });
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void w2() {
        if (this.G) {
            this.G = false;
            this.L.setupGridLayoutManager(this.t, this.r);
        }
    }

    public final void x2() {
        B2();
        u2();
        y2();
        v2();
    }

    public final void y2() {
        OpenDoorModel openDoorModel = (OpenDoorModel) h(OpenDoorModel.class);
        this.D = openDoorModel;
        openDoorModel.getSignLockListLiveData().observe(this, new Observer() { // from class: c.e.c.x.d.b1
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f2027a.S1((ResponseRowsVo) obj);
            }
        });
        this.D.getRoomSelectLiveData().observe(this, new Observer() { // from class: c.e.c.x.d.e1
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f2039a.X1((ResponseStateVo) obj);
            }
        });
        this.D.getErrRequestLiveData().observe(this, new Observer() { // from class: c.e.c.x.d.g1
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f2047a.C((RequestErrDto) obj);
            }
        });
    }

    public final void z2(String str) {
        H();
        this.L.setupRentRoomName(str);
    }
}
