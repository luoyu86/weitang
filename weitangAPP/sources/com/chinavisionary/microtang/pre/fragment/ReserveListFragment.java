package com.chinavisionary.microtang.pre.fragment;

import android.view.View;
import android.widget.TextView;
import androidx.lifecycle.Observer;
import butterknife.BindView;
import butterknife.OnClick;
import c.e.a.d.x;
import c.e.c.c0.c.d;
import com.chinavisionary.core.app.base.CoreBaseFragment;
import com.chinavisionary.core.app.net.base.dto.RequestErrDto;
import com.chinavisionary.core.app.net.base.dto.ResponseRowsVo;
import com.chinavisionary.core.weight.BaseSwipeRefreshLayout;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.base.BaseFragment;
import com.chinavisionary.microtang.contract.vo.UpdateContractEventVo;
import com.chinavisionary.microtang.pre.adapter.PreOrderAdapter;
import com.chinavisionary.microtang.pre.event.EventUpdateReserveList;
import com.chinavisionary.microtang.pre.model.ReserveModel;
import com.chinavisionary.microtang.pre.vo.ReserveItemVo;
import com.chinavisionary.paymentlibrary.vo.EventPayStateVo;
import g.b.a.m;
import g.b.a.r;

/* JADX INFO: loaded from: classes2.dex */
public class ReserveListFragment extends BaseFragment<ReserveItemVo> {
    public int B;
    public ReserveModel C;
    public d D;
    public c.e.a.a.c.c.a E = new c.e.a.a.c.c.a() { // from class: c.e.c.c0.b.f
        @Override // c.e.a.a.c.c.a
        public final void onItemClickListener(View view, int i2) {
            this.f1406a.R1(view, i2);
        }
    };
    public d.a F = new a();
    public Runnable G = new Runnable() { // from class: c.e.c.c0.b.g
        @Override // java.lang.Runnable
        public final void run() {
            this.f1407a.T1();
        }
    };

    @BindView(R.id.swipe_refresh_layout)
    public BaseSwipeRefreshLayout mSwipeRefreshLayout;

    @BindView(R.id.tv_title)
    public TextView mTitleTv;

    public class a implements d.a {
        public a() {
        }

        @Override // c.e.c.c0.c.d.a
        public void addFragment(CoreBaseFragment coreBaseFragment) {
            ReserveListFragment.this.d(coreBaseFragment, R.id.flayout_content);
        }

        @Override // c.e.c.c0.c.d.a
        public void hideAlertLoading() {
            ReserveListFragment.this.H();
        }

        @Override // c.e.c.c0.c.d.a
        public void openActivityToClass(Class cls) {
            ReserveListFragment.this.d0(cls);
        }

        @Override // c.e.c.c0.c.d.a
        public void refreshPage() {
            ReserveListFragment.this.j0();
        }

        @Override // c.e.c.c0.c.d.a
        public void showAlertLoading(int i2) {
            ReserveListFragment.this.z0(i2);
        }

        @Override // c.e.c.c0.c.d.a
        public void showToast(int i2) {
            ReserveListFragment.this.F0(i2);
        }

        @Override // c.e.c.c0.c.d.a
        public void switchFragment(CoreBaseFragment coreBaseFragment) {
            ReserveListFragment.this.K0(coreBaseFragment, R.id.flayout_content);
        }

