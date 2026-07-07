package c.e.e.a.q;

import c.e.e.a.s.d;
import c.e.e.a.s.e;
import com.chinavisionary.core.app.net.base.dto.BaseVo;
import com.chinavisionary.core.app.net.base.dto.NewResponseRowsVo;
import com.chinavisionary.core.app.net.base.dto.NewResponseStateVo;
import com.chinavisionary.core.app.net.base.dto.RequestErrDto;
import com.chinavisionary.core.app.net.base.dto.ResponseRowsVo;
import com.chinavisionary.framework.mobile.common.vo.ResponseContent;
import h.q.i;
import h.q.o;

/* JADX INFO: loaded from: classes2.dex */
public interface a {
    @o("houses/access/controls?source=1")
    h.b<ResponseContent<ResponseRowsVo<e>>> getLockList(@i("Token") String str, @h.q.a BaseVo baseVo);

    @o(RequestErrDto.GET_SPACE_GOODS_PWD_ROOM_LIST_URL)
    h.b<NewResponseRowsVo<d>> getRoomList(@i("Token") String str, @h.q.a BaseVo baseVo);

    @o("user/rent/spacegoods/list")
    h.b<NewResponseRowsVo<d>> getSignRoomList(@i("Token") String str, @h.q.a BaseVo baseVo);

    @o("user/rent/spacegoods/switch")
    h.b<NewResponseStateVo> postRoomKey(@i("Token") String str, @h.q.a c.e.e.a.s.i iVar);
}
