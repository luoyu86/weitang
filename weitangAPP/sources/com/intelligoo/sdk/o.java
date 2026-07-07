package com.intelligoo.sdk;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

/* JADX INFO: loaded from: classes2.dex */
public class o {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static o f9289b = new o();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Socket f9290a = null;

    private o() {
        try {
            a(new Socket("192.168.4.1", 898));
        } catch (UnknownHostException e2) {
            e2.printStackTrace();
        } catch (IOException e3) {
            e3.printStackTrace();
        }
    }

    public static o a() {
        return f9289b;
    }

    private void a(Socket socket) {
        this.f9290a = socket;
    }

    public Socket b() {
        if (this.f9290a.isClosed()) {
            try {
                this.f9290a = new Socket("192.168.4.1", 898);
            } catch (IOException e2) {
                l.a("IOException" + e2.getMessage());
                e2.printStackTrace();
            }
        }
        return this.f9290a;
    }
}
