package com.chinavisionary.microtang.contract.fragment;

import android.view.View;
import android.widget.TextView;
import androidx.lifecycle.Observer;
import butterknife.BindView;
import butterknife.OnClick;
import c.e.a.a.c.c.a;
import com.chinavisionary.core.app.base.CoreBaseFragment;
import com.chinavisionary.core.app.net.base.dto.RequestErrDto;
import com.chinavisionary.core.app.net.base.dto.ResponseRowsVo;
import com.chinavisionary.core.weight.BaseSwipeRefreshLayout;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.base.BaseFragment;
import com.chinavisionary.microtang.contract.adapter.ContractExitRentPropertyStateAdapter;
import com.chinavisionary.microtang.contract.fragment.ContractExitRentPropertyStateFragment;
import com.chinavisionary.microtang.contract.model.ContractModel;
import com.chinavisionary.microtang.contract.vo.ContractExitRentPropertyStateVo;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ContractExitRentPropertyStateFragment extends BaseFragment<ContractExitRentPropertyStateVo> {
    public ContractModel B;
    public a C = new a() { // from class: c.e.c.o.c.n
        @Override // c.e.a.a.c.c.a
        public final void onItemClickListener(View view, int i2) {
            ContractExitRentPropertyStateFragment.G1(view, i2);
        }
    };

    @BindView(R.id.swipe_refresh_layout)
    public BaseSwipeRefreshLayout mSwipeRefreshLayout;

    @BindView(R.id.tv_title)
    public TextView mTitleTv;

    public static /* synthetic */ void G1(View view, int i2) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: H1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void I1(ResponseRowsVo responseRowsVo) {
        N1();
        F1(responseRowsVo.getRows());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: J1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void K1(RequestErrDto requestErrDto) {
        N1();
        C(requestErrDto);
    }

    public static ContractExitRentPropertyStateFragment getInstance(String str) {
        ContractExitRentPropertyStateFragment contractExitRentPropertyStateFragment = new ContractExitRentPropertyStateFragment();
        contractExitRentPropertyStateFragment.setArguments(CoreBaseFragment.q(str));
        return contractExitRentPropertyStateFragment;
    }

    public final void E1(View view, boolean z) {
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    public final void F1(List<ContractExitRentPropertyStateVo> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        this.t.initListData((List<T>) list);
    }

    public final void L1() {
        ContractModel contractModel = (ContractModel) h(ContractModel.class);
        this.B = contractModel;
        contractModel.getExitRentPropertyList().observe(this, new Observer() { // from class: c.e.c.o.c.l
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f1756a.I1((ResponseRowsVo) obj);
            }
        });
        this.B.getErrRequestLiveData().observe(this, new Observer() { // from class: c.e.c.o.c.m
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f1758a.K1((RequestErrDto) obj);
            }
        });
    }

    public final void M1() {
        this.r = this.mSwipeRefreshLayout.getBaseRecyclerView();
        ContractExitRentPropertyStateAdapter contractExitRentPropertyStateAdapter = new ContractExitRentPropertyStateAdapter();
        this.t = contractExitRentPropertyStateAdapter;
        contractExitRentPropertyStateAdapter.setOnClickListener(this.y);
        this.t.setOnItemClickListener(this.C);
    }

    public final void N1() {
        H();
        this.mSwipeRefreshLayout.setRefreshing(false);
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void V(View view) {
        int id = view.getId();
        if (id == R.id.cb_abnormal) {
            E1(view, false);
        } else {
            if (id != R.id.cb_perfect) {
                return;
            }
            E1(view, true);
        }
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void W() {
        this.mTitleTv.setText(R.string.title_exit_rent_property_state);
        L1();
        M1();
        j0();
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
        z0(R.string.loading_text);
        this.B.getContractExitRentPropertyList(this.f6484b);
    }
}
