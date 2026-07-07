package com.chinavisionary.microtang.recommend;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import b.c.b;
import b.c.d;
import butterknife.Unbinder;
import com.chinavisionary.core.weight.BaseSwipeRefreshLayout;
import com.chinavisionary.microtang.R;

/* JADX INFO: loaded from: classes2.dex */
public class RecommendFragment_ViewBinding implements Unbinder {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public RecommendFragment f8211b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f8212c;

    public class a extends b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ RecommendFragment f8213c;

        public a(RecommendFragment recommendFragment) {
            this.f8213c = recommendFragment;
        }

        @Override // b.c.b
        public void doClick(View view) {
            this.f8213c.onBackClick();
        }
    }

    @UiThread
    public RecommendFragment_ViewBinding(RecommendFragment recommendFragment, View view) {
        this.f8211b = recommendFragment;
        recommendFragment.mTitleTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_title, "field 'mTitleTv'", TextView.class);
        recommendFragment.mBaseSwipeRefreshLayout = (BaseSwipeRefreshLayout) d.findRequiredViewAsType(view, R.id.swipe_refresh_layout, "field 'mBaseSwipeRefreshLayout'", BaseSwipeRefreshLayout.class);
        View viewFindRequiredView = d.findRequiredView(view, R.id.tv_back, "method 'onBackClick'");
        this.f8212c = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(recommendFragment));
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        RecommendFragment recommendFragment = this.f8211b;
        if (recommendFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f8211b = null;
        recommendFragment.mTitleTv = null;
        recommendFragment.mBaseSwipeRefreshLayout = null;
        this.f8212c.setOnClickListener(null);
        this.f8212c = null;
    }
}
