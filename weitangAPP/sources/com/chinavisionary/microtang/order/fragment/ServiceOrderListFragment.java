package com.chinavisionary.microtang.order.fragment;

import android.content.Intent;
import android.view.View;
import androidx.lifecycle.Observer;
import butterknife.BindView;
import c.e.a.a.c.c.a;
import c.e.a.d.o;
import c.e.c.b0.b.m;
import c.e.c.b0.b.n;
import com.chinavisionary.core.app.net.base.dto.RequestErrDto;
import com.chinavisionary.core.app.net.base.dto.ResponseRowsVo;
import com.chinavisionary.core.app.net.base.dto.ResponseStateVo;
import com.chinavisionary.core.weight.BaseSwipeRefreshLayout;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.base.BaseFragment;
import com.chinavisionary.microtang.order.CleanOrderCommentActivity;
import com.chinavisionary.microtang.order.CleanOrderDetailsActivity;
import com.chinavisionary.microtang.order.adapter.ServiceOrderAdapter;
import com.chinavisionary.microtang.order.event.EventUpdateOrderStatus;
import com.chinavisionary.microtang.order.model.CleanOrderModel;
import com.chinavisionary.microtang.order.model.ServiceOrderModel;
import com.chinavisionary.microtang.order.vo.ServiceOrderVo;
import com.chinavisionary.microtang.repair.RepairOrderCommentActivity;
import com.chinavisionary.microtang.repair.RepairOrderDetailsActivity;
import com.chinavisionary.microtang.repair.model.RepairModel;
import com.chinavisionary.microtang.repair.vo.EventUpdateOrderState;
import g.b.a.r;

/* JADX INFO: loaded from: classes.dex */
public class ServiceOrderListFragment extends BaseFragment<ServiceOrderVo> {
    public ServiceOrderVo B;
    public ServiceOrderModel C;
    public CleanOrderModel D;
    public RepairModel E;
    public Integer F;
    public a G = new a() { // from class: c.e.c.b0.b.l
        @Override // c.e.a.a.c.c.a
        public final void onItemClickListener(View view, int i2) {
            this.f1392a.L1(view, i2);
        }
    };

