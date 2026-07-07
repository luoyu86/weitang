package anet.channel.session;

import android.os.Build;
import android.util.Pair;
import anet.channel.RequestCb;
import anet.channel.appmonitor.AppMonitor;
import anet.channel.bytes.ByteArray;
import anet.channel.bytes.a;
import anet.channel.request.Request;
import anet.channel.statist.ExceptionStatistic;
import anet.channel.status.NetworkStatusHelper;
import anet.channel.util.ALog;
import anet.channel.util.ErrorConstant;
import anet.channel.util.HttpConstant;
import anet.channel.util.StringUtils;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CancellationException;
import java.util.zip.GZIPInputStream;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;
import org.android.agoo.common.AgooConstants;

/* JADX INFO: loaded from: classes.dex */
public class b {

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f564a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public byte[] f565b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Map<String, List<String>> f566c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f567d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f568e;
    }

    private b() {
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x02ab A[Catch: all -> 0x028e, TryCatch #21 {all -> 0x028e, blocks: (B:12:0x0033, B:14:0x003d, B:22:0x00a3, B:24:0x00a8, B:26:0x00b1, B:28:0x00b7, B:30:0x0119, B:32:0x0123, B:34:0x0129, B:36:0x0132, B:96:0x0296, B:98:0x029c, B:100:0x02a3, B:102:0x02ab, B:104:0x02bf, B:103:0x02ba, B:43:0x0196, B:45:0x01ad, B:47:0x01cf, B:56:0x01e2, B:58:0x01fd, B:60:0x020b, B:61:0x0212, B:65:0x022f, B:68:0x0246, B:70:0x025f, B:63:0x0220, B:64:0x0227, B:129:0x033c, B:131:0x0367, B:140:0x03a4, B:142:0x03cf, B:112:0x02e0, B:120:0x0315, B:150:0x0409, B:158:0x0431, B:166:0x0457, B:174:0x047d), top: B:211:0x0033, inners: #27, #31, #32, #29 }] */
    /* JADX WARN: Removed duplicated region for block: B:103:0x02ba A[Catch: all -> 0x028e, TryCatch #21 {all -> 0x028e, blocks: (B:12:0x0033, B:14:0x003d, B:22:0x00a3, B:24:0x00a8, B:26:0x00b1, B:28:0x00b7, B:30:0x0119, B:32:0x0123, B:34:0x0129, B:36:0x0132, B:96:0x0296, B:98:0x029c, B:100:0x02a3, B:102:0x02ab, B:104:0x02bf, B:103:0x02ba, B:43:0x0196, B:45:0x01ad, B:47:0x01cf, B:56:0x01e2, B:58:0x01fd, B:60:0x020b, B:61:0x0212, B:65:0x022f, B:68:0x0246, B:70:0x025f, B:63:0x0220, B:64:0x0227, B:129:0x033c, B:131:0x0367, B:140:0x03a4, B:142:0x03cf, B:112:0x02e0, B:120:0x0315, B:150:0x0409, B:158:0x0431, B:166:0x0457, B:174:0x047d), top: B:211:0x0033, inners: #27, #31, #32, #29 }] */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0367 A[Catch: all -> 0x028e, TRY_LEAVE, TryCatch #21 {all -> 0x028e, blocks: (B:12:0x0033, B:14:0x003d, B:22:0x00a3, B:24:0x00a8, B:26:0x00b1, B:28:0x00b7, B:30:0x0119, B:32:0x0123, B:34:0x0129, B:36:0x0132, B:96:0x0296, B:98:0x029c, B:100:0x02a3, B:102:0x02ab, B:104:0x02bf, B:103:0x02ba, B:43:0x0196, B:45:0x01ad, B:47:0x01cf, B:56:0x01e2, B:58:0x01fd, B:60:0x020b, B:61:0x0212, B:65:0x022f, B:68:0x0246, B:70:0x025f, B:63:0x0220, B:64:0x0227, B:129:0x033c, B:131:0x0367, B:140:0x03a4, B:142:0x03cf, B:112:0x02e0, B:120:0x0315, B:150:0x0409, B:158:0x0431, B:166:0x0457, B:174:0x047d), top: B:211:0x0033, inners: #27, #31, #32, #29 }] */
    /* JADX WARN: Removed duplicated region for block: B:142:0x03cf A[Catch: all -> 0x028e, TRY_LEAVE, TryCatch #21 {all -> 0x028e, blocks: (B:12:0x0033, B:14:0x003d, B:22:0x00a3, B:24:0x00a8, B:26:0x00b1, B:28:0x00b7, B:30:0x0119, B:32:0x0123, B:34:0x0129, B:36:0x0132, B:96:0x0296, B:98:0x029c, B:100:0x02a3, B:102:0x02ab, B:104:0x02bf, B:103:0x02ba, B:43:0x0196, B:45:0x01ad, B:47:0x01cf, B:56:0x01e2, B:58:0x01fd, B:60:0x020b, B:61:0x0212, B:65:0x022f, B:68:0x0246, B:70:0x025f, B:63:0x0220, B:64:0x0227, B:129:0x033c, B:131:0x0367, B:140:0x03a4, B:142:0x03cf, B:112:0x02e0, B:120:0x0315, B:150:0x0409, B:158:0x0431, B:166:0x0457, B:174:0x047d), top: B:211:0x0033, inners: #27, #31, #32, #29 }] */
    /* JADX WARN: Removed duplicated region for block: B:207:0x038d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:209:0x02cd A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:213:0x03f5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x021e  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0220 A[Catch: Exception -> 0x0276, SSLException -> 0x0278, SSLHandshakeException -> 0x027b, all -> 0x028e, IOException -> 0x02dc, CancellationException -> 0x0311, ConnectException -> 0x0405, ConnectTimeoutException -> 0x042d, SocketTimeoutException -> 0x0453, UnknownHostException -> 0x0479, TryCatch #3 {Exception -> 0x0276, blocks: (B:36:0x0132, B:43:0x0196, B:45:0x01ad, B:47:0x01cf, B:56:0x01e2, B:58:0x01fd, B:60:0x020b, B:61:0x0212, B:65:0x022f, B:68:0x0246, B:70:0x025f, B:63:0x0220, B:64:0x0227), top: B:197:0x0132 }] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0246 A[Catch: Exception -> 0x0276, SSLException -> 0x0278, SSLHandshakeException -> 0x027b, all -> 0x028e, IOException -> 0x02dc, CancellationException -> 0x0311, ConnectException -> 0x0405, ConnectTimeoutException -> 0x042d, SocketTimeoutException -> 0x0453, UnknownHostException -> 0x0479, TRY_ENTER, TryCatch #3 {Exception -> 0x0276, blocks: (B:36:0x0132, B:43:0x0196, B:45:0x01ad, B:47:0x01cf, B:56:0x01e2, B:58:0x01fd, B:60:0x020b, B:61:0x0212, B:65:0x022f, B:68:0x0246, B:70:0x025f, B:63:0x0220, B:64:0x0227), top: B:197:0x0132 }] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x025f A[Catch: Exception -> 0x0276, SSLException -> 0x0278, SSLHandshakeException -> 0x027b, all -> 0x028e, IOException -> 0x02dc, CancellationException -> 0x0311, ConnectException -> 0x0405, ConnectTimeoutException -> 0x042d, SocketTimeoutException -> 0x0453, UnknownHostException -> 0x0479, TRY_LEAVE, TryCatch #3 {Exception -> 0x0276, blocks: (B:36:0x0132, B:43:0x0196, B:45:0x01ad, B:47:0x01cf, B:56:0x01e2, B:58:0x01fd, B:60:0x020b, B:61:0x0212, B:65:0x022f, B:68:0x0246, B:70:0x025f, B:63:0x0220, B:64:0x0227), top: B:197:0x0132 }] */
    /* JADX WARN: Removed duplicated region for block: B:98:0x029c A[Catch: all -> 0x028e, TryCatch #21 {all -> 0x028e, blocks: (B:12:0x0033, B:14:0x003d, B:22:0x00a3, B:24:0x00a8, B:26:0x00b1, B:28:0x00b7, B:30:0x0119, B:32:0x0123, B:34:0x0129, B:36:0x0132, B:96:0x0296, B:98:0x029c, B:100:0x02a3, B:102:0x02ab, B:104:0x02bf, B:103:0x02ba, B:43:0x0196, B:45:0x01ad, B:47:0x01cf, B:56:0x01e2, B:58:0x01fd, B:60:0x020b, B:61:0x0212, B:65:0x022f, B:68:0x0246, B:70:0x025f, B:63:0x0220, B:64:0x0227, B:129:0x033c, B:131:0x0367, B:140:0x03a4, B:142:0x03cf, B:112:0x02e0, B:120:0x0315, B:150:0x0409, B:158:0x0431, B:166:0x0457, B:174:0x047d), top: B:211:0x0033, inners: #27, #31, #32, #29 }] */
    /* JADX WARN: Removed duplicated region for block: B:99:0x02a1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static anet.channel.session.b.a a(anet.channel.request.Request r21, anet.channel.RequestCb r22) {
        /*
            Method dump skipped, instruction units count: 1230
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: anet.channel.session.b.a(anet.channel.request.Request, anet.channel.RequestCb):anet.channel.session.b$a");
    }

    private static void a(Request request, a aVar, RequestCb requestCb, int i2, Throwable th) {
        String errMsg = ErrorConstant.getErrMsg(i2);
        ALog.e("awcn.HttpConnector", "onException", request.getSeq(), "errorCode", Integer.valueOf(i2), "errMsg", errMsg, AgooConstants.OPEN_URL, request.getUrlString(), "host", request.getHost());
        if (aVar != null) {
            aVar.f564a = i2;
        }
        if (!request.f528a.isDone.get()) {
            request.f528a.statusCode = i2;
            request.f528a.msg = errMsg;
            request.f528a.rspEnd = System.currentTimeMillis();
            if (i2 != -204) {
                AppMonitor.getInstance().commitStat(new ExceptionStatistic(i2, errMsg, request.f528a, th));
            }
        }
        if (requestCb != null) {
            requestCb.onFinish(i2, errMsg, request.f528a);
        }
    }

    private static HttpURLConnection a(Request request) throws IOException {
        HttpURLConnection httpURLConnection;
        Pair<String, Integer> wifiProxy = NetworkStatusHelper.getWifiProxy();
        Proxy proxy = wifiProxy != null ? new Proxy(Proxy.Type.HTTP, new InetSocketAddress((String) wifiProxy.first, ((Integer) wifiProxy.second).intValue())) : null;
        anet.channel.util.g gVarA = anet.channel.util.g.a();
        if (NetworkStatusHelper.getStatus().isMobile() && gVarA != null) {
            proxy = gVarA.b();
        }
        URL url = request.getUrl();
        if (proxy != null) {
            httpURLConnection = (HttpURLConnection) url.openConnection(proxy);
        } else {
            httpURLConnection = (HttpURLConnection) url.openConnection();
        }
        httpURLConnection.setConnectTimeout(request.getConnectTimeout());
        httpURLConnection.setReadTimeout(request.getReadTimeout());
        httpURLConnection.setRequestMethod(request.getMethod());
        if (request.containsBody()) {
            httpURLConnection.setDoOutput(true);
        }
        Map<String, String> headers = request.getHeaders();
        for (Map.Entry<String, String> entry : headers.entrySet()) {
            httpURLConnection.addRequestProperty(entry.getKey(), entry.getValue());
        }
        String host = headers.get("Host");
        if (host == null) {
            host = request.getHost();
        }
        String strConcatString = request.getHttpUrl().containsNonDefaultPort() ? StringUtils.concatString(host, ":", String.valueOf(request.getHttpUrl().getPort())) : host;
        httpURLConnection.setRequestProperty("Host", strConcatString);
        if (NetworkStatusHelper.getApn().equals("cmwap")) {
            httpURLConnection.setRequestProperty(HttpConstant.X_ONLINE_HOST, strConcatString);
        }
        if (!headers.containsKey(HttpConstant.ACCEPT_ENCODING)) {
            httpURLConnection.setRequestProperty(HttpConstant.ACCEPT_ENCODING, HttpConstant.GZIP);
        }
        if (gVarA != null) {
            httpURLConnection.setRequestProperty("Authorization", gVarA.c());
        }
        if (url.getProtocol().equalsIgnoreCase("https")) {
            a(httpURLConnection, request, host);
        }
        httpURLConnection.setInstanceFollowRedirects(false);
        return httpURLConnection;
    }

    private static void a(HttpURLConnection httpURLConnection, Request request, String str) {
        if (Integer.parseInt(Build.VERSION.SDK) < 8) {
            ALog.e("awcn.HttpConnector", "supportHttps", "[supportHttps]Froyo 以下版本不支持https", new Object[0]);
            return;
        }
        HttpsURLConnection httpsURLConnection = (HttpsURLConnection) httpURLConnection;
        if (request.getSslSocketFactory() != null) {
            httpsURLConnection.setSSLSocketFactory(request.getSslSocketFactory());
        } else {
            SSLSocketFactory sSLSocketFactory = anet.channel.util.b.f714a;
            if (sSLSocketFactory != null) {
                httpsURLConnection.setSSLSocketFactory(sSLSocketFactory);
                if (ALog.isPrintLog(2)) {
                    ALog.i("awcn.HttpConnector", "HttpSslUtil", request.getSeq(), "SslSocketFactory", anet.channel.util.b.f714a);
                }
            }
        }
        if (request.getHostnameVerifier() != null) {
            httpsURLConnection.setHostnameVerifier(request.getHostnameVerifier());
            return;
        }
        HostnameVerifier hostnameVerifier = anet.channel.util.b.f715b;
        if (hostnameVerifier != null) {
            httpsURLConnection.setHostnameVerifier(hostnameVerifier);
            if (ALog.isPrintLog(2)) {
                ALog.i("awcn.HttpConnector", "HttpSslUtil", request.getSeq(), "HostnameVerifier", anet.channel.util.b.f715b);
                return;
            }
            return;
        }
        httpsURLConnection.setHostnameVerifier(new c(str));
    }

    private static int a(HttpURLConnection httpURLConnection, Request request) {
        int i2 = 0;
        if (request.containsBody()) {
            OutputStream outputStream = null;
            try {
                try {
                    outputStream = httpURLConnection.getOutputStream();
                    int iPostBody = request.postBody(outputStream);
                    if (outputStream != null) {
                        try {
                            outputStream.flush();
                            outputStream.close();
                        } catch (IOException e2) {
                            ALog.e("awcn.HttpConnector", "postData", request.getSeq(), e2, new Object[0]);
                        }
                    }
                    i2 = iPostBody;
                } catch (Throwable th) {
                    if (outputStream != null) {
                        try {
                            outputStream.flush();
                            outputStream.close();
                        } catch (IOException e3) {
                            ALog.e("awcn.HttpConnector", "postData", request.getSeq(), e3, new Object[0]);
                        }
                    }
                    throw th;
                }
            } catch (Exception e4) {
                ALog.e("awcn.HttpConnector", "postData error", request.getSeq(), e4, new Object[0]);
                if (outputStream != null) {
                    try {
                        outputStream.flush();
                        outputStream.close();
                    } catch (IOException e5) {
                        ALog.e("awcn.HttpConnector", "postData", request.getSeq(), e5, new Object[0]);
                    }
                }
            }
            long j = i2;
            request.f528a.reqBodyInflateSize = j;
            request.f528a.reqBodyDeflateSize = j;
            request.f528a.sendDataSize = j;
        }
        return i2;
    }

    private static void a(HttpURLConnection httpURLConnection, Request request, a aVar, RequestCb requestCb) throws Throwable {
        InputStream errorStream;
        ByteArrayOutputStream byteArrayOutputStream;
        anet.channel.util.a aVar2;
        httpURLConnection.getURL().toString();
        anet.channel.util.a aVar3 = null;
        try {
            errorStream = httpURLConnection.getInputStream();
        } catch (IOException e2) {
            if (e2 instanceof FileNotFoundException) {
                ALog.w("awcn.HttpConnector", "File not found", request.getSeq(), AgooConstants.OPEN_URL, request.getUrlString());
            }
            try {
                errorStream = httpURLConnection.getErrorStream();
            } catch (Exception e3) {
                ALog.e("awcn.HttpConnector", "get error stream failed.", request.getSeq(), e3, new Object[0]);
                errorStream = null;
            }
        }
        if (errorStream == null) {
            a(request, aVar, requestCb, ErrorConstant.ERROR_IO_EXCEPTION, null);
            return;
        }
        if (requestCb == null) {
            int i2 = aVar.f567d;
            if (i2 <= 0) {
                i2 = 1024;
            } else if (aVar.f568e) {
                i2 *= 2;
            }
            byteArrayOutputStream = new ByteArrayOutputStream(i2);
        } else {
            byteArrayOutputStream = null;
        }
        try {
            aVar2 = new anet.channel.util.a(errorStream);
        } catch (Throwable th) {
            th = th;
        }
        try {
            InputStream gZIPInputStream = aVar.f568e ? new GZIPInputStream(aVar2) : aVar2;
            ByteArray byteArrayA = null;
            while (!Thread.currentThread().isInterrupted()) {
                if (byteArrayA == null) {
                    byteArrayA = a.C0006a.f385a.a(2048);
                }
                int from = byteArrayA.readFrom(gZIPInputStream);
                if (from != -1) {
                    if (byteArrayOutputStream != null) {
                        byteArrayA.writeTo(byteArrayOutputStream);
                    } else {
                        requestCb.onDataReceive(byteArrayA, false);
                        byteArrayA = null;
                    }
                    long j = from;
                    request.f528a.recDataSize += j;
                    request.f528a.rspBodyInflateSize += j;
                } else {
                    if (byteArrayOutputStream != null) {
                        byteArrayA.recycle();
                    } else {
                        requestCb.onDataReceive(byteArrayA, true);
                    }
                    if (byteArrayOutputStream != null) {
                        aVar.f565b = byteArrayOutputStream.toByteArray();
                    }
                    request.f528a.recDataTime = System.currentTimeMillis() - request.f528a.rspStart;
                    request.f528a.rspBodyDeflateSize = aVar2.a();
                    try {
                        gZIPInputStream.close();
                        return;
                    } catch (IOException unused) {
                        return;
                    }
                }
            }
            throw new CancellationException("task cancelled");
        } catch (Throwable th2) {
            th = th2;
            aVar3 = aVar2;
            request.f528a.recDataTime = System.currentTimeMillis() - request.f528a.rspStart;
            request.f528a.rspBodyDeflateSize = aVar3.a();
            try {
                errorStream.close();
            } catch (IOException unused2) {
            }
            throw th;
        }
    }
}
