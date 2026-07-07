package c.e.c.h0.g;

import c.e.a.d.o;
import com.chinavisionary.core.app.net.base.dto.NewResponseRowsVo;
import com.chinavisionary.microtang.main.vo.ResponseGroupItemDetailsRoomVo;
import com.chinavisionary.microtang.repair.vo.ResponseVo;
import com.chinavisionary.microtang.room.vo.MoreRentRoomVo;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class b {
    public static ResponseVo<MoreRentRoomVo> groupRoomToMoreRentRoomVo(NewResponseRowsVo<ResponseGroupItemDetailsRoomVo> newResponseRowsVo) {
        boolean z;
        ResponseVo<MoreRentRoomVo> responseVo = new ResponseVo<>();
        if (newResponseRowsVo != null && o.isNotEmpty(newResponseRowsVo.getRows())) {
            ArrayList arrayList = new ArrayList();
            for (ResponseGroupItemDetailsRoomVo responseGroupItemDetailsRoomVo : newResponseRowsVo.getRows()) {
                if (responseGroupItemDetailsRoomVo != null) {
                    MoreRentRoomVo moreRentRoomVo = new MoreRentRoomVo();
                    moreRentRoomVo.setHouseName(responseGroupItemDetailsRoomVo.getHouseName());
                    moreRentRoomVo.setMinimumMonthlyRent(responseGroupItemDetailsRoomVo.getRentPrice());
                    moreRentRoomVo.setUnderlineRentFee(responseGroupItemDetailsRoomVo.getUnderlineRentFee());
                    moreRentRoomVo.setGoodsKey(responseGroupItemDetailsRoomVo.getHouseKey());
                    moreRentRoomVo.setAssetInstanceKey(responseGroupItemDetailsRoomVo.getHouseKey());
                    boolean z2 = false;
                    if (responseGroupItemDetailsRoomVo.getReserveStatus() == null || responseGroupItemDetailsRoomVo.getReserveStatus().intValue() != 0) {
                        z = false;
                    } else {
                        moreRentRoomVo.setStatus(5);
                        moreRentRoomVo.setStatusName(responseGroupItemDetailsRoomVo.getReserveStatusName());
                        z = true;
                    }
                    if (responseGroupItemDetailsRoomVo.getSignStatus() != null && responseGroupItemDetailsRoomVo.getSignStatus().intValue() == 0) {
                        moreRentRoomVo.setStatus(1);
                        moreRentRoomVo.setStatusName(responseGroupItemDetailsRoomVo.getSignStatusName());
                        z2 = true;
                    }
                    if (z && z2) {
                        moreRentRoomVo.setStatus(6);
                    }
                    if (!z && !z2) {
                        moreRentRoomVo.setStatusName(responseGroupItemDetailsRoomVo.getHouseStatusName());
                    }
                    arrayList.add(moreRentRoomVo);
                }
            }
            responseVo.setRows(arrayList);
        }
        return responseVo;
    }
}
