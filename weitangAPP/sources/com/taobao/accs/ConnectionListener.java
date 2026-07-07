package com.taobao.accs;

/* JADX INFO: loaded from: classes2.dex */
public interface ConnectionListener {
    void onConnect();

    void onDisconnect(int i2, String str);
}
