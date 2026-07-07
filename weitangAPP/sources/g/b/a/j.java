package g.b.a;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final List<j> f14715a = new ArrayList();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object f14716b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public q f14717c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public j f14718d;

    public j(Object obj, q qVar) {
        this.f14716b = obj;
        this.f14717c = qVar;
    }

    public static j a(q qVar, Object obj) {
        List<j> list = f14715a;
        synchronized (list) {
            int size = list.size();
            if (size <= 0) {
                return new j(obj, qVar);
            }
            j jVarRemove = list.remove(size - 1);
            jVarRemove.f14716b = obj;
            jVarRemove.f14717c = qVar;
            jVarRemove.f14718d = null;
            return jVarRemove;
        }
    }

    public static void b(j jVar) {
        jVar.f14716b = null;
        jVar.f14717c = null;
        jVar.f14718d = null;
        List<j> list = f14715a;
        synchronized (list) {
            if (list.size() < 10000) {
                list.add(jVar);
            }
        }
    }
}
