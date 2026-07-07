package g.a.e.d;

import java.security.PrivateKey;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class b implements PrivateKey {
    public static final String LABEL = "label";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PrivateKey f13857a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, Object> f13858b;

    public b(PrivateKey privateKey, Map<String, Object> map) {
        this.f13857a = privateKey;
        this.f13858b = map;
    }

    public b addAnnotation(String str, Object obj) {
        HashMap map = new HashMap(this.f13858b);
        map.put(str, obj);
        return new b(this.f13857a, Collections.unmodifiableMap(map));
    }

    public boolean equals(Object obj) {
        PrivateKey privateKey;
        if (obj instanceof b) {
            privateKey = this.f13857a;
            obj = ((b) obj).f13857a;
        } else {
            privateKey = this.f13857a;
        }
        return privateKey.equals(obj);
    }

    @Override // java.security.Key
    public String getAlgorithm() {
        return this.f13857a.getAlgorithm();
    }

    public Object getAnnotation(String str) {
        return this.f13858b.get(str);
    }

    public Map<String, Object> getAnnotations() {
        return this.f13858b;
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        return this.f13857a.getEncoded();
    }

    @Override // java.security.Key
    public String getFormat() {
        return this.f13857a.getFormat();
    }

    public PrivateKey getKey() {
        return this.f13857a;
    }

    public int hashCode() {
        return this.f13857a.hashCode();
    }

    public b removeAnnotation(String str) {
        HashMap map = new HashMap(this.f13858b);
        map.remove(str);
        return new b(this.f13857a, Collections.unmodifiableMap(map));
    }

    public String toString() {
        return (this.f13858b.containsKey("label") ? this.f13858b.get("label") : this.f13857a).toString();
    }
}
