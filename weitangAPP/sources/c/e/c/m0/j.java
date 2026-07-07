package c.e.c.m0;

import c.e.a.d.u;
import c.e.a.d.w;
import c.e.a.d.x;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile j f1693a;

    public static synchronized j getInstance() {
        if (f1693a == null) {
            synchronized (j.class) {
                if (f1693a == null) {
                    f1693a = new j();
                }
            }
        }
        return f1693a;
    }

    public static void updateRemoteOpenDoor(List<c.e.e.a.s.e> list) {
        if (c.e.a.d.o.isNotEmpty(list)) {
            for (c.e.e.a.s.e eVar : list) {
                eVar.setOpenDoorModel(u.getInstance().isRemoteOpenDoorData(eVar.getAssetInstanceKey()) ? 1 : 0);
            }
        }
    }

    public List<c.e.e.a.s.e> signLockSetupDefault(List<c.e.e.a.s.d> list) {
        ArrayList arrayList = new ArrayList();
        if (list != null && !list.isEmpty()) {
            String string = w.getInstance().getString("room_key", "");
            for (c.e.e.a.s.d dVar : list) {
                if (dVar != null) {
                    c.e.e.a.s.e eVar = new c.e.e.a.s.e();
                    eVar.setAssetInstanceKey(dVar.getAssetKey());
                    eVar.setAssetInstanceName(dVar.getAddress());
                    eVar.setContractKey(dVar.getContractKey());
                    eVar.setSupportNumberPassword(dVar.isSupportNumberPassword());
                    eVar.setIsSupportedOpening(dVar.getIsSupportedOpening());
                    if (x.isNotNull(string) && x.isNotNull(dVar.getAssetKey()) && string.equals(dVar.getAssetKey())) {
                        eVar.setDefault(true);
                    }
                    arrayList.add(eVar);
                }
            }
        }
        return arrayList;
    }

    public List<c.e.e.a.s.e> signLockToLock(List<c.e.e.a.s.d> list) {
        ArrayList arrayList = new ArrayList();
        if (list != null && !list.isEmpty()) {
            for (c.e.e.a.s.d dVar : list) {
                if (dVar != null) {
                    c.e.e.a.s.e eVar = new c.e.e.a.s.e();
                    eVar.setAssetInstanceKey(dVar.getAssetKey());
                    eVar.setAssetInstanceName(dVar.getAddress());
                    eVar.setContractKey(dVar.getContractKey());
                    arrayList.add(eVar);
                }
            }
        }
        return arrayList;
    }
}
