package com.chinavisionary.microtang.main.fragments;

import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.lifecycle.Observer;
import butterknife.BindView;
import butterknife.OnClick;
import c.e.a.d.o;
import c.e.a.d.q;
import c.e.a.d.v;
import c.e.a.d.x;
import c.e.c.m0.e;
import c.e.c.v.f.f0;
import c.e.c.v.f.h0;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.chinavisionary.core.app.base.CoreBaseFragment;
import com.chinavisionary.core.app.event.EventUpdateToken;
import com.chinavisionary.core.app.net.base.dto.NewResponseRowsVo;
import com.chinavisionary.core.app.net.base.dto.RequestErrDto;
import com.chinavisionary.core.scan.view.ScanCodeActivity;
import com.chinavisionary.core.weight.BaseRecyclerView;
import com.chinavisionary.core.weight.BaseSwipeRefreshLayout;
import com.chinavisionary.core.weight.banner.EditBannerView;
import com.chinavisionary.framework.mobile.common.vo.ResourceVo;
import com.chinavisionary.framework.mobile.login.dto.UserSimpleDto;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.base.BaseFragment;
import com.chinavisionary.microtang.db.vo.CacheVo;
import com.chinavisionary.microtang.login.bo.EventUpdateUserAlertMessage;
import com.chinavisionary.microtang.login.bo.SecretKeyBo;
import com.chinavisionary.microtang.main.adapter.MainAdapter;
import com.chinavisionary.microtang.main.bo.ProjectVo;
import com.chinavisionary.microtang.main.bo.RequestBannerParamBo;
import com.chinavisionary.microtang.main.event.EventBadgeMsgVo;
import com.chinavisionary.microtang.main.event.EventOssUpdateSuccess;
import com.chinavisionary.microtang.main.event.EventUpdateAliYunOss;
import com.chinavisionary.microtang.main.event.EventUpdateCity;
import com.chinavisionary.microtang.main.event.EventUpdateProject;
import com.chinavisionary.microtang.main.fragments.RoomMainFragment;
import com.chinavisionary.microtang.main.model.NewRoomModel;
import com.chinavisionary.microtang.main.vo.CityItemVo;
import com.chinavisionary.microtang.main.vo.ModelProductVo;
import com.chinavisionary.microtang.main.vo.ResponseGroupResultVo;
import com.chinavisionary.microtang.main.vo.RoomModelVo;
import com.chinavisionary.microtang.me.model.NewUserModel;
import com.chinavisionary.microtang.me.vo.FundNewsVo;
import com.chinavisionary.microtang.me.vo.RequestEnterpriseAuthStateBo;
import com.chinavisionary.microtang.me.vo.ResponseEnterpriseAuthStateBo;
import com.chinavisionary.microtang.me.vo.ResponseEnterpriseNotifyBo;
import com.chinavisionary.microtang.msg.MsgActivity;
import com.chinavisionary.microtang.repair.adapter.RepairLeftAdapter;
import com.chinavisionary.microtang.repair.vo.RepairLeftVo;
import com.chinavisionary.microtang.room.SearchRoomActivity;
import com.chinavisionary.microtang.service.CustomerServiceActivity;
import com.chinavisionary.microtang.web.bridge.BridgeWebViewActivity;
import com.chinavisionary.microtang.web.event.EventReloadEnterpriseAuth;
import com.chinavisionary.microtang.web.event.EventReloadEnterpriseNotify;
import g.b.a.m;
import g.b.a.r;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class RoomMainFragment extends BaseFragment<RoomModelVo.ModulesBean> {
    public int C;
    public NewRoomModel D;
    public h0 E;
    public c.e.c.v.c.a F;
    public int G;
    public boolean H;
    public String I;
    public String J;
    public PopupWindow K;
    public BaseRecyclerView L;
    public RepairLeftAdapter M;
    public NewUserModel N;
    public RoomModelVo.ModulesBean Q;
    public RoomModelVo.ModulesBean R;
    public ResponseEnterpriseNotifyBo S;

    @BindView(R.id.tv_badge_paint)
    public TextView mBadgePaintTv;

    @BindView(R.id.tv_badge_value)
    public TextView mBadgeValueTv;

    @BindView(R.id.swipe_refresh_layout_main)
    public BaseSwipeRefreshLayout mBaseSwipeRefreshLayout;

    @BindView(R.id.view_bg)
    public View mBgView;

    @BindView(R.id.tv_city_value)
    public AppCompatTextView mCityValueTv;

    @BindView(R.id.tv_city)
    public AppCompatTextView mProjectNameTv;

    @BindView(R.id.rlayout_title)
    public RelativeLayout mTitleRelativeLayout;
    public long B = 0;
    public boolean O = true;
    public volatile boolean P = false;
    public final c.e.a.a.c.c.a T = new c.e.a.a.c.c.a() { // from class: c.e.c.v.e.b0
        @Override // c.e.a.a.c.c.a
        public final void onItemClickListener(View view, int i2) {
            this.f1899a.l2(view, i2);
        }
    };

    public class a implements PopupWindow.OnDismissListener {
        public a() {
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
        }
    }

    public class b implements c.e.a.a.c.c.a {
        public b() {
        }

        @Override // c.e.a.a.c.c.a
        public void onItemClickListener(View view, int i2) {
            RoomMainFragment.this.H2(i2);
            RoomMainFragment.this.K.dismiss();
        }
    }

    public class c implements CoreBaseFragment.d {
        public c() {
        }

        @Override // com.chinavisionary.core.app.base.CoreBaseFragment.d
        public void updatePosition(int i2, int i3) {
            RoomMainFragment.this.t.setFirstLastPosition(i2, i3);
        }
    }

    public static /* synthetic */ void g2(RoomModelVo.ModulesBean modulesBean) {
        try {
            c.e.c.p.b.getInstance().insertCacheVo(CacheVo.ROOM_BANNER_CACHE_KEY, JSON.toJSONString(modulesBean, SerializerFeature.DisableCircularReferenceDetect));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static RoomMainFragment getInstance(int i2) {
        RoomMainFragment roomMainFragment = new RoomMainFragment();
        roomMainFragment.setType(i2);
        return roomMainFragment;
    }

    public static /* synthetic */ void h2(NewResponseRowsVo newResponseRowsVo) {
        try {
            c.e.c.p.b.getInstance().insertCacheVo(CacheVo.CITY_CACHE_KEY, JSON.toJSONString(newResponseRowsVo.getRows(), SerializerFeature.DisableCircularReferenceDetect));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static /* synthetic */ void i2(List list) {
        try {
            c.e.c.p.b.getInstance().insertCacheVo(CacheVo.PROJECT_CACHE_KEY, JSON.toJSONString(list, SerializerFeature.DisableCircularReferenceDetect));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static /* synthetic */ void j2(List list) {
        try {
            c.e.c.p.b.getInstance().insertCacheVo(CacheVo.ROOM_CACHE_KEY, JSON.toJSONString(list, SerializerFeature.DisableCircularReferenceDetect));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: k2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void l2(View view, int i2) {
        if (i2 >= 0) {
            RoomModelVo.ModulesBean modulesBean = (RoomModelVo.ModulesBean) this.t.getList().get(i2);
            if (modulesBean.getModuleType() == 7) {
                O1();
                return;
            }
            ModelProductVo modelProductVo = modulesBean.getModelProductVo();
            if ((!modulesBean.isHasLink() && modelProductVo == null) || modelProductVo == null || modelProductVo.getParam() == null) {
                return;
            }
            c1(Integer.valueOf(modelProductVo.getType()), modelProductVo.getParam().getKey(), null);
            j1(modelProductVo.getParam().getCommodityTitle());
        }
    }

    public final ProjectVo A2(List<ProjectVo> list) {
        ProjectVo projectVo = (ProjectVo) o.getFirstElement(list);
        if (projectVo != null) {
            this.I = projectVo.getProjectKey();
            v2(projectVo);
        }
        return projectVo;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    /*  JADX ERROR: JadxRuntimeException in pass: FinishTypeInference
        jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r4v2 boolean
        	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:236)
        	at jadx.core.dex.visitors.typeinference.FinishTypeInference.lambda$visit$0(FinishTypeInference.java:27)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.typeinference.FinishTypeInference.visit(FinishTypeInference.java:22)
        */
    public final synchronized void B2(com.chinavisionary.microtang.main.vo.RoomModelVo.ModulesBean r4) {
        /*
            r3 = this;
            monitor-enter(r3)
            com.chinavisionary.core.app.adapter.BaseRecyclerAdapter<T> r0 = r3.t     // Catch: java.lang.Throwable -> L34
            java.util.List r0 = r0.getList()     // Catch: java.lang.Throwable -> L34
            boolean r1 = c.e.a.d.o.isNotEmpty(r0)     // Catch: java.lang.Throwable -> L34
            if (r1 == 0) goto L32
            if (r4 == 0) goto L32
            java.lang.Integer r1 = r3.I1()     // Catch: java.lang.Throwable -> L34
            if (r1 != 0) goto L32
            r1 = 0
            java.lang.Object r0 = r0.get(r1)     // Catch: java.lang.Throwable -> L34
            com.chinavisionary.microtang.main.vo.RoomModelVo$ModulesBean r0 = (com.chinavisionary.microtang.main.vo.RoomModelVo.ModulesBean) r0     // Catch: java.lang.Throwable -> L34
            r2 = 1
            if (r0 == 0) goto L26
            int r0 = r0.getModuleType()     // Catch: java.lang.Throwable -> L34
            if (r0 != r2) goto L26
            r1 = 1
        L26:
            c.e.c.m0.c r0 = c.e.c.m0.c.getInstance()     // Catch: java.lang.Throwable -> L34
            r0.setShowEnterpriseMsg(r2)     // Catch: java.lang.Throwable -> L34
            com.chinavisionary.core.app.adapter.BaseRecyclerAdapter<T> r0 = r3.t     // Catch: java.lang.Throwable -> L34
            r0.addDataToList(r4, r1)     // Catch: java.lang.Throwable -> L34
        L32:
            monitor-exit(r3)
            return
        L34:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.chinavisionary.microtang.main.fragments.RoomMainFragment.B2(com.chinavisionary.microtang.main.vo.RoomModelVo$ModulesBean):void");
    }

    public final void C2() {
        this.D.getCityResult().observe(this, new Observer() { // from class: c.e.c.v.e.v
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f1921a.M1((NewResponseRowsVo) obj);
            }
        });
        this.D.getProjectResult().observe(this, new Observer() { // from class: c.e.c.v.e.a0
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f1897a.Q1((NewResponseRowsVo) obj);
            }
        });
        if (x.isNullStr(this.J)) {
            this.D.getCityList();
        }
    }

    public final void D2() {
        this.l = false;
        MainAdapter mainAdapter = new MainAdapter();
        this.t = mainAdapter;
        mainAdapter.setFragment(this);
        this.t.setDefaultLastPosition(4);
        this.t.setOnClickListener(this.y);
        this.t.setOnItemClickListener(this.T);
        this.v = new c();
    }

    public final void E2() {
        NewRoomModel newRoomModel = (NewRoomModel) h(NewRoomModel.class);
        this.D = newRoomModel;
        newRoomModel.getGroupResult().observe(this, new Observer() { // from class: c.e.c.v.e.t
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f1919a.R1((NewResponseRowsVo) obj);
            }
        });
        this.D.getErrRequestLiveData().observe(this, new Observer() { // from class: c.e.c.v.e.s
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f1918a.G2((RequestErrDto) obj);
            }
        });
        if (c.e.a.a.a.getInstance().isNewVersionModel()) {
            z1();
        }
        if (c.e.a.a.a.getInstance().isH5Model()) {
            NewUserModel newUserModel = (NewUserModel) h(NewUserModel.class);
            this.N = newUserModel;
            newUserModel.getSecretKeyResult().observe(this, new Observer() { // from class: c.e.c.v.e.x
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    this.f1923a.S1((SecretKeyBo) obj);
                }
            });
            this.N.getEnterpriseResult().observe(this, new Observer() { // from class: c.e.c.v.e.u
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    this.f1920a.P1((ResponseEnterpriseNotifyBo) obj);
                }
            });
            this.N.getEnterpriseAuthStateResult().observe(this, new Observer() { // from class: c.e.c.v.e.z
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    this.f1925a.N1((ResponseEnterpriseAuthStateBo) obj);
                }
            });
            this.N.getErrRequestLiveData().observe(this, new Observer() { // from class: c.e.c.v.e.d0
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    this.f1903a.T1((RequestErrDto) obj);
                }
            });
        }
        C2();
    }

    public final void F2() {
        d(ProjectListFragment.getInstance(this.I), R.id.constraint_main_content);
    }

    public final void G2(RequestErrDto requestErrDto) {
        H();
        if (requestErrDto != null) {
            B();
            C(requestErrDto);
        }
        this.mBaseSwipeRefreshLayout.setRefreshing(false);
    }

    public final void H1() {
        Integer numI1 = I1();
        if (numI1 != null) {
            this.t.getList().remove(numI1.intValue());
            this.t.notifyDataSetChanged();
        }
        this.R = null;
        c.e.c.m0.c.getInstance().setShowEnterpriseMsg(false);
    }

    public final void H2(int i2) {
        if (this.I != null) {
            List<RepairLeftVo> list = this.M.getList();
            if (o.isNotEmpty(list)) {
                for (RepairLeftVo repairLeftVo : list) {
                    if (repairLeftVo != null) {
                        repairLeftVo.setSelect(false);
                    }
                }
            }
        }
        RepairLeftVo repairLeftVo2 = this.M.getList().get(i2);
        this.I = repairLeftVo2.getKey();
        this.mProjectNameTv.setText(repairLeftVo2.getTitle());
        this.M.getList().get(i2).setSelect(true);
        this.M.notifyDataSetChanged();
    }

    public final Integer I1() {
        List list = this.t.getList();
        Integer numValueOf = null;
        if (o.isNotEmpty(list)) {
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                RoomModelVo.ModulesBean modulesBean = (RoomModelVo.ModulesBean) list.get(i2);
                if (modulesBean != null && modulesBean.getModuleType() == 7) {
                    numValueOf = Integer.valueOf(i2);
                }
            }
        }
        return numValueOf;
    }

    public final void J1() {
        ResponseEnterpriseNotifyBo responseEnterpriseNotifyBo = this.S;
        if (responseEnterpriseNotifyBo == null || !x.isNotNull(responseEnterpriseNotifyBo.getAuthEnterpriseKey())) {
            return;
        }
        RequestEnterpriseAuthStateBo requestEnterpriseAuthStateBo = new RequestEnterpriseAuthStateBo();
        requestEnterpriseAuthStateBo.setAuthEnterpriseKey(this.S.getAuthEnterpriseKey());
        this.N.getEnterpriseAuthState(requestEnterpriseAuthStateBo);
    }

    public final View K1() {
        View viewInflate = getLayoutInflater().inflate(R.layout.project_popup_layout, (ViewGroup) null, false);
        this.L = (BaseRecyclerView) viewInflate.findViewById(R.id.recycler_project);
        RepairLeftAdapter repairLeftAdapter = new RepairLeftAdapter();
        this.M = repairLeftAdapter;
        repairLeftAdapter.setOnItemClickListener(new b());
        this.L.setAdapter(this.M);
        return viewInflate;
    }

    public final Intent L1(String str) {
        Intent intent = new Intent(this.f6486d, (Class<?>) BridgeWebViewActivity.class);
        intent.setFlags(268435456);
        intent.putExtra("key", str);
        intent.putExtra("is_finish_send_event", true);
        return intent;
    }

    public final void M1(final NewResponseRowsVo<CityItemVo> newResponseRowsVo) {
        if (newResponseRowsVo == null || !o.isNotEmpty(newResponseRowsVo.getRows())) {
            return;
        }
        new Thread(new Runnable() { // from class: c.e.c.v.e.w
            @Override // java.lang.Runnable
            public final void run() {
                RoomMainFragment.h2(newResponseRowsVo);
            }
        }).start();
        CityItemVo cityItemVo = newResponseRowsVo.getRows().get(0);
        this.J = cityItemVo.getKey();
        y2(cityItemVo.getCityName());
        x1(cityItemVo);
        this.D.getProjectList(this.J);
    }

    public final void N1(ResponseEnterpriseAuthStateBo responseEnterpriseAuthStateBo) {
        H();
        if (responseEnterpriseAuthStateBo != null) {
            if (responseEnterpriseAuthStateBo.getHaveAuth() == null || !responseEnterpriseAuthStateBo.getHaveAuth().booleanValue()) {
                B1(x.getString(R.string.tip_enterprise_certificate_msg), x.getString(R.string.big_tip_msg));
            } else {
                q2();
            }
        }
    }

    public final void O1() {
        ResponseEnterpriseNotifyBo responseEnterpriseNotifyBo = this.S;
        if (responseEnterpriseNotifyBo != null) {
            if (responseEnterpriseNotifyBo.getNeedAuth() != null && !this.S.getNeedAuth().booleanValue()) {
                q2();
            } else {
                z0(R.string.loading_text);
                J1();
            }
        }
    }

    public final void P1(ResponseEnterpriseNotifyBo responseEnterpriseNotifyBo) {
        this.S = responseEnterpriseNotifyBo;
        if (responseEnterpriseNotifyBo == null || !x.isNotNull(responseEnterpriseNotifyBo.getJumpUrl()) || !x.isNotNull(responseEnterpriseNotifyBo.getContent()) || !x.isNotNull(responseEnterpriseNotifyBo.getAuthEnterpriseKey())) {
            H1();
            return;
        }
        RoomModelVo.ModulesBean modulesBean = new RoomModelVo.ModulesBean();
        this.R = modulesBean;
        modulesBean.setModuleType(7);
        this.R.setModuleTitle(responseEnterpriseNotifyBo.getContent());
        B2(this.R);
    }

    public final void Q1(NewResponseRowsVo<ProjectVo> newResponseRowsVo) {
        ProjectVo selectProjectVo;
        if (newResponseRowsVo != null) {
            final List<ProjectVo> rows = newResponseRowsVo.getRows();
            if (o.isNotEmpty(rows)) {
                new Thread(new Runnable() { // from class: c.e.c.v.e.y
                    @Override // java.lang.Runnable
                    public final void run() {
                        RoomMainFragment.i2(rows);
                    }
                }).start();
                this.H = rows.size() > 1;
                String str = this.I;
                ProjectVo projectVoA2 = (str == null || (selectProjectVo = this.E.getSelectProjectVo(rows, str)) == null) ? A2(rows) : selectProjectVo;
                Y1(projectVoA2);
                x2(x.getNotNullStr(projectVoA2.getProjectName(), ""));
                this.E.saveSelectProject(projectVoA2);
            }
        }
    }

    public final void R1(NewResponseRowsVo<ResponseGroupResultVo> newResponseRowsVo) {
        c.e.a.a.i.b.getInstance().setCityName(this.mCityValueTv.getText().toString());
        c.e.a.a.i.b.getInstance().setProjectName(this.mProjectNameTv.getText().toString());
        final List<RoomModelVo.ModulesBean> adapterData = this.E.getAdapterData(newResponseRowsVo);
        new Thread(new Runnable() { // from class: c.e.c.v.e.c0
            @Override // java.lang.Runnable
            public final void run() {
                RoomMainFragment.j2(adapterData);
            }
        }).start();
        D(adapterData);
        this.P = true;
        w2();
        G2(null);
        this.r.scrollToPosition(0);
    }

    public final void S1(SecretKeyBo secretKeyBo) {
        u2();
        if (x.isNotNull(this.I)) {
            r2();
        } else {
            I1();
        }
    }

    public final void T1(RequestErrDto requestErrDto) {
        H();
        if (requestErrDto.getUrl().contains("vtapp/v1/user/enterprise/check/auth/enterprise")) {
            G0(requestErrDto.getErrMsg());
        }
    }

    @Override // com.chinavisionary.microtang.base.BaseFragment
    public void U0(final RoomModelVo.ModulesBean modulesBean) {
        this.Q = modulesBean;
        new Thread(new Runnable() { // from class: c.e.c.v.e.r
            @Override // java.lang.Runnable
            public final void run() {
                RoomMainFragment.g2(modulesBean);
            }
        }).start();
        w2();
    }

    public final void U1(View view) {
        EditBannerView.BannerDto bannerDto = (EditBannerView.BannerDto) view.getTag(R.id.edt_banner_view_img_path_id);
        if (x.isNotNull(bannerDto.getTitle())) {
            String title = bannerDto.getTitle();
            String dataKey = bannerDto.getDataKey();
            if (x.isNotNull(bannerDto.getTargetAppid())) {
                int i2 = 15;
                if (x.isNotNull(bannerDto.getTargetMiniType()) && FundNewsVo.TYPE_ALIPAY.equals(bannerDto.getTargetMiniType())) {
                    i2 = 18;
                }
                super.c1(Integer.valueOf(i2), bannerDto.getTargetAppid(), bannerDto.getTargetPath());
            } else {
                super.c1(Integer.valueOf(bannerDto.getDataType()), dataKey, title);
            }
            V0(title);
            u1(bannerDto.getBaseKey());
        }
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void V(View view) {
        if (view.getId() == R.id.img_banner_pic) {
            U1(view);
        } else if (view.getId() == R.id.tv_city) {
            F2();
        } else if (view.getId() == R.id.tv_alert_confirm) {
            p2();
        }
    }

    public final void V1() {
        this.f6485c = getClass().getSimpleName();
        this.E = new h0();
        this.I = R0();
        this.J = N0();
        x2(S0());
        y2(O0());
        h0(this);
        this.mProjectNameTv.setOnClickListener(this.y);
        this.r = this.mBaseSwipeRefreshLayout.getBaseRecyclerView();
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void W() {
        V1();
        X1();
        E2();
        D2();
        W1();
    }

    public final void W1() {
        List<RoomModelVo.ModulesBean> modulesBeans = f0.getInstance().getModulesBeans();
        if (modulesBeans == null || modulesBeans.isEmpty()) {
            D(o2());
            this.B = 0L;
            this.f6483a = 1;
            I1();
            q.d(getClass().getSimpleName(), "initCacheDataOrGetNewData requestData");
        } else {
            this.B = System.currentTimeMillis();
            D(modulesBeans);
            f0.getInstance().setModulesBeans(null);
            q.d(getClass().getSimpleName(), "initCacheDataOrGetNewData list = " + modulesBeans.size());
            r2();
            this.f6483a = this.f6483a + 1;
        }
        n2();
    }

    public final void X1() {
        if (this.K == null) {
            PopupWindow popupWindow = new PopupWindow(this.f6486d);
            this.K = popupWindow;
            popupWindow.setOnDismissListener(new a());
            int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.dp_200);
            this.K.setWidth(dimensionPixelSize);
            this.K.setHeight(dimensionPixelSize);
            this.K.setContentView(K1());
        }
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void Y(int i2, int i3) {
        super.Y(i2, i3);
        int i4 = this.C + i3;
        this.C = i4;
        if (i4 < 20 && this.mBgView.getVisibility() != 4) {
            this.mBgView.setVisibility(4);
        }
        int i5 = this.C;
        if (i5 > 50 && i5 < 400 && this.mBgView.getVisibility() != 0) {
            this.mBgView.setVisibility(0);
        }
        q.d(this.f6485c, "onStartRecyclerScroll down dy = " + this.C + ", abs = " + Math.abs(this.C));
    }

    public final void Y1(ProjectVo projectVo) {
        boolean zIsNullStr = x.isNullStr(this.I);
        String projectKey = projectVo.getProjectKey();
        this.I = projectKey;
        if (x.isNotNull(projectKey) && zIsNullStr && x.isNotNull(c.e.a.a.b.getInstance().getToken())) {
            r2();
        }
    }

    @m(threadMode = r.BACKGROUND)
    public void eventReloadEnterpriseAuth(EventReloadEnterpriseAuth eventReloadEnterpriseAuth) {
        q.d(this.f6485c, "eventReloadEnterpriseAuth");
        if (eventReloadEnterpriseAuth != null) {
            J1();
        }
    }

    @m(threadMode = r.BACKGROUND)
    public void eventReloadEnterpriseNotify(EventReloadEnterpriseNotify eventReloadEnterpriseNotify) {
        q.d(this.f6485c, "eventReloadEnterpriseNotify");
        if (eventReloadEnterpriseNotify != null) {
            s2();
        }
    }

    @m(threadMode = r.BACKGROUND)
    public void eventUpdateAlertMessage(EventUpdateUserAlertMessage eventUpdateUserAlertMessage) {
        q.d(this.f6485c, "eventUpdateAlertMessage");
        if (eventUpdateUserAlertMessage != null) {
            s2();
        }
    }

    @m(threadMode = r.MAIN)
    public void eventUpdateCity(EventUpdateCity eventUpdateCity) {
        this.J = eventUpdateCity.getKey();
    }

    @m(threadMode = r.BACKGROUND)
    public void eventUserSimpleDto(UserSimpleDto userSimpleDto) {
        q.d(this.f6485c, "eventUserSimpleDto");
        if (userSimpleDto == null || !x.isNullStr(userSimpleDto.getNickname()) || O()) {
            return;
        }
        H1();
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public int getLayoutId() {
        return R.layout.fragment_new_main;
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    /* JADX INFO: renamed from: j0 */
    public void I1() {
        this.C = 0;
        if (this.f6485c != null) {
            if (this.f6483a == 1) {
                this.B = 0L;
                if (x.isNullStr(this.J)) {
                    this.D.getCityList();
                } else {
                    q.d(this.f6485c, "requestData mProjectKey = " + this.I);
                    if (this.I == null) {
                        this.D.getProjectList(this.J);
                    }
                }
            }
            if (x.isNotNull(this.I)) {
                boolean z = System.currentTimeMillis() - this.B > 2000;
                q.d(this.f6485c, "requestData interval = " + z);
                if (z) {
                    this.B = System.currentTimeMillis();
                    this.D.getGroupList(this.I, this.f6485c + "-requestData");
                }
            } else {
                this.B = 0L;
            }
            t2();
            s2();
            r2();
        }
        q.d(this.f6485c, "requestData protected");
    }

    @OnClick({R.id.rlayout_notify})
    public void msgClickView(View view) {
        if (N()) {
            d0(MsgActivity.class);
        }
    }

    public final void n2() {
        try {
            CacheVo cacheVo = c.e.c.p.b.getInstance().getCacheVo(CacheVo.ROOM_BANNER_CACHE_KEY);
            if (cacheVo != null) {
                String cacheValue = cacheVo.getCacheValue();
                if (x.isNotNull(cacheValue)) {
                    this.P = true;
                    q.d(this.f6485c, "cacheValue = " + cacheValue);
                    this.Q = (RoomModelVo.ModulesBean) JSON.parseObject(cacheValue, RoomModelVo.ModulesBean.class);
                    w2();
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final List<RoomModelVo.ModulesBean> o2() {
        try {
            CacheVo cacheVo = c.e.c.p.b.getInstance().getCacheVo(CacheVo.ROOM_CACHE_KEY);
            if (cacheVo == null) {
                return null;
            }
            String cacheValue = cacheVo.getCacheValue();
            if (x.isNotNull(cacheValue)) {
                return JSON.parseArray(cacheValue, RoomModelVo.ModulesBean.class);
            }
            return null;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        L0(this);
    }

    @OnClick({R.id.rlayout_scan})
    public void openScan(View view) {
        q.d(getClass().getCanonicalName(), "open scan");
        d0(ScanCodeActivity.class);
    }

    @OnClick({R.id.edt_input_search})
    public void openSearchRoomClick(View view) {
        d0(SearchRoomActivity.class);
    }

    public final void p2() {
        startActivity(L1(c.e.c.r.a.getEnterpriseCertificate()));
    }

    public final void q2() {
        startActivity(L1(c.e.c.r.a.getH5Url(this.S.getJumpUrl())));
    }

    public final void r2() {
        if (x.isNotNull(this.I) && x.isNotNull(c.e.a.a.b.getInstance().getToken())) {
            this.P = false;
            this.Q = null;
            v1(RequestBannerParamBo.GET_MAIN_BANNER_TYPE);
        }
    }

    @m(sticky = true, threadMode = r.MAIN)
    public void registerEventBadgeMsg(EventBadgeMsgVo eventBadgeMsgVo) {
        e.setupBadge(eventBadgeMsgVo, this.mBadgeValueTv, this.mBadgePaintTv);
    }

    @m(threadMode = r.BACKGROUND)
    public void registerEventOssUpdateSuccess(EventOssUpdateSuccess eventOssUpdateSuccess) {
        q.d(this.f6485c, "registerEventOssUpdateSuccess");
    }

    @m(threadMode = r.MAIN)
    public void registerEventUpdateProject(EventUpdateProject eventUpdateProject) {
        this.I = eventUpdateProject.getKey();
        x2(eventUpdateProject.getTitle());
        this.f6483a = 1;
        I1();
        q.d(this.f6485c, "registerEventUpdateProject");
    }

    @m
    public void registerEventUpdateToken(EventUpdateToken eventUpdateToken) {
        if (this.N == null || v.getInstance().isRepeatedlyAction("registerEventUpdateToken")) {
            return;
        }
        this.N.getPublicKeyAndToken();
    }

    @m(threadMode = r.MAIN)
    public void registerNetworkConnectEvent(c.e.c.v.b.a aVar) {
        this.f6483a = 1;
        I1();
        q.d(this.f6485c, "registerNetworkConnectEvent");
    }

    public final void s2() {
        if (O()) {
            this.N.getEnterpriseNotify();
        }
    }

    @OnClick({R.id.rlayout_server})
    public void serverClick(View view) {
        if (c.e.a.a.a.getInstance().isIMModel()) {
            d0(CustomerServiceActivity.class);
        } else if (N()) {
            d0(CustomerServiceActivity.class);
        }
    }

    public void setIMainBannerCallback(c.e.c.v.c.a aVar) {
        this.F = aVar;
    }

    public final void setType(int i2) {
        this.G = i2;
    }

    public final void t2() {
        if (this.N == null || !x.isNullStr(c.e.a.a.b.getInstance().getToken())) {
            return;
        }
        q.d(this.f6485c, "refreshGetToken");
        this.N.getPublicKeyAndToken();
    }

    public final void u2() {
        if (this.O) {
            this.O = false;
            EventUpdateAliYunOss eventUpdateAliYunOss = new EventUpdateAliYunOss();
            eventUpdateAliYunOss.setMethodName(getClass().getCanonicalName() + "-sendUpdateAliYunOss");
            k(eventUpdateAliYunOss);
        }
    }

    public final void v2(ProjectVo projectVo) {
        if (projectVo != null) {
            EventUpdateProject eventUpdateProject = new EventUpdateProject();
            eventUpdateProject.setKey(projectVo.getProjectKey());
            eventUpdateProject.setTitle(projectVo.getProjectName());
            l(eventUpdateProject);
        }
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    public final void w2() {
        if (this.P && this.Q != null) {
            this.P = false;
            z2(this.Q.getBannerDtoList());
            this.t.addDataToList((T) this.Q, 0);
        }
        B2(this.R);
    }

    public final void x2(String str) {
        this.E.updateCityTv(this.mProjectNameTv, str);
    }

    public final void y2(String str) {
        this.mCityValueTv.setText(str);
    }

    public final void z2(List<EditBannerView.BannerDto> list) {
        if (list == null || list.size() != 0) {
            return;
        }
        EditBannerView.BannerDto bannerDto = new EditBannerView.BannerDto();
        ResourceVo resourceVo = new ResourceVo();
        String roomDefaultBannerUrl = c.e.c.x.c.a.getInstance().getRoomDefaultBannerUrl();
        if (x.isNullStr(roomDefaultBannerUrl)) {
            roomDefaultBannerUrl = String.valueOf(R.mipmap.ic_default_room_banner);
        }
        resourceVo.setUrl(roomDefaultBannerUrl);
        resourceVo.setSampleUrl(roomDefaultBannerUrl);
        bannerDto.setCover(resourceVo);
        bannerDto.setPicFitXy(false);
        bannerDto.setBaseKey("setupDefaultBanner");
        bannerDto.setKey("setupDefaultBanner");
        list.add(bannerDto);
    }
}
