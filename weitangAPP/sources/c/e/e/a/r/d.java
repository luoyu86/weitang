package c.e.e.a.r;

import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public interface d {
    void onConnect();

    void onConnectError(String str);

    void onScanEnd();

    void onScanError(String str);

    void onScanStart();

    void onUnlockFailed(String str);

    void onUnlockPwdFailed(String str);

    void onUnlockSuccess();

    void onUnlocking();

    void uploadDoorCommands(List<c.m.a.e.a> list);
}
