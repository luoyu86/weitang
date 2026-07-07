package com.ss.android.socialbase.downloader.network.ok;

import com.ss.android.socialbase.downloader.q.kf;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class ok {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map<String, bl> f10136a;
    private final Map<String, s> bl;
    public int ok;

    /* JADX INFO: renamed from: com.ss.android.socialbase.downloader.network.ok.ok$ok, reason: collision with other inner class name */
    public static final class C0172ok {
        private static final ok ok = new ok();
    }

    public s a(String str, List<com.ss.android.socialbase.downloader.model.bl> list) {
        s sVarRemove;
        synchronized (this.bl) {
            sVarRemove = this.bl.remove(str);
        }
        if (sVarRemove == null) {
            return null;
        }
        if (kf.ok(sVarRemove.kf(), list)) {
            try {
                sVarRemove.n();
            } catch (InterruptedException e2) {
                e2.printStackTrace();
            }
            if (sVarRemove.p() && sVarRemove.h()) {
                return sVarRemove;
            }
        }
        try {
            sVarRemove.s();
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    public void ok(String str, bl blVar) {
        synchronized (this.f10136a) {
            this.f10136a.put(str, blVar);
        }
    }

    private ok() {
        this.f10136a = new HashMap();
        this.bl = new LinkedHashMap(3);
        this.ok = 3;
    }

    public void ok(int i2) {
        this.ok = i2;
    }

    public bl ok(String str, List<com.ss.android.socialbase.downloader.model.bl> list) {
        bl blVarRemove;
        synchronized (this.f10136a) {
            blVarRemove = this.f10136a.remove(str);
        }
        if (blVarRemove == null) {
            return null;
        }
        if (kf.ok(blVarRemove.p(), list)) {
            try {
                blVarRemove.s();
            } catch (InterruptedException e2) {
                e2.printStackTrace();
            }
            if (blVarRemove.kf() && blVarRemove.n()) {
                return blVarRemove;
            }
        }
        try {
            blVarRemove.bl();
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    public boolean ok(String str) {
        bl blVar = this.f10136a.get(str);
        if (blVar == null) {
            return false;
        }
        if (blVar.h()) {
            return true;
        }
        return blVar.kf() && blVar.n();
    }

    public static ok ok() {
        return C0172ok.ok;
    }
}
