package cn.admobiletop.adsuyi.c;

import android.graphics.Bitmap;
import android.net.NetworkInfo;
import cn.admobiletop.adsuyi.c.A;
import cn.admobiletop.adsuyi.c.I;
import cn.admobiletop.adsuyi.c.InterfaceC0337q;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
public class y extends I {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InterfaceC0337q f4288a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final L f4289b;

    public static class a extends IOException {
        public a(String str) {
            super(str);
        }
    }

    public y(InterfaceC0337q interfaceC0337q, L l) {
        this.f4288a = interfaceC0337q;
        this.f4289b = l;
    }

    @Override // cn.admobiletop.adsuyi.c.I
    public int a() {
        return 2;
    }

    @Override // cn.admobiletop.adsuyi.c.I
    public boolean a(G g2) {
        String scheme = g2.f4153e.getScheme();
        return "http".equals(scheme) || "https".equals(scheme);
    }

    @Override // cn.admobiletop.adsuyi.c.I
    public boolean e(boolean z, NetworkInfo networkInfo) {
        return networkInfo == null || networkInfo.isConnected();
    }

    @Override // cn.admobiletop.adsuyi.c.I
    public boolean g() {
        return true;
    }

    @Override // cn.admobiletop.adsuyi.c.I
    public I.a a(G g2, int i2) throws a {
        InterfaceC0337q.a aVarA = this.f4288a.a(g2.f4153e, g2.f4152d);
        if (aVarA == null) {
            return null;
        }
        A.d dVar = aVarA.f4255c ? A.d.DISK : A.d.NETWORK;
        Bitmap bitmapA = aVarA.a();
        if (bitmapA != null) {
            return new I.a(bitmapA, dVar);
        }
        InputStream inputStreamC = aVarA.c();
        if (inputStreamC == null) {
            return null;
        }
        if (dVar == A.d.DISK && aVarA.b() == 0) {
            S.n(inputStreamC);
            throw new a("Received response with 0 content-length header.");
        }
        if (dVar == A.d.NETWORK && aVarA.b() > 0) {
            this.f4289b.c(aVarA.b());
        }
        return new I.a(inputStreamC, dVar);
    }
}
