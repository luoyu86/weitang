package c.e.d.c0;

import android.app.Activity;
import c.e.a.d.x;
import com.chinavisionary.core.app.net.base.dto.ResponseStateVo;
import com.chinavisionary.paymentlibrary.R;

/* JADX INFO: loaded from: classes2.dex */
public abstract class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Activity f2291a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public e f2292b;

    public d(Activity activity) {
        this.f2291a = activity;
    }

    public ResponseStateVo a(String str) {
        ResponseStateVo responseStateVo = new ResponseStateVo();
        responseStateVo.setSuccess(false);
        responseStateVo.setMessage(str);
        return responseStateVo;
    }

    public void b(ResponseStateVo responseStateVo) {
        e eVar = this.f2292b;
        if (eVar != null) {
            eVar.payFailed(responseStateVo);
        }
    }

    public void c() {
        e eVar = this.f2292b;
        if (eVar != null) {
            eVar.paySuccess();
        }
    }

    public void d() {
        b(a(x.getString(R.string.payment_lib_title_sign_parse_failed)));
    }

    public void e(e eVar) {
        this.f2292b = eVar;
    }

    public void recycler() {
        this.f2291a = null;
        this.f2292b = null;
    }

    public abstract void requestPay(String str);
}
