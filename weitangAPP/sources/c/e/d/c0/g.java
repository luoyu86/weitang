package c.e.d.c0;

import android.app.Activity;
import c.e.a.d.x;
import com.chinavisionary.paymentlibrary.R;

/* JADX INFO: loaded from: classes2.dex */
public class g extends d {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public d f2293c;

    public g(Activity activity, int i2, e eVar) {
        super(activity);
        d dVarA = f.a(activity, i2, eVar);
        this.f2293c = dVarA;
        if (dVarA == null) {
            e(eVar);
        }
    }

    @Override // c.e.d.c0.d
    public void requestPay(String str) {
        d dVar = this.f2293c;
        if (dVar != null) {
            dVar.requestPay(str);
        } else {
            b(a(x.getString(R.string.core_lib_tip_pay_channel_is_empty)));
        }
    }
}
