package g.a.e.d;

import java.security.AlgorithmParameterGenerator;
import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.KeyFactory;
import java.security.KeyPairGenerator;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;
import java.security.Signature;
import java.security.cert.CertPathBuilder;
import java.security.cert.CertPathValidator;
import java.security.cert.CertStore;
import java.security.cert.CertStoreParameters;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import javax.crypto.Cipher;
import javax.crypto.ExemptionMechanism;
import javax.crypto.KeyAgreement;
import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKeyFactory;

/* JADX INFO: loaded from: classes2.dex */
public class e implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f13859a;

    public e(String str) {
        this.f13859a = str;
    }

    @Override // g.a.e.d.d
    public AlgorithmParameterGenerator createAlgorithmParameterGenerator(String str) throws NoSuchAlgorithmException, NoSuchProviderException {
        return AlgorithmParameterGenerator.getInstance(str, this.f13859a);
    }

    @Override // g.a.e.d.d
    public AlgorithmParameters createAlgorithmParameters(String str) throws NoSuchAlgorithmException, NoSuchProviderException {
        return AlgorithmParameters.getInstance(str, this.f13859a);
    }

    @Override // g.a.e.d.d
    public CertPathBuilder createCertPathBuilder(String str) throws NoSuchAlgorithmException, NoSuchProviderException {
        return CertPathBuilder.getInstance(str, this.f13859a);
    }

    @Override // g.a.e.d.d
    public CertPathValidator createCertPathValidator(String str) throws NoSuchAlgorithmException, NoSuchProviderException {
        return CertPathValidator.getInstance(str, this.f13859a);
    }

    @Override // g.a.e.d.d
    public CertStore createCertStore(String str, CertStoreParameters certStoreParameters) throws NoSuchAlgorithmException, NoSuchProviderException, InvalidAlgorithmParameterException {
        return CertStore.getInstance(str, certStoreParameters, this.f13859a);
    }

    @Override // g.a.e.d.d
    public CertificateFactory createCertificateFactory(String str) throws CertificateException, NoSuchProviderException {
        return CertificateFactory.getInstance(str, this.f13859a);
    }

    @Override // g.a.e.d.d
    public Cipher createCipher(String str) throws NoSuchPaddingException, NoSuchAlgorithmException, NoSuchProviderException {
        return Cipher.getInstance(str, this.f13859a);
    }

    @Override // g.a.e.d.d
    public MessageDigest createDigest(String str) throws NoSuchAlgorithmException, NoSuchProviderException {
        return MessageDigest.getInstance(str, this.f13859a);
    }

    @Override // g.a.e.d.d
    public ExemptionMechanism createExemptionMechanism(String str) throws NoSuchAlgorithmException, NoSuchProviderException {
        return ExemptionMechanism.getInstance(str, this.f13859a);
    }

    @Override // g.a.e.d.d
    public KeyAgreement createKeyAgreement(String str) throws NoSuchAlgorithmException, NoSuchProviderException {
        return KeyAgreement.getInstance(str, this.f13859a);
    }

    @Override // g.a.e.d.d
    public KeyFactory createKeyFactory(String str) throws NoSuchAlgorithmException, NoSuchProviderException {
        return KeyFactory.getInstance(str, this.f13859a);
    }

    @Override // g.a.e.d.d
    public KeyGenerator createKeyGenerator(String str) throws NoSuchAlgorithmException, NoSuchProviderException {
        return KeyGenerator.getInstance(str, this.f13859a);
    }

    @Override // g.a.e.d.d
    public KeyPairGenerator createKeyPairGenerator(String str) throws NoSuchAlgorithmException, NoSuchProviderException {
        return KeyPairGenerator.getInstance(str, this.f13859a);
    }

    @Override // g.a.e.d.d
    public KeyStore createKeyStore(String str) throws KeyStoreException, NoSuchProviderException {
        return KeyStore.getInstance(str, this.f13859a);
    }

    @Override // g.a.e.d.d
    public Mac createMac(String str) throws NoSuchAlgorithmException, NoSuchProviderException {
        return Mac.getInstance(str, this.f13859a);
    }

    @Override // g.a.e.d.d
    public MessageDigest createMessageDigest(String str) throws NoSuchAlgorithmException, NoSuchProviderException {
        return MessageDigest.getInstance(str, this.f13859a);
    }

    @Override // g.a.e.d.d
    public SecretKeyFactory createSecretKeyFactory(String str) throws NoSuchAlgorithmException, NoSuchProviderException {
        return SecretKeyFactory.getInstance(str, this.f13859a);
    }

    @Override // g.a.e.d.d
    public SecureRandom createSecureRandom(String str) throws NoSuchAlgorithmException, NoSuchProviderException {
        return SecureRandom.getInstance(str, this.f13859a);
    }

    @Override // g.a.e.d.d
    public Signature createSignature(String str) throws NoSuchAlgorithmException, NoSuchProviderException {
        return Signature.getInstance(str, this.f13859a);
    }
}
