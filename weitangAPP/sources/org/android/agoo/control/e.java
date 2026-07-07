package org.android.agoo.control;

/* JADX INFO: loaded from: classes2.dex */
public class e implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f14953a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f14954b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ AgooFactory f14955c;

    public e(AgooFactory agooFactory, String str, String str2) {
        this.f14955c = agooFactory;
        this.f14953a = str;
        this.f14954b = str2;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f14955c.updateMsgStatus(this.f14953a, this.f14954b);
    }
}
