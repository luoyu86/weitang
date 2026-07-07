package com.chinavisionary.microtang.web;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import b.c.d;
import butterknife.Unbinder;
import com.chinavisionary.core.weight.BaseRecyclerView;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.sign.view.NestedScrollWebView;

/* JADX INFO: loaded from: classes2.dex */
public class WebFragment_ViewBinding implements Unbinder {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public WebFragment f8698b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f8699c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public View f8700d;

    public class a extends b.c.b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ WebFragment f8701c;

        public a(WebFragment webFragment) {
            this.f8701c = webFragment;
        }

        @Override // b.c.b
        public void doClick(View view) {
            this.f8701c.backClick();
        }
    }

    public class b extends b.c.b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ WebFragment f8703c;

        public b(WebFragment webFragment) {
            this.f8703c = webFragment;
        }

        @Override // b.c.b
        public void doClick(View view) {
            this.f8703c.refreshClick();
        }
    }

    @UiThread
    public WebFragment_ViewBinding(WebFragment webFragment, View view) {
        this.f8698b = webFragment;
        webFragment.mWebView = (NestedScrollWebView) d.findRequiredViewAsType(view, R.id.web_view, "field 'mWebView'", NestedScrollWebView.class);
        webFragment.mTitleTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_title, "field 'mTitleTv'", TextView.class);
        webFragment.mTitleRightTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_title_right, "field 'mTitleRightTv'", TextView.class);
        webFragment.mRightIv = (ImageView) d.findRequiredViewAsType(view, R.id.img_web_right, "field 'mRightIv'", ImageView.class);
        webFragment.mTitleSplitLineTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_title_split_line, "field 'mTitleSplitLineTv'", TextView.class);
        webFragment.mProgressBar = (ProgressBar) d.findRequiredViewAsType(view, R.id.progress_bar, "field 'mProgressBar'", ProgressBar.class);
        webFragment.mCommandRecyclerView = (BaseRecyclerView) d.findRequiredViewAsType(view, R.id.recycler_view_command, "field 'mCommandRecyclerView'", BaseRecyclerView.class);
        webFragment.mLinearLayout = (LinearLayout) d.findRequiredViewAsType(view, R.id.ll_err_tip, "field 'mLinearLayout'", LinearLayout.class);
        View viewFindRequiredView = d.findRequiredView(view, R.id.tv_back, "method 'backClick'");
        this.f8699c = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(webFragment));
        View viewFindRequiredView2 = d.findRequiredView(view, R.id.btn_reload_page, "method 'refreshClick'");
        this.f8700d = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(webFragment));
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        WebFragment webFragment = this.f8698b;
        if (webFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f8698b = null;
        webFragment.mWebView = null;
        webFragment.mTitleTv = null;
        webFragment.mTitleRightTv = null;
        webFragment.mRightIv = null;
        webFragment.mTitleSplitLineTv = null;
        webFragment.mProgressBar = null;
        webFragment.mCommandRecyclerView = null;
        webFragment.mLinearLayout = null;
        this.f8699c.setOnClickListener(null);
        this.f8699c = null;
        this.f8700d.setOnClickListener(null);
        this.f8700d = null;
    }
}
