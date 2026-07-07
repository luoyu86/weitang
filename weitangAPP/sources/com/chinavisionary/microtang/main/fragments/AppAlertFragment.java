package com.chinavisionary.microtang.main.fragments;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import butterknife.BindView;
import butterknife.OnClick;
import c.e.a.d.o;
import c.e.a.d.w;
import c.e.a.d.x;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.chinavisionary.core.app.config.bo.AppConfigExtVo;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.base.BaseFragment;
import com.chinavisionary.microtang.bill.BillTabActivity;
import com.chinavisionary.microtang.contract.ContractActivity;
import com.chinavisionary.microtang.me.WalletActivity;
import com.chinavisionary.microtang.me.bo.ReportClickMessageBo;
import com.chinavisionary.microtang.me.event.EventShowNotKeepRent;
import com.chinavisionary.microtang.me.model.NewUserOperateModel;
import com.chinavisionary.microtang.me.vo.FundNewsVo;
import com.chinavisionary.microtang.sign.vo.EventSwitchToMeVo;
import com.chinavisionary.microtang.vo.InitAuthSuccessVo;
import com.chinavisionary.twlib.open.bo.AlertMessageVo;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@Route(path = "/message/window")
public class AppAlertFragment extends BaseFragment {
    public boolean E;
    public boolean F;
    public AlertMessageVo G;
    public NewUserOperateModel H;

    @BindView(R.id.constraint_layout_alert)
    public ConstraintLayout mAlertLayout;

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
    public ClickableSpan I = new b();
    public ClickableSpan J = new c();

    public class a extends ClickableSpan {
        public a() {
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            AppConfigExtVo appConfigExtVoO = AppAlertFragment.this.o();
            String privacyPolicyUrl = (appConfigExtVoO == null || !x.isNotNull(appConfigExtVoO.getPrivacyPolicyUrl())) ? AlertMessageVo.PRIVACY_URL : appConfigExtVoO.getPrivacyPolicyUrl();
            AppAlertFragment appAlertFragment = AppAlertFragment.this;
            appAlertFragment.c1(Integer.valueOf(appAlertFragment.G.getForwardType()), privacyPolicyUrl, AppAlertFragment.this.G.getTitle());
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            super.updateDrawState(textPaint);
            textPaint.setColor(AppAlertFragment.this.getResources().getColor(R.color.tab_item_select_color));
            textPaint.setUnderlineText(true);
            textPaint.clearShadowLayer();
        }
    }

    public class b extends ClickableSpan {
        public b() {
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            AppAlertFragment appAlertFragment = AppAlertFragment.this;
            appAlertFragment.c1(Integer.valueOf(appAlertFragment.G.getForwardType()), AppAlertFragment.this.G.getHref(), AppAlertFragment.this.G.getTitle());
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            super.updateDrawState(textPaint);
            textPaint.setColor(AppAlertFragment.this.getResources().getColor(R.color.tab_item_select_color));
            textPaint.setUnderlineText(true);
            textPaint.clearShadowLayer();
        }
    }

    public class c extends ClickableSpan {
        public c() {
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            AppConfigExtVo appConfigExtVoO = AppAlertFragment.this.o();
            String registerProtocolUrl = (appConfigExtVoO == null || !x.isNotNull(appConfigExtVoO.getRegisterProtocolUrl())) ? AlertMessageVo.REGISTER_PROTOCOL_URL : appConfigExtVoO.getRegisterProtocolUrl();
            AppAlertFragment appAlertFragment = AppAlertFragment.this;
            appAlertFragment.c1(Integer.valueOf(appAlertFragment.G.getForwardType()), registerProtocolUrl, AppAlertFragment.this.D);
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            super.updateDrawState(textPaint);
            textPaint.setColor(AppAlertFragment.this.getResources().getColor(R.color.tab_item_select_color));
            textPaint.setUnderlineText(true);
            textPaint.clearShadowLayer();
        }
    }

