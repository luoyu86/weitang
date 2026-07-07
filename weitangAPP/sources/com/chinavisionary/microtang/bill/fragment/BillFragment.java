package com.chinavisionary.microtang.bill.fragment;

import android.view.View;
import androidx.lifecycle.Observer;
import butterknife.BindView;
import c.e.a.a.c.c.a;
import c.e.a.d.q;
import c.e.a.d.x;
import c.e.c.j.c.c;
import com.chinavisionary.core.app.base.CoreBaseFragment;
import com.chinavisionary.core.app.net.base.dto.RequestErrDto;
import com.chinavisionary.core.app.net.base.dto.ResponseRowsVo;
import com.chinavisionary.core.weight.BaseSwipeRefreshLayout;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.base.BaseFragment;
import com.chinavisionary.microtang.bill.adapter.BillAdapter;
import com.chinavisionary.microtang.bill.adapter.LifeBillAdapter;
import com.chinavisionary.microtang.bill.adapter.OtherBillAdapter;
import com.chinavisionary.microtang.bill.event.EventRentBill;
import com.chinavisionary.microtang.bill.model.BillModel;
import com.chinavisionary.microtang.bill.vo.BillVo;
import com.chinavisionary.microtang.main.bo.EventUpdateAlertVo;
import com.chinavisionary.paymentlibrary.vo.EventPayStateVo;
import g.b.a.m;
import g.b.a.r;

/* JADX INFO: loaded from: classes.dex */
public class BillFragment extends BaseFragment<BillVo> {
    public int B;
    public boolean C;
    public BillModel D;
    public c E;
    public a F = new a() { // from class: c.e.c.j.b.d
        @Override // c.e.a.a.c.c.a
        public final void onItemClickListener(View view, int i2) {
            this.f1581a.L1(view, i2);
        }
    };
    public Runnable G = new Runnable() { // from class: c.e.c.j.b.f
        @Override // java.lang.Runnable
        public final void run() {
            this.f1583a.N1();
        }
    };

    @BindView(R.id.swipe_refresh_layout)
    public BaseSwipeRefreshLayout mSwipeRefreshLayout;

    private void I0() {
        H();
        this.mSwipeRefreshLayout.setRefreshing(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: K1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void L1(View view, int i2) {
        K0(BillDetailsFragment.getInstance((BillVo) this.t.getList().get(i2), this.B), R.id.flayout_content);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: M1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void N1() {
        boolean zIsUpdateTimer = this.E.isUpdateTimer(this.t.getList());
        T1();
        if (zIsUpdateTimer) {
            U1();
            this.t.notifyDataSetChanged();
        }
    }

    public static BillFragment getInstance(int i2) {
        BillFragment billFragment = new BillFragment();
        billFragment.Q1(i2);
        return billFragment;
    }

    public final void E1(String str) {
        if (this.B == 1 && x.isNotNull(str)) {
            q.d(getClass().getSimpleName(), "getLiveComment rent bill");
            EventRentBill eventRentBill = new EventRentBill();
            eventRentBill.setBillKey(str);
            k(eventRentBill);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference incomplete: some casts might be missing */
    public final void F1(ResponseRowsVo<BillVo> responseRowsVo) {
        I0();
        if (responseRowsVo == null) {
            D(null);
            return;
        }
        if (!responseRowsVo.getSuccess()) {
            G0(responseRowsVo.getMessage());
            return;
        }
        if (responseRowsVo.getRows() != null && !responseRowsVo.getRows().isEmpty()) {
            D(responseRowsVo.getRows());
            U1();
            return;
        }
        D(null);
        if (this.f6483a == 1) {
            BillVo billVo = new BillVo();
            billVo.setBillStatus(34952);
            this.t.addDataToList((T) billVo);
        }
    }

    public final void G1(View view) {
        u0(x.getString(R.string.title_tip_cancel_pay));
    }

    public final void H1(RequestErrDto requestErrDto) {
        I0();
        C(requestErrDto);
    }

    public final void I1(View view) {
        BillVo billVo = (BillVo) view.getTag();
        if (billVo.getLateFeeDays() > 0 || (billVo.getLateFee() != null && billVo.getLateFee().floatValue() > 0.0f)) {
            this.C = true;
        }
        K0(this.E.createPayTypeFragment(billVo, this.B), R.id.flayout_content);
    }

    public final void P1() {
        if (this.C) {
            this.C = false;
            k(new EventUpdateAlertVo());
        }
        q.d(getClass().getSimpleName(), "sendUpdateEvent isUpdateAlert = " + this.C);
    }

    public final void Q1(int i2) {
        this.B = i2;
    }

    public final void R1() {
        this.E = new c();
        this.f6488f = new CoreBaseFragment.c(this);
        BillModel billModel = (BillModel) h(BillModel.class);
        this.D = billModel;
        billModel.getBillListLiveData().observe(this, new Observer() { // from class: c.e.c.j.b.g
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f1584a.F1((ResponseRowsVo) obj);
            }
        });
        this.D.getErrRequestLiveData().observe(this, new Observer() { // from class: c.e.c.j.b.e
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f1582a.H1((RequestErrDto) obj);
            }
        });
    }

    public final void S1() {
        this.r = this.mSwipeRefreshLayout.getBaseRecyclerView();
        int i2 = this.B;
        if (i2 == 1) {
            this.t = new BillAdapter();
        } else if (i2 != 2) {
            this.t = new OtherBillAdapter();
        } else {
            this.t = new LifeBillAdapter();
        }
        this.t.setEmptyTipMsg(getResources().getString(R.string.title_bill_is_empty));
        this.t.setOnClickListener(this.y);
        this.t.setOnItemClickListener(this.F);
    }

    public final void T1() {
        CoreBaseFragment.c cVar = this.f6488f;
        if (cVar != null) {
            cVar.removeCallbacks(this.G);
        }
    }

    public final void U1() {
        CoreBaseFragment.c cVar = this.f6488f;
        if (cVar == null || this.B == 1) {
            return;
        }
        cVar.postDelayed(this.G, 1000L);
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void V(View view) {
        if (M0(view)) {
            int id = view.getId();
            if (id == R.id.btn_cancel_pay) {
                G1(view);
            } else {
                if (id != R.id.btn_pay) {
                    return;
                }
                I1(view);
            }
        }
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void W() {
        h0(this);
        R1();
        S1();
        z0(R.string.loading_text);
        j0();
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void X() {
        T1();
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void Z() {
        U1();
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public int getLayoutId() {
        return R.layout.fragment_contract_list_layout;
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void j0() {
        this.D.getBillList(r(), this.B);
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        T1();
        L0(this);
    }

    @m(threadMode = r.MAIN)
    public void subscribePayResult(EventPayStateVo eventPayStateVo) {
        H();
        if (!eventPayStateVo.isSuccess()) {
            G0(eventPayStateVo.getMsg());
            return;
        }
        this.f6483a = 1;
        j0();
        P1();
        E1(eventPayStateVo.getBillKey());
    }
}
