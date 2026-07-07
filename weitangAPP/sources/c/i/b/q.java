package c.i.b;

import java.math.BigDecimal;
import java.math.BigInteger;

/* JADX INFO: loaded from: classes2.dex */
public final class q extends l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Class<?>[] f2616a = {Integer.TYPE, Long.TYPE, Short.TYPE, Float.TYPE, Double.TYPE, Byte.TYPE, Boolean.TYPE, Character.TYPE, Integer.class, Long.class, Short.class, Float.class, Double.class, Byte.class, Boolean.class, Character.class};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object f2617b;

    public q(Boolean bool) {
        d(bool);
    }

    public static boolean b(q qVar) {
        Object obj = qVar.f2617b;
        if (!(obj instanceof Number)) {
            return false;
        }
        Number number = (Number) obj;
        return (number instanceof BigInteger) || (number instanceof Long) || (number instanceof Integer) || (number instanceof Short) || (number instanceof Byte);
    }

    public static boolean c(Object obj) {
        if (obj instanceof String) {
            return true;
        }
        Class<?> cls = obj.getClass();
        for (Class<?> cls2 : f2616a) {
            if (cls2.isAssignableFrom(cls)) {
                return true;
            }
        }
        return false;
    }

    public Boolean a() {
        return (Boolean) this.f2617b;
    }

    public void d(Object obj) {
        if (obj instanceof Character) {
            this.f2617b = String.valueOf(((Character) obj).charValue());
        } else {
            c.i.b.y.a.checkArgument((obj instanceof Number) || c(obj));
            this.f2617b = obj;
        }
    }

    @Override // c.i.b.l
    public q deepCopy() {
        return this;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || q.class != obj.getClass()) {
            return false;
        }
        q qVar = (q) obj;
        if (this.f2617b == null) {
            return qVar.f2617b == null;
        }
        if (b(this) && b(qVar)) {
            return getAsNumber().longValue() == qVar.getAsNumber().longValue();
        }
        Object obj2 = this.f2617b;
        if (!(obj2 instanceof Number) || !(qVar.f2617b instanceof Number)) {
            return obj2.equals(qVar.f2617b);
        }
        double dDoubleValue = getAsNumber().doubleValue();
        double dDoubleValue2 = qVar.getAsNumber().doubleValue();
        if (dDoubleValue != dDoubleValue2) {
            return Double.isNaN(dDoubleValue) && Double.isNaN(dDoubleValue2);
        }
        return true;
    }

    @Override // c.i.b.l
    public BigDecimal getAsBigDecimal() {
        Object obj = this.f2617b;
        return obj instanceof BigDecimal ? (BigDecimal) obj : new BigDecimal(this.f2617b.toString());
    }

    @Override // c.i.b.l
    public BigInteger getAsBigInteger() {
        Object obj = this.f2617b;
        return obj instanceof BigInteger ? (BigInteger) obj : new BigInteger(this.f2617b.toString());
    }

    @Override // c.i.b.l
    public boolean getAsBoolean() {
        return isBoolean() ? a().booleanValue() : Boolean.parseBoolean(getAsString());
    }

    @Override // c.i.b.l
    public byte getAsByte() {
        return isNumber() ? getAsNumber().byteValue() : Byte.parseByte(getAsString());
    }

    @Override // c.i.b.l
    public char getAsCharacter() {
        return getAsString().charAt(0);
    }

    @Override // c.i.b.l
    public double getAsDouble() {
        return isNumber() ? getAsNumber().doubleValue() : Double.parseDouble(getAsString());
    }

    @Override // c.i.b.l
    public float getAsFloat() {
        return isNumber() ? getAsNumber().floatValue() : Float.parseFloat(getAsString());
    }

    @Override // c.i.b.l
    public int getAsInt() {
        return isNumber() ? getAsNumber().intValue() : Integer.parseInt(getAsString());
    }

    @Override // c.i.b.l
    public long getAsLong() {
        return isNumber() ? getAsNumber().longValue() : Long.parseLong(getAsString());
    }

    @Override // c.i.b.l
    public Number getAsNumber() {
        Object obj = this.f2617b;
        return obj instanceof String ? new c.i.b.y.f((String) this.f2617b) : (Number) obj;
    }

    @Override // c.i.b.l
    public short getAsShort() {
        return isNumber() ? getAsNumber().shortValue() : Short.parseShort(getAsString());
    }

    @Override // c.i.b.l
    public String getAsString() {
        return isNumber() ? getAsNumber().toString() : isBoolean() ? a().toString() : (String) this.f2617b;
    }

    public int hashCode() {
        long jDoubleToLongBits;
        if (this.f2617b == null) {
            return 31;
        }
        if (b(this)) {
            jDoubleToLongBits = getAsNumber().longValue();
        } else {
            Object obj = this.f2617b;
            if (!(obj instanceof Number)) {
                return obj.hashCode();
            }
            jDoubleToLongBits = Double.doubleToLongBits(getAsNumber().doubleValue());
        }
        return (int) ((jDoubleToLongBits >>> 32) ^ jDoubleToLongBits);
    }

    public boolean isBoolean() {
        return this.f2617b instanceof Boolean;
    }

    public boolean isNumber() {
        return this.f2617b instanceof Number;
    }

    public boolean isString() {
        return this.f2617b instanceof String;
    }

    public q(Number number) {
        d(number);
    }

    public q(String str) {
        d(str);
    }

    public q(Character ch) {
        d(ch);
    }

    public q(Object obj) {
        d(obj);
    }
}
