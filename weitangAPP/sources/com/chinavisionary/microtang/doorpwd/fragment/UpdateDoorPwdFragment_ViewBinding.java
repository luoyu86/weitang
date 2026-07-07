package com.chinavisionary.microtang.doorpwd.fragment;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.appcompat.widget.AppCompatButton;
import b.c.b;
import b.c.d;
import butterknife.Unbinder;
import com.chinavisionary.microtang.R;

/* JADX INFO: loaded from: classes.dex */
public class UpdateDoorPwdFragment_ViewBinding implements Unbinder {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public UpdateDoorPwdFragment f7210b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f7211c;

    public class a extends b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ UpdateDoorPwdFragment f7212c;

        public a(UpdateDoorPwdFragment updateDoorPwdFragment) {
            this.f7212c = updateDoorPwdFragment;
        }

        @Override // b.c.b
        public void doClick(View view) {
            this.f7212c.closeFragment();
        }
    }

    @UiThread
    public UpdateDoorPwdFragment_ViewBinding(UpdateDoorPwdFragment updateDoorPwdFragment, View view) {
        this.f7210b = updateDoorPwdFragment;
        updateDoorPwdFragment.mUserNameTv = (TextView) d.findRequiredViewAsType(view, R.id.tv_user_name, "field 'mUserNameTv'", TextView.class);
        updateDoorPwdFragment.mUserPhoneTv = (TextView) d.findRequiredViewAsType(view, R.id.edt_phone, "field 'mUserPhoneTv'", TextView.class);
        updateDoorPwdFragment.mRetryGetTv = (Button) d.findRequiredViewAsType(view, R.id.btn_send_sms, "field 'mRetryGetTv'", Button.class);
        updateDoorPwdFragment.mConfirmBtn = (AppCompatButton) d.findRequiredViewAsType(view, R.id.tv_confirm, "field 'mConfirmBtn'", AppCompatButton.class);
        updateDoorPwdFragment.mSmsCodeEdt = (EditText) d.findRequiredViewAsType(view, R.id.edt_sms_code, "field 'mSmsCodeEdt'", EditText.class);
        updateDoorPwdFragment.mAgainPwdEdt = (EditText) d.findRequiredViewAsType(view, R.id.edt_new_again_pwd, "field 'mAgainPwdEdt'", EditText.class);
        updateDoorPwdFragment.mPwdEdt = (EditText) d.findRequiredViewAsType(view, R.id.edt_again_pwd, "field 'mPwdEdt'", EditText.class);
        updateDoorPwdFragment.mAgainPwdImg = (ImageView) d.findRequiredViewAsType(view, R.id.img_open_again_pwd, "field 'mAgainPwdImg'", ImageView.class);
        updateDoorPwdFragment.mPwdImg = (ImageView) d.findRequiredViewAsType(view, R.id.img_open_pwd, "field 'mPwdImg'", ImageView.class);
        View viewFindRequiredView = d.findRequiredView(view, R.id.img_close, "method 'closeFragment'");
        this.f7211c = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(updateDoorPwdFragment));
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        UpdateDoorPwdFragment updateDoorPwdFragment = this.f7210b;
        if (updateDoorPwdFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f7210b = null;
        updateDoorPwdFragment.mUserNameTv = null;
        updateDoorPwdFragment.mUserPhoneTv = null;
        updateDoorPwdFragment.mRetryGetTv = null;
        updateDoorPwdFragment.mConfirmBtn = null;
        updateDoorPwdFragment.mSmsCodeEdt = null;
        updateDoorPwdFragment.mAgainPwdEdt = null;
        updateDoorPwdFragment.mPwdEdt = null;
        updateDoorPwdFragment.mAgainPwdImg = null;
        updateDoorPwdFragment.mPwdImg = null;
        this.f7211c.setOnClickListener(null);
        this.f7211c = null;
    }
}
