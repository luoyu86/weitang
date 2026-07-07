package org.android.spdy;

import android.content.Context;
import com.alipay.sdk.m.n.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import javax.mail.UIDFolder;

/* JADX INFO: loaded from: classes2.dex */
public final class SpdyAgent {
    public static final int ACCS_ONLINE_SERVER = 1;
    public static final int ACCS_TEST_SERVER = 0;
    private static final boolean HAVE_CLOSE = false;
    private static final int KB32 = 32768;
    private static final int KB8 = 8192;
    private static final int MAX_SPDY_SESSION_COUNT = 50;
    private static final int MB5 = 5242880;
    public static final int MODE_QUIC = 256;
    public static final int SPDY_CUSTOM_CONTROL_FRAME_RECV = 4106;
    public static final int SPDY_DATA_CHUNK_RECV = 4097;
    public static final int SPDY_DATA_RECV = 4098;
    public static final int SPDY_DATA_SEND = 4099;
    public static final int SPDY_PING_RECV = 4101;
    public static final int SPDY_REQUEST_RECV = 4102;
    public static final int SPDY_SESSION_CLOSE = 4103;
    public static final int SPDY_SESSION_CREATE = 4096;
    public static final int SPDY_SESSION_FAILED_ERROR = 4105;
    public static final int SPDY_STREAM_CLOSE = 4100;
    public static final int SPDY_STREAM_RESPONSE_RECV = 4104;
    private static final String TNET_SO_VERSION = "tnet-3.1.14";
    private static Object domainHashLock = null;
    private static HashMap<String, Integer> domainHashMap = null;
    public static volatile boolean enableDebug = false;
    public static volatile boolean enableTimeGaurd = false;
    private static volatile SpdyAgent gSingleInstance;
    private static volatile boolean loadSucc;
    private static Object lock;
    private static final Lock r;
    private static final ReentrantReadWriteLock rwLock;
    private static int totalDomain;
    private static final Lock w;
    private AccsSSLCallback accsSSLCallback;
    private long agentNativePtr;
    private HashMap<String, SpdySession> sessionMgr = new HashMap<>(5);
    private LinkedList<SpdySession> sessionQueue = new LinkedList<>();
    private AtomicBoolean closed = new AtomicBoolean();
    private String proxyUsername = null;
    private String proxyPassword = null;

    static {
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        rwLock = reentrantReadWriteLock;
        r = reentrantReadWriteLock.readLock();
        w = reentrantReadWriteLock.writeLock();
        loadSucc = false;
        gSingleInstance = null;
        lock = new Object();
        domainHashLock = new Object();
        domainHashMap = new HashMap<>();
        totalDomain = 0;
    }

