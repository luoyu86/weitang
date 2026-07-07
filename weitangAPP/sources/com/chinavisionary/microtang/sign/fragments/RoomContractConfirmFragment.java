package com.chinavisionary.microtang.sign.fragments;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatButton;
import butterknife.BindView;
import butterknife.OnClick;
import c.e.a.d.x;
import com.chinavisionary.core.app.base.CoreBaseFragment;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.base.BaseFragment;
import com.chinavisionary.microtang.sign.view.BaseWebView;
import com.chinavisionary.microtang.sign.vo.ConfirmContractEvent;

/* JADX INFO: loaded from: classes2.dex */
public class RoomContractConfirmFragment extends BaseFragment {
    public int B;
    public String C;
    public String D;

    @BindView(R.id.web_view_contract)
    public BaseWebView mBaseWebView;

    @BindView(R.id.btn_confirm)
    public AppCompatButton mConfirmBtn;

    @BindView(R.id.tv_title)
    public TextView mTitleTv;

    public static RoomContractConfirmFragment getInstance(int i2, String str, String str2) {
        RoomContractConfirmFragment roomContractConfirmFragment = new RoomContractConfirmFragment();
        roomContractConfirmFragment.setArguments(CoreBaseFragment.q(str));
        roomContractConfirmFragment.G1(i2);
        roomContractConfirmFragment.setTitle(str2);
        return roomContractConfirmFragment;
    }

    public final void E1() {
        ConfirmContractEvent confirmContractEvent = new ConfirmContractEvent();
        confirmContractEvent.setPosition(this.B);
        confirmContractEvent.setConfirm(true);
        k(confirmContractEvent);
        n();
    }

    public final void F1() {
        this.mTitleTv.setText(x.getNotNullStr(this.C, x.getString(R.string.title_web)));
        this.mConfirmBtn.setText(x.appendStringToResId(R.string.placeholder_confirm, x.getNotNullStr(this.C, x.getString(R.string.title_contract))));
        this.mConfirmBtn.setOnClickListener(this.y);
    }

    public final void G1(int i2) {
        this.B = i2;
    }

    public final void H1() {
        ((ViewGroup.MarginLayoutParams) this.mBaseWebView.getLayoutParams()).topMargin = getResources().getDimensionPixelSize(R.dimen.margin_top_title_height);
        this.mBaseWebView.postInvalidate();
        if (x.isHttpUrl(this.f6484b)) {
            this.mBaseWebView.loadUrl(this.f6484b);
        } else {
            this.mBaseWebView.loadHtmlContent(x.isNullStr(this.D) ? this.f6484b : this.D, false);
        }
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void V(View view) {
        if (view.getId() == R.id.btn_confirm) {
            E1();
        }
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void W() {
        F1();
        H1();
    }

    @OnClick({R.id.tv_back})
    public void finishFragment(View view) {
        n();
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public int getLayoutId() {
        return R.layout.fragment_room_contract_confirm;
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void j0() {
    }

    public void setHtmlContent(String str) {
        this.D = str;
    }

    public final void setTitle(String str) {
        this.C = str;
    }
}
