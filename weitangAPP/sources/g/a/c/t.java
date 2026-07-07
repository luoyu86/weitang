package g.a.c;

import java.io.IOException;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class t extends f0 {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public g.a.a.i3.m f13699h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public g.a.a.w f13700i;

    public t(g.a.a.i3.m mVar, d0 d0Var, g.a.a.w wVar, g.a.a.y3.a aVar, l lVar, a aVar2) {
        super(mVar.getKeyEncryptionAlgorithm(), aVar, lVar, aVar2);
        this.f13699h = mVar;
        this.f13645a = d0Var;
        this.f13700i = wVar;
    }

    public static void f(List list, g.a.a.i3.m mVar, g.a.a.y3.a aVar, l lVar, a aVar2) {
        g.a.a.d0 recipientEncryptedKeys = mVar.getRecipientEncryptedKeys();
        for (int i2 = 0; i2 < recipientEncryptedKeys.size(); i2++) {
            g.a.a.i3.u uVar = g.a.a.i3.u.getInstance(recipientEncryptedKeys.getObjectAt(i2));
            g.a.a.i3.l identifier = uVar.getIdentifier();
            g.a.a.i3.i issuerAndSerialNumber = identifier.getIssuerAndSerialNumber();
            list.add(new t(mVar, issuerAndSerialNumber != null ? new s(issuerAndSerialNumber.getName(), issuerAndSerialNumber.getSerialNumber().getValue()) : new s(identifier.getRKeyID().getSubjectKeyIdentifier().getOctets()), uVar.getEncryptedKey(), aVar, lVar, aVar2));
        }
    }

    @Override // g.a.c.f0
    public h0 b(c0 c0Var) throws h, IOException {
        r rVar = (r) c0Var;
        return rVar.getRecipientOperator(this.f13646b, this.f13647c, e(rVar.getPrivateKeyAlgorithmIdentifier(), this.f13699h.getOriginator()), this.f13699h.getUserKeyingMaterial(), this.f13700i.getOctets());
    }

    public final g.a.a.y3.l c(x xVar) throws h {
        throw new h("No support for 'originator' as IssuerAndSerialNumber or SubjectKeyIdentifier");
    }

    public final g.a.a.y3.l d(g.a.a.y3.a aVar, g.a.a.i3.q qVar) {
        return new g.a.a.y3.l(aVar, qVar.getPublicKey().getBytes());
    }

    public final g.a.a.y3.l e(g.a.a.y3.a aVar, g.a.a.i3.o oVar) throws h, IOException {
        g.a.a.i3.q originatorKey = oVar.getOriginatorKey();
        if (originatorKey != null) {
            return d(aVar, originatorKey);
        }
        g.a.a.i3.i issuerAndSerialNumber = oVar.getIssuerAndSerialNumber();
        return c(issuerAndSerialNumber != null ? new x(issuerAndSerialNumber.getName(), issuerAndSerialNumber.getSerialNumber().getValue()) : new x(oVar.getSubjectKeyIdentifier().getKeyIdentifier()));
    }

    public g.a.a.i3.o getOriginator() {
        return this.f13699h.getOriginator();
    }

    public byte[] getUserKeyingMaterial() {
        g.a.a.w userKeyingMaterial = this.f13699h.getUserKeyingMaterial();
        if (userKeyingMaterial != null) {
            return g.a.j.a.clone(userKeyingMaterial.getOctets());
        }
        return null;
    }
}
