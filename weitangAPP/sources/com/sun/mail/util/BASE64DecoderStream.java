package com.sun.mail.util;

import java.io.EOFException;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes2.dex */
public class BASE64DecoderStream extends FilterInputStream {
    private static final char[] pem_array = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/'};
    private static final byte[] pem_convert_array = new byte[256];
    private byte[] buffer;
    private int bufsize;
    private boolean ignoreErrors;
    private int index;
    private byte[] input_buffer;
    private int input_len;
    private int input_pos;

    static {
        int i2 = 0;
        for (int i3 = 0; i3 < 255; i3++) {
            pem_convert_array[i3] = -1;
        }
        while (true) {
            char[] cArr = pem_array;
            if (i2 >= cArr.length) {
                return;
            }
            pem_convert_array[cArr[i2]] = (byte) i2;
            i2++;
        }
    }

    public BASE64DecoderStream(InputStream inputStream) {
        super(inputStream);
        this.buffer = new byte[3];
        this.bufsize = 0;
        this.index = 0;
        this.input_buffer = new byte[8190];
        this.input_pos = 0;
        this.input_len = 0;
        this.ignoreErrors = false;
        this.ignoreErrors = PropUtil.getBooleanSystemProperty("mail.mime.base64.ignoreerrors", false);
    }

    private int decode(byte[] bArr, int i2, int i3) throws IOException {
        int i4 = i2;
        while (i3 >= 3) {
            boolean z = false;
            int i5 = 0;
            int i6 = 0;
            while (i5 < 4) {
                int i7 = getByte();
                if (i7 == -1 || i7 == -2) {
                    if (i7 == -1) {
                        if (i5 == 0) {
                            return i4 - i2;
                        }
                        if (!this.ignoreErrors) {
                            throw new DecodingException("BASE64Decoder: Error in encoded stream: needed 4 valid base64 characters but only got " + i5 + " before EOF" + recentChars());
                        }
                        z = true;
                    } else {
                        if (i5 < 2 && !this.ignoreErrors) {
                            throw new DecodingException("BASE64Decoder: Error in encoded stream: needed at least 2 valid base64 characters, but only got " + i5 + " before padding character (=)" + recentChars());
                        }
                        if (i5 == 0) {
                            return i4 - i2;
                        }
                    }
                    int i8 = i5 - 1;
                    if (i8 == 0) {
                        i8 = 1;
                    }
                    int i9 = i6 << 6;
                    for (int i10 = i5 + 1; i10 < 4; i10++) {
                        if (!z) {
                            int i11 = getByte();
                            if (i11 == -1) {
                                if (!this.ignoreErrors) {
                                    throw new DecodingException("BASE64Decoder: Error in encoded stream: hit EOF while looking for padding characters (=)" + recentChars());
                                }
                            } else if (i11 != -2 && !this.ignoreErrors) {
                                throw new DecodingException("BASE64Decoder: Error in encoded stream: found valid base64 character after a padding character (=)" + recentChars());
                            }
                        }
                        i9 <<= 6;
                    }
                    int i12 = i9 >> 8;
                    if (i8 == 2) {
                        bArr[i4 + 1] = (byte) (i12 & 255);
                    }
                    bArr[i4] = (byte) ((i12 >> 8) & 255);
                    return (i4 + i8) - i2;
                }
                i5++;
                i6 = (i6 << 6) | i7;
            }
            bArr[i4 + 2] = (byte) (i6 & 255);
            int i13 = i6 >> 8;
            bArr[i4 + 1] = (byte) (i13 & 255);
            bArr[i4] = (byte) ((i13 >> 8) & 255);
            i3 -= 3;
            i4 += 3;
        }
        return i4 - i2;
    }

    private int getByte() throws IOException {
        byte b2;
        do {
            if (this.input_pos >= this.input_len) {
                try {
                    int i2 = ((FilterInputStream) this).in.read(this.input_buffer);
                    this.input_len = i2;
                    if (i2 <= 0) {
                        return -1;
                    }
                    this.input_pos = 0;
                } catch (EOFException unused) {
                    return -1;
                }
            }
            byte[] bArr = this.input_buffer;
            int i3 = this.input_pos;
            this.input_pos = i3 + 1;
            int i4 = bArr[i3] & 255;
            if (i4 == 61) {
                return -2;
            }
            b2 = pem_convert_array[i4];
        } while (b2 == -1);
        return b2;
    }

