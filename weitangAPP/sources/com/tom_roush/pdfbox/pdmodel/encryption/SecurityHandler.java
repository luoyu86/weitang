package com.tom_roush.pdfbox.pdmodel.encryption;

import android.util.Log;
import com.tom_roush.pdfbox.cos.COSArray;
import com.tom_roush.pdfbox.cos.COSBase;
import com.tom_roush.pdfbox.cos.COSDictionary;
import com.tom_roush.pdfbox.cos.COSName;
import com.tom_roush.pdfbox.cos.COSStream;
import com.tom_roush.pdfbox.cos.COSString;
import com.tom_roush.pdfbox.io.IOUtils;
import com.tom_roush.pdfbox.pdmodel.PDDocument;
import com.tom_roush.pdfbox.util.Charsets;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.Set;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes2.dex */
public abstract class SecurityHandler {
    private static final byte[] AES_SALT = {115, 65, 108, 84};
    private static final short DEFAULT_KEY_LENGTH = 40;
    private SecureRandom customSecureRandom;
    private boolean decryptMetadata;
    public byte[] encryptionKey;
    private COSName streamFilterName;
    private COSName stringFilterName;
    private boolean useAES;
    public short keyLength = DEFAULT_KEY_LENGTH;
    private final RC4Cipher rc4 = new RC4Cipher();
    private final Set<COSBase> objects = Collections.newSetFromMap(new IdentityHashMap());
    private ProtectionPolicy protectionPolicy = null;
    private AccessPermission currentAccessPermission = null;

    private byte[] calcFinalKey(long j, long j2) {
        byte[] bArr = this.encryptionKey;
        int length = bArr.length + 5;
        byte[] bArr2 = new byte[length];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        bArr2[length - 5] = (byte) (j & 255);
        bArr2[length - 4] = (byte) ((j >> 8) & 255);
        bArr2[length - 3] = (byte) ((j >> 16) & 255);
        bArr2[length - 2] = (byte) (j2 & 255);
        bArr2[length - 1] = (byte) ((j2 >> 8) & 255);
        MessageDigest md5 = MessageDigests.getMD5();
        md5.update(bArr2);
        if (this.useAES) {
            md5.update(AES_SALT);
        }
        byte[] bArrDigest = md5.digest();
        int iMin = Math.min(length, 16);
        byte[] bArr3 = new byte[iMin];
        System.arraycopy(bArrDigest, 0, bArr3, 0, iMin);
        return bArr3;
    }

    private Cipher createCipher(byte[] bArr, byte[] bArr2, boolean z) throws GeneralSecurityException {
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(z ? 2 : 1, new SecretKeySpec(bArr, "AES"), new IvParameterSpec(bArr2));
        return cipher;
    }

    private void decryptArray(COSArray cOSArray, long j, long j2) throws IOException {
        for (int i2 = 0; i2 < cOSArray.size(); i2++) {
            decrypt(cOSArray.get(i2), j, j2);
        }
    }

    private void decryptDictionary(COSDictionary cOSDictionary, long j, long j2) throws IOException {
        if (cOSDictionary.getItem(COSName.CF) != null) {
            return;
        }
        COSBase dictionaryObject = cOSDictionary.getDictionaryObject(COSName.TYPE);
        boolean z = COSName.SIG.equals(dictionaryObject) || COSName.DOC_TIME_STAMP.equals(dictionaryObject) || ((cOSDictionary.getDictionaryObject(COSName.CONTENTS) instanceof COSString) && (cOSDictionary.getDictionaryObject(COSName.BYTERANGE) instanceof COSArray));
        for (Map.Entry<COSName, COSBase> entry : cOSDictionary.entrySet()) {
            if (!z || !COSName.CONTENTS.equals(entry.getKey())) {
                COSBase value = entry.getValue();
                if ((value instanceof COSString) || (value instanceof COSArray) || (value instanceof COSDictionary)) {
                    decrypt(value, j, j2);
                }
            }
        }
    }

