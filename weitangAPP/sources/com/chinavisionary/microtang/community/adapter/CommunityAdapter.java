package com.chinavisionary.microtang.community.adapter;

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
import c.k.b.a;
import com.chinavisionary.core.app.adapter.BaseRecyclerAdapter;
import com.chinavisionary.core.app.adapter.BaseRecyclerViewHolder;
import com.chinavisionary.core.weight.CoreRoundedImageView;
import com.chinavisionary.core.weight.banner.EditBannerView;
import com.chinavisionary.framework.mobile.common.vo.ResourceVo;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.community.vo.CommunityActivityVo;
import com.chinavisionary.microtang.community.vo.CommunityCommentVo;
import com.chinavisionary.microtang.community.vo.CommunityGuideVo;
import com.chinavisionary.microtang.community.vo.CommunityVo;
import com.chinavisionary.microtang.main.vo.ModelBannerVo;
import com.lzy.ninegrid.NineGridView;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class CommunityAdapter extends BaseRecyclerAdapter<CommunityVo> {

    public static class ActivityVH extends BaseRecyclerViewHolder<CommunityVo> {

        @BindView(R.id.img_activity_cover)
        public CoreRoundedImageView mActivityCoverImg;

        @BindView(R.id.tv_publish_time)
        public TextView mActivityPublishTimeTv;

        @BindView(R.id.tv_publisher)
        public TextView mActivityPublisherTv;

        @BindView(R.id.tv_activity_subtitle)
        public TextView mActivitySubtitleTv;

        @BindView(R.id.tv_activity_title)
        public TextView mActivityTitleTv;

        @BindView(R.id.tv_top_sticky)
        public TextView mTopStickyTv;

        public ActivityVH(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }

        public void g(CommunityVo communityVo) {
            CommunityActivityVo communityActivityVo = communityVo.getCommunityActivityVo();
            if (communityActivityVo != null) {
                this.mActivityCoverImg.loadImageToUrl(d(communityActivityVo.getCoverResource()));
                this.mActivityTitleTv.setText(x.getNotNullStr(communityActivityVo.getTitle(), ""));
                this.mActivitySubtitleTv.setText(x.getNotNullStr(communityActivityVo.getSubtitle(), ""));
                String strAppendStringToResId = x.appendStringToResId(R.string.placeholder_comment_count, String.valueOf(communityActivityVo.getCommentCount()));
                this.mActivityPublisherTv.setText(x.getNotNullStr(communityActivityVo.getPublisher(), "") + strAppendStringToResId);
                this.mActivityPublishTimeTv.setText(z.getTimeYYMMDD(communityActivityVo.getPublishTime()));
                this.mTopStickyTv.setVisibility(communityActivityVo.isTopSticky() ? 0 : 8);
                this.mTopStickyTv.setText(x.getNotNullStr(communityActivityVo.getTopSticky(), ""));
            }
        }
    }

    public class ActivityVH_ViewBinding implements Unbinder {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public ActivityVH f7038b;

        @UiThread
        public ActivityVH_ViewBinding(ActivityVH activityVH, View view) {
            this.f7038b = activityVH;
            activityVH.mActivityCoverImg = (CoreRoundedImageView) d.findRequiredViewAsType(view, R.id.img_activity_cover, "field 'mActivityCoverImg'", CoreRoundedImageView.class);
            activityVH.mActivityTitleTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_activity_title, "field 'mActivityTitleTv'", TextView.class);
            activityVH.mActivitySubtitleTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_activity_subtitle, "field 'mActivitySubtitleTv'", TextView.class);
            activityVH.mTopStickyTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_top_sticky, "field 'mTopStickyTv'", TextView.class);
            activityVH.mActivityPublisherTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_publisher, "field 'mActivityPublisherTv'", TextView.class);
            activityVH.mActivityPublishTimeTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_publish_time, "field 'mActivityPublishTimeTv'", TextView.class);
        }

        @Override // butterknife.Unbinder
        @CallSuper
        public void unbind() {
            ActivityVH activityVH = this.f7038b;
            if (activityVH == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.f7038b = null;
            activityVH.mActivityCoverImg = null;
            activityVH.mActivityTitleTv = null;
            activityVH.mActivitySubtitleTv = null;
            activityVH.mTopStickyTv = null;
            activityVH.mActivityPublisherTv = null;
            activityVH.mActivityPublishTimeTv = null;
        }
    }

    public static class BannerVH extends BaseRecyclerViewHolder<CommunityVo> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public View.OnClickListener f7039f;

        @BindView(R.id.banner_view)
        public EditBannerView mEditBannerView;

        public BannerVH(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }

        public final List<EditBannerView.BannerDto> g(List<ModelBannerVo> list) {
            ModelBannerVo.ParamBean param;
            ArrayList arrayList = new ArrayList();
            if (list != null && !list.isEmpty()) {
                for (ModelBannerVo modelBannerVo : list) {
                    if (modelBannerVo != null && (param = modelBannerVo.getParam()) != null) {
                        EditBannerView.BannerDto bannerDto = new EditBannerView.BannerDto();
                        bannerDto.setDataKey(param.getHref());
                        bannerDto.setCover(param.getResourceVo());
                        bannerDto.setKey(param.getHref());
                        bannerDto.setDataType(modelBannerVo.getType());
                        bannerDto.setTitle(param.getTitle());
                        arrayList.add(bannerDto);
                    }
                }
            }
            return arrayList;
        }

        public void h(CommunityVo communityVo) {
            this.mEditBannerView.setItemClickListener(this.f7039f);
            this.mEditBannerView.setFragment(null);
            if (communityVo.getDataList() != null) {
                this.mEditBannerView.setAdapterListData(g(communityVo.getDataList()));
            }
        }

        public void setOnClickListener(View.OnClickListener onClickListener) {
            this.f7039f = onClickListener;
        }
    }

    public class BannerVH_ViewBinding implements Unbinder {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public BannerVH f7040b;

        @UiThread
        public BannerVH_ViewBinding(BannerVH bannerVH, View view) {
            this.f7040b = bannerVH;
            bannerVH.mEditBannerView = (EditBannerView) d.findRequiredViewAsType(view, R.id.banner_view, "field 'mEditBannerView'", EditBannerView.class);
        }

        @Override // butterknife.Unbinder
        @CallSuper
        public void unbind() {
            BannerVH bannerVH = this.f7040b;
            if (bannerVH == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.f7040b = null;
            bannerVH.mEditBannerView = null;
        }
    }

    public static class GuideVH extends BaseRecyclerViewHolder<CommunityVo> {

        @BindView(R.id.tv_subtitle)
        public TextView mSubtitleTv;

        @BindView(R.id.tv_title)
        public TextView mTitleTv;

        @BindView(R.id.tv_top_sticky)
        public TextView mTopStickyTv;

        public GuideVH(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }

        public void g(CommunityVo communityVo) {
            CommunityGuideVo communityGuideVo = communityVo.getCommunityGuideVo();
            this.mTitleTv.setText(x.getNotNullStr(communityGuideVo.getTitle(), ""));
            String strAppendStringToResId = x.appendStringToResId(R.string.placeholder_comment_count, String.valueOf(communityGuideVo.getCommentCount()));
            this.mSubtitleTv.setText(x.getNotNullStr(communityGuideVo.getPublisher(), "") + strAppendStringToResId);
            this.mTopStickyTv.setVisibility(communityGuideVo.isTopSticky() ? 0 : 8);
            this.mTopStickyTv.setText(x.getNotNullStr(communityGuideVo.getTopSticky(), ""));
        }
    }

    public class GuideVH_ViewBinding implements Unbinder {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public GuideVH f7041b;

        @UiThread
        public GuideVH_ViewBinding(GuideVH guideVH, View view) {
            this.f7041b = guideVH;
            guideVH.mTitleTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_title, "field 'mTitleTv'", TextView.class);
            guideVH.mTopStickyTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_top_sticky, "field 'mTopStickyTv'", TextView.class);
            guideVH.mSubtitleTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_subtitle, "field 'mSubtitleTv'", TextView.class);
        }

        @Override // butterknife.Unbinder
        @CallSuper
        public void unbind() {
            GuideVH guideVH = this.f7041b;
            if (guideVH == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.f7041b = null;
            guideVH.mTitleTv = null;
            guideVH.mTopStickyTv = null;
            guideVH.mSubtitleTv = null;
        }
    }

    public static class TopicVH extends BaseRecyclerViewHolder<CommunityVo> {

        @BindView(R.id.tv_comment_count)
        public TextView mCommentCountTv;

        @BindView(R.id.tv_like_count)
        public TextView mLikeCountTv;

        @BindView(R.id.nine_grid_view_comment)
        public NineGridView mNineGridViewComment;

        @BindView(R.id.tv_publish_content)
        public TextView mPublishContentTv;

        @BindView(R.id.tv_publish_time)
        public TextView mPublishTimeTv;

        @BindView(R.id.img_user_icon)
        public CoreRoundedImageView mUserIconImg;

        @BindView(R.id.tv_user_name)
        public TextView mUserNameTv;

        public TopicVH(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }

        public final List<a> g(List<ResourceVo> list) {
            ArrayList arrayList = new ArrayList();
            if (list != null && !list.isEmpty()) {
                for (ResourceVo resourceVo : list) {
                    a aVar = new a();
                    aVar.setBigImageUrl(resourceVo.getUrl());
                    aVar.setThumbnailUrl(resourceVo.getUrl());
                    arrayList.add(aVar);
                }
            }
            return arrayList;
        }

        public void h(CommunityVo communityVo) {
            CommunityCommentVo communityCommentVo = communityVo.getCommunityCommentVo();
            if (communityCommentVo != null) {
                this.mUserIconImg.loadImageToUrl(d(communityCommentVo.getUserIconResource()));
                this.mPublishTimeTv.setText(z.getTimeYYMMDD(communityCommentVo.getPublishTime()));
                this.mPublishContentTv.setText(x.getNotNullStr(communityCommentVo.getContent(), ""));
                this.mUserNameTv.setText(x.getNotNullStr(communityCommentVo.getUserName(), ""));
                this.mNineGridViewComment.setAdapter(new c.k.b.d.a(this.mNineGridViewComment.getContext(), g(communityCommentVo.getPublishPicList())));
                this.mLikeCountTv.setText(x.appendStringToResId(R.string.placeholder_like_count, String.valueOf(communityCommentVo.getLikeCount())));
                this.mCommentCountTv.setText(x.appendStringToResId(R.string.placeholder_comment_count, String.valueOf(communityCommentVo.getLikeCount())));
            }
        }
    }

    public class TopicVH_ViewBinding implements Unbinder {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public TopicVH f7042b;

        @UiThread
        public TopicVH_ViewBinding(TopicVH topicVH, View view) {
            this.f7042b = topicVH;
            topicVH.mUserIconImg = (CoreRoundedImageView) d.findRequiredViewAsType(view, R.id.img_user_icon, "field 'mUserIconImg'", CoreRoundedImageView.class);
            topicVH.mUserNameTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_user_name, "field 'mUserNameTv'", TextView.class);
            topicVH.mPublishTimeTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_publish_time, "field 'mPublishTimeTv'", TextView.class);
            topicVH.mPublishContentTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_publish_content, "field 'mPublishContentTv'", TextView.class);
            topicVH.mNineGridViewComment = (NineGridView) d.findRequiredViewAsType(view, R.id.nine_grid_view_comment, "field 'mNineGridViewComment'", NineGridView.class);
            topicVH.mLikeCountTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_like_count, "field 'mLikeCountTv'", TextView.class);
            topicVH.mCommentCountTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_comment_count, "field 'mCommentCountTv'", TextView.class);
        }

        @Override // butterknife.Unbinder
        @CallSuper
        public void unbind() {
            TopicVH topicVH = this.f7042b;
            if (topicVH == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.f7042b = null;
            topicVH.mUserIconImg = null;
            topicVH.mUserNameTv = null;
            topicVH.mPublishTimeTv = null;
            topicVH.mPublishContentTv = null;
            topicVH.mNineGridViewComment = null;
            topicVH.mLikeCountTv = null;
            topicVH.mCommentCountTv = null;
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
        List<T> list = this.f6460b;
        return (list == 0 || list.isEmpty()) ? super.getItemViewType(i2) : ((CommunityVo) this.f6460b.get(i2)).getViewType();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i2) {
        int itemViewType = viewHolder.getItemViewType();
        if (itemViewType == 1111) {
            GuideVH guideVH = (GuideVH) viewHolder;
            guideVH.g((CommunityVo) this.f6460b.get(i2 - h()));
            b(guideVH, i2);
        } else if (itemViewType == 1222) {
            ActivityVH activityVH = (ActivityVH) viewHolder;
            activityVH.g((CommunityVo) this.f6460b.get(i2 - h()));
            b(activityVH, i2);
        } else if (itemViewType != 1333) {
            if (itemViewType != 1444) {
                return;
            }
            ((BannerVH) viewHolder).h((CommunityVo) this.f6460b.get(i2 - h()));
        } else {
            TopicVH topicVH = (TopicVH) viewHolder;
            topicVH.h((CommunityVo) this.f6460b.get(i2 - h()));
            b(topicVH, i2);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i2) {
        RecyclerView.ViewHolder footerViewHolder;
        if (i2 == 1111) {
            View viewI = i(viewGroup, R.layout.item_community_guide);
            GuideVH guideVH = new GuideVH(viewI);
            viewI.setTag(guideVH);
            footerViewHolder = guideVH;
        } else if (i2 == 1222) {
            View viewI2 = i(viewGroup, R.layout.item_community_activity);
            ActivityVH activityVH = new ActivityVH(viewI2);
            viewI2.setTag(activityVH);
            footerViewHolder = activityVH;
        } else if (i2 == 1333) {
            View viewI3 = i(viewGroup, R.layout.item_community_comment);
            TopicVH topicVH = new TopicVH(viewI3);
            viewI3.setTag(topicVH);
            footerViewHolder = topicVH;
        } else if (i2 == 1444) {
            BannerVH bannerVH = new BannerVH(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_life_banner_layout, viewGroup, false));
            bannerVH.setOnClickListener(this.f6461c);
            footerViewHolder = bannerVH;
        } else {
            if (i2 == 26214) {
                return new BaseRecyclerAdapter.RecyclerHeadViewHodler(this.f6466h);
            }
            if (i2 != 39321) {
                return null;
            }
            footerViewHolder = new BaseRecyclerAdapter.FooterViewHolder(f(viewGroup));
        }
        return footerViewHolder;
    }
}
