package c.a.a.a.a;

import android.content.Context;
import com.alibaba.sdk.android.logger.ILog;
import com.aliyun.ams.emas.push.notification.CPushMessage;
import com.taobao.accs.utl.AccsLogger;
import java.util.Random;

/* JADX INFO: loaded from: classes.dex */
public class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ILog f812a = AccsLogger.getLogger("[MPS]");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static String f813b = "com.alibaba.sdk.android.push.NOTIFY_ACTION";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Class<?> f814c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static k f815d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static d f816e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static int f817f = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static int f818g = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static Random f819h = null;

    public static void a(Context context) {
        f815d = new k(context.getApplicationContext());
    }

    public static boolean b() {
        return f815d.a();
    }

    public static int c() {
        if (f818g == 0) {
            if (f819h == null) {
                f819h = new Random(System.currentTimeMillis());
            }
            int iNextInt = f819h.nextInt(1000000);
            f818g = iNextInt;
            if (iNextInt < 0) {
                f818g = iNextInt * (-1);
            }
        }
        int i2 = f818g;
        f818g = i2 + 1;
        return i2;
    }

    public static int d() {
        if (f817f == 0) {
            if (f819h == null) {
                f819h = new Random(System.currentTimeMillis());
            }
            int iNextInt = f819h.nextInt(1000000);
            f817f = iNextInt;
            if (iNextInt < 0) {
                f817f = iNextInt * (-1);
            }
        }
        int i2 = f817f;
        f817f = i2 + 1;
        return i2;
    }

    public static void a(d dVar) {
        f816e = dVar;
    }

    public static void b(CPushMessage cPushMessage) {
        f815d.b(cPushMessage);
    }

    public static void a(Class<?> cls) {
        f814c = cls;
    }

    public static Class<?> a() {
        return f814c;
    }

    public static void a(boolean z) {
        f815d.a(z);
    }

    public static void a(int i2, int i3, int i4, int i5, a aVar) {
        f815d.a(i2, i3, i4, i5, aVar);
    }

    public static void a(Context context, String str, int i2) {
        d dVar = f816e;
        if (dVar != null) {
            dVar.reportPushArrive(context, str, i2);
        }
    }

    public static void a(CPushMessage cPushMessage) {
        f815d.a(cPushMessage);
    }
}
