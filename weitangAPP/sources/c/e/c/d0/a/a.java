package c.e.c.d0.a;

import com.chinavisionary.core.app.net.base.dto.ResponseRowsVo;
import com.chinavisionary.core.app.net.base.dto.ResponseStateVo;
import com.chinavisionary.framework.mobile.common.vo.ResponseContent;
import com.chinavisionary.microtang.prelook.vo.PreLookCommentVo;
import com.chinavisionary.microtang.prelook.vo.PreLookVo;
import h.b;
import h.q.f;
import h.q.o;
import h.q.p;
import h.q.s;
import h.q.u;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public interface a {
    @p("appointment/cancel/{appointmentKey}")
    b<ResponseContent<ResponseStateVo>> cancelPreLook(@s("appointmentKey") String str);

    @f("appointment")
    b<ResponseContent<ResponseRowsVo<PreLookVo>>> getPreLookRecordList(@u Map<String, String> map);

    @o("appointment/comment")
    b<ResponseContent<ResponseStateVo>> postComment(@h.q.a PreLookCommentVo preLookCommentVo);
}
