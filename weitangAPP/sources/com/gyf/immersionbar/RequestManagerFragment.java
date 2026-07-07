package com.gyf.immersionbar;

import android.app.Activity;
import android.app.Dialog;
import android.app.Fragment;
import android.content.res.Configuration;
import c.j.a.h;
import c.j.a.j;

/* JADX INFO: loaded from: classes2.dex */
public final class RequestManagerFragment extends Fragment {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public j f9072a;

    public h get(Object obj) {
        if (this.f9072a == null) {
            this.f9072a = new j(obj);
        }
        return this.f9072a.get();
    }

    @Override // android.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        j jVar = this.f9072a;
        if (jVar != null) {
            jVar.a(configuration);
        }
    }

    @Override // android.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        j jVar = this.f9072a;
        if (jVar != null) {
            jVar.b();
        }
    }

    @Override // android.app.Fragment
    public void onResume() {
        super.onResume();
        j jVar = this.f9072a;
        if (jVar != null) {
            jVar.c();
        }
    }

    public h get(Activity activity, Dialog dialog) {
        if (this.f9072a == null) {
            this.f9072a = new j(activity, dialog);
        }
        return this.f9072a.get();
    }
}
