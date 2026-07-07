package com.gyf.immersionbar;

import android.app.Activity;
import android.app.Dialog;
import android.content.res.Configuration;
import androidx.fragment.app.Fragment;
import c.j.a.h;
import c.j.a.j;

/* JADX INFO: loaded from: classes2.dex */
public final class SupportRequestManagerFragment extends Fragment {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public j f9073a;

    public h get(Object obj) {
        if (this.f9073a == null) {
            this.f9073a = new j(obj);
        }
        return this.f9073a.get();
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        j jVar = this.f9073a;
        if (jVar != null) {
            jVar.a(configuration);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        j jVar = this.f9073a;
        if (jVar != null) {
            jVar.b();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        j jVar = this.f9073a;
        if (jVar != null) {
            jVar.c();
        }
    }

    public h get(Activity activity, Dialog dialog) {
        if (this.f9073a == null) {
            this.f9073a = new j(activity, dialog);
        }
        return this.f9073a.get();
    }
}
