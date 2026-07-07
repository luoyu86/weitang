package com.chinavisionary.microtang.main.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
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
import c.e.a.d.g;
import c.e.a.d.x;
import com.chinavisionary.core.app.ad.manager.ADManager;
import com.chinavisionary.core.app.adapter.BaseRecyclerAdapter;
import com.chinavisionary.core.app.adapter.BaseRecyclerViewHolder;
import com.chinavisionary.core.weight.CoreRoundedImageView;
import com.chinavisionary.core.weight.banner.EditBannerView;
import com.chinavisionary.framework.mobile.common.vo.ResourceVo;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.main.vo.ModelProductVo;
import com.chinavisionary.microtang.main.vo.RoomModelVo;
import com.chinavisionary.microtang.view.HorMainRoomView;
import com.tom_roush.fontbox.ttf.OS2WindowsMetricsTable;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class NewRoomMainAdapter extends BaseRecyclerAdapter<RoomModelVo.ModulesBean> {
    public int n;
    public Fragment o;

    public static class BannerVH extends BaseRecyclerViewHolder<RoomModelVo.ModulesBean> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public View.OnClickListener f7359f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public Fragment f7360g;

        @BindView(R.id.banner_view)
        public EditBannerView mEditBannerView;

        public BannerVH(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }

        public void h(RoomModelVo.ModulesBean modulesBean) {
            this.mEditBannerView.setItemClickListener(this.f7359f);
            this.mEditBannerView.setFragment(null);
            if (modulesBean.getBannerDtoList() != null) {
                this.mEditBannerView.setAdapterListData(modulesBean.getBannerDtoList());
            }
            if (this.f7360g == null || !g.getInstance().isHasEnableMainBannerAd()) {
                return;
            }
            FrameLayout frameLayoutCreateBannerFrameLayout = ADManager.getInstance().createBannerFrameLayout(this.mEditBannerView.getContext(), false);
            this.mEditBannerView.addViewToAdapter(frameLayoutCreateBannerFrameLayout);
            ADManager.getInstance().loadMainBannerAd(this.f7360g, frameLayoutCreateBannerFrameLayout);
        }

        public void setFragment(Fragment fragment) {
            this.f7360g = fragment;
        }

        public final void setOnClickListener(View.OnClickListener onClickListener) {
            this.f7359f = onClickListener;
        }
    }

    public class BannerVH_ViewBinding implements Unbinder {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public BannerVH f7361b;

        @UiThread
        public BannerVH_ViewBinding(BannerVH bannerVH, View view) {
            this.f7361b = bannerVH;
            bannerVH.mEditBannerView = (EditBannerView) d.findRequiredViewAsType(view, R.id.banner_view, "field 'mEditBannerView'", EditBannerView.class);
        }

        @Override // butterknife.Unbinder
        @CallSuper
        public void unbind() {
            BannerVH bannerVH = this.f7361b;
            if (bannerVH == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.f7361b = null;
            bannerVH.mEditBannerView = null;
        }
    }

    public static class HorMainRoomVh extends BaseRecyclerViewHolder<RoomModelVo.ModulesBean> {

        @BindView(R.id.llayout_room_list)
        public HorMainRoomView mHorMainRoomView;
    }

    public class HorMainRoomVh_ViewBinding implements Unbinder {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public HorMainRoomVh f7362b;

        @UiThread
        public HorMainRoomVh_ViewBinding(HorMainRoomVh horMainRoomVh, View view) {
            this.f7362b = horMainRoomVh;
            horMainRoomVh.mHorMainRoomView = (HorMainRoomView) d.findRequiredViewAsType(view, R.id.llayout_room_list, "field 'mHorMainRoomView'", HorMainRoomView.class);
        }

        @Override // butterknife.Unbinder
        @CallSuper
        public void unbind() {
            HorMainRoomVh horMainRoomVh = this.f7362b;
            if (horMainRoomVh == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.f7362b = null;
            horMainRoomVh.mHorMainRoomView = null;
        }
    }

    public static class MainRoomVH extends BaseRecyclerViewHolder<RoomModelVo.ModulesBean> {

        @BindView(R.id.img_room_cover)
        public CoreRoundedImageView mMainCoverImg;

        @BindView(R.id.tv_room_price)
        public TextView mRoomPriceTv;

        @BindView(R.id.tv_room_subtitle)
        public TextView mRoomSubtitleTv;

        @BindView(R.id.tv_room_title)
        public TextView mRoomTitleTv;

        public MainRoomVH(View view) {
            super(view);
            ButterKnife.bind(this, view);
            this.mMainCoverImg.setPicWidth(OS2WindowsMetricsTable.WEIGHT_CLASS_EXTRA_BOLD);
            this.mMainCoverImg.setPicHeight(500);
        }

        public void g(RoomModelVo.ModulesBean modulesBean) {
            ModelProductVo modelProductVo = modulesBean.getModelProductVo();
            if (modelProductVo != null) {
                ModelProductVo.ParamBean param = modelProductVo.getParam();
                if (super.e()) {
                    List<ResourceVo> resourceVos = param != null ? param.getResourceVos() : null;
                    if (resourceVos != null && !resourceVos.isEmpty()) {
                        this.mMainCoverImg.loadAliImageToUrl(resourceVos.get(0).getUrl());
                    }
                } else {
                    this.mMainCoverImg.recyclerImage();
                }
                if (param != null) {
                    this.mRoomTitleTv.setText(x.getNotNullStr(param.getCommodityTitle(), ""));
                    this.mRoomSubtitleTv.setText(x.getNotNullStr(param.getCommoditySubtitle(), ""));
                    this.mRoomPriceTv.setText(x.appendStringToResId(R.string.rmb_placeholder, x.getNotNullStr(param.getMinimumMonthlyRent(), "")));
                } else {
                    this.mRoomTitleTv.setText("");
                    this.mRoomSubtitleTv.setText("");
                    this.mRoomPriceTv.setText("");
                }
            }
        }
    }

    public class MainRoomVH_ViewBinding implements Unbinder {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public MainRoomVH f7363b;

        @UiThread
        public MainRoomVH_ViewBinding(MainRoomVH mainRoomVH, View view) {
            this.f7363b = mainRoomVH;
            mainRoomVH.mMainCoverImg = (CoreRoundedImageView) d.findRequiredViewAsType(view, R.id.img_room_cover, "field 'mMainCoverImg'", CoreRoundedImageView.class);
            mainRoomVH.mRoomTitleTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_room_title, "field 'mRoomTitleTv'", TextView.class);
            mainRoomVH.mRoomSubtitleTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_room_subtitle, "field 'mRoomSubtitleTv'", TextView.class);
            mainRoomVH.mRoomPriceTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_room_price, "field 'mRoomPriceTv'", TextView.class);
        }

        @Override // butterknife.Unbinder
        @CallSuper
        public void unbind() {
            MainRoomVH mainRoomVH = this.f7363b;
            if (mainRoomVH == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.f7363b = null;
            mainRoomVH.mMainCoverImg = null;
            mainRoomVH.mRoomTitleTv = null;
            mainRoomVH.mRoomSubtitleTv = null;
            mainRoomVH.mRoomPriceTv = null;
        }
    }

    public static class MainVH extends BaseRecyclerViewHolder<RoomModelVo.ModulesBean> {

        @BindView(R.id.img_room_cover)
        public CoreRoundedImageView mMainCoverImg;

        @BindView(R.id.img_room_right_bottom)
        public CoreRoundedImageView mMainRightBottomImg;

        @BindView(R.id.img_room_right_top)
        public CoreRoundedImageView mMainRightTopImg;

        @BindView(R.id.tv_room_price)
        public TextView mRoomPriceTv;

        @BindView(R.id.tv_room_subtitle)
        public TextView mRoomSubtitleTv;

        @BindView(R.id.tv_room_title)
        public TextView mRoomTitleTv;
    }

    public class MainVH_ViewBinding implements Unbinder {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public MainVH f7364b;

        @UiThread
        public MainVH_ViewBinding(MainVH mainVH, View view) {
            this.f7364b = mainVH;
            mainVH.mMainCoverImg = (CoreRoundedImageView) d.findRequiredViewAsType(view, R.id.img_room_cover, "field 'mMainCoverImg'", CoreRoundedImageView.class);
            mainVH.mMainRightTopImg = (CoreRoundedImageView) d.findRequiredViewAsType(view, R.id.img_room_right_top, "field 'mMainRightTopImg'", CoreRoundedImageView.class);
            mainVH.mMainRightBottomImg = (CoreRoundedImageView) d.findRequiredViewAsType(view, R.id.img_room_right_bottom, "field 'mMainRightBottomImg'", CoreRoundedImageView.class);
            mainVH.mRoomTitleTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_room_title, "field 'mRoomTitleTv'", TextView.class);
            mainVH.mRoomSubtitleTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_room_subtitle, "field 'mRoomSubtitleTv'", TextView.class);
            mainVH.mRoomPriceTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_room_price, "field 'mRoomPriceTv'", TextView.class);
        }

        @Override // butterknife.Unbinder
        @CallSuper
        public void unbind() {
            MainVH mainVH = this.f7364b;
            if (mainVH == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.f7364b = null;
            mainVH.mMainCoverImg = null;
            mainVH.mMainRightTopImg = null;
            mainVH.mMainRightBottomImg = null;
            mainVH.mRoomTitleTv = null;
            mainVH.mRoomSubtitleTv = null;
            mainVH.mRoomPriceTv = null;
        }
    }

    public static class TitleVH extends BaseRecyclerViewHolder<RoomModelVo.ModulesBean> {

        @BindView(R.id.tv_main_right)
        public TextView mDescTv;

        @BindView(R.id.img_right_icon)
        public ImageView mRightArrowImg;

        @BindView(R.id.tv_main_subtitle)
        public TextView mSubtitleTv;

        @BindView(R.id.tv_main_title)
        public TextView mTitleTv;
    }

    public class TitleVH_ViewBinding implements Unbinder {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public TitleVH f7365b;

        @UiThread
        public TitleVH_ViewBinding(TitleVH titleVH, View view) {
            this.f7365b = titleVH;
            titleVH.mTitleTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_main_title, "field 'mTitleTv'", TextView.class);
            titleVH.mSubtitleTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_main_subtitle, "field 'mSubtitleTv'", TextView.class);
            titleVH.mDescTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_main_right, "field 'mDescTv'", TextView.class);
            titleVH.mRightArrowImg = (ImageView) d.findRequiredViewAsType(view, R.id.img_right_icon, "field 'mRightArrowImg'", ImageView.class);
        }

        @Override // butterknife.Unbinder
        @CallSuper
        public void unbind() {
            TitleVH titleVH = this.f7365b;
            if (titleVH == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.f7365b = null;
            titleVH.mTitleTv = null;
            titleVH.mSubtitleTv = null;
            titleVH.mDescTv = null;
            titleVH.mRightArrowImg = null;
        }
    }

    public static class a extends BaseRecyclerViewHolder<RoomModelVo.ModulesBean> {
        public a(View view) {
            super(view);
        }
    }

    @Override // com.chinavisionary.core.app.adapter.BaseRecyclerAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i2) {
        RoomModelVo.ModulesBean modulesBean;
        if (this.f6466h != null && i2 == 0) {
            return 26214;
        }
        if (this.f6463e && i2 == getItemCount() - 1) {
            return 39321;
        }
        List<T> list = this.f6460b;
        return (list == 0 || list.isEmpty() || (modulesBean = (RoomModelVo.ModulesBean) this.f6460b.get(i2)) == null) ? super.getItemViewType(i2) : modulesBean.getModuleType();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i2) {
        int itemViewType = viewHolder.getItemViewType();
        if (itemViewType == 1) {
            ((BannerVH) viewHolder).h((RoomModelVo.ModulesBean) this.f6460b.get(i2 - h()));
        } else {
            if (itemViewType != 3) {
                return;
            }
            MainRoomVH mainRoomVH = (MainRoomVH) viewHolder;
            mainRoomVH.setFirstLastPosition(this.f6464f, this.f6465g);
            mainRoomVH.g((RoomModelVo.ModulesBean) this.f6460b.get(i2 - h()));
            b(mainRoomVH, i2);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i2) {
        if (i2 != 1) {
            if (i2 != 3) {
                return i2 != 26214 ? i2 != 34952 ? i2 != 39321 ? new a(i(viewGroup, R.layout.item_empty_vh_layout)) : new BaseRecyclerAdapter.FooterViewHolder(f(viewGroup)) : new BaseRecyclerAdapter.EmptyViewHolder(d(viewGroup)) : new BaseRecyclerAdapter.RecyclerHeadViewHodler(this.f6466h);
            }
            View viewI = i(viewGroup, R.layout.item_main_room_layout);
            MainRoomVH mainRoomVH = new MainRoomVH(viewI);
            viewI.setTag(mainRoomVH);
            return mainRoomVH;
        }
        View viewI2 = i(viewGroup, R.layout.item_main_banner_layout);
        BannerVH bannerVH = new BannerVH(viewI2);
        bannerVH.setOnClickListener(this.f6461c);
        bannerVH.setFragment(this.o);
        viewI2.setTag(bannerVH);
        return bannerVH;
    }

    public void setFragment(Fragment fragment) {
        this.o = fragment;
    }

    public void setMainType(int i2) {
        this.n = i2;
    }
}
