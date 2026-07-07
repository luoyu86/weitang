package c.e.c.k0.d;

import com.chinavisionary.framework.mobile.common.vo.ResponseContent;
import com.chinavisionary.microtang.subscribe.vo.ResponseSubscribeVo;
import com.chinavisionary.microtang.subscribe.vo.SubscribeRoomBo;
import h.q.b;
import h.q.f;
import h.q.o;
import h.q.s;
import h.q.u;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public interface a {
    @b("reserve/visit/house/reserves/records/{key}")
    h.b<ResponseContent<String>> cancelSubscribe(@s("key") String str);

    @f("reserve/visit/house/reserves/records")
    h.b<ResponseContent<ResponseSubscribeVo>> getRecordList(@u Map<String, String> map);

    @o("reserve/visit/house/{key}/reserves/times")
    h.b<ResponseContent<String>> postSubscribe(@s("key") String str, @h.q.a SubscribeRoomBo subscribeRoomBo);
}
