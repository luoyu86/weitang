package com.ss.android.socialbase.appdownloader.s;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import com.ss.android.socialbase.appdownloader.bl.j;
import com.ss.android.socialbase.appdownloader.bl.r;

/* JADX INFO: loaded from: classes2.dex */
public class ok extends com.ss.android.socialbase.appdownloader.bl.a {
    private AlertDialog.Builder ok;

    /* JADX INFO: renamed from: com.ss.android.socialbase.appdownloader.s.ok$ok, reason: collision with other inner class name */
    public static class C0146ok implements r {
        private AlertDialog ok;

        public C0146ok(AlertDialog.Builder builder) {
            if (builder != null) {
                this.ok = builder.show();
            }
        }

        @Override // com.ss.android.socialbase.appdownloader.bl.r
        public boolean a() {
            AlertDialog alertDialog = this.ok;
            if (alertDialog != null) {
                return alertDialog.isShowing();
            }
            return false;
        }

        @Override // com.ss.android.socialbase.appdownloader.bl.r
        public void ok() {
            AlertDialog alertDialog = this.ok;
            if (alertDialog != null) {
                alertDialog.show();
            }
        }
    }

    public ok(Context context) {
        this.ok = new AlertDialog.Builder(context);
    }

    @Override // com.ss.android.socialbase.appdownloader.bl.j
    public j a(int i2, DialogInterface.OnClickListener onClickListener) {
        AlertDialog.Builder builder = this.ok;
        if (builder != null) {
            builder.setNegativeButton(i2, onClickListener);
        }
        return this;
    }

    @Override // com.ss.android.socialbase.appdownloader.bl.j
    public j ok(int i2) {
        AlertDialog.Builder builder = this.ok;
        if (builder != null) {
            builder.setTitle(i2);
        }
        return this;
    }

    @Override // com.ss.android.socialbase.appdownloader.bl.j
    public j ok(String str) {
        AlertDialog.Builder builder = this.ok;
        if (builder != null) {
            builder.setMessage(str);
        }
        return this;
    }

    @Override // com.ss.android.socialbase.appdownloader.bl.j
    public j ok(int i2, DialogInterface.OnClickListener onClickListener) {
        AlertDialog.Builder builder = this.ok;
        if (builder != null) {
            builder.setPositiveButton(i2, onClickListener);
        }
        return this;
    }

    @Override // com.ss.android.socialbase.appdownloader.bl.j
    public j ok(DialogInterface.OnCancelListener onCancelListener) {
        AlertDialog.Builder builder = this.ok;
        if (builder != null) {
            builder.setOnCancelListener(onCancelListener);
        }
        return this;
    }

    @Override // com.ss.android.socialbase.appdownloader.bl.j
    public r ok() {
        return new C0146ok(this.ok);
    }
}
