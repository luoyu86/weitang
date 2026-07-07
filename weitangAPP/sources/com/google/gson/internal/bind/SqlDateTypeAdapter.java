package com.google.gson.internal.bind;

import c.i.b.a0.b;
import c.i.b.a0.c;
import c.i.b.f;
import c.i.b.t;
import c.i.b.v;
import c.i.b.w;
import c.i.b.z.a;
import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/* JADX INFO: loaded from: classes2.dex */
public final class SqlDateTypeAdapter extends v<Date> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final w f9025a = new w() { // from class: com.google.gson.internal.bind.SqlDateTypeAdapter.1
        @Override // c.i.b.w
        public <T> v<T> create(f fVar, a<T> aVar) {
            if (aVar.getRawType() == Date.class) {
                return new SqlDateTypeAdapter();
            }
            return null;
        }
    };

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final DateFormat f9026b = new SimpleDateFormat("MMM d, yyyy");

    @Override // c.i.b.v
    public synchronized Date read(c.i.b.a0.a aVar) throws IOException {
        if (aVar.peek() == b.NULL) {
            aVar.nextNull();
            return null;
        }
        try {
            return new Date(this.f9026b.parse(aVar.nextString()).getTime());
        } catch (ParseException e2) {
            throw new t(e2);
        }
    }

    @Override // c.i.b.v
    public synchronized void write(c cVar, Date date) throws IOException {
        cVar.value(date == null ? null : this.f9026b.format((java.util.Date) date));
    }
}
