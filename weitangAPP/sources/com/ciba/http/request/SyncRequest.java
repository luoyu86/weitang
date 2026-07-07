package com.ciba.http.request;

import com.ciba.http.entity.Request;

/* JADX INFO: loaded from: classes2.dex */
public class SyncRequest extends BaseRequest {
    public SyncRequest(Request request) {
        super(request);
    }

    public String run() {
        return execute();
    }
}
