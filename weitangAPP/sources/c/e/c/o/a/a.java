package c.e.c.o.a;

import com.chinavisionary.core.app.net.base.dto.ResponseRowsVo;
import com.chinavisionary.core.app.net.base.dto.ResponseStateVo;
import com.chinavisionary.framework.mobile.common.vo.ResponseContent;
import com.chinavisionary.microtang.contract.vo.ContractChangeResponse;
import com.chinavisionary.microtang.contract.vo.ContractClauseVo;
import com.chinavisionary.microtang.contract.vo.ContractCommentVo;
import com.chinavisionary.microtang.contract.vo.ContractExitRentPropertyStateVo;
import com.chinavisionary.microtang.contract.vo.ContractExitRentStateDetailsVo;
import com.chinavisionary.microtang.contract.vo.ContractExitRentVo;
import com.chinavisionary.microtang.contract.vo.ContractListDetailsVo;
import com.chinavisionary.microtang.contract.vo.ContractListVo;
import com.chinavisionary.microtang.contract.vo.ContractLiveTogetherVo;
import com.chinavisionary.microtang.contract.vo.ContractPropertyStateVo;
import com.chinavisionary.microtang.contract.vo.ContractRentFeeVo;
import com.chinavisionary.microtang.contract.vo.ContractTogetherLiveVo;
import com.chinavisionary.microtang.contract.vo.RentBackFeePreviewListVo;
import com.chinavisionary.microtang.contract.vo.RequestExitRentVo;
import com.chinavisionary.microtang.contract.vo.ResponseFddSignUrlVo;
import com.chinavisionary.microtang.contract.vo.ResponseSignBillWaitPayVo;
import com.chinavisionary.microtang.contract.vo.ResponseSignMainInfoVo;
import com.chinavisionary.microtang.contract.vo.ResultTreatyVo;
import com.chinavisionary.microtang.contract.vo.SignMainInfoVo;
import com.chinavisionary.microtang.contract.vo.SubmitContractCommentBo;
import com.chinavisionary.microtang.contract.vo.SubmitPropertyStateVo;
import com.chinavisionary.microtang.contract.vo.UpdateTogetherLiveBo;
import h.b;
import h.q.f;
import h.q.n;
import h.q.o;
import h.q.s;
import h.q.t;
import h.q.u;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public interface a {
    @n("rent/back/{rentbackkey}/cancel")
    b<ResponseContent<ResponseStateVo>> cancelExitRent(@s("rentbackkey") String str);

    @n("contracts/{key}/cancel")
    b<ResponseContent<ResponseStateVo>> cancelPay(@s("key") String str);

    @n("rent/back/{rentbackkey}/finish")
    b<ResponseContent<ResponseStateVo>> finishExitRent(@s("rentbackkey") String str);

    @f("contracts/checkin/convention")
    b<ResponseContent<ResultTreatyVo>> getCheckinContactUrl();

    @f("contracts/{contractkey}/rent")
    b<ResponseContent<ResponseRowsVo<ContractRentFeeVo>>> getContactRentFeeDetails(@s("contractkey") String str);

    @f("contracts/change/rent/before")
    b<ResponseContent<ContractChangeResponse>> getContractChangeRent(@t("preContractKey") String str);

    @f("contracts/{contractKey}/comment/items")
    b<ResponseContent<ContractCommentVo>> getContractCommentInfo(@s("contractKey") String str);

    @f("rent/back/{contractkey}/sign/user/info")
    b<ResponseContent<ContractExitRentVo>> getContractExitRent(@s("contractkey") String str);

    @f("rent/back/{contractkey}/detail")
    b<ResponseContent<ContractExitRentStateDetailsVo>> getContractExitRentDetails(@s("contractkey") String str);

    @f("rent/back/{rentbackkey}/deliveries")
    b<ResponseContent<ResponseRowsVo<ContractExitRentPropertyStateVo>>> getContractExitRentPropertyList(@s("rentbackkey") String str);

    @f("contracts/list")
    b<ResponseContent<ResponseRowsVo<ContractListVo>>> getContractList(@u Map<String, String> map);

    @f("contracts/{contractkey}")
    b<ResponseContent<ContractListDetailsVo>> getContractListDetails(@s("contractkey") String str);

    @f("contracts/{contractKey}/roommates")
    b<ResponseContent<ContractLiveTogetherVo<ContractTogetherLiveVo>>> getContractTogetherLiveList(@s("contractKey") String str);

    @f("rent/back/preview")
    b<ResponseContent<RentBackFeePreviewListVo>> getExitRentFeePreview(@u Map<String, String> map);

    @f("rent/back/rule")
    b<ResponseContent<ResponseStateVo>> getExitRentRule();

    @f("contracts/{contractkey}/sign/url")
    b<ResponseContent<ResponseFddSignUrlVo>> getFddContactUrl(@s("contractkey") String str);

    @f("contracts/safety/instructions")
    b<ResponseContent<ResultTreatyVo>> getSafetyInstructionUrl();

    @f("contracts/unpaid/bill")
    b<ResponseContent<ResponseRowsVo<ResponseSignBillWaitPayVo>>> getSignBillCount();

    @f("contracts/signing/main")
    b<ResponseContent<ResponseSignMainInfoVo>> getSignMain(@u Map<String, String> map);

    @o("contracts/{contractKey}/comment")
    b<ResponseContent<ResponseStateVo>> postContractCommentInfo(@s("contractKey") String str, @h.q.a SubmitContractCommentBo submitContractCommentBo);

    @o("contracts/{contractKey}/roommates/save")
    b<ResponseContent<ResponseStateVo>> postContractTogetherLiveList(@s("contractKey") String str, @h.q.a UpdateTogetherLiveBo updateTogetherLiveBo);

    @n("rent/back/confirm")
    b<ResponseContent<ResponseStateVo>> postExitRent(@h.q.a RequestExitRentVo requestExitRentVo);

    @o("contracts/{contractKey}/asset/recognition")
    b<ResponseContent<ResponseStateVo>> postRecognitionInfo(@s("contractKey") String str, @h.q.a SubmitPropertyStateVo submitPropertyStateVo);

    @o("contracts/signing/main")
    b<ResponseContent<ResponseStateVo>> postSaveSignMainInfo(@h.q.a SignMainInfoVo signMainInfoVo);

    @f("contracts/clause/{contractkey}")
    b<ResponseContent<ResultTreatyVo>> queryContractClause(@s("contractkey") String str);

    @f("contracts/{contractKey}/clause/list")
    b<ResponseContent<ResponseRowsVo<ContractClauseVo>>> queryContractClauseList(@s("contractKey") String str);

    @f("contracts/asset/recognition")
    b<ResponseContent<ResponseRowsVo<ContractPropertyStateVo>>> queryRecofnitionState(@t("contractKey") String str);
}
