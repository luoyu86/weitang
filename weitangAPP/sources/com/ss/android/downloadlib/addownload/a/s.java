package com.ss.android.downloadlib.addownload.a;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import anet.channel.strategy.dispatch.DispatchConstants;
import com.ss.android.downloadlib.addownload.r;
import java.util.Iterator;
import java.util.LinkedList;

/* JADX INFO: loaded from: classes2.dex */
public class s {
    private static volatile s ok;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final LinkedList<ok> f9780a = new LinkedList<>();
    private static final String[] bl = {"com", DispatchConstants.ANDROID, "ss"};
    private static final int[] s = {3101, 3102, 3103, 3201, 3202, 3203};

    public static class ok {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f9781a;
        public final String bl;
        public final long n;
        public final String ok;
        public final String s;

        private ok(String str, int i2, String str2, String str3, long j) {
            this.ok = str;
            this.f9781a = i2;
            this.bl = str2 != null ? str2.toLowerCase() : null;
            this.s = str3 != null ? str3.toLowerCase() : null;
            this.n = j;
        }
    }

    private s() {
    }

    private ok bl(String str) {
        try {
            PackageManager packageManager = r.getContext().getPackageManager();
            PackageInfo packageInfo = packageManager.getPackageInfo(str, 0);
            if (packageInfo != null) {
                return new ok(str, packageInfo.versionCode, packageInfo.versionName, (String) packageManager.getApplicationLabel(packageInfo.applicationInfo), System.currentTimeMillis());
            }
            return null;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public static s ok() {
        if (ok == null) {
            synchronized (s.class) {
                if (ok == null) {
                    ok = new s();
                }
            }
        }
        return ok;
    }

    public void a(String str) {
        a();
        if (TextUtils.isEmpty(str)) {
            return;
        }
        synchronized (this.f9780a) {
            Iterator<ok> it = this.f9780a.iterator();
            while (it.hasNext()) {
                if (str.equals(it.next().ok)) {
                    it.remove();
                    return;
                }
            }
        }
    }

    public void ok(String str) {
        ok okVarBl;
        a();
        if (TextUtils.isEmpty(str) || (okVarBl = bl(str)) == null) {
            return;
        }
        synchronized (this.f9780a) {
            this.f9780a.add(okVarBl);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x0096, code lost:
    
        r7[1] = r11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public android.util.Pair<com.ss.android.downloadlib.addownload.a.s.ok, java.lang.Integer> a(com.ss.android.downloadad.api.ok.a r19) {
        /*
            Method dump skipped, instruction units count: 343
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.downloadlib.addownload.a.s.a(com.ss.android.downloadad.api.ok.a):android.util.Pair");
    }

    public ok ok(com.ss.android.downloadad.api.ok.a aVar) {
        if (aVar == null) {
            return null;
        }
        a();
        synchronized (this.f9780a) {
            for (ok okVar : this.f9780a) {
                if (okVar.n > aVar.er()) {
                    return okVar;
                }
            }
            return null;
        }
    }

    private static boolean ok(String str, String str2) {
        String[] strArrSplit;
        String[] strArrSplit2;
        boolean z;
        try {
            strArrSplit = str.split("\\.");
            strArrSplit2 = str2.split("\\.");
        } catch (Throwable th) {
            th.printStackTrace();
        }
        if (strArrSplit.length != 0 && strArrSplit2.length != 0) {
            int i2 = 0;
            int i3 = 0;
            for (String str3 : strArrSplit) {
                String[] strArr = bl;
                int length = strArr.length;
                int i4 = 0;
                while (true) {
                    if (i4 >= length) {
                        z = false;
                        break;
                    }
                    String str4 = strArr[i4];
                    if (str4.equals(str3)) {
                        if (i2 < strArrSplit2.length && str4.equals(strArrSplit2[i2])) {
                            i2++;
                        }
                        z = true;
                    } else {
                        i4++;
                    }
                }
                if (!z) {
                    int i5 = i3;
                    int i6 = i2;
                    while (i2 < strArrSplit2.length) {
                        if (str3.equals(strArrSplit2[i2])) {
                            if (i2 == i6) {
                                i6++;
                            }
                            i5++;
                            if (i5 >= 2) {
                                return true;
                            }
                        }
                        i2++;
                    }
                    i2 = i6;
                    i3 = i5;
                }
            }
            return false;
        }
        return false;
    }

    private void a() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        synchronized (this.f9780a) {
            Iterator<ok> it = this.f9780a.iterator();
            while (it.hasNext() && jCurrentTimeMillis - it.next().n > 1800000) {
                it.remove();
            }
        }
    }
}
