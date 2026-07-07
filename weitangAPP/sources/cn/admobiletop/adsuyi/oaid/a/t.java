package cn.admobiletop.adsuyi.oaid.a;

import android.app.Application;
import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
public final class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static cn.admobiletop.adsuyi.oaid.b f4328a;

    public static cn.admobiletop.adsuyi.oaid.b a(Context context) {
        if (context != null && !(context instanceof Application)) {
            context = context.getApplicationContext();
        }
        cn.admobiletop.adsuyi.oaid.b bVar = f4328a;
        if (bVar != null) {
            return bVar;
        }
        cn.admobiletop.adsuyi.oaid.b bVarB = b(context);
        f4328a = bVarB;
        if (bVarB != null && bVarB.a()) {
            return f4328a;
        }
        cn.admobiletop.adsuyi.oaid.b bVarC = c(context);
        f4328a = bVarC;
        return bVarC;
    }

    public static cn.admobiletop.adsuyi.oaid.b b(Context context) {
        if (cn.admobiletop.adsuyi.oaid.e.o() || cn.admobiletop.adsuyi.oaid.e.n()) {
            return new w(context);
        }
        if (cn.admobiletop.adsuyi.oaid.e.q()) {
            return new z(context);
        }
        if (cn.admobiletop.adsuyi.oaid.e.r() || cn.admobiletop.adsuyi.oaid.e.k() || cn.admobiletop.adsuyi.oaid.e.b()) {
            return new A(context);
        }
        if (cn.admobiletop.adsuyi.oaid.e.g()) {
            return new k(context);
        }
        if (cn.admobiletop.adsuyi.oaid.e.h() || cn.admobiletop.adsuyi.oaid.e.d()) {
            return new m(context);
        }
        if (cn.admobiletop.adsuyi.oaid.e.i() || cn.admobiletop.adsuyi.oaid.e.l()) {
            return new o(context);
        }
        if (cn.admobiletop.adsuyi.oaid.e.j()) {
            return new p(context);
        }
        if (cn.admobiletop.adsuyi.oaid.e.m()) {
            return new s(context);
        }
        if (cn.admobiletop.adsuyi.oaid.e.p()) {
            return new y(context);
        }
        if (cn.admobiletop.adsuyi.oaid.e.a()) {
            return new b(context);
        }
        if (cn.admobiletop.adsuyi.oaid.e.a(context)) {
            return new d(context);
        }
        if (cn.admobiletop.adsuyi.oaid.e.c()) {
            return new e(context);
        }
        if (cn.admobiletop.adsuyi.oaid.e.e()) {
            return new h(context);
        }
        return null;
    }

    public static cn.admobiletop.adsuyi.oaid.b c(Context context) {
        r rVar = new r(context);
        return rVar.a() ? rVar : new f();
    }
}
