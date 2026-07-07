package com.chinavisionary.microtang.auth;

import android.os.Bundle;
import android.view.View;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.base.BaseActivity;
import com.chinavisionary.microtang.me.fragment.IDFragment;
import me.jessyan.autosize.internal.CancelAdapt;

/* JADX INFO: loaded from: classes.dex */
@Route(path = "/id_auth/id_auth")
public class IDAuthActivity extends BaseActivity implements CancelAdapt {
    @Override // com.chinavisionary.core.app.base.CoreBaseActivity
    public void U(View view) {
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseActivity
    public int getLayoutId() {
        return R.layout.activity_content;
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseActivity
    public void initView(Bundle bundle) {
        Y(IDFragment.getInstance(), R.id.flayout_content);
    }
}
