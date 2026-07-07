package com.alibaba.sdk.android.push.e;

import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ConcurrentHashMap<Integer, a> f4943a = new ConcurrentHashMap<>();

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f4944a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f4945b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final long f4946c;

        public a(String str, String str2, long j) {
            this.f4944a = str;
            this.f4945b = str2;
            this.f4946c = j;
        }

        public String a() {
            return this.f4945b;
        }

        public long b() {
            return this.f4946c;
        }
    }

    private boolean a(long j, long j2) {
        return j2 - j >= 5000;
    }

    public a a(int i2) {
        a aVar = this.f4943a.get(Integer.valueOf(i2));
        if (aVar == null || a(aVar.b(), System.currentTimeMillis())) {
            return null;
        }
        return aVar;
    }

    public void a(int i2, String str) {
        a aVar;
        long jCurrentTimeMillis = System.currentTimeMillis();
        int i3 = 1;
        if (i2 != 1) {
            i3 = 2;
            if (i2 != 2) {
                i3 = 3;
                if (i2 != 3) {
                    i3 = 4;
                    if (i2 != 4) {
                        return;
                    } else {
                        aVar = new a(String.valueOf(4), str, jCurrentTimeMillis);
                    }
                } else {
                    aVar = new a(String.valueOf(3), str, jCurrentTimeMillis);
                }
            } else {
                aVar = new a(String.valueOf(2), str, jCurrentTimeMillis);
            }
        } else {
            aVar = new a(String.valueOf(1), str, jCurrentTimeMillis);
        }
        this.f4943a.put(Integer.valueOf(i3), aVar);
    }
}
