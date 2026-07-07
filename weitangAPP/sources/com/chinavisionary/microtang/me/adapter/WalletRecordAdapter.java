package com.chinavisionary.microtang.me.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
import com.chinavisionary.microtang.me.vo.WalletRecordVo;
import java.math.BigDecimal;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class WalletRecordAdapter extends BaseRecyclerAdapter<WalletRecordVo> {

    public static class WalletRecordVH extends BaseRecyclerViewHolder<WalletRecordVo> {

        @BindView(R.id.tv_price)
        public TextView mPriceTv;

        @BindView(R.id.tv_time)
        public TextView mTimeTv;

        @BindView(R.id.tv_title)
        public TextView mTitleTv;

        public WalletRecordVH(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }

        public void g(WalletRecordVo walletRecordVo) {
            String str;
            this.mTitleTv.setText(x.getNotNullStr(walletRecordVo.getBody(), ""));
            this.mTimeTv.setText(z.getTime(walletRecordVo.getRecordTime()));
            BigDecimal recordAmount = walletRecordVo.getRecordAmount();
            boolean z = walletRecordVo.getRecordType() == 2;
            this.mPriceTv.setTextColor(this.mPriceTv.getResources().getColor(z ? R.color.item_room_tv_price_color : R.color.color000000));
            TextView textView = this.mPriceTv;
            if (z) {
                str = "+" + x.bigDecimalToPlainString(recordAmount);
            } else {
                str = "" + x.bigDecimalToPlainString(recordAmount);
            }
            textView.setText(str);
        }
    }

    public class WalletRecordVH_ViewBinding implements Unbinder {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public WalletRecordVH f7552b;

        @UiThread
        public WalletRecordVH_ViewBinding(WalletRecordVH walletRecordVH, View view) {
            this.f7552b = walletRecordVH;
            walletRecordVH.mTitleTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_title, "field 'mTitleTv'", TextView.class);
            walletRecordVH.mTimeTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_time, "field 'mTimeTv'", TextView.class);
            walletRecordVH.mPriceTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_price, "field 'mPriceTv'", TextView.class);
        }

        @Override // butterknife.Unbinder
        @CallSuper
        public void unbind() {
            WalletRecordVH walletRecordVH = this.f7552b;
            if (walletRecordVH == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.f7552b = null;
            walletRecordVH.mTitleTv = null;
            walletRecordVH.mTimeTv = null;
            walletRecordVH.mPriceTv = null;
        }
    }

    public WalletRecordAdapter() {
        WalletRecordVo walletRecordVo = new WalletRecordVo();
        walletRecordVo.setType(34952);
        addDataToList(walletRecordVo);
    }

    @Override // com.chinavisionary.core.app.adapter.BaseRecyclerAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i2) {
        List<T> list;
        if (i2 == 0 && (list = this.f6460b) != 0 && !list.isEmpty() && this.f6460b.size() == 1 && ((WalletRecordVo) this.f6460b.get(0)).getType() == 34952) {
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
        WalletRecordVH walletRecordVH = (WalletRecordVH) viewHolder;
        walletRecordVH.g((WalletRecordVo) this.f6460b.get(i2 - h()));
        b(walletRecordVH, i2);
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
        View viewInflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_wallet_record_layout, viewGroup, false);
        WalletRecordVH walletRecordVH = new WalletRecordVH(viewInflate);
        viewInflate.setTag(walletRecordVH);
        return walletRecordVH;
    }
}
