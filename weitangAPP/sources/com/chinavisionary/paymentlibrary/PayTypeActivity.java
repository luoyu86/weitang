package com.chinavisionary.paymentlibrary;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import c.e.a.d.q;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.chinavisionary.paymentlibrary.base.PaymentBaseActivity;
import com.chinavisionary.paymentlibrary.vo.PayTypeVo;

/* JADX INFO: loaded from: classes2.dex */
public class PayTypeActivity extends PaymentBaseActivity {
    @Override // com.chinavisionary.core.app.base.CoreBaseActivity
    public void U(View view) {
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseActivity
    public int getLayoutId() {
        return R.layout.payment_lib_activity_content;
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseActivity
    public void initView(Bundle bundle) {
        Intent intent = getIntent();
        if (intent != null) {
            if (intent.getBooleanExtra("play_forward_start", false)) {
                q.d(getClass().getSimpleName(), "initView isPlayForwardState");
                return;
            } else if (intent.getBooleanExtra("only_start", false)) {
                q.d(getClass().getSimpleName(), "initView isOnly = true");
                finish();
                return;
            }
        }
        String str = this.f6477e;
        if (str != null) {
            try {
                PayTypeVo payTypeVo = (PayTypeVo) JSON.parseObject(str, PayTypeVo.class);
                if (payTypeVo != null) {
                    Y(PayTypeFragment.getInstance(payTypeVo), R.id.flayout_content);
                } else {
                    e0(R.string.payment_lib_title_init_pay_failed);
                    finish();
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
                e0(R.string.payment_lib_tip_param_err);
            }
        } else {
            finish();
        }
        q.d(getClass().getSimpleName(), "initView");
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (f0(i2, keyEvent) || g0(i2, keyEvent)) {
            return true;
        }
        return super.onKeyDown(i2, keyEvent);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        q.d(getClass().getSimpleName(), "onNewIntent");
        if (intent.getBooleanExtra("play_forward_start", false)) {
            q.d(getClass().getSimpleName(), "initView isPlayForwardState");
        }
    }
}
