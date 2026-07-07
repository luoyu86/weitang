package com.chinavisionary.microtang.me.handler;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import b.c.d;
import butterknife.Unbinder;
import com.chinavisionary.microtang.R;

/* JADX INFO: loaded from: classes.dex */
public class UpdatePhoneHandle_ViewBinding implements Unbinder {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public UpdatePhoneHandle f7743b;

    @UiThread
    public UpdatePhoneHandle_ViewBinding(UpdatePhoneHandle updatePhoneHandle, View view) {
        this.f7743b = updatePhoneHandle;
        updatePhoneHandle.mPhoneEdt = (EditText) d.findRequiredViewAsType(view, R.id.edt_phone, "field 'mPhoneEdt'", EditText.class);
        updatePhoneHandle.mOldPhoneEdt = (EditText) d.findRequiredViewAsType(view, R.id.edt_old_phone, "field 'mOldPhoneEdt'", EditText.class);
        updatePhoneHandle.mSmsCodeEdt = (EditText) d.findRequiredViewAsType(view, R.id.edt_sms_code, "field 'mSmsCodeEdt'", EditText.class);
        updatePhoneHandle.mSendSmsCodeBtn = (Button) d.findRequiredViewAsType(view, R.id.btn_send_sms, "field 'mSendSmsCodeBtn'", Button.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        UpdatePhoneHandle updatePhoneHandle = this.f7743b;
        if (updatePhoneHandle == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f7743b = null;
        updatePhoneHandle.mPhoneEdt = null;
        updatePhoneHandle.mOldPhoneEdt = null;
        updatePhoneHandle.mSmsCodeEdt = null;
        updatePhoneHandle.mSendSmsCodeBtn = null;
    }
}
