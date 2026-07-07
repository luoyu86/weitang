package com.ciba.http.constant;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;

/* JADX INFO: loaded from: classes2.dex */
public class HttpConfig {
    private String accept;
    private String charsetName;
    private long connectTimeout;
    private String contentType;
    private HostnameVerifier hostnameVerifier;
    private long readTimeout;
    private SSLSocketFactory sslSocketFactory;
    private boolean useCaches;

    public HttpConfig(String str, String str2, String str3, long j, long j2, boolean z) {
        this.contentType = str;
        this.accept = str2;
        this.charsetName = str3;
        this.connectTimeout = j;
        this.readTimeout = j2;
        this.useCaches = z;
    }

    public String getAccept() {
        return this.accept;
    }

    public String getCharsetName() {
        return this.charsetName;
    }

    public long getConnectTimeout() {
        return this.connectTimeout;
    }

    public String getContentType() {
        return this.contentType;
    }

    public HostnameVerifier getHostnameVerifier() {
        return this.hostnameVerifier;
    }

    public long getReadTimeout() {
        return this.readTimeout;
    }

    public SSLSocketFactory getSslSocketFactory() {
        return this.sslSocketFactory;
    }

    public boolean isUseCaches() {
        return this.useCaches;
    }

    public void setAccept(String str) {
        this.accept = str;
    }

    public void setCharsetName(String str) {
        this.charsetName = str;
    }

    public void setConnectTimeout(long j) {
        this.connectTimeout = j;
    }

    public void setContentType(String str) {
        this.contentType = str;
    }

    public void setHostnameVerifier(HostnameVerifier hostnameVerifier) {
        this.hostnameVerifier = hostnameVerifier;
    }

    public void setReadTimeout(long j) {
        this.readTimeout = j;
    }

    public void setSslSocketFactory(SSLSocketFactory sSLSocketFactory) {
        this.sslSocketFactory = sSLSocketFactory;
    }

    public void setUseCaches(boolean z) {
        this.useCaches = z;
    }
}
