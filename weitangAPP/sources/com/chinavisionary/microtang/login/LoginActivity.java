package com.chinavisionary.microtang.login;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import androidx.fragment.app.Fragment;
import c.e.a.a.g.a;
import c.e.a.d.x;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.chinavisionary.core.app.config.bo.AppConfigExtVo;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.base.BaseActivity;
import com.chinavisionary.microtang.main.fragments.AppAlertFragment;
import com.chinavisionary.microtang.me.fragment.UpdatePhoneOrPwdFragment;
import com.chinavisionary.twlib.open.bo.AlertMessageVo;

/* JADX INFO: loaded from: classes.dex */
@Route(path = "/login/login")
public class LoginActivity extends BaseActivity {
    @Override // com.chinavisionary.core.app.base.CoreBaseActivity
    public void U(View view) {
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseActivity
    public int getLayoutId() {
        return R.layout.activity_content;
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseActivity
    public void initView(Bundle bundle) {
        Y(LoginFragment.getInstance(getIntent().getStringExtra("ErrCode")), R.id.flayout_content);
        if (O() && x.isNullStr(G())) {
            AlertMessageVo alertMessageVo = new AlertMessageVo();
            alertMessageVo.setMessageType(Integer.valueOf(AlertMessageVo.TYPE_APP_LOGIN_PROTOCOL));
            alertMessageVo.setForce(Boolean.TRUE);
            alertMessageVo.setForwardType(1);
            alertMessageVo.setTitle(x.getString(R.string.title_privacy_policy));
            alertMessageVo.setConfirmText(x.getString(R.string.title_agree));
            alertMessageVo.setCancelText(x.getString(R.string.title_not_use));
            AppConfigExtVo appConfigExtVoE = E();
            alertMessageVo.setHref((appConfigExtVoE == null || !x.isNotNull(appConfigExtVoE.getPrivacyPolicyUrl())) ? AlertMessageVo.PRIVACY_URL : appConfigExtVoE.getPrivacyPolicyUrl());
            alertMessageVo.setContent(m0());
            b(AppAlertFragment.getInstance(alertMessageVo), R.id.flayout_content, alertMessageVo.getForce().booleanValue());
        }
    }

    public final String m0() {
        return x.getString(R.string.tip_app_login_protocol);
    }

    public boolean n0() {
        Fragment fragmentFindFragmentByTag = getSupportFragmentManager().findFragmentByTag(RegisterFragment.class.getCanonicalName());
        return (fragmentFindFragmentByTag instanceof RegisterFragment) || (fragmentFindFragmentByTag instanceof UpdatePhoneOrPwdFragment);
    }

    public boolean o0() {
        return getSupportFragmentManager().findFragmentByTag(UpdatePhoneOrPwdFragment.class.getCanonicalName()) instanceof UpdatePhoneOrPwdFragment;
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() != 4) {
            return super.onKeyDown(i2, keyEvent);
        }
        if (n0() || o0()) {
            return super.onKeyDown(i2, keyEvent);
        }
        a.getAppManager().finishActivity(LoginActivity.class);
        return true;
    }
}
