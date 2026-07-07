package okhttp3.internal.http2;

import anet.channel.util.HttpConstant;
import f.f;
import okhttp3.internal.Util;

/* JADX INFO: loaded from: classes2.dex */
public final class Header {
    public final int hpackSize;
    public final f name;
    public final f value;
    public static final f PSEUDO_PREFIX = f.encodeUtf8(":");
    public static final f RESPONSE_STATUS = f.encodeUtf8(HttpConstant.STATUS);
    public static final f TARGET_METHOD = f.encodeUtf8(":method");
    public static final f TARGET_PATH = f.encodeUtf8(":path");
    public static final f TARGET_SCHEME = f.encodeUtf8(":scheme");
    public static final f TARGET_AUTHORITY = f.encodeUtf8(":authority");

    public Header(String str, String str2) {
        this(f.encodeUtf8(str), f.encodeUtf8(str2));
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Header)) {
            return false;
        }
        Header header = (Header) obj;
        return this.name.equals(header.name) && this.value.equals(header.value);
    }

    public int hashCode() {
        return ((527 + this.name.hashCode()) * 31) + this.value.hashCode();
    }

    public String toString() {
        return Util.format("%s: %s", this.name.utf8(), this.value.utf8());
    }

    public Header(f fVar, String str) {
        this(fVar, f.encodeUtf8(str));
    }

    public Header(f fVar, f fVar2) {
        this.name = fVar;
        this.value = fVar2;
        this.hpackSize = fVar.size() + 32 + fVar2.size();
    }
}
