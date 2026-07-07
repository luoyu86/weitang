package c.e.c.c0.c;

import androidx.annotation.NonNull;
import androidx.annotation.StringRes;
import androidx.lifecycle.Observer;
import c.e.a.d.x;
import com.chinavisionary.core.app.base.CoreBaseFragment;
import com.chinavisionary.core.app.config.bo.LeftTitleToRightArrowVo;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.auth.IDAuthActivity;
import com.chinavisionary.microtang.base.BaseFragment;
import com.chinavisionary.microtang.contract.ContractActivity;
import com.chinavisionary.microtang.pre.model.ReserveModel;
import com.chinavisionary.microtang.pre.vo.ReserveCancelResultVo;
import com.chinavisionary.microtang.pre.vo.ReserveDetailsVo;
import com.chinavisionary.microtang.pre.vo.ReserveFddContractVo;
import com.chinavisionary.microtang.pre.vo.ReserveItemVo;
import com.chinavisionary.microtang.room.fragment.AirQualityFragment;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public BaseFragment f1414a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ReserveModel f1415b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public a f1416c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public c f1417d = new c();

    public interface a {
        void addFragment(CoreBaseFragment coreBaseFragment);

        void hideAlertLoading();

        void openActivityToClass(Class cls);

        void refreshPage();

        void showAlertLoading(@StringRes int i2);

        void showToast(@StringRes int i2);

        void switchFragment(CoreBaseFragment coreBaseFragment);

        boolean userIsAuth();
    }

    public d(@NonNull ReserveModel reserveModel, @NonNull BaseFragment baseFragment) {
        this.f1415b = reserveModel;
        this.f1414a = baseFragment;
        j();
    }

    public final void a(ReserveCancelResultVo reserveCancelResultVo) {
        a aVar = this.f1416c;
        if (aVar != null) {
            aVar.hideAlertLoading();
            if (reserveCancelResultVo == null) {
                k(R.string.tip_cancel_failed);
            } else {
                k(R.string.tip_cancel_success);
                this.f1416c.refreshPage();
            }
        }
    }

    public final void b(ReserveFddContractVo reserveFddContractVo) {
        a aVar = this.f1416c;
        if (aVar != null) {
            aVar.hideAlertLoading();
        }
        if (this.f1416c == null || reserveFddContractVo == null || !reserveFddContractVo.isSuccess()) {
            k(R.string.title_get_contract_failed);
        } else if (x.isNotNull(reserveFddContractVo.getReserveSignUrl())) {
            this.f1416c.switchFragment(this.f1417d.c(reserveFddContractVo));
        } else {
            k(R.string.title_get_contract_failed);
        }
    }

    public final void c(ReserveItemVo reserveItemVo) {
        a aVar = this.f1416c;
        if (aVar != null) {
            if (!aVar.userIsAuth()) {
                g();
            } else {
                this.f1416c.showAlertLoading(R.string.loading_text);
                this.f1415b.getReserveFddContract(reserveItemVo.getPrimaryKey());
            }
        }
    }

    public final void f() {
        l(ContractActivity.class);
    }

    public final void g() {
        k(R.string.tip_auth_sign_protocol);
        l(IDAuthActivity.class);
    }

    public List<LeftTitleToRightArrowVo> getDetailsListData(ReserveDetailsVo reserveDetailsVo, String str, int i2) {
        return this.f1417d.a(reserveDetailsVo, str, i2);
    }

    public final void h(ReserveItemVo reserveItemVo) {
        a aVar = this.f1416c;
        if (aVar != null) {
            aVar.switchFragment(this.f1417d.b(reserveItemVo));
        }
    }

    public void handleActionToReserveItemVoe(@NonNull ReserveItemVo reserveItemVo) {
        int status = reserveItemVo.getStatus();
        if (status == 1) {
            h(reserveItemVo);
            return;
        }
        if (status == 2) {
            c(reserveItemVo);
        } else if (status == 5) {
            i(reserveItemVo);
        } else {
            if (status != 8) {
                return;
            }
            f();
        }
    }

    public final void i(ReserveItemVo reserveItemVo) {
        a aVar = this.f1416c;
        if (aVar == null || this.f1414a == null) {
            return;
        }
        if (!aVar.userIsAuth()) {
            g();
        } else {
            this.f1416c.addFragment(AirQualityFragment.getInstance(reserveItemVo.getAssetKey(), false));
        }
    }

    public final void j() {
        this.f1415b.getResponseFddVoLiveData().observe(this.f1414a, new Observer() { // from class: c.e.c.c0.c.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f1412a.b((ReserveFddContractVo) obj);
            }
        });
        this.f1415b.getCancelResultVoLiveData().observe(this.f1414a, new Observer() { // from class: c.e.c.c0.c.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f1413a.a((ReserveCancelResultVo) obj);
            }
        });
    }

    public final void k(@StringRes int i2) {
        a aVar = this.f1416c;
        if (aVar != null) {
            aVar.showToast(i2);
        }
    }

    public final void l(Class cls) {
        a aVar = this.f1416c;
        if (aVar != null) {
            aVar.openActivityToClass(cls);
        }
    }

    public void requestCancelPay(String str) {
        this.f1415b.cancelReservePay(str);
    }

    public void setIView(@NonNull a aVar) {
        this.f1416c = aVar;
    }

    public boolean updateTimer(List<ReserveItemVo> list) {
        return this.f1417d.e(list);
    }
}
