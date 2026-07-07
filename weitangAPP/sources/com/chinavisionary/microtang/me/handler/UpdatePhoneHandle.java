package com.chinavisionary.microtang.me.handler;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;
import butterknife.BindView;
import butterknife.ButterKnife;
import c.e.a.d.x;
import c.e.c.x.e.h0;
import com.chinavisionary.framework.mobile.login.param.SMSSendParam;
import com.chinavisionary.framework.mobile.user.param.NoLoginUpdateUserPhoneParam;
import com.chinavisionary.framework.mobile.user.param.UpdateUserPhoneParam;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.me.model.NewUserModel;
import com.chinavisionary.microtang.me.model.UserModel;

/* JADX INFO: loaded from: classes.dex */
public class UpdatePhoneHandle {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f7738a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f7739b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public h0 f7740c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public TextWatcher f7741d = new a();

    @BindView(R.id.edt_old_phone)
    public EditText mOldPhoneEdt;

    @BindView(R.id.edt_phone)
    public EditText mPhoneEdt;

    @BindView(R.id.btn_send_sms)
    public Button mSendSmsCodeBtn;

    @BindView(R.id.edt_sms_code)
    public EditText mSmsCodeEdt;

    public class a implements TextWatcher {
        public a() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            UpdatePhoneHandle.this.b();
        }
    }

    public UpdatePhoneHandle(h0 h0Var) {
        this.f7740c = h0Var;
        ButterKnife.bind(this, h0Var.getLayoutView());
        this.f7738a = this.mPhoneEdt.getResources().getColor(R.color.colorFE9900);
        this.f7739b = this.mPhoneEdt.getResources().getColor(R.color.colore757575);
    }

    public final void b() {
        String string = this.mPhoneEdt.getText().toString();
        if (x.isNullStr(string) || !x.isMobile(string)) {
            c(false);
        } else {
            c(true);
        }
    }

    public final void c(boolean z) {
        if (((Boolean) this.mSendSmsCodeBtn.getTag()).booleanValue() != z) {
            this.mSendSmsCodeBtn.setTag(Boolean.valueOf(z));
            this.mSendSmsCodeBtn.setTextColor(z ? this.f7738a : this.f7739b);
        }
    }

    public String getNewPhone() {
        return this.mPhoneEdt.getText().toString();
    }

    public void noLoginSendSmsCode(NewUserModel newUserModel) {
        String string = this.mPhoneEdt.getText().toString();
        if (!x.isNotNull(string)) {
            this.f7740c.showToast(R.string.tip_phone_is_empty);
            return;
        }
        if (!x.isMobile(string)) {
            this.f7740c.showToast(R.string.tip_phone_is_failed);
            return;
        }
        this.f7740c.showLoading(R.string.tip_get_sms_code_load);
        SMSSendParam sMSSendParam = new SMSSendParam();
        sMSSendParam.setPhone(this.mPhoneEdt.getText().toString());
        newUserModel.getSmsCode(sMSSendParam);
    }

    public void performNoLoginUpdatePhone(NewUserModel newUserModel) {
        String string = this.mOldPhoneEdt.getText().toString();
        String string2 = this.mPhoneEdt.getText().toString();
        String string3 = this.mSmsCodeEdt.getText().toString();
        if (x.isNullStr(string)) {
            this.f7740c.showToast(R.string.tip_old_phone_is_empty);
            return;
        }
        if (x.isNullStr(string2)) {
            this.f7740c.showToast(R.string.tip_phone_is_empty);
            return;
        }
        if (!x.isMobile(string2)) {
            this.f7740c.showToast(R.string.tip_phone_is_failed);
            return;
        }
        if (x.isNullStr(string3)) {
            this.f7740c.showToast(R.string.tip_sms_code_is_empty);
            return;
        }
        this.f7740c.showLoading(R.string.tip_update_phone_load);
        NoLoginUpdateUserPhoneParam noLoginUpdateUserPhoneParam = new NoLoginUpdateUserPhoneParam();
        noLoginUpdateUserPhoneParam.setNewPhone(string2);
        noLoginUpdateUserPhoneParam.setPhone(string);
        noLoginUpdateUserPhoneParam.setCode(string3);
        newUserModel.noLoginUpdatePhone(noLoginUpdateUserPhoneParam);
    }

    public void performUpdatePhone(UserModel userModel, NewUserModel newUserModel) {
        String string = this.mPhoneEdt.getText().toString();
        String string2 = this.mSmsCodeEdt.getText().toString();
        if (x.isNullStr(string)) {
            this.f7740c.showToast(R.string.tip_phone_is_empty);
            return;
        }
        if (!x.isMobile(string)) {
            this.f7740c.showToast(R.string.tip_phone_is_failed);
            return;
        }
        if (x.isNullStr(string2)) {
            this.f7740c.showToast(R.string.tip_sms_code_is_empty);
            return;
        }
        this.f7740c.showLoading(R.string.tip_update_phone_load);
        UpdateUserPhoneParam updateUserPhoneParam = new UpdateUserPhoneParam();
        updateUserPhoneParam.setPhone(string);
        updateUserPhoneParam.setCode(string2);
        if (newUserModel != null) {
            newUserModel.updatePhone(updateUserPhoneParam);
        } else {
            userModel.updatePhone(updateUserPhoneParam);
        }
    }

    public void sendSmsCode(UserModel userModel, NewUserModel newUserModel) {
        String string = this.mPhoneEdt.getText().toString();
        if (!x.isNotNull(string)) {
            this.f7740c.showToast(R.string.tip_phone_is_empty);
            return;
        }
        if (!x.isMobile(string)) {
            this.f7740c.showToast(R.string.tip_phone_is_failed);
            return;
        }
        this.f7740c.showLoading(R.string.tip_get_sms_code_load);
        SMSSendParam sMSSendParam = new SMSSendParam();
        sMSSendParam.setPhone(this.mPhoneEdt.getText().toString());
        if (newUserModel != null) {
            newUserModel.sendSmsCode(sMSSendParam);
        } else {
            userModel.sendSmsCode(sMSSendParam);
        }
    }

    public void setupShowUpdatePhone(boolean z) {
        this.mSendSmsCodeBtn.setTag(Boolean.FALSE);
        this.mPhoneEdt.addTextChangedListener(this.f7741d);
        this.mSmsCodeEdt.setVisibility(z ? 8 : 0);
        if (!z) {
            EditText editText = this.mSmsCodeEdt;
            editText.setBackgroundColor(editText.getResources().getColor(R.color.color_white));
        }
        this.mPhoneEdt.setVisibility(z ? 8 : 0);
        this.mSendSmsCodeBtn.setVisibility(z ? 8 : 0);
        if (z) {
            this.mPhoneEdt.requestFocus();
        }
    }

    public void showOldPhone() {
        this.mOldPhoneEdt.setVisibility(0);
        this.mOldPhoneEdt.requestFocus();
    }

    public void startTimer(int i2) {
        String string = this.mPhoneEdt.getText().toString();
        if (x.isNullStr(string)) {
            this.f7740c.showToast(R.string.tip_phone_is_empty);
        } else {
            if (!x.isMobile(string)) {
                this.f7740c.showToast(R.string.hint_input_phone);
                return;
            }
            this.mPhoneEdt.setEnabled(false);
            this.mSendSmsCodeBtn.setText(String.format(x.getString(R.string.placeholder_sms_timer), Integer.valueOf(i2)));
            this.mSendSmsCodeBtn.setTextColor(this.mPhoneEdt.getResources().getColor(R.color.tab_item_select_color));
        }
    }

    public void updateTimer(int i2) {
        if (i2 > 0) {
            this.mSendSmsCodeBtn.setText(String.format(x.getString(R.string.placeholder_sms_timer_unit), Integer.valueOf(i2)));
        } else {
            this.mPhoneEdt.setEnabled(true);
            this.mSendSmsCodeBtn.setText(R.string.title_retry_send_sms_code);
        }
    }
}
