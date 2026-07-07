package com.chinavisionary.microtang.clean;

import android.os.Bundle;
import android.view.View;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.base.BaseActivity;

/* JADX INFO: loaded from: classes.dex */
public class CleanDetailsActivity extends BaseActivity {
    @Override // com.chinavisionary.core.app.base.CoreBaseActivity
    public void U(View view) {
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseActivity
    public int getLayoutId() {
        return R.layout.activity_content;
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseActivity
    public void initView(Bundle bundle) {
        int intExtra = -1;
        try {
            intExtra = getIntent().getIntExtra("goodsType", -1);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        Y(CleanDetailsFragment.getInstance(this.f6477e, getIntent().getStringExtra("payPriceKey"), getIntent().getStringExtra("coupon_key"), intExtra), R.id.flayout_content);
    }
}
