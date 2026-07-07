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
import c.e.a.d.o;
import c.e.a.d.x;
import c.e.c.m0.l;
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
public class MainAdapter extends BaseRecyclerAdapter<RoomModelVo.ModulesBean> {
    public int n;
    public Fragment o;

    public static class BannerVH extends BaseRecyclerViewHolder<RoomModelVo.ModulesBean> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public View.OnClickListener f7350f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public Fragment f7351g;

        @BindView(R.id.view_top_title)
        public View mBannerView;

        @BindView(R.id.banner_view)
        public EditBannerView mEditBannerView;

        public BannerVH(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }

        public void h(RoomModelVo.ModulesBean modulesBean) {
            this.mEditBannerView.setItemClickListener(this.f7350f);
            this.mEditBannerView.setImageCornerRadius(0);
            this.mEditBannerView.setImageCornerBottomLeftRadius(this.itemView.getResources().getDimensionPixelSize(R.dimen.dp_25));
            this.mEditBannerView.setFragment(null);
            if (o.isNotEmpty(modulesBean.getBannerDtoList()) || g.getInstance().isHasEnableMainBannerAd()) {
                if (this.mEditBannerView.getVisibility() != 0) {
                    this.mEditBannerView.setVisibility(0);
                    this.mBannerView.setVisibility(8);
                }
                this.mEditBannerView.setAdapterListData(modulesBean.getBannerDtoList());
            } else {
                if (this.mEditBannerView.getVisibility() != 8) {
                    this.mEditBannerView.setVisibility(8);
                }
                this.mBannerView.setVisibility(0);
            }
            if (this.f7351g == null || !g.getInstance().isHasEnableMainBannerAd()) {
                return;
            }
            FrameLayout frameLayoutCreateBannerFrameLayout = ADManager.getInstance().createBannerFrameLayout(this.mEditBannerView.getContext(), false);
            this.mEditBannerView.addViewToAdapter(frameLayoutCreateBannerFrameLayout);
            ADManager.getInstance().loadMainBannerAd(this.f7351g, frameLayoutCreateBannerFrameLayout);
        }

        public void setFragment(Fragment fragment) {
            this.f7351g = fragment;
        }

