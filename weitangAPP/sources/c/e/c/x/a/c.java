package c.e.c.x.a;

import com.chinavisionary.core.app.config.bo.AppConfigExtVo;
import com.chinavisionary.core.app.config.bo.NewUserInfoVo;
import com.chinavisionary.core.app.net.base.dto.BaseVo;
import com.chinavisionary.core.app.net.base.dto.NewResponseRowsVo;
import com.chinavisionary.core.app.net.base.dto.NewResponseStateVo;
import com.chinavisionary.core.app.net.base.dto.ResponseRowsVo;
import com.chinavisionary.core.app.net.base.dto.ResponseStateVo;
import com.chinavisionary.framework.mobile.common.vo.ResponseContent;
import com.chinavisionary.framework.mobile.login.param.SMSSendParam;
import com.chinavisionary.microtang.login.bo.InterestItemVo;
import com.chinavisionary.microtang.login.bo.InterestSelectTagBo;
import com.chinavisionary.microtang.main.vo.ResponseWaterElectricVo;
import com.chinavisionary.microtang.me.bo.CancelAccountBo;
import com.chinavisionary.microtang.me.bo.CancelAccountReasonBo;
import com.chinavisionary.microtang.me.bo.CreateRollOutBo;
import com.chinavisionary.microtang.me.bo.NewCancelAccountBo;
import com.chinavisionary.microtang.me.bo.ReportClickMessageBo;
import com.chinavisionary.microtang.me.bo.RequestClickStatisticBo;
import com.chinavisionary.microtang.me.bo.ResponseManagerQrCodeBo;
import com.chinavisionary.microtang.me.bo.RollOutResultBo;
import com.chinavisionary.microtang.me.vo.BadgeVo;
import com.chinavisionary.microtang.me.vo.NewResponseRollOutVo;
import com.chinavisionary.microtang.me.vo.ResponseWalletVo;
import com.chinavisionary.microtang.me.vo.UpdateUserIdBo;
import com.chinavisionary.microtang.me.vo.WalletRecordDetailsVo;
import com.chinavisionary.microtang.me.vo.WalletRecordVo;
import com.chinavisionary.microtang.me.vo.WorkAddressVo;
import com.chinavisionary.microtang.vo.RequestUserInfoVo;
import com.chinavisionary.twlib.open.bo.AlertMessageVo;
import h.q.f;
import h.q.i;
import h.q.o;
import h.q.s;
import h.q.t;
import h.q.u;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public interface c {
    @o("vtapp/v1/user/apply/cancel")
    h.b<NewResponseStateVo> doCancelAccount(@h.q.a CancelAccountBo cancelAccountBo);

    @o("vtapp/v1/contract/rent/cancellation")
    h.b<NewResponseStateVo> doCancelAccountNew(@h.q.a NewCancelAccountBo newCancelAccountBo);

    @o("vtapp/v1/convenient/statistics/commit")
    h.b<NewResponseStateVo> doClickStatistic(@h.q.a RequestClickStatisticBo requestClickStatisticBo);

    @f("message/popup")
    h.b<ResponseContent<ResponseRowsVo<AlertMessageVo>>> getAlertMessageList();

    @f("system/config")
    h.b<ResponseContent<AppConfigExtVo>> getAppConfig(@i("Token") String str);

    @f("system/config/phone")
    h.b<ResponseContent<ResponseStateVo>> getAppPhoneConfig(@t("projectKey") String str, @t("assetInstanceKey") String str2);

    @f("system/tips")
    h.b<ResponseContent<BadgeVo>> getBadge(@i("Token") String str);

    @o("vtapp/v1/contract/rent/cancellation/reason")
    h.b<CancelAccountReasonBo> getCancelAccountReason(@h.q.a CancelAccountBo cancelAccountBo);

    @f("vtapp/v1/user/get/butler/qrcode")
    h.b<ResponseManagerQrCodeBo> getManagerQrCode(@i("Token") String str);

    @o("vtapp/v1/account/withdraw/result")
    h.b<NewResponseStateVo> getRollOutState(@h.q.a RollOutResultBo rollOutResultBo);

    @f("houses/balance")
    h.b<ResponseContent<ResponseWaterElectricVo>> getRoomBalanceFee();

    @f("houses/balance")
    h.b<ResponseContent<ResponseWaterElectricVo>> getRoomBalanceFee(@t("contractKey") String str);

    @o("vtapp/v1/frameworks/systems/user/send/verification/code")
    h.b<NewResponseStateVo> getSmsCode(@h.q.a String str);

    @o("vtapp/v1/news/user/detail")
    h.b<NewUserInfoVo> getUserInfo(@i("Token") String str, @h.q.a RequestUserInfoVo requestUserInfoVo);

    @o("vtapp/v1/user/interest/tag/list ")
    h.b<NewResponseRowsVo<InterestItemVo>> getUserInterestTags(@h.q.a BaseVo baseVo);

    @o("vtapp/v1/user/balance")
    h.b<ResponseWalletVo> getWalletBalance(@i("Token") String str, @h.q.a BaseVo baseVo);

    @f("account/records/detail")
    h.b<ResponseContent<WalletRecordDetailsVo>> getWalletRecordDetails(@s("recordKey") String str);

    @f("account/records")
    h.b<ResponseContent<ResponseRowsVo<WalletRecordVo>>> getWalletRecordList(@u Map<String, String> map);

    @f("user/address/tags")
    h.b<ResponseContent<ResponseRowsVo<WorkAddressVo>>> getWorkAddressUrl();

    @o("vtapp/v1/message/dealwith")
    h.b<NewResponseStateVo> postClickMessageReport(@h.q.a ReportClickMessageBo reportClickMessageBo);

    @o("vtapp/v1/account/withdraw/send/code")
    h.b<NewResponseStateVo> postOutWalletSendCode(@h.q.a SMSSendParam sMSSendParam);

    @o("vtapp/v1/account/withdraw")
    h.b<NewResponseRollOutVo> postRollOutWalletBalance(@i("Token") String str, @h.q.a CreateRollOutBo createRollOutBo);

    @o("vtapp/v1/user/add/interest/tag")
    h.b<NewResponseStateVo> postUserInterestTags(@h.q.a InterestSelectTagBo interestSelectTagBo);

    @o("user")
    h.b<ResponseContent<ResponseStateVo>> updateUserIdInfo(@h.q.a UpdateUserIdBo updateUserIdBo);
}
