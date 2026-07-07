package com.chinavisionary.microtang.bill.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.UiThread;
import androidx.appcompat.widget.AppCompatButton;
import androidx.recyclerview.widget.RecyclerView;
import b.c.d;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import c.e.a.d.x;
import c.e.a.d.z;
import com.chinavisionary.core.app.adapter.BaseRecyclerAdapter;
import com.chinavisionary.core.app.adapter.BaseRecyclerViewHolder;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.bill.vo.BillVo;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class LifeBillAdapter extends BaseRecyclerAdapter<BillVo> {

    public static class BillVh extends BaseRecyclerViewHolder<BillVo> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public View.OnClickListener f6860f;

        @BindView(R.id.tv_bill_state)
        public TextView mBillStateTv;

        @BindView(R.id.tv_title)
        public TextView mBillTitleTv;

        @BindView(R.id.tv_unit_title)
        public TextView mBillUnitTitleTv;

        @BindView(R.id.tv_unit_value)
        public TextView mBillUnitValueTv;

        @BindView(R.id.tv_bill_date)
        public TextView mBuyNumberTitleTv;

        @BindView(R.id.tv_bill_date_value)
        public TextView mBuyNumberTv;

        @BindView(R.id.btn_cancel_pay)
        public AppCompatButton mCancelPayBtn;

        @BindView(R.id.btn_pay)
        public AppCompatButton mPayBtn;

        @BindView(R.id.tv_pay_countdown)
        public TextView mPayCountdownTv;

        @BindView(R.id.tv_bill_pay_time)
        public TextView mPayDateTitleTv;

        @BindView(R.id.tv_bill_pay_time_value)
        public TextView mPayDateValueTv;

        @BindView(R.id.tv_bill_price_value)
        public TextView mPriceValueTv;

        @BindView(R.id.view_split_line)
        public View mRechargePriceLineTv;

        @BindView(R.id.tv_pay_date)
        public TextView mRechargePriceTitleTv;

        @BindView(R.id.tv_pay_date_value)
        public TextView mRechargePriceTv;

        public BillVh(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }

        public void g(BillVo billVo) {
            this.mPriceValueTv.setText(x.appendStringToResId(R.string.placeholder_rmb_china_unit, x.bigDecimalToPlainString(billVo.getAmount())));
            this.mBillUnitValueTv.setText(x.appendStringToResId(R.string.placeholder_rmb_china_unit, billVo.getUnitPrice()));
            this.mRechargePriceTv.setText(x.appendStringToResId(R.string.placeholder_rmb_china_unit, x.bigDecimalToPlainString(billVo.getAmount())));
            this.mBuyNumberTv.setText(x.getNotNullStr(billVo.getBuyNumber(), ""));
            this.mBillTitleTv.setText(x.getNotNullStr(billVo.getBody(), ""));
            this.mBillStateTv.setText(x.getNotNullStr(billVo.getBillStatusName(), ""));
            boolean zIsNotNull = x.isNotNull(billVo.getBuyNumber());
            this.mBuyNumberTitleTv.setVisibility(zIsNotNull ? 0 : 8);
            this.mBuyNumberTv.setVisibility(zIsNotNull ? 0 : 8);
            this.mRechargePriceTv.setVisibility(zIsNotNull ? 0 : 8);
            this.mRechargePriceTitleTv.setVisibility(zIsNotNull ? 0 : 8);
            this.mRechargePriceLineTv.setVisibility(zIsNotNull ? 0 : 8);
            boolean zIsNotNull2 = x.isNotNull(billVo.getUnitPrice());
            this.mBillUnitTitleTv.setVisibility(zIsNotNull2 ? 0 : 8);
            this.mBillUnitValueTv.setVisibility(zIsNotNull2 ? 0 : 8);
            boolean z = billVo.getBillStatus() == 0;
            this.mPayCountdownTv.setVisibility(z ? 0 : 8);
            this.mPayCountdownTv.setText(x.getNotNullStr(billVo.getSurplusTime(), ""));
            this.mPayBtn.setVisibility(z ? 0 : 8);
            this.mPayBtn.setOnClickListener(null);
            this.mPayBtn.setOnClickListener(this.f6860f);
            this.mPayBtn.setTag(billVo);
            boolean z2 = billVo.getBillStatus() == 1;
            this.mPayDateTitleTv.setVisibility(z2 ? 0 : 8);
            this.mPayDateValueTv.setVisibility(z2 ? 0 : 8);
            this.mPayDateValueTv.setText(z.getTime(billVo.getPayDate(), z.f1243d));
        }

        public void setOnClickListener(View.OnClickListener onClickListener) {
            this.f6860f = onClickListener;
        }
    }

    public class BillVh_ViewBinding implements Unbinder {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public BillVh f6861b;

        @UiThread
        public BillVh_ViewBinding(BillVh billVh, View view) {
            this.f6861b = billVh;
            billVh.mBillStateTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_bill_state, "field 'mBillStateTv'", TextView.class);
            billVh.mBillTitleTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_title, "field 'mBillTitleTv'", TextView.class);
            billVh.mPayBtn = (AppCompatButton) d.findRequiredViewAsType(view, R.id.btn_pay, "field 'mPayBtn'", AppCompatButton.class);
            billVh.mCancelPayBtn = (AppCompatButton) d.findRequiredViewAsType(view, R.id.btn_cancel_pay, "field 'mCancelPayBtn'", AppCompatButton.class);
            billVh.mPriceValueTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_bill_price_value, "field 'mPriceValueTv'", TextView.class);
            billVh.mRechargePriceTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_pay_date_value, "field 'mRechargePriceTv'", TextView.class);
            billVh.mRechargePriceTitleTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_pay_date, "field 'mRechargePriceTitleTv'", TextView.class);
            billVh.mRechargePriceLineTv = d.findRequiredView(view, R.id.view_split_line, "field 'mRechargePriceLineTv'");
            billVh.mBuyNumberTitleTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_bill_date, "field 'mBuyNumberTitleTv'", TextView.class);
            billVh.mBuyNumberTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_bill_date_value, "field 'mBuyNumberTv'", TextView.class);
            billVh.mBillUnitTitleTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_unit_title, "field 'mBillUnitTitleTv'", TextView.class);
            billVh.mBillUnitValueTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_unit_value, "field 'mBillUnitValueTv'", TextView.class);
            billVh.mPayCountdownTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_pay_countdown, "field 'mPayCountdownTv'", TextView.class);
            billVh.mPayDateTitleTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_bill_pay_time, "field 'mPayDateTitleTv'", TextView.class);
            billVh.mPayDateValueTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_bill_pay_time_value, "field 'mPayDateValueTv'", TextView.class);
        }

        @Override // butterknife.Unbinder
        @CallSuper
        public void unbind() {
            BillVh billVh = this.f6861b;
            if (billVh == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.f6861b = null;
            billVh.mBillStateTv = null;
            billVh.mBillTitleTv = null;
            billVh.mPayBtn = null;
            billVh.mCancelPayBtn = null;
            billVh.mPriceValueTv = null;
            billVh.mRechargePriceTv = null;
            billVh.mRechargePriceTitleTv = null;
            billVh.mRechargePriceLineTv = null;
            billVh.mBuyNumberTitleTv = null;
            billVh.mBuyNumberTv = null;
            billVh.mBillUnitTitleTv = null;
            billVh.mBillUnitValueTv = null;
            billVh.mPayCountdownTv = null;
            billVh.mPayDateTitleTv = null;
            billVh.mPayDateValueTv = null;
        }
    }

    public LifeBillAdapter() {
        BillVo billVo = new BillVo();
        billVo.setBillStatus(34952);
        addDataToList(billVo);
    }

    @Override // com.chinavisionary.core.app.adapter.BaseRecyclerAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i2) {
        List<T> list = this.f6460b;
        if (list == 0 || list.isEmpty() || this.f6460b.size() != 1 || ((BillVo) this.f6460b.get(i2)).getBillStatus() != 34952) {
            return super.getItemViewType(i2);
        }
        return 34952;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i2) {
        int itemViewType = viewHolder.getItemViewType();
        if (itemViewType == 34952 || itemViewType == 39321) {
            return;
        }
        BillVh billVh = (BillVh) viewHolder;
        billVh.g((BillVo) this.f6460b.get(i2));
        b(billVh, i2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i2) {
        if (i2 == 34952) {
            return new BaseRecyclerAdapter.EmptyViewHolder(d(viewGroup));
        }
        if (i2 == 39321) {
            return new BaseRecyclerAdapter.FooterViewHolder(f(viewGroup));
        }
        BillVh billVh = new BillVh(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_life_bill_layout, viewGroup, false));
        billVh.setOnClickListener(this.f6461c);
        return billVh;
    }
}
