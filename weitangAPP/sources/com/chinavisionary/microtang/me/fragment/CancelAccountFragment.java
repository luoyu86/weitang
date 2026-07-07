package com.chinavisionary.microtang.me.fragment;

import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.lifecycle.Observer;
import butterknife.BindView;
import butterknife.OnClick;
import c.e.a.d.q;
import c.e.a.d.x;
import com.chinavisionary.core.app.base.CoreBaseFragment;
import com.chinavisionary.core.app.net.base.dto.NewResponseStateVo;
import com.chinavisionary.core.app.net.base.dto.RequestErrDto;
import com.chinavisionary.core.app.net.base.dto.ResponseStateVo;
import com.chinavisionary.framework.mobile.login.param.SMSSendParam;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.base.BaseFragment;
import com.chinavisionary.microtang.me.CancelAccountSuccessActivity;
import com.chinavisionary.microtang.me.bo.CancelAccountItemBo;
import com.chinavisionary.microtang.me.bo.NewCancelAccountBo;
import com.chinavisionary.microtang.me.event.EventCancelAccountSuccess;
import com.chinavisionary.microtang.me.model.NewUserOperateModel;
import com.chinavisionary.view.VerificationCodeEditText;
import com.chinavisionary.view.VerificationCodeInputView;

/* JADX INFO: loaded from: classes.dex */
public class CancelAccountFragment extends BaseFragment<String> {
    public String B;
    public boolean C = false;
    public int D = 60;
    public CancelAccountItemBo E;
    public NewUserOperateModel F;

    @BindView(R.id.tv_retry_get)
    public TextView mRetryGetTv;

    @BindView(R.id.tv_send_phone_number)
    public TextView mSendPhoneNumberTv;

    @BindView(R.id.btn_login)
    public Button mSubmitBtn;

    @BindView(R.id.tv_title)
    public TextView mTitleTv;

    @BindView(R.id.verification_code_input_view)
    public VerificationCodeInputView mVerificationCodeInputView;

    public class a implements VerificationCodeInputView.a {
        public a() {
        }

        @Override // com.chinavisionary.view.VerificationCodeInputView.a
        public void complete(@NonNull String str) {
            q.d(CancelAccountFragment.this.f6485c, "complete code = " + str);
            CancelAccountFragment.this.B = str;
            CancelAccountFragment.this.I1();
        }

        @Override // com.chinavisionary.view.VerificationCodeInputView.a
        public void normalStyle(@NonNull VerificationCodeEditText verificationCodeEditText, int i2) {
        }

        @Override // com.chinavisionary.view.VerificationCodeInputView.a
        public void onTextChange(@NonNull String str) {
            CancelAccountFragment.this.B = str;
            CancelAccountFragment.this.I1();
            q.d(CancelAccountFragment.this.f6485c, "onTextChange code = " + str);
        }

        @Override // com.chinavisionary.view.VerificationCodeInputView.a
        public void selectdStyle(@NonNull VerificationCodeEditText verificationCodeEditText, int i2) {
        }
    }

    public static CancelAccountFragment getInstance(CancelAccountItemBo cancelAccountItemBo) {
        CancelAccountFragment cancelAccountFragment = new CancelAccountFragment();
        cancelAccountFragment.E = cancelAccountItemBo;
        return cancelAccountFragment;
    }

    public final void I1() {
        boolean z = x.isNotNull(this.B) && this.B.length() == 6;
        this.mSubmitBtn.setEnabled(z);
        this.mSubmitBtn.setBackgroundResource(z ? R.drawable.bg_btn_enable : R.drawable.bg_btn_disenable);
    }

    public final void J1() {
        R1();
    }

    public final void K1(ResponseStateVo responseStateVo) {
        if (!responseStateVo.isSuccess()) {
            g0();
            d(CancelAccountFailedFragment.getInstance(this.E), R.id.flayout_content);
        } else {
            Q1();
            d0(CancelAccountSuccessActivity.class);
            m();
        }
    }

