package org.android.agoo.control;

import android.text.TextUtils;
import com.taobao.accs.utl.ALog;
import com.tom_roush.pdfbox.contentstream.operator.OperatorName;
import org.android.agoo.common.Config;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ byte[] f14942a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f14943b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ AgooFactory f14944c;

    public a(AgooFactory agooFactory, byte[] bArr, String str) {
        this.f14944c = agooFactory;
        this.f14942a = bArr;
        this.f14943b = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            String str = new String(this.f14942a, "utf-8");
            JSONArray jSONArray = new JSONArray(str);
            int length = jSONArray.length();
            if (length == 1) {
                String string = null;
                String string2 = null;
                for (int i2 = 0; i2 < length; i2++) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i2);
                    if (jSONObject != null) {
                        string = jSONObject.getString(OperatorName.SET_FLATNESS);
                        string2 = jSONObject.getString("p");
                    }
                }
                if (ALog.isPrintLog(ALog.Level.I)) {
                    ALog.i("AgooFactory", "saveMsg msgId:" + string + ",message=" + str + ",currentPack=" + string2 + ",reportTimes=" + Config.g(AgooFactory.sContext), new Object[0]);
                }
                if (TextUtils.isEmpty(string2) || !TextUtils.equals(string2, AgooFactory.sContext.getPackageName())) {
                    return;
                }
                if (TextUtils.isEmpty(this.f14943b)) {
                    this.f14944c.messageService.a(string, str, "0");
                } else {
                    this.f14944c.messageService.a(string, str, this.f14943b);
                }
            }
        } catch (Throwable th) {
            ALog.e("AgooFactory", "saveMsg fail:" + th.toString(), new Object[0]);
        }
    }
}
