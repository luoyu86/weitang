package g.a.a;

import java.io.IOException;
import java.util.Enumeration;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes2.dex */
public class a3 implements Enumeration {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public p f13034a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object f13035b = a();

    public a3(byte[] bArr) {
        this.f13034a = new p(bArr, true);
    }

    public final Object a() {
        try {
            return this.f13034a.readObject();
        } catch (IOException e2) {
            throw new z("malformed ASN.1: " + e2, e2);
        }
    }

    @Override // java.util.Enumeration
    public boolean hasMoreElements() {
        return this.f13035b != null;
    }

    @Override // java.util.Enumeration
    public Object nextElement() {
        Object obj = this.f13035b;
        if (obj == null) {
            throw new NoSuchElementException();
        }
        this.f13035b = a();
        return obj;
    }
}
