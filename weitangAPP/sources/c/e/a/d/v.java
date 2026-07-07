package c.e.a.d;

import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static long f1229a = 800;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static long f1230b = 1500;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile v f1231c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ConcurrentHashMap<Integer, Long> f1232d = new ConcurrentHashMap<>();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ConcurrentHashMap<String, Long> f1233e = new ConcurrentHashMap<>();

    public static v getInstance() {
        if (f1231c == null) {
            synchronized (v.class) {
                if (f1231c == null) {
                    f1231c = new v();
                }
            }
        }
        return f1231c;
    }

    public synchronized void clearActionMap() {
        ConcurrentHashMap<Integer, Long> concurrentHashMap = this.f1232d;
        if (concurrentHashMap != null) {
            concurrentHashMap.clear();
        }
        ConcurrentHashMap<String, Long> concurrentHashMap2 = this.f1233e;
        if (concurrentHashMap2 != null) {
            concurrentHashMap2.clear();
        }
    }

    public synchronized boolean isRepeatedlyAction(int i2) {
        boolean z;
        boolean zContainsKey = this.f1232d.containsKey(Integer.valueOf(i2));
        z = false;
        try {
            if (zContainsKey) {
                Long lValueOf = this.f1232d.get(Integer.valueOf(i2));
                if (lValueOf == null) {
                    lValueOf = Long.valueOf(System.currentTimeMillis());
                }
                if (System.currentTimeMillis() - lValueOf.longValue() < f1229a) {
                    z = true;
                } else {
                    this.f1232d.remove(Integer.valueOf(i2));
                    this.f1232d.put(Integer.valueOf(i2), Long.valueOf(System.currentTimeMillis()));
                }
            } else {
                this.f1232d.put(Integer.valueOf(i2), Long.valueOf(System.currentTimeMillis()));
            }
            q.d(getClass().getSimpleName(), "isRepeatedlyAction isRepeatedly = " + z + "，isContains = " + zContainsKey);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return z;
    }

    public boolean removeActionInteger(int i2) {
        boolean zContainsKey = this.f1232d.containsKey(Integer.valueOf(i2));
        if (zContainsKey) {
            this.f1232d.remove(Integer.valueOf(i2));
        }
        return zContainsKey;
    }

    public void setMinActionIntervalTime(long j) {
        f1230b = j;
    }

    public synchronized boolean isRepeatedlyAction(int i2, int i3) {
        boolean z;
        boolean zContainsKey = this.f1232d.containsKey(Integer.valueOf(i2));
        z = false;
        try {
            if (zContainsKey) {
                Long lValueOf = this.f1232d.get(Integer.valueOf(i2));
                if (lValueOf == null) {
                    lValueOf = Long.valueOf(System.currentTimeMillis());
                }
                if (System.currentTimeMillis() - lValueOf.longValue() < i3) {
                    z = true;
                } else {
                    this.f1232d.remove(Integer.valueOf(i2));
                    this.f1232d.put(Integer.valueOf(i2), Long.valueOf(System.currentTimeMillis()));
                }
            } else {
                this.f1232d.put(Integer.valueOf(i2), Long.valueOf(System.currentTimeMillis()));
            }
            q.d(getClass().getSimpleName(), "isRepeatedlyAction isRepeatedly = " + z + "，isContains = " + zContainsKey);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return z;
    }

    public synchronized boolean isRepeatedlyAction(String str) {
        boolean z;
        z = false;
        try {
            if (this.f1233e.containsKey(str)) {
                Long lValueOf = this.f1233e.get(str);
                if (lValueOf == null) {
                    lValueOf = Long.valueOf(System.currentTimeMillis());
                }
                if (System.currentTimeMillis() - lValueOf.longValue() < f1230b) {
                    z = true;
                } else {
                    this.f1233e.remove(str);
                    this.f1233e.put(str, Long.valueOf(System.currentTimeMillis()));
                }
            } else {
                this.f1233e.put(str, Long.valueOf(System.currentTimeMillis()));
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return z;
    }

    public synchronized boolean isRepeatedlyAction(String str, int i2) {
        boolean z;
        z = false;
        try {
            if (this.f1233e.containsKey(str)) {
                Long lValueOf = this.f1233e.get(str);
                if (lValueOf == null) {
                    lValueOf = Long.valueOf(System.currentTimeMillis());
                }
                if (System.currentTimeMillis() - lValueOf.longValue() < i2) {
                    z = true;
                } else {
                    this.f1233e.remove(str);
                    this.f1233e.put(str, Long.valueOf(System.currentTimeMillis()));
                }
            } else {
                this.f1233e.put(str, Long.valueOf(System.currentTimeMillis()));
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return z;
    }
}
