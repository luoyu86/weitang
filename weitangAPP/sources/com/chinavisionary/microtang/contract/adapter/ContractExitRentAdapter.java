package com.chinavisionary.microtang.contract.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.appcompat.widget.AppCompatEditText;
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
import com.chinavisionary.microtang.contract.vo.ExitRentVo;
import com.nex3z.flowlayout.FlowLayout;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ContractExitRentAdapter extends LeftTitleToRightArrowAdapter {

    public static class ContractExitRentVh extends BaseRecyclerViewHolder<LeftTitleToRightArrowVo> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public LinearLayout.LayoutParams f7081f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public View.OnClickListener f7082g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f7083h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f7084i;
        public int j;
        public List<LeftTitleToRightArrowVo> k;
        public int l;

        @BindView(R.id.flow_layout_exit_reason)
        public FlowLayout mExitReasonFlowLayout;

        @BindView(R.id.edt_input_reason)
        public AppCompatEditText mReasonEdt;

        public class a implements TextWatcher {
            public a() {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                ((ExitRentVo) ((LeftTitleToRightArrowVo) ContractExitRentVh.this.k.get(ContractExitRentVh.this.l)).getExtObj()).setReason(ContractExitRentVh.this.mReasonEdt.getText().toString());
            }
        }

        public ContractExitRentVh(View view) {
            super(view);
            this.f7084i = -1;
            this.j = -1;
            ButterKnife.bind(this, view);
            this.f7084i = view.getResources().getColor(R.color.tab_item_select_color);
            this.j = view.getResources().getColor(R.color.colore757575);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            this.f7081f = layoutParams;
            layoutParams.rightMargin = view.getResources().getDimensionPixelSize(R.dimen.dp_8);
            this.f7083h = view.getResources().getDimensionPixelSize(R.dimen.dp_6);
            this.mReasonEdt.addTextChangedListener(new a());
        }

        public final CheckBox i(Context context, ExitRentVo.ExitRentTag exitRentTag, int i2) {
            CheckBox checkBox = new CheckBox(context);
            checkBox.setLayoutParams(this.f7081f);
            checkBox.setTag(exitRentTag);
            checkBox.setId(R.id.id_exit_reason_cb);
            checkBox.setOnClickListener(this.f7082g);
            checkBox.setTag(R.id.id_exit_reason_cb, Integer.valueOf(this.l));
            checkBox.setTag(R.id.id_exit_reason_cb_index, Integer.valueOf(i2));
            checkBox.setButtonDrawable((Drawable) null);
            boolean zIsSelect = exitRentTag.isSelect();
            checkBox.setChecked(exitRentTag.isSelect());
            checkBox.setBackgroundResource(zIsSelect ? R.drawable.bg_btn_store_6_radius : R.drawable.bg_btn_store_grad_6_radius);
            checkBox.setTextColor(zIsSelect ? this.f7084i : this.j);
            checkBox.setText(x.getNotNullStr(exitRentTag.getTagValue(), ""));
            int i3 = this.f7083h;
            checkBox.setPadding(i3, i3, i3, i3);
            return checkBox;
        }

        public void setData(LeftTitleToRightArrowVo leftTitleToRightArrowVo) {
            ExitRentVo exitRentVo = (ExitRentVo) leftTitleToRightArrowVo.getExtObj();
            this.mReasonEdt.setText(x.getNotNullStr(exitRentVo.getReason(), ""));
            List<ExitRentVo.ExitRentTag> tags = exitRentVo.getTags();
            this.mExitReasonFlowLayout.removeAllViews();
            if (tags == null || tags.isEmpty()) {
                return;
            }
            int size = tags.size();
            for (int i2 = 0; i2 < size; i2++) {
                ExitRentVo.ExitRentTag exitRentTag = tags.get(i2);
                FlowLayout flowLayout = this.mExitReasonFlowLayout;
                flowLayout.addView(i(flowLayout.getContext(), exitRentTag, i2));
            }
        }

        public void setLeftTitleToRightArrowVos(List<LeftTitleToRightArrowVo> list) {
            this.k = list;
        }

        public void setOnClickListener(View.OnClickListener onClickListener) {
            this.f7082g = onClickListener;
        }

        public void setPosition(int i2) {
            this.l = i2;
        }
    }

    public class ContractExitRentVh_ViewBinding implements Unbinder {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public ContractExitRentVh f7086b;

        @UiThread
        public ContractExitRentVh_ViewBinding(ContractExitRentVh contractExitRentVh, View view) {
            this.f7086b = contractExitRentVh;
            contractExitRentVh.mExitReasonFlowLayout = (FlowLayout) d.findRequiredViewAsType(view, R.id.flow_layout_exit_reason, "field 'mExitReasonFlowLayout'", FlowLayout.class);
            contractExitRentVh.mReasonEdt = (AppCompatEditText) d.findRequiredViewAsType(view, R.id.edt_input_reason, "field 'mReasonEdt'", AppCompatEditText.class);
        }

        @Override // butterknife.Unbinder
        @CallSuper
        public void unbind() {
            ContractExitRentVh contractExitRentVh = this.f7086b;
            if (contractExitRentVh == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.f7086b = null;
            contractExitRentVh.mExitReasonFlowLayout = null;
            contractExitRentVh.mReasonEdt = null;
        }
    }

    @Override // com.chinavisionary.core.app.base.LeftTitleToRightArrowAdapter
    public void q(RecyclerView.ViewHolder viewHolder, int i2) {
        ContractExitRentVh contractExitRentVh = (ContractExitRentVh) viewHolder;
        contractExitRentVh.setLeftTitleToRightArrowVos(this.f6460b);
        contractExitRentVh.setPosition(i2);
        contractExitRentVh.setData((LeftTitleToRightArrowVo) this.f6460b.get(i2));
    }

    @Override // com.chinavisionary.core.app.base.LeftTitleToRightArrowAdapter
    public RecyclerView.ViewHolder r(ViewGroup viewGroup, int i2) {
        ContractExitRentVh contractExitRentVh = new ContractExitRentVh(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_contract_exit_rent, viewGroup, false));
        contractExitRentVh.setOnClickListener(this.f6461c);
        return contractExitRentVh;
    }
}
