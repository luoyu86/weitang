package com.chinavisionary.microtang.main.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import b.c.d;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.chinavisionary.core.app.adapter.BaseRecyclerAdapter;
import com.chinavisionary.core.app.adapter.BaseRecyclerViewHolder;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.repair.vo.RepairLeftVo;

/* JADX INFO: loaded from: classes.dex */
public class ProjectAdapter extends BaseRecyclerAdapter<RepairLeftVo> {

    public static class ProjectItemVh extends BaseRecyclerViewHolder<RepairLeftVo> {

        @BindView(R.id.tv_community_details)
        public TextView mCommunityDetailsTv;

        @BindView(R.id.view_split_line)
        public View mLineView;

        @BindView(R.id.card_view_mask)
        public View mMaskView;

        @BindView(R.id.img_project_select)
        public ImageView mProjectImg;

        @BindView(R.id.tv_project_name)
        public TextView mProjectNameTv;

        public ProjectItemVh(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }

        public void g(RepairLeftVo repairLeftVo) {
            f(this.mCommunityDetailsTv, this.f6469b);
            this.mCommunityDetailsTv.setTag(Integer.valueOf(getAdapterPosition()));
            this.mProjectNameTv.setText(c(repairLeftVo.getTitle()));
        }
    }

    public class ProjectItemVh_ViewBinding implements Unbinder {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public ProjectItemVh f7366b;

        @UiThread
        public ProjectItemVh_ViewBinding(ProjectItemVh projectItemVh, View view) {
            this.f7366b = projectItemVh;
            projectItemVh.mProjectNameTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_project_name, "field 'mProjectNameTv'", TextView.class);
            projectItemVh.mProjectImg = (ImageView) d.findRequiredViewAsType(view, R.id.img_project_select, "field 'mProjectImg'", ImageView.class);
            projectItemVh.mCommunityDetailsTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_community_details, "field 'mCommunityDetailsTv'", TextView.class);
            projectItemVh.mMaskView = d.findRequiredView(view, R.id.card_view_mask, "field 'mMaskView'");
            projectItemVh.mLineView = d.findRequiredView(view, R.id.view_split_line, "field 'mLineView'");
        }

        @Override // butterknife.Unbinder
        @CallSuper
        public void unbind() {
            ProjectItemVh projectItemVh = this.f7366b;
            if (projectItemVh == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.f7366b = null;
            projectItemVh.mProjectNameTv = null;
            projectItemVh.mProjectImg = null;
            projectItemVh.mCommunityDetailsTv = null;
            projectItemVh.mMaskView = null;
            projectItemVh.mLineView = null;
        }
    }

    public static class ProjectTitleItemVh extends BaseRecyclerViewHolder<RepairLeftVo> {

        @BindView(R.id.tv_city)
        public TextView mCityNameTv;

        public ProjectTitleItemVh(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    public class ProjectTitleItemVh_ViewBinding implements Unbinder {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public ProjectTitleItemVh f7367b;

        @UiThread
        public ProjectTitleItemVh_ViewBinding(ProjectTitleItemVh projectTitleItemVh, View view) {
            this.f7367b = projectTitleItemVh;
            projectTitleItemVh.mCityNameTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_city, "field 'mCityNameTv'", TextView.class);
        }

        @Override // butterknife.Unbinder
        @CallSuper
        public void unbind() {
            ProjectTitleItemVh projectTitleItemVh = this.f7367b;
            if (projectTitleItemVh == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.f7367b = null;
            projectTitleItemVh.mCityNameTv = null;
        }
    }

    @Override // com.chinavisionary.core.app.adapter.BaseRecyclerAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i2) {
        return ((RepairLeftVo) this.f6460b.get(i2 - h())).getType();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i2) {
        if (viewHolder.getItemViewType() == 3) {
            ((ProjectItemVh) viewHolder).g((RepairLeftVo) this.f6460b.get(i2));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i2) {
        return i2 == 34952 ? new BaseRecyclerAdapter.EmptyViewHolder(d(viewGroup)) : i2 == 2 ? new ProjectTitleItemVh(i(viewGroup, R.layout.item_project_title_layout)) : p(viewGroup);
    }

    public final ProjectItemVh p(ViewGroup viewGroup) {
        ProjectItemVh projectItemVh = new ProjectItemVh(i(viewGroup, R.layout.item_project_layout));
        projectItemVh.setViewOnClickListener(this.f6461c);
        a(projectItemVh);
        return projectItemVh;
    }
}
