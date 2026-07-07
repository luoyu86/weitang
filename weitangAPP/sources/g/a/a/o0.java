package g.a.a;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.SimpleTimeZone;

/* JADX INFO: loaded from: classes2.dex */
public class o0 extends a0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final r0 f13271a = new a(o0.class, 23);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte[] f13272b;

    public static class a extends r0 {
        public a(Class cls, int i2) {
            super(cls, i2);
        }

        @Override // g.a.a.r0
        public a0 d(x1 x1Var) {
            return o0.g(x1Var.getOctets());
        }
    }

    public o0(String str) {
        this.f13272b = g.a.j.q.toByteArray(str);
        try {
            getDate();
        } catch (ParseException e2) {
            throw new IllegalArgumentException("invalid date string: " + e2.getMessage());
        }
    }

    public o0(Date date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyMMddHHmmss'Z'", w2.f13396c);
        simpleDateFormat.setTimeZone(new SimpleTimeZone(0, "Z"));
        this.f13272b = g.a.j.q.toByteArray(simpleDateFormat.format(date));
    }

    public o0(Date date, Locale locale) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyMMddHHmmss'Z'", locale);
        simpleDateFormat.setTimeZone(new SimpleTimeZone(0, "Z"));
        this.f13272b = g.a.j.q.toByteArray(simpleDateFormat.format(date));
    }

    public o0(byte[] bArr) {
        if (bArr.length < 2) {
            throw new IllegalArgumentException("UTCTime string too short");
        }
        this.f13272b = bArr;
        if (!h(0) || !h(1)) {
            throw new IllegalArgumentException("illegal characters in UTCTime string");
        }
    }

    public static o0 g(byte[] bArr) {
        return new o0(bArr);
    }

    public static o0 getInstance(l0 l0Var, boolean z) {
        return (o0) f13271a.e(l0Var, z);
    }

    public static o0 getInstance(Object obj) {
        if (obj == null || (obj instanceof o0)) {
            return (o0) obj;
        }
        if (obj instanceof g) {
            a0 aSN1Primitive = ((g) obj).toASN1Primitive();
            if (aSN1Primitive instanceof o0) {
                return (o0) aSN1Primitive;
            }
        }
        if (!(obj instanceof byte[])) {
            throw new IllegalArgumentException("illegal object in getInstance: " + obj.getClass().getName());
        }
        try {
            return (o0) f13271a.b((byte[]) obj);
        } catch (Exception e2) {
            throw new IllegalArgumentException("encoding error in getInstance: " + e2.toString());
        }
    }

    @Override // g.a.a.a0
    public boolean a(a0 a0Var) {
        if (a0Var instanceof o0) {
            return g.a.j.a.areEqual(this.f13272b, ((o0) a0Var).f13272b);
        }
        return false;
    }

    @Override // g.a.a.a0
    public void b(y yVar, boolean z) throws IOException {
        yVar.m(z, 23, this.f13272b);
    }

    @Override // g.a.a.a0
    public final boolean c() {
        return false;
    }

    @Override // g.a.a.a0
    public int d(boolean z) {
        return y.e(z, this.f13272b.length);
    }

    public Date getAdjustedDate() throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmssz");
        simpleDateFormat.setTimeZone(new SimpleTimeZone(0, "Z"));
        return w2.a(simpleDateFormat.parse(getAdjustedTime()));
    }

    public String getAdjustedTime() {
        StringBuilder sb;
        String str;
        String time = getTime();
        if (time.charAt(0) < '5') {
            sb = new StringBuilder();
            str = "20";
        } else {
            sb = new StringBuilder();
            str = "19";
        }
        sb.append(str);
        sb.append(time);
        return sb.toString();
    }

    public Date getDate() throws ParseException {
        return w2.a(new SimpleDateFormat("yyMMddHHmmssz").parse(getTime()));
    }

    public String getTime() {
        StringBuilder sb;
        String strSubstring;
        String strFromByteArray = g.a.j.q.fromByteArray(this.f13272b);
        if (strFromByteArray.indexOf(45) >= 0 || strFromByteArray.indexOf(43) >= 0) {
            int iIndexOf = strFromByteArray.indexOf(45);
            if (iIndexOf < 0) {
                iIndexOf = strFromByteArray.indexOf(43);
            }
            if (iIndexOf == strFromByteArray.length() - 3) {
                strFromByteArray = strFromByteArray + "00";
            }
            if (iIndexOf == 10) {
                sb = new StringBuilder();
                sb.append(strFromByteArray.substring(0, 10));
                sb.append("00GMT");
                sb.append(strFromByteArray.substring(10, 13));
                sb.append(":");
                strSubstring = strFromByteArray.substring(13, 15);
            } else {
                sb = new StringBuilder();
                sb.append(strFromByteArray.substring(0, 12));
                sb.append("GMT");
                sb.append(strFromByteArray.substring(12, 15));
                sb.append(":");
                strSubstring = strFromByteArray.substring(15, 17);
            }
        } else if (strFromByteArray.length() == 11) {
            sb = new StringBuilder();
            sb.append(strFromByteArray.substring(0, 10));
            strSubstring = "00GMT+00:00";
        } else {
            sb = new StringBuilder();
            sb.append(strFromByteArray.substring(0, 12));
            strSubstring = "GMT+00:00";
        }
        sb.append(strSubstring);
        return sb.toString();
    }

    public final boolean h(int i2) {
        byte[] bArr = this.f13272b;
        return bArr.length > i2 && bArr[i2] >= 48 && bArr[i2] <= 57;
    }

    @Override // g.a.a.a0, g.a.a.t
    public int hashCode() {
        return g.a.j.a.hashCode(this.f13272b);
    }

    public String toString() {
        return g.a.j.q.fromByteArray(this.f13272b);
    }
}
