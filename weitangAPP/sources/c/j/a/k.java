package c.j.a;

import android.app.Application;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public final class k extends ContentObserver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ArrayList<o> f2754a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Application f2755b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Boolean f2756c;

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final k f2757a = new k();
    }

    public static k b() {
        return b.f2757a;
    }

    public void a(o oVar) {
        if (oVar == null) {
            return;
        }
        if (this.f2754a == null) {
            this.f2754a = new ArrayList<>();
        }
        if (this.f2754a.contains(oVar)) {
            return;
        }
        this.f2754a.add(oVar);
    }

    public void c(Application application) {
        this.f2755b = application;
        int i2 = Build.VERSION.SDK_INT;
        if (i2 < 17 || application == null || application.getContentResolver() == null || this.f2756c.booleanValue()) {
            return;
        }
        Uri uriFor = null;
        if (m.isMIUI()) {
            uriFor = Settings.Global.getUriFor("force_fsg_nav_bar");
        } else if (m.isEMUI()) {
            uriFor = (m.isEMUI3_x() || i2 < 21) ? Settings.System.getUriFor("navigationbar_is_min") : Settings.Global.getUriFor("navigationbar_is_min");
        }
        if (uriFor != null) {
            this.f2755b.getContentResolver().registerContentObserver(uriFor, true, this);
            this.f2756c = Boolean.TRUE;
        }
    }

    public void d(o oVar) {
        ArrayList<o> arrayList;
        if (oVar == null || (arrayList = this.f2754a) == null) {
            return;
        }
        arrayList.remove(oVar);
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z) {
        Application application;
        ArrayList<o> arrayList;
        super.onChange(z);
        int i2 = Build.VERSION.SDK_INT;
        if (i2 < 17 || (application = this.f2755b) == null || application.getContentResolver() == null || (arrayList = this.f2754a) == null || arrayList.isEmpty()) {
            return;
        }
        int i3 = m.isMIUI() ? Settings.Global.getInt(this.f2755b.getContentResolver(), "force_fsg_nav_bar", 0) : m.isEMUI() ? (m.isEMUI3_x() || i2 < 21) ? Settings.System.getInt(this.f2755b.getContentResolver(), "navigationbar_is_min", 0) : Settings.Global.getInt(this.f2755b.getContentResolver(), "navigationbar_is_min", 0) : 0;
        for (o oVar : this.f2754a) {
            boolean z2 = true;
            if (i3 == 1) {
                z2 = false;
            }
            oVar.onNavigationBarChange(z2);
        }
    }

    public k() {
        super(new Handler(Looper.getMainLooper()));
        this.f2756c = Boolean.FALSE;
    }
}
