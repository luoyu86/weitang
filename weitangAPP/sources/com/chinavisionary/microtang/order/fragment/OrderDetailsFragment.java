package com.chinavisionary.microtang.order.fragment;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.lifecycle.Observer;
import butterknife.BindView;
import butterknife.OnClick;
import c.e.a.d.x;
import c.e.c.b0.c.e;
import com.alibaba.fastjson.JSON;
import com.chinavisionary.core.app.base.CoreBaseFragment;
import com.chinavisionary.core.app.config.bo.LeftTitleToRightArrowVo;
import com.chinavisionary.core.app.net.base.dto.RequestErrDto;
import com.chinavisionary.core.app.net.base.dto.ResponseStateVo;
import com.chinavisionary.core.weight.BaseSwipeRefreshLayout;
import com.chinavisionary.core.weight.CoreRoundedImageView;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.base.BaseFragment;
import com.chinavisionary.microtang.bill.vo.PayBillVo;
import com.chinavisionary.microtang.buycart.vo.BuyCartVo;
import com.chinavisionary.microtang.merchant.MerchantMainActivity;
import com.chinavisionary.microtang.order.adapter.OrderDetailsAdapter;
import com.chinavisionary.microtang.order.model.OrderModel;
import com.chinavisionary.microtang.order.vo.DetailItemsBean;
import com.chinavisionary.microtang.order.vo.EventUpdateOrderStateVo;
import com.chinavisionary.microtang.order.vo.KeyValueVo;
import com.chinavisionary.microtang.order.vo.OrderDetailsVo;
import com.chinavisionary.microtang.view.BuyCartSpecView;
import com.chinavisionary.paymentlibrary.PayTypeActivity;
import com.chinavisionary.paymentlibrary.vo.EventPayStateVo;
import com.chinavisionary.paymentlibrary.vo.PayTypeVo;
import g.b.a.m;
import g.b.a.r;
import java.math.BigDecimal;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class OrderDetailsFragment extends BaseFragment<LeftTitleToRightArrowVo> {
    public TextView B;
    public TextView C;
    public TextView D;
    public TextView E;
    public AppCompatButton F;
    public AppCompatButton G;
    public int H;
    public int I;
    public OrderModel J;
    public OrderDetailsVo K;
    public boolean L;

    @BindView(R.id.swipe_refresh_layout_order_details)
    public BaseSwipeRefreshLayout mBaseSwipeRefreshLayout;

    @BindView(R.id.view_bottom_bg)
    public View mBgView;

    @BindView(R.id.tv_count_pay_price)
    public TextView mCountPayPriceTv;

    @BindView(R.id.tv_count_pay_title)
    public TextView mCountPayTitleTv;

    @BindView(R.id.btn_keep_pay)
    public AppCompatButton mKeepPayBtn;

    @BindView(R.id.tv_title)
    public TextView mTitleTv;

    public static OrderDetailsFragment getInstance(String str, int i2) {
        OrderDetailsFragment orderDetailsFragment = new OrderDetailsFragment();
        orderDetailsFragment.setArguments(CoreBaseFragment.q(str));
        orderDetailsFragment.V1(i2);
        return orderDetailsFragment;
    }

    public final BuyCartVo E1(DetailItemsBean detailItemsBean) {
        BuyCartVo buyCartVo = new BuyCartVo();
        buyCartVo.setSpecCount(detailItemsBean.getSpecifications().size());
        buyCartVo.setTotalAmount(detailItemsBean.getTotalAmount());
        buyCartVo.setFeesBeans(detailItemsBean.getPrices());
        KeyValueVo keyValueVo = new KeyValueVo();
        keyValueVo.setKey(x.getString(R.string.title_total_count));
        keyValueVo.setValue(x.bigDecimalToPlainString(buyCartVo.getTotalAmount()));
        buyCartVo.getFeesBeans().add(keyValueVo);
        buyCartVo.setCommodities(e.commoditySpecsToBuyCartProduct(detailItemsBean.getSpecifications()));
        return buyCartVo;
    }

    public final View F1(LayoutInflater layoutInflater, DetailItemsBean detailItemsBean) {
        View viewInflate = layoutInflater.inflate(R.layout.item_order_details_head_layout, (ViewGroup) this.r, false);
        BuyCartSpecView buyCartSpecView = (BuyCartSpecView) viewInflate.findViewById(R.id.view_buy_cart_spec);
        CoreRoundedImageView coreRoundedImageView = (CoreRoundedImageView) viewInflate.findViewById(R.id.img_business_cover);
        TextView textView = (TextView) viewInflate.findViewById(R.id.tv_business_name);
        View viewFindViewById = viewInflate.findViewById(R.id.view_spec_bottom_line);
        coreRoundedImageView.setTag(coreRoundedImageView.getId(), detailItemsBean.getMerchantKey());
        coreRoundedImageView.setOnClickListener(this.y);
        coreRoundedImageView.loadImageToResourceVo(detailItemsBean.getMerchantCover());
        textView.setText(x.getNotNullStr(detailItemsBean.getMerchantName(), ""));
        buyCartSpecView.addDataToSpec(E1(detailItemsBean), 0, false, 5, 6);
        viewFindViewById.setVisibility(0);
        return viewInflate;
    }

    public final void G1() {
        this.F.setVisibility(8);
        this.E.setVisibility(8);
    }

    public final void H1() {
        int i2 = this.I;
        if (i2 == 0) {
            S1();
            return;
        }
        if (i2 == 4002 || i2 == 5) {
            R1();
        } else {
            if (i2 != 6) {
                return;
            }
            Q1();
        }
    }

    public final void I1() {
        int i2 = this.I;
        if (i2 == 0) {
            P1();
        } else if (i2 == 4002) {
            T1();
        }
    }

    public final void J1(View view) {
        c0(MerchantMainActivity.class, (String) view.getTag(view.getId()));
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    public final void K1(OrderDetailsVo orderDetailsVo) {
        H();
        this.mBaseSwipeRefreshLayout.setRefreshing(false);
        if (orderDetailsVo == null || !orderDetailsVo.isSuccess()) {
            F0(R.string.data_error);
            return;
        }
        if (this.L) {
            U1(this.I, orderDetailsVo.getOrderStatus());
        }
        this.E.setText(x.bigDecimalToPlainStringAddRMBUnit(orderDetailsVo.getTotalPayAmount()));
        this.I = orderDetailsVo.getOrderStatus();
        if (this.K == null) {
            this.K = orderDetailsVo;
            List<DetailItemsBean> detailItems = orderDetailsVo.getDetailItems();
            LayoutInflater layoutInflaterFrom = LayoutInflater.from(this.f6486d);
            for (DetailItemsBean detailItemsBean : detailItems) {
                if (detailItemsBean != null) {
                    this.t.addHeadView(F1(layoutInflaterFrom, detailItemsBean));
                }
            }
        } else {
            this.K = orderDetailsVo;
        }
        this.t.initListData((List<T>) e.keyValueToLeftTitleToRightArrowVo(orderDetailsVo.getOthers()));
        Z1(orderDetailsVo.getOrderStatus(), orderDetailsVo.getOrderStatusName());
    }

    public final void L1(ResponseStateVo responseStateVo) {
        if (F(responseStateVo, R.string.title_operation_success, R.string.title_operation_failed)) {
            this.L = true;
            if (this.H != 2) {
                S();
                return;
            }
            int i2 = this.I;
            U1(i2, i2);
            n();
        }
    }

    public final void P1() {
        z0(R.string.tip_submit_cancel);
        this.J.cancelOrder(this.f6484b);
    }

    public final void Q1() {
        K0(OrderCommentFragment.getInstance(this.f6484b, "微棠食.一店"), R.id.flayout_content);
    }

    public final void R1() {
        u0(x.getString(R.string.tip_alert_content_receive_commodity));
    }

    public final void S1() {
        String string = x.getString(R.string.title_wt_food);
        BigDecimal totalPayAmount = this.K.getTotalPayAmount();
        PayBillVo payBillVo = new PayBillVo();
        payBillVo.setPaymentKey(this.f6484b);
        PayTypeVo payTypeVo = new PayTypeVo();
        payTypeVo.setType(19);
        payTypeVo.setBill(true);
        payTypeVo.setResStrId(R.string.title_wt_food);
        payTypeVo.setPrice(x.bigDecimalToPlainString(totalPayAmount));
        payTypeVo.setTitle(x.appendStringToResId(R.string.placeholder_pay_order_fee, string));
        payTypeVo.setExtJson(JSON.toJSONString(payBillVo));
        Intent intent = new Intent(this.f6487e, (Class<?>) PayTypeActivity.class);
        intent.setFlags(268435456);
        intent.putExtra("key", JSON.toJSONString(payTypeVo));
        startActivity(intent);
    }

    public final void T1() {
        z0(R.string.tip_submit_data_loading);
        this.J.confirmReceipt(this.f6484b);
    }

    public final void U1(int i2, int i3) {
        this.L = false;
        EventUpdateOrderStateVo eventUpdateOrderStateVo = new EventUpdateOrderStateVo();
        eventUpdateOrderStateVo.setOrderState(i3);
        eventUpdateOrderStateVo.setOldOrderState(i2);
        k(eventUpdateOrderStateVo);
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void V(View view) {
        switch (view.getId()) {
            case R.id.btn_action /* 2131230831 */:
                H1();
                break;
            case R.id.btn_action_cancel /* 2131230833 */:
                u0(x.getString(R.string.title_tip_cancel_pay));
                break;
            case R.id.img_business_cover /* 2131231202 */:
                J1(view);
                break;
            case R.id.tv_alert_confirm /* 2131231942 */:
                I1();
                break;
        }
    }

    public final void V1(int i2) {
        this.H = i2;
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void W() {
        h0(this);
        this.mTitleTv.setText(this.H == 1 ? R.string.title_order_details : R.string.title_bill_details);
        X1();
        a2();
        Y1();
        z0(R.string.loading_text);
        S();
    }

    public final void W1() {
        View viewInflate = LayoutInflater.from(this.f6487e).inflate(R.layout.item_reserve_details_head_layout, (ViewGroup) this.r, false);
        viewInflate.setBackgroundColor(getResources().getColor(R.color.color_line));
        this.B = (TextView) viewInflate.findViewById(R.id.tv_reserve_state);
        this.C = (TextView) viewInflate.findViewById(R.id.tv_reserve_state_center);
        this.D = (TextView) viewInflate.findViewById(R.id.tv_reserve_timer);
        this.E = (TextView) viewInflate.findViewById(R.id.tv_pay_price);
        this.G = (AppCompatButton) viewInflate.findViewById(R.id.btn_action);
        this.F = (AppCompatButton) viewInflate.findViewById(R.id.btn_action_cancel);
        this.G.setOnClickListener(this.y);
        this.F.setOnClickListener(this.y);
        this.F.setVisibility(8);
        this.C.setVisibility(0);
        this.D.setVisibility(8);
        this.t.addHeadView(viewInflate);
    }

    public final void X1() {
        this.mBgView.setVisibility(8);
        this.mKeepPayBtn.setVisibility(8);
        this.mCountPayPriceTv.setVisibility(8);
        this.mCountPayTitleTv.setVisibility(8);
    }

    public final void Y1() {
        OrderModel orderModel = (OrderModel) h(OrderModel.class);
        this.J = orderModel;
        orderModel.getOrderDetailsLive().observe(this, new Observer() { // from class: c.e.c.b0.b.j
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f1390a.K1((OrderDetailsVo) obj);
            }
        });
        this.J.getCancelOrderLive().observe(this, new Observer() { // from class: c.e.c.b0.b.h
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f1388a.L1((ResponseStateVo) obj);
            }
        });
        this.J.getConfirmOrderLive().observe(this, new Observer() { // from class: c.e.c.b0.b.h
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f1388a.L1((ResponseStateVo) obj);
            }
        });
        this.J.getErrRequestLiveData().observe(this, new Observer() { // from class: c.e.c.b0.b.i
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f1389a.C((RequestErrDto) obj);
            }
        });
    }

    public final void Z1(int i2, String str) {
        this.I = i2;
        if (i2 == -1 || i2 == 0) {
            this.E.setVisibility(0);
            this.G.setVisibility(0);
            this.F.setVisibility(0);
            this.B.setText(x.getNotNullStr(str, ""));
            return;
        }
        if (i2 == 6) {
            G1();
            this.G.setVisibility(0);
            this.G.setText(R.string.title_comment);
            this.B.setText(x.getNotNullStr(str, ""));
            return;
        }
        if (i2 != 4002) {
            G1();
            this.G.setVisibility(8);
            this.B.setVisibility(8);
            this.C.setText(x.getNotNullStr(str, ""));
            return;
        }
        G1();
        this.G.setVisibility(0);
        this.G.setText(R.string.title_confirm_receiver_product);
        this.B.setText(x.getNotNullStr(str, ""));
    }

    public final void a2() {
        this.t = new OrderDetailsAdapter();
        this.r = this.mBaseSwipeRefreshLayout.getBaseRecyclerView();
        b2();
    }

    public final void b2() {
        W1();
    }

    @OnClick({R.id.tv_back})
    public void backClick(View view) {
        n();
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public int getLayoutId() {
        return R.layout.fragment_order_details_layout;
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    /* JADX INFO: renamed from: j0 */
    public void S() {
        this.J.getOrderDetails(this.f6484b, this.H);
    }

    @OnClick({R.id.btn_keep_pay})
    public void keepPayClickView(View view) {
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        L0(this);
    }

    @m(threadMode = r.MAIN)
    public void subscribePayResult(EventPayStateVo eventPayStateVo) {
        if (this.H == 2) {
            H();
            if (eventPayStateVo.isSuccess()) {
                n();
            } else {
                G0(eventPayStateVo.getMsg());
            }
        }
    }
}
