package com.chinavisionary.microtang.order.fragment;

import android.content.Intent;
import android.view.View;
import androidx.fragment.app.Fragment;
import butterknife.BindView;
import c.e.a.d.o;
import c.e.a.d.q;
import c.e.a.d.x;
import c.e.c.b0.c.f;
import com.alibaba.fastjson.JSON;
import com.chinavisionary.core.app.net.base.dto.RequestErrDto;
import com.chinavisionary.core.app.net.base.dto.ResponseStateVo;
import com.chinavisionary.core.weight.BaseSwipeRefreshLayout;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.base.BaseFragment;
import com.chinavisionary.microtang.bill.vo.PayBillVo;
import com.chinavisionary.microtang.buycart.vo.BuyCartVo;
import com.chinavisionary.microtang.merchant.MerchantMainActivity;
import com.chinavisionary.microtang.order.OrderDetailsActivity;
import com.chinavisionary.microtang.order.adapter.OrderAdapter;
import com.chinavisionary.microtang.order.vo.EventUpdateAllStateVo;
import com.chinavisionary.microtang.order.vo.EventUpdateOrderStateVo;
import com.chinavisionary.paymentlibrary.PayTypeActivity;
import com.chinavisionary.paymentlibrary.vo.EventPayStateVo;
import com.chinavisionary.paymentlibrary.vo.PayTypeVo;
import g.b.a.m;
import g.b.a.r;
import java.math.BigDecimal;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class OrderFragment extends BaseFragment<BuyCartVo> {
    public BuyCartVo B;
    public f C;
    public int D;
    public c.e.c.b0.d.a E = new a();
    public c.e.a.a.c.c.a F = new b();

    @BindView(R.id.swipe_refresh_layout)
    public BaseSwipeRefreshLayout mBaseSwipeRefreshLayout;

    public class a implements c.e.c.b0.d.a {
        public a() {
        }

        @Override // c.e.c.b0.d.a
        public Fragment getCurrentFragment() {
            return OrderFragment.this;
        }

        @Override // c.e.c.b0.d.a
        public void operationResponseState(ResponseStateVo responseStateVo) {
            OrderFragment.this.f6483a = 1;
            OrderFragment.this.F(responseStateVo, R.string.title_operation_success, R.string.title_operation_failed);
            OrderFragment.this.j0();
        }

        @Override // c.e.c.b0.d.a
        public void setupOrderList(List<BuyCartVo> list) {
            OrderFragment.this.mBaseSwipeRefreshLayout.setRefreshing(false);
            if (OrderFragment.this.f6483a != 1 || !o.listIsEmpty(list)) {
                OrderFragment.this.D(list);
                return;
            }
            BuyCartVo buyCartVo = new BuyCartVo();
            buyCartVo.setItemType(34952);
            OrderFragment.this.t.initListData(null);
            OrderFragment.this.t.addDataToList(buyCartVo);
        }

        @Override // c.e.c.b0.d.a
        public void setupRequestErr(RequestErrDto requestErrDto) {
            OrderFragment.this.mBaseSwipeRefreshLayout.setRefreshing(false);
            OrderFragment.this.C(requestErrDto);
        }
    }

    public class b implements c.e.a.a.c.c.a {
        public b() {
        }

        @Override // c.e.a.a.c.c.a
        public void onItemClickListener(View view, int i2) {
            OrderFragment.this.Q1(i2);
        }
    }

    public static OrderFragment getInstance(int i2) {
        OrderFragment orderFragment = new OrderFragment();
        orderFragment.V1(i2);
        return orderFragment;
    }

    public final void M1(View view) {
        BuyCartVo buyCartVo = (BuyCartVo) this.t.getList().get(((Integer) view.getTag()).intValue());
        this.B = buyCartVo;
        int orderState = buyCartVo.getOrderState();
        if (orderState == 0) {
            T1();
            return;
        }
        if (orderState == 4002 || orderState == 5) {
            W1();
        } else {
            if (orderState != 6) {
                return;
            }
            S1();
        }
    }

    public final void N1() {
        int orderState = this.B.getOrderState();
        q.d(getClass().getSimpleName(), "handleAlertConfirm order state :" + orderState);
        if (orderState == 0) {
            R1();
        } else if (orderState == 5 || orderState == 4002) {
            U1();
        }
    }

    public final void O1(View view) {
        c0(MerchantMainActivity.class, ((BuyCartVo) this.t.getList().get(((Integer) view.getTag(view.getId())).intValue())).getMerchantKey());
    }

    public final void P1(View view) {
        this.B = (BuyCartVo) this.t.getList().get(((Integer) view.getTag()).intValue());
        u0(x.getString(R.string.title_tip_cancel_pay));
    }

    public final void Q1(int i2) {
        if (i2 >= 0) {
            BuyCartVo buyCartVo = (BuyCartVo) this.t.getList().get(i2);
            this.f6484b = buyCartVo.getBaseKey();
            int i3 = buyCartVo.isBill() ? 2 : 1;
            Intent intent = new Intent(this.f6487e, (Class<?>) OrderDetailsActivity.class);
            intent.setFlags(268435456);
            intent.putExtra("orderStateKey", i3);
            intent.putExtra("key", this.f6484b);
            startActivity(intent);
        }
    }

    public final void R1() {
        z0(R.string.tip_submit_cancel);
        this.C.performCancelOrder(this.B.getBaseKey());
    }

    public final void S1() {
        K0(OrderCommentFragment.getInstance(this.f6484b, this.B.getMerchantName()), R.id.flayout_content);
    }

    public final void T1() {
        String string = x.getString(R.string.title_wt_food);
        BigDecimal totalAmount = this.B.getTotalAmount();
        PayBillVo payBillVo = new PayBillVo();
        payBillVo.setPaymentKey(this.B.getBaseKey());
        PayTypeVo payTypeVo = new PayTypeVo();
        payTypeVo.setResStrId(R.string.title_wt_food);
        payTypeVo.setType(19);
        payTypeVo.setBill(true);
        payTypeVo.setPayCode(this.B.getBaseKey());
        payTypeVo.setPrice(x.bigDecimalToPlainString(totalAmount));
        payTypeVo.setTitle(x.appendStringToResId(R.string.placeholder_pay_order_fee, string));
        payTypeVo.setExtJson(JSON.toJSONString(payBillVo));
        Intent intent = new Intent(this.f6487e, (Class<?>) PayTypeActivity.class);
        intent.setFlags(268435456);
        intent.putExtra("key", JSON.toJSONString(payTypeVo));
        startActivity(intent);
    }

    public final void U1() {
        this.C.performReceiverCommodity(this.B.getBaseKey());
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void V(View view) {
        switch (view.getId()) {
            case R.id.btn_cancel /* 2131230848 */:
                P1(view);
                break;
            case R.id.btn_confirm /* 2131230858 */:
                q.d(OrderFragment.class.getSimpleName(), "position : btn_confirm");
                M1(view);
                break;
            case R.id.img_business_cover /* 2131231202 */:
                O1(view);
                break;
            case R.id.tv_alert_confirm /* 2131231942 */:
                N1();
                break;
        }
    }

    public final void V1(int i2) {
        this.D = i2;
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void W() {
        h0(this);
        this.mBaseSwipeRefreshLayout.setBackgroundColor(getResources().getColor(R.color.color_white));
        this.r = this.mBaseSwipeRefreshLayout.getBaseRecyclerView();
        OrderAdapter orderAdapter = new OrderAdapter(4, this.D);
        this.t = orderAdapter;
        orderAdapter.setEmptyTipMsg(getString(R.string.title_order_empty));
        this.t.setOnItemClickListener(this.F);
        this.t.setOnClickListener(this.y);
        this.C = new f(this.E);
        j0();
    }

    public final void W1() {
        u0(x.getString(R.string.tip_alert_content_receive_commodity));
    }

    @m(threadMode = r.MAIN)
    public void eventUpdateAllStateVo(EventUpdateAllStateVo eventUpdateAllStateVo) {
        this.f6483a = 1;
        j0();
    }

    @m(threadMode = r.MAIN)
    public void eventUpdateOrderState(EventUpdateOrderStateVo eventUpdateOrderStateVo) {
        if (this.D == -1 || eventUpdateOrderStateVo.getOrderState() == this.D || eventUpdateOrderStateVo.getOldOrderState() == this.D) {
            this.f6483a = 1;
            j0();
        }
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public int getLayoutId() {
        return R.layout.fragment_swipe_refresh;
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment
    public void j0() {
        if (O()) {
            this.C.getOrderList(r(), this.D);
        } else {
            H();
        }
    }

    @Override // com.chinavisionary.core.app.base.CoreBaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        L0(this);
    }

    @m(threadMode = r.MAIN)
    public void subscribePayResult(EventPayStateVo eventPayStateVo) {
        int i2 = this.D;
        if (i2 == -1 || i2 == 0) {
            H();
            if (!eventPayStateVo.isSuccess()) {
                G0(eventPayStateVo.getMsg());
            } else {
                this.f6483a = 1;
                j0();
            }
        }
    }
}
