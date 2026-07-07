package com.chinavisionary.microtang.buycart.fragment;

import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.Observer;
import butterknife.BindView;
import butterknife.OnClick;
import c.e.a.d.o;
import c.e.a.d.x;
import c.e.c.f.a;
import com.alibaba.fastjson.JSON;
import com.chinavisionary.core.app.net.base.dto.RequestErrDto;
import com.chinavisionary.core.app.net.base.dto.ResponseStateVo;
import com.chinavisionary.core.weight.BaseSwipeRefreshLayout;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.address.AddressFragment;
import com.chinavisionary.microtang.base.BaseFragment;
import com.chinavisionary.microtang.bill.vo.PayBillVo;
import com.chinavisionary.microtang.buycart.adapter.BuyCartAdapter;
import com.chinavisionary.microtang.buycart.bo.RequestCreateOrderBo;
import com.chinavisionary.microtang.buycart.model.BuyCartSubmitModel;
import com.chinavisionary.microtang.buycart.vo.BuyCartProductVo;
import com.chinavisionary.microtang.buycart.vo.BuyCartVo;
import com.chinavisionary.microtang.buycart.vo.CreateOrderSpecVo;
import com.chinavisionary.microtang.buycart.vo.MerchantsBean;
import com.chinavisionary.microtang.buycart.vo.RequestAmountBo;
import com.chinavisionary.microtang.buycart.vo.RequestCreateBuyCartOrderVo;
import com.chinavisionary.microtang.buycart.vo.RequestInitBuyCartOrderVo;
import com.chinavisionary.microtang.buycart.vo.ResponseAmountVo;
import com.chinavisionary.microtang.buycart.vo.ResponseWaitBuyListVo;
import com.chinavisionary.microtang.order.vo.EventUpdateOrderStateVo;
import com.chinavisionary.microtang.order.vo.KeyValueVo;
import com.chinavisionary.microtang.room.fragment.ReceiverSaleFragment;
import com.chinavisionary.microtang.room.vo.ExpressVo;
import com.chinavisionary.microtang.view.ExpressAddressView;
import com.chinavisionary.microtang.view.SelfAddressView;
import com.chinavisionary.paymentlibrary.PayTypeActivity;
import com.chinavisionary.paymentlibrary.vo.PayTypeVo;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class BuyCartSubmitOrderFragment extends BaseFragment<BuyCartVo> {
    public int B;
    public int C;
    public int D;
    public List<BuyCartVo> E;
    public String F;
    public BuyCartSubmitModel G;
    public List<ExpressVo> H;
    public ResponseAmountVo I;
    public a J = new a() { // from class: c.e.c.k.b.j
        @Override // c.e.c.f.a
        public final void setupSelectAddress(ExpressVo expressVo) {
            this.f1637a.V1(expressVo);
        }
    };
    public c.e.a.a.c.c.a K = new c.e.a.a.c.c.a() { // from class: c.e.c.k.b.e
        @Override // c.e.a.a.c.c.a
        public final void onItemClickListener(View view, int i2) {
            this.f1632a.X1(view, i2);
        }
    };

    @BindView(R.id.tv_buy_cart_count_price)
    public TextView mCountPriceTv;

    @BindView(R.id.view_express_order_address_bottom_line)
    public View mExpressAddressLineView;

    @BindView(R.id.express_address_view)
    public ExpressAddressView mExpressAddressView;

    @BindView(R.id.cb_express)
    public AppCompatCheckBox mExpressCb;

    @BindView(R.id.tv_express_fee_value)
    public TextView mExpressFeeValueTv;

    @BindView(R.id.tv_sale_price)
    public TextView mSalePriceTv;

    @BindView(R.id.self_address_view)
    public SelfAddressView mSelfAddressView;

    @BindView(R.id.cb_self_picked)
    public AppCompatCheckBox mSelfPickedCb;

    @BindView(R.id.swipe_refresh_layout)
    public BaseSwipeRefreshLayout mSwipeRefreshLayout;

    @BindView(R.id.tv_tip_msg)
    public TextView mTipExpressFeeTv;

    @BindView(R.id.tv_title)
    public TextView mTitleTv;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: U1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void V1(ExpressVo expressVo) {
        this.mExpressAddressView.setupData(expressVo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: W1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void X1(View view, int i2) {
        if (view.getTag() instanceof BuyCartAdapter.OrderSaleVh) {
            d(ReceiverSaleFragment.getInstance(""), R.id.flayout_content);
        }
    }

    public static BuyCartSubmitOrderFragment getInstance(int i2) {
        BuyCartSubmitOrderFragment buyCartSubmitOrderFragment = new BuyCartSubmitOrderFragment();
        buyCartSubmitOrderFragment.d2(i2);
        return buyCartSubmitOrderFragment;
    }

    public final void E1() {
        if (!x.isNotNull(this.F)) {
            F0(R.string.tip_wait_buy_cart_key_empty);
            return;
        }
        if (!x.isNotNull(this.mExpressAddressView.getAddressKey())) {
            F0(R.string.tip_express_address_empty);
            return;
        }
        z0(R.string.tip_submit_data_loading);
        RequestInitBuyCartOrderVo requestInitBuyCartOrderVo = new RequestInitBuyCartOrderVo();
        requestInitBuyCartOrderVo.setAddressKey(this.mExpressAddressView.getAddressKey());
        requestInitBuyCartOrderVo.setDeliveryMethod(1);
        requestInitBuyCartOrderVo.setToBePurchasedCommoditiesKey(this.F);
        List<RequestInitBuyCartOrderVo.MerchantRemarkBean> listH1 = H1();
        if (o.isNotEmpty(listH1)) {
            requestInitBuyCartOrderVo.setMerchantRemark(listH1);
        }
        this.G.createInitOrder(requestInitBuyCartOrderVo);
    }

    public final void F1(String str) {
        this.G.getWaitBuyListToKey(str);
    }

    public final void G1() {
        RequestAmountBo requestAmountBo = new RequestAmountBo();
        requestAmountBo.setToBePurchasedCommoditiesKey(this.F);
        this.G.getWaitBuyListAmount(requestAmountBo);
    }

    public final List<RequestInitBuyCartOrderVo.MerchantRemarkBean> H1() {
        List<BuyCartVo> list = this.t.getList();
        ArrayList arrayList = new ArrayList();
        for (BuyCartVo buyCartVo : list) {
            if (buyCartVo.getItemType() != 98394) {
                String orderRemark = buyCartVo.getOrderRemark();
                if (x.isNotNull(orderRemark)) {
                    RequestInitBuyCartOrderVo.MerchantRemarkBean merchantRemarkBean = new RequestInitBuyCartOrderVo.MerchantRemarkBean();
                    merchantRemarkBean.setMerchantKey(buyCartVo.getMerchantKey());
                    merchantRemarkBean.setRemark(orderRemark);
                    arrayList.add(merchantRemarkBean);
                    i("remark msg :" + orderRemark + ", merchant key :" + buyCartVo.getMerchantKey());
                }
            }
        }
        return arrayList;
    }

    public final void I1(ResponseAmountVo responseAmountVo) {
        this.I = responseAmountVo;
        if (responseAmountVo.getDiscountAmount() != null && responseAmountVo.getDiscountAmount().floatValue() > 0.0f) {
            this.mSalePriceTv.setText(x.appendStringToResId(R.string.placeholder_discount_amount, x.bigDecimalToPlainString(responseAmountVo.getDiscountAmount())));
        }
        this.mCountPriceTv.setText(x.appendStringToResId(R.string.placeholder_rmb_china_unit, x.bigDecimalToPlainString(responseAmountVo.getPayAmount())));
    }

    public final void J1(ResponseStateVo responseStateVo) {
        if (responseStateVo != null) {
            String key = responseStateVo.getKey();
            if (x.isNotNull(key)) {
                b2(key);
                m();
            } else {
                H();
                F0(R.string.tip_create_order_failed);
            }
        }
    }

    public final void K1(String str) {
        if (!x.isNotNull(str)) {
            F0(R.string.data_error);
        } else {
            this.F = str;
            F1(str);
        }
    }

    public final void L1(ResponseStateVo responseStateVo) {
        if (responseStateVo != null) {
            RequestCreateOrderBo requestCreateOrderBo = new RequestCreateOrderBo();
            requestCreateOrderBo.setShoppingRDKey(this.F);
            this.G.createBuyCartOrder(requestCreateOrderBo);
        }
    }

    public final void M1(View view) {
        this.C = ((Integer) view.getTag()).intValue();
        this.B = ((Integer) view.getTag(view.getId())).intValue();
        d(ReceiverSaleFragment.getInstance(((BuyCartVo) this.t.getList().get(this.C)).getCommodities().get(this.B).getCommodityKey()), R.id.flayout_content);
    }

    public final void N1(View view) {
        this.C = ((Integer) view.getTag()).intValue();
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    public final void O1(ResponseWaitBuyListVo responseWaitBuyListVo) {
        if (responseWaitBuyListVo != null) {
            List<ExpressVo> address = responseWaitBuyListVo.getAddress();
            this.H = address;
            ExpressVo expressVo = (ExpressVo) o.getFirstElement(address);
            if (expressVo != null) {
                this.mExpressAddressView.setupData(expressVo);
            }
            ArrayList arrayList = new ArrayList();
            List<MerchantsBean> merchants = responseWaitBuyListVo.getMerchants();
            if (o.isNotEmpty(merchants)) {
                for (MerchantsBean merchantsBean : merchants) {
                    if (merchantsBean != null) {
                        BuyCartVo buyCartVo = new BuyCartVo();
                        buyCartVo.setMerchantLogo(merchantsBean.getMerchantLogo());
                        buyCartVo.setMerchantName(merchantsBean.getMerchantName());
                        buyCartVo.setMerchantKey(merchantsBean.getMerchantKey());
                        buyCartVo.setTotalAmount(merchantsBean.getTotalPrice());
                        buyCartVo.setFeesBeans(merchantsBean.getAttachFees());
                        buyCartVo.setCommodities(merchantsBean.getCommodities());
                        buyCartVo.setOrderRemark(merchantsBean.getRemark());
                        KeyValueVo keyValueVo = new KeyValueVo();
                        keyValueVo.setKey(x.getString(R.string.title_count_fee));
                        keyValueVo.setValue(x.bigDecimalToPlainString(buyCartVo.getTotalAmount()));
                        if (o.isNotEmpty(buyCartVo.getFeesBeans())) {
                            buyCartVo.getFeesBeans().add(keyValueVo);
                        } else {
                            ArrayList arrayList2 = new ArrayList();
                            arrayList2.add(keyValueVo);
                            buyCartVo.setFeesBeans(arrayList2);
                        }
                        arrayList.add(buyCartVo);
                    }
                }
            }
            this.E = arrayList;
            this.t.initListData(arrayList);
        }
        H();
        this.mSwipeRefreshLayout.setRefreshing(false);
        G1();
    }

    public final void P1() {
        this.mTitleTv.setText(R.string.title_confirm_order);
        this.mExpressAddressView.setOnClickListener(this.y);
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void V(View view) {
        int id = view.getId();
        if (id == R.id.express_address_view) {
            a2();
        } else if (id == R.id.tv_sale_name) {
            M1(view);
        } else {
            if (id != R.id.tv_self_picked_address) {
                return;
            }
            N1(view);
        }
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void W() {
        P1();
        f2();
        e2();
        z0(R.string.loading_text);
        I1();
    }

    public final void a2() {
        if (x.isNotNull(this.mExpressAddressView.getAddressKey())) {
            AddressFragment addressFragment = AddressFragment.getInstance(this.mExpressAddressView.getAddressKey(), this.J);
            addressFragment.setExpressVos(this.H);
            d(addressFragment, R.id.flayout_content);
        }
    }

    public final void b2(String str) {
        String string = x.getString(R.string.title_wt_food);
        BigDecimal payAmount = this.I.getPayAmount();
        PayBillVo payBillVo = new PayBillVo();
        payBillVo.setPaymentKey(str);
        PayTypeVo payTypeVo = new PayTypeVo();
        payTypeVo.setResStrId(R.string.title_wt_food);
        payTypeVo.setType(19);
        payTypeVo.setBill(true);
        payTypeVo.setPrice(x.bigDecimalToPlainString(payAmount));
        payTypeVo.setTitle(x.appendStringToResId(R.string.placeholder_pay_order_fee, string));
        payTypeVo.setExtJson(JSON.toJSONString(payBillVo));
        Intent intent = new Intent(this.f6487e, (Class<?>) PayTypeActivity.class);
        intent.setFlags(268435456);
        intent.putExtra("key", JSON.toJSONString(payTypeVo));
        startActivity(intent);
        h2();
    }

    public final void c2() {
        ArrayList arrayList = new ArrayList();
        RequestCreateBuyCartOrderVo requestCreateBuyCartOrderVo = new RequestCreateBuyCartOrderVo();
        requestCreateBuyCartOrderVo.setItems(arrayList);
        for (BuyCartVo buyCartVo : this.E) {
            if (buyCartVo != null) {
                List<BuyCartProductVo> commodities = buyCartVo.getCommodities();
                if (o.isNotEmpty(commodities)) {
                    for (BuyCartProductVo buyCartProductVo : commodities) {
                        if (buyCartProductVo != null) {
                            CreateOrderSpecVo createOrderSpecVo = new CreateOrderSpecVo();
                            createOrderSpecVo.setQuantity(buyCartProductVo.getQuantity());
                            createOrderSpecVo.setCommoditySpecificationKey(buyCartProductVo.getCommoditySpecificationKey());
                            arrayList.add(createOrderSpecVo);
                        }
                    }
                }
            }
        }
        this.G.createWaitBuyList(requestCreateBuyCartOrderVo);
    }

    @OnClick({R.id.cb_express, R.id.cb_self_picked})
    public void cbClickView(View view) {
        int id = view.getId();
        if (id == R.id.cb_express) {
            g2(true);
        } else {
            if (id != R.id.cb_self_picked) {
                return;
            }
            g2(false);
        }
    }

    public final void d2(int i2) {
        this.D = i2;
    }

    public final void e2() {
        BuyCartSubmitModel buyCartSubmitModel = (BuyCartSubmitModel) h(BuyCartSubmitModel.class);
        this.G = buyCartSubmitModel;
        buyCartSubmitModel.getCreateWaitBuyListResult().observe(this, new Observer() { // from class: c.e.c.k.b.h
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f1635a.K1((String) obj);
            }
        });
        this.G.getWaitBuyListResult().observe(this, new Observer() { // from class: c.e.c.k.b.f
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f1633a.O1((ResponseWaitBuyListVo) obj);
            }
        });
        this.G.getAmountResult().observe(this, new Observer() { // from class: c.e.c.k.b.l
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f1639a.I1((ResponseAmountVo) obj);
            }
        });
        this.G.getInitResult().observe(this, new Observer() { // from class: c.e.c.k.b.k
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f1638a.L1((ResponseStateVo) obj);
            }
        });
        this.G.getCreateResult().observe(this, new Observer() { // from class: c.e.c.k.b.i
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f1636a.J1((ResponseStateVo) obj);
            }
        });
        this.G.getErrRequestLiveData().observe(this, new Observer() { // from class: c.e.c.k.b.g
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f1634a.C((RequestErrDto) obj);
            }
        });
    }

    public final void f2() {
        this.r = this.mSwipeRefreshLayout.getBaseRecyclerView();
        BuyCartAdapter buyCartAdapter = new BuyCartAdapter(this.D);
        this.t = buyCartAdapter;
        buyCartAdapter.setDeliveryType(3);
        this.t.setOnClickListener(this.y);
        this.t.setOnItemClickListener(this.K);
    }

    @OnClick({R.id.tv_back})
    public void finishFragment(View view) {
        n();
    }

    public final void g2(boolean z) {
        this.mExpressCb.setChecked(z);
        this.mSelfPickedCb.setChecked(!z);
        this.mExpressAddressLineView.setVisibility(z ? 0 : 8);
        this.mExpressAddressView.setVisibility(z ? 0 : 8);
        this.mSelfAddressView.setVisibility(z ? 8 : 0);
        ((BuyCartAdapter) this.t).setDeliveryType(z ? 3 : 2);
        ((ViewGroup.MarginLayoutParams) ((ConstraintLayout.LayoutParams) this.mSwipeRefreshLayout.getLayoutParams())).topMargin = getResources().getDimensionPixelSize(z ? R.dimen.dp_220 : R.dimen.dp_260);
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public int getLayoutId() {
        return R.layout.fragment_buy_cart_submit_order;
    }

    public final void h2() {
        EventUpdateOrderStateVo eventUpdateOrderStateVo = new EventUpdateOrderStateVo();
        eventUpdateOrderStateVo.setOldOrderState(-1);
        eventUpdateOrderStateVo.setOrderState(0);
        k(eventUpdateOrderStateVo);
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    /* JADX INFO: renamed from: j0 */
    public void I1() {
        c2();
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
    }

    public void setSelectBuyCartList(List<BuyCartVo> list) {
        this.E = list;
    }

    @OnClick({R.id.btn_submit_order})
    public void submitOrderClick(View view) {
        E1();
    }
}
