package com.tianmu.http.listener;

import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public interface HttpListener {
    void onRequestFailed(int i2, String str);

    void onRequestFailed(int i2, String str, String str2);

    void onRequestStart();

    void onRequestSuccess(String str);

    void onRequestSuccess(String str, Map<String, List<String>> map);
}
