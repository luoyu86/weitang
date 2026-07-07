package com.chinavisionary.microtang.subscribe;

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
public class SubscribeLookFragment_ViewBinding implements Unbinder {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public SubscribeLookFragment f8617b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f8618c;

    public class a extends b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ SubscribeLookFragment f8619c;

        public a(SubscribeLookFragment subscribeLookFragment) {
            this.f8619c = subscribeLookFragment;
        }

        @Override // b.c.b
        public void doClick(View view) {
            this.f8619c.backClick(view);
        }
    }

    @UiThread
    public SubscribeLookFragment_ViewBinding(SubscribeLookFragment subscribeLookFragment, View view) {
        this.f8617b = subscribeLookFragment;
        subscribeLookFragment.mTitleTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_title, "field 'mTitleTv'", TextView.class);
        subscribeLookFragment.mSubscribeLookRefreshLayout = (BaseSwipeRefreshLayout) d.findRequiredViewAsType(view, R.id.swipe_refresh_layout_subscribe, "field 'mSubscribeLookRefreshLayout'", BaseSwipeRefreshLayout.class);
        View viewFindRequiredView = d.findRequiredView(view, R.id.tv_back, "method 'backClick'");
        this.f8618c = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(subscribeLookFragment));
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        SubscribeLookFragment subscribeLookFragment = this.f8617b;
        if (subscribeLookFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f8617b = null;
        subscribeLookFragment.mTitleTv = null;
        subscribeLookFragment.mSubscribeLookRefreshLayout = null;
        this.f8618c.setOnClickListener(null);
        this.f8618c = null;
    }
}
