package com.ciba.http.client;

import com.ciba.http.client.BaseHttpClient;
import com.ciba.http.constant.HttpConfig;
import java.util.Map;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;

/* JADX INFO: loaded from: classes2.dex */
public class BaseHttpClient<T extends BaseHttpClient> {
    private Map<String, String> headers;
    private final HttpConfig httpConfig = createDefaultHttpConfig();

    private HttpConfig createDefaultHttpConfig() {
        return new HttpConfig("application/x-www-form-urlencoded", "application/json", "UTF-8", 5000L, 5000L, false);
    }

    public Map<String, String> getHeaders() {
        return this.headers;
    }

    public HostnameVerifier getHostnameVerifier() {
        return this.httpConfig.getHostnameVerifier();
    }

    public HttpConfig getHttpConfig() {
        return this.httpConfig;
    }

    public SSLSocketFactory getSslSocketFactory() {
        return this.httpConfig.getSslSocketFactory();
    }

    public T setConnectTimeout(long j) {
        this.httpConfig.setConnectTimeout(j);
        return this;
    }

    public T setContentType(String str) {
        this.httpConfig.setContentType(str);
        return this;
    }

    public T setHeaders(Map<String, String> map) {
        this.headers = map;
        return this;
    }

    public void setHostnameVerifier(HostnameVerifier hostnameVerifier) {
        this.httpConfig.setHostnameVerifier(hostnameVerifier);
    }

    public T setReadTimeout(long j) {
        this.httpConfig.setReadTimeout(j);
        return this;
    }

    public void setSslSocketFactory(SSLSocketFactory sSLSocketFactory) {
        this.httpConfig.setSslSocketFactory(sSLSocketFactory);
    }
}
