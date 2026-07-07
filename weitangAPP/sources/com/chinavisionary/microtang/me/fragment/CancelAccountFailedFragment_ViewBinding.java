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
public class CancelAccountFailedFragment_ViewBinding implements Unbinder {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public CancelAccountFailedFragment f7576b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f7577c;

    public class a extends b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ CancelAccountFailedFragment f7578c;

        public a(CancelAccountFailedFragment cancelAccountFailedFragment) {
            this.f7578c = cancelAccountFailedFragment;
        }

        @Override // b.c.b
        public void doClick(View view) {
            this.f7578c.clickBack();
        }
    }

    @UiThread
    public CancelAccountFailedFragment_ViewBinding(CancelAccountFailedFragment cancelAccountFailedFragment, View view) {
        this.f7576b = cancelAccountFailedFragment;
        cancelAccountFailedFragment.mTitleTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_title, "field 'mTitleTv'", TextView.class);
        cancelAccountFailedFragment.mBaseSwipeRefreshLayout = (BaseSwipeRefreshLayout) d.findRequiredViewAsType(view, R.id.swipe_refresh_layout, "field 'mBaseSwipeRefreshLayout'", BaseSwipeRefreshLayout.class);
        cancelAccountFailedFragment.mSubmitBtn = (Button) d.findRequiredViewAsType(view, R.id.btn_submit, "field 'mSubmitBtn'", Button.class);
        cancelAccountFailedFragment.mThinkBtn = (Button) d.findRequiredViewAsType(view, R.id.btn_think, "field 'mThinkBtn'", Button.class);
        cancelAccountFailedFragment.mCancelPhoneTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_cancel_account, "field 'mCancelPhoneTv'", TextView.class);
        cancelAccountFailedFragment.mTipImg = (ImageView) d.findRequiredViewAsType(view, R.id.img_tip_icon, "field 'mTipImg'", ImageView.class);
        cancelAccountFailedFragment.mBgView = d.findRequiredView(view, R.id.view_bottom_bg, "field 'mBgView'");
        View viewFindRequiredView = d.findRequiredView(view, R.id.tv_back, "method 'clickBack'");
        this.f7577c = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(cancelAccountFailedFragment));
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        CancelAccountFailedFragment cancelAccountFailedFragment = this.f7576b;
        if (cancelAccountFailedFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f7576b = null;
        cancelAccountFailedFragment.mTitleTv = null;
        cancelAccountFailedFragment.mBaseSwipeRefreshLayout = null;
        cancelAccountFailedFragment.mSubmitBtn = null;
        cancelAccountFailedFragment.mThinkBtn = null;
        cancelAccountFailedFragment.mCancelPhoneTv = null;
        cancelAccountFailedFragment.mTipImg = null;
        cancelAccountFailedFragment.mBgView = null;
        this.f7577c.setOnClickListener(null);
        this.f7577c = null;
    }
}
