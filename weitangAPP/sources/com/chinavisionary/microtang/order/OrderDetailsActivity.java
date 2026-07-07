package com.chinavisionary.microtang.order;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.base.BaseActivity;
import com.chinavisionary.microtang.order.fragment.OrderDetailsFragment;

/* JADX INFO: loaded from: classes.dex */
public class OrderDetailsActivity extends BaseActivity {
    @Override // com.chinavisionary.core.app.base.CoreBaseActivity
    public void U(View view) {
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseActivity
    public int getLayoutId() {
        return R.layout.activity_content;
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseActivity
    public void initView(Bundle bundle) {
        int intExtra;
        Intent intent = getIntent();
        if (intent == null || (intExtra = intent.getIntExtra("orderStateKey", -1)) == -1) {
            return;
        }
        Y(OrderDetailsFragment.getInstance(this.f6477e, intExtra), R.id.flayout_content);
    }
}
