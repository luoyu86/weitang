package c.e.c.y.a;

import com.chinavisionary.core.app.net.base.dto.ResponseRowsVo;
import com.chinavisionary.core.weight.banner.EditBannerView;
import com.chinavisionary.framework.mobile.common.vo.ResponseContent;
import com.chinavisionary.microtang.main.vo.MerchantInfoVo;
import com.chinavisionary.microtang.merchant.vo.MerchantDetailsVo;
import com.chinavisionary.microtang.merchant.vo.MerchantProductVo;
import h.q.f;
import h.q.s;
import h.q.u;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public interface c {
    @f("shoppings/takeaways/merchants/{merchantKey}/banners")
    h.b<ResponseContent<ResponseRowsVo<EditBannerView.BannerDto>>> getMerchantBanner(@s("merchantKey") String str);

    @f("shoppings/takeaways/merchants/{merchantKey}")
    h.b<ResponseContent<MerchantDetailsVo>> getMerchantDetails(@s("merchantKey") String str);

    @f("shoppings/takeaways/merchants")
    h.b<ResponseContent<ResponseRowsVo<MerchantInfoVo>>> getMerchantList(@u Map<String, String> map);

    @f("shoppings/takeaways/merchants/{merchantKey}/commodities")
    h.b<ResponseContent<ResponseRowsVo<MerchantProductVo>>> getMerchantProductList(@s("merchantKey") String str);
}
