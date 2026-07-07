package com.ss.android.downloadlib.bl;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import com.ss.android.download.api.model.a;
import com.ss.android.socialbase.appdownloader.bl.j;
import com.ss.android.socialbase.appdownloader.bl.r;

/* JADX INFO: loaded from: classes2.dex */
public class h extends com.ss.android.socialbase.appdownloader.bl.ok {
    private static String ok = "h";

    public static class ok implements r {
        private Dialog ok;

        public ok(Dialog dialog) {
            if (dialog != null) {
                this.ok = dialog;
                ok();
            }
        }

        @Override // com.ss.android.socialbase.appdownloader.bl.r
        public boolean a() {
            Dialog dialog = this.ok;
            if (dialog != null) {
                return dialog.isShowing();
            }
            return false;
        }

        @Override // com.ss.android.socialbase.appdownloader.bl.r
        public void ok() {
            Dialog dialog = this.ok;
            if (dialog != null) {
                dialog.show();
            }
        }
    }

    @Override // com.ss.android.socialbase.appdownloader.bl.ok, com.ss.android.socialbase.appdownloader.bl.bl
    public j ok(Context context) {
        return new j(context) { // from class: com.ss.android.downloadlib.bl.h.1
            private a.ok bl;
            private DialogInterface.OnCancelListener kf;
            private DialogInterface.OnClickListener n;
            public final /* synthetic */ Context ok;
            private DialogInterface.OnClickListener s;

            {
                this.ok = context;
                this.bl = new a.ok(context);
            }

            @Override // com.ss.android.socialbase.appdownloader.bl.j
            public j a(int i2, DialogInterface.OnClickListener onClickListener) {
                this.bl.s(this.ok.getResources().getString(i2));
                this.n = onClickListener;
                return this;
            }

            @Override // com.ss.android.socialbase.appdownloader.bl.j
            public j ok(int i2) {
                this.bl.ok(this.ok.getResources().getString(i2));
                return this;
            }

            @Override // com.ss.android.socialbase.appdownloader.bl.j
            public j ok(String str) {
                this.bl.a(str);
                return this;
            }

            @Override // com.ss.android.socialbase.appdownloader.bl.j
            public j ok(int i2, DialogInterface.OnClickListener onClickListener) {
                this.bl.bl(this.ok.getResources().getString(i2));
                this.s = onClickListener;
                return this;
            }

            @Override // com.ss.android.socialbase.appdownloader.bl.j
            public j ok(DialogInterface.OnCancelListener onCancelListener) {
                this.kf = onCancelListener;
                return this;
            }

            @Override // com.ss.android.socialbase.appdownloader.bl.j
            public j ok(boolean z) {
                this.bl.ok(z);
                return this;
            }

            @Override // com.ss.android.socialbase.appdownloader.bl.j
            public r ok() {
                this.bl.ok(new a.InterfaceC0128a() { // from class: com.ss.android.downloadlib.bl.h.1.1
                    @Override // com.ss.android.download.api.model.a.InterfaceC0128a
                    public void a(DialogInterface dialogInterface) {
                        if (AnonymousClass1.this.n != null) {
                            AnonymousClass1.this.n.onClick(dialogInterface, -2);
                        }
                    }

                    @Override // com.ss.android.download.api.model.a.InterfaceC0128a
                    public void bl(DialogInterface dialogInterface) {
                        if (AnonymousClass1.this.kf == null || dialogInterface == null) {
                            return;
                        }
                        AnonymousClass1.this.kf.onCancel(dialogInterface);
                    }

                    @Override // com.ss.android.download.api.model.a.InterfaceC0128a
                    public void ok(DialogInterface dialogInterface) {
                        if (AnonymousClass1.this.s != null) {
                            AnonymousClass1.this.s.onClick(dialogInterface, -1);
                        }
                    }
                });
                com.ss.android.downloadlib.h.r.ok(h.ok, "getThemedAlertDlgBuilder", null);
                this.bl.ok(3);
                return new ok(com.ss.android.downloadlib.addownload.r.bl().a(this.bl.ok()));
            }
        };
    }

    @Override // com.ss.android.socialbase.appdownloader.bl.ok, com.ss.android.socialbase.appdownloader.bl.bl
    public boolean ok() {
        return true;
    }
}
