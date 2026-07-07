package com.alibaba.sdk.android.error;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class ServerError extends ErrorCode {
    public static final String TYPE_SERVER = "SERVER";

    public ServerError(String str, String str2, String str3, String[] strArr, boolean z) {
        super(str + "_SERVER_" + str2, str3, null, strArr, z);
    }
}
