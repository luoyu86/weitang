package com.alibaba.sdk.android.oss.network;

import com.alibaba.sdk.android.oss.callback.OSSProgressCallback;
import com.alibaba.sdk.android.oss.model.OSSRequest;
import f.c;
import f.e;
import f.h;
import f.l;
import f.t;
import java.io.IOException;
import okhttp3.MediaType;
import okhttp3.ResponseBody;

/* JADX INFO: loaded from: classes.dex */
public class ProgressTouchableResponseBody<T extends OSSRequest> extends ResponseBody {
    private e mBufferedSource;
    private OSSProgressCallback mProgressListener;
    private final ResponseBody mResponseBody;
    private T request;

    public ProgressTouchableResponseBody(ResponseBody responseBody, ExecutionContext executionContext) {
        this.mResponseBody = responseBody;
        this.mProgressListener = executionContext.getProgressCallback();
        this.request = (T) executionContext.getRequest();
    }

    @Override // okhttp3.ResponseBody
    public long contentLength() {
        return this.mResponseBody.contentLength();
    }

    @Override // okhttp3.ResponseBody
    public MediaType contentType() {
        return this.mResponseBody.contentType();
    }

    @Override // okhttp3.ResponseBody
    public e source() {
        if (this.mBufferedSource == null) {
            this.mBufferedSource = l.buffer(source(this.mResponseBody.source()));
        }
        return this.mBufferedSource;
    }

    private t source(t tVar) {
        return new h(tVar) { // from class: com.alibaba.sdk.android.oss.network.ProgressTouchableResponseBody.1
            private long totalBytesRead = 0;

            @Override // f.h, f.t
            public long read(c cVar, long j) throws IOException {
                long j2 = super.read(cVar, j);
                this.totalBytesRead += j2 != -1 ? j2 : 0L;
                if (ProgressTouchableResponseBody.this.mProgressListener != null && j2 != -1 && this.totalBytesRead != 0) {
                    ProgressTouchableResponseBody.this.mProgressListener.onProgress(ProgressTouchableResponseBody.this.request, this.totalBytesRead, ProgressTouchableResponseBody.this.mResponseBody.contentLength());
                }
                return j2;
            }
        };
    }
}
