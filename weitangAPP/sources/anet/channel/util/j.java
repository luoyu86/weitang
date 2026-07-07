package anet.channel.util;

import android.net.SSLCertificateSocketFactory;
import android.os.Build;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.Socket;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

/* JADX INFO: loaded from: classes.dex */
public class j extends SSLSocketFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f732a = "awcn.TlsSniSocketFactory";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Method f733b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f734c;

    public j(String str) {
        this.f734c = str;
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
        if (this.f734c == null) {
            this.f734c = str;
        }
        if (ALog.isPrintLog(1)) {
            ALog.i("awcn.TlsSniSocketFactory", "customized createSocket", null, "host", this.f734c);
        }
        InetAddress inetAddress = socket.getInetAddress();
        if (z) {
            socket.close();
        }
        SSLCertificateSocketFactory sSLCertificateSocketFactory = (SSLCertificateSocketFactory) SSLCertificateSocketFactory.getDefault(0);
        SSLSocket sSLSocket = (SSLSocket) sSLCertificateSocketFactory.createSocket(inetAddress, i2);
        sSLSocket.setEnabledProtocols(sSLSocket.getSupportedProtocols());
        if (Build.VERSION.SDK_INT >= 17) {
            sSLCertificateSocketFactory.setHostname(sSLSocket, this.f734c);
        } else {
            try {
                if (this.f733b == null) {
                    Method method = sSLSocket.getClass().getMethod("setHostname", String.class);
                    this.f733b = method;
                    method.setAccessible(true);
                }
                this.f733b.invoke(sSLSocket, this.f734c);
            } catch (Exception e2) {
                ALog.w("awcn.TlsSniSocketFactory", "SNI not useable", null, e2, new Object[0]);
            }
        }
        SSLSession session = sSLSocket.getSession();
        if (ALog.isPrintLog(1)) {
            ALog.d("awcn.TlsSniSocketFactory", null, null, "SSLSession PeerHost", session.getPeerHost());
        }
        return sSLSocket;
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
