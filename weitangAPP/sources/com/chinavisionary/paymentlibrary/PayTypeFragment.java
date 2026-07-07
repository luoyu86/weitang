package com.chinavisionary.paymentlibrary;

import android.os.Build;
import android.os.Message;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import butterknife.BindView;
import butterknife.OnClick;
import c.e.a.d.i;
import c.e.a.d.q;
import c.e.a.d.x;
import c.e.a.d.z;
import c.e.d.c0.h;
import c.e.d.y.l;
import c.e.d.y.o;
import c.e.d.y.r;
import cn.com.heaton.blelibrary.ble.BleStates;
import com.alibaba.fastjson.JSON;
import com.chinavisionary.core.app.base.CoreBaseFragment;
import com.chinavisionary.core.app.config.bo.LeftTitleToRightArrowVo;
import com.chinavisionary.core.app.net.base.dto.RequestErrDto;
import com.chinavisionary.core.weight.BaseRecyclerView;
import com.chinavisionary.paymentlibrary.adapter.PayFeeAdapter;
import com.chinavisionary.paymentlibrary.adapter.PaymentCouponAdapter;
import com.chinavisionary.paymentlibrary.fragment.CardCouponFragment;
import com.chinavisionary.paymentlibrary.model.BillModel;
import com.chinavisionary.paymentlibrary.model.NewBillModel;
import com.chinavisionary.paymentlibrary.model.NewPayModel;
import com.chinavisionary.paymentlibrary.model.PayModel;
import com.chinavisionary.paymentlibrary.view.PayChannelView;
import com.chinavisionary.paymentlibrary.vo.CouponMutexVo;
import com.chinavisionary.paymentlibrary.vo.CreatePayChannelVo;
import com.chinavisionary.paymentlibrary.vo.EventPayStateVo;
import com.chinavisionary.paymentlibrary.vo.H5CreatePayBillBo;
import com.chinavisionary.paymentlibrary.vo.PayBillResultVo;
import com.chinavisionary.paymentlibrary.vo.PayBillVo;
import com.chinavisionary.paymentlibrary.vo.PayCostTypeVo;
import com.chinavisionary.paymentlibrary.vo.PayCouponVo;
import com.chinavisionary.paymentlibrary.vo.PayStateVo;
import com.chinavisionary.paymentlibrary.vo.PayTypeVo;
import com.chinavisionary.paymentlibrary.vo.RequestOrderTicketBo;
import com.chinavisionary.paymentlibrary.vo.RequestUseCouponParamBo;
import com.chinavisionary.paymentlibrary.vo.ResponseCouponVo;
import com.chinavisionary.paymentlibrary.vo.ResponseH5BillDetailsVo;
import com.chinavisionary.paymentlibrary.vo.ResponseOrderTicketBo;
import com.chinavisionary.paymentlibrary.vo.ResponsePayModeBo;
import com.chinavisionary.paymentlibrary.vo.ResponseUseCouponResultBo;
import com.chinavisionary.paymentlibrary.vo.ResponseUserCouponResultItemVo;
import com.chinavisionary.paymentlibrary.vo.ResponseWalletVo;
import com.chinavisionary.paymentlibrary.vo.SelectCouponResultVo;
import g.b.a.m;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import org.android.agoo.common.AgooConstants;

/* JADX INFO: loaded from: classes2.dex */
public class PayTypeFragment extends CoreBaseFragment<LeftTitleToRightArrowVo> {
    public long C;
    public boolean D;
    public BillModel E;
    public NewBillModel F;
    public PayModel G;
    public NewPayModel H;
    public CreatePayChannelVo I;
    public String J;
    public PayTypeVo K;
    public l L;
    public BigDecimal M;
    public boolean N;
    public SelectCouponResultVo O;
    public ResponseH5BillDetailsVo P;
    public List<PayCouponVo> Q;
    public List<PayCostTypeVo> R;
    public List<ResponseUserCouponResultItemVo> S;
    public PayFeeAdapter T;
    public h U;
    public PaymentCouponAdapter V;
    public PayCouponVo W;
    public PayCouponVo c0;
    public ResponseOrderTicketBo c1;

    @BindView(2288)
    public AppCompatButton mConfirmPayBtn;

    @BindView(2857)
    public TextView mCouponTitleTv;

    @BindView(2847)
    public TextView mCouponValueTv;

    @BindView(2872)
    public TextView mPayChannelTitleTv;

    @BindView(2493)
    public PayChannelView mPayChannelView;

    @BindView(BleStates.BleStatus.Write)
    public BaseRecyclerView mPayCostListRecyclerView;

    @BindView(2873)
    public TextView mPayCountdownTv;

    @BindView(BleStates.BleStatus.Changed)
    public BaseRecyclerView mPayCouponListRecyclerView;

    @BindView(2874)
    public TextView mPayCouponTitleTv;

    @BindView(2877)
    public TextView mPayLateFeeTv;

    @BindView(2878)
    public TextView mPayPriceTv;

    @BindView(2879)
    public TextView mPaySrcPriceTv;

    @BindView(2880)
    public TextView mPayTitleTv;

    @BindView(2922)
    public View mTitleBgView;

    @BindView(2898)
    public TextView mTitleTv;
    public int A = 2;
    public Long B = null;
    public int A0 = -1;
    public volatile boolean C0 = false;
    public final o A1 = new a();
    public final c.e.d.a0.a C1 = new b();
    public final c.e.a.a.c.c.a A2 = new c.e.a.a.c.c.a() { // from class: c.e.d.x
        @Override // c.e.a.a.c.c.a
        public final void onItemClickListener(View view, int i2) {
            this.f2324a.Z1(view, i2);
        }
    };
    public final Runnable W2 = new d();

    public class a implements o {
        public a() {
        }

