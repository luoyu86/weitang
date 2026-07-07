package com.chinavisionary.microtang.settlement;

import android.os.Bundle;
import android.view.View;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.base.BaseActivity;
import com.chinavisionary.microtang.buycart.fragment.BuyCartSubmitOrderFragment;

/* JADX INFO: loaded from: classes2.dex */
public class SettlementActivity extends BaseActivity {
    @Override // com.chinavisionary.core.app.base.CoreBaseActivity
    public void U(View view) {
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseActivity
    public int getLayoutId() {
        return R.layout.activity_content;
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseActivity
    public void initView(Bundle bundle) {
        Y(BuyCartSubmitOrderFragment.getInstance(5), R.id.flayout_content);
    }
}
