package c.e.a.d.d0;

import java.util.Random;
import java.util.UUID;

/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Random f1199a = new Random();

    public static String createCode(int i2, int i3) throws Exception {
        StringBuilder sb = new StringBuilder();
        if (i3 <= 1 || i2 <= i3) {
            throw new Exception(String.format("Create Code ERROR with wrong params(Max: %d, Min: %d)", Integer.valueOf(i2), Integer.valueOf(i3)));
        }
        for (int iNextInt = (f1199a.nextInt((i2 - i3) + 1) + i3) - 1; iNextInt >= 0; iNextInt--) {
            sb.append("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".charAt(f1199a.nextInt(62)));
        }
        return sb.toString();
    }

    public static synchronized String getInvidID() {
        String str;
        Random random = new Random();
        str = "";
        for (int i2 = 0; i2 < 6; i2++) {
            str = str + random.nextInt(10);
        }
        return str;
    }

    public static synchronized String getUuid() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }
}