        @Override // c.e.d.y.o
        public void addFragmentToActivity(CoreBaseFragment coreBaseFragment) {
            PayTypeFragment.this.n2(coreBaseFragment);
        }

        @Override // c.e.d.y.o
        public void finishFragmentOrActivity(boolean z) {
            if (z) {
                PayTypeFragment.this.n();
            } else {
                PayTypeFragment.this.m();
            }
        }

        @Override // c.e.d.y.o
        public FragmentActivity getCurrentActivity() {
            return PayTypeFragment.this.getActivity();
        }

        @Override // c.e.d.y.o
        public CoreBaseFragment getCurrentFragment() {
            return PayTypeFragment.this;
        }

        @Override // c.e.d.y.o
        public void handleRequestErr(RequestErrDto requestErrDto) {
            PayTypeFragment.this.C(requestErrDto);
        }

        @Override // c.e.d.y.o
        public void hiedAlertLoading() {
            PayTypeFragment.this.H();
        }

        @Override // c.e.d.y.o
        public void showAlertLoading(int i2) {
            PayTypeFragment.this.z0(i2);
        }

        @Override // c.e.d.y.o
        public void showToast(int i2) {
            PayTypeFragment.this.F0(i2);
        }

        @Override // c.e.d.y.o
        public void updatePayPrice(String str) {
            PayTypeFragment.this.G2(str);
        }

        @Override // c.e.d.y.o
        public boolean userIsAuth() {
            return PayTypeFragment.this.M();
        }

        @Override // c.e.d.y.o
        public void showToast(String str) {
            PayTypeFragment.this.G0(str);
        }
    }

    public class b implements c.e.d.a0.a {
        public b() {
        }

