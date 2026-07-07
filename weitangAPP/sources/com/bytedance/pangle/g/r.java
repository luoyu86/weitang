package com.bytedance.pangle.g;

import java.math.BigInteger;
import java.security.Principal;
import java.security.PublicKey;
import java.security.cert.CertificateExpiredException;
import java.security.cert.CertificateNotYetValidException;
import java.security.cert.X509Certificate;
import java.util.Date;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class r extends X509Certificate {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final X509Certificate f6108a;

    public r(X509Certificate x509Certificate) {
        this.f6108a = x509Certificate;
    }

    @Override // java.security.cert.X509Certificate
    public void checkValidity() throws CertificateNotYetValidException, CertificateExpiredException {
        this.f6108a.checkValidity();
    }

    @Override // java.security.cert.X509Certificate
    public int getBasicConstraints() {
        return this.f6108a.getBasicConstraints();
    }

    @Override // java.security.cert.X509Extension
    public Set<String> getCriticalExtensionOIDs() {
        return this.f6108a.getCriticalExtensionOIDs();
    }

    @Override // java.security.cert.Certificate
    public byte[] getEncoded() {
        return this.f6108a.getEncoded();
    }

    @Override // java.security.cert.X509Extension
    public byte[] getExtensionValue(String str) {
        return this.f6108a.getExtensionValue(str);
    }

    @Override // java.security.cert.X509Certificate
    public Principal getIssuerDN() {
        return this.f6108a.getIssuerDN();
    }

    @Override // java.security.cert.X509Certificate
    public boolean[] getIssuerUniqueID() {
        return this.f6108a.getIssuerUniqueID();
    }

    @Override // java.security.cert.X509Certificate
    public boolean[] getKeyUsage() {
        return this.f6108a.getKeyUsage();
    }

    @Override // java.security.cert.X509Extension
    public Set<String> getNonCriticalExtensionOIDs() {
        return this.f6108a.getNonCriticalExtensionOIDs();
    }

    @Override // java.security.cert.X509Certificate
    public Date getNotAfter() {
        return this.f6108a.getNotAfter();
    }

    @Override // java.security.cert.X509Certificate
    public Date getNotBefore() {
        return this.f6108a.getNotBefore();
    }

    @Override // java.security.cert.Certificate
    public PublicKey getPublicKey() {
        return this.f6108a.getPublicKey();
    }

    @Override // java.security.cert.X509Certificate
    public BigInteger getSerialNumber() {
        return this.f6108a.getSerialNumber();
    }

    @Override // java.security.cert.X509Certificate
    public String getSigAlgName() {
        return this.f6108a.getSigAlgName();
    }

    @Override // java.security.cert.X509Certificate
    public String getSigAlgOID() {
        return this.f6108a.getSigAlgOID();
    }

    @Override // java.security.cert.X509Certificate
    public byte[] getSigAlgParams() {
        return this.f6108a.getSigAlgParams();
    }

    @Override // java.security.cert.X509Certificate
    public byte[] getSignature() {
        return this.f6108a.getSignature();
    }

    @Override // java.security.cert.X509Certificate
    public Principal getSubjectDN() {
        return this.f6108a.getSubjectDN();
    }

    @Override // java.security.cert.X509Certificate
    public boolean[] getSubjectUniqueID() {
        return this.f6108a.getSubjectUniqueID();
    }

    @Override // java.security.cert.X509Certificate
    public byte[] getTBSCertificate() {
        return this.f6108a.getTBSCertificate();
    }

    @Override // java.security.cert.X509Certificate
    public int getVersion() {
        return this.f6108a.getVersion();
    }

    @Override // java.security.cert.X509Extension
    public boolean hasUnsupportedCriticalExtension() {
        return this.f6108a.hasUnsupportedCriticalExtension();
    }

    @Override // java.security.cert.Certificate
    public String toString() {
        return this.f6108a.toString();
    }

    @Override // java.security.cert.Certificate
    public void verify(PublicKey publicKey) {
        this.f6108a.verify(publicKey);
    }

    @Override // java.security.cert.X509Certificate
    public void checkValidity(Date date) throws CertificateNotYetValidException, CertificateExpiredException {
        this.f6108a.checkValidity(date);
    }

    @Override // java.security.cert.Certificate
    public void verify(PublicKey publicKey, String str) {
        this.f6108a.verify(publicKey, str);
    }
}
