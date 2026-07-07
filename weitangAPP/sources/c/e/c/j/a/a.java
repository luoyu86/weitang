package c.e.c.j.a;

import com.chinavisionary.core.app.net.base.dto.ResponseRowsVo;
import com.chinavisionary.core.app.net.base.dto.ResponseStateVo;
import com.chinavisionary.framework.mobile.common.vo.ResponseContent;
import com.chinavisionary.microtang.bill.vo.BillDetailsVo;
import com.chinavisionary.microtang.bill.vo.BillVo;
import com.chinavisionary.microtang.sign.vo.ResponseFirstFeeVo;
import h.b;
import h.q.f;
import h.q.s;
import h.q.u;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public interface a {
    @f("bills/{contractKey}/fees")
    b<ResponseContent<ResponseStateVo>> confirmBillFirstFee(@s("contractKey") String str);

    @f("bills/{billkey}/detail")
    b<ResponseContent<BillDetailsVo>> getBillDetails(@s("billkey") String str);

    @f("bills/{contractKey}/first/fee")
    b<ResponseContent<ResponseFirstFeeVo>> getBillFirstFee(@s("contractKey") String str);

    @f("bills/list")
    b<ResponseContent<ResponseRowsVo<BillVo>>> getBillList(@u Map<String, String> map);
}
