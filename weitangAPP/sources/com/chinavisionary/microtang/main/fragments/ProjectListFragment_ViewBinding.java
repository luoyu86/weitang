package com.chinavisionary.microtang.main.fragments;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import b.c.b;
import b.c.d;
import butterknife.Unbinder;
import com.chinavisionary.core.weight.BaseSwipeRefreshLayout;
import com.chinavisionary.microtang.R;

/* JADX INFO: loaded from: classes.dex */
public class ProjectListFragment_ViewBinding implements Unbinder {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ProjectListFragment f7441b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f7442c;

    public class a extends b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ ProjectListFragment f7443c;

        public a(ProjectListFragment projectListFragment) {
            this.f7443c = projectListFragment;
        }

        @Override // b.c.b
        public void doClick(View view) {
            this.f7443c.backClick();
        }
    }

    @UiThread
    public ProjectListFragment_ViewBinding(ProjectListFragment projectListFragment, View view) {
        this.f7441b = projectListFragment;
        projectListFragment.mTitleBgView = d.findRequiredView(view, R.id.view_title_bg, "field 'mTitleBgView'");
        projectListFragment.mTitleTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_title, "field 'mTitleTv'", TextView.class);
        projectListFragment.mSelectProjectNameTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_select_project_name, "field 'mSelectProjectNameTv'", TextView.class);
        projectListFragment.mSwipeRefreshLayout = (BaseSwipeRefreshLayout) d.findRequiredViewAsType(view, R.id.swipe_refresh_layout_project, "field 'mSwipeRefreshLayout'", BaseSwipeRefreshLayout.class);
        projectListFragment.mCitySwipeRefreshLayout = (BaseSwipeRefreshLayout) d.findRequiredViewAsType(view, R.id.swipe_refresh_layout_city, "field 'mCitySwipeRefreshLayout'", BaseSwipeRefreshLayout.class);
        View viewFindRequiredView = d.findRequiredView(view, R.id.tv_back, "method 'backClick'");
        this.f7442c = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(projectListFragment));
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        ProjectListFragment projectListFragment = this.f7441b;
        if (projectListFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f7441b = null;
        projectListFragment.mTitleBgView = null;
        projectListFragment.mTitleTv = null;
        projectListFragment.mSelectProjectNameTv = null;
        projectListFragment.mSwipeRefreshLayout = null;
        projectListFragment.mCitySwipeRefreshLayout = null;
        this.f7442c.setOnClickListener(null);
        this.f7442c = null;
    }
}
