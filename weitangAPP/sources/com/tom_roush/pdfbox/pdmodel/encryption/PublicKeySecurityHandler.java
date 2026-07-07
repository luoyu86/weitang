package com.tom_roush.pdfbox.pdmodel.encryption;

import com.tom_roush.pdfbox.cos.COSArray;
import com.tom_roush.pdfbox.cos.COSBase;
import com.tom_roush.pdfbox.cos.COSDictionary;
import com.tom_roush.pdfbox.cos.COSName;
import com.tom_roush.pdfbox.cos.COSString;
import com.tom_roush.pdfbox.pdmodel.PDDocument;
import g.a.a.a0;
import g.a.a.c2;
import g.a.a.f0;
import g.a.a.i3.e;
import g.a.a.i3.g;
import g.a.a.i3.i;
import g.a.a.i3.n;
import g.a.a.i3.w;
import g.a.a.p;
import g.a.a.x1;
import g.a.a.y3.a;
import g.a.b.f;
import g.a.c.d0;
import g.a.c.h;
import g.a.c.v;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.security.AlgorithmParameterGenerator;
import java.security.AlgorithmParameters;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.Provider;
import java.security.SecureRandom;
import java.security.cert.CertificateEncodingException;
import java.security.cert.X509Certificate;
import java.util.Iterator;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;

/* JADX INFO: loaded from: classes2.dex */
public final class PublicKeySecurityHandler extends SecurityHandler {
    public static final String FILTER = "Adobe.PubSec";
    private static final String SUBFILTER4 = "adbe.pkcs7.s4";
    private static final String SUBFILTER5 = "adbe.pkcs7.s5";

    public PublicKeySecurityHandler() {
    }

    private void appendCertInfo(StringBuilder sb, v vVar, X509Certificate x509Certificate, f fVar) {
        BigInteger serialNumber = vVar.getSerialNumber();
        if (serialNumber != null) {
            BigInteger serialNumber2 = x509Certificate.getSerialNumber();
            String string = serialNumber2 != null ? serialNumber2.toString(16) : "unknown";
            sb.append("serial-#: rid ");
            sb.append(serialNumber.toString(16));
            sb.append(" vs. cert ");
            sb.append(string);
            sb.append(" issuer: rid '");
            sb.append(vVar.getIssuer());
            sb.append("' vs. cert '");
            sb.append(fVar == null ? "null" : fVar.getIssuer());
            sb.append("' ");
        }
    }

    private n computeRecipientInfo(X509Certificate x509Certificate, byte[] bArr) throws BadPaddingException, IllegalBlockSizeException, IOException, InvalidKeyException, CertificateEncodingException {
        p pVar = new p(x509Certificate.getTBSCertificate());
        g.a.a.y3.n nVar = g.a.a.y3.n.getInstance(pVar.readObject());
        pVar.close();
        a algorithm = nVar.getSubjectPublicKeyInfo().getAlgorithm();
        i iVar = new i(nVar.getIssuer(), nVar.getSerialNumber().getValue());
        try {
            Cipher cipher = Cipher.getInstance(algorithm.getAlgorithm().getId(), SecurityProvider.getProvider());
            cipher.init(1, x509Certificate.getPublicKey());
            return new n(new g.a.a.i3.v(iVar), algorithm, new x1(cipher.doFinal(bArr)));
        } catch (NoSuchAlgorithmException e2) {
            throw new RuntimeException("Could not find a suitable javax.crypto provider", e2);
        } catch (NoSuchPaddingException e3) {
            throw new RuntimeException("Could not find a suitable javax.crypto provider", e3);
        }
    }

