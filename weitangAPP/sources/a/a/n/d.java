package a.a.n;

import a.a.n.a;
import anet.channel.util.HttpHelper;
import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;

/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final TimeZone f170a = TimeZone.getTimeZone("GMT");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ThreadLocal<SimpleDateFormat> f171b = new ThreadLocal<>();

    public static String a(long j) {
        return b().format(new Date(j));
    }

    public static SimpleDateFormat b() {
        ThreadLocal<SimpleDateFormat> threadLocal = f171b;
        SimpleDateFormat simpleDateFormat = threadLocal.get();
        if (simpleDateFormat != null) {
            return simpleDateFormat;
        }
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss 'GMT'", Locale.US);
        simpleDateFormat2.setTimeZone(f170a);
        threadLocal.set(simpleDateFormat2);
        return simpleDateFormat2;
    }

    public static long a(String str) {
        if (str.length() == 0) {
            return 0L;
        }
        try {
            ParsePosition parsePosition = new ParsePosition(0);
            Date date = b().parse(str, parsePosition);
            if (parsePosition.getIndex() == str.length()) {
                return date.getTime();
            }
        } catch (Exception unused) {
        }
        return 0L;
    }

    public static a.C0000a a(Map<String, List<String>> map) {
        long j;
        long j2;
        long jCurrentTimeMillis = System.currentTimeMillis();
        String singleHeaderFieldByKey = HttpHelper.getSingleHeaderFieldByKey(map, "Cache-Control");
        boolean z = true;
        int i2 = 0;
        if (singleHeaderFieldByKey != null) {
            String[] strArrSplit = singleHeaderFieldByKey.split(",");
            j = 0;
            while (true) {
                if (i2 >= strArrSplit.length) {
                    break;
                }
                String strTrim = strArrSplit[i2].trim();
                if (strTrim.equals("no-store")) {
                    return null;
                }
                if (strTrim.equals("no-cache")) {
                    j = 0;
                    break;
                }
                if (strTrim.startsWith("max-age=")) {
                    try {
                        j = Long.parseLong(strTrim.substring(8));
                    } catch (Exception unused) {
                    }
                }
                i2++;
            }
        } else {
            j = 0;
            z = false;
        }
        String singleHeaderFieldByKey2 = HttpHelper.getSingleHeaderFieldByKey(map, HttpHeaders.DATE);
        long jA = singleHeaderFieldByKey2 != null ? a(singleHeaderFieldByKey2) : 0L;
        String singleHeaderFieldByKey3 = HttpHelper.getSingleHeaderFieldByKey(map, HttpHeaders.EXPIRES);
        long jA2 = singleHeaderFieldByKey3 != null ? a(singleHeaderFieldByKey3) : 0L;
        String singleHeaderFieldByKey4 = HttpHelper.getSingleHeaderFieldByKey(map, HttpHeaders.LAST_MODIFIED);
        long jA3 = singleHeaderFieldByKey4 != null ? a(singleHeaderFieldByKey4) : 0L;
        String singleHeaderFieldByKey5 = HttpHelper.getSingleHeaderFieldByKey(map, HttpHeaders.ETAG);
        if (z) {
            jCurrentTimeMillis += j * 1000;
        } else {
            if (jA <= 0 || jA2 < jA) {
                j2 = jA3;
                if (j2 <= 0) {
                    jCurrentTimeMillis = 0;
                }
                if (jCurrentTimeMillis != 0 && singleHeaderFieldByKey5 == null) {
                    return null;
                }
                a.C0000a c0000a = new a.C0000a();
                c0000a.etag = singleHeaderFieldByKey5;
                c0000a.ttl = jCurrentTimeMillis;
                c0000a.serverDate = jA;
                c0000a.lastModified = j2;
                c0000a.responseHeaders = map;
                return c0000a;
            }
            jCurrentTimeMillis += jA2 - jA;
        }
        j2 = jA3;
        if (jCurrentTimeMillis != 0) {
        }
        a.C0000a c0000a2 = new a.C0000a();
        c0000a2.etag = singleHeaderFieldByKey5;
        c0000a2.ttl = jCurrentTimeMillis;
        c0000a2.serverDate = jA;
        c0000a2.lastModified = j2;
        c0000a2.responseHeaders = map;
        return c0000a2;
    }
}
