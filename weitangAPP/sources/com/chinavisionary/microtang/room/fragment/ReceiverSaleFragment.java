package com.chinavisionary.microtang.room.fragment;

import android.view.View;
import butterknife.BindView;
import butterknife.OnClick;
import com.chinavisionary.core.app.base.CoreBaseFragment;
import com.chinavisionary.core.weight.BaseRecyclerView;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.base.BaseFragment;
import com.chinavisionary.microtang.room.adapter.SaleAdapter;
import com.chinavisionary.microtang.room.vo.SaleReceiverVo;
import com.tom_roush.pdfbox.contentstream.operator.OperatorName;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class ReceiverSaleFragment extends BaseFragment<SaleReceiverVo> {

    @BindView(R.id.view_bg)
    public View mBgView;

    @BindView(R.id.recycler_receive_sale)
    public BaseRecyclerView mReceiveSaleRecyclerView;

    public static ReceiverSaleFragment getInstance(String str) {
        ReceiverSaleFragment receiverSaleFragment = new ReceiverSaleFragment();
        receiverSaleFragment.setArguments(CoreBaseFragment.q(str));
        return receiverSaleFragment;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    public final void E1() {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < 10; i2++) {
            SaleReceiverVo saleReceiverVo = new SaleReceiverVo();
            saleReceiverVo.setCost("2" + i2);
            saleReceiverVo.setKey(OperatorName.SET_FLATNESS + i2);
            saleReceiverVo.setUseRule("房租缴费时即可抵扣");
            saleReceiverVo.setCouponCategory("满减券");
            saleReceiverVo.setValidDate(Long.valueOf(System.currentTimeMillis()));
            arrayList.add(saleReceiverVo);
        }
        this.t.initListData(arrayList);
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void V(View view) {
        view.getId();
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void W() {
        this.r = this.mReceiveSaleRecyclerView;
        SaleAdapter saleAdapter = new SaleAdapter(true);
        this.t = saleAdapter;
        saleAdapter.setOnClickListener(this.y);
        E1();
    }

    @OnClick({R.id.img_close, R.id.view_transparent_bg})
    public void closeFragment(View view) {
        n();
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public int getLayoutId() {
        return R.layout.fragment_receiver_sale;
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void j0() {
    }
}