    private byte[][] computeRecipientsField(byte[] bArr) throws GeneralSecurityException, IOException {
        PublicKeyProtectionPolicy publicKeyProtectionPolicy = (PublicKeyProtectionPolicy) getProtectionPolicy();
        byte[][] bArr2 = new byte[publicKeyProtectionPolicy.getNumberOfRecipients()][];
        Iterator<PublicKeyRecipient> recipientsIterator = publicKeyProtectionPolicy.getRecipientsIterator();
        int i2 = 0;
        while (recipientsIterator.hasNext()) {
            PublicKeyRecipient next = recipientsIterator.next();
            X509Certificate x509 = next.getX509();
            int permissionBytesForPublicKey = next.getPermission().getPermissionBytesForPublicKey();
            byte[] bArr3 = new byte[24];
            System.arraycopy(bArr, 0, bArr3, 0, 20);
            bArr3[20] = (byte) (permissionBytesForPublicKey >>> 24);
            bArr3[21] = (byte) (permissionBytesForPublicKey >>> 16);
            bArr3[22] = (byte) (permissionBytesForPublicKey >>> 8);
            bArr3[23] = (byte) permissionBytesForPublicKey;
            a0 a0VarCreateDERForRecipient = createDERForRecipient(bArr3, x509);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            a0VarCreateDERForRecipient.encodeTo(byteArrayOutputStream, "DER");
            bArr2[i2] = byteArrayOutputStream.toByteArray();
            i2++;
        }
        return bArr2;
    }

    private a0 createDERForRecipient(byte[] bArr, X509Certificate x509Certificate) throws GeneralSecurityException, IOException {
        String id = g.a.a.t3.a.X0.getId();
        try {
            Provider provider = SecurityProvider.getProvider();
            AlgorithmParameterGenerator algorithmParameterGenerator = AlgorithmParameterGenerator.getInstance(id, provider);
            KeyGenerator keyGenerator = KeyGenerator.getInstance(id, provider);
            Cipher cipher = Cipher.getInstance(id, provider);
            AlgorithmParameters algorithmParametersGenerateParameters = algorithmParameterGenerator.generateParameters();
            p pVar = new p(algorithmParametersGenerateParameters.getEncoded("ASN.1"));
            a0 object = pVar.readObject();
            pVar.close();
            keyGenerator.init(128);
            SecretKey secretKeyGenerateKey = keyGenerator.generateKey();
            cipher.init(1, secretKeyGenerateKey, algorithmParametersGenerateParameters);
            return new e(g.a.a.t3.a.o1, new g((g.a.a.i3.p) null, new c2(new w(computeRecipientInfo(x509Certificate, secretKeyGenerateKey.getEncoded()))), new g.a.a.i3.f(g.a.a.t3.a.m1, new a(new g.a.a.v(id), object), new x1(cipher.doFinal(bArr))), (f0) null)).toASN1Primitive();
        } catch (NoSuchAlgorithmException e2) {
            throw new IOException("Could not find a suitable javax.crypto provider for algorithm " + id + "; possible reason: using an unsigned .jar file", e2);
        } catch (NoSuchPaddingException e3) {
            throw new RuntimeException("Could not find a suitable javax.crypto provider", e3);
        }
    }

    private void prepareEncryptionDictAES(PDEncryption pDEncryption, COSName cOSName, byte[][] bArr) {
        PDCryptFilterDictionary pDCryptFilterDictionary = new PDCryptFilterDictionary();
        pDCryptFilterDictionary.setCryptFilterMethod(cOSName);
        pDCryptFilterDictionary.setLength(getKeyLength());
        COSArray cOSArray = new COSArray();
        for (byte[] bArr2 : bArr) {
            cOSArray.add((COSBase) new COSString(bArr2));
        }
        pDCryptFilterDictionary.getCOSObject().setItem(COSName.RECIPIENTS, (COSBase) cOSArray);
        cOSArray.setDirect(true);
        pDEncryption.setDefaultCryptFilterDictionary(pDCryptFilterDictionary);
        COSName cOSName2 = COSName.DEFAULT_CRYPT_FILTER;
        pDEncryption.setStreamFilterName(cOSName2);
        pDEncryption.setStringFilterName(cOSName2);
        pDCryptFilterDictionary.getCOSObject().setDirect(true);
        setAES(true);
    }

