package com.chinavisionary.microtang.auth.fragment;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import b.c.b;
import b.c.d;
import butterknife.Unbinder;
import com.chinavisionary.core.weight.BaseSwipeRefreshLayout;
import com.chinavisionary.microtang.R;

/* JADX INFO: loaded from: classes.dex */
public class MeAuthDetailsFragment_ViewBinding implements Unbinder {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public MeAuthDetailsFragment f6828b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f6829c;

    public class a extends b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ MeAuthDetailsFragment f6830c;

        public a(MeAuthDetailsFragment meAuthDetailsFragment) {
            this.f6830c = meAuthDetailsFragment;
        }

        @Override // b.c.b
        public void doClick(View view) {
            this.f6830c.clickBack();
        }
    }

    @UiThread
    public MeAuthDetailsFragment_ViewBinding(MeAuthDetailsFragment meAuthDetailsFragment, View view) {
        this.f6828b = meAuthDetailsFragment;
        meAuthDetailsFragment.mTitleTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_title, "field 'mTitleTv'", TextView.class);
        meAuthDetailsFragment.mAgreeBtn = (Button) d.findRequiredViewAsType(view, R.id.btn_agree, "field 'mAgreeBtn'", Button.class);
        meAuthDetailsFragment.mRejectBtn = (Button) d.findRequiredViewAsType(view, R.id.btn_reject, "field 'mRejectBtn'", Button.class);
        meAuthDetailsFragment.mStateTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_state, "field 'mStateTv'", TextView.class);
        meAuthDetailsFragment.mBaseSwipeRefreshLayout = (BaseSwipeRefreshLayout) d.findRequiredViewAsType(view, R.id.swipe_refresh_layout, "field 'mBaseSwipeRefreshLayout'", BaseSwipeRefreshLayout.class);
        View viewFindRequiredView = d.findRequiredView(view, R.id.tv_back, "method 'clickBack'");
        this.f6829c = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(meAuthDetailsFragment));
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        MeAuthDetailsFragment meAuthDetailsFragment = this.f6828b;
        if (meAuthDetailsFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f6828b = null;
        meAuthDetailsFragment.mTitleTv = null;
        meAuthDetailsFragment.mAgreeBtn = null;
        meAuthDetailsFragment.mRejectBtn = null;
        meAuthDetailsFragment.mStateTv = null;
        meAuthDetailsFragment.mBaseSwipeRefreshLayout = null;
        this.f6829c.setOnClickListener(null);
        this.f6829c = null;
    }
}
