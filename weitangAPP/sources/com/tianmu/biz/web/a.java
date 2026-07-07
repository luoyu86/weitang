package com.tianmu.biz.web;

import android.app.AlertDialog;
import android.content.ClipData;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.view.View;
import android.webkit.GeolocationPermissions;
import android.webkit.JsResult;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.VideoView;

/* JADX INFO: loaded from: classes2.dex */
public class a extends WebChromeClient implements MediaPlayer.OnPreparedListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ProgressBar f10920a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private FrameLayout f10921b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f10922c = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private FrameLayout f10923d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private WebChromeClient.CustomViewCallback f10924e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private b f10925f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private BaseWebActivity f10926g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private ValueCallback<Uri> f10927h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private ValueCallback<Uri[]> f10928i;
    private AlertDialog j;

    /* JADX INFO: renamed from: com.tianmu.biz.web.a$a, reason: collision with other inner class name */
    public class RunnableC0185a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f10929a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ JsResult f10930b;

        /* JADX INFO: renamed from: com.tianmu.biz.web.a$a$a, reason: collision with other inner class name */
        public class DialogInterfaceOnClickListenerC0186a implements DialogInterface.OnClickListener {
            public DialogInterfaceOnClickListenerC0186a() {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
                RunnableC0185a.this.f10930b.cancel();
            }
        }

        /* JADX INFO: renamed from: com.tianmu.biz.web.a$a$b */
        public class b implements DialogInterface.OnClickListener {
            public b() {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
                RunnableC0185a.this.f10930b.confirm();
            }
        }

        public RunnableC0185a(String str, JsResult jsResult) {
            this.f10929a = str;
            this.f10930b = jsResult;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.this.j != null) {
                a.this.j = null;
            }
            AlertDialog.Builder cancelable = new AlertDialog.Builder(a.this.f10926g).setMessage(this.f10929a).setPositiveButton("确定", new b()).setNegativeButton("取消", new DialogInterfaceOnClickListenerC0186a()).setCancelable(false);
            try {
                a.this.j = cancelable.create();
                a.this.j.show();
            } catch (Exception unused) {
            }
        }
    }

    public interface b {
        void getTitle(String str);

        void onProgressChanged(int i2);

        void toggledFullscreen(boolean z);
    }

    public a(FrameLayout frameLayout, BaseWebActivity baseWebActivity) {
        this.f10921b = frameLayout;
        this.f10926g = baseWebActivity;
        this.f10920a = new ProgressBar(baseWebActivity);
    }

    @Override // android.webkit.WebChromeClient
    public View getVideoLoadingProgressView() {
        ProgressBar progressBar = this.f10920a;
        if (progressBar == null) {
            return super.getVideoLoadingProgressView();
        }
        progressBar.setVisibility(0);
        return this.f10920a;
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public void onCompletion(MediaPlayer mediaPlayer) {
        onHideCustomView();
    }

    @Override // android.media.MediaPlayer.OnErrorListener
    public boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
        return false;
    }

    @Override // android.webkit.WebChromeClient
    public void onGeolocationPermissionsShowPrompt(String str, GeolocationPermissions.Callback callback) {
        callback.invoke(str, true, false);
        super.onGeolocationPermissionsShowPrompt(str, callback);
    }

    @Override // android.webkit.WebChromeClient
    public void onHideCustomView() {
        FrameLayout frameLayout = this.f10921b;
        if (frameLayout != null && this.f10922c) {
            frameLayout.setVisibility(8);
            this.f10921b.removeView(this.f10923d);
            WebChromeClient.CustomViewCallback customViewCallback = this.f10924e;
            if (customViewCallback != null && !customViewCallback.getClass().getName().contains(".chromium.")) {
                this.f10924e.onCustomViewHidden();
            }
            this.f10922c = false;
            this.f10923d = null;
            this.f10924e = null;
            b bVar = this.f10925f;
            if (bVar != null) {
                bVar.toggledFullscreen(false);
            }
        }
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsConfirm(WebView webView, String str, String str2, JsResult jsResult) {
        BaseWebActivity baseWebActivity;
        if (webView == null || (baseWebActivity = this.f10926g) == null) {
            return true;
        }
        baseWebActivity.runOnUiThread(new RunnableC0185a(str2, jsResult));
        return true;
    }

    @Override // android.media.MediaPlayer.OnPreparedListener
    public void onPrepared(MediaPlayer mediaPlayer) {
        ProgressBar progressBar = this.f10920a;
        if (progressBar != null) {
            progressBar.setVisibility(8);
        }
    }

    @Override // android.webkit.WebChromeClient
    public void onProgressChanged(WebView webView, int i2) {
        super.onProgressChanged(webView, i2);
        b bVar = this.f10925f;
        if (bVar != null) {
            bVar.onProgressChanged(i2);
        }
    }

    @Override // android.webkit.WebChromeClient
    public void onReceivedTitle(WebView webView, String str) {
        super.onReceivedTitle(webView, str);
        if (this.f10925f != null) {
            String strSubstring = "";
            if (str != null && str.length() > 8) {
                strSubstring = str.substring(0, 8);
            }
            this.f10925f.getTitle(strSubstring);
        }
    }

    @Override // android.webkit.WebChromeClient
    public void onShowCustomView(View view, WebChromeClient.CustomViewCallback customViewCallback) {
        if (this.f10921b != null && (view instanceof FrameLayout)) {
            FrameLayout frameLayout = (FrameLayout) view;
            View focusedChild = frameLayout.getFocusedChild();
            this.f10922c = true;
            this.f10924e = customViewCallback;
            this.f10923d = frameLayout;
            this.f10921b.addView(frameLayout);
            this.f10921b.setVisibility(0);
            if (focusedChild instanceof VideoView) {
                VideoView videoView = (VideoView) focusedChild;
                videoView.setOnPreparedListener(this);
                videoView.setOnCompletionListener(this);
                videoView.setOnErrorListener(this);
            }
            b bVar = this.f10925f;
            if (bVar != null) {
                bVar.toggledFullscreen(true);
            }
        }
    }

    @Override // android.webkit.WebChromeClient
    public boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> valueCallback, WebChromeClient.FileChooserParams fileChooserParams) {
        if (this.f10926g == null) {
            return true;
        }
        this.f10928i = valueCallback;
        try {
            Intent intent = new Intent("android.intent.action.GET_CONTENT");
            intent.addCategory("android.intent.category.OPENABLE");
            intent.setType("image/*");
            this.f10926g.startActivityForResult(Intent.createChooser(intent, "File Browser"), 12343);
            return true;
        } catch (Exception e2) {
            e2.printStackTrace();
            return true;
        }
    }

    public void b() {
        AlertDialog alertDialog = this.j;
        if (alertDialog != null) {
            alertDialog.dismiss();
            this.j = null;
        }
        this.f10925f = null;
        this.f10926g = null;
    }

    public void a(int i2, int i3, Intent intent) {
        Uri[] uriArr;
        if (i2 == 12343 && i3 == -1) {
            Uri data = intent == null ? null : intent.getData();
            if (this.f10928i != null) {
                if (intent != null) {
                    String dataString = intent.getDataString();
                    ClipData clipData = Build.VERSION.SDK_INT >= 16 ? intent.getClipData() : null;
                    if (clipData != null) {
                        uriArr = new Uri[clipData.getItemCount()];
                        for (int i4 = 0; i4 < clipData.getItemCount(); i4++) {
                            uriArr[i4] = clipData.getItemAt(i4).getUri();
                        }
                    } else {
                        uriArr = null;
                    }
                    if (dataString != null) {
                        uriArr = new Uri[]{Uri.parse(dataString)};
                    }
                } else {
                    uriArr = null;
                }
                this.f10928i.onReceiveValue(uriArr);
                this.f10928i = null;
                return;
            }
            ValueCallback<Uri> valueCallback = this.f10927h;
            if (valueCallback != null) {
                valueCallback.onReceiveValue(data);
                this.f10927h = null;
            }
        }
    }

    @Override // android.webkit.WebChromeClient
    public void onShowCustomView(View view, int i2, WebChromeClient.CustomViewCallback customViewCallback) {
        onShowCustomView(view, customViewCallback);
    }

    public void a(b bVar) {
        this.f10925f = bVar;
    }

    public boolean a() {
        if (!this.f10922c) {
            return false;
        }
        onHideCustomView();
        return true;
    }
}
