package com.chinavisionary.microtang.me.fragment;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import b.c.b;
import b.c.d;
import butterknife.Unbinder;
import com.chinavisionary.microtang.R;
import com.chinavisionary.view.VerificationCodeInputView;

/* JADX INFO: loaded from: classes.dex */
public class CancelAccountFragment_ViewBinding implements Unbinder {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public CancelAccountFragment f7581b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f7582c;

    public class a extends b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ CancelAccountFragment f7583c;

        public a(CancelAccountFragment cancelAccountFragment) {
            this.f7583c = cancelAccountFragment;
        }

        @Override // b.c.b
        public void doClick(View view) {
            this.f7583c.clickBack();
        }
    }

    @UiThread
    public CancelAccountFragment_ViewBinding(CancelAccountFragment cancelAccountFragment, View view) {
        this.f7581b = cancelAccountFragment;
        cancelAccountFragment.mTitleTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_title, "field 'mTitleTv'", TextView.class);
        cancelAccountFragment.mSendPhoneNumberTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_send_phone_number, "field 'mSendPhoneNumberTv'", TextView.class);
        cancelAccountFragment.mRetryGetTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_retry_get, "field 'mRetryGetTv'", TextView.class);
        cancelAccountFragment.mVerificationCodeInputView = (VerificationCodeInputView) d.findRequiredViewAsType(view, R.id.verification_code_input_view, "field 'mVerificationCodeInputView'", VerificationCodeInputView.class);
        cancelAccountFragment.mSubmitBtn = (Button) d.findRequiredViewAsType(view, R.id.btn_login, "field 'mSubmitBtn'", Button.class);
        View viewFindRequiredView = d.findRequiredView(view, R.id.tv_back, "method 'clickBack'");
        this.f7582c = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(cancelAccountFragment));
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        CancelAccountFragment cancelAccountFragment = this.f7581b;
        if (cancelAccountFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f7581b = null;
        cancelAccountFragment.mTitleTv = null;
        cancelAccountFragment.mSendPhoneNumberTv = null;
        cancelAccountFragment.mRetryGetTv = null;
        cancelAccountFragment.mVerificationCodeInputView = null;
        cancelAccountFragment.mSubmitBtn = null;
        this.f7582c.setOnClickListener(null);
        this.f7582c = null;
    }
}
