package com.chinavisionary.microtang.web.bridge;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import b.c.d;
import butterknife.Unbinder;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.sign.view.NestedScrollWebView;

/* JADX INFO: loaded from: classes2.dex */
public class BridgeWebFragment_ViewBinding implements Unbinder {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public BridgeWebFragment f8712b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f8713c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public View f8714d;

    public class a extends b.c.b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ BridgeWebFragment f8715c;

        public a(BridgeWebFragment bridgeWebFragment) {
            this.f8715c = bridgeWebFragment;
        }

        @Override // b.c.b
        public void doClick(View view) {
            this.f8715c.refreshClick();
        }
    }

    public class b extends b.c.b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ BridgeWebFragment f8717c;

        public b(BridgeWebFragment bridgeWebFragment) {
            this.f8717c = bridgeWebFragment;
        }

        @Override // b.c.b
        public void doClick(View view) {
            this.f8717c.backClick();
        }
    }

    @UiThread
    public BridgeWebFragment_ViewBinding(BridgeWebFragment bridgeWebFragment, View view) {
        this.f8712b = bridgeWebFragment;
        bridgeWebFragment.mWebView = (NestedScrollWebView) d.findRequiredViewAsType(view, R.id.web_view, "field 'mWebView'", NestedScrollWebView.class);
        bridgeWebFragment.mTitleTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_title, "field 'mTitleTv'", TextView.class);
        bridgeWebFragment.mBgView = d.findRequiredView(view, R.id.view_bg, "field 'mBgView'");
        bridgeWebFragment.mRightIv = (ImageView) d.findRequiredViewAsType(view, R.id.img_web_right, "field 'mRightIv'", ImageView.class);
        bridgeWebFragment.mBackImg = (ImageView) d.findRequiredViewAsType(view, R.id.img_back, "field 'mBackImg'", ImageView.class);
        bridgeWebFragment.mTitleRightTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_title_right, "field 'mTitleRightTv'", TextView.class);
        bridgeWebFragment.mTitleSplitLineTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_title_split_line, "field 'mTitleSplitLineTv'", TextView.class);
        bridgeWebFragment.mPermissionInfoTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_permission_info, "field 'mPermissionInfoTv'", TextView.class);
        bridgeWebFragment.mProgressBar = (ProgressBar) d.findRequiredViewAsType(view, R.id.progress_bar, "field 'mProgressBar'", ProgressBar.class);
        bridgeWebFragment.mLinearLayout = (LinearLayout) d.findRequiredViewAsType(view, R.id.ll_err_tip, "field 'mLinearLayout'", LinearLayout.class);
        View viewFindRequiredView = d.findRequiredView(view, R.id.btn_reload_page, "method 'refreshClick'");
        this.f8713c = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(bridgeWebFragment));
        View viewFindRequiredView2 = d.findRequiredView(view, R.id.tv_back, "method 'backClick'");
        this.f8714d = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(bridgeWebFragment));
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        BridgeWebFragment bridgeWebFragment = this.f8712b;
        if (bridgeWebFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f8712b = null;
        bridgeWebFragment.mWebView = null;
        bridgeWebFragment.mTitleTv = null;
        bridgeWebFragment.mBgView = null;
        bridgeWebFragment.mRightIv = null;
        bridgeWebFragment.mBackImg = null;
        bridgeWebFragment.mTitleRightTv = null;
        bridgeWebFragment.mTitleSplitLineTv = null;
        bridgeWebFragment.mPermissionInfoTv = null;
        bridgeWebFragment.mProgressBar = null;
        bridgeWebFragment.mLinearLayout = null;
        this.f8713c.setOnClickListener(null);
        this.f8713c = null;
        this.f8714d.setOnClickListener(null);
        this.f8714d = null;
    }
}
