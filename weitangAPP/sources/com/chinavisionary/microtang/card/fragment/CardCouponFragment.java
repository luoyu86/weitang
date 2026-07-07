package com.chinavisionary.microtang.card.fragment;

import android.view.View;
import butterknife.BindView;
import com.chinavisionary.core.weight.BaseSwipeRefreshLayout;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.base.BaseFragment;
import com.chinavisionary.microtang.room.adapter.SaleAdapter;
import com.chinavisionary.microtang.room.vo.SaleReceiverVo;
import com.tom_roush.pdfbox.contentstream.operator.OperatorName;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class CardCouponFragment extends BaseFragment {
    public int B;

    @BindView(R.id.swipe_refresh_layout)
    public BaseSwipeRefreshLayout mReceiveSaleRecyclerView;

    public static CardCouponFragment getInstance(int i2) {
        CardCouponFragment cardCouponFragment = new CardCouponFragment();
        cardCouponFragment.E1(i2);
        return cardCouponFragment;
    }

    public final void E1(int i2) {
        this.B = i2;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    public final void F1() {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < 10; i2++) {
            SaleReceiverVo saleReceiverVo = new SaleReceiverVo();
            saleReceiverVo.setCost("2" + i2);
            saleReceiverVo.setKey(OperatorName.SET_FLATNESS + i2);
            saleReceiverVo.setUseRule("房租缴费时即可抵扣");
            saleReceiverVo.setCouponCategory("满减券");
            saleReceiverVo.setValidDate(Long.valueOf(System.currentTimeMillis()));
            saleReceiverVo.setUnavailable(true);
            saleReceiverVo.setUnavailableReason("订单不可用");
            arrayList.add(saleReceiverVo);
        }
        this.t.initListData(arrayList);
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void V(View view) {
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void W() {
        this.mReceiveSaleRecyclerView.setBackgroundColor(getResources().getColor(R.color.colorF8F8F8));
        this.r = this.mReceiveSaleRecyclerView.getBaseRecyclerView();
        this.t = new SaleAdapter(false);
        F1();
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public int getLayoutId() {
        return R.layout.fragment_swipe_refresh;
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void j0() {
    }
}