        public final void setOnClickListener(View.OnClickListener onClickListener) {
            this.f7350f = onClickListener;
        }
    }

    public class BannerVH_ViewBinding implements Unbinder {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public BannerVH f7352b;

        @UiThread
        public BannerVH_ViewBinding(BannerVH bannerVH, View view) {
            this.f7352b = bannerVH;
            bannerVH.mEditBannerView = (EditBannerView) d.findRequiredViewAsType(view, R.id.banner_view, "field 'mEditBannerView'", EditBannerView.class);
            bannerVH.mBannerView = d.findRequiredView(view, R.id.view_top_title, "field 'mBannerView'");
        }

        @Override // butterknife.Unbinder
        @CallSuper
        public void unbind() {
            BannerVH bannerVH = this.f7352b;
            if (bannerVH == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.f7352b = null;
            bannerVH.mEditBannerView = null;
            bannerVH.mBannerView = null;
        }
    }

    public static class EnterpriseNotifyVH extends BaseRecyclerViewHolder<RoomModelVo.ModulesBean> {

        @BindView(R.id.tv_notify_msg)
        public TextView mTitleTv;

        public EnterpriseNotifyVH(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }

        public void g(RoomModelVo.ModulesBean modulesBean) {
            this.mTitleTv.setVisibility(x.isNotNull(modulesBean.getModuleTitle()) ? 0 : 8);
            this.mTitleTv.setText(x.getNotNullStr(modulesBean.getModuleTitle(), ""));
        }
    }

    public class EnterpriseNotifyVH_ViewBinding implements Unbinder {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public EnterpriseNotifyVH f7353b;

        @UiThread
        public EnterpriseNotifyVH_ViewBinding(EnterpriseNotifyVH enterpriseNotifyVH, View view) {
            this.f7353b = enterpriseNotifyVH;
            enterpriseNotifyVH.mTitleTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_notify_msg, "field 'mTitleTv'", TextView.class);
        }

        @Override // butterknife.Unbinder
        @CallSuper
        public void unbind() {
            EnterpriseNotifyVH enterpriseNotifyVH = this.f7353b;
            if (enterpriseNotifyVH == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.f7353b = null;
            enterpriseNotifyVH.mTitleTv = null;
        }
    }

    public static class HorMainRoomVh extends BaseRecyclerViewHolder<RoomModelVo.ModulesBean> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public View.OnClickListener f7354f;

        @BindView(R.id.llayout_room_list)
        public HorMainRoomView mHorMainRoomView;

        public HorMainRoomVh(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }

        public void g(RoomModelVo.ModulesBean modulesBean) {
            this.mHorMainRoomView.setupOnClickListener(this.f7354f);
            this.mHorMainRoomView.addData(modulesBean.getSubModules(), this.f6468a);
        }

        public void setOnClickListener(View.OnClickListener onClickListener) {
            this.f7354f = onClickListener;
        }
    }

    public class HorMainRoomVh_ViewBinding implements Unbinder {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public HorMainRoomVh f7355b;

        @UiThread
        public HorMainRoomVh_ViewBinding(HorMainRoomVh horMainRoomVh, View view) {
            this.f7355b = horMainRoomVh;
            horMainRoomVh.mHorMainRoomView = (HorMainRoomView) d.findRequiredViewAsType(view, R.id.llayout_room_list, "field 'mHorMainRoomView'", HorMainRoomView.class);
        }

        @Override // butterknife.Unbinder
        @CallSuper
        public void unbind() {
            HorMainRoomVh horMainRoomVh = this.f7355b;
            if (horMainRoomVh == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.f7355b = null;
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
            if (modelProductVo == null) {
                this.mMainCoverImg.loadImageToResId(R.drawable.ic_default);
                this.mRoomTitleTv.setText("");
                this.mRoomSubtitleTv.setText("");
                this.mRoomPriceTv.setText("");
                return;
            }
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

    public class MainRoomVH_ViewBinding implements Unbinder {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public MainRoomVH f7356b;

        @UiThread
        public MainRoomVH_ViewBinding(MainRoomVH mainRoomVH, View view) {
            this.f7356b = mainRoomVH;
            mainRoomVH.mMainCoverImg = (CoreRoundedImageView) d.findRequiredViewAsType(view, R.id.img_room_cover, "field 'mMainCoverImg'", CoreRoundedImageView.class);
            mainRoomVH.mRoomTitleTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_room_title, "field 'mRoomTitleTv'", TextView.class);
            mainRoomVH.mRoomSubtitleTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_room_subtitle, "field 'mRoomSubtitleTv'", TextView.class);
            mainRoomVH.mRoomPriceTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_room_price, "field 'mRoomPriceTv'", TextView.class);
        }

        @Override // butterknife.Unbinder
        @CallSuper
        public void unbind() {
            MainRoomVH mainRoomVH = this.f7356b;
            if (mainRoomVH == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.f7356b = null;
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

        public MainVH(View view) {
            super(view);
            ButterKnife.bind(this, view);
            this.mMainCoverImg.setPicWidth(OS2WindowsMetricsTable.WEIGHT_CLASS_EXTRA_BOLD);
            this.mMainCoverImg.setPicHeight(500);
        }

        public void g(RoomModelVo.ModulesBean modulesBean) {
            ModelProductVo modelProductVo = modulesBean.getModelProductVo();
            if (modelProductVo == null) {
                this.mMainCoverImg.loadImageToResId(R.drawable.ic_default);
                this.mMainRightBottomImg.loadImageToResId(R.drawable.ic_default);
                this.mMainRightTopImg.loadImageToResId(R.drawable.ic_default);
                this.mRoomTitleTv.setText("");
                this.mRoomSubtitleTv.setText("");
                this.mRoomPriceTv.setText("");
                return;
            }
            ModelProductVo.ParamBean param = modelProductVo.getParam();
            if (super.e()) {
                List<ResourceVo> resourceVos = param != null ? param.getResourceVos() : null;
                if (resourceVos == null || resourceVos.isEmpty()) {
                    this.mMainCoverImg.loadImageToResId(R.drawable.ic_default);
                    this.mMainRightBottomImg.loadImageToResId(R.drawable.ic_default);
                    this.mMainRightTopImg.loadImageToResId(R.drawable.ic_default);
                } else {
                    this.mMainCoverImg.loadAliImageToUrl(resourceVos.get(0).getUrl());
                    if (resourceVos.size() >= 2) {
                        this.mMainRightTopImg.loadAliImageToUrl(resourceVos.get(1).getUrl());
                    } else {
                        this.mMainRightTopImg.setVisibility(8);
                        this.mMainRightBottomImg.setVisibility(8);
                    }
                    if (resourceVos.size() >= 3) {
                        this.mMainRightBottomImg.loadAliImageToUrl(resourceVos.get(2).getUrl());
                    }
                }
            } else {
                this.mMainCoverImg.recyclerImage();
                this.mMainRightTopImg.recyclerImage();
                this.mMainRightBottomImg.recyclerImage();
            }
            if (param != null) {
                this.mRoomTitleTv.setText(x.getNotNullStr(param.getCommodityTitle(), ""));
                this.mRoomSubtitleTv.setText(x.getNotNullStr(param.getCommoditySubtitle(), ""));
                l.setupMethodRentPrice(x.isNotNull(param.getMinimumMonthlyRent()) ? x.appendStringToResId(R.string.title_placeholder_rent_price, x.getNotNullStr(param.getMinimumMonthlyRent(), "")) : "", this.mRoomPriceTv);
            } else {
                this.mRoomTitleTv.setText("");
                this.mRoomSubtitleTv.setText("");
                this.mRoomPriceTv.setText("");
            }
        }
    }

    public class MainVH_ViewBinding implements Unbinder {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public MainVH f7357b;

        @UiThread
        public MainVH_ViewBinding(MainVH mainVH, View view) {
            this.f7357b = mainVH;
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
            MainVH mainVH = this.f7357b;
            if (mainVH == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.f7357b = null;
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

        public TitleVH(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }

        public void g(RoomModelVo.ModulesBean modulesBean) {
            this.mTitleTv.setVisibility(x.isNotNull(modulesBean.getModuleTitle()) ? 0 : 8);
            this.mTitleTv.setText(x.getNotNullStr(modulesBean.getModuleTitle(), ""));
            this.mSubtitleTv.setVisibility(x.isNotNull(modulesBean.getModuleSubtitle()) ? 0 : 8);
            this.mSubtitleTv.setText(x.getNotNullStr(modulesBean.getModuleSubtitle(), ""));
            this.mRightArrowImg.setVisibility(modulesBean.isHasLink() ? 0 : 8);
        }
    }

    public class TitleVH_ViewBinding implements Unbinder {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public TitleVH f7358b;

        @UiThread
        public TitleVH_ViewBinding(TitleVH titleVH, View view) {
            this.f7358b = titleVH;
            titleVH.mTitleTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_main_title, "field 'mTitleTv'", TextView.class);
            titleVH.mSubtitleTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_main_subtitle, "field 'mSubtitleTv'", TextView.class);
            titleVH.mDescTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_main_right, "field 'mDescTv'", TextView.class);
            titleVH.mRightArrowImg = (ImageView) d.findRequiredViewAsType(view, R.id.img_right_icon, "field 'mRightArrowImg'", ImageView.class);
        }

        @Override // butterknife.Unbinder
        @CallSuper
        public void unbind() {
            TitleVH titleVH = this.f7358b;
            if (titleVH == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.f7358b = null;
            titleVH.mTitleTv = null;
            titleVH.mSubtitleTv = null;
            titleVH.mDescTv = null;
            titleVH.mRightArrowImg = null;
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
            return;
        }
        if (itemViewType == 2) {
            TitleVH titleVH = (TitleVH) viewHolder;
            titleVH.g((RoomModelVo.ModulesBean) this.f6460b.get(i2 - h()));
            b(titleVH, i2);
            return;
        }
        if (itemViewType == 3) {
            if (this.n == 4) {
                MainRoomVH mainRoomVH = (MainRoomVH) viewHolder;
                mainRoomVH.setFirstLastPosition(this.f6464f, this.f6465g);
                mainRoomVH.g((RoomModelVo.ModulesBean) this.f6460b.get(i2 - h()));
                b(mainRoomVH, i2);
                return;
            }
            MainVH mainVH = (MainVH) viewHolder;
            mainVH.setFirstLastPosition(this.f6464f, this.f6465g);
            mainVH.g((RoomModelVo.ModulesBean) this.f6460b.get(i2 - h()));
            b(mainVH, i2);
            return;
        }
        if (itemViewType != 4) {
            if (itemViewType != 7) {
                return;
            }
            EnterpriseNotifyVH enterpriseNotifyVH = (EnterpriseNotifyVH) viewHolder;
            enterpriseNotifyVH.g((RoomModelVo.ModulesBean) this.f6460b.get(i2 - h()));
            b(enterpriseNotifyVH, i2);
            return;
        }
        HorMainRoomVh horMainRoomVh = (HorMainRoomVh) viewHolder;
        horMainRoomVh.setListPosition(i2);
        horMainRoomVh.setOnClickListener(this.f6461c);
        horMainRoomVh.g((RoomModelVo.ModulesBean) this.f6460b.get(i2 - h()));
        b(horMainRoomVh, i2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i2) {
        RecyclerView.ViewHolder emptyViewHolder;
        if (i2 == 1) {
            View viewI = i(viewGroup, R.layout.item_main_banner_layout);
            BannerVH bannerVH = new BannerVH(viewI);
            bannerVH.setFragment(this.o);
            bannerVH.setOnClickListener(this.f6461c);
            viewI.setTag(bannerVH);
            emptyViewHolder = bannerVH;
        } else if (i2 == 2) {
            View viewI2 = i(viewGroup, R.layout.item_main_title_layout);
            TitleVH titleVH = new TitleVH(viewI2);
            viewI2.setTag(titleVH);
            emptyViewHolder = titleVH;
        } else if (i2 != 3) {
            if (i2 == 4) {
                View viewI3 = i(viewGroup, R.layout.item_hor_main_room_layout);
                HorMainRoomVh horMainRoomVh = new HorMainRoomVh(viewI3);
                viewI3.setTag(horMainRoomVh);
                emptyViewHolder = horMainRoomVh;
            } else if (i2 == 7) {
                View viewI4 = i(viewGroup, R.layout.item_notify_msg_layout);
                EnterpriseNotifyVH enterpriseNotifyVH = new EnterpriseNotifyVH(viewI4);
                viewI4.setTag(enterpriseNotifyVH);
                emptyViewHolder = enterpriseNotifyVH;
            } else {
                if (i2 == 26214) {
                    return new BaseRecyclerAdapter.RecyclerHeadViewHodler(this.f6466h);
                }
                if (i2 == 34952) {
                    emptyViewHolder = new BaseRecyclerAdapter.EmptyViewHolder(d(viewGroup));
                } else {
                    if (i2 != 39321) {
                        return null;
                    }
                    emptyViewHolder = new BaseRecyclerAdapter.FooterViewHolder(f(viewGroup));
                }
            }
        } else if (this.n == 4) {
            View viewI5 = i(viewGroup, R.layout.item_main_room_layout);
            MainRoomVH mainRoomVH = new MainRoomVH(viewI5);
            viewI5.setTag(mainRoomVH);
            emptyViewHolder = mainRoomVH;
        } else {
            View viewI6 = i(viewGroup, R.layout.item_room);
            MainVH mainVH = new MainVH(viewI6);
            viewI6.setTag(mainVH);
            emptyViewHolder = mainVH;
        }
        return emptyViewHolder;
    }

    public void setFragment(Fragment fragment) {
        this.o = fragment;
    }

    public void setMainType(int i2) {
        this.n = i2;
    }
}
