package c.j.a;

import android.app.Activity;
import android.app.Dialog;
import android.content.res.Configuration;
import android.os.Build;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

/* JADX INFO: loaded from: classes2.dex */
public class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public h f2753a;

    public j(Object obj) {
        if (obj instanceof Activity) {
            if (this.f2753a == null) {
                this.f2753a = new h((Activity) obj);
                return;
            }
            return;
        }
        if (obj instanceof Fragment) {
            if (this.f2753a == null) {
                if (obj instanceof DialogFragment) {
                    this.f2753a = new h((DialogFragment) obj);
                    return;
                } else {
                    this.f2753a = new h((Fragment) obj);
                    return;
                }
            }
            return;
        }
        if ((obj instanceof android.app.Fragment) && this.f2753a == null) {
            if (obj instanceof android.app.DialogFragment) {
                this.f2753a = new h((android.app.DialogFragment) obj);
            } else {
                this.f2753a = new h((android.app.Fragment) obj);
            }
        }
    }

    public void a(Configuration configuration) {
        if (this.f2753a != null) {
            if ((m.isEMUI3_x() || Build.VERSION.SDK_INT == 19) && this.f2753a.u() && !this.f2753a.w() && this.f2753a.getBarParams().E) {
                this.f2753a.init();
            }
        }
    }

    public void b() {
        h hVar = this.f2753a;
        if (hVar != null) {
            hVar.d();
            this.f2753a = null;
        }
    }

    public void c() {
        if (this.f2753a != null && m.isEMUI3_x() && this.f2753a.u() && !this.f2753a.w() && this.f2753a.getBarParams().F) {
            this.f2753a.init();
        }
    }

    public h get() {
        return this.f2753a;
    }

    public j(Activity activity, Dialog dialog) {
        if (this.f2753a == null) {
            this.f2753a = new h(activity, dialog);
        }
    }
}
