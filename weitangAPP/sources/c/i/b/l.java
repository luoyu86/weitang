package c.i.b;

import java.io.IOException;
import java.io.StringWriter;
import java.math.BigDecimal;
import java.math.BigInteger;

/* JADX INFO: loaded from: classes2.dex */
public abstract class l {
    public abstract l deepCopy();

    public BigDecimal getAsBigDecimal() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public BigInteger getAsBigInteger() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public boolean getAsBoolean() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public byte getAsByte() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public char getAsCharacter() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public double getAsDouble() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public float getAsFloat() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public int getAsInt() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public i getAsJsonArray() {
        if (isJsonArray()) {
            return (i) this;
        }
        throw new IllegalStateException("Not a JSON Array: " + this);
    }

    public n getAsJsonNull() {
        if (isJsonNull()) {
            return (n) this;
        }
        throw new IllegalStateException("Not a JSON Null: " + this);
    }

    public o getAsJsonObject() {
        if (isJsonObject()) {
            return (o) this;
        }
        throw new IllegalStateException("Not a JSON Object: " + this);
    }

    public q getAsJsonPrimitive() {
        if (isJsonPrimitive()) {
            return (q) this;
        }
        throw new IllegalStateException("Not a JSON Primitive: " + this);
    }

    public long getAsLong() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public Number getAsNumber() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public short getAsShort() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public String getAsString() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public boolean isJsonArray() {
        return this instanceof i;
    }

    public boolean isJsonNull() {
        return this instanceof n;
    }

    public boolean isJsonObject() {
        return this instanceof o;
    }

    public boolean isJsonPrimitive() {
        return this instanceof q;
    }

    public String toString() {
        try {
            StringWriter stringWriter = new StringWriter();
            c.i.b.a0.c cVar = new c.i.b.a0.c(stringWriter);
            cVar.setLenient(true);
            c.i.b.y.k.write(this, cVar);
            return stringWriter.toString();
        } catch (IOException e2) {
            throw new AssertionError(e2);
        }
    }
}
