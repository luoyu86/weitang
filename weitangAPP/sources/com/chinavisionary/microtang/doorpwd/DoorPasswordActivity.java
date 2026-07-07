package com.chinavisionary.microtang.doorpwd;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.base.BaseActivity;
import com.chinavisionary.microtang.doorpwd.fragment.DoorPasswordFragment;
import com.chinavisionary.microtang.doorpwd.fragment.UpdateDoorPwdBleFragment;

/* JADX INFO: loaded from: classes.dex */
public class DoorPasswordActivity extends BaseActivity {
    @Override // com.chinavisionary.core.app.base.CoreBaseActivity
    public void U(View view) {
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseActivity
    public int getLayoutId() {
        return R.layout.activity_content;
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseActivity
    public void initView(Bundle bundle) {
        Y(DoorPasswordFragment.getInstance(), R.id.flayout_content);
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        Fragment fragmentFindFragmentByTag = getSupportFragmentManager().findFragmentByTag(UpdateDoorPwdBleFragment.class.getCanonicalName());
        if (fragmentFindFragmentByTag != null) {
            fragmentFindFragmentByTag.onActivityResult(i2, i3, intent);
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        Fragment fragmentFindFragmentByTag;
        if (keyEvent.getKeyCode() == 4 && (fragmentFindFragmentByTag = getSupportFragmentManager().findFragmentByTag(UpdateDoorPwdBleFragment.class.getCanonicalName())) != null && ((UpdateDoorPwdBleFragment) fragmentFindFragmentByTag).onKeyDown(i2, keyEvent)) {
            return true;
        }
        return super.onKeyDown(i2, keyEvent);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity, androidx.core.app.ActivityCompat.OnRequestPermissionsResultCallback
    public void onRequestPermissionsResult(int i2, @NonNull String[] strArr, @NonNull int[] iArr) {
        super.onRequestPermissionsResult(i2, strArr, iArr);
        Fragment fragmentFindFragmentByTag = getSupportFragmentManager().findFragmentByTag(UpdateDoorPwdBleFragment.class.getCanonicalName());
        if (fragmentFindFragmentByTag != null) {
            fragmentFindFragmentByTag.onRequestPermissionsResult(i2, strArr, iArr);
        }
    }
}
