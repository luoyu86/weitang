package a.a.n;

import anet.channel.util.ALog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static List<a> f163a = new ArrayList();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ReentrantReadWriteLock f164b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ReentrantReadWriteLock.ReadLock f165c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ReentrantReadWriteLock.WriteLock f166d;

    public static class a implements Comparable<a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final a.a.n.a f167a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final c f168b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f169c;

        public a(a.a.n.a aVar, c cVar, int i2) {
            this.f167a = aVar;
            this.f168b = cVar;
            this.f169c = i2;
        }

        @Override // java.lang.Comparable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(a aVar) {
            return this.f169c - aVar.f169c;
        }
    }

    static {
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        f164b = reentrantReadWriteLock;
        f165c = reentrantReadWriteLock.readLock();
        f166d = reentrantReadWriteLock.writeLock();
    }

    public static void addCache(a.a.n.a aVar, c cVar, int i2) {
        try {
            if (aVar == null) {
                throw new IllegalArgumentException("cache is null");
            }
            if (cVar == null) {
                throw new IllegalArgumentException("prediction is null");
            }
            ReentrantReadWriteLock.WriteLock writeLock = f166d;
            writeLock.lock();
            f163a.add(new a(aVar, cVar, i2));
            Collections.sort(f163a);
            writeLock.unlock();
        } catch (Throwable th) {
            f166d.unlock();
            throw th;
        }
    }

    public static void clearAllCache() {
        ALog.w("anet.CacheManager", "clearAllCache", null, new Object[0]);
        Iterator<a> it = f163a.iterator();
        while (it.hasNext()) {
            try {
                it.next().f167a.clear();
            } catch (Exception unused) {
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x001f, code lost:
    
        r3 = r1.f167a;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static a.a.n.a getCache(java.lang.String r3, java.util.Map<java.lang.String, java.lang.String> r4) {
        /*
            java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock r0 = a.a.n.b.f165c     // Catch: java.lang.Throwable -> L29
            r0.lock()     // Catch: java.lang.Throwable -> L29
            java.util.List<a.a.n.b$a> r0 = a.a.n.b.f163a     // Catch: java.lang.Throwable -> L29
            java.util.Iterator r0 = r0.iterator()     // Catch: java.lang.Throwable -> L29
        Lb:
            boolean r1 = r0.hasNext()     // Catch: java.lang.Throwable -> L29
            if (r1 == 0) goto L27
            java.lang.Object r1 = r0.next()     // Catch: java.lang.Throwable -> L29
            a.a.n.b$a r1 = (a.a.n.b.a) r1     // Catch: java.lang.Throwable -> L29
            a.a.n.c r2 = r1.f168b     // Catch: java.lang.Throwable -> L29
            boolean r2 = r2.handleCache(r3, r4)     // Catch: java.lang.Throwable -> L29
            if (r2 == 0) goto Lb
            a.a.n.a r3 = r1.f167a     // Catch: java.lang.Throwable -> L29
        L21:
            java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock r4 = a.a.n.b.f165c
            r4.unlock()
            return r3
        L27:
            r3 = 0
            goto L21
        L29:
            r3 = move-exception
            java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock r4 = a.a.n.b.f165c
            r4.unlock()
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: a.a.n.b.getCache(java.lang.String, java.util.Map):a.a.n.a");
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x001b, code lost:
    
        r0.remove();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void removeCache(a.a.n.a r2) {
        /*
            java.util.concurrent.locks.ReentrantReadWriteLock$WriteLock r0 = a.a.n.b.f166d     // Catch: java.lang.Throwable -> L24
            r0.lock()     // Catch: java.lang.Throwable -> L24
            java.util.List<a.a.n.b$a> r0 = a.a.n.b.f163a     // Catch: java.lang.Throwable -> L24
            java.util.ListIterator r0 = r0.listIterator()     // Catch: java.lang.Throwable -> L24
        Lb:
            boolean r1 = r0.hasNext()     // Catch: java.lang.Throwable -> L24
            if (r1 == 0) goto L1e
            java.lang.Object r1 = r0.next()     // Catch: java.lang.Throwable -> L24
            a.a.n.b$a r1 = (a.a.n.b.a) r1     // Catch: java.lang.Throwable -> L24
            a.a.n.a r1 = r1.f167a     // Catch: java.lang.Throwable -> L24
            if (r1 != r2) goto Lb
            r0.remove()     // Catch: java.lang.Throwable -> L24
        L1e:
            java.util.concurrent.locks.ReentrantReadWriteLock$WriteLock r2 = a.a.n.b.f166d
            r2.unlock()
            return
        L24:
            r2 = move-exception
            java.util.concurrent.locks.ReentrantReadWriteLock$WriteLock r0 = a.a.n.b.f166d
            r0.unlock()
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: a.a.n.b.removeCache(a.a.n.a):void");
    }
}
