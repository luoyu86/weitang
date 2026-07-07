package com.chinavisionary.microtang.login;

import android.os.Message;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import androidx.lifecycle.Observer;
import butterknife.BindView;
import butterknife.OnClick;
import c.e.a.d.b0;
import c.e.a.d.q;
import c.e.a.d.v;
import c.e.a.d.x;
import c.e.c.u.m.h;
import c.e.c.u.m.i;
import c.e.c.u.m.j;
import c.e.c.u.m.k;
import com.chinavisionary.core.app.base.CoreBaseFragment;
import com.chinavisionary.core.app.config.bo.AppConfigExtVo;
import com.chinavisionary.core.app.config.bo.UserInfoVo;
import com.chinavisionary.core.app.net.base.dto.RequestErrDto;
import com.chinavisionary.framework.mobile.login.dto.UserSimpleDto;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.base.BaseFragment;
import com.chinavisionary.microtang.login.bo.AppRegisterVo;
import com.chinavisionary.microtang.login.bo.NewAppRegisterVo;
import com.chinavisionary.microtang.me.model.NewUserModel;
import com.chinavisionary.microtang.me.model.NewUserOperateModel;
import com.chinavisionary.microtang.me.model.UserModel;
import com.chinavisionary.microtang.me.model.UserOperateModel;
import com.chinavisionary.microtang.web.WebFragment;
import com.chinavisionary.twlib.open.bo.AlertMessageVo;

/* JADX INFO: loaded from: classes.dex */
public class RegisterFragment extends BaseFragment {
    public boolean B;
    public boolean C;
    public UserModel D;
    public NewUserModel E;
    public UserOperateModel F;
    public NewUserOperateModel G;
    public k H;
    public j I;
    public i J;
    public final h K = new a();
    public final TextWatcher L = new b();

    @BindView(R.id.cb_agree)
    public CheckBox mAgreeCb;

    @BindView(R.id.cb_man)
    public CheckBox mManCb;

    @BindView(R.id.edt_name)
    public EditText mNameEdt;

    @BindView(R.id.edt_phone)
    public EditText mPhoneEdt;

    @BindView(R.id.tv_private_policy)
    public TextView mPrivatePolicyTv;

    @BindView(R.id.tv_protocol)
    public TextView mProtocolTv;

    @BindView(R.id.edt_again_pwd)
    public EditText mPwdAgainEdt;

    @BindView(R.id.edt_pwd)
    public EditText mPwdEdt;

    @BindView(R.id.btn_register)
    public Button mRegisterBtn;

    @BindView(R.id.btn_send_sms)
    public Button mSendSmsCodeBtn;

    @BindView(R.id.edt_sms_code)
    public EditText mSmsCodeEdt;

    @BindView(R.id.tv_title_split_line)
    public TextView mSplitLineTv;

    @BindView(R.id.tv_title)
    public TextView mTitleTv;

    @BindView(R.id.cb_woman)
    public CheckBox mWomanCb;

    public class a implements h {
        public a() {
        }

        @Override // c.e.c.u.m.h
        public void hiedAlertLoading() {
            RegisterFragment.this.H();
        }

        @Override // c.e.c.u.m.h
        public void showLoadingToStringRes(int i2) {
            RegisterFragment.this.z0(i2);
        }

        @Override // c.e.c.u.m.h
        public void showToastToStringRes(int i2) {
            RegisterFragment.this.F0(i2);
        }
    }

