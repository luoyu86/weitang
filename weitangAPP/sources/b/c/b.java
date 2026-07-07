package b.c;

import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public abstract class b implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f777a = true;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Runnable f778b = new Runnable() { // from class: b.c.a
        @Override // java.lang.Runnable
        public final void run() {
            b.f777a = true;
        }
    };

    public abstract void doClick(View view);

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (f777a) {
            f777a = false;
            view.post(f778b);
            doClick(view);
        }
    }
}
