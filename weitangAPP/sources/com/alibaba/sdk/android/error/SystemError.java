package com.alibaba.sdk.android.error;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class SystemError extends ErrorCode {
    public static final String TYPE_SYSTEM = "ANDROID";

    public SystemError(String str, String str2, String str3, String[] strArr, boolean z) {
        super(str + "_ANDROID_" + str2, str3, null, strArr, z);
    }
}
