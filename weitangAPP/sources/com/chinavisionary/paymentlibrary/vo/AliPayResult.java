package com.chinavisionary.paymentlibrary.vo;

import android.text.TextUtils;
import com.alipay.sdk.m.u.i;
import com.alipay.sdk.m.u.l;
import com.chinavisionary.core.app.net.base.dto.BaseVo;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class AliPayResult extends BaseVo {
    private String memo;
    private String result;
    private String resultStatus;

    public AliPayResult(Map<String, String> map) {
        if (map == null) {
            return;
        }
        for (String str : map.keySet()) {
            if (TextUtils.equals(str, l.f5707a)) {
                this.resultStatus = map.get(str);
            } else if (TextUtils.equals(str, "result")) {
                this.result = map.get(str);
            } else if (TextUtils.equals(str, l.f5708b)) {
                this.memo = map.get(str);
            }
        }
    }

    public String getMemo() {
        return this.memo;
    }

    public String getResult() {
        return this.result;
    }

    public String getResultStatus() {
        return this.resultStatus;
    }

    public String toString() {
        return "resultStatus={" + this.resultStatus + "};memo={" + this.memo + "};result={" + this.result + i.f5699d;
    }
}
