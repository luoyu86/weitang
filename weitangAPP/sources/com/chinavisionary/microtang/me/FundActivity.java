package com.chinavisionary.microtang.me;

import android.os.Bundle;
import android.view.View;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.base.BaseActivity;
import com.chinavisionary.microtang.me.fragment.FundFragment;

/* JADX INFO: loaded from: classes.dex */
public class FundActivity extends BaseActivity {
    @Override // com.chinavisionary.core.app.base.CoreBaseActivity
    public void U(View view) {
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseActivity
    public int getLayoutId() {
        return R.layout.activity_content;
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseActivity
    public void initView(Bundle bundle) {
        Y(FundFragment.getInstance(getIntent().getStringExtra("app_id"), getIntent().getStringExtra("app_page"), getIntent().getStringExtra("page_type")), R.id.flayout_content);
    }
}
