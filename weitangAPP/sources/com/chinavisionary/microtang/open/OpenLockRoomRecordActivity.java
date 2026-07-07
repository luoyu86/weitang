package com.chinavisionary.microtang.open;

import android.os.Bundle;
import android.view.View;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.base.BaseActivity;
import com.chinavisionary.microtang.open.record.RoomOpenLockRecordListFragment;

/* JADX INFO: loaded from: classes.dex */
public class OpenLockRoomRecordActivity extends BaseActivity {
    @Override // com.chinavisionary.core.app.base.CoreBaseActivity
    public void U(View view) {
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseActivity
    public int getLayoutId() {
        return R.layout.activity_content;
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseActivity
    public void initView(Bundle bundle) {
        Y(RoomOpenLockRecordListFragment.getInstance(), R.id.flayout_content);
    }
}