    private SpdyAgent(Context context, SpdyVersion spdyVersion, SpdySessionKind spdySessionKind, AccsSSLCallback accsSSLCallback) throws UnsatisfiedLinkError {
        try {
            SoInstallMgrSdk.init(context);
            loadSucc = SoInstallMgrSdk.initSo(TNET_SO_VERSION, 1);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        try {
            this.agentNativePtr = initAgent(spdyVersion.getInt(), spdySessionKind.getint(), SslVersion.SLIGHT_VERSION_V1.getint());
            this.accsSSLCallback = accsSSLCallback;
        } catch (UnsatisfiedLinkError e2) {
            e2.printStackTrace();
        }
        this.closed.set(false);
    }

    public static void InvlidCharJudge(byte[] bArr, byte[] bArr2) {
        for (int i2 = 0; i2 < bArr.length; i2++) {
            if ((bArr[i2] & 255) < 32 || (bArr[i2] & 255) > 126) {
                bArr[i2] = 63;
            }
        }
        for (int i3 = 0; i3 < bArr2.length; i3++) {
            if ((bArr2[i3] & 255) < 32 || (bArr2[i3] & 255) > 126) {
                bArr2[i3] = 63;
            }
        }
    }

    private void agentIsOpen() {
        if (this.closed.get()) {
            throw new SpdyErrorException("SPDY_JNI_ERR_ASYNC_CLOSE", TnetStatusCode.TNET_JNI_ERR_ASYNC_CLOSE);
        }
        checkLoadSo();
    }

    private void bioPingRecvCallback(SpdySession spdySession, int i2) {
        spduLog.Logi("tnet-jni", "[bioPingRecvCallback] - ");
        if (spdySession == null) {
            spduLog.Logi("tnet-jni", "[bioPingRecvCallback] - session is null");
            return;
        }
        Intenalcb intenalcb = spdySession.intenalcb;
        if (intenalcb == null) {
            spduLog.Logi("tnet-jni", "[bioPingRecvCallback] - session.intenalcb is null");
        } else {
            intenalcb.bioPingRecvCallback(spdySession, i2);
        }
    }

    private void checkLoadSo() throws SpdyErrorException {
        if (loadSucc) {
            return;
        }
        try {
        } catch (Throwable th) {
            th.printStackTrace();
        }
        synchronized (lock) {
            if (loadSucc) {
                return;
            }
            loadSucc = SoInstallMgrSdk.initSo(TNET_SO_VERSION, 1);
            this.agentNativePtr = initAgent(0, 0, 0);
            if (!loadSucc) {
                throw new SpdyErrorException("TNET_JNI_ERR_LOAD_SO_FAIL", TnetStatusCode.TNET_JNI_ERR_LOAD_SO_FAIL);
            }
        }
    }

    public static boolean checkLoadSucc() {
        return loadSucc;
    }

    private native int closeSessionN(long j);

    public static int configIpStackMode(int i2) {
        spduLog.Logi("tnet-jni", "[configIpStackMode] - " + i2);
        return configIpStackModeN(i2);
    }

    private static native int configIpStackModeN(int i2);

    private native int configLogFileN(String str, int i2, int i3);

    private native int configLogFileN(String str, int i2, int i3, int i4);

    private static void crashReporter(int i2) {
    }

    private native long createSessionN(long j, SpdySession spdySession, int i2, byte[] bArr, char c2, byte[] bArr2, char c3, byte[] bArr3, byte[] bArr4, Object obj, int i3, int i4, int i5, byte[] bArr5);

    public static byte[] dataproviderToByteArray(SpdyRequest spdyRequest, SpdyDataProvider spdyDataProvider) {
        headJudge(spdyRequest.getHeaders());
        if (spdyDataProvider == null) {
            return null;
        }
        String strMapBodyToString = mapBodyToString(spdyDataProvider.postBody);
        byte[] bytes = strMapBodyToString != null ? strMapBodyToString.getBytes() : spdyDataProvider.data;
        if (bytes == null || bytes.length < 5242880) {
            return bytes;
        }
        throw new SpdyErrorException("SPDY_JNI_ERR_INVALID_PARAM:total=" + bytes.length, TnetStatusCode.TNET_JNI_ERR_INVLID_PARAM);
    }

    private native int freeAgent(long j);

    private int getDomainHashIndex(String str) {
        Integer numValueOf;
        synchronized (domainHashLock) {
            numValueOf = domainHashMap.get(str);
            if (numValueOf == null) {
                HashMap<String, Integer> map = domainHashMap;
                int i2 = totalDomain + 1;
                totalDomain = i2;
                map.put(str, Integer.valueOf(i2));
                numValueOf = Integer.valueOf(totalDomain);
            }
        }
        return numValueOf.intValue();
    }

    public static SpdyAgent getInstance(Context context, SpdyVersion spdyVersion, SpdySessionKind spdySessionKind) throws SpdyErrorException, UnsatisfiedLinkError {
        if (gSingleInstance == null) {
            synchronized (lock) {
                if (gSingleInstance == null) {
                    gSingleInstance = new SpdyAgent(context, spdyVersion, spdySessionKind, null);
                }
            }
        }
        return gSingleInstance;
    }

    private void getPerformance(SpdySession spdySession, SslPermData sslPermData) {
    }

    private byte[] getSSLMeta(SpdySession spdySession) {
        if (spdySession == null) {
            spduLog.Logi("tnet-jni", "[getSSLMeta] - session is null");
            return null;
        }
        Intenalcb intenalcb = spdySession.intenalcb;
        if (intenalcb != null) {
            return intenalcb.getSSLMeta(spdySession);
        }
        spduLog.Logi("tnet-jni", "[getSSLMeta] - session.intenalcb is null");
        return null;
    }

    private byte[] getSSLPublicKey(int i2, byte[] bArr) {
        AccsSSLCallback accsSSLCallback = this.accsSSLCallback;
        if (accsSSLCallback != null) {
            return accsSSLCallback.getSSLPublicKey(i2, bArr);
        }
        spduLog.Logd("tnet-jni", "[getSSLPublicKey] - accsSSLCallback is null.");
        return null;
    }

    private native long getSession(long j, byte[] bArr, char c2);

    public static void headJudge(Map<String, String> map) {
        if (map != null) {
            int length = 0;
            for (Map.Entry<String, String> entry : map.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                InvlidCharJudge(key.getBytes(), value.getBytes());
                length += key.length() + 1 + value.length();
                securityCheck(length, value.length());
            }
        }
    }

    private native long initAgent(int i2, int i3, int i4);

    @Deprecated
    public static void inspect(String str) {
    }

    private native void logFileCloseN();

    private native void logFileFlushN();

    public static String mapBodyToString(Map<String, String> map) {
        StringBuilder sb = new StringBuilder();
        if (map == null) {
            return null;
        }
        int length = 0;
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            sb.append(key);
            sb.append(a.f5521h);
            sb.append(value);
            sb.append('&');
            length += key.length() + 1 + value.length();
            tableListJudge(length);
        }
        if (sb.length() > 0) {
            sb.setLength(sb.length() - 1);
        }
        return sb.toString();
    }

