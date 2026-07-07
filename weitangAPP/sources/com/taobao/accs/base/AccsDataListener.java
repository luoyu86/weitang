package com.taobao.accs.base;

import com.taobao.accs.base.TaoBaseService;

/* JADX INFO: loaded from: classes2.dex */
public interface AccsDataListener {
    @Deprecated
    void onAntiBrush(boolean z, TaoBaseService.ExtraInfo extraInfo);

    void onBind(String str, int i2, TaoBaseService.ExtraInfo extraInfo);

    @Deprecated
    void onConnected(TaoBaseService.ConnectInfo connectInfo);

    void onData(String str, String str2, String str3, byte[] bArr, TaoBaseService.ExtraInfo extraInfo);

    @Deprecated
    void onDisconnected(TaoBaseService.ConnectInfo connectInfo);

    void onResponse(String str, String str2, int i2, byte[] bArr, TaoBaseService.ExtraInfo extraInfo);

    void onSendData(String str, String str2, int i2, TaoBaseService.ExtraInfo extraInfo);

    void onUnbind(String str, int i2, TaoBaseService.ExtraInfo extraInfo);
}
