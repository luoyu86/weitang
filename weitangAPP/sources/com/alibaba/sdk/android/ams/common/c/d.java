package com.alibaba.sdk.android.ams.common.c;

import com.alibaba.sdk.android.ams.common.logger.AmsLogger;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final AmsLogger f4593a = AmsLogger.getLogger("ServiceLoader");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f4594b = com.alibaba.sdk.android.push.d.a.c.class.getName();

    public static <T> List<T> a(Class<T> cls, ClassLoader classLoader) {
        String name = cls.getName();
        try {
            ArrayList arrayList = new ArrayList();
            arrayList.add(cls.cast(classLoader.loadClass(f4594b).newInstance()));
            return arrayList;
        } catch (Exception e2) {
            throw new IllegalStateException("Fail to load ams-spi-services for " + name, e2);
        }
    }
}
