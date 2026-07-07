package c.e.a.c.b;

import android.app.Activity;
import android.content.DialogInterface;

/* JADX INFO: loaded from: classes.dex */
public final class e implements DialogInterface.OnClickListener, DialogInterface.OnCancelListener, Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Activity f1167a;

    public e(Activity activity) {
        this.f1167a = activity;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        run();
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i2) {
        run();
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f1167a.finish();
    }
}
