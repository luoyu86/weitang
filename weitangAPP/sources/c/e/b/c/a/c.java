package c.e.b.c.a;

import android.view.View;
import android.widget.ImageView;
import com.alipay.sdk.m.x.d;
import com.chinavisionary.jslibrary.R;
import com.chinavisionary.jslibrary.jsbridge.BridgeWebView;
import d.k0.d.p;
import d.k0.d.t;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f1269a = new a(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, Integer> f1270b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final BridgeWebView f1271c;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(p pVar) {
            this();
        }
    }

    public c(BridgeWebView bridgeWebView) {
        t.checkNotNullParameter(bridgeWebView, "mWebView");
        this.f1271c = bridgeWebView;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        this.f1270b = linkedHashMap;
        linkedHashMap.put("scan", Integer.valueOf(R.mipmap.ic_js_lib_scan));
        linkedHashMap.put("search", Integer.valueOf(R.mipmap.ic_js_lib_search));
        linkedHashMap.put("share", Integer.valueOf(R.mipmap.ic_js_lib_share));
        linkedHashMap.put(d.w, Integer.valueOf(R.mipmap.ic_js_lib_refresh));
        linkedHashMap.put("menu", Integer.valueOf(R.mipmap.ic_js_lib_menu));
        linkedHashMap.put("add", Integer.valueOf(R.mipmap.ic_js_lib_add));
        linkedHashMap.put("help", Integer.valueOf(R.mipmap.ic_js_lib_help));
        linkedHashMap.put("more", Integer.valueOf(R.mipmap.ic_js_lib_mutile));
    }

    public final void a() {
    }

    public final void handleRightClick() {
        this.f1271c.callHandler("onClickNavigationBarRight", "{}", null);
    }

    public final void handleRightImgClick(View view) {
        t.checkNotNullParameter(view, "view");
        Object tag = view.getTag();
        if (tag != null) {
            String string = tag.toString();
            int iHashCode = string.hashCode();
            if (iHashCode != 3524221) {
                if (iHashCode == 1085444827 && string.equals(d.w)) {
                    this.f1271c.reload();
                    return;
                }
            } else if (string.equals("scan")) {
                a();
                return;
            }
            handleRightClick();
        }
    }

    public final boolean isNeedSetRightImg(String str) {
        t.checkNotNullParameter(str, "functionKey");
        return this.f1270b.containsKey(str);
    }

    public final boolean isNeedSetRightTv(String str) {
        t.checkNotNullParameter(str, "functionKey");
        return t.areEqual("button", str);
    }

    public final void setupRightImageData(String str, ImageView imageView) {
        t.checkNotNullParameter(str, "functionKey");
        t.checkNotNullParameter(imageView, "rightImg");
        if (this.f1270b.containsKey(str)) {
            imageView.setTag(str);
            imageView.setVisibility(0);
            Integer num = this.f1270b.get(str);
            t.checkNotNull(num);
            imageView.setImageResource(num.intValue());
        }
    }
}
