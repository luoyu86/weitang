package com.chinavisionary.microtang.community;

import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.base.BaseActivity;
import com.chinavisionary.microtang.community.fragment.CommunityActivityRecordTabFragment;

/* JADX INFO: loaded from: classes.dex */
public class CommunityActivityTabActivity extends BaseActivity {
    public final c.e.c.n.b.a k = new a();

    public class a implements c.e.c.n.b.a {
        public a() {
        }

        @Override // c.e.c.n.b.a
        public void onAddFragmentToActivity(Fragment fragment, boolean z) {
            CommunityActivityTabActivity.this.b(fragment, R.id.flayout_content, !z);
        }
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseActivity
    public void U(View view) {
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseActivity
    public int getLayoutId() {
        return R.layout.activity_content;
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseActivity
    public void initView(Bundle bundle) {
        Y(CommunityActivityRecordTabFragment.getInstance(this.k), R.id.flayout_content);
    }
}
