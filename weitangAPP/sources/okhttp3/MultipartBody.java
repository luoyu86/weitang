package okhttp3;

import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import com.tom_roush.pdfbox.pdfparser.BaseParser;
import f.c;
import f.d;
import f.f;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import javax.annotation.Nullable;
import okhttp3.internal.Util;

/* JADX INFO: loaded from: classes2.dex */
public final class MultipartBody extends RequestBody {
    private final f boundary;
    private long contentLength = -1;
    private final MediaType contentType;
    private final MediaType originalType;
    private final List<Part> parts;
    public static final MediaType MIXED = MediaType.get("multipart/mixed");
    public static final MediaType ALTERNATIVE = MediaType.get("multipart/alternative");
    public static final MediaType DIGEST = MediaType.get("multipart/digest");
    public static final MediaType PARALLEL = MediaType.get("multipart/parallel");
    public static final MediaType FORM = MediaType.get("multipart/form-data");
    private static final byte[] COLONSPACE = {58, 32};
    private static final byte[] CRLF = {BaseParser.ASCII_CR, 10};
    private static final byte[] DASHDASH = {45, 45};

    public static final class Builder {
        private final f boundary;
        private final List<Part> parts;
        private MediaType type;

        public Builder() {
            this(UUID.randomUUID().toString());
        }

        public Builder addFormDataPart(String str, String str2) {
            return addPart(Part.createFormData(str, str2));
        }

        public Builder addPart(RequestBody requestBody) {
            return addPart(Part.create(requestBody));
        }

        public MultipartBody build() {
            if (this.parts.isEmpty()) {
                throw new IllegalStateException("Multipart body must have at least one part.");
            }
            return new MultipartBody(this.boundary, this.type, this.parts);
        }

        public Builder setType(MediaType mediaType) {
            Objects.requireNonNull(mediaType, "type == null");
            if (mediaType.type().equals("multipart")) {
                this.type = mediaType;
                return this;
            }
            throw new IllegalArgumentException("multipart != " + mediaType);
        }

        public Builder(String str) {
            this.type = MultipartBody.MIXED;
            this.parts = new ArrayList();
            this.boundary = f.encodeUtf8(str);
        }

        public Builder addFormDataPart(String str, @Nullable String str2, RequestBody requestBody) {
            return addPart(Part.createFormData(str, str2, requestBody));
        }

        public Builder addPart(@Nullable Headers headers, RequestBody requestBody) {
            return addPart(Part.create(headers, requestBody));
        }

        public Builder addPart(Part part) {
            Objects.requireNonNull(part, "part == null");
            this.parts.add(part);
            return this;
        }
    }

    public static final class Part {
        public final RequestBody body;

        @Nullable
        public final Headers headers;

        private Part(@Nullable Headers headers, RequestBody requestBody) {
            this.headers = headers;
            this.body = requestBody;
        }

        public static Part create(RequestBody requestBody) {
            return create(null, requestBody);
        }

        public static Part createFormData(String str, String str2) {
            return createFormData(str, null, RequestBody.create((MediaType) null, str2));
        }

        public RequestBody body() {
            return this.body;
        }

        @Nullable
        public Headers headers() {
            return this.headers;
        }

        public static Part create(@Nullable Headers headers, RequestBody requestBody) {
            Objects.requireNonNull(requestBody, "body == null");
            if (headers != null && headers.get("Content-Type") != null) {
                throw new IllegalArgumentException("Unexpected header: Content-Type");
            }
            if (headers == null || headers.get("Content-Length") == null) {
                return new Part(headers, requestBody);
            }
            throw new IllegalArgumentException("Unexpected header: Content-Length");
        }

        public static Part createFormData(String str, @Nullable String str2, RequestBody requestBody) {
            Objects.requireNonNull(str, "name == null");
            StringBuilder sb = new StringBuilder("form-data; name=");
            MultipartBody.appendQuotedString(sb, str);
            if (str2 != null) {
                sb.append("; filename=");
                MultipartBody.appendQuotedString(sb, str2);
            }
            return create(Headers.of(HttpHeaders.CONTENT_DISPOSITION, sb.toString()), requestBody);
        }
    }

    public MultipartBody(f fVar, MediaType mediaType, List<Part> list) {
        this.boundary = fVar;
        this.originalType = mediaType;
        this.contentType = MediaType.get(mediaType + "; boundary=" + fVar.utf8());
        this.parts = Util.immutableList(list);
    }

    public static StringBuilder appendQuotedString(StringBuilder sb, String str) {
        sb.append('\"');
        int length = str.length();
        for (int i2 = 0; i2 < length; i2++) {
            char cCharAt = str.charAt(i2);
            if (cCharAt == '\n') {
                sb.append("%0A");
            } else if (cCharAt == '\r') {
                sb.append("%0D");
            } else if (cCharAt != '\"') {
                sb.append(cCharAt);
            } else {
                sb.append("%22");
            }
        }
        sb.append('\"');
        return sb;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private long writeOrCountBytes(@Nullable d dVar, boolean z) throws IOException {
        c cVar;
        if (z) {
            dVar = new c();
            cVar = dVar;
        } else {
            cVar = 0;
        }
        int size = this.parts.size();
        long j = 0;
        for (int i2 = 0; i2 < size; i2++) {
            Part part = this.parts.get(i2);
            Headers headers = part.headers;
            RequestBody requestBody = part.body;
            dVar.write(DASHDASH);
            dVar.write(this.boundary);
            dVar.write(CRLF);
            if (headers != null) {
                int size2 = headers.size();
                for (int i3 = 0; i3 < size2; i3++) {
                    dVar.writeUtf8(headers.name(i3)).write(COLONSPACE).writeUtf8(headers.value(i3)).write(CRLF);
                }
            }
            MediaType mediaTypeContentType = requestBody.contentType();
            if (mediaTypeContentType != null) {
                dVar.writeUtf8("Content-Type: ").writeUtf8(mediaTypeContentType.toString()).write(CRLF);
            }
            long jContentLength = requestBody.contentLength();
            if (jContentLength != -1) {
                dVar.writeUtf8("Content-Length: ").writeDecimalLong(jContentLength).write(CRLF);
            } else if (z) {
                cVar.clear();
                return -1L;
            }
            byte[] bArr = CRLF;
            dVar.write(bArr);
            if (z) {
                j += jContentLength;
            } else {
                requestBody.writeTo(dVar);
            }
            dVar.write(bArr);
        }
        byte[] bArr2 = DASHDASH;
        dVar.write(bArr2);
        dVar.write(this.boundary);
        dVar.write(bArr2);
        dVar.write(CRLF);
        if (!z) {
            return j;
        }
        long size3 = j + cVar.size();
        cVar.clear();
        return size3;
    }

    public String boundary() {
        return this.boundary.utf8();
    }

    @Override // okhttp3.RequestBody
    public long contentLength() throws IOException {
        long j = this.contentLength;
        if (j != -1) {
            return j;
        }
        long jWriteOrCountBytes = writeOrCountBytes(null, true);
        this.contentLength = jWriteOrCountBytes;
        return jWriteOrCountBytes;
    }

    @Override // okhttp3.RequestBody
    public MediaType contentType() {
        return this.contentType;
    }

    public Part part(int i2) {
        return this.parts.get(i2);
    }

    public List<Part> parts() {
        return this.parts;
    }

    public int size() {
        return this.parts.size();
    }

    public MediaType type() {
        return this.originalType;
    }

    @Override // okhttp3.RequestBody
    public void writeTo(d dVar) throws IOException {
        writeOrCountBytes(dVar, false);
    }
}
