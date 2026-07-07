package com.alibaba.mtl.log.d;

import android.net.SSLCertificateSocketFactory;
import android.net.SSLSessionCache;
import android.os.Build;
import android.text.TextUtils;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.Socket;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

/* JADX INFO: loaded from: classes.dex */
public class x extends SSLSocketFactory {
    private String ak;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Method f4575b = null;

    public x(String str) {
        this.ak = str;
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket() throws IOException {
        return null;
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String str, int i2) throws IOException {
        return null;
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String str, int i2, InetAddress inetAddress, int i3) throws IOException {
        return null;
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress inetAddress, int i2) throws IOException {
        return null;
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress inetAddress, int i2, InetAddress inetAddress2, int i3) throws IOException {
        return null;
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public Socket createSocket(Socket socket, String str, int i2, boolean z) throws IOException {
        i.a("UtSslSocketFactory", "bizHost", this.ak, "host", str, "port", Integer.valueOf(i2), "autoClose", Boolean.valueOf(z));
        if (TextUtils.isEmpty(this.ak)) {
            throw new IOException("SDK set empty bizHost");
        }
        i.a("UtSslSocketFactory", "customized createSocket. host: " + this.ak);
        try {
            SSLCertificateSocketFactory sSLCertificateSocketFactory = (SSLCertificateSocketFactory) SSLCertificateSocketFactory.getDefault(10000, new SSLSessionCache(com.alibaba.mtl.log.a.getContext()));
            int i3 = Build.VERSION.SDK_INT;
            if (i3 < 24) {
                sSLCertificateSocketFactory.setTrustManagers(y.getTrustManagers());
            } else {
                sSLCertificateSocketFactory.setTrustManagers(v.getTrustManagers());
            }
            SSLSocket sSLSocket = (SSLSocket) sSLCertificateSocketFactory.createSocket(socket, this.ak, i2, z);
            sSLSocket.setEnabledProtocols(sSLSocket.getSupportedProtocols());
            if (i3 < 17) {
                try {
                    if (this.f4575b == null) {
                        Method method = sSLSocket.getClass().getMethod("setHostname", String.class);
                        this.f4575b = method;
                        method.setAccessible(true);
                    }
                    this.f4575b.invoke(sSLSocket, this.ak);
                } catch (Exception unused) {
                }
            } else {
                sSLCertificateSocketFactory.setUseSessionTickets(sSLSocket, true);
                sSLCertificateSocketFactory.setHostname(sSLSocket, this.ak);
            }
            sSLSocket.startHandshake();
            return sSLSocket;
        } catch (Throwable th) {
            throw new IOException("createSocket exception: " + th);
        }
    }

    public boolean equals(Object obj) {
        if (TextUtils.isEmpty(this.ak) || !(obj instanceof x)) {
            return false;
        }
        String str = ((x) obj).ak;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return this.ak.equals(str);
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getDefaultCipherSuites() {
        return new String[0];
    }

    public String getHost() {
        return this.ak;
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getSupportedCipherSuites() {
        return new String[0];
    }
}
