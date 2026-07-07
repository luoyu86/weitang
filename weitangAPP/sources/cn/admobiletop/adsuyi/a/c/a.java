package cn.admobiletop.adsuyi.a.c;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class a implements Application.ActivityLifecycleCallbacks {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<InterfaceC0050a> f3229a = new ArrayList();

    /* JADX INFO: renamed from: cn.admobiletop.adsuyi.a.c.a$a, reason: collision with other inner class name */
    public interface InterfaceC0050a {
        void onActivityDestroyed(Activity activity);

        void onActivityPaused(Activity activity);

        void onActivityResumed(Activity activity);
    }

    public void a(InterfaceC0050a interfaceC0050a) {
        if (interfaceC0050a != null) {
            this.f3229a.add(interfaceC0050a);
        }
    }

    public void b(InterfaceC0050a interfaceC0050a) {
        if (interfaceC0050a != null) {
            this.f3229a.remove(interfaceC0050a);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(@NonNull Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(@NonNull Activity activity) {
        if (this.f3229a.size() > 0) {
            for (int i2 = 0; i2 < this.f3229a.size(); i2++) {
                this.f3229a.get(i2).onActivityDestroyed(activity);
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(@NonNull Activity activity) {
        if (this.f3229a.size() > 0) {
            for (int i2 = 0; i2 < this.f3229a.size(); i2++) {
                this.f3229a.get(i2).onActivityPaused(activity);
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(@NonNull Activity activity) {
        if (this.f3229a.size() > 0) {
            for (int i2 = 0; i2 < this.f3229a.size(); i2++) {
                this.f3229a.get(i2).onActivityResumed(activity);
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(@NonNull Activity activity, @NonNull Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(@NonNull Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(@NonNull Activity activity) {
    }
}
