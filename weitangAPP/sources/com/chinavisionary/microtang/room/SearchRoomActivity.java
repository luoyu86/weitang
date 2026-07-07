package com.chinavisionary.microtang.room;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import androidx.fragment.app.Fragment;
import c.e.a.d.x;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.base.BaseActivity;
import com.chinavisionary.microtang.room.fragment.SearchRoomFragment;
import com.chinavisionary.paymentlibrary.PayTypeFragment;
import me.jessyan.autosize.internal.CancelAdapt;

/* JADX INFO: loaded from: classes2.dex */
public class SearchRoomActivity extends BaseActivity implements CancelAdapt {
    @Override // com.chinavisionary.core.app.base.CoreBaseActivity
    public void U(View view) {
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseActivity
    public int getLayoutId() {
        return R.layout.activity_content;
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseActivity
    public void initView(Bundle bundle) {
        SearchRoomFragment searchRoomFragment = SearchRoomFragment.getInstance();
        if (getIntent() != null) {
            String stringExtra = getIntent().getStringExtra("key");
            if (x.isNotNull(stringExtra)) {
                boolean booleanExtra = getIntent().getBooleanExtra("extendOldRentFlag", false);
                Long lValueOf = Long.valueOf(getIntent().getLongExtra("extendOldRentDateFlag", -1L));
                searchRoomFragment.setContractKey(stringExtra);
                searchRoomFragment.setExtendOldRentFlag(Boolean.valueOf(booleanExtra));
                searchRoomFragment.setBackRentDate(lValueOf);
            }
        }
        Y(searchRoomFragment, R.id.flayout_content);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        Fragment fragmentFindFragmentByTag = getSupportFragmentManager().findFragmentByTag(PayTypeFragment.class.getCanonicalName());
        return fragmentFindFragmentByTag instanceof PayTypeFragment ? ((PayTypeFragment) fragmentFindFragmentByTag).onKeyDown(i2, keyEvent) : super.onKeyDown(i2, keyEvent);
    }
}
