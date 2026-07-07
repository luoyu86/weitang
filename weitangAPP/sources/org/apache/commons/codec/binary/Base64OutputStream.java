package org.apache.commons.codec.binary;

import java.io.OutputStream;
import org.apache.commons.codec.CodecPolicy;

/* JADX INFO: loaded from: classes2.dex */
public class Base64OutputStream extends BaseNCodecOutputStream {
    public Base64OutputStream(OutputStream outputStream) {
        this(outputStream, true);
    }

    public Base64OutputStream(OutputStream outputStream, boolean z) {
        super(outputStream, new Base64(false), z);
    }

    public Base64OutputStream(OutputStream outputStream, boolean z, int i2, byte[] bArr) {
        super(outputStream, new Base64(i2, bArr), z);
    }

    public Base64OutputStream(OutputStream outputStream, boolean z, int i2, byte[] bArr, CodecPolicy codecPolicy) {
        super(outputStream, new Base64(i2, bArr, false, codecPolicy), z);
    }
}
