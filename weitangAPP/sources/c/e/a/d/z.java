package c.e.a.d;

import android.os.SystemClock;
import com.chinavisionary.core.R;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/* JADX INFO: loaded from: classes.dex */
public class z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final SimpleDateFormat f1240a = new SimpleDateFormat("yyyy-MM-dd HH:mm");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SimpleDateFormat f1241b = new SimpleDateFormat("MM/dd HH:mm");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final SimpleDateFormat f1242c = new SimpleDateFormat("yyyy/MM/dd HH:mm");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final SimpleDateFormat f1243d = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final SimpleDateFormat f1244e = new SimpleDateFormat("yyyyMMdd");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final SimpleDateFormat f1245f = new SimpleDateFormat("yyyy");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final SimpleDateFormat f1246g = new SimpleDateFormat("yyyy-MM-dd");

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final SimpleDateFormat f1247h = new SimpleDateFormat("yyyyMMddHHmmss");

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final SimpleDateFormat f1248i = new SimpleDateFormat("yyyyMMddHHmm");
    public static final SimpleDateFormat j = new SimpleDateFormat("yyyy年MM月dd日");
    public static final SimpleDateFormat k = new SimpleDateFormat("MM-dd HH:mm");
    public static final SimpleDateFormat l = new SimpleDateFormat("HH:mm");
    public static final SimpleDateFormat m = new SimpleDateFormat("MM月dd日");
    public static final SimpleDateFormat n = new SimpleDateFormat("MM/dd");
    public static final SimpleDateFormat o = new SimpleDateFormat("yyyy-MM");

    public static long a() {
        return System.currentTimeMillis();
    }

    public static int daysBetween(Date date, Date date2) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        long timeInMillis = calendar.getTimeInMillis();
        calendar.setTime(date2);
        return Integer.parseInt(String.valueOf((calendar.getTimeInMillis() - timeInMillis) / 86400000));
    }

    public static String getAfterDayToTime(Long l2) {
        if (l2 == null) {
            return "";
        }
        long j2 = 60;
        long jCurrentTimeMillis = ((System.currentTimeMillis() - l2.longValue()) / 1000) / j2;
        long j3 = 0;
        if (jCurrentTimeMillis >= j2) {
            long j4 = jCurrentTimeMillis / j2;
            long j5 = 24;
            long j6 = j4 >= j5 ? j4 / j5 : 0L;
            int i2 = (j6 > 0L ? 1 : (j6 == 0L ? 0 : -1));
            j3 = j6;
        }
        l2.longValue();
        StringBuilder sb = new StringBuilder(3);
        if (j3 < 5) {
            return getTimeYYMMDD(l2);
        }
        sb.append(j3);
        sb.append("天");
        return sb.toString();
    }

    public static String getCurrentTime() {
        return getTime(Long.valueOf(System.currentTimeMillis()), f1247h);
    }

    public static String getCurrentTimeInString() {
        return getTime(Long.valueOf(a()));
    }

    public static String getCurrentYearMmString(long j2) {
        return getTime(Long.valueOf(j2), o);
    }

    public static Long getCurrentYearMonthDayToLong() {
        Long lValueOf = Long.valueOf(a());
        SimpleDateFormat simpleDateFormat = f1246g;
        return Long.valueOf(getTimeInLong(simpleDateFormat, getTime(lValueOf, simpleDateFormat)));
    }

    public static Date getDateBefore(Date date, int i2) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(5, calendar.get(5) - i2);
        return calendar.getTime();
    }

    public static String getHourToTime(Float f2) {
        return f2 != null ? String.valueOf(((f2.floatValue() / 1000.0f) / 60.0f) / 60.0f) : "";
    }

    public static String getMMDDHHMMTime(Long l2) {
        return l2 == null ? "" : getTime(l2, f1241b);
    }

    public static int getMillis() {
        return Integer.parseInt(new SimpleDateFormat("SSS").format(new Date(a())));
    }

    public static long getNextDayToAmount(int i2) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date(System.currentTimeMillis()));
        calendar.add(5, i2);
        return calendar.getTime().getTime();
    }

    public static long getNextYear(long j2) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date(j2));
        calendar.add(1, 2);
        return calendar.getTime().getTime();
    }

    public static String getSurplusDateToTime(Long l2) {
        long j2;
        long j3;
        Object objValueOf;
        if (l2 == null) {
            return "";
        }
        long j4 = 60;
        long jLongValue = l2.longValue() / j4;
        if (jLongValue >= j4) {
            j2 = jLongValue / j4;
            long j5 = 24;
            j3 = j2 >= j5 ? j2 / j5 : 0L;
            if (j3 > 0) {
                j2 -= j3 * j5;
            }
            jLongValue = (jLongValue - ((j5 * j3) * j4)) - (j2 * j4);
        } else {
            j2 = 0;
            j3 = 0;
        }
        long jLongValue2 = ((l2.longValue() - (((((long) 24) * j3) * j4) * j4)) - ((j2 * j4) * j4)) - (j4 * jLongValue);
        StringBuilder sb = new StringBuilder(3);
        if (j3 > 0) {
            sb.append(j3);
            sb.append("天");
        }
        if (j2 > 0) {
            sb.append(j2);
            sb.append("小时");
        }
        sb.append(jLongValue == 0 ? "00" : Long.valueOf(jLongValue));
        sb.append(":");
        if (jLongValue2 < 10) {
            objValueOf = "0" + jLongValue2;
        } else {
            objValueOf = Long.valueOf(jLongValue2);
        }
        sb.append(objValueOf);
        return sb.toString();
    }

    public static String getSurplusToTime(Long l2) {
        long j2;
        long j3;
        Object objValueOf;
        if (l2 == null) {
            return "";
        }
        long j4 = 60;
        long jLongValue = l2.longValue() / j4;
        if (jLongValue >= j4) {
            j2 = jLongValue / j4;
            long j5 = 24;
            j3 = j2 >= j5 ? j2 / j5 : 0L;
            if (j3 > 0) {
                j2 -= j3 * j5;
            }
            jLongValue = (jLongValue - ((j5 * j3) * j4)) - (j2 * j4);
        } else {
            j2 = 0;
            j3 = 0;
        }
        long jLongValue2 = ((l2.longValue() - (((((long) 24) * j3) * j4) * j4)) - ((j2 * j4) * j4)) - (j4 * jLongValue);
        StringBuilder sb = new StringBuilder(3);
        if (j3 > 0) {
            sb.append(j3);
            sb.append("天");
        }
        if (j2 > 0) {
            sb.append(j2);
            sb.append("小时");
        }
        sb.append(jLongValue == 0 ? "00" : Long.valueOf(jLongValue));
        sb.append("分");
        if (jLongValue2 < 10) {
            objValueOf = "0" + jLongValue2;
        } else {
            objValueOf = Long.valueOf(jLongValue2);
        }
        sb.append(objValueOf);
        sb.append("秒");
        return sb.toString();
    }

    public static String getTime(Long l2, SimpleDateFormat simpleDateFormat) {
        return l2 == null ? "" : simpleDateFormat.format(new Date(l2.longValue()));
    }

    public static String getTimeFromTo(Long l2, Long l3) {
        if (getTimeYYMMDD(l2).equals(getTimeYYMMDD(l3))) {
            return getTime(l2) + "-" + getTime(l3, l);
        }
        return getTime(l2) + "-" + getTime(l3);
    }

    public static long getTimeInLong(SimpleDateFormat simpleDateFormat, String str) {
        try {
            return simpleDateFormat.parse(str).getTime();
        } catch (Exception e2) {
            e2.printStackTrace();
            return System.currentTimeMillis();
        }
    }

    public static long getTimeMillis() {
        try {
            return f1246g.parse(getTimeYYMMDD(Long.valueOf(a()))).getTime();
        } catch (ParseException e2) {
            e2.printStackTrace();
            return a();
        }
    }

    public static String getTimeYYMMDD(Long l2) {
        return (l2 != null && l2.longValue() >= 100) ? getTime(l2, f1246g) : "";
    }

    public static String getTodayAndWeek(long j2) {
        Date date = new Date(j2);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String str = simpleDateFormat.format(new Date());
        String str2 = simpleDateFormat.format(new Date(System.currentTimeMillis() + 86400000));
        String str3 = simpleDateFormat.format(date);
        return str3.equals(str) ? "今天" : str3.equals(str2) ? "明天" : getWeek(j2);
    }

    public static String getWeek(long j2) {
        String[] strArr = {"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date(j2));
        int i2 = calendar.get(7) - 1;
        if (i2 < 0) {
            i2 = 0;
        }
        return strArr[i2];
    }

    public static int getWeekToTime(long j2) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date(j2));
        int i2 = calendar.get(7) - 1;
        if (i2 < 0) {
            return 0;
        }
        return i2;
    }

    public static String getYYYYMMDDHHMMTime(Long l2) {
        return l2 == null ? "" : getTime(l2, f1242c);
    }

    public static Long getYearMonthDayToLong(long j2) {
        Long lValueOf = Long.valueOf(j2);
        SimpleDateFormat simpleDateFormat = f1246g;
        return Long.valueOf(getTimeInLong(simpleDateFormat, getTime(lValueOf, simpleDateFormat)));
    }

    public static Long getYearMonthToLong(long j2) {
        Long lValueOf = Long.valueOf(j2);
        SimpleDateFormat simpleDateFormat = o;
        return Long.valueOf(getTimeInLong(simpleDateFormat, getTime(lValueOf, simpleDateFormat)));
    }

    public static boolean isEqualsDay(Long l2, Long l3) {
        if (l2 == null || l3 == null) {
            return false;
        }
        return getTimeYYMMDD(l2).equals(getTimeYYMMDD(l3));
    }

    public static boolean isEqualsYear(Long l2, Long l3) {
        if (l2 == null || l3 == null) {
            return false;
        }
        SimpleDateFormat simpleDateFormat = f1245f;
        return getTime(l2, simpleDateFormat).equals(getTime(l3, simpleDateFormat));
    }

    public static String secondToMinute(Long l2) {
        if (l2.longValue() <= 0) {
            return x.getString(R.string.title_surplus_time_out);
        }
        return x.getString(R.string.title_surplus_time) + getSurplusDateToTime(l2);
    }

    public static final long uptimeMillis() {
        return SystemClock.uptimeMillis();
    }

    public static String getCurrentTimeInString(SimpleDateFormat simpleDateFormat) {
        return getTime(Long.valueOf(a()), simpleDateFormat);
    }

    public static String getTime(Long l2) {
        return l2 == null ? "" : getTime(l2, f1240a);
    }
}
