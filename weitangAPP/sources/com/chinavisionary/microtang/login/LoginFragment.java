package com.chinavisionary.microtang.login;

import android.annotation.SuppressLint;
import android.os.Message;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import androidx.lifecycle.Observer;
import butterknife.BindView;
import butterknife.OnClick;
import c.e.a.d.l;
import c.e.a.d.q;
import c.e.a.d.v;
import c.e.a.d.w;
import c.e.a.d.x;
import c.e.c.u.m.h;
import c.e.c.u.m.i;
import c.e.c.u.m.j;
import c.e.c.u.m.k;
import com.chinavisionary.core.app.base.CoreBaseFragment;
import com.chinavisionary.core.app.config.bo.AppConfigExtVo;
import com.chinavisionary.core.app.net.base.dto.RequestErrDto;
import com.chinavisionary.framework.mobile.login.dto.UserSimpleDto;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.base.BaseFragment;
import com.chinavisionary.microtang.login.bo.NewLoginBo;
import com.chinavisionary.microtang.login.bo.SpinnerVo;
import com.chinavisionary.microtang.main.event.EventBadgeMsgVo;
import com.chinavisionary.microtang.me.fragment.UpdatePhoneOrPwdFragment;
import com.chinavisionary.microtang.me.model.NewUserModel;
import com.chinavisionary.microtang.me.model.NewUserOperateModel;
import com.chinavisionary.microtang.me.model.UserModel;
import com.chinavisionary.microtang.web.WebViewActivity;
import com.chinavisionary.twlib.open.bo.AlertMessageVo;
import g.b.a.m;
import g.b.a.r;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"NonConstantResourceId"})
public class LoginFragment extends BaseFragment<String> {
    public c.e.c.u.k.a B;
    public UserModel C;
    public NewUserModel D;
    public NewUserOperateModel E;
    public j F;
    public k G;
    public i H;
    public boolean I = true;
    public final h J = new a();
    public final TextWatcher K = new d();
    public final TextWatcher L = new e();

    @BindView(R.id.cb_agree)
    public CheckBox mAgreeCb;

    @BindView(R.id.btn_login)
    public Button mLoginBtn;

    @BindView(R.id.edt_phone)
    public EditText mPhoneEdt;

    @BindView(R.id.edt_pwd)
    public EditText mPwdEdt;

    @BindView(R.id.img_pwd)
    public ImageView mPwdIconImg;

    @BindView(R.id.btn_send_sms)
    public Button mSendSmsBtn;

    @BindView(R.id.tv_show_pwd)
    public TextView mShowPwdTv;

    @BindView(R.id.tv_sms_login)
    public TextView mSmsLoginTv;

    @BindView(R.id.tv_title_split_line)
    public TextView mSplitLineTv;

    @BindView(R.id.spinner_eve)
    public Spinner mSwitchEveSpinner;

    @BindView(R.id.tv_switch_tip_msg)
    public TextView mSwitchEveTipTv;

    @BindView(R.id.tv_switch_eve)
    public TextView mSwitchEveTv;

    @BindView(R.id.tv_title)
    public TextView mTitleTv;

    public class a implements h {
        public a() {
        }

        @Override // c.e.c.u.m.h
        public void hiedAlertLoading() {
            LoginFragment.this.H();
        }

        @Override // c.e.c.u.m.h
        public void showLoadingToStringRes(int i2) {
            LoginFragment.this.z0(i2);
        }

        @Override // c.e.c.u.m.h
        public void showToastToStringRes(int i2) {
            LoginFragment.this.F0(i2);
        }
    }

