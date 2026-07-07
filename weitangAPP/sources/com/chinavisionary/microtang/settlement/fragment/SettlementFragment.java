package com.chinavisionary.microtang.settlement.fragment;

import android.view.View;
import android.widget.TextView;
import butterknife.BindView;
import c.e.c.y.d.a;
import com.chinavisionary.core.weight.BaseSwipeRefreshLayout;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.base.BaseFragment;
import com.chinavisionary.microtang.buycart.adapter.BuyCartAdapter;
import com.chinavisionary.microtang.buycart.vo.BuyCartVo;

/* JADX INFO: loaded from: classes2.dex */
public class SettlementFragment extends BaseFragment<BuyCartVo> {

    @BindView(R.id.swipe_refresh_layout)
    public BaseSwipeRefreshLayout mBaseSwipeRefreshLayout;

    @BindView(R.id.tv_title)
    public TextView mTitleTv;

    public static SettlementFragment getInstance() {
        return new SettlementFragment();
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    public final void E1() {
        this.t.addDataToList((T) a.getFoodSettlementList(2));
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void V(View view) {
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void W() {
        this.mTitleTv.setText("结算");
        this.r = this.mBaseSwipeRefreshLayout.getBaseRecyclerView();
        this.t = new BuyCartAdapter(4);
        E1();
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public int getLayoutId() {
        return R.layout.fragment_recycler;
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void j0() {
    }
}
