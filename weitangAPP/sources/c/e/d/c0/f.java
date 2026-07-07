package c.e.d.c0;

import android.app.Activity;

/* JADX INFO: loaded from: classes2.dex */
public class f {
    public static d a(Activity activity, int i2, e eVar) {
        d bVar;
        switch (i2) {
            case 1:
            case 6:
            case 8:
                bVar = new b(activity);
                break;
            case 2:
            case 7:
                bVar = new m(activity);
                break;
            case 3:
                bVar = new k(activity);
                break;
            case 4:
                bVar = new l(activity);
                break;
            case 5:
                bVar = new c(activity);
                break;
            case 9:
            case 12:
                bVar = new i(activity);
                break;
            case 10:
            case 13:
                bVar = new j(activity);
                break;
            case 11:
                bVar = new j(activity);
                break;
            default:
                bVar = null;
                break;
        }
        if (bVar != null) {
            bVar.e(eVar);
        }
        return bVar;
    }
}
