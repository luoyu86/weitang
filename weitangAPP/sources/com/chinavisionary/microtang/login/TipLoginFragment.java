package com.chinavisionary.microtang.login;

import android.view.View;
import butterknife.OnClick;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.base.BaseFragment;

/* JADX INFO: loaded from: classes.dex */
public class TipLoginFragment extends BaseFragment<String> {
    public static TipLoginFragment getInstance() {
        return new TipLoginFragment();
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void V(View view) {
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void W() {
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public int getLayoutId() {
        return R.layout.fragment_tip_login_layout;
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void j0() {
    }

    @OnClick({R.id.btn_login})
    public void openLoginActivity() {
        N();
    }

    public void popSelfFragment() {
        g0();
    }
}
