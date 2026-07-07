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
public final class e extends ContentObserver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ArrayList<i> f2722a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Application f2723b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Boolean f2724c;

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final e f2725a = new e();
    }

    public static e b() {
        return b.f2725a;
    }

    public void a(i iVar) {
        if (iVar == null) {
            return;
        }
        if (this.f2722a == null) {
            this.f2722a = new ArrayList<>();
        }
        if (this.f2722a.contains(iVar)) {
            return;
        }
        this.f2722a.add(iVar);
    }

    public void c(Application application) {
        Uri uriFor;
        this.f2723b = application;
        if (Build.VERSION.SDK_INT < 17 || application == null || application.getContentResolver() == null || this.f2724c.booleanValue() || (uriFor = Settings.System.getUriFor("navigationbar_is_min")) == null) {
            return;
        }
        this.f2723b.getContentResolver().registerContentObserver(uriFor, true, this);
        this.f2724c = Boolean.TRUE;
    }

    public void d(i iVar) {
        ArrayList<i> arrayList;
        if (iVar == null || (arrayList = this.f2722a) == null) {
            return;
        }
        arrayList.remove(iVar);
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z) {
        Application application;
        ArrayList<i> arrayList;
        super.onChange(z);
        if (Build.VERSION.SDK_INT < 17 || (application = this.f2723b) == null || application.getContentResolver() == null || (arrayList = this.f2722a) == null || arrayList.isEmpty()) {
            return;
        }
        int i2 = Settings.System.getInt(this.f2723b.getContentResolver(), "navigationbar_is_min", 0);
        for (i iVar : this.f2722a) {
            boolean z2 = true;
            if (i2 == 1) {
                z2 = false;
            }
            iVar.onNavigationBarChange(z2);
        }
    }

    public e() {
        super(new Handler(Looper.getMainLooper()));
        this.f2724c = Boolean.FALSE;
    }
}
