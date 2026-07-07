package com.taobao.accs;

import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public interface IAppReceiver {
    Map<String, String> getAllServices();

    String getService(String str);

    void onBindApp(int i2);

    void onBindUser(String str, int i2);

    void onData(String str, String str2, byte[] bArr);

    void onSendData(String str, int i2);

    void onUnbindApp(int i2);

    void onUnbindUser(int i2);
}
