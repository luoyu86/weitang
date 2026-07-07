package com.google.gson.internal.bind;

import c.i.b.a0.b;
import c.i.b.a0.c;
import c.i.b.f;
import c.i.b.t;
import c.i.b.v;
import c.i.b.w;
import c.i.b.y.d;
import c.i.b.y.i;
import c.i.b.z.a;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
public final class DateTypeAdapter extends v<Date> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final w f8997a = new w() { // from class: com.google.gson.internal.bind.DateTypeAdapter.1
        @Override // c.i.b.w
        public <T> v<T> create(f fVar, a<T> aVar) {
            if (aVar.getRawType() == Date.class) {
                return new DateTypeAdapter();
            }
            return null;
        }
    };

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<DateFormat> f8998b;

    public DateTypeAdapter() {
        ArrayList arrayList = new ArrayList();
        this.f8998b = arrayList;
        Locale locale = Locale.US;
        arrayList.add(DateFormat.getDateTimeInstance(2, 2, locale));
        if (!Locale.getDefault().equals(locale)) {
            arrayList.add(DateFormat.getDateTimeInstance(2, 2));
        }
        if (d.isJava9OrLater()) {
            arrayList.add(i.getUSDateTimeFormat(2, 2));
        }
    }

    public final synchronized Date a(String str) {
        Iterator<DateFormat> it = this.f8998b.iterator();
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

    @Override // c.i.b.v
    public Date read(c.i.b.a0.a aVar) throws IOException {
        if (aVar.peek() != b.NULL) {
            return a(aVar.nextString());
        }
        aVar.nextNull();
        return null;
    }

    @Override // c.i.b.v
    public synchronized void write(c cVar, Date date) throws IOException {
        if (date == null) {
            cVar.nullValue();
        } else {
            cVar.value(this.f8998b.get(0).format(date));
        }
    }
}
