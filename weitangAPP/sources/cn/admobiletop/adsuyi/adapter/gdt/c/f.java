package cn.admobiletop.adsuyi.adapter.gdt.c;

import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public class f implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ g f3685a;

    public f(g gVar) {
        this.f3685a = gVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        View view = (View) this.f3685a.getParent();
        if (view == null) {
            return;
        }
        int width = view.getWidth();
        int height = view.getHeight();
        g gVar = this.f3685a;
        gVar.f3690e = (height - gVar.getHeight()) - this.f3685a.f3688c;
        g gVar2 = this.f3685a;
        gVar2.f3689d = (width - gVar2.getWidth()) - this.f3685a.f3688c;
    }
}
