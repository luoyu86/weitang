package c.i.b;

import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public final class o extends l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c.i.b.y.g<String, l> f2615a = new c.i.b.y.g<>();

    public final l a(Object obj) {
        return obj == null ? n.f2614a : new q(obj);
    }

    public void add(String str, l lVar) {
        if (lVar == null) {
            lVar = n.f2614a;
        }
        this.f2615a.put(str, lVar);
    }

    public void addProperty(String str, String str2) {
        add(str, a(str2));
    }

    public Set<Map.Entry<String, l>> entrySet() {
        return this.f2615a.entrySet();
    }

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof o) && ((o) obj).f2615a.equals(this.f2615a));
    }

    public l get(String str) {
        return this.f2615a.get(str);
    }

    public i getAsJsonArray(String str) {
        return (i) this.f2615a.get(str);
    }

    public o getAsJsonObject(String str) {
        return (o) this.f2615a.get(str);
    }

    public q getAsJsonPrimitive(String str) {
        return (q) this.f2615a.get(str);
    }

    public boolean has(String str) {
        return this.f2615a.containsKey(str);
    }

    public int hashCode() {
        return this.f2615a.hashCode();
    }

    public Set<String> keySet() {
        return this.f2615a.keySet();
    }

    public l remove(String str) {
        return this.f2615a.remove(str);
    }

    public int size() {
        return this.f2615a.size();
    }

    public void addProperty(String str, Number number) {
        add(str, a(number));
    }

    @Override // c.i.b.l
    public o deepCopy() {
        o oVar = new o();
        for (Map.Entry<String, l> entry : this.f2615a.entrySet()) {
            oVar.add(entry.getKey(), entry.getValue().deepCopy());
        }
        return oVar;
    }

    public void addProperty(String str, Boolean bool) {
        add(str, a(bool));
    }

    public void addProperty(String str, Character ch) {
        add(str, a(ch));
    }
}
