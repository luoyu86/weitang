package c.e.d.y;

import android.app.AlertDialog;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.StringRes;
import c.e.a.d.v;
import c.e.a.d.x;
import com.alibaba.android.arouter.launcher.ARouter;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.chinavisionary.core.app.net.base.dto.BaseVo;
import com.chinavisionary.paymentlibrary.R;
import com.chinavisionary.paymentlibrary.model.BillModel;
import com.chinavisionary.paymentlibrary.model.NewBillModel;

/* JADX INFO: loaded from: classes2.dex */
public abstract class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public View f2336a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TextView f2337b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public o f2338c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public AlertDialog f2339d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public BillModel f2340e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public NewBillModel f2341f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f2342g;

    public l(View view, BillModel billModel, o oVar) {
        this.f2336a = view;
        this.f2340e = billModel;
        this.f2338c = oVar;
        d();
    }

    public void a(boolean z) {
        o oVar = this.f2338c;
        if (oVar != null) {
            oVar.finishFragmentOrActivity(z);
        }
    }

    public void b() {
        o oVar = this.f2338c;
        if (oVar != null) {
            oVar.hiedAlertLoading();
            this.f2338c.showToast(R.string.payment_lib_tip_param_err);
        }
    }

    public void c() {
        o oVar = this.f2338c;
        if (oVar != null) {
            oVar.hiedAlertLoading();
        }
    }

    public final void d() {
        View view = this.f2336a;
        if (view != null) {
            this.f2337b = (TextView) view.findViewById(R.id.tv_pay_price);
        }
    }

    public void e(int i2) {
        o oVar = this.f2338c;
        if (oVar == null || oVar.getCurrentActivity() == null) {
            return;
        }
        ARouter.getInstance().build("/bill_tab/bill_tab").withInt(RequestParameters.POSITION, i2).navigation();
    }

    public void f() {
        k("/contract/contract");
    }

    public void g(boolean z) {
        c.e.a.d.q.d("openPaySuccessTipActivity", "setupAppletJsonData mAppletJsonData = " + this.f2342g);
        if (v.getInstance().isRepeatedlyAction("openPaySuccessTipActivity", 1000)) {
            return;
        }
        ARouter.getInstance().build("/pay_success_tip/pay_success_tip").withBoolean("isOpenOrder", z).withString("appletJsonKey", this.f2342g).navigation();
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0112  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.util.List<com.chinavisionary.paymentlibrary.vo.PayChannelVo> getPayChannelList(com.chinavisionary.paymentlibrary.vo.CreatePayChannelVo r10) {
        /*
            Method dump skipped, instruction units count: 366
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: c.e.d.y.l.getPayChannelList(com.chinavisionary.paymentlibrary.vo.CreatePayChannelVo):java.util.List");
    }

    public void h(@StringRes int i2) {
        o oVar = this.f2338c;
        if (oVar != null) {
            oVar.showAlertLoading(i2);
        }
    }

    public abstract void handlePayFailed();

    public abstract void handlePaySuccessResult();

    public void i(String str, View.OnClickListener onClickListener) {
        o oVar = this.f2338c;
        if (oVar == null || oVar.getCurrentActivity() == null) {
            return;
        }
        AlertDialog alertDialog = this.f2339d;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
        this.f2339d = c.e.a.a.e.p.showAlert(this.f2338c.getCurrentActivity(), null, str, x.getString(R.string.core_lib_title_confirm), x.getString(R.string.core_lib_title_cancel), onClickListener, false);
    }

    public abstract void initData(BaseVo baseVo);

    public void j(String str, View.OnClickListener onClickListener) {
        o oVar = this.f2338c;
        if (oVar == null || oVar.getCurrentActivity() == null) {
            return;
        }
        AlertDialog alertDialog = this.f2339d;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
        this.f2339d = c.e.a.a.e.p.showAlertOnlyConfirm(this.f2338c.getCurrentActivity(), null, str, x.getString(R.string.core_lib_title_confirm), x.getString(R.string.core_lib_title_cancel), onClickListener, false);
    }

    public void k(String str) {
        if (x.isNotNull(str)) {
            ARouter.getInstance().build(str).navigation();
        }
    }

    public abstract void requestGetPaySign(BaseVo baseVo, int i2);

    public void setNewBillModel(NewBillModel newBillModel) {
        this.f2341f = newBillModel;
    }

    public void setupAppletJsonData(String str) {
        this.f2342g = str;
        c.e.a.d.q.d("openPaySuccessTipActivity", "setupAppletJsonData appletJsonData = " + str);
    }
}
