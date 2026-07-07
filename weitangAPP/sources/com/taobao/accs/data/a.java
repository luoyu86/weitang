package com.taobao.accs.data;

import com.taobao.accs.common.ThreadPoolExecutorFactory;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public class a {
    public static final int SPLIT_DATA_INDEX = 17;
    public static final int SPLIT_DATA_MD5 = 18;
    public static final int SPLIT_DATA_NUMS = 16;
    public static final int SPLIT_TIME_OUT = 15;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final char[] f10278a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f10279b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f10280c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f10281d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f10282e;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private ScheduledFuture<?> f10284g;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private volatile int f10283f = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Map<Integer, byte[]> f10285h = new TreeMap(new b(this));

    public a(String str, int i2, String str2) {
        this.f10279b = str;
        this.f10280c = i2;
        this.f10281d = str2;
    }

    public void a(long j) {
        if (j <= 0) {
            j = 30000;
        }
        this.f10284g = ThreadPoolExecutorFactory.getScheduledExecutor().schedule(new c(this), j, TimeUnit.MILLISECONDS);
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x00e6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public byte[] a(int r13, int r14, byte[] r15) {
        /*
            Method dump skipped, instruction units count: 359
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.accs.data.a.a(int, int, byte[]):byte[]");
    }

    private static char[] a(byte[] bArr) {
        int length = bArr.length;
        char[] cArr = new char[length << 1];
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            int i4 = i2 + 1;
            char[] cArr2 = f10278a;
            cArr[i2] = cArr2[(bArr[i3] & 240) >>> 4];
            i2 = i4 + 1;
            cArr[i4] = cArr2[bArr[i3] & 15];
        }
        return cArr;
    }
}
