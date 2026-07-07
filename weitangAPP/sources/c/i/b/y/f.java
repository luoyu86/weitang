package c.i.b.y;

import java.io.ObjectStreamException;
import java.math.BigDecimal;

/* JADX INFO: loaded from: classes2.dex */
public final class f extends Number {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f2654a;

    public f(String str) {
        this.f2654a = str;
    }

    private Object writeReplace() throws ObjectStreamException {
        return new BigDecimal(this.f2654a);
    }

    @Override // java.lang.Number
    public double doubleValue() {
        return Double.parseDouble(this.f2654a);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        String str = this.f2654a;
        String str2 = ((f) obj).f2654a;
        return str == str2 || str.equals(str2);
    }

    @Override // java.lang.Number
    public float floatValue() {
        return Float.parseFloat(this.f2654a);
    }

    public int hashCode() {
        return this.f2654a.hashCode();
    }

    @Override // java.lang.Number
    public int intValue() {
        try {
            try {
                return Integer.parseInt(this.f2654a);
            } catch (NumberFormatException unused) {
                return new BigDecimal(this.f2654a).intValue();
            }
        } catch (NumberFormatException unused2) {
            return (int) Long.parseLong(this.f2654a);
        }
    }

    @Override // java.lang.Number
    public long longValue() {
        try {
            return Long.parseLong(this.f2654a);
        } catch (NumberFormatException unused) {
            return new BigDecimal(this.f2654a).longValue();
        }
    }

    public String toString() {
        return this.f2654a;
    }
}
