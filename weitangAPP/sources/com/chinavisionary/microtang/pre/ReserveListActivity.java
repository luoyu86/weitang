package com.chinavisionary.microtang.pre;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import c.e.a.a.a;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.base.BaseActivity;
import com.chinavisionary.microtang.pre.fragment.ReserveListFragment;
import com.chinavisionary.microtang.web.bridge.BridgeWebViewActivity;
import me.jessyan.autosize.internal.CancelAdapt;

/* JADX INFO: loaded from: classes.dex */
@Route(path = "/reserve_list/reserve_list")
public class ReserveListActivity extends BaseActivity implements CancelAdapt {
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
            Z(ReserveListFragment.getInstance(), R.id.flayout_content, false);
        } else {
            finish();
            W(BridgeWebViewActivity.class, c.e.c.r.a.getMyReserve());
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (h0(i2, keyEvent)) {
            return true;
        }
        return super.onKeyDown(i2, keyEvent);
    }
}
