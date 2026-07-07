package anet.channel.security;

/* JADX INFO: loaded from: classes.dex */
public interface ISecurityFactory {
    ISecurity createNonSecurity(String str);

    ISecurity createSecurity(String str);
}
