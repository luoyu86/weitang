package com.ss.android.downloadlib.addownload.compliance;

/* JADX INFO: loaded from: classes2.dex */
public class bl extends com.ss.android.socialbase.downloader.q.p<Long, com.ss.android.downloadlib.addownload.a.a> {

    public static class ok {
        private static bl ok = new bl();
    }

    public static bl ok() {
        return ok.ok;
    }

    private bl() {
        super(16, 16);
    }

    public void ok(com.ss.android.downloadlib.addownload.a.a aVar) {
        if (aVar == null) {
            return;
        }
        put(Long.valueOf(aVar.ok()), aVar);
    }

    public com.ss.android.downloadlib.addownload.a.a ok(long j, long j2) {
        return get(get(Long.valueOf(j)) != null ? Long.valueOf(j) : Long.valueOf(j2));
    }

    public com.ss.android.downloadlib.addownload.a.a ok(long j) {
        return get(Long.valueOf(j));
    }
}
