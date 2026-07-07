package com.alibaba.sdk.android.ams.common.logger;

import android.util.Log;
import com.alibaba.sdk.android.logger.ILogger;
import com.alibaba.sdk.android.logger.LogLevel;
import com.taobao.accs.utl.AccsLogger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class AmsLogger {
    public static final int DEBUG = 2;
    public static final int ERROR = 0;
    public static final int INFO = 1;
    public static volatile int log_level = 3;
    public String TAG;
    public static List<LoggerListener> listener = new ArrayList();
    private static final String IMPORTANT_LOG_TAG = "[MPS]";
    private static final AmsLogger importantLogger = getLogger(IMPORTANT_LOG_TAG);

    /* JADX INFO: renamed from: com.alibaba.sdk.android.ams.common.logger.AmsLogger$2, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f4596a;

        static {
            int[] iArr = new int[LogLevel.values().length];
            f4596a = iArr;
            try {
                iArr[LogLevel.ERROR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f4596a[LogLevel.WARN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f4596a[LogLevel.INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f4596a[LogLevel.DEBUG.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public static void addListener(final LoggerListener loggerListener) {
        listener.add(loggerListener);
        AccsLogger.addILogger(new ILogger() { // from class: com.alibaba.sdk.android.ams.common.logger.AmsLogger.1
            @Override // com.alibaba.sdk.android.logger.ILogger
            public void print(LogLevel logLevel, String str, String str2) {
                int i2 = AnonymousClass2.f4596a[logLevel.ordinal()];
                if (i2 == 1) {
                    loggerListener.e(str, str2, null, 0);
                    return;
                }
                if (i2 == 2) {
                    loggerListener.w(str, str2, null, 0);
                } else if (i2 == 3) {
                    loggerListener.i(str, str2, null, 0);
                } else {
                    if (i2 != 4) {
                        return;
                    }
                    loggerListener.d(str, str2, null, 0);
                }
            }
        });
    }

    public static void clearListeners() {
        listener.clear();
    }

    public static AmsLogger getImportantLogger() {
        return importantLogger;
    }

    public static AmsLogger getLogger(String str) {
        AmsLogger amsLogger = new AmsLogger();
        amsLogger.TAG = str;
        return amsLogger;
    }

    public void d(String str) {
        d(str, null, 0);
    }

    public void d(String str, Throwable th) {
        d(str, th, 0);
    }

    public void d(String str, Throwable th, int i2) {
        if (log_level >= 2) {
            String str2 = this.TAG;
            if (th == null) {
                Log.d(str2, str);
            } else {
                Log.d(str2, str, th);
            }
        }
        Iterator<LoggerListener> it = listener.iterator();
        while (it.hasNext()) {
            it.next().d(this.TAG, str, th, i2);
        }
    }

    public void e(String str) {
        e(str, null, 0);
    }

    public void e(String str, Throwable th) {
        e(str, th, 0);
    }

    public void e(String str, Throwable th, int i2) {
        if (log_level >= 0) {
            String str2 = this.TAG;
            if (th == null) {
                Log.e(str2, str);
            } else {
                Log.e(str2, str, th);
            }
        }
        Iterator<LoggerListener> it = listener.iterator();
        while (it.hasNext()) {
            it.next().e(this.TAG, str, th, i2);
        }
    }

    public void i(String str) {
        i(str, null, 0);
    }

    public void i(String str, Throwable th) {
        i(str, th, 0);
    }

    public void i(String str, Throwable th, int i2) {
        if (log_level >= 1) {
            String str2 = this.TAG;
            if (th == null) {
                Log.i(str2, str);
            } else {
                Log.i(str2, str, th);
            }
        }
        Iterator<LoggerListener> it = listener.iterator();
        while (it.hasNext()) {
            it.next().i(this.TAG, str, th, i2);
        }
    }

    public void w(String str) {
        w(str, null, 0);
    }

    public void w(String str, Throwable th) {
        w(str, th, 0);
    }

    public void w(String str, Throwable th, int i2) {
        if (log_level >= 1) {
            String str2 = this.TAG;
            if (th == null) {
                Log.w(str2, str);
            } else if (str == null) {
                Log.w(str2, th);
            } else {
                Log.w(str2, str, th);
            }
        }
        Iterator<LoggerListener> it = listener.iterator();
        while (it.hasNext()) {
            it.next().w(this.TAG, str, th, i2);
        }
    }

    public void w(Throwable th) {
        w(null, th, 0);
    }
}
