package c.e.b.c.c;

import android.content.Intent;
import c.e.b.a.d;
import c.e.b.c.d.e;
import c.e.b.c.d.h;
import c.e.b.c.d.i;
import c.e.b.c.d.m;
import c.e.b.c.d.o;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public interface a {

    /* JADX INFO: renamed from: c.e.b.c.c.a$a, reason: collision with other inner class name */
    public static final class C0028a {
        public static /* synthetic */ void addFragmentToActivity$default(a aVar, i iVar, boolean z, int i2, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addFragmentToActivity");
            }
            if ((i2 & 2) != 0) {
                z = false;
            }
            aVar.addFragmentToActivity(iVar, z);
        }
    }

    void addFragmentToActivity(i iVar, boolean z);

    void performActivityEvaluateActivity(String str);

    void performAuthActivity();

    void performCallPhone(String str);

    void performChooseImage(d dVar, int i2, c.e.b.c.d.d dVar2);

    void performContractActivity(String str);

    void performFinishActivity();

    void performLogin();

    void performMainActivity();

    void performMap(h hVar);

    void performOpenImagePreview(List<String> list, int i2);

    void performProductDetailsActivity(String str, e eVar);

    void performReportAbnormalBo(m mVar);

    void performRoomSourceActivity(String str, String str2);

    void performStartActivity(Intent intent);

    void performUpdateUserInfo();

    void performWeChartShared(o oVar);

    void performWxMiniProgram(String str);

    void setupAppBarStyle(c.e.b.c.d.b bVar);
}
