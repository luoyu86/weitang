package c.i.b.y;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
public class i {
    public static String a(int i2) {
        if (i2 == 0) {
            return "EEEE, MMMM d, y";
        }
        if (i2 == 1) {
            return "MMMM d, y";
        }
        if (i2 == 2) {
            return "MMM d, y";
        }
        if (i2 == 3) {
            return "M/d/yy";
        }
        throw new IllegalArgumentException("Unknown DateFormat style: " + i2);
    }

    public static String b(int i2) {
        if (i2 == 0) {
            return "EEEE, MMMM d, yyyy";
        }
        if (i2 == 1) {
            return "MMMM d, yyyy";
        }
        if (i2 == 2) {
            return "MMM d, yyyy";
        }
        if (i2 == 3) {
            return "M/d/yy";
        }
        throw new IllegalArgumentException("Unknown DateFormat style: " + i2);
    }

    public static String c(int i2) {
        if (i2 == 0 || i2 == 1) {
            return "h:mm:ss a z";
        }
        if (i2 == 2) {
            return "h:mm:ss a";
        }
        if (i2 == 3) {
            return "h:mm a";
        }
        throw new IllegalArgumentException("Unknown DateFormat style: " + i2);
    }

    public static DateFormat getUSDateFormat(int i2) {
        return new SimpleDateFormat(a(i2), Locale.US);
    }

    public static DateFormat getUSDateTimeFormat(int i2, int i3) {
        return new SimpleDateFormat(b(i2) + " " + c(i3), Locale.US);
    }
}
