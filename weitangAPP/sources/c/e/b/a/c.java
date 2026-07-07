package c.e.b.a;

import android.graphics.Bitmap;
import android.os.Build;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.chinavisionary.jslibrary.jsbridge.BridgeWebView;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class c extends WebViewClient {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public BridgeWebView f1249a;

    public c(BridgeWebView bridgeWebView) {
        this.f1249a = bridgeWebView;
    }

    public void a(WebView webView, String str) {
    }

    public boolean b(String str) {
        return false;
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) throws Throwable {
        super.onPageFinished(webView, str);
        c.e.b.b.a.d(getClass().getSimpleName(), "onPageFinished url = " + str);
        b.webViewLoadLocalJs(webView, "WebViewJavascriptBridge.js");
        if (this.f1249a.getStartupMessage() != null) {
            Iterator<f> it = this.f1249a.getStartupMessage().iterator();
            while (it.hasNext()) {
                this.f1249a.b(it.next());
            }
            this.f1249a.setStartupMessage(null);
        }
        a(webView, str);
    }

    @Override // android.webkit.WebViewClient
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        super.onPageStarted(webView, str, bitmap);
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        try {
            str = URLDecoder.decode(str, "UTF-8");
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
        }
        if (str.startsWith("yy://return/")) {
            this.f1249a.f(str);
            return true;
        }
        if (str.startsWith("yy://")) {
            this.f1249a.d();
            return true;
        }
        if (b(str)) {
            return true;
        }
        return super.shouldOverrideUrlLoading(webView, str);
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
        if (Build.VERSION.SDK_INT >= 24) {
            String string = webResourceRequest.getUrl().toString();
            try {
                string = URLDecoder.decode(string, "UTF-8");
            } catch (UnsupportedEncodingException e2) {
                e2.printStackTrace();
            }
            if (string.startsWith("yy://return/")) {
                this.f1249a.f(string);
                return true;
            }
            if (string.startsWith("yy://")) {
                this.f1249a.d();
                return true;
            }
            if (b(string)) {
                return true;
            }
            return super.shouldOverrideUrlLoading(webView, webResourceRequest);
        }
        return super.shouldOverrideUrlLoading(webView, webResourceRequest);
    }
}
