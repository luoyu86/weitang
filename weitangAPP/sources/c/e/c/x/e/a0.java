package c.e.c.x.e;

import android.content.Intent;

/* JADX INFO: loaded from: classes.dex */
public class a0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public g0 f2122a;

    public a0(g0 g0Var) {
        this.f2122a = g0Var;
    }

    public void a(Class cls) {
        g0 g0Var = this.f2122a;
        if (g0Var == null || g0Var.getCurrentActivity() == null) {
            return;
        }
        Intent intent = new Intent(this.f2122a.getCurrentActivity(), (Class<?>) cls);
        intent.setFlags(268435456);
        this.f2122a.getCurrentActivity().startActivity(intent);
    }
}
