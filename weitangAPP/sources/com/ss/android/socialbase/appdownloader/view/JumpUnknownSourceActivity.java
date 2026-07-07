package com.ss.android.socialbase.appdownloader.view;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Window;
import android.view.WindowManager;
import androidx.annotation.Nullable;
import com.ss.android.socialbase.appdownloader.a;
import com.ss.android.socialbase.appdownloader.bl;
import com.ss.android.socialbase.appdownloader.bl.j;
import com.ss.android.socialbase.appdownloader.bl.r;
import com.ss.android.socialbase.appdownloader.p;
import com.ss.android.socialbase.appdownloader.q;
import com.ss.android.socialbase.appdownloader.s;
import com.taobao.accs.messenger.MessengerService;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class JumpUnknownSourceActivity extends Activity {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Intent f9967a;

    @Nullable
    private Intent bl;
    private JSONObject n;
    private r ok;
    private int s;

    @Override // android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        ok();
        p.ok().ok(this);
    }

    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        p.ok().ok(this);
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        Intent intent = getIntent();
        this.f9967a = intent;
        if (intent != null) {
            this.bl = (Intent) intent.getParcelableExtra(MessengerService.INTENT);
            this.s = intent.getIntExtra("id", -1);
            try {
                this.n = new JSONObject(intent.getStringExtra("config"));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        if (this.n == null) {
            bl.ok((Activity) this);
            return;
        }
        a();
        r rVar = this.ok;
        if (rVar != null && !rVar.a()) {
            this.ok.ok();
        } else if (this.ok == null) {
            finish();
        }
    }

    private void a() {
        if (this.ok != null || this.f9967a == null) {
            return;
        }
        try {
            com.ss.android.socialbase.appdownloader.bl.bl blVarOk = s.k().ok();
            j jVarOk = blVarOk != null ? blVarOk.ok(this) : null;
            if (jVarOk == null) {
                jVarOk = new com.ss.android.socialbase.appdownloader.s.ok(this);
            }
            int iOk = q.ok(this, "tt_appdownloader_tip");
            int iOk2 = q.ok(this, "tt_appdownloader_label_ok");
            int iOk3 = q.ok(this, "tt_appdownloader_label_cancel");
            String strOptString = this.n.optString("jump_unknown_source_tips");
            if (TextUtils.isEmpty(strOptString)) {
                strOptString = getString(q.ok(this, "tt_appdownloader_jump_unknown_source_tips"));
            }
            jVarOk.ok(iOk).ok(strOptString).ok(iOk2, new DialogInterface.OnClickListener() { // from class: com.ss.android.socialbase.appdownloader.view.JumpUnknownSourceActivity.3
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i2) {
                    JumpUnknownSourceActivity jumpUnknownSourceActivity = JumpUnknownSourceActivity.this;
                    if (a.ok(jumpUnknownSourceActivity, jumpUnknownSourceActivity.bl, JumpUnknownSourceActivity.this.s, JumpUnknownSourceActivity.this.n)) {
                        a.bl(JumpUnknownSourceActivity.this.s, JumpUnknownSourceActivity.this.n);
                    } else {
                        JumpUnknownSourceActivity jumpUnknownSourceActivity2 = JumpUnknownSourceActivity.this;
                        a.ok((Context) jumpUnknownSourceActivity2, jumpUnknownSourceActivity2.bl, true);
                    }
                    a.ok(JumpUnknownSourceActivity.this.s, JumpUnknownSourceActivity.this.n);
                    JumpUnknownSourceActivity.this.finish();
                }
            }).a(iOk3, new DialogInterface.OnClickListener() { // from class: com.ss.android.socialbase.appdownloader.view.JumpUnknownSourceActivity.2
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i2) {
                    if (JumpUnknownSourceActivity.this.bl != null) {
                        JumpUnknownSourceActivity jumpUnknownSourceActivity = JumpUnknownSourceActivity.this;
                        a.ok((Context) jumpUnknownSourceActivity, jumpUnknownSourceActivity.bl, true);
                    }
                    a.a(JumpUnknownSourceActivity.this.s, JumpUnknownSourceActivity.this.n);
                    JumpUnknownSourceActivity.this.finish();
                }
            }).ok(new DialogInterface.OnCancelListener() { // from class: com.ss.android.socialbase.appdownloader.view.JumpUnknownSourceActivity.1
                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                    if (JumpUnknownSourceActivity.this.bl != null) {
                        JumpUnknownSourceActivity jumpUnknownSourceActivity = JumpUnknownSourceActivity.this;
                        a.ok((Context) jumpUnknownSourceActivity, jumpUnknownSourceActivity.bl, true);
                    }
                    a.a(JumpUnknownSourceActivity.this.s, JumpUnknownSourceActivity.this.n);
                    JumpUnknownSourceActivity.this.finish();
                }
            }).ok(false);
            this.ok = jVarOk.ok();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void ok() {
        Window window = getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.alpha = 0.0f;
        window.setAttributes(attributes);
    }
}
