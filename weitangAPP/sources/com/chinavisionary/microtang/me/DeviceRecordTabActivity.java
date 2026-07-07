package com.chinavisionary.microtang.me;

import android.os.Bundle;
import android.view.View;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.base.BaseActivity;
import com.chinavisionary.microtang.me.fragment.WaterAndElectricRecordTabFragment;

/* JADX INFO: loaded from: classes.dex */
public class DeviceRecordTabActivity extends BaseActivity {
    @Override // com.chinavisionary.core.app.base.CoreBaseActivity
    public void U(View view) {
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseActivity
    public int getLayoutId() {
        return R.layout.activity_content;
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseActivity
    public void initView(Bundle bundle) {
        Y(WaterAndElectricRecordTabFragment.getInstance(), R.id.flayout_content);
    }
}
