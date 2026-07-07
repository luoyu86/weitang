package com.chinavisionary.microtang.me.fragment;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.appcompat.widget.AppCompatButton;
import butterknife.Unbinder;
import com.chinavisionary.microtang.R;

/* JADX INFO: loaded from: classes.dex */
public class UpdatePwdFragment_ViewBinding implements Unbinder {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public UpdatePwdFragment f7714b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f7715c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public View f7716d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public View f7717e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public View f7718f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public View f7719g;

    public class a extends b.c.b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ UpdatePwdFragment f7720c;

        public a(UpdatePwdFragment updatePwdFragment) {
            this.f7720c = updatePwdFragment;
        }

        @Override // b.c.b
        public void doClick(View view) {
            this.f7720c.showOldPwdClickView(view);
        }
    }

    public class b extends b.c.b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ UpdatePwdFragment f7722c;

        public b(UpdatePwdFragment updatePwdFragment) {
            this.f7722c = updatePwdFragment;
        }

        @Override // b.c.b
        public void doClick(View view) {
            this.f7722c.showNewPwdClickView(view);
        }
    }

    public class c extends b.c.b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ UpdatePwdFragment f7724c;

        public c(UpdatePwdFragment updatePwdFragment) {
            this.f7724c = updatePwdFragment;
        }

        @Override // b.c.b
        public void doClick(View view) {
            this.f7724c.sendSmsCodeClick(view);
        }
    }

    public class d extends b.c.b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ UpdatePwdFragment f7726c;

        public d(UpdatePwdFragment updatePwdFragment) {
            this.f7726c = updatePwdFragment;
        }

        @Override // b.c.b
        public void doClick(View view) {
            this.f7726c.confirmUpdate(view);
        }
    }

    public class e extends b.c.b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ UpdatePwdFragment f7728c;

        public e(UpdatePwdFragment updatePwdFragment) {
            this.f7728c = updatePwdFragment;
        }

        @Override // b.c.b
        public void doClick(View view) {
            this.f7728c.backClick(view);
        }
    }

    @UiThread
    public UpdatePwdFragment_ViewBinding(UpdatePwdFragment updatePwdFragment, View view) {
        this.f7714b = updatePwdFragment;
        updatePwdFragment.mTitleTv = (TextView) b.c.d.findRequiredViewAsType(view, R.id.tv_title, "field 'mTitleTv'", TextView.class);
        updatePwdFragment.mPhoneEdt = (EditText) b.c.d.findRequiredViewAsType(view, R.id.edt_phone, "field 'mPhoneEdt'", EditText.class);
        updatePwdFragment.mSmsCodeEdt = (EditText) b.c.d.findRequiredViewAsType(view, R.id.edt_sms_code, "field 'mSmsCodeEdt'", EditText.class);
        updatePwdFragment.mPwdEdt = (EditText) b.c.d.findRequiredViewAsType(view, R.id.edt_pwd, "field 'mPwdEdt'", EditText.class);
        updatePwdFragment.mPwdAgainEdt = (EditText) b.c.d.findRequiredViewAsType(view, R.id.edt_again_pwd, "field 'mPwdAgainEdt'", EditText.class);
        updatePwdFragment.mPhoneImg = (ImageView) b.c.d.findRequiredViewAsType(view, R.id.img_phone, "field 'mPhoneImg'", ImageView.class);
        updatePwdFragment.mSmsCodeImg = (ImageView) b.c.d.findRequiredViewAsType(view, R.id.img_sms_code, "field 'mSmsCodeImg'", ImageView.class);
        updatePwdFragment.mPwdImg = (ImageView) b.c.d.findRequiredViewAsType(view, R.id.img_pwd, "field 'mPwdImg'", ImageView.class);
        updatePwdFragment.mAgainPwdImg = (ImageView) b.c.d.findRequiredViewAsType(view, R.id.img_again_pwd, "field 'mAgainPwdImg'", ImageView.class);
        View viewFindRequiredView = b.c.d.findRequiredView(view, R.id.tv_show_pwd, "field 'mShowPwdTv' and method 'showOldPwdClickView'");
        updatePwdFragment.mShowPwdTv = (TextView) b.c.d.castView(viewFindRequiredView, R.id.tv_show_pwd, "field 'mShowPwdTv'", TextView.class);
        this.f7715c = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(updatePwdFragment));
        View viewFindRequiredView2 = b.c.d.findRequiredView(view, R.id.tv_show_again_pwd, "field 'mShowAgainPwdTv' and method 'showNewPwdClickView'");
        updatePwdFragment.mShowAgainPwdTv = (TextView) b.c.d.castView(viewFindRequiredView2, R.id.tv_show_again_pwd, "field 'mShowAgainPwdTv'", TextView.class);
        this.f7716d = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(updatePwdFragment));
        updatePwdFragment.mPwdNewAgainEdt = (EditText) b.c.d.findRequiredViewAsType(view, R.id.edt_new_again_pwd, "field 'mPwdNewAgainEdt'", EditText.class);
        updatePwdFragment.mAgainNewPwdImg = (ImageView) b.c.d.findRequiredViewAsType(view, R.id.img_new_again_pwd, "field 'mAgainNewPwdImg'", ImageView.class);
        updatePwdFragment.mShowNewAgainPwdTv = (TextView) b.c.d.findRequiredViewAsType(view, R.id.tv_show_new_again_pwd, "field 'mShowNewAgainPwdTv'", TextView.class);
        View viewFindRequiredView3 = b.c.d.findRequiredView(view, R.id.btn_send_sms, "field 'mSendSmsCodeBtn' and method 'sendSmsCodeClick'");
        updatePwdFragment.mSendSmsCodeBtn = (Button) b.c.d.castView(viewFindRequiredView3, R.id.btn_send_sms, "field 'mSendSmsCodeBtn'", Button.class);
        this.f7717e = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new c(updatePwdFragment));
        View viewFindRequiredView4 = b.c.d.findRequiredView(view, R.id.tv_confirm, "field 'mConfirmBtn' and method 'confirmUpdate'");
        updatePwdFragment.mConfirmBtn = (AppCompatButton) b.c.d.castView(viewFindRequiredView4, R.id.tv_confirm, "field 'mConfirmBtn'", AppCompatButton.class);
        this.f7718f = viewFindRequiredView4;
        viewFindRequiredView4.setOnClickListener(new d(updatePwdFragment));
        View viewFindRequiredView5 = b.c.d.findRequiredView(view, R.id.tv_back, "method 'backClick'");
        this.f7719g = viewFindRequiredView5;
        viewFindRequiredView5.setOnClickListener(new e(updatePwdFragment));
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        UpdatePwdFragment updatePwdFragment = this.f7714b;
        if (updatePwdFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f7714b = null;
        updatePwdFragment.mTitleTv = null;
        updatePwdFragment.mPhoneEdt = null;
        updatePwdFragment.mSmsCodeEdt = null;
        updatePwdFragment.mPwdEdt = null;
        updatePwdFragment.mPwdAgainEdt = null;
        updatePwdFragment.mPhoneImg = null;
        updatePwdFragment.mSmsCodeImg = null;
        updatePwdFragment.mPwdImg = null;
        updatePwdFragment.mAgainPwdImg = null;
        updatePwdFragment.mShowPwdTv = null;
        updatePwdFragment.mShowAgainPwdTv = null;
        updatePwdFragment.mPwdNewAgainEdt = null;
        updatePwdFragment.mAgainNewPwdImg = null;
        updatePwdFragment.mShowNewAgainPwdTv = null;
        updatePwdFragment.mSendSmsCodeBtn = null;
        updatePwdFragment.mConfirmBtn = null;
        this.f7715c.setOnClickListener(null);
        this.f7715c = null;
        this.f7716d.setOnClickListener(null);
        this.f7716d = null;
        this.f7717e.setOnClickListener(null);
        this.f7717e = null;
        this.f7718f.setOnClickListener(null);
        this.f7718f = null;
        this.f7719g.setOnClickListener(null);
        this.f7719g = null;
    }
}
