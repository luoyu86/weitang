package cn.admobiletop.adsuyi.a.m;

import java.util.Random;

/* JADX INFO: loaded from: classes.dex */
public class m {
    public static int a() {
        try {
            return new Random().nextInt(100);
        } catch (Exception unused) {
            return 0;
        }
    }

    public static boolean a(int i2) {
        return i2 == 100 || i2 > a();
    }
}
