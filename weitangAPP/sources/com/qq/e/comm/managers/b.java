package com.qq.e.comm.managers;

import com.qq.e.comm.managers.plugin.e;
import com.qq.e.comm.util.GDTLogger;

/* JADX INFO: loaded from: classes2.dex */
public class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ boolean f9671a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ a f9672b;

    public b(a aVar, boolean z) {
        this.f9672b = aVar;
        this.f9671a = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.f9672b.f9665d.getPOFactory(this.f9671a, true);
            this.f9672b.f9663b = true;
        } catch (e e2) {
            GDTLogger.e(e2.getMessage(), e2);
        }
    }
}
