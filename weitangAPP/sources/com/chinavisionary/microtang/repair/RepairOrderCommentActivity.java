package com.chinavisionary.microtang.repair;

import android.os.Bundle;
import android.view.View;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.base.BaseActivity;
import com.chinavisionary.microtang.repair.fragment.RepairOrderCommentFragment;

/* JADX INFO: loaded from: classes2.dex */
public class RepairOrderCommentActivity extends BaseActivity {
    @Override // com.chinavisionary.core.app.base.CoreBaseActivity
    public void U(View view) {
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseActivity
    public int getLayoutId() {
        return R.layout.activity_content;
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseActivity
    public void initView(Bundle bundle) {
        Y(RepairOrderCommentFragment.getInstance(this.f6477e), R.id.flayout_content);
    }
}
