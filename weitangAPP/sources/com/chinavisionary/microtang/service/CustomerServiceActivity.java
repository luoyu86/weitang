package com.chinavisionary.microtang.service;

import android.os.Bundle;
import android.view.View;
import c.e.a.a.a;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.base.BaseActivity;
import com.chinavisionary.microtang.service.fragment.CustomerServiceMainFragment;
import com.chinavisionary.microtang.web.bridge.BridgeWebViewActivity;

/* JADX INFO: loaded from: classes2.dex */
public class CustomerServiceActivity extends BaseActivity {
    @Override // com.chinavisionary.core.app.base.CoreBaseActivity
    public void U(View view) {
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseActivity
    public int getLayoutId() {
        return R.layout.activity_content;
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseActivity
    public void initView(Bundle bundle) {
        if (!a.getInstance().isH5Repair()) {
            Y(CustomerServiceMainFragment.getInstance(), R.id.flayout_content);
            return;
        }
        finish();
        if (a.getInstance().isIMModel()) {
            W(BridgeWebViewActivity.class, c.e.c.r.a.getIMUrl());
        } else {
            W(BridgeWebViewActivity.class, c.e.c.r.a.getMyServiceActivity());
        }
    }
}
