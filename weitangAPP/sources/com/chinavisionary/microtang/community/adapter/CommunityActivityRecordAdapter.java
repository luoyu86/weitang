package com.chinavisionary.microtang.community.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.UiThread;
import androidx.appcompat.widget.AppCompatButton;
import androidx.recyclerview.widget.RecyclerView;
import b.c.d;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import c.e.a.d.x;
import c.e.a.d.z;
import com.chinavisionary.core.app.adapter.BaseRecyclerAdapter;
import com.chinavisionary.core.app.adapter.BaseRecyclerViewHolder;
import com.chinavisionary.core.weight.CoreRoundedImageView;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.community.vo.NewCommunityActivityItemVo;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class CommunityActivityRecordAdapter extends BaseRecyclerAdapter<NewCommunityActivityItemVo> {
    public int n;

    public static class CommunityActivityVh extends BaseRecyclerViewHolder<NewCommunityActivityItemVo> {

        @BindView(R.id.img_activity_cover)
        public CoreRoundedImageView mActivityCoverImg;

        @BindView(R.id.tv_activity_lab)
        public TextView mActivityLabTv;

        @BindView(R.id.tv_activity_time)
        public TextView mActivityTimeTv;

        @BindView(R.id.tv_activity_title)
        public TextView mActivityTitleTv;

        @BindView(R.id.btn_comment)
        public AppCompatButton mCommentBtn;

        public CommunityActivityVh(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }

        public void g(NewCommunityActivityItemVo newCommunityActivityItemVo) {
            this.mActivityLabTv.setVisibility(newCommunityActivityItemVo.getActivityLab() != null ? 0 : 8);
            this.mActivityTitleTv.setText(c(newCommunityActivityItemVo.getTitle()));
            this.mActivityTimeTv.setText(x.getString(R.string.placeholder_activity_time, z.getTime(newCommunityActivityItemVo.getStartTime()), z.isEqualsDay(newCommunityActivityItemVo.getStartTime(), newCommunityActivityItemVo.getEndTime()) ? z.getTime(newCommunityActivityItemVo.getEndTime(), z.l) : z.getTime(newCommunityActivityItemVo.getEndTime())));
            h(newCommunityActivityItemVo.getComment());
            this.mActivityCoverImg.loadImageToUrl(newCommunityActivityItemVo.getCoverUrl());
        }

        public final void h(Boolean bool) {
            if (bool == null) {
                this.mCommentBtn.setVisibility(8);
                return;
            }
            this.mCommentBtn.setOnClickListener(this.f6469b);
            this.mCommentBtn.setTag(Integer.valueOf(getAdapterPosition()));
            this.mCommentBtn.setVisibility(0);
            if (bool.booleanValue()) {
                this.mCommentBtn.setText(R.string.title_cat_comment);
                this.mCommentBtn.setBackgroundResource(R.drawable.bg_btn_activity_cat_comment);
            } else {
                this.mCommentBtn.setText(R.string.title_comment);
                this.mCommentBtn.setBackgroundResource(R.drawable.bg_btn_activity_join);
            }
        }
    }

    public class CommunityActivityVh_ViewBinding implements Unbinder {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public CommunityActivityVh f7037b;

        @UiThread
        public CommunityActivityVh_ViewBinding(CommunityActivityVh communityActivityVh, View view) {
            this.f7037b = communityActivityVh;
            communityActivityVh.mActivityCoverImg = (CoreRoundedImageView) d.findRequiredViewAsType(view, R.id.img_activity_cover, "field 'mActivityCoverImg'", CoreRoundedImageView.class);
            communityActivityVh.mActivityTitleTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_activity_title, "field 'mActivityTitleTv'", TextView.class);
            communityActivityVh.mActivityLabTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_activity_lab, "field 'mActivityLabTv'", TextView.class);
            communityActivityVh.mActivityTimeTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_activity_time, "field 'mActivityTimeTv'", TextView.class);
            communityActivityVh.mCommentBtn = (AppCompatButton) d.findRequiredViewAsType(view, R.id.btn_comment, "field 'mCommentBtn'", AppCompatButton.class);
        }

        @Override // butterknife.Unbinder
        @CallSuper
        public void unbind() {
            CommunityActivityVh communityActivityVh = this.f7037b;
            if (communityActivityVh == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.f7037b = null;
            communityActivityVh.mActivityCoverImg = null;
            communityActivityVh.mActivityTitleTv = null;
            communityActivityVh.mActivityLabTv = null;
            communityActivityVh.mActivityTimeTv = null;
            communityActivityVh.mCommentBtn = null;
        }
    }

    public CommunityActivityRecordAdapter(int i2) {
        this.n = i2;
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
        return (list == 0 || list.isEmpty()) ? super.getItemViewType(i2) : ((NewCommunityActivityItemVo) this.f6460b.get(i2)).getViewType();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i2) {
        if (122 == viewHolder.getItemViewType()) {
            ((CommunityActivityVh) viewHolder).g((NewCommunityActivityItemVo) this.f6460b.get(i2));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i2) {
        return 122 == i2 ? p(viewGroup) : 39321 == i2 ? new BaseRecyclerAdapter.FooterViewHolder(f(viewGroup)) : 34952 == i2 ? new BaseRecyclerAdapter.EmptyViewHolder(d(viewGroup)) : super.c(viewGroup, i2);
    }

    public final RecyclerView.ViewHolder p(ViewGroup viewGroup) {
        CommunityActivityVh communityActivityVh = new CommunityActivityVh(i(viewGroup, R.layout.item_community_activity_list_layout));
        communityActivityVh.setViewOnClickListener(this.f6461c);
        a(communityActivityVh);
        return communityActivityVh;
    }
}
