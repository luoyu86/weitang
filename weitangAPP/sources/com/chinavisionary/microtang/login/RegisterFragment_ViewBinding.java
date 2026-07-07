package com.chinavisionary.microtang.login;

import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import com.chinavisionary.microtang.R;

/* JADX INFO: loaded from: classes.dex */
public class RegisterFragment_ViewBinding implements Unbinder {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public RegisterFragment f7323b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f7324c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public View f7325d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public View f7326e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public View f7327f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public View f7328g;

    public class a extends b.c.b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ RegisterFragment f7329c;

        public a(RegisterFragment registerFragment) {
            this.f7329c = registerFragment;
        }

        @Override // b.c.b
        public void doClick(View view) {
            this.f7329c.pageClick(view);
        }
    }

    public class b extends b.c.b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ RegisterFragment f7331c;

        public b(RegisterFragment registerFragment) {
            this.f7331c = registerFragment;
        }

        @Override // b.c.b
        public void doClick(View view) {
            this.f7331c.pageClick(view);
        }
    }

    public class c extends b.c.b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ RegisterFragment f7333c;

        public c(RegisterFragment registerFragment) {
            this.f7333c = registerFragment;
        }

        @Override // b.c.b
        public void doClick(View view) {
            this.f7333c.pageClick(view);
        }
    }

    public class d extends b.c.b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ RegisterFragment f7335c;

        public d(RegisterFragment registerFragment) {
            this.f7335c = registerFragment;
        }

        @Override // b.c.b
        public void doClick(View view) {
            this.f7335c.pageClick(view);
        }
    }

    public class e extends b.c.b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ RegisterFragment f7337c;

        public e(RegisterFragment registerFragment) {
            this.f7337c = registerFragment;
        }

        @Override // b.c.b
        public void doClick(View view) {
            this.f7337c.showAgainPwdClick(view);
        }
    }

    @UiThread
    public RegisterFragment_ViewBinding(RegisterFragment registerFragment, View view) {
        this.f7323b = registerFragment;
        registerFragment.mTitleTv = (TextView) b.c.d.findRequiredViewAsType(view, R.id.tv_title, "field 'mTitleTv'", TextView.class);
        registerFragment.mSplitLineTv = (TextView) b.c.d.findRequiredViewAsType(view, R.id.tv_title_split_line, "field 'mSplitLineTv'", TextView.class);
        registerFragment.mWomanCb = (CheckBox) b.c.d.findRequiredViewAsType(view, R.id.cb_woman, "field 'mWomanCb'", CheckBox.class);
        registerFragment.mManCb = (CheckBox) b.c.d.findRequiredViewAsType(view, R.id.cb_man, "field 'mManCb'", CheckBox.class);
        View viewFindRequiredView = b.c.d.findRequiredView(view, R.id.btn_register, "field 'mRegisterBtn' and method 'pageClick'");
        registerFragment.mRegisterBtn = (Button) b.c.d.castView(viewFindRequiredView, R.id.btn_register, "field 'mRegisterBtn'", Button.class);
        this.f7324c = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(registerFragment));
        registerFragment.mPhoneEdt = (EditText) b.c.d.findRequiredViewAsType(view, R.id.edt_phone, "field 'mPhoneEdt'", EditText.class);
        registerFragment.mSmsCodeEdt = (EditText) b.c.d.findRequiredViewAsType(view, R.id.edt_sms_code, "field 'mSmsCodeEdt'", EditText.class);
        registerFragment.mPwdEdt = (EditText) b.c.d.findRequiredViewAsType(view, R.id.edt_pwd, "field 'mPwdEdt'", EditText.class);
        registerFragment.mPwdAgainEdt = (EditText) b.c.d.findRequiredViewAsType(view, R.id.edt_again_pwd, "field 'mPwdAgainEdt'", EditText.class);
        registerFragment.mNameEdt = (EditText) b.c.d.findRequiredViewAsType(view, R.id.edt_name, "field 'mNameEdt'", EditText.class);
        View viewFindRequiredView2 = b.c.d.findRequiredView(view, R.id.btn_send_sms, "field 'mSendSmsCodeBtn' and method 'pageClick'");
        registerFragment.mSendSmsCodeBtn = (Button) b.c.d.castView(viewFindRequiredView2, R.id.btn_send_sms, "field 'mSendSmsCodeBtn'", Button.class);
        this.f7325d = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(registerFragment));
        registerFragment.mAgreeCb = (CheckBox) b.c.d.findRequiredViewAsType(view, R.id.cb_agree, "field 'mAgreeCb'", CheckBox.class);
        registerFragment.mProtocolTv = (TextView) b.c.d.findRequiredViewAsType(view, R.id.tv_protocol, "field 'mProtocolTv'", TextView.class);
        registerFragment.mPrivatePolicyTv = (TextView) b.c.d.findRequiredViewAsType(view, R.id.tv_private_policy, "field 'mPrivatePolicyTv'", TextView.class);
        View viewFindRequiredView3 = b.c.d.findRequiredView(view, R.id.tv_show_pwd, "method 'pageClick'");
        this.f7326e = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new c(registerFragment));
        View viewFindRequiredView4 = b.c.d.findRequiredView(view, R.id.tv_back, "method 'pageClick'");
        this.f7327f = viewFindRequiredView4;
        viewFindRequiredView4.setOnClickListener(new d(registerFragment));
        View viewFindRequiredView5 = b.c.d.findRequiredView(view, R.id.tv_show_again_pwd, "method 'showAgainPwdClick'");
        this.f7328g = viewFindRequiredView5;
        viewFindRequiredView5.setOnClickListener(new e(registerFragment));
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        RegisterFragment registerFragment = this.f7323b;
        if (registerFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f7323b = null;
        registerFragment.mTitleTv = null;
        registerFragment.mSplitLineTv = null;
        registerFragment.mWomanCb = null;
        registerFragment.mManCb = null;
        registerFragment.mRegisterBtn = null;
        registerFragment.mPhoneEdt = null;
        registerFragment.mSmsCodeEdt = null;
        registerFragment.mPwdEdt = null;
        registerFragment.mPwdAgainEdt = null;
        registerFragment.mNameEdt = null;
        registerFragment.mSendSmsCodeBtn = null;
        registerFragment.mAgreeCb = null;
        registerFragment.mProtocolTv = null;
        registerFragment.mPrivatePolicyTv = null;
        this.f7324c.setOnClickListener(null);
        this.f7324c = null;
        this.f7325d.setOnClickListener(null);
        this.f7325d = null;
        this.f7326e.setOnClickListener(null);
        this.f7326e = null;
        this.f7327f.setOnClickListener(null);
        this.f7327f = null;
        this.f7328g.setOnClickListener(null);
        this.f7328g = null;
    }
}
