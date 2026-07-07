package a.a.w;

import a.a.w.l.a;

/* JADX INFO: loaded from: classes.dex */
public class n implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ l f287a;

    public n(l lVar) {
        this.f287a = lVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        l lVar = this.f287a;
        lVar.new a(0, lVar.f281a.f275a.a(), this.f287a.f281a.f276b).proceed(this.f287a.f281a.f275a.a(), this.f287a.f281a.f276b);
    }
}
