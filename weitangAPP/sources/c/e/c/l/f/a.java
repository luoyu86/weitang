package c.e.c.l.f;

import com.chinavisionary.core.app.net.base.dto.ResponseRowsVo;
import com.chinavisionary.framework.mobile.common.vo.ResponseContent;
import com.chinavisionary.microtang.me.vo.CleanProductDetailsVo;
import com.chinavisionary.microtang.me.vo.ValueaddedListBo;
import h.q.f;
import h.q.s;
import h.q.t;

/* JADX INFO: loaded from: classes.dex */
public interface a {
    @f("valueadded/{key}/detail")
    h.b<ResponseContent<CleanProductDetailsVo>> getCleanDetails(@s("key") String str);

    @f("valueadded/category/list")
    h.b<ResponseContent<ResponseRowsVo<ValueaddedListBo>>> getCleanList(@t("projectKey") String str, @t("assetInstanceKey") String str2, @t("goodsCategory") String str3);
}
