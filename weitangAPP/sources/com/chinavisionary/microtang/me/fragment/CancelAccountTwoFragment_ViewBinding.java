package com.chinavisionary.microtang.me.fragment;

import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import b.c.b;
import b.c.d;
import butterknife.Unbinder;
import com.chinavisionary.core.weight.BaseSwipeRefreshLayout;
import com.chinavisionary.microtang.R;

/* JADX INFO: loaded from: classes.dex */
public class CancelAccountTwoFragment_ViewBinding implements Unbinder {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public CancelAccountTwoFragment f7598b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f7599c;

    public class a extends b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ CancelAccountTwoFragment f7600c;

        public a(CancelAccountTwoFragment cancelAccountTwoFragment) {
            this.f7600c = cancelAccountTwoFragment;
        }

        @Override // b.c.b
        public void doClick(View view) {
            this.f7600c.clickBack();
        }
    }

    @UiThread
    public CancelAccountTwoFragment_ViewBinding(CancelAccountTwoFragment cancelAccountTwoFragment, View view) {
        this.f7598b = cancelAccountTwoFragment;
        cancelAccountTwoFragment.mTitleTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_title, "field 'mTitleTv'", TextView.class);
        cancelAccountTwoFragment.mBaseSwipeRefreshLayout = (BaseSwipeRefreshLayout) d.findRequiredViewAsType(view, R.id.swipe_refresh_layout, "field 'mBaseSwipeRefreshLayout'", BaseSwipeRefreshLayout.class);
        cancelAccountTwoFragment.mSubmitBtn = (Button) d.findRequiredViewAsType(view, R.id.btn_submit, "field 'mSubmitBtn'", Button.class);
        cancelAccountTwoFragment.mCheckBox = (CheckBox) d.findRequiredViewAsType(view, R.id.cb_reason, "field 'mCheckBox'", CheckBox.class);
        cancelAccountTwoFragment.mReasonTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_reason, "field 'mReasonTv'", TextView.class);
        View viewFindRequiredView = d.findRequiredView(view, R.id.tv_back, "method 'clickBack'");
        this.f7599c = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(cancelAccountTwoFragment));
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        CancelAccountTwoFragment cancelAccountTwoFragment = this.f7598b;
        if (cancelAccountTwoFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f7598b = null;
        cancelAccountTwoFragment.mTitleTv = null;
        cancelAccountTwoFragment.mBaseSwipeRefreshLayout = null;
        cancelAccountTwoFragment.mSubmitBtn = null;
        cancelAccountTwoFragment.mCheckBox = null;
        cancelAccountTwoFragment.mReasonTv = null;
        this.f7599c.setOnClickListener(null);
        this.f7599c = null;
    }
}
