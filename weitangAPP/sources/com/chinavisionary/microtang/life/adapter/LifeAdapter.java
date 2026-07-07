package com.chinavisionary.microtang.life.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import b.c.d;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import c.e.a.d.k;
import c.e.a.d.x;
import com.chinavisionary.core.app.adapter.BaseRecyclerViewHolder;
import com.chinavisionary.core.weight.CoreRoundedImageView;
import com.chinavisionary.core.weight.banner.EditBannerView;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.main.adapter.MainAdapter;
import com.chinavisionary.microtang.main.vo.MerchantInfoVo;
import com.chinavisionary.microtang.main.vo.RoomModelVo;
import com.chinavisionary.microtang.prelook.vo.TagVo;
import com.chinavisionary.microtang.view.CustomTextView;
import com.hedgehog.ratingbar.RatingBar;
import com.nex3z.flowlayout.FlowLayout;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class LifeAdapter extends MainAdapter {

    public static class BannerVH extends BaseRecyclerViewHolder<RoomModelVo.ModulesBean> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public View.OnClickListener f7268f;

        @BindView(R.id.banner_view)
        public EditBannerView mEditBannerView;

        public BannerVH(View view) {
            super(view);
            ButterKnife.bind(this, view);
            this.mEditBannerView.getLayoutParams().height = k.getBannerHeight(this.mEditBannerView.getContext());
        }

        public void g(RoomModelVo.ModulesBean modulesBean) {
            this.mEditBannerView.setItemClickListener(this.f7268f);
            this.mEditBannerView.setFragment(null);
            if (modulesBean.getBannerDtoList() == null || !e()) {
                return;
            }
            this.mEditBannerView.setAdapterListData(modulesBean.getBannerDtoList());
        }

        public void setOnClickListener(View.OnClickListener onClickListener) {
            this.f7268f = onClickListener;
        }
    }

    public class BannerVH_ViewBinding implements Unbinder {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public BannerVH f7269b;

        @UiThread
        public BannerVH_ViewBinding(BannerVH bannerVH, View view) {
            this.f7269b = bannerVH;
            bannerVH.mEditBannerView = (EditBannerView) d.findRequiredViewAsType(view, R.id.banner_view, "field 'mEditBannerView'", EditBannerView.class);
        }

        @Override // butterknife.Unbinder
        @CallSuper
        public void unbind() {
            BannerVH bannerVH = this.f7269b;
            if (bannerVH == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.f7269b = null;
            bannerVH.mEditBannerView = null;
        }
    }

    public static class NearbyMerchantVh extends BaseRecyclerViewHolder<RoomModelVo.ModulesBean> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public Context f7270f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f7271g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f7272h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f7273i;
        public LinearLayout.LayoutParams j;

        @BindView(R.id.tv_merchant_average_consume_value)
        public CustomTextView mMerchantAverageConsumeValueTv;

        @BindView(R.id.img_merchant_icon)
        public CoreRoundedImageView mMerchantIconImg;

        @BindView(R.id.tv_merchant_location_distance)
        public CustomTextView mMerchantLocationDistanceTv;

        @BindView(R.id.tv_month_sale_volume_value)
        public CustomTextView mMerchantMonthSaleVolumeValueTv;

        @BindView(R.id.tv_merchant_name)
        public CustomTextView mMerchantNameTv;

        @BindView(R.id.rating_bar_merchant_score)
        public RatingBar mMerchantScoreRat;

        @BindView(R.id.tv_merchant_score_value)
        public CustomTextView mMerchantScoreValueTv;

        @BindView(R.id.flow_layout_merchant_store_tag)
        public FlowLayout mMerchantStoreTagFlowLayout;

        public NearbyMerchantVh(View view) {
            super(view);
            ButterKnife.bind(this, view);
            this.f7270f = view.getContext();
            Resources resources = view.getResources();
            this.f7271g = resources.getColor(R.color.item_room_tv_price_color);
            this.f7272h = resources.getDimensionPixelSize(R.dimen.dp_4);
            this.f7273i = resources.getDimensionPixelSize(R.dimen.dp_2);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            this.j = layoutParams;
            layoutParams.rightMargin = resources.getDimensionPixelSize(R.dimen.dp_6);
        }

        public final void g(List<TagVo> list) {
            this.mMerchantStoreTagFlowLayout.removeAllViews();
            for (TagVo tagVo : list) {
                if (tagVo != null) {
                    this.mMerchantStoreTagFlowLayout.addView(h(tagVo));
                }
            }
        }

        public final View h(TagVo tagVo) {
            CustomTextView customTextView = new CustomTextView(this.f7270f);
            customTextView.setTextSize(10.0f);
            customTextView.setTextColor(this.f7271g);
            customTextView.setLayoutParams(this.j);
            customTextView.setBackgroundResource(R.drawable.bg_merchant_red_tag);
            int i2 = this.f7272h;
            int i3 = this.f7273i;
            customTextView.setPadding(i2, i3, i2, i3);
            customTextView.setText(tagVo.getContent());
            return customTextView;
        }

        public void i(RoomModelVo.ModulesBean modulesBean) {
            MerchantInfoVo merchantInfoVo = modulesBean.getMerchantInfoVo();
            this.mMerchantIconImg.loadImageToResourceVo(merchantInfoVo.getCover());
            this.mMerchantNameTv.setText(merchantInfoVo.getMerchantName());
            this.mMerchantScoreValueTv.setText(String.valueOf(merchantInfoVo.getScore()));
            this.mMerchantAverageConsumeValueTv.setText(x.bigDecimalToString(merchantInfoVo.getAveragePrice()));
            this.mMerchantMonthSaleVolumeValueTv.setText(String.valueOf(merchantInfoVo.getSellAmount()));
            this.mMerchantLocationDistanceTv.setText(merchantInfoVo.getDescription());
            g(merchantInfoVo.getTags());
        }
    }

    public class NearbyMerchantVh_ViewBinding implements Unbinder {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public NearbyMerchantVh f7274b;

        @UiThread
        public NearbyMerchantVh_ViewBinding(NearbyMerchantVh nearbyMerchantVh, View view) {
            this.f7274b = nearbyMerchantVh;
            nearbyMerchantVh.mMerchantIconImg = (CoreRoundedImageView) d.findRequiredViewAsType(view, R.id.img_merchant_icon, "field 'mMerchantIconImg'", CoreRoundedImageView.class);
            nearbyMerchantVh.mMerchantNameTv = (CustomTextView) d.findRequiredViewAsType(view, R.id.tv_merchant_name, "field 'mMerchantNameTv'", CustomTextView.class);
            nearbyMerchantVh.mMerchantScoreRat = (RatingBar) d.findRequiredViewAsType(view, R.id.rating_bar_merchant_score, "field 'mMerchantScoreRat'", RatingBar.class);
            nearbyMerchantVh.mMerchantScoreValueTv = (CustomTextView) d.findRequiredViewAsType(view, R.id.tv_merchant_score_value, "field 'mMerchantScoreValueTv'", CustomTextView.class);
            nearbyMerchantVh.mMerchantAverageConsumeValueTv = (CustomTextView) d.findRequiredViewAsType(view, R.id.tv_merchant_average_consume_value, "field 'mMerchantAverageConsumeValueTv'", CustomTextView.class);
            nearbyMerchantVh.mMerchantMonthSaleVolumeValueTv = (CustomTextView) d.findRequiredViewAsType(view, R.id.tv_month_sale_volume_value, "field 'mMerchantMonthSaleVolumeValueTv'", CustomTextView.class);
            nearbyMerchantVh.mMerchantLocationDistanceTv = (CustomTextView) d.findRequiredViewAsType(view, R.id.tv_merchant_location_distance, "field 'mMerchantLocationDistanceTv'", CustomTextView.class);
            nearbyMerchantVh.mMerchantStoreTagFlowLayout = (FlowLayout) d.findRequiredViewAsType(view, R.id.flow_layout_merchant_store_tag, "field 'mMerchantStoreTagFlowLayout'", FlowLayout.class);
        }

        @Override // butterknife.Unbinder
        @CallSuper
        public void unbind() {
            NearbyMerchantVh nearbyMerchantVh = this.f7274b;
            if (nearbyMerchantVh == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.f7274b = null;
            nearbyMerchantVh.mMerchantIconImg = null;
            nearbyMerchantVh.mMerchantNameTv = null;
            nearbyMerchantVh.mMerchantScoreRat = null;
            nearbyMerchantVh.mMerchantScoreValueTv = null;
            nearbyMerchantVh.mMerchantAverageConsumeValueTv = null;
            nearbyMerchantVh.mMerchantMonthSaleVolumeValueTv = null;
            nearbyMerchantVh.mMerchantLocationDistanceTv = null;
            nearbyMerchantVh.mMerchantStoreTagFlowLayout = null;
        }
    }

    @Override // com.chinavisionary.microtang.main.adapter.MainAdapter, com.chinavisionary.core.app.adapter.BaseRecyclerAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i2) {
        return super.getItemViewType(i2);
    }

    @Override // com.chinavisionary.microtang.main.adapter.MainAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i2) {
        int itemViewType = viewHolder.getItemViewType();
        if (itemViewType == 1) {
            BannerVH bannerVH = (BannerVH) viewHolder;
            bannerVH.setFirstLastPosition(this.f6464f, this.f6465g);
            bannerVH.g((RoomModelVo.ModulesBean) this.f6460b.get(i2 - h()));
        } else {
            if (itemViewType != 5) {
                super.onBindViewHolder(viewHolder, i2);
                return;
            }
            NearbyMerchantVh nearbyMerchantVh = (NearbyMerchantVh) viewHolder;
            nearbyMerchantVh.setListPosition(i2);
            nearbyMerchantVh.i((RoomModelVo.ModulesBean) this.f6460b.get(i2 - h()));
            b(nearbyMerchantVh, i2);
        }
    }

    @Override // com.chinavisionary.microtang.main.adapter.MainAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i2) {
        RecyclerView.ViewHolder nearbyMerchantVh;
        if (i2 == 1) {
            View viewI = i(viewGroup, R.layout.item_life_banner_layout);
            BannerVH bannerVH = new BannerVH(viewI);
            bannerVH.setOnClickListener(this.f6461c);
            viewI.setTag(bannerVH);
            nearbyMerchantVh = bannerVH;
        } else {
            if (i2 != 5) {
                return super.onCreateViewHolder(viewGroup, i2);
            }
            nearbyMerchantVh = new NearbyMerchantVh(i(viewGroup, R.layout.item_nearby_merchant_layout));
        }
        return nearbyMerchantVh;
    }
}
