package com.chinavisionary.microtang.contract.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
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
import com.chinavisionary.microtang.contract.vo.ContractPropertyStateVo;

/* JADX INFO: loaded from: classes.dex */
public class ContractPropertyStateAdapter extends LeftTitleToRightArrowAdapter {

    public static class ContractPropertyStateVh extends BaseRecyclerViewHolder<LeftTitleToRightArrowVo> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public View.OnClickListener f7098f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f7099g;

        @BindView(R.id.cb_abnormal)
        public CheckBox mAbnormalCb;

        @BindView(R.id.cb_need_repair)
        public CheckBox mNeedRepairCb;

        @BindView(R.id.cb_perfect)
        public CheckBox mPerfectCb;

        @BindView(R.id.tv_title)
        public TextView mTitleTv;

        public ContractPropertyStateVh(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }

        public void setData(LeftTitleToRightArrowVo leftTitleToRightArrowVo) {
            ContractPropertyStateVo contractPropertyStateVo = (ContractPropertyStateVo) leftTitleToRightArrowVo.getExtObj();
            int recognitionStatus = contractPropertyStateVo.getRecognitionStatus();
            this.mTitleTv.setText(x.getNotNullStr(contractPropertyStateVo.getAssetName(), ""));
            this.mNeedRepairCb.setChecked(recognitionStatus == 5);
            this.mPerfectCb.setChecked(recognitionStatus == 6);
            this.mAbnormalCb.setChecked(recognitionStatus == 3);
            if (!contractPropertyStateVo.isClick()) {
                this.mNeedRepairCb.setEnabled(false);
                this.mPerfectCb.setEnabled(false);
                this.mAbnormalCb.setEnabled(false);
                return;
            }
            this.mNeedRepairCb.setOnClickListener(null);
            this.mPerfectCb.setOnClickListener(null);
            this.mAbnormalCb.setOnClickListener(null);
            this.mNeedRepairCb.setTag(Integer.valueOf(this.f7099g));
            this.mPerfectCb.setTag(Integer.valueOf(this.f7099g));
            this.mAbnormalCb.setTag(Integer.valueOf(this.f7099g));
            this.mNeedRepairCb.setOnClickListener(this.f7098f);
            this.mPerfectCb.setOnClickListener(this.f7098f);
            this.mAbnormalCb.setOnClickListener(this.f7098f);
        }

        public void setOnClickListener(View.OnClickListener onClickListener) {
            this.f7098f = onClickListener;
        }

        public void setPosition(int i2) {
            this.f7099g = i2;
        }
    }

    public class ContractPropertyStateVh_ViewBinding implements Unbinder {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public ContractPropertyStateVh f7100b;

        @UiThread
        public ContractPropertyStateVh_ViewBinding(ContractPropertyStateVh contractPropertyStateVh, View view) {
            this.f7100b = contractPropertyStateVh;
            contractPropertyStateVh.mTitleTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_title, "field 'mTitleTv'", TextView.class);
            contractPropertyStateVh.mNeedRepairCb = (CheckBox) d.findRequiredViewAsType(view, R.id.cb_need_repair, "field 'mNeedRepairCb'", CheckBox.class);
            contractPropertyStateVh.mAbnormalCb = (CheckBox) d.findRequiredViewAsType(view, R.id.cb_abnormal, "field 'mAbnormalCb'", CheckBox.class);
            contractPropertyStateVh.mPerfectCb = (CheckBox) d.findRequiredViewAsType(view, R.id.cb_perfect, "field 'mPerfectCb'", CheckBox.class);
        }

        @Override // butterknife.Unbinder
        @CallSuper
        public void unbind() {
            ContractPropertyStateVh contractPropertyStateVh = this.f7100b;
            if (contractPropertyStateVh == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.f7100b = null;
            contractPropertyStateVh.mTitleTv = null;
            contractPropertyStateVh.mNeedRepairCb = null;
            contractPropertyStateVh.mAbnormalCb = null;
            contractPropertyStateVh.mPerfectCb = null;
        }
    }

    @Override // com.chinavisionary.core.app.base.LeftTitleToRightArrowAdapter
    public void q(RecyclerView.ViewHolder viewHolder, int i2) {
        ContractPropertyStateVh contractPropertyStateVh = (ContractPropertyStateVh) viewHolder;
        contractPropertyStateVh.setPosition(i2);
        contractPropertyStateVh.setData((LeftTitleToRightArrowVo) this.f6460b.get(i2));
    }

    @Override // com.chinavisionary.core.app.base.LeftTitleToRightArrowAdapter
    public RecyclerView.ViewHolder r(ViewGroup viewGroup, int i2) {
        View viewI = i(viewGroup, R.layout.item_contract_property_state_layout);
        ContractPropertyStateVh contractPropertyStateVh = new ContractPropertyStateVh(viewI);
        contractPropertyStateVh.setOnClickListener(this.f6461c);
        viewI.setTag(contractPropertyStateVh);
        return contractPropertyStateVh;
    }
}
