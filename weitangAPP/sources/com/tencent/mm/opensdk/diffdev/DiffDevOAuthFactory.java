package com.tencent.mm.opensdk.diffdev;

import com.tencent.mm.opensdk.diffdev.a.a;
import com.tencent.mm.opensdk.utils.Log;

/* JADX INFO: loaded from: classes2.dex */
public class DiffDevOAuthFactory {
    public static final int MAX_SUPPORTED_VERSION = 1;
    private static final String TAG = "MicroMsg.SDK.DiffDevOAuthFactory";
    public static final int VERSION_1 = 1;
    private static IDiffDevOAuth v1Instance;

    private DiffDevOAuthFactory() {
    }

    public static IDiffDevOAuth getDiffDevOAuth() {
        return getDiffDevOAuth(1);
    }

    public static IDiffDevOAuth getDiffDevOAuth(int i2) {
        Log.v(TAG, "getDiffDevOAuth, version = ".concat(String.valueOf(i2)));
        if (i2 > 1) {
            Log.e(TAG, "getDiffDevOAuth fail, unsupported version = ".concat(String.valueOf(i2)));
            return null;
        }
        if (i2 != 1) {
            return null;
        }
        if (v1Instance == null) {
            v1Instance = new a();
        }
        return v1Instance;
    }
}
