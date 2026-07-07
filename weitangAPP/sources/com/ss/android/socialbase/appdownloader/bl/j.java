package com.ss.android.socialbase.appdownloader.bl;

import android.content.DialogInterface;

/* JADX INFO: loaded from: classes2.dex */
public interface j {
    j a(int i2, DialogInterface.OnClickListener onClickListener);

    j ok(int i2);

    j ok(int i2, DialogInterface.OnClickListener onClickListener);

    j ok(DialogInterface.OnCancelListener onCancelListener);

    j ok(String str);

    j ok(boolean z);

    r ok();
}
