package com.chinavisionary.paymentlibrary.base;

import android.os.Bundle;
import android.view.KeyEvent;
import androidx.fragment.app.Fragment;
import c.e.a.a.a;
import com.alipay.sdk.app.EnvUtils;
import com.chinavisionary.core.app.base.CoreBaseActivity;
import com.chinavisionary.paymentlibrary.FragmentPay;
import com.chinavisionary.paymentlibrary.PayTypeFragment;

/* JADX INFO: loaded from: classes2.dex */
public abstract class PaymentBaseActivity extends CoreBaseActivity {
    public boolean f0(int i2, KeyEvent keyEvent) {
        Fragment fragmentFindFragmentByTag = getSupportFragmentManager().findFragmentByTag(FragmentPay.class.getCanonicalName());
        if (fragmentFindFragmentByTag instanceof FragmentPay) {
            return ((FragmentPay) fragmentFindFragmentByTag).onKeyDown(i2, keyEvent);
        }
        return false;
    }

    public boolean g0(int i2, KeyEvent keyEvent) {
        Fragment fragmentFindFragmentByTag = getSupportFragmentManager().findFragmentByTag(PayTypeFragment.class.getCanonicalName());
        if ((fragmentFindFragmentByTag instanceof PayTypeFragment) && getSupportFragmentManager().getBackStackEntryCount() == 0) {
            return ((PayTypeFragment) fragmentFindFragmentByTag).onKeyDown(i2, keyEvent);
        }
        return false;
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (a.getInstance().isSandBoxDebug()) {
            EnvUtils.setEnv(EnvUtils.EnvEnum.SANDBOX);
        }
    }
}
