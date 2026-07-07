package com.tencent.mm.opensdk.diffdev.a;

import android.os.AsyncTask;
import android.os.Build;
import android.util.Base64;
import com.intelligoo.sdk.ConstantsUtils;
import com.tencent.mm.opensdk.diffdev.OAuthErrCode;
import com.tencent.mm.opensdk.diffdev.OAuthListener;
import com.tencent.mm.opensdk.utils.Log;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class d extends AsyncTask<Void, Void, a> {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static String f10531h = "https://open.weixin.qq.com/connect/sdk/qrconnect?appid=%s&noncestr=%s&timestamp=%s&scope=%s&signature=%s";
    private String appId;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private String f10532i;
    private String j;
    private OAuthListener k;
    private f l;
    private String scope;
    private String signature;

    public static class a {
        public OAuthErrCode m;
        public String n;
        public String o;
        public String p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public int f10533q;
        public String r;
        public byte[] s;

        private a() {
        }

        public static a a(byte[] bArr) {
            OAuthErrCode oAuthErrCode;
            String str;
            a aVar = new a();
            if (bArr != null && bArr.length != 0) {
                try {
                } catch (Exception e2) {
                    str = String.format("parse fail, build String fail, ex = %s", e2.getMessage());
                }
                try {
                    JSONObject jSONObject = new JSONObject(new String(bArr, "utf-8"));
                    int i2 = jSONObject.getInt("errcode");
                    if (i2 != 0) {
                        Log.e("MicroMsg.SDK.GetQRCodeResult", String.format("resp errcode = %d", Integer.valueOf(i2)));
                        aVar.m = OAuthErrCode.WechatAuth_Err_NormalErr;
                        aVar.f10533q = i2;
                        aVar.r = jSONObject.optString("errmsg");
                        return aVar;
                    }
                    String string = jSONObject.getJSONObject(ConstantsUtils.DEVICEOPENDOOR_QRCODE).getString("qrcodebase64");
                    if (string != null && string.length() != 0) {
                        byte[] bArrDecode = Base64.decode(string, 0);
                        if (bArrDecode != null && bArrDecode.length != 0) {
                            aVar.m = OAuthErrCode.WechatAuth_Err_OK;
                            aVar.s = bArrDecode;
                            aVar.n = jSONObject.getString("uuid");
                            String string2 = jSONObject.getString("appname");
                            aVar.o = string2;
                            Log.d("MicroMsg.SDK.GetQRCodeResult", String.format("parse succ, save in memory, uuid = %s, appname = %s, imgBufLength = %d", aVar.n, string2, Integer.valueOf(aVar.s.length)));
                            return aVar;
                        }
                        Log.e("MicroMsg.SDK.GetQRCodeResult", "parse fail, qrcodeBuf is null");
                        aVar.m = OAuthErrCode.WechatAuth_Err_JsonDecodeErr;
                        return aVar;
                    }
                    Log.e("MicroMsg.SDK.GetQRCodeResult", "parse fail, qrcodeBase64 is null");
                    aVar.m = OAuthErrCode.WechatAuth_Err_JsonDecodeErr;
                    return aVar;
                } catch (Exception e3) {
                    str = String.format("parse json fail, ex = %s", e3.getMessage());
                    Log.e("MicroMsg.SDK.GetQRCodeResult", str);
                    oAuthErrCode = OAuthErrCode.WechatAuth_Err_NormalErr;
                    aVar.m = oAuthErrCode;
                    return aVar;
                }
            }
            Log.e("MicroMsg.SDK.GetQRCodeResult", "parse fail, buf is null");
            oAuthErrCode = OAuthErrCode.WechatAuth_Err_NetworkErr;
            aVar.m = oAuthErrCode;
            return aVar;
        }
    }

    public d(String str, String str2, String str3, String str4, String str5, OAuthListener oAuthListener) {
        this.appId = str;
        this.scope = str2;
        this.f10532i = str3;
        this.j = str4;
        this.signature = str5;
        this.k = oAuthListener;
    }

    public final boolean a() {
        Log.i("MicroMsg.SDK.GetQRCodeTask", "cancelTask");
        f fVar = this.l;
        return fVar == null ? cancel(true) : fVar.cancel(true);
    }

    @Override // android.os.AsyncTask
    public final /* synthetic */ a doInBackground(Void[] voidArr) throws Throwable {
        Thread.currentThread().setName("OpenSdkGetQRCodeTask");
        Log.i("MicroMsg.SDK.GetQRCodeTask", "doInBackground");
        String str = String.format(f10531h, this.appId, this.f10532i, this.j, this.scope, this.signature);
        long jCurrentTimeMillis = System.currentTimeMillis();
        byte[] bArrA = e.a(str);
        Log.d("MicroMsg.SDK.GetQRCodeTask", String.format("doInBackground, url = %s, time consumed = %d(ms)", str, Long.valueOf(System.currentTimeMillis() - jCurrentTimeMillis)));
        return a.a(bArrA);
    }

    @Override // android.os.AsyncTask
    public final /* synthetic */ void onPostExecute(a aVar) {
        a aVar2 = aVar;
        OAuthErrCode oAuthErrCode = aVar2.m;
        if (oAuthErrCode != OAuthErrCode.WechatAuth_Err_OK) {
            Log.e("MicroMsg.SDK.GetQRCodeTask", String.format("onPostExecute, get qrcode fail, OAuthErrCode = %s", oAuthErrCode));
            this.k.onAuthFinish(aVar2.m, null);
            return;
        }
        Log.d("MicroMsg.SDK.GetQRCodeTask", "onPostExecute, get qrcode success imgBufSize = " + aVar2.s.length);
        this.k.onAuthGotQrcode(aVar2.p, aVar2.s);
        f fVar = new f(aVar2.n, this.k);
        this.l = fVar;
        if (Build.VERSION.SDK_INT >= 11) {
            fVar.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        } else {
            fVar.execute(new Void[0]);
        }
    }
}