    public class b implements CompoundButton.OnCheckedChangeListener {
        public b() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (z) {
                LoginFragment.this.L1();
            }
        }
    }

    public class c implements AdapterView.OnItemSelectedListener {
        public c() {
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView<?> adapterView, View view, int i2, long j) {
            int eveValue = LoginFragment.this.B.getList().get(i2).getEveValue();
            w.getInstance().putInt("app_eve", eveValue);
            if (c.e.a.d.j.getInstance().f1216b != eveValue) {
                w.getInstance().clear();
            }
            q.d(c.class.getSimpleName(), "onItemSelected mCurrentEnvironmental = " + eveValue);
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView<?> adapterView) {
        }
    }

    public class d implements TextWatcher {
        public d() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            LoginFragment.this.U1();
            LoginFragment.this.X1();
        }
    }

    public class e implements TextWatcher {
        public e() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            LoginFragment.this.L1();
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            LoginFragment.this.X1();
        }
    }

    public static LoginFragment getInstance(String str) {
        LoginFragment loginFragment = new LoginFragment();
        loginFragment.f1(str);
        return loginFragment;
    }

    public final void L1() {
        try {
            EditText editText = this.mPwdEdt;
            if (editText != null) {
                String string = editText.getText().toString();
                if (this.I && this.G.isSendSms() && x.isNotNull(string)) {
                    q.d(this.f6485c, "autoLoginSms sms = " + string);
                    if (string.trim().length() == 6) {
                        O1();
                    }
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final void M1() {
        if (!c.e.a.a.a.getInstance().isAdmin() || l.isExitFolder()) {
            return;
        }
        c.e.a.a.a.getInstance().setAdmin(false);
    }

    public final void N1() {
        c.e.c.x.c.a.getInstance().setShowWallet(false);
        c.e.c.x.c.a.getInstance().clearCacheData();
        c.e.e.a.t.b.getInstance().deleteRoomLock();
        c.e.e.a.t.b.getInstance().delRoomPwd();
        c.e.e.a.u.d.getInstance().setLockResponseVoList(null);
        c.e.e.a.u.d.getInstance().setAssetKeyPwsMap(new HashMap());
        c.e.c.m0.c.getInstance().setBillAlertMessageVo(null);
        c.e.c.m0.c.getInstance().setLateFeeAlertMessageVo(null);
    }

    public final void O1() {
        if (!this.mAgreeCb.isChecked()) {
            F0(R.string.tip_read_and_agree);
            return;
        }
        String strQ1 = Q1();
        String string = this.mPwdEdt.getText().toString();
        if (x.isNullStr(strQ1)) {
            F0(R.string.tip_phone_is_empty);
            return;
        }
        boolean z = this.mSendSmsBtn.getVisibility() == 0;
        if (x.isNullStr(string)) {
            F0(z ? R.string.tip_sms_code_is_empty : R.string.tip_pwd_is_empty);
        } else if (z) {
            this.G.performSmsCodeLogin(strQ1, string);
        } else {
            this.F.performPwdLogin(strQ1, string);
        }
    }

    public final void P1() {
        c.e.a.a.g.a.getAppManager().finishActivity(LoginActivity.class);
    }

    public final String Q1() {
        return this.mPhoneEdt.getText().toString();
    }

    public final void R1(UserSimpleDto userSimpleDto) {
        l0(Q1());
        this.F.updateDeviceId(this.f6486d, true);
        this.H.saveUserSimpleAndGetUserDetails(userSimpleDto);
    }

    public final void S1(String str) {
        H();
        if (x.isNullStr(Q1())) {
            F0(R.string.tip_phone_is_empty);
            return;
        }
        this.G.handlerStartTimer();
        this.mPhoneEdt.setEnabled(false);
        this.mPwdEdt.setFocusableInTouchMode(true);
        this.mPwdEdt.requestFocus();
        g1(this.mPhoneEdt.getText().toString());
        E0(this.mPwdEdt);
        if (c.e.a.a.a.getInstance().isDebug() && 6 == c.e.a.d.j.getInstance().f1216b) {
            this.mPwdEdt.setText("123321");
        }
    }

    public final void T1(RequestErrDto requestErrDto) {
        this.mPhoneEdt.setEnabled(true);
        C(requestErrDto);
    }

    public final void U1() {
        k kVar;
        if (!this.I || (kVar = this.G) == null) {
            return;
        }
        kVar.setupSendSmsBtnIsEnableToPhone(Q1());
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void V(View view) {
    }

    public final void V1() {
        this.f6488f = new CoreBaseFragment.c(this);
        this.C = (UserModel) h(UserModel.class);
        this.D = (NewUserModel) h(NewUserModel.class);
        this.E = (NewUserOperateModel) h(NewUserOperateModel.class);
        j jVar = new j(this.C);
        this.F = jVar;
        jVar.setNewUserModel(this.D);
        this.F.setIView(this.J);
        k kVar = new k(this.mSendSmsBtn, this.f6488f, this.C);
        this.G = kVar;
        kVar.setNewUserModel(this.D);
        this.G.setIView(this.J);
        i iVar = new i(this);
        this.H = iVar;
        iVar.setIView(this.J);
        this.H.setNewUserOperateModel(this.E);
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void W() {
        W1();
        V1();
        i2();
        U1();
        l1();
        e2();
        N1();
    }

    public final void W1() {
        h0(this);
        this.mTitleTv.setText(R.string.title_login);
        this.mSendSmsBtn.setTag(Boolean.FALSE);
        this.mSplitLineTv.setVisibility(0);
        this.mPhoneEdt.addTextChangedListener(this.K);
        this.mPwdEdt.addTextChangedListener(this.L);
        this.mPhoneEdt.setText(x.getNotNullStr(s(), ""));
        E0(this.mPhoneEdt);
        this.mAgreeCb.setOnCheckedChangeListener(new b());
        h2();
        M1();
    }

    public final void X1() {
        g2((x.isNullStr(Q1()) || x.isNullStr(this.mPwdEdt.getText().toString())) ? false : true);
    }

    public final void b2() {
        AppConfigExtVo appConfigExtVoO = o();
        String privacyPolicyUrl = (appConfigExtVoO == null || !x.isNotNull(appConfigExtVoO.getPrivacyPolicyUrl())) ? AlertMessageVo.PRIVACY_URL : appConfigExtVoO.getPrivacyPolicyUrl();
        HashMap map = new HashMap();
        map.put("key", privacyPolicyUrl);
        map.put("titleKey", x.getString(R.string.title_privacy_policy));
        b0(WebViewActivity.class, map);
    }

    public final void c2() {
        AppConfigExtVo appConfigExtVoO = o();
        String registerProtocolUrl = (appConfigExtVoO == null || !x.isNotNull(appConfigExtVoO.getRegisterProtocolUrl())) ? AlertMessageVo.REGISTER_PROTOCOL_URL : appConfigExtVoO.getRegisterProtocolUrl();
        HashMap map = new HashMap();
        map.put("key", registerProtocolUrl);
        map.put("titleKey", x.getString(R.string.title_register_protocol));
        b0(WebViewActivity.class, map);
    }

    public final void d2() {
        d(UpdatePhoneOrPwdFragment.getInstance(3), R.id.flayout_content);
    }

    public final void e2() {
        k(new EventBadgeMsgVo());
    }

    @m(threadMode = r.MAIN)
    public void eventUpdateNewPhone(c.e.c.u.l.a aVar) {
        this.mPhoneEdt.setText(aVar.getPhone());
        w.getInstance().putString(NewLoginBo.SMS_LOGIN_NAME, aVar.getPhone());
    }

    public final void f2() {
        this.G.sendSmsCodeToPhone(Q1());
    }

    public final void g2(boolean z) {
        int color = getResources().getColor(R.color.color686868);
        int color2 = getResources().getColor(R.color.color_white);
        int i2 = z ? R.drawable.login_btn_sel_bg_drawable : R.drawable.login_btn_bg_drawable;
        Button button = this.mLoginBtn;
        if (z) {
            color = color2;
        }
        button.setTextColor(color);
        this.mLoginBtn.setBackgroundResource(i2);
        this.mLoginBtn.setEnabled(z);
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public int getLayoutId() {
        return R.layout.fragment_login;
    }

    public final void h2() {
        if (c.e.a.a.a.getInstance().isTestModel()) {
            this.mSwitchEveTv.setVisibility(0);
            this.mSwitchEveTipTv.setVisibility(0);
            this.mSwitchEveSpinner.setVisibility(0);
            List<SpinnerVo> spinnerVoList = c.e.c.u.n.a.getInstance().getSpinnerVoList();
            c.e.c.u.k.a aVar = new c.e.c.u.k.a(this.f6486d);
            this.B = aVar;
            aVar.setupDataList(spinnerVoList);
            this.mSwitchEveSpinner.setAdapter((SpinnerAdapter) this.B);
            this.mSwitchEveSpinner.setSelection(c.e.c.u.n.a.getInstance().getSelectIndex(spinnerVoList));
            this.mSwitchEveSpinner.setOnItemSelectedListener(new c());
        }
    }

    public final void i2() {
        this.C.getSmsCodeResult().observe(this, new Observer() { // from class: c.e.c.u.e
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f1855a.S1((String) obj);
            }
        });
        this.C.getLoginResultLiveData().observe(this, new Observer() { // from class: c.e.c.u.f
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f1856a.R1((UserSimpleDto) obj);
            }
        });
        this.C.getErrRequestLiveData().observe(this, new Observer() { // from class: c.e.c.u.d
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f1854a.T1((RequestErrDto) obj);
            }
        });
        this.D.getLoginResultLiveData().observe(this, new Observer() { // from class: c.e.c.u.f
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f1856a.R1((UserSimpleDto) obj);
            }
        });
        this.D.getSmsCodeResult().observe(this, new Observer() { // from class: c.e.c.u.e
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f1855a.S1((String) obj);
            }
        });
        this.D.getErrRequestLiveData().observe(this, new Observer() { // from class: c.e.c.u.d
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f1854a.T1((RequestErrDto) obj);
            }
        });
        this.D.getPublicKeyAndToken();
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void j0() {
    }

    public final void j2(boolean z) {
        this.mPwdEdt.setHint(z ? R.string.hint_input_sms_code : R.string.hint_input_pwd);
        this.mPwdEdt.setTransformationMethod(z ? HideReturnsTransformationMethod.getInstance() : PasswordTransformationMethod.getInstance());
        this.mPwdEdt.setInputType(z ? 2 : 1);
        this.mShowPwdTv.setVisibility(z ? 8 : 0);
        this.mSendSmsBtn.setVisibility(z ? 0 : 8);
        this.mPwdIconImg.setImageResource(z ? R.mipmap.ic_sms_code : R.mipmap.ic_pwd);
    }

    public final void k2(EditText editText, View view) {
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

    public final void l2(View view) {
        TextView textView = (TextView) view;
        if (x.getString(R.string.title_pwd_login).equals(textView.getText().toString())) {
            this.I = false;
            textView.setText(R.string.title_sms_login);
            this.mPwdEdt.setText("");
            j2(false);
            return;
        }
        this.I = true;
        textView.setText(R.string.title_pwd_login);
        j2(true);
        U1();
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        L0(this);
        if (O()) {
            return;
        }
        g();
    }

    @OnClick({R.id.view_register_mask, R.id.tv_show_pwd, R.id.tv_back, R.id.btn_login, R.id.tv_sms_login, R.id.btn_send_sms, R.id.tv_update_phone, R.id.tv_protocol, R.id.tv_private_policy})
    @SuppressLint({"NonConstantResourceId"})
    public void pageClick(View view) {
        if (v.getInstance().isRepeatedlyAction(view.getId())) {
            return;
        }
        switch (view.getId()) {
            case R.id.btn_login /* 2131230877 */:
                O1();
                break;
            case R.id.btn_send_sms /* 2131230905 */:
                f2();
                break;
            case R.id.tv_back /* 2131231972 */:
                P1();
                break;
            case R.id.tv_private_policy /* 2131232268 */:
                b2();
                break;
            case R.id.tv_protocol /* 2131232281 */:
                c2();
                break;
            case R.id.tv_show_pwd /* 2131232416 */:
                k2(this.mPwdEdt, view);
                break;
            case R.id.tv_sms_login /* 2131232419 */:
                l2(view);
                break;
            case R.id.tv_update_phone /* 2131232491 */:
                d2();
                break;
            case R.id.view_register_mask /* 2131232569 */:
                K0(RegisterFragment.getInstance(), R.id.flayout_content);
                break;
        }
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void z(Message message) {
        int i2 = message.what;
        if (1 == i2) {
            this.G.updateTimer();
        } else if (2 == i2) {
            this.mPhoneEdt.setEnabled(true);
        }
    }
}
