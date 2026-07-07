package g.a.a;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.SimpleTimeZone;
import java.util.TimeZone;

/* JADX INFO: loaded from: classes2.dex */
public class m extends a0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final r0 f13242a = new a(m.class, 24);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte[] f13243b;

    public static class a extends r0 {
        public a(Class cls, int i2) {
            super(cls, i2);
        }

        @Override // g.a.a.r0
        public a0 d(x1 x1Var) {
            return m.j(x1Var.getOctets());
        }
    }

    public m(String str) {
        this.f13243b = g.a.j.q.toByteArray(str);
        try {
            getDate();
        } catch (ParseException e2) {
            throw new IllegalArgumentException("invalid date string: " + e2.getMessage());
        }
    }

    public m(Date date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss'Z'", w2.f13396c);
        simpleDateFormat.setTimeZone(new SimpleTimeZone(0, "Z"));
        this.f13243b = g.a.j.q.toByteArray(simpleDateFormat.format(date));
    }

    public m(Date date, Locale locale) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss'Z'", locale);
        simpleDateFormat.setTimeZone(new SimpleTimeZone(0, "Z"));
        this.f13243b = g.a.j.q.toByteArray(simpleDateFormat.format(date));
    }

    public m(byte[] bArr) {
        if (bArr.length < 4) {
            throw new IllegalArgumentException("GeneralizedTime string too short");
        }
        this.f13243b = bArr;
        if (!n(0) || !n(1) || !n(2) || !n(3)) {
            throw new IllegalArgumentException("illegal characters in GeneralizedTime string");
        }
    }

    public static m getInstance(l0 l0Var, boolean z) {
        return (m) f13242a.e(l0Var, z);
    }

    public static m getInstance(Object obj) {
        if (obj == null || (obj instanceof m)) {
            return (m) obj;
        }
        if (obj instanceof g) {
            a0 aSN1Primitive = ((g) obj).toASN1Primitive();
            if (aSN1Primitive instanceof m) {
                return (m) aSN1Primitive;
            }
        }
        if (!(obj instanceof byte[])) {
            throw new IllegalArgumentException("illegal object in getInstance: " + obj.getClass().getName());
        }
        try {
            return (m) f13242a.b((byte[]) obj);
        } catch (Exception e2) {
            throw new IllegalArgumentException("encoding error in getInstance: " + e2.toString());
        }
    }

    public static m j(byte[] bArr) {
        return new m(bArr);
    }

    @Override // g.a.a.a0
    public boolean a(a0 a0Var) {
        if (a0Var instanceof m) {
            return g.a.j.a.areEqual(this.f13243b, ((m) a0Var).f13243b);
        }
        return false;
    }

    @Override // g.a.a.a0
    public void b(y yVar, boolean z) throws IOException {
        yVar.m(z, 24, this.f13243b);
    }

    @Override // g.a.a.a0
    public final boolean c() {
        return false;
    }

    @Override // g.a.a.a0
    public int d(boolean z) {
        return y.e(z, this.f13243b.length);
    }

    @Override // g.a.a.a0
    public a0 e() {
        return new s1(this.f13243b);
    }

    @Override // g.a.a.a0
    public a0 f() {
        return new s1(this.f13243b);
    }

    public final SimpleDateFormat g() {
        SimpleDateFormat simpleDateFormat = k() ? new SimpleDateFormat("yyyyMMddHHmmss.SSSz") : m() ? new SimpleDateFormat("yyyyMMddHHmmssz") : l() ? new SimpleDateFormat("yyyyMMddHHmmz") : new SimpleDateFormat("yyyyMMddHHz");
        simpleDateFormat.setTimeZone(new SimpleTimeZone(0, "Z"));
        return simpleDateFormat;
    }

    public Date getDate() throws ParseException {
        SimpleDateFormat simpleDateFormatG;
        String strFromByteArray = g.a.j.q.fromByteArray(this.f13243b);
        if (strFromByteArray.endsWith("Z")) {
            simpleDateFormatG = k() ? new SimpleDateFormat("yyyyMMddHHmmss.SSS'Z'") : m() ? new SimpleDateFormat("yyyyMMddHHmmss'Z'") : l() ? new SimpleDateFormat("yyyyMMddHHmm'Z'") : new SimpleDateFormat("yyyyMMddHH'Z'");
            simpleDateFormatG.setTimeZone(new SimpleTimeZone(0, "Z"));
        } else if (strFromByteArray.indexOf(45) > 0 || strFromByteArray.indexOf(43) > 0) {
            strFromByteArray = getTime();
            simpleDateFormatG = g();
        } else {
            simpleDateFormatG = k() ? new SimpleDateFormat("yyyyMMddHHmmss.SSS") : m() ? new SimpleDateFormat("yyyyMMddHHmmss") : l() ? new SimpleDateFormat("yyyyMMddHHmm") : new SimpleDateFormat("yyyyMMddHH");
            simpleDateFormatG.setTimeZone(new SimpleTimeZone(0, TimeZone.getDefault().getID()));
        }
        if (k()) {
            strFromByteArray = o(strFromByteArray);
        }
        return w2.a(simpleDateFormatG.parse(strFromByteArray));
    }

    public String getTime() {
        String strFromByteArray = g.a.j.q.fromByteArray(this.f13243b);
        if (strFromByteArray.charAt(strFromByteArray.length() - 1) == 'Z') {
            return strFromByteArray.substring(0, strFromByteArray.length() - 1) + "GMT+00:00";
        }
        int length = strFromByteArray.length() - 6;
        char cCharAt = strFromByteArray.charAt(length);
        if ((cCharAt == '-' || cCharAt == '+') && strFromByteArray.indexOf("GMT") == length - 3) {
            return strFromByteArray;
        }
        int length2 = strFromByteArray.length() - 5;
        char cCharAt2 = strFromByteArray.charAt(length2);
        if (cCharAt2 == '-' || cCharAt2 == '+') {
            StringBuilder sb = new StringBuilder();
            sb.append(strFromByteArray.substring(0, length2));
            sb.append("GMT");
            int i2 = length2 + 3;
            sb.append(strFromByteArray.substring(length2, i2));
            sb.append(":");
            sb.append(strFromByteArray.substring(i2));
            return sb.toString();
        }
        int length3 = strFromByteArray.length() - 3;
        char cCharAt3 = strFromByteArray.charAt(length3);
        if (cCharAt3 != '-' && cCharAt3 != '+') {
            return strFromByteArray + h(strFromByteArray);
        }
        return strFromByteArray.substring(0, length3) + "GMT" + strFromByteArray.substring(length3) + ":00";
    }

    public String getTimeString() {
        return g.a.j.q.fromByteArray(this.f13243b);
    }

    public final String h(String str) {
        String str2;
        TimeZone timeZone = TimeZone.getDefault();
        int rawOffset = timeZone.getRawOffset();
        if (rawOffset < 0) {
            rawOffset = -rawOffset;
            str2 = "-";
        } else {
            str2 = "+";
        }
        int i2 = rawOffset / 3600000;
        int i3 = (rawOffset - (((i2 * 60) * 60) * 1000)) / 60000;
        try {
            if (timeZone.useDaylightTime()) {
                if (k()) {
                    str = o(str);
                }
                if (timeZone.inDaylightTime(g().parse(str + "GMT" + str2 + i(i2) + ":" + i(i3)))) {
                    i2 += str2.equals("+") ? 1 : -1;
                }
            }
        } catch (ParseException unused) {
        }
        return "GMT" + str2 + i(i2) + ":" + i(i3);
    }

    @Override // g.a.a.a0, g.a.a.t
    public int hashCode() {
        return g.a.j.a.hashCode(this.f13243b);
    }

    public final String i(int i2) {
        if (i2 >= 10) {
            return Integer.toString(i2);
        }
        return "0" + i2;
    }

    public boolean k() {
        int i2 = 0;
        while (true) {
            byte[] bArr = this.f13243b;
            if (i2 == bArr.length) {
                return false;
            }
            if (bArr[i2] == 46 && i2 == 14) {
                return true;
            }
            i2++;
        }
    }

    public boolean l() {
        return n(10) && n(11);
    }

    public boolean m() {
        return n(12) && n(13);
    }

    public final boolean n(int i2) {
        byte[] bArr = this.f13243b;
        return bArr.length > i2 && bArr[i2] >= 48 && bArr[i2] <= 57;
    }

    public final String o(String str) {
        String str2;
        StringBuilder sb;
        char cCharAt;
        String strSubstring = str.substring(14);
        int i2 = 1;
        while (i2 < strSubstring.length() && '0' <= (cCharAt = strSubstring.charAt(i2)) && cCharAt <= '9') {
            i2++;
        }
        int i3 = i2 - 1;
        if (i3 > 3) {
            str2 = strSubstring.substring(0, 4) + strSubstring.substring(i2);
            sb = new StringBuilder();
        } else if (i3 == 1) {
            str2 = strSubstring.substring(0, i2) + "00" + strSubstring.substring(i2);
            sb = new StringBuilder();
        } else {
            if (i3 != 2) {
                return str;
            }
            str2 = strSubstring.substring(0, i2) + "0" + strSubstring.substring(i2);
            sb = new StringBuilder();
        }
        sb.append(str.substring(0, 14));
        sb.append(str2);
        return sb.toString();
    }
}
