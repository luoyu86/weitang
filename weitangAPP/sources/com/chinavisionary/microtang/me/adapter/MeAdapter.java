package com.chinavisionary.microtang.me.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.UiThread;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import b.c.d;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import c.e.a.d.x;
import com.chinavisionary.core.app.adapter.BaseRecyclerAdapter;
import com.chinavisionary.core.app.adapter.BaseRecyclerViewHolder;
import com.chinavisionary.core.weight.CoreRoundedImageView;
import com.chinavisionary.core.weight.banner.EditBannerView;
import com.chinavisionary.framework.mobile.common.vo.ResourceVo;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.me.vo.MeVo;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class MeAdapter extends BaseRecyclerAdapter<MeVo> {
    public Fragment n;

    public static class BannerVh extends BaseRecyclerViewHolder<MeVo> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public View.OnClickListener f7527f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public Fragment f7528g;

        @BindView(R.id.banner_view_me_cover)
        public EditBannerView mEditBannerView;

        @BindView(R.id.tv_title)
        public TextView mTitleTv;

        public BannerVh(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }

        public final List<EditBannerView.BannerDto> g(MeVo meVo) {
            ArrayList arrayList = new ArrayList();
            for (MeVo.CoverVo coverVo : meVo.getCoverList()) {
                ResourceVo resourceVo = coverVo.getResourceVo();
                if (resourceVo != null) {
                    EditBannerView.BannerDto bannerDto = new EditBannerView.BannerDto();
                    bannerDto.setDataKey(coverVo.getUrl());
                    bannerDto.setCover(resourceVo);
                    arrayList.add(bannerDto);
                }
            }
            return arrayList;
        }

        public void h(MeVo meVo) {
            this.mTitleTv.setVisibility(x.isNotNull(meVo.getTitle()) ? 0 : 8);
            this.mTitleTv.setText(x.getNotNullStr(meVo.getTitle(), ""));
            this.mEditBannerView.setFragment(null);
            this.mEditBannerView.setItemClickListener(this.f7527f);
            this.mEditBannerView.setAdapterListData(g(meVo));
        }

        public void setFragment(Fragment fragment) {
            this.f7528g = fragment;
        }

        public void setOnClickListener(View.OnClickListener onClickListener) {
            this.f7527f = onClickListener;
        }
    }

    public class BannerVh_ViewBinding implements Unbinder {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public BannerVh f7529b;

        @UiThread
        public BannerVh_ViewBinding(BannerVh bannerVh, View view) {
            this.f7529b = bannerVh;
            bannerVh.mTitleTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_title, "field 'mTitleTv'", TextView.class);
            bannerVh.mEditBannerView = (EditBannerView) d.findRequiredViewAsType(view, R.id.banner_view_me_cover, "field 'mEditBannerView'", EditBannerView.class);
        }

        @Override // butterknife.Unbinder
        @CallSuper
        public void unbind() {
            BannerVh bannerVh = this.f7529b;
            if (bannerVh == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.f7529b = null;
            bannerVh.mTitleTv = null;
            bannerVh.mEditBannerView = null;
        }
    }

    public static class HorCoverVh extends BaseRecyclerViewHolder<MeVo> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public View.OnClickListener f7530f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public LinearLayout.LayoutParams f7531g;

        @BindView(R.id.llayout_cover)
        public LinearLayout mCoverLlayout;

        @BindView(R.id.tv_title)
        public TextView mTitleTv;

        public HorCoverVh(View view) {
            super(view);
            ButterKnife.bind(this, view);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(view.getResources().getDimensionPixelSize(R.dimen.dp_120), view.getResources().getDimensionPixelSize(R.dimen.dp_80));
            this.f7531g = layoutParams;
            layoutParams.leftMargin = view.getResources().getDimensionPixelSize(R.dimen.dp_12);
        }

        public void g(MeVo meVo) {
            ResourceVo resourceVo;
            this.mTitleTv.setVisibility(x.isNotNull(meVo.getTitle()) ? 0 : 8);
            this.mTitleTv.setText(x.getNotNullStr(meVo.getTitle(), ""));
            this.mCoverLlayout.removeAllViews();
            List<MeVo.CoverVo> coverList = meVo.getCoverList();
            if (coverList != null) {
                int size = coverList.size();
                for (int i2 = 0; i2 < size; i2++) {
                    MeVo.CoverVo coverVo = coverList.get(i2);
                    if (coverVo != null && (resourceVo = coverVo.getResourceVo()) != null) {
                        CoreRoundedImageView coreRoundedImageView = new CoreRoundedImageView(this.mCoverLlayout.getContext());
                        coreRoundedImageView.setLayoutParams(this.f7531g);
                        coreRoundedImageView.loadImageToUrl(resourceVo.getUrl());
                        coreRoundedImageView.setCornerRadius(6.0f);
                        coreRoundedImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                        coreRoundedImageView.setId(R.id.id_me_cover_img);
                        coreRoundedImageView.setTag(R.id.id_me_cover_img, coverVo);
                        coreRoundedImageView.setOnClickListener(this.f7530f);
                        this.mCoverLlayout.addView(coreRoundedImageView);
                    }
                }
            }
        }

        public void setOnClickListener(View.OnClickListener onClickListener) {
            this.f7530f = onClickListener;
        }
    }

    public class HorCoverVh_ViewBinding implements Unbinder {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public HorCoverVh f7532b;

        @UiThread
        public HorCoverVh_ViewBinding(HorCoverVh horCoverVh, View view) {
            this.f7532b = horCoverVh;
            horCoverVh.mTitleTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_title, "field 'mTitleTv'", TextView.class);
            horCoverVh.mCoverLlayout = (LinearLayout) d.findRequiredViewAsType(view, R.id.llayout_cover, "field 'mCoverLlayout'", LinearLayout.class);
        }

        @Override // butterknife.Unbinder
        @CallSuper
        public void unbind() {
            HorCoverVh horCoverVh = this.f7532b;
            if (horCoverVh == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.f7532b = null;
            horCoverVh.mTitleTv = null;
            horCoverVh.mCoverLlayout = null;
        }
    }

    public static class TvVh extends BaseRecyclerViewHolder<MeVo> {

        @BindView(R.id.tv_title)
        public TextView mTitleTv;

        public TvVh(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }

        public void g(MeVo meVo) {
            this.mTitleTv.setVisibility(x.isNotNull(meVo.getTitle()) ? 0 : 8);
            this.mTitleTv.setText(x.getNotNullStr(meVo.getTitle(), ""));
        }
    }

    public class TvVh_ViewBinding implements Unbinder {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public TvVh f7533b;

        @UiThread
        public TvVh_ViewBinding(TvVh tvVh, View view) {
            this.f7533b = tvVh;
            tvVh.mTitleTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_title, "field 'mTitleTv'", TextView.class);
        }

        @Override // butterknife.Unbinder
        @CallSuper
        public void unbind() {
            TvVh tvVh = this.f7533b;
            if (tvVh == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.f7533b = null;
            tvVh.mTitleTv = null;
        }
    }

    @Override // com.chinavisionary.core.app.adapter.BaseRecyclerAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i2) {
        if (this.f6466h != null && i2 == 0) {
            return 26214;
        }
        List<T> list = this.f6460b;
        return list != 0 ? ((MeVo) list.get(i2 - h())).getType() : super.getItemViewType(i2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i2) {
        switch (viewHolder.getItemViewType()) {
            case 18:
                ((BannerVh) viewHolder).h((MeVo) this.f6460b.get(i2 - h()));
                break;
            case 19:
                ((TvVh) viewHolder).g((MeVo) this.f6460b.get(i2 - h()));
                break;
            case 20:
                ((HorCoverVh) viewHolder).g((MeVo) this.f6460b.get(i2 - h()));
                break;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i2) {
        RecyclerView.ViewHolder viewHolder;
        if (i2 == 26214) {
            return new BaseRecyclerAdapter.RecyclerHeadViewHodler(this.f6466h);
        }
        switch (i2) {
            case 18:
                View viewInflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_me_cover_layout, viewGroup, false);
                BannerVh bannerVh = new BannerVh(viewInflate);
                bannerVh.setOnClickListener(this.f6461c);
                bannerVh.setFragment(this.n);
                viewInflate.setTag(bannerVh);
                viewHolder = bannerVh;
                break;
            case 19:
                View viewInflate2 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_me_tv, viewGroup, false);
                TvVh tvVh = new TvVh(viewInflate2);
                viewInflate2.setTag(tvVh);
                viewHolder = tvVh;
                break;
            case 20:
                View viewInflate3 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_me_hor_layout, viewGroup, false);
                HorCoverVh horCoverVh = new HorCoverVh(viewInflate3);
                horCoverVh.setOnClickListener(this.f6461c);
                viewInflate3.setTag(horCoverVh);
                viewHolder = horCoverVh;
                break;
            default:
                return null;
        }
        return viewHolder;
    }

    public void setFragment(Fragment fragment) {
        this.n = fragment;
    }
}
