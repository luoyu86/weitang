package c.e.a.d;

/* JADX INFO: loaded from: classes.dex */
public class s {
    public static int dip2px(float f2) {
        try {
            f2 = (f2 * c.e.a.a.b.getInstance().getResources().getDisplayMetrics().density) + 0.5f;
        } catch (Exception e2) {
            e2.printStackTrace();
            q.e("PixelUtils", "dip2px occur Exception::" + e2);
        }
        return (int) f2;
    }

    public static int px2dip(float f2) {
        return (int) ((f2 / c.e.a.a.b.getInstance().getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static int px2sp(float f2) {
        return (int) ((f2 / c.e.a.a.b.getInstance().getResources().getDisplayMetrics().scaledDensity) + 0.5f);
    }

    public static int sp2px(float f2) {
        return (int) ((f2 * c.e.a.a.b.getInstance().getResources().getDisplayMetrics().scaledDensity) + 0.5f);
    }
}
