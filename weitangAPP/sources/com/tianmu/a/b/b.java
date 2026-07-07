package com.tianmu.a.b;

import android.content.Context;
import com.tianmu.a.a.c;
import com.tianmu.a.a.d;
import com.tianmu.c.i.i;
import com.tianmu.c.n.n;

/* JADX INFO: loaded from: classes2.dex */
public abstract class b implements com.tianmu.api.iinterface.a {
    @Override // com.tianmu.api.iinterface.a
    public void a(Context context, String str) {
        new a().a(this, context, str);
    }

    @Override // com.tianmu.api.iinterface.a
    public String b() {
        return "rps_nstd";
    }

    @Override // com.tianmu.api.iinterface.a
    public String c() {
        i iVarD = n.D().d();
        return (iVarD == null || !iVarD.h()) ? d.b() : com.tianmu.a.a.e.b.b();
    }

    @Override // com.tianmu.api.iinterface.a
    public String d() {
        return com.tianmu.a.a.b.b();
    }

    @Override // com.tianmu.api.iinterface.a
    public String e() {
        i iVarD = n.D().d();
        return (iVarD == null || !iVarD.h()) ? d.a() : com.tianmu.a.a.e.b.a();
    }

    @Override // com.tianmu.api.iinterface.a
    public String f() {
        i iVarD = n.D().d();
        return (iVarD == null || !iVarD.h()) ? c.a() : com.tianmu.a.a.e.a.a();
    }

    @Override // com.tianmu.api.iinterface.a
    public String a() {
        return com.tianmu.a.a.b.a();
    }
}
