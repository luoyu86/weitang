package com.chinavisionary.microtang.me.fragment;

import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import c.e.a.d.x;
import com.chinavisionary.core.app.base.CoreBaseFragment;
import com.chinavisionary.core.weight.BaseSwipeRefreshLayout;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.base.BaseFragment;
import com.chinavisionary.microtang.me.bo.CancelAccountItemBo;

/* JADX INFO: loaded from: classes.dex */
public class CancelAccountSuccessFragment extends BaseFragment<CancelAccountItemBo> {
    public int B = 5;

    @BindView(R.id.img_back)
    public ImageView mBackImg;

    @BindView(R.id.tv_back)
    public TextView mBackTv;

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

    @BindView(R.id.tv_cancel_account_timer)
    public TextView mTimerTv;

    @BindView(R.id.img_tip_icon)
    public ImageView mTipImg;

    @BindView(R.id.tv_title)
    public TextView mTitleTv;

    public static CancelAccountSuccessFragment getInstance() {
        return new CancelAccountSuccessFragment();
    }

    private void o0() {
        this.l = false;
        p0(this.mBaseSwipeRefreshLayout);
        this.mBaseSwipeRefreshLayout.setVisibility(8);
    }

    public final void E1() {
        int i2 = this.B - 1;
        this.B = i2;
        this.mTimerTv.setText(x.getString(R.string.placeholder_auto_exit, String.valueOf(i2)));
        if (this.B > 0) {
            this.f6488f.sendEmptyMessageDelayed(1, 1000L);
        } else {
            n();
        }
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void V(View view) {
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void W() {
        this.f6488f = new CoreBaseFragment.c(this);
        this.mTitleTv.setText(R.string.title_cancel_account);
        this.mTipImg.setImageResource(R.mipmap.ic_cancel_account_success);
        this.mThinkBtn.setVisibility(8);
        this.mSubmitBtn.setVisibility(8);
        this.mBgView.setVisibility(8);
        this.mBackImg.setVisibility(8);
        this.mBackTv.setVisibility(4);
        this.mTimerTv.setVisibility(0);
        this.mCancelPhoneTv.setText(R.string.title_cancel_account_success);
        o0();
        this.mTimerTv.setText(x.getString(R.string.placeholder_auto_exit, String.valueOf(this.B)));
        this.f6488f.sendEmptyMessageDelayed(1, 1000L);
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public int getLayoutId() {
        return R.layout.fragment_cancel_account_three;
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void j0() {
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void z(Message message) {
        super.z(message);
        if (message.what == 1) {
            E1();
        }
    }
}
