package com.alibaba.fastjson.parser;

import com.alibaba.fastjson.annotation.JSONType;
import com.alibaba.fastjson.util.FieldInfo;
import com.alibaba.fastjson.util.TypeUtils;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class JavaBeanInfo {
    public final Constructor<?> creatorConstructor;
    public final String[] creatorConstructorParameters;
    public final Constructor<?> defaultConstructor;
    public final int defaultConstructorParameterSize;
    public final Method factoryMethod;
    public final FieldInfo[] fields;
    public final JSONType jsonType;
    public boolean ordered = false;
    public final int parserFeatures;
    public final FieldInfo[] sortedFields;
    public final boolean supportBeanToArray;
    public final String typeKey;
    public final long typeKeyHashCode;
    public final String typeName;

    public JavaBeanInfo(Class<?> cls, Constructor<?> constructor, Constructor<?> constructor2, Method method, FieldInfo[] fieldInfoArr, FieldInfo[] fieldInfoArr2, JSONType jSONType, String[] strArr) {
        int i2;
        boolean z;
        int length = 0;
        this.defaultConstructor = constructor;
        this.creatorConstructor = constructor2;
        this.factoryMethod = method;
        this.fields = fieldInfoArr;
        this.jsonType = jSONType;
        if (strArr == null || strArr.length != fieldInfoArr.length) {
            this.creatorConstructorParameters = strArr;
        } else {
            this.creatorConstructorParameters = null;
        }
        if (jSONType != null) {
            String strTypeName = jSONType.typeName();
            this.typeName = strTypeName.length() <= 0 ? cls.getName() : strTypeName;
            String strTypeKey = jSONType.typeKey();
            this.typeKey = strTypeKey.length() > 0 ? strTypeKey : null;
            i2 = 0;
            for (Feature feature : jSONType.parseFeatures()) {
                i2 |= feature.mask;
            }
        } else {
            this.typeName = cls.getName();
            this.typeKey = null;
            i2 = 0;
        }
        String str = this.typeKey;
        if (str == null) {
            this.typeKeyHashCode = 0L;
        } else {
            this.typeKeyHashCode = TypeUtils.fnv_64_lower(str);
        }
        this.parserFeatures = i2;
        if (jSONType != null) {
            Feature[] features = jSONType.parseFeatures();
            z = false;
            for (Feature feature2 : features) {
                if (feature2 == Feature.SupportArrayToBean) {
                    z = true;
                }
            }
        } else {
            z = false;
        }
        this.supportBeanToArray = z;
        FieldInfo[] fieldInfoArrComputeSortedFields = computeSortedFields(fieldInfoArr, fieldInfoArr2);
        this.sortedFields = Arrays.equals(fieldInfoArr, fieldInfoArrComputeSortedFields) ? fieldInfoArr : fieldInfoArrComputeSortedFields;
        if (constructor != null) {
            length = constructor.getParameterTypes().length;
        } else if (method != null) {
            length = method.getParameterTypes().length;
        }
        this.defaultConstructorParameterSize = length;
    }

    public static boolean addField(List<FieldInfo> list, FieldInfo fieldInfo, boolean z) {
        if (!z) {
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                FieldInfo fieldInfo2 = list.get(i2);
                if (fieldInfo2.name.equals(fieldInfo.name) && (!fieldInfo2.getOnly || fieldInfo.getOnly)) {
                    return false;
                }
            }
        }
        list.add(fieldInfo);
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:251:0x0581  */
    /* JADX WARN: Removed duplicated region for block: B:261:0x05da  */
    /* JADX WARN: Removed duplicated region for block: B:265:0x05e9  */
    /* JADX WARN: Removed duplicated region for block: B:286:0x0669  */
    /* JADX WARN: Removed duplicated region for block: B:310:0x06b3  */
    /* JADX WARN: Removed duplicated region for block: B:362:0x07b0  */
    /* JADX WARN: Removed duplicated region for block: B:364:0x07ff  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.alibaba.fastjson.parser.JavaBeanInfo build(java.lang.Class<?> r38, int r39, java.lang.reflect.Type r40, boolean r41, boolean r42, boolean r43, boolean r44, com.alibaba.fastjson.PropertyNamingStrategy r45) {
        /*
            Method dump skipped, instruction units count: 2110
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JavaBeanInfo.build(java.lang.Class, int, java.lang.reflect.Type, boolean, boolean, boolean, boolean, com.alibaba.fastjson.PropertyNamingStrategy):com.alibaba.fastjson.parser.JavaBeanInfo");
    }

    private FieldInfo[] computeSortedFields(FieldInfo[] fieldInfoArr, FieldInfo[] fieldInfoArr2) {
        String[] strArrOrders;
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        JSONType jSONType = this.jsonType;
        if (jSONType != null && (strArrOrders = jSONType.orders()) != null && strArrOrders.length != 0) {
            int i2 = 0;
            while (true) {
                if (i2 >= strArrOrders.length) {
                    z = true;
                    break;
                }
                int i3 = 0;
                while (true) {
                    if (i3 >= fieldInfoArr2.length) {
                        z4 = false;
                        break;
                    }
                    if (fieldInfoArr2[i3].name.equals(strArrOrders[i2])) {
                        z4 = true;
                        break;
                    }
                    i3++;
                }
                if (!z4) {
                    z = false;
                    break;
                }
                i2++;
            }
            if (!z) {
                return fieldInfoArr2;
            }
            if (strArrOrders.length == fieldInfoArr.length) {
                int i4 = 0;
                while (true) {
                    if (i4 >= strArrOrders.length) {
                        z3 = true;
                        break;
                    }
                    if (!fieldInfoArr2[i4].name.equals(strArrOrders[i4])) {
                        z3 = false;
                        break;
                    }
                    i4++;
                }
                if (z3) {
                    return fieldInfoArr2;
                }
                FieldInfo[] fieldInfoArr3 = new FieldInfo[fieldInfoArr2.length];
                for (int i5 = 0; i5 < strArrOrders.length; i5++) {
                    int i6 = 0;
                    while (true) {
                        if (i6 >= fieldInfoArr2.length) {
                            break;
                        }
                        if (fieldInfoArr2[i6].name.equals(strArrOrders[i5])) {
                            fieldInfoArr3[i5] = fieldInfoArr2[i6];
                            break;
                        }
                        i6++;
                    }
                }
                this.ordered = true;
                return fieldInfoArr3;
            }
            int length = fieldInfoArr2.length;
            FieldInfo[] fieldInfoArr4 = new FieldInfo[length];
            for (int i7 = 0; i7 < strArrOrders.length; i7++) {
                int i8 = 0;
                while (true) {
                    if (i8 >= fieldInfoArr2.length) {
                        break;
                    }
                    if (fieldInfoArr2[i8].name.equals(strArrOrders[i7])) {
                        fieldInfoArr4[i7] = fieldInfoArr2[i8];
                        break;
                    }
                    i8++;
                }
            }
            int length2 = strArrOrders.length;
            for (int i9 = 0; i9 < fieldInfoArr2.length; i9++) {
                for (int i10 = 0; i10 < length && i10 < length2; i10++) {
                    if (fieldInfoArr4[i9].equals(fieldInfoArr2[i10])) {
                        z2 = true;
                        break;
                    }
                }
                z2 = false;
                if (!z2) {
                    fieldInfoArr4[length2] = fieldInfoArr2[i9];
                    length2++;
                }
            }
            this.ordered = true;
        }
        return fieldInfoArr2;
    }
}
