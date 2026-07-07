package c.a.a.a.a;

import android.app.Notification;

/* JADX INFO: loaded from: classes.dex */
public class i implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Notification f798a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Notification f799b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ h f800c;

    public i(h hVar, Notification notification, Notification notification2) {
        this.f800c = hVar;
        this.f798a = notification;
        this.f799b = notification2;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f800c.f797g.a(this.f798a, this.f799b);
    }
}
