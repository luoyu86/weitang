package com.chinavisionary.microtang.me.handler;

import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.NonNull;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import c.e.a.d.b0;
import c.e.a.d.x;
import c.e.c.x.e.h0;
import com.chinavisionary.framework.mobile.user.param.NewUpdateUserPasswordParam;
import com.chinavisionary.framework.mobile.user.param.UpdateUserPasswordParam;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.me.model.NewUserModel;
import com.chinavisionary.microtang.me.model.UserModel;

/* JADX INFO: loaded from: classes.dex */
public class UpdatePwdHandle {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public h0 f7744a;

    @BindView(R.id.tv_forget_pwd)
    public TextView mForgetPwdTv;

    @BindView(R.id.edt_again_pwd)
    public EditText mPwdAgainEdt;

    @BindView(R.id.edt_pwd)
    public EditText mPwdEdt;

    @BindView(R.id.edt_new_again_pwd)
    public EditText mPwdNewAgainEdt;

    public UpdatePwdHandle(@NonNull h0 h0Var) {
        this.f7744a = h0Var;
        ButterKnife.bind(this, h0Var.getLayoutView());
    }

    public final void a(EditText editText, View view) {
        TextView textView = (TextView) view;
        String string = textView.getText().toString();
        int i2 = R.string.title_hide;
        boolean zEquals = string.equals(x.getString(R.string.title_hide));
        editText.setTransformationMethod(zEquals ? PasswordTransformationMethod.getInstance() : HideReturnsTransformationMethod.getInstance());
        editText.setSelection(editText.length());
        if (zEquals) {
            i2 = R.string.title_show;
        }
        textView.setText(i2);
    }

    @OnClick({R.id.tv_forget_pwd})
    public void openUpdatePwdFragment() {
        this.f7744a.openUpdatePwdFragment();
    }

    public void setupShowUpdatePwdView(boolean z) {
        this.mForgetPwdTv.setVisibility(z ? 0 : 8);
        this.mPwdEdt.setVisibility(z ? 0 : 8);
        this.mPwdAgainEdt.setVisibility(z ? 0 : 8);
        this.mPwdNewAgainEdt.setVisibility(z ? 0 : 8);
    }

    @OnClick({R.id.tv_show_new_again_pwd})
    public void showNewAginPwdClickView(View view) {
        a(this.mPwdNewAgainEdt, view);
    }

    @OnClick({R.id.tv_show_again_pwd})
    public void showNewPwdClickView(View view) {
        a(this.mPwdAgainEdt, view);
    }

    @OnClick({R.id.tv_show_pwd})
    public void showOldPwdClickView(View view) {
        a(this.mPwdEdt, view);
    }

    public void updatePassword(UserModel userModel, NewUserModel newUserModel) {
        String string = this.mPwdEdt.getText().toString();
        String string2 = this.mPwdAgainEdt.getText().toString();
        String string3 = this.mPwdNewAgainEdt.getText().toString();
        if (x.isNullStr(string)) {
            this.f7744a.showToast(R.string.tip_old_pwd_is_empty);
            return;
        }
        if (x.isNullStr(string2)) {
            this.f7744a.showToast(R.string.tip_new_pwd_is_empty);
            return;
        }
        if (x.isNullStr(string3)) {
            this.f7744a.showToast(R.string.tip_again_pwd_is_empty);
            return;
        }
        if (!b0.checkPasswordIsValid(string2)) {
            this.f7744a.showToast(R.string.tip_pwd_rule_msg);
            return;
        }
        if (!b0.checkPasswordIsValid(string3)) {
            this.f7744a.showToast(R.string.tip_confirm_pwd_rule_msg);
            return;
        }
        if (!string2.equals(string3)) {
            this.f7744a.showToast(R.string.tip_again_pwd_not_equals);
            return;
        }
        this.f7744a.showLoading(R.string.tip_update_pwd_load);
        UpdateUserPasswordParam updateUserPasswordParam = new UpdateUserPasswordParam();
        updateUserPasswordParam.setOldPassword(string);
        updateUserPasswordParam.setNewPassword(string2);
        if (newUserModel == null) {
            userModel.updatePassword(updateUserPasswordParam);
            return;
        }
        NewUpdateUserPasswordParam newUpdateUserPasswordParam = new NewUpdateUserPasswordParam();
        newUpdateUserPasswordParam.setOldPwd(string);
        newUpdateUserPasswordParam.setNewPwd(string2);
        newUpdateUserPasswordParam.setNewConfirmPwd(string2);
        newUserModel.updatePassword(newUpdateUserPasswordParam);
    }
}
