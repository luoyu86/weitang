package cn.admobiletop.adsuyi.adapter.gdt.c;

import android.view.ViewGroup;
import cn.admobiletop.adsuyi.ad.ADSuyiAd;
import cn.admobiletop.adsuyi.util.ADSuyiAdUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static e f3683a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Map<String, List<cn.admobiletop.adsuyi.adapter.gdt.widget.c>> f3684b = new HashMap();

    public static e a() {
        if (f3683a == null) {
            synchronized (e.class) {
                if (f3683a == null) {
                    f3683a = new e();
                }
            }
        }
        return f3683a;
    }

    public final synchronized void c(String str) {
        List<cn.admobiletop.adsuyi.adapter.gdt.widget.c> list;
        try {
            list = this.f3684b.get(str);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        if (list != null) {
            ADSuyiAdUtil.releaseList(list);
            this.f3684b.remove(str);
        }
    }

    public synchronized cn.admobiletop.adsuyi.adapter.gdt.widget.c a(ViewGroup viewGroup, ADSuyiAd aDSuyiAd) {
        cn.admobiletop.adsuyi.adapter.gdt.widget.c cVar = null;
        if (!ADSuyiAdUtil.isReleased(aDSuyiAd) && viewGroup != null) {
            String key = aDSuyiAd.getKey();
            List<cn.admobiletop.adsuyi.adapter.gdt.widget.c> arrayList = this.f3684b.get(key);
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                this.f3684b.put(key, arrayList);
                aDSuyiAd.addReleaseListener(new d(this));
            }
            long jCurrentTimeMillis = System.currentTimeMillis();
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                cn.admobiletop.adsuyi.adapter.gdt.widget.c cVar2 = arrayList.get(i2);
                if (cVar2 != null) {
                    if (cVar2.getParent() != null && cVar2.getParent() == viewGroup) {
                        return cVar2;
                    }
                    if (cVar2.a() && cVar2.getIdleTime() < jCurrentTimeMillis) {
                        jCurrentTimeMillis = cVar2.getIdleTime();
                        cVar = cVar2;
                    }
                }
            }
            if (cVar == null) {
                cVar = new cn.admobiletop.adsuyi.adapter.gdt.widget.c(viewGroup.getContext());
                arrayList.add(cVar);
            }
            return cVar;
        }
        return null;
    }
}
