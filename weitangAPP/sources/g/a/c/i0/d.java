package g.a.c.i0;

import g.a.h.n;
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
import java.security.PrivateKey;
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
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;

/* JADX INFO: loaded from: classes2.dex */
public interface d extends g.a.e.d.d {
    @Override // g.a.e.d.d
    /* synthetic */ AlgorithmParameterGenerator createAlgorithmParameterGenerator(String str) throws NoSuchAlgorithmException, NoSuchProviderException;

    @Override // g.a.e.d.d
    /* synthetic */ AlgorithmParameters createAlgorithmParameters(String str) throws NoSuchAlgorithmException, NoSuchProviderException;

    g.a.h.o.a createAsymmetricUnwrapper(g.a.a.y3.a aVar, PrivateKey privateKey);

    g.a.h.o.c createAsymmetricUnwrapper(g.a.a.y3.a aVar, PrivateKey privateKey, byte[] bArr, byte[] bArr2);

    @Override // g.a.e.d.d
    /* synthetic */ CertPathBuilder createCertPathBuilder(String str) throws NoSuchAlgorithmException, NoSuchProviderException;

    @Override // g.a.e.d.d
    /* synthetic */ CertPathValidator createCertPathValidator(String str) throws NoSuchAlgorithmException, NoSuchProviderException;

    @Override // g.a.e.d.d
    /* synthetic */ CertStore createCertStore(String str, CertStoreParameters certStoreParameters) throws NoSuchAlgorithmException, NoSuchProviderException, InvalidAlgorithmParameterException;

    @Override // g.a.e.d.d
    /* synthetic */ CertificateFactory createCertificateFactory(String str) throws CertificateException, NoSuchProviderException;

    @Override // g.a.e.d.d
    /* synthetic */ Cipher createCipher(String str) throws NoSuchPaddingException, NoSuchAlgorithmException, NoSuchProviderException;

    @Override // g.a.e.d.d
    /* synthetic */ MessageDigest createDigest(String str) throws NoSuchAlgorithmException, NoSuchProviderException;

    @Override // g.a.e.d.d
    /* synthetic */ ExemptionMechanism createExemptionMechanism(String str) throws NoSuchAlgorithmException, NoSuchProviderException;

    @Override // g.a.e.d.d
    /* synthetic */ KeyAgreement createKeyAgreement(String str) throws NoSuchAlgorithmException, NoSuchProviderException;

    @Override // g.a.e.d.d
    /* synthetic */ KeyFactory createKeyFactory(String str) throws NoSuchAlgorithmException, NoSuchProviderException;

    @Override // g.a.e.d.d
    /* synthetic */ KeyGenerator createKeyGenerator(String str) throws NoSuchAlgorithmException, NoSuchProviderException;

    @Override // g.a.e.d.d
    /* synthetic */ KeyPairGenerator createKeyPairGenerator(String str) throws NoSuchAlgorithmException, NoSuchProviderException;

    @Override // g.a.e.d.d
    /* synthetic */ KeyStore createKeyStore(String str) throws KeyStoreException, NoSuchProviderException;

    @Override // g.a.e.d.d
    /* synthetic */ Mac createMac(String str) throws NoSuchAlgorithmException, NoSuchProviderException;

    @Override // g.a.e.d.d
    /* synthetic */ MessageDigest createMessageDigest(String str) throws NoSuchAlgorithmException, NoSuchProviderException;

    @Override // g.a.e.d.d
    /* synthetic */ SecretKeyFactory createSecretKeyFactory(String str) throws NoSuchAlgorithmException, NoSuchProviderException;

    @Override // g.a.e.d.d
    /* synthetic */ SecureRandom createSecureRandom(String str) throws NoSuchAlgorithmException, NoSuchProviderException;

    @Override // g.a.e.d.d
    /* synthetic */ Signature createSignature(String str) throws NoSuchAlgorithmException, NoSuchProviderException;

    n createSymmetricUnwrapper(g.a.a.y3.a aVar, SecretKey secretKey);
}
