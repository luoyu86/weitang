package com.tom_roush.pdfbox.pdmodel.encryption;

import android.util.Log;
import com.tom_roush.pdfbox.cos.COSArray;
import com.tom_roush.pdfbox.cos.COSBase;
import com.tom_roush.pdfbox.cos.COSName;
import com.tom_roush.pdfbox.cos.COSString;
import com.tom_roush.pdfbox.pdmodel.PDDocument;
import com.tom_roush.pdfbox.util.Charsets;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

/* JADX INFO: loaded from: classes2.dex */
public final class StandardSecurityHandler extends SecurityHandler {
    public static final String FILTER = "Standard";
    public static final Class<?> PROTECTION_POLICY_CLASS = StandardProtectionPolicy.class;
    private static final byte[] ENCRYPT_PADDING = {40, -65, 78, 94, 78, 117, -118, 65, 100, 0, 78, 86, -1, -6, 1, 8, 46, 46, 0, -74, -48, 104, 62, -128, 47, 12, -87, -2, 100, 83, 105, 122};
    private static final String[] HASHES_2B = {MessageDigestAlgorithms.SHA_256, MessageDigestAlgorithms.SHA_384, MessageDigestAlgorithms.SHA_512};

    public StandardSecurityHandler() {
    }

    private byte[] computeEncryptedKeyRev234(byte[] bArr, byte[] bArr2, int i2, byte[] bArr3, boolean z, int i3, int i4) {
        byte[] bArrTruncateOrPad = truncateOrPad(bArr);
        MessageDigest md5 = MessageDigests.getMD5();
        md5.update(bArrTruncateOrPad);
        md5.update(bArr2);
        md5.update((byte) i2);
        md5.update((byte) (i2 >>> 8));
        md5.update((byte) (i2 >>> 16));
        md5.update((byte) (i2 >>> 24));
        md5.update(bArr3);
        if (i4 == 4 && !z) {
            md5.update(new byte[]{-1, -1, -1, -1});
        }
        byte[] bArrDigest = md5.digest();
        if (i4 == 3 || i4 == 4) {
            for (int i5 = 0; i5 < 50; i5++) {
                md5.update(bArrDigest, 0, i3);
                bArrDigest = md5.digest();
            }
        }
        byte[] bArr4 = new byte[i3];
        System.arraycopy(bArrDigest, 0, bArr4, 0, i3);
        return bArr4;
    }

    private byte[] computeEncryptedKeyRev56(byte[] bArr, boolean z, byte[] bArr2, byte[] bArr3, byte[] bArr4, byte[] bArr5, int i2) throws IOException {
        byte[] bArrComputeSHA256;
        if (z) {
            if (bArr4 == null) {
                throw new IOException("/Encrypt/OE entry is missing");
            }
            byte[] bArr6 = new byte[8];
            System.arraycopy(bArr2, 40, bArr6, 0, 8);
            bArrComputeSHA256 = i2 == 5 ? computeSHA256(bArr, bArr6, bArr3) : computeHash2A(bArr, bArr6, bArr3);
        } else {
            if (bArr5 == null) {
                throw new IOException("/Encrypt/UE entry is missing");
            }
            byte[] bArr7 = new byte[8];
            System.arraycopy(bArr3, 40, bArr7, 0, 8);
            bArrComputeSHA256 = i2 == 5 ? computeSHA256(bArr, bArr7, null) : computeHash2A(bArr, bArr7, null);
            bArr4 = bArr5;
        }
        try {
            Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
            cipher.init(2, new SecretKeySpec(bArrComputeSHA256, "AES"), new IvParameterSpec(new byte[16]));
            return cipher.doFinal(bArr4);
        } catch (GeneralSecurityException e2) {
            logIfStrongEncryptionMissing();
            throw new IOException(e2);
        }
    }

