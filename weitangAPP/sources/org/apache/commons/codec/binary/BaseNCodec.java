package org.apache.commons.codec.binary;

import com.tom_roush.pdfbox.pdfparser.BaseParser;
import java.util.Arrays;
import java.util.Objects;
import javax.mail.UIDFolder;
import org.apache.commons.codec.BinaryDecoder;
import org.apache.commons.codec.BinaryEncoder;
import org.apache.commons.codec.CodecPolicy;
import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.EncoderException;

/* JADX INFO: loaded from: classes2.dex */
public abstract class BaseNCodec implements BinaryEncoder, BinaryDecoder {
    private static final int DEFAULT_BUFFER_RESIZE_FACTOR = 2;
    private static final int DEFAULT_BUFFER_SIZE = 8192;
    public static final int EOF = -1;
    public static final int MASK_8BITS = 255;
    private static final int MAX_BUFFER_SIZE = 2147483639;
    public static final int MIME_CHUNK_SIZE = 76;
    public static final byte PAD_DEFAULT = 61;
    public static final int PEM_CHUNK_SIZE = 64;

    @Deprecated
    public final byte PAD;
    private final int chunkSeparatorLength;
    private final CodecPolicy decodingPolicy;
    private final int encodedBlockSize;
    public final int lineLength;
    public final byte pad;
    private final int unencodedBlockSize;
    public static final CodecPolicy DECODING_POLICY_DEFAULT = CodecPolicy.LENIENT;
    public static final byte[] CHUNK_SEPARATOR = {BaseParser.ASCII_CR, 10};

    public static class Context {
        public byte[] buffer;
        public int currentLinePos;
        public boolean eof;
        public int ibitWorkArea;
        public long lbitWorkArea;
        public int modulus;
        public int pos;
        public int readPos;

        public String toString() {
            return String.format("%s[buffer=%s, currentLinePos=%s, eof=%s, ibitWorkArea=%s, lbitWorkArea=%s, modulus=%s, pos=%s, readPos=%s]", getClass().getSimpleName(), Arrays.toString(this.buffer), Integer.valueOf(this.currentLinePos), Boolean.valueOf(this.eof), Integer.valueOf(this.ibitWorkArea), Long.valueOf(this.lbitWorkArea), Integer.valueOf(this.modulus), Integer.valueOf(this.pos), Integer.valueOf(this.readPos));
        }
    }

    public BaseNCodec(int i2, int i3, int i4, int i5) {
        this(i2, i3, i4, i5, PAD_DEFAULT);
    }

    private static int compareUnsigned(int i2, int i3) {
        return Integer.compare(i2 - Integer.MIN_VALUE, i3 - Integer.MIN_VALUE);
    }

    private static int createPositiveCapacity(int i2) {
        if (i2 >= 0) {
            return i2 > MAX_BUFFER_SIZE ? i2 : MAX_BUFFER_SIZE;
        }
        throw new OutOfMemoryError("Unable to allocate array size: " + (((long) i2) & UIDFolder.MAXUID));
    }

    public static byte[] getChunkSeparator() {
        return (byte[]) CHUNK_SEPARATOR.clone();
    }

    public static boolean isWhiteSpace(byte b2) {
        return b2 == 9 || b2 == 10 || b2 == 13 || b2 == 32;
    }

    private static byte[] resizeBuffer(Context context, int i2) {
        int length = context.buffer.length * 2;
        if (compareUnsigned(length, i2) < 0) {
            length = i2;
        }
        if (compareUnsigned(length, MAX_BUFFER_SIZE) > 0) {
            length = createPositiveCapacity(i2);
        }
        byte[] bArr = new byte[length];
        byte[] bArr2 = context.buffer;
        System.arraycopy(bArr2, 0, bArr, 0, bArr2.length);
        context.buffer = bArr;
        return bArr;
    }

    public int available(Context context) {
        if (context.buffer != null) {
            return context.pos - context.readPos;
        }
        return 0;
    }

    public boolean containsAlphabetOrPad(byte[] bArr) {
        if (bArr == null) {
            return false;
        }
        for (byte b2 : bArr) {
            if (this.pad == b2 || isInAlphabet(b2)) {
                return true;
            }
        }
        return false;
    }

    public abstract void decode(byte[] bArr, int i2, int i3, Context context);

