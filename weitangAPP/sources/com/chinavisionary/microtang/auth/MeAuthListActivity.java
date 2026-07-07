package com.chinavisionary.microtang.auth;

import android.os.Bundle;
import android.view.View;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.auth.fragment.MeAuthListFragment;
import com.chinavisionary.microtang.base.BaseActivity;

/* JADX INFO: loaded from: classes.dex */
public class MeAuthListActivity extends BaseActivity {
    @Override // com.chinavisionary.core.app.base.CoreBaseActivity
    public void U(View view) {
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseActivity
    public int getLayoutId() {
        return R.layout.activity_content;
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseActivity
    public void initView(Bundle bundle) {
        Y(MeAuthListFragment.getInstance(), R.id.flayout_content);
    }
}
