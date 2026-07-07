package anet.channel;

import android.text.TextUtils;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Map<String, Integer> f386a = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Map<String, SessionInfo> f387b = new ConcurrentHashMap();

    public void a(SessionInfo sessionInfo) {
        Objects.requireNonNull(sessionInfo, "info is null");
        if (TextUtils.isEmpty(sessionInfo.host)) {
            throw new IllegalArgumentException("host cannot be null or empty");
        }
        this.f387b.put(sessionInfo.host, sessionInfo);
    }

    public SessionInfo b(String str) {
        return this.f387b.get(str);
    }

    public int c(String str) {
        Integer num;
        synchronized (this.f386a) {
            num = this.f386a.get(str);
        }
        if (num == null) {
            return -1;
        }
        return num.intValue();
    }

    public SessionInfo a(String str) {
        return this.f387b.remove(str);
    }

    public Collection<SessionInfo> a() {
        return this.f387b.values();
    }

    public void a(String str, int i2) {
        if (!TextUtils.isEmpty(str)) {
            synchronized (this.f386a) {
                this.f386a.put(str, Integer.valueOf(i2));
            }
            return;
        }
        throw new IllegalArgumentException("host cannot be null or empty");
    }
}
