package com.chinavisionary.microtang.community.adapter;

import android.graphics.drawable.Drawable;
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
import c.e.a.d.q;
import c.e.a.d.x;
import com.chinavisionary.core.app.adapter.BaseRecyclerAdapter;
import com.chinavisionary.core.app.adapter.BaseRecyclerViewHolder;
import com.chinavisionary.core.app.adapter.SimpleRecyclerViewHolder;
import com.chinavisionary.core.weight.CoreRoundedImageView;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.community.vo.CommunityActivityItemVo;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class CommunityActivityAdapter extends BaseRecyclerAdapter<CommunityActivityItemVo> {

    public static class CommunityActivityVh extends BaseRecyclerViewHolder<CommunityActivityItemVo> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public Drawable f7032f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public Drawable f7033g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public Drawable f7034h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public Drawable f7035i;
        public int j;
        public int k;
        public int l;
        public int m;

        @BindView(R.id.img_activity_cover)
        public CoreRoundedImageView mActivityCoverImg;

        @BindView(R.id.tv_activity_distance)
        public TextView mActivityDistanceTv;

        @BindView(R.id.btn_activity_join)
        public AppCompatButton mActivityJoinBtn;

        @BindView(R.id.tv_activity_join_number)
        public TextView mActivityJoinNumberTv;

        @BindView(R.id.tv_activity_lab)
        public TextView mActivityLabTv;

        @BindView(R.id.tv_activity_location)
        public TextView mActivityLocationTv;

        @BindView(R.id.tv_activity_publisher)
        public TextView mActivityPublisherTv;

        @BindView(R.id.tv_activity_state)
        public TextView mActivityStateTv;

        @BindView(R.id.tv_activity_time)
        public TextView mActivityTimeTv;

        @BindView(R.id.tv_activity_timer)
        public TextView mActivityTimerTv;

        @BindView(R.id.tv_activity_title)
        public TextView mActivityTitleTv;

        @BindView(R.id.tv_activity_timer_day_title)
        public TextView mDayTitleTv;

        @BindView(R.id.tv_activity_timer_day_value)
        public TextView mDayTv;

        @BindView(R.id.tv_activity_timer_hour_value)
        public TextView mHourTv;

        @BindView(R.id.tv_activity_timer_min_value)
        public TextView mMinTv;

        @BindView(R.id.tv_activity_timer_second_value)
        public TextView mSecondTv;

        @BindView(R.id.tv_time_split_end)
        public TextView mSplitEndTv;

        @BindView(R.id.tv_time_split)
        public TextView mSplitTv;

        @BindView(R.id.view_bg)
        public View mViewBg;

        public CommunityActivityVh(View view) {
            super(view);
            ButterKnife.bind(this, view);
            this.f7034h = view.getResources().getDrawable(R.mipmap.ic_activity_time_start);
            this.f7035i = view.getResources().getDrawable(R.mipmap.ic_activity_time_end);
            this.f7032f = view.getResources().getDrawable(R.mipmap.ic_activity_location_available);
            this.f7033g = view.getResources().getDrawable(R.mipmap.ic_activity_location_disable);
            this.j = view.getResources().getColor(R.color.colorA4A4A4);
            this.l = view.getResources().getColor(R.color.color909090);
            this.m = view.getResources().getColor(R.color.color000000);
            this.k = view.getResources().getColor(R.color.colorFE9900);
        }

        public void g(CommunityActivityItemVo communityActivityItemVo) {
            this.mActivityTitleTv.setText(c(communityActivityItemVo.getActivityName()));
            this.mActivityTimeTv.setText(x.getString(R.string.placeholder_activity_time, communityActivityItemVo.getShowStartDate(), communityActivityItemVo.getShowEndDate()));
            if (communityActivityItemVo.joinPersonIsFull()) {
                this.mActivityJoinNumberTv.setText(R.string.title_join_person_full);
            } else {
                this.mActivityJoinNumberTv.setText("");
            }
            this.mActivityPublisherTv.setText(c(communityActivityItemVo.getPublisher()));
            this.mActivityLabTv.setText(c(communityActivityItemVo.getActivityLab()));
            this.mActivityLabTv.setVisibility(x.isNotNull(communityActivityItemVo.getActivityLab()) ? 0 : 4);
            this.mActivityTimeTv.setVisibility(communityActivityItemVo.getActivityStartTime() != null ? 0 : 8);
            this.mActivityTimerTv.setVisibility(communityActivityItemVo.activityTimerValue() != null ? 0 : 8);
            this.mActivityLocationTv.setVisibility(x.isNotNull(communityActivityItemVo.getActivityAddress()) ? 0 : 8);
            this.mActivityDistanceTv.setVisibility(x.isNotNull(communityActivityItemVo.getDistance()) ? 0 : 8);
            this.mActivityLocationTv.setText(c(communityActivityItemVo.getActivityAddress()));
            this.mActivityDistanceTv.setText(x.getString(R.string.title_distance) + c(communityActivityItemVo.getDistance()));
            int i2 = x.isNotNull(communityActivityItemVo.activityStatusDesc()) ? 0 : 8;
            if (this.mActivityStateTv.getVisibility() != i2) {
                this.mActivityStateTv.setVisibility(i2);
            }
            if (communityActivityItemVo.getFinishFlag()) {
                this.mActivityLabTv.setBackgroundResource(R.drawable.bg_community_end_tag);
                this.mViewBg.setBackgroundResource(R.drawable.bg_community_end_item);
                this.mActivityStateTv.setTextColor(this.j);
                this.mActivityTitleTv.setTextColor(this.l);
                this.mActivityLocationTv.setTextColor(this.j);
                this.mActivityLocationTv.setCompoundDrawablesWithIntrinsicBounds(this.f7033g, (Drawable) null, (Drawable) null, (Drawable) null);
                this.mActivityTimeTv.setCompoundDrawablesWithIntrinsicBounds(this.f7035i, (Drawable) null, (Drawable) null, (Drawable) null);
                this.mActivityStateTv.setBackgroundResource(R.drawable.bg_community_activity_end_radius);
            } else {
                this.mViewBg.setBackgroundResource(R.drawable.bg_community_item);
                this.mActivityLabTv.setBackgroundResource(R.drawable.bg_community_tag);
                this.mActivityTimeTv.setCompoundDrawablesWithIntrinsicBounds(this.f7034h, (Drawable) null, (Drawable) null, (Drawable) null);
                this.mActivityLocationTv.setCompoundDrawablesWithIntrinsicBounds(this.f7032f, (Drawable) null, (Drawable) null, (Drawable) null);
                this.mActivityTitleTv.setTextColor(this.m);
                this.mActivityLocationTv.setTextColor(this.m);
                this.mActivityStateTv.setTextColor(this.k);
                this.mActivityStateTv.setBackgroundResource(R.drawable.bg_community_activity_state_radius);
            }
            this.mActivityStateTv.setText(c(communityActivityItemVo.activityStatusDesc()));
            this.mActivityCoverImg.loadImageToResourceVo(communityActivityItemVo.getCoverRes());
            h(communityActivityItemVo);
        }

        public final void h(CommunityActivityItemVo communityActivityItemVo) {
            int i2 = x.isNotNull(communityActivityItemVo.getDay()) ? 0 : 8;
            int i3 = x.isNotNull(communityActivityItemVo.getHour()) ? 0 : 8;
            int i4 = x.isNotNull(communityActivityItemVo.getMinute()) ? 0 : 8;
            int i5 = x.isNotNull(communityActivityItemVo.getSecond()) ? 0 : 8;
            this.mDayTv.setVisibility(i2);
            this.mDayTitleTv.setVisibility(i2);
            this.mDayTv.setText(c(communityActivityItemVo.getDay()));
            this.mHourTv.setVisibility(i3);
            this.mSplitTv.setVisibility(i3);
            this.mHourTv.setText(c(communityActivityItemVo.getHour()));
            this.mMinTv.setVisibility(i4);
            this.mSplitEndTv.setVisibility(i4);
            this.mMinTv.setText(c(communityActivityItemVo.getMinute()));
            this.mSecondTv.setVisibility(i5);
            this.mSecondTv.setText(c(communityActivityItemVo.getSecond()));
        }
    }

    public class CommunityActivityVh_ViewBinding implements Unbinder {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public CommunityActivityVh f7036b;

        @UiThread
        public CommunityActivityVh_ViewBinding(CommunityActivityVh communityActivityVh, View view) {
            this.f7036b = communityActivityVh;
            communityActivityVh.mActivityCoverImg = (CoreRoundedImageView) d.findRequiredViewAsType(view, R.id.img_activity_cover, "field 'mActivityCoverImg'", CoreRoundedImageView.class);
            communityActivityVh.mActivityTimerTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_activity_timer, "field 'mActivityTimerTv'", TextView.class);
            communityActivityVh.mActivityLabTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_activity_lab, "field 'mActivityLabTv'", TextView.class);
            communityActivityVh.mActivityTitleTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_activity_title, "field 'mActivityTitleTv'", TextView.class);
            communityActivityVh.mActivityTimeTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_activity_time, "field 'mActivityTimeTv'", TextView.class);
            communityActivityVh.mActivityPublisherTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_activity_publisher, "field 'mActivityPublisherTv'", TextView.class);
            communityActivityVh.mActivityJoinNumberTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_activity_join_number, "field 'mActivityJoinNumberTv'", TextView.class);
            communityActivityVh.mActivityLocationTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_activity_location, "field 'mActivityLocationTv'", TextView.class);
            communityActivityVh.mActivityDistanceTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_activity_distance, "field 'mActivityDistanceTv'", TextView.class);
            communityActivityVh.mActivityStateTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_activity_state, "field 'mActivityStateTv'", TextView.class);
            communityActivityVh.mViewBg = d.findRequiredView(view, R.id.view_bg, "field 'mViewBg'");
            communityActivityVh.mDayTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_activity_timer_day_value, "field 'mDayTv'", TextView.class);
            communityActivityVh.mDayTitleTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_activity_timer_day_title, "field 'mDayTitleTv'", TextView.class);
            communityActivityVh.mHourTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_activity_timer_hour_value, "field 'mHourTv'", TextView.class);
            communityActivityVh.mMinTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_activity_timer_min_value, "field 'mMinTv'", TextView.class);
            communityActivityVh.mSecondTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_activity_timer_second_value, "field 'mSecondTv'", TextView.class);
            communityActivityVh.mSplitTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_time_split, "field 'mSplitTv'", TextView.class);
            communityActivityVh.mSplitEndTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_time_split_end, "field 'mSplitEndTv'", TextView.class);
            communityActivityVh.mActivityJoinBtn = (AppCompatButton) d.findRequiredViewAsType(view, R.id.btn_activity_join, "field 'mActivityJoinBtn'", AppCompatButton.class);
        }

        @Override // butterknife.Unbinder
        @CallSuper
        public void unbind() {
            CommunityActivityVh communityActivityVh = this.f7036b;
            if (communityActivityVh == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.f7036b = null;
            communityActivityVh.mActivityCoverImg = null;
            communityActivityVh.mActivityTimerTv = null;
            communityActivityVh.mActivityLabTv = null;
            communityActivityVh.mActivityTitleTv = null;
            communityActivityVh.mActivityTimeTv = null;
            communityActivityVh.mActivityPublisherTv = null;
            communityActivityVh.mActivityJoinNumberTv = null;
            communityActivityVh.mActivityLocationTv = null;
            communityActivityVh.mActivityDistanceTv = null;
            communityActivityVh.mActivityStateTv = null;
            communityActivityVh.mViewBg = null;
            communityActivityVh.mDayTv = null;
            communityActivityVh.mDayTitleTv = null;
            communityActivityVh.mHourTv = null;
            communityActivityVh.mMinTv = null;
            communityActivityVh.mSecondTv = null;
            communityActivityVh.mSplitTv = null;
            communityActivityVh.mSplitEndTv = null;
            communityActivityVh.mActivityJoinBtn = null;
        }
    }

    public static class a extends SimpleRecyclerViewHolder<CommunityActivityItemVo> {
        public a(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }

        @Override // com.chinavisionary.core.app.adapter.SimpleRecyclerViewHolder
        public void setupData(CommunityActivityItemVo communityActivityItemVo) {
        }
    }

    @Override // com.chinavisionary.core.app.adapter.BaseRecyclerAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i2) {
        if (this.f6466h != null && i2 == 0) {
            return 26214;
        }
        q.d("CommunityActivityAdapter", "isShowFooterView isShowFooterView " + this.f6463e);
        if (this.f6463e && i2 == getItemCount() - 1) {
            q.d("CommunityActivityAdapter", "isShowFooterView FOOTER_TYPE");
            return 39321;
        }
        List<T> list = this.f6460b;
        return (list == 0 || list.isEmpty()) ? super.getItemViewType(i2) : ((CommunityActivityItemVo) this.f6460b.get(i2)).getViewType();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i2) {
        if (122 == viewHolder.getItemViewType()) {
            ((CommunityActivityVh) viewHolder).g((CommunityActivityItemVo) this.f6460b.get(i2));
        }
        if (123 == viewHolder.getItemViewType()) {
            ((a) viewHolder).setupData((CommunityActivityItemVo) this.f6460b.get(i2));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i2) {
        if (122 == i2) {
            return q(viewGroup);
        }
        if (123 == i2) {
            return p(viewGroup);
        }
        if (39321 != i2) {
            return 34952 == i2 ? new BaseRecyclerAdapter.EmptyViewHolder(d(viewGroup)) : super.c(viewGroup, i2);
        }
        q.d("CommunityActivityAdapter", "FooterViewHolder");
        return new BaseRecyclerAdapter.FooterViewHolder(f(viewGroup));
    }

    public final a p(ViewGroup viewGroup) {
        return new a(i(viewGroup, R.layout.item_activity_end_split_line));
    }

    public final RecyclerView.ViewHolder q(ViewGroup viewGroup) {
        CommunityActivityVh communityActivityVh = new CommunityActivityVh(i(viewGroup, R.layout.item_community_activity_layout));
        communityActivityVh.setViewOnClickListener(this.f6461c);
        a(communityActivityVh);
        return communityActivityVh;
    }
}
