package com.alibaba.sdk.android.error;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class SdkError extends ErrorCode {
    public static final String TYPE_SDK = "SDK";

    public SdkError(String str, String str2, String str3, String[] strArr, boolean z) {
        super(str + "_SDK_" + str2, str3, null, strArr, z);
    }
}
