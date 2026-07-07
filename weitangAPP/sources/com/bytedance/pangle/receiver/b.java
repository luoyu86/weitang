package com.bytedance.pangle.receiver;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.bytedance.pangle.util.FieldUtils;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import org.android.agoo.common.AgooConstants;

/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final c f6184a;

    public static class a implements c {
        private a() {
        }

        private static Object b(Context context) {
            Field field;
            Object field2;
            try {
                Field field3 = FieldUtils.getField(Class.forName("android.app.LoadedApk"), "mReceiverResource");
                if (field3 == null || (field = FieldUtils.getField(Class.forName("android.app.ContextImpl"), "mPackageInfo")) == null || (field2 = FieldUtils.readField(field, context)) == null) {
                    return null;
                }
                return FieldUtils.readField(field3, field2);
            } catch (Throwable unused) {
                return null;
            }
        }

        @Override // com.bytedance.pangle.receiver.b.c
        public boolean a(Context context) throws IllegalAccessException {
            Object objB = b(context);
            Object objA = a(objB, "mWhiteList");
            if (!(objA instanceof String[])) {
                if (objB == null) {
                    return false;
                }
                FieldUtils.writeField(objB, "mResourceConfig", (Object) null);
                return false;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(context.getPackageName());
            Collections.addAll(arrayList, (String[]) objA);
            FieldUtils.writeField(objB, "mWhiteList", arrayList.toArray(new String[arrayList.size()]));
            return true;
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static Object a(Context context, String str) {
            return a(b(context), str);
        }

        private static Object a(Object obj, String str) {
            if (obj == null) {
                return null;
            }
            try {
                return FieldUtils.readField(obj, str);
            } catch (Throwable unused) {
                return null;
            }
        }
    }

    /* JADX INFO: renamed from: com.bytedance.pangle.receiver.b$b, reason: collision with other inner class name */
    public static class C0106b extends e {
        private C0106b() {
            super((byte) 0);
        }

        @Override // com.bytedance.pangle.receiver.b.e, com.bytedance.pangle.receiver.b.a, com.bytedance.pangle.receiver.b.c
        public final boolean a(Context context) {
            return false;
        }

        public /* synthetic */ C0106b(byte b2) {
            this();
        }
    }

    public interface c {
        boolean a(Context context);
    }

    public static class d extends a {
        private d() {
            super((byte) 0);
        }

        @Override // com.bytedance.pangle.receiver.b.a, com.bytedance.pangle.receiver.b.c
        public final boolean a(Context context) {
            Object objA = a.a(context, "mWhiteList");
            if (!(objA instanceof List)) {
                return false;
            }
            ((List) objA).add(context.getPackageName());
            return true;
        }

        public /* synthetic */ d(byte b2) {
            this();
        }
    }

    public static class e extends a {
        private e() {
            super((byte) 0);
        }

        @Override // com.bytedance.pangle.receiver.b.a, com.bytedance.pangle.receiver.b.c
        public boolean a(Context context) {
            Object objA = a.a(context, "mWhiteListMap");
            if (!(objA instanceof Map)) {
                return false;
            }
            Map map = (Map) objA;
            List arrayList = (List) map.get(0);
            if (arrayList == null) {
                arrayList = new ArrayList();
                map.put(0, arrayList);
            }
            arrayList.add(context.getPackageName());
            return true;
        }

        public /* synthetic */ e(byte b2) {
            this();
        }
    }

    static {
        int i2 = Build.VERSION.SDK_INT;
        byte b2 = 0;
        if (i2 < 24) {
            f6184a = new a(b2);
            return;
        }
        if (i2 < 26) {
            f6184a = new d(b2);
        } else if (i2 < 28) {
            f6184a = new e(b2);
        } else {
            f6184a = new C0106b(b2);
        }
    }

    public static void a(Application application) {
        if (application != null) {
            try {
                if (TextUtils.equals(Build.BRAND.toLowerCase(), AgooConstants.MESSAGE_SYSTEM_SOURCE_HUAWEI)) {
                    f6184a.a(application.getBaseContext());
                }
            } catch (Throwable unused) {
            }
        }
    }
}
