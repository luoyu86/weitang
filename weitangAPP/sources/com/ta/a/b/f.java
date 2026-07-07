package com.ta.a.b;

import android.net.SSLCertificateSocketFactory;
import android.os.Build;
import android.text.TextUtils;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.Socket;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

/* JADX INFO: loaded from: classes2.dex */
public class f extends SSLSocketFactory {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f10193c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Method f10192a = null;
    private HostnameVerifier hostnameVerifier = HttpsURLConnection.getDefaultHostnameVerifier();

    public f(String str) {
        this.f10193c = str;
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
        SSLSocket sSLSocket;
        com.ta.a.c.f.b("", "peerHost", this.f10193c, "host", str, "port", Integer.valueOf(i2), "autoClose", Boolean.valueOf(z));
        SSLCertificateSocketFactory sSLCertificateSocketFactory = (SSLCertificateSocketFactory) SSLCertificateSocketFactory.getDefault(0);
        int i3 = Build.VERSION.SDK_INT;
        if (i3 < 24) {
            sSLCertificateSocketFactory.setTrustManagers(g.getTrustManagers());
        } else {
            sSLCertificateSocketFactory.setTrustManagers(c.getTrustManagers());
        }
        com.ta.a.c.f.m80a("", "createSocket");
        if (i3 < 23) {
            InetAddress inetAddress = socket.getInetAddress();
            if (z) {
                socket.close();
            }
            sSLSocket = (SSLSocket) sSLCertificateSocketFactory.createSocket(inetAddress, i2);
        } else {
            sSLSocket = (SSLSocket) sSLCertificateSocketFactory.createSocket(socket, this.f10193c, i2, true);
        }
        com.ta.a.c.f.m80a("", "createSocket end");
        sSLSocket.setEnabledProtocols(sSLSocket.getSupportedProtocols());
        if (i3 >= 17) {
            sSLCertificateSocketFactory.setHostname(sSLSocket, this.f10193c);
        } else {
            try {
                if (this.f10192a == null) {
                    Method method = sSLSocket.getClass().getMethod("setHostname", String.class);
                    this.f10192a = method;
                    method.setAccessible(true);
                }
                this.f10192a.invoke(sSLSocket, this.f10193c);
            } catch (Exception e2) {
                com.ta.a.c.f.m80a("", "SNI not useable", e2);
            }
        }
        SSLSession session = sSLSocket.getSession();
        if (this.hostnameVerifier.verify(this.f10193c, session)) {
            com.ta.a.c.f.b("", "SSLSession PeerHost", session.getPeerHost());
            return sSLSocket;
        }
        throw new SSLPeerUnverifiedException("Cannot verify hostname: " + this.f10193c);
    }

    public boolean equals(Object obj) {
        if (TextUtils.isEmpty(this.f10193c) || !(obj instanceof f)) {
            return false;
        }
        String str = ((f) obj).f10193c;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return this.f10193c.equals(str);
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getDefaultCipherSuites() {
        return new String[0];
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getSupportedCipherSuites() {
        return new String[0];
    }
}
