package org.apache.commons.codec.binary;

import java.io.InputStream;
import org.apache.commons.codec.CodecPolicy;

/* JADX INFO: loaded from: classes2.dex */
public class Base32InputStream extends BaseNCodecInputStream {
    public Base32InputStream(InputStream inputStream) {
        this(inputStream, false);
    }

    public Base32InputStream(InputStream inputStream, boolean z) {
        super(inputStream, new Base32(false), z);
    }

    public Base32InputStream(InputStream inputStream, boolean z, int i2, byte[] bArr) {
        super(inputStream, new Base32(i2, bArr), z);
    }

    public Base32InputStream(InputStream inputStream, boolean z, int i2, byte[] bArr, CodecPolicy codecPolicy) {
        super(inputStream, new Base32(i2, bArr, false, BaseNCodec.PAD_DEFAULT, codecPolicy), z);
    }
}
