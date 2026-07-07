package com.ss.android.socialbase.downloader.q;

/* JADX INFO: loaded from: classes2.dex */
public class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ok f10183a;
    private int bl;
    private ok ok;
    private int s = 10;

    public static class ok {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f10184a;
        public ok bl;
        public long ok;
        public ok s;

        private ok() {
        }
    }

    public long a(long j, long j2) {
        synchronized (this) {
            ok okVar = this.ok;
            if (okVar == null) {
                return -1L;
            }
            ok okVarOk = ok(j);
            if (okVarOk == null) {
                return -1L;
            }
            long j3 = okVar.ok - okVarOk.ok;
            long j4 = j2 - okVarOk.f10184a;
            if (j3 < 0 || j4 <= 0) {
                return -1L;
            }
            return j3 / j4;
        }
    }

    public boolean ok(long j, long j2) {
        synchronized (this) {
            ok okVar = this.ok;
            if (okVar != null) {
                if (j >= okVar.ok && j2 >= okVar.f10184a) {
                    ok okVar2 = okVar.bl;
                    if (okVar2 != null && j2 - okVar2.f10184a < 1000) {
                        okVar.ok = j;
                        okVar.f10184a = j2;
                        return true;
                    }
                }
                return false;
            }
            ok okVarOk = ok();
            okVarOk.ok = j;
            okVarOk.f10184a = j2;
            if (okVar != null) {
                okVarOk.bl = okVar;
                okVar.s = okVarOk;
            }
            this.ok = okVarOk;
            return true;
        }
    }

    private ok ok() {
        ok okVar;
        int i2 = this.bl;
        if (i2 >= this.s && (okVar = this.f10183a) != null) {
            ok okVar2 = okVar.s;
            okVar.s = null;
            this.f10183a = okVar2;
            if (okVar2 != null) {
                okVar2.bl = null;
            }
            return okVar;
        }
        this.bl = i2 + 1;
        return new ok();
    }

    private ok ok(long j) {
        ok okVar = this.ok;
        ok okVar2 = null;
        while (okVar != null && okVar.f10184a > j) {
            okVar2 = okVar;
            okVar = okVar.bl;
        }
        return (okVar == null || okVar2 == null || okVar == okVar2 || j - okVar.f10184a >= okVar2.f10184a - j) ? okVar2 : okVar;
    }
}
