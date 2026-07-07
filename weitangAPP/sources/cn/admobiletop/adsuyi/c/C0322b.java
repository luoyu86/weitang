package cn.admobiletop.adsuyi.c;

import android.content.Context;
import android.content.res.AssetManager;
import android.net.Uri;
import cn.admobiletop.adsuyi.c.A;
import cn.admobiletop.adsuyi.c.I;

/* JADX INFO: renamed from: cn.admobiletop.adsuyi.c.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C0322b extends I {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f4218a = 22;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AssetManager f4219b;

    public C0322b(Context context) {
        this.f4219b = context.getAssets();
    }

    public static String h(G g2) {
        return g2.f4153e.toString().substring(f4218a);
    }

    @Override // cn.admobiletop.adsuyi.c.I
    public boolean a(G g2) {
        Uri uri = g2.f4153e;
        return "file".equals(uri.getScheme()) && !uri.getPathSegments().isEmpty() && "android_asset".equals(uri.getPathSegments().get(0));
    }

    @Override // cn.admobiletop.adsuyi.c.I
    public I.a a(G g2, int i2) {
        return new I.a(this.f4219b.open(h(g2)), A.d.DISK);
    }
}
