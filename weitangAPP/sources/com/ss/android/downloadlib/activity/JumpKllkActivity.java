package com.ss.android.downloadlib.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.ss.android.downloadlib.addownload.r;
import com.ss.android.downloadlib.h.p;
import com.ss.android.downloadlib.n.bl;

/* JADX INFO: loaded from: classes2.dex */
public class JumpKllkActivity extends TTDelegateActivity {
    @Override // com.ss.android.downloadlib.activity.TTDelegateActivity
    public void ok() {
        Intent intent = getIntent();
        if (getIntent() == null) {
            bl.ok().ok("handleIntent is null");
            com.ss.android.socialbase.appdownloader.bl.ok((Activity) this);
            return;
        }
        String stringExtra = intent.getStringExtra("p");
        long longExtra = intent.getLongExtra("id", 0L);
        if (TextUtils.isEmpty(stringExtra) || longExtra == 0) {
            bl.ok().ok("getPackage or id is null");
            com.ss.android.socialbase.appdownloader.bl.ok((Activity) this);
        }
        boolean booleanExtra = intent.getBooleanExtra("dl", false);
        String stringExtra2 = intent.getStringExtra("bk");
        if (booleanExtra && (!TextUtils.isEmpty(stringExtra2))) {
            p.ok((Context) this, stringExtra, longExtra, stringExtra2, true);
            com.ss.android.socialbase.appdownloader.bl.ok((Activity) this);
            return;
        }
        int iOptInt = r.q().optInt("ab", 0);
        p.ok(this, stringExtra, longExtra, iOptInt == 1);
        if (iOptInt != 1) {
            com.ss.android.socialbase.appdownloader.bl.ok((Activity) this);
        }
    }

    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
        com.ss.android.socialbase.appdownloader.bl.ok((Activity) this);
    }
}
