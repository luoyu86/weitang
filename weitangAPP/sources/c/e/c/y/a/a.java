package c.e.c.y.a;

import com.chinavisionary.core.app.net.base.dto.ResponseRowsVo;
import com.chinavisionary.framework.mobile.common.vo.ResponseContent;
import com.chinavisionary.microtang.merchant.vo.MerchantCommentVo;
import h.q.f;
import h.q.s;
import h.q.u;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public interface a {
    @f("shoppings/takeaways/commodities/{commodityKey}/comments")
    h.b<ResponseContent<ResponseRowsVo<MerchantCommentVo>>> getCommodityComment(@s("commodityKey") String str, @u Map<String, String> map);

    @f("shoppings/takeaways/merchants/{merchantKey}/comments")
    h.b<ResponseContent<ResponseRowsVo<MerchantCommentVo>>> getMerchantCommentList(@s("merchantKey") String str, @u Map<String, String> map);
}
