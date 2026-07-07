package anet.channel.request;

import android.text.TextUtils;
import anet.channel.AwcnConfig;
import anet.channel.statist.RequestStatistic;
import anet.channel.util.ALog;
import anet.channel.util.HttpUrl;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import org.apache.commons.codec.net.RFC1522Codec;

/* JADX INFO: loaded from: classes.dex */
public class Request {
    public static final String DEFAULT_CHARSET = "UTF-8";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RequestStatistic f528a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private HttpUrl f529b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private HttpUrl f530c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private HttpUrl f531d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private URL f532e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f533f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Map<String, String> f534g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private Map<String, String> f535h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private String f536i;
    private BodyEntry j;
    private boolean k;
    private String l;
    private String m;
    private int n;
    private int o;
    private int p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private HostnameVerifier f537q;
    private SSLSocketFactory r;
    private boolean s;

    public static class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private HttpUrl f538a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private HttpUrl f539b;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private Map<String, String> f542e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private String f543f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private BodyEntry f544g;
        private HostnameVerifier j;
        private SSLSocketFactory k;
        private String l;
        private String m;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        private boolean f547q;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private String f540c = "GET";

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private Map<String, String> f541d = new HashMap();

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private boolean f545h = true;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private int f546i = 0;
        private int n = 10000;
        private int o = 10000;
        private RequestStatistic p = null;

        public Builder addHeader(String str, String str2) {
            this.f541d.put(str, str2);
            return this;
        }

        public Builder addParam(String str, String str2) {
            if (this.f542e == null) {
                this.f542e = new HashMap();
            }
            this.f542e.put(str, str2);
            this.f539b = null;
            return this;
        }

        public Request build() {
            if (this.f544g == null && this.f542e == null && Method.a(this.f540c)) {
                ALog.e("awcn.Request", "method " + this.f540c + " must have a request body", null, new Object[0]);
            }
            if (this.f544g != null && !Method.b(this.f540c)) {
                ALog.e("awcn.Request", "method " + this.f540c + " should not have a request body", null, new Object[0]);
                this.f544g = null;
            }
            BodyEntry bodyEntry = this.f544g;
            if (bodyEntry != null && bodyEntry.getContentType() != null) {
                addHeader("Content-Type", this.f544g.getContentType());
            }
            return new Request(this);
        }

        public Builder setAllowRequestInBg(boolean z) {
            this.f547q = z;
            return this;
        }

        public Builder setBizId(String str) {
            this.l = str;
            return this;
        }

        public Builder setBody(BodyEntry bodyEntry) {
            this.f544g = bodyEntry;
            return this;
        }

        public Builder setCharset(String str) {
            this.f543f = str;
            this.f539b = null;
            return this;
        }

        public Builder setConnectTimeout(int i2) {
            if (i2 > 0) {
                this.n = i2;
            }
            return this;
        }

        public Builder setHeaders(Map<String, String> map) {
            this.f541d.clear();
            if (map != null) {
                this.f541d.putAll(map);
            }
            return this;
        }

        public Builder setHostnameVerifier(HostnameVerifier hostnameVerifier) {
            this.j = hostnameVerifier;
            return this;
        }

        public Builder setMethod(String str) {
            if (TextUtils.isEmpty(str)) {
                throw new IllegalArgumentException("method is null or empty");
            }
            if ("GET".equalsIgnoreCase(str)) {
                this.f540c = "GET";
            } else if ("POST".equalsIgnoreCase(str)) {
                this.f540c = "POST";
            } else if (Method.OPTION.equalsIgnoreCase(str)) {
                this.f540c = Method.OPTION;
            } else if (Method.HEAD.equalsIgnoreCase(str)) {
                this.f540c = Method.HEAD;
            } else if (Method.PUT.equalsIgnoreCase(str)) {
                this.f540c = Method.PUT;
            } else if (Method.DELETE.equalsIgnoreCase(str)) {
                this.f540c = Method.DELETE;
            } else {
                this.f540c = "GET";
            }
            return this;
        }

        public Builder setParams(Map<String, String> map) {
            this.f542e = map;
            this.f539b = null;
            return this;
        }

        public Builder setReadTimeout(int i2) {
            if (i2 > 0) {
                this.o = i2;
            }
            return this;
        }

        public Builder setRedirectEnable(boolean z) {
            this.f545h = z;
            return this;
        }

        public Builder setRedirectTimes(int i2) {
            this.f546i = i2;
            return this;
        }

        public Builder setRequestStatistic(RequestStatistic requestStatistic) {
            this.p = requestStatistic;
            return this;
        }

        public Builder setSeq(String str) {
            this.m = str;
            return this;
        }

        public Builder setSslSocketFactory(SSLSocketFactory sSLSocketFactory) {
            this.k = sSLSocketFactory;
            return this;
        }

        public Builder setUrl(HttpUrl httpUrl) {
            this.f538a = httpUrl;
            this.f539b = null;
            return this;
        }

