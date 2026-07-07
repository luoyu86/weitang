package com.bytedance.pangle.g;

import java.security.cert.CertificateEncodingException;
import java.security.cert.X509Certificate;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class p extends r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final byte[] f6105a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f6106b;

    public p(X509Certificate x509Certificate, byte[] bArr) {
        super(x509Certificate);
        this.f6106b = -1;
        this.f6105a = bArr;
    }

    @Override // java.security.cert.Certificate
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof p)) {
            return false;
        }
        try {
            return Arrays.equals(getEncoded(), ((p) obj).getEncoded());
        } catch (CertificateEncodingException unused) {
            return false;
        }
    }

    @Override // com.bytedance.pangle.g.r, java.security.cert.Certificate
    public final byte[] getEncoded() {
        return this.f6105a;
    }

    @Override // java.security.cert.Certificate
    public final int hashCode() {
        if (this.f6106b == -1) {
            try {
                this.f6106b = Arrays.hashCode(getEncoded());
            } catch (CertificateEncodingException unused) {
                this.f6106b = 0;
            }
        }
        return this.f6106b;
    }
}
