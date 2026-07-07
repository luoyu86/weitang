package com.gyf.immersionbar.components;

import android.content.res.Configuration;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import c.j.a.q.a;
import c.j.a.q.b;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ImmersionFragment extends Fragment implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public b f9074a = new b(this);

    @Override // c.j.a.q.a
    public boolean immersionBarEnabled() {
        return true;
    }

    @Override // c.j.a.q.a
    public abstract /* synthetic */ void initImmersionBar();

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(@Nullable Bundle bundle) {
        super.onActivityCreated(bundle);
        this.f9074a.onActivityCreated(bundle);
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.f9074a.onConfigurationChanged(configuration);
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        this.f9074a.onCreate(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.f9074a.onDestroy();
    }

    @Override // androidx.fragment.app.Fragment
    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        this.f9074a.onHiddenChanged(z);
    }

    @Override // c.j.a.q.a
    public void onInvisible() {
    }

    @Override // c.j.a.q.a
    public void onLazyAfterView() {
    }

    @Override // c.j.a.q.a
    public void onLazyBeforeView() {
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        this.f9074a.onPause();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        this.f9074a.onResume();
    }

    @Override // c.j.a.q.a
    public void onVisible() {
    }

    @Override // androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        this.f9074a.setUserVisibleHint(z);
    }
}
