package c.e.c.m0;

import c.e.a.d.w;
import com.alibaba.fastjson.JSON;
import com.chinavisionary.microtang.me.bo.ResponseManagerQrCodeBo;

/* JADX INFO: loaded from: classes2.dex */
public class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final o f1702a = new o();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ResponseManagerQrCodeBo f1703b;

    public static o getInstance() {
        return f1702a;
    }

    public ResponseManagerQrCodeBo getResponseManagerQrCodeBo() {
        return this.f1703b;
    }

    public void initData() {
        String string = w.getInstance().getString("managerQrCodeKey", null);
        if (string != null) {
            try {
                this.f1703b = (ResponseManagerQrCodeBo) JSON.parseObject(string, ResponseManagerQrCodeBo.class);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void setResponseManagerQrCodeBo(ResponseManagerQrCodeBo responseManagerQrCodeBo) {
        this.f1703b = responseManagerQrCodeBo;
        if (responseManagerQrCodeBo != null) {
            w.getInstance().putString("managerQrCodeKey", JSON.toJSONString(responseManagerQrCodeBo));
        } else {
            w.getInstance().remove("managerQrCodeKey");
        }
    }
}
