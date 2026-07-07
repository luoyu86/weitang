package com.chinavisionary.microtang.me.fragment;

import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.lifecycle.Observer;
import butterknife.BindView;
import butterknife.OnClick;
import c.e.a.a.c.c.a;
import c.e.a.d.i;
import c.e.a.d.q;
import c.e.a.d.x;
import c.e.c.m0.c;
import com.chinavisionary.core.app.event.EventUpdateUserInfoVo;
import com.chinavisionary.core.app.net.base.dto.NewResponseRowsVo;
import com.chinavisionary.core.app.net.base.dto.RequestErrDto;
import com.chinavisionary.core.weight.BaseSwipeRefreshLayout;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.base.BaseFragment;
import com.chinavisionary.microtang.bill.fragment.BillDetailsFragment;
import com.chinavisionary.microtang.hydropower.RechargeFragment;
import com.chinavisionary.microtang.me.adapter.WalletRecordAdapter;
import com.chinavisionary.microtang.me.model.NewUserOperateModel;
import com.chinavisionary.microtang.me.model.UserOperateModel;
import com.chinavisionary.microtang.me.vo.EventUpdateWallet;
import com.chinavisionary.microtang.me.vo.ResponseWalletVo;
import com.chinavisionary.microtang.me.vo.WalletRecordVo;
import g.b.a.m;
import g.b.a.r;
import java.math.BigDecimal;

/* JADX INFO: loaded from: classes.dex */
public class WalletFragment extends BaseFragment<WalletRecordVo> {
    public TextView B;
    public AppCompatButton C;
    public AppCompatButton D;
    public UserOperateModel E;
    public NewUserOperateModel F;
    public final a G = new a() { // from class: c.e.c.x.d.q2
        @Override // c.e.a.a.c.c.a
        public final void onItemClickListener(View view, int i2) {
            this.f2088a.L1(view, i2);
        }
    };

    @BindView(R.id.swipe_refresh_layout)
    public BaseSwipeRefreshLayout mSwipeRefreshLayout;

    @BindView(R.id.tv_title)
    public TextView mTitleTv;

