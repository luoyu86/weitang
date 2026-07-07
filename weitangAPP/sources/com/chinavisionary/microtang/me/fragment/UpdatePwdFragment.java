package com.chinavisionary.microtang.me.fragment;

import android.os.Message;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.lifecycle.Observer;
import butterknife.BindView;
import butterknife.OnClick;
import c.e.a.d.b0;
import c.e.a.d.w;
import c.e.a.d.x;
import com.chinavisionary.core.app.base.CoreBaseFragment;
import com.chinavisionary.core.app.net.base.dto.RequestErrDto;
import com.chinavisionary.core.app.net.base.dto.ResponseStateVo;
import com.chinavisionary.framework.mobile.login.dto.UserSimpleDto;
import com.chinavisionary.framework.mobile.login.param.SMSSendParam;
import com.chinavisionary.framework.mobile.user.param.UpdateUserPhoneParam;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.base.BaseFragment;
import com.chinavisionary.microtang.me.bo.NewUpdateDeviceIdVo;
import com.chinavisionary.microtang.me.bo.NewUpdatePwdToPhoneCode;
import com.chinavisionary.microtang.me.bo.UpdateDeviceIdVo;
import com.chinavisionary.microtang.me.bo.UpdatePwdToPhoneCode;
import com.chinavisionary.microtang.me.model.NewUserModel;
import com.chinavisionary.microtang.me.model.UserModel;
import g.b.a.c;

/* JADX INFO: loaded from: classes.dex */
public class UpdatePwdFragment extends BaseFragment {
    public int B;
    public int C;
    public int E;
    public UserModel F;
    public NewUserModel G;

    @BindView(R.id.img_new_again_pwd)
    public ImageView mAgainNewPwdImg;

    @BindView(R.id.img_again_pwd)
    public ImageView mAgainPwdImg;

    @BindView(R.id.tv_confirm)
    public AppCompatButton mConfirmBtn;

    @BindView(R.id.edt_phone)
    public EditText mPhoneEdt;

    @BindView(R.id.img_phone)
    public ImageView mPhoneImg;

    @BindView(R.id.edt_again_pwd)
    public EditText mPwdAgainEdt;

    @BindView(R.id.edt_pwd)
    public EditText mPwdEdt;

    @BindView(R.id.img_pwd)
    public ImageView mPwdImg;

    @BindView(R.id.edt_new_again_pwd)
    public EditText mPwdNewAgainEdt;

    @BindView(R.id.btn_send_sms)
    public Button mSendSmsCodeBtn;

    @BindView(R.id.tv_show_again_pwd)
    public TextView mShowAgainPwdTv;

    @BindView(R.id.tv_show_new_again_pwd)
    public TextView mShowNewAgainPwdTv;

    @BindView(R.id.tv_show_pwd)
    public TextView mShowPwdTv;

    @BindView(R.id.edt_sms_code)
    public EditText mSmsCodeEdt;

    @BindView(R.id.img_sms_code)
    public ImageView mSmsCodeImg;

