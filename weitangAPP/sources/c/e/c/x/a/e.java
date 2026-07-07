package c.e.c.x.a;

import com.chinavisionary.core.app.config.bo.AppConfigExtVo;
import com.chinavisionary.core.app.config.bo.UserInfoVo;
import com.chinavisionary.core.app.net.base.dto.NewResponseRowsVo;
import com.chinavisionary.core.app.net.base.dto.NewResponseStateVo;
import com.chinavisionary.core.app.net.base.dto.ResponseRowsVo;
import com.chinavisionary.core.app.net.base.dto.ResponseStateVo;
import com.chinavisionary.framework.mobile.common.vo.ResponseContent;
import com.chinavisionary.microtang.comment.bo.ResponseCommentBadgeBo;
import com.chinavisionary.microtang.login.bo.InterestItemVo;
import com.chinavisionary.microtang.login.bo.InterestSelectTagBo;
import com.chinavisionary.microtang.main.bo.CancelContractParamBo;
import com.chinavisionary.microtang.main.vo.ResponseWaterElectricVo;
import com.chinavisionary.microtang.me.bo.CancelAccountBo;
import com.chinavisionary.microtang.me.bo.CreateRollOutBo;
import com.chinavisionary.microtang.me.bo.RequestServerConfigBo;
import com.chinavisionary.microtang.me.vo.BadgeVo;
import com.chinavisionary.microtang.me.vo.FundNewsVo;
import com.chinavisionary.microtang.me.vo.ResponseRollOutVo;
import com.chinavisionary.microtang.me.vo.ResponseWalletVo;
import com.chinavisionary.microtang.me.vo.UpdateUserIdBo;
import com.chinavisionary.microtang.me.vo.WalletRecordDetailsVo;
import com.chinavisionary.microtang.me.vo.WalletRecordVo;
import com.chinavisionary.microtang.me.vo.WorkAddressVo;
import com.chinavisionary.microtang.vo.RequestUserInfoVo;
import com.chinavisionary.twlib.open.bo.AlertMessageVo;
import h.q.f;
import h.q.i;
import h.q.n;
import h.q.o;
import h.q.t;
import h.q.u;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public interface e {
    @o("cancellation")
    h.b<ResponseContent<ResponseStateVo>> doCancelAccount(@h.q.a CancelAccountBo cancelAccountBo);

    @o("nologin/aboutUs/config")
    h.b<NewResponseRowsVo<FundNewsVo>> getAboutUsConfig(@i("Token") String str, @h.q.a RequestServerConfigBo requestServerConfigBo);

    @o("message/popup/query")
    h.b<NewResponseRowsVo<AlertMessageVo>> getAlertMessageList(@i("Token") String str, @h.q.a RequestUserInfoVo requestUserInfoVo);

    @f("nologin/system/config")
    h.b<ResponseContent<AppConfigExtVo>> getAppConfig(@i("Token") String str);

    @f("system/config/phone")
    h.b<ResponseContent<ResponseStateVo>> getAppPhoneConfig(@i("Token") String str, @t("projectKey") String str2, @t("assetInstanceKey") String str3);

    @o("nologin/convenient/config")
    h.b<NewResponseRowsVo<FundNewsVo>> getAppServerConfig(@i("Token") String str, @h.q.a RequestServerConfigBo requestServerConfigBo);

    @f("user/check/in/apply/number")
    h.b<ResponseCommentBadgeBo> getApplyRentBadge();

    @f("system/tips")
    h.b<ResponseContent<BadgeVo>> getBadge();

    @f("cancel/contract/confirm")
    h.b<NewResponseRowsVo<AlertMessageVo>> getCancelContractAlertMessageList(@i("Token") String str);

    @o("nologin/myVtown/config")
    h.b<NewResponseRowsVo<FundNewsVo>> getMeVtConfig(@i("Token") String str, @h.q.a RequestServerConfigBo requestServerConfigBo);

    @f("vtapp/v1/account/withdraw")
    h.b<ResponseContent<String>> getRollOutState(@t("withdrawalPaymentAccountRecordKey") String str);

    @f("houses/balance")
    h.b<ResponseContent<ResponseWaterElectricVo>> getRoomBalanceFee();

    @f("houses/balance")
    h.b<ResponseContent<ResponseWaterElectricVo>> getRoomBalanceFee(@t("contractKey") String str);

    @f("user")
    h.b<ResponseContent<UserInfoVo>> getUserInfo();

    @f("user/interest/tags")
    h.b<ResponseContent<ResponseRowsVo<InterestItemVo>>> getUserInterestTags();

    @f("account/balance")
    h.b<ResponseContent<ResponseWalletVo>> getWalletBalance();

    @f("account/records/detail")
    h.b<WalletRecordDetailsVo> getWalletRecordDetails(@t("recordKey") String str);

    @f("account/records")
    h.b<NewResponseRowsVo<WalletRecordVo>> getWalletRecordList(@u Map<String, String> map);

    @f("user/address/tags")
    h.b<ResponseContent<ResponseRowsVo<WorkAddressVo>>> getWorkAddressUrl();

    @o("cancel/contract/click")
    h.b<NewResponseStateVo> postCancelContractAlertMessageList(@i("Token") String str, @h.q.a CancelContractParamBo cancelContractParamBo);

    @o("vtapp/v1/account/withdraw")
    h.b<ResponseContent<ResponseRollOutVo>> postRollOutWalletBalance(@h.q.a CreateRollOutBo createRollOutBo);

    @o("user/portrait/tags")
    h.b<ResponseContent<ResponseStateVo>> postUserInterestTags(@h.q.a InterestSelectTagBo interestSelectTagBo);

    @n("user")
    h.b<ResponseContent<ResponseStateVo>> updateUserIdInfo(@h.q.a UpdateUserIdBo updateUserIdBo);
}