    private void I0() {
        H();
        this.mSwipeRefreshLayout.setRefreshing(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: K1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void L1(View view, int i2) {
        String paymentAccountRecordKey = ((WalletRecordVo) this.t.getList().get(i2)).getPaymentAccountRecordKey();
        if (x.isNotNull(paymentAccountRecordKey)) {
            BillDetailsFragment billDetailsFragment = BillDetailsFragment.getInstance(null, 12340);
            billDetailsFragment.setRecordKey(paymentAccountRecordKey);
            K0(billDetailsFragment, R.id.flayout_content);
        }
    }

    public static WalletFragment getInstance() {
        return new WalletFragment();
    }

    public final WalletRecordVo E1() {
        WalletRecordVo walletRecordVo = new WalletRecordVo();
        walletRecordVo.setType(34952);
        return walletRecordVo;
    }

    public final void F1(RequestErrDto requestErrDto) {
        boolean zOpenTipActivity;
        if (requestErrDto != null) {
            int code = requestErrDto.getCode();
            zOpenTipActivity = c.getInstance().openTipActivity(this.f6487e, code);
            q.d(this.f6485c, "handleResponseErr errCode = " + code);
            if (zOpenTipActivity) {
                n();
            }
        } else {
            zOpenTipActivity = false;
        }
        if (zOpenTipActivity) {
            return;
        }
        C(requestErrDto);
    }

    public final void G1(NewResponseRowsVo<WalletRecordVo> newResponseRowsVo) {
        if (newResponseRowsVo != null && newResponseRowsVo.getSuccess() && newResponseRowsVo.getRows() != null) {
            if (this.f6483a == 1 && newResponseRowsVo.getRows().isEmpty()) {
                newResponseRowsVo.getRows().add(E1());
            }
            D(newResponseRowsVo.getRows());
        }
        I0();
    }

    public final void H1() {
        h0(this);
        this.mTitleTv.setText(R.string.title_me_account);
        this.r = this.mSwipeRefreshLayout.getBaseRecyclerView();
        WalletRecordAdapter walletRecordAdapter = new WalletRecordAdapter();
        this.t = walletRecordAdapter;
        walletRecordAdapter.setOnItemClickListener(this.G);
        P1();
    }

    public final void N1() {
        if (N()) {
            d(RechargeFragment.getInstance(7), R.id.flayout_content);
        }
    }

    public final void O1() {
        BigDecimal balance;
        if (this.B.getTag() == null || (balance = ((ResponseWalletVo) this.B.getTag()).getBalance()) == null) {
            return;
        }
        if (balance.floatValue() > 0.0f) {
            d(RollOutAlipayInputFragment.getInstance(x.bigDecimalToPlainString(balance)), R.id.flayout_content);
        } else {
            F0(R.string.tip_balance_is_nagative);
        }
    }

    public final void P1() {
        this.u.findViewById(R.id.constraint_layout_wallet).setVisibility(0);
        this.B = (TextView) this.u.findViewById(R.id.tv_account_surplus);
        this.D = (AppCompatButton) this.u.findViewById(R.id.btn_recharge_wallet);
        this.C = (AppCompatButton) this.u.findViewById(R.id.btn_roll_out_wallet);
        View viewFindViewById = this.u.findViewById(R.id.view_wallet_bottom_line);
        this.C.setVisibility(0);
        viewFindViewById.setVisibility(8);
        this.D.setOnClickListener(this.y);
        this.C.setOnClickListener(this.y);
    }

    public final void Q1(RequestErrDto requestErrDto) {
        F1(requestErrDto);
        B();
        I0();
    }

    public final void R1() {
        if (c.e.a.a.a.getInstance().isH5Model()) {
            NewUserOperateModel newUserOperateModel = (NewUserOperateModel) h(NewUserOperateModel.class);
            this.F = newUserOperateModel;
            newUserOperateModel.getWalletResult().observe(this, new Observer() { // from class: c.e.c.x.d.o2
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    this.f2080a.S1((ResponseWalletVo) obj);
                }
            });
        }
        UserOperateModel userOperateModel = (UserOperateModel) h(UserOperateModel.class);
        this.E = userOperateModel;
        userOperateModel.getWalletResult().observe(this, new Observer() { // from class: c.e.c.x.d.o2
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f2080a.S1((ResponseWalletVo) obj);
            }
        });
        this.E.getWalletRecordList().observe(this, new Observer() { // from class: c.e.c.x.d.r2
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f2093a.G1((NewResponseRowsVo) obj);
            }
        });
        this.E.getErrRequestLiveData().observe(this, new Observer() { // from class: c.e.c.x.d.p2
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f2084a.Q1((RequestErrDto) obj);
            }
        });
    }

    public final void S1(ResponseWalletVo responseWalletVo) {
        if (responseWalletVo != null) {
            i.getInstance().setWalletBalance(responseWalletVo.getBalance());
            this.D.setVisibility((responseWalletVo.isRechargeable() || c.e.c.x.c.a.getInstance().isShowWalletTest() || c.e.c.x.c.a.getInstance().isShowWallet()) ? 0 : 8);
            BigDecimal balance = responseWalletVo.getBalance();
            if (balance != null) {
                this.C.setVisibility((balance.floatValue() > 0.0f ? 1 : (balance.floatValue() == 0.0f ? 0 : -1)) <= 0 ? 8 : 0);
            }
            this.B.setTag(responseWalletVo);
            this.B.setText(x.getNotNullStr(x.bigDecimalToPlainString(balance), x.bigDecimalToPlainString(new BigDecimal("0.00"))));
        }
        k(new EventUpdateWallet());
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void V(View view) {
        if (M0(view)) {
            int id = view.getId();
            if (id == R.id.btn_recharge_wallet) {
                N1();
            } else {
                if (id != R.id.btn_roll_out_wallet) {
                    return;
                }
                O1();
            }
        }
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void W() {
        H1();
        R1();
        z0(R.string.loading_text);
        j0();
    }

    @OnClick({R.id.tv_back})
    public void backClick(View view) {
        n();
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public int getLayoutId() {
        return R.layout.fragment_wallet;
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void j0() {
        if (this.f6483a == 1) {
            NewUserOperateModel newUserOperateModel = this.F;
            if (newUserOperateModel != null) {
                newUserOperateModel.getWalletBalance();
            } else {
                this.E.getWalletBalance();
            }
        }
        this.E.getWalletRecordList(r());
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        L0(this);
    }

    @m(threadMode = r.MAIN)
    public void updateWalletState(EventUpdateUserInfoVo eventUpdateUserInfoVo) {
        if (eventUpdateUserInfoVo.getWhatMsg() == 2) {
            this.f6483a = 1;
            j0();
        }
    }
}
