package g.a.c;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class b0 extends f0 {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static Map f13626h = new HashMap();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static Map f13627i;
    public g.a.a.i3.t j;

    static {
        HashMap map = new HashMap();
        f13627i = map;
        g.a.a.v vVar = b.f13617b;
        map.put(vVar, g.a.j.g.valueOf(8));
        Map map2 = f13627i;
        g.a.a.v vVar2 = b.f13621f;
        map2.put(vVar2, g.a.j.g.valueOf(16));
        Map map3 = f13627i;
        g.a.a.v vVar3 = b.f13622g;
        map3.put(vVar3, g.a.j.g.valueOf(16));
        Map map4 = f13627i;
        g.a.a.v vVar4 = b.f13623h;
        map4.put(vVar4, g.a.j.g.valueOf(16));
        f13626h.put(vVar, g.a.j.g.valueOf(192));
        f13626h.put(vVar2, g.a.j.g.valueOf(128));
        f13626h.put(vVar3, g.a.j.g.valueOf(192));
        f13626h.put(vVar4, g.a.j.g.valueOf(256));
    }

    public b0(g.a.a.i3.t tVar, g.a.a.y3.a aVar, l lVar, a aVar2) {
        super(tVar.getKeyEncryptionAlgorithm(), aVar, lVar, aVar2);
        this.j = tVar;
        this.f13645a = new a0();
    }

    @Override // g.a.c.f0
    public h0 b(c0 c0Var) throws h, IOException {
        z zVar = (z) c0Var;
        g.a.a.y3.a aVar = g.a.a.y3.a.getInstance(g.a.a.y3.a.getInstance(this.j.getKeyEncryptionAlgorithm()).getParameters());
        return zVar.getRecipientOperator(aVar, this.f13647c, zVar.calculateDerivedKey(zVar.getPasswordConversionScheme(), getKeyDerivationAlgorithm(), ((Integer) f13626h.get(aVar.getAlgorithm())).intValue()), this.j.getEncryptedKey().getOctets());
    }

    public String getKeyDerivationAlgOID() {
        if (this.j.getKeyDerivationAlgorithm() != null) {
            return this.j.getKeyDerivationAlgorithm().getAlgorithm().getId();
        }
        return null;
    }

    public byte[] getKeyDerivationAlgParams() {
        g.a.a.g parameters;
        try {
            if (this.j.getKeyDerivationAlgorithm() == null || (parameters = this.j.getKeyDerivationAlgorithm().getParameters()) == null) {
                return null;
            }
            return parameters.toASN1Primitive().getEncoded();
        } catch (Exception e2) {
            throw new RuntimeException("exception getting encryption parameters " + e2);
        }
    }

    public g.a.a.y3.a getKeyDerivationAlgorithm() {
        return this.j.getKeyDerivationAlgorithm();
    }
}
