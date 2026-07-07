package c.e.c.v.f;

import android.content.Intent;
import android.view.View;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import com.chinavisionary.microtang.R;

/* JADX INFO: loaded from: classes.dex */
public class d0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public FragmentActivity f1946a;

    public d0(FragmentActivity fragmentActivity) {
        this.f1946a = fragmentActivity;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void c(View view) {
        if (view.getId() != R.id.tv_alert_confirm) {
            this.f1946a.finish();
        } else {
            this.f1946a.startActivity(new Intent("android.settings.SETTINGS"));
        }
    }

    public void a(int[] iArr) {
        if (iArr == null || iArr.length <= 0) {
            return;
        }
        for (int i2 : iArr) {
            if (i2 == -1) {
                c.e.c.g.n.getInstance().showAlertUnCancel(this.f1946a, c.e.a.d.x.getString(R.string.title_alert_tip), c.e.a.d.x.getString(R.string.title_permissions_failed_tip_msg), c.e.a.d.x.getString(R.string.title_confirm), c.e.a.d.x.getString(R.string.tip_exit), new View.OnClickListener() { // from class: c.e.c.v.f.n
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        this.f1988a.c(view);
                    }
                });
                return;
            } else {
                if (ContextCompat.checkSelfPermission(this.f1946a, "android.permission.WRITE_EXTERNAL_STORAGE") == 0) {
                    c.e.a.d.l.createMicroTangFolder();
                }
            }
        }
    }
}
