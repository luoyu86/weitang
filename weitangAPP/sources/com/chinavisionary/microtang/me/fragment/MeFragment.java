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
import c.e.a.d.q;
import c.e.a.d.w;
import c.e.a.d.x;
import c.e.c.m0.c;
import c.e.c.m0.o;
import c.e.c.x.e.g0;
import c.e.c.x.e.k0;
import c.e.c.x.e.p0;
import c.e.e.a.s.d;
import c.e.e.a.s.e;
import c.e.e.a.x.k;
import c.e.e.a.x.l;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.chinavisionary.core.app.base.CoreBaseFragment;
import com.chinavisionary.core.app.config.bo.AppConfigExtVo;
import com.chinavisionary.core.app.config.bo.UserInfoVo;
import com.chinavisionary.core.app.event.EventUpdateSelectRoom;
import com.chinavisionary.core.app.event.EventUpdateUserInfoVo;
import com.chinavisionary.core.app.net.base.dto.NewResponseRowsVo;
import com.chinavisionary.core.app.net.base.dto.RequestErrDto;
import com.chinavisionary.core.app.net.base.dto.ResponseRowsVo;
import com.chinavisionary.core.app.net.base.dto.ResponseStateVo;
import com.chinavisionary.core.scan.view.ScanCodeActivity;
import com.chinavisionary.core.weight.BaseSwipeRefreshLayout;
import com.chinavisionary.core.weight.banner.EditBannerView;
import com.chinavisionary.framework.mobile.common.vo.ResourceVo;
import com.chinavisionary.framework.mobile.login.dto.UserSimpleDto;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.base.BaseFragment;
import com.chinavisionary.microtang.clean.model.CleanModel;
import com.chinavisionary.microtang.comment.bo.ResponseCommentBadgeBo;
import com.chinavisionary.microtang.comment.event.EventRefreshCommentList;
import com.chinavisionary.microtang.comment.model.CommentModel;
import com.chinavisionary.microtang.contract.adapter.ContractListAdapter;
import com.chinavisionary.microtang.contract.model.ContractModel;
import com.chinavisionary.microtang.contract.vo.ContractListVo;
import com.chinavisionary.microtang.contract.vo.UpdateContractEventVo;
import com.chinavisionary.microtang.db.vo.CacheVo;
import com.chinavisionary.microtang.login.bo.EventUpdateUserAlertMessage;
import com.chinavisionary.microtang.main.bo.RequestBannerParamBo;
import com.chinavisionary.microtang.main.event.EventBadgeMsgVo;
import com.chinavisionary.microtang.main.event.EventUpdateProject;
import com.chinavisionary.microtang.main.fragments.AppAlertFragment;
import com.chinavisionary.microtang.main.vo.RoomModelVo;
import com.chinavisionary.microtang.me.FundActivity;
import com.chinavisionary.microtang.me.adapter.IncrementProductAdapter;
import com.chinavisionary.microtang.me.bo.RequestClickStatisticBo;
import com.chinavisionary.microtang.me.bo.ResponseManagerQrCodeBo;
import com.chinavisionary.microtang.me.fragment.MeFragment;
import com.chinavisionary.microtang.me.model.NewUserOperateModel;
import com.chinavisionary.microtang.me.model.UserOperateModel;
import com.chinavisionary.microtang.me.vo.CleanProductVo;
import com.chinavisionary.microtang.me.vo.EventContract;
import com.chinavisionary.microtang.me.vo.EventSwitchRoomVo;
import com.chinavisionary.microtang.me.vo.EventUpdateWallet;
import com.chinavisionary.microtang.me.vo.FundNewsVo;
import com.chinavisionary.microtang.me.vo.OrderVo;
import com.chinavisionary.microtang.msg.MsgActivity;
import com.chinavisionary.microtang.open.event.EventUpdateOftenRoomCache;
import com.chinavisionary.microtang.room.KeepRentActivity;
import com.chinavisionary.microtang.service.CustomerServiceActivity;
import com.chinavisionary.microtang.vo.EventUpdateRentState;
import com.chinavisionary.paymentlibrary.vo.EventPayStateVo;
import com.chinavisionary.twlib.open.bo.AlertMessageVo;
import com.chinavisionary.twlib.open.model.NewOpenDoorModel;
import com.chinavisionary.twlib.open.model.OpenDoorModel;
import com.tencent.mm.opensdk.modelbiz.WXLaunchMiniProgram;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import g.b.a.m;
import g.b.a.r;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class MeFragment extends BaseFragment<CleanProductVo> {
    public CleanModel B;
    public UserOperateModel C;
    public NewUserOperateModel D;
    public OpenDoorModel E;
    public NewOpenDoorModel F;
    public ContractModel G;
    public CommentModel H;
    public e K;
    public ContractListVo M;
    public k0 N;
    public p0 O;
    public String P;

    @BindView(R.id.tv_badge_paint)
    public TextView mBadgePaintTv;

    @BindView(R.id.tv_badge_value)
    public TextView mBadgeValueTv;

    @BindView(R.id.recycler_clean)
    public BaseSwipeRefreshLayout mBaseSwipeRefreshLayout;

    @BindView(R.id.tv_title)
    public TextView mTitleTv;
    public boolean I = true;
    public boolean J = true;
    public boolean L = true;
    public final c.e.a.a.c.c.a Q = new c.e.a.a.c.c.a() { // from class: c.e.c.x.d.o0
        @Override // c.e.a.a.c.c.a
        public final void onItemClickListener(View view, int i2) {
            this.f2078a.N2(view, i2);
        }
    };
    public final g0 R = new a();

    public class a implements g0 {
        public a() {
        }

        @Override // c.e.c.x.e.g0
        public void addFragment(BaseFragment baseFragment) {
            MeFragment.this.f2(baseFragment, true);
        }

        @Override // c.e.c.x.e.g0
        public void clickBannerItem(View view) {
            EditBannerView.BannerDto bannerDto = (EditBannerView.BannerDto) view.getTag(R.id.edt_banner_view_img_path_id);
            if (x.isNotNull(bannerDto.getTitle())) {
                String title = bannerDto.getTitle();
                String dataKey = bannerDto.getDataKey();
                if (x.isNotNull(bannerDto.getTargetAppid())) {
                    int i2 = 15;
                    if (x.isNotNull(bannerDto.getTargetMiniType()) && FundNewsVo.TYPE_ALIPAY.equals(bannerDto.getTargetMiniType())) {
                        i2 = 18;
                    }
                    MeFragment.this.c1(Integer.valueOf(i2), bannerDto.getTargetAppid(), bannerDto.getTargetPath());
                } else {
                    MeFragment.this.c1(Integer.valueOf(bannerDto.getDataType()), dataKey, title);
                }
                MeFragment.this.V0(title);
                MeFragment.this.u1(bannerDto.getBaseKey());
            }
        }

        @Override // c.e.c.x.e.g0
        public void clickForward(OrderVo orderVo) {
            int forwardType = orderVo.getForwardType();
            orderVo.getMessageType();
            if (forwardType == 1) {
                MeFragment.this.c1(1, orderVo.getContent(), orderVo.getTitle());
                return;
            }
            if (forwardType == 2) {
                MeFragment.this.c1(1, orderVo.getH5Url(), orderVo.getTitle());
                return;
            }
            if (forwardType == 7) {
                MeFragment.this.c1(15, orderVo.getMiniAppId(), orderVo.getMiniPagePath());
                return;
            }
            if (forwardType == 8) {
                MeFragment.this.c1(18, orderVo.getMiniAppId(), orderVo.getMiniPagePath());
                return;
            }
            if (forwardType != 9) {
                return;
            }
            Intent intent = new Intent(MeFragment.this.getContext(), (Class<?>) FundActivity.class);
            intent.putExtra("page_type", orderVo.getJumpType());
            intent.putExtra("app_id", orderVo.getMiniAppId());
            intent.putExtra("app_page", orderVo.getMiniPagePath());
            MeFragment.this.startActivity(intent);
        }

        @Override // c.e.c.x.e.g0
        public void clickFunction(String str) {
            MeFragment.this.d1(str);
        }

        @Override // c.e.c.x.e.g0
        public void clickFunctionType(String str) {
            if (x.isNotNull(str)) {
                RequestClickStatisticBo requestClickStatisticBo = new RequestClickStatisticBo();
                requestClickStatisticBo.setType(str);
                MeFragment.this.D.doClickStatistic(requestClickStatisticBo);
            }
        }

        @Override // c.e.c.x.e.g0
        public void clickWxMiniAppManager() {
            ResponseManagerQrCodeBo responseManagerQrCodeBo = o.getInstance().getResponseManagerQrCodeBo();
            if (responseManagerQrCodeBo == null) {
                MeFragment.this.D.getManagerQrCode();
                showToast("暂无管家信息");
                return;
            }
            if (!x.isNotNull(responseManagerQrCodeBo.getBuildingKey())) {
                showToast("暂无社区或者楼栋信息");
                return;
            }
            IWXAPI iwxapiCreateWXAPI = WXAPIFactory.createWXAPI(MeFragment.this.f6487e, "wx566d59045c104e04");
            WXLaunchMiniProgram.Req req = new WXLaunchMiniProgram.Req();
            req.userName = "gh_e34b59122a96";
            req.path = "/pageDoc/card/card?communityKey=" + responseManagerQrCodeBo.getCommunityKey() + "&communityHousekeeperType=apartment&buildingKey=" + responseManagerQrCodeBo.getBuildingKey();
            String str = MeFragment.this.f6485c;
            StringBuilder sb = new StringBuilder();
            sb.append("path = ");
            sb.append(req.path);
            q.d(str, sb.toString());
            req.miniprogramType = 0;
            iwxapiCreateWXAPI.sendReq(req);
        }

        @Override // c.e.c.x.e.g0
        public FragmentActivity getCurrentActivity() {
            return MeFragment.this.getActivity();
        }

        @Override // c.e.c.x.e.g0
        public void handleOftenUseRoomEventMonitor(String str) {
            MeFragment.this.h1(str);
        }

        @Override // c.e.c.x.e.g0
        public void hideAlertLoading() {
            MeFragment.this.H();
        }

        @Override // c.e.c.x.e.g0
        public boolean isLoginApp() {
            return MeFragment.this.N();
        }

        @Override // c.e.c.x.e.g0
        public void showAlertDialog(String str, String str2, boolean z, View.OnClickListener onClickListener) {
            MeFragment.this.C1(str, str2, Boolean.valueOf(z), onClickListener);
        }

        @Override // c.e.c.x.e.g0
        public void showAlertLoading(int i2) {
            MeFragment.this.z0(i2);
        }

        @Override // c.e.c.x.e.g0
        public void showOpenDoorSuccessAlert() {
            List<AlertMessageVo> billAlertMessageVo = l.getInstance().getBillAlertMessageVo();
            if (c.e.a.d.o.isNotEmpty(billAlertMessageVo)) {
                for (AlertMessageVo alertMessageVo : billAlertMessageVo) {
                    String href = alertMessageVo.getHref();
                    if (k.isNotNull(href) && href.contains("http")) {
                        alertMessageVo.setMessageType(5);
                        alertMessageVo.setForwardType(1);
                    }
                    MeFragment.this.f2(AppAlertFragment.getInstance(alertMessageVo), true);
                }
            }
        }

        @Override // c.e.c.x.e.g0
        public void showToast(int i2) {
            MeFragment.this.F0(i2);
        }

        @Override // c.e.c.x.e.g0
        public boolean userIsAuth() {
            return MeFragment.this.L() || MeFragment.this.M();
        }

        @Override // c.e.c.x.e.g0
        public boolean userIsRent() {
            return MeFragment.this.Q();
        }

        @Override // c.e.c.x.e.g0
        public void addFragment(BaseFragment baseFragment, boolean z) {
            MeFragment.this.f2(baseFragment, z);
        }

        @Override // c.e.c.x.e.g0
        public void showAlertLoading(String str) {
            MeFragment.this.B0(str);
        }

        @Override // c.e.c.x.e.g0
        public void showToast(String str) {
            MeFragment.this.G0(str);
        }
    }

    public class b implements CoreBaseFragment.d {
        public b() {
        }

        @Override // com.chinavisionary.core.app.base.CoreBaseFragment.d
        public void updatePosition(int i2, int i3) {
            MeFragment.this.t.setFirstLastPosition(i2, i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: J2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void K2() {
        this.C.getApplyRentBadge();
    }

    public static /* synthetic */ void L2(RoomModelVo.ModulesBean modulesBean) {
        try {
            c.e.c.p.b.getInstance().insertCacheVo(CacheVo.ME_BANNER_CACHE_KEY, JSON.toJSONString(modulesBean, SerializerFeature.DisableCircularReferenceDetect));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: M2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void N2(View view, int i2) {
        if (view.getTag() instanceof IncrementProductAdapter.IncrementProductVH) {
            this.N.openCleanDetails((CleanProductVo) this.t.getList().get(i2));
        } else if (view.getTag() instanceof ContractListAdapter.ContractListVh) {
            this.N.openContractDetails((CleanProductVo) this.t.getList().get(i2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: O2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void P2() {
        this.L = true;
        I1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: R2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void S2(RequestErrDto requestErrDto) {
        q2();
    }

    public static /* synthetic */ void T2(ResponseRowsVo responseRowsVo) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: U2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void V2(RequestErrDto requestErrDto) {
        q3();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: W2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void X2(RequestErrDto requestErrDto) {
        q3();
    }

    public static MeFragment getInstance() {
        return new MeFragment();
    }

    private void o0() {
        this.l = false;
        IncrementProductAdapter incrementProductAdapter = new IncrementProductAdapter();
        this.t = incrementProductAdapter;
        incrementProductAdapter.setOnClickListener(this.y);
        this.t.setOnItemClickListener(this.Q);
        View viewInflate = LayoutInflater.from(this.f6487e).inflate(R.layout.item_clean_head_layout, (ViewGroup) null);
        this.N.initUserView(viewInflate);
        c.e.a.a.a.getInstance().setShowPwdDoor(w.getInstance().getBoolean("is_show_pwd_door", false));
        c.e.a.a.a.getInstance().setEnterpriseUser(!"18688948873".equals(s()));
        this.N.updateMenuItem();
        this.O.initWalletView(viewInflate);
        this.t.addHeadView(viewInflate);
        this.r = this.mBaseSwipeRefreshLayout.getBaseRecyclerView();
        this.v = new b();
    }

    public final void A2() {
        k0 k0Var = new k0(this.R);
        this.N = k0Var;
        k0Var.setAppConfigVo(o());
        p0 p0Var = new p0(this.R);
        this.O = p0Var;
        p0Var.setUserOperateModel(this.C, this.D);
    }

    @Override // com.chinavisionary.microtang.base.BaseFragment
    public void U0(final RoomModelVo.ModulesBean modulesBean) {
        new Thread(new Runnable() { // from class: c.e.c.x.d.k0
            @Override // java.lang.Runnable
            public final void run() {
                MeFragment.L2(modulesBean);
            }
        }).start();
        this.N.addMeBannerData(modulesBean.getBannerDtoList(), this);
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void V(View view) {
        int id = view.getId();
        if (id == R.id.btn_action) {
            handlerAction(view);
        } else if (id == R.id.btn_keep_rent) {
            p2(view);
        } else if (id == R.id.id_about_item) {
            this.N.handleAboutItemClickView(view);
        }
        if (view.getId() == R.id.img_banner_pic) {
            y2(view);
        }
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void W() {
        z2();
        l3();
        A2();
        o0();
        TextView textView = (TextView) this.u.findViewById(R.id.tv_debug_content);
        if (c.e.a.a.a.getInstance().isDebug()) {
            textView.setVisibility(0);
        }
        u3(w());
        c3();
        I1();
    }

    public final void c3() {
        try {
            CacheVo cacheVo = c.e.c.p.b.getInstance().getCacheVo(CacheVo.ME_BANNER_CACHE_KEY);
            if (cacheVo != null) {
                String cacheValue = cacheVo.getCacheValue();
                if (x.isNotNull(cacheValue)) {
                    q.d(this.f6485c, "cacheValue = " + cacheValue);
                    this.N.addMeBannerData(((RoomModelVo.ModulesBean) JSON.parseObject(cacheValue, RoomModelVo.ModulesBean.class)).getBannerDtoList(), this);
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
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
    public final void d2() {
        if (c.e.a.a.a.getInstance().isNewVersionModel() || !this.I) {
            return;
        }
        this.I = false;
        this.N.addAboutDataToList(this.t, this.r);
    }

    public final void d3() {
        NewUserOperateModel newUserOperateModel;
        if (!O() || (newUserOperateModel = this.D) == null) {
            return;
        }
        newUserOperateModel.getWalletBalance();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference incomplete: some casts might be missing */
    public final void e2(List list) {
        if (list.isEmpty() && this.f6483a == 1) {
            CleanProductVo cleanProductVo = new CleanProductVo();
            cleanProductVo.setType(34952);
            this.t.addDataToList((T) cleanProductVo);
        } else if (this.f6483a == 1) {
            k3();
        }
    }

    public final void e3() {
        if (c.e.a.a.a.getInstance().isNewVersionModel()) {
            this.mBaseSwipeRefreshLayout.setRefreshing(false);
        } else {
            this.B.getCleanList(r(), this.P, v(), "");
        }
    }

    @m(threadMode = r.MAIN)
    public void eventLoginSuccess(EventUpdateUserAlertMessage eventUpdateUserAlertMessage) {
        c.e.a.a.a.getInstance().setEnterpriseUser(!"18688948873".equals(s()));
        this.N.updateMenuItem();
    }

    @m
    public void eventRefreshAppBo(c.e.b.c.d.l lVar) {
        if (c.e.b.c.d.l.APPLY_RENT_BADGE.equals(lVar.getRefresh())) {
            h2();
        }
    }

    @m
    public void eventUpdateOftenRoomCache(EventUpdateOftenRoomCache eventUpdateOftenRoomCache) {
        k0 k0Var = this.N;
        if (k0Var != null) {
            k0Var.updateOftenRoomCache();
        }
    }

    public final void f2(BaseFragment baseFragment, boolean z) {
        e(baseFragment, R.id.constraint_main_content, z);
    }

    public final void f3() {
        NewOpenDoorModel newOpenDoorModel = this.F;
        if (newOpenDoorModel == null) {
            this.E.getSignLockList();
        } else {
            newOpenDoorModel.getRoomList("MeFragment-requestLockList");
            this.F.getSignLockList("MeFragment-requestLockList");
        }
    }

    public final void g2(boolean z) {
        this.N.addMenuItemToIsRent(z);
    }

    public final void g3() {
        NewUserOperateModel newUserOperateModel = this.D;
        if (newUserOperateModel != null) {
            newUserOperateModel.getUserInfo();
        }
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public int getLayoutId() {
        return R.layout.fragment_me;
    }

    public final void h2() {
        this.f6488f.postDelayed(new Runnable() { // from class: c.e.c.x.d.i0
            @Override // java.lang.Runnable
            public final void run() {
                this.f2054a.K2();
            }
        }, 500L);
    }

    public final void h3() {
        this.N.updateApplyRentBadge(0);
        k(new EventBadgeMsgVo());
    }

    public final void handlerAction(View view) {
        CleanProductVo cleanProductVo = (CleanProductVo) this.t.getList().get(((Integer) view.getTag()).intValue());
        this.M = cleanProductVo.getContractListVo();
        this.N.openContractDetails(cleanProductVo);
    }

    public final String i2() {
        return w.getInstance().getString("current_room_key", null);
    }

    public final void i3() {
        CleanModel cleanModel = (CleanModel) h(CleanModel.class);
        this.B = cleanModel;
        cleanModel.getListMutableLiveData().observe(this, new Observer() { // from class: c.e.c.x.d.y0
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f2116a.n2((ResponseRowsVo) obj);
            }
        });
        this.B.getErrRequestLiveData().observe(this, new Observer() { // from class: c.e.c.x.d.w0
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f2110a.S2((RequestErrDto) obj);
            }
        });
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    /* JADX INFO: renamed from: j0 */
    public void I1() {
        e3();
        this.C.getAppConfig();
        this.C.getAppServerConfig();
        if (O()) {
            g3();
        }
        v1(RequestBannerParamBo.GET_ME_BANNER_TYPE);
    }

    public final void j2(NewResponseRowsVo<FundNewsVo> newResponseRowsVo) {
        if (newResponseRowsVo != null) {
            this.N.updateAboutUsConfig(newResponseRowsVo.getRows());
        }
    }

    public final void j3() {
        ContractModel contractModel = (ContractModel) h(ContractModel.class);
        this.G = contractModel;
        contractModel.getContactList().observe(this, new Observer() { // from class: c.e.c.x.d.p0
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                MeFragment.T2((ResponseRowsVo) obj);
            }
        });
    }

    public final void k2(ResponseRowsVo<d> responseRowsVo) {
        e defaultRentRoom = this.N.getDefaultRentRoom(responseRowsVo, v());
        if (defaultRentRoom != null) {
            this.K = defaultRentRoom;
            NewOpenDoorModel newOpenDoorModel = this.F;
            if (newOpenDoorModel != null) {
                newOpenDoorModel.postSelectRoom(defaultRentRoom);
            } else {
                this.E.postSelectRoom(defaultRentRoom);
            }
        } else {
            this.K = null;
        }
        e eVar = this.K;
        if (eVar != null) {
            n3(eVar.getAssetInstanceName(), this.K.getAssetInstanceKey());
        } else {
            n3(null, null);
        }
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
    public final void k3() {
        if (this.J) {
            this.J = false;
            this.N.setupGridLayoutManager(this.t, this.r);
        }
    }

    public final void l2(AppConfigExtVo appConfigExtVo) {
        if (appConfigExtVo != null) {
            c.getInstance().setAppConfigExtVo(appConfigExtVo);
            q.d(getClass().getSimpleName(), "handleAppConfigResult :" + appConfigExtVo.getTestConfig());
            this.N.setAppConfigVo(appConfigExtVo);
            k0(appConfigExtVo);
        }
    }

    public final void l3() {
        z1();
        p3();
        i3();
        m3();
        j3();
    }

    public final void m2(ResponseCommentBadgeBo responseCommentBadgeBo) {
        if (responseCommentBadgeBo != null) {
            this.N.updateApplyRentBadge(responseCommentBadgeBo.getTotal());
        }
    }

    public final void m3() {
        OpenDoorModel openDoorModel = (OpenDoorModel) h(OpenDoorModel.class);
        this.E = openDoorModel;
        openDoorModel.getSignLockListLiveData().observe(this, new Observer() { // from class: c.e.c.x.d.q0
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f2086a.k2((ResponseRowsVo) obj);
            }
        });
        this.E.getRoomSelectLiveData().observe(this, new Observer() { // from class: c.e.c.x.d.h0
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f2050a.v2((ResponseStateVo) obj);
            }
        });
        this.E.getErrRequestLiveData().observe(this, new Observer() { // from class: c.e.c.x.d.z0
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f2119a.t2((RequestErrDto) obj);
            }
        });
        if (c.e.a.a.a.getInstance().isH5Model()) {
            NewOpenDoorModel newOpenDoorModel = (NewOpenDoorModel) h(NewOpenDoorModel.class);
            this.F = newOpenDoorModel;
            newOpenDoorModel.getSignLockListLiveData().observe(this, new Observer() { // from class: c.e.c.x.d.q0
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    this.f2086a.k2((ResponseRowsVo) obj);
                }
            });
            this.F.getRoomSelectLiveData().observe(this, new Observer() { // from class: c.e.c.x.d.h0
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    this.f2050a.v2((ResponseStateVo) obj);
                }
            });
            this.F.getRoomList().observe(this, new Observer() { // from class: c.e.c.x.d.x0
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    this.f2113a.u2((NewResponseRowsVo) obj);
                }
            });
            this.F.getErrRequestLiveData().observe(this, new Observer() { // from class: c.e.c.x.d.z0
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    this.f2119a.t2((RequestErrDto) obj);
                }
            });
        }
    }

    @OnClick({R.id.rlayout_notify})
    public void msgClickView(View view) {
        if (N()) {
            d0(MsgActivity.class);
        }
    }

    public final void n2(ResponseRowsVo<CleanProductVo> responseRowsVo) {
        q3();
        if (responseRowsVo != null) {
            this.I = true;
            D(responseRowsVo.getRows());
            e2(responseRowsVo.getRows());
        }
        d2();
        if (O()) {
            c.e.a.a.a.getInstance().isDebug();
        }
    }

    public final void n3(String str, String str2) {
        H();
        this.N.setupRentRoomName(str);
        c.getInstance().setRoomKey(str2);
        w.getInstance().putString("room_key", str2);
    }

    @m(threadMode = r.MAIN)
    public void newContract(EventContract eventContract) {
        i("newContract");
        CoreBaseFragment.c cVar = this.f6488f;
        if (cVar != null) {
            cVar.postDelayed(new Runnable() { // from class: c.e.c.x.d.u0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f2103a.P2();
                }
            }, 1000L);
        }
    }

    public final void o2(ResponseCommentBadgeBo responseCommentBadgeBo) {
        if (responseCommentBadgeBo != null) {
            this.N.updateRentCommentBadge(responseCommentBadgeBo.isCommentFlage(), responseCommentBadgeBo.getTotal());
        }
    }

    public final void o3(String str, ResourceVo resourceVo) {
        this.N.setupUserInfo(str, c.e.a.d.c0.d.getInstance().getUrlToResourceVo(resourceVo));
        this.O.setupIsShowWallet(O() && R());
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
        if (!O()) {
            n3(null, null);
            return;
        }
        String strI2 = i2();
        if (x.isNullStr(strI2)) {
            f3();
        } else {
            n3(strI2, v());
        }
    }

    @OnClick({R.id.rlayout_scan})
    public void openScan(View view) {
        d0(ScanCodeActivity.class);
    }

    public final void p2(View view) {
        String assetKey = ((CleanProductVo) this.t.getList().get(((Integer) view.getTag()).intValue())).getContractListVo().getAssetKey();
        if (x.isNotNull(assetKey)) {
            Intent intent = new Intent(this.f6487e, (Class<?>) KeepRentActivity.class);
            intent.putExtra("key", assetKey);
            startActivity(intent);
        }
    }

    public final void p3() {
        if (c.e.a.a.a.getInstance().isH5Model()) {
            NewUserOperateModel newUserOperateModel = (NewUserOperateModel) h(NewUserOperateModel.class);
            this.D = newUserOperateModel;
            newUserOperateModel.getUserInfoVoResult().observe(this, new Observer() { // from class: c.e.c.x.d.l0
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    this.f2066a.x2((UserInfoVo) obj);
                }
            });
            this.D.getManagerQrCodeResult().observe(this, new Observer() { // from class: c.e.c.x.d.g0
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    this.f2046a.r2((ResponseManagerQrCodeBo) obj);
                }
            });
            this.D.getErrRequestLiveData().observe(this, new Observer() { // from class: c.e.c.x.d.t0
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    this.f2099a.V2((RequestErrDto) obj);
                }
            });
        }
        UserOperateModel userOperateModel = (UserOperateModel) h(UserOperateModel.class);
        this.C = userOperateModel;
        userOperateModel.getUserInfoVoResult().observe(this, new Observer() { // from class: c.e.c.x.d.l0
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f2066a.x2((UserInfoVo) obj);
            }
        });
        this.C.getAppConfigLiveData().observe(this, new Observer() { // from class: c.e.c.x.d.v0
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f2106a.l2((AppConfigExtVo) obj);
            }
        });
        this.C.getServerConfigResult().observe(this, new Observer() { // from class: c.e.c.x.d.n0
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f2074a.w2((NewResponseRowsVo) obj);
            }
        });
        this.C.getMeVtConfigResult().observe(this, new Observer() { // from class: c.e.c.x.d.r0
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f2090a.s2((NewResponseRowsVo) obj);
            }
        });
        this.C.getAboutUsConfigResult().observe(this, new Observer() { // from class: c.e.c.x.d.a1
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f2023a.j2((NewResponseRowsVo) obj);
            }
        });
        this.C.getApplyRentBadgeResult().observe(this, new Observer() { // from class: c.e.c.x.d.s0
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f2095a.m2((ResponseCommentBadgeBo) obj);
            }
        });
        this.C.getErrRequestLiveData().observe(this, new Observer() { // from class: c.e.c.x.d.m0
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f2070a.X2((RequestErrDto) obj);
            }
        });
        CommentModel commentModel = (CommentModel) h(CommentModel.class);
        this.H = commentModel;
        commentModel.getCommentBadgeResult().observe(this, new Observer() { // from class: c.e.c.x.d.j0
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f2058a.o2((ResponseCommentBadgeBo) obj);
            }
        });
    }

    @m(threadMode = r.MAIN)
    public void payStateEvent(EventPayStateVo eventPayStateVo) {
        if (O() && eventPayStateVo.isSuccess()) {
            d3();
        }
    }

    public final void q2() {
        q3();
        B();
        if (this.f6483a == 1 && this.t.getList().isEmpty()) {
            e2(new ArrayList());
            d2();
        }
    }

    public final void q3() {
        H();
        this.mBaseSwipeRefreshLayout.setRefreshing(false);
    }

    public final void r2(ResponseManagerQrCodeBo responseManagerQrCodeBo) {
        o.getInstance().setResponseManagerQrCodeBo(responseManagerQrCodeBo);
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
    public final void r3() {
        this.L = true;
        g2(false);
        this.N.removeContractList(this.t, this.r);
        this.N.unLoginState();
        this.O.setupIsShowWallet(false);
        m0(null);
        h3();
        s3();
    }

    @m
    public void refreshCommentList(EventRefreshCommentList eventRefreshCommentList) {
        CommentModel commentModel = this.H;
        if (commentModel != null) {
            commentModel.getIsShowCommentBadge("refreshCommentList");
        }
    }

    @m(sticky = true, threadMode = r.MAIN)
    public void registerEventBadgeMsg(EventBadgeMsgVo eventBadgeMsgVo) {
        c.e.c.m0.e.setupBadge(eventBadgeMsgVo, this.mBadgeValueTv, this.mBadgePaintTv);
    }

    @m(threadMode = r.MAIN)
    public void registerEventUpdateProject(EventUpdateProject eventUpdateProject) {
        this.P = eventUpdateProject.getKey();
        I1();
    }

    public final void s2(NewResponseRowsVo<FundNewsVo> newResponseRowsVo) {
        if (newResponseRowsVo != null) {
            this.N.updateMeVtConfig(newResponseRowsVo.getRows());
            h2();
        }
    }

    public final void s3() {
        this.N.updatePwdDoorEntryState();
    }

    @OnClick({R.id.rlayout_server})
    public void serverClick(View view) {
        if (c.e.a.a.a.getInstance().isIMModel()) {
            d0(CustomerServiceActivity.class);
        } else if (N()) {
            d0(CustomerServiceActivity.class);
        }
    }

    public final void t2(RequestErrDto requestErrDto) {
        if (requestErrDto == null || x.getString(R.string.tip_title_retry_use_api).equals(requestErrDto.getErrMsg())) {
            return;
        }
        C(requestErrDto);
    }

    public final void t3(boolean z) {
        if (z) {
            n3(i2(), v());
        }
        if (this.L) {
            NewOpenDoorModel newOpenDoorModel = this.F;
            if (newOpenDoorModel == null) {
                this.E.getSignLockList();
            } else {
                newOpenDoorModel.getRoomList("MeFragment-updateRoomLockList");
                this.F.getSignLockList("MeFragment-updateRoomLockList");
            }
        }
    }

    public final void u2(NewResponseRowsVo<d> newResponseRowsVo) {
        if (newResponseRowsVo != null && c.e.a.d.o.isNotEmpty(newResponseRowsVo.getRows())) {
            List<d> rows = newResponseRowsVo.getRows();
            c.e.a.a.a.getInstance().setShowPwdDoor(false);
            Iterator<d> it = rows.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                d next = it.next();
                if (next != null && next.isSupportNumberPassword()) {
                    c.e.a.a.a.getInstance().setShowPwdDoor(true);
                    w.getInstance().putBoolean("is_show_pwd_door", true);
                    break;
                }
            }
        }
        s3();
    }

    public final void u3(UserInfoVo userInfoVo) {
        boolean z = false;
        if (userInfoVo == null) {
            r3();
            this.N.updateOftenUseRoomVisibility(false);
            return;
        }
        this.N.handlerIsAuth(Boolean.valueOf(userInfoVo.isValidate() || userInfoVo.isValidateFaDaDa()));
        o3(userInfoVo.getNickname(), userInfoVo.getAvatar());
        k0 k0Var = this.N;
        if (userInfoVo.isCheckIn() && (userInfoVo.isValidate() || userInfoVo.isValidateFaDaDa())) {
            z = true;
        }
        k0Var.updateOftenUseRoomVisibility(z);
    }

    @m(threadMode = r.MAIN)
    public void updateContractState(UpdateContractEventVo updateContractEventVo) {
        this.L = true;
        I1();
    }

    @m
    public void updateRemoteOpenDoor(c.e.c.a0.g.a aVar) {
        this.N.updateRemoteOpenDoor();
    }

    @m(threadMode = r.MAIN)
    public void updateSelectRoom(EventUpdateSelectRoom eventUpdateSelectRoom) {
        this.L = false;
        g3();
        n3(eventUpdateSelectRoom.getName(), eventUpdateSelectRoom.getKey());
        e3();
    }

    @m(threadMode = r.MAIN)
    public void updateUser(UserSimpleDto userSimpleDto) {
        if (x.isNullStr(userSimpleDto.getNickname())) {
            r3();
        } else {
            g3();
            o3(userSimpleDto.getNickname(), userSimpleDto.getAvatar());
        }
    }

    @m(threadMode = r.MAIN)
    public void updateUserInfo(EventUpdateUserInfoVo eventUpdateUserInfoVo) {
        int whatMsg = eventUpdateUserInfoVo.getWhatMsg();
        if (whatMsg == 0) {
            I1();
        } else if (whatMsg != 2) {
            u3(w());
            e3();
        } else {
            I1();
            d3();
        }
    }

    @m(threadMode = r.MAIN)
    public void updateWalletEvent(EventUpdateWallet eventUpdateWallet) {
        if (O()) {
            d3();
        }
    }

    public final void v2(ResponseStateVo responseStateVo) {
        if (responseStateVo != null) {
            this.L = false;
            e eVar = this.K;
            if (eVar != null) {
                n3(eVar.getAssetInstanceName(), this.K.getAssetInstanceKey());
            }
            k(new EventSwitchRoomVo());
            g3();
            e3();
        }
    }

    public final void w2(NewResponseRowsVo<FundNewsVo> newResponseRowsVo) {
        if (newResponseRowsVo != null) {
            this.N.updateServerConfig(newResponseRowsVo.getRows());
        }
    }

    public final void x2(UserInfoVo userInfoVo) {
        q3();
        if (userInfoVo != null) {
            d3();
            u3(userInfoVo);
            m0(JSON.toJSONString(userInfoVo));
            t3(Q());
            k(new EventUpdateRentState());
            this.H.getIsShowCommentBadge("handleUserInfo");
        }
    }

    public final void y2(View view) {
        EditBannerView.BannerDto bannerDto = (EditBannerView.BannerDto) view.getTag(R.id.edt_banner_view_img_path_id);
        if (x.isNotNull(bannerDto.getTitle())) {
            String title = bannerDto.getTitle();
            String dataKey = bannerDto.getDataKey();
            if (x.isNotNull(bannerDto.getTargetAppid())) {
                super.c1(15, bannerDto.getTargetAppid(), bannerDto.getTargetPath());
            } else {
                super.c1(Integer.valueOf(bannerDto.getDataType()), dataKey, title);
            }
            super.V0(title);
            u1(bannerDto.getBaseKey());
        }
    }

    public final void z2() {
        h0(this);
        this.mTitleTv.setText(R.string.title_me);
        this.mTitleTv.setTextSize(18.0f);
        this.mTitleTv.setVisibility(8);
        this.mTitleTv.setTextColor(getResources().getColor(R.color.color000000));
        this.f6488f = new CoreBaseFragment.c(this);
        this.P = w.getInstance().getString("selectProjectKey", null);
    }
}