    @Override // com.tom_roush.pdfbox.pdmodel.encryption.SecurityHandler
    public void prepareDocumentForEncryption(PDDocument pDDocument) throws IOException {
        byte[] bArrDigest;
        try {
            PDEncryption encryption = pDDocument.getEncryption();
            if (encryption == null) {
                encryption = new PDEncryption();
            }
            encryption.setFilter(FILTER);
            encryption.setLength(getKeyLength());
            int iComputeVersionNumber = computeVersionNumber();
            encryption.setVersion(iComputeVersionNumber);
            encryption.removeV45filters();
            int length = 20;
            byte[] bArr = new byte[20];
            try {
                KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
                keyGenerator.init(192, new SecureRandom());
                System.arraycopy(keyGenerator.generateKey().getEncoded(), 0, bArr, 0, 20);
                byte[][] bArrComputeRecipientsField = computeRecipientsField(bArr);
                int length2 = 20;
                for (byte[] bArr2 : bArrComputeRecipientsField) {
                    length2 += bArr2.length;
                }
                byte[] bArr3 = new byte[length2];
                System.arraycopy(bArr, 0, bArr3, 0, 20);
                for (byte[] bArr4 : bArrComputeRecipientsField) {
                    System.arraycopy(bArr4, 0, bArr3, length, bArr4.length);
                    length += bArr4.length;
                }
                if (iComputeVersionNumber == 4) {
                    encryption.setSubFilter(SUBFILTER5);
                    bArrDigest = MessageDigests.getSHA1().digest(bArr3);
                    prepareEncryptionDictAES(encryption, COSName.AESV2, bArrComputeRecipientsField);
                } else if (iComputeVersionNumber != 5) {
                    encryption.setSubFilter(SUBFILTER4);
                    bArrDigest = MessageDigests.getSHA1().digest(bArr3);
                    encryption.setRecipients(bArrComputeRecipientsField);
                } else {
                    encryption.setSubFilter(SUBFILTER5);
                    bArrDigest = MessageDigests.getSHA256().digest(bArr3);
                    prepareEncryptionDictAES(encryption, COSName.AESV3, bArrComputeRecipientsField);
                }
                setEncryptionKey(new byte[getKeyLength() / 8]);
                System.arraycopy(bArrDigest, 0, getEncryptionKey(), 0, getKeyLength() / 8);
                pDDocument.setEncryptionDictionary(encryption);
                pDDocument.getDocument().setEncryptionDictionary(encryption.getCOSObject());
            } catch (NoSuchAlgorithmException e2) {
                throw new RuntimeException(e2);
            }
        } catch (GeneralSecurityException e3) {
            throw new IOException(e3);
        }
    }

