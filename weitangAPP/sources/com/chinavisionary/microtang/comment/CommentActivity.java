package com.chinavisionary.microtang.comment;

import android.os.Bundle;
import android.view.View;
import com.alibaba.android.arouter.launcher.ARouter;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.base.BaseActivity;
import com.chinavisionary.microtang.comment.fragment.NewCreateCommentFragment;

/* JADX INFO: loaded from: classes.dex */
public class CommentActivity extends BaseActivity {
    public boolean k;
    public String l;
    public String m;

    @Override // com.chinavisionary.core.app.base.CoreBaseActivity
    public void U(View view) {
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseActivity
    public int getLayoutId() {
        return R.layout.activity_content;
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseActivity
    public void initView(Bundle bundle) {
        String stringExtra = getIntent().getStringExtra("title");
        this.l = getIntent().getStringExtra("assetConfirmTime");
        this.m = getIntent().getStringExtra("contractKey");
        this.k = getIntent().getBooleanExtra("isOpenAssetConfirm", false);
        Z(NewCreateCommentFragment.getInstance(this.f6477e, stringExtra), R.id.flayout_content, false);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (isFinishing() && this.k) {
            ARouter.getInstance().build("/live_check/live_check").withBoolean("isFinish", true).withString("key", this.m).withBoolean("isShowAlert", this.l != null).withString("showDate", this.l).navigation();
        }
    }
}
