package com.chinavisionary.microtang.contract.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import b.c.d;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import c.e.a.d.x;
import com.chinavisionary.core.app.adapter.BaseRecyclerViewHolder;
import com.chinavisionary.core.app.base.LeftTitleToRightArrowAdapter;
import com.chinavisionary.core.app.config.bo.LeftTitleToRightArrowVo;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.contract.vo.ContractCostDetailsVo;

/* JADX INFO: loaded from: classes.dex */
public class ContractCostDetailsAdapter extends LeftTitleToRightArrowAdapter {

    public static class CostDetailsVh extends BaseRecyclerViewHolder<LeftTitleToRightArrowVo> {

        @BindView(R.id.tv_exit_account_value)
        public TextView mAccountValueTv;

        @BindView(R.id.tv_exit_bank_value)
        public TextView mBankValueTv;

        @BindView(R.id.tv_exit_price_state_value)
        public TextView mExitPriceStateValueTv;

        @BindView(R.id.tv_exit_price_count)
        public TextView mPriceCountTv;

        public CostDetailsVh(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }

        public void setData(LeftTitleToRightArrowVo leftTitleToRightArrowVo) {
            ContractCostDetailsVo contractCostDetailsVo = (ContractCostDetailsVo) leftTitleToRightArrowVo.getExtObj();
            this.mPriceCountTv.setText(x.appendStringToResId(R.string.placeholder_rmb_china_unit, x.getNotNullStr(contractCostDetailsVo.getExitPrice(), "")));
            this.mAccountValueTv.setText(x.getNotNullStr(contractCostDetailsVo.getExitAccount(), ""));
            this.mBankValueTv.setText(x.getNotNullStr(contractCostDetailsVo.getExitBank(), ""));
            this.mExitPriceStateValueTv.setText(x.getNotNullStr(contractCostDetailsVo.getExitState(), ""));
        }
    }

    public class CostDetailsVh_ViewBinding implements Unbinder {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public CostDetailsVh f7080b;

        @UiThread
        public CostDetailsVh_ViewBinding(CostDetailsVh costDetailsVh, View view) {
            this.f7080b = costDetailsVh;
            costDetailsVh.mPriceCountTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_exit_price_count, "field 'mPriceCountTv'", TextView.class);
            costDetailsVh.mAccountValueTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_exit_account_value, "field 'mAccountValueTv'", TextView.class);
            costDetailsVh.mBankValueTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_exit_bank_value, "field 'mBankValueTv'", TextView.class);
            costDetailsVh.mExitPriceStateValueTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_exit_price_state_value, "field 'mExitPriceStateValueTv'", TextView.class);
        }

        @Override // butterknife.Unbinder
        @CallSuper
        public void unbind() {
            CostDetailsVh costDetailsVh = this.f7080b;
            if (costDetailsVh == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.f7080b = null;
            costDetailsVh.mPriceCountTv = null;
            costDetailsVh.mAccountValueTv = null;
            costDetailsVh.mBankValueTv = null;
            costDetailsVh.mExitPriceStateValueTv = null;
        }
    }

    @Override // com.chinavisionary.core.app.base.LeftTitleToRightArrowAdapter
    public void q(RecyclerView.ViewHolder viewHolder, int i2) {
        ((CostDetailsVh) viewHolder).setData((LeftTitleToRightArrowVo) this.f6460b.get(i2));
    }

    @Override // com.chinavisionary.core.app.base.LeftTitleToRightArrowAdapter
    public RecyclerView.ViewHolder r(ViewGroup viewGroup, int i2) {
        View viewInflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_exit_price_details, viewGroup, false);
        CostDetailsVh costDetailsVh = new CostDetailsVh(viewInflate);
        viewInflate.setTag(costDetailsVh);
        return costDetailsVh;
    }
}
