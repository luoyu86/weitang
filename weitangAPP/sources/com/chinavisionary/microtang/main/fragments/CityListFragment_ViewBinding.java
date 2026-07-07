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
public class CityListFragment_ViewBinding implements Unbinder {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public CityListFragment f7413b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f7414c;

    public class a extends b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ CityListFragment f7415c;

        public a(CityListFragment cityListFragment) {
            this.f7415c = cityListFragment;
        }

        @Override // b.c.b
        public void doClick(View view) {
            this.f7415c.backClick();
        }
    }

    @UiThread
    public CityListFragment_ViewBinding(CityListFragment cityListFragment, View view) {
        this.f7413b = cityListFragment;
        cityListFragment.mCurrentLocationTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_current_location_value, "field 'mCurrentLocationTv'", TextView.class);
        cityListFragment.mSwipeRefreshLayout = (BaseSwipeRefreshLayout) d.findRequiredViewAsType(view, R.id.swipe_refresh_layout_project, "field 'mSwipeRefreshLayout'", BaseSwipeRefreshLayout.class);
        View viewFindRequiredView = d.findRequiredView(view, R.id.img_back, "method 'backClick'");
        this.f7414c = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(cityListFragment));
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        CityListFragment cityListFragment = this.f7413b;
        if (cityListFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f7413b = null;
        cityListFragment.mCurrentLocationTv = null;
        cityListFragment.mSwipeRefreshLayout = null;
        this.f7414c.setOnClickListener(null);
        this.f7414c = null;
    }
}
