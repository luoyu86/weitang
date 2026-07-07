package com.chinavisionary.microtang.contract.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.appcompat.widget.AppCompatButton;
import androidx.recyclerview.widget.RecyclerView;
import b.c.d;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.chinavisionary.core.app.adapter.BaseRecyclerViewHolder;
import com.chinavisionary.core.app.base.LeftTitleToRightArrowAdapter;
import com.chinavisionary.core.app.config.bo.LeftTitleToRightArrowVo;
import com.chinavisionary.microtang.R;

/* JADX INFO: loaded from: classes.dex */
public class ContractListDetailsAdapter extends LeftTitleToRightArrowAdapter {

    public static class ContractListDetailsVh extends BaseRecyclerViewHolder<LeftTitleToRightArrowVo> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public View.OnClickListener f7096f;

        @BindView(R.id.btn_action)
        public AppCompatButton mActionBtn;

        @BindView(R.id.btn_action_change)
        public AppCompatButton mActionChangeBtn;

        public ContractListDetailsVh(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }

        public void setData(LeftTitleToRightArrowVo leftTitleToRightArrowVo) {
        }

        public void setOnClickListener(View.OnClickListener onClickListener) {
            this.f7096f = onClickListener;
        }
    }

    public class ContractListDetailsVh_ViewBinding implements Unbinder {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public ContractListDetailsVh f7097b;

        @UiThread
        public ContractListDetailsVh_ViewBinding(ContractListDetailsVh contractListDetailsVh, View view) {
            this.f7097b = contractListDetailsVh;
            contractListDetailsVh.mActionBtn = (AppCompatButton) d.findRequiredViewAsType(view, R.id.btn_action, "field 'mActionBtn'", AppCompatButton.class);
            contractListDetailsVh.mActionChangeBtn = (AppCompatButton) d.findRequiredViewAsType(view, R.id.btn_action_change, "field 'mActionChangeBtn'", AppCompatButton.class);
        }

        @Override // butterknife.Unbinder
        @CallSuper
        public void unbind() {
            ContractListDetailsVh contractListDetailsVh = this.f7097b;
            if (contractListDetailsVh == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.f7097b = null;
            contractListDetailsVh.mActionBtn = null;
            contractListDetailsVh.mActionChangeBtn = null;
        }
    }

    @Override // com.chinavisionary.core.app.base.LeftTitleToRightArrowAdapter
    public void q(RecyclerView.ViewHolder viewHolder, int i2) {
        ((ContractListDetailsVh) viewHolder).setData((LeftTitleToRightArrowVo) this.f6460b.get(i2));
    }

    @Override // com.chinavisionary.core.app.base.LeftTitleToRightArrowAdapter
    public RecyclerView.ViewHolder r(ViewGroup viewGroup, int i2) {
        View viewInflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_contract_list_details, viewGroup, false);
        ContractListDetailsVh contractListDetailsVh = new ContractListDetailsVh(viewInflate);
        contractListDetailsVh.setOnClickListener(this.f6461c);
        viewInflate.setTag(contractListDetailsVh);
        return contractListDetailsVh;
    }
}
