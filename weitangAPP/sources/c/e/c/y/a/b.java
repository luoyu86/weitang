package c.e.c.y.a;

import com.chinavisionary.framework.mobile.common.vo.ResponseContent;
import com.chinavisionary.microtang.merchant.vo.CommodityVo;
import h.q.f;
import h.q.s;

/* JADX INFO: loaded from: classes.dex */
public interface b {
    @f("shoppings/takeaways/commodities/{commodityKey}")
    h.b<ResponseContent<CommodityVo>> getCommodityDetails(@s("commodityKey") String str);
}
