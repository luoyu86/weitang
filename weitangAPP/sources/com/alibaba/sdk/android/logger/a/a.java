package com.alibaba.sdk.android.logger.a;

import android.util.Log;
import com.alibaba.sdk.android.logger.IObjectLogFormat;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private HashMap<Class, IObjectLogFormat> f4651a = new HashMap<>();

    public String a(Object obj) {
        if (obj == null) {
            return "null";
        }
        int i2 = 0;
        if (obj instanceof Object[]) {
            StringBuilder sb = new StringBuilder();
            Object[] objArr = (Object[]) obj;
            sb.append("[");
            while (i2 < objArr.length) {
                if (i2 != 0) {
                    sb.append(", ");
                }
                sb.append(a(objArr[i2]));
                i2++;
            }
            sb.append("]");
            return sb.toString();
        }
        if (obj instanceof short[]) {
            StringBuilder sb2 = new StringBuilder();
            short[] sArr = (short[]) obj;
            sb2.append("[");
            while (i2 < sArr.length) {
                if (i2 != 0) {
                    sb2.append(", ");
                }
                sb2.append((int) sArr[i2]);
                i2++;
            }
            sb2.append("]");
            return sb2.toString();
        }
        if (obj instanceof int[]) {
            StringBuilder sb3 = new StringBuilder();
            int[] iArr = (int[]) obj;
            sb3.append("[");
            while (i2 < iArr.length) {
                if (i2 != 0) {
                    sb3.append(", ");
                }
                sb3.append(iArr[i2]);
                i2++;
            }
            sb3.append("]");
            return sb3.toString();
        }
        if (obj instanceof long[]) {
            StringBuilder sb4 = new StringBuilder();
            long[] jArr = (long[]) obj;
            sb4.append("[");
            while (i2 < jArr.length) {
                if (i2 != 0) {
                    sb4.append(", ");
                }
                sb4.append(jArr[i2]);
                i2++;
            }
            sb4.append("]");
            return sb4.toString();
        }
        if (obj instanceof boolean[]) {
            StringBuilder sb5 = new StringBuilder();
            boolean[] zArr = (boolean[]) obj;
            sb5.append("[");
            while (i2 < zArr.length) {
                if (i2 != 0) {
                    sb5.append(", ");
                }
                sb5.append(zArr[i2]);
                i2++;
            }
            sb5.append("]");
            return sb5.toString();
        }
        if (obj instanceof char[]) {
            StringBuilder sb6 = new StringBuilder();
            char[] cArr = (char[]) obj;
            sb6.append("[");
            while (i2 < cArr.length) {
                if (i2 != 0) {
                    sb6.append(", ");
                }
                sb6.append(cArr[i2]);
                i2++;
            }
            sb6.append("]");
            return sb6.toString();
        }
        if (obj instanceof float[]) {
            StringBuilder sb7 = new StringBuilder();
            float[] fArr = (float[]) obj;
            sb7.append("[");
            while (i2 < fArr.length) {
                if (i2 != 0) {
                    sb7.append(", ");
                }
                sb7.append(fArr[i2]);
                i2++;
            }
            sb7.append("]");
            return sb7.toString();
        }
        if (obj instanceof double[]) {
            StringBuilder sb8 = new StringBuilder();
            double[] dArr = (double[]) obj;
            sb8.append("[");
            while (i2 < dArr.length) {
                if (i2 != 0) {
                    sb8.append(", ");
                }
                sb8.append(dArr[i2]);
                i2++;
            }
            sb8.append("]");
            return sb8.toString();
        }
        if (!(obj instanceof byte[])) {
            if (obj instanceof Throwable) {
                return Log.getStackTraceString((Throwable) obj);
            }
            IObjectLogFormat iObjectLogFormat = this.f4651a.get(obj.getClass());
            return iObjectLogFormat != null ? iObjectLogFormat.format(obj) : obj.toString();
        }
        StringBuilder sb9 = new StringBuilder();
        byte[] bArr = (byte[]) obj;
        sb9.append("[");
        while (i2 < bArr.length) {
            if (i2 != 0) {
                sb9.append(", ");
            }
            sb9.append((int) bArr[i2]);
            i2++;
        }
        sb9.append("]");
        return sb9.toString();
    }

    public <T> void a(Class<T> cls, IObjectLogFormat<T> iObjectLogFormat) {
        this.f4651a.put(cls, iObjectLogFormat);
    }
}
