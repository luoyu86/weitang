package c.e.c.a0.e;

import com.chinavisionary.core.app.net.base.dto.ResponseRowsVo;
import com.chinavisionary.framework.mobile.common.vo.ResponseContent;
import com.chinavisionary.microtang.open.bo.RoomOpenLockRecordDetailsVo;
import com.chinavisionary.microtang.open.bo.RoomOpenLockRecordVo;
import h.b;
import h.q.f;
import h.q.s;
import h.q.u;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public interface a {
    @f("rents/houses/{rentHouseKey}/doors/records")
    b<ResponseContent<ResponseRowsVo<RoomOpenLockRecordDetailsVo>>> getOpenLockRecordDetailsList(@s("rentHouseKey") String str, @u Map<String, String> map);

    @f("rents/houses/doors")
    b<ResponseContent<ResponseRowsVo<RoomOpenLockRecordVo>>> getRoomOpenLockRecordList(@u Map<String, String> map);
}
