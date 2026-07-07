package g.a.e.b.b;

import java.security.spec.DSAParameterSpec;
import java.util.Map;
import java.util.Set;
import javax.crypto.spec.DHParameterSpec;

/* JADX INFO: loaded from: classes2.dex */
public interface b {
    Set getAcceptableNamedCurves();

    Map getAdditionalECParameters();

    DHParameterSpec getDHDefaultParameters(int i2);

    DSAParameterSpec getDSADefaultParameters(int i2);

    g.a.f.d.c getEcImplicitlyCa();
}
