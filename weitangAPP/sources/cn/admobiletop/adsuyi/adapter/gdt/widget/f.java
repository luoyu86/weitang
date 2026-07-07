package cn.admobiletop.adsuyi.adapter.gdt.widget;

import android.app.Dialog;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import cn.admobiletop.adsuyi.adapter.gdt.R;
import com.qq.e.comm.compliance.DownloadConfirmCallBack;

/* JADX INFO: loaded from: classes.dex */
public class f extends Dialog implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f3776a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f3777b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public DownloadConfirmCallBack f3778c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public WebView f3779d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ImageView f3780e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Button f3781f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ViewGroup f3782g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ProgressBar f3783h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Button f3784i;
    public String j;
    public boolean k;

    public class a extends WebViewClient {
        public a() {
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            if (f.this.k) {
                return;
            }
            f.this.f3783h.setVisibility(8);
            f.this.f3784i.setVisibility(8);
            f.this.f3782g.setVisibility(0);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
            super.onReceivedError(webView, webResourceRequest, webResourceError);
            Log.d("ADGdtSuyiLog", "doConfirmWithInfo onReceivedError:" + webResourceError + " " + webResourceRequest);
            f.this.k = true;
            f.this.f3783h.setVisibility(8);
            f.this.f3782g.setVisibility(8);
            f.this.f3784i.setVisibility(0);
            f.this.f3784i.setText("重新加载");
            f.this.f3784i.setEnabled(true);
        }
    }

    public f(Context context, String str, DownloadConfirmCallBack downloadConfirmCallBack) {
        super(context, R.style.adsuyi_gdt_DownloadConfirmDialogFullScreen);
        this.k = false;
        this.f3776a = context;
        this.f3778c = downloadConfirmCallBack;
        this.j = str;
        this.f3777b = context.getResources().getConfiguration().orientation;
        requestWindowFeature(1);
        setCanceledOnTouchOutside(true);
        f();
    }

    public final void a() {
        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.adsuyi_gdt_download_confirm_holder);
        WebView webView = new WebView(this.f3776a);
        this.f3779d = webView;
        webView.getSettings().setJavaScriptEnabled(true);
        this.f3779d.removeJavascriptInterface("searchBoxJavaBridge_");
        this.f3779d.removeJavascriptInterface("accessibility");
        this.f3779d.removeJavascriptInterface("accessibilityTraversal");
        this.f3779d.getSettings().setSavePassword(false);
        this.f3779d.getSettings().setAllowFileAccess(false);
        this.f3779d.setWebViewClient(new a());
        frameLayout.addView(this.f3779d);
    }

    public final void b(String str) {
        if (TextUtils.isEmpty(str)) {
            this.f3783h.setVisibility(8);
            this.f3782g.setVisibility(8);
            this.f3784i.setVisibility(0);
            this.f3784i.setText("抱歉，应用信息获取失败");
            this.f3784i.setEnabled(false);
            return;
        }
        this.k = false;
        Log.d("ADGdtSuyiLog", "download confirm load url:" + str);
        this.f3779d.loadUrl(str);
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void cancel() {
        super.cancel();
        DownloadConfirmCallBack downloadConfirmCallBack = this.f3778c;
        if (downloadConfirmCallBack != null) {
            downloadConfirmCallBack.onCancel();
        }
    }

    public final void f() {
        setContentView(R.layout.adsuyi_gdt_download_confirm_dialog);
        View viewFindViewById = findViewById(R.id.download_confirm_root);
        int i2 = this.f3777b;
        if (i2 == 1) {
            viewFindViewById.setBackgroundResource(R.drawable.adsuyi_gdt_download_confirm_background_portrait);
        } else if (i2 == 2) {
            viewFindViewById.setBackgroundResource(R.drawable.adsuyi_gdt_download_confirm_background_landscape);
        }
        ImageView imageView = (ImageView) findViewById(R.id.adsuyi_gdt_download_confirm_close);
        this.f3780e = imageView;
        imageView.setOnClickListener(this);
        Button button = (Button) findViewById(R.id.adsuyi_gdt_download_confirm_reload_button);
        this.f3784i = button;
        button.setOnClickListener(this);
        Button button2 = (Button) findViewById(R.id.adsuyi_gdt_download_confirm_confirm);
        this.f3781f = button2;
        button2.setOnClickListener(this);
        this.f3783h = (ProgressBar) findViewById(R.id.adsuyi_gdt_download_confirm_progress_bar);
        this.f3782g = (ViewGroup) findViewById(R.id.adsuyi_gdt_download_confirm_content);
        a();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.f3780e) {
            DownloadConfirmCallBack downloadConfirmCallBack = this.f3778c;
            if (downloadConfirmCallBack != null) {
                downloadConfirmCallBack.onCancel();
            }
            dismiss();
            return;
        }
        if (view != this.f3781f) {
            if (view == this.f3784i) {
                b(this.j);
            }
        } else {
            DownloadConfirmCallBack downloadConfirmCallBack2 = this.f3778c;
            if (downloadConfirmCallBack2 != null) {
                downloadConfirmCallBack2.onConfirm();
            }
            dismiss();
        }
    }

    @Override // android.app.Dialog
    public void onStart() {
        int iA = cn.admobiletop.adsuyi.adapter.gdt.e.c.a(this.f3776a);
        int iB = cn.admobiletop.adsuyi.adapter.gdt.e.c.b(this.f3776a);
        Window window = getWindow();
        window.getDecorView().setPadding(0, 0, 0, 0);
        WindowManager.LayoutParams attributes = window.getAttributes();
        int i2 = this.f3777b;
        if (i2 == 1) {
            attributes.width = (int) (((double) iB) * 0.8d);
            attributes.height = (int) (((double) iA) * 0.5d);
            attributes.gravity = 17;
            attributes.windowAnimations = R.style.adsuyi_gdt_DownloadConfirmDialogAnimationUp;
        } else if (i2 == 2) {
            attributes.width = (int) (((double) iB) * 0.7d);
            attributes.height = (int) (((double) iA) * 0.8d);
            attributes.gravity = 17;
            attributes.windowAnimations = R.style.adsuyi_gdt_DownloadConfirmDialogAnimationUp;
        }
        attributes.dimAmount = 0.5f;
        window.setAttributes(attributes);
        setOnShowListener(new e(this));
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
        try {
            b(this.j);
        } catch (Exception e2) {
            Log.e("ADGdtSuyiLog", "load error url:" + this.j, e2);
        }
    }
}
