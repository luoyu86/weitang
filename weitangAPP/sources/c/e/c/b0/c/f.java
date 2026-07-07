package c.e.c.b0.c;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import c.e.a.d.o;
import com.chinavisionary.core.app.net.base.dto.PageBo;
import com.chinavisionary.core.app.net.base.dto.RequestErrDto;
import com.chinavisionary.core.app.net.base.dto.ResponseRowsVo;
import com.chinavisionary.core.app.net.base.dto.ResponseStateVo;
import com.chinavisionary.microtang.order.model.OrderModel;
import com.chinavisionary.microtang.order.vo.OrderVo;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public c.e.c.b0.d.a f1398a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public OrderModel f1399b;

    public f(c.e.c.b0.d.a aVar) {
        this.f1398a = aVar;
        e();
    }

    public final void a(ResponseRowsVo<OrderVo> responseRowsVo) {
        if (responseRowsVo == null) {
            b(null);
            return;
        }
        ArrayList arrayList = new ArrayList();
        List<OrderVo> rows = responseRowsVo.getRows();
        if (o.isNotEmpty(rows)) {
            for (OrderVo orderVo : rows) {
                if (orderVo != null) {
                    e.addBuyCartVo(orderVo, arrayList);
                }
            }
        }
        this.f1398a.setupOrderList(arrayList);
    }

    public final void b(RequestErrDto requestErrDto) {
        c.e.c.b0.d.a aVar = this.f1398a;
        if (aVar != null) {
            aVar.setupRequestErr(requestErrDto);
        }
    }

    public final void e() {
        c.e.c.b0.d.a aVar = this.f1398a;
        if (aVar != null) {
            Fragment currentFragment = aVar.getCurrentFragment();
            OrderModel orderModel = (OrderModel) ViewModelProviders.of(currentFragment).get(OrderModel.class);
            this.f1399b = orderModel;
            orderModel.getOrderListLive().observe(currentFragment, new Observer() { // from class: c.e.c.b0.c.b
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    this.f1396a.a((ResponseRowsVo) obj);
                }
            });
            MutableLiveData<ResponseStateVo> confirmOrderLive = this.f1399b.getConfirmOrderLive();
            final c.e.c.b0.d.a aVar2 = this.f1398a;
            Objects.requireNonNull(aVar2);
            confirmOrderLive.observe(currentFragment, new Observer() { // from class: c.e.c.b0.c.c
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    aVar2.operationResponseState((ResponseStateVo) obj);
                }
            });
            MutableLiveData<ResponseStateVo> cancelOrderLive = this.f1399b.getCancelOrderLive();
            final c.e.c.b0.d.a aVar3 = this.f1398a;
            Objects.requireNonNull(aVar3);
            cancelOrderLive.observe(currentFragment, new Observer() { // from class: c.e.c.b0.c.c
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    aVar3.operationResponseState((ResponseStateVo) obj);
                }
            });
            this.f1399b.getErrRequestLiveData().observe(currentFragment, new Observer() { // from class: c.e.c.b0.c.a
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    this.f1395a.b((RequestErrDto) obj);
                }
            });
        }
    }

    public void getOrderList(PageBo pageBo, int i2) {
        OrderModel orderModel = this.f1399b;
        if (orderModel != null) {
            orderModel.getOrderList(pageBo, i2);
        }
    }

    public void performCancelOrder(String str) {
        OrderModel orderModel = this.f1399b;
        if (orderModel != null) {
            orderModel.cancelOrder(str);
        }
    }

    public void performReceiverCommodity(String str) {
        OrderModel orderModel = this.f1399b;
        if (orderModel != null) {
            orderModel.confirmReceipt(str);
        }
    }
}
