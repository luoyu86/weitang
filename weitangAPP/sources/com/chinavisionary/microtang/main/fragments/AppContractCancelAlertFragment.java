package com.chinavisionary.microtang.main.fragments;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.Observer;
import butterknife.BindView;
import butterknife.OnClick;
import c.e.a.d.q;
import c.e.a.d.v;
import c.e.a.d.x;
import com.chinavisionary.core.app.base.CoreBaseFragment;
import com.chinavisionary.core.app.config.bo.AppConfigExtVo;
import com.chinavisionary.core.app.net.base.dto.NewResponseStateVo;
import com.chinavisionary.core.app.net.base.dto.RequestErrDto;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.base.BaseFragment;
import com.chinavisionary.microtang.main.bo.CancelContractParamBo;
import com.chinavisionary.microtang.me.event.EventShowNotKeepRent;
import com.chinavisionary.microtang.me.model.UserOperateModel;
import com.chinavisionary.microtang.sign.view.AlertBaseWebView;
import com.chinavisionary.microtang.vo.InitAuthSuccessVo;
import com.chinavisionary.twlib.open.bo.AlertMessageVo;
import com.tom_roush.pdfbox.pdmodel.interactive.form.PDButton;

/* JADX INFO: loaded from: classes.dex */
public class AppContractCancelAlertFragment extends BaseFragment<String> {
    public boolean E;
    public boolean F;
    public AlertMessageVo J;
    public UserOperateModel K;

    @BindView(R.id.constraint_layout_alert)
    public ConstraintLayout mAlertLayout;

    @BindView(R.id.web_view_content)
    public AlertBaseWebView mBaseWebView;

    @BindView(R.id.btn_alert_cancel)
    public Button mCancelBtn;

    @BindView(R.id.btn_alert_center)
    public Button mCenterBtn;

    @BindView(R.id.btn_alert_confirm)
    public Button mConfirmBtn;

    @BindView(R.id.tv_alert_content)
    public TextView mContentTv;

    @BindView(R.id.tv_content)
    public TextView mRentAlertContentTv;

    @BindView(R.id.constraint_layout_rent_alert)
    public ConstraintLayout mRentAlertLayout;

    @BindView(R.id.tv_title)
    public TextView mRentAlertTitleTv;

    @BindView(R.id.btn_confirm_renewal)
    public Button mRentConfirmRenewalBtn;

    @BindView(R.id.btn_not_think)
    public Button mRentNotThinkBtn;

    @BindView(R.id.btn_think)
    public Button mRentThinkBtn;

    @BindView(R.id.tv_alert_title)
    public TextView mTitleTv;
    public String B = "微棠隐私政策";
    public String C = "隐私政策";
    public String D = "用户协议";
    public volatile boolean G = false;
    public volatile boolean H = false;
    public int I = 5;
    public ClickableSpan L = new c();
    public ClickableSpan M = new d();

    public class a implements AlertBaseWebView.i {
        public a() {
        }

        @Override // com.chinavisionary.microtang.sign.view.AlertBaseWebView.i
        public void onScrollBottom(boolean z) {
            AppContractCancelAlertFragment.this.G = z;
            AppContractCancelAlertFragment.this.a2();
        }

        @Override // com.chinavisionary.microtang.sign.view.AlertBaseWebView.i
        public void onScrollTop() {
        }
    }

    public class b extends ClickableSpan {
        public b() {
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            AppConfigExtVo appConfigExtVoO = AppContractCancelAlertFragment.this.o();
            String privacyPolicyUrl = (appConfigExtVoO == null || !x.isNotNull(appConfigExtVoO.getPrivacyPolicyUrl())) ? AlertMessageVo.PRIVACY_URL : appConfigExtVoO.getPrivacyPolicyUrl();
            AppContractCancelAlertFragment appContractCancelAlertFragment = AppContractCancelAlertFragment.this;
            appContractCancelAlertFragment.c1(Integer.valueOf(appContractCancelAlertFragment.J.getForwardType()), privacyPolicyUrl, AppContractCancelAlertFragment.this.J.getTitle());
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            super.updateDrawState(textPaint);
            textPaint.setColor(AppContractCancelAlertFragment.this.getResources().getColor(R.color.tab_item_select_color));
            textPaint.setUnderlineText(true);
            textPaint.clearShadowLayer();
        }
    }

