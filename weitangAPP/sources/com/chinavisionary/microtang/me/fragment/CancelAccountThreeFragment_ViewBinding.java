package com.chinavisionary.microtang.me.fragment;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import b.c.b;
import b.c.d;
import butterknife.Unbinder;
import com.chinavisionary.core.weight.BaseSwipeRefreshLayout;
import com.chinavisionary.microtang.R;

/* JADX INFO: loaded from: classes.dex */
public class CancelAccountThreeFragment_ViewBinding implements Unbinder {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public CancelAccountThreeFragment f7592b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f7593c;

    public class a extends b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ CancelAccountThreeFragment f7594c;

        public a(CancelAccountThreeFragment cancelAccountThreeFragment) {
            this.f7594c = cancelAccountThreeFragment;
        }

        @Override // b.c.b
        public void doClick(View view) {
            this.f7594c.clickBack();
        }
    }

    @UiThread
    public CancelAccountThreeFragment_ViewBinding(CancelAccountThreeFragment cancelAccountThreeFragment, View view) {
        this.f7592b = cancelAccountThreeFragment;
        cancelAccountThreeFragment.mTitleTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_title, "field 'mTitleTv'", TextView.class);
        cancelAccountThreeFragment.mBaseSwipeRefreshLayout = (BaseSwipeRefreshLayout) d.findRequiredViewAsType(view, R.id.swipe_refresh_layout, "field 'mBaseSwipeRefreshLayout'", BaseSwipeRefreshLayout.class);
        cancelAccountThreeFragment.mSubmitBtn = (Button) d.findRequiredViewAsType(view, R.id.btn_submit, "field 'mSubmitBtn'", Button.class);
        cancelAccountThreeFragment.mThinkBtn = (Button) d.findRequiredViewAsType(view, R.id.btn_think, "field 'mThinkBtn'", Button.class);
        cancelAccountThreeFragment.mCancelPhoneTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_cancel_account, "field 'mCancelPhoneTv'", TextView.class);
        cancelAccountThreeFragment.mTipImg = (ImageView) d.findRequiredViewAsType(view, R.id.img_tip_icon, "field 'mTipImg'", ImageView.class);
        View viewFindRequiredView = d.findRequiredView(view, R.id.tv_back, "method 'clickBack'");
        this.f7593c = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(cancelAccountThreeFragment));
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        CancelAccountThreeFragment cancelAccountThreeFragment = this.f7592b;
        if (cancelAccountThreeFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f7592b = null;
        cancelAccountThreeFragment.mTitleTv = null;
        cancelAccountThreeFragment.mBaseSwipeRefreshLayout = null;
        cancelAccountThreeFragment.mSubmitBtn = null;
        cancelAccountThreeFragment.mThinkBtn = null;
        cancelAccountThreeFragment.mCancelPhoneTv = null;
        cancelAccountThreeFragment.mTipImg = null;
        this.f7593c.setOnClickListener(null);
        this.f7593c = null;
    }
}
