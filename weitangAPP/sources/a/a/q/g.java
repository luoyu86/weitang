package a.a.q;

import anet.channel.request.Request;
import anet.channel.statist.RequestStatistic;
import anet.channel.util.ALog;
import anet.channel.util.HttpConstant;
import anet.channel.util.HttpUrl;
import anet.channel.util.Utils;
import anetwork.channel.aidl.ParcelableRequest;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ParcelableRequest f214a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Request f215b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f217d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public RequestStatistic f219f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f220g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f221h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f222i;
    public final int j;
    public final boolean k;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f216c = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f218e = 0;

    public g(ParcelableRequest parcelableRequest, int i2, boolean z) {
        this.f215b = null;
        this.f217d = 0;
        if (parcelableRequest == null) {
            throw new IllegalArgumentException("request is null");
        }
        this.f214a = parcelableRequest;
        this.j = i2;
        this.k = z;
        this.f222i = a.a.x.a.a(parcelableRequest.m, i2 == 0 ? "HTTP" : "DGRD");
        int i3 = parcelableRequest.j;
        this.f220g = i3 <= 0 ? (int) (Utils.getNetworkTimeFactor() * 12000.0f) : i3;
        int i4 = parcelableRequest.k;
        this.f221h = i4 <= 0 ? (int) (Utils.getNetworkTimeFactor() * 12000.0f) : i4;
        int i5 = parcelableRequest.f767c;
        this.f217d = (i5 < 0 || i5 > 3) ? 2 : i5;
        HttpUrl httpUrlL = l();
        RequestStatistic requestStatistic = new RequestStatistic(httpUrlL.host(), String.valueOf(parcelableRequest.l));
        this.f219f = requestStatistic;
        requestStatistic.url = httpUrlL.simpleUrlString();
        this.f215b = c(httpUrlL);
    }

    public Request a() {
        return this.f215b;
    }

    public int b() {
        return this.f221h * (this.f217d + 1);
    }

    public final Request c(HttpUrl httpUrl) {
        Request.Builder requestStatistic = new Request.Builder().setUrl(httpUrl).setMethod(this.f214a.f771g).setBody(this.f214a.f766b).setReadTimeout(this.f221h).setConnectTimeout(this.f220g).setRedirectEnable(this.f214a.f770f).setRedirectTimes(this.f216c).setBizId(this.f214a.l).setSeq(this.f222i).setRequestStatistic(this.f219f);
        requestStatistic.setParams(this.f214a.f773i);
        String str = this.f214a.f769e;
        if (str != null) {
            requestStatistic.setCharset(str);
        }
        requestStatistic.setHeaders(d(httpUrl));
        return requestStatistic.build();
    }

    public boolean d() {
        return this.f218e < this.f217d;
    }

    public boolean e() {
        return a.a.o.b.isHttpSessionEnable() && !"false".equalsIgnoreCase(this.f214a.getExtProperty("EnableHttpDns")) && (a.a.o.b.isAllowHttpIpRetry() || this.f218e == 0);
    }

    public HttpUrl f() {
        return this.f215b.getHttpUrl();
    }

    public String g() {
        return this.f215b.getUrlString();
    }

    public Map<String, String> h() {
        return this.f215b.getHeaders();
    }

    public boolean i() {
        return !"false".equalsIgnoreCase(this.f214a.getExtProperty("EnableCookie"));
    }

    public boolean j() {
        return "true".equals(this.f214a.getExtProperty("CheckContentLength"));
    }

    public void k() {
        int i2 = this.f218e + 1;
        this.f218e = i2;
        this.f219f.retryTimes = i2;
    }

    public final HttpUrl l() {
        HttpUrl httpUrl = HttpUrl.parse(this.f214a.f768d);
        if (httpUrl == null) {
            throw new IllegalArgumentException("url is invalid. url=" + this.f214a.f768d);
        }
        if (!a.a.o.b.isSSLEnabled()) {
            ALog.i("anet.RequestConfig", "request ssl disabled.", this.f222i, new Object[0]);
            httpUrl.downgradeSchemeAndLock();
        } else if ("false".equalsIgnoreCase(this.f214a.getExtProperty("EnableSchemeReplace"))) {
            httpUrl.lockScheme();
        }
        return httpUrl;
    }

    public void a(Request request) {
        this.f215b = request;
    }

    public final Map<String, String> d(HttpUrl httpUrl) {
        String strHost = httpUrl.host();
        boolean z = !anet.channel.strategy.utils.c.a(strHost);
        if (strHost.length() > 2 && strHost.charAt(0) == '[' && strHost.charAt(strHost.length() - 1) == ']' && anet.channel.strategy.utils.c.b(strHost.substring(1, strHost.length() - 1))) {
            z = false;
        }
        HashMap map = new HashMap();
        Map<String, String> map2 = this.f214a.f772h;
        if (map2 != null) {
            for (Map.Entry<String, String> entry : map2.entrySet()) {
                String key = entry.getKey();
                if (!"Host".equalsIgnoreCase(key) && !":host".equalsIgnoreCase(key)) {
                    boolean zEqualsIgnoreCase = "true".equalsIgnoreCase(this.f214a.getExtProperty("KeepCustomCookie"));
                    if (!HttpConstant.COOKIE.equalsIgnoreCase(key) || zEqualsIgnoreCase) {
                        map.put(key, entry.getValue());
                    }
                } else if (!z) {
                    map.put("Host", entry.getValue());
                }
            }
        }
        return map;
    }

    public String a(String str) {
        return this.f214a.getExtProperty(str);
    }

    public void a(HttpUrl httpUrl) {
        ALog.i("anet.RequestConfig", "redirect", this.f222i, "to url", httpUrl.toString());
        this.f216c++;
        this.f219f.url = httpUrl.simpleUrlString();
        this.f215b = c(httpUrl);
    }

    public boolean c() {
        return this.k;
    }
}
