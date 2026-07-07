package g.a.c;

/* JADX INFO: loaded from: classes2.dex */
public class w extends f0 {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public g.a.a.i3.n f13702h;

    public w(g.a.a.i3.n nVar, g.a.a.y3.a aVar, l lVar, a aVar2) {
        v vVar;
        super(nVar.getKeyEncryptionAlgorithm(), aVar, lVar, aVar2);
        this.f13702h = nVar;
        g.a.a.i3.v recipientIdentifier = nVar.getRecipientIdentifier();
        boolean zIsTagged = recipientIdentifier.isTagged();
        g.a.a.g id = recipientIdentifier.getId();
        if (zIsTagged) {
            vVar = new v(g.a.a.w.getInstance(id).getOctets());
        } else {
            g.a.a.i3.i iVar = g.a.a.i3.i.getInstance(id);
            vVar = new v(iVar.getName(), iVar.getSerialNumber().getValue());
        }
        this.f13645a = vVar;
    }

    @Override // g.a.c.f0
    public h0 b(c0 c0Var) throws h {
        return ((u) c0Var).getRecipientOperator(this.f13646b, this.f13647c, this.f13702h.getEncryptedKey().getOctets());
    }
}
