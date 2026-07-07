package c.e.c.z.a;

import com.chinavisionary.core.app.net.base.dto.BaseVo;
import com.chinavisionary.framework.mobile.common.vo.ResponseContent;
import com.chinavisionary.microtang.msg.vo.BadgeCountVo;
import com.chinavisionary.microtang.msg.vo.MsgVo;
import com.chinavisionary.microtang.msg.vo.RequestReadBadgeBo;
import com.chinavisionary.microtang.repair.vo.ResponseVo;
import h.b;
import h.q.f;
import h.q.i;
import h.q.o;
import h.q.u;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public interface a {
    @o("business/message/count")
    b<BadgeCountVo> getMsgCountList(@i("Token") String str, @h.q.a BaseVo baseVo);

    @f("message/general")
    b<ResponseContent<ResponseVo<MsgVo>>> getMsgList(@u Map<String, String> map);

    @o("message/general/read")
    b<ResponseContent<BadgeCountVo>> postReadMsgList(@h.q.a RequestReadBadgeBo requestReadBadgeBo);
}
