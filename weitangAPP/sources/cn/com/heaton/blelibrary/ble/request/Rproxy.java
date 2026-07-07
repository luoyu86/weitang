package cn.com.heaton.blelibrary.ble.request;

import android.content.Context;
import cn.com.heaton.blelibrary.ble.annotation.Implement;
import dalvik.system.DexFile;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class Rproxy {
    private static final Rproxy s_instance = new Rproxy();
    private Map<Class, Object> mRequestObjs = new HashMap();

    private Rproxy() {
    }

    public static Rproxy getInstance() {
        return s_instance;
    }

    private List<Class> getRequestsClass(Context context, String str) {
        ArrayList arrayList = new ArrayList();
        try {
            Enumeration<String> enumerationEntries = new DexFile(context.getPackageCodePath()).entries();
            while (enumerationEntries.hasMoreElements()) {
                String strNextElement = enumerationEntries.nextElement();
                if (strNextElement.contains(str) && !strNextElement.contains("$")) {
                    try {
                        arrayList.add(Class.forName(strNextElement));
                    } catch (ClassNotFoundException e2) {
                        e2.printStackTrace();
                    }
                }
            }
        } catch (IOException e3) {
            e3.printStackTrace();
        }
        return arrayList;
    }

    public <T> T getRequest(Class cls) {
        return (T) this.mRequestObjs.get(cls);
    }

    public void init(Class... clsArr) {
        for (Class cls : clsArr) {
            if (cls.isAnnotationPresent(Implement.class)) {
                for (Annotation annotation : cls.getDeclaredAnnotations()) {
                    if (annotation instanceof Implement) {
                        try {
                            this.mRequestObjs.put(cls, ((Implement) annotation).value().newInstance());
                        } catch (IllegalAccessException e2) {
                            e2.printStackTrace();
                        } catch (InstantiationException e3) {
                            e3.printStackTrace();
                        }
                    }
                }
            }
        }
    }
}
