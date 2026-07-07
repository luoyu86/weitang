package org.android.netutil;

/* JADX INFO: loaded from: classes2.dex */
public class UdpConnectType {
    public static native int nativeTestUdpConnectIpv4();

    public static native int nativeTestUdpConnectIpv6();

    public static boolean testUdpConnectIpv4() {
        return nativeTestUdpConnectIpv4() != 0;
    }

    public static boolean testUdpConnectIpv6() {
        return nativeTestUdpConnectIpv6() != 0;
    }
}
