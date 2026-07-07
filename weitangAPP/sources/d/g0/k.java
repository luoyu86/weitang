package d.g0;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class k extends j {
    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> void a(T[] tArr, StringBuilder sb, List<Object[]> list) {
        if (list.contains(tArr)) {
            sb.append("[...]");
            return;
        }
        list.add(tArr);
        sb.append('[');
        int length = tArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (i2 != 0) {
                sb.append(", ");
            }
            Object[] objArr = tArr[i2];
            if (objArr == 0) {
                sb.append("null");
            } else if (objArr instanceof Object[]) {
                a(objArr, sb, list);
            } else if (objArr instanceof byte[]) {
                String string = Arrays.toString((byte[]) objArr);
                d.k0.d.t.checkNotNullExpressionValue(string, "java.util.Arrays.toString(this)");
                sb.append(string);
            } else if (objArr instanceof short[]) {
                String string2 = Arrays.toString((short[]) objArr);
                d.k0.d.t.checkNotNullExpressionValue(string2, "java.util.Arrays.toString(this)");
                sb.append(string2);
            } else if (objArr instanceof int[]) {
                String string3 = Arrays.toString((int[]) objArr);
                d.k0.d.t.checkNotNullExpressionValue(string3, "java.util.Arrays.toString(this)");
                sb.append(string3);
            } else if (objArr instanceof long[]) {
                String string4 = Arrays.toString((long[]) objArr);
                d.k0.d.t.checkNotNullExpressionValue(string4, "java.util.Arrays.toString(this)");
                sb.append(string4);
            } else if (objArr instanceof float[]) {
                String string5 = Arrays.toString((float[]) objArr);
                d.k0.d.t.checkNotNullExpressionValue(string5, "java.util.Arrays.toString(this)");
                sb.append(string5);
            } else if (objArr instanceof double[]) {
                String string6 = Arrays.toString((double[]) objArr);
                d.k0.d.t.checkNotNullExpressionValue(string6, "java.util.Arrays.toString(this)");
                sb.append(string6);
            } else if (objArr instanceof char[]) {
                String string7 = Arrays.toString((char[]) objArr);
                d.k0.d.t.checkNotNullExpressionValue(string7, "java.util.Arrays.toString(this)");
                sb.append(string7);
            } else if (objArr instanceof boolean[]) {
                String string8 = Arrays.toString((boolean[]) objArr);
                d.k0.d.t.checkNotNullExpressionValue(string8, "java.util.Arrays.toString(this)");
                sb.append(string8);
            } else if (objArr instanceof d.u) {
                sb.append(d.g0.j1.b.m187contentToString2csIQuQ(((d.u) objArr).m422unboximpl()));
            } else if (objArr instanceof d.b0) {
                sb.append(d.g0.j1.b.m191contentToStringd6D3K8(((d.b0) objArr).m117unboximpl()));
            } else if (objArr instanceof d.w) {
                sb.append(d.g0.j1.b.m190contentToStringXUkPCBk(((d.w) objArr).m446unboximpl()));
            } else if (objArr instanceof d.y) {
                sb.append(d.g0.j1.b.m193contentToStringuLth9ew(((d.y) objArr).m470unboximpl()));
            } else {
                sb.append(objArr.toString());
            }
        }
        sb.append(']');
        list.remove(s.getLastIndex(list));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> boolean contentDeepEquals(T[] tArr, T[] tArr2) {
        if (tArr == tArr2) {
            return true;
        }
        if (tArr == 0 || tArr2 == 0 || tArr.length != tArr2.length) {
            return false;
        }
        int length = tArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            Object[] objArr = tArr[i2];
            Object[] objArr2 = tArr2[i2];
            if (objArr != objArr2) {
                if (objArr == 0 || objArr2 == 0) {
                    return false;
                }
                if ((objArr instanceof Object[]) && (objArr2 instanceof Object[])) {
                    if (!contentDeepEquals(objArr, objArr2)) {
                        return false;
                    }
                } else if ((objArr instanceof byte[]) && (objArr2 instanceof byte[])) {
                    if (!Arrays.equals((byte[]) objArr, (byte[]) objArr2)) {
                        return false;
                    }
                } else if ((objArr instanceof short[]) && (objArr2 instanceof short[])) {
                    if (!Arrays.equals((short[]) objArr, (short[]) objArr2)) {
                        return false;
                    }
                } else if ((objArr instanceof int[]) && (objArr2 instanceof int[])) {
                    if (!Arrays.equals((int[]) objArr, (int[]) objArr2)) {
                        return false;
                    }
                } else if ((objArr instanceof long[]) && (objArr2 instanceof long[])) {
                    if (!Arrays.equals((long[]) objArr, (long[]) objArr2)) {
                        return false;
                    }
                } else if ((objArr instanceof float[]) && (objArr2 instanceof float[])) {
                    if (!Arrays.equals((float[]) objArr, (float[]) objArr2)) {
                        return false;
                    }
                } else if ((objArr instanceof double[]) && (objArr2 instanceof double[])) {
                    if (!Arrays.equals((double[]) objArr, (double[]) objArr2)) {
                        return false;
                    }
                } else if ((objArr instanceof char[]) && (objArr2 instanceof char[])) {
                    if (!Arrays.equals((char[]) objArr, (char[]) objArr2)) {
                        return false;
                    }
                } else if ((objArr instanceof boolean[]) && (objArr2 instanceof boolean[])) {
                    if (!Arrays.equals((boolean[]) objArr, (boolean[]) objArr2)) {
                        return false;
                    }
                } else if ((objArr instanceof d.u) && (objArr2 instanceof d.u)) {
                    if (!d.g0.j1.b.m173contentEqualskV0jMPg(((d.u) objArr).m422unboximpl(), ((d.u) objArr2).m422unboximpl())) {
                        return false;
                    }
                } else if ((objArr instanceof d.b0) && (objArr2 instanceof d.b0)) {
                    if (!d.g0.j1.b.m170contentEqualsFGO6Aew(((d.b0) objArr).m117unboximpl(), ((d.b0) objArr2).m117unboximpl())) {
                        return false;
                    }
                } else if ((objArr instanceof d.w) && (objArr2 instanceof d.w)) {
                    if (!d.g0.j1.b.m171contentEqualsKJPZfPQ(((d.w) objArr).m446unboximpl(), ((d.w) objArr2).m446unboximpl())) {
                        return false;
                    }
                } else if ((objArr instanceof d.y) && (objArr2 instanceof d.y)) {
                    if (!d.g0.j1.b.m175contentEqualslec5QzE(((d.y) objArr).m470unboximpl(), ((d.y) objArr2).m470unboximpl())) {
                        return false;
                    }
                } else if (!d.k0.d.t.areEqual(objArr, objArr2)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static final <T> String contentDeepToString(T[] tArr) {
        if (tArr == null) {
            return "null";
        }
        StringBuilder sb = new StringBuilder((d.m0.p.coerceAtMost(tArr.length, 429496729) * 5) + 2);
        a(tArr, sb, new ArrayList());
        String string = sb.toString();
        d.k0.d.t.checkNotNullExpressionValue(string, "StringBuilder(capacity).…builderAction).toString()");
        return string;
    }

    public static final <T> List<T> flatten(T[][] tArr) {
        d.k0.d.t.checkNotNullParameter(tArr, "$this$flatten");
        int length = 0;
        for (T[] tArr2 : tArr) {
            length += tArr2.length;
        }
        ArrayList arrayList = new ArrayList(length);
        for (T[] tArr3 : tArr) {
            x.addAll(arrayList, tArr3);
        }
        return arrayList;
    }

    public static final <T, R> d.m<List<T>, List<R>> unzip(d.m<? extends T, ? extends R>[] mVarArr) {
        d.k0.d.t.checkNotNullParameter(mVarArr, "$this$unzip");
        ArrayList arrayList = new ArrayList(mVarArr.length);
        ArrayList arrayList2 = new ArrayList(mVarArr.length);
        for (d.m<? extends T, ? extends R> mVar : mVarArr) {
            arrayList.add(mVar.getFirst());
            arrayList2.add(mVar.getSecond());
        }
        return d.s.to(arrayList, arrayList2);
    }
}
