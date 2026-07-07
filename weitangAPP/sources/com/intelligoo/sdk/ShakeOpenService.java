package com.intelligoo.sdk;

import android.os.Bundle;
import com.intelligoo.sdk.utils.BleLog;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

/* JADX INFO: loaded from: classes2.dex */
public class ShakeOpenService implements q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static DataOutputStream f9160a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static DataInputStream f9161b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Socket f9162c;

    private void a(String str) {
        try {
            try {
                try {
                    f9162c = o.a().b();
                    f9160a = new DataOutputStream(f9162c.getOutputStream());
                    f9161b = new DataInputStream(f9162c.getInputStream());
                    f9160a.write(str.getBytes());
                    f9160a.flush();
                    byte[] bArr = new byte[20];
                    while (true) {
                        int i2 = f9161b.read(bArr);
                        if (i2 == -1) {
                            break;
                        }
                        byte[] bArr2 = new byte[i2];
                        System.arraycopy(bArr, 0, bArr2, 0, i2);
                        k.b(bArr2);
                    }
                    f9160a.close();
                    f9161b.close();
                    Socket socket = f9162c;
                    if (socket != null) {
                        socket.close();
                    }
                } catch (UnknownHostException e2) {
                    e2.printStackTrace();
                    Socket socket2 = f9162c;
                    if (socket2 != null) {
                        socket2.close();
                    }
                } catch (IOException e3) {
                    e3.printStackTrace();
                    Socket socket3 = f9162c;
                    if (socket3 != null) {
                        socket3.close();
                    }
                }
            } catch (IOException e4) {
                e4.printStackTrace();
            }
        } catch (Throwable th) {
            try {
                Socket socket4 = f9162c;
                if (socket4 != null) {
                    socket4.close();
                }
            } catch (IOException e5) {
                e5.printStackTrace();
            }
            throw th;
        }
    }

    public static void a(byte[] bArr) {
        String str = "DM+" + e.c(bArr, bArr.length).toUpperCase() + BleLog.LINE_BREAK;
        try {
            try {
                try {
                    try {
                        f9162c = o.a().b();
                        f9160a.write(str.getBytes());
                        f9160a.flush();
                        byte[] bArr2 = new byte[20];
                        while (true) {
                            int i2 = f9161b.read(bArr2);
                            if (i2 == -1) {
                                break;
                            }
                            byte[] bArr3 = new byte[i2];
                            System.arraycopy(bArr2, 0, bArr3, 0, i2);
                            k.b(bArr3);
                        }
                        f9160a.close();
                        f9161b.close();
                        Socket socket = f9162c;
                        if (socket != null) {
                            socket.close();
                        }
                    } catch (UnknownHostException e2) {
                        l.a("UnknownHostException" + e2.getLocalizedMessage());
                        e2.printStackTrace();
                        Socket socket2 = f9162c;
                        if (socket2 != null) {
                            socket2.close();
                        }
                    }
                } catch (IOException e3) {
                    l.a("IOException" + e3.getLocalizedMessage());
                    e3.printStackTrace();
                    Socket socket3 = f9162c;
                    if (socket3 != null) {
                        socket3.close();
                    }
                }
            } catch (Throwable th) {
                try {
                    Socket socket4 = f9162c;
                    if (socket4 != null) {
                        socket4.close();
                    }
                } catch (IOException e4) {
                    e4.printStackTrace();
                }
                throw th;
            }
        } catch (IOException e5) {
            e5.printStackTrace();
        }
    }

    @Override // com.intelligoo.sdk.q
    public void onOpenCmdCallBack(int i2, byte[] bArr) {
        k.a(false);
        if (i2 == 0) {
            a(bArr);
        } else {
            l.a("get random error");
        }
    }

    @Override // com.intelligoo.sdk.q
    public void onRandomCmdCallBack(int i2, Bundle bundle) {
        k.a(false);
        l.a(i2 == 0 ? com.taobao.agoo.a.a.b.JSON_SUCCESS : com.alipay.sdk.m.u.h.j);
    }

    public void open(String str, int i2) {
        byte[] bArrA = k.a((byte) i2, e.b(str));
        String str2 = "DM+" + e.c(bArrA, bArrA.length).toUpperCase() + BleLog.LINE_BREAK;
        k.a(true);
        a(str2);
    }
}
