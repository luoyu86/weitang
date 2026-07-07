package c.e.c.x.a;

import com.chinavisionary.core.app.net.base.dto.ResponseRowsVo;
import com.chinavisionary.core.app.net.base.dto.ResponseStateVo;
import com.chinavisionary.framework.mobile.common.vo.ResponseContent;
import com.chinavisionary.framework.mobile.login.dto.UserSimpleDto;
import com.chinavisionary.framework.mobile.user.param.UpdateAppUserInfoParam;
import com.chinavisionary.microtang.auth.vo.RequestIDCardBo;
import com.chinavisionary.microtang.me.bo.UpdateDeviceIdVo;
import com.chinavisionary.microtang.me.vo.NameValueVo;
import h.q.f;
import h.q.n;
import h.q.o;
import h.q.s;
import h.q.t;

/* JADX INFO: loaded from: classes.dex */
public interface d {
    @h.q.b("frameworks/push/android/{deviceid}")
    h.b<ResponseContent<ResponseStateVo>> delPushDeviceId(@s("deviceid") String str, @t("sourceType") int i2);

    @o("frameworks/systems/logout")
    h.b<ResponseContent<String>> doLogout();

    @f("frameworks/systems/users/dropdown/education")
    h.b<ResponseContent<ResponseRowsVo<NameValueVo>>> getEductionList();

    @f("frameworks/systems/users/dropdown/credentials/type")
    h.b<ResponseContent<ResponseRowsVo<NameValueVo>>> getIDTypeList();

    @f("frameworks/systems/users/dropdown/marriage")
    h.b<ResponseContent<ResponseRowsVo<NameValueVo>>> getMarriageList();

    @f("frameworks/systems/users/dropdown/political")
    h.b<ResponseContent<ResponseRowsVo<NameValueVo>>> getPoliticalList();

    @o("frameworks/systems/security")
    h.b<ResponseContent<String>> getPublicKey();

    @o("frameworks/systems/verificationCode")
    h.b<ResponseContent<String>> getSmsCode(@h.q.a String str);

    @f("frameworks/systems/users/detail")
    h.b<ResponseContent<String>> getUserIdCardInfo();

    @f("frameworks/systems/users/dropdown/work/address")
    h.b<ResponseContent<ResponseRowsVo<NameValueVo>>> getWorkAddressList();

    @o("frameworks/systems/login")
    h.b<ResponseContent<UserSimpleDto>> postLogin(@h.q.a String str);

    @o("frameworks/push/android")
    h.b<ResponseContent<ResponseStateVo>> postPushDeviceId(@h.q.a UpdateDeviceIdVo updateDeviceIdVo);

    @o("frameworks/systems/register")
    h.b<ResponseContent<UserSimpleDto>> postRegister(@h.q.a String str);

    @o("frameworks/systems/login/phone")
    h.b<ResponseContent<UserSimpleDto>> postSmsLogin(@h.q.a String str);

    @n("frameworks/systems/users/chipher")
    h.b<ResponseContent<String>> updatePassword(@h.q.a String str);

    @n("frameworks/systems/users/chipherByVerifyCode")
    h.b<ResponseContent<ResponseStateVo>> updatePasswordToPhone(@h.q.a String str);

    @n("frameworks/systems/users/phone")
    h.b<ResponseContent<String>> updatePhone(@h.q.a String str);

    @n("frameworks/systems/users/update")
    h.b<ResponseContent<ResponseStateVo>> updateUserInfo(@h.q.a UpdateAppUserInfoParam updateAppUserInfoParam);

    @o("frameworks/systems/users/validate")
    h.b<ResponseContent<ResponseStateVo>> userAuth(@h.q.a RequestIDCardBo requestIDCardBo);
}
