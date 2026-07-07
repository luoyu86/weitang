package com.chinavisionary.microtang.me.fragment;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;
import b.c.d;
import butterknife.Unbinder;
import com.chinavisionary.microtang.R;

/* JADX INFO: loaded from: classes.dex */
public class RollOutCheckFragment_ViewBinding implements Unbinder {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public RollOutCheckFragment f7684b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f7685c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public View f7686d;

    public class a extends b.c.b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ RollOutCheckFragment f7687c;

        public a(RollOutCheckFragment rollOutCheckFragment) {
            this.f7687c = rollOutCheckFragment;
        }

        @Override // b.c.b
        public void doClick(View view) {
            this.f7687c.confirmViewClick(view);
        }
    }

    public class b extends b.c.b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ RollOutCheckFragment f7689c;

        public b(RollOutCheckFragment rollOutCheckFragment) {
            this.f7689c = rollOutCheckFragment;
        }

        @Override // b.c.b
        public void doClick(View view) {
            this.f7689c.finishFragment(view);
        }
    }

    @UiThread
    public RollOutCheckFragment_ViewBinding(RollOutCheckFragment rollOutCheckFragment, View view) {
        this.f7684b = rollOutCheckFragment;
        rollOutCheckFragment.mRollOutPriceTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_title_roll_out_price, "field 'mRollOutPriceTv'", TextView.class);
        rollOutCheckFragment.mAlipayAccountTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_alipay_account, "field 'mAlipayAccountTv'", TextView.class);
        rollOutCheckFragment.mAlipayRealNameTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_alipay_real_name, "field 'mAlipayRealNameTv'", TextView.class);
        rollOutCheckFragment.mPhoneEdt = (AppCompatEditText) d.findRequiredViewAsType(view, R.id.edt_account_phone, "field 'mPhoneEdt'", AppCompatEditText.class);
        rollOutCheckFragment.mPhoneSmsCodeEdt = (AppCompatEditText) d.findRequiredViewAsType(view, R.id.edt_sms_code, "field 'mPhoneSmsCodeEdt'", AppCompatEditText.class);
        rollOutCheckFragment.mSendSmsCodeBtn = (AppCompatButton) d.findRequiredViewAsType(view, R.id.btn_send_sms, "field 'mSendSmsCodeBtn'", AppCompatButton.class);
        View viewFindRequiredView = d.findRequiredView(view, R.id.btn_confirm, "method 'confirmViewClick'");
        this.f7685c = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(rollOutCheckFragment));
        View viewFindRequiredView2 = d.findRequiredView(view, R.id.view_bg, "method 'finishFragment'");
        this.f7686d = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(rollOutCheckFragment));
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        RollOutCheckFragment rollOutCheckFragment = this.f7684b;
        if (rollOutCheckFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f7684b = null;
        rollOutCheckFragment.mRollOutPriceTv = null;
        rollOutCheckFragment.mAlipayAccountTv = null;
        rollOutCheckFragment.mAlipayRealNameTv = null;
        rollOutCheckFragment.mPhoneEdt = null;
        rollOutCheckFragment.mPhoneSmsCodeEdt = null;
        rollOutCheckFragment.mSendSmsCodeBtn = null;
        this.f7685c.setOnClickListener(null);
        this.f7685c = null;
        this.f7686d.setOnClickListener(null);
        this.f7686d = null;
    }
}
