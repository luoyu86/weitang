package org.android.agoo.control;

import com.taobao.accs.base.TaoBaseService;

/* JADX INFO: loaded from: classes2.dex */
public class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ byte[] f14945a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f14946b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ TaoBaseService.ExtraInfo f14947c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ AgooFactory f14948d;

    public b(AgooFactory agooFactory, byte[] bArr, String str, TaoBaseService.ExtraInfo extraInfo) {
        this.f14948d = agooFactory;
        this.f14945a = bArr;
        this.f14946b = str;
        this.f14947c = extraInfo;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f14948d.msgReceiverPreHandler(this.f14945a, this.f14946b, this.f14947c, true);
    }
}
