package com.chinavisionary.microtang.sign.fragments;

import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import androidx.lifecycle.Observer;
import butterknife.BindView;
import butterknife.OnClick;
import c.e.a.d.q;
import c.e.a.d.x;
import com.chinavisionary.core.app.base.CoreBaseFragment;
import com.chinavisionary.core.app.config.bo.AppConfigExtVo;
import com.chinavisionary.core.app.net.base.dto.RequestErrDto;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.base.BaseFragment;
import com.chinavisionary.microtang.me.model.UserOperateModel;
import com.chinavisionary.microtang.sign.model.SignRoomModel;
import com.chinavisionary.microtang.sign.view.BaseWebView;
import com.chinavisionary.microtang.sign.vo.ContactResponseVo;
import com.chinavisionary.microtang.sign.vo.CreateContractVo;
import com.chinavisionary.microtang.sign.vo.ResponseConfirmContactVo;

/* JADX INFO: loaded from: classes2.dex */
public class ContractFragment extends BaseFragment {
    public ResponseConfirmContactVo B;
    public SignRoomModel C;
    public UserOperateModel D;
    public CreateContractVo E;
    public ContactResponseVo F;
    public int G;

    @BindView(R.id.cb_agree)
    public CheckBox mAgreeCb;

    @BindView(R.id.btn_next)
    public Button mNextBtn;

    @BindView(R.id.tv_protocol_title)
    public TextView mProtocolTitleTv;

    @BindView(R.id.tv_title_split_line)
    public TextView mTitleSplitLineTv;

    @BindView(R.id.tv_title)
    public TextView mTitleTv;

    @BindView(R.id.web_view)
    public BaseWebView mWebView;

    public class a extends WebChromeClient {
        public a() {
        }

