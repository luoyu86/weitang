package a.a.s;

import anet.channel.util.ALog;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final CopyOnWriteArrayList<b> f226a = new CopyOnWriteArrayList<>();

    public static void addInterceptor(b bVar) {
        CopyOnWriteArrayList<b> copyOnWriteArrayList = f226a;
        if (copyOnWriteArrayList.contains(bVar)) {
            return;
        }
        copyOnWriteArrayList.add(bVar);
        ALog.i("anet.InterceptorManager", "[addInterceptor]", null, "interceptors", copyOnWriteArrayList.toString());
    }

    public static boolean contains(b bVar) {
        return f226a.contains(bVar);
    }

    public static b getInterceptor(int i2) {
        return f226a.get(i2);
    }

    public static int getSize() {
        return f226a.size();
    }

    public static void removeInterceptor(b bVar) {
        CopyOnWriteArrayList<b> copyOnWriteArrayList = f226a;
        copyOnWriteArrayList.remove(bVar);
        ALog.i("anet.InterceptorManager", "[remoteInterceptor]", null, "interceptors", copyOnWriteArrayList.toString());
    }
}
