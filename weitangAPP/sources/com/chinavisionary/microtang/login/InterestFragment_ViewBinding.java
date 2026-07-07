package com.chinavisionary.microtang.login;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import b.c.d;
import butterknife.Unbinder;
import com.chinavisionary.core.weight.BaseSwipeRefreshLayout;
import com.chinavisionary.microtang.R;

/* JADX INFO: loaded from: classes.dex */
public class InterestFragment_ViewBinding implements Unbinder {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public InterestFragment f7289b;

    @UiThread
    public InterestFragment_ViewBinding(InterestFragment interestFragment, View view) {
        this.f7289b = interestFragment;
        interestFragment.mBackImg = (ImageView) d.findRequiredViewAsType(view, R.id.img_back, "field 'mBackImg'", ImageView.class);
        interestFragment.mTitleTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_title, "field 'mTitleTv'", TextView.class);
        interestFragment.mRightTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_title_right, "field 'mRightTv'", TextView.class);
        interestFragment.mLineTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_title_split_line, "field 'mLineTv'", TextView.class);
        interestFragment.mConfirmCb = (CheckBox) d.findRequiredViewAsType(view, R.id.cb_confirm, "field 'mConfirmCb'", CheckBox.class);
        interestFragment.mBaseSwipeRefreshLayout = (BaseSwipeRefreshLayout) d.findRequiredViewAsType(view, R.id.swipe_refresh_layout, "field 'mBaseSwipeRefreshLayout'", BaseSwipeRefreshLayout.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        InterestFragment interestFragment = this.f7289b;
        if (interestFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f7289b = null;
        interestFragment.mBackImg = null;
        interestFragment.mTitleTv = null;
        interestFragment.mRightTv = null;
        interestFragment.mLineTv = null;
        interestFragment.mConfirmCb = null;
        interestFragment.mBaseSwipeRefreshLayout = null;
    }
}
