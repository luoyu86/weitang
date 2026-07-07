package com.chinavisionary.microtang.main.fragments;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.constraintlayout.widget.ConstraintLayout;
import butterknife.Unbinder;
import com.chinavisionary.microtang.R;

/* JADX INFO: loaded from: classes.dex */
public class AppAlertFragment_ViewBinding implements Unbinder {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public AppAlertFragment f7373b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f7374c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public View f7375d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public View f7376e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public View f7377f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public View f7378g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public View f7379h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public View f7380i;

    public class a extends b.c.b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ AppAlertFragment f7381c;

        public a(AppAlertFragment appAlertFragment) {
            this.f7381c = appAlertFragment;
        }

        @Override // b.c.b
        public void doClick(View view) {
            this.f7381c.cancelView(view);
        }
    }

    public class b extends b.c.b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ AppAlertFragment f7383c;

        public b(AppAlertFragment appAlertFragment) {
            this.f7383c = appAlertFragment;
        }

        @Override // b.c.b
        public void doClick(View view) {
            this.f7383c.confirmView(view);
        }
    }

    public class c extends b.c.b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ AppAlertFragment f7385c;

        public c(AppAlertFragment appAlertFragment) {
            this.f7385c = appAlertFragment;
        }

        @Override // b.c.b
        public void doClick(View view) {
            this.f7385c.confirmView(view);
        }
    }

    public class d extends b.c.b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ AppAlertFragment f7387c;

        public d(AppAlertFragment appAlertFragment) {
            this.f7387c = appAlertFragment;
        }

        @Override // b.c.b
        public void doClick(View view) {
            this.f7387c.notThinkView(view);
        }
    }

    public class e extends b.c.b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ AppAlertFragment f7389c;

        public e(AppAlertFragment appAlertFragment) {
            this.f7389c = appAlertFragment;
        }

        @Override // b.c.b
        public void doClick(View view) {
            this.f7389c.thinkView(view);
        }
    }

    public class f extends b.c.b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ AppAlertFragment f7391c;

        public f(AppAlertFragment appAlertFragment) {
            this.f7391c = appAlertFragment;
        }

        @Override // b.c.b
        public void doClick(View view) {
            this.f7391c.centerClickView(view);
        }
    }

    public class g extends b.c.b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ AppAlertFragment f7393c;

        public g(AppAlertFragment appAlertFragment) {
            this.f7393c = appAlertFragment;
        }

        @Override // b.c.b
        public void doClick(View view) {
            this.f7393c.clickView(view);
        }
    }

    @UiThread
    public AppAlertFragment_ViewBinding(AppAlertFragment appAlertFragment, View view) {
        this.f7373b = appAlertFragment;
        appAlertFragment.mTitleTv = (TextView) b.c.d.findRequiredViewAsType(view, R.id.tv_alert_title, "field 'mTitleTv'", TextView.class);
        appAlertFragment.mContentTv = (TextView) b.c.d.findRequiredViewAsType(view, R.id.tv_alert_content, "field 'mContentTv'", TextView.class);
        View viewFindRequiredView = b.c.d.findRequiredView(view, R.id.btn_alert_cancel, "field 'mCancelBtn' and method 'cancelView'");
        appAlertFragment.mCancelBtn = (Button) b.c.d.castView(viewFindRequiredView, R.id.btn_alert_cancel, "field 'mCancelBtn'", Button.class);
        this.f7374c = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(appAlertFragment));
        View viewFindRequiredView2 = b.c.d.findRequiredView(view, R.id.btn_alert_confirm, "field 'mConfirmBtn' and method 'confirmView'");
        appAlertFragment.mConfirmBtn = (Button) b.c.d.castView(viewFindRequiredView2, R.id.btn_alert_confirm, "field 'mConfirmBtn'", Button.class);
        this.f7375d = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(appAlertFragment));
        View viewFindRequiredView3 = b.c.d.findRequiredView(view, R.id.btn_alert_center, "field 'mCenterBtn' and method 'confirmView'");
        appAlertFragment.mCenterBtn = (Button) b.c.d.castView(viewFindRequiredView3, R.id.btn_alert_center, "field 'mCenterBtn'", Button.class);
        this.f7376e = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new c(appAlertFragment));
        appAlertFragment.mAlertLayout = (ConstraintLayout) b.c.d.findRequiredViewAsType(view, R.id.constraint_layout_alert, "field 'mAlertLayout'", ConstraintLayout.class);
        appAlertFragment.mRentAlertLayout = (ConstraintLayout) b.c.d.findRequiredViewAsType(view, R.id.constraint_layout_rent_alert, "field 'mRentAlertLayout'", ConstraintLayout.class);
        appAlertFragment.mRentAlertTitleTv = (TextView) b.c.d.findRequiredViewAsType(view, R.id.tv_title, "field 'mRentAlertTitleTv'", TextView.class);
        appAlertFragment.mRentAlertContentTv = (TextView) b.c.d.findRequiredViewAsType(view, R.id.tv_content, "field 'mRentAlertContentTv'", TextView.class);
        View viewFindRequiredView4 = b.c.d.findRequiredView(view, R.id.btn_not_think, "field 'mRentNotThinkBtn' and method 'notThinkView'");
        appAlertFragment.mRentNotThinkBtn = (Button) b.c.d.castView(viewFindRequiredView4, R.id.btn_not_think, "field 'mRentNotThinkBtn'", Button.class);
        this.f7377f = viewFindRequiredView4;
        viewFindRequiredView4.setOnClickListener(new d(appAlertFragment));
        View viewFindRequiredView5 = b.c.d.findRequiredView(view, R.id.btn_think, "field 'mRentThinkBtn' and method 'thinkView'");
        appAlertFragment.mRentThinkBtn = (Button) b.c.d.castView(viewFindRequiredView5, R.id.btn_think, "field 'mRentThinkBtn'", Button.class);
        this.f7378g = viewFindRequiredView5;
        viewFindRequiredView5.setOnClickListener(new e(appAlertFragment));
        View viewFindRequiredView6 = b.c.d.findRequiredView(view, R.id.btn_confirm_renewal, "field 'mRentConfirmRenewalBtn' and method 'centerClickView'");
        appAlertFragment.mRentConfirmRenewalBtn = (Button) b.c.d.castView(viewFindRequiredView6, R.id.btn_confirm_renewal, "field 'mRentConfirmRenewalBtn'", Button.class);
        this.f7379h = viewFindRequiredView6;
        viewFindRequiredView6.setOnClickListener(new f(appAlertFragment));
        View viewFindRequiredView7 = b.c.d.findRequiredView(view, R.id.view_bg, "method 'clickView'");
        this.f7380i = viewFindRequiredView7;
        viewFindRequiredView7.setOnClickListener(new g(appAlertFragment));
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        AppAlertFragment appAlertFragment = this.f7373b;
        if (appAlertFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f7373b = null;
        appAlertFragment.mTitleTv = null;
        appAlertFragment.mContentTv = null;
        appAlertFragment.mCancelBtn = null;
        appAlertFragment.mConfirmBtn = null;
        appAlertFragment.mCenterBtn = null;
        appAlertFragment.mAlertLayout = null;
        appAlertFragment.mRentAlertLayout = null;
        appAlertFragment.mRentAlertTitleTv = null;
        appAlertFragment.mRentAlertContentTv = null;
        appAlertFragment.mRentNotThinkBtn = null;
        appAlertFragment.mRentThinkBtn = null;
        appAlertFragment.mRentConfirmRenewalBtn = null;
        this.f7374c.setOnClickListener(null);
        this.f7374c = null;
        this.f7375d.setOnClickListener(null);
        this.f7375d = null;
        this.f7376e.setOnClickListener(null);
        this.f7376e = null;
        this.f7377f.setOnClickListener(null);
        this.f7377f = null;
        this.f7378g.setOnClickListener(null);
        this.f7378g = null;
        this.f7379h.setOnClickListener(null);
        this.f7379h = null;
        this.f7380i.setOnClickListener(null);
        this.f7380i = null;
    }
}
