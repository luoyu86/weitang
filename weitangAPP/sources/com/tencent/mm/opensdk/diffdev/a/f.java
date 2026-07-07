package com.tencent.mm.opensdk.diffdev.a;

import android.os.AsyncTask;
import com.tencent.mm.opensdk.diffdev.OAuthErrCode;
import com.tencent.mm.opensdk.diffdev.OAuthListener;
import com.tencent.mm.opensdk.utils.Log;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class f extends AsyncTask<Void, Void, a> {
    private OAuthListener k;
    private String n;
    private int t;
    private String url;

    public static class a {
        public OAuthErrCode m;
        public String u;
        public int v;

        public static a b(byte[] bArr) {
            OAuthErrCode oAuthErrCode;
            String str;
            OAuthErrCode oAuthErrCode2;
            a aVar = new a();
            Log.d("MicroMsg.SDK.NoopingResult", "star parse NoopingResult");
            if (bArr == null || bArr.length == 0) {
                Log.e("MicroMsg.SDK.NoopingResult", "parse fail, buf is null");
                oAuthErrCode = OAuthErrCode.WechatAuth_Err_NetworkErr;
            } else {
                try {
                    try {
                        JSONObject jSONObject = new JSONObject(new String(bArr, "utf-8"));
                        int i2 = jSONObject.getInt("wx_errcode");
                        aVar.v = i2;
                        Log.d("MicroMsg.SDK.NoopingResult", String.format("nooping uuidStatusCode = %d", Integer.valueOf(i2)));
                        int i3 = aVar.v;
                        if (i3 == 408) {
                            oAuthErrCode2 = OAuthErrCode.WechatAuth_Err_OK;
                        } else if (i3 != 500) {
                            switch (i3) {
                                case 402:
                                    oAuthErrCode2 = OAuthErrCode.WechatAuth_Err_Timeout;
                                    break;
                                case 403:
                                    oAuthErrCode2 = OAuthErrCode.WechatAuth_Err_Cancel;
                                    break;
                                case 404:
                                    oAuthErrCode2 = OAuthErrCode.WechatAuth_Err_OK;
                                    break;
                                case 405:
                                    aVar.m = OAuthErrCode.WechatAuth_Err_OK;
                                    aVar.u = jSONObject.getString("wx_code");
                                    return aVar;
                                default:
                                    oAuthErrCode2 = OAuthErrCode.WechatAuth_Err_NormalErr;
                                    break;
                            }
                        } else {
                            oAuthErrCode2 = OAuthErrCode.WechatAuth_Err_NormalErr;
                        }
                        aVar.m = oAuthErrCode2;
                        return aVar;
                    } catch (Exception e2) {
                        str = String.format("parse json fail, ex = %s", e2.getMessage());
                        Log.e("MicroMsg.SDK.NoopingResult", str);
                        oAuthErrCode = OAuthErrCode.WechatAuth_Err_NormalErr;
                        aVar.m = oAuthErrCode;
                        return aVar;
                    }
                } catch (Exception e3) {
                    str = String.format("parse fail, build String fail, ex = %s", e3.getMessage());
                }
            }
            aVar.m = oAuthErrCode;
            return aVar;
        }
    }

    public f(String str, OAuthListener oAuthListener) {
        this.n = str;
        this.k = oAuthListener;
        this.url = String.format("https://long.open.weixin.qq.com/connect/l/qrconnect?f=json&uuid=%s", str);
    }

    @Override // android.os.AsyncTask
    public final /* synthetic */ a doInBackground(Void[] voidArr) throws Throwable {
        a aVar;
        OAuthErrCode oAuthErrCode;
        String str;
        Thread.currentThread().setName("OpenSdkNoopingTask");
        String str2 = this.n;
        if (str2 == null || str2.length() == 0) {
            Log.e("MicroMsg.SDK.NoopingTask", "run fail, uuid is null");
            aVar = new a();
            oAuthErrCode = OAuthErrCode.WechatAuth_Err_NormalErr;
        } else {
            Log.i("MicroMsg.SDK.NoopingTask", "doInBackground start " + isCancelled());
            while (!isCancelled()) {
                StringBuilder sb = new StringBuilder();
                sb.append(this.url);
                if (this.t == 0) {
                    str = "";
                } else {
                    str = "&last=" + this.t;
                }
                sb.append(str);
                String string = sb.toString();
                long jCurrentTimeMillis = System.currentTimeMillis();
                byte[] bArrA = e.a(string);
                long jCurrentTimeMillis2 = System.currentTimeMillis();
                a aVarB = a.b(bArrA);
                Log.d("MicroMsg.SDK.NoopingTask", String.format("nooping, url = %s, errCode = %s, uuidStatusCode = %d, time consumed = %d(ms)", string, aVarB.m.toString(), Integer.valueOf(aVarB.v), Long.valueOf(jCurrentTimeMillis2 - jCurrentTimeMillis)));
                OAuthErrCode oAuthErrCode2 = aVarB.m;
                if (oAuthErrCode2 != OAuthErrCode.WechatAuth_Err_OK) {
                    Log.e("MicroMsg.SDK.NoopingTask", String.format("nooping fail, errCode = %s, uuidStatusCode = %d", oAuthErrCode2.toString(), Integer.valueOf(aVarB.v)));
                    return aVarB;
                }
                int i2 = aVarB.v;
                this.t = i2;
                if (i2 == g.UUID_SCANED.getCode()) {
                    this.k.onQrcodeScanned();
                } else if (aVarB.v != g.UUID_KEEP_CONNECT.getCode() && aVarB.v == g.UUID_CONFIRM.getCode()) {
                    String str3 = aVarB.u;
                    if (str3 == null || str3.length() == 0) {
                        Log.e("MicroMsg.SDK.NoopingTask", "nooping fail, confirm with an empty code!!!");
                        aVarB.m = OAuthErrCode.WechatAuth_Err_NormalErr;
                    }
                    return aVarB;
                }
            }
            Log.i("MicroMsg.SDK.NoopingTask", "IDiffDevOAuth.stopAuth / detach invoked");
            aVar = new a();
            oAuthErrCode = OAuthErrCode.WechatAuth_Err_Auth_Stopped;
        }
        aVar.m = oAuthErrCode;
        return aVar;
    }

    @Override // android.os.AsyncTask
    public final /* synthetic */ void onPostExecute(a aVar) {
        a aVar2 = aVar;
        this.k.onAuthFinish(aVar2.m, aVar2.u);
    }
}