    public static String[] mapToByteArray(Map<String, String> map) {
        if (map == null || map.size() <= 0) {
            return null;
        }
        String[] strArr = new String[map.size() * 2];
        int i2 = 0;
        for (Map.Entry<String, String> entry : map.entrySet()) {
            strArr[i2] = entry.getKey();
            strArr[i2 + 1] = entry.getValue();
            i2 += 2;
        }
        return strArr;
    }

    private int putSSLMeta(SpdySession spdySession, byte[] bArr) {
        if (spdySession == null) {
            spduLog.Logi("tnet-jni", "[putSSLMeta] - session is null");
            return -1;
        }
        Intenalcb intenalcb = spdySession.intenalcb;
        if (intenalcb != null) {
            return intenalcb.putSSLMeta(spdySession, bArr);
        }
        spduLog.Logi("tnet-jni", "[putSSLMeta] - session.intenalcb is null");
        return -1;
    }

    public static void securityCheck(int i2, int i3) {
        if (i2 >= 32768) {
            throw new SpdyErrorException("SPDY_JNI_ERR_INVALID_PARAM:total=" + i2, TnetStatusCode.TNET_JNI_ERR_INVLID_PARAM);
        }
        if (i3 < 8192) {
            return;
        }
        throw new SpdyErrorException("SPDY_JNI_ERR_INVALID_PARAM:value=" + i3, TnetStatusCode.TNET_JNI_ERR_INVLID_PARAM);
    }

    private native int setConTimeout(long j, int i2);

    private native int setSessionKind(long j, int i2);

    private void spdyCustomControlFrameFailCallback(SpdySession spdySession, Object obj, int i2, int i3) {
        spduLog.Logi("tnet-jni", "[spdyCustomControlFrameFailCallback] - ");
        if (spdySession == null) {
            spduLog.Logi("tnet-jni", "[spdyCustomControlFrameFailCallback] - session is null");
            return;
        }
        Intenalcb intenalcb = spdySession.intenalcb;
        if (intenalcb == null) {
            spduLog.Logi("tnet-jni", "[spdyCustomControlFrameFailCallback] - session.intenalcb is null");
        } else {
            intenalcb.spdyCustomControlFrameFailCallback(spdySession, obj, i2, i3);
        }
    }

