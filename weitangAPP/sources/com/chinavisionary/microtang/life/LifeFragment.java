package com.chinavisionary.microtang.life;

import android.content.Intent;
import android.os.Message;
import android.view.View;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.GridLayoutManager;
import butterknife.BindView;
import c.e.a.d.b0;
import c.e.a.d.q;
import c.e.a.d.x;
import c.e.c.n.b.b;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.chinavisionary.core.app.adapter.BaseRecyclerAdapter;
import com.chinavisionary.core.app.base.CoreBaseFragment;
import com.chinavisionary.core.app.config.bo.AppConfigExtVo;
import com.chinavisionary.core.app.event.EventUpdateUserInfoVo;
import com.chinavisionary.core.app.net.base.dto.RequestErrDto;
import com.chinavisionary.core.app.net.base.dto.ResponseRowsVo;
import com.chinavisionary.core.weight.BaseRecyclerView;
import com.chinavisionary.core.weight.BaseSwipeRefreshLayout;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.base.BaseFragment;
import com.chinavisionary.microtang.clean.CleanDetailsActivity;
import com.chinavisionary.microtang.clean.model.NewCleanModel;
import com.chinavisionary.microtang.clean.vo.CreateCleanOrderVo;
import com.chinavisionary.microtang.db.vo.CacheVo;
import com.chinavisionary.microtang.main.adapter.LifeMainAdapter;
import com.chinavisionary.microtang.main.event.EventUpdateProject;
import com.chinavisionary.microtang.me.vo.CleanProductVo;
import com.chinavisionary.microtang.me.vo.EventSwitchRoomVo;
import com.chinavisionary.paymentlibrary.PayTypeActivity;
import com.chinavisionary.paymentlibrary.vo.PayTypeVo;
import g.b.a.m;
import g.b.a.r;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class LifeFragment extends BaseFragment<CleanProductVo> {
    public NewCleanModel B;
    public String C;
    public String D;
    public b H;

    @BindView(R.id.swipe_refresh_layout_life)
    public BaseSwipeRefreshLayout mSwipeRefreshLayout;
    public String E = "";
    public volatile boolean F = false;
    public volatile boolean G = false;
    public final c.e.a.a.c.c.a I = new c.e.a.a.c.c.a() { // from class: c.e.c.t.d
        @Override // c.e.a.a.c.c.a
        public final void onItemClickListener(View view, int i2) {
            this.f1839a.N1(view, i2);
        }
    };

    public class a extends GridLayoutManager.SpanSizeLookup {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BaseRecyclerView f7243a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ BaseRecyclerAdapter f7244b;

        public a(BaseRecyclerView baseRecyclerView, BaseRecyclerAdapter baseRecyclerAdapter) {
            this.f7243a = baseRecyclerView;
            this.f7244b = baseRecyclerAdapter;
        }

        @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
        public int getSpanSize(int i2) {
            return ((i2 == this.f7243a.getAdapter().getItemCount() - 1 && this.f7244b.isShowFooterView()) || ((CleanProductVo) this.f7244b.getList().get(i2)).getType() == 34952) ? 2 : 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: K1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void L1(List list) {
        if (list != null) {
            try {
                if (x.isNotNull(G1())) {
                    c.e.c.p.b.getInstance().insertCacheVo(G1(), JSON.toJSONString(list, SerializerFeature.DisableCircularReferenceDetect));
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: M1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void N1(View view, int i2) {
        if (i2 < 0 || !(view.getTag() instanceof LifeMainAdapter.IncrementProductVH)) {
            return;
        }
        S1(i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: O1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void P1(ResponseRowsVo responseRowsVo) {
        if (responseRowsVo != null) {
            H1(responseRowsVo.getRows());
            D(responseRowsVo.getRows());
        }
        E1();
        V1(null);
    }

    public static LifeFragment getInstance(int i2, b bVar) {
        LifeFragment lifeFragment = new LifeFragment();
        lifeFragment.E = String.valueOf(i2);
        lifeFragment.H = bVar;
        return lifeFragment;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference incomplete: some casts might be missing */
    public final void E1() {
        if (this.f6483a == 1 && this.t.getList().isEmpty()) {
            if (Q()) {
                this.t.setEmptyTipMsg(x.getString(R.string.title_clean_goods_is_empty_rent));
            } else {
                this.t.setEmptyTipMsg(x.getString(R.string.title_clean_goods_is_empty));
            }
            CleanProductVo cleanProductVo = new CleanProductVo();
            cleanProductVo.setType(34952);
            this.t.addDataToList((T) cleanProductVo);
        }
    }

    public final void F1() {
        boolean z;
        AppConfigExtVo appConfigExtVoO = o();
        if (appConfigExtVoO != null) {
            z = appConfigExtVoO.isQqAppStory() && appConfigExtVoO.getVersionCode() == c.e.a.a.b.getInstance().getAppVersion();
            this.C = appConfigExtVoO.getValueaddTip();
        } else {
            z = false;
        }
        q.d(this.f6485c, "onCreateView isAppStory = " + z + "， mType = " + this.E);
        if (c.e.a.a.a.getInstance().isQQAppStory() && z && String.valueOf(6).equals(this.E)) {
            this.F = false;
            E1();
            V1(null);
        } else {
            this.F = true;
            this.mSwipeRefreshLayout.setEnabled(true);
            j0();
            Q1();
        }
    }

    public final String G1() {
        try {
            if (!x.isNotNull(this.E)) {
                return null;
            }
            int i2 = Integer.parseInt(this.E);
            if (i2 == 2) {
                return CacheVo.WT_CLEAN_CACHE_KEY;
            }
            if (i2 == 4) {
                return CacheVo.WT_FOOD_CACHE_KEY;
            }
            if (i2 != 6) {
                return null;
            }
            return CacheVo.WT_LIEF_CACHE_KEY;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public final void H1(final List<CleanProductVo> list) {
        new Thread(new Runnable() { // from class: c.e.c.t.c
            @Override // java.lang.Runnable
            public final void run() {
                this.f1837a.L1(list);
            }
        }).start();
    }

    public final void Q1() {
        CacheVo cacheVo;
        try {
            if (!x.isNotNull(G1()) || (cacheVo = c.e.c.p.b.getInstance().getCacheVo(G1())) == null) {
                return;
            }
            String cacheValue = cacheVo.getCacheValue();
            if (x.isNotNull(cacheValue)) {
                D(JSON.parseArray(cacheValue, CleanProductVo.class));
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void R1(CleanProductVo cleanProductVo) {
        b0.getInstance().setProductType(this.E);
        String strBigDecimalToString = x.bigDecimalToString(cleanProductVo.getPrice());
        Intent intent = new Intent(this.f6486d, (Class<?>) CleanDetailsActivity.class);
        intent.setFlags(268435456);
        intent.putExtra("key", cleanProductVo.getValueaddedKey());
        intent.putExtra("payPriceKey", strBigDecimalToString);
        try {
            if (x.isNumeric(this.E)) {
                intent.putExtra("goodsType", Integer.parseInt(this.E));
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        startActivity(intent);
    }

    public final void S1(int i2) {
        CleanProductVo cleanProductVo = (CleanProductVo) this.t.getList().get(i2);
        if (cleanProductVo != null) {
            R1(cleanProductVo);
        }
    }

    public final void T1(int i2) {
        CleanProductVo cleanProductVo = (CleanProductVo) this.t.getList().get(i2);
        if (N()) {
            if (!Q()) {
                G0(x.isNotNull(this.C) ? this.C : x.getString(R.string.tip_is_not_rent));
                return;
            }
            String strBigDecimalToString = x.bigDecimalToString(cleanProductVo.getPrice());
            CreateCleanOrderVo createCleanOrderVo = new CreateCleanOrderVo();
            createCleanOrderVo.setValueaddedKey(cleanProductVo.getValueaddedKey());
            PayTypeVo payTypeVo = new PayTypeVo();
            payTypeVo.setType(17);
            payTypeVo.setPrice(strBigDecimalToString);
            payTypeVo.setResStrId(R.string.title_pay_increment_fee);
            payTypeVo.setExtJson(JSON.toJSONString(createCleanOrderVo));
            Intent intent = new Intent(this.f6487e, (Class<?>) PayTypeActivity.class);
            intent.setFlags(268435456);
            intent.putExtra("key", JSON.toJSONString(payTypeVo));
            startActivity(intent);
        }
    }

    public final void U1() {
        NewCleanModel newCleanModel = (NewCleanModel) h(NewCleanModel.class);
        this.B = newCleanModel;
        newCleanModel.getListMutableLiveData().observe(this, new Observer() { // from class: c.e.c.t.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f1836a.P1((ResponseRowsVo) obj);
            }
        });
        this.B.getErrRequestLiveData().observe(this, new Observer() { // from class: c.e.c.t.e
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f1840a.V1((RequestErrDto) obj);
            }
        });
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void V(View view) {
        if (view.getId() == R.id.btn_pre) {
            T1(((Integer) view.getTag()).intValue());
        }
    }

    public final void V1(RequestErrDto requestErrDto) {
        H();
        if (requestErrDto != null) {
            B();
            C(requestErrDto);
        }
        this.mSwipeRefreshLayout.setRefreshing(false);
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void W() {
        h0(this);
        U1();
        this.l = false;
        this.f6488f = new CoreBaseFragment.c(this);
        BaseSwipeRefreshLayout baseSwipeRefreshLayout = this.mSwipeRefreshLayout;
        this.s = baseSwipeRefreshLayout;
        this.r = baseSwipeRefreshLayout.getBaseRecyclerView();
        LifeMainAdapter lifeMainAdapter = new LifeMainAdapter();
        this.t = lifeMainAdapter;
        lifeMainAdapter.setEmptyTipMsg(getString(R.string.title_clean_goods_is_empty));
        this.t.setOnClickListener(this.y);
        this.t.setOnItemClickListener(this.I);
        setupGridLayoutManager(this.t, this.r);
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public int getLayoutId() {
        return R.layout.fragment_life;
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void j0() {
        if (!this.F) {
            this.mSwipeRefreshLayout.setRefreshing(false);
            return;
        }
        if (this.D == null) {
            this.D = R0();
        }
        if (this.B != null) {
            q.d(this.f6485c, "requestData");
            try {
                if (x.isNotNull(this.E)) {
                    this.B.getCleanList(r(), this.D, v(), Integer.parseInt(this.E));
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        if (this.f6483a == 1) {
            H0();
            b bVar = this.H;
            if (bVar != null) {
                bVar.onRefresh();
            }
        }
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        L0(this);
    }

    @m(sticky = true, threadMode = r.BACKGROUND)
    public void registerEventSwitchRoomVo(EventSwitchRoomVo eventSwitchRoomVo) {
        this.f6483a = 1;
        j0();
        q.d(this.f6485c, "registerEventSwitchRoomVo requestData");
    }

    @m(sticky = true, threadMode = r.BACKGROUND)
    public void registerEventUpdateProject(EventUpdateProject eventUpdateProject) {
        this.D = eventUpdateProject.getKey();
        this.f6483a = 1;
        j0();
    }

    @m(threadMode = r.BACKGROUND)
    public void registerEventUpdateUserInfoVo(EventUpdateUserInfoVo eventUpdateUserInfoVo) {
        this.f6483a = 1;
        int whatMsg = eventUpdateUserInfoVo.getWhatMsg();
        if (whatMsg == 0 || whatMsg == 2) {
            return;
        }
        j0();
    }

    @Override // androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        q.d(this.f6485c, "setUserVisibleHint isVisibleToUser - " + z);
        if (!z || this.G || this.mSwipeRefreshLayout == null) {
            return;
        }
        this.G = true;
        if (c.e.a.a.a.getInstance().isQQAppStory()) {
            this.f6488f.postDelayed(new Runnable() { // from class: c.e.c.t.a
                @Override // java.lang.Runnable
                public final void run() {
                    this.f1835a.F1();
                }
            }, 1000L);
        } else {
            F1();
        }
    }

    public final void setupGridLayoutManager(BaseRecyclerAdapter<CleanProductVo> baseRecyclerAdapter, BaseRecyclerView baseRecyclerView) {
        if (baseRecyclerView == null || baseRecyclerAdapter == null) {
            return;
        }
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2);
        gridLayoutManager.setSpanSizeLookup(new a(baseRecyclerView, baseRecyclerAdapter));
        baseRecyclerView.setLayoutManager(gridLayoutManager);
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void z(Message message) {
        super.z(message);
        if (message.what == 209988331) {
            a0();
            q.d(this.f6485c, "onlyStopRefreshLayout");
        }
    }
}
