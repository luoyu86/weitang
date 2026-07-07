package g.a.b;

import g.a.a.a0;
import g.a.a.v1;
import g.a.j.l;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Set f13594a = Collections.unmodifiableSet(new HashSet());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static List f13595b = Collections.unmodifiableList(new ArrayList());

    public static Set a(g.a.a.y3.f fVar) {
        return fVar == null ? f13594a : Collections.unmodifiableSet(new HashSet(Arrays.asList(fVar.getCriticalExtensionOIDs())));
    }

    public static List b(g.a.a.y3.f fVar) {
        return fVar == null ? f13595b : Collections.unmodifiableList(Arrays.asList(fVar.getExtensionOIDs()));
    }

    public static Set c(g.a.a.y3.f fVar) {
        return fVar == null ? f13594a : Collections.unmodifiableSet(new HashSet(Arrays.asList(fVar.getNonCriticalExtensionOIDs())));
    }

    public static boolean d(g.a.a.y3.a aVar, g.a.a.y3.a aVar2) {
        if (!aVar.getAlgorithm().equals((a0) aVar2.getAlgorithm())) {
            return false;
        }
        if (l.isOverrideSet("org.bouncycastle.x509.allow_absent_equiv_NULL")) {
            if (aVar.getParameters() == null) {
                return aVar2.getParameters() == null || aVar2.getParameters().equals(v1.f13368b);
            }
            if (aVar2.getParameters() == null) {
                return aVar.getParameters() == null || aVar.getParameters().equals(v1.f13368b);
            }
        }
        if (aVar.getParameters() != null) {
            return aVar.getParameters().equals(aVar2.getParameters());
        }
        if (aVar2.getParameters() != null) {
            return aVar2.getParameters().equals(aVar.getParameters());
        }
        return true;
    }

    public static a0 e(byte[] bArr) throws IOException {
        a0 a0VarFromByteArray = a0.fromByteArray(bArr);
        if (a0VarFromByteArray != null) {
            return a0VarFromByteArray;
        }
        throw new IOException("no content found");
    }
}
