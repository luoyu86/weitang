package i.a.a.a;

import android.annotation.TargetApi;
import android.os.Build;
import android.view.View;

/* JADX INFO: loaded from: classes3.dex */
public class a {
    @TargetApi(5)
    public static int a(int i2) {
        return (i2 & 65280) >> 8;
    }

    @TargetApi(11)
    public static int b(int i2) {
        return (i2 & 65280) >> 8;
    }

    @TargetApi(16)
    public static void c(View view, Runnable runnable) {
        view.postOnAnimation(runnable);
    }

    public static int getPointerIndex(int i2) {
        return Build.VERSION.SDK_INT >= 11 ? b(i2) : a(i2);
    }

    public static void postOnAnimation(View view, Runnable runnable) {
        if (Build.VERSION.SDK_INT >= 16) {
            c(view, runnable);
        } else {
            view.postDelayed(runnable, 16L);
        }
    }
}
