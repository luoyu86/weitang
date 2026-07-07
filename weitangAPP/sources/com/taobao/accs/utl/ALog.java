package com.taobao.accs.utl;

import anet.channel.util.ALog;
import com.alibaba.sdk.android.logger.ILog;
import com.alibaba.sdk.android.logger.LogLevel;

/* JADX INFO: loaded from: classes2.dex */
@Deprecated
public class ALog {
    private static final ILog LOG = AccsLogger.getLogger("DefaultLog");

    public enum Level {
        V,
        D,
        I,
        W,
        E,
        L
    }

    private static String buildLogMsg(String str, Object... objArr) {
        if (str == null && objArr == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        if (str != null) {
            sb.append(" ");
            sb.append(str);
        }
        if (objArr != null) {
            int i2 = 0;
            while (true) {
                int i3 = i2 + 1;
                if (i3 >= objArr.length) {
                    break;
                }
                sb.append(" ");
                sb.append(formatKv(objArr[i2], objArr[i3]));
                i2 = i3 + 1;
            }
            if (i2 == objArr.length - 1) {
                sb.append(" ");
                sb.append(objArr[i2]);
            }
        }
        return sb.toString();
    }

    public static void d(String str, String str2, Object... objArr) {
        LOG.d("[" + str + "]" + buildLogMsg(str2, objArr));
    }

    public static void e(String str, String str2, Object... objArr) {
        LOG.e("[" + str + "]" + buildLogMsg(str2, objArr));
    }

    private static String formatKv(Object obj, Object obj2) {
        StringBuilder sb = new StringBuilder();
        if (obj == null) {
            obj = "";
        }
        sb.append(obj);
        sb.append(":");
        if (obj2 == null) {
            obj2 = "";
        }
        sb.append(obj2);
        return sb.toString();
    }

    public static void i(String str, String str2, Object... objArr) {
        LOG.i("[" + str + "]" + buildLogMsg(str2, objArr));
    }

    @Deprecated
    public static void initALog(String str, int i2) {
    }

    @Deprecated
    public static boolean isPrintLog() {
        return true;
    }

    public static boolean isPrintLog(Level level) {
        return true;
    }

    @Deprecated
    private static boolean isTLogExist() {
        return false;
    }

    @Deprecated
    public static void setEnableTLog(boolean z) {
    }

    @Deprecated
    public static void setLogLevel(Level level) {
        LogLevel logLevel = LogLevel.ERROR;
        switch (b.f10474b[level.ordinal()]) {
            case 1:
            case 2:
                logLevel = LogLevel.DEBUG;
                break;
            case 3:
                logLevel = LogLevel.INFO;
                break;
            case 4:
                logLevel = LogLevel.WARN;
                break;
        }
        AccsLogger.setLevel(logLevel);
    }

    @Deprecated
    public static void setLogger(ALog.ILog iLog) {
        if (iLog != null) {
            AccsLogger.addILogger(new a(iLog));
        }
    }

    public static void setPrintLog(boolean z) {
        AccsLogger.enable(z);
    }

    @Deprecated
    public static void setUseTlog(boolean z) {
    }

    public static void v(String str, String str2, Object... objArr) {
        LOG.d("[" + str + "]" + buildLogMsg(str2, objArr));
    }

    public static void w(String str, String str2, Object... objArr) {
        LOG.w("[" + str + "]" + buildLogMsg(str2, objArr));
    }

    public static void e(String str, String str2, Throwable th, Object... objArr) {
        LOG.e("[" + str + "]" + buildLogMsg(str2, objArr), th);
    }

    public static void w(String str, String str2, Throwable th, Object... objArr) {
        LOG.w("[" + str + "]" + buildLogMsg(str2, objArr), th);
    }
}
