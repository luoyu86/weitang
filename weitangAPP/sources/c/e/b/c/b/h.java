package c.e.b.c.b;

import c.e.a.d.w;
import c.e.b.c.d.q;
import com.alibaba.fastjson.JSON;
import com.chinavisionary.core.app.config.bo.UserInfoVo;
import com.chinavisionary.framework.mobile.common.vo.ResourceVo;
import com.chinavisionary.jslibrary.jsbridge.BridgeWebView;
import com.chinavisionary.microtang.login.bo.NewLoginBo;
import d.k0.d.p;
import d.k0.d.t;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: classes.dex */
public final class h extends c.e.b.c.b.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f1299b = new a(null);

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(p pVar) {
            this();
        }
    }

    public static final class b implements c.e.b.a.a {
        public b() {
        }

        @Override // c.e.b.a.a
        public final void handler(String str, c.e.b.a.d dVar) {
            h.this.a().performAuthActivity();
        }
    }

    public static final class c implements c.e.b.a.a {
        public c() {
        }

        @Override // c.e.b.a.a
        public final void handler(String str, c.e.b.a.d dVar) {
            h hVar = h.this;
            t.checkNotNullExpressionValue(dVar, "function");
            hVar.g(dVar);
        }
    }

    public static final class d implements c.e.b.a.a {
        public d() {
        }

        @Override // c.e.b.a.a
        public final void handler(String str, c.e.b.a.d dVar) {
            h.this.a().performUpdateUserInfo();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(c.e.b.c.c.a aVar) {
        super(aVar);
        t.checkNotNullParameter(aVar, "iView");
    }

    public final String b() {
        return w.getInstance().getString("device_id_key", "");
    }

    public final String c() {
        return w.getInstance().getString(NewLoginBo.SMS_LOGIN_NAME, "");
    }

    public final String d() {
        return w.getInstance().getString(com.alipay.sdk.m.p.e.o, "");
    }

    public final String e() {
        return w.getInstance().getString("Token", "");
    }

    public final UserInfoVo f() {
        String string = w.getInstance().getString("userDetailsInfoKey", null);
        if (string != null) {
            return (UserInfoVo) JSON.parseObject(string, UserInfoVo.class);
        }
        return null;
    }

    public final void g(c.e.b.a.d dVar) {
        String url;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        String strE = e();
        t.checkNotNullExpressionValue(strE, "getTokenValue()");
        linkedHashMap.put("token", strE);
        linkedHashMap.put("source", "vt-app");
        String strD = d();
        t.checkNotNullExpressionValue(strD, "getPublicKeyValue()");
        linkedHashMap.put("publicKey", strD);
        q qVar = new q();
        qVar.setToken(e());
        qVar.setDeviceId(b());
        qVar.setPublicKey(d());
        UserInfoVo userInfoVoF = f();
        if (userInfoVoF != null) {
            String nickname = userInfoVoF.getNickname();
            if (nickname == null) {
                nickname = "";
            }
            qVar.setUserName(nickname);
            qVar.setUserPhone(c());
            c.e.a.a.b bVar = c.e.a.a.b.getInstance();
            t.checkNotNullExpressionValue(bVar, "AppHelper.getInstance()");
            String projectKey = bVar.getProjectKey();
            qVar.setProjectKey(projectKey != null ? projectKey : "");
            qVar.setCertificationStatus(userInfoVoF.isValidate() ? "1" : "0");
            String userKey = userInfoVoF.getUserKey();
            if (userKey != null) {
                linkedHashMap.put("key", userKey);
            }
            String nickname2 = userInfoVoF.getNickname();
            if (nickname2 != null) {
                linkedHashMap.put("nikeName", nickname2);
            }
            ResourceVo avatar = userInfoVoF.getAvatar();
            if (avatar != null && (url = avatar.getUrl()) != null) {
                linkedHashMap.put("avatar", url);
            }
        }
        String jSONString = JSON.toJSONString(qVar);
        c.e.a.d.q.d("UserInfoBridgeManager", "getUserInfo : " + jSONString);
        dVar.onCallBack(jSONString);
    }

    public final void h(BridgeWebView bridgeWebView) {
        bridgeWebView.registerHandler("onIdCardAuthentication", new b());
    }

    public final void i(BridgeWebView bridgeWebView) {
        bridgeWebView.registerHandler("getUserInfo", new c());
    }

    public final void j(BridgeWebView bridgeWebView) {
        bridgeWebView.registerHandler("updateUserInfo", new d());
    }

    @Override // c.e.b.c.b.a
    public void registerBridge(BridgeWebView bridgeWebView) {
        t.checkNotNullParameter(bridgeWebView, "webView");
        i(bridgeWebView);
        j(bridgeWebView);
        h(bridgeWebView);
    }
}