        public Builder setUrl(String str) {
            HttpUrl httpUrl = HttpUrl.parse(str);
            this.f538a = httpUrl;
            this.f539b = null;
            if (httpUrl != null) {
                return this;
            }
            throw new IllegalArgumentException("toURL is invalid! toURL = " + str);
        }
    }

    public static final class Method {
        public static final String DELETE = "DELETE";
        public static final String GET = "GET";
        public static final String HEAD = "HEAD";
        public static final String OPTION = "OPTIONS";
        public static final String POST = "POST";
        public static final String PUT = "PUT";

        public static boolean a(String str) {
            return str.equals("POST") || str.equals(PUT);
        }

        public static boolean b(String str) {
            return a(str) || str.equals(DELETE) || str.equals(OPTION);
        }
    }

    private Map<String, String> a() {
        return AwcnConfig.isCookieHeaderRedundantFix() ? new HashMap(this.f534g) : this.f534g;
    }

    private void b() {
        String strA = anet.channel.strategy.utils.c.a(this.f535h, getContentEncoding());
        if (!TextUtils.isEmpty(strA)) {
            if (Method.a(this.f533f) && this.j == null) {
                try {
                    this.j = new ByteArrayEntry(strA.getBytes(getContentEncoding()));
                    this.f534g.put("Content-Type", "application/x-www-form-urlencoded; charset=" + getContentEncoding());
                } catch (UnsupportedEncodingException unused) {
                }
            } else {
                String strUrlString = this.f529b.urlString();
                StringBuilder sb = new StringBuilder(strUrlString);
                if (sb.indexOf("?") == -1) {
                    sb.append(RFC1522Codec.SEP);
                } else if (strUrlString.charAt(strUrlString.length() - 1) != '&') {
                    sb.append('&');
                }
                sb.append(strA);
                HttpUrl httpUrl = HttpUrl.parse(sb.toString());
                if (httpUrl != null) {
                    this.f530c = httpUrl;
                }
            }
        }
        if (this.f530c == null) {
            this.f530c = this.f529b;
        }
    }

    public boolean containsBody() {
        return this.j != null;
    }

    public String getBizId() {
        return this.l;
    }

    public byte[] getBodyBytes() {
        if (this.j == null) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(128);
        try {
            postBody(byteArrayOutputStream);
        } catch (IOException unused) {
        }
        return byteArrayOutputStream.toByteArray();
    }

    public int getConnectTimeout() {
        return this.o;
    }

    public String getContentEncoding() {
        String str = this.f536i;
        return str != null ? str : "UTF-8";
    }

    public Map<String, String> getHeaders() {
        return Collections.unmodifiableMap(this.f534g);
    }

    public String getHost() {
        return this.f530c.host();
    }

    public HostnameVerifier getHostnameVerifier() {
        return this.f537q;
    }

    public HttpUrl getHttpUrl() {
        return this.f530c;
    }

    public String getMethod() {
        return this.f533f;
    }

    public int getReadTimeout() {
        return this.p;
    }

    public int getRedirectTimes() {
        return this.n;
    }

    public String getSeq() {
        return this.m;
    }

    public SSLSocketFactory getSslSocketFactory() {
        return this.r;
    }

    public URL getUrl() {
        if (this.f532e == null) {
            HttpUrl httpUrl = this.f531d;
            if (httpUrl == null) {
                httpUrl = this.f530c;
            }
            this.f532e = httpUrl.toURL();
        }
        return this.f532e;
    }

    public String getUrlString() {
        return this.f530c.urlString();
    }

    public boolean isAllowRequestInBg() {
        return this.s;
    }

    public boolean isRedirectEnable() {
        return this.k;
    }

    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.f540c = this.f533f;
        builder.f541d = a();
        builder.f542e = this.f535h;
        builder.f544g = this.j;
        builder.f543f = this.f536i;
        builder.f545h = this.k;
        builder.f546i = this.n;
        builder.j = this.f537q;
        builder.k = this.r;
        builder.f538a = this.f529b;
        builder.f539b = this.f530c;
        builder.l = this.l;
        builder.m = this.m;
        builder.n = this.o;
        builder.o = this.p;
        builder.p = this.f528a;
        builder.f547q = this.s;
        return builder;
    }

    public int postBody(OutputStream outputStream) throws IOException {
        BodyEntry bodyEntry = this.j;
        if (bodyEntry != null) {
            return bodyEntry.writeTo(outputStream);
        }
        return 0;
    }

    public void setDnsOptimize(String str, int i2) {
        if (str != null) {
            if (this.f531d == null) {
                this.f531d = new HttpUrl(this.f530c);
            }
            this.f531d.replaceIpAndPort(str, i2);
        } else {
            this.f531d = null;
        }
        this.f532e = null;
        this.f528a.setIPAndPort(str, i2);
    }

    public void setUrlScheme(boolean z) {
        if (this.f531d == null) {
            this.f531d = new HttpUrl(this.f530c);
        }
        this.f531d.setScheme(z ? "https" : "http");
        this.f532e = null;
    }

    private Request(Builder builder) {
        this.f533f = "GET";
        this.k = true;
        this.n = 0;
        this.o = 10000;
        this.p = 10000;
        this.f533f = builder.f540c;
        this.f534g = builder.f541d;
        this.f535h = builder.f542e;
        this.j = builder.f544g;
        this.f536i = builder.f543f;
        this.k = builder.f545h;
        this.n = builder.f546i;
        this.f537q = builder.j;
        this.r = builder.k;
        this.l = builder.l;
        this.m = builder.m;
        this.o = builder.n;
        this.p = builder.o;
        this.f529b = builder.f538a;
        HttpUrl httpUrl = builder.f539b;
        this.f530c = httpUrl;
        if (httpUrl == null) {
            b();
        }
        this.f528a = builder.p != null ? builder.p : new RequestStatistic(getHost(), this.l);
        this.s = builder.f547q;
    }
}
