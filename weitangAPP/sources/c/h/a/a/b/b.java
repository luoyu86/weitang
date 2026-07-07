package c.h.a.a.b;

import android.annotation.SuppressLint;
import android.os.Build;
import android.view.ViewTreeObserver;

/* JADX INFO: loaded from: classes2.dex */
public class b {
    @SuppressLint({"NewApi"})
    public static void removeOnGlobalLayoutListener(ViewTreeObserver viewTreeObserver, ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
        if (Build.VERSION.SDK_INT >= 16) {
            viewTreeObserver.removeOnGlobalLayoutListener(onGlobalLayoutListener);
        } else {
            viewTreeObserver.removeGlobalOnLayoutListener(onGlobalLayoutListener);
        }
    }
}
