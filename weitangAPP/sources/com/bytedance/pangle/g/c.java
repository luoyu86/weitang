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
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(api = 21)
public final class c {

    public static class a extends Exception {
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<X509Certificate> f6074a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final List<Integer> f6075b;

        public b(List<X509Certificate> list, List<Integer> list2) {
            this.f6074a = list;
            this.f6075b = list2;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.pangle.g.c$c, reason: collision with other inner class name */
    public static class C0104c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final X509Certificate[] f6076a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final b f6077b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public byte[] f6078c;

        public C0104c(X509Certificate[] x509CertificateArr, b bVar) {
            this.f6076a = x509CertificateArr;
            this.f6077b = bVar;
        }
    }

    public static C0104c a(RandomAccessFile randomAccessFile, m mVar) {
        ArrayMap arrayMap = new ArrayMap();
        try {
            CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
            try {
                ByteBuffer byteBufferA = f.a(mVar.f6094a);
                int i2 = 0;
                C0104c c0104cA = null;
                while (byteBufferA.hasRemaining()) {
                    try {
                        c0104cA = a(f.a(byteBufferA), arrayMap, certificateFactory);
                        i2++;
                    } catch (a unused) {
                    } catch (IOException e2) {
                        e = e2;
                        throw new SecurityException("Failed to parse/verify signer #" + i2 + " block", e);
                    } catch (SecurityException e3) {
                        e = e3;
                        throw new SecurityException("Failed to parse/verify signer #" + i2 + " block", e);
                    } catch (BufferUnderflowException e4) {
                        e = e4;
                        throw new SecurityException("Failed to parse/verify signer #" + i2 + " block", e);
                    }
                }
                if (i2 <= 0 || c0104cA == null) {
                    throw new SecurityException("No signers found");
                }
                if (i2 != 1) {
                    throw new SecurityException("APK Signature Scheme V3 only supports one signer: multiple signers found.");
                }
                if (arrayMap.isEmpty()) {
                    throw new SecurityException("No content digests found");
                }
                f.a(arrayMap, randomAccessFile, mVar);
                if (arrayMap.containsKey(3)) {
                    c0104cA.f6078c = f.a((byte[]) arrayMap.get(3), randomAccessFile.length(), mVar);
                }
                return c0104cA;
            } catch (IOException e5) {
                throw new SecurityException("Failed to read list of signers", e5);
            }
        } catch (CertificateException e6) {
            throw new RuntimeException("Failed to obtain X.509 CertificateFactory", e6);
        }
    }

