package anet.channel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* JADX INFO: loaded from: classes.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map<SessionRequest, List<Session>> f433a = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ReentrantReadWriteLock f434b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ReentrantReadWriteLock.ReadLock f435c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ReentrantReadWriteLock.WriteLock f436d;

    public e() {
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        this.f434b = reentrantReadWriteLock;
        this.f435c = reentrantReadWriteLock.readLock();
        this.f436d = reentrantReadWriteLock.writeLock();
    }

    public void a(SessionRequest sessionRequest, Session session) {
        if (sessionRequest == null || sessionRequest.a() == null || session == null) {
            return;
        }
        this.f436d.lock();
        try {
            List<Session> arrayList = this.f433a.get(sessionRequest);
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                this.f433a.put(sessionRequest, arrayList);
            }
            if (arrayList.indexOf(session) != -1) {
                return;
            }
            arrayList.add(session);
            Collections.sort(arrayList);
        } finally {
            this.f436d.unlock();
        }
    }

    public void b(SessionRequest sessionRequest, Session session) {
        this.f436d.lock();
        try {
            List<Session> list = this.f433a.get(sessionRequest);
            if (list == null) {
                return;
            }
            list.remove(session);
            if (list.size() == 0) {
                this.f433a.remove(sessionRequest);
            }
        } finally {
            this.f436d.unlock();
        }
    }

    public boolean c(SessionRequest sessionRequest, Session session) {
        this.f435c.lock();
        try {
            List<Session> list = this.f433a.get(sessionRequest);
            boolean z = false;
            if (list != null) {
                if (list.indexOf(session) != -1) {
                    z = true;
                }
            }
            return z;
        } finally {
            this.f435c.unlock();
        }
    }

    public List<Session> a(SessionRequest sessionRequest) {
        this.f435c.lock();
        try {
            List<Session> list = this.f433a.get(sessionRequest);
            if (list != null) {
                return new ArrayList(list);
            }
            return Collections.EMPTY_LIST;
        } finally {
            this.f435c.unlock();
        }
    }

    public Session a(SessionRequest sessionRequest, int i2) {
        this.f435c.lock();
        try {
            List<Session> list = this.f433a.get(sessionRequest);
            Session session = null;
            if (list != null && !list.isEmpty()) {
                for (Session session2 : list) {
                    if (session2 != null && session2.isAvailable() && (i2 == anet.channel.entity.c.f464c || session2.j.getType() == i2)) {
                        session = session2;
                        break;
                    }
                }
                return session;
            }
            return null;
        } finally {
            this.f435c.unlock();
        }
    }

    public List<SessionRequest> a() {
        List<SessionRequest> list = Collections.EMPTY_LIST;
        this.f435c.lock();
        try {
            return this.f433a.isEmpty() ? list : new ArrayList(this.f433a.keySet());
        } finally {
            this.f435c.unlock();
        }
    }
}
