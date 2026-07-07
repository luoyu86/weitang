package g.a.i.b.i;

import androidx.appcompat.widget.ActivityChooserView;
import g.a.i.b.i.g;
import g.a.i.b.i.i;
import g.a.i.b.i.j;
import java.io.Serializable;
import java.util.Objects;
import java.util.Stack;

/* JADX INFO: loaded from: classes3.dex */
public class c implements Serializable, Cloneable {
    private static final long serialVersionUID = 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public u f14447a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f14448b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f14449c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f14450d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f14451e = false;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f14452f = false;

    public c(int i2) {
        this.f14448b = i2;
    }

    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public c clone() {
        c cVar = new c(this.f14448b);
        cVar.f14447a = this.f14447a;
        cVar.f14449c = this.f14449c;
        cVar.f14450d = this.f14450d;
        cVar.f14451e = this.f14451e;
        cVar.f14452f = this.f14452f;
        return cVar;
    }

    public int b() {
        return this.f14450d;
    }

    public void c(int i2) {
        this.f14447a = null;
        this.f14449c = this.f14448b;
        this.f14450d = i2;
        this.f14451e = true;
        this.f14452f = false;
    }

    public boolean d() {
        return this.f14452f;
    }

    public boolean e() {
        return this.f14451e;
    }

    public void f(u uVar) {
        this.f14447a = uVar;
        int height = uVar.getHeight();
        this.f14449c = height;
        if (height == this.f14448b) {
            this.f14452f = true;
        }
    }

    public void g(Stack<u> stack, k kVar, byte[] bArr, byte[] bArr2, j jVar) {
        Objects.requireNonNull(jVar, "otsHashAddress == null");
        if (this.f14452f || !this.f14451e) {
            throw new IllegalStateException("finished or not initialized");
        }
        j jVar2 = (j) new j.b().g(jVar.a()).h(jVar.b()).p(this.f14450d).n(jVar.d()).o(jVar.e()).f(jVar.getKeyAndMask()).l();
        i iVar = (i) new i.b().g(jVar2.a()).h(jVar2.b()).n(this.f14450d).l();
        g gVar = (g) new g.b().g(jVar2.a()).h(jVar2.b()).n(this.f14450d).k();
        kVar.h(kVar.g(bArr2, jVar2), bArr);
        u uVarA = v.a(kVar, kVar.e(jVar2), iVar);
        while (!stack.isEmpty() && stack.peek().getHeight() == uVarA.getHeight() && stack.peek().getHeight() != this.f14448b) {
            g gVar2 = (g) new g.b().g(gVar.a()).h(gVar.b()).m(gVar.d()).n((gVar.e() - 1) / 2).f(gVar.getKeyAndMask()).k();
            u uVarB = v.b(kVar, stack.pop(), uVarA, gVar2);
            u uVar = new u(uVarB.getHeight() + 1, uVarB.getValue());
            gVar = (g) new g.b().g(gVar2.a()).h(gVar2.b()).m(gVar2.d() + 1).n(gVar2.e()).f(gVar2.getKeyAndMask()).k();
            uVarA = uVar;
        }
        u uVar2 = this.f14447a;
        if (uVar2 == null) {
            this.f14447a = uVarA;
        } else if (uVar2.getHeight() == uVarA.getHeight()) {
            g gVar3 = (g) new g.b().g(gVar.a()).h(gVar.b()).m(gVar.d()).n((gVar.e() - 1) / 2).f(gVar.getKeyAndMask()).k();
            uVarA = new u(this.f14447a.getHeight() + 1, v.b(kVar, this.f14447a, uVarA, gVar3).getValue());
            this.f14447a = uVarA;
        } else {
            stack.push(uVarA);
        }
        if (this.f14447a.getHeight() == this.f14448b) {
            this.f14452f = true;
        } else {
            this.f14449c = uVarA.getHeight();
            this.f14450d++;
        }
    }

    public int getHeight() {
        return (!this.f14451e || this.f14452f) ? ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED : this.f14449c;
    }

    public u getTailNode() {
        return this.f14447a;
    }
}
