package com.taobao.accs;

import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public abstract class IAppReceiverV1 implements IAppReceiver {
    @Override // com.taobao.accs.IAppReceiver
    public abstract Map<String, String> getAllServices();

    @Override // com.taobao.accs.IAppReceiver
    public abstract String getService(String str);

    @Override // com.taobao.accs.IAppReceiver
    @Deprecated
    public void onBindApp(int i2) {
        onBindApp(i2, "");
    }

    public abstract void onBindApp(int i2, String str);

    @Override // com.taobao.accs.IAppReceiver
    public abstract void onBindUser(String str, int i2);

    @Override // com.taobao.accs.IAppReceiver
    public void onData(String str, String str2, byte[] bArr) {
    }

    @Override // com.taobao.accs.IAppReceiver
    public void onSendData(String str, int i2) {
    }

    @Override // com.taobao.accs.IAppReceiver
    public abstract void onUnbindApp(int i2);

    @Override // com.taobao.accs.IAppReceiver
    public abstract void onUnbindUser(int i2);
}
