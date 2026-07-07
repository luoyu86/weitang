package cn.admobiletop.adsuyi.a.n;

import android.os.CountDownTimer;

/* JADX INFO: loaded from: classes.dex */
public class f extends CountDownTimer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ g f3466a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(g gVar, long j, long j2) {
        super(j, j2);
        this.f3466a = gVar;
    }

    @Override // android.os.CountDownTimer
    public void onFinish() {
        this.f3466a.f3472g = true;
        this.f3466a.setSkipText(0L);
        this.f3466a.i(false);
    }

    @Override // android.os.CountDownTimer
    public void onTick(long j) {
        g gVar = this.f3466a;
        gVar.f3472g = j <= (gVar.getCountDownTime() - 5000) + 200;
        this.f3466a.setSkipText(j);
    }
}
