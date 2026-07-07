package g.a.a.y3;

import g.a.a.a0;
import g.a.a.f2;
import g.a.a.l0;
import g.a.a.o0;
import g.a.a.s1;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.SimpleTimeZone;

/* JADX INFO: loaded from: classes2.dex */
public class p extends g.a.a.t implements g.a.a.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a0 f13517a;

    public p(a0 a0Var) {
        if (!(a0Var instanceof o0) && !(a0Var instanceof g.a.a.m)) {
            throw new IllegalArgumentException("unknown object passed to Time");
        }
        this.f13517a = a0Var;
    }

    public p(Date date) {
        SimpleTimeZone simpleTimeZone = new SimpleTimeZone(0, "Z");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        simpleDateFormat.setTimeZone(simpleTimeZone);
        String str = simpleDateFormat.format(date) + "Z";
        int i2 = Integer.parseInt(str.substring(0, 4));
        this.f13517a = (i2 < 1950 || i2 > 2049) ? new s1(str) : new f2(str.substring(2));
    }

    public p(Date date, Locale locale) {
        SimpleTimeZone simpleTimeZone = new SimpleTimeZone(0, "Z");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss", locale);
        simpleDateFormat.setTimeZone(simpleTimeZone);
        String str = simpleDateFormat.format(date) + "Z";
        int i2 = Integer.parseInt(str.substring(0, 4));
        this.f13517a = (i2 < 1950 || i2 > 2049) ? new s1(str) : new f2(str.substring(2));
    }

    public static p getInstance(l0 l0Var, boolean z) {
        return getInstance(l0Var.getObject());
    }

    public static p getInstance(Object obj) {
        if (obj == null || (obj instanceof p)) {
            return (p) obj;
        }
        if (obj instanceof o0) {
            return new p((o0) obj);
        }
        if (obj instanceof g.a.a.m) {
            return new p((g.a.a.m) obj);
        }
        throw new IllegalArgumentException("unknown object in factory: " + obj.getClass().getName());
    }

    public Date getDate() {
        try {
            a0 a0Var = this.f13517a;
            return a0Var instanceof o0 ? ((o0) a0Var).getAdjustedDate() : ((g.a.a.m) a0Var).getDate();
        } catch (ParseException e2) {
            throw new IllegalStateException("invalid date string: " + e2.getMessage());
        }
    }

    public String getTime() {
        a0 a0Var = this.f13517a;
        return a0Var instanceof o0 ? ((o0) a0Var).getAdjustedTime() : ((g.a.a.m) a0Var).getTime();
    }

    @Override // g.a.a.t, g.a.a.g
    public a0 toASN1Primitive() {
        return this.f13517a;
    }

    public String toString() {
        return getTime();
    }
}
