package okhttp3;

import f.d;
import f.f;
import f.l;
import f.t;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Objects;
import javax.annotation.Nullable;
import okhttp3.internal.Util;

/* JADX INFO: loaded from: classes2.dex */
public abstract class RequestBody {
    public static RequestBody create(@Nullable MediaType mediaType, String str) {
        Charset charset = Util.UTF_8;
        if (mediaType != null) {
            Charset charset2 = mediaType.charset();
            if (charset2 == null) {
                mediaType = MediaType.parse(mediaType + "; charset=utf-8");
            } else {
                charset = charset2;
            }
        }
        return create(mediaType, str.getBytes(charset));
    }

    public long contentLength() throws IOException {
        return -1L;
    }

    @Nullable
    public abstract MediaType contentType();

    public abstract void writeTo(d dVar) throws IOException;

    public static RequestBody create(@Nullable final MediaType mediaType, final f fVar) {
        return new RequestBody() { // from class: okhttp3.RequestBody.1
            @Override // okhttp3.RequestBody
            public long contentLength() throws IOException {
                return fVar.size();
            }

            @Override // okhttp3.RequestBody
            @Nullable
            public MediaType contentType() {
                return mediaType;
            }

            @Override // okhttp3.RequestBody
            public void writeTo(d dVar) throws IOException {
                dVar.write(fVar);
            }
        };
    }

    public static RequestBody create(@Nullable MediaType mediaType, byte[] bArr) {
        return create(mediaType, bArr, 0, bArr.length);
    }

    public static RequestBody create(@Nullable final MediaType mediaType, final byte[] bArr, final int i2, final int i3) {
        Objects.requireNonNull(bArr, "content == null");
        Util.checkOffsetAndCount(bArr.length, i2, i3);
        return new RequestBody() { // from class: okhttp3.RequestBody.2
            @Override // okhttp3.RequestBody
            public long contentLength() {
                return i3;
            }

            @Override // okhttp3.RequestBody
            @Nullable
            public MediaType contentType() {
                return mediaType;
            }

            @Override // okhttp3.RequestBody
            public void writeTo(d dVar) throws IOException {
                dVar.write(bArr, i2, i3);
            }
        };
    }

    public static RequestBody create(@Nullable final MediaType mediaType, final File file) {
        Objects.requireNonNull(file, "content == null");
        return new RequestBody() { // from class: okhttp3.RequestBody.3
            @Override // okhttp3.RequestBody
            public long contentLength() {
                return file.length();
            }

            @Override // okhttp3.RequestBody
            @Nullable
            public MediaType contentType() {
                return mediaType;
            }

            @Override // okhttp3.RequestBody
            public void writeTo(d dVar) throws IOException {
                t tVarSource = null;
                try {
                    tVarSource = l.source(file);
                    dVar.writeAll(tVarSource);
                } finally {
                    Util.closeQuietly(tVarSource);
                }
            }
        };
    }
}