    private byte[] computeHash2A(byte[] bArr, byte[] bArr2, byte[] bArr3) throws IOException {
        if (bArr3 == null) {
            bArr3 = new byte[0];
        } else {
            if (bArr3.length < 48) {
                throw new IOException("Bad U length");
            }
            if (bArr3.length > 48) {
                byte[] bArr4 = new byte[48];
                System.arraycopy(bArr3, 0, bArr4, 0, 48);
                bArr3 = bArr4;
            }
        }
        byte[] bArrTruncate127 = truncate127(bArr);
        return computeHash2B(concat(bArrTruncate127, bArr2, bArr3), bArrTruncate127, bArr3);
    }

    private static byte[] computeHash2B(byte[] bArr, byte[] bArr2, byte[] bArr3) throws IOException {
        try {
            byte[] bArrDigest = MessageDigests.getSHA256().digest(bArr);
            byte[] bArr4 = null;
            int i2 = 0;
            while (true) {
                if (i2 >= 64 && (bArr4[bArr4.length - 1] & 255) <= i2 - 32) {
                    break;
                }
                byte[] bArr5 = (bArr3 == null || bArr3.length < 48) ? new byte[(bArr2.length + bArrDigest.length) * 64] : new byte[(bArr2.length + bArrDigest.length + 48) * 64];
                int length = 0;
                for (int i3 = 0; i3 < 64; i3++) {
                    System.arraycopy(bArr2, 0, bArr5, length, bArr2.length);
                    int length2 = length + bArr2.length;
                    System.arraycopy(bArrDigest, 0, bArr5, length2, bArrDigest.length);
                    length = length2 + bArrDigest.length;
                    if (bArr3 != null && bArr3.length >= 48) {
                        System.arraycopy(bArr3, 0, bArr5, length, 48);
                        length += 48;
                    }
                }
                byte[] bArr6 = new byte[16];
                byte[] bArr7 = new byte[16];
                System.arraycopy(bArrDigest, 0, bArr6, 0, 16);
                System.arraycopy(bArrDigest, 16, bArr7, 0, 16);
                Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
                cipher.init(1, new SecretKeySpec(bArr6, "AES"), new IvParameterSpec(bArr7));
                byte[] bArrDoFinal = cipher.doFinal(bArr5);
                byte[] bArr8 = new byte[16];
                System.arraycopy(bArrDoFinal, 0, bArr8, 0, 16);
                i2++;
                bArr4 = bArrDoFinal;
                bArrDigest = MessageDigest.getInstance(HASHES_2B[new BigInteger(1, bArr8).mod(new BigInteger("3")).intValue()]).digest(bArrDoFinal);
            }
            if (bArrDigest.length <= 32) {
                return bArrDigest;
            }
            byte[] bArr9 = new byte[32];
            System.arraycopy(bArrDigest, 0, bArr9, 0, 32);
            return bArr9;
        } catch (GeneralSecurityException e2) {
            logIfStrongEncryptionMissing();
            throw new IOException(e2);
        }
    }

    private byte[] computeRC4key(byte[] bArr, int i2, int i3) {
        MessageDigest md5 = MessageDigests.getMD5();
        byte[] bArrDigest = md5.digest(truncateOrPad(bArr));
        if (i2 == 3 || i2 == 4) {
            for (int i4 = 0; i4 < 50; i4++) {
                md5.update(bArrDigest, 0, i3);
                bArrDigest = md5.digest();
            }
        }
        byte[] bArr2 = new byte[i3];
        System.arraycopy(bArrDigest, 0, bArr2, 0, i3);
        return bArr2;
    }

    private int computeRevisionNumber(int i2) {
        AccessPermission permissions = ((StandardProtectionPolicy) getProtectionPolicy()).getPermissions();
        if (i2 < 2 && !permissions.hasAnyRevision3PermissionSet()) {
            return 2;
        }
        if (i2 == 5) {
            return 6;
        }
        if (i2 == 4) {
            return 4;
        }
        return (i2 == 2 || i2 == 3 || permissions.hasAnyRevision3PermissionSet()) ? 3 : 4;
    }

    private static byte[] computeSHA256(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        MessageDigest sha256 = MessageDigests.getSHA256();
        sha256.update(bArr);
        sha256.update(bArr2);
        return bArr3 == null ? sha256.digest() : sha256.digest(bArr3);
    }

