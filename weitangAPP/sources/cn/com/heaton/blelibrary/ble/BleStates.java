package cn.com.heaton.blelibrary.ble;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes.dex */
public class BleStates {

    @Retention(RetentionPolicy.SOURCE)
    public @interface BleStatus {
        public static final int BlutoothStatusOff = 2527;
        public static final int BlutoothStatusOn = 2528;
        public static final int CONNECTED = 2505;
        public static final int CONNECTING = 2504;
        public static final int Changed = 2515;
        public static final int ConnectError = 2522;
        public static final int ConnectException = 2523;
        public static final int ConnectFailed = 2521;
        public static final int ConnectTimeOut = 2510;
        public static final int ConnectionChanged = 2511;
        public static final int DISCONNECT = 2503;
        public static final int DescriptorRead = 2517;
        public static final int DescriptorWriter = 2516;
        public static final int MTUCHANGED = 2526;
        public static final int NotifySuccess = 2525;
        public static final int OnReady = 2520;
        public static final int Read = 2513;
        public static final int ReadRssi = 2524;
        public static final int ServicesDiscovered = 2512;
        public static final int Start = 2518;
        public static final int Stop = 2519;
        public static final int Write = 2514;
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface StatusCode {
        public static final int BleNotOpen = -3;
        public static final int Data_Command_Error = -7;
        public static final int NotFindDevice = -6;
        public static final int PermissionError = -4;
        public static final int Processing = -5;
        public static final int WriteCancel = -2;
        public static final int WriteFailed = -1;
        public static final int WriteSuccess = 0;
    }
}
