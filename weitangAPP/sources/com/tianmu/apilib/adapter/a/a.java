package com.tianmu.apilib.adapter.a;

import android.content.Context;
import android.text.TextUtils;
import com.tianmu.TianmuSDK;
import com.tianmu.apilib.adapter.iiterface.IAdapterApiLoader;
import com.tianmu.apilib.utils.TianmuStateUtil;
import com.tianmu.apilib.utils.i;
import com.tianmu.c.n.e;
import com.tianmu.c.n.n;
import com.tianmu.utils.TianmuClassUtil;
import com.tianmu.utils.TianmuLogUtil;

/* JADX INFO: loaded from: classes2.dex */
public class a implements IAdapterApiLoader {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f10790a;

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final a f10791a = new a();
    }

    public static a b() {
        return b.f10791a;
    }

    public boolean a() {
        return this.f10790a;
    }

    @Override // com.tianmu.apilib.adapter.iiterface.IAdapterApiLoader
    public boolean apiLoad(String str) {
        try {
            boolean zIsImportAdmDependencies = TianmuClassUtil.isImportAdmDependencies();
            boolean zA = i.a().a("admobilePlatformEmpty");
            if ((zIsImportAdmDependencies && !zA) || !TianmuClassUtil.isImportTianmuAdapterDependencies()) {
                return false;
            }
            Context context = TianmuSDK.getInstance().getContext();
            com.tianmu.c.i.i iVarD = n.D().d();
            if (iVarD == null || !TianmuStateUtil.checkPool()) {
                return false;
            }
            String strC = iVarD.c();
            if (context != null && !TextUtils.isEmpty(strC)) {
                if (!this.f10790a) {
                    this.f10790a = true;
                }
                TianmuLogUtil.ti("res_nsend", "proc 0x0002");
                if (com.tianmu.b.a.a().a(context, str, strC)) {
                    e.a().a(true);
                    return true;
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return false;
    }

    private a() {
    }
}
