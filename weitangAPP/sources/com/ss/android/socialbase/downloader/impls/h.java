package com.ss.android.socialbase.downloader.impls;

import android.net.Uri;
import android.text.TextUtils;
import anet.channel.util.HttpConstant;
import com.ss.android.socialbase.downloader.network.IDownloadHttpService;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.zip.GZIPInputStream;
import okhttp3.Call;
import okhttp3.Dns;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

/* JADX INFO: loaded from: classes2.dex */
public class h implements IDownloadHttpService {
    private final com.ss.android.socialbase.downloader.q.p<String, OkHttpClient> ok = new com.ss.android.socialbase.downloader.q.p<>(4, 8);

    private OkHttpClient ok(String str, final String str2) {
        try {
            final String host = Uri.parse(str).getHost();
            if (!TextUtils.isEmpty(host) && !TextUtils.isEmpty(str2)) {
                String str3 = host + "_" + str2;
                synchronized (this.ok) {
                    OkHttpClient okHttpClient = this.ok.get(str3);
                    if (okHttpClient != null) {
                        return okHttpClient;
                    }
                    OkHttpClient.Builder builderIo = com.ss.android.socialbase.downloader.downloader.bl.io();
                    builderIo.dns(new Dns() { // from class: com.ss.android.socialbase.downloader.impls.h.2
                    });
                    OkHttpClient okHttpClientBuild = builderIo.build();
                    synchronized (this.ok) {
                        this.ok.put(str3, okHttpClientBuild);
                    }
                    return okHttpClientBuild;
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return com.ss.android.socialbase.downloader.downloader.bl.zz();
    }

    @Override // com.ss.android.socialbase.downloader.network.IDownloadHttpService
    public com.ss.android.socialbase.downloader.network.q downloadWithConnection(int i2, String str, List<com.ss.android.socialbase.downloader.model.bl> list) throws IOException {
        String strA;
        Request.Builder builderUrl = new Request.Builder().url(str);
        if (list == null || list.size() <= 0) {
            strA = null;
        } else {
            strA = null;
            for (com.ss.android.socialbase.downloader.model.bl blVar : list) {
                String strOk = blVar.ok();
                if (strA == null && "ss_d_request_host_ip_114".equals(strOk)) {
                    strA = blVar.a();
                } else {
                    builderUrl.addHeader(strOk, com.ss.android.socialbase.downloader.q.kf.h(blVar.a()));
                }
            }
        }
        OkHttpClient okHttpClientOk = !TextUtils.isEmpty(strA) ? ok(str, strA) : com.ss.android.socialbase.downloader.downloader.bl.zz();
        if (okHttpClientOk == null) {
            throw new IOException("can't get httpClient");
        }
        final Call callNewCall = okHttpClientOk.newCall(builderUrl.build());
        final Response responseExecute = callNewCall.execute();
        if (responseExecute == null) {
            throw new IOException("can't get response");
        }
        final ResponseBody responseBodyBody = responseExecute.body();
        if (responseBodyBody == null) {
            return null;
        }
        InputStream inputStreamByteStream = responseBodyBody.byteStream();
        String strHeader = responseExecute.header("Content-Encoding");
        final InputStream gZIPInputStream = (strHeader == null || !HttpConstant.GZIP.equalsIgnoreCase(strHeader) || (inputStreamByteStream instanceof GZIPInputStream)) ? inputStreamByteStream : new GZIPInputStream(inputStreamByteStream);
        return new com.ss.android.socialbase.downloader.network.n() { // from class: com.ss.android.socialbase.downloader.impls.h.1
            @Override // com.ss.android.socialbase.downloader.network.h
            public int a() throws IOException {
                return responseExecute.code();
            }

            @Override // com.ss.android.socialbase.downloader.network.h
            public void bl() {
                Call call = callNewCall;
                if (call == null || call.isCanceled()) {
                    return;
                }
                callNewCall.cancel();
            }

            @Override // com.ss.android.socialbase.downloader.network.ok
            public String n() {
                return "";
            }

            @Override // com.ss.android.socialbase.downloader.network.q
            public InputStream ok() throws IOException {
                return gZIPInputStream;
            }

            @Override // com.ss.android.socialbase.downloader.network.q
            public void s() {
                try {
                    ResponseBody responseBody = responseBodyBody;
                    if (responseBody != null) {
                        responseBody.close();
                    }
                    Call call = callNewCall;
                    if (call == null || call.isCanceled()) {
                        return;
                    }
                    callNewCall.cancel();
                } catch (Throwable unused) {
                }
            }

            @Override // com.ss.android.socialbase.downloader.network.h
            public String ok(String str2) {
                return responseExecute.header(str2);
            }
        };
    }
}
