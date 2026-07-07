package com.bun.miitmdid.utilsforrequestpermission;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Nullable;
import com.bun.miitmdid.c;
import com.bun.miitmdid.interfaces.IPermissionCallbackListener;
import com.bun.miitmdid.j0;
import com.bun.miitmdid.m0;
import com.bun.miitmdid.p;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class PermissionTransparentActivity extends Activity {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f5910a = 1111;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f5911b = "1";

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public native void run();
    }

    @Override // android.app.Activity
    public native void finish();

    @Override // android.app.Activity
    public void onActivityResult(int i2, int i3, @Nullable Intent intent) {
        super.onActivityResult(i2, i3, intent);
        j0.a("PermissionTransparentActivity", "onActivityResult---------,requestCode: " + i2 + ", resultCode: " + i3);
        if (this.f5910a == i2 && -1 == i3 && intent != null) {
            IPermissionCallbackListener iPermissionCallbackListenerB = m0.a().b();
            String stringExtra = intent.getStringExtra("permissionCode");
            String str = p.a().b(this).A;
            j0.a("PermissionTransparentActivity", "providerName: " + str);
            if (str.equals(c.VIVO.A)) {
                j0.a("PermissionTransparentActivity", "providerName is vivo");
                if (this.f5911b.equals(stringExtra)) {
                    j0.a("PermissionTransparentActivity", "onGranted");
                    iPermissionCallbackListenerB.onGranted(new String[]{"VIVO_OAID_STATE_ENABLE"});
                } else {
                    j0.a("PermissionTransparentActivity", "onDenied");
                    ArrayList arrayList = new ArrayList(1);
                    arrayList.add("VIVO_OAID_STATE_DISABLE");
                    iPermissionCallbackListenerB.onDenied(arrayList);
                }
            }
        }
        finish();
    }

    @Override // android.app.Activity
    public native void onCreate(Bundle bundle);

    @Override // android.app.Activity
    public native void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr);
}
