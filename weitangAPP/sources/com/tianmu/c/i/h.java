package com.tianmu.c.i;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.tianmu.ad.listener.VideoAdListener;
import com.tianmu.ad.model.ITianmuNativeVideoAd;
import com.tianmu.c.n.r;
import com.tianmu.danikula.videocache.CacheListener;
import java.io.File;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class h extends c implements ITianmuNativeVideoAd, CacheListener {
    public String F;
    private String G;
    public long H;
    public long I;
    private VideoAdListener J;
    private boolean K;
    private Integer L;
    private boolean M = true;
    private com.tianmu.biz.widget.g N;

    public class a extends com.tianmu.biz.widget.g {
        public a(Context context, String str, String str2, com.tianmu.j.a.c.a aVar, int i2, int i3, VideoAdListener videoAdListener, ViewGroup.LayoutParams layoutParams, Integer num, boolean z) {
            super(context, str, str2, aVar, i2, i3, videoAdListener, layoutParams, num, z);
        }

        @Override // com.tianmu.biz.widget.g, com.tianmu.biz.widget.a.InterfaceC0188a
        public void onVideoCompletion(int i2) {
            super.onVideoCompletion(i2);
            h hVar = h.this;
            com.tianmu.c.o.a aVar = hVar.k;
            if (aVar != null && (aVar instanceof com.tianmu.c.o.c)) {
                ((com.tianmu.c.o.c) aVar).b(hVar.T(), i2);
            }
            if (h.this.J != null) {
                h.this.J.onVideoFinish(h.this);
            }
        }

        @Override // com.tianmu.biz.widget.g, com.tianmu.biz.widget.a.InterfaceC0188a
        public void onVideoError() {
            super.onVideoError();
            h hVar = h.this;
            com.tianmu.c.o.a aVar = hVar.k;
            if (aVar != null && (aVar instanceof com.tianmu.c.o.c)) {
                ((com.tianmu.c.o.c) aVar).c(hVar.Y());
            }
            if (h.this.J != null) {
                h.this.J.onVideoError(h.this);
            }
        }

        @Override // com.tianmu.biz.widget.a.InterfaceC0188a
        public void onVideoPause(int i2) {
            h hVar = h.this;
            com.tianmu.c.o.a aVar = hVar.k;
            if (aVar != null && (aVar instanceof com.tianmu.c.o.c)) {
                ((com.tianmu.c.o.c) aVar).b(hVar.X());
            }
            if (h.this.J != null) {
                h.this.J.onVideoPause(h.this);
            }
        }

        @Override // com.tianmu.biz.widget.g, com.tianmu.biz.widget.a.InterfaceC0188a
        public void onVideoPosition(int i2, int i3) {
            h hVar;
            com.tianmu.c.o.a aVar;
            super.onVideoPosition(i2, i3);
            if (i2 <= 0 || i3 <= 0 || (aVar = (hVar = h.this).k) == null || !(aVar instanceof com.tianmu.c.o.c)) {
                return;
            }
            float f2 = i2 / i3;
            if (f2 >= 0.75f) {
                ((com.tianmu.c.o.c) aVar).f(hVar.e0(), i2);
            } else if (f2 >= 0.5f) {
                ((com.tianmu.c.o.c) aVar).c(hVar.U(), i2);
            } else if (f2 >= 0.25f) {
                ((com.tianmu.c.o.c) aVar).e(hVar.Z(), i2);
            }
        }

        @Override // com.tianmu.biz.widget.g, com.tianmu.biz.widget.a.InterfaceC0188a
        public void onVideoPrepared(long j) {
            super.onVideoPrepared(j);
            h hVar = h.this;
            com.tianmu.c.o.a aVar = hVar.k;
            if (aVar == null || !(aVar instanceof com.tianmu.c.o.c)) {
                return;
            }
            ((com.tianmu.c.o.c) aVar).a(hVar.V());
            h hVar2 = h.this;
            ((com.tianmu.c.o.c) hVar2.k).f(hVar2.d0());
        }

        @Override // com.tianmu.biz.widget.g, com.tianmu.biz.widget.a.InterfaceC0188a
        public void onVideoStart() {
            super.onVideoStart();
            if (h.this.J != null) {
                h.this.J.onVideoStart(h.this);
            }
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private h f11718a = new h();

        public b a(long j) {
            this.f11718a.H = j;
            return this;
        }

        public b b(List<String> list) {
            this.f11718a.f11698f = list;
            return this;
        }

        public b c(String str) {
            this.f11718a.f11702q = str;
            return this;
        }

        public b d(String str) {
            this.f11718a.f11699g = str;
            return this;
        }

        public b e(String str) {
            this.f11718a.f11696d = str;
            return this;
        }

        public b f(String str) {
            this.f11718a.f11697e = str;
            return this;
        }

        public b g(String str) {
            this.f11718a.f11700h = str;
            return this;
        }

        public b h(String str) {
            this.f11718a.w = str;
            return this;
        }

        public b i(String str) {
            this.f11718a.A = str;
            return this;
        }

        public b j(String str) {
            this.f11718a.f11695c = str;
            return this;
        }

        public b k(String str) {
            this.f11718a.F = str;
            return this;
        }

        public b l(String str) {
            this.f11718a.v = str;
            return this;
        }

        public b a(o oVar) {
            this.f11718a.f11701i = oVar;
            return this;
        }

        public b b(int i2) {
            this.f11718a.u = i2;
            return this;
        }

        public b c(int i2) {
            this.f11718a.t = i2;
            return this;
        }

        public b d(int i2) {
            this.f11718a.y = i2;
            return this;
        }

        public b e(int i2) {
            this.f11718a.z = i2;
            return this;
        }

        public b f(int i2) {
            this.f11718a.f11694b = i2;
            return this;
        }

        public b g(int i2) {
            this.f11718a.r = i2;
            return this;
        }

        public b a(p pVar) {
            this.f11718a.j = pVar;
            return this;
        }

        public b b(String str) {
            this.f11718a.B = str;
            return this;
        }

        public b a(com.tianmu.c.i.a aVar) {
            this.f11718a.l = aVar;
            return this;
        }

        public b a(int i2) {
            this.f11718a.s = i2;
            return this;
        }

        public b a(String str) {
            this.f11718a.x = str;
            return this;
        }

        public b a(List<String> list) {
            this.f11718a.C = list;
            return this;
        }

        public b a(boolean z) {
            this.f11718a.E = z;
            return this;
        }

        public h a() {
            return this.f11718a;
        }
    }

    private void i0() {
        if (this.K) {
            return;
        }
        this.K = true;
        com.tianmu.c.o.a aVar = this.k;
        if (aVar != null && (aVar instanceof com.tianmu.c.o.c)) {
            ((com.tianmu.c.o.c) aVar).a(V());
        }
        if (com.tianmu.c.n.l.a().b(u()) != null) {
            com.tianmu.c.n.l.a().b(u()).onVideoCache();
        }
    }

    @Override // com.tianmu.c.i.c
    public com.tianmu.c.o.a G() {
        return new com.tianmu.c.o.c();
    }

    public void Q() {
        if (this.G == null) {
            if (r.a().a(getVideoUrl())) {
                i0();
            }
            this.G = r.a().a(getVideoUrl(), this);
        }
    }

    public long R() {
        return this.I;
    }

    public List<String> S() {
        o oVar = this.f11701i;
        if (oVar != null) {
            return oVar.l();
        }
        return null;
    }

    public List<String> T() {
        o oVar = this.f11701i;
        if (oVar != null) {
            return oVar.m();
        }
        return null;
    }

    public List<String> U() {
        o oVar = this.f11701i;
        if (oVar != null) {
            return oVar.p();
        }
        return null;
    }

    public List<String> V() {
        o oVar = this.f11701i;
        if (oVar != null) {
            return oVar.o();
        }
        return null;
    }

    public List<String> W() {
        o oVar = this.f11701i;
        if (oVar != null) {
            return oVar.q();
        }
        return null;
    }

    public List<String> X() {
        o oVar = this.f11701i;
        if (oVar != null) {
            return oVar.r();
        }
        return null;
    }

    public List<String> Y() {
        o oVar = this.f11701i;
        if (oVar != null) {
            return oVar.n();
        }
        return null;
    }

    public List<String> Z() {
        o oVar = this.f11701i;
        if (oVar != null) {
            return oVar.s();
        }
        return null;
    }

    public List<String> a0() {
        o oVar = this.f11701i;
        if (oVar != null) {
            return oVar.t();
        }
        return null;
    }

    public com.tianmu.c.o.c b0() {
        return (com.tianmu.c.o.c) this.k;
    }

    public List<String> c0() {
        o oVar = this.f11701i;
        if (oVar != null) {
            return oVar.u();
        }
        return null;
    }

    @Override // com.tianmu.ad.model.ITianmuNativeVideoAd
    public void checkPlayVideo(boolean z) {
        com.tianmu.biz.widget.g gVar = this.N;
        if (gVar != null) {
            gVar.a(z);
        }
    }

    public List<String> d0() {
        o oVar = this.f11701i;
        if (oVar != null) {
            return oVar.v();
        }
        return null;
    }

    @Override // com.tianmu.c.i.c, com.tianmu.ad.model.INativeAd
    public void destroy() {
        com.tianmu.biz.widget.g gVar = this.N;
        if (gVar != null) {
            ViewGroup viewGroup = (ViewGroup) gVar.getParent();
            if (viewGroup != null) {
                viewGroup.removeView(this.N);
            }
            this.N.d();
        }
        r.a().a(this);
        super.destroy();
    }

    public List<String> e0() {
        o oVar = this.f11701i;
        if (oVar != null) {
            return oVar.w();
        }
        return null;
    }

    public void f(boolean z) {
        this.M = z;
    }

    public List<String> f0() {
        o oVar = this.f11701i;
        if (oVar != null) {
            return oVar.x();
        }
        return null;
    }

    public void g0() {
        com.tianmu.biz.widget.g gVar = this.N;
        if (gVar != null) {
            gVar.c();
        }
    }

    @Override // com.tianmu.ad.model.ITianmuNativeVideoAd
    public View getAdView(Context context, com.tianmu.j.a.c.a aVar, int i2) {
        return getAdView(context, aVar, i2, null, 0);
    }

    @Override // com.tianmu.ad.model.ITianmuNativeVideoAd
    public String getVideoCacheUrl() {
        return this.G;
    }

    @Override // com.tianmu.ad.model.ITianmuNativeVideoAd
    public String getVideoUrl() {
        return !TextUtils.isEmpty(this.G) ? getVideoCacheUrl() : this.F;
    }

    public void h0() {
        com.tianmu.biz.widget.g gVar = this.N;
        if (gVar != null) {
            gVar.e();
        }
    }

    @Override // com.tianmu.c.i.c, com.tianmu.ad.model.INativeAd
    public boolean isVideo() {
        return true;
    }

    @Override // com.tianmu.danikula.videocache.CacheListener
    public void onCacheAvailable(File file, String str, int i2) {
        if (i2 < 100 || str == null || !str.equals(getVideoUrl())) {
            return;
        }
        i0();
    }

    @Override // com.tianmu.ad.model.ITianmuNativeVideoAd
    public void registerVideoListener(VideoAdListener videoAdListener) {
        this.J = videoAdListener;
    }

    public void a(Integer num) {
        this.L = num;
    }

    @Override // com.tianmu.ad.model.ITianmuNativeVideoAd
    public View getAdView(Context context, com.tianmu.j.a.c.a aVar, int i2, int i3) {
        return getAdView(context, aVar, i2, null, i3);
    }

    @Override // com.tianmu.ad.model.ITianmuNativeVideoAd
    public View getAdView(Context context, com.tianmu.j.a.c.a aVar, int i2, ViewGroup.LayoutParams layoutParams, int i3) {
        if (this.N == null) {
            Q();
            String imageUrl = getImageUrl();
            String str = this.G;
            if (str == null) {
                str = this.F;
            }
            this.N = new a(context, imageUrl, str, aVar, i3, i2, this.J, layoutParams, this.L, this.M);
        }
        return this.N;
    }
}
