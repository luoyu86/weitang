package com.taobao.accs.utl;

import com.alibaba.sdk.android.error.ErrorCode;
import com.taobao.accs.AccsErrorCode;
import com.taobao.accs.IAppReceiver;
import com.taobao.accs.IAppReceiverV1;
import com.taobao.accs.IAppReceiverV2;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class c extends IAppReceiverV2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final IAppReceiver f10475a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f10476b = false;

    private c(IAppReceiver iAppReceiver) {
        this.f10475a = iAppReceiver;
    }

    public static IAppReceiver a(IAppReceiver iAppReceiver) {
        if (iAppReceiver == null) {
            return null;
        }
        return new c(iAppReceiver);
    }

    public static void b(ErrorCode errorCode, IAppReceiver iAppReceiver, String str) {
        if (iAppReceiver instanceof IAppReceiverV2) {
            ((IAppReceiverV2) iAppReceiver).onBindUser(str, errorCode.getCodeInt(), errorCode.getMsg());
        } else {
            iAppReceiver.onBindUser(str, errorCode.getCodeInt());
        }
    }

    public boolean equals(Object obj) {
        return obj instanceof c ? this.f10475a.equals(((c) obj).f10475a) : this.f10475a.equals(obj);
    }

    @Override // com.taobao.accs.IAppReceiverV1, com.taobao.accs.IAppReceiver
    public Map<String, String> getAllServices() {
        return this.f10475a.getAllServices();
    }

    @Override // com.taobao.accs.IAppReceiverV1, com.taobao.accs.IAppReceiver
    public String getService(String str) {
        return this.f10475a.getService(str);
    }

    public int hashCode() {
        return this.f10475a.hashCode();
    }

    @Override // com.taobao.accs.IAppReceiverV1, com.taobao.accs.IAppReceiver
    public void onBindApp(int i2) {
        if (this.f10476b) {
            return;
        }
        this.f10476b = true;
        this.f10475a.onBindApp(i2);
    }

    @Override // com.taobao.accs.IAppReceiverV2, com.taobao.accs.IAppReceiverV1, com.taobao.accs.IAppReceiver
    public void onBindUser(String str, int i2) {
        this.f10475a.onBindUser(str, i2);
    }

    @Override // com.taobao.accs.IAppReceiverV1, com.taobao.accs.IAppReceiver
    public void onData(String str, String str2, byte[] bArr) {
        this.f10475a.onData(str, str2, bArr);
    }

    @Override // com.taobao.accs.IAppReceiverV1, com.taobao.accs.IAppReceiver
    public void onSendData(String str, int i2) {
        this.f10475a.onSendData(str, i2);
    }

    @Override // com.taobao.accs.IAppReceiverV2, com.taobao.accs.IAppReceiverV1, com.taobao.accs.IAppReceiver
    public void onUnbindApp(int i2) {
        if (this.f10476b) {
            this.f10476b = false;
            this.f10475a.onUnbindApp(i2);
        }
    }

    @Override // com.taobao.accs.IAppReceiverV2, com.taobao.accs.IAppReceiverV1, com.taobao.accs.IAppReceiver
    public void onUnbindUser(int i2) {
        this.f10475a.onUnbindUser(i2);
    }

    public static void a(ErrorCode errorCode, IAppReceiver iAppReceiver, String str) {
        if (iAppReceiver instanceof IAppReceiverV2) {
            ((IAppReceiverV2) iAppReceiver).onBindApp(errorCode.getCodeInt(), errorCode.getMsg(), str);
        } else if (iAppReceiver instanceof IAppReceiverV1) {
            ((IAppReceiverV1) iAppReceiver).onBindApp(errorCode.getCodeInt(), str);
        } else {
            iAppReceiver.onBindApp(errorCode.getCodeInt());
        }
    }

    @Override // com.taobao.accs.IAppReceiverV2
    public void onBindUser(String str, int i2, String str2) {
        IAppReceiver iAppReceiver = this.f10475a;
        if (iAppReceiver instanceof IAppReceiverV2) {
            ((IAppReceiverV2) iAppReceiver).onBindUser(str, i2, str2);
        } else {
            iAppReceiver.onBindUser(str, i2);
        }
    }

    @Override // com.taobao.accs.IAppReceiverV2
    public void onUnbindUser(int i2, String str) {
        IAppReceiver iAppReceiver = this.f10475a;
        if (iAppReceiver instanceof IAppReceiverV2) {
            ((IAppReceiverV2) iAppReceiver).onUnbindUser(i2, str);
        } else {
            iAppReceiver.onUnbindUser(i2);
        }
    }

    public static void b(ErrorCode errorCode, IAppReceiver iAppReceiver) {
        if (iAppReceiver instanceof IAppReceiverV2) {
            ((IAppReceiverV2) iAppReceiver).onUnbindUser(errorCode.getCodeInt(), errorCode.getMsg());
        } else {
            iAppReceiver.onUnbindUser(errorCode.getCodeInt());
        }
    }

    @Override // com.taobao.accs.IAppReceiverV2, com.taobao.accs.IAppReceiverV1
    public void onBindApp(int i2, String str) {
        if (this.f10476b) {
            return;
        }
        this.f10476b = true;
        IAppReceiver iAppReceiver = this.f10475a;
        if (iAppReceiver instanceof IAppReceiverV1) {
            ((IAppReceiverV1) iAppReceiver).onBindApp(i2, str);
        } else {
            iAppReceiver.onBindApp(i2);
        }
    }

    @Override // com.taobao.accs.IAppReceiverV2
    public void onUnbindApp(int i2, String str) {
        if (this.f10476b) {
            this.f10476b = false;
            IAppReceiver iAppReceiver = this.f10475a;
            if (iAppReceiver instanceof IAppReceiverV2) {
                ((IAppReceiverV2) iAppReceiver).onUnbindApp(i2, str);
            } else {
                iAppReceiver.onUnbindApp(i2);
            }
        }
    }

    public static void a(ErrorCode errorCode, IAppReceiver iAppReceiver) {
        if (iAppReceiver instanceof IAppReceiverV2) {
            ((IAppReceiverV2) iAppReceiver).onUnbindApp(errorCode.getCodeInt(), errorCode.getMsg());
        } else {
            iAppReceiver.onUnbindApp(errorCode.getCodeInt());
        }
    }

    @Override // com.taobao.accs.IAppReceiverV2
    public void onBindApp(int i2, String str, String str2) {
        if (this.f10476b) {
            return;
        }
        if (i2 == AccsErrorCode.SUCCESS.getCodeInt()) {
            this.f10476b = true;
        }
        IAppReceiver iAppReceiver = this.f10475a;
        if (iAppReceiver instanceof IAppReceiverV2) {
            ((IAppReceiverV2) iAppReceiver).onBindApp(i2, str, str2);
        } else if (iAppReceiver instanceof IAppReceiverV1) {
            ((IAppReceiverV1) iAppReceiver).onBindApp(i2, str2);
        } else {
            iAppReceiver.onBindApp(i2);
        }
    }
}
