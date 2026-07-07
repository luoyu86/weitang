package com.chinavisionary.microtang.pre.fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;
import androidx.lifecycle.Observer;
import butterknife.BindView;
import butterknife.OnClick;
import c.e.a.d.x;
import c.e.c.c0.c.d;
import com.chinavisionary.core.app.base.CoreBaseFragment;
import com.chinavisionary.core.app.config.bo.LeftTitleToRightArrowVo;
import com.chinavisionary.core.app.net.base.dto.RequestErrDto;
import com.chinavisionary.core.weight.BaseSwipeRefreshLayout;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.base.BaseFragment;
import com.chinavisionary.microtang.contract.vo.UpdateContractEventVo;
import com.chinavisionary.microtang.pre.adapter.PreOrderDetailsAdapter;
import com.chinavisionary.microtang.pre.event.EventUpdateReserveList;
import com.chinavisionary.microtang.pre.model.ReserveModel;
import com.chinavisionary.microtang.pre.vo.ReserveDetailsVo;
import com.chinavisionary.microtang.pre.vo.ReserveItemVo;
import com.chinavisionary.microtang.web.WebFragment;
import com.chinavisionary.paymentlibrary.vo.EventPayStateVo;
import g.b.a.m;
import g.b.a.r;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class ReserveDetailsFragment extends BaseFragment<LeftTitleToRightArrowVo> {
    public ReserveDetailsVo B;
    public ReserveItemVo C;
    public ReserveModel D;
    public d E;
    public TextView F;
    public TextView G;
    public TextView H;
    public AppCompatButton I;
    public AppCompatButton J;
    public c.e.a.a.c.c.a K = new c.e.a.a.c.c.a() { // from class: c.e.c.c0.b.a
        @Override // c.e.a.a.c.c.a
        public final void onItemClickListener(View view, int i2) {
            this.f1401a.Q1(view, i2);
        }
    };
    public d.a L = new a();
    public Runnable M = new Runnable() { // from class: c.e.c.c0.b.b
        @Override // java.lang.Runnable
        public final void run() {
            this.f1402a.S1();
        }
    };

    @BindView(R.id.swipe_refresh_layout_details)
    public BaseSwipeRefreshLayout mBaseSwipeRefreshLayout;

    @BindView(R.id.tv_title)
    public TextView mTitleTv;

    public class a implements d.a {
        public a() {
        }

        @Override // c.e.c.c0.c.d.a
        public void addFragment(CoreBaseFragment coreBaseFragment) {
            ReserveDetailsFragment.this.d(coreBaseFragment, R.id.flayout_content);
        }

        @Override // c.e.c.c0.c.d.a
        public void hideAlertLoading() {
            ReserveDetailsFragment.this.H();
        }

        @Override // c.e.c.c0.c.d.a
        public void openActivityToClass(Class cls) {
            ReserveDetailsFragment.this.d0(cls);
        }

        @Override // c.e.c.c0.c.d.a
        public void refreshPage() {
            ReserveDetailsFragment.this.T1();
            ReserveDetailsFragment.this.j0();
        }

        @Override // c.e.c.c0.c.d.a
        public void showAlertLoading(int i2) {
            ReserveDetailsFragment.this.z0(i2);
        }

        @Override // c.e.c.c0.c.d.a
        public void showToast(int i2) {
            ReserveDetailsFragment.this.F0(i2);
        }

        @Override // c.e.c.c0.c.d.a
        public void switchFragment(CoreBaseFragment coreBaseFragment) {
            ReserveDetailsFragment.this.K0(coreBaseFragment, R.id.flayout_content);
        }

        @Override // c.e.c.c0.c.d.a
        public boolean userIsAuth() {
            return ReserveDetailsFragment.this.M();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: P1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void Q1(View view, int i2) {
        LeftTitleToRightArrowVo leftTitleToRightArrowVo = (LeftTitleToRightArrowVo) this.t.getList().get(i2);
        if (leftTitleToRightArrowVo.getOnlyKey() == 2000) {
            WebFragment webFragment = WebFragment.getInstance((String) leftTitleToRightArrowVo.getExtObj());
            webFragment.setTitle(x.getString(R.string.title_reserve_contract));
            K0(webFragment, R.id.flayout_content);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: R1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void S1() {
        if (this.B != null) {
            boolean z = false;
            Long lValueOf = Long.valueOf(System.currentTimeMillis());
            int status = this.B.getStatus();
            if (status == 1 || status == 5) {
                Long expireTime = status == 1 ? this.B.getExpireTime() : this.B.getReserveExpireTime();
                if (expireTime != null) {
                    long jLongValue = expireTime.longValue() - lValueOf.longValue();
                    if (jLongValue >= 0) {
                        this.B.setSurplusTime(y1(Long.valueOf(jLongValue / 1000)));
                        z = true;
                    }
                }
            }
            a2();
            if (z) {
                b2();
                c2();
            }
        }
    }

    public static ReserveDetailsFragment getInstance(@NonNull ReserveItemVo reserveItemVo) {
        ReserveDetailsFragment reserveDetailsFragment = new ReserveDetailsFragment();
        reserveDetailsFragment.setArguments(CoreBaseFragment.q(reserveItemVo.getPrimaryKey()));
        reserveDetailsFragment.U1(reserveItemVo);
        return reserveDetailsFragment;
    }

    public final void M1() {
        this.E.requestCancelPay(this.f6484b);
    }

    public final void T1() {
        k(new EventUpdateReserveList());
    }

    public final void U1(ReserveItemVo reserveItemVo) {
        this.C = reserveItemVo;
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void V(View view) {
        int id = view.getId();
        if (id == R.id.btn_action) {
            this.E.handleActionToReserveItemVoe(this.C);
        } else if (id == R.id.btn_action_cancel) {
            u0(x.getString(R.string.title_tip_cancel_pay));
        } else {
            if (id != R.id.tv_alert_confirm) {
                return;
            }
            M1();
        }
    }

    public final void V1() {
        View viewInflate = LayoutInflater.from(this.f6487e).inflate(R.layout.item_reserve_details_head_layout, (ViewGroup) this.r, false);
        this.F = (TextView) viewInflate.findViewById(R.id.tv_reserve_state);
        this.G = (TextView) viewInflate.findViewById(R.id.tv_reserve_state_center);
        this.H = (TextView) viewInflate.findViewById(R.id.tv_reserve_timer);
        this.J = (AppCompatButton) viewInflate.findViewById(R.id.btn_action);
        this.I = (AppCompatButton) viewInflate.findViewById(R.id.btn_action_cancel);
        this.J.setOnClickListener(this.y);
        this.I.setOnClickListener(this.y);
        this.I.setVisibility(8);
        this.H.setVisibility(8);
        this.t.addHeadView(viewInflate);
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void W() {
        this.mTitleTv.setText(R.string.title_pre_order_details);
        h0(this);
        Y1();
        Z1();
        V1();
        z0(R.string.loading_text);
        j0();
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    public final void W1(ReserveDetailsVo reserveDetailsVo) {
        H();
        this.B = reserveDetailsVo;
        X1(reserveDetailsVo.getStatusName(), reserveDetailsVo.getStatus());
        this.C.setStatus(reserveDetailsVo.getStatus());
        this.C.setStatusName(reserveDetailsVo.getStatusName());
        this.t.initListData((List<T>) this.E.getDetailsListData(reserveDetailsVo, s(), 2000));
        b2();
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void X() {
        a2();
    }

    public final void X1(String str, int i2) {
        boolean z;
        boolean z2;
        boolean z3;
        this.F.setText(x.getNotNullStr(str, ""));
        this.G.setText(x.getNotNullStr(str, ""));
        boolean z4 = true;
        if (i2 != 1) {
            if (i2 == 2) {
                this.J.setText(R.string.title_sign_reserve_contract);
            } else if (i2 == 5) {
                this.J.setText(R.string.title_sign_room);
                b2();
                c2();
                z4 = false;
                z = true;
                z2 = true;
                z3 = false;
            } else if (i2 != 8) {
                z = false;
                z2 = false;
                z3 = false;
            } else {
                this.J.setText(R.string.title_sign_room);
            }
            z4 = false;
            z = false;
            z2 = true;
            z3 = false;
        } else {
            this.J.setText(R.string.title_confirm_pay);
            b2();
            c2();
            z4 = false;
            z = true;
            z2 = true;
            z3 = true;
        }
        this.G.setVisibility(z4 ? 0 : 8);
        this.F.setVisibility(z4 ? 8 : 0);
        this.H.setVisibility(z ? 0 : 8);
        this.J.setVisibility(z2 ? 0 : 8);
        this.I.setVisibility(z3 ? 0 : 8);
    }

    public final void Y1() {
        this.mBaseSwipeRefreshLayout.setEnabled(false);
        this.r = this.mBaseSwipeRefreshLayout.getBaseRecyclerView();
        PreOrderDetailsAdapter preOrderDetailsAdapter = new PreOrderDetailsAdapter();
        this.t = preOrderDetailsAdapter;
        preOrderDetailsAdapter.setOnItemClickListener(this.K);
        this.t.setOnClickListener(this.y);
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void Z() {
        b2();
    }

    public final void Z1() {
        this.f6488f = new CoreBaseFragment.c(this);
        ReserveModel reserveModel = (ReserveModel) h(ReserveModel.class);
        this.D = reserveModel;
        d dVar = new d(reserveModel, this);
        this.E = dVar;
        dVar.setIView(this.L);
        this.D.getReserveDetailsVoLiveData().observe(this, new Observer() { // from class: c.e.c.c0.b.c
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f1403a.W1((ReserveDetailsVo) obj);
            }
        });
        this.D.getErrRequestLiveData().observe(this, new Observer() { // from class: c.e.c.c0.b.d
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f1404a.C((RequestErrDto) obj);
            }
        });
    }

    public final void a2() {
        CoreBaseFragment.c cVar = this.f6488f;
        if (cVar != null) {
            cVar.removeCallbacks(this.M);
        }
    }

    public final void b2() {
        if (this.f6488f != null) {
            a2();
            this.f6488f.postDelayed(this.M, 1000L);
        }
    }

    @OnClick({R.id.tv_back})
    public void backClick(View view) {
        n();
    }

    public final void c2() {
        ReserveDetailsVo reserveDetailsVo = this.B;
        if (reserveDetailsVo != null) {
            this.H.setText(reserveDetailsVo.getSurplusTime());
        }
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public int getLayoutId() {
        return R.layout.fragment_pre_order_details;
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void j0() {
        this.D.getReserveDetails(this.f6484b);
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        L0(this);
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        b2();
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment, androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        a2();
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