    public final void L1(RequestErrDto requestErrDto) {
        if (requestErrDto != null) {
            String url = requestErrDto.getUrl();
            if (x.isNotNull(url)) {
                if (url.contains("vtapp/v1/frameworks/systems/user/send/verification/code")) {
                    C(requestErrDto);
                    this.D = 0;
                    U1();
                }
                if (url.contains("vtapp/v1/contract/rent/cancellation")) {
                    H();
                    ResponseStateVo responseStateVo = new ResponseStateVo();
                    if (x.isNullStr(requestErrDto.getErrMsg())) {
                        K1(responseStateVo);
                    } else {
                        G0(requestErrDto.getErrMsg());
                    }
                }
            }
        }
    }

    public final void M1(NewResponseStateVo newResponseStateVo) {
        if (newResponseStateVo.isSuccess()) {
            this.C = false;
            this.D = 60;
            U1();
            F0(R.string.tip_sms_code_send_success);
        } else {
            F0(R.string.title_sms_code_is_failed);
        }
        H();
    }

    public final void Q1() {
        k(new EventCancelAccountSuccess());
    }

    public final void R1() {
        z0(R.string.tip_submit_data_loading);
        SMSSendParam sMSSendParam = new SMSSendParam();
        sMSSendParam.setPhone(s());
        this.F.onlySendSmsCode(sMSSendParam);
    }

    public final void S1() {
        NewUserOperateModel newUserOperateModel = (NewUserOperateModel) h(NewUserOperateModel.class);
        this.F = newUserOperateModel;
        newUserOperateModel.getErrRequestLiveData().observeForever(new Observer() { // from class: c.e.c.x.d.f
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f2041a.L1((RequestErrDto) obj);
            }
        });
        this.F.getSmsCodeResult().observeForever(new Observer() { // from class: c.e.c.x.d.e
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f2037a.M1((NewResponseStateVo) obj);
            }
        });
        this.F.getCancelAccountLiveData().observeForever(new Observer() { // from class: c.e.c.x.d.d
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f2033a.K1((ResponseStateVo) obj);
            }
        });
        R1();
    }

    public final void T1() {
        this.mVerificationCodeInputView.setMVerificationCodeInputChildStyleListener(new a());
    }

    public final void U1() {
        int i2 = this.D - 1;
        this.D = i2;
        if (i2 > 0) {
            this.mRetryGetTv.setTextColor(getResources().getColor(R.color.color191920));
            this.mRetryGetTv.setText(x.getString(R.string.placeholder_retry_get_sms_code, String.valueOf(this.D)));
            this.f6488f.sendEmptyMessageDelayed(1, 1000L);
        } else {
            this.C = true;
            this.mRetryGetTv.setTextColor(getResources().getColor(R.color.colorFE9A02));
            this.mRetryGetTv.setText(R.string.title_retry_get_sms_code);
        }
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void V(View view) {
        if (view.getId() == R.id.btn_login) {
            V1();
        }
        if (view.getId() == R.id.tv_retry_get && this.C) {
            J1();
        }
    }

    public final void V1() {
        z0(R.string.tip_submit_data_loading);
        NewCancelAccountBo newCancelAccountBo = new NewCancelAccountBo();
        newCancelAccountBo.setCode(this.B);
        newCancelAccountBo.setPhone(s());
        newCancelAccountBo.setReason(this.E.getReasonKey());
        if (this.E.isNeedShowRemark()) {
            newCancelAccountBo.setReasonDesc(this.E.getRemarkValue());
        }
        this.F.cancelAccountNew(newCancelAccountBo);
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void W() {
        this.f6488f = new CoreBaseFragment.c(this);
        this.mTitleTv.setText(R.string.title_cancel_account);
        this.mSendPhoneNumberTv.setText(s());
        this.mSubmitBtn.setOnClickListener(this.y);
        this.mRetryGetTv.setOnClickListener(this.y);
        T1();
        S1();
    }

    @OnClick({R.id.tv_back})
    public void clickBack() {
        n();
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public int getLayoutId() {
        return R.layout.fragment_cancel_account_four;
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void j0() {
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void z(Message message) {
        super.z(message);
        if (message.what == 1) {
            U1();
        }
    }
}
