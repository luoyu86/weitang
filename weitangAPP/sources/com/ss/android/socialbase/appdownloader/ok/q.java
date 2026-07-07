package com.ss.android.socialbase.appdownloader.ok;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tom_roush.pdfbox.contentstream.operator.OperatorName;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class q extends ok {
    private String n;
    private String s;

    public q(Context context, com.ss.android.socialbase.downloader.h.ok okVar, String str, String str2, String str3) {
        super(context, okVar, str);
        this.s = str2;
        this.n = str3;
    }

    @Override // com.ss.android.socialbase.appdownloader.ok.n
    public Intent a() {
        String str;
        String strBl = this.f9950a.bl(OperatorName.CLOSE_AND_STROKE);
        String strOk = com.ss.android.socialbase.appdownloader.kf.bl.ok(this.f9950a.bl("ak"), strBl);
        String strOk2 = com.ss.android.socialbase.appdownloader.kf.bl.ok(this.f9950a.bl("am"), strBl);
        String strOk3 = com.ss.android.socialbase.appdownloader.kf.bl.ok(this.f9950a.bl(com.alipay.sdk.m.s.a.u), strBl);
        String strSubstring = null;
        if (!TextUtils.isEmpty(strOk3) && strOk3.split(",").length == 2) {
            String[] strArrSplit = strOk3.split(",");
            String strOk4 = com.ss.android.socialbase.appdownloader.kf.bl.ok(this.f9950a.bl("al"), strBl);
            String strOk5 = com.ss.android.socialbase.appdownloader.kf.bl.ok(this.f9950a.bl("ao"), strBl);
            if (!TextUtils.isEmpty(strOk5) && strOk5.split(",").length == 2) {
                String[] strArrSplit2 = strOk5.split(",");
                JSONObject jSONObjectS = this.f9950a.s("download_dir");
                if (jSONObjectS != null) {
                    String strOptString = jSONObjectS.optString("dir_name");
                    if (TextUtils.isEmpty(strOptString) || !strOptString.contains("%s")) {
                        str = this.n;
                    } else {
                        try {
                            str = String.format(strOptString, this.n);
                        } catch (Throwable unused) {
                            str = this.n;
                        }
                    }
                    strSubstring = str;
                    if (strSubstring.length() > 255) {
                        strSubstring = strOk4.substring(strSubstring.length() - 255);
                    }
                }
                Intent intent = new Intent(strOk);
                intent.putExtra(strArrSplit2[0], strArrSplit2[1]);
                intent.putExtra(strOk2, this.s);
                intent.putExtra(strOk4, strSubstring);
                intent.putExtra(strArrSplit[0], Integer.parseInt(strArrSplit[1]));
                intent.addFlags(268468224);
                return intent;
            }
        }
        return null;
    }
}
