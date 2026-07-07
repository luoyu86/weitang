package cn.admobiletop.adsuyi.a.n;

import android.webkit.WebView;
import android.webkit.WebViewClient;

/* JADX INFO: loaded from: classes.dex */
public class h extends WebViewClient {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ i f3475a;

    public h(i iVar) {
        this.f3475a = iVar;
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        super.onPageFinished(webView, str);
        this.f3475a.b(webView, str);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView webView, int i2, String str, String str2) {
        i iVar = this.f3475a;
        iVar.loadHtml(iVar.getEmptyUrl());
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        webView.loadUrl(str);
        return true;
    }
}
