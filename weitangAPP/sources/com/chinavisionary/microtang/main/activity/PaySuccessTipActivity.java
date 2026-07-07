package com.chinavisionary.microtang.main.activity;

import android.os.Bundle;
import android.view.View;
import c.e.a.d.q;
import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.base.BaseActivity;
import com.chinavisionary.microtang.main.fragments.PaySuccessTipFragment;

/* JADX INFO: loaded from: classes.dex */
@Route(path = "/pay_success_tip/pay_success_tip")
public class PaySuccessTipActivity extends BaseActivity {

    @Autowired
    public String k;

    @Override // com.chinavisionary.core.app.base.CoreBaseActivity
    public void U(View view) {
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseActivity
    public int getLayoutId() {
        return R.layout.activity_content;
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseActivity
    public void initView(Bundle bundle) {
        ARouter.getInstance().inject(this);
        boolean booleanExtra = getIntent().getBooleanExtra("isOpenOrder", false);
        String stringExtra = getIntent().getStringExtra("orderIdKey");
        q.d("openPaySuccessTipActivity", "PaySuccessTipActivity appletJsonKey = " + this.k);
        Y(PaySuccessTipFragment.getInstance(booleanExtra, stringExtra, this.k), R.id.flayout_content);
    }
}
