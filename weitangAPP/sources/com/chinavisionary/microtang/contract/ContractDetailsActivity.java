package com.chinavisionary.microtang.contract;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.base.BaseActivity;
import com.chinavisionary.microtang.contract.fragment.ContractListDetailsFragment;
import me.jessyan.autosize.internal.CancelAdapt;

/* JADX INFO: loaded from: classes.dex */
public class ContractDetailsActivity extends BaseActivity implements CancelAdapt {
    @Override // com.chinavisionary.core.app.base.CoreBaseActivity
    public void U(View view) {
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseActivity
    public int getLayoutId() {
        return R.layout.activity_content;
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseActivity
    public void initView(Bundle bundle) {
        Intent intent = getIntent();
        if (intent != null) {
            String stringExtra = intent.getStringExtra("contractStateName");
            Y(ContractListDetailsFragment.getInstance(this.f6477e, intent.getIntExtra("contractState", -1), stringExtra), R.id.flayout_content);
        }
    }
}
