package com.sun.mail.util;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PushbackInputStream;
import java.nio.ByteBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CodingErrorAction;
import java.nio.charset.StandardCharsets;

/* JADX INFO: loaded from: classes2.dex */
public class LineInputStream extends FilterInputStream {
    private boolean allowutf8;
    private CharsetDecoder decoder;
    private byte[] lineBuffer;
    private static boolean defaultutf8 = PropUtil.getBooleanSystemProperty("mail.mime.allowutf8", false);
    private static int MAX_INCR = 1048576;

    public LineInputStream(InputStream inputStream) {
        this(inputStream, false);
    }

    public String readLine() throws IOException {
        int i2;
        byte[] bArr = this.lineBuffer;
        if (bArr == null) {
            bArr = new byte[128];
            this.lineBuffer = bArr;
        }
        int length = bArr.length;
        int i3 = 0;
        while (true) {
            i2 = ((FilterInputStream) this).in.read();
            if (i2 == -1 || i2 == 10) {
                break;
            }
            boolean z = true;
            if (i2 == 13) {
                if (((FilterInputStream) this).in.markSupported()) {
                    ((FilterInputStream) this).in.mark(2);
                }
                int i4 = ((FilterInputStream) this).in.read();
                if (i4 == 13) {
                    i4 = ((FilterInputStream) this).in.read();
                } else {
                    z = false;
                }
                if (i4 != 10) {
                    if (((FilterInputStream) this).in.markSupported()) {
                        ((FilterInputStream) this).in.reset();
                    } else {
                        if (!(((FilterInputStream) this).in instanceof PushbackInputStream)) {
                            ((FilterInputStream) this).in = new PushbackInputStream(((FilterInputStream) this).in, 2);
                        }
                        if (i4 != -1) {
                            ((PushbackInputStream) ((FilterInputStream) this).in).unread(i4);
                        }
                        if (z) {
                            ((PushbackInputStream) ((FilterInputStream) this).in).unread(13);
                        }
                    }
                }
            } else {
                length--;
                if (length < 0) {
                    int length2 = bArr.length;
                    int i5 = MAX_INCR;
                    bArr = length2 < i5 ? new byte[bArr.length * 2] : new byte[bArr.length + i5];
                    length = (bArr.length - i3) - 1;
                    System.arraycopy(this.lineBuffer, 0, bArr, 0, i3);
                    this.lineBuffer = bArr;
                }
                bArr[i3] = (byte) i2;
                i3++;
            }
        }
        if (i2 == -1 && i3 == 0) {
            return null;
        }
        if (this.allowutf8) {
            return new String(bArr, 0, i3, StandardCharsets.UTF_8);
        }
        if (defaultutf8) {
            try {
                return this.decoder.decode(ByteBuffer.wrap(bArr, 0, i3)).toString();
            } catch (CharacterCodingException unused) {
            }
        }
        return new String(bArr, 0, 0, i3);
    }

    public LineInputStream(InputStream inputStream, boolean z) {
        super(inputStream);
        this.lineBuffer = null;
        this.allowutf8 = z;
        if (z || !defaultutf8) {
            return;
        }
        CharsetDecoder charsetDecoderNewDecoder = StandardCharsets.UTF_8.newDecoder();
        this.decoder = charsetDecoderNewDecoder;
        charsetDecoderNewDecoder.onMalformedInput(CodingErrorAction.REPORT);
        this.decoder.onUnmappableCharacter(CodingErrorAction.REPORT);
    }
}
