package i.a.a.a.g;

import android.content.Context;
import android.os.Build;

/* JADX INFO: loaded from: classes3.dex */
public abstract class d {
    public static d getScroller(Context context) {
        int i2 = Build.VERSION.SDK_INT;
        return i2 < 9 ? new c(context) : i2 < 14 ? new a(context) : new b(context);
    }

    public abstract boolean computeScrollOffset();

    public abstract void fling(int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11);

    public abstract void forceFinished(boolean z);

    public abstract int getCurrX();

    public abstract int getCurrY();

    public abstract boolean isFinished();
}
