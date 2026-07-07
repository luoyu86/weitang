package com.chinavisionary.microtang.me.fragment;

import android.text.SpannableString;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatEditText;
import butterknife.BindView;
import butterknife.OnClick;
import c.e.a.d.x;
import com.chinavisionary.core.app.config.bo.AppConfigExtVo;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.base.BaseFragment;

/* JADX INFO: loaded from: classes.dex */
public class RollOutAlipayInputFragment extends BaseFragment {
    public String B;

    @BindView(R.id.tv_alert_tip)
    public TextView mAlertTipTv;

    @BindView(R.id.edt_alipay_account)
    public AppCompatEditText mAlipayAccountEdt;

    @BindView(R.id.edt_alipay_real_name)
    public AppCompatEditText mAlipayRealNameEdt;

    @BindView(R.id.tv_title_roll_out_price)
    public TextView mRollOutPriceTv;

    public static RollOutAlipayInputFragment getInstance(String str) {
        RollOutAlipayInputFragment rollOutAlipayInputFragment = new RollOutAlipayInputFragment();
        rollOutAlipayInputFragment.B = str;
        return rollOutAlipayInputFragment;
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void V(View view) {
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void W() {
        AppConfigExtVo appConfigExtVoO = o();
        if (appConfigExtVoO != null && x.isNotNull(appConfigExtVoO.getTransferOutTip())) {
            this.mAlertTipTv.setText(appConfigExtVoO.getTransferOutTip());
        }
        if (x.isNullStr(this.B)) {
            this.B = "";
        }
        String strAppendStringToResId = x.appendStringToResId(R.string.placeholder_roll_out_price, this.B);
        SpannableString spannableString = new SpannableString(strAppendStringToResId);
        spannableString.setSpan(new AbsoluteSizeSpan(12, true), 0, 4, 33);
        spannableString.setSpan(new AbsoluteSizeSpan(18, true), 4, this.B.length() + 5, 33);
        spannableString.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.item_room_tv_price_color)), 4, this.B.length() + 5, 33);
        spannableString.setSpan(new AbsoluteSizeSpan(12, true), this.B.length() + 5, strAppendStringToResId.length(), 33);
        this.mRollOutPriceTv.setText(spannableString);
    }

    @OnClick({R.id.btn_confirm})
    public void confirmViewClick(View view) {
        String string = this.mAlipayRealNameEdt.getText().toString();
        String string2 = this.mAlipayAccountEdt.getText().toString();
        if (x.isNullStr(string)) {
            F0(R.string.tip_name_is_empty);
        } else if (x.isNullStr(string2)) {
            F0(R.string.tip_alipay_account_is_empty);
        } else {
            g0();
            d(RollOutCheckFragment.getInstance(string, string2, this.B), R.id.flayout_content);
        }
    }

    @OnClick({R.id.view_bg})
    public void finishFragment(View view) {
        n();
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public int getLayoutId() {
        return R.layout.fragment_roll_out;
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void j0() {
    }

    @OnClick({R.id.img_btn_tip, R.id.img_alipay_roll_out_tip})
    public void openAlipayTipFragment(View view) {
        d(AlipayRollOutTipFragment.getInstance(), R.id.flayout_content);
    }
}
