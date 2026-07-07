package com.tianmu.danikula.videocache;

import android.text.TextUtils;
import android.util.Log;
import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import com.alipay.sdk.m.u.i;
import com.tianmu.danikula.videocache.headers.EmptyHeadersInjector;
import com.tianmu.danikula.videocache.headers.HeaderInjector;
import com.tianmu.danikula.videocache.sourcestorage.SourceInfoStorage;
import com.tianmu.danikula.videocache.sourcestorage.SourceInfoStorageFactory;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class HttpUrlSource implements Source {
    private static final int MAX_REDIRECTS = 5;
    private static final String TAG = "HttpUrlSource";
    private HttpURLConnection connection;
    private final HeaderInjector headerInjector;
    private InputStream inputStream;
    private SourceInfo sourceInfo;
    private final SourceInfoStorage sourceInfoStorage;

    public HttpUrlSource(String str) {
        this(str, SourceInfoStorageFactory.newEmptySourceInfoStorage());
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0090  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void fetchContentInfo() throws java.lang.Throwable {
        /*
            r9 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Read content info from "
            r0.append(r1)
            com.tianmu.danikula.videocache.SourceInfo r1 = r9.sourceInfo
            java.lang.String r1 = r1.url
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "HttpUrlSource"
            android.util.Log.i(r1, r0)
            r2 = 0
            r0 = 10000(0x2710, float:1.4013E-41)
            r4 = 0
            java.net.HttpURLConnection r0 = r9.openConnection(r2, r0)     // Catch: java.lang.Throwable -> L64 java.io.IOException -> L67
            long r2 = r9.getContentLength(r0)     // Catch: java.lang.Throwable -> L5b java.io.IOException -> L60
            java.lang.String r5 = r0.getContentType()     // Catch: java.lang.Throwable -> L5b java.io.IOException -> L60
            java.io.InputStream r4 = r0.getInputStream()     // Catch: java.lang.Throwable -> L5b java.io.IOException -> L60
            com.tianmu.danikula.videocache.SourceInfo r6 = new com.tianmu.danikula.videocache.SourceInfo     // Catch: java.lang.Throwable -> L5b java.io.IOException -> L60
            com.tianmu.danikula.videocache.SourceInfo r7 = r9.sourceInfo     // Catch: java.lang.Throwable -> L5b java.io.IOException -> L60
            java.lang.String r7 = r7.url     // Catch: java.lang.Throwable -> L5b java.io.IOException -> L60
            r6.<init>(r7, r2, r5)     // Catch: java.lang.Throwable -> L5b java.io.IOException -> L60
            r9.sourceInfo = r6     // Catch: java.lang.Throwable -> L5b java.io.IOException -> L60
            com.tianmu.danikula.videocache.sourcestorage.SourceInfoStorage r2 = r9.sourceInfoStorage     // Catch: java.lang.Throwable -> L5b java.io.IOException -> L60
            java.lang.String r3 = r6.url     // Catch: java.lang.Throwable -> L5b java.io.IOException -> L60
            r2.put(r3, r6)     // Catch: java.lang.Throwable -> L5b java.io.IOException -> L60
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L5b java.io.IOException -> L60
            r2.<init>()     // Catch: java.lang.Throwable -> L5b java.io.IOException -> L60
            java.lang.String r3 = "Source info fetched: "
            r2.append(r3)     // Catch: java.lang.Throwable -> L5b java.io.IOException -> L60
            com.tianmu.danikula.videocache.SourceInfo r3 = r9.sourceInfo     // Catch: java.lang.Throwable -> L5b java.io.IOException -> L60
            r2.append(r3)     // Catch: java.lang.Throwable -> L5b java.io.IOException -> L60
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Throwable -> L5b java.io.IOException -> L60
            android.util.Log.i(r1, r2)     // Catch: java.lang.Throwable -> L5b java.io.IOException -> L60
            com.tianmu.danikula.videocache.ProxyCacheUtils.close(r4)
            goto L86
        L5b:
            r1 = move-exception
            r8 = r4
            r4 = r0
            r0 = r8
            goto L8b
        L60:
            r8 = r4
            r4 = r0
            r0 = r8
            goto L68
        L64:
            r1 = move-exception
            r0 = r4
            goto L8b
        L67:
            r0 = r4
        L68:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L8a
            r2.<init>()     // Catch: java.lang.Throwable -> L8a
            java.lang.String r3 = "Error fetching info from "
            r2.append(r3)     // Catch: java.lang.Throwable -> L8a
            com.tianmu.danikula.videocache.SourceInfo r3 = r9.sourceInfo     // Catch: java.lang.Throwable -> L8a
            java.lang.String r3 = r3.url     // Catch: java.lang.Throwable -> L8a
            r2.append(r3)     // Catch: java.lang.Throwable -> L8a
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Throwable -> L8a
            android.util.Log.i(r1, r2)     // Catch: java.lang.Throwable -> L8a
            com.tianmu.danikula.videocache.ProxyCacheUtils.close(r0)
            if (r4 == 0) goto L89
            r0 = r4
        L86:
            r0.disconnect()
        L89:
            return
        L8a:
            r1 = move-exception
        L8b:
            com.tianmu.danikula.videocache.ProxyCacheUtils.close(r0)
            if (r4 == 0) goto L93
            r4.disconnect()
        L93:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tianmu.danikula.videocache.HttpUrlSource.fetchContentInfo():void");
    }

    private long getContentLength(HttpURLConnection httpURLConnection) {
        String headerField = httpURLConnection.getHeaderField("Content-Length");
        if (headerField == null) {
            return -1L;
        }
        return Long.parseLong(headerField);
    }

    private void injectCustomHeaders(HttpURLConnection httpURLConnection, String str) {
        for (Map.Entry<String, String> entry : this.headerInjector.addHeaders(str).entrySet()) {
            httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
        }
    }

    private HttpURLConnection openConnection(long j, int i2) throws ProxyCacheException, IOException {
        String str;
        HttpURLConnection httpURLConnection;
        boolean z;
        String headerField = this.sourceInfo.url;
        int i3 = 0;
        do {
            StringBuilder sb = new StringBuilder();
            sb.append("Open connection ");
            if (j > 0) {
                str = " with offset " + j;
            } else {
                str = "";
            }
            sb.append(str);
            sb.append(" to ");
            sb.append(headerField);
            Log.i(TAG, sb.toString());
            httpURLConnection = (HttpURLConnection) new URL(headerField).openConnection();
            injectCustomHeaders(httpURLConnection, headerField);
            if (j > 0) {
                httpURLConnection.setRequestProperty(HttpHeaders.RANGE, "bytes=" + j + "-");
            }
            if (i2 > 0) {
                httpURLConnection.setConnectTimeout(i2);
                httpURLConnection.setReadTimeout(i2);
            }
            int responseCode = httpURLConnection.getResponseCode();
            z = responseCode == 301 || responseCode == 302 || responseCode == 303;
            if (z) {
                headerField = httpURLConnection.getHeaderField("Location");
                i3++;
                httpURLConnection.disconnect();
            }
            if (i3 > 5) {
                throw new ProxyCacheException("Too many redirects: " + i3);
            }
        } while (z);
        return httpURLConnection;
    }

    private long readSourceAvailableBytes(HttpURLConnection httpURLConnection, long j, int i2) {
        long contentLength = getContentLength(httpURLConnection);
        return i2 == 200 ? contentLength : i2 == 206 ? contentLength + j : this.sourceInfo.length;
    }

    @Override // com.tianmu.danikula.videocache.Source
    public void close() {
        HttpURLConnection httpURLConnection = this.connection;
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
            } catch (ArrayIndexOutOfBoundsException unused) {
                Log.i(TAG, "HttpUrlSource Error closing connection correctly. Should happen only on Android L. If anybody know how to fix it, please visit https://github.com/danikula/AndroidVideoCache/issues/88. Until good solution is not know, just ignore this issue :(");
            } catch (IllegalArgumentException e2) {
                e = e2;
                throw new RuntimeException("Wait... but why? WTF!? Really shouldn't happen any more after fixing https://github.com/danikula/AndroidVideoCache/issues/43. If you read it on your device log, please, notify me danikula@gmail.com or create issue here https://github.com/danikula/AndroidVideoCache/issues.", e);
            } catch (NullPointerException e3) {
                e = e3;
                throw new RuntimeException("Wait... but why? WTF!? Really shouldn't happen any more after fixing https://github.com/danikula/AndroidVideoCache/issues/43. If you read it on your device log, please, notify me danikula@gmail.com or create issue here https://github.com/danikula/AndroidVideoCache/issues.", e);
            }
        }
    }

    public synchronized String getMime() {
        if (TextUtils.isEmpty(this.sourceInfo.mime)) {
            fetchContentInfo();
        }
        return this.sourceInfo.mime;
    }

    public String getUrl() {
        return this.sourceInfo.url;
    }

    @Override // com.tianmu.danikula.videocache.Source
    public synchronized long length() {
        if (this.sourceInfo.length == -2147483648L) {
            fetchContentInfo();
        }
        return this.sourceInfo.length;
    }

    @Override // com.tianmu.danikula.videocache.Source
    public void open(long j) throws ProxyCacheException {
        try {
            HttpURLConnection httpURLConnectionOpenConnection = openConnection(j, -1);
            this.connection = httpURLConnectionOpenConnection;
            String contentType = httpURLConnectionOpenConnection.getContentType();
            this.inputStream = new BufferedInputStream(this.connection.getInputStream(), 8192);
            HttpURLConnection httpURLConnection = this.connection;
            SourceInfo sourceInfo = new SourceInfo(this.sourceInfo.url, readSourceAvailableBytes(httpURLConnection, j, httpURLConnection.getResponseCode()), contentType);
            this.sourceInfo = sourceInfo;
            this.sourceInfoStorage.put(sourceInfo.url, sourceInfo);
        } catch (IOException e2) {
            throw new ProxyCacheException("Error opening connection for " + this.sourceInfo.url + " with offset " + j, e2);
        }
    }

    @Override // com.tianmu.danikula.videocache.Source
    public int read(byte[] bArr) throws ProxyCacheException {
        InputStream inputStream = this.inputStream;
        if (inputStream == null) {
            throw new ProxyCacheException("Error reading data from " + this.sourceInfo.url + ": connection is absent!");
        }
        try {
            return inputStream.read(bArr, 0, bArr.length);
        } catch (InterruptedIOException e2) {
            throw new InterruptedProxyCacheException("Reading source " + this.sourceInfo.url + " is interrupted", e2);
        } catch (IOException e3) {
            throw new ProxyCacheException("Error reading data from " + this.sourceInfo.url, e3);
        }
    }

    public String toString() {
        return "HttpUrlSource{sourceInfo='" + this.sourceInfo + i.f5699d;
    }

    public HttpUrlSource(String str, SourceInfoStorage sourceInfoStorage) {
        this(str, sourceInfoStorage, new EmptyHeadersInjector());
    }

    public HttpUrlSource(String str, SourceInfoStorage sourceInfoStorage, HeaderInjector headerInjector) {
        this.sourceInfoStorage = (SourceInfoStorage) Preconditions.checkNotNull(sourceInfoStorage);
        this.headerInjector = (HeaderInjector) Preconditions.checkNotNull(headerInjector);
        SourceInfo sourceInfo = sourceInfoStorage.get(str);
        this.sourceInfo = sourceInfo == null ? new SourceInfo(str, -2147483648L, ProxyCacheUtils.getSupposablyMime(str)) : sourceInfo;
    }

    public HttpUrlSource(HttpUrlSource httpUrlSource) {
        this.sourceInfo = httpUrlSource.sourceInfo;
        this.sourceInfoStorage = httpUrlSource.sourceInfoStorage;
        this.headerInjector = httpUrlSource.headerInjector;
    }
}
