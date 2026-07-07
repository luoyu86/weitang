package com.google.gson.internal.bind;

import c.i.b.a0.b;
import c.i.b.a0.c;
import c.i.b.f;
import c.i.b.t;
import c.i.b.v;
import c.i.b.w;
import c.i.b.z.a;
import java.io.IOException;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/* JADX INFO: loaded from: classes2.dex */
public final class TimeTypeAdapter extends v<Time> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final w f9027a = new w() { // from class: com.google.gson.internal.bind.TimeTypeAdapter.1
        @Override // c.i.b.w
        public <T> v<T> create(f fVar, a<T> aVar) {
            if (aVar.getRawType() == Time.class) {
                return new TimeTypeAdapter();
            }
            return null;
        }
    };

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final DateFormat f9028b = new SimpleDateFormat("hh:mm:ss a");

    @Override // c.i.b.v
    public synchronized Time read(c.i.b.a0.a aVar) throws IOException {
        if (aVar.peek() == b.NULL) {
            aVar.nextNull();
            return null;
        }
        try {
            return new Time(this.f9028b.parse(aVar.nextString()).getTime());
        } catch (ParseException e2) {
            throw new t(e2);
        }
    }

    @Override // c.i.b.v
    public synchronized void write(c cVar, Time time) throws IOException {
        cVar.value(time == null ? null : this.f9028b.format((Date) time));
    }
}
