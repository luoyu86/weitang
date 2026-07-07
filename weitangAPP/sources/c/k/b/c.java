package c.k.b;

import android.view.View;

/* JADX INFO: loaded from: classes2.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f2827a = new c();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public View.OnLongClickListener f2828b;

    public static c getInstance() {
        return f2827a;
    }

    public View.OnLongClickListener getOnLongClickListener() {
        return this.f2828b;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.f2828b = onLongClickListener;
    }
}
