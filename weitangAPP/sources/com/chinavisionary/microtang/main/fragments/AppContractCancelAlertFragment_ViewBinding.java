package com.chinavisionary.microtang.main.fragments;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.constraintlayout.widget.ConstraintLayout;
import butterknife.Unbinder;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.sign.view.AlertBaseWebView;

/* JADX INFO: loaded from: classes.dex */
public class AppContractCancelAlertFragment_ViewBinding implements Unbinder {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public AppContractCancelAlertFragment f7399b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f7400c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public View f7401d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public View f7402e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public View f7403f;

    public class a extends b.c.b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ AppContractCancelAlertFragment f7404c;

        public a(AppContractCancelAlertFragment appContractCancelAlertFragment) {
            this.f7404c = appContractCancelAlertFragment;
        }

        @Override // b.c.b
        public void doClick(View view) {
            this.f7404c.notThinkView(view);
        }
    }

    public class b extends b.c.b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ AppContractCancelAlertFragment f7406c;

        public b(AppContractCancelAlertFragment appContractCancelAlertFragment) {
            this.f7406c = appContractCancelAlertFragment;
        }

        @Override // b.c.b
        public void doClick(View view) {
            this.f7406c.thinkView(view);
        }
    }

    public class c extends b.c.b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ AppContractCancelAlertFragment f7408c;

        public c(AppContractCancelAlertFragment appContractCancelAlertFragment) {
            this.f7408c = appContractCancelAlertFragment;
        }

        @Override // b.c.b
        public void doClick(View view) {
            this.f7408c.centerClickView(view);
        }
    }

    public class d extends b.c.b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ AppContractCancelAlertFragment f7410c;

        public d(AppContractCancelAlertFragment appContractCancelAlertFragment) {
            this.f7410c = appContractCancelAlertFragment;
        }

        @Override // b.c.b
        public void doClick(View view) {
            this.f7410c.clickView(view);
        }
    }

    @UiThread
    public AppContractCancelAlertFragment_ViewBinding(AppContractCancelAlertFragment appContractCancelAlertFragment, View view) {
        this.f7399b = appContractCancelAlertFragment;
        appContractCancelAlertFragment.mTitleTv = (TextView) b.c.d.findRequiredViewAsType(view, R.id.tv_alert_title, "field 'mTitleTv'", TextView.class);
        appContractCancelAlertFragment.mContentTv = (TextView) b.c.d.findRequiredViewAsType(view, R.id.tv_alert_content, "field 'mContentTv'", TextView.class);
        appContractCancelAlertFragment.mCancelBtn = (Button) b.c.d.findRequiredViewAsType(view, R.id.btn_alert_cancel, "field 'mCancelBtn'", Button.class);
        appContractCancelAlertFragment.mConfirmBtn = (Button) b.c.d.findRequiredViewAsType(view, R.id.btn_alert_confirm, "field 'mConfirmBtn'", Button.class);
        appContractCancelAlertFragment.mCenterBtn = (Button) b.c.d.findRequiredViewAsType(view, R.id.btn_alert_center, "field 'mCenterBtn'", Button.class);
        appContractCancelAlertFragment.mAlertLayout = (ConstraintLayout) b.c.d.findRequiredViewAsType(view, R.id.constraint_layout_alert, "field 'mAlertLayout'", ConstraintLayout.class);
        appContractCancelAlertFragment.mBaseWebView = (AlertBaseWebView) b.c.d.findRequiredViewAsType(view, R.id.web_view_content, "field 'mBaseWebView'", AlertBaseWebView.class);
        appContractCancelAlertFragment.mRentAlertLayout = (ConstraintLayout) b.c.d.findRequiredViewAsType(view, R.id.constraint_layout_rent_alert, "field 'mRentAlertLayout'", ConstraintLayout.class);
        appContractCancelAlertFragment.mRentAlertTitleTv = (TextView) b.c.d.findRequiredViewAsType(view, R.id.tv_title, "field 'mRentAlertTitleTv'", TextView.class);
        appContractCancelAlertFragment.mRentAlertContentTv = (TextView) b.c.d.findRequiredViewAsType(view, R.id.tv_content, "field 'mRentAlertContentTv'", TextView.class);
        View viewFindRequiredView = b.c.d.findRequiredView(view, R.id.btn_not_think, "field 'mRentNotThinkBtn' and method 'notThinkView'");
        appContractCancelAlertFragment.mRentNotThinkBtn = (Button) b.c.d.castView(viewFindRequiredView, R.id.btn_not_think, "field 'mRentNotThinkBtn'", Button.class);
        this.f7400c = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(appContractCancelAlertFragment));
        View viewFindRequiredView2 = b.c.d.findRequiredView(view, R.id.btn_think, "field 'mRentThinkBtn' and method 'thinkView'");
        appContractCancelAlertFragment.mRentThinkBtn = (Button) b.c.d.castView(viewFindRequiredView2, R.id.btn_think, "field 'mRentThinkBtn'", Button.class);
        this.f7401d = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(appContractCancelAlertFragment));
        View viewFindRequiredView3 = b.c.d.findRequiredView(view, R.id.btn_confirm_renewal, "field 'mRentConfirmRenewalBtn' and method 'centerClickView'");
        appContractCancelAlertFragment.mRentConfirmRenewalBtn = (Button) b.c.d.castView(viewFindRequiredView3, R.id.btn_confirm_renewal, "field 'mRentConfirmRenewalBtn'", Button.class);
        this.f7402e = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new c(appContractCancelAlertFragment));
        View viewFindRequiredView4 = b.c.d.findRequiredView(view, R.id.view_bg, "method 'clickView'");
        this.f7403f = viewFindRequiredView4;
        viewFindRequiredView4.setOnClickListener(new d(appContractCancelAlertFragment));
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        AppContractCancelAlertFragment appContractCancelAlertFragment = this.f7399b;
        if (appContractCancelAlertFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f7399b = null;
        appContractCancelAlertFragment.mTitleTv = null;
        appContractCancelAlertFragment.mContentTv = null;
        appContractCancelAlertFragment.mCancelBtn = null;
        appContractCancelAlertFragment.mConfirmBtn = null;
        appContractCancelAlertFragment.mCenterBtn = null;
        appContractCancelAlertFragment.mAlertLayout = null;
        appContractCancelAlertFragment.mBaseWebView = null;
        appContractCancelAlertFragment.mRentAlertLayout = null;
        appContractCancelAlertFragment.mRentAlertTitleTv = null;
        appContractCancelAlertFragment.mRentAlertContentTv = null;
        appContractCancelAlertFragment.mRentNotThinkBtn = null;
        appContractCancelAlertFragment.mRentThinkBtn = null;
        appContractCancelAlertFragment.mRentConfirmRenewalBtn = null;
        this.f7400c.setOnClickListener(null);
        this.f7400c = null;
        this.f7401d.setOnClickListener(null);
        this.f7401d = null;
        this.f7402e.setOnClickListener(null);
        this.f7402e = null;
        this.f7403f.setOnClickListener(null);
        this.f7403f = null;
    }
}
