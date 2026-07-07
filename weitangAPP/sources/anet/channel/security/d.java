package anet.channel.security;

/* JADX INFO: loaded from: classes.dex */
public final class d implements ISecurityFactory {
    @Override // anet.channel.security.ISecurityFactory
    public ISecurity createNonSecurity(String str) {
        return new a(str);
    }

    @Override // anet.channel.security.ISecurityFactory
    public ISecurity createSecurity(String str) {
        return new b(str);
    }
}
