package cn.admobiletop.adsuyi.a.b;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import cn.admobiletop.adsuyi.ADSuyiSdk;

/* JADX INFO: loaded from: classes.dex */
public class t extends FragmentManager.FragmentLifecycleCallbacks {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Fragment f3218a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ u f3219b;

    public t(u uVar, Fragment fragment) {
        this.f3219b = uVar;
        this.f3218a = fragment;
    }

    @Override // androidx.fragment.app.FragmentManager.FragmentLifecycleCallbacks
    public void onFragmentPaused(FragmentManager fragmentManager, Fragment fragment) {
        if (this.f3219b.f3226g != null && this.f3218a == fragment) {
            this.f3219b.f3226g.onPaused();
        }
        super.onFragmentPaused(fragmentManager, fragment);
    }

    @Override // androidx.fragment.app.FragmentManager.FragmentLifecycleCallbacks
    public void onFragmentResumed(FragmentManager fragmentManager, Fragment fragment) {
        if (this.f3219b.f3226g != null && this.f3218a == fragment) {
            this.f3219b.f3226g.onResumed();
        }
        super.onFragmentResumed(fragmentManager, fragment);
    }

    @Override // androidx.fragment.app.FragmentManager.FragmentLifecycleCallbacks
    public void onFragmentViewDestroyed(FragmentManager fragmentManager, Fragment fragment) {
        if (this.f3218a == fragment && (ADSuyiSdk.getInstance().getConfig() == null || ADSuyiSdk.getInstance().getConfig().isCanAutoReleaseAd())) {
            this.f3219b.release();
        }
        super.onFragmentViewDestroyed(fragmentManager, fragment);
    }
}