    private static byte[] concat(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = new byte[bArr.length + bArr2.length];
        System.arraycopy(bArr, 0, bArr3, 0, bArr.length);
        System.arraycopy(bArr2, 0, bArr3, bArr.length, bArr2.length);
        return bArr3;
    }

    private byte[] getDocumentIDBytes(COSArray cOSArray) {
        return (cOSArray == null || cOSArray.size() < 1) ? new byte[0] : ((COSString) cOSArray.getObject(0)).getBytes();
    }

    private boolean isUserPassword234(byte[] bArr, byte[] bArr2, byte[] bArr3, int i2, byte[] bArr4, int i3, int i4, boolean z) throws IOException {
        byte[] bArrComputeUserPassword = computeUserPassword(bArr, bArr3, i2, bArr4, i3, i4, z);
        return i3 == 2 ? Arrays.equals(bArr2, bArrComputeUserPassword) : Arrays.equals(Arrays.copyOf(bArr2, 16), Arrays.copyOf(bArrComputeUserPassword, 16));
    }

    private boolean isUserPassword56(byte[] bArr, byte[] bArr2, int i2) throws IOException {
        byte[] bArrTruncate127 = truncate127(bArr);
        byte[] bArr3 = new byte[32];
        byte[] bArr4 = new byte[8];
        System.arraycopy(bArr2, 0, bArr3, 0, 32);
        System.arraycopy(bArr2, 32, bArr4, 0, 8);
        return Arrays.equals(i2 == 5 ? computeSHA256(bArrTruncate127, bArr4, null) : computeHash2A(bArrTruncate127, bArr4, null), bArr3);
    }

    private static void logIfStrongEncryptionMissing() {
        try {
            if (Cipher.getMaxAllowedKeyLength("AES") != Integer.MAX_VALUE) {
                Log.w("PdfBox-Android", "JCE unlimited strength jurisdiction policy files are not installed");
            }
        } catch (NoSuchAlgorithmException unused) {
        }
    }

    private void prepareEncryptionDictAES(PDEncryption pDEncryption, COSName cOSName) {
        PDCryptFilterDictionary pDCryptFilterDictionary = new PDCryptFilterDictionary();
        pDCryptFilterDictionary.setCryptFilterMethod(cOSName);
        pDCryptFilterDictionary.setLength(getKeyLength());
        pDEncryption.setStdCryptFilterDictionary(pDCryptFilterDictionary);
        COSName cOSName2 = COSName.STD_CF;
        pDEncryption.setStreamFilterName(cOSName2);
        pDEncryption.setStringFilterName(cOSName2);
        setAES(true);
    }

    private void prepareEncryptionDictRev2345(String str, String str2, PDEncryption pDEncryption, int i2, PDDocument pDDocument, int i3, int i4) throws IOException {
        COSArray documentID = pDDocument.getDocument().getDocumentID();
        if (documentID == null || documentID.size() < 2) {
            MessageDigest md5 = MessageDigests.getMD5();
            md5.update(BigInteger.valueOf(System.currentTimeMillis()).toByteArray());
            Charset charset = Charsets.ISO_8859_1;
            md5.update(str.getBytes(charset));
            md5.update(str2.getBytes(charset));
            md5.update(pDDocument.getDocument().toString().getBytes(charset));
            COSString cOSString = new COSString(md5.digest(toString().getBytes(charset)));
            documentID = new COSArray();
            documentID.add((COSBase) cOSString);
            documentID.add((COSBase) cOSString);
            pDDocument.getDocument().setDocumentID(documentID);
        }
        COSString cOSString2 = (COSString) documentID.getObject(0);
        Charset charset2 = Charsets.ISO_8859_1;
        byte[] bArrComputeOwnerPassword = computeOwnerPassword(str.getBytes(charset2), str2.getBytes(charset2), i3, i4);
        byte[] bArrComputeUserPassword = computeUserPassword(str2.getBytes(charset2), bArrComputeOwnerPassword, i2, cOSString2.getBytes(), i3, i4, true);
        setEncryptionKey(computeEncryptedKey(str2.getBytes(charset2), bArrComputeOwnerPassword, null, null, null, i2, cOSString2.getBytes(), i3, i4, true, false));
        pDEncryption.setOwnerKey(bArrComputeOwnerPassword);
        pDEncryption.setUserKey(bArrComputeUserPassword);
        if (i3 == 4) {
            prepareEncryptionDictAES(pDEncryption, COSName.AESV2);
        }
    }

