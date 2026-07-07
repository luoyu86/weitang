package c.e.c.h.a;

import com.chinavisionary.core.app.net.base.dto.ResponseRowsVo;
import com.chinavisionary.core.app.net.base.dto.ResponseStateVo;
import com.chinavisionary.framework.mobile.common.vo.ResponseContent;
import com.chinavisionary.microtang.auth.vo.MeAuthDetailsVo;
import com.chinavisionary.microtang.auth.vo.MeAuthHandleVo;
import com.chinavisionary.microtang.auth.vo.MeAuthVo;
import h.b;
import h.q.f;
import h.q.o;
import h.q.s;
import h.q.u;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public interface a {
    @f("auth/door/{authKey}/detail")
    b<ResponseContent<MeAuthDetailsVo>> getMeAuthDetails(@s("authKey") String str);

    @f("auth/door")
    b<ResponseContent<ResponseRowsVo<MeAuthVo>>> getMeAuthList(@u Map<String, String> map);

    @o("auth/door/auth")
    b<ResponseContent<ResponseStateVo>> postHandleAuth(@h.q.a MeAuthHandleVo meAuthHandleVo);
}
