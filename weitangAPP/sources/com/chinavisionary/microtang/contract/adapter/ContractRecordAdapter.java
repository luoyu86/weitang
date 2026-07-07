package com.chinavisionary.microtang.contract.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.UiThread;
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
import com.chinavisionary.microtang.contract.vo.ContractVo;
import java.text.SimpleDateFormat;

/* JADX INFO: loaded from: classes.dex */
public class ContractRecordAdapter extends BaseRecyclerAdapter<ContractVo> {

    public static class ContractRecordVH extends BaseRecyclerViewHolder<ContractVo> {

        @BindView(R.id.btn_cancel_pay)
        public Button mCancelPayBtn;

        @BindView(R.id.tv_contract_no_value)
        public TextView mContractNoTv;

        @BindView(R.id.tv_contract_time_value)
        public TextView mContractTimeTv;

        @BindView(R.id.btn_exit)
        public Button mExitBtn;

        @BindView(R.id.btn_keep)
        public Button mKeepBtn;

        @BindView(R.id.tv_contract_tip)
        public TextView mStateTv;

        @BindView(R.id.btn_wait_pay)
        public Button mWaitPayBtn;

        @BindView(R.id.btn_wait_sign_contract)
        public Button mWaitSignContractBtn;

        public ContractRecordVH(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }

        public final void g(Integer num, Integer num2, String str) {
            j(false);
            if (num == null) {
                h();
                i();
                return;
            }
            int iIntValue = num.intValue();
            if (iIntValue == 1) {
                h();
                i();
                this.mStateTv.setVisibility(0);
                return;
            }
            if (iIntValue == 2) {
                i();
                this.mExitBtn.setVisibility(0);
                this.mKeepBtn.setVisibility(0);
                this.mStateTv.setVisibility(8);
                return;
            }
            if (iIntValue == 11) {
                h();
                this.mWaitPayBtn.setVisibility(0);
                this.mCancelPayBtn.setVisibility(0);
                this.mStateTv.setVisibility(0);
                return;
            }
            if (iIntValue == 12) {
                h();
                i();
                this.mStateTv.setVisibility(0);
            } else if (iIntValue == 15) {
                h();
                i();
                this.mStateTv.setVisibility(0);
            } else {
                if (iIntValue != 16) {
                    return;
                }
                j(true);
                this.mStateTv.setVisibility(8);
                h();
                i();
            }
        }

        public final void h() {
            this.mExitBtn.setVisibility(8);
            this.mKeepBtn.setVisibility(8);
        }

        public final void i() {
            this.mWaitPayBtn.setVisibility(8);
            this.mCancelPayBtn.setVisibility(8);
        }

        public final void j(boolean z) {
            this.mWaitSignContractBtn.setVisibility(z ? 0 : 8);
        }

        public void k(ContractVo contractVo) {
            this.mExitBtn.setTag(contractVo.getRentKey());
            this.mWaitPayBtn.setTag(contractVo.getRentKey());
            this.mCancelPayBtn.setTag(contractVo.getRentKey());
            this.mWaitSignContractBtn.setTag(contractVo.getRentKey());
            this.mKeepBtn.setTag(contractVo);
            g(contractVo.getStatus(), contractVo.getRentStatus(), contractVo.getRentStatusName());
            this.mContractNoTv.setText(x.getNotNullStr(contractVo.getContractCode(), ""));
            StringBuilder sb = new StringBuilder();
            Long rentStart = contractVo.getRentStart();
            SimpleDateFormat simpleDateFormat = z.f1246g;
            sb.append(z.getTime(rentStart, simpleDateFormat));
            sb.append(x.getString(R.string.title_time_middle_unit));
            sb.append(z.getTime(contractVo.getRentEnd(), simpleDateFormat));
            this.mContractTimeTv.setText(sb.toString());
            this.mStateTv.setText(x.getNotNullStr(contractVo.getStatusName(), ""));
        }
    }

    public class ContractRecordVH_ViewBinding implements Unbinder {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public ContractRecordVH f7101b;

