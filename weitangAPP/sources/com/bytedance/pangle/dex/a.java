package com.bytedance.pangle.dex;

import com.bytedance.pangle.d.c;
import com.bytedance.pangle.e.b;
import com.bytedance.pangle.e.g;
import com.bytedance.pangle.util.FieldUtils;
import dalvik.system.DexFile;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.zip.ZipFile;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile int f5994a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile Constructor<?> f5995b;

    public static void a(ClassLoader classLoader, String str, int i2) throws IllegalAccessException, IOException {
        Object obj = FieldUtils.getField(classLoader.getClass(), "pathList").get(classLoader);
        ArrayList arrayList = new ArrayList();
        String[] strArrSplit = g.a(str, i2).split(":");
        String strC = c.c(str, i2);
        for (String str2 : strArrSplit) {
            Object objNative_load_direct_dex = DirectDex.native_load_direct_dex(str2);
            if (objNative_load_direct_dex == null) {
                objNative_load_direct_dex = DexFile.loadDex(str2, strC + File.separator + b.a(str2), 0);
            }
            arrayList.add(a(new File(str2), objNative_load_direct_dex));
        }
        Object[] array = arrayList.toArray();
        Field field = FieldUtils.getField(obj.getClass(), "dexElements");
        Object[] objArr = (Object[]) field.get(obj);
        Object[] objArr2 = (Object[]) Array.newInstance(objArr.getClass().getComponentType(), objArr.length + array.length);
        System.arraycopy(objArr, 0, objArr2, 0, objArr.length);
        System.arraycopy(array, 0, objArr2, objArr.length, array.length);
        field.set(obj, objArr2);
    }

    private static Object a(File file, Object obj) {
        Class<?> cls;
        int i2 = f5994a;
        Constructor<?> constructor = f5995b;
        if (constructor == null) {
            try {
                cls = Class.forName("dalvik.system.DexPathList$Element");
            } catch (Exception unused) {
                cls = null;
            }
        } else {
            cls = null;
        }
        if (constructor == null) {
            try {
                constructor = cls.getConstructor(File.class, Boolean.TYPE, File.class, DexFile.class);
                constructor.setAccessible(true);
                i2 = 8;
            } catch (Exception unused2) {
                constructor = null;
            }
        }
        if (constructor == null) {
            try {
                constructor = cls.getConstructor(File.class, ZipFile.class, DexFile.class);
                constructor.setAccessible(true);
                i2 = 4;
            } catch (Exception unused3) {
                constructor = null;
            }
        }
        if (constructor == null) {
            try {
                constructor = cls.getConstructor(File.class, File.class, DexFile.class);
                constructor.setAccessible(true);
                i2 = 2;
            } catch (Exception unused4) {
                constructor = null;
            }
        }
        if (constructor == null) {
            try {
                constructor = cls.getConstructor(File.class, Boolean.TYPE, File.class, DexFile.class);
                constructor.setAccessible(true);
                i2 = 1;
            } catch (Exception unused5) {
                constructor = null;
            }
        }
        f5995b = constructor;
        f5994a = i2;
        if (i2 != 1) {
            if (i2 == 2 || i2 == 4) {
                return a(constructor, file, null, obj);
            }
            if (i2 != 8) {
                return null;
            }
        }
        return a(constructor, file, Boolean.FALSE, null, obj);
    }

    private static Object a(Constructor<?> constructor, Object... objArr) {
        try {
            return constructor.newInstance(objArr);
        } catch (Exception unused) {
            return null;
        }
    }
}
