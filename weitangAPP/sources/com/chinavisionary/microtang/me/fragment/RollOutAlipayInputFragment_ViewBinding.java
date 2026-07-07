package com.chinavisionary.microtang.me.fragment;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.appcompat.widget.AppCompatEditText;
import butterknife.Unbinder;
import com.chinavisionary.microtang.R;

/* JADX INFO: loaded from: classes.dex */
public class RollOutAlipayInputFragment_ViewBinding implements Unbinder {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public RollOutAlipayInputFragment f7671b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f7672c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public View f7673d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public View f7674e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public View f7675f;

    public class a extends b.c.b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ RollOutAlipayInputFragment f7676c;

        public a(RollOutAlipayInputFragment rollOutAlipayInputFragment) {
            this.f7676c = rollOutAlipayInputFragment;
        }

        @Override // b.c.b
        public void doClick(View view) {
            this.f7676c.confirmViewClick(view);
        }
    }

    public class b extends b.c.b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ RollOutAlipayInputFragment f7678c;

        public b(RollOutAlipayInputFragment rollOutAlipayInputFragment) {
            this.f7678c = rollOutAlipayInputFragment;
        }

        @Override // b.c.b
        public void doClick(View view) {
            this.f7678c.openAlipayTipFragment(view);
        }
    }

    public class c extends b.c.b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ RollOutAlipayInputFragment f7680c;

        public c(RollOutAlipayInputFragment rollOutAlipayInputFragment) {
            this.f7680c = rollOutAlipayInputFragment;
        }

        @Override // b.c.b
        public void doClick(View view) {
            this.f7680c.openAlipayTipFragment(view);
        }
    }

    public class d extends b.c.b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ RollOutAlipayInputFragment f7682c;

        public d(RollOutAlipayInputFragment rollOutAlipayInputFragment) {
            this.f7682c = rollOutAlipayInputFragment;
        }

        @Override // b.c.b
        public void doClick(View view) {
            this.f7682c.finishFragment(view);
        }
    }

    @UiThread
    public RollOutAlipayInputFragment_ViewBinding(RollOutAlipayInputFragment rollOutAlipayInputFragment, View view) {
        this.f7671b = rollOutAlipayInputFragment;
        rollOutAlipayInputFragment.mRollOutPriceTv = (TextView) b.c.d.findRequiredViewAsType(view, R.id.tv_title_roll_out_price, "field 'mRollOutPriceTv'", TextView.class);
        rollOutAlipayInputFragment.mAlertTipTv = (TextView) b.c.d.findRequiredViewAsType(view, R.id.tv_alert_tip, "field 'mAlertTipTv'", TextView.class);
        rollOutAlipayInputFragment.mAlipayRealNameEdt = (AppCompatEditText) b.c.d.findRequiredViewAsType(view, R.id.edt_alipay_real_name, "field 'mAlipayRealNameEdt'", AppCompatEditText.class);
        rollOutAlipayInputFragment.mAlipayAccountEdt = (AppCompatEditText) b.c.d.findRequiredViewAsType(view, R.id.edt_alipay_account, "field 'mAlipayAccountEdt'", AppCompatEditText.class);
        View viewFindRequiredView = b.c.d.findRequiredView(view, R.id.btn_confirm, "method 'confirmViewClick'");
        this.f7672c = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(rollOutAlipayInputFragment));
        View viewFindRequiredView2 = b.c.d.findRequiredView(view, R.id.img_btn_tip, "method 'openAlipayTipFragment'");
        this.f7673d = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(rollOutAlipayInputFragment));
        View viewFindRequiredView3 = b.c.d.findRequiredView(view, R.id.img_alipay_roll_out_tip, "method 'openAlipayTipFragment'");
        this.f7674e = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new c(rollOutAlipayInputFragment));
        View viewFindRequiredView4 = b.c.d.findRequiredView(view, R.id.view_bg, "method 'finishFragment'");
        this.f7675f = viewFindRequiredView4;
        viewFindRequiredView4.setOnClickListener(new d(rollOutAlipayInputFragment));
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        RollOutAlipayInputFragment rollOutAlipayInputFragment = this.f7671b;
        if (rollOutAlipayInputFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f7671b = null;
        rollOutAlipayInputFragment.mRollOutPriceTv = null;
        rollOutAlipayInputFragment.mAlertTipTv = null;
        rollOutAlipayInputFragment.mAlipayRealNameEdt = null;
        rollOutAlipayInputFragment.mAlipayAccountEdt = null;
        this.f7672c.setOnClickListener(null);
        this.f7672c = null;
        this.f7673d.setOnClickListener(null);
        this.f7673d = null;
        this.f7674e.setOnClickListener(null);
        this.f7674e = null;
        this.f7675f.setOnClickListener(null);
        this.f7675f = null;
    }
}
