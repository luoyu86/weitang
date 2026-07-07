package a.a.n;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public interface a {

    /* JADX INFO: renamed from: a.a.n.a$a, reason: collision with other inner class name */
    public static class C0000a implements Serializable {
        public byte[] data;
        public String etag;
        public long lastModified;
        public Map<String, List<String>> responseHeaders = Collections.EMPTY_MAP;
        public long serverDate;
        public long ttl;

        public boolean isFresh() {
            return System.currentTimeMillis() <= this.ttl;
        }
    }

    void clear();

    C0000a get(String str);

    void put(String str, C0000a c0000a);

    void remove(String str);
}
