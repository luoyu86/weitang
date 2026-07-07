package c.a.a.a.a.e;

import android.app.NotificationManager;
import android.content.Context;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static a f787a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static List<Integer> f788b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ConcurrentHashMap<String, List<c.a.a.a.a.n.a>> f789c = new ConcurrentHashMap<>();

    public a() {
        f788b = new ArrayList();
    }

    public static a a() {
        if (f787a == null) {
            f787a = new a();
        }
        return f787a;
    }

    public final void b() {
        ConcurrentHashMap<String, List<c.a.a.a.a.n.a>> concurrentHashMap = f789c;
        if (concurrentHashMap.isEmpty()) {
            return;
        }
        try {
            Iterator<Map.Entry<String, List<c.a.a.a.a.n.a>>> it = concurrentHashMap.entrySet().iterator();
            while (it.hasNext()) {
                List<c.a.a.a.a.n.a> value = it.next().getValue();
                if (value != null) {
                    value.clear();
                }
            }
            f789c.clear();
        } catch (Exception unused) {
        }
    }

    public void a(int i2) {
        f788b.add(Integer.valueOf(i2));
    }

    public void a(Context context) {
        NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
        while (!f788b.isEmpty()) {
            notificationManager.cancel(f788b.get(r0.size() - 1).intValue());
            f788b.remove(r0.size() - 1);
        }
        b();
    }

    public void a(String str, c.a.a.a.a.n.a aVar) {
        ConcurrentHashMap<String, List<c.a.a.a.a.n.a>> concurrentHashMap = f789c;
        List<c.a.a.a.a.n.a> list = concurrentHashMap.get(str);
        if (list != null && !list.isEmpty()) {
            list.add(aVar);
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(aVar);
        concurrentHashMap.put(str, arrayList);
    }

    public void a(String str) {
        ConcurrentHashMap<String, List<c.a.a.a.a.n.a>> concurrentHashMap = f789c;
        List<c.a.a.a.a.n.a> list = concurrentHashMap.get(str);
        if (list != null) {
            list.clear();
            concurrentHashMap.remove(str);
        }
    }
}
