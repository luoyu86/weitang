package com.tianmu.c.i;

import com.tianmu.ad.model.INativeRewardAd;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class f extends h implements INativeRewardAd {
    private String O;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private f f11715a = new f();

        public a a(long j) {
            this.f11715a.H = j;
            return this;
        }

        public a b(long j) {
            this.f11715a.I = j;
            return this;
        }

        public a c(String str) {
            this.f11715a.f11702q = str;
            return this;
        }

        public a d(String str) {
            this.f11715a.f11699g = str;
            return this;
        }

        public a e(String str) {
            this.f11715a.f11696d = str;
            return this;
        }

        public a f(String str) {
            this.f11715a.f11697e = str;
            return this;
        }

        public a g(String str) {
            this.f11715a.f11700h = str;
            return this;
        }

        public a h(String str) {
            this.f11715a.w = str;
            return this;
        }

        public a i(String str) {
            this.f11715a.A = str;
            return this;
        }

        public a j(String str) {
            this.f11715a.f11695c = str;
            return this;
        }

        public a k(String str) {
            this.f11715a.F = str;
            return this;
        }

        public a l(String str) {
            this.f11715a.v = str;
            return this;
        }

        public a a(o oVar) {
            this.f11715a.f11701i = oVar;
            return this;
        }

        public a b(List<String> list) {
            this.f11715a.f11698f = list;
            return this;
        }

        public a c(int i2) {
            this.f11715a.t = i2;
            return this;
        }

        public a d(int i2) {
            this.f11715a.y = i2;
            return this;
        }

        public a e(int i2) {
            this.f11715a.z = i2;
            return this;
        }

        public a f(int i2) {
            this.f11715a.f11694b = i2;
            return this;
        }

        public a g(int i2) {
            this.f11715a.r = i2;
            return this;
        }

        public a a(p pVar) {
            this.f11715a.j = pVar;
            return this;
        }

        public a b(int i2) {
            this.f11715a.u = i2;
            return this;
        }

        public a a(com.tianmu.c.i.a aVar) {
            this.f11715a.l = aVar;
            return this;
        }

        public a b(String str) {
            this.f11715a.B = str;
            return this;
        }

        public a a(int i2) {
            this.f11715a.s = i2;
            return this;
        }

        public a a(String str) {
            this.f11715a.x = str;
            return this;
        }

        public a a(List<String> list) {
            this.f11715a.C = list;
            return this;
        }

        public a a(boolean z) {
            this.f11715a.E = z;
            return this;
        }

        public f a() {
            return this.f11715a;
        }
    }

    @Override // com.tianmu.c.i.h, com.tianmu.c.i.c
    public com.tianmu.c.o.a G() {
        return new com.tianmu.c.o.b();
    }

    @Override // com.tianmu.ad.model.INativeRewardAd
    public void cache() {
        Q();
    }

    @Override // com.tianmu.c.i.h, com.tianmu.c.i.c, com.tianmu.ad.model.INativeAd
    public void destroy() {
        super.destroy();
    }

    public com.tianmu.c.o.b i0() {
        return (com.tianmu.c.o.b) this.k;
    }

    public List<String> j0() {
        o oVar = this.f11701i;
        if (oVar != null) {
            return oVar.k();
        }
        return null;
    }

    public String k0() {
        return this.O;
    }

    @Override // com.tianmu.ad.model.INativeRewardAd
    public void reportAdClose(int i2) {
        com.tianmu.c.o.b bVarI0 = i0();
        if (bVarI0 != null) {
            bVarI0.a(S(), i2);
        }
    }
}
