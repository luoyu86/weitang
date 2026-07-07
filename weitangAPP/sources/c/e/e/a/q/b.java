package c.e.e.a.q;

import c.e.e.a.s.d;
import c.e.e.a.s.e;
import com.chinavisionary.core.app.net.base.dto.NewResponseRowsVo;
import com.chinavisionary.core.app.net.base.dto.ResponseRowsVo;
import com.chinavisionary.core.app.net.base.dto.ResponseStateVo;
import com.chinavisionary.framework.mobile.common.vo.ResponseContent;
import h.q.f;
import h.q.i;
import h.q.o;
import h.q.u;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public interface b {
    @f("business/house/access/controls?source=1")
    h.b<NewResponseRowsVo<e>> getLockList(@i("Token") String str);

    @f("business/house/access/controls/power?source=1")
    h.b<NewResponseRowsVo<e>> getLockPowerList(@i("Token") String str, @u Map<String, String> map);

    @f("business/house/access/controls/status?source=1")
    h.b<NewResponseRowsVo<e>> getLockRoomStateList(@i("Token") String str, @u Map<String, String> map);

    @f("houses/list")
    h.b<ResponseContent<ResponseRowsVo<d>>> getSignRoomList(@i("Token") String str);

    @o("houses/swtich")
    h.b<ResponseContent<ResponseStateVo>> postRoomKey(@i("Token") String str, @h.q.a c.e.e.a.s.i iVar);
}
