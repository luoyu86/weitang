package c.e.c.x.e;

import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.lifecycle.Observer;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.hydropower.RechargeFragment;
import com.chinavisionary.microtang.me.WalletActivity;
import com.chinavisionary.microtang.me.model.NewUserOperateModel;
import com.chinavisionary.microtang.me.model.UserOperateModel;
import com.chinavisionary.microtang.me.vo.ResponseWalletVo;
import java.math.BigDecimal;

/* JADX INFO: loaded from: classes.dex */
public class p0 extends a0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public View f2203b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public TextView f2204c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public AppCompatButton f2205d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public UserOperateModel f2206e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public NewUserOperateModel f2207f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final View.OnClickListener f2208g;

    public p0(g0 g0Var) {
        super(g0Var);
        this.f2208g = new View.OnClickListener() { // from class: c.e.c.x.e.y
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f2220a.d(view);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void d(View view) {
        g0 g0Var = this.f2122a;
        if (g0Var == null || !g0Var.isLoginApp()) {
            return;
        }
        int id = view.getId();
        if (id == R.id.btn_recharge_wallet) {
            f();
        } else {
            if (id != R.id.constraint_layout_wallet) {
                return;
            }
            e();
        }
    }

    public final void e() {
        a(WalletActivity.class);
    }

    public final void f() {
        this.f2122a.addFragment(RechargeFragment.getInstance(7));
    }

    public final void g() {
        NewUserOperateModel newUserOperateModel = this.f2207f;
        if (newUserOperateModel != null) {
            newUserOperateModel.getWalletResult().observe(this.f2122a.getCurrentActivity(), new Observer() { // from class: c.e.c.x.e.z
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    this.f2221a.h((ResponseWalletVo) obj);
                }
            });
        }
        this.f2206e.getWalletResult().observe(this.f2122a.getCurrentActivity(), new Observer() { // from class: c.e.c.x.e.z
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f2221a.h((ResponseWalletVo) obj);
            }
        });
    }

    public final void h(ResponseWalletVo responseWalletVo) {
        if (responseWalletVo != null) {
            setupIsShowRechargeWalletBtn(responseWalletVo.isRechargeable() || c.e.c.x.c.a.getInstance().isShowWallet() || c.e.c.x.c.a.getInstance().isShowWalletTest());
            c.e.a.d.i.getInstance().setWalletBalance(responseWalletVo.getBalance());
            this.f2204c.setText(c.e.a.d.x.getNotNullStr(c.e.a.d.x.bigDecimalToPlainString(responseWalletVo.getBalance()), c.e.a.d.x.bigDecimalToPlainString(new BigDecimal("0.00"))));
        }
    }

    public void initWalletView(View view) {
        View viewFindViewById = view.findViewById(R.id.constraint_layout_wallet);
        this.f2203b = viewFindViewById;
        viewFindViewById.setOnClickListener(this.f2208g);
        this.f2204c = (TextView) view.findViewById(R.id.tv_account_surplus);
        AppCompatButton appCompatButton = (AppCompatButton) view.findViewById(R.id.btn_recharge_wallet);
        this.f2205d = appCompatButton;
        appCompatButton.setOnClickListener(this.f2208g);
    }

    public void setUserOperateModel(UserOperateModel userOperateModel, NewUserOperateModel newUserOperateModel) {
        this.f2206e = userOperateModel;
        this.f2207f = newUserOperateModel;
        g();
    }

    public void setupIsShowRechargeWalletBtn(boolean z) {
        this.f2205d.setVisibility(z ? 0 : 8);
    }

    public void setupIsShowWallet(boolean z) {
        this.f2203b.setVisibility(z ? 0 : 8);
    }
}
