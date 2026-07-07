package c.e.c.b0.a.c;

import com.chinavisionary.core.app.net.base.dto.ResponseStateVo;
import com.chinavisionary.framework.mobile.common.vo.ResponseContent;
import com.chinavisionary.microtang.order.vo.CleanOrderCommentDetailsVo;
import com.chinavisionary.microtang.order.vo.CleanOrderItemDetailsVo;
import com.chinavisionary.microtang.repair.vo.CreateRepairOrderCommentVo;
import com.chinavisionary.microtang.repair.vo.RepairOrderCommentScoreVo;
import h.b;
import h.q.f;
import h.q.n;
import h.q.o;
import h.q.s;

/* JADX INFO: loaded from: classes.dex */
public interface a {
    @n("cleaning/cancel/{cleaningOrderKey}")
    b<ResponseContent<ResponseStateVo>> cancelCleanOrder(@s("cleaningOrderKey") String str);

    @o("cleaning/comment")
    b<ResponseContent<ResponseStateVo>> createCleanOrderComment(@h.q.a CreateRepairOrderCommentVo createRepairOrderCommentVo);

    @f("cleaning/comment/{orderKey}")
    b<ResponseContent<CleanOrderCommentDetailsVo>> getCleanOrderCommentDetails(@s("orderKey") String str);

    @f("cleaning/comment/score/type/{commentResult}")
    b<ResponseContent<RepairOrderCommentScoreVo>> getCleanOrderCommentScore(@s("commentResult") int i2);

    @f("cleaning/{cleaningOrderKey}")
    b<ResponseContent<CleanOrderItemDetailsVo>> getCleanOrderDetails(@s("cleaningOrderKey") String str);
}
