package c.e.c.k.a;

import com.chinavisionary.core.app.net.base.dto.ResponseStateVo;
import com.chinavisionary.framework.mobile.common.vo.ResponseContent;
import com.chinavisionary.microtang.buycart.bo.RequestCreateOrderBo;
import com.chinavisionary.microtang.buycart.vo.RequestAmountBo;
import com.chinavisionary.microtang.buycart.vo.RequestCreateBuyCartOrderVo;
import com.chinavisionary.microtang.buycart.vo.RequestInitBuyCartOrderVo;
import com.chinavisionary.microtang.buycart.vo.ResponseAmountVo;
import com.chinavisionary.microtang.buycart.vo.ResponseWaitBuyListVo;
import h.q.f;
import h.q.o;
import h.q.s;

/* JADX INFO: loaded from: classes.dex */
public interface b {
    @o("shopping/carts/payments/order/init")
    h.b<ResponseContent<ResponseStateVo>> createBuyCartInitOrder(@h.q.a RequestInitBuyCartOrderVo requestInitBuyCartOrderVo);

    @o("order/confirm/create")
    h.b<ResponseContent<ResponseStateVo>> createOrder(@h.q.a RequestCreateOrderBo requestCreateOrderBo);

    @o("shopping/carts/payments/commodities")
    h.b<ResponseContent<String>> createWaitBuyList(@h.q.a RequestCreateBuyCartOrderVo requestCreateBuyCartOrderVo);

    @o("shopping/carts/payments/bills/amounts")
    h.b<ResponseContent<ResponseAmountVo>> getWaitBuyAmount(@h.q.a RequestAmountBo requestAmountBo);

    @f("shopping/carts/payments/commodities/page/data/{toBePurchasedCommoditiesKey}")
    h.b<ResponseContent<ResponseWaitBuyListVo>> getWaitBuyList(@s("toBePurchasedCommoditiesKey") String str);
}
