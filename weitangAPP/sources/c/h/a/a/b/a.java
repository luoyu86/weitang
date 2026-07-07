package c.h.a.a.b;

import android.os.Build;
import android.view.View;

/* JADX INFO: loaded from: classes2.dex */
public class a {
    public static boolean isLaidOut(View view) {
        return Build.VERSION.SDK_INT >= 19 ? view.isLaidOut() : view.getWidth() > 0 && view.getHeight() > 0;
    }
}
