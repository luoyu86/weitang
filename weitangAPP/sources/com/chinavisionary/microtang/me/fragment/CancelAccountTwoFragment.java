package com.chinavisionary.microtang.me.fragment;

import android.content.Intent;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.OnClick;
import c.e.a.d.q;
import com.chinavisionary.core.app.base.CoreBaseFragment;
import com.chinavisionary.core.weight.BaseSwipeRefreshLayout;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.base.BaseFragment;
import com.chinavisionary.microtang.me.adapter.CancelAccountAdapter;
import com.chinavisionary.microtang.me.bo.CancelAccountItemBo;
import com.chinavisionary.microtang.web.bridge.BridgeWebViewActivity;

/* JADX INFO: loaded from: classes.dex */
public class CancelAccountTwoFragment extends BaseFragment<CancelAccountItemBo> {
    public CancelAccountItemBo C;

    @BindView(R.id.swipe_refresh_layout)
    public BaseSwipeRefreshLayout mBaseSwipeRefreshLayout;

    @BindView(R.id.cb_reason)
    public CheckBox mCheckBox;

    @BindView(R.id.tv_reason)
    public TextView mReasonTv;

    @BindView(R.id.btn_submit)
    public Button mSubmitBtn;

    @BindView(R.id.tv_title)
    public TextView mTitleTv;
    public int B = -1;
    public final ClickableSpan D = new b();

    public class a implements CompoundButton.OnCheckedChangeListener {
        public a() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            CancelAccountTwoFragment.this.G1(z);
        }
    }

    public class b extends ClickableSpan {
        public b() {
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            CancelAccountTwoFragment.this.H1();
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            super.updateDrawState(textPaint);
            textPaint.setColor(CancelAccountTwoFragment.this.getResources().getColor(R.color.tab_item_select_color));
            textPaint.setUnderlineText(true);
            textPaint.clearShadowLayer();
        }
    }

    public static CancelAccountTwoFragment getInstance(CancelAccountItemBo cancelAccountItemBo) {
        CancelAccountTwoFragment cancelAccountTwoFragment = new CancelAccountTwoFragment();
        cancelAccountTwoFragment.C = cancelAccountItemBo;
        return cancelAccountTwoFragment;
    }

    private void o0() {
        this.l = false;
        this.t = new CancelAccountAdapter();
        p0(this.mBaseSwipeRefreshLayout);
        D(c.e.c.x.c.b.getTwoData());
    }

    public final void G1(boolean z) {
        this.mSubmitBtn.setBackgroundResource(z ? R.drawable.bg_room_details_pre_look : R.drawable.bg_btn_disable);
    }

    public final void H1() {
        if (c.e.c.x.c.b.getCancelAccountProtocol() == null) {
            F0(R.string.tip_protocol_empty);
            return;
        }
        Intent intent = new Intent(this.f6487e, (Class<?>) BridgeWebViewActivity.class);
        intent.putExtra("titleKey", "用户注销协议");
        intent.putExtra("content", c.e.c.x.c.b.getCancelAccountProtocol());
        startActivity(intent);
    }

    public final void I1() {
        if (this.mCheckBox.isChecked()) {
            d(CancelAccountThreeFragment.getInstance(this.C), R.id.flayout_content);
        } else {
            F0(R.string.tip_check_cancel_account_protocol);
        }
    }

    public final void J1() {
        SpannableString spannableString = new SpannableString("我已阅读并同意《微棠注销协议》");
        spannableString.setSpan(this.D, 7, 15, 17);
        this.mReasonTv.setHighlightColor(getResources().getColor(R.color.tab_item_select_color));
        this.mReasonTv.setMovementMethod(LinkMovementMethod.getInstance());
        this.mReasonTv.setText(spannableString);
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void V(View view) {
        if (view.getId() == R.id.btn_submit) {
            I1();
        }
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void W() {
        this.f6488f = new CoreBaseFragment.c(this);
        this.mTitleTv.setText(R.string.title_cancel_account);
        this.mSubmitBtn.setOnClickListener(this.y);
        String remarkValue = this.C.isNeedShowRemark() ? this.C.getRemarkValue() : this.C.getReason();
        q.d(this.f6485c, "onCreateView reason = " + remarkValue);
        c.e.c.x.c.b.updateCancelAccountReason(remarkValue);
        o0();
        J1();
        G1(false);
        this.mCheckBox.setOnCheckedChangeListener(new a());
    }

    @OnClick({R.id.tv_back})
    public void clickBack() {
        n();
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public int getLayoutId() {
        return R.layout.fragment_cancel_account_two;
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void j0() {
    }
}
