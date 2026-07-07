package c.i.b.y;

/* JADX INFO: loaded from: classes2.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f2652a = a();

    public static int a() {
        return c(System.getProperty("java.version"));
    }

    public static int b(String str) {
        try {
            StringBuilder sb = new StringBuilder();
            for (int i2 = 0; i2 < str.length(); i2++) {
                char cCharAt = str.charAt(i2);
                if (!Character.isDigit(cCharAt)) {
                    break;
                }
                sb.append(cCharAt);
            }
            return Integer.parseInt(sb.toString());
        } catch (NumberFormatException unused) {
            return -1;
        }
    }

    public static int c(String str) {
        int iD = d(str);
        if (iD == -1) {
            iD = b(str);
        }
        if (iD == -1) {
            return 6;
        }
        return iD;
    }

    public static int d(String str) {
        try {
            String[] strArrSplit = str.split("[._]");
            int i2 = Integer.parseInt(strArrSplit[0]);
            return (i2 != 1 || strArrSplit.length <= 1) ? i2 : Integer.parseInt(strArrSplit[1]);
        } catch (NumberFormatException unused) {
            return -1;
        }
    }

    public static int getMajorJavaVersion() {
        return f2652a;
    }

    public static boolean isJava9OrLater() {
        return f2652a >= 9;
    }
}
