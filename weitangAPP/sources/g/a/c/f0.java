package g.a.c;

import g.a.c.g;
import java.io.ByteArrayInputStream;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public abstract class f0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public d0 f13645a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public g.a.a.y3.a f13646b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public g.a.a.y3.a f13647c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public l f13648d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public a f13649e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public byte[] f13650f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public h0 f13651g;

    public f0(g.a.a.y3.a aVar, g.a.a.y3.a aVar2, l lVar, a aVar3) {
        this.f13646b = aVar;
        this.f13647c = aVar2;
        this.f13648d = lVar;
        this.f13649e = aVar3;
    }

    public final byte[] a(g.a.a.g gVar) throws IOException {
        if (gVar != null) {
            return gVar.toASN1Primitive().getEncoded();
        }
        return null;
    }

    public abstract h0 b(c0 c0Var) throws h, IOException;

    public byte[] getContent(c0 c0Var) throws h {
        try {
            return n.streamToByteArray(getContentStream(c0Var).getContentStream());
        } catch (IOException e2) {
            throw new h("unable to parse internal stream: " + e2.getMessage(), e2);
        }
    }

    public byte[] getContentDigest() {
        l lVar = this.f13648d;
        if (lVar instanceof g.a) {
            return ((g.a) lVar).getDigest();
        }
        return null;
    }

    public m getContentStream(c0 c0Var) throws h, IOException {
        this.f13651g = b(c0Var);
        a aVar = this.f13649e;
        if (aVar == null) {
            return new m(this.f13648d.getContentType(), this.f13651g.getInputStream(this.f13648d.getInputStream()));
        }
        if (!aVar.isAead()) {
            return new m(this.f13648d.getContentType(), this.f13648d.getInputStream());
        }
        this.f13651g.getAADStream().write(this.f13649e.getAuthAttributes().getEncoded("DER"));
        return new m(this.f13648d.getContentType(), this.f13651g.getInputStream(this.f13648d.getInputStream()));
    }

    public g.a.a.v getContentType() {
        return this.f13648d.getContentType();
    }

    public String getKeyEncryptionAlgOID() {
        return this.f13646b.getAlgorithm().getId();
    }

    public byte[] getKeyEncryptionAlgParams() {
        try {
            return a(this.f13646b.getParameters());
        } catch (Exception e2) {
            throw new RuntimeException("exception getting encryption parameters " + e2);
        }
    }

    public g.a.a.y3.a getKeyEncryptionAlgorithm() {
        return this.f13646b;
    }

    public byte[] getMac() {
        if (this.f13650f == null && this.f13651g.isMacBased()) {
            if (this.f13649e != null) {
                try {
                    g.a.j.s.b.drain(this.f13651g.getInputStream(new ByteArrayInputStream(this.f13649e.getAuthAttributes().getEncoded("DER"))));
                } catch (IOException e2) {
                    throw new IllegalStateException("unable to drain input: " + e2.getMessage());
                }
            }
            this.f13650f = this.f13651g.getMac();
        }
        return this.f13650f;
    }

    public d0 getRID() {
        return this.f13645a;
    }
}