    public class c extends ClickableSpan {
        public c() {
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            AppContractCancelAlertFragment appContractCancelAlertFragment = AppContractCancelAlertFragment.this;
            appContractCancelAlertFragment.c1(Integer.valueOf(appContractCancelAlertFragment.J.getForwardType()), AppContractCancelAlertFragment.this.J.getHref(), AppContractCancelAlertFragment.this.J.getTitle());
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            super.updateDrawState(textPaint);
            textPaint.setColor(AppContractCancelAlertFragment.this.getResources().getColor(R.color.tab_item_select_color));
            textPaint.setUnderlineText(true);
            textPaint.clearShadowLayer();
        }
    }

    public class d extends ClickableSpan {
        public d() {
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            AppConfigExtVo appConfigExtVoO = AppContractCancelAlertFragment.this.o();
            String registerProtocolUrl = (appConfigExtVoO == null || !x.isNotNull(appConfigExtVoO.getRegisterProtocolUrl())) ? AlertMessageVo.REGISTER_PROTOCOL_URL : appConfigExtVoO.getRegisterProtocolUrl();
            AppContractCancelAlertFragment appContractCancelAlertFragment = AppContractCancelAlertFragment.this;
            appContractCancelAlertFragment.c1(Integer.valueOf(appContractCancelAlertFragment.J.getForwardType()), registerProtocolUrl, AppContractCancelAlertFragment.this.D);
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            super.updateDrawState(textPaint);
            textPaint.setColor(AppContractCancelAlertFragment.this.getResources().getColor(R.color.tab_item_select_color));
            textPaint.setUnderlineText(true);
            textPaint.clearShadowLayer();
        }
    }

    public static AppContractCancelAlertFragment getInstance(AlertMessageVo alertMessageVo) {
        AppContractCancelAlertFragment appContractCancelAlertFragment = new AppContractCancelAlertFragment();
        appContractCancelAlertFragment.U1(alertMessageVo);
        return appContractCancelAlertFragment;
    }