    private void decryptString(COSString cOSString, long j, long j2) throws IOException {
        if (COSName.IDENTITY.equals(this.stringFilterName)) {
            return;
        }
        InputStream byteArrayInputStream = new ByteArrayInputStream(cOSString.getBytes());
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            encryptData(j, j2, byteArrayInputStream, byteArrayOutputStream, true);
            cOSString.setValue(byteArrayOutputStream.toByteArray());
        } catch (IOException e2) {
            Log.e("PdfBox-Android", "Failed to decrypt COSString of length " + cOSString.getBytes().length + " in object " + j + ": " + e2.getMessage());
        }
    }

    private void encryptData(long j, long j2, InputStream inputStream, OutputStream outputStream, boolean z) throws IOException {
        if (this.useAES && this.encryptionKey.length == 32) {
            encryptDataAES256(inputStream, outputStream, z);
        } else {
            byte[] bArrCalcFinalKey = calcFinalKey(j, j2);
            if (this.useAES) {
                encryptDataAESother(bArrCalcFinalKey, inputStream, outputStream, z);
            } else {
                encryptDataRC4(bArrCalcFinalKey, inputStream, outputStream);
            }
        }
        outputStream.flush();
    }

    private void encryptDataAES256(InputStream inputStream, OutputStream outputStream, boolean z) throws IOException {
        byte[] bArr = new byte[16];
        if (prepareAESInitializationVector(z, bArr, inputStream, outputStream)) {
            try {
                CipherInputStream cipherInputStream = new CipherInputStream(inputStream, createCipher(this.encryptionKey, bArr, z));
                try {
                    try {
                        IOUtils.copy(cipherInputStream, outputStream);
                    } catch (IOException e2) {
                        if (!(e2.getCause() instanceof GeneralSecurityException)) {
                            throw e2;
                        }
                        Log.d("PdfBox-Android", "A GeneralSecurityException occurred when decrypting some stream data", e2);
                    }
                } finally {
                    cipherInputStream.close();
                }
            } catch (GeneralSecurityException e3) {
                throw new IOException(e3);
            }
        }
    }

    private void encryptDataAESother(byte[] bArr, InputStream inputStream, OutputStream outputStream, boolean z) throws IOException {
        byte[] bArr2 = new byte[16];
        if (!prepareAESInitializationVector(z, bArr2, inputStream, outputStream)) {
            return;
        }
        try {
            Cipher cipherCreateCipher = createCipher(bArr, bArr2, z);
            byte[] bArr3 = new byte[256];
            while (true) {
                int i2 = inputStream.read(bArr3);
                if (i2 == -1) {
                    outputStream.write(cipherCreateCipher.doFinal());
                    return;
                } else {
                    byte[] bArrUpdate = cipherCreateCipher.update(bArr3, 0, i2);
                    if (bArrUpdate != null) {
                        outputStream.write(bArrUpdate);
                    }
                }
            }
        } catch (GeneralSecurityException e2) {
            throw new IOException(e2);
        }
    }

    private SecureRandom getSecureRandom() {
        SecureRandom secureRandom = this.customSecureRandom;
        return secureRandom != null ? secureRandom : new SecureRandom();
    }

    private boolean prepareAESInitializationVector(boolean z, byte[] bArr, InputStream inputStream, OutputStream outputStream) throws IOException {
        if (!z) {
            getSecureRandom().nextBytes(bArr);
            outputStream.write(bArr);
            return true;
        }
        int iPopulateBuffer = (int) IOUtils.populateBuffer(inputStream, bArr);
        if (iPopulateBuffer == 0) {
            return false;
        }
        if (iPopulateBuffer == bArr.length) {
            return true;
        }
        throw new IOException("AES initialization vector not fully read: only " + iPopulateBuffer + " bytes read instead of " + bArr.length);
    }

    public int computeVersionNumber() {
        short s = this.keyLength;
        if (s == 40) {
            return 1;
        }
        if (s == 128 && this.protectionPolicy.isPreferAES()) {
            return 4;
        }
        return this.keyLength == 256 ? 5 : 2;
    }

    public void decrypt(COSBase cOSBase, long j, long j2) throws IOException {
        if (cOSBase instanceof COSString) {
            if (this.objects.contains(cOSBase)) {
                return;
            }
            this.objects.add(cOSBase);
            decryptString((COSString) cOSBase, j, j2);
            return;
        }
        if (cOSBase instanceof COSStream) {
            if (this.objects.contains(cOSBase)) {
                return;
            }
            this.objects.add(cOSBase);
            decryptStream((COSStream) cOSBase, j, j2);
            return;
        }
        if (cOSBase instanceof COSDictionary) {
            decryptDictionary((COSDictionary) cOSBase, j, j2);
        } else if (cOSBase instanceof COSArray) {
            decryptArray((COSArray) cOSBase, j, j2);
        }
    }

    public void decryptStream(COSStream cOSStream, long j, long j2) throws IOException {
        if (COSName.IDENTITY.equals(this.streamFilterName)) {
            return;
        }
        COSName cOSName = cOSStream.getCOSName(COSName.TYPE);
        if ((this.decryptMetadata || !COSName.METADATA.equals(cOSName)) && !COSName.XREF.equals(cOSName)) {
            if (COSName.METADATA.equals(cOSName)) {
                InputStream inputStreamCreateRawInputStream = cOSStream.createRawInputStream();
                byte[] bArr = new byte[10];
                IOUtils.populateBuffer(inputStreamCreateRawInputStream, bArr);
                inputStreamCreateRawInputStream.close();
                if (Arrays.equals(bArr, "<?xpacket ".getBytes(Charsets.ISO_8859_1))) {
                    Log.w("PdfBox-Android", "Metadata is not encrypted, but was expected to be");
                    Log.w("PdfBox-Android", "Read PDF specification about EncryptMetadata (default value: true)");
                    return;
                }
            }
            decryptDictionary(cOSStream, j, j2);
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(IOUtils.toByteArray(cOSStream.createRawInputStream()));
            OutputStream outputStreamCreateRawOutputStream = cOSStream.createRawOutputStream();
            try {
                try {
                    encryptData(j, j2, byteArrayInputStream, outputStreamCreateRawOutputStream, true);
                } catch (IOException e2) {
                    Log.e("PdfBox-Android", e2.getClass().getSimpleName() + " thrown when decrypting object " + j + " " + j2 + " obj");
                    throw e2;
                }
            } finally {
                outputStreamCreateRawOutputStream.close();
            }
        }
    }

    public void encryptDataRC4(byte[] bArr, InputStream inputStream, OutputStream outputStream) throws IOException {
        this.rc4.setKey(bArr);
        this.rc4.write(inputStream, outputStream);
    }

    public void encryptStream(COSStream cOSStream, long j, int i2) throws IOException {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(IOUtils.toByteArray(cOSStream.createRawInputStream()));
        OutputStream outputStreamCreateRawOutputStream = cOSStream.createRawOutputStream();
        try {
            encryptData(j, i2, byteArrayInputStream, outputStreamCreateRawOutputStream, false);
        } finally {
            outputStreamCreateRawOutputStream.close();
        }
    }

    public void encryptString(COSString cOSString, long j, int i2) throws IOException {
        InputStream byteArrayInputStream = new ByteArrayInputStream(cOSString.getBytes());
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        encryptData(j, i2, byteArrayInputStream, byteArrayOutputStream, false);
        cOSString.setValue(byteArrayOutputStream.toByteArray());
    }

    public AccessPermission getCurrentAccessPermission() {
        return this.currentAccessPermission;
    }

    public byte[] getEncryptionKey() {
        return this.encryptionKey;
    }

    public int getKeyLength() {
        return this.keyLength;
    }

    public ProtectionPolicy getProtectionPolicy() {
        return this.protectionPolicy;
    }

    public boolean hasProtectionPolicy() {
        return this.protectionPolicy != null;
    }

    public boolean isAES() {
        return this.useAES;
    }

    public boolean isDecryptMetadata() {
        return this.decryptMetadata;
    }

    public abstract void prepareDocumentForEncryption(PDDocument pDDocument) throws IOException;

    public abstract void prepareForDecryption(PDEncryption pDEncryption, COSArray cOSArray, DecryptionMaterial decryptionMaterial) throws IOException;

    public void setAES(boolean z) {
        this.useAES = z;
    }

    public void setCurrentAccessPermission(AccessPermission accessPermission) {
        this.currentAccessPermission = accessPermission;
    }

    public void setCustomSecureRandom(SecureRandom secureRandom) {
        this.customSecureRandom = secureRandom;
    }

    public void setDecryptMetadata(boolean z) {
        this.decryptMetadata = z;
    }

    public void setEncryptionKey(byte[] bArr) {
        this.encryptionKey = bArr;
    }

    public void setKeyLength(int i2) {
        this.keyLength = (short) i2;
    }

    public void setProtectionPolicy(ProtectionPolicy protectionPolicy) {
        this.protectionPolicy = protectionPolicy;
    }

    public void setStreamFilterName(COSName cOSName) {
        this.streamFilterName = cOSName;
    }

    public void setStringFilterName(COSName cOSName) {
        this.stringFilterName = cOSName;
    }

    public void encryptDataRC4(byte[] bArr, byte[] bArr2, OutputStream outputStream) throws IOException {
        this.rc4.setKey(bArr);
        this.rc4.write(bArr2, outputStream);
    }
}
