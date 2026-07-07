package com.bytedance.pangle.g;

import android.util.ArrayMap;
import android.util.Pair;
import androidx.annotation.RequiresApi;
import androidx.core.view.InputDeviceCompat;
import com.tom_roush.fontbox.ttf.WGL4Names;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(api = 21)
public final class b {

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final X509Certificate[][] f6072a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final byte[] f6073b;

        public a(X509Certificate[][] x509CertificateArr, byte[] bArr) {
            this.f6072a = x509CertificateArr;
            this.f6073b = bArr;
        }
    }

    public static a a(RandomAccessFile randomAccessFile, m mVar) {
        ArrayMap arrayMap = new ArrayMap();
        ArrayList arrayList = new ArrayList();
        try {
            CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
            try {
                ByteBuffer byteBufferA = f.a(mVar.f6094a);
                int i2 = 0;
                while (byteBufferA.hasRemaining()) {
                    i2++;
                    try {
                        arrayList.add(a(f.a(byteBufferA), arrayMap, certificateFactory));
                    } catch (IOException | SecurityException | BufferUnderflowException e2) {
                        throw new SecurityException("Failed to parse/verify signer #" + i2 + " block", e2);
                    }
                }
                if (i2 <= 0) {
                    throw new SecurityException("No signers found");
                }
                if (arrayMap.isEmpty()) {
                    throw new SecurityException("No content digests found");
                }
                f.a(arrayMap, randomAccessFile, mVar);
                return new a((X509Certificate[][]) arrayList.toArray(new X509Certificate[arrayList.size()][]), arrayMap.containsKey(3) ? f.a((byte[]) arrayMap.get(3), randomAccessFile.length(), mVar) : null);
            } catch (IOException e3) {
                throw new SecurityException("Failed to read list of signers", e3);
            }
        } catch (CertificateException e4) {
            throw new RuntimeException("Failed to obtain X.509 CertificateFactory", e4);
        }
    }

    private static X509Certificate[] a(ByteBuffer byteBuffer, Map<Integer, byte[]> map, CertificateFactory certificateFactory) throws IOException {
        ByteBuffer byteBufferA = f.a(byteBuffer);
        ByteBuffer byteBufferA2 = f.a(byteBuffer);
        byte[] bArrB = f.b(byteBuffer);
        ArrayList arrayList = new ArrayList();
        byte[] bArrB2 = null;
        byte[] bArrB3 = null;
        int i2 = -1;
        int i3 = 0;
        while (true) {
            boolean z = true;
            if (!byteBufferA2.hasRemaining()) {
                if (i2 == -1) {
                    if (i3 == 0) {
                        throw new SecurityException("No signatures found");
                    }
                    throw new SecurityException("No supported signatures found");
                }
                String strC = f.c(i2);
                Pair<String, ? extends AlgorithmParameterSpec> pairD = f.d(i2);
                String str = (String) pairD.first;
                AlgorithmParameterSpec algorithmParameterSpec = (AlgorithmParameterSpec) pairD.second;
                try {
                    PublicKey publicKeyGeneratePublic = KeyFactory.getInstance(strC).generatePublic(new X509EncodedKeySpec(bArrB));
                    Signature signature = Signature.getInstance(str);
                    signature.initVerify(publicKeyGeneratePublic);
                    if (algorithmParameterSpec != null) {
                        signature.setParameter(algorithmParameterSpec);
                    }
                    signature.update(byteBufferA);
                    if (signature.verify(bArrB3)) {
                        byteBufferA.clear();
                        ByteBuffer byteBufferA3 = f.a(byteBufferA);
                        ArrayList arrayList2 = new ArrayList();
                        int i4 = 0;
                        while (byteBufferA3.hasRemaining()) {
                            i4++;
                            try {
                                ByteBuffer byteBufferA4 = f.a(byteBufferA3);
                                if (byteBufferA4.remaining() >= 8) {
                                    int i5 = byteBufferA4.getInt();
                                    arrayList2.add(Integer.valueOf(i5));
                                    if (i5 == i2) {
                                        bArrB2 = f.b(byteBufferA4);
                                    }
                                } else {
                                    throw new IOException("Record too short");
                                }
                            } catch (IOException | BufferUnderflowException e2) {
                                throw new IOException("Failed to parse digest record #".concat(String.valueOf(i4)), e2);
                            }
                        }
                        if (arrayList.equals(arrayList2)) {
                            int iA = f.a(i2);
                            byte[] bArrPut = map.put(Integer.valueOf(iA), bArrB2);
                            if (bArrPut != null && !MessageDigest.isEqual(bArrPut, bArrB2)) {
                                throw new SecurityException(f.b(iA) + " contents digest does not match the digest specified by a preceding signer");
                            }
                            ByteBuffer byteBufferA5 = f.a(byteBufferA);
                            ArrayList arrayList3 = new ArrayList();
                            int i6 = 0;
                            while (byteBufferA5.hasRemaining()) {
                                i6++;
                                byte[] bArrB4 = f.b(byteBufferA5);
                                try {
                                    arrayList3.add(new p((X509Certificate) certificateFactory.generateCertificate(new ByteArrayInputStream(bArrB4)), bArrB4));
                                } catch (CertificateException e3) {
                                    throw new SecurityException("Failed to decode certificate #".concat(String.valueOf(i6)), e3);
                                }
                            }
                            if (!arrayList3.isEmpty()) {
                                if (Arrays.equals(bArrB, ((X509Certificate) arrayList3.get(0)).getPublicKey().getEncoded())) {
                                    a(f.a(byteBufferA));
                                    return (X509Certificate[]) arrayList3.toArray(new X509Certificate[arrayList3.size()]);
                                }
                                throw new SecurityException("Public key mismatch between certificate and signature record");
                            }
                            throw new SecurityException("No certificates listed");
                        }
                        throw new SecurityException("Signature algorithms don't match between digests and signatures records");
                    }
                    throw new SecurityException(str + " signature did not verify");
                } catch (InvalidAlgorithmParameterException | InvalidKeyException | NoSuchAlgorithmException | SignatureException | InvalidKeySpecException e4) {
                    throw new SecurityException("Failed to verify " + str + " signature", e4);
                }
            }
            i3++;
            try {
                ByteBuffer byteBufferA6 = f.a(byteBufferA2);
                if (byteBufferA6.remaining() >= 8) {
                    int i7 = byteBufferA6.getInt();
                    arrayList.add(Integer.valueOf(i7));
                    if (i7 != 513 && i7 != 514 && i7 != 769 && i7 != 1057 && i7 != 1059 && i7 != 1061) {
                        switch (i7) {
                            case InputDeviceCompat.SOURCE_KEYBOARD /* 257 */:
                            case WGL4Names.NUMBER_OF_MAC_GLYPHS /* 258 */:
                            case 259:
                            case 260:
                                break;
                            default:
                                z = false;
                                break;
                        }
                    }
                    if (z && (i2 == -1 || f.a(i7, i2) > 0)) {
                        bArrB3 = f.b(byteBufferA6);
                        i2 = i7;
                    }
                } else {
                    throw new SecurityException("Signature record too short");
                }
            } catch (IOException | BufferUnderflowException e5) {
                throw new SecurityException("Failed to parse signature record #".concat(String.valueOf(i3)), e5);
            }
        }
    }

    private static void a(ByteBuffer byteBuffer) throws IOException {
        while (byteBuffer.hasRemaining()) {
            ByteBuffer byteBufferA = f.a(byteBuffer);
            if (byteBufferA.remaining() >= 4) {
                if (byteBufferA.getInt() == -1091571699) {
                    if (byteBufferA.remaining() >= 4) {
                        if (byteBufferA.getInt() == 3) {
                            throw new SecurityException("V2 signature indicates APK is signed using APK Signature Scheme v3, but none was found. Signature stripped?");
                        }
                    } else {
                        throw new IOException("V2 Signature Scheme Stripping Protection Attribute  value too small. Expected 4 bytes, but found " + byteBufferA.remaining());
                    }
                }
            } else {
                throw new IOException("Remaining buffer too short to contain additional attribute ID. Remaining: " + byteBufferA.remaining());
            }
        }
    }
}
