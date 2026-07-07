package com.ciba.http.entity;

import com.ciba.http.constant.HttpConfig;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class Request {
    private Map<String, String> headers;
    private HttpConfig httpConfig;
    private String json;
    private String requestMethod;
    private Map<String, String> requestParams;
    private String url;

    public Request(String str, String str2, HttpConfig httpConfig) {
        this.requestMethod = str;
        this.url = str2;
        this.httpConfig = httpConfig;
    }

    public Map<String, String> getHeaders() {
        return this.headers;
    }

    public HttpConfig getHttpConfig() {
        return this.httpConfig;
    }

    public String getJson() {
        return this.json;
    }

    public String getRequestMethod() {
        return this.requestMethod;
    }

    public Map<String, String> getRequestParams() {
        return this.requestParams;
    }

    public String getUrl() {
        return this.url;
    }

    public void setHeaders(Map<String, String> map) {
        this.headers = map;
    }

    public void setHttpConfig(HttpConfig httpConfig) {
        this.httpConfig = httpConfig;
    }

    public void setJson(String str) {
        this.json = str;
    }

    public void setRequestMethod(String str) {
        this.requestMethod = str;
    }

    public void setRequestParams(Map<String, String> map) {
        this.requestParams = map;
    }

    public void setUrl(String str) {
        this.url = str;
    }
}