        @Override // c.e.c.c0.c.d.a
        public boolean userIsAuth() {
            return ReserveListFragment.this.M();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: Q1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void R1(View view, int i2) {
        ReserveItemVo reserveItemVo = (ReserveItemVo) this.t.getList().get(i2);
        if (reserveItemVo != null) {
            K0(ReserveDetailsFragment.getInstance(reserveItemVo), R.id.flayout_content);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: S1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void T1() {
        boolean zUpdateTimer = this.D.updateTimer(this.t.getList());
        X1();
        if (zUpdateTimer) {
            Y1();
            this.t.notifyDataSetChanged();
        }
    }

    public static ReserveListFragment getInstance() {
        return new ReserveListFragment();
    }

    public final void L1(View view) {
        this.B = ((Integer) view.getTag()).intValue();
        u0(x.getString(R.string.title_tip_cancel_pay));
    }

    public final void M1() {
        z0(R.string.tip_submit_cancel);
        this.D.requestCancelPay(((ReserveItemVo) this.t.getList().get(this.B)).getPrimaryKey());
    }

    public final void N1(View view) {
        this.D.handleActionToReserveItemVoe((ReserveItemVo) this.t.getList().get(((Integer) view.getTag()).intValue()));
    }

    public final void U1() {
        h0(this);
        this.mSwipeRefreshLayout.setBackgroundColor(getResources().getColor(R.color.color_bg));
        this.r = this.mSwipeRefreshLayout.getBaseRecyclerView();
        PreOrderAdapter preOrderAdapter = new PreOrderAdapter();
        this.t = preOrderAdapter;
        preOrderAdapter.setEmptyTipMsg(x.getString(R.string.title_reserve_list_is_empty));
        this.t.setOnClickListener(this.y);
        this.t.setOnItemClickListener(this.E);
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void V(View view) {
        if (M0(view)) {
            int id = view.getId();
            if (id == R.id.btn_cancel_pay) {
                L1(view);
            } else if (id == R.id.btn_pay_sign) {
                N1(view);
            } else {
                if (id != R.id.tv_alert_confirm) {
                    return;
                }
                M1();
            }
        }
    }

    public final void V1(ResponseRowsVo<ReserveItemVo> responseRowsVo) {
        H();
        this.mSwipeRefreshLayout.setRefreshing(false);
        if (responseRowsVo == null || !responseRowsVo.getSuccess() || responseRowsVo.getRows() == null || responseRowsVo.getRows().isEmpty()) {
            return;
        }
        D(responseRowsVo.getRows());
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void W() {
        this.mTitleTv.setText(R.string.title_pre_order);
        this.f6488f = new CoreBaseFragment.c(this);
        U1();
        W1();
        z0(R.string.loading_text);
        j0();
    }

    public final void W1() {
        ReserveModel reserveModel = (ReserveModel) h(ReserveModel.class);
        this.C = reserveModel;
        d dVar = new d(reserveModel, this);
        this.D = dVar;
        dVar.setIView(this.F);
        this.C.getReserveItemVoLiveData().observe(this, new Observer() { // from class: c.e.c.c0.b.h
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f1408a.V1((ResponseRowsVo) obj);
            }
        });
        this.C.getErrRequestLiveData().observe(this, new Observer() { // from class: c.e.c.c0.b.e
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f1405a.C((RequestErrDto) obj);
            }
        });
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void X() {
        X1();
    }

    public final void X1() {
        CoreBaseFragment.c cVar = this.f6488f;
        if (cVar != null) {
            cVar.removeCallbacks(this.G);
        }
    }

    public final void Y1() {
        if (this.f6488f != null) {
            X1();
            this.f6488f.postDelayed(this.G, 1000L);
        }
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void Z() {
        Y1();
    }

    @OnClick({R.id.tv_back})
    public void backClick(View view) {
        n();
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public int getLayoutId() {
        return R.layout.fragment_recycler;
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void j0() {
        this.C.getReserveList();
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        L0(this);
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        Y1();
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment, androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        X1();
    }

    @m(threadMode = r.MAIN)
    public void subscribePayResult(EventPayStateVo eventPayStateVo) {
        if (eventPayStateVo.isSuccess()) {
            j0();
        }
    }

    @m(threadMode = r.MAIN)
    public void updateList(UpdateContractEventVo updateContractEventVo) {
        j0();
    }

    @m
    public void updateReserveList(EventUpdateReserveList eventUpdateReserveList) {
        j0();
    }
}
