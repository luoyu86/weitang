package g.a.e.d;

import g.a.a.a0;
import g.a.a.g;
import java.io.IOException;
import java.security.AlgorithmParameters;

/* JADX INFO: loaded from: classes2.dex */
public class a {
    public static g extractParameters(AlgorithmParameters algorithmParameters) throws IOException {
        try {
            return a0.fromByteArray(algorithmParameters.getEncoded("ASN.1"));
        } catch (Exception unused) {
            return a0.fromByteArray(algorithmParameters.getEncoded());
        }
    }

    public static void loadParameters(AlgorithmParameters algorithmParameters, g gVar) throws IOException {
        try {
            algorithmParameters.init(gVar.toASN1Primitive().getEncoded(), "ASN.1");
        } catch (Exception unused) {
            algorithmParameters.init(gVar.toASN1Primitive().getEncoded());
        }
    }
}
