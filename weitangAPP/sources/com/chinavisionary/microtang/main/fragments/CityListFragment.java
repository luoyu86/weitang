package com.chinavisionary.microtang.main.fragments;

import android.view.View;
import android.widget.TextView;
import androidx.lifecycle.Observer;
import butterknife.BindView;
import butterknife.OnClick;
import c.e.a.d.o;
import c.e.a.d.x;
import com.chinavisionary.core.app.net.base.dto.NewResponseRowsVo;
import com.chinavisionary.core.app.net.base.dto.RequestErrDto;
import com.chinavisionary.core.weight.BaseSwipeRefreshLayout;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.base.BaseFragment;
import com.chinavisionary.microtang.main.adapter.CityAdapter;
import com.chinavisionary.microtang.main.bo.ProjectVo;
import com.chinavisionary.microtang.main.event.EventUpdateCity;
import com.chinavisionary.microtang.main.event.EventUpdateProject;
import com.chinavisionary.microtang.main.model.NewRoomModel;
import com.chinavisionary.microtang.main.vo.CityItemVo;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class CityListFragment extends BaseFragment<CityItemVo> {
    public NewRoomModel B;
    public c.e.c.v.d.a C;
    public CityItemVo D;
    public CityItemVo E;
    public final c.e.a.a.c.c.a F = new a();

    @BindView(R.id.tv_current_location_value)
    public TextView mCurrentLocationTv;

    @BindView(R.id.swipe_refresh_layout_project)
    public BaseSwipeRefreshLayout mSwipeRefreshLayout;

    public class a implements c.e.a.a.c.c.a {
        public a() {
        }

        @Override // c.e.a.a.c.c.a
        public void onItemClickListener(View view, int i2) {
            CityListFragment.this.C.selectCurrentCity(i2, CityListFragment.this.t.getList());
            CityListFragment.this.t.notifyDataSetChanged();
            CityListFragment cityListFragment = CityListFragment.this;
            cityListFragment.S1((CityItemVo) cityListFragment.t.getList().get(i2));
        }
    }

    public static CityListFragment getInstance() {
        return new CityListFragment();
    }

    public final void J1() {
        M1();
        this.u.postDelayed(new Runnable() { // from class: c.e.c.v.e.c
            @Override // java.lang.Runnable
            public final void run() {
                this.f1900a.n();
            }
        }, 200L);
    }

    public final void K1(NewResponseRowsVo<ProjectVo> newResponseRowsVo) {
        H();
        if (newResponseRowsVo == null || !o.isNotEmpty(newResponseRowsVo.getRows())) {
            F0(R.string.tip_switch_failed);
        } else {
            T1(newResponseRowsVo.getRows().get(0));
            J1();
        }
    }

    public final void L1(NewResponseRowsVo<CityItemVo> newResponseRowsVo) {
        if (newResponseRowsVo != null) {
            List<CityItemVo> rows = newResponseRowsVo.getRows();
            this.C.setupSelectCity(this.D.getKey(), rows);
            D(rows);
        }
        this.s.setRefreshing(false);
    }

    public final void M1() {
        CityItemVo cityItemVo = this.E;
        if (cityItemVo != null) {
            x1(cityItemVo);
            EventUpdateCity eventUpdateCity = new EventUpdateCity();
            eventUpdateCity.setKey(this.E.getKey());
            eventUpdateCity.setTitle(this.E.getCityName());
            k(eventUpdateCity);
        }
    }

    public final void N1() {
        this.l = false;
        this.C = new c.e.c.v.d.a();
        CityItemVo cityItemVoQ0 = Q0();
        this.D = cityItemVoQ0;
        this.mCurrentLocationTv.setText(cityItemVoQ0.getCityName());
    }

    public final void S1(CityItemVo cityItemVo) {
        this.E = cityItemVo;
        if (!x.isNotNull(cityItemVo.getKey()) || cityItemVo.getKey().equals(this.D.getKey())) {
            J1();
        } else {
            z0(R.string.tip_switch_city);
            this.B.getProjectList(cityItemVo.getKey());
        }
    }

    public final void T1(ProjectVo projectVo) {
        this.B.postSwitchProject(projectVo.getProjectKey());
        EventUpdateProject eventUpdateProject = new EventUpdateProject();
        eventUpdateProject.setKey(projectVo.getProjectKey());
        eventUpdateProject.setTitle(projectVo.getProjectName());
        l(eventUpdateProject);
    }

    public final void U1() {
        NewRoomModel newRoomModel = (NewRoomModel) h(NewRoomModel.class);
        this.B = newRoomModel;
        newRoomModel.getCityResult().observe(this, new Observer() { // from class: c.e.c.v.e.d
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f1902a.L1((NewResponseRowsVo) obj);
            }
        });
        this.B.getProjectResult().observe(this, new Observer() { // from class: c.e.c.v.e.f
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f1905a.K1((NewResponseRowsVo) obj);
            }
        });
        this.B.getErrRequestLiveData().observe(this, new Observer() { // from class: c.e.c.v.e.e
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f1904a.C((RequestErrDto) obj);
            }
        });
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void V(View view) {
    }

    public final void V1() {
        BaseSwipeRefreshLayout baseSwipeRefreshLayout = this.mSwipeRefreshLayout;
        this.s = baseSwipeRefreshLayout;
        this.r = baseSwipeRefreshLayout.getBaseRecyclerView();
        CityAdapter cityAdapter = new CityAdapter();
        this.t = cityAdapter;
        cityAdapter.setOnItemClickListener(this.F);
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void W() {
        N1();
        U1();
        V1();
        z0(R.string.loading_text);
        j0();
    }

    @OnClick({R.id.img_back})
    public void backClick() {
        n();
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public int getLayoutId() {
        return R.layout.fragment_city_list_layout;
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void j0() {
        this.B.getCityList();
    }
}
