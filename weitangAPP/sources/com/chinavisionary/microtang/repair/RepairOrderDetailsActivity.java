package com.chinavisionary.microtang.repair;

import android.os.Bundle;
import android.view.View;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.base.BaseActivity;
import com.chinavisionary.microtang.repair.fragment.RepairOrderDetailsFragment;

/* JADX INFO: loaded from: classes2.dex */
public class RepairOrderDetailsActivity extends BaseActivity {
    @Override // com.chinavisionary.core.app.base.CoreBaseActivity
    public void U(View view) {
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseActivity
    public int getLayoutId() {
        return R.layout.activity_content;
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseActivity
    public void initView(Bundle bundle) {
        Y(RepairOrderDetailsFragment.getInstance(this.f6477e, getIntent().getIntExtra("status", -1)), R.id.flayout_content);
    }
}