    public static AppAlertFragment getInstance(AlertMessageVo alertMessageVo) {
        AppAlertFragment appAlertFragment = new AppAlertFragment();
        appAlertFragment.Q1(alertMessageVo);
        return appAlertFragment;
    }

    public final void L1(boolean z) {
        AlertMessageVo alertMessageVo = this.G;
        if (alertMessageVo == null || alertMessageVo.getForce() == null) {
            g0();
            return;
        }
        if (this.G.getMessageType() != null && this.G.getMessageType().intValue() == 0 && this.G.getForwardType() == 2000) {
            this.G.setForce(Boolean.FALSE);
            O1();
        }
        if (!this.G.getForce().booleanValue()) {
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

    public final void M1() {
        try {
            if (this.G.getMessageType() != null) {
                int iIntValue = this.G.getMessageType().intValue();
                if (iIntValue == 0) {
                    d0(BillTabActivity.class);
                    return;
                }
                if (iIntValue != 1 && iIntValue != 2) {
                    if (iIntValue == 5) {
                        c1(Integer.valueOf(this.G.getForwardType()), this.G.getHref(), this.G.getTitle());
                        return;
                    }
                    if (iIntValue == 7) {
                        k(new EventSwitchToMeVo());
                        d0(WalletActivity.class);
                        if (this.G.getForce() == null || !this.G.getForce().booleanValue()) {
                            return;
                        }
                        g0();
                        return;
                    }
                    if (iIntValue == 5900) {
                        openSettingUI(this.f6487e);
                        return;
                    }
                    if (iIntValue == 5999) {
                        w.getInstance().putBoolean("isInitAppKey", false);
                        i0(this);
                        return;
                    }
                    if (iIntValue == 6999) {
                        w.getInstance().putBoolean("isFirstLoginAppKey", false);
                        N1();
                        i0(this);
                        return;
                    }
                    if (iIntValue != 14) {
                        int i2 = 18;
                        if (iIntValue == 15) {
                            if (!x.isNotNull(this.G.getTargetMiniType()) || !FundNewsVo.TYPE_ALIPAY.equals(this.G.getTargetMiniType())) {
                                i2 = 15;
                            }
                            c1(Integer.valueOf(i2), this.G.getTargetAppid(), this.G.getTargetPath());
                            return;
                        }
                        if (iIntValue != 18) {
                            if (iIntValue != 19) {
                                return;
                            }
                            c1(Integer.valueOf(this.G.getForwardType()), this.G.getHref(), this.G.getTitle());
                            return;
                        } else {
                            if (!x.isNotNull(this.G.getTargetMiniType()) || !FundNewsVo.TYPE_ALIPAY.equals(this.G.getTargetMiniType())) {
                                i2 = 15;
                            }
                            c1(Integer.valueOf(i2), this.G.getTargetAppid(), this.G.getTargetPath());
                            return;
                        }
                    }
                }
                d0(ContractActivity.class);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final void N1() {
        if (this.E) {
            k(new InitAuthSuccessVo());
        }
    }

    public final void O1() {
        if (this.G.getForwardType() == 2000 && o.isNotEmpty(c.e.c.m0.c.getInstance().getLateFeeAlertMessageVo())) {
            List<AlertMessageVo> lateFeeAlertMessageVo = c.e.c.m0.c.getInstance().getLateFeeAlertMessageVo();
            int i2 = -1;
            int i3 = 0;
            while (true) {
                if (i3 >= lateFeeAlertMessageVo.size()) {
                    break;
                }
                if (lateFeeAlertMessageVo.get(i3).getContent().equals(this.G.getContent())) {
                    i2 = i3;
                    break;
                }
                i3++;
            }
            if (i2 >= 0) {
                lateFeeAlertMessageVo.remove(i2);
            }
        }
    }

    public final void P1(boolean z, Integer num) {
        AlertMessageVo alertMessageVo = this.G;
        if (alertMessageVo == null || !x.isNotNull(alertMessageVo.getMessageKey())) {
            return;
        }
        ReportClickMessageBo reportClickMessageBo = new ReportClickMessageBo();
        reportClickMessageBo.setPrimaryKey(this.G.getMessageKey());
        if (num != null) {
            reportClickMessageBo.setContinueRentFlag(num.intValue());
        } else {
            reportClickMessageBo.setFlag(Boolean.valueOf(z));
        }
        this.H.postClickMessageReport(reportClickMessageBo);
    }

    public final void Q1(AlertMessageVo alertMessageVo) {
        this.G = alertMessageVo;
    }

    public final void R1() {
        String content = this.G.getContent();
        int iIndexOf = content.indexOf(this.C);
        int iIndexOf2 = content.indexOf(this.D);
        int iLastIndexOf = content.lastIndexOf(this.C);
        SpannableString spannableString = new SpannableString(this.G.getContent());
        spannableString.setSpan(this.I, iIndexOf, this.C.length() + iIndexOf, 17);
        spannableString.setSpan(this.J, iIndexOf2, this.D.length() + iIndexOf2, 17);
        spannableString.setSpan(new a(), iLastIndexOf, this.C.length() + iLastIndexOf, 17);
        this.mContentTv.setHighlightColor(getResources().getColor(R.color.tab_item_select_color));
        this.mContentTv.setMovementMethod(LinkMovementMethod.getInstance());
        this.mContentTv.setText(spannableString);
    }

    public final void S1() {
        int iIndexOf = this.G.getContent().indexOf(this.B);
        SpannableString spannableString = new SpannableString(this.G.getContent());
        spannableString.setSpan(this.I, iIndexOf, this.B.length() + iIndexOf, 17);
        this.mContentTv.setHighlightColor(getResources().getColor(R.color.tab_item_select_color));
        this.mContentTv.setMovementMethod(LinkMovementMethod.getInstance());
        this.mContentTv.setText(spannableString);
    }

    public final void T1() {
        this.H = (NewUserOperateModel) h(NewUserOperateModel.class);
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void V(View view) {
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void W() {
        AlertMessageVo alertMessageVo;
        ARouter.getInstance().inject(this);
        Bundle arguments = getArguments();
        if (arguments != null) {
            try {
                if (arguments.getParcelable("alertMessageVo") != null && (alertMessageVo = (AlertMessageVo) arguments.getParcelable("alertMessageVo")) != null) {
                    this.G = alertMessageVo;
                }
            } catch (NullPointerException e2) {
                e2.printStackTrace();
            }
        }
        AlertMessageVo alertMessageVo2 = this.G;
        if (alertMessageVo2 != null) {
            if (x.isNotNull(alertMessageVo2.getCenterText())) {
                this.mAlertLayout.setVisibility(4);
                this.mRentAlertLayout.setVisibility(0);
                this.G.setForce(Boolean.TRUE);
                if (this.G.getMessageType() != null) {
                    this.F = this.G.getMessageType().intValue() == 14;
                }
                this.mRentNotThinkBtn.setVisibility(this.F ? 8 : 0);
            }
            T1();
            String title = this.G.getTitle();
            this.mTitleTv.setText(x.isNullStr(title) ? x.getString(R.string.title_alert_tip) : title);
            TextView textView = this.mRentAlertTitleTv;
            if (x.isNullStr(title)) {
                title = x.getString(R.string.title_alert_tip);
            }
            textView.setText(title);
            this.mCancelBtn.setText(this.G.getForce().booleanValue() ? x.getNotNullStr(this.G.getCancelText(), getString(R.string.title_exit_app)) : x.getNotNullStr(this.G.getCancelText(), getString(R.string.title_cancel)));
            this.mRentNotThinkBtn.setText(this.G.getForce().booleanValue() ? x.getNotNullStr(this.G.getCancelText(), getString(R.string.title_exit_app)) : x.getNotNullStr(this.G.getCancelText(), getString(R.string.title_cancel)));
            this.mConfirmBtn.setText(x.getNotNullStr(this.G.getConfirmText(), getString(R.string.title_confirm)));
            this.G.getMessageType();
            if (x.isNullStr(this.G.getHref())) {
                try {
                    if (this.G.getMessageType() != null && this.G.getMessageType().intValue() == -1) {
                        this.G.setMessageType(5);
                    }
                    if (this.G.getMessageType() == null) {
                        this.G.setMessageType(5);
                    }
                    if (5 == this.G.getMessageType().intValue()) {
                        this.mConfirmBtn.setVisibility(8);
                        this.mCancelBtn.setText(R.string.title_confirm);
                        this.mCancelBtn.setTag(Boolean.TRUE);
                        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) this.mCancelBtn.getLayoutParams();
                        ((ViewGroup.MarginLayoutParams) layoutParams).width = -1;
                        ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin = getResources().getDimensionPixelSize(R.dimen.dp_24);
                    }
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
            }
            this.mRentThinkBtn.setText(x.getNotNullStr(this.G.getCenterText(), getString(R.string.title_confirm)));
            this.mRentConfirmRenewalBtn.setText(x.getNotNullStr(this.G.getConfirmText(), getString(R.string.title_confirm)));
            String content = this.G.getContent();
            if (this.G.getMessageType() != null) {
                this.E = this.G.getMessageType().intValue() == 6999;
            }
            if (x.isNotNull(content) && content.contains(this.B)) {
                S1();
                return;
            }
            if (x.isNotNull(content) && content.contains(this.C) && this.E) {
                R1();
                return;
            }
            this.mRentAlertContentTv.setText(x.getNotNullStr(this.G.getContent(), ""));
            this.mContentTv.setText(x.getNotNullStr(this.G.getContent(), ""));
            if (x.isNullStr(this.G.getContent())) {
                this.mAlertLayout.getLayoutParams().height = this.mAlertLayout.getResources().getDimensionPixelSize(R.dimen.dp_160);
            }
        }
    }

    @OnClick({R.id.btn_alert_cancel})
    public void cancelView(View view) {
        if (view.getTag() != null) {
            P1(true, null);
        } else {
            P1(false, null);
        }
        L1(false);
    }

    @OnClick({R.id.btn_confirm_renewal})
    public void centerClickView(View view) {
        P1(true, 1);
        if (this.G != null) {
            g0();
            M1();
        }
    }

    @OnClick({R.id.view_bg})
    public void clickView(View view) {
    }

    @OnClick({R.id.btn_alert_confirm, R.id.btn_alert_center})
    public void confirmView(View view) {
        P1(true, null);
        AlertMessageVo alertMessageVo = this.G;
        if (alertMessageVo != null) {
            try {
                if (alertMessageVo.getMessageType() != null && this.G.getMessageType().intValue() == 0) {
                    this.G.setForce(Boolean.FALSE);
                    O1();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            if (this.G.getForce() != null && !this.G.getForce().booleanValue()) {
                g0();
            }
            M1();
        }
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public int getLayoutId() {
        return R.layout.fragment_alert_msg_layout;
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void j0() {
    }

    @OnClick({R.id.btn_not_think})
    public void notThinkView(View view) {
        P1(false, 0);
        L1(false);
    }

    public void openSettingUI(Activity activity) {
        activity.startActivityForResult(new Intent("android.settings.DATA_ROAMING_SETTINGS"), 22);
    }

    @OnClick({R.id.btn_think})
    public void thinkView(View view) {
        if (!this.F) {
            P1(false, 2);
            L1(false);
        } else {
            P1(false, 4);
            L1(false);
            k(new EventShowNotKeepRent());
        }
    }
}
