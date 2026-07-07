package okhttp3;

import f.c;
import f.d;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.annotation.Nullable;
import okhttp3.internal.Util;

/* JADX INFO: loaded from: classes2.dex */
public final class FormBody extends RequestBody {
    private static final MediaType CONTENT_TYPE = MediaType.get("application/x-www-form-urlencoded");
    private final List<String> encodedNames;
    private final List<String> encodedValues;

    public static final class Builder {
        private final Charset charset;
        private final List<String> names;
        private final List<String> values;

        public Builder() {
            this(null);
        }

        public Builder add(String str, String str2) {
            Objects.requireNonNull(str, "name == null");
            Objects.requireNonNull(str2, "value == null");
            this.names.add(HttpUrl.canonicalize(str, HttpUrl.FORM_ENCODE_SET, false, false, true, true, this.charset));
            this.values.add(HttpUrl.canonicalize(str2, HttpUrl.FORM_ENCODE_SET, false, false, true, true, this.charset));
            return this;
        }

        public Builder addEncoded(String str, String str2) {
            Objects.requireNonNull(str, "name == null");
            Objects.requireNonNull(str2, "value == null");
            this.names.add(HttpUrl.canonicalize(str, HttpUrl.FORM_ENCODE_SET, true, false, true, true, this.charset));
            this.values.add(HttpUrl.canonicalize(str2, HttpUrl.FORM_ENCODE_SET, true, false, true, true, this.charset));
            return this;
        }

        public FormBody build() {
            return new FormBody(this.names, this.values);
        }

        public Builder(Charset charset) {
            this.names = new ArrayList();
            this.values = new ArrayList();
            this.charset = charset;
        }
    }

    public FormBody(List<String> list, List<String> list2) {
        this.encodedNames = Util.immutableList(list);
        this.encodedValues = Util.immutableList(list2);
    }

    private long writeOrCountBytes(@Nullable d dVar, boolean z) {
        c cVar = z ? new c() : dVar.buffer();
        int size = this.encodedNames.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (i2 > 0) {
                cVar.writeByte(38);
            }
            cVar.writeUtf8(this.encodedNames.get(i2));
            cVar.writeByte(61);
            cVar.writeUtf8(this.encodedValues.get(i2));
        }
        if (!z) {
            return 0L;
        }
        long size2 = cVar.size();
        cVar.clear();
        return size2;
    }

    @Override // okhttp3.RequestBody
    public long contentLength() {
        return writeOrCountBytes(null, true);
    }

    @Override // okhttp3.RequestBody
    public MediaType contentType() {
        return CONTENT_TYPE;
    }

    public String encodedName(int i2) {
        return this.encodedNames.get(i2);
    }

    public String encodedValue(int i2) {
        return this.encodedValues.get(i2);
    }

    public String name(int i2) {
        return HttpUrl.percentDecode(encodedName(i2), true);
    }

    public int size() {
        return this.encodedNames.size();
    }

    public String value(int i2) {
        return HttpUrl.percentDecode(encodedValue(i2), true);
    }

    @Override // okhttp3.RequestBody
    public void writeTo(d dVar) throws IOException {
        writeOrCountBytes(dVar, false);
    }
}