        @Override // android.webkit.WebChromeClient
        public void onProgressChanged(WebView webView, int i2) {
            super.onProgressChanged(webView, i2);
            if (i2 > 60) {
                ContractFragment.this.H();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: I1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void J1(ResponseConfirmContactVo responseConfirmContactVo) {
        H();
        if (responseConfirmContactVo.isSuccess()) {
            this.B = responseConfirmContactVo;
            O1(responseConfirmContactVo);
            return;
        }
        ResponseConfirmContactVo responseConfirmContactVo2 = this.B;
        if (responseConfirmContactVo2 != null) {
            O1(responseConfirmContactVo2);
        } else {
            G0(responseConfirmContactVo.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: K1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void L1(RequestErrDto requestErrDto) {
        H();
        G0(requestErrDto.getErrMsg());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: M1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void N1(AppConfigExtVo appConfigExtVo) {
        if (appConfigExtVo != null) {
            k0(appConfigExtVo);
            V1(false);
        }
        H();
    }

    public static ContractFragment getInstance(String str, int i2) {
        ContractFragment contractFragment = new ContractFragment();
        contractFragment.setArguments(CoreBaseFragment.q(str));
        contractFragment.setType(i2);
        return contractFragment;
    }

    public final void F1() {
        if (!this.mAgreeCb.isChecked()) {
            F0(R.string.tip_agree_checking_protocol);
            return;
        }
        ContractFragment contractFragment = getInstance(this.f6484b, 1);
        contractFragment.R1(this.E);
        contractFragment.Q1(this.F);
        d(contractFragment, R.id.flayout_content);
    }

    public final void G1() {
        if (!this.mAgreeCb.isChecked()) {
            F0(R.string.tip_agree_safety_protocol);
            return;
        }
        ContractFragment contractFragment = getInstance(this.f6484b, 2);
        contractFragment.R1(this.E);
        contractFragment.Q1(this.F);
        d(contractFragment, R.id.flayout_content);
    }

    public final int H1() {
        int i2 = this.G;
        if (i2 == 1) {
            this.mNextBtn.setText(R.string.title_confirm_sign);
            this.mProtocolTitleTv.setText(R.string.title_micro_tang_protocol);
            S1();
            return R.string.title_contract;
        }
        if (i2 == 2) {
            this.mProtocolTitleTv.setText(R.string.title_micro_tang_checking_protocol);
            this.mNextBtn.setText(R.string.title_confirm_protocol);
            V1(true);
            this.mWebView.getSettings().setTextZoom(200);
            return R.string.title_checkin_protocol;
        }
        if (i2 != 3) {
            return R.string.title_contract;
        }
        this.mNextBtn.setText(R.string.title_confirm_notice);
        this.mProtocolTitleTv.setText(R.string.title_micro_tang_safety_protocol);
        V1(false);
        this.mWebView.getSettings().setTextZoom(200);
        return R.string.title_safety_notice;
    }

    public final void O1(ResponseConfirmContactVo responseConfirmContactVo) {
        if (responseConfirmContactVo != null) {
            d(ContractDetailsFragment.getInstance(responseConfirmContactVo), R.id.flayout_content);
        }
    }

    public final void P1() {
        if (!this.mAgreeCb.isChecked()) {
            F0(R.string.tip_agree_rent_contract);
        } else {
            z0(R.string.tip_submit_data_loading);
            this.C.confirmContact(this.E);
        }
    }

    public void Q1(ContactResponseVo contactResponseVo) {
        this.F = contactResponseVo;
    }

    public void R1(CreateContractVo createContractVo) {
        this.E = createContractVo;
    }

    public final void S1() {
        this.mWebView.loadHtmlContent(this.F.getTermsText(), false);
    }

    public final void T1() {
        SignRoomModel signRoomModel = (SignRoomModel) h(SignRoomModel.class);
        this.C = signRoomModel;
        signRoomModel.getConfirmContactLiveData().observe(this, new Observer() { // from class: c.e.c.j0.b.e
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f1600a.J1((ResponseConfirmContactVo) obj);
            }
        });
        this.C.getErrRequestLiveData().observe(this, new Observer() { // from class: c.e.c.j0.b.d
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f1599a.L1((RequestErrDto) obj);
            }
        });
    }

    public final void U1() {
        this.mTitleTv.setText(H1());
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void V(View view) {
    }

    public final void V1(boolean z) {
        AppConfigExtVo appConfigExtVoO = o();
        if (appConfigExtVoO == null) {
            z0(R.string.loading_text);
            this.D.getAppConfig();
            return;
        }
        if (z) {
            String checkinProtocolUrl = x.isNotNull(appConfigExtVoO.getCheckinProtocolUrl()) ? appConfigExtVoO.getCheckinProtocolUrl() : "https://app.yuanjingweitang.com/checkInConvention.html";
            q.d(getClass().getSimpleName(), "http: " + checkinProtocolUrl);
            this.mWebView.loadUrl(checkinProtocolUrl);
            return;
        }
        String safetyNoticeUrl = x.isNotNull(appConfigExtVoO.getSafetyNoticeUrl()) ? appConfigExtVoO.getSafetyNoticeUrl() : "https://app.yuanjingweitang.com/houseSafe.html";
        q.d(getClass().getSimpleName(), "http: " + safetyNoticeUrl);
        this.mWebView.loadUrl(safetyNoticeUrl);
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void W() {
        W1();
        U1();
        z0(R.string.loading_text);
        this.mWebView.setWebChromeClient(new a());
        this.mTitleSplitLineTv.setVisibility(0);
        T1();
    }

    public final void W1() {
        UserOperateModel userOperateModel = (UserOperateModel) h(UserOperateModel.class);
        this.D = userOperateModel;
        userOperateModel.getAppConfigLiveData().observe(this, new Observer() { // from class: c.e.c.j0.b.f
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f1601a.N1((AppConfigExtVo) obj);
            }
        });
    }

    @OnClick({R.id.tv_back})
    public void backClick(View view) {
        n();
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public int getLayoutId() {
        return R.layout.fragment_contract;
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void j0() {
    }

    @OnClick({R.id.btn_next})
    public void nextClick(View view) {
        int i2 = this.G;
        if (i2 == 1) {
            P1();
        } else if (i2 == 2) {
            F1();
        } else {
            if (i2 != 3) {
                return;
            }
            G1();
        }
    }

    public void setType(int i2) {
        this.G = i2;
    }
}