    private void spdyCustomControlFrameRecvCallback(SpdySession spdySession, Object obj, int i2, int i3, int i4, int i5, byte[] bArr) {
        spduLog.Logi("tnet-jni", "[spdyCustomControlFrameRecvCallback] - ");
        if (spdySession == null) {
            spduLog.Logi("tnet-jni", "[spdyCustomControlFrameRecvCallback] - session is null");
            return;
        }
        Intenalcb intenalcb = spdySession.intenalcb;
        if (intenalcb == null) {
            spduLog.Logi("tnet-jni", "[spdyCustomControlFrameRecvCallback] - session.intenalcb is null");
        } else {
            intenalcb.spdyCustomControlFrameRecvCallback(spdySession, obj, i2, i3, i4, i5, bArr);
        }
    }

    private void spdyDataChunkRecvCB(SpdySession spdySession, boolean z, int i2, SpdyByteArray spdyByteArray, int i3) {
        spduLog.Logi("tnet-jni", "[spdyDataChunkRecvCB] - ");
        long j = ((long) i2) & UIDFolder.MAXUID;
        if (spdySession == null) {
            spduLog.Logi("tnet-jni", "[spdyDataChunkRecvCB] - session is null");
            return;
        }
        Intenalcb intenalcb = spdySession.intenalcb;
        if (intenalcb == null) {
            spduLog.Logi("tnet-jni", "[spdyDataChunkRecvCB] - session.intenalcb is null");
        } else {
            intenalcb.spdyDataChunkRecvCB(spdySession, z, j, spdyByteArray, i3);
        }
    }

    private void spdyDataRecvCallback(SpdySession spdySession, boolean z, int i2, int i3, int i4) {
        spduLog.Logi("tnet-jni", "[spdyDataRecvCallback] - ");
        long j = ((long) i2) & UIDFolder.MAXUID;
        if (spdySession == null) {
            spduLog.Logi("tnet-jni", "[spdyDataRecvCallback] - session is null");
            return;
        }
        Intenalcb intenalcb = spdySession.intenalcb;
        if (intenalcb == null) {
            spduLog.Logi("tnet-jni", "[spdyDataRecvCallback] - session.intenalcb is null");
        } else {
            intenalcb.spdyDataRecvCallback(spdySession, z, j, i3, i4);
        }
    }

    private void spdyDataSendCallback(SpdySession spdySession, boolean z, int i2, int i3, int i4) {
        long j = ((long) i2) & UIDFolder.MAXUID;
        if (spdySession == null) {
            spduLog.Logi("tnet-jni", "[spdyDataSendCallback] - session is null");
            return;
        }
        Intenalcb intenalcb = spdySession.intenalcb;
        if (intenalcb == null) {
            spduLog.Logi("tnet-jni", "[spdyDataSendCallback] - session.intenalcb is null");
        } else {
            intenalcb.spdyDataSendCallback(spdySession, z, j, i3, i4);
        }
    }

    private void spdyPingRecvCallback(SpdySession spdySession, int i2, Object obj) {
        spduLog.Logi("tnet-jni", "[spdyPingRecvCallback] - ");
        if (spdySession == null) {
            spduLog.Logi("tnet-jni", "[spdyPingRecvCallback] - session is null");
            return;
        }
        Intenalcb intenalcb = spdySession.intenalcb;
        if (intenalcb == null) {
            spduLog.Logi("tnet-jni", "[spdyPingRecvCallback] - session.intenalcb is null");
        } else {
            intenalcb.spdyPingRecvCallback(spdySession, i2, obj);
        }
    }

    private void spdyRequestRecvCallback(SpdySession spdySession, int i2, int i3) {
        long j = ((long) i2) & UIDFolder.MAXUID;
        if (spdySession == null) {
            spduLog.Logi("tnet-jni", "[spdyRequestRecvCallback] - session is null");
            return;
        }
        Intenalcb intenalcb = spdySession.intenalcb;
        if (intenalcb == null) {
            spduLog.Logi("tnet-jni", "[spdyRequestRecvCallback] - session.intenalcb is null");
        } else {
            intenalcb.spdyRequestRecvCallback(spdySession, j, i3);
        }
    }

