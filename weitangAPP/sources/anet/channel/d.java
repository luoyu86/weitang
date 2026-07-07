package anet.channel;

import anet.channel.security.ISecurity;
import anet.channel.strategy.dispatch.IAmdcSign;

/* JADX INFO: loaded from: classes.dex */
public class d implements IAmdcSign {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f390a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ISecurity f391b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ SessionCenter f392c;

    public d(SessionCenter sessionCenter, String str, ISecurity iSecurity) {
        this.f392c = sessionCenter;
        this.f390a = str;
        this.f391b = iSecurity;
    }

    @Override // anet.channel.strategy.dispatch.IAmdcSign
    public String getAppkey() {
        return this.f390a;
    }

    @Override // anet.channel.strategy.dispatch.IAmdcSign
    public String sign(String str) {
        return this.f391b.sign(this.f392c.f334b, ISecurity.SIGN_ALGORITHM_HMAC_SHA1, getAppkey(), str);
    }

    @Override // anet.channel.strategy.dispatch.IAmdcSign
    public boolean useSecurityGuard() {
        return !this.f391b.isSecOff();
    }
}
