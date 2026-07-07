package com.chinavisionary.microtang.bill;

import android.os.Bundle;
import android.view.View;
import c.e.a.a.a;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.base.BaseActivity;
import com.chinavisionary.microtang.bill.fragment.BillTabFragment;
import com.chinavisionary.microtang.web.bridge.BridgeWebViewActivity;

/* JADX INFO: loaded from: classes.dex */
@Route(path = "/bill_tab/bill_tab")
public class BillTabActivity extends BaseActivity {
    @Override // com.chinavisionary.core.app.base.CoreBaseActivity
    public void U(View view) {
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseActivity
    public int getLayoutId() {
        return R.layout.activity_content;
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseActivity
    public void initView(Bundle bundle) {
        if (!a.getInstance().isH5Model()) {
            Y(BillTabFragment.getInstance(getIntent().getIntExtra(RequestParameters.POSITION, 0)), R.id.flayout_content);
        } else {
            finish();
            W(BridgeWebViewActivity.class, c.e.c.r.a.getMyBill());
        }
    }
}