    public class b implements TextWatcher {
        public b() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            RegisterFragment.this.N1();
            RegisterFragment.this.Q1();
        }
    }

    public static RegisterFragment getInstance() {
        return new RegisterFragment();
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void J1() {
        if (this.C) {
            return;
        }
        String string = this.mNameEdt.getText().toString();
        if (x.isNullStr(string)) {
            F0(R.string.tip_name_is_empty);
            return;
        }
        String string2 = this.mPhoneEdt.getText().toString();
        if (x.isNullStr(string2)) {
            F0(R.string.tip_phone_is_empty);
            return;
        }
        boolean zIsChecked = this.mManCb.isChecked();
        boolean zIsChecked2 = this.mWomanCb.isChecked();
        if (!zIsChecked && !zIsChecked2) {
            F0(R.string.tip_sel_gender);
            return;
        }
        String string3 = this.mSmsCodeEdt.getText().toString();
        if (x.isNullStr(string3)) {
            F0(R.string.tip_sms_code_is_empty);
            return;
        }
        String string4 = this.mPwdEdt.getText().toString();
        if (x.isNullStr(string4)) {
            F0(R.string.tip_pwd_is_empty);
            return;
        }
        String string5 = this.mPwdAgainEdt.getText().toString();
        if (x.isNullStr(string5)) {
            F0(R.string.tip_again_pwd_is_empty);
            return;
        }
        if (!b0.checkPasswordIsValid(string4)) {
            F0(R.string.tip_pwd_rule_msg);
            return;
        }
        if (!b0.checkPasswordIsValid(string5)) {
            F0(R.string.tip_confirm_pwd_rule_msg);
            return;
        }
        if (!string4.equals(string5)) {
            F0(R.string.tip_again_pwd_not_equals);
            return;
        }
        if (!this.B) {
            F0(R.string.title_please_send_sms_code);
            return;
        }
        if (!this.mAgreeCb.isChecked()) {
            F0(R.string.tip_read_register_and_agree);
            return;
        }
        A0(R.string.tip_register_loading, false);
        this.C = true;
        AppRegisterVo appRegisterVo = new AppRegisterVo();
        appRegisterVo.setPhone(x.trimAll(string2));
        appRegisterVo.setPassword(string4);
        appRegisterVo.setAccount(x.trimAll(string2));
        appRegisterVo.setNickname(string.trim());
        appRegisterVo.setCode(x.trimAll(string3));
        appRegisterVo.setGender(zIsChecked ? 1 : 0);
        if (this.E == null) {
            this.D.doRegister(appRegisterVo);
            return;
        }
        NewAppRegisterVo newAppRegisterVo = new NewAppRegisterVo();
        newAppRegisterVo.setIdentifier(x.trimAll(string2));
        newAppRegisterVo.setPhone(x.trimAll(string2));
        newAppRegisterVo.setCredential(string4);
        newAppRegisterVo.setNickname(string.trim());
        newAppRegisterVo.setCode(x.trimAll(string3));
        newAppRegisterVo.setSex(zIsChecked ? 1 : 2);
        this.E.doRegister(newAppRegisterVo);
    }

    public final void K1() {
        String string = this.mPhoneEdt.getText().toString();
        if (x.isNullStr(string)) {
            F0(R.string.tip_phone_is_empty);
            return;
        }
        if (!x.isMobile(string)) {
            F0(R.string.tip_phone_is_failed);
            return;
        }
        Q1();
        this.B = true;
        this.H.sendSmsCodeToPhone(string);
        Q1();
    }

    public final void L1(RequestErrDto requestErrDto) {
        this.C = false;
        C(requestErrDto);
    }

    public final void M1(UserInfoVo userInfoVo) {
        H();
        this.J.saveUserDetailsAndCheckIsRent(userInfoVo);
        if (userInfoVo != null) {
            d0(InterestActivity.class);
        }
    }

    public final void N1() {
        this.H.setupSendSmsBtnIsEnableToPhone(this.mPhoneEdt.getText().toString());
    }

    public final void O1(String str) {
        H();
        if (x.isNullStr(this.mPhoneEdt.getText().toString())) {
            F0(R.string.tip_phone_is_empty);
        } else {
            this.B = true;
            this.H.handlerStartTimer();
        }
    }

    public final void P1() {
        this.mSplitLineTv.setVisibility(0);
        this.mTitleTv.setText(R.string.title_register);
    }

    public final void Q1() {
        String string = this.mPhoneEdt.getText().toString();
        if (x.isNullStr(string) && !x.isMobile(string)) {
            d2(false);
            return;
        }
        boolean zIsChecked = this.mManCb.isChecked();
        boolean zIsChecked2 = this.mWomanCb.isChecked();
        if (!zIsChecked && !zIsChecked2) {
            d2(false);
            return;
        }
        if (x.isNullStr(this.mSmsCodeEdt.getText().toString())) {
            d2(false);
            return;
        }
        if (x.isNullStr(this.mPwdEdt.getText().toString())) {
            d2(false);
            return;
        }
        if (x.isNullStr(this.mPwdAgainEdt.getText().toString())) {
            d2(false);
        } else if (this.mAgreeCb.isChecked()) {
            d2(this.B);
        } else {
            d2(false);
        }
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void V(View view) {
        switch (view.getId()) {
            case R.id.cb_agree /* 2131230932 */:
                Q1();
                break;
            case R.id.cb_man /* 2131230945 */:
                b2(true);
                break;
            case R.id.cb_woman /* 2131230962 */:
                b2(false);
                break;
            case R.id.tv_private_policy /* 2131232268 */:
                V1();
                break;
            case R.id.tv_protocol /* 2131232281 */:
                W1();
                break;
        }
    }

    public final void V1() {
        AppConfigExtVo appConfigExtVoO = o();
        WebFragment webFragment = WebFragment.getInstance((appConfigExtVoO == null || !x.isNotNull(appConfigExtVoO.getPrivacyPolicyUrl())) ? AlertMessageVo.PRIVACY_URL : appConfigExtVoO.getPrivacyPolicyUrl());
        webFragment.setTitle(x.getString(R.string.title_privacy_policy));
        d(webFragment, R.id.flayout_content);
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void W() {
        P1();
        a2();
        Z1();
        Y1();
    }

    public final void W1() {
        AppConfigExtVo appConfigExtVoO = o();
        WebFragment webFragment = WebFragment.getInstance((appConfigExtVoO == null || !x.isNotNull(appConfigExtVoO.getRegisterProtocolUrl())) ? AlertMessageVo.REGISTER_PROTOCOL_URL : appConfigExtVoO.getRegisterProtocolUrl());
        webFragment.setTitle(x.getString(R.string.title_register_protocol));
        d(webFragment, R.id.flayout_content);
    }

    public final void X1(UserSimpleDto userSimpleDto) {
        this.C = false;
        l0(this.mPhoneEdt.getText().toString());
        this.I.updateDeviceId(this.f6486d, true);
        this.J.saveUserSimpleAndGetUserDetails(userSimpleDto);
    }

    public final void Y1() {
        CoreBaseFragment.c cVar = new CoreBaseFragment.c(this);
        this.f6488f = cVar;
        k kVar = new k(this.mSendSmsCodeBtn, cVar, this.D);
        this.H = kVar;
        kVar.setNewUserModel(this.E);
        this.H.setIView(this.K);
        j jVar = new j(this.D);
        this.I = jVar;
        jVar.setNewUserModel(this.E);
        this.I.setIView(this.K);
        i iVar = new i(this);
        this.J = iVar;
        iVar.setIView(this.K);
        this.J.setNewUserOperateModel(this.G);
    }

    public final void Z1() {
        this.D = (UserModel) h(UserModel.class);
        this.F = (UserOperateModel) h(UserOperateModel.class);
        this.G = (NewUserOperateModel) h(NewUserOperateModel.class);
        NewUserModel newUserModel = (NewUserModel) h(NewUserModel.class);
        this.E = newUserModel;
        newUserModel.getLoginResultLiveData().observe(this, new Observer() { // from class: c.e.c.u.g
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f1857a.X1((UserSimpleDto) obj);
            }
        });
        this.E.getSmsCodeResult().observe(this, new Observer() { // from class: c.e.c.u.h
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f1858a.O1((String) obj);
            }
        });
        this.E.getErrRequestLiveData().observe(this, new Observer() { // from class: c.e.c.u.j
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f1860a.L1((RequestErrDto) obj);
            }
        });
        this.G.getUserInfoVoResult().observe(this, new Observer() { // from class: c.e.c.u.i
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f1859a.M1((UserInfoVo) obj);
            }
        });
        this.D.getSmsCodeResult().observe(this, new Observer() { // from class: c.e.c.u.h
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f1858a.O1((String) obj);
            }
        });
        this.D.getLoginResultLiveData().observe(this, new Observer() { // from class: c.e.c.u.g
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f1857a.X1((UserSimpleDto) obj);
            }
        });
        this.D.getErrRequestLiveData().observe(this, new Observer() { // from class: c.e.c.u.j
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f1860a.L1((RequestErrDto) obj);
            }
        });
        this.F.getUserInfoVoResult().observe(this, new Observer() { // from class: c.e.c.u.i
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f1859a.M1((UserInfoVo) obj);
            }
        });
    }

    public final void a2() {
        Button button = this.mSendSmsCodeBtn;
        Boolean bool = Boolean.FALSE;
        button.setTag(bool);
        this.mRegisterBtn.setTag(bool);
        this.B = false;
        this.mWomanCb.setOnClickListener(this.y);
        this.mManCb.setOnClickListener(this.y);
        this.mProtocolTv.setOnClickListener(this.y);
        this.mPrivatePolicyTv.setOnClickListener(this.y);
        this.mAgreeCb.setOnClickListener(this.y);
        this.mNameEdt.addTextChangedListener(this.L);
        this.mPhoneEdt.addTextChangedListener(this.L);
        this.mSmsCodeEdt.addTextChangedListener(this.L);
        this.mPwdEdt.addTextChangedListener(this.L);
        this.mPwdAgainEdt.addTextChangedListener(this.L);
    }

    public final void b2(boolean z) {
        this.mManCb.setChecked(z);
        this.mWomanCb.setChecked(!z);
        Q1();
    }

    public final void c2(EditText editText, View view) {
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

    public final void d2(boolean z) {
        boolean zBooleanValue = ((Boolean) this.mRegisterBtn.getTag()).booleanValue();
        q.d(getClass().getSimpleName(), "isEnable:" + z + ", cacheIsEnable:" + zBooleanValue);
        if (zBooleanValue != z) {
            this.mRegisterBtn.setTag(Boolean.valueOf(z));
            int color = getResources().getColor(R.color.color686868);
            int color2 = getResources().getColor(R.color.color_white);
            Button button = this.mRegisterBtn;
            if (z) {
                color = color2;
            }
            button.setTextColor(color);
            this.mRegisterBtn.setBackgroundResource(z ? R.drawable.login_btn_sel_bg_drawable : R.drawable.login_sms_btn_bg_drawable);
        }
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public int getLayoutId() {
        return R.layout.fragment_register;
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void j0() {
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (O()) {
            return;
        }
        g();
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        this.C = false;
    }

    @OnClick({R.id.btn_register, R.id.tv_show_pwd, R.id.tv_back, R.id.btn_send_sms})
    public void pageClick(View view) {
        if (v.getInstance().isRepeatedlyAction(view.getId())) {
            return;
        }
        switch (view.getId()) {
            case R.id.btn_register /* 2131230892 */:
                J1();
                break;
            case R.id.btn_send_sms /* 2131230905 */:
                K1();
                break;
            case R.id.tv_back /* 2131231972 */:
                n();
                break;
            case R.id.tv_show_pwd /* 2131232416 */:
                c2(this.mPwdEdt, view);
                break;
        }
    }

    @OnClick({R.id.tv_show_again_pwd})
    public void showAgainPwdClick(View view) {
        c2(this.mPwdAgainEdt, view);
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void z(Message message) {
        if (1 == message.what) {
            this.H.updateTimer();
        }
    }
}
