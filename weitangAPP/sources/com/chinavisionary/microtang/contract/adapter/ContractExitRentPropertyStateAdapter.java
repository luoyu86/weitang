package com.chinavisionary.microtang.contract.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.UiThread;
import androidx.constraintlayout.widget.Group;
import androidx.recyclerview.widget.RecyclerView;
import b.c.d;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import c.e.a.d.x;
import com.chinavisionary.core.app.adapter.BaseRecyclerAdapter;
import com.chinavisionary.core.app.adapter.BaseRecyclerViewHolder;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.contract.vo.ContractExitRentPropertyStateVo;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ContractExitRentPropertyStateAdapter extends BaseRecyclerAdapter<ContractExitRentPropertyStateVo> {

    public static class ContractPropertyStateVh extends BaseRecyclerViewHolder<ContractExitRentPropertyStateVo> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public View.OnClickListener f7087f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f7088g;

        @BindView(R.id.cb_abnormal)
        public CheckBox mAbnormalCb;

        @BindView(R.id.tv_compensation_cost_value)
        public TextView mCompensationCostValueTv;

        @BindView(R.id.tv_fault_type_value)
        public TextView mFaultTypeValueTv;

        @BindView(R.id.tag_transition_group)
        public Group mGroup;

        @BindView(R.id.cb_perfect)
        public CheckBox mPerfectCb;

        @BindView(R.id.tv_title)
        public TextView mTitleTv;

        public ContractPropertyStateVh(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }

        public void g(ContractExitRentPropertyStateVo contractExitRentPropertyStateVo) {
            this.mTitleTv.setText(x.getNotNullStr(contractExitRentPropertyStateVo.getName(), ""));
            boolean z = !contractExitRentPropertyStateVo.isPerfect();
            this.mAbnormalCb.setEnabled(false);
            this.mAbnormalCb.setChecked(z);
            this.mPerfectCb.setEnabled(false);
            this.mPerfectCb.setChecked(contractExitRentPropertyStateVo.isPerfect());
            this.mGroup.setVisibility(z ? 0 : 8);
            this.mFaultTypeValueTv.setText(x.getNotNullStr(contractExitRentPropertyStateVo.getFaultTypeName(), ""));
            this.mCompensationCostValueTv.setText(x.bigDecimalToString(contractExitRentPropertyStateVo.getCompensationAmount()));
        }

        public void setOnClickListener(View.OnClickListener onClickListener) {
            this.f7087f = onClickListener;
        }

        public void setPosition(int i2) {
            this.f7088g = i2;
        }
    }

    public class ContractPropertyStateVh_ViewBinding implements Unbinder {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public ContractPropertyStateVh f7089b;

        @UiThread
        public ContractPropertyStateVh_ViewBinding(ContractPropertyStateVh contractPropertyStateVh, View view) {
            this.f7089b = contractPropertyStateVh;
            contractPropertyStateVh.mTitleTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_title, "field 'mTitleTv'", TextView.class);
            contractPropertyStateVh.mAbnormalCb = (CheckBox) d.findRequiredViewAsType(view, R.id.cb_abnormal, "field 'mAbnormalCb'", CheckBox.class);
            contractPropertyStateVh.mPerfectCb = (CheckBox) d.findRequiredViewAsType(view, R.id.cb_perfect, "field 'mPerfectCb'", CheckBox.class);
            contractPropertyStateVh.mGroup = (Group) d.findRequiredViewAsType(view, R.id.tag_transition_group, "field 'mGroup'", Group.class);
            contractPropertyStateVh.mFaultTypeValueTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_fault_type_value, "field 'mFaultTypeValueTv'", TextView.class);
            contractPropertyStateVh.mCompensationCostValueTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_compensation_cost_value, "field 'mCompensationCostValueTv'", TextView.class);
        }

        @Override // butterknife.Unbinder
        @CallSuper
        public void unbind() {
            ContractPropertyStateVh contractPropertyStateVh = this.f7089b;
            if (contractPropertyStateVh == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.f7089b = null;
            contractPropertyStateVh.mTitleTv = null;
            contractPropertyStateVh.mAbnormalCb = null;
            contractPropertyStateVh.mPerfectCb = null;
            contractPropertyStateVh.mGroup = null;
            contractPropertyStateVh.mFaultTypeValueTv = null;
            contractPropertyStateVh.mCompensationCostValueTv = null;
        }
    }

    public ContractExitRentPropertyStateAdapter() {
        ContractExitRentPropertyStateVo contractExitRentPropertyStateVo = new ContractExitRentPropertyStateVo();
        contractExitRentPropertyStateVo.setStatus(34952);
        addDataToList(contractExitRentPropertyStateVo);
    }

    @Override // com.chinavisionary.core.app.adapter.BaseRecyclerAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i2) {
        List<T> list = this.f6460b;
        if (list != 0 && list.size() == 1 && ((ContractExitRentPropertyStateVo) this.f6460b.get(i2)).getStatus() == 34952) {
            return 34952;
        }
        return super.getItemViewType(i2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i2) {
        if (viewHolder.getItemViewType() != 34952) {
            ContractPropertyStateVh contractPropertyStateVh = (ContractPropertyStateVh) viewHolder;
            contractPropertyStateVh.setPosition(i2);
            contractPropertyStateVh.g((ContractExitRentPropertyStateVo) this.f6460b.get(i2));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i2) {
        if (i2 == 34952) {
            return new BaseRecyclerAdapter.EmptyViewHolder(d(viewGroup));
        }
        View viewI = i(viewGroup, R.layout.item_contract_property_state);
        ContractPropertyStateVh contractPropertyStateVh = new ContractPropertyStateVh(viewI);
        contractPropertyStateVh.setOnClickListener(this.f6461c);
        viewI.setTag(contractPropertyStateVh);
        return contractPropertyStateVh;
    }
}
