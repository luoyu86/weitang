package com.chinavisionary.microtang.me.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import b.c.d;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import c.e.c.h0.e.b;
import com.chinavisionary.core.app.adapter.BaseRecyclerAdapter;
import com.chinavisionary.core.app.adapter.BaseRecyclerViewHolder;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.hydropower.vo.ElectricVo;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class RechargeAdapter extends BaseRecyclerAdapter<ElectricVo> {
    public b n;

    public class WalletRecordVH extends BaseRecyclerViewHolder<ElectricVo> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public b f7534f;

        @BindView(R.id.recharge_cb)
        public CheckBox mCheckBox;

        public class a implements CompoundButton.OnCheckedChangeListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ RechargeAdapter f7536a;

            public a(RechargeAdapter rechargeAdapter) {
                this.f7536a = rechargeAdapter;
            }

            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                int adapterPosition = WalletRecordVH.this.getAdapterPosition();
                if (WalletRecordVH.this.f7534f == null || adapterPosition < 0 || ((ElectricVo) RechargeAdapter.this.f6460b.get(adapterPosition)).getDefaultFlag() == z) {
                    return;
                }
                WalletRecordVH.this.f7534f.onCheckBoxClick(adapterPosition, z);
            }
        }

        public WalletRecordVH(View view) {
            super(view);
            ButterKnife.bind(this, view);
            this.mCheckBox.setOnCheckedChangeListener(new a(RechargeAdapter.this));
        }

        public void h(ElectricVo electricVo) {
            this.mCheckBox.setChecked(electricVo.getDefaultFlag());
            this.mCheckBox.setText(c(electricVo.getName()));
        }

        public void setICheckBoxCallback(b bVar) {
            this.f7534f = bVar;
        }
    }

    public class WalletRecordVH_ViewBinding implements Unbinder {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public WalletRecordVH f7538b;

        @UiThread
        public WalletRecordVH_ViewBinding(WalletRecordVH walletRecordVH, View view) {
            this.f7538b = walletRecordVH;
            walletRecordVH.mCheckBox = (CheckBox) d.findRequiredViewAsType(view, R.id.recharge_cb, "field 'mCheckBox'", CheckBox.class);
        }

        @Override // butterknife.Unbinder
        @CallSuper
        public void unbind() {
            WalletRecordVH walletRecordVH = this.f7538b;
            if (walletRecordVH == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.f7538b = null;
            walletRecordVH.mCheckBox = null;
        }
    }

    public RechargeAdapter() {
        ElectricVo electricVo = new ElectricVo();
        electricVo.setType(34952);
        addDataToList(electricVo);
    }

    @Override // com.chinavisionary.core.app.adapter.BaseRecyclerAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i2) {
        List<T> list;
        if (i2 == 0 && (list = this.f6460b) != 0 && !list.isEmpty() && this.f6460b.size() == 1 && ((ElectricVo) this.f6460b.get(0)).getType() == 34952) {
            return 34952;
        }
        return super.getItemViewType(i2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i2) {
        int itemViewType = viewHolder.getItemViewType();
        if (itemViewType == 26214 || itemViewType == 34952 || itemViewType == 39321) {
            return;
        }
        ((WalletRecordVH) viewHolder).h((ElectricVo) this.f6460b.get(i2 - h()));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i2) {
        if (i2 == 26214) {
            return new BaseRecyclerAdapter.RecyclerHeadViewHodler(this.f6466h);
        }
        if (i2 == 34952) {
            return new BaseRecyclerAdapter.EmptyViewHolder(d(viewGroup));
        }
        if (i2 == 39321) {
            return new BaseRecyclerAdapter.FooterViewHolder(f(viewGroup));
        }
        WalletRecordVH walletRecordVH = new WalletRecordVH(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_recharge_layout, viewGroup, false));
        walletRecordVH.setICheckBoxCallback(this.n);
        return walletRecordVH;
    }

    public void setICheckBoxCallback(b bVar) {
        this.n = bVar;
    }
}
