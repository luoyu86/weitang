package g.a.c;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes2.dex */
public class i implements j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g.a.a.v f13663a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte[] f13664b;

    public i(g.a.a.v vVar, byte[] bArr) {
        this.f13663a = vVar;
        this.f13664b = bArr;
    }

    public i(byte[] bArr) {
        this(g.a.a.i3.d.Y, bArr);
    }

    public Object getContent() {
        return g.a.j.a.clone(this.f13664b);
    }

    public g.a.a.v getContentType() {
        return this.f13663a;
    }

    @Override // g.a.c.j
    public InputStream getInputStream() {
        return new ByteArrayInputStream(this.f13664b);
    }

    public void write(OutputStream outputStream) throws h, IOException {
        outputStream.write(this.f13664b);
    }
}
