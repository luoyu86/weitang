package g.a.c;

import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public class q extends f0 {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public g.a.a.i3.k f13697h;

    public q(g.a.a.i3.k kVar, g.a.a.y3.a aVar, l lVar, a aVar2) {
        super(kVar.getKeyEncryptionAlgorithm(), aVar, lVar, aVar2);
        this.f13697h = kVar;
        this.f13645a = new p(kVar.getKekid().getKeyIdentifier().getOctets());
    }

    @Override // g.a.c.f0
    public h0 b(c0 c0Var) throws h, IOException {
        return ((o) c0Var).getRecipientOperator(this.f13646b, this.f13647c, this.f13697h.getEncryptedKey().getOctets());
    }
}