    private void prepareEncryptionDictRev6(String str, String str2, PDEncryption pDEncryption, int i2) throws IOException {
        try {
            SecureRandom secureRandom = new SecureRandom();
            Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
            setEncryptionKey(new byte[32]);
            secureRandom.nextBytes(getEncryptionKey());
            Charset charset = Charsets.UTF_8;
            byte[] bArrTruncate127 = truncate127(str2.getBytes(charset));
            byte[] bArr = new byte[8];
            byte[] bArr2 = new byte[8];
            secureRandom.nextBytes(bArr);
            secureRandom.nextBytes(bArr2);
            byte[] bArrConcat = concat(computeHash2B(concat(bArrTruncate127, bArr), bArrTruncate127, null), bArr, bArr2);
            cipher.init(1, new SecretKeySpec(computeHash2B(concat(bArrTruncate127, bArr2), bArrTruncate127, null), "AES"), new IvParameterSpec(new byte[16]));
            byte[] bArrDoFinal = cipher.doFinal(getEncryptionKey());
            byte[] bArrTruncate1272 = truncate127(str.getBytes(charset));
            byte[] bArr3 = new byte[8];
            byte[] bArr4 = new byte[8];
            secureRandom.nextBytes(bArr3);
            secureRandom.nextBytes(bArr4);
            byte[] bArrConcat2 = concat(computeHash2B(concat(bArrTruncate1272, bArr3, bArrConcat), bArrTruncate1272, bArrConcat), bArr3, bArr4);
            cipher.init(1, new SecretKeySpec(computeHash2B(concat(bArrTruncate1272, bArr4, bArrConcat), bArrTruncate1272, bArrConcat), "AES"), new IvParameterSpec(new byte[16]));
            byte[] bArrDoFinal2 = cipher.doFinal(getEncryptionKey());
            pDEncryption.setUserKey(bArrConcat);
            pDEncryption.setUserEncryptionKey(bArrDoFinal);
            pDEncryption.setOwnerKey(bArrConcat2);
            pDEncryption.setOwnerEncryptionKey(bArrDoFinal2);
            prepareEncryptionDictAES(pDEncryption, COSName.AESV3);
            byte[] bArr5 = new byte[16];
            bArr5[0] = (byte) i2;
            bArr5[1] = (byte) (i2 >>> 8);
            bArr5[2] = (byte) (i2 >>> 16);
            bArr5[3] = (byte) (i2 >>> 24);
            bArr5[4] = -1;
            bArr5[5] = -1;
            bArr5[6] = -1;
            bArr5[7] = -1;
            bArr5[8] = 84;
            bArr5[9] = 97;
            bArr5[10] = 100;
            bArr5[11] = 98;
            for (int i3 = 12; i3 <= 15; i3++) {
                bArr5[i3] = (byte) secureRandom.nextInt();
            }
            cipher.init(1, new SecretKeySpec(getEncryptionKey(), "AES"), new IvParameterSpec(new byte[16]));
            pDEncryption.setPerms(cipher.doFinal(bArr5));
        } catch (GeneralSecurityException e2) {
            logIfStrongEncryptionMissing();
            throw new IOException(e2);
        }
    }

    private static byte[] truncate127(byte[] bArr) {
        if (bArr.length <= 127) {
            return bArr;
        }
        byte[] bArr2 = new byte[127];
        System.arraycopy(bArr, 0, bArr2, 0, 127);
        return bArr2;
    }

