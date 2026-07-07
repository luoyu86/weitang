package c.e.a.a.e;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Window;
import android.view.WindowManager;
import c.e.a.d.s;
import com.chinavisionary.core.R;

/* JADX INFO: loaded from: classes.dex */
public abstract class o extends Dialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f989a;

    public o(Context context) {
        super(context, R.style.DialogStyle);
        a(context);
    }

    public final void a(Context context) {
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        if (isShowing()) {
            super.dismiss();
        }
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Window window = getWindow();
        if (window != null) {
            if (window.getDecorView() != null) {
                window.getDecorView().setPadding(0, 0, 0, 0);
            }
            WindowManager.LayoutParams attributes = window.getAttributes();
            window.setGravity(17);
            attributes.width = c.e.a.d.k.getScreenWidth(c.e.a.a.b.getInstance().getContext()) - (s.dip2px(30.0f) * 2);
            attributes.height = -2;
            window.setAttributes(attributes);
        }
        setCancelable(this.f989a);
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        return i2 == 4 ? !this.f989a : super.onKeyDown(i2, keyEvent);
    }

    @Override // android.app.Dialog
    public void setCancelable(boolean z) {
        this.f989a = z;
    }

    @Override // android.app.Dialog
    public void show() {
        if (isShowing()) {
            return;
        }
        super.show();
    }
}
