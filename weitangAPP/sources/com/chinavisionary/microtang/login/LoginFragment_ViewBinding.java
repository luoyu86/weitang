package com.chinavisionary.microtang.login;

import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import com.chinavisionary.microtang.R;

/* JADX INFO: loaded from: classes.dex */
public class LoginFragment_ViewBinding implements Unbinder {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public LoginFragment f7295b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f7296c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public View f7297d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public View f7298e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public View f7299f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public View f7300g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public View f7301h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public View f7302i;
    public View j;
    public View k;

    public class a extends b.c.b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ LoginFragment f7303c;

        public a(LoginFragment loginFragment) {
            this.f7303c = loginFragment;
        }

        @Override // b.c.b
        public void doClick(View view) {
            this.f7303c.pageClick(view);
        }
    }

    public class b extends b.c.b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ LoginFragment f7305c;

        public b(LoginFragment loginFragment) {
            this.f7305c = loginFragment;
        }

        @Override // b.c.b
        public void doClick(View view) {
            this.f7305c.pageClick(view);
        }
    }

    public class c extends b.c.b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ LoginFragment f7307c;

        public c(LoginFragment loginFragment) {
            this.f7307c = loginFragment;
        }

        @Override // b.c.b
        public void doClick(View view) {
            this.f7307c.pageClick(view);
        }
    }

    public class d extends b.c.b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ LoginFragment f7309c;

        public d(LoginFragment loginFragment) {
            this.f7309c = loginFragment;
        }

        @Override // b.c.b
        public void doClick(View view) {
            this.f7309c.pageClick(view);
        }
    }

    public class e extends b.c.b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ LoginFragment f7311c;

        public e(LoginFragment loginFragment) {
            this.f7311c = loginFragment;
        }

        @Override // b.c.b
        public void doClick(View view) {
            this.f7311c.pageClick(view);
        }
    }

    public class f extends b.c.b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ LoginFragment f7313c;

        public f(LoginFragment loginFragment) {
            this.f7313c = loginFragment;
        }

        @Override // b.c.b
        public void doClick(View view) {
            this.f7313c.pageClick(view);
        }
    }

    public class g extends b.c.b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ LoginFragment f7315c;

        public g(LoginFragment loginFragment) {
            this.f7315c = loginFragment;
        }

        @Override // b.c.b
        public void doClick(View view) {
            this.f7315c.pageClick(view);
        }
    }

    public class h extends b.c.b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ LoginFragment f7317c;

        public h(LoginFragment loginFragment) {
            this.f7317c = loginFragment;
        }

        @Override // b.c.b
        public void doClick(View view) {
            this.f7317c.pageClick(view);
        }
    }

    public class i extends b.c.b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ LoginFragment f7319c;

        public i(LoginFragment loginFragment) {
            this.f7319c = loginFragment;
        }

        @Override // b.c.b
        public void doClick(View view) {
            this.f7319c.pageClick(view);
        }
    }

    @UiThread
    public LoginFragment_ViewBinding(LoginFragment loginFragment, View view) {
        this.f7295b = loginFragment;
        loginFragment.mTitleTv = (TextView) b.c.d.findRequiredViewAsType(view, R.id.tv_title, "field 'mTitleTv'", TextView.class);
        loginFragment.mSplitLineTv = (TextView) b.c.d.findRequiredViewAsType(view, R.id.tv_title_split_line, "field 'mSplitLineTv'", TextView.class);
        View viewFindRequiredView = b.c.d.findRequiredView(view, R.id.btn_login, "field 'mLoginBtn' and method 'pageClick'");
        loginFragment.mLoginBtn = (Button) b.c.d.castView(viewFindRequiredView, R.id.btn_login, "field 'mLoginBtn'", Button.class);
        this.f7296c = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(loginFragment));
        loginFragment.mPhoneEdt = (EditText) b.c.d.findRequiredViewAsType(view, R.id.edt_phone, "field 'mPhoneEdt'", EditText.class);
        loginFragment.mPwdEdt = (EditText) b.c.d.findRequiredViewAsType(view, R.id.edt_pwd, "field 'mPwdEdt'", EditText.class);
        loginFragment.mAgreeCb = (CheckBox) b.c.d.findRequiredViewAsType(view, R.id.cb_agree, "field 'mAgreeCb'", CheckBox.class);
        loginFragment.mPwdIconImg = (ImageView) b.c.d.findRequiredViewAsType(view, R.id.img_pwd, "field 'mPwdIconImg'", ImageView.class);
        View viewFindRequiredView2 = b.c.d.findRequiredView(view, R.id.btn_send_sms, "field 'mSendSmsBtn' and method 'pageClick'");
        loginFragment.mSendSmsBtn = (Button) b.c.d.castView(viewFindRequiredView2, R.id.btn_send_sms, "field 'mSendSmsBtn'", Button.class);
        this.f7297d = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(loginFragment));
        View viewFindRequiredView3 = b.c.d.findRequiredView(view, R.id.tv_show_pwd, "field 'mShowPwdTv' and method 'pageClick'");
        loginFragment.mShowPwdTv = (TextView) b.c.d.castView(viewFindRequiredView3, R.id.tv_show_pwd, "field 'mShowPwdTv'", TextView.class);
        this.f7298e = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new c(loginFragment));
        View viewFindRequiredView4 = b.c.d.findRequiredView(view, R.id.tv_sms_login, "field 'mSmsLoginTv' and method 'pageClick'");
        loginFragment.mSmsLoginTv = (TextView) b.c.d.castView(viewFindRequiredView4, R.id.tv_sms_login, "field 'mSmsLoginTv'", TextView.class);
        this.f7299f = viewFindRequiredView4;
        viewFindRequiredView4.setOnClickListener(new d(loginFragment));
        loginFragment.mSwitchEveTv = (TextView) b.c.d.findRequiredViewAsType(view, R.id.tv_switch_eve, "field 'mSwitchEveTv'", TextView.class);
        loginFragment.mSwitchEveTipTv = (TextView) b.c.d.findRequiredViewAsType(view, R.id.tv_switch_tip_msg, "field 'mSwitchEveTipTv'", TextView.class);
        loginFragment.mSwitchEveSpinner = (Spinner) b.c.d.findRequiredViewAsType(view, R.id.spinner_eve, "field 'mSwitchEveSpinner'", Spinner.class);
        View viewFindRequiredView5 = b.c.d.findRequiredView(view, R.id.view_register_mask, "method 'pageClick'");
        this.f7300g = viewFindRequiredView5;
        viewFindRequiredView5.setOnClickListener(new e(loginFragment));
        View viewFindRequiredView6 = b.c.d.findRequiredView(view, R.id.tv_back, "method 'pageClick'");
        this.f7301h = viewFindRequiredView6;
        viewFindRequiredView6.setOnClickListener(new f(loginFragment));
        View viewFindRequiredView7 = b.c.d.findRequiredView(view, R.id.tv_update_phone, "method 'pageClick'");
        this.f7302i = viewFindRequiredView7;
        viewFindRequiredView7.setOnClickListener(new g(loginFragment));
        View viewFindRequiredView8 = b.c.d.findRequiredView(view, R.id.tv_protocol, "method 'pageClick'");
        this.j = viewFindRequiredView8;
        viewFindRequiredView8.setOnClickListener(new h(loginFragment));
        View viewFindRequiredView9 = b.c.d.findRequiredView(view, R.id.tv_private_policy, "method 'pageClick'");
        this.k = viewFindRequiredView9;
        viewFindRequiredView9.setOnClickListener(new i(loginFragment));
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        LoginFragment loginFragment = this.f7295b;
        if (loginFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f7295b = null;
        loginFragment.mTitleTv = null;
        loginFragment.mSplitLineTv = null;
        loginFragment.mLoginBtn = null;
        loginFragment.mPhoneEdt = null;
        loginFragment.mPwdEdt = null;
        loginFragment.mAgreeCb = null;
        loginFragment.mPwdIconImg = null;
        loginFragment.mSendSmsBtn = null;
        loginFragment.mShowPwdTv = null;
        loginFragment.mSmsLoginTv = null;
        loginFragment.mSwitchEveTv = null;
        loginFragment.mSwitchEveTipTv = null;
        loginFragment.mSwitchEveSpinner = null;
        this.f7296c.setOnClickListener(null);
        this.f7296c = null;
        this.f7297d.setOnClickListener(null);
        this.f7297d = null;
        this.f7298e.setOnClickListener(null);
        this.f7298e = null;
        this.f7299f.setOnClickListener(null);
        this.f7299f = null;
        this.f7300g.setOnClickListener(null);
        this.f7300g = null;
        this.f7301h.setOnClickListener(null);
        this.f7301h = null;
        this.f7302i.setOnClickListener(null);
        this.f7302i = null;
        this.j.setOnClickListener(null);
        this.j = null;
        this.k.setOnClickListener(null);
        this.k = null;
    }
}
