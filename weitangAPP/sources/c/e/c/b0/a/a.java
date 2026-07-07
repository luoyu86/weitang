package c.e.c.b0.a;

import com.chinavisionary.core.app.net.base.dto.ResponseRowsVo;
import com.chinavisionary.core.app.net.base.dto.ResponseStateVo;
import com.chinavisionary.framework.mobile.common.vo.ResponseContent;
import com.chinavisionary.microtang.order.vo.OrderDetailsVo;
import com.chinavisionary.microtang.order.vo.OrderVo;
import h.q.f;
import h.q.n;
import h.q.s;
import h.q.u;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public interface a {
    @n("order/{paymentKey}/cancel")
    h.b<ResponseContent<ResponseStateVo>> cancelOrder(@s("paymentKey") String str);

    @n("order/{paymentKey}/confirm/receipt")
    h.b<ResponseContent<ResponseStateVo>> confirmReceipt(@s("paymentKey") String str);

    @f("order/{type}/{paymentKey}/detail")
    h.b<ResponseContent<OrderDetailsVo>> getOrderDetails(@s("type") int i2, @s("paymentKey") String str);

    @f("order/list")
    h.b<ResponseContent<ResponseRowsVo<OrderVo>>> getOrderList(@u Map<String, String> map);
}
