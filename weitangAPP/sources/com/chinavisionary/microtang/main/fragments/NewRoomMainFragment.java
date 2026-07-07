package com.chinavisionary.microtang.main.fragments;

import android.content.res.Resources;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.GridLayoutManager;
import butterknife.BindView;
import butterknife.OnClick;
import c.e.a.d.o;
import c.e.a.d.q;
import c.e.a.d.w;
import c.e.a.d.x;
import c.e.c.v.f.f0;
import c.e.c.v.f.h0;
import com.chinavisionary.core.app.adapter.BaseRecyclerAdapter;
import com.chinavisionary.core.app.base.CoreBaseFragment;
import com.chinavisionary.core.app.net.base.dto.PageBo;
import com.chinavisionary.core.app.net.base.dto.RequestErrDto;
import com.chinavisionary.core.scan.view.ScanCodeActivity;
import com.chinavisionary.core.weight.BaseRecyclerView;
import com.chinavisionary.core.weight.BaseSwipeRefreshLayout;
import com.chinavisionary.core.weight.banner.EditBannerView;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.base.BaseFragment;
import com.chinavisionary.microtang.main.adapter.NewRoomMainAdapter;
import com.chinavisionary.microtang.main.event.EventUpdateProject;
import com.chinavisionary.microtang.main.model.RoomModel;
import com.chinavisionary.microtang.main.vo.ModelProductVo;
import com.chinavisionary.microtang.main.vo.RoomModelVo;
import com.chinavisionary.microtang.me.adapter.RoomGridSpecItemDecoration;
import com.chinavisionary.microtang.msg.MsgActivity;
import com.chinavisionary.microtang.room.SearchRoomActivity;
import com.chinavisionary.microtang.service.CustomerServiceActivity;
import g.b.a.m;
import g.b.a.r;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class NewRoomMainFragment extends BaseFragment<RoomModelVo.ModulesBean> {
    public RoomModel B;
    public h0 C;
    public c.e.c.v.c.a D;
    public int E;
    public String F;
    public c.e.a.a.c.c.a G = new c.e.a.a.c.c.a() { // from class: c.e.c.v.e.i
        @Override // c.e.a.a.c.c.a
        public final void onItemClickListener(View view, int i2) {
            this.f1908a.M1(view, i2);
        }
    };

    @BindView(R.id.swipe_refresh_layout_main)
    public BaseSwipeRefreshLayout mBaseSwipeRefreshLayout;

    @BindView(R.id.tv_city)
    public TextView mCityTv;

    @BindView(R.id.rlayout_title)
    public RelativeLayout mTitleRelativeLayout;

    public class a implements CoreBaseFragment.d {
        public a() {
        }

        @Override // com.chinavisionary.core.app.base.CoreBaseFragment.d
        public void updatePosition(int i2, int i3) {
            NewRoomMainFragment.this.t.setFirstLastPosition(i2, i3);
        }
    }

    public class b extends GridLayoutManager.SpanSizeLookup {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BaseRecyclerView f7418a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ BaseRecyclerAdapter f7419b;

        public b(BaseRecyclerView baseRecyclerView, BaseRecyclerAdapter baseRecyclerAdapter) {
            this.f7418a = baseRecyclerView;
            this.f7419b = baseRecyclerAdapter;
        }

        @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
        public int getSpanSize(int i2) {
            return ((i2 == this.f7418a.getAdapter().getItemCount() - 1 && this.f7419b.isShowFooterView()) || this.f7419b.getItemViewType(i2) == 26214 || this.f7419b.getItemViewType(i2) == 2 || this.f7419b.getItemViewType(i2) == 34952 || this.f7419b.getItemViewType(i2) == 39321 || this.f7419b.getItemViewType(i2) == 1 || i2 == 0) ? 2 : 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: L1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void M1(View view, int i2) {
        RoomModelVo.ModulesBean modulesBean = (RoomModelVo.ModulesBean) this.t.getList().get(i2);
        ModelProductVo modelProductVo = modulesBean.getModelProductVo();
        if ((!modulesBean.isHasLink() && modelProductVo == null) || modelProductVo == null || modelProductVo.getParam() == null) {
            return;
        }
        c1(Integer.valueOf(modelProductVo.getType()), modelProductVo.getParam().getKey(), null);
        j1(modelProductVo.getParam().getCommodityTitle());
    }

    public static NewRoomMainFragment getInstance(int i2) {
        NewRoomMainFragment newRoomMainFragment = new NewRoomMainFragment();
        newRoomMainFragment.setType(i2);
        return newRoomMainFragment;
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
    public final PageBo F1() {
        return this.C.getPageBoAndSetLastModuleKey(r(), this.t);
    }

    public final void G1(View view) {
        EditBannerView.BannerDto bannerDto = (EditBannerView.BannerDto) view.getTag(R.id.edt_banner_view_img_path_id);
        if (x.isNotNull(bannerDto.getTitle())) {
            String title = bannerDto.getTitle();
            String dataKey = bannerDto.getDataKey();
            if (x.isNotNull(bannerDto.getTargetAppid())) {
                c1(15, bannerDto.getTargetAppid(), bannerDto.getTargetPath());
            } else {
                c1(Integer.valueOf(bannerDto.getDataType()), dataKey, title);
            }
            V0(title);
        }
    }

    public final void H1() {
        h0(this);
        this.F = w.getInstance().getString("selectProjectKey", null);
        this.C = new h0();
        this.r = this.mBaseSwipeRefreshLayout.getBaseRecyclerView();
    }

    public final void I1() {
        List<RoomModelVo.ModulesBean> modulesBeans = f0.getInstance().getModulesBeans();
        if (modulesBeans == null || modulesBeans.isEmpty()) {
            this.f6483a = 1;
            j0();
            q.d(getClass().getSimpleName(), "initCacheDataOrGetNewData requestData");
            return;
        }
        R1(modulesBeans);
        q.d(getClass().getSimpleName(), "initCacheDataOrGetNewData list = " + modulesBeans.size());
        f0.getInstance().setModulesBeans(null);
        this.f6483a = this.f6483a + 1;
    }

    public void N1(BaseRecyclerAdapter baseRecyclerAdapter, BaseRecyclerView baseRecyclerView, int i2) {
        if (baseRecyclerView.getItemDecorationCount() > 0) {
            baseRecyclerView.removeItemDecorationAt(0);
        }
        Resources resources = baseRecyclerView.getResources();
        RoomGridSpecItemDecoration roomGridSpecItemDecoration = new RoomGridSpecItemDecoration(2, resources.getDimensionPixelSize(R.dimen.dp_10), resources.getDimensionPixelSize(R.dimen.dp_6));
        roomGridSpecItemDecoration.setSkipPosition(i2);
        roomGridSpecItemDecoration.setOtherPosition(baseRecyclerAdapter.getItemCount() - 1);
        roomGridSpecItemDecoration.setDivider(resources.getDrawable(R.drawable.bg_me_recycler_item_line));
        baseRecyclerView.addItemDecoration(roomGridSpecItemDecoration);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void O1() {
        NewRoomMainAdapter newRoomMainAdapter = new NewRoomMainAdapter();
        this.t = newRoomMainAdapter;
        newRoomMainAdapter.setFragment(this);
        N1(this.t, this.r, 1);
        setupGridLayoutManager(this.t, this.r);
        this.t.setDefaultLastPosition(4);
        this.t.setOnClickListener(this.y);
        this.t.setOnItemClickListener(this.G);
        this.v = new a();
    }

    public final void P1() {
        RoomModel roomModel = (RoomModel) h(RoomModel.class);
        this.B = roomModel;
        roomModel.getRoomModelResult().observe(this, new Observer() { // from class: c.e.c.v.e.g
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f1906a.Q1((RoomModelVo) obj);
            }
        });
        this.B.getErrRequestLiveData().observe(this, new Observer() { // from class: c.e.c.v.e.h
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f1907a.T1((RequestErrDto) obj);
            }
        });
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
    public final void Q1(RoomModelVo roomModelVo) {
        if (roomModelVo != null) {
            R1(this.C.getAdapterDataToRoomModel(roomModelVo, this.f6483a, this.t));
        }
        T1(null);
    }

    public final void R1(List<RoomModelVo.ModulesBean> list) {
        String simpleName = getClass().getSimpleName();
        StringBuilder sb = new StringBuilder();
        sb.append("setupRoomModelVo page= ");
        sb.append(this.f6483a);
        sb.append(", is not empty = ");
        sb.append(o.isNotEmpty(list));
        sb.append(", is null ==");
        sb.append(this.D != null);
        q.d(simpleName, sb.toString());
        if (1 == this.f6483a && this.D != null && o.isNotEmpty(list)) {
            RoomModelVo.ModulesBean modulesBean = (RoomModelVo.ModulesBean) o.getFirstElement(list);
            if (modulesBean != null && modulesBean.getModuleType() == 1) {
                this.D.setupMainBanner(modulesBean);
                list.remove(0);
            }
        } else {
            q.d(getClass().getSimpleName(), "setupRoomModelVo page= " + this.f6483a);
        }
        D(list);
    }

    public final void S1() {
        d(ProjectListFragment.getInstance(this.F), R.id.constraint_main_content);
    }

    public final void T1(RequestErrDto requestErrDto) {
        H();
        if (requestErrDto != null) {
            B();
            C(requestErrDto);
        }
        this.mBaseSwipeRefreshLayout.setRefreshing(false);
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void V(View view) {
        if (view.getId() == R.id.img_banner_pic) {
            G1(view);
        } else if (view.getId() == R.id.tv_city) {
            S1();
        }
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void W() {
        H1();
        P1();
        O1();
        I1();
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public int getLayoutId() {
        return R.layout.fragment_new_room_main;
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void j0() {
        this.B.getRoomModel(F1(), this.F);
    }

    @OnClick({R.id.rlayout_notify})
    public void msgClickView(View view) {
        if (N()) {
            d0(MsgActivity.class);
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

    @m(threadMode = r.MAIN)
    public void registerEventUpdateProject(EventUpdateProject eventUpdateProject) {
        this.F = eventUpdateProject.getKey();
        this.mCityTv.setText(eventUpdateProject.getTitle());
    }

    @m(threadMode = r.MAIN)
    public void registerNetworkConnectEvent(c.e.c.v.b.a aVar) {
        this.f6483a = 1;
        j0();
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
        this.D = aVar;
    }

    public final void setType(int i2) {
        this.E = i2;
    }

    public void setupGridLayoutManager(BaseRecyclerAdapter<RoomModelVo.ModulesBean> baseRecyclerAdapter, BaseRecyclerView baseRecyclerView) {
        if (baseRecyclerView == null || baseRecyclerAdapter == null) {
            return;
        }
        GridLayoutManager gridLayoutManager = new GridLayoutManager(baseRecyclerView.getContext(), 2);
        gridLayoutManager.setSpanSizeLookup(new b(baseRecyclerView, baseRecyclerAdapter));
        baseRecyclerView.setLayoutManager(gridLayoutManager);
    }
}
