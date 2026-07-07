package i.a.a.a.e;

import android.content.Context;
import android.os.Build;

/* JADX INFO: loaded from: classes3.dex */
public final class f {
    public static d newInstance(Context context, e eVar) {
        int i2 = Build.VERSION.SDK_INT;
        d aVar = i2 < 5 ? new a(context) : i2 < 8 ? new b(context) : new c(context);
        aVar.setOnGestureListener(eVar);
        return aVar;
    }
}
