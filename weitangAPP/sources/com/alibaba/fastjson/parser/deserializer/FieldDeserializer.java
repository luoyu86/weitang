package com.alibaba.fastjson.parser.deserializer;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.util.FieldInfo;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public abstract class FieldDeserializer {
    public final Class<?> clazz;
    public long[] enumNameHashCodes;
    public Enum[] enums;
    public final FieldInfo fieldInfo;

    public FieldDeserializer(Class<?> cls, FieldInfo fieldInfo, int i2) {
        this.clazz = cls;
        this.fieldInfo = fieldInfo;
        if (fieldInfo == null) {
            return;
        }
        Class<?> cls2 = fieldInfo.fieldClass;
        if (cls2.isEnum()) {
            Enum[] enumArr = (Enum[]) cls2.getEnumConstants();
            int length = enumArr.length;
            long[] jArr = new long[length];
            this.enumNameHashCodes = new long[enumArr.length];
            for (int i3 = 0; i3 < enumArr.length; i3++) {
                String strName = enumArr[i3].name();
                long jCharAt = -3750763034362895579L;
                for (int i4 = 0; i4 < strName.length(); i4++) {
                    jCharAt = (jCharAt ^ ((long) strName.charAt(i4))) * 1099511628211L;
                }
                jArr[i3] = jCharAt;
                this.enumNameHashCodes[i3] = jCharAt;
            }
            Arrays.sort(this.enumNameHashCodes);
            this.enums = new Enum[enumArr.length];
            for (int i5 = 0; i5 < this.enumNameHashCodes.length; i5++) {
                int i6 = 0;
                while (true) {
                    if (i6 >= length) {
                        break;
                    }
                    if (this.enumNameHashCodes[i5] == jArr[i6]) {
                        this.enums[i5] = enumArr[i6];
                        break;
                    }
                    i6++;
                }
            }
        }
    }

    public Enum getEnumByHashCode(long j) {
        int iBinarySearch;
        if (this.enums != null && (iBinarySearch = Arrays.binarySearch(this.enumNameHashCodes, j)) >= 0) {
            return this.enums[iBinarySearch];
        }
        return null;
    }

    public abstract void parseField(DefaultJSONParser defaultJSONParser, Object obj, Type type, Map<String, Object> map);

    public void setValue(Object obj, int i2) throws IllegalAccessException {
        this.fieldInfo.field.setInt(obj, i2);
    }

    public void setValue(Object obj, long j) throws IllegalAccessException {
        this.fieldInfo.field.setLong(obj, j);
    }

    public void setValue(Object obj, float f2) throws IllegalAccessException {
        this.fieldInfo.field.setFloat(obj, f2);
    }

    public void setValue(Object obj, double d2) throws IllegalAccessException {
        this.fieldInfo.field.setDouble(obj, d2);
    }

    public void setValue(Object obj, Object obj2) {
        if (obj2 == null && this.fieldInfo.fieldClass.isPrimitive()) {
            return;
        }
        FieldInfo fieldInfo = this.fieldInfo;
        Field field = fieldInfo.field;
        Method method = fieldInfo.method;
        try {
            if (fieldInfo.fieldAccess) {
                if (fieldInfo.getOnly) {
                    if (Map.class.isAssignableFrom(fieldInfo.fieldClass)) {
                        Map map = (Map) field.get(obj);
                        if (map != null) {
                            map.putAll((Map) obj2);
                            return;
                        }
                        return;
                    }
                    Collection collection = (Collection) field.get(obj);
                    if (collection != null) {
                        collection.addAll((Collection) obj2);
                        return;
                    }
                    return;
                }
                field.set(obj, obj2);
                return;
            }
            if (fieldInfo.getOnly) {
                if (Map.class.isAssignableFrom(fieldInfo.fieldClass)) {
                    Map map2 = (Map) method.invoke(obj, new Object[0]);
                    if (map2 != null) {
                        map2.putAll((Map) obj2);
                        return;
                    }
                    return;
                }
                Collection collection2 = (Collection) method.invoke(obj, new Object[0]);
                if (collection2 != null) {
                    collection2.addAll((Collection) obj2);
                    return;
                }
                return;
            }
            method.invoke(obj, obj2);
        } catch (Exception e2) {
            throw new JSONException("set property error, " + this.fieldInfo.name, e2);
        }
    }
}