    @BindView(R.id.tv_title)
    public TextView mTitleTv;
    public int D = 60;
    public TextWatcher H = new a();

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
            UpdatePwdFragment.this.F1();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: K1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void L1(String str) {
        G1();
        H();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: M1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void N1(String str) {
        H();
        I1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: O1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void P1(String str) {
        H();
        int i2 = this.E;
        if (i2 == 1) {
            F0(R.string.tip_update_success);
            H1();
        } else {
            if (i2 != 2) {
                return;
            }
            H1();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: Q1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void R1(ResponseStateVo responseStateVo) {
        F0(R.string.tip_update_pwd_success);
        H1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: S1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void T1(String str) {
        G1();
        H();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: U1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void V1(String str) {
        H();
        I1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: W1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void X1(String str) {
        H();
        int i2 = this.E;
        if (i2 == 1) {
            F0(R.string.tip_update_success);
            H1();
        } else {
            if (i2 != 2) {
                return;
            }
            H1();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: Y1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void Z1(ResponseStateVo responseStateVo) {
        F0(R.string.tip_update_pwd_success);
        H1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void b2(RequestErrDto requestErrDto) {
        G0(requestErrDto.getErrMsg());
        H();
    }

    public static UpdatePwdFragment getInstance(int i2) {
        UpdatePwdFragment updatePwdFragment = new UpdatePwdFragment();
        updatePwdFragment.setType(i2);
        return updatePwdFragment;
    }

    public final void F1() {
        String strS = s();
        if (x.isNullStr(strS) || !x.isMobile(strS)) {
            i2(false);
        } else {
            i2(true);
        }
    }

    public final void G1() {
        this.mPhoneEdt.setEnabled(false);
        this.mSendSmsCodeBtn.setText(String.format(x.getString(R.string.placeholder_sms_timer), Integer.valueOf(this.D)));
        this.mSendSmsCodeBtn.setTextColor(getResources().getColor(R.color.tab_item_select_color));
        CoreBaseFragment.c cVar = this.f6488f;
        if (cVar != null) {
            cVar.sendEmptyMessageDelayed(1, 1000L);
        }
    }

    public final void H1() {
        UpdateDeviceIdVo updateDeviceIdVo = null;
        String string = w.getInstance().getString("device_id_key", null);
        if (x.isNotNull(string)) {
            updateDeviceIdVo = new UpdateDeviceIdVo();
            updateDeviceIdVo.setDeviceid(string);
        }
        if (this.G == null) {
            this.F.doLogout(updateDeviceIdVo);
            return;
        }
        NewUpdateDeviceIdVo newUpdateDeviceIdVo = new NewUpdateDeviceIdVo();
        newUpdateDeviceIdVo.setDeviceid(string);
        this.G.doLogout(newUpdateDeviceIdVo);
    }

    public final void I1() {
        F0(this.E == 2 ? R.string.tip_update_pwd_success : R.string.tip_update_phone_success);
        c.getDefault().post(new UserSimpleDto());
        m();
        w.getInstance().clear();
        N();
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void V(View view) {
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void W() {
        this.mPwdNewAgainEdt.setVisibility(8);
        this.mAgainNewPwdImg.setVisibility(8);
        this.mShowNewAgainPwdTv.setVisibility(8);
        this.mConfirmBtn.setText(R.string.title_conform_value);
        this.B = getResources().getColor(R.color.colorFE9900);
        this.C = getResources().getColor(R.color.colore757575);
        e2();
        d2();
        this.f6488f = new CoreBaseFragment.c(this);
        this.mSendSmsCodeBtn.setTag(Boolean.FALSE);
        this.mPhoneEdt.addTextChangedListener(this.H);
    }

    @OnClick({R.id.tv_back})
    public void backClick(View view) {
        n();
    }

    public final void c2() {
        String strS = s();
        if (!x.isNotNull(strS)) {
            F0(R.string.tip_phone_is_empty);
            return;
        }
        if (!x.isMobile(strS)) {
            F0(R.string.tip_phone_is_failed);
            return;
        }
        z0(R.string.tip_get_sms_code_load);
        SMSSendParam sMSSendParam = new SMSSendParam();
        sMSSendParam.setPhone(strS);
        NewUserModel newUserModel = this.G;
        if (newUserModel != null) {
            newUserModel.sendSmsCode(sMSSendParam);
        } else {
            this.F.sendSmsCode(sMSSendParam);
        }
    }

    @OnClick({R.id.tv_confirm})
    public void confirmUpdate(View view) {
        int i2 = this.E;
        if (i2 == 1) {
            h2();
        } else {
            if (i2 != 2) {
                return;
            }
            g2();
        }
    }

    public final void d2() {
        if (c.e.a.a.a.getInstance().isH5Model()) {
            NewUserModel newUserModel = (NewUserModel) h(NewUserModel.class);
            this.G = newUserModel;
            newUserModel.getSmsCodeResult().observe(this, new Observer() { // from class: c.e.c.x.d.k2
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    this.f2064a.L1((String) obj);
                }
            });
            this.G.getLogoutLiveData().observe(this, new Observer() { // from class: c.e.c.x.d.m2
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    this.f2072a.N1((String) obj);
                }
            });
            this.G.getUpdateStateLiveData().observe(this, new Observer() { // from class: c.e.c.x.d.n2
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    this.f2076a.P1((String) obj);
                }
            });
            this.G.getUpdatePwdResult().observe(this, new Observer() { // from class: c.e.c.x.d.g2
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    this.f2048a.R1((ResponseStateVo) obj);
                }
            });
            this.G.getErrRequestLiveData().observe(this, new Observer() { // from class: c.e.c.x.d.h2
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    this.f2052a.C((RequestErrDto) obj);
                }
            });
        }
        UserModel userModel = (UserModel) h(UserModel.class);
        this.F = userModel;
        userModel.getSmsCodeResult().observe(this, new Observer() { // from class: c.e.c.x.d.i2
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f2056a.T1((String) obj);
            }
        });
        this.F.getLogoutLiveData().observe(this, new Observer() { // from class: c.e.c.x.d.f2
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f2044a.V1((String) obj);
            }
        });
        this.F.getUpdateStateLiveData().observe(this, new Observer() { // from class: c.e.c.x.d.l2
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f2068a.X1((String) obj);
            }
        });
        this.F.getUpdatePwdResult().observe(this, new Observer() { // from class: c.e.c.x.d.j2
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f2060a.Z1((ResponseStateVo) obj);
            }
        });
        this.F.getErrRequestLiveData().observe(this, new Observer() { // from class: c.e.c.x.d.e2
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f2040a.b2((RequestErrDto) obj);
            }
        });
    }

    public final void e2() {
        this.mTitleTv.setText(R.string.title_update_passwrod);
        this.mPhoneEdt.setText(t());
        this.mPhoneEdt.setEnabled(false);
        this.mPwdAgainEdt.setHint(R.string.hint_title_input_again_pwd);
        EditText editText = this.mPwdAgainEdt;
        editText.setBackgroundColor(editText.getResources().getColor(R.color.color_white));
        this.mPwdEdt.setHint(R.string.hint_title_input_new_pwd);
        F1();
    }

    public final void f2(EditText editText, View view) {
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

    public final void g2() {
        String string = this.mPwdEdt.getText().toString();
        String string2 = this.mPwdAgainEdt.getText().toString();
        String string3 = this.mSmsCodeEdt.getText().toString();
        if (x.isNullStr(string3)) {
            F0(R.string.tip_sms_code_is_empty);
            return;
        }
        if (x.isNullStr(string)) {
            F0(R.string.tip_new_pwd_is_empty);
            return;
        }
        if (x.isNullStr(string2)) {
            F0(R.string.tip_new_pwd_is_empty);
            return;
        }
        if (!b0.checkPasswordIsValid(string2)) {
            F0(R.string.tip_pwd_rule_msg);
            return;
        }
        if (!b0.checkPasswordIsValid(string2)) {
            F0(R.string.tip_confirm_pwd_rule_msg);
            return;
        }
        z0(R.string.tip_update_pwd_load);
        UpdatePwdToPhoneCode updatePwdToPhoneCode = new UpdatePwdToPhoneCode();
        updatePwdToPhoneCode.setCode(string3);
        updatePwdToPhoneCode.setNewPassword(string2);
        if (this.G == null) {
            this.F.updatePasswordToPhone(updatePwdToPhoneCode);
            return;
        }
        NewUpdatePwdToPhoneCode newUpdatePwdToPhoneCode = new NewUpdatePwdToPhoneCode();
        newUpdatePwdToPhoneCode.setCode(string3);
        newUpdatePwdToPhoneCode.setPhone(s());
        newUpdatePwdToPhoneCode.setNewPwd(string2);
        newUpdatePwdToPhoneCode.setNewConfirmPwd(string2);
        this.G.updatePasswordToPhone(newUpdatePwdToPhoneCode);
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public int getLayoutId() {
        return R.layout.fragment_update_phone_pwd;
    }

    public final void h2() {
        String strS = s();
        String string = this.mSmsCodeEdt.getText().toString();
        if (x.isNullStr(strS)) {
            F0(R.string.tip_phone_is_empty);
            return;
        }
        if (!x.isMobile(strS)) {
            F0(R.string.tip_phone_is_failed);
            return;
        }
        if (x.isNullStr(string)) {
            F0(R.string.tip_sms_code_is_empty);
            return;
        }
        if (x.isNotNull(strS) && x.isNotNull(string)) {
            z0(R.string.tip_update_phone_load);
            UpdateUserPhoneParam updateUserPhoneParam = new UpdateUserPhoneParam();
            updateUserPhoneParam.setPhone(strS);
            updateUserPhoneParam.setCode(string);
            NewUserModel newUserModel = this.G;
            if (newUserModel != null) {
                newUserModel.updatePhone(updateUserPhoneParam);
            } else {
                this.F.updatePhone(updateUserPhoneParam);
            }
        }
    }

    public final void i2(boolean z) {
        this.mSendSmsCodeBtn.setTag(Boolean.valueOf(z));
        this.mSendSmsCodeBtn.setTextColor(z ? this.B : this.C);
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void j0() {
    }

    public final void j2() {
        if (this.f6488f != null) {
            int i2 = this.D - 1;
            this.D = i2;
            if (i2 > 0) {
                this.mSendSmsCodeBtn.setText(String.format(x.getString(R.string.placeholder_sms_timer), Integer.valueOf(this.D)));
                this.f6488f.sendEmptyMessageDelayed(1, 1000L);
            } else {
                this.D = 60;
                this.mPhoneEdt.setEnabled(true);
                this.f6488f.removeMessages(1);
                this.mSendSmsCodeBtn.setText(R.string.title_retry_send_sms_code);
            }
        }
    }

    @OnClick({R.id.btn_send_sms})
    public void sendSmsCodeClick(View view) {
        c2();
    }

    public final void setType(int i2) {
        this.E = i2;
    }

    @OnClick({R.id.tv_show_again_pwd})
    public void showNewPwdClickView(View view) {
        f2(this.mPwdAgainEdt, view);
    }

    @OnClick({R.id.tv_show_pwd})
    public void showOldPwdClickView(View view) {
        f2(this.mPwdEdt, view);
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void z(Message message) {
        if (message.what != 1) {
            return;
        }
        j2();
    }
}
