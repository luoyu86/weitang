package com.chinavisionary.microtang.base;

import android.os.Bundle;
import android.view.View;
import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;

/* JADX INFO: loaded from: classes.dex */
@Route(path = "/forward/forward")
public class ForwardActivity extends BaseActivity {

    @Autowired
    public String k;

    @Autowired
    public int l;

    @Autowired
    public String m;

    @Override // com.chinavisionary.core.app.base.CoreBaseActivity
    public void U(View view) {
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseActivity
    public int getLayoutId() {
        return 0;
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseActivity
    public void initView(Bundle bundle) {
        ARouter.getInstance().inject(this);
        finish();
        g0(this.l, this.m, this.k);
    }
}
