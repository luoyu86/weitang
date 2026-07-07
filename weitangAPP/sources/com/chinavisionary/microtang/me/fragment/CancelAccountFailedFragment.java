package com.chinavisionary.microtang.me.fragment;

import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.OnClick;
import c.e.c.x.c.b;
import com.chinavisionary.core.app.base.CoreBaseFragment;
import com.chinavisionary.core.weight.BaseSwipeRefreshLayout;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.base.BaseFragment;
import com.chinavisionary.microtang.me.adapter.CancelAccountAdapter;
import com.chinavisionary.microtang.me.bo.CancelAccountItemBo;

/* JADX INFO: loaded from: classes.dex */
public class CancelAccountFailedFragment extends BaseFragment<CancelAccountItemBo> {
    public CancelAccountItemBo B;

    @BindView(R.id.swipe_refresh_layout)
    public BaseSwipeRefreshLayout mBaseSwipeRefreshLayout;

    @BindView(R.id.view_bottom_bg)
    public View mBgView;

    @BindView(R.id.tv_cancel_account)
    public TextView mCancelPhoneTv;

    @BindView(R.id.btn_submit)
    public Button mSubmitBtn;

    @BindView(R.id.btn_think)
    public Button mThinkBtn;

    @BindView(R.id.img_tip_icon)
    public ImageView mTipImg;

    @BindView(R.id.tv_title)
    public TextView mTitleTv;

    public static CancelAccountFailedFragment getInstance(CancelAccountItemBo cancelAccountItemBo) {
        CancelAccountFailedFragment cancelAccountFailedFragment = new CancelAccountFailedFragment();
        cancelAccountFailedFragment.B = cancelAccountItemBo;
        return cancelAccountFailedFragment;
    }

    private void o0() {
        this.l = false;
        this.t = new CancelAccountAdapter();
        p0(this.mBaseSwipeRefreshLayout);
        this.mBaseSwipeRefreshLayout.setEnabled(false);
        D(b.getCancelFailedData());
        this.t.getItemCount();
        ((ViewGroup.MarginLayoutParams) this.mBaseSwipeRefreshLayout.getLayoutParams()).bottomMargin = getResources().getDimensionPixelOffset(R.dimen.dp_60);
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void V(View view) {
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void W() {
        this.f6488f = new CoreBaseFragment.c(this);
        this.mTitleTv.setText(R.string.title_cancel_account);
        this.mTipImg.setImageResource(R.mipmap.ic_cancel_account_failed);
        this.mThinkBtn.setVisibility(8);
        this.mBgView.setVisibility(8);
        this.mSubmitBtn.setVisibility(8);
        this.mCancelPhoneTv.setText("账号无法注销");
        o0();
    }

    @OnClick({R.id.tv_back})
    public void clickBack() {
        n();
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public int getLayoutId() {
        return R.layout.fragment_cancel_account_three;
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void j0() {
    }
}
