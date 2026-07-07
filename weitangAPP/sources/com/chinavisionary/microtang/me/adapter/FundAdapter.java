package com.chinavisionary.microtang.me.adapter;

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
import c.e.a.d.o;
import c.e.a.d.z;
import com.chinavisionary.core.app.adapter.BaseRecyclerAdapter;
import com.chinavisionary.core.app.adapter.SimpleRecyclerViewHolder;
import com.chinavisionary.core.weight.CoreRoundedImageView;
import com.chinavisionary.core.weight.banner.EditBannerView;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.me.vo.FundNewsVo;

/* JADX INFO: loaded from: classes.dex */
public class FundAdapter extends BaseRecyclerAdapter<FundNewsVo> {

    public static class FundNewsViewHolder extends SimpleRecyclerViewHolder<FundNewsVo> {

        @BindView(R.id.img_news_cover)
        public CoreRoundedImageView mCoreRoundedImageView;

        @BindView(R.id.tv_news_content)
        public TextView mNewsContentTv;

        @BindView(R.id.tv_news_date)
        public TextView mNewsDateTv;

        public FundNewsViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }

        @Override // com.chinavisionary.core.app.adapter.SimpleRecyclerViewHolder
        public void setupData(FundNewsVo fundNewsVo) {
            this.mCoreRoundedImageView.loadImageToUrl(fundNewsVo.getPicUrl());
            this.mNewsContentTv.setText(c(fundNewsVo.getTitle()));
            this.mNewsDateTv.setText(z.getTime(fundNewsVo.getCreateTime(), z.j));
        }
    }

    public class FundNewsViewHolder_ViewBinding implements Unbinder {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public FundNewsViewHolder f7521b;

        @UiThread
        public FundNewsViewHolder_ViewBinding(FundNewsViewHolder fundNewsViewHolder, View view) {
            this.f7521b = fundNewsViewHolder;
            fundNewsViewHolder.mCoreRoundedImageView = (CoreRoundedImageView) d.findRequiredViewAsType(view, R.id.img_news_cover, "field 'mCoreRoundedImageView'", CoreRoundedImageView.class);
            fundNewsViewHolder.mNewsContentTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_news_content, "field 'mNewsContentTv'", TextView.class);
            fundNewsViewHolder.mNewsDateTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_news_date, "field 'mNewsDateTv'", TextView.class);
        }

        @Override // butterknife.Unbinder
        @CallSuper
        public void unbind() {
            FundNewsViewHolder fundNewsViewHolder = this.f7521b;
            if (fundNewsViewHolder == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.f7521b = null;
            fundNewsViewHolder.mCoreRoundedImageView = null;
            fundNewsViewHolder.mNewsContentTv = null;
            fundNewsViewHolder.mNewsDateTv = null;
        }
    }

    public static class HeadVH extends SimpleRecyclerViewHolder<FundNewsVo> {

        @BindView(R.id.btn_cat_fund_account)
        public Button mCatFundAccountBtn;

        @BindView(R.id.banner_fund)
        public EditBannerView mEditBannerView;

        public HeadVH(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }

        @Override // com.chinavisionary.core.app.adapter.SimpleRecyclerViewHolder
        public void setupData(FundNewsVo fundNewsVo) {
            this.mCatFundAccountBtn.setOnClickListener(this.f6469b);
            this.mEditBannerView.setItemClickListener(this.f6469b);
            this.mEditBannerView.setFragment(null);
            if (fundNewsVo.getListData() != null) {
                if (this.mEditBannerView.getVisibility() != 0) {
                    this.mEditBannerView.setVisibility(0);
                }
                this.mEditBannerView.setAdapterListData(fundNewsVo.getListData());
            } else if (this.mEditBannerView.getVisibility() != 8) {
                this.mEditBannerView.setVisibility(8);
            }
        }
    }

    public class HeadVH_ViewBinding implements Unbinder {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public HeadVH f7522b;

        @UiThread
        public HeadVH_ViewBinding(HeadVH headVH, View view) {
            this.f7522b = headVH;
            headVH.mEditBannerView = (EditBannerView) d.findRequiredViewAsType(view, R.id.banner_fund, "field 'mEditBannerView'", EditBannerView.class);
            headVH.mCatFundAccountBtn = (Button) d.findRequiredViewAsType(view, R.id.btn_cat_fund_account, "field 'mCatFundAccountBtn'", Button.class);
        }

        @Override // butterknife.Unbinder
        @CallSuper
        public void unbind() {
            HeadVH headVH = this.f7522b;
            if (headVH == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.f7522b = null;
            headVH.mEditBannerView = null;
            headVH.mCatFundAccountBtn = null;
        }
    }

    public static class TitleViewHolder extends SimpleRecyclerViewHolder<FundNewsVo> {

        @BindView(R.id.tv_cat_more)
        public TextView mCateMoreTv;

        public TitleViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }

        @Override // com.chinavisionary.core.app.adapter.SimpleRecyclerViewHolder
        public void setupData(FundNewsVo fundNewsVo) {
            this.mCateMoreTv.setOnClickListener(this.f6469b);
        }
    }

    public class TitleViewHolder_ViewBinding implements Unbinder {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public TitleViewHolder f7523b;

        @UiThread
        public TitleViewHolder_ViewBinding(TitleViewHolder titleViewHolder, View view) {
            this.f7523b = titleViewHolder;
            titleViewHolder.mCateMoreTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_cat_more, "field 'mCateMoreTv'", TextView.class);
        }

        @Override // butterknife.Unbinder
        @CallSuper
        public void unbind() {
            TitleViewHolder titleViewHolder = this.f7523b;
            if (titleViewHolder == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.f7523b = null;
            titleViewHolder.mCateMoreTv = null;
        }
    }

    @Override // com.chinavisionary.core.app.adapter.BaseRecyclerAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i2) {
        return o.isNotEmpty(this.f6460b) ? ((FundNewsVo) this.f6460b.get(i2)).getItemType() : super.getItemViewType(i2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i2) {
        int itemViewType = viewHolder.getItemViewType();
        if (itemViewType == 2) {
            ((HeadVH) viewHolder).setupData((FundNewsVo) this.f6460b.get(i2));
            return;
        }
        if (itemViewType == 3) {
            ((TitleViewHolder) viewHolder).setupData((FundNewsVo) this.f6460b.get(i2));
        } else {
            if (itemViewType == 34952 || itemViewType == 39321) {
                return;
            }
            ((FundNewsViewHolder) viewHolder).setupData((FundNewsVo) this.f6460b.get(i2));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i2) {
        if (i2 == 2) {
            HeadVH headVH = new HeadVH(i(viewGroup, R.layout.item_fund_head));
            headVH.setViewOnClickListener(this.f6461c);
            return headVH;
        }
        if (i2 == 3) {
            TitleViewHolder titleViewHolder = new TitleViewHolder(i(viewGroup, R.layout.item_fund_title));
            titleViewHolder.setViewOnClickListener(this.f6461c);
            return titleViewHolder;
        }
        if (i2 == 34952) {
            BaseRecyclerAdapter.EmptyViewHolder emptyViewHolder = new BaseRecyclerAdapter.EmptyViewHolder(d(viewGroup));
            emptyViewHolder.itemView.setBackgroundResource(R.drawable.bg_empty_item);
            return emptyViewHolder;
        }
        if (i2 == 39321) {
            return new BaseRecyclerAdapter.FooterViewHolder(f(viewGroup));
        }
        FundNewsViewHolder fundNewsViewHolder = new FundNewsViewHolder(i(viewGroup, R.layout.item_fund_layout));
        a(fundNewsViewHolder);
        return fundNewsViewHolder;
    }
}
