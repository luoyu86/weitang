package com.chinavisionary.microtang.me.fragment;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import b.c.d;
import butterknife.Unbinder;
import com.chinavisionary.core.weight.BaseSwipeRefreshLayout;
import com.chinavisionary.microtang.R;

/* JADX INFO: loaded from: classes.dex */
public class CancelAccountSuccessFragment_ViewBinding implements Unbinder {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public CancelAccountSuccessFragment f7591b;

    @UiThread
    public CancelAccountSuccessFragment_ViewBinding(CancelAccountSuccessFragment cancelAccountSuccessFragment, View view) {
        this.f7591b = cancelAccountSuccessFragment;
        cancelAccountSuccessFragment.mTitleTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_title, "field 'mTitleTv'", TextView.class);
        cancelAccountSuccessFragment.mBackTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_back, "field 'mBackTv'", TextView.class);
        cancelAccountSuccessFragment.mBackImg = (ImageView) d.findRequiredViewAsType(view, R.id.img_back, "field 'mBackImg'", ImageView.class);
        cancelAccountSuccessFragment.mBaseSwipeRefreshLayout = (BaseSwipeRefreshLayout) d.findRequiredViewAsType(view, R.id.swipe_refresh_layout, "field 'mBaseSwipeRefreshLayout'", BaseSwipeRefreshLayout.class);
        cancelAccountSuccessFragment.mSubmitBtn = (Button) d.findRequiredViewAsType(view, R.id.btn_submit, "field 'mSubmitBtn'", Button.class);
        cancelAccountSuccessFragment.mThinkBtn = (Button) d.findRequiredViewAsType(view, R.id.btn_think, "field 'mThinkBtn'", Button.class);
        cancelAccountSuccessFragment.mCancelPhoneTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_cancel_account, "field 'mCancelPhoneTv'", TextView.class);
        cancelAccountSuccessFragment.mTipImg = (ImageView) d.findRequiredViewAsType(view, R.id.img_tip_icon, "field 'mTipImg'", ImageView.class);
        cancelAccountSuccessFragment.mTimerTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_cancel_account_timer, "field 'mTimerTv'", TextView.class);
        cancelAccountSuccessFragment.mBgView = d.findRequiredView(view, R.id.view_bottom_bg, "field 'mBgView'");
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        CancelAccountSuccessFragment cancelAccountSuccessFragment = this.f7591b;
        if (cancelAccountSuccessFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f7591b = null;
        cancelAccountSuccessFragment.mTitleTv = null;
        cancelAccountSuccessFragment.mBackTv = null;
        cancelAccountSuccessFragment.mBackImg = null;
        cancelAccountSuccessFragment.mBaseSwipeRefreshLayout = null;
        cancelAccountSuccessFragment.mSubmitBtn = null;
        cancelAccountSuccessFragment.mThinkBtn = null;
        cancelAccountSuccessFragment.mCancelPhoneTv = null;
        cancelAccountSuccessFragment.mTipImg = null;
        cancelAccountSuccessFragment.mTimerTv = null;
        cancelAccountSuccessFragment.mBgView = null;
    }
}
