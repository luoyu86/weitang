package com.tianmu.biz.widget;

import android.content.Context;

/* JADX INFO: loaded from: classes2.dex */
public class a extends com.tianmu.j.b.c.i {
    private com.tianmu.j.a.a F;

    /* JADX INFO: renamed from: com.tianmu.biz.widget.a$a, reason: collision with other inner class name */
    public interface InterfaceC0188a {
        void onVideoCompletion(int i2);

        void onVideoError();

        void onVideoPause(int i2);

        void onVideoPosition(int i2, int i3);

        void onVideoPrepared(long j);

        void onVideoStart();
    }

    public a(Context context, String str, String str2) {
        this(context, str, str2, null);
    }

    public void F() {
        u();
    }

    public boolean G() {
        return this.f12305q;
    }

    public void H() {
        x();
    }

    public void I() {
        g();
    }

    public void J() {
        F();
    }

    public void a(InterfaceC0188a interfaceC0188a) {
        com.tianmu.j.a.a aVar = this.F;
        if (aVar != null) {
            aVar.a(interfaceC0188a);
        }
    }

    @Override // com.tianmu.j.b.c.e, com.tianmu.j.b.c.f
    public void w() {
        super.w();
    }

    public a(Context context, String str, String str2, com.tianmu.j.a.c.a aVar) {
        super(context);
        com.tianmu.j.a.a aVar2 = new com.tianmu.j.a.a(getContext());
        this.F = aVar2;
        aVar2.a(str2, aVar);
        this.F.a(false);
        a((com.tianmu.j.b.a.a) this.F);
        c(false);
        a(str);
        b(str2);
    }
}
