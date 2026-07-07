package g.a.e.b.b;

import com.taobao.accs.AccsState;
import g.a.j.q;
import java.security.BasicPermission;
import java.security.Permission;
import java.util.StringTokenizer;

/* JADX INFO: loaded from: classes2.dex */
public class c extends BasicPermission {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f13836a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f13837b;

    public c(String str) {
        super(str);
        this.f13836a = AccsState.ALL;
        this.f13837b = 63;
    }

    public c(String str, String str2) {
        super(str, str2);
        this.f13836a = str2;
        this.f13837b = a(str2);
    }

    public final int a(String str) {
        StringTokenizer stringTokenizer = new StringTokenizer(q.toLowerCase(str), " ,");
        int i2 = 0;
        while (stringTokenizer.hasMoreTokens()) {
            String strNextToken = stringTokenizer.nextToken();
            if (strNextToken.equals("threadlocalecimplicitlyca")) {
                i2 |= 1;
            } else if (strNextToken.equals("ecimplicitlyca")) {
                i2 |= 2;
            } else if (strNextToken.equals("threadlocaldhdefaultparams")) {
                i2 |= 4;
            } else if (strNextToken.equals("dhdefaultparams")) {
                i2 |= 8;
            } else if (strNextToken.equals("acceptableeccurves")) {
                i2 |= 16;
            } else if (strNextToken.equals("additionalecparameters")) {
                i2 |= 32;
            } else if (strNextToken.equals(AccsState.ALL)) {
                i2 |= 63;
            }
        }
        if (i2 != 0) {
            return i2;
        }
        throw new IllegalArgumentException("unknown permissions passed to mask");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return this.f13837b == cVar.f13837b && getName().equals(cVar.getName());
    }

    @Override // java.security.BasicPermission, java.security.Permission
    public String getActions() {
        return this.f13836a;
    }

    public int hashCode() {
        return getName().hashCode() + this.f13837b;
    }

    @Override // java.security.BasicPermission, java.security.Permission
    public boolean implies(Permission permission) {
        if (!(permission instanceof c) || !getName().equals(permission.getName())) {
            return false;
        }
        int i2 = this.f13837b;
        int i3 = ((c) permission).f13837b;
        return (i2 & i3) == i3;
    }
}
