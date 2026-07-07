package com.ss.android.downloadlib.h;

import java.lang.ref.SoftReference;

/* JADX INFO: loaded from: classes2.dex */
public class bl<P, R> implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private R f9868a;
    private int bl;
    private bl<R, ?> kf;
    private bl<?, P> n;
    private P ok;
    private SoftReference<ok<P, R>> s;

    public interface ok<PARAM, RESULT> {
        RESULT ok(PARAM param);
    }

    private bl(int i2, ok<P, R> okVar, P p) {
        this.bl = i2;
        this.s = new SoftReference<>(okVar);
        this.ok = p;
    }

    private R a() {
        return this.f9868a;
    }

    public static <P, R> bl<P, R> ok(ok<P, R> okVar, P p) {
        return new bl<>(2, okVar, p);
    }

    @Override // java.lang.Runnable
    public void run() {
        bl<?, P> blVar;
        if (this.bl == 0 && !j.a()) {
            com.ss.android.downloadlib.h.ok().a().post(this);
            return;
        }
        if (this.bl == 1 && j.a()) {
            com.ss.android.downloadlib.s.ok().ok(this);
            return;
        }
        if (this.bl == 2 && j.a()) {
            com.ss.android.downloadlib.s.ok().a(this);
            return;
        }
        if (this.ok == null && (blVar = this.n) != null) {
            this.ok = blVar.a();
        }
        ok<P, R> okVar = this.s.get();
        if (okVar == null) {
            return;
        }
        this.f9868a = okVar.ok(this.ok);
        bl<R, ?> blVar2 = this.kf;
        if (blVar2 != null) {
            blVar2.run();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <NR> bl<R, NR> ok(int i2, ok<R, NR> okVar) {
        bl blVar = (bl<R, ?>) new bl(i2, okVar, null);
        this.kf = blVar;
        blVar.n = this;
        return blVar;
    }

    public <NR> bl<R, NR> ok(ok<R, NR> okVar) {
        return ok(0, okVar);
    }

    public void ok() {
        bl<?, P> blVar = this.n;
        if (blVar != null) {
            blVar.ok();
        } else {
            run();
        }
    }
}
