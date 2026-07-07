package c.e.c.v.a;

import com.chinavisionary.core.app.net.base.dto.NewResponseRowsVo;
import com.chinavisionary.core.app.net.base.dto.NewResponseStateVo;
import com.chinavisionary.microtang.community.vo.ActivityConstantVo;
import com.chinavisionary.microtang.main.bo.ClickBannerParamBo;
import com.chinavisionary.microtang.main.bo.RequestBannerParamBo;
import com.chinavisionary.microtang.main.bo.ResponseBannerItemVo;
import com.chinavisionary.microtang.main.bo.ResponseNewBannerItemVo;
import h.q.f;
import h.q.i;
import h.q.o;
import h.q.t;

/* JADX INFO: loaded from: classes.dex */
public interface a {
    @o("nologin/banner")
    h.b<NewResponseRowsVo<ResponseNewBannerItemVo>> getBannerList(@i("Token") String str, @h.q.a RequestBannerParamBo requestBannerParamBo);

    @f("nologin/constant")
    h.b<ActivityConstantVo> getConstantList(@i("Token") String str, @t("type") String str2);

    @o("nologin/banner/list")
    h.b<NewResponseRowsVo<ResponseBannerItemVo>> getRoomBannerList(@i("Token") String str, @h.q.a RequestBannerParamBo requestBannerParamBo);

    @o("nologin/banner/click")
    h.b<NewResponseStateVo> postBannerClick(@i("Token") String str, @h.q.a ClickBannerParamBo clickBannerParamBo);
}
