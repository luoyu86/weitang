package com.taobao.accs.net;

import anet.channel.NoAvailStrategyException;
import anet.channel.Session;
import anet.channel.SessionCenter;
import anet.channel.entity.ConnType;
import com.alibaba.sdk.android.error.ErrorCode;
import com.taobao.accs.AccsErrorCode;
import com.taobao.accs.AccsState;
import com.taobao.accs.utl.UtilityImpl;
import java.net.ConnectException;
import java.security.InvalidParameterException;
import java.util.concurrent.TimeoutException;

/* JADX INFO: loaded from: classes2.dex */
public class r implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ j f10404a;

    public r(j jVar) {
        this.f10404a = jVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        ErrorCode errorCodeBuild = AccsErrorCode.SUCCESS;
        try {
            SessionCenter sessionCenter = SessionCenter.getInstance(this.f10404a.f10359i.getAppKey());
            j jVar = this.f10404a;
            boolean z = false;
            jVar.a(sessionCenter, jVar.f10359i.getInappHost(), false);
            Session throwsException = null;
            try {
                try {
                    throwsException = sessionCenter.getThrowsException(this.f10404a.b((String) null), ConnType.TypeLevel.SPDY, 60000L);
                } catch (ConnectException e2) {
                    errorCodeBuild = AccsErrorCode.NETWORK_INAPP_CONNECT_FAIL.copy().detail(AccsErrorCode.getAllDetails(e2.getMessage())).build();
                } catch (InvalidParameterException e3) {
                    errorCodeBuild = AccsErrorCode.NETWORK_INAPP_ARGS_INVALID.copy().detail(e3.getMessage()).build();
                } catch (TimeoutException e4) {
                    errorCodeBuild = AccsErrorCode.NETWORK_INAPP_TIMEOUT.copy().detail(AccsErrorCode.getAllDetails(e4.getMessage())).build();
                }
            } catch (NoAvailStrategyException e5) {
                errorCodeBuild = AccsErrorCode.NETWORK_INAPP_NO_STRATEGY.copy().detail(e5.getMessage()).build();
            } catch (Throwable th) {
                errorCodeBuild = UtilityImpl.g(this.f10404a.f10354d) ? AccsErrorCode.NETWORK_INAPP_EXCEPTION.copy().detail(AccsErrorCode.getAllDetails(AccsErrorCode.getExceptionInfo(th))).build() : AccsErrorCode.NO_NETWORK.copy().detail(AccsErrorCode.getExceptionInfo(th)).build();
            }
            if (throwsException != null) {
                throwsException.ping(true);
                z = true;
            } else if (errorCodeBuild.getCodeInt() != AccsErrorCode.SUCCESS.getCodeInt()) {
                this.f10404a.t.e(errorCodeBuild.toString());
                AccsState.getInstance().b(this.f10404a.m, "re", Integer.valueOf(errorCodeBuild.getCodeInt()));
            } else {
                this.f10404a.t.e("reconnect fail");
                AccsState.getInstance().b(this.f10404a.m, "re", "reconnect session null");
            }
            if (z) {
                return;
            }
            this.f10404a.r();
        } finally {
        }
    }
}
