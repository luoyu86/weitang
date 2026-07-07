package com.bytedance.pangle.g;

import android.content.pm.Signature;
import android.util.ArraySet;
import androidx.annotation.Nullable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.security.PublicKey;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final o f6099a = new o(null, 0, null, null, null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    public final Signature[] f6100b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f6101c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    public final ArraySet<PublicKey> f6102d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Nullable
    public final Signature[] f6103e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Nullable
    public final int[] f6104f;

    public o(Signature[] signatureArr, int i2, ArraySet<PublicKey> arraySet, Signature[] signatureArr2, int[] iArr) {
        this.f6100b = signatureArr;
        this.f6101c = i2;
        this.f6102d = arraySet;
        this.f6103e = signatureArr2;
        this.f6104f = iArr;
    }

    private static ArraySet<PublicKey> a(Signature[] signatureArr) {
        ArraySet<PublicKey> arraySet = new ArraySet<>(signatureArr.length);
        for (Signature signature : signatureArr) {
            Method method = null;
            try {
                method = Signature.class.getMethod("getPublicKey", new Class[0]);
            } catch (NoSuchMethodException e2) {
                e2.printStackTrace();
            }
            if (method != null && method.isAccessible()) {
                try {
                    arraySet.add((PublicKey) method.invoke(signature, new Object[0]));
                } catch (IllegalAccessException e3) {
                    e3.printStackTrace();
                } catch (InvocationTargetException e4) {
                    e4.printStackTrace();
                } catch (Exception e5) {
                    e5.printStackTrace();
                }
            }
        }
        return arraySet;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof o)) {
            return false;
        }
        o oVar = (o) obj;
        if (this.f6101c != oVar.f6101c || !a(this.f6100b, oVar.f6100b)) {
            return false;
        }
        ArraySet<PublicKey> arraySet = this.f6102d;
        if (arraySet != null) {
            if (!arraySet.equals(oVar.f6102d)) {
                return false;
            }
        } else if (oVar.f6102d != null) {
            return false;
        }
        return Arrays.equals(this.f6103e, oVar.f6103e) && Arrays.equals(this.f6104f, oVar.f6104f);
    }

    public final int hashCode() {
        int iHashCode = ((Arrays.hashCode(this.f6100b) * 31) + this.f6101c) * 31;
        ArraySet<PublicKey> arraySet = this.f6102d;
        return ((((iHashCode + (arraySet != null ? arraySet.hashCode() : 0)) * 31) + Arrays.hashCode(this.f6103e)) * 31) + Arrays.hashCode(this.f6104f);
    }

    public o(Signature[] signatureArr, int i2, Signature[] signatureArr2, int[] iArr) {
        this(signatureArr, i2, a(signatureArr), signatureArr2, iArr);
    }

    public o(Signature[] signatureArr) {
        this(signatureArr, 2, null, null);
    }

    public static boolean a(Signature[] signatureArr, Signature[] signatureArr2) {
        return signatureArr.length == signatureArr2.length && com.bytedance.pangle.util.d.a((Object[]) signatureArr, (Object[]) signatureArr2) && com.bytedance.pangle.util.d.a((Object[]) signatureArr2, (Object[]) signatureArr);
    }

    public static boolean a(byte[] bArr, byte[] bArr2) {
        if (bArr.length != bArr2.length) {
            return false;
        }
        for (int i2 = 0; i2 < bArr.length; i2++) {
            if (bArr[i2] != bArr2[i2]) {
                return false;
            }
        }
        return true;
    }
}
