package c.e.b.a;

import android.webkit.WebView;

/* JADX INFO: loaded from: classes.dex */
public class b {
    /* JADX WARN: Removed duplicated region for block: B:39:0x004c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String assetFile2Str(android.content.Context r4, java.lang.String r5) throws java.lang.Throwable {
        /*
            r0 = 0
            android.content.res.AssetManager r4 = r4.getAssets()     // Catch: java.lang.Throwable -> L3b java.lang.Exception -> L3d
            java.io.InputStream r4 = r4.open(r5)     // Catch: java.lang.Throwable -> L3b java.lang.Exception -> L3d
            java.io.BufferedReader r5 = new java.io.BufferedReader     // Catch: java.lang.Exception -> L39 java.lang.Throwable -> L48
            java.io.InputStreamReader r1 = new java.io.InputStreamReader     // Catch: java.lang.Exception -> L39 java.lang.Throwable -> L48
            r1.<init>(r4)     // Catch: java.lang.Exception -> L39 java.lang.Throwable -> L48
            r5.<init>(r1)     // Catch: java.lang.Exception -> L39 java.lang.Throwable -> L48
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L39 java.lang.Throwable -> L48
            r1.<init>()     // Catch: java.lang.Exception -> L39 java.lang.Throwable -> L48
        L18:
            java.lang.String r2 = r5.readLine()     // Catch: java.lang.Exception -> L39 java.lang.Throwable -> L48
            if (r2 == 0) goto L29
            java.lang.String r3 = "^\\s*\\/\\/.*"
            boolean r3 = r2.matches(r3)     // Catch: java.lang.Exception -> L39 java.lang.Throwable -> L48
            if (r3 != 0) goto L29
            r1.append(r2)     // Catch: java.lang.Exception -> L39 java.lang.Throwable -> L48
        L29:
            if (r2 != 0) goto L18
            r5.close()     // Catch: java.lang.Exception -> L39 java.lang.Throwable -> L48
            r4.close()     // Catch: java.lang.Exception -> L39 java.lang.Throwable -> L48
            java.lang.String r5 = r1.toString()     // Catch: java.lang.Exception -> L39 java.lang.Throwable -> L48
            r4.close()     // Catch: java.io.IOException -> L38
        L38:
            return r5
        L39:
            r5 = move-exception
            goto L3f
        L3b:
            r5 = move-exception
            goto L4a
        L3d:
            r5 = move-exception
            r4 = r0
        L3f:
            r5.printStackTrace()     // Catch: java.lang.Throwable -> L48
            if (r4 == 0) goto L47
            r4.close()     // Catch: java.io.IOException -> L47
        L47:
            return r0
        L48:
            r5 = move-exception
            r0 = r4
        L4a:
            if (r0 == 0) goto L4f
            r0.close()     // Catch: java.io.IOException -> L4f
        L4f:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: c.e.b.a.b.assetFile2Str(android.content.Context, java.lang.String):java.lang.String");
    }

    public static String getDataFromReturnUrl(String str) {
        if (str.startsWith("yy://return/_fetchQueue/")) {
            return str.replace("yy://return/_fetchQueue/", "");
        }
        String[] strArrSplit = str.replace("yy://return/", "").split("/");
        if (strArrSplit.length < 2) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (int i2 = 1; i2 < strArrSplit.length; i2++) {
            sb.append(strArrSplit[i2]);
        }
        return sb.toString();
    }

    public static String getFunctionFromReturnUrl(String str) {
        String[] strArrSplit = str.replace("yy://return/", "").split("/");
        if (strArrSplit.length >= 1) {
            return strArrSplit[0];
        }
        return null;
    }

    public static String parseFunctionName(String str) {
        return str.replace("javascript:WebViewJavascriptBridge.", "").replaceAll("\\(.*\\);", "");
    }

    public static void webViewLoadJs(WebView webView, String str) {
        webView.loadUrl("javascript:" + (("var newscript = document.createElement(\"script\");newscript.src=\"" + str + "\";") + "document.scripts[0].parentNode.insertBefore(newscript,document.scripts[0]);"));
    }

    public static void webViewLoadLocalJs(WebView webView, String str) throws Throwable {
        webView.loadUrl("javascript:" + assetFile2Str(webView.getContext(), str));
    }
}