    private String recentChars() {
        String str;
        int i2 = this.input_pos;
        if (i2 > 10) {
            i2 = 10;
        }
        if (i2 <= 0) {
            return "";
        }
        String str2 = ", the " + i2 + " most recent characters were: \"";
        for (int i3 = this.input_pos - i2; i3 < this.input_pos; i3++) {
            char c2 = (char) (this.input_buffer[i3] & 255);
            if (c2 == '\t') {
                str = str2 + "\\t";
            } else if (c2 == '\n') {
                str = str2 + "\\n";
            } else if (c2 == '\r') {
                str = str2 + "\\r";
            } else if (c2 < ' ' || c2 >= 127) {
                str = str2 + "\\" + ((int) c2);
            } else {
                str = str2 + c2;
            }
            str2 = str;
        }
        return str2 + "\"";
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int available() throws IOException {
        return ((((FilterInputStream) this).in.available() * 3) / 4) + (this.bufsize - this.index);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public boolean markSupported() {
        return false;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        if (this.index >= this.bufsize) {
            byte[] bArr = this.buffer;
            int iDecode = decode(bArr, 0, bArr.length);
            this.bufsize = iDecode;
            if (iDecode <= 0) {
                return -1;
            }
            this.index = 0;
        }
        byte[] bArr2 = this.buffer;
        int i2 = this.index;
        this.index = i2 + 1;
        return bArr2[i2] & 255;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public long skip(long j) throws IOException {
        long j2 = 0;
        while (true) {
            long j3 = j - 1;
            if (j <= 0 || read() < 0) {
                break;
            }
            j2++;
            j = j3;
        }
        return j2;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i2, int i3) throws IOException {
        int i4;
        int i5;
        if (i3 == 0) {
            return 0;
        }
        int i6 = i2;
        while (true) {
            i4 = this.index;
            i5 = this.bufsize;
            if (i4 >= i5 || i3 <= 0) {
                break;
            }
            byte[] bArr2 = this.buffer;
            this.index = i4 + 1;
            bArr[i6] = bArr2[i4];
            i3--;
            i6++;
        }
        if (i4 >= i5) {
            this.index = 0;
            this.bufsize = 0;
        }
        int i7 = (i3 / 3) * 3;
        if (i7 > 0) {
            int iDecode = decode(bArr, i6, i7);
            i6 += iDecode;
            i3 -= iDecode;
            if (iDecode != i7) {
                if (i6 == i2) {
                    return -1;
                }
                return i6 - i2;
            }
        }
        while (i3 > 0) {
            int i8 = read();
            if (i8 == -1) {
                break;
            }
            bArr[i6] = (byte) i8;
            i3--;
            i6++;
        }
        if (i6 == i2) {
            return -1;
        }
        return i6 - i2;
    }

    public BASE64DecoderStream(InputStream inputStream, boolean z) {
        super(inputStream);
        this.buffer = new byte[3];
        this.bufsize = 0;
        this.index = 0;
        this.input_buffer = new byte[8190];
        this.input_pos = 0;
        this.input_len = 0;
        this.ignoreErrors = false;
        this.ignoreErrors = z;
    }

    public static byte[] decode(byte[] bArr) {
        int i2;
        int length = (bArr.length / 4) * 3;
        if (length == 0) {
            return bArr;
        }
        if (bArr[bArr.length - 1] == 61) {
            length--;
            if (bArr[bArr.length - 2] == 61) {
                length--;
            }
        }
        byte[] bArr2 = new byte[length];
        int length2 = bArr.length;
        int i3 = 0;
        int i4 = 0;
        while (length2 > 0) {
            byte[] bArr3 = pem_convert_array;
            int i5 = i3 + 1;
            int i6 = i5 + 1;
            int i7 = ((bArr3[bArr[i3] & 255] << 6) | bArr3[bArr[i5] & 255]) << 6;
            if (bArr[i6] != 61) {
                i7 |= bArr3[bArr[i6] & 255];
                i6++;
                i2 = 3;
            } else {
                i2 = 2;
            }
            int i8 = i7 << 6;
            if (bArr[i6] != 61) {
                i8 |= bArr3[bArr[i6] & 255];
                i6++;
            } else {
                i2--;
            }
            if (i2 > 2) {
                bArr2[i4 + 2] = (byte) (i8 & 255);
            }
            int i9 = i8 >> 8;
            if (i2 > 1) {
                bArr2[i4 + 1] = (byte) (i9 & 255);
            }
            bArr2[i4] = (byte) ((i9 >> 8) & 255);
            i4 += i2;
            length2 -= 4;
            i3 = i6;
        }
        return bArr2;
    }
}