    private byte[] truncateOrPad(byte[] bArr) {
        byte[] bArr2 = ENCRYPT_PADDING;
        int length = bArr2.length;
        byte[] bArr3 = new byte[length];
        int iMin = Math.min(bArr.length, length);
        System.arraycopy(bArr, 0, bArr3, 0, iMin);
        System.arraycopy(bArr2, 0, bArr3, iMin, bArr2.length - iMin);
        return bArr3;
    }

    private void validatePerms(PDEncryption pDEncryption, int i2, boolean z) throws IOException {
        try {
            Cipher cipher = Cipher.getInstance("AES/ECB/NoPadding");
            cipher.init(2, new SecretKeySpec(getEncryptionKey(), "AES"));
            byte[] bArrDoFinal = cipher.doFinal(pDEncryption.getPerms());
            if (bArrDoFinal[9] != 97 || bArrDoFinal[10] != 100 || bArrDoFinal[11] != 98) {
                Log.w("PdfBox-Android", "Verification of permissions failed (constant)");
            }
            int i3 = (bArrDoFinal[0] & 255) | ((bArrDoFinal[1] & 255) << 8) | ((bArrDoFinal[2] & 255) << 16) | ((bArrDoFinal[3] & 255) << 24);
            if (i3 != i2) {
                Log.w("PdfBox-Android", "Verification of permissions failed (" + String.format("%08X", Integer.valueOf(i3)) + " != " + String.format("%08X", Integer.valueOf(i2)) + ")");
            }
            if ((!z || bArrDoFinal[8] == 84) && (z || bArrDoFinal[8] == 70)) {
                return;
            }
            Log.w("PdfBox-Android", "Verification of permissions failed (EncryptMetadata)");
        } catch (GeneralSecurityException e2) {
            logIfStrongEncryptionMissing();
            throw new IOException(e2);
        }
    }

    public byte[] computeEncryptedKey(byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4, byte[] bArr5, int i2, byte[] bArr6, int i3, int i4, boolean z, boolean z2) throws IOException {
        return (i3 == 6 || i3 == 5) ? computeEncryptedKeyRev56(bArr, z2, bArr2, bArr3, bArr4, bArr5, i3) : computeEncryptedKeyRev234(bArr, bArr2, i2, bArr6, z, i4, i3);
    }

    public byte[] computeOwnerPassword(byte[] bArr, byte[] bArr2, int i2, int i3) throws IOException {
        if (i2 == 2 && i3 != 5) {
            throw new IOException("Expected length=5 actual=" + i3);
        }
        byte[] bArrComputeRC4key = computeRC4key(bArr, i2, i3);
        byte[] bArrTruncateOrPad = truncateOrPad(bArr2);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        encryptDataRC4(bArrComputeRC4key, new ByteArrayInputStream(bArrTruncateOrPad), byteArrayOutputStream);
        if (i2 == 3 || i2 == 4) {
            int length = bArrComputeRC4key.length;
            byte[] bArr3 = new byte[length];
            for (int i4 = 1; i4 < 20; i4++) {
                System.arraycopy(bArrComputeRC4key, 0, bArr3, 0, bArrComputeRC4key.length);
                for (int i5 = 0; i5 < length; i5++) {
                    bArr3[i5] = (byte) (bArr3[i5] ^ ((byte) i4));
                }
                InputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
                byteArrayOutputStream.reset();
                encryptDataRC4(bArr3, byteArrayInputStream, byteArrayOutputStream);
            }
        }
        return byteArrayOutputStream.toByteArray();
    }

