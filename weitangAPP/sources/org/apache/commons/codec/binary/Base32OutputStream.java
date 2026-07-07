package org.apache.commons.codec.binary;

import java.io.OutputStream;
import org.apache.commons.codec.CodecPolicy;

/* JADX INFO: loaded from: classes2.dex */
public class Base32OutputStream extends BaseNCodecOutputStream {
    public Base32OutputStream(OutputStream outputStream) {
        this(outputStream, true);
    }

    public Base32OutputStream(OutputStream outputStream, boolean z) {
        super(outputStream, new Base32(false), z);
    }

    public Base32OutputStream(OutputStream outputStream, boolean z, int i2, byte[] bArr) {
        super(outputStream, new Base32(i2, bArr), z);
    }

    public Base32OutputStream(OutputStream outputStream, boolean z, int i2, byte[] bArr, CodecPolicy codecPolicy) {
        super(outputStream, new Base32(i2, bArr, false, BaseNCodec.PAD_DEFAULT, codecPolicy), z);
    }
}
