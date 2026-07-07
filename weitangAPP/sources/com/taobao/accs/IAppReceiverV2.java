package com.taobao.accs;

/* JADX INFO: loaded from: classes2.dex */
public abstract class IAppReceiverV2 extends IAppReceiverV1 {
    @Override // com.taobao.accs.IAppReceiverV1
    @Deprecated
    public void onBindApp(int i2, String str) {
        onBindApp(i2, "", str);
    }

    public abstract void onBindApp(int i2, String str, String str2);

    @Override // com.taobao.accs.IAppReceiverV1, com.taobao.accs.IAppReceiver
    public void onBindUser(String str, int i2) {
    }

    public void onBindUser(String str, int i2, String str2) {
        onBindUser(str, i2);
    }

    @Override // com.taobao.accs.IAppReceiverV1, com.taobao.accs.IAppReceiver
    public void onUnbindApp(int i2) {
    }

    public void onUnbindApp(int i2, String str) {
        onUnbindApp(i2);
    }

    @Override // com.taobao.accs.IAppReceiverV1, com.taobao.accs.IAppReceiver
    public void onUnbindUser(int i2) {
    }

    public void onUnbindUser(int i2, String str) {
        onUnbindUser(i2);
    }
}
