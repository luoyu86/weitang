package cn.admobiletop.adsuyi.a.n;

import android.content.Context;
import android.os.Build;
import android.webkit.WebSettings;
import android.webkit.WebView;
import cn.admobiletop.adsuyi.util.ADSuyiLogUtil;
import cn.admobiletop.adsuyi.util.ADSuyiViewUtil;

/* JADX INFO: loaded from: classes.dex */
public abstract class i extends WebView {
    public i(Context context) {
        super(context);
        try {
            int i2 = Build.VERSION.SDK_INT;
            if (i2 >= 21) {
                setNestedScrollingEnabled(false);
            }
            removeJavascriptInterface("searchBoxJavaBridge_");
            removeJavascriptInterface("accessibility");
            removeJavascriptInterface("accessibilityTraversal");
            setHorizontalScrollBarEnabled(false);
            setVerticalScrollBarEnabled(false);
            setScrollBarStyle(0);
            WebSettings settings = getSettings();
            settings.setCacheMode(-1);
            settings.setDomStorageEnabled(true);
            settings.setDefaultTextEncodingName("UTF-8");
            settings.setSupportZoom(false);
            settings.setBuiltInZoomControls(false);
            settings.setLoadsImagesAutomatically(true);
            settings.setDomStorageEnabled(true);
            settings.setSavePassword(false);
            settings.setAllowFileAccess(false);
            if (i2 >= 21) {
                getSettings().setMixedContentMode(2);
            }
            setWebViewClient(new h(this));
            setBackgroundColor(0);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getEmptyUrl() {
        return "<html xmlns=\"http://www.w3.org/1999/xhtml\"> <body style=\"margin: 0; padding: 0\" ><text width=\"1px\" height=\"1px\"/></body></html>";
    }

    public abstract void b(WebView webView, String str);

    public void c(boolean z) {
        if (z) {
            try {
                clearCache(false);
            } catch (Throwable th) {
                th.printStackTrace();
                return;
            }
        }
        setVisibility(8);
        clearHistory();
        clearView();
        removeAllViews();
        ADSuyiViewUtil.removeSelfFromParent(this);
        destroy();
        ADSuyiLogUtil.d("release ad view...");
    }

    public void loadHtml(String str) {
        if (str != null) {
            try {
                loadDataWithBaseURL(null, str, "text/html", "utf-8", null);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }
}
