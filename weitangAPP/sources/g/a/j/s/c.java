package g.a.j.s;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes3.dex */
public class c extends InputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InputStream f14672a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final OutputStream f14673b;

    public c(InputStream inputStream, OutputStream outputStream) {
        this.f14672a = inputStream;
        this.f14673b = outputStream;
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        return this.f14672a.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f14672a.close();
        this.f14673b.close();
    }

    public OutputStream getOutputStream() {
        return this.f14673b;
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        int i2 = this.f14672a.read();
        if (i2 >= 0) {
            this.f14673b.write(i2);
        }
        return i2;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i2, int i3) throws IOException {
        int i4 = this.f14672a.read(bArr, i2, i3);
        if (i4 > 0) {
            this.f14673b.write(bArr, i2, i4);
        }
        return i4;
    }
}
