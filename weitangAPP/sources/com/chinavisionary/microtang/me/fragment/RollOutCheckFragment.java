package com.chinavisionary.microtang.me.fragment;

import android.os.Message;
import android.text.SpannableString;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.lifecycle.Observer;
import butterknife.BindView;
import butterknife.OnClick;
import c.e.a.d.x;
import com.chinavisionary.core.app.base.CoreBaseFragment;
import com.chinavisionary.core.app.event.EventUpdateUserInfoVo;
import com.chinavisionary.core.app.net.base.dto.NewResponseStateVo;
import com.chinavisionary.core.app.net.base.dto.RequestErrDto;
import com.chinavisionary.framework.mobile.login.param.SMSSendParam;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.base.BaseFragment;
import com.chinavisionary.microtang.me.bo.CreateRollOutBo;
import com.chinavisionary.microtang.me.model.NewUserOperateModel;
import com.chinavisionary.microtang.me.model.UserModel;
import com.chinavisionary.microtang.me.model.UserOperateModel;
import com.chinavisionary.microtang.me.vo.NewResponseRollOutVo;
import com.chinavisionary.microtang.me.vo.ResponseRollOutVo;
import g.b.a.c;

/* JADX INFO: loaded from: classes.dex */
public class RollOutCheckFragment extends BaseFragment {
    public int B = 60;
    public boolean C;
    public String D;
    public String E;
    public String F;
    public boolean G;
    public String H;
    public UserModel I;
    public UserOperateModel J;
    public NewUserOperateModel K;

    @BindView(R.id.tv_alipay_account)
    public TextView mAlipayAccountTv;

    @BindView(R.id.tv_alipay_real_name)
    public TextView mAlipayRealNameTv;

    @BindView(R.id.edt_account_phone)
    public AppCompatEditText mPhoneEdt;

    @BindView(R.id.edt_sms_code)
    public AppCompatEditText mPhoneSmsCodeEdt;

    @BindView(R.id.tv_title_roll_out_price)
    public TextView mRollOutPriceTv;

    @BindView(R.id.btn_send_sms)
    public AppCompatButton mSendSmsCodeBtn;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: W1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void X1(NewResponseRollOutVo newResponseRollOutVo) {
        this.K.getRollOutState(newResponseRollOutVo.getKey());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: Y1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void Z1(ResponseRollOutVo responseRollOutVo) {
        this.K.getRollOutState(responseRollOutVo.getKey());
    }

    public static RollOutCheckFragment getInstance(String str, String str2, String str3) {
        RollOutCheckFragment rollOutCheckFragment = new RollOutCheckFragment();
        rollOutCheckFragment.c2(str);
        rollOutCheckFragment.d2(str2);
        rollOutCheckFragment.F = str3;
        return rollOutCheckFragment;
    }

    public final void E1() {
        if (this.G) {
            n();
        }
    }

    public final void F1() {
        if (this.G) {
            n();
        } else {
            b2();
        }
    }

    public final void G1(RequestErrDto requestErrDto) {
        C(requestErrDto);
        i2();
        if (requestErrDto == null || !requestErrDto.getUrl().contains("vtapp/v1/account/withdraw")) {
            return;
        }
        n();
    }

    public final void H1(final NewResponseRollOutVo newResponseRollOutVo) {
        if (newResponseRollOutVo == null) {
            G0("转出失败");
        } else if (!newResponseRollOutVo.isSuccess()) {
            G0("转出失败");
        } else {
            this.H = x.bigDecimalToPlainString(newResponseRollOutVo.getWithdrawalAmount());
            this.f6488f.postDelayed(new Runnable() { // from class: c.e.c.x.d.r1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f2091a.X1(newResponseRollOutVo);
                }
            }, 1000L);
        }
    }

