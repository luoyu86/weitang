package com.chinavisionary.microtang.me.adapter;

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
import com.chinavisionary.core.app.adapter.BaseRecyclerAdapter;
import com.chinavisionary.core.app.adapter.BaseRecyclerViewHolder;
import com.chinavisionary.core.weight.CoreRoundedImageView;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.contract.adapter.ContractListAdapter;
import com.chinavisionary.microtang.me.view.AboutView;
import com.chinavisionary.microtang.me.vo.CleanProductVo;
import com.chinavisionary.microtang.open.bo.AboutVo;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class IncrementProductAdapter extends BaseRecyclerAdapter<CleanProductVo> {
    public List<AboutVo> n;

    public static class AboutVH extends BaseRecyclerViewHolder<CleanProductVo> {

        @BindView(R.id.view_about)
        public AboutView mAboutView;

        public AboutVH(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }

        public void g(List<AboutVo> list, View.OnClickListener onClickListener) {
            this.mAboutView.setAboutList(list, onClickListener);
        }
    }

    public class AboutVH_ViewBinding implements Unbinder {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public AboutVH f7524b;

        @UiThread
        public AboutVH_ViewBinding(AboutVH aboutVH, View view) {
            this.f7524b = aboutVH;
            aboutVH.mAboutView = (AboutView) d.findRequiredViewAsType(view, R.id.view_about, "field 'mAboutView'", AboutView.class);
        }

        @Override // butterknife.Unbinder
        @CallSuper
        public void unbind() {
            AboutVH aboutVH = this.f7524b;
            if (aboutVH == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.f7524b = null;
            aboutVH.mAboutView = null;
        }
    }

    public static class IncrementProductVH extends BaseRecyclerViewHolder<CleanProductVo> {

        @BindView(R.id.tv_clean_buy_number)
        public TextView mBuyNumberTv;

        @BindView(R.id.img_clean_cover)
        public CoreRoundedImageView mCleanCoverImg;

        @BindView(R.id.tv_clean_info)
        public TextView mCleanInfoTv;

        @BindView(R.id.tv_server_price)
        public TextView mCleanPriceTv;

        public IncrementProductVH(View view) {
            super(view);
            ButterKnife.bind(this, view);
            this.mCleanCoverImg.setPicWidth(400);
            this.mCleanCoverImg.setPicHeight(300);
        }

        public void g(CleanProductVo cleanProductVo) {
            if (cleanProductVo != null) {
                a(this.mCleanCoverImg, cleanProductVo.getCover(), true);
                this.mCleanInfoTv.setText(x.getNotNullStr(cleanProductVo.getName(), ""));
                this.mCleanPriceTv.setText(x.appendStringToResId(R.string.rmb_placeholder, x.bigDecimalToString(cleanProductVo.getPrice())));
            }
        }
    }

    public class IncrementProductVH_ViewBinding implements Unbinder {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public IncrementProductVH f7525b;

        @UiThread
        public IncrementProductVH_ViewBinding(IncrementProductVH incrementProductVH, View view) {
            this.f7525b = incrementProductVH;
            incrementProductVH.mCleanCoverImg = (CoreRoundedImageView) d.findRequiredViewAsType(view, R.id.img_clean_cover, "field 'mCleanCoverImg'", CoreRoundedImageView.class);
            incrementProductVH.mBuyNumberTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_clean_buy_number, "field 'mBuyNumberTv'", TextView.class);
            incrementProductVH.mCleanInfoTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_clean_info, "field 'mCleanInfoTv'", TextView.class);
            incrementProductVH.mCleanPriceTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_server_price, "field 'mCleanPriceTv'", TextView.class);
        }

        @Override // butterknife.Unbinder
        @CallSuper
        public void unbind() {
            IncrementProductVH incrementProductVH = this.f7525b;
            if (incrementProductVH == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.f7525b = null;
            incrementProductVH.mCleanCoverImg = null;
            incrementProductVH.mBuyNumberTv = null;
            incrementProductVH.mCleanInfoTv = null;
            incrementProductVH.mCleanPriceTv = null;
        }
    }

    public static class TitleVh extends BaseRecyclerViewHolder<CleanProductVo> {

        @BindView(R.id.tv_main_title)
        public TextView mTitleTv;

        public TitleVh(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }

        public void g(CleanProductVo cleanProductVo) {
            this.mTitleTv.setText(x.getNotNullStr(cleanProductVo.getName(), ""));
        }
    }

    public class TitleVh_ViewBinding implements Unbinder {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public TitleVh f7526b;

        @UiThread
        public TitleVh_ViewBinding(TitleVh titleVh, View view) {
            this.f7526b = titleVh;
            titleVh.mTitleTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_main_title, "field 'mTitleTv'", TextView.class);
        }

        @Override // butterknife.Unbinder
        @CallSuper
        public void unbind() {
            TitleVh titleVh = this.f7526b;
            if (titleVh == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.f7526b = null;
            titleVh.mTitleTv = null;
        }
    }

    @Override // com.chinavisionary.core.app.adapter.BaseRecyclerAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i2) {
        if (this.f6466h != null && i2 == 0) {
            return 26214;
        }
        if (this.f6463e && i2 == getItemCount() - 1) {
            return 39321;
        }
        if (((CleanProductVo) this.f6460b.get(i2 - h())).getType() == 34952) {
            return 34952;
        }
        if (((CleanProductVo) this.f6460b.get(i2 - h())).getType() == 97) {
            return 97;
        }
        if (((CleanProductVo) this.f6460b.get(i2 - h())).getType() == 99) {
            return 99;
        }
        if (((CleanProductVo) this.f6460b.get(i2 - h())).getType() != 26758 || this.n == null) {
            return super.getItemViewType(i2);
        }
        return 26758;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i2) {
        int itemViewType = viewHolder.getItemViewType();
        if (itemViewType == 97) {
            ((TitleVh) viewHolder).g((CleanProductVo) this.f6460b.get(i2 - h()));
            return;
        }
        if (itemViewType == 99) {
            ContractListAdapter.ContractListVh contractListVh = (ContractListAdapter.ContractListVh) viewHolder;
            contractListVh.setListPosition(i2 - h());
            contractListVh.setData(((CleanProductVo) this.f6460b.get(i2 - h())).getContractListVo());
        } else if (itemViewType != 26214) {
            if (itemViewType == 26758) {
                AboutVH aboutVH = (AboutVH) viewHolder;
                aboutVH.g(this.n, this.f6461c);
                b(aboutVH, i2);
            } else {
                if (itemViewType == 34952 || itemViewType == 39321) {
                    return;
                }
                IncrementProductVH incrementProductVH = (IncrementProductVH) viewHolder;
                incrementProductVH.setFirstLastPosition(this.f6464f, this.f6465g);
                b(incrementProductVH, i2);
                incrementProductVH.g((CleanProductVo) this.f6460b.get(i2 - h()));
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i2) {
        if (i2 == 97) {
            return new TitleVh(i(viewGroup, R.layout.item_left_bar_title_layout));
        }
        if (i2 == 99) {
            View viewI = i(viewGroup, R.layout.item_contract_list_layout);
            ((ViewGroup.MarginLayoutParams) viewI.getLayoutParams()).leftMargin = 0;
            ((ViewGroup.MarginLayoutParams) viewI.getLayoutParams()).rightMargin = 0;
            viewI.setBackgroundResource(R.color.color_white);
            ContractListAdapter.ContractListVh contractListVh = new ContractListAdapter.ContractListVh(viewI);
            contractListVh.setOnClickListener(this.f6461c);
            a(contractListVh);
            viewI.setTag(contractListVh);
            return contractListVh;
        }
        if (i2 == 26214) {
            return new BaseRecyclerAdapter.RecyclerHeadViewHodler(this.f6466h);
        }
        if (i2 == 26758) {
            View viewI2 = i(viewGroup, R.layout.item_about_root_view_layout);
            AboutVH aboutVH = new AboutVH(viewI2);
            viewI2.setTag(aboutVH);
            return aboutVH;
        }
        if (i2 == 34952) {
            return new BaseRecyclerAdapter.EmptyViewHolder(i(viewGroup, R.layout.item_clean_empty));
        }
        if (i2 == 39321) {
            return new BaseRecyclerAdapter.FooterViewHolder(i(viewGroup, R.layout.item_clean_empty_layout));
        }
        View viewI3 = i(viewGroup, R.layout.item_clean_layout);
        IncrementProductVH incrementProductVH = new IncrementProductVH(viewI3);
        viewI3.setTag(incrementProductVH);
        return incrementProductVH;
    }

    public void setAboutVos(List<AboutVo> list) {
        this.n = list;
    }
}
