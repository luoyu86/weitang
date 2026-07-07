package anet.channel.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public class a extends InputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private InputStream f712a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f713b = 0;

    public a(InputStream inputStream) {
        this.f712a = null;
        Objects.requireNonNull(inputStream, "input stream cannot be null");
        this.f712a = inputStream;
    }

    public long a() {
        return this.f713b;
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        this.f713b++;
        return this.f712a.read();
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i2, int i3) throws IOException {
        int i4 = this.f712a.read(bArr, i2, i3);
        if (i4 != -1) {
            this.f713b += (long) i4;
        }
        return i4;
    }
}
