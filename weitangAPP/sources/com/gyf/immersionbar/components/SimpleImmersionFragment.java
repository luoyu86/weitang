package com.gyf.immersionbar.components;

import android.content.res.Configuration;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import c.j.a.q.c;
import c.j.a.q.d;

/* JADX INFO: loaded from: classes2.dex */
public abstract class SimpleImmersionFragment extends Fragment implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public d f9075a = new d(this);

    @Override // c.j.a.q.c
    public boolean immersionBarEnabled() {
        return true;
    }

    @Override // c.j.a.q.c
    public abstract /* synthetic */ void initImmersionBar();

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(@Nullable Bundle bundle) {
        super.onActivityCreated(bundle);
        this.f9075a.onActivityCreated(bundle);
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.f9075a.onConfigurationChanged(configuration);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.f9075a.onDestroy();
    }

    @Override // androidx.fragment.app.Fragment
    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        this.f9075a.onHiddenChanged(z);
    }

    @Override // androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        this.f9075a.setUserVisibleHint(z);
    }
}