        @Override // c.e.d.a0.a
        public void onSelectCouponResult(List<PayCouponVo> list, List<ResponseUserCouponResultItemVo> list2, SelectCouponResultVo selectCouponResultVo, BigDecimal bigDecimal) {
            PayTypeFragment.this.P.setActualAmount(bigDecimal);
            PayTypeFragment.this.Q = list;
            PayTypeFragment.this.O = selectCouponResultVo;
            PayTypeFragment.this.S = list2;
            if (PayTypeFragment.this.T != null) {
                h.updateSelectCoupon(list2, PayTypeFragment.this.T.getList());
                PayTypeFragment.this.T.notifyDataSetChanged();
            }
            PayTypeFragment payTypeFragment = PayTypeFragment.this;
            payTypeFragment.D2(payTypeFragment.Q);
            PayTypeFragment.this.E2();
        }
    }

    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PayTypeFragment.this.o1();
        }
    }

    public class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            PayTypeFragment.Y0(PayTypeFragment.this);
            if (PayTypeFragment.this.f6488f != null) {
                PayTypeFragment.this.f6488f.postDelayed(this, 1000L);
                PayTypeFragment.this.f6488f.obtainMessage(1).sendToTarget();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: V1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void W1(View view) {
        if (view.getId() == R.id.tv_alert_confirm) {
            k1();
        }
    }

    public static /* synthetic */ long Y0(PayTypeFragment payTypeFragment) {
        long j = payTypeFragment.C;
        payTypeFragment.C = j - 1;
        return j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: Y1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void Z1(View view, int i2) {
        if (this.V.getList().get(i2).isUnavailable()) {
            return;
        }
        s1(i2, !this.V.getList().get(i2).isCheck());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: c2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void d2(ResponseWalletVo responseWalletVo) {
        if (responseWalletVo == null || !responseWalletVo.isSuccess()) {
            return;
        }
        this.M = responseWalletVo.getBalance();
        i.getInstance().setWalletBalance(this.M);
        this.I.setBigDecimal(this.M);
        x2();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: e2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void f2(EventPayStateVo eventPayStateVo) {
        String msg = eventPayStateVo.getMsg();
        if (x.isNotNull(msg)) {
            i("subscribePayResult base handle errMsg:" + msg);
            this.f6488f.obtainMessage(1000, msg).sendToTarget();
        }
    }

    public static PayTypeFragment getInstance(PayTypeVo payTypeVo) {
        PayTypeFragment payTypeFragment = new PayTypeFragment();
        payTypeFragment.K = payTypeVo;
        return payTypeFragment;
    }

    public final void A1(PayStateVo payStateVo) {
    }

    public final void A2(boolean z) {
        y2(false);
        this.mPayTitleTv.setText(m1());
        w2();
    }

    public final void B1(ResponseUseCouponResultBo responseUseCouponResultBo) {
        H();
        if (!responseUseCouponResultBo.isSuccess()) {
            G0(responseUseCouponResultBo.getMessage());
            return;
        }
        BigDecimal originalAmount = responseUseCouponResultBo.getOriginalAmount();
        List<ResponseUserCouponResultItemVo> list = responseUseCouponResultBo.getList();
        SelectCouponResultVo selectCouponResultVo = h.getSelectCouponResultVo(list);
        this.C1.onSelectCouponResult(selectCouponResultVo.getUserCouponList(), list, selectCouponResultVo, originalAmount);
    }

    public final void B2() {
        NewBillModel newBillModel = this.F;
        if (newBillModel != null) {
            newBillModel.getWalletResult().observe(this, new Observer() { // from class: c.e.d.n
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    this.f2313a.d2((ResponseWalletVo) obj);
                }
            });
            this.F.getPayModeResult().observe(this, new Observer() { // from class: c.e.d.u
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    this.f2321a.x1((ResponsePayModeBo) obj);
                }
            });
        }
        m2();
    }

    public final void C1(RequestErrDto requestErrDto) {
        boolean z = true;
        if (requestErrDto != null) {
            if (x.isNotNull(requestErrDto.getUrl())) {
                if (requestErrDto.getUrl().contains("business/company/pay/find/paymode")) {
                    String string = x.getString(R.string.pay_lib_pay_mode_response_err);
                    if (x.isNullStr(requestErrDto.getErrMsg())) {
                        requestErrDto.setErrMsg(string);
                    } else {
                        requestErrDto.setErrMsg(x.appendStringToResId(R.string.pay_lib_pay_mode_err, requestErrDto.getErrMsg()));
                    }
                }
                if (requestErrDto.getUrl().contains(RequestErrDto.GET_ORDER_IS_TICKET_URL)) {
                    q.d(this.f6485c, "handleResponseErr url = " + requestErrDto.getUrl() + "msg : " + requestErrDto.getErrMsg());
                    z = false;
                }
                if (requestErrDto.getUrl().contains("business/order/addcoupon/preview")) {
                    q.d(this.f6485c, "handleResponseErr url = " + requestErrDto.getUrl() + "msg : " + requestErrDto.getErrMsg());
                    if (this.A0 >= 0) {
                        this.V.getList().get(this.A0).setCheck(false);
                        this.V.notifyItemChanged(this.A0);
                    }
                }
            }
            q.d(this.f6485c, "handleResponseErr url = " + requestErrDto.getUrl() + "msg : " + requestErrDto.getErrMsg());
        }
        if (z) {
            C(requestErrDto);
        }
    }

    public final void C2() {
        CoreBaseFragment.c cVar = this.f6488f;
        if (cVar != null) {
            cVar.removeCallbacksAndMessages(null);
        }
    }

    public final void D1() {
        this.U = new h();
        PaymentCouponAdapter paymentCouponAdapter = new PaymentCouponAdapter(false);
        this.V = paymentCouponAdapter;
        paymentCouponAdapter.setOnClickListener(this.y);
        this.V.setOnItemClickListener(this.A2);
        this.V.setEmptyTipMsg(x.getString(R.string.tip_coupon_is_empty));
        this.mPayCouponListRecyclerView.setAdapter(this.V);
    }

    public final void D2(List<PayCouponVo> list) {
        List<PayCouponVo> list2 = this.V.getList();
        List<String> payCouponVosToIds = this.U.getPayCouponVosToIds(list);
        if (c.e.a.d.o.isNotEmpty(list2)) {
            q.d(this.f6485c, "updateCouponSelectState couponId = " + JSON.toJSONString(payCouponVosToIds));
            for (PayCouponVo payCouponVo : list2) {
                q.d(this.f6485c, "updateCouponSelectState payCouponVo = " + JSON.toJSONString(payCouponVo));
                if (c.e.a.d.o.isNotEmpty(payCouponVosToIds)) {
                    payCouponVo.setCheck(payCouponVosToIds.contains(payCouponVo.getCouponId()));
                } else {
                    payCouponVo.setCheck(false);
                }
            }
        }
        this.c0 = null;
        this.V.notifyDataSetChanged();
    }

    public final void E1() {
        boolean z = c.e.a.d.o.isNotEmpty(this.R) && this.R.size() > 1;
        this.mPayCostListRecyclerView.setVisibility(z ? 0 : 8);
        if (z) {
            this.T.initListData(this.R);
        }
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void E2() {
        if (this.O != null) {
            String strBigDecimalToString = x.bigDecimalToString(this.P.getActualAmount());
            if (this.O.getCouponTotal() > 0) {
                BigDecimal couponValueTotal = this.O.getCouponValueTotal();
                this.mCouponValueTv.setText(x.getString(R.string.payment_lib_placeholder_coupon_price, Integer.valueOf(this.O.getCouponTotal()), couponValueTotal));
                if (couponValueTotal.floatValue() > 0.0f) {
                    String strCalculationPayPrice = h.calculationPayPrice(this.P.getActualAmount(), couponValueTotal);
                    this.K.setPrice(strCalculationPayPrice);
                    if (strBigDecimalToString.equals(strCalculationPayPrice)) {
                        this.mPaySrcPriceTv.setText("");
                    } else {
                        this.mPaySrcPriceTv.setText(x.getString(R.string.payment_lib_placeholder_rmb_china_unit, strBigDecimalToString));
                    }
                } else {
                    this.K.setPrice(strBigDecimalToString);
                    this.mPaySrcPriceTv.setText("");
                }
            } else {
                this.mPaySrcPriceTv.setText("");
                this.K.setPrice(strBigDecimalToString);
                this.mCouponValueTv.setText(R.string.payment_lib_placeholder_coupon_use);
            }
            y2(true);
        }
    }

    public final void F1() {
        r rVar = new r(this.u, this.E, this.A1);
        this.L = rVar;
        rVar.setNewBillModel(this.F);
        this.L.initData(this.K);
    }

    public final void F2() {
        if (this.B != null) {
            this.mPayCountdownTv.setText(t2(Long.valueOf(this.C)));
            this.f6488f.postDelayed(this.W2, 1000L);
        }
    }

    public final void G1() {
        this.mTitleBgView.setVisibility(0);
        h0(this);
        this.J = null;
        this.f6488f = new CoreBaseFragment.c(this);
        F2();
        this.mConfirmPayBtn.setOnClickListener(this.y);
        this.mTitleTv.setText(R.string.payment_lib_title_default_pay);
        A2(false);
        v2();
    }

    public final void G2(String str) {
        PayTypeVo payTypeVo = this.K;
        if (payTypeVo != null) {
            payTypeVo.setPrice(str);
        }
        this.I.setBigDecimal(this.M);
        this.I.setPayPrice(str);
        x2();
    }

    public final boolean H1() {
        PayTypeVo payTypeVo = this.K;
        if (payTypeVo == null || payTypeVo.getType() == 18 || this.K.isInitBJPay()) {
            return true;
        }
        return I1();
    }

    public final void H2() {
        this.D = true;
        C2();
        TextView textView = this.mPayCountdownTv;
        int i2 = R.string.payment_lib_tip_pay_success;
        textView.setText(i2);
        this.mConfirmPayBtn.setText(i2);
        F0(i2);
        k2();
        if (this.A == 3) {
            m2();
        }
    }

    public final boolean I1() {
        PayTypeVo payTypeVo = this.K;
        if (payTypeVo != null) {
            return payTypeVo.isSrcToH5();
        }
        return false;
    }

    public final void I2() {
    }

    public final boolean J1() {
        return this.mPayChannelTitleTv.getVisibility() == 8 && this.K.getType() == 18;
    }

    public final boolean K1() {
        PayTypeVo payTypeVo = this.K;
        if (payTypeVo != null) {
            return payTypeVo.isHasRentBill();
        }
        return false;
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void V(View view) {
        if (M0(view)) {
            int id = view.getId();
            if (id == R.id.btn_confirm_pay) {
                q1();
                return;
            }
            if (id == R.id.tv_alert_confirm) {
                o1();
            } else if (id == R.id.tv_alert_cancel) {
                n1();
            } else if (id == R.id.tv_discount_title) {
                h2();
            }
        }
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void W() {
        if (this.K == null) {
            q.d(this.f6485c, "onCreateView");
            try {
                View view = this.u;
                if (view != null) {
                    view.postDelayed(new Runnable() { // from class: c.e.d.s
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f2319a.n();
                        }
                    }, 600L);
                } else {
                    n();
                }
                return;
            } catch (Throwable th) {
                th.printStackTrace();
                return;
            }
        }
        this.I = new CreatePayChannelVo();
        if (this.K != null) {
            if (this.M == null) {
                this.M = i.getInstance().getWalletBalance();
            }
            this.I.setPayType(this.A);
            this.I.setBigDecimal(this.M);
            this.I.setPayPrice(this.K.getPrice());
            this.I.setPayType(this.K.getType());
            z2();
        }
        G1();
        u2();
        F1();
        if (J1()) {
            this.mConfirmPayBtn.setText(R.string.pay_lib_confirm_create_order);
        }
        I1();
    }

    @OnClick({2836})
    public void backClick() {
        j2();
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void e0() {
        n0(false);
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void f0() {
        n0(false);
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public int getLayoutId() {
        return R.layout.payment_lib_fragment_pay_channle_layout;
    }

    public final void h2() {
        if (this.Q == null) {
            this.Q = new ArrayList();
        }
        if (this.R == null) {
            this.R = new ArrayList();
        }
        ResponseH5BillDetailsVo responseH5BillDetailsVo = this.P;
        if (responseH5BillDetailsVo == null) {
            F0(R.string.payment_lib_title_pay_order_id_is_empty);
            return;
        }
        if (responseH5BillDetailsVo.getActualAmount() == null) {
            F0(R.string.payment_lib_title_pay_amount_is_empty);
        } else if (this.P.getOrderId() != null) {
            d(CardCouponFragment.getInstance(this.Q, this.R, this.P.getActualAmount(), this.C1, this.P.getOrderId(), this.O, this.S), R.id.flayout_content);
        } else {
            F0(R.string.payment_lib_title_pay_order_id_is_empty);
        }
    }

    public final void i2(PayBillResultVo payBillResultVo) {
        H();
        q.d(getClass().getCanonicalName(), "openFragmentPay getPaySign :");
        if (payBillResultVo == null || !x.isNotNull(payBillResultVo.getPaySign())) {
            q.d(getClass().getCanonicalName(), "openFragmentPay getPaySign :payment_lib_title_get_sign_failed");
            this.N = false;
            u0(x.getString(R.string.payment_lib_title_get_sign_failed));
            return;
        }
        this.N = true;
        FragmentPay fragmentPay = FragmentPay.getInstance(payBillResultVo.getPaymentKey(), this.A);
        fragmentPay.setPayRoomFee(K1());
        fragmentPay.setPayBillResultVo(payBillResultVo);
        ResponseH5BillDetailsVo responseH5BillDetailsVo = this.P;
        if (responseH5BillDetailsVo != null) {
            fragmentPay.setOrderId(responseH5BillDetailsVo.getOrderId());
        } else {
            fragmentPay.setOrderId(payBillResultVo.getPaymentKey());
        }
        d(fragmentPay, R.id.flayout_content);
        q.d(getClass().getCanonicalName(), "openFragmentPay");
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    /* JADX INFO: renamed from: j0 */
    public void I1() {
        if (I1() || this.P != null) {
            z0(R.string.loading_text);
            if (this.F != null) {
                String primaryKey = this.K.getPrimaryKey();
                this.F.getBillDetails(primaryKey);
                o2(primaryKey);
            }
        }
    }

    public final void j2() {
        l lVar = this.L;
        if (lVar != null) {
            lVar.handlePayFailed();
        }
    }

    public final void k1() {
        int i2;
        if (this.K != null) {
            int selectPayType = this.mPayChannelView.getSelectPayType();
            this.A = selectPayType;
            if (-1 == selectPayType && !J1()) {
                F0(R.string.core_lib_tip_pay_channel_is_empty);
                return;
            }
            if ("18688948873".equals(s()) && ((i2 = this.A) == 2 || i2 == 4 || i2 == 9 || i2 == 12 || i2 == 7)) {
                String str = Build.MANUFACTURER;
                Locale locale = Locale.ROOT;
                if ((str.toLowerCase(locale).contains(AgooConstants.MESSAGE_SYSTEM_SOURCE_HONOR) || str.toLowerCase(locale).contains(AgooConstants.MESSAGE_SYSTEM_SOURCE_HUAWEI)) && !c.e.a.a.b.getInstance().isInstallWX(this.f6486d)) {
                    G0("支付失败，您未安装微信，请下载安装微信。");
                    return;
                }
            }
            if ((I1() || this.K.isInitBJPay()) && this.P != null) {
                PayBillVo payBillVo = new PayBillVo();
                payBillVo.setPaymentKey(this.P.getOrderId());
                payBillVo.setPayChannel(this.A);
                H5CreatePayBillBo h5CreatePayBillBo = new H5CreatePayBillBo();
                h5CreatePayBillBo.setOrderId(this.P.getOrderId());
                h5CreatePayBillBo.setPayType(Integer.valueOf(this.A));
                SelectCouponResultVo selectCouponResultVo = this.O;
                if (selectCouponResultVo != null) {
                    h5CreatePayBillBo.setCouponList(selectCouponResultVo.getCouponList());
                }
                payBillVo.setCreatePayBillBo(h5CreatePayBillBo);
                this.K.setExtJson(JSON.toJSONString(payBillVo));
            }
            A0(R.string.payment_lib_tip_create_order, false);
            if (J1()) {
                this.L.requestGetPaySign(this.K, 1);
            } else {
                this.L.requestGetPaySign(this.K, this.A);
            }
        }
    }

    public final void k2() {
        l lVar = this.L;
        if (lVar != null) {
            lVar.handlePaySuccessResult();
        }
    }

    public final long l1() {
        Long l = this.B;
        if (l != null) {
            long jLongValue = l.longValue() - System.currentTimeMillis();
            if (jLongValue > 0) {
                return jLongValue / 1000;
            }
        }
        return -1L;
    }

    public final void l2() {
        String primaryKey = this.K.getPrimaryKey();
        RequestOrderTicketBo requestOrderTicketBo = new RequestOrderTicketBo();
        requestOrderTicketBo.setOrderId(primaryKey);
        this.F.postQueryOrderIsTicket(requestOrderTicketBo);
    }

    public final String m1() {
        PayTypeVo payTypeVo = this.K;
        if (payTypeVo == null) {
            return x.getString(R.string.payment_lib_title_default_pay);
        }
        if (payTypeVo.getResStrId() == 0) {
            this.K.setResStrId(R.string.payment_lib_title_default_pay);
        }
        return x.getNotNullStr(this.K.getTitle(), x.getString(this.K.getResStrId()));
    }

    public final void m2() {
        NewBillModel newBillModel;
        if (!c.e.a.a.a.getInstance().isTestModel() || (newBillModel = this.F) == null) {
            return;
        }
        newBillModel.getWalletBalance();
    }

    public final void n1() {
    }

    public final void n2(CoreBaseFragment coreBaseFragment) {
        if (coreBaseFragment != null) {
            K0(coreBaseFragment, R.id.flayout_content);
        }
    }

    public final void o1() {
        j2();
        if (this.A == 2) {
            PayTypeVo payTypeVo = this.K;
            if (payTypeVo == null || !payTypeVo.isBill()) {
                m();
            } else {
                n();
            }
        }
    }

    public final void o2(String str) {
        if (this.Q == null) {
            this.Q = new ArrayList();
        }
        if (this.R == null) {
            this.R = new ArrayList();
        }
        z0(R.string.loading_text);
        this.F.getCouponList(h.getPayCostTypeVosToTypes(this.R), str);
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.J = null;
        H();
        C2();
        L0(this);
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        super.onKeyDown(i2, keyEvent);
        if (keyEvent.getKeyCode() != 4) {
            return true;
        }
        j2();
        return true;
    }

    public final void p1(ResponseH5BillDetailsVo responseH5BillDetailsVo) {
        if (responseH5BillDetailsVo != null) {
            this.P = responseH5BillDetailsVo;
            List<PayCostTypeVo> billDetails = responseH5BillDetailsVo.getBillDetails();
            this.R = billDetails;
            if (c.e.a.d.o.listIsEmpty(billDetails) && x.isNotNull(responseH5BillDetailsVo.getTypeStr())) {
                this.R = new ArrayList();
                PayCostTypeVo payCostTypeVo = new PayCostTypeVo();
                payCostTypeVo.setType(responseH5BillDetailsVo.getTypeStr());
                payCostTypeVo.setName(this.K.getTitle());
                try {
                    payCostTypeVo.setValue(new BigDecimal(this.K.getPrice()));
                } catch (Exception e2) {
                    e2.printStackTrace();
                    payCostTypeVo.setValue(responseH5BillDetailsVo.getActualAmount());
                }
                this.R.add(payCostTypeVo);
            }
            E1();
            this.K.setTitle(responseH5BillDetailsVo.getName());
            this.K.setBaseKey(responseH5BillDetailsVo.getBizId());
            this.K.setPrice(x.bigDecimalToString(responseH5BillDetailsVo.getActualAmount()));
            this.K.setLateDay(responseH5BillDetailsVo.getLateFeeDays());
            this.K.setLateFee(responseH5BillDetailsVo.getLateFeeAmout());
            A2(true);
            l lVar = this.L;
            if (lVar != null) {
                lVar.initData(this.K);
            }
            if (responseH5BillDetailsVo.isNeedPay() == null || responseH5BillDetailsVo.isNeedPay().booleanValue()) {
                this.mConfirmPayBtn.setEnabled(true);
                this.mConfirmPayBtn.setText(R.string.payment_lib_placeholder_confirm_pay);
            } else {
                this.mConfirmPayBtn.setEnabled(false);
                this.mConfirmPayBtn.setText(R.string.payment_lib_title_not_pay);
            }
            q.d(this.f6485c, "handleBillDetailsResult mPayTypeVo = " + this.K.getTitle());
        }
        p2();
        q2();
        l2();
        m2();
    }

    public final void p2() {
        PayTypeVo payTypeVo;
        if (this.C0 || (payTypeVo = this.K) == null || TextUtils.isEmpty(payTypeVo.getCouponKey())) {
            q.d(this.f6485c, "requestLoadCouponList isInitSelectCoupon = " + this.C0);
            return;
        }
        ResponseH5BillDetailsVo responseH5BillDetailsVo = this.P;
        if (responseH5BillDetailsVo == null || TextUtils.isEmpty(responseH5BillDetailsVo.getOrderId())) {
            q.d(this.f6485c, "requestLoadCouponList mResponseH5BillDetailsVo empty or order id empty");
            return;
        }
        this.C0 = true;
        String orderId = this.P.getOrderId();
        if (this.R == null) {
            this.R = new ArrayList();
        }
        this.F.getCouponList(h.getPayCostTypeVosToTypes(this.R), orderId);
    }

    public final void q1() {
        if (this.D) {
            k2();
            return;
        }
        boolean z = this.mPayCouponListRecyclerView.getVisibility() == 0;
        SelectCouponResultVo selectCouponResultVo = this.O;
        boolean zListIsEmpty = selectCouponResultVo != null ? c.e.a.d.o.listIsEmpty(selectCouponResultVo.getUserCouponList()) : true;
        if (z && zListIsEmpty) {
            w0("您有本次可使用但未勾选的卡券/代金券，确定要放弃优惠，继续支付吗？", "确认支付", "稍等我看看", "直接支付", false, new View.OnClickListener() { // from class: c.e.d.r
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f2318a.W1(view);
                }
            });
        } else {
            k1();
        }
    }

    public final void q2() {
        this.F.getPayMode(this.K.getPrimaryKey());
    }

    public final void r1(ResponseCouponVo responseCouponVo) {
        if (responseCouponVo != null) {
            this.W = null;
            if (c.e.a.d.o.isNotEmpty(responseCouponVo.getOptionalList())) {
                this.mCouponValueTv.setText(R.string.payment_lib_placeholder_coupon_use);
                this.mPayCouponListRecyclerView.setVisibility(0);
                this.V.initListData(responseCouponVo.getOptionalList());
            } else {
                this.mCouponValueTv.setText(R.string.payment_lib_placeholder_coupon_not);
                this.mPayCouponListRecyclerView.setVisibility(8);
            }
            List<PayCouponVo> payCouponList = h.getPayCouponList(responseCouponVo);
            q.d(this.f6485c, "handleCouponResult size : " + payCouponList.size());
            if (c.e.a.d.o.isNotEmpty(payCouponList)) {
                String couponKey = this.K.getCouponKey();
                if (couponKey != null) {
                    Iterator<PayCouponVo> it = payCouponList.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        PayCouponVo next = it.next();
                        if (next != null && couponKey.equals(next.getCouponId())) {
                            this.W = next;
                            q.d(this.f6485c, "handleCouponResult getTitle : " + next.getTitle());
                            break;
                        }
                    }
                }
                if (this.W != null) {
                    s2();
                }
            }
        }
    }

    public final void r2() {
        z0(R.string.loading_text);
        RequestUseCouponParamBo requestUseCouponParamBo = new RequestUseCouponParamBo();
        requestUseCouponParamBo.setOrderId(this.P.getOrderId());
        requestUseCouponParamBo.setCouponIds(this.U.getSelectCouponList(this.V.getList()));
        this.F.postPreViewUseCoupon(requestUseCouponParamBo);
    }

    public final void s1(int i2, boolean z) {
        this.c0 = null;
        this.A0 = i2;
        PayCouponVo payCouponVo = this.V.getList().get(i2);
        if (!z) {
            payCouponVo.setCheck(false);
            h.removeCouponVosToIds(this.Q, payCouponVo.getCouponId());
        } else if (this.U.isCanKeepMinusPayCost(this.R, this.Q, this.P.getActualAmount(), payCouponVo).isCanMinus()) {
            CouponMutexVo couponMutexVoIsMutex = this.U.isMutex(this.Q, payCouponVo);
            if (couponMutexVoIsMutex.isMutex()) {
                payCouponVo.setCheck(false);
                G0(x.appendStringToResId(R.string.payment_lib_placeholder_coupon_mutex, couponMutexVoIsMutex.getSelectCouponVo().getTitle()));
            } else {
                this.c0 = payCouponVo;
                payCouponVo.setCheck(true);
            }
        } else {
            this.c0 = payCouponVo;
            payCouponVo.setCheck(true);
        }
        I2();
        r2();
        this.V.notifyDataSetChanged();
    }

    public final void s2() {
        if (this.P == null || TextUtils.isEmpty(this.K.getCouponKey())) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.K.getCouponKey());
        RequestUseCouponParamBo requestUseCouponParamBo = new RequestUseCouponParamBo();
        requestUseCouponParamBo.setOrderId(this.P.getOrderId());
        requestUseCouponParamBo.setCouponIds(arrayList);
        this.F.postPreViewUseCoupon(requestUseCouponParamBo);
    }

    public void setExpireDate(Long l) {
        this.B = l;
        this.C = l1();
    }

    @m(threadMode = g.b.a.r.MAIN)
    public void subscribePayResult(final EventPayStateVo eventPayStateVo) {
        H();
        this.N = false;
        if (eventPayStateVo.isSuccess()) {
            H2();
            return;
        }
        CoreBaseFragment.c cVar = this.f6488f;
        if (cVar != null) {
            cVar.postDelayed(new Runnable() { // from class: c.e.d.o
                @Override // java.lang.Runnable
                public final void run() {
                    this.f2314a.f2(eventPayStateVo);
                }
            }, 500L);
        }
    }

    public final void t1(PayBillResultVo payBillResultVo) {
        if (payBillResultVo != null) {
            ResponseH5BillDetailsVo responseH5BillDetailsVo = new ResponseH5BillDetailsVo();
            this.P = responseH5BillDetailsVo;
            responseH5BillDetailsVo.setOrderId(payBillResultVo.getPaymentKey());
            if (this.K.getPrice() != null) {
                this.P.setActualAmount(new BigDecimal(this.K.getPrice()));
            }
            k1();
        }
    }

    public final String t2(Long l) {
        if (l.longValue() <= 0) {
            return x.getString(R.string.payment_lib_title_pay_time_out);
        }
        return x.getString(R.string.payment_lib_title_pay_surplus_second) + z.getSurplusDateToTime(l);
    }

    public final void u1(ResponseOrderTicketBo responseOrderTicketBo) {
        if (responseOrderTicketBo != null) {
            q.d(this.f6485c, "handleOrderTicketResult orderTicketBo = " + JSON.toJSONString(responseOrderTicketBo));
            if (responseOrderTicketBo.isSuccess()) {
                q.d(this.f6485c, "handleOrderTicketResult orderTicketBo = " + responseOrderTicketBo.isTicket());
                if (responseOrderTicketBo.isTicket()) {
                    this.c1 = responseOrderTicketBo;
                }
            }
        }
        String jSONString = null;
        ResponseOrderTicketBo responseOrderTicketBo2 = this.c1;
        if (responseOrderTicketBo2 != null) {
            try {
                jSONString = JSON.toJSONString(responseOrderTicketBo2);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        this.L.setupAppletJsonData(jSONString);
    }

    public final void u2() {
        PayModel payModel = (PayModel) h(PayModel.class);
        this.G = payModel;
        payModel.getPayStateResult().observeForever(new Observer() { // from class: c.e.d.w
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f2323a.A1((PayStateVo) obj);
            }
        });
        this.G.getErrRequestLiveData().observe(this, new Observer() { // from class: c.e.d.i
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f2308a.C((RequestErrDto) obj);
            }
        });
        BillModel billModel = (BillModel) h(BillModel.class);
        this.E = billModel;
        billModel.getPayBillResultLiveData().observe(this, new Observer() { // from class: c.e.d.p
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f2316a.w1((PayBillResultVo) obj);
            }
        });
        this.E.getPayStateResult().observe(this, new Observer() { // from class: c.e.d.t
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f2320a.z1((PayStateVo) obj);
            }
        });
        this.E.getErrRequestLiveData().observe(this, new Observer() { // from class: c.e.d.i
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f2308a.C((RequestErrDto) obj);
            }
        });
        if (H1()) {
            NewPayModel newPayModel = (NewPayModel) h(NewPayModel.class);
            this.H = newPayModel;
            newPayModel.getPayStateResult().observeForever(new Observer() { // from class: c.e.d.w
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    this.f2323a.A1((PayStateVo) obj);
                }
            });
            this.H.getErrRequestLiveData().observe(this, new Observer() { // from class: c.e.d.i
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    this.f2308a.C((RequestErrDto) obj);
                }
            });
            NewBillModel newBillModel = (NewBillModel) h(NewBillModel.class);
            this.F = newBillModel;
            newBillModel.getPayBillResultLiveData().observe(this, new Observer() { // from class: c.e.d.l
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    this.f2311a.v1((PayBillResultVo) obj);
                }
            });
            this.F.getIncrementPayBillResultLiveData().observe(this, new Observer() { // from class: c.e.d.q
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    this.f2317a.t1((PayBillResultVo) obj);
                }
            });
            this.F.getPayOrderCreateResult().observe(this, new Observer() { // from class: c.e.d.h
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    this.f2307a.y1((ResponseH5BillDetailsVo) obj);
                }
            });
            this.F.getPayStateResult().observe(this, new Observer() { // from class: c.e.d.t
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    this.f2320a.z1((PayStateVo) obj);
                }
            });
            this.F.getErrRequestLiveData().observe(this, new Observer() { // from class: c.e.d.m
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    this.f2312a.C1((RequestErrDto) obj);
                }
            });
            this.F.getBillDetailsResult().observeForever(new Observer() { // from class: c.e.d.v
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    this.f2322a.p1((ResponseH5BillDetailsVo) obj);
                }
            });
            this.F.getPreviewUseCouponResult().observeForever(new Observer() { // from class: c.e.d.g
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    this.f2306a.B1((ResponseUseCouponResultBo) obj);
                }
            });
            this.F.getCouponResult().observeForever(new Observer() { // from class: c.e.d.k
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    this.f2310a.r1((ResponseCouponVo) obj);
                }
            });
            this.F.getOrderTicketResult().observeForever(new Observer() { // from class: c.e.d.j
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    this.f2309a.u1((ResponseOrderTicketBo) obj);
                }
            });
        }
        this.c1 = null;
        B2();
    }

    public final void v1(PayBillResultVo payBillResultVo) {
        if (payBillResultVo == null) {
            H();
            F0(R.string.payment_lib_tip_pay_failed);
            return;
        }
        this.J = payBillResultVo.getPaymentKey();
        if (this.A == 3) {
            payBillResultVo.setPullPay(false);
        }
        if (!payBillResultVo.getPullPay()) {
            payBillResultVo.setPaySign("queryPayState");
        }
        q.d(getClass().getCanonicalName(), "handlePayBillResult getPaySign :");
        i2(payBillResultVo);
        NewBillModel newBillModel = this.F;
        if (newBillModel != null) {
            newBillModel.getPayState(payBillResultVo.getPaymentKey());
        }
    }

    public final void v2() {
        PayFeeAdapter payFeeAdapter = new PayFeeAdapter();
        this.T = payFeeAdapter;
        this.mPayCostListRecyclerView.setAdapter(payFeeAdapter);
        this.mPaySrcPriceTv.setVisibility(0);
        this.mPaySrcPriceTv.getPaint().setFlags(16);
        this.mCouponValueTv.setText(R.string.payment_lib_placeholder_coupon_not);
        this.mCouponValueTv.setVisibility(0);
        this.mCouponTitleTv.setVisibility(0);
        D1();
        this.mPayCouponTitleTv.setVisibility(0);
        this.mCouponTitleTv.setOnClickListener(this.y);
    }

    public final void w1(PayBillResultVo payBillResultVo) {
        v1(payBillResultVo);
    }

    public final void w2() {
        PayTypeVo payTypeVo = this.K;
        if (payTypeVo != null) {
            boolean z = payTypeVo.getLateFee() != null;
            this.mPayCountdownTv.setVisibility(z ? 8 : 0);
            this.mPayLateFeeTv.setVisibility(z ? 0 : 8);
            if (z) {
                this.mPayLateFeeTv.setText(x.getString(R.string.payment_lib_placeholder_day_last_fee, String.valueOf(this.K.getLateDay()), x.bigDecimalToPlainString(this.K.getLateFee())));
            }
        }
    }

    public final void x1(ResponsePayModeBo responsePayModeBo) {
        Integer payTypeToMode;
        H();
        if (responsePayModeBo == null) {
            G0(x.getString(R.string.tip_pay_mode_empty));
            return;
        }
        List<String> payModeSet = responsePayModeBo.getPayModeSet();
        if (!c.e.a.d.o.isNotEmpty(payModeSet)) {
            G0(x.getString(R.string.tip_pay_mode_empty));
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < payModeSet.size(); i2++) {
            String str = payModeSet.get(i2);
            if (x.isNotNull(str) && (payTypeToMode = ResponsePayModeBo.getPayTypeToMode(str)) != null) {
                arrayList.add(payTypeToMode);
                boolean z = true;
                if (ResponsePayModeBo.ALI_PAY.equals(str) || ResponsePayModeBo.BOC_ALI_PAY.equals(str)) {
                    if (this.I.getAliPayType() == null || 5 != this.I.getAliPayType().intValue()) {
                        this.I.setAliPayType(payTypeToMode);
                    }
                }
                if (ResponsePayModeBo.ALI_WITHDRAW_PAY.equals(str)) {
                    if (this.I.getAliPayType() == null || 5 != this.I.getAliPayType().intValue()) {
                        this.I.setAliPayType(payTypeToMode);
                    }
                }
                if (ResponsePayModeBo.WX_PAY.equals(str) || ResponsePayModeBo.BOC_WX_PAY.equals(str)) {
                    if (this.I.getWxPayType() != null && 4 == this.I.getWxPayType().intValue()) {
                        z = false;
                    }
                    if (z) {
                        this.I.setWxPayType(payTypeToMode);
                    }
                }
                if (ResponsePayModeBo.CCB_ALI_PAY.equals(str)) {
                    this.I.setAliPayType(payTypeToMode);
                }
                if (ResponsePayModeBo.CCB_WX_PAY.equals(str)) {
                    this.I.setWxPayType(payTypeToMode);
                }
                if (ResponsePayModeBo.TL_ALI_PAY.equals(str)) {
                    this.I.setAliPayType(payTypeToMode);
                }
                if (ResponsePayModeBo.TL_FZ_ALI_PAY.equals(str)) {
                    this.I.setAliPayType(payTypeToMode);
                }
                if (ResponsePayModeBo.GJJ_ALI_PAY.equals(str)) {
                    this.I.setGjjAliPayType(payTypeToMode);
                }
                if (ResponsePayModeBo.TL_FZ_WX_PAY.equals(str)) {
                    this.I.setWxPayType(payTypeToMode);
                }
                if (ResponsePayModeBo.TL_WX_PAY.equals(str)) {
                    this.I.setWxPayType(payTypeToMode);
                }
                if (ResponsePayModeBo.WT_PAY.equals(str)) {
                    this.I.setWtPayType(payTypeToMode);
                }
            }
        }
        this.mPayChannelTitleTv.setVisibility(0);
        this.I.setPayIndexMap(arrayList);
        x2();
        this.mConfirmPayBtn.setText(R.string.payment_lib_placeholder_confirm_pay);
    }

    public final void x2() {
        if (this.K != null) {
            this.mPayChannelView.setupPayChannelList(this.L.getPayChannelList(this.I));
        }
    }

    public final void y1(ResponseH5BillDetailsVo responseH5BillDetailsVo) {
        this.P = responseH5BillDetailsVo;
        k1();
    }

    public final void y2(boolean z) {
        PayTypeVo payTypeVo = this.K;
        if (payTypeVo != null) {
            String price = payTypeVo.getPrice();
            if (x.isNotNull(price)) {
                String string = x.getString(R.string.payment_lib_rmb_china_price_unit);
                if (price.contains(string)) {
                    this.mPayPriceTv.setText(price);
                    this.K.setPrice(price.replace(string, ""));
                } else {
                    this.mPayPriceTv.setText(x.appendStringToResId(R.string.payment_lib_placeholder_rmb_china_unit_value, price));
                }
                this.I.setPayPrice(price);
                if (z) {
                    x2();
                }
            }
        }
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void z(Message message) {
        Object obj;
        int i2 = message.what;
        if (i2 == 1) {
            this.mPayCountdownTv.setText(t2(Long.valueOf(this.C)));
        } else if (i2 == 1000 && (obj = message.obj) != null) {
            r0((String) obj, false, new c());
        }
    }

    public final void z1(PayStateVo payStateVo) {
        if (payStateVo == null || payStateVo.getPayStatus() != 0) {
            return;
        }
        setExpireDate(payStateVo.getExpiryDate());
        if (this.f6488f != null) {
            C2();
        }
        F2();
    }

    public final void z2() {
        String responseH5BillDetailsVoJson = this.K.getResponseH5BillDetailsVoJson();
        if (responseH5BillDetailsVoJson != null) {
            try {
                ResponseH5BillDetailsVo responseH5BillDetailsVo = (ResponseH5BillDetailsVo) JSON.parseObject(responseH5BillDetailsVoJson, ResponseH5BillDetailsVo.class);
                this.P = responseH5BillDetailsVo;
                if (responseH5BillDetailsVo != null) {
                    this.K.setPrimaryKey(responseH5BillDetailsVo.getOrderId());
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
}
