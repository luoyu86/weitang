package com.chinavisionary.microtang.pdf;

import android.os.Bundle;
import android.view.View;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.base.BaseActivity;

/* JADX INFO: loaded from: classes.dex */
public class PdfActivity extends BaseActivity {
    @Override // com.chinavisionary.core.app.base.CoreBaseActivity
    public void U(View view) {
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseActivity
    public int getLayoutId() {
        return R.layout.activity_content;
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseActivity
    public void initView(Bundle bundle) {
        Y(PdfFragment.getInstance(this.f6477e, getIntent().getStringExtra("titleKey")), R.id.flayout_content);
    }
}
