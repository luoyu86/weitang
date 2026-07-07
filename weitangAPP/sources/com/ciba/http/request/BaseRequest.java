package com.ciba.http.request;

import android.text.TextUtils;
import com.ciba.http.entity.Request;
import java.io.Closeable;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public abstract class BaseRequest {
    private static final int REDIRECT_MAX_NUM = 5;
    public int errorCode;
    public String errorMessage;
    public boolean needResponseHeader;
    public Request request;
    public int resultCode;
    private int redirectNum = 0;
    public Map<String, List<String>> responseHeader = null;

    public BaseRequest(Request request) {
        this.request = request;
        if (request != null) {
            try {
                if (request.getHeaders() != null) {
                    String str = request.getHeaders().get("CIBA_RESPONSE_HEADER");
                    if (TextUtils.isEmpty(str)) {
                        return;
                    }
                    this.needResponseHeader = "1".equals(str);
                    request.getHeaders().remove("CIBA_RESPONSE_HEADER");
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    private void close(Closeable... closeableArr) {
        if (closeableArr == null || closeableArr.length <= 0) {
            return;
        }
        for (Closeable closeable : closeableArr) {
            if (closeable != null) {
                try {
                    closeable.close();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    private void failed(int i2, String str) {
        this.errorCode = i2;
        this.errorMessage = str;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:117:0x020b  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0222  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00fc A[Catch: all -> 0x0153, Exception -> 0x015b, TRY_ENTER, TRY_LEAVE, TryCatch #12 {Exception -> 0x015b, all -> 0x0153, blocks: (B:33:0x00c3, B:35:0x00cd, B:47:0x00fc), top: B:135:0x00c3 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String execute() throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 565
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ciba.http.request.BaseRequest.execute():java.lang.String");
    }
}
