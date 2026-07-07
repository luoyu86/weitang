package com.tianmu.i.a.g;

import android.app.Application;
import android.content.Context;

/* JADX INFO: loaded from: classes2.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static com.tianmu.i.a.c f12226a;

    public static com.tianmu.i.a.c a(Context context) {
        if (context != null && !(context instanceof Application)) {
            context = context.getApplicationContext();
        }
        com.tianmu.i.a.c cVar = f12226a;
        if (cVar != null) {
            return cVar;
        }
        com.tianmu.i.a.c cVarB = b(context);
        f12226a = cVarB;
        if (cVarB != null && cVarB.a()) {
            return f12226a;
        }
        com.tianmu.i.a.c cVarC = c(context);
        f12226a = cVarC;
        return cVarC;
    }

    private static com.tianmu.i.a.c b(Context context) {
        if (com.tianmu.i.a.f.o() || com.tianmu.i.a.f.n()) {
            return new n(context);
        }
        if (com.tianmu.i.a.f.q()) {
            return new p(context);
        }
        if (com.tianmu.i.a.f.r() || com.tianmu.i.a.f.k() || com.tianmu.i.a.f.b()) {
            return new q(context);
        }
        if (com.tianmu.i.a.f.g()) {
            return new f(context);
        }
        if (com.tianmu.i.a.f.h() || com.tianmu.i.a.f.d()) {
            return new g(context);
        }
        if (com.tianmu.i.a.f.i() || com.tianmu.i.a.f.l()) {
            return new h(context);
        }
        if (com.tianmu.i.a.f.j()) {
            return new i(context);
        }
        if (com.tianmu.i.a.f.m()) {
            return new k(context);
        }
        if (com.tianmu.i.a.f.p()) {
            return new o(context);
        }
        if (com.tianmu.i.a.f.a()) {
            return new a(context);
        }
        if (com.tianmu.i.a.f.a(context)) {
            return new b(context);
        }
        if (com.tianmu.i.a.f.c()) {
            return new c(context);
        }
        if (com.tianmu.i.a.f.e()) {
            return new e(context);
        }
        return null;
    }

    private static com.tianmu.i.a.c c(Context context) {
        j jVar = new j(context);
        return jVar.a() ? jVar : new d();
    }
}
