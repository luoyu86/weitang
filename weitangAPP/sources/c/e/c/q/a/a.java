package c.e.c.q.a;

import c.e.c.q.d.c;
import c.e.c.q.d.d;
import com.chinavisionary.core.app.net.base.dto.NewResponseStateVo;
import com.chinavisionary.microtang.doorpwd.vo.ResponseDoorPasswordBleCommandBo;
import h.b;
import h.q.o;

/* JADX INFO: loaded from: classes.dex */
public interface a {
    @o("business/update/secretKey")
    b<ResponseDoorPasswordBleCommandBo> getDoorPasswordBleCommand(@h.q.a c cVar);

    @o("business/report/results")
    b<NewResponseStateVo> postDoorPasswordBleCommandResult(@h.q.a d dVar);
}
