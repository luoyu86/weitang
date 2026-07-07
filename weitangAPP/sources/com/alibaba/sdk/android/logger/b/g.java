package com.alibaba.sdk.android.logger.b;

import com.taobao.accs.AccsClientConfig;

/* JADX INFO: loaded from: classes.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f4663a;

    public g(String str) {
        this.f4663a = str;
        if (str == null) {
            this.f4663a = AccsClientConfig.DEFAULT_CONFIG_TAG;
        }
    }

    public String a(Object obj) {
        String simpleName;
        if (obj == null) {
            simpleName = "";
        } else if (obj instanceof Class) {
            simpleName = ((Class) obj).getSimpleName();
        } else if (obj instanceof String) {
            simpleName = (String) obj;
        } else {
            simpleName = obj.getClass().getSimpleName() + "@" + obj.hashCode();
        }
        return this.f4663a + "_" + simpleName;
    }
}
