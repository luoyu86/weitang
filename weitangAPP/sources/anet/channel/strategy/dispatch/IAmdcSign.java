package anet.channel.strategy.dispatch;

/* JADX INFO: loaded from: classes.dex */
public interface IAmdcSign {
    String getAppkey();

    String sign(String str);

    boolean useSecurityGuard();
}
