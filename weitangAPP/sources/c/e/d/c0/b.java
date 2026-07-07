package c.e.d.c0;

import android.app.Activity;
import android.text.TextUtils;
import c.e.a.d.q;
import c.e.a.d.x;
import c.e.a.d.y;
import com.alipay.sdk.app.PayTask;
import com.chinavisionary.paymentlibrary.R;
import com.chinavisionary.paymentlibrary.vo.AliPayResult;

/* JADX INFO: loaded from: classes2.dex */
public class b extends d {
    public b(Activity activity) {
        super(activity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void g(String str) {
        if (x.isNotNull(str)) {
            AliPayResult aliPayResult = new AliPayResult(new PayTask(this.f2291a).payV2(str, true));
            String memo = aliPayResult.getMemo();
            if (TextUtils.equals(aliPayResult.getResultStatus(), "9000")) {
                c();
                return;
            }
            if (x.isNullStr(memo)) {
                memo = x.getString(R.string.payment_lib_tip_pay_failed);
            }
            b(a(memo));
            q.d("requestPay", "handlePayFailed resultInfo： " + memo);
        }
    }

    @Override // c.e.d.c0.d
    public void requestPay(final String str) {
        y.get().addRunnable(new Runnable() { // from class: c.e.d.c0.a
            @Override // java.lang.Runnable
            public final void run() {
                this.f2289a.g(str);
            }
        });
    }
}
