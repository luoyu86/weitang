package com.tianmu.apilib.ad;

import com.tianmu.http.listener.HttpListener;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public interface IAdHttp {
    void get(String str, Map<String, String> map, HttpListener httpListener);

    void getAd(String str, Map<String, String> map, HttpListener httpListener);

    void post(String str, Map<String, String> map, HttpListener httpListener);
}