    private void spdySessionCloseCallback(SpdySession spdySession, Object obj, SuperviseConnectInfo superviseConnectInfo, int i2) {
        spduLog.Logi("tnet-jni", "[spdySessionCloseCallback] - errorCode = " + i2);
        if (spdySession == null) {
            spduLog.Logi("tnet-jni", "[spdySessionCloseCallback] - session is null");
        } else {
            try {
                Intenalcb intenalcb = spdySession.intenalcb;
                if (intenalcb == null) {
                    spduLog.Logi("tnet-jni", "[spdySessionCloseCallback] - session.intenalcb is null");
                } else {
                    intenalcb.spdySessionCloseCallback(spdySession, obj, superviseConnectInfo, i2);
                }
            } finally {
                spdySession.cleanUp();
            }
        }
        spdySession.releasePptr();
    }

    private void spdySessionConnectCB(SpdySession spdySession, SuperviseConnectInfo superviseConnectInfo) {
        spduLog.Logi("tnet-jni", "[spdySessionConnectCB] - ");
        if (spdySession == null) {
            spduLog.Logi("tnet-jni", "[spdySessionConnectCB] - session is null");
            return;
        }
        Intenalcb intenalcb = spdySession.intenalcb;
        if (intenalcb == null) {
            spduLog.Logi("tnet-jni", "[spdySessionConnectCB] - session.intenalcb is null");
        } else {
            intenalcb.spdySessionConnectCB(spdySession, superviseConnectInfo);
        }
    }

    private void spdySessionFailedError(SpdySession spdySession, int i2, Object obj) {
        spduLog.Logi("tnet-jni", "[spdySessionFailedError] - ");
        if (spdySession == null) {
            spduLog.Logi("tnet-jni", "[spdySessionFailedError] - session is null");
        } else {
            try {
                Intenalcb intenalcb = spdySession.intenalcb;
                if (intenalcb == null) {
                    spduLog.Logi("tnet-jni", "[spdySessionFailedError] - session.intenalcb is null");
                } else {
                    intenalcb.spdySessionFailedError(spdySession, i2, obj);
                }
            } finally {
                spdySession.cleanUp();
            }
        }
        spdySession.releasePptr();
    }

    private void spdySessionOnWritable(SpdySession spdySession, Object obj, int i2) {
        spduLog.Logi("tnet-jni", "[spdySessionOnWritable] - ");
        if (spdySession == null) {
            spduLog.Logi("tnet-jni", "[spdySessionOnWritable] - session is null");
            return;
        }
        try {
            Intenalcb intenalcb = spdySession.intenalcb;
            if (intenalcb == null) {
                spduLog.Logi("tnet-jni", "[spdySessionOnWritable] - session.intenalcb is null");
            } else {
                intenalcb.spdySessionOnWritable(spdySession, obj, i2);
            }
        } catch (Throwable th) {
            spduLog.Loge("tnet-jni", "[spdySessionOnWritable] - exception:" + th);
        }
    }

    private void spdyStreamCloseCallback(SpdySession spdySession, int i2, int i3, int i4, SuperviseData superviseData) {
        spduLog.Logi("tnet-jni", "[spdyStreamCloseCallback] - ");
        long j = ((long) i2) & UIDFolder.MAXUID;
        if (spdySession == null) {
            spduLog.Logi("tnet-jni", "[spdyStreamCloseCallback] - session is null");
            return;
        }
        Intenalcb intenalcb = spdySession.intenalcb;
        if (intenalcb == null) {
            spduLog.Logi("tnet-jni", "[spdyStreamCloseCallback] - session.intenalcb is null");
        } else {
            intenalcb.spdyStreamCloseCallback(spdySession, j, i3, i4, superviseData);
        }
    }

    private void spdyStreamResponseRecv(SpdySession spdySession, int i2, String[] strArr, int i3) {
        spduLog.Logi("tnet-jni", "[spdyStreamResponseRecv] - ");
        Map<String, List<String>> mapStringArrayToMap = stringArrayToMap(strArr);
        long j = ((long) i2) & UIDFolder.MAXUID;
        if (spdySession == null) {
            spduLog.Logi("tnet-jni", "[spdyStreamResponseRecv] - session is null");
            return;
        }
        Intenalcb intenalcb = spdySession.intenalcb;
        if (intenalcb == null) {
            spduLog.Logi("tnet-jni", "[spdyStreamResponseRecv] - session.intenalcb is null");
        } else {
            intenalcb.spdyOnStreamResponse(spdySession, j, mapStringArrayToMap, i3);
        }
    }

