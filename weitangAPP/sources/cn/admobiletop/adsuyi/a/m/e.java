package cn.admobiletop.adsuyi.a.m;

import java.text.SimpleDateFormat;
import java.util.Date;

/* JADX INFO: loaded from: classes.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final SimpleDateFormat f3434a = new SimpleDateFormat("yyyy-MM-dd");

    public static long a() {
        return System.currentTimeMillis();
    }

    public static long b() {
        return System.currentTimeMillis() / 1000;
    }

    public static synchronized String c() {
        return f3434a.format(new Date());
    }
}
