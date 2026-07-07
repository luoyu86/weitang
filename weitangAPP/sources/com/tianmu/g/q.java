package com.tianmu.g;

import android.graphics.Bitmap;
import android.net.NetworkInfo;
import com.tianmu.g.i;
import com.tianmu.g.r;
import com.tianmu.g.x;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes2.dex */
public class q extends x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final i f12112a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final z f12113b;

    public static class a extends IOException {
        public a(String str) {
            super(str);
        }
    }

    public q(i iVar, z zVar) {
        this.f12112a = iVar;
        this.f12113b = zVar;
    }

    @Override // com.tianmu.g.x
    public int a() {
        return 2;
    }

    @Override // com.tianmu.g.x
    public boolean a(v vVar) {
        String scheme = vVar.f12159d.getScheme();
        return "http".equals(scheme) || "https".equals(scheme);
    }

    @Override // com.tianmu.g.x
    public boolean b() {
        return true;
    }

    @Override // com.tianmu.g.x
    public x.a a(v vVar, int i2) throws a {
        i.a aVarA = this.f12112a.a(vVar.f12159d, vVar.f12158c);
        if (aVarA == null) {
            return null;
        }
        r.e eVar = aVarA.f12082c ? r.e.f12137c : r.e.f12138d;
        Bitmap bitmapA = aVarA.a();
        if (bitmapA != null) {
            return new x.a(bitmapA, eVar);
        }
        InputStream inputStreamC = aVarA.c();
        if (inputStreamC == null) {
            return null;
        }
        if (eVar == r.e.f12137c && aVarA.b() == 0) {
            f0.a(inputStreamC);
            throw new a("Received response with 0 content-length header.");
        }
        if (eVar == r.e.f12138d && aVarA.b() > 0) {
            this.f12113b.a(aVarA.b());
        }
        return new x.a(inputStreamC, eVar);
    }

    @Override // com.tianmu.g.x
    public boolean a(boolean z, NetworkInfo networkInfo) {
        return networkInfo == null || networkInfo.isConnected();
    }
}
