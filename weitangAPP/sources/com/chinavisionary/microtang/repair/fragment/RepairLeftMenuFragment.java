package com.chinavisionary.microtang.repair.fragment;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import butterknife.BindView;
import butterknife.OnClick;
import c.e.a.d.q;
import c.e.a.d.x;
import c.e.c.g.n;
import com.chinavisionary.core.app.net.base.dto.RequestErrDto;
import com.chinavisionary.core.weight.BaseRecyclerView;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.base.BaseFragment;
import com.chinavisionary.microtang.repair.RepairHistoryActivity;
import com.chinavisionary.microtang.repair.adapter.RepairLeftAdapter;
import com.chinavisionary.microtang.repair.adapter.RepairRightAdapter;
import com.chinavisionary.microtang.repair.model.RepairModel;
import com.chinavisionary.microtang.repair.vo.RepairDeviceVo;
import com.chinavisionary.microtang.repair.vo.RepairLeftVo;
import com.chinavisionary.microtang.repair.vo.RepairRightVo;
import com.chinavisionary.microtang.repair.vo.ResponseVo;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class RepairLeftMenuFragment extends BaseFragment {
    public RepairLeftAdapter B;
    public RepairRightAdapter C;
    public RepairRightVo.RepairProduct D;
    public RepairModel E;
    public boolean F = false;
    public SwipeRefreshLayout.OnRefreshListener G = new SwipeRefreshLayout.OnRefreshListener() { // from class: c.e.c.g0.b.f
        @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
        public final void onRefresh() {
            this.f1464a.I1();
        }
    };
    public BaseRecyclerView.f H = new a();
    public c.e.a.a.c.c.a I = new c.e.a.a.c.c.a() { // from class: c.e.c.g0.b.g
        @Override // c.e.a.a.c.c.a
        public final void onItemClickListener(View view, int i2) {
            this.f1465a.K1(view, i2);
        }
    };

    @BindView(R.id.recycler_left_menu)
    public BaseRecyclerView mLeftMenuRecyclerView;

    @BindView(R.id.recycler_right_menu)
    public BaseRecyclerView mRightMenuRecyclerView;

    @BindView(R.id.tv_title_right)
    public TextView mRightTv;

    @BindView(R.id.swipe_refresh_layout)
    public SwipeRefreshLayout mSwipeRefreshLayout;

    @BindView(R.id.tv_title)
    public TextView mTitleTv;

    public class a implements BaseRecyclerView.f {
        public a() {
        }

        @Override // com.chinavisionary.core.weight.BaseRecyclerView.f
        public void onLoadFirstAndLastPosition(int i2, int i3) {
            if (i2 > 0) {
                i2 += (i3 - i2) / 2;
            }
            q.d(RepairLeftMenuFragment.class.getSimpleName(), "first:" + i2 + ", last:" + i3);
            if (!RepairLeftMenuFragment.this.F) {
                RepairLeftMenuFragment.this.X1(i2);
            }
            if (RepairLeftMenuFragment.this.F) {
                RepairLeftMenuFragment.this.F = false;
            }
        }

        @Override // com.chinavisionary.core.weight.BaseRecyclerView.f
        public void onLoadMore() {
        }

        @Override // com.chinavisionary.core.weight.BaseRecyclerView.f
        public void onRefresh() {
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

    public class b extends LinearSmoothScroller {
        public b(Context context) {
            super(context);
        }

        @Override // androidx.recyclerview.widget.LinearSmoothScroller
        public int getVerticalSnapPreference() {
            return -1;
        }

        @Override // androidx.recyclerview.widget.LinearSmoothScroller, androidx.recyclerview.widget.RecyclerView.SmoothScroller
        public void onStart() {
            super.onStart();
        }

        @Override // androidx.recyclerview.widget.LinearSmoothScroller, androidx.recyclerview.widget.RecyclerView.SmoothScroller
        public void onStop() {
            super.onStop();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: J1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void K1(View view, int i2) {
        this.F = true;
        X1(i2);
        Y1(i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: L1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void M1(ResponseVo responseVo) {
        W1();
        if (responseVo == null || responseVo.getRows() == null) {
            F0(R.string.empty_view_hint);
        } else {
            initAdapterData(responseVo.getRows());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: N1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void O1(RequestErrDto requestErrDto) {
        W1();
        C(requestErrDto);
    }

    public static RepairLeftMenuFragment getInstance() {
        return new RepairLeftMenuFragment();
    }

    public final List<RepairRightVo.RepairProduct> H1(List<RepairDeviceVo.DevicesBean> list) {
        ArrayList arrayList = new ArrayList();
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            RepairDeviceVo.DevicesBean devicesBean = list.get(i2);
            RepairRightVo.RepairProduct repairProduct = new RepairRightVo.RepairProduct();
            repairProduct.setKey(devicesBean.getAssetCategoryKey());
            repairProduct.setTitle(devicesBean.getAssetCategoryKeyName());
            repairProduct.setResourceVo(devicesBean.getResourceVo());
            arrayList.add(repairProduct);
        }
        return arrayList;
    }

    public final void P1() {
        K0(AddRepairInfoFragment.getInstance(this.D.getKey(), this.D.getTitle()), R.id.flayout_content);
    }

    public final void Q1() {
        Intent intent = new Intent(this.f6487e, (Class<?>) RepairHistoryActivity.class);
        intent.setFlags(268435456);
        startActivity(intent);
    }

    public final void R1() {
        RepairModel repairModel = (RepairModel) h(RepairModel.class);
        this.E = repairModel;
        repairModel.getDeviceMenu().observe(this, new Observer() { // from class: c.e.c.g0.b.e
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f1463a.M1((ResponseVo) obj);
            }
        });
        this.E.getErrRequestLiveData().observe(this, new Observer() { // from class: c.e.c.g0.b.h
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f1466a.O1((RequestErrDto) obj);
            }
        });
    }

    public final void S1(int i2) {
        b bVar = new b(this.f6486d);
        bVar.setTargetPosition(i2);
        this.mRightMenuRecyclerView.getLayoutManager().startSmoothScroll(bVar);
    }

    public final void T1() {
        this.mSwipeRefreshLayout.setOnRefreshListener(this.G);
        RepairRightAdapter repairRightAdapter = new RepairRightAdapter();
        this.C = repairRightAdapter;
        repairRightAdapter.setOnClickListener(this.y);
        RepairLeftAdapter repairLeftAdapter = new RepairLeftAdapter();
        this.B = repairLeftAdapter;
        repairLeftAdapter.setOnItemClickListener(this.I);
        this.mLeftMenuRecyclerView.setAdapter(this.B);
        this.mRightMenuRecyclerView.setAdapter(this.C);
        this.mRightMenuRecyclerView.setOnRecyclerScrollListener(this.H);
    }

    public final void U1() {
        this.mRightTv.setVisibility(0);
        this.mRightTv.setText(R.string.title_repair_order);
        this.mRightTv.setOnClickListener(this.y);
        this.mTitleTv.setText(R.string.title_repair);
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void V(View view) {
        int id = view.getId();
        if (id == R.id.tv_alert_confirm) {
            P1();
            return;
        }
        if (id == R.id.tv_title_right) {
            Q1();
        } else {
            if (id != R.id.view_repair_product) {
                return;
            }
            RepairRightVo.RepairProduct repairProduct = (RepairRightVo.RepairProduct) view.getTag();
            this.D = repairProduct;
            V1(repairProduct);
        }
    }

    public final void V1(RepairRightVo.RepairProduct repairProduct) {
        n.getInstance().showAlert(this.f6487e, x.getString(R.string.title_alert_tip), x.getString(R.string.title_is_confirm_repair) + repairProduct.getTitle(), x.getString(R.string.title_confirm), x.getString(R.string.title_cancel), this.y);
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void W() {
        U1();
        R1();
        T1();
        z0(R.string.loading_text);
        S();
    }

    public final void W1() {
        H();
        this.mSwipeRefreshLayout.setRefreshing(false);
    }

    public final void X1(int i2) {
        List<RepairLeftVo> list = this.B.getList();
        int size = list.size();
        int i3 = 0;
        while (i3 < size) {
            list.get(i3).setSelect(i3 == i2);
            i3++;
        }
        this.B.notifyDataSetChanged();
    }

    public final void Y1(int i2) {
        S1(i2);
    }

    @OnClick({R.id.tv_back})
    public void backClick(View view) {
        n();
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public int getLayoutId() {
        return R.layout.fragment_repair_left_menu;
    }

    public final void initAdapterData(List<RepairDeviceVo> list) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            RepairDeviceVo repairDeviceVo = list.get(i2);
            RepairLeftVo repairLeftVo = new RepairLeftVo();
            repairLeftVo.setKey(repairDeviceVo.getDeviceMenuKey());
            repairLeftVo.setTitle(repairDeviceVo.getDeviceMenuName());
            arrayList.add(repairLeftVo);
            RepairRightVo repairRightVo = new RepairRightVo();
            repairRightVo.setKey(repairDeviceVo.getDeviceMenuKey());
            repairRightVo.setTitle(repairDeviceVo.getDeviceMenuName());
            repairRightVo.setProductList(H1(repairDeviceVo.getDevices()));
            arrayList2.add(repairRightVo);
        }
        this.B.initListData(arrayList);
        this.C.initListData(arrayList2);
        X1(0);
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    /* JADX INFO: renamed from: j0, reason: merged with bridge method [inline-methods] */
    public void I1() {
        this.E.getDeviceCategoryMenuList();
    }
}
