package g.a.c;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class g0 implements Iterable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f13659a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map f13660b;

    public g0(f0 f0Var) {
        HashMap map = new HashMap();
        this.f13660b = map;
        ArrayList arrayList = new ArrayList(1);
        this.f13659a = arrayList;
        arrayList.add(f0Var);
        map.put(f0Var.getRID(), arrayList);
    }

    public g0(Collection<f0> collection) {
        this.f13660b = new HashMap();
        for (f0 f0Var : collection) {
            d0 rid = f0Var.getRID();
            ArrayList arrayList = (ArrayList) this.f13660b.get(rid);
            if (arrayList == null) {
                arrayList = new ArrayList(1);
                this.f13660b.put(rid, arrayList);
            }
            arrayList.add(f0Var);
        }
        this.f13659a = new ArrayList(collection);
    }

    public f0 get(d0 d0Var) {
        Collection<f0> recipients = getRecipients(d0Var);
        if (recipients.size() == 0) {
            return null;
        }
        return recipients.iterator().next();
    }

    public Collection<f0> getRecipients() {
        return new ArrayList(this.f13659a);
    }

    public Collection<f0> getRecipients(d0 d0Var) {
        if (d0Var instanceof v) {
            v vVar = (v) d0Var;
            g.a.a.x3.c issuer = vVar.getIssuer();
            byte[] subjectKeyIdentifier = vVar.getSubjectKeyIdentifier();
            if (issuer != null && subjectKeyIdentifier != null) {
                ArrayList arrayList = new ArrayList();
                Collection<f0> recipients = getRecipients(new v(issuer, vVar.getSerialNumber()));
                if (recipients != null) {
                    arrayList.addAll(recipients);
                }
                Collection<f0> recipients2 = getRecipients(new v(subjectKeyIdentifier));
                if (recipients2 != null) {
                    arrayList.addAll(recipients2);
                }
                return arrayList;
            }
        }
        ArrayList arrayList2 = (ArrayList) this.f13660b.get(d0Var);
        return arrayList2 == null ? new ArrayList() : new ArrayList(arrayList2);
    }

    @Override // java.lang.Iterable
    public Iterator<f0> iterator() {
        return getRecipients().iterator();
    }

    public int size() {
        return this.f13659a.size();
    }
}
