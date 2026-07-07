package com.qq.e.comm.util;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<String, Boolean> f9711a = new HashMap();

    public static boolean a(Class cls, String str, Class... clsArr) {
        String string;
        if (cls == null) {
            string = "";
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append(cls.getName());
            sb.append("#");
            sb.append(str);
            for (Class cls2 : clsArr) {
                sb.append("_");
                sb.append(cls2.getName());
            }
            string = sb.toString();
        }
        Map<String, Boolean> map = f9711a;
        Boolean bool = map.get(string);
        if (bool != null) {
            return Boolean.TRUE.equals(bool);
        }
        try {
            cls.getDeclaredMethod(str, clsArr);
            map.put(string, Boolean.TRUE);
            return true;
        } catch (NoSuchMethodException unused) {
            f9711a.put(string, Boolean.FALSE);
            return false;
        }
    }

    public static boolean a(Object obj) {
        if (obj == null) {
            return false;
        }
        return a(obj.getClass(), "onRenderFail", new Class[0]);
    }

    public static boolean b(Object obj) {
        if (obj == null) {
            return false;
        }
        return a(obj.getClass(), "onRenderSuccess", new Class[0]);
    }
}
