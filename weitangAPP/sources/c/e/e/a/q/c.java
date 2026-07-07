package c.e.e.a.q;

import c.e.e.a.s.g;
import c.e.e.a.s.h;
import c.e.e.a.s.j;
import com.chinavisionary.core.app.net.base.dto.NewResponseRowsVo;
import com.chinavisionary.core.app.net.base.dto.NewResponseStateVo;
import com.chinavisionary.twlib.open.bo.AlertMessageVo;
import com.chinavisionary.twlib.open.bo.ResponseOpenDoorVo;
import com.chinavisionary.twlib.open.bo.TwLibCheckCreateCommentBo;
import h.q.f;
import h.q.i;
import h.q.o;
import h.q.t;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public interface c {
    @o("business/comment/popup/data")
    h.b<TwLibCheckCreateCommentBo> getCheckCreateComment(@i("Token") String str, @h.q.a g gVar);

    @o("business/comment/sign/popup/data")
    h.b<TwLibCheckCreateCommentBo> getCheckSignComment(@i("Token") String str, @h.q.a HashMap<String, Object> map);

    @f("business/get/secretkey")
    h.b<ResponseOpenDoorVo> getDoorPwdToKey(@i("Token") String str, @t("assetKey") String str2);

    @o("message/bounced/open/doorlock/after")
    h.b<NewResponseRowsVo<AlertMessageVo>> getDoorlockAfter(@i("Token") String str, @h.q.a j jVar);

    @o("message/bounced/open/doorlock/before")
    h.b<NewResponseRowsVo<AlertMessageVo>> getDoorlockBefore(@i("Token") String str, @h.q.a j jVar);

    @o("business/create/open/door/batch")
    h.b<String> postBatchDoorOpenDoorRecord(@h.q.a c.e.e.a.s.b bVar);

    @o("business/create/open/door")
    h.b<String> postDoorOpenDoorRecord(@i("Token") String str, @h.q.a c.e.e.a.s.f fVar);

    @o("business/entrance/guard/remote/open")
    h.b<NewResponseStateVo> postNetworkOpenDoor(@i("Token") String str, @h.q.a h hVar);
}
