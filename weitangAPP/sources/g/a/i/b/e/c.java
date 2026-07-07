package g.a.i.b.e;

/* JADX INFO: loaded from: classes3.dex */
public class c {
    public static int a(int i2) {
        if (i2 == 5) {
            return 5224;
        }
        if (i2 == 6) {
            return 12392;
        }
        throw new IllegalArgumentException("unknown security category: " + i2);
    }

    public static int b(int i2) {
        if (i2 == 5) {
            return 14880;
        }
        if (i2 == 6) {
            return 38432;
        }
        throw new IllegalArgumentException("unknown security category: " + i2);
    }

    public static String getName(int i2) {
        if (i2 == 5) {
            return "qTESLA-p-I";
        }
        if (i2 == 6) {
            return "qTESLA-p-III";
        }
        throw new IllegalArgumentException("unknown security category: " + i2);
    }
}
