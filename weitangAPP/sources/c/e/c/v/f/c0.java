package c.e.c.v.f;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.chinavisionary.core.app.config.bo.AppConfigExtVo;
import com.chinavisionary.core.scan.ScanResultVo;
import com.chinavisionary.microtang.R;

/* JADX INFO: loaded from: classes.dex */
public class c0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public z f1944a;

    public c0(z zVar) {
        this.f1944a = zVar;
    }

    public final void a(int i2, String str, String str2) {
        z zVar = this.f1944a;
        if (zVar != null) {
            zVar.handleForward(i2, str, str2);
        }
    }

    public void b(AppConfigExtVo appConfigExtVo, String str) {
        if (appConfigExtVo == null || !c.e.a.d.x.isNotNull(appConfigExtVo.getCommonPublicKey()) || this.f1944a == null) {
            c(str);
            c.e.a.d.q.d(c0.class.getSimpleName(), "getCommonPublicKey is null");
            return;
        }
        try {
            String strDecryptByPublicKey = c.e.a.d.d0.c.decryptByPublicKey(str, appConfigExtVo.getCommonPublicKey());
            if (strDecryptByPublicKey.indexOf("{") == 0 && strDecryptByPublicKey.lastIndexOf(com.alipay.sdk.m.u.i.f5699d) == strDecryptByPublicKey.length() - 1) {
                try {
                    ScanResultVo scanResultVo = (ScanResultVo) JSON.parseObject(strDecryptByPublicKey, ScanResultVo.class);
                    a(scanResultVo.getType(), scanResultVo.getKey(), null);
                } catch (JSONException e2) {
                    e2.printStackTrace();
                    c.e.a.d.q.d(getClass().getSimpleName(), "ScanResultVo parse err");
                    c(strDecryptByPublicKey);
                }
            } else {
                c(strDecryptByPublicKey);
            }
        } catch (Exception e3) {
            e3.printStackTrace();
            c.e.a.d.q.d(c0.class.getSimpleName(), "data parse err");
            c(str);
        }
    }

    public final void c(String str) {
        a(1, str, c.e.a.d.x.getString(R.string.scan_code_title));
    }
}
