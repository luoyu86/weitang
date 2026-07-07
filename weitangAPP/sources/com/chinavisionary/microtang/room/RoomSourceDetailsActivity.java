package com.chinavisionary.microtang.room;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.base.BaseActivity;
import com.chinavisionary.microtang.room.fragment.RoomSourceDetailsFragment;

/* JADX INFO: loaded from: classes2.dex */
public class RoomSourceDetailsActivity extends BaseActivity {
    @Override // com.chinavisionary.core.app.base.CoreBaseActivity
    public void U(View view) {
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseActivity
    public int getLayoutId() {
        return R.layout.activity_content;
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseActivity
    public void initView(Bundle bundle) {
        Y(RoomSourceDetailsFragment.getInstance(this.f6477e, getIntent().getStringExtra("open_sign_url_key")), R.id.flayout_content);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (h0(i2, keyEvent)) {
            return true;
        }
        return super.onKeyDown(i2, keyEvent);
    }
}
