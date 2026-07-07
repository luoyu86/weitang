package g.a.c;

import g.a.c.g;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes2.dex */
public class e implements g.a.j.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public g0 f13630a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public g.a.a.i3.e f13631b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public g.a.a.y3.a f13632c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public g.a.a.f0 f13633d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public y f13634e;

    public e(g.a.a.i3.e eVar) throws h {
        this.f13631b = eVar;
        try {
            g.a.a.i3.g gVar = g.a.a.i3.g.getInstance(eVar.getContent());
            if (gVar.getOriginatorInfo() != null) {
                this.f13634e = new y(gVar.getOriginatorInfo());
            }
            g.a.a.f0 recipientInfos = gVar.getRecipientInfos();
            g.a.a.i3.f encryptedContentInfo = gVar.getEncryptedContentInfo();
            this.f13632c = encryptedContentInfo.getContentEncryptionAlgorithm();
            this.f13630a = g.a(recipientInfos, this.f13632c, new g.b(this.f13632c, encryptedContentInfo.getContentType(), new i(encryptedContentInfo.getEncryptedContent().getOctets())));
            this.f13633d = gVar.getUnprotectedAttrs();
        } catch (ClassCastException e2) {
            throw new h("Malformed content.", e2);
        } catch (IllegalArgumentException e3) {
            throw new h("Malformed content.", e3);
        }
    }

    public e(InputStream inputStream) throws h {
        this(n.a(inputStream));
    }

    public e(byte[] bArr) throws h {
        this(n.c(bArr));
    }

    public final byte[] a(g.a.a.g gVar) throws IOException {
        if (gVar != null) {
            return gVar.toASN1Primitive().getEncoded();
        }
        return null;
    }

    public g.a.a.y3.a getContentEncryptionAlgorithm() {
        return this.f13632c;
    }

    @Override // g.a.j.d
    public byte[] getEncoded() throws IOException {
        return this.f13631b.getEncoded();
    }

    public String getEncryptionAlgOID() {
        return this.f13632c.getAlgorithm().getId();
    }

    public byte[] getEncryptionAlgParams() {
        try {
            return a(this.f13632c.getParameters());
        } catch (Exception e2) {
            throw new RuntimeException("exception getting encryption parameters " + e2);
        }
    }

    public y getOriginatorInfo() {
        return this.f13634e;
    }

    public g0 getRecipientInfos() {
        return this.f13630a;
    }

    public g.a.a.i3.b getUnprotectedAttributes() {
        g.a.a.f0 f0Var = this.f13633d;
        if (f0Var == null) {
            return null;
        }
        return new g.a.a.i3.b(f0Var);
    }

    public g.a.a.i3.e toASN1Structure() {
        return this.f13631b;
    }
}