    @Override // com.tom_roush.pdfbox.pdmodel.encryption.SecurityHandler
    public void prepareForDecryption(PDEncryption pDEncryption, COSArray cOSArray, DecryptionMaterial decryptionMaterial) throws IOException {
        byte[] bArrDigest;
        PublicKeyDecryptionMaterial publicKeyDecryptionMaterial;
        if (!(decryptionMaterial instanceof PublicKeyDecryptionMaterial)) {
            throw new IOException("Provided decryption material is not compatible with the document - did you pass a null keyStore?");
        }
        PDCryptFilterDictionary defaultCryptFilterDictionary = pDEncryption.getDefaultCryptFilterDictionary();
        if (defaultCryptFilterDictionary != null && defaultCryptFilterDictionary.getLength() != 0) {
            setKeyLength(defaultCryptFilterDictionary.getLength());
            setDecryptMetadata(defaultCryptFilterDictionary.isEncryptMetaData());
        } else if (pDEncryption.getLength() != 0) {
            setKeyLength(pDEncryption.getLength());
            setDecryptMetadata(pDEncryption.isEncryptMetaData());
        }
        PublicKeyDecryptionMaterial publicKeyDecryptionMaterial2 = (PublicKeyDecryptionMaterial) decryptionMaterial;
        try {
            X509Certificate certificate = publicKeyDecryptionMaterial2.getCertificate();
            byte[] content = null;
            f fVar = certificate != null ? new f(certificate.getEncoded()) : null;
            COSDictionary cOSObject = pDEncryption.getCOSObject();
            COSName cOSName = COSName.RECIPIENTS;
            COSArray cOSArray2 = cOSObject.getCOSArray(cOSName);
            if (cOSArray2 == null && defaultCryptFilterDictionary != null) {
                cOSArray2 = defaultCryptFilterDictionary.getCOSObject().getCOSArray(cOSName);
            }
            if (cOSArray2 == null) {
                throw new IOException("/Recipients entry is missing in encryption dictionary");
            }
            int size = cOSArray2.size();
            byte[][] bArr = new byte[size][];
            StringBuilder sb = new StringBuilder();
            int i2 = 0;
            boolean z = false;
            int length = 0;
            while (i2 < cOSArray2.size()) {
                byte[] bytes = ((COSString) cOSArray2.getObject(i2)).getBytes();
                Iterator<g.a.c.f0> it = new g.a.c.e(bytes).getRecipientInfos().getRecipients().iterator();
                int i3 = 0;
                while (true) {
                    if (!it.hasNext()) {
                        publicKeyDecryptionMaterial = publicKeyDecryptionMaterial2;
                        break;
                    }
                    g.a.c.f0 next = it.next();
                    Iterator<g.a.c.f0> it2 = it;
                    d0 rid = next.getRID();
                    if (!z && rid.match(fVar)) {
                        content = next.getContent(new g.a.c.i0.e((PrivateKey) publicKeyDecryptionMaterial2.getPrivateKey()));
                        publicKeyDecryptionMaterial = publicKeyDecryptionMaterial2;
                        z = true;
                        break;
                    }
                    PublicKeyDecryptionMaterial publicKeyDecryptionMaterial3 = publicKeyDecryptionMaterial2;
                    int i4 = i3 + 1;
                    if (certificate != null) {
                        sb.append('\n');
                        sb.append(i4);
                        sb.append(": ");
                        if (rid instanceof v) {
                            appendCertInfo(sb, (v) rid, certificate, fVar);
                        }
                    }
                    i3 = i4;
                    it = it2;
                    publicKeyDecryptionMaterial2 = publicKeyDecryptionMaterial3;
                }
                bArr[i2] = bytes;
                length += bytes.length;
                i2++;
                publicKeyDecryptionMaterial2 = publicKeyDecryptionMaterial;
            }
            if (!z || content == null) {
                throw new IOException("The certificate matches none of " + cOSArray2.size() + " recipient entries" + sb.toString());
            }
            if (content.length != 24) {
                throw new IOException("The enveloped data does not contain 24 bytes");
            }
            byte[] bArr2 = new byte[4];
            int length2 = 20;
            System.arraycopy(content, 20, bArr2, 0, 4);
            AccessPermission accessPermission = new AccessPermission(bArr2);
            accessPermission.setReadOnly();
            setCurrentAccessPermission(accessPermission);
            int i5 = length + 20;
            byte[] bArrCopyOf = new byte[i5];
            int i6 = 0;
            System.arraycopy(content, 0, bArrCopyOf, 0, 20);
            int i7 = 0;
            while (i7 < size) {
                byte[] bArr3 = bArr[i7];
                System.arraycopy(bArr3, i6, bArrCopyOf, length2, bArr3.length);
                length2 += bArr3.length;
                i7++;
                i6 = 0;
            }
            if (pDEncryption.getVersion() == 4 || pDEncryption.getVersion() == 5) {
                if (!isDecryptMetadata()) {
                    bArrCopyOf = g.a.j.a.copyOf(bArrCopyOf, i5 + 4);
                    System.arraycopy(new byte[]{-1, -1, -1, -1}, 0, bArrCopyOf, bArrCopyOf.length - 4, 4);
                }
                bArrDigest = pDEncryption.getVersion() == 4 ? MessageDigests.getSHA1().digest(bArrCopyOf) : MessageDigests.getSHA256().digest(bArrCopyOf);
                if (defaultCryptFilterDictionary != null) {
                    COSName cryptFilterMethod = defaultCryptFilterDictionary.getCryptFilterMethod();
                    setAES(COSName.AESV2.equals(cryptFilterMethod) || COSName.AESV3.equals(cryptFilterMethod));
                }
            } else {
                bArrDigest = MessageDigests.getSHA1().digest(bArrCopyOf);
            }
            setEncryptionKey(new byte[getKeyLength() / 8]);
            System.arraycopy(bArrDigest, 0, getEncryptionKey(), 0, getKeyLength() / 8);
        } catch (h e2) {
            throw new IOException(e2);
        } catch (KeyStoreException e3) {
            throw new IOException(e3);
        } catch (CertificateEncodingException e4) {
            throw new IOException(e4);
        }
    }

    public PublicKeySecurityHandler(PublicKeyProtectionPolicy publicKeyProtectionPolicy) {
        setProtectionPolicy(publicKeyProtectionPolicy);
        setKeyLength(publicKeyProtectionPolicy.getEncryptionKeyLength());
    }
}
