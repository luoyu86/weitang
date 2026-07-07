package com.aliyun.ams.emas.push;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import c.a.a.a.a.m;
import c.a.a.a.a.n.f;
import com.taobao.accs.utl.ALog;

/* JADX INFO: loaded from: classes.dex */
public class NotificationActivity extends Activity {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public f f5808a = new f();

    @Override // android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        if (intent != null) {
            String action = intent.getAction();
            ALog.d("MPS:NotificationActivity", " onCreate begin...action=" + action, new Object[0]);
            if (TextUtils.equals(action, m.f813b)) {
                this.f5808a.a(intent, getApplicationContext(), 1);
            }
        }
        finish();
    }

    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (intent != null) {
            String action = intent.getAction();
            ALog.d("MPS:NotificationActivity", " onNewIntent begin...action=" + action, new Object[0]);
            if (TextUtils.equals(action, m.f813b)) {
                this.f5808a.a(intent, getApplicationContext(), 1);
            }
        }
        finish();
    }
}
