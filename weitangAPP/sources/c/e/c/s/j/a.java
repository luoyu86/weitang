package c.e.c.s.j;

import com.chinavisionary.core.app.net.base.dto.NewResponseRowsVo;
import com.chinavisionary.core.app.net.base.dto.ResponseRowsVo;
import com.chinavisionary.core.app.net.base.dto.ResponseStateVo;
import com.chinavisionary.framework.mobile.common.vo.ResponseContent;
import com.chinavisionary.microtang.hydropower.vo.CreateOrderBo;
import com.chinavisionary.microtang.hydropower.vo.CreatePayOrderBo;
import com.chinavisionary.microtang.hydropower.vo.CreateWaterElectriBo;
import com.chinavisionary.microtang.hydropower.vo.ElectricBalanceVo;
import com.chinavisionary.microtang.hydropower.vo.ElectricVo;
import com.chinavisionary.microtang.hydropower.vo.PayRecordVo;
import com.chinavisionary.microtang.hydropower.vo.RentFeeVo;
import com.chinavisionary.microtang.hydropower.vo.RoomOtherFeeUnitVo;
import com.chinavisionary.microtang.hydropower.vo.WaterBalanceVo;
import com.chinavisionary.microtang.hydropower.vo.WaterElectriVo;
import com.chinavisionary.microtang.me.vo.RecordTabVo;
import com.chinavisionary.microtang.me.vo.RecordVo;
import h.b;
import h.q.f;
import h.q.o;
import h.q.s;
import h.q.u;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public interface a {
    @o("payment/rechargeElectricityFee")
    b<ResponseContent<WaterElectriVo>> createElectriPay(@h.q.a CreateWaterElectriBo createWaterElectriBo);

    @o("orders/payments/electricity")
    b<ResponseContent<ResponseStateVo>> createElectricOrder(@h.q.a CreateOrderBo createOrderBo);

    @o("orders/payments/{key}")
    b<ResponseContent<ResponseStateVo>> createPayOrder(@s("key") String str, @h.q.a CreatePayOrderBo createPayOrderBo);

    @o("orders/payments/water")
    b<ResponseContent<ResponseStateVo>> createWaterOrder(@h.q.a CreateOrderBo createOrderBo);

    @o("payment/rechargeWaterFee")
    b<ResponseContent<WaterElectriVo>> createWaterPay(@h.q.a CreateWaterElectriBo createWaterElectriBo);

    @f("payment/electricity")
    b<ResponseContent<ElectricBalanceVo>> getElectricBalance();

    @f("houses/{rechargetype}/recharge/quantity")
    b<ResponseContent<ResponseRowsVo<ElectricVo>>> getElectricList(@s("rechargetype") String str);

    @f("payment/paymentInfoList")
    b<ResponseContent<ResponseRowsVo<PayRecordVo>>> getPayRecordList(@u Map<String, String> map);

    @o("account/recharge/amount/list")
    b<NewResponseRowsVo<ElectricVo>> getRechargeWalletList(@h.q.a HashMap map);

    @f("houses/history/reading/type")
    b<ResponseContent<ResponseRowsVo<RecordTabVo>>> getRecordTabList();

    @f("orders/payments/prepare")
    b<ResponseContent<ResponseRowsVo<RentFeeVo>>> getRentFee();

    @f("houses/water/electric/unit")
    b<ResponseContent<RoomOtherFeeUnitVo>> getRoomOtherFee();

    @f("payment/water")
    b<ResponseContent<WaterBalanceVo>> getWaterBalance();

    @f("houses/{rechargetype}/recharge/quantity")
    b<ResponseContent<ResponseRowsVo<ElectricVo>>> getWaterList(@s("rechargetype") String str);

    @f("houses/history/reading")
    b<ResponseContent<ResponseRowsVo<RecordVo>>> getWaterRecordList(@u Map<String, String> map);
}
