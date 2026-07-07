package a.a.u;

import anet.channel.util.StringUtils;
import com.alipay.sdk.m.u.i;
import java.util.Collections;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class d implements a.a.u.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Map<String, String> f232a;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static d f233a = new d(null);
    }

    public /* synthetic */ d(c cVar) {
        this();
    }

    public static d getInstance() {
        return a.f233a;
    }

    @Override // a.a.u.a
    public String get(String str) {
        return this.f232a.get(str);
    }

    @Override // a.a.u.a
    public void put(String str, a.a.v.a aVar) {
        if (StringUtils.isBlank(str)) {
            return;
        }
        StringBuilder sb = new StringBuilder(48);
        sb.append("{\"oneWayTime\" : ");
        sb.append(aVar.oneWayTime_ANet);
        sb.append(", \"totalSize\" : ");
        sb.append(aVar.totalSize);
        sb.append(i.f5699d);
        this.f232a.put(str, sb.toString());
    }

    @Override // a.a.u.a
    public void reset(String str) {
        if (this.f232a.containsKey(str)) {
            this.f232a.put(str, "{\"oneWayTime\" : 0, \"totalSize\" : 0}");
        }
    }

    public d() {
        this.f232a = Collections.synchronizedMap(new c(this));
    }
}
