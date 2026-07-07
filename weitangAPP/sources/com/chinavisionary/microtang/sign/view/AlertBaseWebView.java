package com.chinavisionary.microtang.sign.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.webkit.JavascriptInterface;
import android.webkit.SslErrorHandler;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import c.e.a.d.l;
import c.e.a.d.q;
import c.e.a.d.w;
import c.e.a.d.x;
import c.e.a.d.y;
import com.chinavisionary.jslibrary.jsbridge.BridgeWebView;
import com.tom_roush.pdfbox.pdmodel.interactive.form.PDButton;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.android.agoo.common.AgooConstants;

/* JADX INFO: loaded from: classes2.dex */
public class AlertBaseWebView extends BridgeWebView {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f8558g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public File f8559h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Handler f8560i;
    public ArrayList<String> j;
    public f k;
    public e l;
    public h m;
    public g n;
    public i o;
    public boolean p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public String f8561q;
    public GestureDetector r;

    public class a extends GestureDetector.SimpleOnGestureListener {
        public a() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
            AlertBaseWebView.this.p = true;
            AlertBaseWebView.this.f8561q = null;
            return super.onFling(motionEvent, motionEvent2, f2, f3);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            AlertBaseWebView.this.p = false;
            if (AlertBaseWebView.this.k != null && x.isNotNull(AlertBaseWebView.this.f8561q)) {
                AlertBaseWebView.this.k.catPic(Integer.parseInt(AlertBaseWebView.this.f8561q));
            }
            return super.onSingleTapConfirmed(motionEvent);
        }
    }

    public class b extends Handler {
        public b() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            q.d(b.class.getSimpleName(), "handleMessage what :" + message.what);
            if (message.what == 1) {
                if (x.isNotNull(AlertBaseWebView.this.f8558g)) {
                    AlertBaseWebView.this.getSettings().setDefaultTextEncodingName("UTF-8");
                    AlertBaseWebView alertBaseWebView = AlertBaseWebView.this;
                    alertBaseWebView.loadData(alertBaseWebView.f8558g, "text/html", "UTF-8");
                    return;
                }
                return;
            }
            AlertBaseWebView.this.loadUrl("file:" + AlertBaseWebView.this.f8559h.getAbsolutePath());
        }
    }

    public class c extends WebViewClient {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Map f8564a;

        public c(Map map) {
            this.f8564a = map;
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            sslErrorHandler.proceed();
            q.d(AlertBaseWebView.this.getClass().getSimpleName(), "onReceivedSslError");
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            if (str.startsWith("weixin://wap/pay?") || str.startsWith(com.alipay.sdk.m.l.a.n)) {
                Intent intent = new Intent();
                intent.setAction("android.intent.action.VIEW");
                intent.setData(Uri.parse(str));
                c.e.a.a.b.getInstance().getContext().startActivity(intent);
                return true;
            }
            webView.loadUrl(str, this.f8564a);
            q.d(AlertBaseWebView.this.getClass().getSimpleName(), "shouldOverrideUrlLoading url:" + str);
            return true;
        }
    }

    public class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f8566a;

        public d(String str) {
            this.f8566a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            String htmlSavePath = l.getHtmlSavePath(c.e.a.a.b.getInstance().getContext());
            if (!x.isNotNull(htmlSavePath)) {
                AlertBaseWebView.this.f8560i.obtainMessage(1).sendToTarget();
                return;
            }
            AlertBaseWebView.this.f8559h = new File(htmlSavePath, "peanut.html");
            AlertBaseWebView.this.f8559h.getParentFile().mkdirs();
            try {
                if (AlertBaseWebView.this.f8559h.exists()) {
                    AlertBaseWebView.this.f8559h.delete();
                } else {
                    AlertBaseWebView.this.f8559h.createNewFile();
                }
                OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream(AlertBaseWebView.this.f8559h), "UTF-8");
                outputStreamWriter.write(this.f8566a);
                outputStreamWriter.flush();
                outputStreamWriter.close();
                AlertBaseWebView.this.f8560i.obtainMessage().sendToTarget();
            } catch (IOException e2) {
                e2.printStackTrace();
                AlertBaseWebView.this.f8560i.obtainMessage(1).sendToTarget();
            }
        }
    }

    public interface e {
        void setWebViewHeight(int i2);
    }

    public interface f {
        void catPic(int i2);

        void catSignPic(String str);

        void onImagePreview(String str);
    }

    public interface g {
        void doCellPhone(String str);

        void doLogin();

        String getTitle();

        void onIdCardAuthentication();

        void showBack();
    }

    public interface h {
        void openLockToRoomKey(String str);
    }

    public interface i {
        void onScrollBottom(boolean z);

        void onScrollTop();
    }

    public class j {
        public j() {
        }

        @JavascriptInterface
        public void doLogin() {
            if (AlertBaseWebView.this.n != null) {
                AlertBaseWebView.this.n.doLogin();
            }
        }

        @JavascriptInterface
        public void getContentHeight(String str) {
            if (AlertBaseWebView.this.l != null) {
                AlertBaseWebView.this.l.setWebViewHeight(Integer.parseInt(str));
            }
        }

        @JavascriptInterface
        public String getToken() {
            return AlertBaseWebView.this.y();
        }

        @JavascriptInterface
        public void onIdCardAuthentication() {
            if (AlertBaseWebView.this.n != null) {
                AlertBaseWebView.this.n.onIdCardAuthentication();
            }
        }

        @JavascriptInterface
        public void onImagePreview(String str) {
            if (AlertBaseWebView.this.k != null && !AlertBaseWebView.this.p) {
                AlertBaseWebView.this.k.onImagePreview(str);
            }
            q.d(AlertBaseWebView.class.getSimpleName(), "onImagePreview =" + str);
        }

        @JavascriptInterface
        public void openImage(String str) {
            AlertBaseWebView.this.f8561q = str;
            if (AlertBaseWebView.this.k == null || AlertBaseWebView.this.p) {
                return;
            }
            AlertBaseWebView.this.k.catPic(Integer.parseInt(str));
            AlertBaseWebView.this.f8561q = null;
        }

        @JavascriptInterface
        public void openLock(String str) {
            if (AlertBaseWebView.this.m != null) {
                AlertBaseWebView.this.m.openLockToRoomKey(str);
            }
        }

        @JavascriptInterface
        public void openUrl(String str) {
            if (AlertBaseWebView.this.k != null && !AlertBaseWebView.this.p) {
                AlertBaseWebView.this.k.catSignPic(str);
            }
            q.d(AlertBaseWebView.class.getSimpleName(), "openUrl url=" + str);
        }
    }

    public AlertBaseWebView(Context context) {
        super(context);
        this.r = null;
        g();
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    private void g() {
        this.r = new GestureDetector(getContext(), new a());
        this.f8560i = new b();
        this.j = new ArrayList<>();
        addJavascriptInterface(new j(), "micro_tang");
        WebSettings settings = getSettings();
        settings.setUseWideViewPort(true);
        settings.setJavaScriptEnabled(true);
        settings.setLoadWithOverviewMode(true);
        settings.setCacheMode(2);
        settings.setDomStorageEnabled(true);
        settings.setAllowFileAccess(true);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        setHorizontalScrollBarEnabled(false);
        setVerticalScrollbarOverlay(true);
        setScrollBarStyle(PDButton.FLAG_RADIOS_IN_UNISON);
        WebView.setWebContentsDebuggingEnabled(c.e.a.a.a.getInstance().isDebug());
        settings.setPluginState(WebSettings.PluginState.ON_DEMAND);
        HashMap map = new HashMap();
        map.put("Referer", "https://wxpay.wxutil.com/mch/pay/h5.v2.php");
        setWebViewClient(new c(map));
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        this.r.onTouchEvent(motionEvent);
        return super.dispatchTouchEvent(motionEvent);
    }

    public String getClickImgJS() {
        return "var objs = document.getElementsByTagName('img');\nfor (var i = 0; i < objs.length; i++) {\nobjs[i].setAttribute('value', i); \n objs[i].addEventListener('click', function() {\nclick(this);}); \n}\nfunction click(imgObj) {\nwindow.micro_tang.openUrl(imgObj.getAttribute('src'));\n} \n";
    }

    public ArrayList<String> getImgSrcList() {
        return this.j;
    }

    public String getJS() {
        return "<script type='text/javascript'>\nfunction load() {\nvar objs = document.getElementsByTagName('img');\nfor (var i = 0; i < objs.length; i++) {\nobjs[i].setAttribute('value', i); \n objs[i].style.width = '100%';\nobjs[i].style.height = 'auto';\nobjs[i].addEventListener('click', function() {\nclick(this);}); \n}\nvar height = document.getElementsByTagName('body')[0].offsetHeight;\nwindow.control.getContentHeight(height);\nfunction click(imgObj) {\nwindow.micro_tang.openImage(imgObj.getAttribute('value'));\n} \n}\n</script>";
    }

    public boolean isContentScrollable() {
        int contentHeight = getContentHeight();
        int height = getHeight();
        int iComputeVerticalScrollRange = computeVerticalScrollRange();
        isWebViewAtBottom();
        q.d("BaseWebView", "isContentScrollable contentHeight = " + contentHeight + ", viewHeight = " + height + ", scrollRange = " + iComputeVerticalScrollRange);
        return iComputeVerticalScrollRange > height;
    }

    public boolean isWebViewAtBottom() {
        int iComputeVerticalScrollRange = computeVerticalScrollRange();
        int iComputeVerticalScrollOffset = computeVerticalScrollOffset();
        int iComputeVerticalScrollExtent = computeVerticalScrollExtent();
        q.d("BaseWebView", "onScrollChanged scrollRange = " + iComputeVerticalScrollRange + ",scrollOffset =" + iComputeVerticalScrollOffset + ", scrollExtent = " + iComputeVerticalScrollExtent);
        return iComputeVerticalScrollOffset + iComputeVerticalScrollExtent >= iComputeVerticalScrollRange;
    }

    public void loadHtmlContent(String str, boolean z) {
        loadHtmlContent(str, z, "40", AgooConstants.ACK_PACK_NULL, "#FFFFFF", "#000000", null);
    }

    public void loadHtmlContractContent(String str, boolean z, String str2, String str3, String str4, String str5, String str6) {
        String str7;
        if (str != null) {
            if (str6 != null) {
                str7 = ";margin-top:" + str6 + "px;;margin-bottom:" + str6 + "px;";
            } else {
                str7 = "";
            }
            StringBuilder sb = new StringBuilder(5);
            sb.append("<html><head> \n<style type='text/css'>\n  \nbody{ height:auto;line-height:180%; background-color:" + str4 + ";font-size:" + str2 + "px;color:" + str5 + ";margin-left:" + str3 + "px;" + str7 + "margin-right:" + str3 + "px} \n</style>");
            sb.append(getJS());
            sb.append("</head><body onload='load()'>");
            if (z) {
                sb.append(str.replaceAll("font-size:", ""));
            } else {
                sb.append(str);
            }
            sb.append("</body></html>");
            String string = sb.toString();
            q.d(getClass().getSimpleName(), "loadHtmlContent:" + string);
            w(string);
            q.d(getClass().getSimpleName(), "end loadHtmlContent:" + string);
            v(string);
        }
    }

    public void loadJsMethodToNameAndParam(String str, String str2) {
        if (x.isNotNull(str)) {
            StringBuilder sb = new StringBuilder(3);
            sb.append("javascript:");
            sb.append(str);
            if (x.isNotNull(str2)) {
                sb.append("(" + str2 + ")");
            } else {
                sb.append("()");
            }
            loadUrl(sb.toString());
        }
    }

    @Override // android.webkit.WebView, android.view.View
    public void onScrollChanged(int i2, int i3, int i4, int i5) {
        super.onScrollChanged(i2, i3, i4, i5);
        scrollTo(0, i3);
        q.d("BaseWebView", "onScrollChanged t = " + i3 + "，isWebViewAtBottom = " + isWebViewAtBottom());
        i iVar = this.o;
        if (iVar != null) {
            if (i3 == 0) {
                iVar.onScrollTop();
            }
            this.o.onScrollBottom(isWebViewAtBottom());
        }
    }

    public void recycler() {
        Handler handler = this.f8560i;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.f8560i = null;
        }
    }

    public void setIWebViewHeightListener(e eVar) {
        this.l = eVar;
    }

    public void setIWebViewJsListener(f fVar) {
        this.k = fVar;
    }

    public void setIWebViewLoginListener(g gVar) {
        this.n = gVar;
    }

    public void setIWebViewOpenLockListener(h hVar) {
        this.m = hVar;
    }

    public void setOnWebViewScrollListener(i iVar) {
        this.o = iVar;
    }

    public final void v(String str) {
        this.f8558g = str;
        y.get().addRunnable(new d(str));
    }

    public final void w(String str) {
        if (x.isNotNull(str)) {
            x(str);
            String[] strArrSplit = str.split("<img src=\"");
            q.d(getClass().getSimpleName(), "length :" + strArrSplit.length);
            if (strArrSplit.length > 1) {
                for (int i2 = 1; i2 < strArrSplit.length; i2++) {
                    String str2 = strArrSplit[i2];
                    this.j.add(str2.substring(0, str2.indexOf("\"")));
                }
            }
        }
    }

    public final void x(String str) {
        if (x.isNotNull(str)) {
            for (String str2 : str.split("<img")) {
                q.d(getClass().getSimpleName(), "img value :" + str2);
                String[] strArrSplit = str2.split("src=\"");
                if (strArrSplit.length > 1) {
                    for (int i2 = 1; i2 < strArrSplit.length; i2++) {
                        String str3 = strArrSplit[i2];
                        str3.substring(0, str3.indexOf("\""));
                    }
                }
            }
        }
    }

    public final String y() {
        g gVar;
        String string = w.getInstance().getString("Token", null);
        if (x.isNullStr(string) && (gVar = this.n) != null) {
            gVar.doLogin();
        }
        q.d(AlertBaseWebView.class.getSimpleName(), "token:" + string);
        return string;
    }

    public void loadHtmlContent(String str, boolean z, String str2, String str3, String str4, String str5, String str6) {
        String str7;
        if (str != null) {
            if (str6 != null) {
                str7 = ";padding-top:" + str6 + "px;;padding-bottom:" + str6 + "px;";
            } else {
                str7 = "";
            }
            StringBuilder sb = new StringBuilder(5);
            sb.append("<html><head> \n<style type='text/css'>\n  \nbody{background-color:" + str4 + ";font-size:" + str2 + "px;color:" + str5 + ";padding-left:" + str3 + "px;" + str7 + "padding-right:" + str3 + "px} \n</style>");
            sb.append(getJS());
            sb.append("</head><body onload='load()'>");
            if (z) {
                sb.append(str.replaceAll("font-size:", ""));
            } else {
                sb.append(str);
            }
            sb.append("</body></html>");
            String string = sb.toString();
            q.d(getClass().getSimpleName(), "loadHtmlContent:" + string);
            w(string);
            q.d(getClass().getSimpleName(), "end loadHtmlContent:" + string);
            v(string);
        }
    }

    public AlertBaseWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.r = null;
        g();
    }

    public AlertBaseWebView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.r = null;
        g();
    }
}
