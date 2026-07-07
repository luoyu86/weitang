package cn.admobiletop.adsuyi.c;

import android.content.Context;
import cn.admobiletop.adsuyi.c.A;
import cn.admobiletop.adsuyi.c.I;
import java.io.InputStream;

/* JADX INFO: renamed from: cn.admobiletop.adsuyi.c.m, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C0333m extends I {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f4236a;

    public C0333m(Context context) {
        this.f4236a = context;
    }

    @Override // cn.admobiletop.adsuyi.c.I
    public boolean a(G g2) {
        return "content".equals(g2.f4153e.getScheme());
    }

    public InputStream h(G g2) {
        return this.f4236a.getContentResolver().openInputStream(g2.f4153e);
    }

    @Override // cn.admobiletop.adsuyi.c.I
    public I.a a(G g2, int i2) {
        return new I.a(h(g2), A.d.DISK);
    }
}