    public final void I1(final ResponseRollOutVo responseRollOutVo) {
        if (responseRollOutVo != null) {
            this.H = x.bigDecimalToPlainString(responseRollOutVo.getWithdrawalAmount());
            this.f6488f.postDelayed(new Runnable() { // from class: c.e.c.x.d.v1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f2107a.Z1(responseRollOutVo);
                }
            }, 1000L);
        }
    }

    public final void J1(NewResponseStateVo newResponseStateVo) {
        this.G = true;
        H();
        if (newResponseStateVo != null) {
            G0(newResponseStateVo.getMessage());
            if (newResponseStateVo.isSuccess()) {
                i2();
                A1(getString(R.string.placeholder_roll_out_success_phone_name, this.H, this.E, this.D));
            }
        }
    }

    public final void K1(String str) {
        this.G = true;
        H();
        i2();
        A1(getString(R.string.placeholder_roll_out_success_phone_name, this.H, this.E, this.D));
    }

    public final void L1() {
        z0(R.string.tip_get_sms_code_load);
        SMSSendParam sMSSendParam = new SMSSendParam();
        sMSSendParam.setPhone(s());
        this.K.sendSmsCode(sMSSendParam);
    }

    public final void M1(NewResponseStateVo newResponseStateVo) {
        if (newResponseStateVo.isSuccess()) {
            this.C = true;
            O1();
        } else {
            F0(R.string.title_sms_code_is_failed);
        }
        H();
    }

    public final void N1(String str) {
        this.C = true;
        O1();
        H();
    }

    public final void O1() {
        this.mSendSmsCodeBtn.setText(String.format(x.getString(R.string.placeholder_sms_timer), Integer.valueOf(this.B)));
        this.mSendSmsCodeBtn.setTextColor(getResources().getColor(R.color.tab_item_select_color));
        this.mSendSmsCodeBtn.setBackgroundResource(R.drawable.bg_btn_sms_code);
        CoreBaseFragment.c cVar = this.f6488f;
        if (cVar != null) {
            cVar.sendEmptyMessageDelayed(1, 1000L);
        }
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void V(View view) {
        if (M0(view)) {
            switch (view.getId()) {
                case R.id.btn_send_sms /* 2131230905 */:
                    L1();
                    break;
                case R.id.tv_alert_cancel /* 2131231941 */:
                    E1();
                    break;
                case R.id.tv_alert_confirm /* 2131231942 */:
                    F1();
                    break;
            }
        }
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void W() {
        this.mPhoneEdt.setText(t());
        this.mSendSmsCodeBtn.setOnClickListener(this.y);
        e2();
        this.mAlipayAccountTv.setText(x.appendStringToResId(R.string.placeholder_alipay_account, this.E));
        this.mAlipayRealNameTv.setText(x.appendStringToResId(R.string.placeholder_alipay_account_name, this.D));
        f2();
        g2();
    }

    public final void b2() {
        z0(R.string.tip_submit_data_loading);
        String string = this.mPhoneSmsCodeEdt.getText().toString();
        CreateRollOutBo createRollOutBo = new CreateRollOutBo();
        createRollOutBo.setVerificationCode(string);
        createRollOutBo.setAccountName(this.D);
        createRollOutBo.setWithdrawalAccount(this.E);
        this.K.rollOutBalance(createRollOutBo);
    }

    public final void c2(String str) {
        this.D = str;
    }

    @OnClick({R.id.btn_confirm})
    public void confirmViewClick(View view) {
        if (M0(view)) {
            String string = this.mPhoneSmsCodeEdt.getText().toString();
            if (!this.C) {
                F0(R.string.tip_click_send_sms_code);
            } else if (x.isNullStr(string)) {
                F0(R.string.tip_sms_code_is_empty);
            } else {
                this.G = false;
                A1(getString(R.string.placeholder_alipay_phone_name, this.E, this.D));
            }
        }
    }

    public final void d2(String str) {
        this.E = str;
    }

    public final void e2() {
        if (x.isNullStr(this.F)) {
            this.F = "";
        }
        String strAppendStringToResId = x.appendStringToResId(R.string.placeholder_roll_out_price, this.F);
        SpannableString spannableString = new SpannableString(strAppendStringToResId);
        spannableString.setSpan(new AbsoluteSizeSpan(12, true), 0, 4, 33);
        spannableString.setSpan(new AbsoluteSizeSpan(18, true), 4, this.F.length() + 5, 33);
        spannableString.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.item_room_tv_price_color)), 4, this.F.length() + 5, 33);
        spannableString.setSpan(new AbsoluteSizeSpan(12, true), this.F.length() + 5, strAppendStringToResId.length(), 33);
        this.mRollOutPriceTv.setText(spannableString);
    }

    public final void f2() {
        this.f6488f = new CoreBaseFragment.c(this);
        UserModel userModel = (UserModel) h(UserModel.class);
        this.I = userModel;
        userModel.getSmsCodeResult().observe(this, new Observer() { // from class: c.e.c.x.d.s1
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f2096a.N1((String) obj);
            }
        });
        this.I.getErrRequestLiveData().observe(this, new Observer() { // from class: c.e.c.x.d.x1
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f2114a.C((RequestErrDto) obj);
            }
        });
    }

    @OnClick({R.id.view_bg})
    public void finishFragment(View view) {
        n();
    }

    public final void g2() {
        UserOperateModel userOperateModel = (UserOperateModel) h(UserOperateModel.class);
        this.J = userOperateModel;
        userOperateModel.getRollOutResult().observe(this, new Observer() { // from class: c.e.c.x.d.p1
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f2083a.I1((ResponseRollOutVo) obj);
            }
        });
        this.J.getRollOutStateResult().observe(this, new Observer() { // from class: c.e.c.x.d.u1
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f2104a.K1((String) obj);
            }
        });
        this.J.getErrRequestLiveData().observe(this, new Observer() { // from class: c.e.c.x.d.t1
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f2100a.G1((RequestErrDto) obj);
            }
        });
        NewUserOperateModel newUserOperateModel = (NewUserOperateModel) h(NewUserOperateModel.class);
        this.K = newUserOperateModel;
        newUserOperateModel.getRollOutResult().observe(this, new Observer() { // from class: c.e.c.x.d.o1
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f2079a.H1((NewResponseRollOutVo) obj);
            }
        });
        this.K.getSmsCodeResult().observe(this, new Observer() { // from class: c.e.c.x.d.w1
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f2111a.M1((NewResponseStateVo) obj);
            }
        });
        this.K.getRollOutStateResult().observe(this, new Observer() { // from class: c.e.c.x.d.q1
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f2087a.J1((NewResponseStateVo) obj);
            }
        });
        this.K.getErrRequestLiveData().observe(this, new Observer() { // from class: c.e.c.x.d.t1
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f2100a.G1((RequestErrDto) obj);
            }
        });
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public int getLayoutId() {
        return R.layout.fragment_roll_out_check;
    }

    public final void h2() {
        CoreBaseFragment.c cVar = this.f6488f;
        if (cVar != null) {
            int i2 = this.B - 1;
            this.B = i2;
            if (i2 > 0) {
                this.mSendSmsCodeBtn.setText(String.format(x.getString(R.string.placeholder_sms_timer), Integer.valueOf(this.B)));
                this.f6488f.sendEmptyMessageDelayed(1, 1000L);
            } else {
                this.C = false;
                this.B = 60;
                cVar.removeMessages(1);
                this.mSendSmsCodeBtn.setText(R.string.title_retry_send_sms_code);
            }
        }
    }

    public final void i2() {
        EventUpdateUserInfoVo eventUpdateUserInfoVo = new EventUpdateUserInfoVo();
        eventUpdateUserInfoVo.setWhatMsg(2);
        c.getDefault().post(eventUpdateUserInfoVo);
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void j0() {
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void z(Message message) {
        if (message.what == 1) {
            h2();
        }
    }
}
