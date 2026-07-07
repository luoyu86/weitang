package com.chinavisionary.microtang.merchant.adapter;

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
import c.e.a.d.o;
import c.e.a.d.x;
import com.chinavisionary.core.app.adapter.BaseRecyclerViewHolder;
import com.chinavisionary.core.weight.CoreRoundedImageView;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.life.adapter.LifeAdapter;
import com.chinavisionary.microtang.main.vo.MerchantInfoVo;
import com.chinavisionary.microtang.main.vo.RoomModelVo;
import com.chinavisionary.microtang.prelook.vo.TagVo;
import com.chinavisionary.microtang.view.CustomTextView;
import com.nex3z.flowlayout.FlowLayout;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class MerchantListAdapter extends LifeAdapter {

    public static class MerchantListVh extends BaseRecyclerViewHolder<RoomModelVo.ModulesBean> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public Context f7826f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f7827g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f7828h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f7829i;
        public LinearLayout.LayoutParams j;

        @BindView(R.id.tv_merchant_average_consume_value)
        public CustomTextView mMerchantAverageConsumeValueTv;

        @BindView(R.id.tv_merchant_comment_content)
        public CustomTextView mMerchantCommentContentTv;

        @BindView(R.id.img_merchant_cover)
        public CoreRoundedImageView mMerchantCoverImg;

        @BindView(R.id.tv_month_sale_volume_value)
        public CustomTextView mMerchantMonthSaleVolumeValueTv;

        @BindView(R.id.tv_merchant_name)
        public CustomTextView mMerchantNameTv;

        @BindView(R.id.tv_merchant_score_value)
        public CustomTextView mMerchantScoreValueTv;

        @BindView(R.id.flow_layout_sale_tag)
        public FlowLayout mSaleTagFlowLayout;

        public MerchantListVh(View view) {
            super(view);
            ButterKnife.bind(this, view);
            this.f7826f = view.getContext();
            Resources resources = view.getResources();
            this.f7827g = resources.getColor(R.color.item_room_tv_price_color);
            this.f7828h = resources.getDimensionPixelSize(R.dimen.dp_4);
            this.f7829i = resources.getDimensionPixelSize(R.dimen.dp_2);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            this.j = layoutParams;
            layoutParams.rightMargin = resources.getDimensionPixelSize(R.dimen.dp_6);
        }

        public final void g(List<TagVo> list) {
            this.mSaleTagFlowLayout.removeAllViews();
            if (!o.isNotEmpty(list)) {
                this.mSaleTagFlowLayout.setVisibility(8);
                return;
            }
            this.mSaleTagFlowLayout.setVisibility(0);
            for (TagVo tagVo : list) {
                if (tagVo != null) {
                    this.mSaleTagFlowLayout.addView(h(tagVo));
                }
            }
        }

        public final View h(TagVo tagVo) {
            CustomTextView customTextView = new CustomTextView(this.f7826f);
            customTextView.setTextSize(10.0f);
            customTextView.setTextColor(this.f7827g);
            customTextView.setLayoutParams(this.j);
            customTextView.setBackgroundResource(R.drawable.bg_merchant_red_tag);
            int i2 = this.f7828h;
            int i3 = this.f7829i;
            customTextView.setPadding(i2, i3, i2, i3);
            customTextView.setText(tagVo.getContent());
            return customTextView;
        }

        public void i(RoomModelVo.ModulesBean modulesBean) {
            MerchantInfoVo merchantInfoVo = modulesBean.getMerchantInfoVo();
            b(this.mMerchantCoverImg, merchantInfoVo.getCover());
            this.mMerchantNameTv.setText(merchantInfoVo.getMerchantName());
            this.mMerchantScoreValueTv.setText(this.f7826f.getString(R.string.placeholder_score_unit, Float.valueOf(merchantInfoVo.getScore())));
            this.mMerchantScoreValueTv.setVisibility(8);
            this.mMerchantAverageConsumeValueTv.setVisibility(8);
            this.mMerchantMonthSaleVolumeValueTv.setVisibility(8);
            this.mMerchantAverageConsumeValueTv.setText(x.appendStringToResId(R.string.placeholder_title_avg_price, x.bigDecimalToPlainString(merchantInfoVo.getAveragePrice())));
            this.mMerchantMonthSaleVolumeValueTv.setText(x.appendStringToResId(R.string.placeholder_title_month_volume, String.valueOf(merchantInfoVo.getSellAmount())));
            this.mMerchantCommentContentTv.setText(merchantInfoVo.getDescription());
            g(merchantInfoVo.getTags());
        }
    }

    public class MerchantListVh_ViewBinding implements Unbinder {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public MerchantListVh f7830b;

        @UiThread
        public MerchantListVh_ViewBinding(MerchantListVh merchantListVh, View view) {
            this.f7830b = merchantListVh;
            merchantListVh.mMerchantCoverImg = (CoreRoundedImageView) d.findRequiredViewAsType(view, R.id.img_merchant_cover, "field 'mMerchantCoverImg'", CoreRoundedImageView.class);
            merchantListVh.mMerchantNameTv = (CustomTextView) d.findRequiredViewAsType(view, R.id.tv_merchant_name, "field 'mMerchantNameTv'", CustomTextView.class);
            merchantListVh.mMerchantScoreValueTv = (CustomTextView) d.findRequiredViewAsType(view, R.id.tv_merchant_score_value, "field 'mMerchantScoreValueTv'", CustomTextView.class);
            merchantListVh.mMerchantCommentContentTv = (CustomTextView) d.findRequiredViewAsType(view, R.id.tv_merchant_comment_content, "field 'mMerchantCommentContentTv'", CustomTextView.class);
            merchantListVh.mSaleTagFlowLayout = (FlowLayout) d.findRequiredViewAsType(view, R.id.flow_layout_sale_tag, "field 'mSaleTagFlowLayout'", FlowLayout.class);
            merchantListVh.mMerchantAverageConsumeValueTv = (CustomTextView) d.findRequiredViewAsType(view, R.id.tv_merchant_average_consume_value, "field 'mMerchantAverageConsumeValueTv'", CustomTextView.class);
            merchantListVh.mMerchantMonthSaleVolumeValueTv = (CustomTextView) d.findRequiredViewAsType(view, R.id.tv_month_sale_volume_value, "field 'mMerchantMonthSaleVolumeValueTv'", CustomTextView.class);
        }

        @Override // butterknife.Unbinder
        @CallSuper
        public void unbind() {
            MerchantListVh merchantListVh = this.f7830b;
            if (merchantListVh == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.f7830b = null;
            merchantListVh.mMerchantCoverImg = null;
            merchantListVh.mMerchantNameTv = null;
            merchantListVh.mMerchantScoreValueTv = null;
            merchantListVh.mMerchantCommentContentTv = null;
            merchantListVh.mSaleTagFlowLayout = null;
            merchantListVh.mMerchantAverageConsumeValueTv = null;
            merchantListVh.mMerchantMonthSaleVolumeValueTv = null;
        }
    }

    @Override // com.chinavisionary.microtang.life.adapter.LifeAdapter, com.chinavisionary.microtang.main.adapter.MainAdapter, com.chinavisionary.core.app.adapter.BaseRecyclerAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i2) {
        return super.getItemViewType(i2);
    }

    @Override // com.chinavisionary.microtang.life.adapter.LifeAdapter, com.chinavisionary.microtang.main.adapter.MainAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i2) {
        if (viewHolder.getItemViewType() == 6) {
            MerchantListVh merchantListVh = (MerchantListVh) viewHolder;
            merchantListVh.setFirstLastPosition(this.f6464f, this.f6465g);
            merchantListVh.i((RoomModelVo.ModulesBean) this.f6460b.get(i2 - h()));
        }
        super.onBindViewHolder(viewHolder, i2);
    }

    @Override // com.chinavisionary.microtang.life.adapter.LifeAdapter, com.chinavisionary.microtang.main.adapter.MainAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i2) {
        if (i2 != 6) {
            return super.onCreateViewHolder(viewGroup, i2);
        }
        MerchantListVh merchantListVh = new MerchantListVh(i(viewGroup, R.layout.item_merchant_list_layout));
        a(merchantListVh);
        return merchantListVh;
    }
}
