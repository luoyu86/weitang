package com.chinavisionary.microtang.life.activity;

import android.os.Bundle;
import android.view.View;
import c.e.b.c.d.e;
import com.alibaba.fastjson.JSON;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.base.BaseActivity;
import com.chinavisionary.microtang.life.LifeGoodsListFragment;

/* JADX INFO: loaded from: classes.dex */
public class LifeGoodsListActivity extends BaseActivity {
    @Override // com.chinavisionary.core.app.base.CoreBaseActivity
    public void U(View view) {
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseActivity
    public int getLayoutId() {
        return R.layout.activity_content;
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseActivity
    public void initView(Bundle bundle) {
        Y(LifeGoodsListFragment.getInstance((e) JSON.parseObject(this.f6477e, e.class)), R.id.flayout_content);
    }
}
