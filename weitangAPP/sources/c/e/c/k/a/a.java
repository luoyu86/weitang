package c.e.c.k.a;

import anet.channel.request.Request;
import com.chinavisionary.core.app.net.base.dto.ResponseRowsVo;
import com.chinavisionary.core.app.net.base.dto.ResponseStateVo;
import com.chinavisionary.framework.mobile.common.vo.ResponseContent;
import com.chinavisionary.microtang.buycart.vo.BuyCartVo;
import com.chinavisionary.microtang.buycart.vo.RequestAddBuyCartBo;
import com.chinavisionary.microtang.buycart.vo.RequestDelBuyCartBo;
import com.chinavisionary.microtang.buycart.vo.RequestUpdateBuyCartBo;
import h.q.f;
import h.q.h;
import h.q.n;
import h.q.o;
import h.q.u;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public interface a {
    @h(hasBody = true, method = Request.Method.DELETE, path = "carts")
    h.b<ResponseContent<ResponseStateVo>> deleteBuyCart(@h.q.a RequestDelBuyCartBo requestDelBuyCartBo);

    @f("carts/all")
    h.b<ResponseContent<ResponseRowsVo<BuyCartVo>>> getAllBuyCartList(@u Map<String, String> map);

    @f("carts")
    h.b<ResponseContent<ResponseRowsVo<BuyCartVo>>> getBuyCartList(@u Map<String, String> map);

    @n("carts")
    h.b<ResponseContent<ResponseStateVo>> patchBuyCart(@h.q.a RequestUpdateBuyCartBo requestUpdateBuyCartBo);

    @o("carts")
    h.b<ResponseContent<ResponseStateVo>> postBuyCart(@h.q.a RequestAddBuyCartBo requestAddBuyCartBo);
}