    public static Map<String, List<String>> stringArrayToMap(String[] strArr) {
        if (strArr == null) {
            return null;
        }
        HashMap map = new HashMap(5);
        int i2 = 0;
        while (true) {
            int i3 = i2 + 2;
            if (i3 > strArr.length) {
                return map;
            }
            if (strArr[i2] == null) {
                break;
            }
            int i4 = i2 + 1;
            if (strArr[i4] == null) {
                break;
            }
            List arrayList = (List) map.get(strArr[i2]);
            if (arrayList == null) {
                arrayList = new ArrayList(1);
                map.put(strArr[i2], arrayList);
            }
            arrayList.add(strArr[i4]);
            i2 = i3;
        }
        return null;
    }

    public static void tableListJudge(int i2) {
        if (i2 < 5242880) {
            return;
        }
        throw new SpdyErrorException("SPDY_JNI_ERR_INVALID_PARAM:total=" + i2, TnetStatusCode.TNET_JNI_ERR_INVLID_PARAM);
    }

    public void clearSpdySession(String str, String str2, int i2) {
        if (str != null) {
            Lock lock2 = w;
            lock2.lock();
            try {
                this.sessionMgr.remove(str + str2 + i2);
                lock2.unlock();
            } catch (Throwable th) {
                try {
                    th.printStackTrace();
                } finally {
                    w.unlock();
                }
            }
        }
    }

    public void close() {
    }

    public int closeSession(long j) {
        return closeSessionN(j);
    }

    public int configLogFile(String str, int i2, int i3) {
        if (loadSucc) {
            return configLogFileN(str, i2, i3);
        }
        return -1;
    }

    @Deprecated
    public SpdySession createSession(String str, Object obj, SessionCb sessionCb, int i2) throws SpdyErrorException {
        return createSession(str, "", obj, sessionCb, null, i2, 0);
    }

    public HashMap<String, SpdySession> getAllSession() {
        return this.sessionMgr;
    }

    public void logFileClose() {
        if (loadSucc) {
            logFileFlushN();
            logFileCloseN();
        }
    }

    public void logFileFlush() {
        if (loadSucc) {
            logFileFlushN();
        }
    }

    public void removeSession(SpdySession spdySession) {
        Lock lock2 = w;
        lock2.lock();
        try {
            this.sessionQueue.remove(spdySession);
            lock2.unlock();
        } catch (Throwable th) {
            w.unlock();
            throw th;
        }
    }

    public void setAccsSslCallback(AccsSSLCallback accsSSLCallback) {
        spduLog.Logi("tnet-jni", "[setAccsSslCallback] - " + accsSSLCallback.getClass());
        this.accsSSLCallback = accsSSLCallback;
    }

