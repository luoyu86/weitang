package androidx.appcompat.app;

import android.app.Dialog;
import android.os.Bundle;
import androidx.annotation.RestrictTo;
import androidx.fragment.app.DialogFragment;

/* JADX INFO: loaded from: classes.dex */
public class AppCompatDialogFragment extends DialogFragment {
    @Override // androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        return new AppCompatDialog(getContext(), getTheme());
    }

    @Override // androidx.fragment.app.DialogFragment
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setupDialog(Dialog dialog, int i2) {
        if (!(dialog instanceof AppCompatDialog)) {
            super.setupDialog(dialog, i2);
            return;
        }
        AppCompatDialog appCompatDialog = (AppCompatDialog) dialog;
        if (i2 != 1 && i2 != 2) {
            if (i2 != 3) {
                return;
            } else {
                dialog.getWindow().addFlags(24);
            }
        }
        appCompatDialog.supportRequestWindowFeature(1);
    }
}