    @Override // org.apache.commons.codec.BinaryDecoder
    public byte[] decode(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return bArr;
        }
        Context context = new Context();
        decode(bArr, 0, bArr.length, context);
        decode(bArr, 0, -1, context);
        int i2 = context.pos;
        byte[] bArr2 = new byte[i2];
        readResults(bArr2, 0, i2, context);
        return bArr2;
    }

    public abstract void encode(byte[] bArr, int i2, int i3, Context context);

    @Override // org.apache.commons.codec.BinaryEncoder
    public byte[] encode(byte[] bArr) {
        return (bArr == null || bArr.length == 0) ? bArr : encode(bArr, 0, bArr.length);
    }

    public String encodeAsString(byte[] bArr) {
        return StringUtils.newStringUtf8(encode(bArr));
    }

    public String encodeToString(byte[] bArr) {
        return StringUtils.newStringUtf8(encode(bArr));
    }

    public byte[] ensureBufferSize(int i2, Context context) {
        byte[] bArr = context.buffer;
        if (bArr == null) {
            context.buffer = new byte[Math.max(i2, getDefaultBufferSize())];
            context.pos = 0;
            context.readPos = 0;
        } else {
            int i3 = context.pos;
            if ((i3 + i2) - bArr.length > 0) {
                return resizeBuffer(context, i3 + i2);
            }
        }
        return context.buffer;
    }

    public CodecPolicy getCodecPolicy() {
        return this.decodingPolicy;
    }

    public int getDefaultBufferSize() {
        return 8192;
    }

    public long getEncodedLength(byte[] bArr) {
        int length = bArr.length;
        long j = ((long) (((length + r0) - 1) / this.unencodedBlockSize)) * ((long) this.encodedBlockSize);
        int i2 = this.lineLength;
        return i2 > 0 ? j + ((((((long) i2) + j) - 1) / ((long) i2)) * ((long) this.chunkSeparatorLength)) : j;
    }

    public boolean hasData(Context context) {
        return context.buffer != null;
    }

    public abstract boolean isInAlphabet(byte b2);

    public boolean isInAlphabet(byte[] bArr, boolean z) {
        for (byte b2 : bArr) {
            if (!isInAlphabet(b2) && (!z || (b2 != this.pad && !isWhiteSpace(b2)))) {
                return false;
            }
        }
        return true;
    }

    public boolean isStrictDecoding() {
        return this.decodingPolicy == CodecPolicy.STRICT;
    }

    public int readResults(byte[] bArr, int i2, int i3, Context context) {
        if (context.buffer == null) {
            return context.eof ? -1 : 0;
        }
        int iMin = Math.min(available(context), i3);
        System.arraycopy(context.buffer, context.readPos, bArr, i2, iMin);
        int i4 = context.readPos + iMin;
        context.readPos = i4;
        if (i4 >= context.pos) {
            context.buffer = null;
        }
        return iMin;
    }

    public BaseNCodec(int i2, int i3, int i4, int i5, byte b2) {
        this(i2, i3, i4, i5, b2, DECODING_POLICY_DEFAULT);
    }

    public BaseNCodec(int i2, int i3, int i4, int i5, byte b2, CodecPolicy codecPolicy) {
        this.PAD = PAD_DEFAULT;
        this.unencodedBlockSize = i2;
        this.encodedBlockSize = i3;
        this.lineLength = i4 > 0 && i5 > 0 ? (i4 / i3) * i3 : 0;
        this.chunkSeparatorLength = i5;
        this.pad = b2;
        Objects.requireNonNull(codecPolicy, "codecPolicy");
        this.decodingPolicy = codecPolicy;
    }

    public byte[] encode(byte[] bArr, int i2, int i3) {
        if (bArr == null || bArr.length == 0) {
            return bArr;
        }
        Context context = new Context();
        encode(bArr, i2, i3, context);
        encode(bArr, i2, -1, context);
        int i4 = context.pos - context.readPos;
        byte[] bArr2 = new byte[i4];
        readResults(bArr2, 0, i4, context);
        return bArr2;
    }

    public boolean isInAlphabet(String str) {
        return isInAlphabet(StringUtils.getBytesUtf8(str), true);
    }

    @Override // org.apache.commons.codec.Decoder
    public Object decode(Object obj) throws DecoderException {
        if (obj instanceof byte[]) {
            return decode((byte[]) obj);
        }
        if (obj instanceof String) {
            return decode((String) obj);
        }
        throw new DecoderException("Parameter supplied to Base-N decode is not a byte[] or a String");
    }

    @Override // org.apache.commons.codec.Encoder
    public Object encode(Object obj) throws EncoderException {
        if (obj instanceof byte[]) {
            return encode((byte[]) obj);
        }
        throw new EncoderException("Parameter supplied to Base-N encode is not a byte[]");
    }

    public byte[] decode(String str) {
        return decode(StringUtils.getBytesUtf8(str));
    }
}
