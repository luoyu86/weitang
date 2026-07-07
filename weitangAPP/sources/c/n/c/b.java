package c.n.c;

import android.os.Build;
import android.view.View;
import android.view.animation.Interpolator;
import c.n.a.a;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes2.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final WeakHashMap<View, b> f2925a = new WeakHashMap<>(0);

    public static b animate(View view) {
        WeakHashMap<View, b> weakHashMap = f2925a;
        b dVar = weakHashMap.get(view);
        if (dVar == null) {
            int iIntValue = Integer.valueOf(Build.VERSION.SDK).intValue();
            dVar = iIntValue >= 14 ? new d(view) : iIntValue >= 11 ? new c(view) : new e(view);
            weakHashMap.put(view, dVar);
        }
        return dVar;
    }

    public abstract b alpha(float f2);

    public abstract b alphaBy(float f2);

    public abstract void cancel();

    public abstract long getDuration();

    public abstract long getStartDelay();

    public abstract b rotation(float f2);

    public abstract b rotationBy(float f2);

    public abstract b rotationX(float f2);

    public abstract b rotationXBy(float f2);

    public abstract b rotationY(float f2);

    public abstract b rotationYBy(float f2);

    public abstract b scaleX(float f2);

    public abstract b scaleXBy(float f2);

    public abstract b scaleY(float f2);

    public abstract b scaleYBy(float f2);

    public abstract b setDuration(long j);

    public abstract b setInterpolator(Interpolator interpolator);

    public abstract b setListener(a.InterfaceC0045a interfaceC0045a);

    public abstract b setStartDelay(long j);

    public abstract void start();

    public abstract b translationX(float f2);

    public abstract b translationXBy(float f2);

    public abstract b translationY(float f2);

    public abstract b translationYBy(float f2);

    public abstract b x(float f2);

    public abstract b xBy(float f2);

    public abstract b y(float f2);

    public abstract b yBy(float f2);
}