    public final void N1(boolean z) {
        AlertMessageVo alertMessageVo = this.J;
        if (alertMessageVo == null || alertMessageVo.getForce() == null) {
            g0();
            return;
        }
        if (!this.J.getForce().booleanValue()) {
            g0();
        } else {
            if (z) {
                return;
            }
            if (this.mRentAlertLayout.getVisibility() == 0) {
                g0();
            } else {
                m();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x00ae A[Catch: Exception -> 0x00ba, TryCatch #0 {Exception -> 0x00ba, blocks: (B:2:0x0000, B:4:0x0008, B:25:0x0037, B:26:0x004c, B:27:0x005c, B:28:0x0069, B:29:0x006f, B:31:0x0084, B:33:0x0090, B:34:0x0094, B:35:0x00ae, B:36:0x00b4), top: B:42:0x0000 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void O1() {
        /*
            r3 = this;
            com.chinavisionary.twlib.open.bo.AlertMessageVo r0 = r3.J     // Catch: java.lang.Exception -> Lba
            java.lang.Integer r0 = r0.getMessageType()     // Catch: java.lang.Exception -> Lba
            if (r0 == 0) goto Lbe
            com.chinavisionary.twlib.open.bo.AlertMessageVo r0 = r3.J     // Catch: java.lang.Exception -> Lba
            java.lang.Integer r0 = r0.getMessageType()     // Catch: java.lang.Exception -> Lba
            int r0 = r0.intValue()     // Catch: java.lang.Exception -> Lba
            if (r0 == 0) goto Lb4
            r1 = 1
            if (r0 == r1) goto Lae
            r1 = 2
            if (r0 == r1) goto Lae
            r1 = 5
            if (r0 == r1) goto L94
            r1 = 7
            if (r0 == r1) goto L6f
            r1 = 5900(0x170c, float:8.268E-42)
            if (r0 == r1) goto L69
            r1 = 5999(0x176f, float:8.406E-42)
            r2 = 0
            if (r0 == r1) goto L5c
            r1 = 6999(0x1b57, float:9.808E-42)
            if (r0 == r1) goto L4c
            r1 = 14
            if (r0 == r1) goto Lae
            r1 = 15
            if (r0 == r1) goto L37
            goto Lbe
        L37:
            java.lang.Integer r0 = java.lang.Integer.valueOf(r1)     // Catch: java.lang.Exception -> Lba
            com.chinavisionary.twlib.open.bo.AlertMessageVo r1 = r3.J     // Catch: java.lang.Exception -> Lba
            java.lang.String r1 = r1.getTargetAppid()     // Catch: java.lang.Exception -> Lba
            com.chinavisionary.twlib.open.bo.AlertMessageVo r2 = r3.J     // Catch: java.lang.Exception -> Lba
            java.lang.String r2 = r2.getTargetPath()     // Catch: java.lang.Exception -> Lba
            r3.c1(r0, r1, r2)     // Catch: java.lang.Exception -> Lba
            goto Lbe
        L4c:
            c.e.a.d.w r0 = c.e.a.d.w.getInstance()     // Catch: java.lang.Exception -> Lba
            java.lang.String r1 = "isFirstLoginAppKey"
            r0.putBoolean(r1, r2)     // Catch: java.lang.Exception -> Lba
            r3.Q1()     // Catch: java.lang.Exception -> Lba
            r3.i0(r3)     // Catch: java.lang.Exception -> Lba
            goto Lbe
        L5c:
            c.e.a.d.w r0 = c.e.a.d.w.getInstance()     // Catch: java.lang.Exception -> Lba
            java.lang.String r1 = "isInitAppKey"
            r0.putBoolean(r1, r2)     // Catch: java.lang.Exception -> Lba
            r3.i0(r3)     // Catch: java.lang.Exception -> Lba
            goto Lbe
        L69:
            android.app.Activity r0 = r3.f6487e     // Catch: java.lang.Exception -> Lba
            r3.openSettingUI(r0)     // Catch: java.lang.Exception -> Lba
            goto Lbe
        L6f:
            com.chinavisionary.microtang.sign.vo.EventSwitchToMeVo r0 = new com.chinavisionary.microtang.sign.vo.EventSwitchToMeVo     // Catch: java.lang.Exception -> Lba
            r0.<init>()     // Catch: java.lang.Exception -> Lba
            r3.k(r0)     // Catch: java.lang.Exception -> Lba
            java.lang.Class<com.chinavisionary.microtang.me.WalletActivity> r0 = com.chinavisionary.microtang.me.WalletActivity.class
            r3.d0(r0)     // Catch: java.lang.Exception -> Lba
            com.chinavisionary.twlib.open.bo.AlertMessageVo r0 = r3.J     // Catch: java.lang.Exception -> Lba
            java.lang.Boolean r0 = r0.getForce()     // Catch: java.lang.Exception -> Lba
            if (r0 == 0) goto Lbe
            com.chinavisionary.twlib.open.bo.AlertMessageVo r0 = r3.J     // Catch: java.lang.Exception -> Lba
            java.lang.Boolean r0 = r0.getForce()     // Catch: java.lang.Exception -> Lba
            boolean r0 = r0.booleanValue()     // Catch: java.lang.Exception -> Lba
            if (r0 == 0) goto Lbe
            r3.g0()     // Catch: java.lang.Exception -> Lba
            goto Lbe
        L94:
            com.chinavisionary.twlib.open.bo.AlertMessageVo r0 = r3.J     // Catch: java.lang.Exception -> Lba
            int r0 = r0.getForwardType()     // Catch: java.lang.Exception -> Lba
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch: java.lang.Exception -> Lba
            com.chinavisionary.twlib.open.bo.AlertMessageVo r1 = r3.J     // Catch: java.lang.Exception -> Lba
            java.lang.String r1 = r1.getHref()     // Catch: java.lang.Exception -> Lba
            com.chinavisionary.twlib.open.bo.AlertMessageVo r2 = r3.J     // Catch: java.lang.Exception -> Lba
            java.lang.String r2 = r2.getTitle()     // Catch: java.lang.Exception -> Lba
            r3.c1(r0, r1, r2)     // Catch: java.lang.Exception -> Lba
            goto Lbe
        Lae:
            java.lang.Class<com.chinavisionary.microtang.contract.ContractActivity> r0 = com.chinavisionary.microtang.contract.ContractActivity.class
            r3.d0(r0)     // Catch: java.lang.Exception -> Lba
            goto Lbe
        Lb4:
            java.lang.Class<com.chinavisionary.microtang.bill.BillTabActivity> r0 = com.chinavisionary.microtang.bill.BillTabActivity.class
            r3.d0(r0)     // Catch: java.lang.Exception -> Lba
            goto Lbe
        Lba:
            r0 = move-exception
            r0.printStackTrace()
        Lbe:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.chinavisionary.microtang.main.fragments.AppContractCancelAlertFragment.O1():void");
    }

    public final void P1(NewResponseStateVo newResponseStateVo) {
        H();
        if (newResponseStateVo != null) {
            if (!newResponseStateVo.isSuccess()) {
                G0(newResponseStateVo.getMessage());
            } else {
                q.d(this.f6485c, "handleSubmitResult");
                i0(this);
            }
        }
    }

    public final void Q1() {
        if (this.E) {
            k(new InitAuthSuccessVo());
        }
    }

    public final synchronized void T1(boolean z, Integer num) {
        if (!v.getInstance().isRepeatedlyAction("reportClickMessage", 500)) {
            AlertMessageVo alertMessageVo = this.J;
            if (alertMessageVo != null) {
                x.isNotNull(alertMessageVo.getMessageKey());
            }
            if (this.H) {
                if (this.G) {
                    z0(R.string.tip_submit_data_loading);
                    CancelContractParamBo cancelContractParamBo = new CancelContractParamBo();
                    cancelContractParamBo.setMessageKey(this.J.getMessageKey());
                    cancelContractParamBo.setCancelStatus(Integer.valueOf(z ? 1 : 2));
                    this.K.postCancelContractAlertMessageList(cancelContractParamBo);
                } else {
                    F0(R.string.tip_conent_scroll_bottom);
                }
            }
            q.d(this.f6485c, "reportClickMessage isRepeatedlyAction isConfirm = " + z);
        }
        q.d(this.f6485c, "reportClickMessage isConfirm = " + z);
    }

    public final void U1(AlertMessageVo alertMessageVo) {
        this.J = alertMessageVo;
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void V(View view) {
        if (view.getId() == R.id.btn_alert_cancel) {
            T1(false, null);
        }
        if (view.getId() == R.id.btn_alert_confirm) {
            T1(true, null);
        }
    }

    public final void V1() {
        String content = this.J.getContent();
        int iIndexOf = content.indexOf(this.C);
        int iIndexOf2 = content.indexOf(this.D);
        int iLastIndexOf = content.lastIndexOf(this.C);
        SpannableString spannableString = new SpannableString(this.J.getContent());
        spannableString.setSpan(this.L, iIndexOf, this.C.length() + iIndexOf, 17);
        spannableString.setSpan(this.M, iIndexOf2, this.D.length() + iIndexOf2, 17);
        spannableString.setSpan(new b(), iLastIndexOf, this.C.length() + iLastIndexOf, 17);
        this.mContentTv.setHighlightColor(getResources().getColor(R.color.tab_item_select_color));
        this.mContentTv.setMovementMethod(LinkMovementMethod.getInstance());
        this.mContentTv.setText(spannableString);
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void W() {
        AlertMessageVo alertMessageVo;
        Bundle arguments = getArguments();
        if (arguments != null) {
            try {
                if (arguments.getParcelable("alertMessageVo") != null && (alertMessageVo = (AlertMessageVo) arguments.getParcelable("alertMessageVo")) != null) {
                    this.J = alertMessageVo;
                }
            } catch (NullPointerException e2) {
                e2.printStackTrace();
            }
        }
        this.f6488f = new CoreBaseFragment.c(this);
        AlertMessageVo alertMessageVo2 = this.J;
        if (alertMessageVo2 != null) {
            this.I = alertMessageVo2.getCountDownTime();
            this.mCancelBtn.setOnClickListener(this.y);
            this.mConfirmBtn.setOnClickListener(this.y);
            if (x.isNotNull(this.J.getCenterText())) {
                this.mAlertLayout.setVisibility(4);
                this.mRentAlertLayout.setVisibility(0);
                this.J.setForce(Boolean.TRUE);
                if (this.J.getMessageType() != null) {
                    this.F = this.J.getMessageType().intValue() == 14;
                }
                this.mRentNotThinkBtn.setVisibility(this.F ? 8 : 0);
            }
            X1();
            String title = this.J.getTitle();
            this.mTitleTv.setText(x.isNullStr(title) ? x.getString(R.string.title_alert_tip) : title);
            TextView textView = this.mRentAlertTitleTv;
            if (x.isNullStr(title)) {
                title = x.getString(R.string.title_alert_tip);
            }
            textView.setText(title);
            this.mRentNotThinkBtn.setText(this.J.getForce().booleanValue() ? x.getNotNullStr(this.J.getCancelText(), getString(R.string.title_exit_app)) : x.getNotNullStr(this.J.getCancelText(), getString(R.string.title_cancel)));
            String str = this.J.getConfirmText() + "(" + this.I + ")";
            String str2 = this.J.getCancelText() + "(" + this.I + ")";
            this.mConfirmBtn.setText(str);
            this.mCancelBtn.setText(str2);
            String content = this.J.getContent();
            if (this.J.getMessageType() != null) {
                this.E = this.J.getMessageType().intValue() == 6999;
            }
            if (x.isNotNull(content) && content.contains(this.B)) {
                W1();
                return;
            }
            if (x.isNotNull(content) && content.contains(this.C) && this.E) {
                V1();
                return;
            }
            this.mBaseWebView.setOnWebViewScrollListener(new a());
            Y1();
            this.mBaseWebView.getSettings().setBuiltInZoomControls(true);
            this.mBaseWebView.setVerticalScrollBarEnabled(true);
            this.mBaseWebView.setScrollbarFadingEnabled(false);
            this.mBaseWebView.setScrollBarStyle(PDButton.FLAG_RADIOS_IN_UNISON);
            this.mBaseWebView.loadHtmlContractContent(x.getNotNullStr(this.J.getContent(), ""), false, "60", "60", "#F6F6F6", "#555555", "60");
            int scrollBarSize = this.mBaseWebView.getScrollBarSize();
            this.mBaseWebView.getHeight();
            int contentHeight = scrollBarSize + this.mBaseWebView.getContentHeight();
        }
    }

    public final void W1() {
        int iIndexOf = this.J.getContent().indexOf(this.B);
        SpannableString spannableString = new SpannableString(this.J.getContent());
        spannableString.setSpan(this.L, iIndexOf, this.B.length() + iIndexOf, 17);
        this.mContentTv.setHighlightColor(getResources().getColor(R.color.tab_item_select_color));
        this.mContentTv.setMovementMethod(LinkMovementMethod.getInstance());
        this.mContentTv.setText(spannableString);
    }

    public final void X1() {
        UserOperateModel userOperateModel = (UserOperateModel) h(UserOperateModel.class);
        this.K = userOperateModel;
        userOperateModel.getErrRequestLiveData().observeForever(new Observer() { // from class: c.e.c.v.e.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f1896a.C((RequestErrDto) obj);
            }
        });
        this.K.getSubmitCancelResult().observeForever(new Observer() { // from class: c.e.c.v.e.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f1898a.P1((NewResponseStateVo) obj);
            }
        });
    }

    public final void Y1() {
        if (this.I <= 0) {
            this.H = true;
        } else {
            Z1();
            this.f6488f.sendEmptyMessageDelayed(234, 1000L);
        }
    }

    public final void Z1() {
        CoreBaseFragment.c cVar = this.f6488f;
        if (cVar != null) {
            cVar.removeMessages(234);
        }
    }

    public final synchronized void a2() {
        int color = getResources().getColor((this.G && this.H) ? R.color.tab_item_select_color : R.color.color999999);
        this.mConfirmBtn.setTextColor(color);
        this.mCancelBtn.setTextColor(color);
    }

    @OnClick({R.id.btn_confirm_renewal})
    public void centerClickView(View view) {
        T1(true, 1);
        if (this.J != null) {
            g0();
            O1();
        }
    }

    @OnClick({R.id.view_bg})
    public void clickView(View view) {
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public int getLayoutId() {
        return R.layout.fragment_alert_cancel_contract_layout;
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void j0() {
    }

    @OnClick({R.id.btn_not_think})
    public void notThinkView(View view) {
        T1(false, 0);
        N1(false);
    }

    public void openSettingUI(Activity activity) {
        activity.startActivityForResult(new Intent("android.settings.DATA_ROAMING_SETTINGS"), 22);
    }

    @OnClick({R.id.btn_think})
    public void thinkView(View view) {
        if (!this.F) {
            T1(false, 2);
            N1(false);
        } else {
            T1(false, 4);
            N1(false);
            k(new EventShowNotKeepRent());
        }
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void z(Message message) {
        super.z(message);
        if (message.what == 234) {
            if (this.I > 0) {
                String str = this.J.getConfirmText() + "(" + this.I + "s)";
                String str2 = this.J.getCancelText() + "(" + this.I + "s)";
                this.mConfirmBtn.setText(str);
                this.mCancelBtn.setText(str2);
                Y1();
            } else {
                this.H = true;
                this.mConfirmBtn.setText(this.J.getConfirmText());
                this.mCancelBtn.setText(this.J.getCancelText());
                this.G = this.mBaseWebView.isWebViewAtBottom();
                q.d(this.f6485c, "hasVerticalScrollbar = " + this.mBaseWebView.isWebViewAtBottom());
                a2();
            }
            this.I--;
        }
    }
}
