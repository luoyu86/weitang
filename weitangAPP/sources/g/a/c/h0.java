package g.a.c;

import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes2.dex */
public class h0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f13662a;

    public h0(g.a.h.i iVar) {
        this.f13662a = iVar;
    }

    public h0(g.a.h.j jVar) {
        this.f13662a = jVar;
    }

    public OutputStream getAADStream() {
        return ((g.a.h.h) this.f13662a).getAADStream();
    }

    public InputStream getInputStream(InputStream inputStream) {
        Object obj = this.f13662a;
        return obj instanceof g.a.h.i ? ((g.a.h.i) obj).getInputStream(inputStream) : new g.a.j.s.c(inputStream, ((g.a.h.j) this.f13662a).getOutputStream());
    }

    public byte[] getMac() {
        return ((g.a.h.j) this.f13662a).getMac();
    }

    public boolean isAEADBased() {
        return this.f13662a instanceof g.a.h.h;
    }

    public boolean isMacBased() {
        return this.f13662a instanceof g.a.h.j;
    }
}
