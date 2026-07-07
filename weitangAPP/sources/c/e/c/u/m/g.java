package c.e.c.u.m;

import androidx.annotation.StringRes;

/* JADX INFO: loaded from: classes.dex */
public abstract class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public h f1873a;

    public void a() {
        h hVar = this.f1873a;
        if (hVar != null) {
            hVar.hiedAlertLoading();
        }
    }

    public void b(@StringRes int i2) {
        h hVar = this.f1873a;
        if (hVar != null) {
            hVar.showLoadingToStringRes(i2);
        }
    }

    public void c(@StringRes int i2) {
        h hVar = this.f1873a;
        if (hVar != null) {
            hVar.showToastToStringRes(i2);
        }
    }

    public void setIView(h hVar) {
        this.f1873a = hVar;
    }
}
