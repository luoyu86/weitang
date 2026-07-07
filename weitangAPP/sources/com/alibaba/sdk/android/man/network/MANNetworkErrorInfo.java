package com.alibaba.sdk.android.man.network;

import com.alibaba.sdk.android.man.util.ToolKit;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public class MANNetworkErrorInfo {
    private final HashMap<String, String> properties;

    public MANNetworkErrorInfo(HashMap<String, String> map) {
        this.properties = map;
    }

    public HashMap<String, String> getProperties() {
        return this.properties;
    }

    public MANNetworkErrorInfo withExtraInfo(String str, String str2) {
        if (!ToolKit.isNullOrEmpty(str) && !ToolKit.isNullOrEmpty(str2)) {
            this.properties.put(str, str2);
        }
        return this;
    }
}
