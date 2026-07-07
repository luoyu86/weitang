package com.chinavisionary.microtang.contract.adapter;

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
import com.chinavisionary.microtang.contract.vo.ContractListVo;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ContractListAdapter extends BaseRecyclerAdapter<ContractListVo> {

    public static class ContractListVh extends BaseRecyclerViewHolder<ContractListVo> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public View.OnClickListener f7094f;

        @BindView(R.id.btn_change_rent)
        public AppCompatButton mChangeRentBtn;

        @BindView(R.id.tv_contract_no)
        public TextView mContractNoTv;

        @BindView(R.id.tv_contract_time_value)
        public TextView mContractTimeTv;

        @BindView(R.id.tv_pay_countdown)
        public TextView mCountdownTimeTv;

        @BindView(R.id.tv_first_pay_title)
        public TextView mFirstPayTitleTv;

        @BindView(R.id.tv_first_pay_value)
        public TextView mFirstPayTv;

        @BindView(R.id.btn_keep_rent)
        public AppCompatButton mKeepRentBtn;

        @BindView(R.id.tv_month_rent_value)
        public TextView mMonthRentTv;

        @BindView(R.id.btn_action)
        public AppCompatButton mRentActionBtn;

        @BindView(R.id.btn_rent_change)
        public AppCompatButton mRentChangeBtn;

        @BindView(R.id.tv_room_name)
        public TextView mRoomNameTv;

        @BindView(R.id.tv_pay_state)
        public TextView mStateTv;

        public ContractListVh(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }

        public final String g(int i2) {
            switch (i2) {
                case 10:
                    return x.getString(R.string.title_confirm_contract_ext);
                case 11:
                    return x.getString(R.string.title_pay_first);
                case 12:
                case 14:
                case 16:
                default:
                    return null;
                case 13:
                    return x.getString(R.string.title_sign_room);
                case 15:
                case 17:
                case 18:
                    return x.getString(R.string.title_cat_rescission);
            }
        }

        public void setOnClickListener(View.OnClickListener onClickListener) {
            this.f7094f = onClickListener;
        }

        public void setData(ContractListVo contractListVo) {
            this.mRoomNameTv.setText(x.getNotNullStr(contractListVo.getAddress(), ""));
            boolean z = contractListVo.getFirstPayAmount() != null;
            this.mFirstPayTv.setVisibility(z ? 0 : 8);
            this.mFirstPayTitleTv.setVisibility(z ? 0 : 8);
            this.mFirstPayTv.setText(x.appendStringToResId(R.string.placeholder_rmb_china_unit, x.bigDecimalToString(contractListVo.getFirstPayAmount())));
            this.mMonthRentTv.setText(x.appendStringToResId(R.string.placeholder_rmb_china_unit, x.bigDecimalToString(contractListVo.getRentFee())));
            this.mContractNoTv.setText(x.getNotNullStr(contractListVo.getContractCode(), ""));
            this.mStateTv.setText(x.getNotNullStr(contractListVo.getContractStatusName(), ""));
            this.mContractTimeTv.setText(z.getTimeYYMMDD(contractListVo.getRentTermFrom()) + x.getString(R.string.title_time_middle_unit) + z.getTimeYYMMDD(contractListVo.getRentTermTo()));
            this.mCountdownTimeTv.setText(x.getNotNullStr(contractListVo.getSurplusTime(), ""));
            int contractStatus = contractListVo.getContractStatus();
            boolean zIsRentBackFlag = contractListVo.isRentBackFlag();
            this.mRentChangeBtn.setText((contractStatus == 11 || contractStatus == 10) ? R.string.title_cancel : R.string.title_apply_exit_rent);
            this.mRentChangeBtn.setVisibility(zIsRentBackFlag ? 0 : contractListVo.isChangeRentFlag() ? 4 : 8);
            this.mRentChangeBtn.setTag(Integer.valueOf(this.f6468a));
            this.mRentChangeBtn.setOnClickListener(null);
            this.mRentChangeBtn.setOnClickListener(this.f7094f);
            String strG = g(contractStatus);
            if (contractListVo.isRentBackInfoFlag()) {
                strG = x.getString(R.string.title_cat_rescission);
            }
            this.mRentActionBtn.setVisibility(x.isNotNull(strG) ? 0 : 8);
            this.mRentActionBtn.setText(x.getNotNullStr(strG, ""));
            this.mRentActionBtn.setTag(Integer.valueOf(this.f6468a));
            this.mRentActionBtn.setOnClickListener(null);
            this.mRentActionBtn.setOnClickListener(this.f7094f);
            this.mChangeRentBtn.setVisibility(contractListVo.isChangeRentFlag() ? 0 : 8);
            this.mChangeRentBtn.setTag(Integer.valueOf(this.f6468a));
            this.mChangeRentBtn.setOnClickListener(null);
            this.mChangeRentBtn.setOnClickListener(this.f7094f);
            this.mKeepRentBtn.setVisibility(contractListVo.isRenewalFlag() ? 0 : 8);
            this.mKeepRentBtn.setTag(Integer.valueOf(this.f6468a));
            this.mKeepRentBtn.setOnClickListener(null);
            this.mKeepRentBtn.setOnClickListener(this.f7094f);
        }
    }

    public class ContractListVh_ViewBinding implements Unbinder {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public ContractListVh f7095b;

        @UiThread
        public ContractListVh_ViewBinding(ContractListVh contractListVh, View view) {
            this.f7095b = contractListVh;
            contractListVh.mRoomNameTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_room_name, "field 'mRoomNameTv'", TextView.class);
            contractListVh.mFirstPayTitleTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_first_pay_title, "field 'mFirstPayTitleTv'", TextView.class);
            contractListVh.mFirstPayTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_first_pay_value, "field 'mFirstPayTv'", TextView.class);
            contractListVh.mMonthRentTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_month_rent_value, "field 'mMonthRentTv'", TextView.class);
            contractListVh.mContractNoTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_contract_no, "field 'mContractNoTv'", TextView.class);
            contractListVh.mStateTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_pay_state, "field 'mStateTv'", TextView.class);
            contractListVh.mContractTimeTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_contract_time_value, "field 'mContractTimeTv'", TextView.class);
            contractListVh.mCountdownTimeTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_pay_countdown, "field 'mCountdownTimeTv'", TextView.class);
            contractListVh.mRentActionBtn = (AppCompatButton) d.findRequiredViewAsType(view, R.id.btn_action, "field 'mRentActionBtn'", AppCompatButton.class);
            contractListVh.mRentChangeBtn = (AppCompatButton) d.findRequiredViewAsType(view, R.id.btn_rent_change, "field 'mRentChangeBtn'", AppCompatButton.class);
            contractListVh.mKeepRentBtn = (AppCompatButton) d.findRequiredViewAsType(view, R.id.btn_keep_rent, "field 'mKeepRentBtn'", AppCompatButton.class);
            contractListVh.mChangeRentBtn = (AppCompatButton) d.findRequiredViewAsType(view, R.id.btn_change_rent, "field 'mChangeRentBtn'", AppCompatButton.class);
        }

        @Override // butterknife.Unbinder
        @CallSuper
        public void unbind() {
            ContractListVh contractListVh = this.f7095b;
            if (contractListVh == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.f7095b = null;
            contractListVh.mRoomNameTv = null;
            contractListVh.mFirstPayTitleTv = null;
            contractListVh.mFirstPayTv = null;
            contractListVh.mMonthRentTv = null;
            contractListVh.mContractNoTv = null;
            contractListVh.mStateTv = null;
            contractListVh.mContractTimeTv = null;
            contractListVh.mCountdownTimeTv = null;
            contractListVh.mRentActionBtn = null;
            contractListVh.mRentChangeBtn = null;
            contractListVh.mKeepRentBtn = null;
            contractListVh.mChangeRentBtn = null;
        }
    }

    public ContractListAdapter() {
        addEmptyData();
    }

    public final void addEmptyData() {
        ContractListVo contractListVo = new ContractListVo();
        contractListVo.setContractStatus(34952);
        addDataToList(contractListVo);
    }

    @Override // com.chinavisionary.core.app.adapter.BaseRecyclerAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i2) {
        List<T> list = this.f6460b;
        if (list == 0 || list.isEmpty() || this.f6460b.size() != 1 || ((ContractListVo) this.f6460b.get(i2)).getContractStatus() != 34952) {
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
        ContractListVh contractListVh = (ContractListVh) viewHolder;
        contractListVh.setListPosition(i2);
        contractListVh.setData((ContractListVo) this.f6460b.get(i2));
        b(contractListVh, i2);
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
        ContractListVh contractListVh = new ContractListVh(i(viewGroup, R.layout.item_contract_list_layout));
        contractListVh.setOnClickListener(this.f6461c);
        return contractListVh;
    }
}
