package com.tianmu.biz.web;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.tianmu.c.n.m;

/* JADX INFO: loaded from: classes2.dex */
public class b extends WebViewClient {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private f f10934a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private BaseWebActivity f10935b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private AlertDialog f10936c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Handler f10937d = new Handler(Looper.getMainLooper());

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SslErrorHandler f10938a;

        public a(SslErrorHandler sslErrorHandler) {
            this.f10938a = sslErrorHandler;
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.a(this.f10938a);
        }
    }

    /* JADX INFO: renamed from: com.tianmu.biz.web.b$b, reason: collision with other inner class name */
    public class DialogInterfaceOnClickListenerC0187b implements DialogInterface.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SslErrorHandler f10940a;

        public DialogInterfaceOnClickListenerC0187b(b bVar, SslErrorHandler sslErrorHandler) {
            this.f10940a = sslErrorHandler;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            this.f10940a.cancel();
        }
    }

    public class c implements DialogInterface.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SslErrorHandler f10941a;

        public c(b bVar, SslErrorHandler sslErrorHandler) {
            this.f10941a = sslErrorHandler;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            this.f10941a.proceed();
        }
    }

    public class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f10942a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f10943b;

        public d(String str, boolean z) {
            this.f10942a = str;
            this.f10943b = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (b.this.f10934a != null) {
                b.this.f10934a.checkStartDownload(this.f10942a, this.f10943b);
            }
        }
    }

    public class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f10945a;

        public e(String str) {
            this.f10945a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (b.this.f10935b != null) {
                try {
                    if (this.f10945a.startsWith("tel:")) {
                        Intent intent = new Intent("android.intent.action.DIAL");
                        intent.setData(Uri.parse(this.f10945a));
                        intent.addFlags(268435456);
                        b.this.f10935b.startActivity(intent);
                    } else {
                        m.b().a(b.this.f10935b, this.f10945a);
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public interface f {
        void checkStartDownload(String str, boolean z);
    }

    public b(BaseWebActivity baseWebActivity) {
        this.f10935b = baseWebActivity;
    }

    public void a(String str) {
    }

    @Override // android.webkit.WebViewClient
    public void onFormResubmission(WebView webView, Message message, Message message2) {
        super.onFormResubmission(webView, message, message2);
        message2.sendToTarget();
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        super.onPageFinished(webView, str);
    }

    @Override // android.webkit.WebViewClient
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        super.onPageStarted(webView, str, bitmap);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView webView, int i2, String str, String str2) {
        super.onReceivedError(webView, i2, str, str2);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        Handler handler = this.f10937d;
        if (handler != null) {
            handler.post(new a(sslErrorHandler));
        }
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        if (str == null) {
            return false;
        }
        if (str.contains(".apk")) {
            a(str, true);
            return true;
        }
        if (str.startsWith("http://") || str.startsWith("https://")) {
            return false;
        }
        b(str);
        return true;
    }

    private void b(String str) {
        Handler handler;
        if (!m.b().a() || (handler = this.f10937d) == null) {
            return;
        }
        handler.post(new e(str));
    }

    public void a(f fVar) {
        this.f10934a = fVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(SslErrorHandler sslErrorHandler) {
        BaseWebActivity baseWebActivity;
        if (sslErrorHandler == null || (baseWebActivity = this.f10935b) == null) {
            return;
        }
        if (this.f10936c == null) {
            AlertDialog.Builder builder = new AlertDialog.Builder(baseWebActivity);
            builder.setTitle("SSL证书授权错误");
            builder.setMessage("确定继续访问该网址吗？");
            builder.setNegativeButton("取消", new DialogInterfaceOnClickListenerC0187b(this, sslErrorHandler));
            builder.setPositiveButton("确定", new c(this, sslErrorHandler));
            AlertDialog alertDialogCreate = builder.create();
            this.f10936c = alertDialogCreate;
            alertDialogCreate.setCancelable(false);
            this.f10936c.setCanceledOnTouchOutside(false);
        }
        try {
            this.f10936c.show();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void a(String str, boolean z) {
        Handler handler = this.f10937d;
        if (handler != null) {
            handler.post(new d(str, z));
        }
    }

    public void a() {
        AlertDialog alertDialog = this.f10936c;
        if (alertDialog != null) {
            alertDialog.dismiss();
            this.f10936c = null;
        }
        this.f10934a = null;
        this.f10935b = null;
        Handler handler = this.f10937d;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.f10937d = null;
        }
    }
}
