package org.greenrobot.eventbus.util;

import android.R;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;

/* JADX INFO: loaded from: classes3.dex */
public class ErrorDialogFragments {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f14980a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Class<?> f14981b;

    @TargetApi(11)
    public static class Honeycomb extends DialogFragment implements DialogInterface.OnClickListener {
        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            ErrorDialogFragments.handleOnClick(dialogInterface, i2, getActivity(), getArguments());
        }

        @Override // android.app.DialogFragment
        public Dialog onCreateDialog(Bundle bundle) {
            return ErrorDialogFragments.createDialog(getActivity(), getArguments(), this);
        }
    }

    public static class Support extends androidx.fragment.app.DialogFragment implements DialogInterface.OnClickListener {
        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            ErrorDialogFragments.handleOnClick(dialogInterface, i2, getActivity(), getArguments());
        }

        @Override // androidx.fragment.app.DialogFragment
        public Dialog onCreateDialog(Bundle bundle) {
            return ErrorDialogFragments.createDialog(getActivity(), getArguments(), this);
        }
    }

    public static Dialog createDialog(Context context, Bundle bundle, DialogInterface.OnClickListener onClickListener) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(bundle.getString("de.greenrobot.eventbus.errordialog.title"));
        builder.setMessage(bundle.getString("de.greenrobot.eventbus.errordialog.message"));
        int i2 = f14980a;
        if (i2 != 0) {
            builder.setIcon(i2);
        }
        builder.setPositiveButton(R.string.ok, onClickListener);
        return builder.create();
    }

    public static void handleOnClick(DialogInterface dialogInterface, int i2, Activity activity, Bundle bundle) {
        Class<?> cls = f14981b;
        if (cls != null) {
            try {
                cls.newInstance();
                throw null;
            } catch (Exception e2) {
                throw new RuntimeException("Event cannot be constructed", e2);
            }
        } else {
            if (!bundle.getBoolean("de.greenrobot.eventbus.errordialog.finish_after_dialog", false) || activity == null) {
                return;
            }
            activity.finish();
        }
    }
}
