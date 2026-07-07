package com.chinavisionary.microtang.repair.fragment;

import android.view.View;
import android.widget.TextView;
import androidx.lifecycle.Observer;
import butterknife.BindView;
import butterknife.OnClick;
import c.e.a.a.c.c.a;
import c.e.a.d.x;
import com.chinavisionary.core.app.net.base.dto.RequestErrDto;
import com.chinavisionary.core.app.net.base.dto.ResponseStateVo;
import com.chinavisionary.core.weight.BaseSwipeRefreshLayout;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.base.BaseFragment;
import com.chinavisionary.microtang.repair.adapter.RepairOrderAdapter;
import com.chinavisionary.microtang.repair.model.RepairModel;
import com.chinavisionary.microtang.repair.vo.EventUpdateOrderState;
import com.chinavisionary.microtang.repair.vo.RepairOrderItemVo;
import com.chinavisionary.microtang.repair.vo.ResponseVo;
import g.b.a.m;
import g.b.a.r;

/* JADX INFO: loaded from: classes2.dex */
public class RepairOrderListFragment extends BaseFragment<RepairOrderItemVo> {
    public RepairOrderItemVo B;
    public RepairModel C;
    public a D = new a() { // from class: c.e.c.g0.b.r
        @Override // c.e.a.a.c.c.a
        public final void onItemClickListener(View view, int i2) {
            this.f1476a.H1(view, i2);
        }
    };

    @BindView(R.id.swipe_refresh_layout)
    public BaseSwipeRefreshLayout mSwipeRefreshLayout;

    @BindView(R.id.tv_title)
    public TextView mTitleTv;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: G1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void H1(View view, int i2) {
        P1(i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: I1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void J1(ResponseVo responseVo) {
        T1();
        if (responseVo == null || responseVo.getRows() == null) {
            F0(R.string.empty_view_hint);
        } else {
            if (responseVo.getRows().isEmpty()) {
                return;
            }
            D(responseVo.getRows());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: K1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void L1(ResponseStateVo responseStateVo) {
        if (F(responseStateVo, R.string.tip_cancel_success, R.string.tip_cancel_failed)) {
            j0();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: M1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void N1(RequestErrDto requestErrDto) {
        T1();
        C(requestErrDto);
    }

    public static RepairOrderListFragment getInstance() {
        return new RepairOrderListFragment();
    }

    public final void E1(View view) {
        f(((RepairOrderItemVo) this.t.getList().get(((Integer) view.getTag()).intValue())).getRepairPhone());
    }

    public final void F1() {
        u0(getString(R.string.placeholder_confirm_cancal_repair_order, this.B.getRepairDesc()));
    }

    public final void O1(RepairOrderItemVo repairOrderItemVo) {
        K0(RepairOrderCommentFragment.getInstance(repairOrderItemVo.getRepairOrderKey()), R.id.flayout_content);
    }

    public final void P1(int i2) {
        RepairOrderItemVo repairOrderItemVo = (RepairOrderItemVo) this.t.getList().get(i2);
        RepairOrderDetailsFragment repairOrderDetailsFragment = RepairOrderDetailsFragment.getInstance(repairOrderItemVo.getRepairOrderKey(), repairOrderItemVo.getStatus());
        repairOrderDetailsFragment.setRepairOrderListFragment(this, i2);
        K0(repairOrderDetailsFragment, R.id.flayout_content);
    }

    public void Q1(int i2, int i3) {
        ((RepairOrderItemVo) this.t.getList().get(i2)).setStatus(i3);
        ((RepairOrderItemVo) this.t.getList().get(i2)).setStatusDesc(x.getString(R.string.title_cancelled));
        this.t.notifyDataSetChanged();
    }

    public final void R1() {
        this.r = this.mSwipeRefreshLayout.getBaseRecyclerView();
        RepairOrderAdapter repairOrderAdapter = new RepairOrderAdapter();
        this.t = repairOrderAdapter;
        repairOrderAdapter.setOnItemClickListener(this.D);
        this.t.setOnClickListener(this.y);
    }

    public final void S1() {
        h0(this);
        RepairModel repairModel = (RepairModel) h(RepairModel.class);
        this.C = repairModel;
        repairModel.getRepairOrderItemList().observe(this, new Observer() { // from class: c.e.c.g0.b.p
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f1474a.J1((ResponseVo) obj);
            }
        });
        this.C.getResultLiveData().observe(this, new Observer() { // from class: c.e.c.g0.b.q
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f1475a.L1((ResponseStateVo) obj);
            }
        });
        this.C.getErrRequestLiveData().observe(this, new Observer() { // from class: c.e.c.g0.b.s
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f1477a.N1((RequestErrDto) obj);
            }
        });
    }

    public final void T1() {
        H();
        this.mSwipeRefreshLayout.setRefreshing(false);
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void V(View view) {
        int id = view.getId();
        if (id == R.id.btn_action) {
            handlerAction(view);
            return;
        }
        if (id == R.id.btn_contact) {
            E1(view);
        } else {
            if (id != R.id.tv_alert_confirm) {
                return;
            }
            z0(R.string.tip_cancel_ordering);
            this.C.cancelRepairOrder(this.B.getRepairOrderKey());
        }
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void W() {
        this.mTitleTv.setText(R.string.title_repair_order);
        S1();
        R1();
        z0(R.string.loading_text);
        j0();
    }

    @OnClick({R.id.tv_back})
    public void backClick(View view) {
        n();
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public int getLayoutId() {
        return R.layout.fragment_repair_order;
    }

    public final void handlerAction(View view) {
        RepairOrderItemVo repairOrderItemVo = (RepairOrderItemVo) this.t.getList().get(((Integer) view.getTag()).intValue());
        this.B = repairOrderItemVo;
        if (repairOrderItemVo.getStatus() != 4) {
            F1();
        } else {
            O1(this.B);
        }
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void j0() {
        this.C.getRepairOrderList(r());
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        L0(this);
    }

    @m(threadMode = r.MAIN)
    public void updateList(EventUpdateOrderState eventUpdateOrderState) {
        j0();
    }
}