    public byte[] computeUserPassword(byte[] bArr, byte[] bArr2, int i2, byte[] bArr3, int i3, int i4, boolean z) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArrComputeEncryptedKey = computeEncryptedKey(bArr, bArr2, null, null, null, i2, bArr3, i3, i4, z, true);
        if (i3 == 2) {
            encryptDataRC4(bArrComputeEncryptedKey, ENCRYPT_PADDING, byteArrayOutputStream);
        } else if (i3 == 3 || i3 == 4) {
            MessageDigest md5 = MessageDigests.getMD5();
            md5.update(ENCRYPT_PADDING);
            md5.update(bArr3);
            byteArrayOutputStream.write(md5.digest());
            int length = bArrComputeEncryptedKey.length;
            byte[] bArr4 = new byte[length];
            for (int i5 = 0; i5 < 20; i5++) {
                System.arraycopy(bArrComputeEncryptedKey, 0, bArr4, 0, length);
                for (int i6 = 0; i6 < length; i6++) {
                    bArr4[i6] = (byte) (bArr4[i6] ^ i5);
                }
                InputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
                byteArrayOutputStream.reset();
                encryptDataRC4(bArr4, byteArrayInputStream, byteArrayOutputStream);
            }
            byte[] bArr5 = new byte[32];
            System.arraycopy(byteArrayOutputStream.toByteArray(), 0, bArr5, 0, 16);
            System.arraycopy(ENCRYPT_PADDING, 0, bArr5, 16, 16);
            byteArrayOutputStream.reset();
            byteArrayOutputStream.write(bArr5);
        }
        return byteArrayOutputStream.toByteArray();
    }

    public byte[] getUserPassword(byte[] bArr, byte[] bArr2, int i2, int i3) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArrComputeRC4key = computeRC4key(bArr, i2, i3);
        if (i2 == 2) {
            encryptDataRC4(bArrComputeRC4key, bArr2, byteArrayOutputStream);
        } else if (i2 == 3 || i2 == 4) {
            int length = bArrComputeRC4key.length;
            byte[] bArr3 = new byte[length];
            byte[] byteArray = new byte[bArr2.length];
            System.arraycopy(bArr2, 0, byteArray, 0, bArr2.length);
            for (int i4 = 19; i4 >= 0; i4--) {
                System.arraycopy(bArrComputeRC4key, 0, bArr3, 0, bArrComputeRC4key.length);
                for (int i5 = 0; i5 < length; i5++) {
                    bArr3[i5] = (byte) (bArr3[i5] ^ ((byte) i4));
                }
                byteArrayOutputStream.reset();
                encryptDataRC4(bArr3, byteArray, byteArrayOutputStream);
                byteArray = byteArrayOutputStream.toByteArray();
            }
        }
        return byteArrayOutputStream.toByteArray();
    }

    public boolean isOwnerPassword(byte[] bArr, byte[] bArr2, byte[] bArr3, int i2, byte[] bArr4, int i3, int i4, boolean z) throws IOException {
        if (i3 != 6 && i3 != 5) {
            return isUserPassword(getUserPassword(bArr, bArr3, i3, i4), bArr2, bArr3, i2, bArr4, i3, i4, z);
        }
        byte[] bArrTruncate127 = truncate127(bArr);
        byte[] bArr5 = new byte[32];
        byte[] bArr6 = new byte[8];
        if (bArr3.length < 40) {
            throw new IOException("Owner password is too short");
        }
        System.arraycopy(bArr3, 0, bArr5, 0, 32);
        System.arraycopy(bArr3, 32, bArr6, 0, 8);
        return Arrays.equals(i3 == 5 ? computeSHA256(bArrTruncate127, bArr6, bArr2) : computeHash2A(bArrTruncate127, bArr6, bArr2), bArr5);
    }

    public boolean isUserPassword(byte[] bArr, byte[] bArr2, byte[] bArr3, int i2, byte[] bArr4, int i3, int i4, boolean z) throws IOException {
        if (i3 == 2 || i3 == 3 || i3 == 4) {
            return isUserPassword234(bArr, bArr2, bArr3, i2, bArr4, i3, i4, z);
        }
        if (i3 == 5 || i3 == 6) {
            return isUserPassword56(bArr, bArr2, i3);
        }
        throw new IOException("Unknown Encryption Revision " + i3);
    }

    @Override // com.tom_roush.pdfbox.pdmodel.encryption.SecurityHandler
    public void prepareDocumentForEncryption(PDDocument pDDocument) throws IOException {
        PDEncryption encryption = pDDocument.getEncryption();
        if (encryption == null) {
            encryption = new PDEncryption();
        }
        int iComputeVersionNumber = computeVersionNumber();
        int iComputeRevisionNumber = computeRevisionNumber(iComputeVersionNumber);
        encryption.setFilter("Standard");
        encryption.setVersion(iComputeVersionNumber);
        if (iComputeVersionNumber != 4 && iComputeVersionNumber != 5) {
            encryption.removeV45filters();
        }
        encryption.setRevision(iComputeRevisionNumber);
        encryption.setLength(getKeyLength());
        StandardProtectionPolicy standardProtectionPolicy = (StandardProtectionPolicy) getProtectionPolicy();
        String ownerPassword = standardProtectionPolicy.getOwnerPassword();
        String userPassword = standardProtectionPolicy.getUserPassword();
        if (ownerPassword == null) {
            ownerPassword = "";
        }
        if (userPassword == null) {
            userPassword = "";
        }
        if (ownerPassword.isEmpty()) {
            ownerPassword = userPassword;
        }
        int permissionBytes = standardProtectionPolicy.getPermissions().getPermissionBytes();
        encryption.setPermissions(permissionBytes);
        int keyLength = getKeyLength() / 8;
        if (iComputeRevisionNumber == 6) {
            prepareEncryptionDictRev6(SaslPrep.saslPrepStored(ownerPassword), SaslPrep.saslPrepStored(userPassword), encryption, permissionBytes);
        } else {
            prepareEncryptionDictRev2345(ownerPassword, userPassword, encryption, permissionBytes, pDDocument, iComputeRevisionNumber, keyLength);
        }
        pDDocument.setEncryptionDictionary(encryption);
        pDDocument.getDocument().setEncryptionDictionary(encryption.getCOSObject());
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x007b A[PHI: r1
  0x007b: PHI (r1v21 int) = (r1v7 int), (r1v8 int), (r1v7 int) binds: [B:19:0x0056, B:24:0x006f, B:17:0x0050] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // com.tom_roush.pdfbox.pdmodel.encryption.SecurityHandler
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void prepareForDecryption(com.tom_roush.pdfbox.pdmodel.encryption.PDEncryption r23, com.tom_roush.pdfbox.cos.COSArray r24, com.tom_roush.pdfbox.pdmodel.encryption.DecryptionMaterial r25) throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 376
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tom_roush.pdfbox.pdmodel.encryption.StandardSecurityHandler.prepareForDecryption(com.tom_roush.pdfbox.pdmodel.encryption.PDEncryption, com.tom_roush.pdfbox.cos.COSArray, com.tom_roush.pdfbox.pdmodel.encryption.DecryptionMaterial):void");
    }

    public StandardSecurityHandler(StandardProtectionPolicy standardProtectionPolicy) {
        setProtectionPolicy(standardProtectionPolicy);
        setKeyLength(standardProtectionPolicy.getEncryptionKeyLength());
    }

    private static byte[] concat(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        byte[] bArr4 = new byte[bArr.length + bArr2.length + bArr3.length];
        System.arraycopy(bArr, 0, bArr4, 0, bArr.length);
        System.arraycopy(bArr2, 0, bArr4, bArr.length, bArr2.length);
        System.arraycopy(bArr3, 0, bArr4, bArr.length + bArr2.length, bArr3.length);
        return bArr4;
    }

    public boolean isUserPassword(String str, byte[] bArr, byte[] bArr2, int i2, byte[] bArr3, int i3, int i4, boolean z) throws IOException {
        if (i3 != 6 && i3 != 5) {
            return isUserPassword(str.getBytes(Charsets.ISO_8859_1), bArr, bArr2, i2, bArr3, i3, i4, z);
        }
        return isUserPassword(str.getBytes(Charsets.UTF_8), bArr, bArr2, i2, bArr3, i3, i4, z);
    }

    public boolean isOwnerPassword(String str, byte[] bArr, byte[] bArr2, int i2, byte[] bArr3, int i3, int i4, boolean z) throws IOException {
        return isOwnerPassword(str.getBytes(Charsets.ISO_8859_1), bArr, bArr2, i2, bArr3, i3, i4, z);
    }
}
