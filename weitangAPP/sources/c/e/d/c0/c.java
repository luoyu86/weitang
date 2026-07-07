package c.e.d.c0;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import c.e.a.d.q;
import c.e.a.d.x;
import com.chinavisionary.paymentlibrary.R;

/* JADX INFO: loaded from: classes2.dex */
public class c extends d {
    public c(Activity activity) {
        super(activity);
    }

    public final void f(Context context, String str) {
        if (!str.contains("http")) {
            b(a(x.getString(R.string.payment_lib_tip_pay_failed_qr)));
            return;
        }
        try {
            Intent intent = new Intent();
            intent.setFlags(268435456);
            intent.setAction("android.intent.action.VIEW");
            intent.setData(Uri.parse("alipays://platformapi/startapp?appId=20000067&url=" + str));
            q.d(getClass().getSimpleName(), "getPaySign url = " + str);
            context.startActivity(intent);
        } catch (Exception e2) {
            e2.printStackTrace();
            b(a("支付失败，您未安装支付宝，请下载安装支付宝。"));
        }
    }

    @Override // c.e.d.c0.d
    public void requestPay(String str) {
        if (x.isNotNull(str)) {
            f(this.f2291a, str);
        }
    }
}