        @UiThread
        public ContractRecordVH_ViewBinding(ContractRecordVH contractRecordVH, View view) {
            this.f7101b = contractRecordVH;
            contractRecordVH.mExitBtn = (Button) d.findRequiredViewAsType(view, R.id.btn_exit, "field 'mExitBtn'", Button.class);
            contractRecordVH.mKeepBtn = (Button) d.findRequiredViewAsType(view, R.id.btn_keep, "field 'mKeepBtn'", Button.class);
            contractRecordVH.mWaitPayBtn = (Button) d.findRequiredViewAsType(view, R.id.btn_wait_pay, "field 'mWaitPayBtn'", Button.class);
            contractRecordVH.mCancelPayBtn = (Button) d.findRequiredViewAsType(view, R.id.btn_cancel_pay, "field 'mCancelPayBtn'", Button.class);
            contractRecordVH.mWaitSignContractBtn = (Button) d.findRequiredViewAsType(view, R.id.btn_wait_sign_contract, "field 'mWaitSignContractBtn'", Button.class);
            contractRecordVH.mContractTimeTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_contract_time_value, "field 'mContractTimeTv'", TextView.class);
            contractRecordVH.mContractNoTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_contract_no_value, "field 'mContractNoTv'", TextView.class);
            contractRecordVH.mStateTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_contract_tip, "field 'mStateTv'", TextView.class);
        }

        @Override // butterknife.Unbinder
        @CallSuper
        public void unbind() {
            ContractRecordVH contractRecordVH = this.f7101b;
            if (contractRecordVH == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.f7101b = null;
            contractRecordVH.mExitBtn = null;
            contractRecordVH.mKeepBtn = null;
            contractRecordVH.mWaitPayBtn = null;
            contractRecordVH.mCancelPayBtn = null;
            contractRecordVH.mWaitSignContractBtn = null;
            contractRecordVH.mContractTimeTv = null;
            contractRecordVH.mContractNoTv = null;
            contractRecordVH.mStateTv = null;
        }
    }

    @Override // com.chinavisionary.core.app.adapter.BaseRecyclerAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f6460b.size() + e();
    }

    @Override // com.chinavisionary.core.app.adapter.BaseRecyclerAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i2) {
        if (1 == this.f6460b.size() && i2 == 0 && ((ContractVo) this.f6460b.get(i2)).getRentEnd() == null && x.isNullStr(((ContractVo) this.f6460b.get(i2)).getContractCode()) && ((ContractVo) this.f6460b.get(i2)).getStatus() == null) {
            return 34952;
        }
        return super.getItemViewType(i2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i2) {
        int itemViewType = viewHolder.getItemViewType();
        if (itemViewType == 34952 || itemViewType == 39321) {
            return;
        }
        ContractRecordVH contractRecordVH = (ContractRecordVH) viewHolder;
        contractRecordVH.k((ContractVo) this.f6460b.get(i2));
        p(contractRecordVH.mExitBtn);
        p(contractRecordVH.mKeepBtn);
        p(contractRecordVH.mWaitPayBtn);
        p(contractRecordVH.mCancelPayBtn);
        p(contractRecordVH.mWaitSignContractBtn);
        b(contractRecordVH, i2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i2) {
        if (i2 == 34952) {
            return new BaseRecyclerAdapter.EmptyViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_empty_contract_layout, viewGroup, false));
        }
        if (i2 == 39321) {
            return new BaseRecyclerAdapter.FooterViewHolder(f(viewGroup));
        }
        View viewInflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_contract_record, viewGroup, false);
        ContractRecordVH contractRecordVH = new ContractRecordVH(viewInflate);
        viewInflate.setTag(contractRecordVH);
        return contractRecordVH;
    }

    public final void p(Button button) {
        button.setOnClickListener(null);
        View.OnClickListener onClickListener = this.f6461c;
        if (onClickListener != null) {
            button.setOnClickListener(onClickListener);
        }
    }
}
