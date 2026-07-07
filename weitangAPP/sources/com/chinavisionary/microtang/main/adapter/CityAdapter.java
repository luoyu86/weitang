package com.chinavisionary.microtang.main.adapter;

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
import com.chinavisionary.core.app.adapter.BaseRecyclerAdapter;
import com.chinavisionary.core.app.adapter.BaseRecyclerViewHolder;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.main.vo.CityItemVo;

/* JADX INFO: loaded from: classes.dex */
public class CityAdapter extends BaseRecyclerAdapter<CityItemVo> {

    public static class ProjectItemVh extends BaseRecyclerViewHolder<CityItemVo> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f7344f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final int f7345g;

        @BindView(R.id.tv_city)
        public TextView mCityNameTv;

        public ProjectItemVh(View view) {
            super(view);
            ButterKnife.bind(this, view);
            this.f7344f = view.getResources().getColor(R.color.color_333333);
            this.f7345g = view.getResources().getColor(R.color.color555555);
        }

        public void g(CityItemVo cityItemVo) {
            this.mCityNameTv.setText(c(cityItemVo.getCityName()));
            this.mCityNameTv.setBackgroundResource(cityItemVo.isSelect() ? R.drawable.bg_city_select : R.drawable.bg_city_normal);
            this.mCityNameTv.setTextColor(cityItemVo.isSelect() ? this.f7344f : this.f7345g);
        }
    }

    public class ProjectItemVh_ViewBinding implements Unbinder {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public ProjectItemVh f7346b;

        @UiThread
        public ProjectItemVh_ViewBinding(ProjectItemVh projectItemVh, View view) {
            this.f7346b = projectItemVh;
            projectItemVh.mCityNameTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_city, "field 'mCityNameTv'", TextView.class);
        }

        @Override // butterknife.Unbinder
        @CallSuper
        public void unbind() {
            ProjectItemVh projectItemVh = this.f7346b;
            if (projectItemVh == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.f7346b = null;
            projectItemVh.mCityNameTv = null;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i2) {
        ((ProjectItemVh) viewHolder).g((CityItemVo) this.f6460b.get(i2));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i2) {
        return p(viewGroup);
    }

    public final ProjectItemVh p(ViewGroup viewGroup) {
        ProjectItemVh projectItemVh = new ProjectItemVh(i(viewGroup, R.layout.item_city_layout));
        a(projectItemVh);
        return projectItemVh;
    }
}
