package com.chinavisionary.microtang.main.fragments;

import android.view.View;
import android.widget.TextView;
import androidx.lifecycle.Observer;
import butterknife.BindView;
import butterknife.OnClick;
import c.e.a.d.o;
import c.e.a.d.w;
import c.e.a.d.x;
import c.e.c.v.f.g0;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.chinavisionary.core.app.base.CoreBaseFragment;
import com.chinavisionary.core.app.net.base.dto.NewResponseRowsVo;
import com.chinavisionary.core.app.net.base.dto.RequestErrDto;
import com.chinavisionary.core.weight.BaseRecyclerView;
import com.chinavisionary.core.weight.BaseSwipeRefreshLayout;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.base.BaseFragment;
import com.chinavisionary.microtang.db.vo.CacheVo;
import com.chinavisionary.microtang.main.adapter.CityAdapter;
import com.chinavisionary.microtang.main.adapter.ProjectAdapter;
import com.chinavisionary.microtang.main.bo.ProjectVo;
import com.chinavisionary.microtang.main.event.EventUpdateCity;
import com.chinavisionary.microtang.main.event.EventUpdateProject;
import com.chinavisionary.microtang.main.fragments.ProjectListFragment;
import com.chinavisionary.microtang.main.model.NewRoomModel;
import com.chinavisionary.microtang.main.vo.CityItemVo;
import com.chinavisionary.microtang.repair.adapter.RepairLeftAdapter;
import com.chinavisionary.microtang.repair.vo.RepairLeftVo;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ProjectListFragment extends BaseFragment<RepairLeftVo> {
    public BaseRecyclerView B;
    public CityAdapter C;
    public c.e.c.v.d.a D;
    public g0 E;
    public CityItemVo F;
    public CityItemVo G;
    public String H;
    public NewRoomModel J;
    public String K;

    @BindView(R.id.swipe_refresh_layout_city)
    public BaseSwipeRefreshLayout mCitySwipeRefreshLayout;

    @BindView(R.id.tv_select_project_name)
    public TextView mSelectProjectNameTv;

    @BindView(R.id.swipe_refresh_layout_project)
    public BaseSwipeRefreshLayout mSwipeRefreshLayout;

    @BindView(R.id.view_title_bg)
    public View mTitleBgView;

    @BindView(R.id.tv_title)
    public TextView mTitleTv;
    public List<String> I = new ArrayList();
    public final BaseRecyclerView.f L = new a();
    public final c.e.a.a.c.c.a M = new b();
    public final c.e.a.a.c.c.a N = new c();

    public class a implements BaseRecyclerView.f {
        public a() {
        }

        @Override // com.chinavisionary.core.weight.BaseRecyclerView.f
        public void onLoadFirstAndLastPosition(int i2, int i3) {
        }

        @Override // com.chinavisionary.core.weight.BaseRecyclerView.f
        public void onLoadMore() {
        }

        @Override // com.chinavisionary.core.weight.BaseRecyclerView.f
        public void onRefresh() {
            ProjectListFragment.this.b2();
        }

        @Override // com.chinavisionary.core.weight.BaseRecyclerView.f
        public void onStartScroll() {
        }

        @Override // com.chinavisionary.core.weight.BaseRecyclerView.f
        public void onStartScroll(int i2, int i3) {
        }

        @Override // com.chinavisionary.core.weight.BaseRecyclerView.f
        public void onStopScroll() {
        }
    }

    public class b implements c.e.a.a.c.c.a {
        public b() {
        }

        @Override // c.e.a.a.c.c.a
        public void onItemClickListener(View view, int i2) {
            if (i2 >= 0) {
                ProjectListFragment.this.D.selectCurrentCity(i2, ProjectListFragment.this.C.getList());
                ProjectListFragment.this.C.notifyDataSetChanged();
                ProjectListFragment.this.c2(ProjectListFragment.this.C.getList().get(i2));
            }
        }
    }

    public class c implements c.e.a.a.c.c.a {
        public c() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void b() {
            ProjectListFragment.this.n();
        }

        @Override // c.e.a.a.c.c.a
        public void onItemClickListener(View view, int i2) {
            if (i2 >= 0) {
                ProjectListFragment.this.m2(i2);
                ProjectListFragment.this.O1();
                ProjectListFragment.this.u.postDelayed(new Runnable() { // from class: c.e.c.v.e.l
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f1911a.b();
                    }
                }, 300L);
            }
        }
    }

    public static /* synthetic */ void V1() {
        try {
            c.e.c.p.b.getInstance().insertCacheVo(CacheVo.ROOM_CACHE_KEY, null);
            c.e.c.p.b.getInstance().insertCacheVo(CacheVo.ROOM_BANNER_CACHE_KEY, null);
            c.e.c.p.b.getInstance().insertCacheVo(CacheVo.ACTIVITY_BANNER_CACHE_KEY, null);
            c.e.c.p.b.getInstance().insertCacheVo(CacheVo.LIFE_BANNER_CACHE_KEY, null);
            c.e.c.p.b.getInstance().insertCacheVo(CacheVo.WT_CLEAN_CACHE_KEY, null);
            c.e.c.p.b.getInstance().insertCacheVo(CacheVo.WT_LIEF_CACHE_KEY, null);
            c.e.c.p.b.getInstance().insertCacheVo(CacheVo.WT_FOOD_CACHE_KEY, null);
            c.e.c.p.b.getInstance().insertCacheVo(CacheVo.ME_BANNER_CACHE_KEY, null);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static /* synthetic */ void W1(List list) {
        try {
            c.e.c.p.b.getInstance().insertCacheVo(CacheVo.CITY_CACHE_KEY, JSON.toJSONString(list, SerializerFeature.DisableCircularReferenceDetect));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static /* synthetic */ void X1(List list) {
        try {
            c.e.c.p.b.getInstance().insertCacheVo(CacheVo.PROJECT_CACHE_KEY, JSON.toJSONString(list, SerializerFeature.DisableCircularReferenceDetect));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference incomplete: some casts might be missing */
    /* JADX INFO: renamed from: Y1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void Z1(NewResponseRowsVo newResponseRowsVo) {
        if (newResponseRowsVo != null) {
            final List<ProjectVo> rows = newResponseRowsVo.getRows();
            new Thread(new Runnable() { // from class: c.e.c.v.e.n
                @Override // java.lang.Runnable
                public final void run() {
                    ProjectListFragment.X1(rows);
                }
            }).start();
            List<RepairLeftVo> listA2 = a2(rows, this.f6484b);
            if (x.isNotNull(this.K) && this.K.equals(this.H)) {
                N1(listA2);
                this.t.initListData((List<T>) listA2);
                k2(listA2);
            }
            this.E.addProjectVoToMap(this.H, listA2);
        }
        P1();
    }

    public static ProjectListFragment getInstance(String str) {
        ProjectListFragment projectListFragment = new ProjectListFragment();
        projectListFragment.setArguments(CoreBaseFragment.q(str));
        return projectListFragment;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference incomplete: some casts might be missing */
    public final void M1() {
        if (this.f6483a == 1 && this.t.getList().isEmpty()) {
            RepairLeftVo repairLeftVo = new RepairLeftVo();
            repairLeftVo.setType(34952);
            this.t.addDataToList((T) repairLeftVo);
        }
    }

    public final void N1(List<RepairLeftVo> list) {
        if (!o.isNotEmpty(list) || list.get(0).getType() == 2) {
            return;
        }
        RepairLeftVo repairLeftVo = new RepairLeftVo();
        repairLeftVo.setType(2);
        list.add(0, repairLeftVo);
    }

    public final void O1() {
        new Thread(new Runnable() { // from class: c.e.c.v.e.p
            @Override // java.lang.Runnable
            public final void run() {
                ProjectListFragment.V1();
            }
        }).start();
    }

    public final void P1() {
        if (!o.isNotEmpty(this.I)) {
            l2(null);
            this.H = null;
        } else {
            String strRemove = this.I.remove(0);
            this.H = strRemove;
            this.J.getProjectList(strRemove);
        }
    }

    public final void Q1(NewResponseRowsVo<CityItemVo> newResponseRowsVo) {
        if (newResponseRowsVo != null) {
            final List<CityItemVo> rows = newResponseRowsVo.getRows();
            if (o.isNotEmpty(rows)) {
                new Thread(new Runnable() { // from class: c.e.c.v.e.q
                    @Override // java.lang.Runnable
                    public final void run() {
                        ProjectListFragment.W1(rows);
                    }
                }).start();
                if (this.F == null) {
                    this.F = rows.get(0);
                }
                CityItemVo cityItemVo = this.F;
                key = cityItemVo != null ? cityItemVo.getKey() : null;
                this.I = this.E.getCityKey(rows);
                P1();
            } else {
                H();
            }
            this.D.setupSelectCity(key, rows);
            this.C.initListData(rows);
        }
        this.mCitySwipeRefreshLayout.setRefreshing(false);
    }

    public final void R1() {
        CityItemVo cityItemVo = this.G;
        if (cityItemVo != null) {
            x1(cityItemVo);
            EventUpdateCity eventUpdateCity = new EventUpdateCity();
            eventUpdateCity.setKey(this.G.getKey());
            eventUpdateCity.setTitle(this.G.getCityName());
            k(eventUpdateCity);
        }
    }

    public final void S1() {
        this.l = false;
        this.mTitleTv.setText(R.string.title_switch_project);
        this.mTitleBgView.setVisibility(0);
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void V(View view) {
        if (view.getId() == R.id.tv_community_details) {
            RepairLeftVo repairLeftVo = (RepairLeftVo) this.t.getList().get(((Integer) view.getTag()).intValue());
            if ("18688948873".equals(s())) {
                repairLeftVo.setJumpUrl("https://chinavisionary-vtown-uat2.oss-cn-beijing.aliyuncs.com/android/details/%E5%BE%AE%E6%A3%A0%E7%A4%BE%E5%8C%BA.jpg");
            }
            c1(1, repairLeftVo.getJumpUrl(), repairLeftVo.getTitle());
        }
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void W() {
        S1();
        g2();
        this.D = new c.e.c.v.d.a();
        this.E = new g0();
        f2();
        h2();
        String strN0 = N0();
        this.K = strN0;
        if (x.isNotNull(strN0)) {
            CityItemVo cityItemVo = new CityItemVo();
            this.F = cityItemVo;
            cityItemVo.setKey(this.K);
        }
        b2();
        e2();
    }

    public final List<RepairLeftVo> a2(List<ProjectVo> list, String str) {
        ArrayList arrayList = new ArrayList();
        if (o.isNotEmpty(list)) {
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                ProjectVo projectVo = list.get(i2);
                if (projectVo != null) {
                    String projectKey = projectVo.getProjectKey();
                    RepairLeftVo repairLeftVo = new RepairLeftVo();
                    repairLeftVo.setKey(projectKey);
                    repairLeftVo.setJumpUrl(projectVo.getProjectDescUrl());
                    repairLeftVo.setTitle(projectVo.getProjectName());
                    if (str == null) {
                        if (i2 == 0) {
                            repairLeftVo.setSelect(true);
                            str = projectKey;
                        }
                    } else if (projectKey.equals(str)) {
                        repairLeftVo.setSelect(true);
                    }
                    arrayList.add(repairLeftVo);
                }
            }
        }
        return arrayList;
    }

    public final void b2() {
        this.J.getCityList();
    }

    @OnClick({R.id.tv_back})
    public void backClick() {
        n();
    }

    public final void c2(CityItemVo cityItemVo) {
        this.G = cityItemVo;
        List<RepairLeftVo> projectList = this.E.getProjectList(cityItemVo.getKey());
        N1(projectList);
        D(projectList);
        R1();
        M1();
    }

    public final void d2(RepairLeftVo repairLeftVo) {
        EventUpdateProject eventUpdateProject = new EventUpdateProject();
        eventUpdateProject.setKey(repairLeftVo.getKey());
        eventUpdateProject.setTitle(repairLeftVo.getTitle());
        k(eventUpdateProject);
    }

    public final void e2() {
        CacheVo cacheVo = c.e.c.p.b.getInstance().getCacheVo(CacheVo.CITY_CACHE_KEY);
        if (cacheVo == null || !x.isNotNull(cacheVo.getCacheValue())) {
            return;
        }
        try {
            List<CityItemVo> array = JSON.parseArray(cacheVo.getCacheValue(), CityItemVo.class);
            if (this.F == null) {
                this.F = array.get(0);
            }
            CityItemVo cityItemVo = this.F;
            String key = cityItemVo != null ? cityItemVo.getKey() : null;
            this.I = this.E.getCityKey(array);
            this.D.setupSelectCity(key, array);
            this.C.initListData(array);
            i2();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final void f2() {
        this.C = new CityAdapter();
        BaseRecyclerView baseRecyclerView = this.mCitySwipeRefreshLayout.getBaseRecyclerView();
        this.B = baseRecyclerView;
        baseRecyclerView.setOnRecyclerScrollListener(this.L);
        this.C.setOnItemClickListener(this.M);
        this.B.setAdapter(this.C);
    }

    public final void g2() {
        this.J = (NewRoomModel) h(NewRoomModel.class);
        j2();
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public int getLayoutId() {
        return R.layout.fragment_project_list_layout;
    }

    public final void h2() {
        this.r = this.mSwipeRefreshLayout.getBaseRecyclerView();
        if (c.e.a.a.a.getInstance().isNewVersionModel()) {
            this.t = new ProjectAdapter();
        } else {
            this.t = new RepairLeftAdapter();
        }
        this.t.setEmptyTipMsg(getString(R.string.title_project_is_empty));
        this.t.setOnClickListener(this.y);
        this.t.setOnItemClickListener(this.N);
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    public final void i2() {
        CacheVo cacheVo = c.e.c.p.b.getInstance().getCacheVo(CacheVo.PROJECT_CACHE_KEY);
        if (cacheVo == null || !x.isNotNull(cacheVo.getCacheValue())) {
            return;
        }
        try {
            List<RepairLeftVo> listA2 = a2(JSON.parseArray(cacheVo.getCacheValue(), ProjectVo.class), this.f6484b);
            if (x.isNotNull(this.K)) {
                N1(listA2);
                this.t.initListData((List<T>) listA2);
                k2(listA2);
            }
            this.E.addProjectVoToMap(this.H, listA2);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void j0() {
        this.J.getProjectList(this.K);
    }

    public final void j2() {
        this.J.getErrRequestLiveData().observe(this, new Observer() { // from class: c.e.c.v.e.o
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f1914a.l2((RequestErrDto) obj);
            }
        });
        this.J.getProjectResult().observe(this, new Observer() { // from class: c.e.c.v.e.m
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f1912a.Z1((NewResponseRowsVo) obj);
            }
        });
        this.J.getCityResult().observe(this, new Observer() { // from class: c.e.c.v.e.k
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f1910a.Q1((NewResponseRowsVo) obj);
            }
        });
    }

    public final void k2(List<RepairLeftVo> list) {
        RepairLeftVo repairLeftVo = null;
        if (o.isNotEmpty(list)) {
            for (RepairLeftVo repairLeftVo2 : list) {
                if (repairLeftVo2.isSelect()) {
                    repairLeftVo = repairLeftVo2;
                }
            }
        }
        if (repairLeftVo != null) {
            this.mSelectProjectNameTv.setText(repairLeftVo.getTitle());
        }
    }

    public final void l2(RequestErrDto requestErrDto) {
        C(requestErrDto);
        this.mSwipeRefreshLayout.setRefreshing(false);
        this.mCitySwipeRefreshLayout.setRefreshing(false);
    }

    public final void m2(int i2) {
        List<RepairLeftVo> list = this.t.getList();
        if (o.isNotEmpty(list)) {
            for (RepairLeftVo repairLeftVo : list) {
                if (repairLeftVo != null) {
                    repairLeftVo.setSelect(false);
                }
            }
        }
        RepairLeftVo repairLeftVo2 = (RepairLeftVo) this.t.getList().get(i2);
        if (x.isNotNull(repairLeftVo2.getKey())) {
            String key = repairLeftVo2.getKey();
            this.f6484b = key;
            this.E.unSelectProject(key);
            this.mSelectProjectNameTv.setText(repairLeftVo2.getTitle());
            ((RepairLeftVo) this.t.getList().get(i2)).setSelect(true);
            this.t.notifyDataSetChanged();
            w.getInstance().putString("selectProjectKey", this.f6484b);
            w.getInstance().putString("selectProjectName", repairLeftVo2.getTitle());
            c.e.a.a.i.b.getInstance().setProjectName(repairLeftVo2.getTitle());
            this.J.postSwitchProject(repairLeftVo2.getKey());
            d2(repairLeftVo2);
        }
    }
}
