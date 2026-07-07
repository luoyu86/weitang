package g.a.j.r;

import g.a.j.q;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes3.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f14666a = new d();

    public static int decode(String str, OutputStream outputStream) throws IOException {
        return f14666a.decode(str, outputStream);
    }

    public static byte[] decode(String str) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            f14666a.decode(str, byteArrayOutputStream);
            return byteArrayOutputStream.toByteArray();
        } catch (Exception e2) {
            throw new a("exception decoding Hex string: " + e2.getMessage(), e2);
        }
    }

    public static byte[] decode(byte[] bArr) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            f14666a.decode(bArr, 0, bArr.length, byteArrayOutputStream);
            return byteArrayOutputStream.toByteArray();
        } catch (Exception e2) {
            throw new a("exception decoding Hex data: " + e2.getMessage(), e2);
        }
    }

    public static byte[] decodeStrict(String str) {
        try {
            return f14666a.a(str, 0, str.length());
        } catch (Exception e2) {
            throw new a("exception decoding Hex string: " + e2.getMessage(), e2);
        }
    }

    public static byte[] decodeStrict(String str, int i2, int i3) {
        try {
            return f14666a.a(str, i2, i3);
        } catch (Exception e2) {
            throw new a("exception decoding Hex string: " + e2.getMessage(), e2);
        }
    }

    public static int encode(byte[] bArr, int i2, int i3, OutputStream outputStream) throws IOException {
        return f14666a.encode(bArr, i2, i3, outputStream);
    }

    public static int encode(byte[] bArr, OutputStream outputStream) throws IOException {
        return f14666a.encode(bArr, 0, bArr.length, outputStream);
    }

    public static byte[] encode(byte[] bArr) {
        return encode(bArr, 0, bArr.length);
    }

    public static byte[] encode(byte[] bArr, int i2, int i3) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            f14666a.encode(bArr, i2, i3, byteArrayOutputStream);
            return byteArrayOutputStream.toByteArray();
        } catch (Exception e2) {
            throw new b("exception encoding Hex string: " + e2.getMessage(), e2);
        }
    }

    public static String toHexString(byte[] bArr) {
        return toHexString(bArr, 0, bArr.length);
    }

    public static String toHexString(byte[] bArr, int i2, int i3) {
        return q.fromByteArray(encode(bArr, i2, i3));
    }
}
