package com.chinavisionary.microtang.main.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import c.e.a.d.q;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.base.BaseActivity;
import com.chinavisionary.paymentlibrary.PayTypeActivity;

/* JADX INFO: loaded from: classes.dex */
public class TlPlayForwordActivty extends BaseActivity {
    @Override // com.chinavisionary.core.app.base.CoreBaseActivity
    public void U(View view) {
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseActivity
    public int getLayoutId() {
        return R.layout.activity_content;
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseActivity
    public void initView(Bundle bundle) {
        q.d("TlPlayForwordActivty", "initView");
        Intent intent = new Intent(this, (Class<?>) PayTypeActivity.class);
        intent.putExtra("play_forward_start", true);
        startActivity(intent);
        finish();
    }
}
