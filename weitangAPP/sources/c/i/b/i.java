package c.i.b;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class i extends l implements Iterable<l> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<l> f2613a;

    public i() {
        this.f2613a = new ArrayList();
    }

    public void add(Boolean bool) {
        this.f2613a.add(bool == null ? n.f2614a : new q(bool));
    }

    public void addAll(i iVar) {
        this.f2613a.addAll(iVar.f2613a);
    }

    public boolean contains(l lVar) {
        return this.f2613a.contains(lVar);
    }

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof i) && ((i) obj).f2613a.equals(this.f2613a));
    }

    public l get(int i2) {
        return this.f2613a.get(i2);
    }

    @Override // c.i.b.l
    public BigDecimal getAsBigDecimal() {
        if (this.f2613a.size() == 1) {
            return this.f2613a.get(0).getAsBigDecimal();
        }
        throw new IllegalStateException();
    }

    @Override // c.i.b.l
    public BigInteger getAsBigInteger() {
        if (this.f2613a.size() == 1) {
            return this.f2613a.get(0).getAsBigInteger();
        }
        throw new IllegalStateException();
    }

    @Override // c.i.b.l
    public boolean getAsBoolean() {
        if (this.f2613a.size() == 1) {
            return this.f2613a.get(0).getAsBoolean();
        }
        throw new IllegalStateException();
    }

    @Override // c.i.b.l
    public byte getAsByte() {
        if (this.f2613a.size() == 1) {
            return this.f2613a.get(0).getAsByte();
        }
        throw new IllegalStateException();
    }

    @Override // c.i.b.l
    public char getAsCharacter() {
        if (this.f2613a.size() == 1) {
            return this.f2613a.get(0).getAsCharacter();
        }
        throw new IllegalStateException();
    }

    @Override // c.i.b.l
    public double getAsDouble() {
        if (this.f2613a.size() == 1) {
            return this.f2613a.get(0).getAsDouble();
        }
        throw new IllegalStateException();
    }

    @Override // c.i.b.l
    public float getAsFloat() {
        if (this.f2613a.size() == 1) {
            return this.f2613a.get(0).getAsFloat();
        }
        throw new IllegalStateException();
    }

    @Override // c.i.b.l
    public int getAsInt() {
        if (this.f2613a.size() == 1) {
            return this.f2613a.get(0).getAsInt();
        }
        throw new IllegalStateException();
    }

    @Override // c.i.b.l
    public long getAsLong() {
        if (this.f2613a.size() == 1) {
            return this.f2613a.get(0).getAsLong();
        }
        throw new IllegalStateException();
    }

    @Override // c.i.b.l
    public Number getAsNumber() {
        if (this.f2613a.size() == 1) {
            return this.f2613a.get(0).getAsNumber();
        }
        throw new IllegalStateException();
    }

    @Override // c.i.b.l
    public short getAsShort() {
        if (this.f2613a.size() == 1) {
            return this.f2613a.get(0).getAsShort();
        }
        throw new IllegalStateException();
    }

    @Override // c.i.b.l
    public String getAsString() {
        if (this.f2613a.size() == 1) {
            return this.f2613a.get(0).getAsString();
        }
        throw new IllegalStateException();
    }

    public int hashCode() {
        return this.f2613a.hashCode();
    }

    @Override // java.lang.Iterable
    public Iterator<l> iterator() {
        return this.f2613a.iterator();
    }

    public boolean remove(l lVar) {
        return this.f2613a.remove(lVar);
    }

    public l set(int i2, l lVar) {
        return this.f2613a.set(i2, lVar);
    }

    public int size() {
        return this.f2613a.size();
    }

    public void add(Character ch) {
        this.f2613a.add(ch == null ? n.f2614a : new q(ch));
    }

    @Override // c.i.b.l
    public i deepCopy() {
        if (this.f2613a.isEmpty()) {
            return new i();
        }
        i iVar = new i(this.f2613a.size());
        Iterator<l> it = this.f2613a.iterator();
        while (it.hasNext()) {
            iVar.add(it.next().deepCopy());
        }
        return iVar;
    }

    public l remove(int i2) {
        return this.f2613a.remove(i2);
    }

    public i(int i2) {
        this.f2613a = new ArrayList(i2);
    }

    public void add(Number number) {
        this.f2613a.add(number == null ? n.f2614a : new q(number));
    }

    public void add(String str) {
        this.f2613a.add(str == null ? n.f2614a : new q(str));
    }

    public void add(l lVar) {
        if (lVar == null) {
            lVar = n.f2614a;
        }
        this.f2613a.add(lVar);
    }
}
