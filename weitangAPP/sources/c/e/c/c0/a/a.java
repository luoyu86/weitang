package c.e.c.c0.a;

import com.chinavisionary.core.app.net.base.dto.ResponseRowsVo;
import com.chinavisionary.framework.mobile.common.vo.ResponseContent;
import com.chinavisionary.microtang.bill.vo.PayBillResultVo;
import com.chinavisionary.microtang.contract.vo.ContractClauseVo;
import com.chinavisionary.microtang.pre.vo.RequestReserveInfoVo;
import com.chinavisionary.microtang.pre.vo.ReserveCancelResultVo;
import com.chinavisionary.microtang.pre.vo.ReserveClauseRequestVo;
import com.chinavisionary.microtang.pre.vo.ReserveDetailsVo;
import com.chinavisionary.microtang.pre.vo.ReserveFddContractVo;
import com.chinavisionary.microtang.pre.vo.ReserveItemVo;
import com.chinavisionary.microtang.pre.vo.ReserveRoomInfoVo;
import h.b;
import h.q.f;
import h.q.n;
import h.q.o;
import h.q.s;

/* JADX INFO: loaded from: classes.dex */
public interface a {
    @n("rent/reserve/{reserveKey}/cancel")
    b<ResponseContent<ReserveCancelResultVo>> cancelReserve(@s("reserveKey") String str);

    @o("rent/reserve/clause/list")
    b<ResponseContent<ResponseRowsVo<ContractClauseVo>>> getReserveClauseList(@h.q.a ReserveClauseRequestVo reserveClauseRequestVo);

    @f("rent/reserve/{reserveKey}/detail")
    b<ResponseContent<ReserveDetailsVo>> getReserveDetails(@s("reserveKey") String str);

    @f("rent/reserve/{reserveKey}/sign")
    b<ResponseContent<ReserveFddContractVo>> getReserveFdd(@s("reserveKey") String str);

    @f("rent/reserve/list")
    b<ResponseContent<ResponseRowsVo<ReserveItemVo>>> getReserveList();

    @f("rent/reserve/{assetKey}/before")
    b<ResponseContent<ReserveRoomInfoVo>> getReserveRoomInfoToKey(@s("assetKey") String str);

    @o("rent/reserve/confirm")
    b<ResponseContent<PayBillResultVo>> postReserve(@h.q.a RequestReserveInfoVo requestReserveInfoVo);
}
