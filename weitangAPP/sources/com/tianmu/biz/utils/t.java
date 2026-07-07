package com.tianmu.biz.utils;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.WindowManager;
import androidx.core.app.ActivityCompat;
import com.tianmu.c.f.c1;

/* JADX INFO: loaded from: classes2.dex */
public class t {

    public static class a implements DialogInterface.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Activity f10902a;

        public a(Activity activity) {
            this.f10902a = activity;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            ActivityCompat.requestPermissions(this.f10902a, new String[]{"android.permission.POST_NOTIFICATIONS"}, 1);
            com.tianmu.c.n.n.D().a(true);
            dialogInterface.dismiss();
        }
    }

    public static class b implements DialogInterface.OnClickListener {
        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            dialogInterface.dismiss();
        }
    }

    public static void a(Activity activity) {
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setTitle(c1.m);
        builder.setMessage(c1.n);
        builder.setPositiveButton(c1.o, new a(activity));
        builder.setNegativeButton(c1.p, new b());
        AlertDialog alertDialogCreate = builder.create();
        WindowManager.LayoutParams attributes = alertDialogCreate.getWindow().getAttributes();
        attributes.gravity = 80;
        attributes.y = 100;
        alertDialogCreate.getWindow().setAttributes(attributes);
        alertDialogCreate.show();
    }
}
