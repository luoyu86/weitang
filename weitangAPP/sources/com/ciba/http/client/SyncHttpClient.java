package com.ciba.http.client;

import com.ciba.http.entity.Request;
import com.ciba.http.request.SyncRequest;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class SyncHttpClient extends BaseHttpClient<SyncHttpClient> {
    private String sendRequest(String str, String str2, String str3, Map<String, String> map, Map<String, String> map2) {
        Request request = new Request(str, str2, getHttpConfig());
        request.setJson(str3);
        request.setRequestParams(map);
        request.setHeaders(map2);
        return new SyncRequest(request).run();
    }

    public String get(String str, Map<String, String> map) {
        return get(str, map, getHeaders());
    }

    public String post(String str, Map<String, String> map) {
        return post(str, map, getHeaders());
    }

    public String postJson(String str, String str2) {
        return postJson(str, str2, getHeaders());
    }

    public String get(String str, Map<String, String> map, Map<String, String> map2) {
        return sendRequest("GET", str, null, map, map2);
    }

    public String post(String str, Map<String, String> map, Map<String, String> map2) {
        return post(str, null, map, map2);
    }

    public String postJson(String str, String str2, Map<String, String> map) {
        return post(str, str2, null, map);
    }

    private String post(String str, String str2, Map<String, String> map, Map<String, String> map2) {
        return sendRequest("POST", str, str2, map, map2);
    }
}
