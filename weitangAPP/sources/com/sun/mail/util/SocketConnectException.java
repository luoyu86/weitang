package com.sun.mail.util;

import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public class SocketConnectException extends IOException {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final long serialVersionUID = 3997871560538755463L;
    private int cto;
    private String host;
    private int port;

    public SocketConnectException(String str, Exception exc, String str2, int i2, int i3) {
        super(str);
        initCause(exc);
        this.host = str2;
        this.port = i2;
        this.cto = i3;
    }

    public int getConnectionTimeout() {
        return this.cto;
    }

    public Exception getException() {
        return (Exception) getCause();
    }

    public String getHost() {
        return this.host;
    }

    public int getPort() {
        return this.port;
    }
}