    @BindView(R.id.swipe_refresh_layout)
    public BaseSwipeRefreshLayout mSwipeRefreshLayout;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: K1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void L1(View view, int i2) {
        Q1(i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: N1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void O1(ResponseRowsVo responseRowsVo) {
        X1();
        if (responseRowsVo == null) {
            T1();
            return;
        }
        D(responseRowsVo.getRows());
        if (this.f6483a == 1 && o.listIsEmpty(responseRowsVo.getRows())) {
            T1();
        }
    }

    public static ServiceOrderListFragment getInstance(Integer num) {
        ServiceOrderListFragment serviceOrderListFragment = new ServiceOrderListFragment();
        serviceOrderListFragment.R1(num);
        return serviceOrderListFragment;
    }

    public final void E1() {
        z0(R.string.tip_cancel_ordering);
        int businessOrderType = this.B.getBusinessOrderType();
        if (businessOrderType == 1) {
            this.E.cancelRepairOrder(this.B.getOrderKey());
        } else {
            if (businessOrderType != 2) {
                return;
            }
            this.D.postCancelOrder(this.B.getOrderKey());
        }
    }

    public final void F1(View view) {
    }

    public final void G1(ResponseStateVo responseStateVo) {
        if (F(responseStateVo, R.string.tip_cancel_success, R.string.tip_cancel_failed)) {
            j0();
        }
    }

    public final void H1(RequestErrDto requestErrDto) {
        X1();
        C(requestErrDto);
    }

    public final void I1() {
        u0(getString(R.string.placeholder_confirm_cancel_service_order, this.B.getContent()));
    }

    public final void P1(ServiceOrderVo serviceOrderVo) {
        int businessOrderType = serviceOrderVo.getBusinessOrderType();
        Intent intent = businessOrderType != 1 ? businessOrderType != 2 ? null : new Intent(this.f6487e, (Class<?>) CleanOrderCommentActivity.class) : new Intent(this.f6487e, (Class<?>) RepairOrderCommentActivity.class);
        intent.putExtra("key", serviceOrderVo.getOrderKey());
        startActivity(intent);
    }

    public final void Q1(int i2) {
        ServiceOrderVo serviceOrderVo = (ServiceOrderVo) this.t.getList().get(i2);
        int businessOrderType = serviceOrderVo.getBusinessOrderType();
        Intent intent = businessOrderType != 1 ? businessOrderType != 2 ? null : new Intent(this.f6487e, (Class<?>) CleanOrderDetailsActivity.class) : new Intent(this.f6487e, (Class<?>) RepairOrderDetailsActivity.class);
        intent.putExtra("key", serviceOrderVo.getOrderKey());
        intent.putExtra("status", serviceOrderVo.getStatus());
        startActivity(intent);
    }

    public final void R1(Integer num) {
        this.F = num;
    }

    public final void S1() {
        CleanOrderModel cleanOrderModel = (CleanOrderModel) h(CleanOrderModel.class);
        this.D = cleanOrderModel;
        cleanOrderModel.getCancelResultVo().observe(this, new n(this));
        this.D.getErrRequestLiveData().observe(this, new m(this));
    }

    public final void T1() {
        ((ServiceOrderAdapter) this.t).addEmptyData();
    }

    public final void U1() {
        this.r = this.mSwipeRefreshLayout.getBaseRecyclerView();
        ServiceOrderAdapter serviceOrderAdapter = new ServiceOrderAdapter();
        this.t = serviceOrderAdapter;
        serviceOrderAdapter.setOnItemClickListener(this.G);
        this.t.setOnClickListener(this.y);
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void V(View view) {
        int id = view.getId();
        if (id == R.id.btn_action) {
            handlerAction(view);
        } else if (id == R.id.btn_contact) {
            F1(view);
        } else {
            if (id != R.id.tv_alert_confirm) {
                return;
            }
            E1();
        }
    }

    public final void V1() {
        h0(this);
        ServiceOrderModel serviceOrderModel = (ServiceOrderModel) h(ServiceOrderModel.class);
        this.C = serviceOrderModel;
        serviceOrderModel.getOrderResultVo().observe(this, new Observer() { // from class: c.e.c.b0.b.k
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f1391a.O1((ResponseRowsVo) obj);
            }
        });
        this.C.getErrRequestLiveData().observe(this, new m(this));
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void W() {
        V1();
        S1();
        W1();
        U1();
        z0(R.string.loading_text);
        j0();
    }

    public final void W1() {
        RepairModel repairModel = (RepairModel) h(RepairModel.class);
        this.E = repairModel;
        repairModel.getResultLiveData().observe(this, new n(this));
        this.E.getErrRequestLiveData().observe(this, new m(this));
    }

    public final void X1() {
        H();
        this.mSwipeRefreshLayout.setRefreshing(false);
    }

    @g.b.a.m(threadMode = r.MAIN)
    public void eventUpdateEventUpdateOrderStatus(EventUpdateOrderStatus eventUpdateOrderStatus) {
        j0();
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public int getLayoutId() {
        return R.layout.fragment_not_title_recycler;
    }

    public final void handlerAction(View view) {
        ServiceOrderVo serviceOrderVo = (ServiceOrderVo) this.t.getList().get(((Integer) view.getTag()).intValue());
        this.B = serviceOrderVo;
        if (serviceOrderVo.getStatus() != 4) {
            I1();
        } else {
            P1(this.B);
        }
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void j0() {
        this.C.getServiceOrderList(r(), this.F);
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        L0(this);
    }

    @g.b.a.m(threadMode = r.MAIN)
    public void updateList(EventUpdateOrderState eventUpdateOrderState) {
        j0();
    }
}
