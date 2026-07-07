package c.e.c.g0.a;

import com.chinavisionary.core.app.net.base.dto.ResponseStateVo;
import com.chinavisionary.framework.mobile.common.vo.ResponseContent;
import com.chinavisionary.microtang.repair.vo.CreateRepairOrderCommentVo;
import com.chinavisionary.microtang.repair.vo.CreateRepairOrderVo;
import com.chinavisionary.microtang.repair.vo.RepairCommentDetailsVo;
import com.chinavisionary.microtang.repair.vo.RepairDeviceMenuVo;
import com.chinavisionary.microtang.repair.vo.RepairDeviceVo;
import com.chinavisionary.microtang.repair.vo.RepairHistoryVo;
import com.chinavisionary.microtang.repair.vo.RepairOrderCommentScoreVo;
import com.chinavisionary.microtang.repair.vo.RepairOrderItemDetailsVo;
import com.chinavisionary.microtang.repair.vo.RepairOrderItemVo;
import com.chinavisionary.microtang.repair.vo.RepairOrderReasonVo;
import com.chinavisionary.microtang.repair.vo.RequestCreateRepairBo;
import com.chinavisionary.microtang.repair.vo.ResponseVo;
import com.chinavisionary.microtang.repair.vo.UpdateAuthOpenDoorParamBo;
import h.b;
import h.q.f;
import h.q.n;
import h.q.o;
import h.q.s;
import h.q.u;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public interface a {
    @n("orders/maintain/{key}")
    b<ResponseContent<ResponseStateVo>> cancelRepair(@s("key") String str);

    @n("repair/cancel/{repairOrderKey}")
    b<ResponseContent<ResponseStateVo>> cancelRepairOrder(@s("repairOrderKey") String str);

    @o("repair")
    b<ResponseContent<ResponseStateVo>> createRepairOrder(@h.q.a CreateRepairOrderVo createRepairOrderVo);

    @o("repair/comment")
    b<ResponseContent<ResponseStateVo>> createRepairOrderComment(@h.q.a CreateRepairOrderCommentVo createRepairOrderCommentVo);

    @f("repair/device/queryDevice/{deviceMenuKey}")
    b<ResponseContent<ResponseVo<RepairDeviceMenuVo>>> getDeviceAssetMenuList(@s("deviceMenuKey") String str);

    @f("repair/device/menu")
    b<ResponseContent<ResponseVo<RepairDeviceVo>>> getDeviceMenuList();

    @f("orders/maintain")
    b<ResponseContent<ResponseVo<RepairHistoryVo>>> getRecordList(@u Map<String, String> map);

    @f("repair/comment/{orderKey}")
    b<ResponseContent<RepairCommentDetailsVo>> getRepairOrderCommentDetails(@s("orderKey") String str);

    @f("repair/comment/score/type/{key}")
    b<ResponseContent<RepairOrderCommentScoreVo>> getRepairOrderCommentScore(@s("key") int i2);

    @f("repair/{repairOrderKey}")
    b<ResponseContent<RepairOrderItemDetailsVo>> getRepairOrderItemDetails(@s("repairOrderKey") String str);

    @f("repair")
    b<ResponseContent<ResponseVo<RepairOrderItemVo>>> getRepairOrderList(@u Map<String, String> map);

    @f("repair/device/{assetKey}/asset/instance")
    b<ResponseContent<RepairOrderReasonVo>> getRepairOrderReason(@s("assetKey") String str);

    @o("orders/maintain")
    b<ResponseContent<ResponseStateVo>> postRepair(@h.q.a RequestCreateRepairBo requestCreateRepairBo);

    @n("repair/auth/time/{orderKey}")
    b<ResponseContent<ResponseStateVo>> updateAuthOpenDoorTime(@s("orderKey") String str, @h.q.a UpdateAuthOpenDoorParamBo updateAuthOpenDoorParamBo);
}
