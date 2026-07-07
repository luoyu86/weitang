package com.ss.android.downloadlib.addownload.ok;

import android.app.Activity;
import android.app.Dialog;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.R;

/* JADX INFO: loaded from: classes2.dex */
public class n extends Dialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private TextView f9820a;
    private TextView bl;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f9821h;
    private String j;
    private String k;
    private bl kf;
    private s n;
    private TextView ok;
    private boolean p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private Activity f9822q;
    private String r;
    private TextView s;
    private String z;

    public static class ok {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f9823a;
        private String bl;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private s f9824h;
        private boolean kf;
        private String n;
        private Activity ok;
        private bl p;
        private String s;

        public ok(Activity activity) {
            this.ok = activity;
        }

        public ok a(String str) {
            this.bl = str;
            return this;
        }

        public ok bl(String str) {
            this.s = str;
            return this;
        }

        public ok ok(String str) {
            this.f9823a = str;
            return this;
        }

        public ok s(String str) {
            this.n = str;
            return this;
        }

        public ok ok(boolean z) {
            this.kf = z;
            return this;
        }

        public ok ok(s sVar) {
            this.f9824h = sVar;
            return this;
        }

        public ok ok(bl blVar) {
            this.p = blVar;
            return this;
        }

        public n ok() {
            return new n(this.ok, this.f9823a, this.bl, this.s, this.n, this.kf, this.f9824h, this.p);
        }
    }

    public n(@NonNull Activity activity, String str, String str2, String str3, String str4, boolean z, @NonNull s sVar, bl blVar) {
        super(activity, R.style.ttdownloader_translucent_dialog);
        this.f9822q = activity;
        this.n = sVar;
        this.k = str;
        this.r = str2;
        this.j = str3;
        this.z = str4;
        this.kf = blVar;
        setCanceledOnTouchOutside(z);
        s();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void delete() {
        this.p = true;
        dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kf() {
        dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        this.f9821h = true;
        dismiss();
    }

    private void s() {
        setContentView(LayoutInflater.from(this.f9822q.getApplicationContext()).inflate(ok(), (ViewGroup) null));
        this.ok = (TextView) findViewById(a());
        this.f9820a = (TextView) findViewById(bl());
        this.bl = (TextView) findViewById(R.id.message_tv);
        this.s = (TextView) findViewById(R.id.delete_tv);
        if (!TextUtils.isEmpty(this.r)) {
            this.ok.setText(this.r);
        }
        if (!TextUtils.isEmpty(this.j)) {
            this.f9820a.setText(this.j);
        }
        if (TextUtils.isEmpty(this.z)) {
            this.s.setVisibility(8);
        } else {
            this.s.setText(this.z);
        }
        if (!TextUtils.isEmpty(this.k)) {
            this.bl.setText(this.k);
        }
        this.ok.setOnClickListener(new View.OnClickListener() { // from class: com.ss.android.downloadlib.addownload.ok.n.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                n.this.n();
            }
        });
        this.f9820a.setOnClickListener(new View.OnClickListener() { // from class: com.ss.android.downloadlib.addownload.ok.n.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                n.this.kf();
            }
        });
        this.s.setOnClickListener(new View.OnClickListener() { // from class: com.ss.android.downloadlib.addownload.ok.n.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                n.this.delete();
            }
        });
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        if (!this.f9822q.isFinishing()) {
            this.f9822q.finish();
        }
        if (this.f9821h) {
            this.n.ok();
        } else if (this.p) {
            this.kf.delete();
        } else {
            this.n.a();
        }
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public boolean dispatchKeyEvent(@NonNull KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == 4) {
            return true;
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    public int a() {
        return R.id.confirm_tv;
    }

    public int bl() {
        return R.id.cancel_tv;
    }

    public int ok() {
        return R.layout.ttdownloader_dialog_select_operation;
    }
}