    @Deprecated
    public int setConnectTimeOut(int i2) {
        agentIsOpen();
        try {
            return setConTimeout(this.agentNativePtr, i2);
        } catch (UnsatisfiedLinkError e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    public void setProxyUsernamePassword(String str, String str2) {
        this.proxyUsername = str;
        this.proxyPassword = str2;
    }

    @Deprecated
    public int setSessionKind(SpdySessionKind spdySessionKind) {
        agentIsOpen();
        try {
            return setSessionKind(this.agentNativePtr, spdySessionKind.getint());
        } catch (UnsatisfiedLinkError e2) {
            e2.printStackTrace();
            return -1;
        }
    }

    @Deprecated
    public SpdySession submitRequest(SpdyRequest spdyRequest, SpdyDataProvider spdyDataProvider, Object obj, Object obj2, Spdycb spdycb, SessionCb sessionCb, SslCertcb sslCertcb, int i2) throws SpdyErrorException {
        SpdySession spdySessionCreateSession = createSession(spdyRequest.getAuthority(), spdyRequest.getDomain(), obj, sessionCb, sslCertcb, i2, 0, spdyRequest.getConnectionTimeoutMs());
        spdySessionCreateSession.submitRequest(spdyRequest, spdyDataProvider, obj2, spdycb);
        return spdySessionCreateSession;
    }

    @Deprecated
    public void switchAccsServer(int i2) {
    }

    public int configLogFile(String str, int i2, int i3, int i4) {
        if (loadSucc) {
            return configLogFileN(str, i2, i3, i4);
        }
        return -1;
    }

    @Deprecated
    public SpdySession createSession(String str, String str2, Object obj, SessionCb sessionCb, int i2) throws SpdyErrorException {
        return createSession(str, str2, obj, sessionCb, null, i2, 0);
    }

    @Deprecated
    public SpdySession createSession(String str, Object obj, SessionCb sessionCb, SslCertcb sslCertcb, int i2) throws SpdyErrorException {
        return createSession(str, "", obj, sessionCb, sslCertcb, i2, 0);
    }

    @Deprecated
    public SpdySession submitRequest(SpdyRequest spdyRequest, SpdyDataProvider spdyDataProvider, Object obj, Object obj2, Spdycb spdycb, SessionCb sessionCb, SslCertcb sslCertcb, int i2, int i3) throws SpdyErrorException {
        SpdySession spdySessionCreateSession = createSession(spdyRequest.getAuthority(), spdyRequest.getDomain(), obj, sessionCb, sslCertcb, i2, i3, spdyRequest.getConnectionTimeoutMs());
        spdySessionCreateSession.submitRequest(spdyRequest, spdyDataProvider, obj2, spdycb);
        return spdySessionCreateSession;
    }

    public SpdySession createSession(SessionInfo sessionInfo) throws SpdyErrorException {
        return createSession(sessionInfo.getAuthority(), sessionInfo.getDomain(), sessionInfo.getSessonUserData(), sessionInfo.getSessionCb(), null, sessionInfo.getMode(), sessionInfo.getPubKeySeqNum(), sessionInfo.getConnectionTimeoutMs(), sessionInfo.getCertHost());
    }

    @Deprecated
    public SpdySession createSession(String str, String str2, Object obj, SessionCb sessionCb, SslCertcb sslCertcb, int i2, int i3) throws SpdyErrorException {
        return createSession(str, str2, obj, sessionCb, sslCertcb, i2, i3, -1);
    }

    public SpdySession submitRequest(SpdyRequest spdyRequest, SpdyDataProvider spdyDataProvider, Object obj, Object obj2, Spdycb spdycb, SessionCb sessionCb, int i2, int i3) throws SpdyErrorException {
        return submitRequest(spdyRequest, spdyDataProvider, obj, obj2, spdycb, sessionCb, null, i2, i3);
    }

    public SpdySession createSession(String str, String str2, Object obj, SessionCb sessionCb, SslCertcb sslCertcb, int i2, int i3, int i4) throws SpdyErrorException {
        return createSession(str, str2, obj, sessionCb, sslCertcb, i2, i3, i4, null);
    }

    @Deprecated
    public SpdySession submitRequest(SpdyRequest spdyRequest, SpdyDataProvider spdyDataProvider, Object obj, Object obj2, Spdycb spdycb, SessionCb sessionCb, int i2) throws SpdyErrorException {
        return submitRequest(spdyRequest, spdyDataProvider, obj, obj2, spdycb, sessionCb, (SslCertcb) null, i2);
    }

    @Deprecated
    public static SpdyAgent getInstance(Context context, SpdyVersion spdyVersion, SpdySessionKind spdySessionKind, AccsSSLCallback accsSSLCallback) throws SpdyErrorException, UnsatisfiedLinkError {
        if (gSingleInstance == null) {
            synchronized (lock) {
                if (gSingleInstance == null) {
                    gSingleInstance = new SpdyAgent(context, spdyVersion, spdySessionKind, accsSSLCallback);
                }
            }
        }
        return gSingleInstance;
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x0140  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public org.android.spdy.SpdySession createSession(java.lang.String r25, java.lang.String r26, java.lang.Object r27, org.android.spdy.SessionCb r28, org.android.spdy.SslCertcb r29, int r30, int r31, int r32, java.lang.String r33) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 518
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: org.android.spdy.SpdyAgent.createSession(java.lang.String, java.lang.String, java.lang.Object, org.android.spdy.SessionCb, org.android.spdy.SslCertcb, int, int, int, java.lang.String):org.android.spdy.SpdySession");
    }
}
