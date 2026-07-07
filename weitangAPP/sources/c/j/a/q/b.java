package c.j.a.q;

import android.content.res.Configuration;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

/* JADX INFO: loaded from: classes2.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Fragment f2763a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public a f2764b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f2765c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f2766d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f2767e;

    /* JADX WARN: Multi-variable type inference failed */
    public b(Fragment fragment) {
        this.f2763a = fragment;
        if (!(fragment instanceof a)) {
            throw new IllegalArgumentException("Fragment请实现ImmersionOwner接口");
        }
        this.f2764b = (a) fragment;
    }

    public boolean isUserVisibleHint() {
        Fragment fragment = this.f2763a;
        if (fragment != null) {
            return fragment.getUserVisibleHint();
        }
        return false;
    }

    public void onActivityCreated(@Nullable Bundle bundle) {
        this.f2765c = true;
        Fragment fragment = this.f2763a;
        if (fragment == null || !fragment.getUserVisibleHint()) {
            return;
        }
        if (this.f2764b.immersionBarEnabled()) {
            this.f2764b.initImmersionBar();
        }
        if (this.f2766d) {
            return;
        }
        this.f2764b.onLazyAfterView();
        this.f2766d = true;
    }

    public void onConfigurationChanged(Configuration configuration) {
        Fragment fragment = this.f2763a;
        if (fragment == null || !fragment.getUserVisibleHint()) {
            return;
        }
        if (this.f2764b.immersionBarEnabled()) {
            this.f2764b.initImmersionBar();
        }
        this.f2764b.onVisible();
    }

    public void onCreate(@Nullable Bundle bundle) {
        Fragment fragment = this.f2763a;
        if (fragment == null || !fragment.getUserVisibleHint() || this.f2767e) {
            return;
        }
        this.f2764b.onLazyBeforeView();
        this.f2767e = true;
    }

    public void onDestroy() {
        this.f2763a = null;
        this.f2764b = null;
    }

    public void onHiddenChanged(boolean z) {
        Fragment fragment = this.f2763a;
        if (fragment != null) {
            fragment.setUserVisibleHint(!z);
        }
    }

    public void onPause() {
        if (this.f2763a != null) {
            this.f2764b.onInvisible();
        }
    }

    public void onResume() {
        Fragment fragment = this.f2763a;
        if (fragment == null || !fragment.getUserVisibleHint()) {
            return;
        }
        this.f2764b.onVisible();
    }

    public void setUserVisibleHint(boolean z) {
        Fragment fragment = this.f2763a;
        if (fragment != null) {
            if (!fragment.getUserVisibleHint()) {
                if (this.f2765c) {
                    this.f2764b.onInvisible();
                    return;
                }
                return;
            }
            if (!this.f2767e) {
                this.f2764b.onLazyBeforeView();
                this.f2767e = true;
            }
            if (this.f2765c && this.f2763a.getUserVisibleHint()) {
                if (this.f2764b.immersionBarEnabled()) {
                    this.f2764b.initImmersionBar();
                }
                if (!this.f2766d) {
                    this.f2764b.onLazyAfterView();
                    this.f2766d = true;
                }
                this.f2764b.onVisible();
            }
        }
    }
}
