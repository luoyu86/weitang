package c.e.c.x.a;

import com.chinavisionary.core.app.net.base.dto.BaseVo;
import com.chinavisionary.core.app.net.base.dto.NewResponseStateVo;
import com.chinavisionary.framework.mobile.user.param.NewUpdateAppUserInfoParam;
import com.chinavisionary.microtang.login.bo.LogoutBo;
import com.chinavisionary.microtang.login.bo.SecretKeyBo;
import com.chinavisionary.microtang.login.vo.NewResponseLoginResultVo;
import com.chinavisionary.microtang.main.bo.RequestSwitchProjectBo;
import com.chinavisionary.microtang.me.bo.NewUpdateDeviceIdVo;
import com.chinavisionary.microtang.me.vo.RequestEnterpriseAuthStateBo;
import com.chinavisionary.microtang.me.vo.ResponseEnterpriseAuthStateBo;
import com.chinavisionary.microtang.me.vo.ResponseEnterpriseNotifyBo;
import h.q.i;
import h.q.o;

/* JADX INFO: loaded from: classes.dex */
public interface b {
    @o("vtapp/v1/user/device/push/remove")
    h.b<NewResponseStateVo> delPushDeviceId(@h.q.a BaseVo baseVo);

    @o("vtapp/v1/frameworks/systems/user/logout")
    h.b<LogoutBo> doLogout(@h.q.a BaseVo baseVo);

    @o("vtapp/v1/user/enterprise/check/auth/enterprise")
    h.b<ResponseEnterpriseAuthStateBo> getEnterpriseAuthState(@i("Token") String str, @h.q.a RequestEnterpriseAuthStateBo requestEnterpriseAuthStateBo);

    @o("vtapp/v1/user/enterprise/check/in/plan")
    h.b<ResponseEnterpriseNotifyBo> getEnterpriseNotify(@i("Token") String str, @h.q.a BaseVo baseVo);

    @o("vtapp/v1/frameworks/systems/user/send/verification/code")
    h.b<NewResponseStateVo> getSmsCode(@h.q.a String str);

    @o("uas-2/v1/uas/security")
    h.b<SecretKeyBo> getUasPublicKey(@i("secretKey") String str, @h.q.a BaseVo baseVo);

    @o("vtapp/v1/nologin/user/reset/phone")
    h.b<NewResponseStateVo> noLoginUpdatePhone(@h.q.a String str);

    @o("vtapp/v1/frameworks/systems/user/app/login")
    h.b<NewResponseLoginResultVo> postLogin(@h.q.a String str);

    @o("vtapp/v1/user/device/push/add")
    h.b<NewResponseStateVo> postPushDeviceId(@h.q.a NewUpdateDeviceIdVo newUpdateDeviceIdVo);

    @o("vtapp/v1/frameworks/systems/user/app/register")
    h.b<NewResponseLoginResultVo> postRegister(@h.q.a String str);

    @o("vtapp/v1/frameworks/systems/user/app/login")
    h.b<NewResponseLoginResultVo> postSmsLogin(@h.q.a String str);

    @o("vtapp/v1/nologin/update/project")
    h.b<NewResponseStateVo> switchProject(@h.q.a RequestSwitchProjectBo requestSwitchProjectBo);

    @o("vtapp/v1/user/update/pwd")
    h.b<NewResponseStateVo> updatePassword(@h.q.a String str);

    @o("vtapp/v1/user/update/pwd")
    h.b<NewResponseStateVo> updatePasswordToPhone(@h.q.a String str);

    @o("vtapp/v1/user/reset/phone")
    h.b<NewResponseStateVo> updatePhone(@h.q.a String str);

    @o("vtapp/v1/user/update")
    h.b<NewResponseStateVo> updateUserInfo(@h.q.a NewUpdateAppUserInfoParam newUpdateAppUserInfoParam);
}
