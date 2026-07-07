package com.bytedance.sdk.openadsdk.downloadnew.core;

import android.content.DialogInterface;

/* JADX INFO: loaded from: classes.dex */
public interface IDialogStatusChangedListener {
    void onCancel(DialogInterface dialogInterface);

    void onNegativeBtnClick(DialogInterface dialogInterface);

    void onPositiveBtnClick(DialogInterface dialogInterface);
}
