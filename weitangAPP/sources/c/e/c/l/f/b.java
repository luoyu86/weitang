package c.e.c.l.f;

import com.chinavisionary.core.app.net.base.dto.NewResponseRowsVo;
import com.chinavisionary.microtang.clean.vo.RequestIncrementServiceDetailsParamBo;
import com.chinavisionary.microtang.clean.vo.RequestIncrementServiceParamBo;
import com.chinavisionary.microtang.clean.vo.RequestSubmitOrderParamBo;
import com.chinavisionary.microtang.life.bo.RequestGetCouponGoodsParam;
import com.chinavisionary.microtang.life.vo.SubmitLifeOrderDetailsVo;
import com.chinavisionary.microtang.me.vo.CleanProductVo;
import com.chinavisionary.microtang.me.vo.NewCleanProductDetailsVo;
import h.q.i;
import h.q.o;

/* JADX INFO: loaded from: classes.dex */
public interface b {
    @o("nologin/commodity/detail")
    h.b<NewCleanProductDetailsVo> getCleanDetails(@i("Token") String str, @h.q.a RequestIncrementServiceDetailsParamBo requestIncrementServiceDetailsParamBo);

    @o("nologin/commodity/list")
    h.b<NewResponseRowsVo<CleanProductVo>> getCleanList(@i("Token") String str, @h.q.a RequestIncrementServiceParamBo requestIncrementServiceParamBo);

    @o("nologin/coupon/commodity/list")
    h.b<NewResponseRowsVo<CleanProductVo>> getCouponGoodsList(@i("Token") String str, @h.q.a RequestGetCouponGoodsParam requestGetCouponGoodsParam);

    @o("nologin/commodity/order/page")
    h.b<SubmitLifeOrderDetailsVo> getSubmitOrderDetailsUrl(@i("Token") String str, @h.q.a RequestSubmitOrderParamBo requestSubmitOrderParamBo);
}
