package com.lzy.imagepicker.ui;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import c.k.a.a;
import c.k.a.f.b;
import com.lzy.imagepicker.R;

/* JADX INFO: loaded from: classes2.dex */
public class ImageBaseActivity extends FragmentActivity {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public b f9361a;

    @TargetApi(19)
    public final void c(boolean z) {
        Window window = getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        if (z) {
            attributes.flags |= 67108864;
        } else {
            attributes.flags &= -67108865;
        }
        window.setAttributes(attributes);
    }

    public boolean checkPermission(@NonNull String str) {
        return ContextCompat.checkSelfPermission(this, str) == 0;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (Build.VERSION.SDK_INT >= 19) {
            c(true);
        }
        b bVar = new b(this);
        this.f9361a = bVar;
        bVar.setStatusBarTintEnabled(true);
        this.f9361a.setStatusBarTintResource(R.color.ip_color_primary_dark);
    }

    @Override // android.app.Activity
    public void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        a.getInstance().restoreInstanceState(bundle);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        a.getInstance().saveInstanceState(bundle);
    }

    public void showToast(String str) {
        Toast.makeText(getApplicationContext(), str, 0).show();
    }
}
