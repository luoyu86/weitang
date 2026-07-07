package com.tianmu.ad.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tianmu.biz.utils.s0;
import com.tianmu.c.f.f;
import com.tianmu.c.l.a;

/* JADX INFO: loaded from: classes2.dex */
public class AppPermissionsActivity extends Activity {
    public static void start(@NonNull Context context, @NonNull String str) {
        Intent intent = new Intent(context, (Class<?>) AppPermissionsActivity.class);
        intent.putExtra("KEY_PERMISSIONS", str);
        intent.setFlags(268435456);
        context.startActivity(intent);
    }

    @Override // android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(f.f11353a);
        String stringExtra = getIntent().getStringExtra("KEY_PERMISSIONS");
        if (TextUtils.isEmpty(stringExtra)) {
            s0.a("应用权限详情不存在");
            finish();
        }
        ((TextView) findViewById(f.f11354b)).setText(stringExtra);
        findViewById(f.f11355c).setOnClickListener(new a() { // from class: com.tianmu.ad.activity.AppPermissionsActivity.1
            @Override // com.tianmu.c.l.a
            public void onSingleClick(View view) {
                AppPermissionsActivity.this.finish();
            }
        });
    }
}
