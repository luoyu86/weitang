package com.ss.android.download.api.ok;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.ss.android.download.api.config.j;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.download.api.model.a;

/* JADX INFO: loaded from: classes2.dex */
public class ok implements j {
    @Override // com.ss.android.download.api.config.j
    public Dialog a(@NonNull com.ss.android.download.api.model.a aVar) {
        return ok(aVar);
    }

    @Override // com.ss.android.download.api.config.j
    public void ok(int i2, @Nullable Context context, DownloadModel downloadModel, String str, Drawable drawable, int i3) {
        Toast.makeText(context, str, 0).show();
    }

    private static Dialog ok(final com.ss.android.download.api.model.a aVar) {
        if (aVar == null) {
            return null;
        }
        AlertDialog alertDialogShow = new AlertDialog.Builder(aVar.ok).setTitle(aVar.f9721a).setMessage(aVar.bl).setPositiveButton(aVar.s, new DialogInterface.OnClickListener() { // from class: com.ss.android.download.api.ok.ok.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
                a.InterfaceC0128a interfaceC0128a = aVar.p;
                if (interfaceC0128a != null) {
                    interfaceC0128a.ok(dialogInterface);
                }
            }
        }).setNegativeButton(aVar.n, new DialogInterface.OnClickListener() { // from class: com.ss.android.download.api.ok.ok.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
                a.InterfaceC0128a interfaceC0128a = aVar.p;
                if (interfaceC0128a != null) {
                    interfaceC0128a.a(dialogInterface);
                }
            }
        }).show();
        alertDialogShow.setCanceledOnTouchOutside(aVar.kf);
        alertDialogShow.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.ss.android.download.api.ok.ok.3
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                a.InterfaceC0128a interfaceC0128a = aVar.p;
                if (interfaceC0128a != null) {
                    interfaceC0128a.bl(dialogInterface);
                }
            }
        });
        Drawable drawable = aVar.f9722h;
        if (drawable != null) {
            alertDialogShow.setIcon(drawable);
        }
        return alertDialogShow;
    }
}
