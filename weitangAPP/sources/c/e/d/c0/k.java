package c.e.d.c0;

import android.app.Activity;
import c.e.a.d.x;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.chinavisionary.core.app.net.base.dto.ResponseStateVo;
import com.chinavisionary.paymentlibrary.R;

/* JADX INFO: loaded from: classes2.dex */
public class k extends d {
    public k(Activity activity) {
        super(activity);
    }

    @Override // c.e.d.c0.d
    public void requestPay(String str) {
        try {
            ResponseStateVo responseStateVo = (ResponseStateVo) JSON.parseObject(str, ResponseStateVo.class);
            if (responseStateVo.isSuccess()) {
                c();
                return;
            }
            String message = responseStateVo.getMessage();
            if (x.isNullStr(message)) {
                message = x.getString(R.string.payment_lib_tip_pay_failed);
            }
            b(a(message));
        } catch (JSONException e2) {
            e2.printStackTrace();
            d();
        }
    }
}
