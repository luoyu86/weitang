package com.chinavisionary.twlib.open.base;

import com.alibaba.android.arouter.launcher.ARouter;
import com.chinavisionary.core.app.base.CoreBaseActivity;

/* JADX INFO: loaded from: classes2.dex */
public abstract class TwBaseActivity extends CoreBaseActivity {
    public void f0(int i2, String str, String str2) {
        ARouter.getInstance().build("/forward/forward").withString("title", str2).withString("href", str).withInt("forwardType", i2).navigation();
    }
}
