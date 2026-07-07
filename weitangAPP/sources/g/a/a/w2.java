package g.a.a;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class w2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Long f13394a = c(0);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map f13395b = new HashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Locale f13396c = b();

    public static Date a(Date date) throws ParseException {
        Locale locale = Locale.getDefault();
        if (locale == null) {
            return date;
        }
        Map map = f13395b;
        synchronized (map) {
            Long lC = (Long) map.get(locale);
            if (lC == null) {
                long time = new SimpleDateFormat("yyyyMMddHHmmssz").parse("19700101000000GMT+00:00").getTime();
                lC = time == 0 ? f13394a : c(time);
                map.put(locale, lC);
            }
            if (lC != f13394a) {
                return new Date(date.getTime() - lC.longValue());
            }
            return date;
        }
    }

    public static Locale b() {
        if ("en".equalsIgnoreCase(Locale.getDefault().getLanguage())) {
            return Locale.getDefault();
        }
        Locale[] availableLocales = Locale.getAvailableLocales();
        for (int i2 = 0; i2 != availableLocales.length; i2++) {
            if ("en".equalsIgnoreCase(availableLocales[i2].getLanguage())) {
                return availableLocales[i2];
            }
        }
        return Locale.getDefault();
    }

    public static Long c(long j) {
        return Long.valueOf(j);
    }
}
