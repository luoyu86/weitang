package c.e.c.x.e;

import android.app.Activity;
import android.content.Intent;

/* JADX INFO: loaded from: classes.dex */
public abstract class b0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public g0 f2124a;

    public b0(g0 g0Var) {
        this.f2124a = g0Var;
    }

    public void a(Class<? extends Activity> cls) {
        g0 g0Var = this.f2124a;
        if (g0Var == null || g0Var.getCurrentActivity() == null) {
            return;
        }
        Intent intent = new Intent(this.f2124a.getCurrentActivity(), cls);
        intent.setFlags(268435456);
        this.f2124a.getCurrentActivity().startActivity(intent);
    }

    public void b(Class<? extends Activity> cls, String str) {
        g0 g0Var = this.f2124a;
        if (g0Var == null || g0Var.getCurrentActivity() == null) {
            return;
        }
        Intent intent = new Intent(this.f2124a.getCurrentActivity(), cls);
        intent.setFlags(268435456);
        intent.putExtra("key", str);
        this.f2124a.getCurrentActivity().startActivity(intent);
    }
}
