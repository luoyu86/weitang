package c.i.b;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
public final class a extends v<Date> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Class<? extends Date> f2566a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<DateFormat> f2567b;

    public a(Class<? extends Date> cls, String str) {
        ArrayList arrayList = new ArrayList();
        this.f2567b = arrayList;
        this.f2566a = b(cls);
        Locale locale = Locale.US;
        arrayList.add(new SimpleDateFormat(str, locale));
        if (Locale.getDefault().equals(locale)) {
            return;
        }
        arrayList.add(new SimpleDateFormat(str));
    }

    public static Class<? extends Date> b(Class<? extends Date> cls) {
        if (cls == Date.class || cls == java.sql.Date.class || cls == Timestamp.class) {
            return cls;
        }
        throw new IllegalArgumentException("Date type must be one of " + Date.class + ", " + Timestamp.class + ", or " + java.sql.Date.class + " but was " + cls);
    }

    public final Date a(String str) {
        synchronized (this.f2567b) {
            Iterator<DateFormat> it = this.f2567b.iterator();
            while (it.hasNext()) {
                try {
                    return it.next().parse(str);
                } catch (ParseException unused) {
                }
            }
            try {
                return c.i.b.y.m.d.a.parse(str, new ParsePosition(0));
            } catch (ParseException e2) {
                throw new t(str, e2);
            }
        }
    }

    public String toString() {
        DateFormat dateFormat = this.f2567b.get(0);
        if (dateFormat instanceof SimpleDateFormat) {
            return "DefaultDateTypeAdapter(" + ((SimpleDateFormat) dateFormat).toPattern() + ')';
        }
        return "DefaultDateTypeAdapter(" + dateFormat.getClass().getSimpleName() + ')';
    }

    @Override // c.i.b.v
    public Date read(c.i.b.a0.a aVar) throws IOException {
        if (aVar.peek() == c.i.b.a0.b.NULL) {
            aVar.nextNull();
            return null;
        }
        Date dateA = a(aVar.nextString());
        Class<? extends Date> cls = this.f2566a;
        if (cls == Date.class) {
            return dateA;
        }
        if (cls == Timestamp.class) {
            return new Timestamp(dateA.getTime());
        }
        if (cls == java.sql.Date.class) {
            return new java.sql.Date(dateA.getTime());
        }
        throw new AssertionError();
    }

    @Override // c.i.b.v
    public void write(c.i.b.a0.c cVar, Date date) throws IOException {
        if (date == null) {
            cVar.nullValue();
            return;
        }
        synchronized (this.f2567b) {
            cVar.value(this.f2567b.get(0).format(date));
        }
    }

    public a(int i2, int i3) {
        this(Date.class, i2, i3);
    }

    public a(Class<? extends Date> cls, int i2, int i3) {
        ArrayList arrayList = new ArrayList();
        this.f2567b = arrayList;
        this.f2566a = b(cls);
        Locale locale = Locale.US;
        arrayList.add(DateFormat.getDateTimeInstance(i2, i3, locale));
        if (!Locale.getDefault().equals(locale)) {
            arrayList.add(DateFormat.getDateTimeInstance(i2, i3));
        }
        if (c.i.b.y.d.isJava9OrLater()) {
            arrayList.add(c.i.b.y.i.getUSDateTimeFormat(i2, i3));
        }
    }
}
