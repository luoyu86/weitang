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
public class CancelAccountThreeFragment extends BaseFragment<CancelAccountItemBo> {
    public int B = -1;
    public CancelAccountItemBo C;

    @BindView(R.id.swipe_refresh_layout)
    public BaseSwipeRefreshLayout mBaseSwipeRefreshLayout;

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

    public static CancelAccountThreeFragment getInstance(CancelAccountItemBo cancelAccountItemBo) {
        CancelAccountThreeFragment cancelAccountThreeFragment = new CancelAccountThreeFragment();
        cancelAccountThreeFragment.C = cancelAccountItemBo;
        return cancelAccountThreeFragment;
    }

    private void o0() {
        this.l = false;
        this.t = new CancelAccountAdapter();
        p0(this.mBaseSwipeRefreshLayout);
        this.mBaseSwipeRefreshLayout.setEnabled(false);
        D(b.getThreeData());
        this.t.getItemCount();
        ((ViewGroup.MarginLayoutParams) this.mBaseSwipeRefreshLayout.getLayoutParams()).bottomMargin = getResources().getDimensionPixelOffset(R.dimen.dp_60);
    }

    public final void E1() {
        d(CancelAccountFragment.getInstance(this.C), R.id.flayout_content);
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void V(View view) {
        if (view.getId() == R.id.btn_submit) {
            E1();
        }
        if (view.getId() == R.id.btn_think) {
            m();
        }
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void W() {
        this.f6488f = new CoreBaseFragment.c(this);
        this.mTitleTv.setText(R.string.title_cancel_account);
        this.mSubmitBtn.setOnClickListener(this.y);
        this.mThinkBtn.setOnClickListener(this.y);
        this.mCancelPhoneTv.setText("注销 " + t());
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
