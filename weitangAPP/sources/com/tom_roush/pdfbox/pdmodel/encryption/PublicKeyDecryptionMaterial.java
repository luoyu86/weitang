package com.tom_roush.pdfbox.pdmodel.encryption;

import java.security.Key;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.X509Certificate;

/* JADX INFO: loaded from: classes2.dex */
public class PublicKeyDecryptionMaterial extends DecryptionMaterial {
    private String alias;
    private KeyStore keyStore;
    private String password;

    public PublicKeyDecryptionMaterial(KeyStore keyStore, String str, String str2) {
        this.password = null;
        this.keyStore = null;
        this.alias = null;
        this.keyStore = keyStore;
        this.alias = str;
        this.password = str2;
    }

    public X509Certificate getCertificate() throws KeyStoreException {
        if (this.keyStore.size() == 1) {
            return (X509Certificate) this.keyStore.getCertificate(this.keyStore.aliases().nextElement());
        }
        if (this.keyStore.containsAlias(this.alias)) {
            return (X509Certificate) this.keyStore.getCertificate(this.alias);
        }
        throw new KeyStoreException("the keystore does not contain the given alias");
    }

    public String getPassword() {
        return this.password;
    }

    public Key getPrivateKey() throws KeyStoreException {
        try {
            if (this.keyStore.size() == 1) {
                return this.keyStore.getKey(this.keyStore.aliases().nextElement(), this.password.toCharArray());
            }
            if (this.keyStore.containsAlias(this.alias)) {
                return this.keyStore.getKey(this.alias, this.password.toCharArray());
            }
            throw new KeyStoreException("the keystore does not contain the given alias");
        } catch (NoSuchAlgorithmException e2) {
            throw new KeyStoreException("the algorithm necessary to recover the key is not available", e2);
        } catch (UnrecoverableKeyException e3) {
            throw new KeyStoreException("the private key is not recoverable", e3);
        }
    }
}
