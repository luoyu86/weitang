package cn.admobiletop.adsuyi.ad.widget;

import android.content.Context;
import android.webkit.WebView;
import cn.admobiletop.adsuyi.a.n.i;

/* JADX INFO: loaded from: classes.dex */
public class ADSuyiWebView extends i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public RenderListener f3570a;

    public interface RenderListener {
        void onRenderFinish();
    }

    public ADSuyiWebView(Context context) {
        super(context);
    }

    public static String getImageHtml(String str, int i2) {
        return "<html xmlns=\"http://www.w3.org/1999/xhtml\">    <body style=\"margin: 0; padding: 0; width: 100%; height: 100%\" >       <img style=\"object-fit:cover; width: 100%; height: 100%; border-radius: " + i2 + "px\" src=\"" + str + "\"/>   </body></html>";
    }

    @Override // cn.admobiletop.adsuyi.a.n.i
    public void b(WebView webView, String str) {
        RenderListener renderListener = this.f3570a;
        if (renderListener != null) {
            renderListener.onRenderFinish();
        }
    }

    public void destroyWebView(boolean z) {
        this.f3570a = null;
        c(z);
    }

    @Override // cn.admobiletop.adsuyi.a.n.i
    public void loadHtml(String str) {
        super.loadHtml(str);
    }

    public void setRenderListener(RenderListener renderListener) {
        this.f3570a = renderListener;
    }
}
