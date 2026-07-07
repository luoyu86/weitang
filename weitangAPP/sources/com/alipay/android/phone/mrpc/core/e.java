package com.alipay.android.phone.mrpc.core;

import org.apache.http.HttpResponse;
import org.apache.http.impl.client.DefaultRedirectHandler;
import org.apache.http.protocol.HttpContext;

/* JADX INFO: loaded from: classes.dex */
public final class e extends DefaultRedirectHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f5076a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ d f5077b;

    public e(d dVar) {
        this.f5077b = dVar;
    }

    @Override // org.apache.http.impl.client.DefaultRedirectHandler, org.apache.http.client.RedirectHandler
    public final boolean isRedirectRequested(HttpResponse httpResponse, HttpContext httpContext) {
        int statusCode;
        this.f5076a++;
        boolean zIsRedirectRequested = super.isRedirectRequested(httpResponse, httpContext);
        if (zIsRedirectRequested || this.f5076a >= 5 || !((statusCode = httpResponse.getStatusLine().getStatusCode()) == 301 || statusCode == 302)) {
            return zIsRedirectRequested;
        }
        return true;
    }
}
