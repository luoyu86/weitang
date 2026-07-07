package com.chinavisionary.microtang.recommend.adapter;

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
import com.chinavisionary.core.weight.banner.EditBannerView;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.recommend.vo.RecommendVo;

/* JADX INFO: loaded from: classes2.dex */
public class RecommendAdapter extends BaseRecyclerAdapter<RecommendVo> {

    public static class BannerVh extends BaseRecyclerViewHolder<RecommendVo> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public View.OnClickListener f8215f;

        @BindView(R.id.banner_view)
        public EditBannerView mEditBannerView;

        public BannerVh(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }

        public void h(RecommendVo recommendVo) {
            this.mEditBannerView.setItemClickListener(this.f8215f);
            this.mEditBannerView.setFragment(null);
            if (recommendVo.getBannerList() != null) {
                this.mEditBannerView.setAdapterListData(recommendVo.getBannerList());
            }
        }

        public final void setOnClickListener(View.OnClickListener onClickListener) {
            this.f8215f = onClickListener;
        }
    }

    public class BannerVh_ViewBinding implements Unbinder {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public BannerVh f8216b;

        @UiThread
        public BannerVh_ViewBinding(BannerVh bannerVh, View view) {
            this.f8216b = bannerVh;
            bannerVh.mEditBannerView = (EditBannerView) d.findRequiredViewAsType(view, R.id.banner_view, "field 'mEditBannerView'", EditBannerView.class);
        }

        @Override // butterknife.Unbinder
        @CallSuper
        public void unbind() {
            BannerVh bannerVh = this.f8216b;
            if (bannerVh == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.f8216b = null;
            bannerVh.mEditBannerView = null;
        }
    }

    public static class RecommendContentVh extends BaseRecyclerViewHolder<RecommendVo> {

        @BindView(R.id.tv_content)
        public TextView mContentTv;

        @BindView(R.id.tv_recommended_info)
        public TextView mRecommendInfoTv;

        @BindView(R.id.tv_recommended_time)
        public TextView mRecommendTimeTv;

        public RecommendContentVh(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }

        public void g(RecommendVo recommendVo) {
            this.mContentTv.setText(c(recommendVo.getTitle()));
            this.mRecommendInfoTv.setText(x.getString(R.string.placeholder_recommended_info, c(recommendVo.getRecommendedPersonName()), c(recommendVo.getRecommendedPersonPhone())));
            this.mRecommendTimeTv.setText(z.getTime(recommendVo.getCurrentTime()));
        }
    }

    public class RecommendContentVh_ViewBinding implements Unbinder {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public RecommendContentVh f8217b;

        @UiThread
        public RecommendContentVh_ViewBinding(RecommendContentVh recommendContentVh, View view) {
            this.f8217b = recommendContentVh;
            recommendContentVh.mContentTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_content, "field 'mContentTv'", TextView.class);
            recommendContentVh.mRecommendInfoTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_recommended_info, "field 'mRecommendInfoTv'", TextView.class);
            recommendContentVh.mRecommendTimeTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_recommended_time, "field 'mRecommendTimeTv'", TextView.class);
        }

        @Override // butterknife.Unbinder
        @CallSuper
        public void unbind() {
            RecommendContentVh recommendContentVh = this.f8217b;
            if (recommendContentVh == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.f8217b = null;
            recommendContentVh.mContentTv = null;
            recommendContentVh.mRecommendInfoTv = null;
            recommendContentVh.mRecommendTimeTv = null;
        }
    }

    public static class TitleVh extends BaseRecyclerViewHolder<RecommendVo> {

        @BindView(R.id.tv_title)
        public TextView mTitleTv;

        public TitleVh(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }

        public void g(RecommendVo recommendVo) {
            this.mTitleTv.setText(c(recommendVo.getTitle()));
        }
    }

    public class TitleVh_ViewBinding implements Unbinder {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public TitleVh f8218b;

        @UiThread
        public TitleVh_ViewBinding(TitleVh titleVh, View view) {
            this.f8218b = titleVh;
            titleVh.mTitleTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_title, "field 'mTitleTv'", TextView.class);
        }

        @Override // butterknife.Unbinder
        @CallSuper
        public void unbind() {
            TitleVh titleVh = this.f8218b;
            if (titleVh == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.f8218b = null;
            titleVh.mTitleTv = null;
        }
    }

    @Override // com.chinavisionary.core.app.adapter.BaseRecyclerAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i2) {
        return !getList().isEmpty() ? getList().get(i2).getItemType() : super.getItemViewType(i2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i2) {
        int itemViewType = viewHolder.getItemViewType();
        if (itemViewType == 1) {
            s(viewHolder, i2);
        } else if (itemViewType == 2) {
            u(viewHolder, i2);
        } else {
            if (itemViewType != 3) {
                return;
            }
            t(viewHolder, i2);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i2) {
        if (i2 == 1) {
            return p(viewGroup);
        }
        if (i2 == 2) {
            return r(viewGroup);
        }
        if (i2 != 3) {
            return null;
        }
        return q(viewGroup);
    }

    public final BannerVh p(ViewGroup viewGroup) {
        View viewI = i(viewGroup, R.layout.item_main_banner_layout);
        BannerVh bannerVh = new BannerVh(viewI);
        bannerVh.setOnClickListener(this.f6461c);
        viewI.setTag(bannerVh);
        return bannerVh;
    }

    public final RecommendContentVh q(ViewGroup viewGroup) {
        View viewI = i(viewGroup, R.layout.item_recommend_content);
        RecommendContentVh recommendContentVh = new RecommendContentVh(viewI);
        viewI.setTag(recommendContentVh);
        return recommendContentVh;
    }

    public final TitleVh r(ViewGroup viewGroup) {
        View viewI = i(viewGroup, R.layout.item_sign_title);
        TitleVh titleVh = new TitleVh(viewI);
        viewI.setTag(titleVh);
        return titleVh;
    }

    public final void s(RecyclerView.ViewHolder viewHolder, int i2) {
        ((BannerVh) viewHolder).h((RecommendVo) this.f6460b.get(i2));
    }

    public final void t(RecyclerView.ViewHolder viewHolder, int i2) {
        ((RecommendContentVh) viewHolder).g((RecommendVo) this.f6460b.get(i2));
    }

    public final void u(RecyclerView.ViewHolder viewHolder, int i2) {
        ((TitleVh) viewHolder).g((RecommendVo) this.f6460b.get(i2));
    }
}
