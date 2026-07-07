package com.chinavisionary.microtang.me.fragment;

import android.view.View;
import butterknife.BindView;
import butterknife.OnClick;
import com.chinavisionary.core.photo.photopicker.widget.TouchImageView;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.base.BaseFragment;

/* JADX INFO: loaded from: classes.dex */
public class AlipayRollOutTipFragment extends BaseFragment {

    @BindView(R.id.img_tip)
    public TouchImageView mTouchImageView;

    public static AlipayRollOutTipFragment getInstance() {
        return new AlipayRollOutTipFragment();
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void V(View view) {
        n();
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void W() {
        this.mTouchImageView.setOnClickListener(this.y);
    }

    @OnClick({R.id.view_bg})
    public void finishFragment(View view) {
        n();
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public int getLayoutId() {
        return R.layout.fragment_alipay_tip_roll_out;
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void j0() {
    }
}
