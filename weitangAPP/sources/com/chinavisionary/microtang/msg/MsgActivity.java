package com.chinavisionary.microtang.msg;

import android.os.Bundle;
import android.view.View;
import c.e.a.a.a;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.base.BaseActivity;
import com.chinavisionary.microtang.msg.fragment.MsgFragment;
import com.chinavisionary.microtang.web.bridge.BridgeWebViewActivity;

/* JADX INFO: loaded from: classes.dex */
public class MsgActivity extends BaseActivity {
    @Override // com.chinavisionary.core.app.base.CoreBaseActivity
    public void U(View view) {
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseActivity
    public int getLayoutId() {
        return R.layout.activity_content;
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseActivity
    public void initView(Bundle bundle) {
        if (!a.getInstance().isH5Repair()) {
            Y(MsgFragment.getInstance(), R.id.flayout_content);
        } else {
            finish();
            W(BridgeWebViewActivity.class, c.e.c.r.a.getMyMessageActivity());
        }
    }
}
