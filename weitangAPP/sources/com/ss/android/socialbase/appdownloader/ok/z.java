package com.ss.android.socialbase.appdownloader.ok;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.tom_roush.pdfbox.contentstream.operator.OperatorName;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class z extends ok {
    public z(Context context, com.ss.android.socialbase.downloader.h.ok okVar, String str) {
        super(context, okVar, str);
    }

    public static String ok(Map<String, String> map) {
        if (map == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            stringBuffer.append(entry.getKey());
            stringBuffer.append("=");
            stringBuffer.append(URLEncoder.encode(entry.getValue()));
            stringBuffer.append("&");
        }
        String string = stringBuffer.toString();
        return string.endsWith("&") ? string.substring(0, string.length() - 1) : string;
    }

    @Override // com.ss.android.socialbase.appdownloader.ok.n
    public Intent a() {
        String strBl = this.f9950a.bl(OperatorName.CLOSE_AND_STROKE);
        String strOk = com.ss.android.socialbase.appdownloader.kf.bl.ok(this.f9950a.bl("bb"), strBl);
        if (!TextUtils.isEmpty(strOk) && strOk.split(",").length == 2) {
            String strOk2 = com.ss.android.socialbase.appdownloader.kf.bl.ok(this.f9950a.bl("bc"), strBl);
            if (!TextUtils.isEmpty(strOk2) && strOk2.split(",").length == 2) {
                String[] strArrSplit = strOk.split(",");
                String[] strArrSplit2 = strOk2.split(",");
                String strOk3 = com.ss.android.socialbase.appdownloader.kf.bl.ok(this.f9950a.bl("bd"), strBl);
                String strOk4 = com.ss.android.socialbase.appdownloader.kf.bl.ok(this.f9950a.bl("be"), strBl);
                String strOk5 = com.ss.android.socialbase.appdownloader.kf.bl.ok(this.f9950a.bl("bf"), strBl);
                HashMap map = new HashMap();
                map.put(strArrSplit[0], strArrSplit[1]);
                map.put(strArrSplit2[0], strArrSplit2[1]);
                map.put(strOk3, this.bl);
                Intent intent = new Intent();
                intent.setAction(strOk5);
                intent.setData(Uri.parse(strOk4 + ok(map)));
                intent.addFlags(268468224);
                return intent;
            }
        }
        return null;
    }
}