    private static C0104c a(ByteBuffer byteBuffer, Map<Integer, byte[]> map, CertificateFactory certificateFactory) throws IOException {
        ByteBuffer byteBufferA = f.a(byteBuffer);
        int i2 = byteBuffer.getInt();
        int i3 = byteBuffer.getInt();
        ByteBuffer byteBufferA2 = f.a(byteBuffer);
        byte[] bArrB = f.b(byteBuffer);
        ArrayList arrayList = new ArrayList();
        int i4 = -1;
        int i5 = 0;
        byte[] bArrB2 = null;
        while (true) {
            int i6 = 8;
            boolean z = true;
            if (!byteBufferA2.hasRemaining()) {
                if (i4 == -1) {
                    if (i5 == 0) {
                        throw new SecurityException("No signatures found");
                    }
                    throw new SecurityException("No supported signatures found");
                }
                String strC = f.c(i4);
                Pair<String, ? extends AlgorithmParameterSpec> pairD = f.d(i4);
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
                    if (signature.verify(bArrB2)) {
                        byteBufferA.clear();
                        ByteBuffer byteBufferA3 = f.a(byteBufferA);
                        ArrayList arrayList2 = new ArrayList();
                        byte[] bArrB3 = null;
                        int i7 = 0;
                        while (byteBufferA3.hasRemaining()) {
                            i7++;
                            try {
                                ByteBuffer byteBufferA4 = f.a(byteBufferA3);
                                if (byteBufferA4.remaining() >= i6) {
                                    int i8 = byteBufferA4.getInt();
                                    arrayList2.add(Integer.valueOf(i8));
                                    if (i8 == i4) {
                                        bArrB3 = f.b(byteBufferA4);
                                    }
                                    i6 = 8;
                                } else {
                                    throw new IOException("Record too short");
                                }
                            } catch (IOException | BufferUnderflowException e2) {
                                throw new IOException("Failed to parse digest record #".concat(String.valueOf(i7)), e2);
                            }
                        }
                        if (arrayList.equals(arrayList2)) {
                            int iA = f.a(i4);
                            byte[] bArrPut = map.put(Integer.valueOf(iA), bArrB3);
                            if (bArrPut != null && !MessageDigest.isEqual(bArrPut, bArrB3)) {
                                throw new SecurityException(f.b(iA) + " contents digest does not match the digest specified by a preceding signer");
                            }
                            ByteBuffer byteBufferA5 = f.a(byteBufferA);
                            ArrayList arrayList3 = new ArrayList();
                            int i9 = 0;
                            while (byteBufferA5.hasRemaining()) {
                                i9++;
                                byte[] bArrB4 = f.b(byteBufferA5);
                                try {
                                    arrayList3.add(new p((X509Certificate) certificateFactory.generateCertificate(new ByteArrayInputStream(bArrB4)), bArrB4));
                                } catch (CertificateException e3) {
                                    throw new SecurityException("Failed to decode certificate #".concat(String.valueOf(i9)), e3);
                                }
                            }
                            if (!arrayList3.isEmpty()) {
                                if (Arrays.equals(bArrB, ((X509Certificate) arrayList3.get(0)).getPublicKey().getEncoded())) {
                                    if (byteBufferA.getInt() == i2) {
                                        if (byteBufferA.getInt() == i3) {
                                            return a(f.a(byteBufferA), arrayList3, certificateFactory);
                                        }
                                        throw new SecurityException("maxSdkVersion mismatch between signed and unsigned in v3 signer block.");
                                    }
                                    throw new SecurityException("minSdkVersion mismatch between signed and unsigned in v3 signer block.");
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
            i5++;
            try {
                ByteBuffer byteBufferA6 = f.a(byteBufferA2);
                if (byteBufferA6.remaining() >= 8) {
                    int i10 = byteBufferA6.getInt();
                    arrayList.add(Integer.valueOf(i10));
                    if (i10 != 513 && i10 != 514 && i10 != 769 && i10 != 1057 && i10 != 1059 && i10 != 1061) {
                        switch (i10) {
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
                    if (z && (i4 == -1 || f.a(i10, i4) > 0)) {
                        bArrB2 = f.b(byteBufferA6);
                        i4 = i10;
                    }
                } else {
                    throw new SecurityException("Signature record too short");
                }
            } catch (IOException | BufferUnderflowException e5) {
                throw new SecurityException("Failed to parse signature record #".concat(String.valueOf(i5)), e5);
            }
        }
    }

    private static C0104c a(ByteBuffer byteBuffer, List<X509Certificate> list, CertificateFactory certificateFactory) throws IOException {
        X509Certificate[] x509CertificateArr = (X509Certificate[]) list.toArray(new X509Certificate[list.size()]);
        b bVarA = null;
        while (byteBuffer.hasRemaining()) {
            ByteBuffer byteBufferA = f.a(byteBuffer);
            if (byteBufferA.remaining() >= 4) {
                if (byteBufferA.getInt() == 1000370060) {
                    if (bVarA == null) {
                        bVarA = a(byteBufferA, certificateFactory);
                        try {
                            if (bVarA.f6074a.size() > 0) {
                                if (!Arrays.equals(bVarA.f6074a.get(r1.size() - 1).getEncoded(), x509CertificateArr[0].getEncoded())) {
                                    throw new SecurityException("Terminal certificate in Proof-of-rotation record does not match APK signing certificate");
                                }
                            } else {
                                continue;
                            }
                        } catch (CertificateEncodingException e2) {
                            throw new SecurityException("Failed to encode certificate when comparing Proof-of-rotation record and signing certificate", e2);
                        }
                    } else {
                        throw new SecurityException("Encountered multiple Proof-of-rotation records when verifying APK Signature Scheme v3 signature");
                    }
                }
            } else {
                throw new IOException("Remaining buffer too short to contain additional attribute ID. Remaining: " + byteBufferA.remaining());
            }
        }
        return new C0104c(x509CertificateArr, bVarA);
    }

    private static b a(ByteBuffer byteBuffer, CertificateFactory certificateFactory) throws IOException {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        int i2 = 0;
        try {
            byteBuffer.getInt();
            HashSet hashSet = new HashSet();
            int i3 = -1;
            p pVar = null;
            while (byteBuffer.hasRemaining()) {
                i2++;
                ByteBuffer byteBufferA = f.a(byteBuffer);
                ByteBuffer byteBufferA2 = f.a(byteBufferA);
                int i4 = byteBufferA.getInt();
                int i5 = byteBufferA.getInt();
                byte[] bArrB = f.b(byteBufferA);
                if (pVar != null) {
                    Pair<String, ? extends AlgorithmParameterSpec> pairD = f.d(i3);
                    PublicKey publicKey = pVar.getPublicKey();
                    Signature signature = Signature.getInstance((String) pairD.first);
                    signature.initVerify(publicKey);
                    Object obj = pairD.second;
                    if (obj != null) {
                        signature.setParameter((AlgorithmParameterSpec) obj);
                    }
                    signature.update(byteBufferA2);
                    if (!signature.verify(bArrB)) {
                        throw new SecurityException("Unable to verify signature of certificate #" + i2 + " using " + ((String) pairD.first) + " when verifying Proof-of-rotation record");
                    }
                }
                byteBufferA2.rewind();
                byte[] bArrB2 = f.b(byteBufferA2);
                int i6 = byteBufferA2.getInt();
                if (pVar != null && i3 != i6) {
                    throw new SecurityException("Signing algorithm ID mismatch for certificate #" + i2 + " when verifying Proof-of-rotation record");
                }
                pVar = new p((X509Certificate) certificateFactory.generateCertificate(new ByteArrayInputStream(bArrB2)), bArrB2);
                if (!hashSet.contains(pVar)) {
                    hashSet.add(pVar);
                    arrayList.add(pVar);
                    arrayList2.add(Integer.valueOf(i4));
                    i3 = i5;
                } else {
                    throw new SecurityException("Encountered duplicate entries in Proof-of-rotation record at certificate #" + i2 + ".  All signing certificates should be unique");
                }
            }
            return new b(arrayList, arrayList2);
        } catch (IOException e2) {
            e = e2;
            throw new IOException("Failed to parse Proof-of-rotation record", e);
        } catch (BufferUnderflowException e3) {
            e = e3;
            throw new IOException("Failed to parse Proof-of-rotation record", e);
        } catch (InvalidAlgorithmParameterException e4) {
            e = e4;
            throw new SecurityException("Failed to verify signature over signed data for certificate #0 when verifying Proof-of-rotation record", e);
        } catch (InvalidKeyException e5) {
            e = e5;
            throw new SecurityException("Failed to verify signature over signed data for certificate #0 when verifying Proof-of-rotation record", e);
        } catch (NoSuchAlgorithmException e6) {
            e = e6;
            throw new SecurityException("Failed to verify signature over signed data for certificate #0 when verifying Proof-of-rotation record", e);
        } catch (SignatureException e7) {
            e = e7;
            throw new SecurityException("Failed to verify signature over signed data for certificate #0 when verifying Proof-of-rotation record", e);
        } catch (CertificateException e8) {
            throw new SecurityException("Failed to decode certificate #0 when verifying Proof-of-rotation record", e8);
        }
    }
}
