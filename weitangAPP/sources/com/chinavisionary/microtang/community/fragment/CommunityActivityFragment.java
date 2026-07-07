package com.chinavisionary.microtang.community.fragment;

import android.annotation.SuppressLint;
import android.os.Message;
import android.view.View;
import androidx.lifecycle.Observer;
import butterknife.BindView;
import c.e.a.a.c.c.a;
import c.e.a.d.o;
import c.e.a.d.q;
import c.e.a.d.x;
import c.e.c.n.b.b;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.chinavisionary.core.app.base.CoreBaseFragment;
import com.chinavisionary.core.app.net.base.dto.NewResponseRowsVo;
import com.chinavisionary.core.app.net.base.dto.RequestErrDto;
import com.chinavisionary.core.weight.BaseSwipeRefreshLayout;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.base.BaseFragment;
import com.chinavisionary.microtang.community.adapter.CommunityActivityAdapter;
import com.chinavisionary.microtang.community.model.CommunityModel;
import com.chinavisionary.microtang.community.vo.CommunityActivityItemVo;
import com.chinavisionary.microtang.community.vo.LatLngVo;
import com.chinavisionary.microtang.community.vo.NewCommunityActivityItemVo;
import com.chinavisionary.microtang.db.vo.CacheVo;
import com.chinavisionary.microtang.main.event.EventUpdateProject;
import g.b.a.m;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class CommunityActivityFragment extends BaseFragment<CommunityActivityItemVo> {
    public CommunityModel D;
    public b E;
    public String F;
    public LatLngVo G;
    public String H;

    @BindView(R.id.swipe_refresh_layout_activity)
    public BaseSwipeRefreshLayout mBaseSwipeRefreshLayout;
    public volatile boolean B = false;
    public volatile boolean C = false;
    public final a I = new a() { // from class: c.e.c.n.d.f
        @Override // c.e.a.a.c.c.a
        public final void onItemClickListener(View view, int i2) {
            this.f1719a.S1(view, i2);
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: L1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void M1(ArrayList arrayList) {
        try {
            String str = CacheVo.WT_ACTIVITY_CACHE_KEY + this.H;
            q.d(this.f6485c, "insertCacheVo dataCacheKey = " + str);
            c.e.c.p.b.getInstance().insertCacheVo(str, JSON.toJSONString(arrayList, SerializerFeature.DisableCircularReferenceDetect));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: N1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void O1(List list) {
        D(list);
        E1();
        if (o.isNotEmpty(list)) {
            U1();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: P1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void Q1() {
        try {
            String str = CacheVo.WT_ACTIVITY_CACHE_KEY + this.H;
            q.d(this.f6485c, "loadActivityCache dataCacheKey = " + str);
            CacheVo cacheVo = c.e.c.p.b.getInstance().getCacheVo(str);
            if (cacheVo != null) {
                String cacheValue = cacheVo.getCacheValue();
                if (x.isNotNull(cacheValue)) {
                    q.d(this.f6485c, "cacheValue = " + cacheValue);
                    final List array = JSON.parseArray(cacheValue, CommunityActivityItemVo.class);
                    CoreBaseFragment.c cVar = this.f6488f;
                    if (cVar != null) {
                        cVar.post(new Runnable() { // from class: c.e.c.n.d.h
                            @Override // java.lang.Runnable
                            public final void run() {
                                this.f1721a.O1(array);
                            }
                        });
                    }
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: R1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void S1(View view, int i2) {
        G1(i2);
    }

    public static CommunityActivityFragment getInstance(b bVar, String str) {
        CommunityActivityFragment communityActivityFragment = new CommunityActivityFragment();
        communityActivityFragment.E = bVar;
        communityActivityFragment.H = str;
        return communityActivityFragment;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference incomplete: some casts might be missing */
    public final void E1() {
        if (this.f6483a != 1 || !this.t.getList().isEmpty()) {
            U1();
            return;
        }
        CommunityActivityItemVo communityActivityItemVo = new CommunityActivityItemVo();
        communityActivityItemVo.setViewType(34952);
        this.t.addDataToList((T) communityActivityItemVo);
    }

    public final void F1(NewResponseRowsVo<NewCommunityActivityItemVo> newResponseRowsVo) {
        if (newResponseRowsVo != null) {
            final ArrayList arrayList = new ArrayList();
            List<NewCommunityActivityItemVo> rows = newResponseRowsVo.getRows();
            if (o.isNotEmpty(rows)) {
                for (NewCommunityActivityItemVo newCommunityActivityItemVo : rows) {
                    if (newCommunityActivityItemVo != null) {
                        CommunityActivityItemVo communityActivityItemVo = c.e.c.n.c.a.getCommunityActivityItemVo(newCommunityActivityItemVo);
                        if (newCommunityActivityItemVo.finishFlag && !this.C) {
                            this.C = true;
                            CommunityActivityItemVo communityActivityItemVo2 = new CommunityActivityItemVo();
                            communityActivityItemVo2.setViewType(123);
                            arrayList.add(communityActivityItemVo2);
                        }
                        arrayList.add(communityActivityItemVo);
                    }
                }
            }
            new Thread(new Runnable() { // from class: c.e.c.n.d.i
                @Override // java.lang.Runnable
                public final void run() {
                    this.f1723a.M1(arrayList);
                }
            }).start();
            D(arrayList);
        }
        E1();
        this.mBaseSwipeRefreshLayout.setRefreshing(false);
    }

    public final void G1(int i2) {
        if (i2 < 0 || i2 >= this.t.getList().size()) {
            return;
        }
        CommunityActivityItemVo communityActivityItemVo = (CommunityActivityItemVo) this.t.getList().get(i2);
        String activityName = communityActivityItemVo.getActivityName();
        String href = communityActivityItemVo.getHref();
        Z0(activityName);
        c1(1, href, activityName);
    }

    public final void H1() {
        h0(this);
        this.f6488f = new CoreBaseFragment.c(this);
        this.F = R0();
    }

    public final void I1() {
        CommunityModel communityModel = (CommunityModel) h(CommunityModel.class);
        this.D = communityModel;
        communityModel.getActivityResult().observeForever(new Observer() { // from class: c.e.c.n.d.g
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f1720a.F1((NewResponseRowsVo) obj);
            }
        });
        this.D.getErrRequestLiveData().observeForever(new Observer() { // from class: c.e.c.n.d.e
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f1718a.C((RequestErrDto) obj);
            }
        });
    }

    public final void T1() {
        new Thread(new Runnable() { // from class: c.e.c.n.d.j
            @Override // java.lang.Runnable
            public final void run() {
                this.f1725a.Q1();
            }
        }).start();
    }

    public final void U1() {
        CoreBaseFragment.c cVar = this.f6488f;
        if (cVar != null) {
            cVar.removeMessages(1);
            this.f6488f.sendEmptyMessageDelayed(1, 1000L);
        }
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void V(View view) {
        if (view.getId() == R.id.btn_activity_join) {
            G1(((Integer) view.getTag()).intValue());
        }
    }

    public final void V1() {
        BaseSwipeRefreshLayout baseSwipeRefreshLayout = this.mBaseSwipeRefreshLayout;
        this.s = baseSwipeRefreshLayout;
        this.r = baseSwipeRefreshLayout.getBaseRecyclerView();
        CommunityActivityAdapter communityActivityAdapter = new CommunityActivityAdapter();
        this.t = communityActivityAdapter;
        communityActivityAdapter.setEmptyTipMsg(getResources().getString(R.string.title_activity_is_empty));
        this.t.setOnClickListener(this.y);
        this.t.setOnItemClickListener(this.I);
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void W() {
        H1();
        V1();
        I1();
    }

    public final void W1() {
        CoreBaseFragment.c cVar = this.f6488f;
        if (cVar != null) {
            cVar.removeMessages(1);
        }
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public int getLayoutId() {
        return R.layout.fragment_community_activity;
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void j0() {
        b bVar;
        if (this.f6483a == 1) {
            this.C = false;
        }
        this.D.getActivityList(r(), this.F, c.e.c.n.c.a.getInstance().getLatLngVo(), this.H);
        if (this.f6483a != 1 || (bVar = this.E) == null) {
            return;
        }
        bVar.onRefresh();
        H0();
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        L0(this);
    }

    @m(sticky = true)
    public void registerEventUpdateProject(EventUpdateProject eventUpdateProject) {
        this.F = eventUpdateProject.getKey();
        this.f6483a = 1;
        j0();
    }

    public void setLatLngVo(LatLngVo latLngVo) {
        this.G = latLngVo;
        this.f6483a = 1;
        q.d(this.f6485c, "setLatLngVo update mActivityLabKey = " + this.H);
        j0();
    }

    @Override // androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        q.d(this.f6485c, "setUserVisibleHint isVisibleToUser - " + z);
        if (z && !this.B && this.s != null) {
            this.B = true;
            T1();
            j0();
        }
        if (z) {
            U1();
        } else {
            W1();
        }
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    @SuppressLint({"NotifyDataSetChanged"})
    public void z(Message message) {
        if (message.what == 209988331) {
            a0();
            q.d(this.f6485c, "onlyStopRefreshLayout");
        } else {
            if (!this.r.isComputingLayout()) {
                this.t.notifyDataSetChanged();
            }
            U1();
        }
    }
}
