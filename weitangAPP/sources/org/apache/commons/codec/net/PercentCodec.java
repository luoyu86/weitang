package org.apache.commons.codec.net;

import androidx.appcompat.widget.ActivityChooserView;
import java.nio.ByteBuffer;
import java.util.BitSet;
import org.apache.commons.codec.BinaryDecoder;
import org.apache.commons.codec.BinaryEncoder;
import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.EncoderException;

/* JADX INFO: loaded from: classes2.dex */
public class PercentCodec implements BinaryEncoder, BinaryDecoder {
    private static final byte ESCAPE_CHAR = 37;
    private final BitSet alwaysEncodeChars;
    private int alwaysEncodeCharsMax;
    private int alwaysEncodeCharsMin;
    private final boolean plusForSpace;

    public PercentCodec() {
        this.alwaysEncodeChars = new BitSet();
        this.alwaysEncodeCharsMin = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        this.alwaysEncodeCharsMax = Integer.MIN_VALUE;
        this.plusForSpace = false;
        insertAlwaysEncodeChar((byte) 37);
    }

    private boolean canEncode(byte b2) {
        return !isAsciiChar(b2) || (inAlwaysEncodeCharsRange(b2) && this.alwaysEncodeChars.get(b2));
    }

    private boolean containsSpace(byte[] bArr) {
        for (byte b2 : bArr) {
            if (b2 == 32) {
                return true;
            }
        }
        return false;
    }

    private byte[] doEncode(byte[] bArr, int i2, boolean z) {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(i2);
        for (byte b2 : bArr) {
            if (z && canEncode(b2)) {
                if (b2 < 0) {
                    b2 = (byte) (b2 + 256);
                }
                char cHexDigit = Utils.hexDigit(b2 >> 4);
                char cHexDigit2 = Utils.hexDigit(b2);
                byteBufferAllocate.put((byte) 37);
                byteBufferAllocate.put((byte) cHexDigit);
                byteBufferAllocate.put((byte) cHexDigit2);
            } else if (this.plusForSpace && b2 == 32) {
                byteBufferAllocate.put((byte) 43);
            } else {
                byteBufferAllocate.put(b2);
            }
        }
        return byteBufferAllocate.array();
    }

    private int expectedDecodingBytes(byte[] bArr) {
        int i2 = 0;
        int i3 = 0;
        while (i2 < bArr.length) {
            i2 += bArr[i2] == 37 ? 3 : 1;
            i3++;
        }
        return i3;
    }

    private int expectedEncodingBytes(byte[] bArr) {
        int i2 = 0;
        for (byte b2 : bArr) {
            i2 += canEncode(b2) ? 3 : 1;
        }
        return i2;
    }

    private boolean inAlwaysEncodeCharsRange(byte b2) {
        return b2 >= this.alwaysEncodeCharsMin && b2 <= this.alwaysEncodeCharsMax;
    }

    private void insertAlwaysEncodeChar(byte b2) {
        this.alwaysEncodeChars.set(b2);
        if (b2 < this.alwaysEncodeCharsMin) {
            this.alwaysEncodeCharsMin = b2;
        }
        if (b2 > this.alwaysEncodeCharsMax) {
            this.alwaysEncodeCharsMax = b2;
        }
    }

    private void insertAlwaysEncodeChars(byte[] bArr) {
        if (bArr != null) {
            for (byte b2 : bArr) {
                insertAlwaysEncodeChar(b2);
            }
        }
        insertAlwaysEncodeChar((byte) 37);
    }

    private boolean isAsciiChar(byte b2) {
        return b2 >= 0;
    }

    @Override // org.apache.commons.codec.BinaryDecoder
    public byte[] decode(byte[] bArr) throws DecoderException {
        if (bArr == null) {
            return null;
        }
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(expectedDecodingBytes(bArr));
        int i2 = 0;
        while (i2 < bArr.length) {
            byte b2 = bArr[i2];
            if (b2 == 37) {
                int i3 = i2 + 1;
                try {
                    int iDigit16 = Utils.digit16(bArr[i3]);
                    i2 = i3 + 1;
                    byteBufferAllocate.put((byte) ((iDigit16 << 4) + Utils.digit16(bArr[i2])));
                } catch (ArrayIndexOutOfBoundsException e2) {
                    throw new DecoderException("Invalid percent decoding: ", e2);
                }
            } else if (this.plusForSpace && b2 == 43) {
                byteBufferAllocate.put((byte) 32);
            } else {
                byteBufferAllocate.put(b2);
            }
            i2++;
        }
        return byteBufferAllocate.array();
    }

    @Override // org.apache.commons.codec.BinaryEncoder
    public byte[] encode(byte[] bArr) throws EncoderException {
        if (bArr == null) {
            return null;
        }
        int iExpectedEncodingBytes = expectedEncodingBytes(bArr);
        boolean z = iExpectedEncodingBytes != bArr.length;
        return (z || (this.plusForSpace && containsSpace(bArr))) ? doEncode(bArr, iExpectedEncodingBytes, z) : bArr;
    }

    @Override // org.apache.commons.codec.Encoder
    public Object encode(Object obj) throws EncoderException {
        if (obj == null) {
            return null;
        }
        if (obj instanceof byte[]) {
            return encode((byte[]) obj);
        }
        throw new EncoderException("Objects of type " + obj.getClass().getName() + " cannot be Percent encoded");
    }

    public PercentCodec(byte[] bArr, boolean z) {
        this.alwaysEncodeChars = new BitSet();
        this.alwaysEncodeCharsMin = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        this.alwaysEncodeCharsMax = Integer.MIN_VALUE;
        this.plusForSpace = z;
        insertAlwaysEncodeChars(bArr);
    }

    @Override // org.apache.commons.codec.Decoder
    public Object decode(Object obj) throws DecoderException {
        if (obj == null) {
            return null;
        }
        if (obj instanceof byte[]) {
            return decode((byte[]) obj);
        }
        throw new DecoderException("Objects of type " + obj.getClass().getName() + " cannot be Percent decoded");
    }
}
