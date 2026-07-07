package com.chinavisionary.paymentlibrary.fragment;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.lifecycle.Observer;
import butterknife.BindView;
import c.e.a.d.o;
import c.e.a.d.q;
import c.e.a.d.x;
import c.e.d.a0.a;
import c.e.d.c0.h;
import com.chinavisionary.core.app.base.CoreBaseFragment;
import com.chinavisionary.core.app.net.base.dto.RequestErrDto;
import com.chinavisionary.core.weight.BaseRecyclerView;
import com.chinavisionary.core.weight.BaseSwipeRefreshLayout;
import com.chinavisionary.paymentlibrary.R;
import com.chinavisionary.paymentlibrary.adapter.PaymentCouponAdapter;
import com.chinavisionary.paymentlibrary.model.NewBillModel;
import com.chinavisionary.paymentlibrary.vo.CouponMutexVo;
import com.chinavisionary.paymentlibrary.vo.PayCostTypeVo;
import com.chinavisionary.paymentlibrary.vo.PayCouponVo;
import com.chinavisionary.paymentlibrary.vo.RequestUseCouponParamBo;
import com.chinavisionary.paymentlibrary.vo.ResponseCouponVo;
import com.chinavisionary.paymentlibrary.vo.ResponseUseCouponResultBo;
import com.chinavisionary.paymentlibrary.vo.ResponseUserCouponResultItemVo;
import com.chinavisionary.paymentlibrary.vo.SelectCouponResultVo;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class CardCouponFragment extends CoreBaseFragment<PayCouponVo> {
    public List<PayCouponVo> A;
    public List<PayCostTypeVo> B;
    public BigDecimal C;
    public a D;
    public h E;
    public NewBillModel F;
    public String G;
    public SelectCouponResultVo H;
    public List<ResponseUserCouponResultItemVo> I;
    public Integer J;
    public PayCouponVo K;
    public final c.e.a.a.c.c.a L = new c.e.a.a.c.c.a() { // from class: c.e.d.b0.d
        @Override // c.e.a.a.c.c.a
        public final void onItemClickListener(View view, int i2) {
            this.f2287a.X0(view, i2);
        }
    };

    @BindView(2836)
    public TextView mBackTv;

    @BindView(2916)
    public View mConfirmBgView;

    @BindView(2287)
    public Button mConfirmBtn;

    @BindView(2578)
    public BaseSwipeRefreshLayout mReceiveSaleRecyclerView;

    @BindView(2898)
    public TextView mTitleTv;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: W0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void X0(View view, int i2) {
        if (((PayCouponVo) this.t.getList().get(i2)).isUnavailable()) {
            return;
        }
        P0(i2, !((PayCouponVo) this.t.getList().get(i2)).isCheck());
    }

    public static CardCouponFragment getInstance(List<PayCouponVo> list, List<PayCostTypeVo> list2, BigDecimal bigDecimal, a aVar, String str, SelectCouponResultVo selectCouponResultVo, List<ResponseUserCouponResultItemVo> list3) {
        CardCouponFragment cardCouponFragment = new CardCouponFragment();
        cardCouponFragment.A = new ArrayList(list);
        if (list3 == null) {
            list3 = new ArrayList<>();
        }
        cardCouponFragment.I = new ArrayList(list3);
        cardCouponFragment.D = aVar;
        cardCouponFragment.C = bigDecimal;
        cardCouponFragment.B = list2;
        cardCouponFragment.G = str;
        cardCouponFragment.H = selectCouponResultVo;
        return cardCouponFragment;
    }

    private void o0() {
        BaseSwipeRefreshLayout baseSwipeRefreshLayout = this.mReceiveSaleRecyclerView;
        this.s = baseSwipeRefreshLayout;
        this.r = baseSwipeRefreshLayout.getBaseRecyclerView();
        PaymentCouponAdapter paymentCouponAdapter = new PaymentCouponAdapter(false);
        this.t = paymentCouponAdapter;
        paymentCouponAdapter.setOnClickListener(this.y);
        this.t.setOnItemClickListener(this.L);
        this.t.setEmptyTipMsg(x.getString(R.string.tip_coupon_is_empty));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference incomplete: some casts might be missing */
    public final void N0() {
        this.mConfirmBtn.setVisibility(8);
        this.mConfirmBgView.setVisibility(8);
        PayCouponVo payCouponVo = new PayCouponVo();
        payCouponVo.setItemType(34952);
        this.t.initListData(null);
        this.t.addDataToList((T) payCouponVo);
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    public final void O0(ResponseCouponVo responseCouponVo) {
        H();
        this.mReceiveSaleRecyclerView.setRefreshing(false);
        if (responseCouponVo == null) {
            N0();
            return;
        }
        List<PayCouponVo> payCouponList = h.getPayCouponList(responseCouponVo);
        q.d(this.f6485c, "handleCouponResult size : " + payCouponList.size() + ",mSelectCouponList = " + this.A.size());
        if (!o.isNotEmpty(payCouponList)) {
            N0();
            return;
        }
        int iFindSelectCouponPosition = this.E.findSelectCouponPosition(payCouponList, this.A);
        List<PayCouponVo> listFilterAvailableCoupons = this.E.filterAvailableCoupons(payCouponList, this.B, this.A);
        if (!o.isNotEmpty(listFilterAvailableCoupons)) {
            N0();
            return;
        }
        q.d(this.f6485c, "start selectPosition = " + iFindSelectCouponPosition);
        this.t.initListData((List<T>) listFilterAvailableCoupons);
        Z0(iFindSelectCouponPosition);
    }

    public final void P0(int i2, boolean z) {
        PayCouponVo payCouponVo = (PayCouponVo) this.t.getList().get(i2);
        if (!z) {
            payCouponVo.setCheck(false);
            h.removeCouponVosToIds(this.A, payCouponVo.getCouponId());
        } else if (this.E.isCanKeepMinusPayCost(this.B, this.A, this.C, payCouponVo).isCanMinus()) {
            CouponMutexVo couponMutexVoIsMutex = this.E.isMutex(this.A, payCouponVo);
            if (couponMutexVoIsMutex.isMutex()) {
                payCouponVo.setCheck(false);
                G0(x.appendStringToResId(R.string.payment_lib_placeholder_coupon_mutex, couponMutexVoIsMutex.getSelectCouponVo().getTitle()));
            } else {
                payCouponVo.setCheck(true);
                this.A.add(payCouponVo);
            }
        } else {
            payCouponVo.setCheck(true);
            this.A.add(payCouponVo);
        }
        this.J = Integer.valueOf(i2);
        this.K = payCouponVo;
        q.d(this.f6485c, "handleCouponSelect ,mSelectCouponList = " + this.A.size());
        c1();
        Y0();
        this.t.notifyDataSetChanged();
    }

    public final void Q0(ResponseUseCouponResultBo responseUseCouponResultBo) {
        H();
        if (!responseUseCouponResultBo.isSuccess()) {
            this.I = null;
            G0(responseUseCouponResultBo.getMessage());
        } else {
            this.C = responseUseCouponResultBo.getOriginalAmount();
            this.I = responseUseCouponResultBo.getList();
            b1();
        }
    }

    public final void R0(RequestErrDto requestErrDto) {
        C(requestErrDto);
        PayCouponVo payCouponVo = this.K;
        if (payCouponVo != null) {
            h.removeCouponVosToIds(this.A, payCouponVo.getCouponId());
        }
        b1();
    }

    public final void S0() {
        this.mTitleTv.setText(R.string.payment_lib_title_select_coupon);
        this.mConfirmBtn.setOnClickListener(this.y);
        this.mConfirmBtn.setVisibility(8);
        this.mConfirmBgView.setVisibility(8);
        this.mBackTv.setOnClickListener(this.y);
        c1();
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void V(View view) {
        if (view.getId() == R.id.tv_back) {
            n();
        }
        if (view.getId() == R.id.btn_confirm) {
            this.D.onSelectCouponResult(this.A, this.I, this.H, this.C);
            n();
        }
        if (view.getId() == R.id.cb_select_sale) {
            ((Integer) view.getTag()).intValue();
        }
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void W() {
        this.l = false;
        this.E = new h();
        S0();
        o0();
        a1();
        z0(R.string.loading_text);
        j0();
    }

    public final void Y0() {
        z0(R.string.loading_text);
        RequestUseCouponParamBo requestUseCouponParamBo = new RequestUseCouponParamBo();
        requestUseCouponParamBo.setOrderId(this.G);
        requestUseCouponParamBo.setCouponIds(this.E.getSelectCouponList(this.t.getList()));
        this.F.postPreViewUseCoupon(requestUseCouponParamBo);
    }

    public final void Z0(int i2) {
        BaseRecyclerView baseRecyclerView;
        if (i2 < 0 || (baseRecyclerView = this.mReceiveSaleRecyclerView.getBaseRecyclerView()) == null) {
            return;
        }
        baseRecyclerView.scrollToPosition(i2);
    }

    public final void a1() {
        NewBillModel newBillModel = (NewBillModel) h(NewBillModel.class);
        this.F = newBillModel;
        newBillModel.getCouponResult().observeForever(new Observer() { // from class: c.e.d.b0.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f2284a.O0((ResponseCouponVo) obj);
            }
        });
        this.F.getPreviewUseCouponResult().observeForever(new Observer() { // from class: c.e.d.b0.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f2285a.Q0((ResponseUseCouponResultBo) obj);
            }
        });
        this.F.getErrRequestLiveData().observeForever(new Observer() { // from class: c.e.d.b0.c
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f2286a.R0((RequestErrDto) obj);
            }
        });
    }

    public final void b1() {
        if (o.isNotEmpty(this.I)) {
            SelectCouponResultVo selectCouponResultVo = h.getSelectCouponResultVo(this.I);
            this.H = selectCouponResultVo;
            this.E.updateSelectCouponList(this.E.getPayCouponParamBoToIds(selectCouponResultVo.getCouponList()), this.t.getList());
            c1();
            this.t.notifyDataSetChanged();
            return;
        }
        if (this.J != null && this.t.getItemCount() > this.J.intValue()) {
            ((PayCouponVo) this.t.getList().get(this.J.intValue())).setCheck(false);
            this.t.notifyDataSetChanged();
        }
        this.J = null;
        this.K = null;
    }

    public final void c1() {
        SelectCouponResultVo selectCouponResultVo = this.H;
        if (selectCouponResultVo == null) {
            selectCouponResultVo = new SelectCouponResultVo();
        }
        this.mConfirmBtn.setText(x.getString(R.string.payment_lib_title_confirm, Integer.valueOf(selectCouponResultVo.getCouponTotal()), x.bigDecimalToString(selectCouponResultVo.getCouponValueTotal()), h.calculationPayPrice(this.C, selectCouponResultVo.getCouponValueTotal())));
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
        return R.layout.payment_lib_fragment_swipe_refresh;
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void j0() {
        this.F.getCouponList(h.getPayCostTypeVosToTypes(this.B), this.G);
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment, androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        q.d(this.f6485c, "onStop isRemoving = " + isRemoving());
        if (isRemoving()) {
            this.D.onSelectCouponResult(this.A, this.I, this.H, this.C);
        }
    }
}
