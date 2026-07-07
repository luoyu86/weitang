package com.ss.android.socialbase.downloader.impls;

import java.io.IOException;
import java.util.List;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/* JADX INFO: loaded from: classes2.dex */
public class kf implements com.ss.android.socialbase.downloader.network.p {
    @Override // com.ss.android.socialbase.downloader.network.p
    public com.ss.android.socialbase.downloader.network.h ok(String str, List<com.ss.android.socialbase.downloader.model.bl> list) throws IOException {
        OkHttpClient okHttpClientZz = com.ss.android.socialbase.downloader.downloader.bl.zz();
        if (okHttpClientZz == null) {
            throw new IOException("can't get httpClient");
        }
        Request.Builder builderHead = new Request.Builder().url(str).head();
        if (list != null && list.size() > 0) {
            for (com.ss.android.socialbase.downloader.model.bl blVar : list) {
                builderHead.addHeader(blVar.ok(), com.ss.android.socialbase.downloader.q.kf.h(blVar.a()));
            }
        }
        final Call callNewCall = okHttpClientZz.newCall(builderHead.build());
        final Response responseExecute = callNewCall.execute();
        if (responseExecute == null) {
            throw new IOException("can't get response");
        }
        if (com.ss.android.socialbase.downloader.q.ok.ok(2097152)) {
            responseExecute.close();
        }
        return new com.ss.android.socialbase.downloader.network.h() { // from class: com.ss.android.socialbase.downloader.impls.kf.1
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

            @Override // com.ss.android.socialbase.downloader.network.h
            public String ok(String str2) {
                return responseExecute.header(str2);
            }
        };
    }
}
