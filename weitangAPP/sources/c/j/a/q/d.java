package c.j.a.q;

import android.content.res.Configuration;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

/* JADX INFO: loaded from: classes2.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Fragment f2768a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public c f2769b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f2770c;

    /* JADX WARN: Multi-variable type inference failed */
    public d(Fragment fragment) {
        this.f2768a = fragment;
        if (!(fragment instanceof c)) {
            throw new IllegalArgumentException("Fragment请实现SimpleImmersionOwner接口");
        }
        this.f2769b = (c) fragment;
    }

    public final void a() {
        Fragment fragment = this.f2768a;
        if (fragment != null && this.f2770c && fragment.getUserVisibleHint() && this.f2769b.immersionBarEnabled()) {
            this.f2769b.initImmersionBar();
        }
    }

    public boolean isUserVisibleHint() {
        Fragment fragment = this.f2768a;
        if (fragment != null) {
            return fragment.getUserVisibleHint();
        }
        return false;
    }

    public void onActivityCreated(@Nullable Bundle bundle) {
        this.f2770c = true;
        a();
    }

    public void onConfigurationChanged(Configuration configuration) {
        a();
    }

    public void onDestroy() {
        this.f2768a = null;
        this.f2769b = null;
    }

    public void onHiddenChanged(boolean z) {
        Fragment fragment = this.f2768a;
        if (fragment != null) {
            fragment.setUserVisibleHint(!z);
        }
    }

    public void setUserVisibleHint(boolean z) {
        a();
    }
}
