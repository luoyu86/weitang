package c.e.c.b0.a;

import com.chinavisionary.core.app.net.base.dto.ResponseRowsVo;
import com.chinavisionary.framework.mobile.common.vo.ResponseContent;
import com.chinavisionary.microtang.order.vo.ServiceOrderVo;
import h.q.f;
import h.q.u;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public interface b {
    @f("business/order")
    h.b<ResponseContent<ResponseRowsVo<ServiceOrderVo>>> getServiceOrderList(@u Map<String, String> map);
}
