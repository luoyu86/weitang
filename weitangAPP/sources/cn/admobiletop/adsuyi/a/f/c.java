package cn.admobiletop.adsuyi.a.f;

import android.content.ContentValues;
import android.database.Cursor;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import cn.admobiletop.adsuyi.a.l.o;
import cn.admobiletop.adsuyi.ad.data.ADSuyiPlatformPosId;
import cn.admobiletop.adsuyi.ad.data.ADSuyiPosId;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static c f3243a;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Map<String, cn.admobiletop.adsuyi.a.f.b.a> f3246d;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Handler f3244b = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Map<String, Map<String, cn.admobiletop.adsuyi.a.f.b.a>> f3245c = new HashMap();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f3247e = cn.admobiletop.adsuyi.a.m.e.c();

    public interface a {
        void onFinish();
    }

    public static c b() {
        if (f3243a == null) {
            synchronized (c.class) {
                if (f3243a == null) {
                    f3243a = new c();
                }
            }
        }
        return f3243a;
    }

    public void a(String str, ADSuyiPlatformPosId aDSuyiPlatformPosId) {
        cn.admobiletop.adsuyi.a.f.b.a aVar;
        if (aDSuyiPlatformPosId == null) {
            return;
        }
        try {
            h(str);
            if (aDSuyiPlatformPosId.getFrequency() <= 0) {
                return;
            }
            if (aDSuyiPlatformPosId.isLoopFrequencyType() || !aDSuyiPlatformPosId.isFrequencyFinished()) {
                Map<String, cn.admobiletop.adsuyi.a.f.b.a> map = this.f3245c.get(str);
                if (map == null) {
                    map = this.f3246d;
                }
                if (map == null || (aVar = map.get(aDSuyiPlatformPosId.getPlatformPosId())) == null) {
                    return;
                }
                boolean z = false;
                if (aVar.c() < aDSuyiPlatformPosId.getFrequency()) {
                    aVar.a(aVar.c() + 1);
                    if (aVar.c() < aDSuyiPlatformPosId.getFrequency()) {
                        e(aVar);
                    } else {
                        aDSuyiPlatformPosId.setFrequencyFinishTime(cn.admobiletop.adsuyi.a.m.e.b());
                        m(aVar);
                        z = true;
                    }
                }
                if (aVar.c() >= aDSuyiPlatformPosId.getFrequency()) {
                    aDSuyiPlatformPosId.setFrequencyFinished(true);
                    if (z || !aDSuyiPlatformPosId.isLoopFrequencyType()) {
                        return;
                    }
                    aVar.a(aVar.c() + 1);
                    m(aVar);
                    if (aVar.c() % aDSuyiPlatformPosId.getFrequency() == 0) {
                        aDSuyiPlatformPosId.setFrequencyFinishTime(cn.admobiletop.adsuyi.a.m.e.b());
                    }
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final void d(Cursor cursor, Map<String, cn.admobiletop.adsuyi.a.f.b.a> map) {
        cn.admobiletop.adsuyi.a.f.b.a aVar = new cn.admobiletop.adsuyi.a.f.b.a();
        aVar.b(cursor.getString(cursor.getColumnIndex("platform_pos_id")));
        aVar.c(cursor.getString(cursor.getColumnIndex("pos_id")));
        aVar.a(cursor.getInt(cursor.getColumnIndex("fre_count")));
        aVar.a(cursor.getString(cursor.getColumnIndex("fre_date")));
        aVar.b(cursor.getInt(cursor.getColumnIndex("total_count")));
        aVar.a(cursor.getInt(cursor.getColumnIndex("update_time")));
        if (!this.f3247e.equalsIgnoreCase(aVar.d())) {
            aVar.a(0);
            aVar.a(this.f3247e);
        }
        map.put(aVar.e(), aVar);
    }

    public final void e(cn.admobiletop.adsuyi.a.f.b.a aVar) {
        ArrayList arrayList = new ArrayList();
        ContentValues contentValues = new ContentValues();
        contentValues.put("pos_id", aVar.f());
        contentValues.put("platform_pos_id", aVar.e());
        contentValues.put("fre_date", aVar.d());
        contentValues.put("fre_count", Integer.valueOf(aVar.c()));
        contentValues.put("total_count", Integer.valueOf(aVar.g()));
        contentValues.put("update_time", Long.valueOf(cn.admobiletop.adsuyi.a.m.e.b()));
        arrayList.add(contentValues);
        h.b().a("frequency", arrayList);
    }

    public final void h(String str) {
        ADSuyiPosId aDSuyiPosIdK = cn.admobiletop.adsuyi.a.l.h.l().k();
        if (aDSuyiPosIdK == null || !str.equals(aDSuyiPosIdK.getPosId())) {
            return;
        }
        o.b().a(cn.admobiletop.adsuyi.a.m.e.b());
    }

    public final void i(String str, List<ADSuyiPlatformPosId> list, a aVar) {
        h.b().a("frequency", "pos_id=?", new String[]{str}, null, new b(this, new HashMap(), str, list, aVar));
    }

    public final void j(String str, List<ADSuyiPlatformPosId> list, Map<String, cn.admobiletop.adsuyi.a.f.b.a> map) {
        if (TextUtils.isEmpty(str) || list == null || list.size() <= 0 || map == null) {
            return;
        }
        boolean zN = n(str, list);
        for (int i2 = 0; i2 < list.size(); i2++) {
            ADSuyiPlatformPosId aDSuyiPlatformPosId = list.get(i2);
            if (aDSuyiPlatformPosId != null) {
                if (aDSuyiPlatformPosId.getFrequency() <= 0) {
                    map.remove(aDSuyiPlatformPosId.getPlatformPosId());
                } else {
                    cn.admobiletop.adsuyi.a.f.b.a aVar = map.get(aDSuyiPlatformPosId.getPlatformPosId());
                    if (aVar == null && aDSuyiPlatformPosId.getFrequency() > 0) {
                        map.put(aDSuyiPlatformPosId.getPlatformPosId(), new cn.admobiletop.adsuyi.a.f.b.a(str, aDSuyiPlatformPosId.getPlatformPosId(), this.f3247e, aDSuyiPlatformPosId.getFrequency()));
                    } else if (aVar != null) {
                        if (aVar.g() != aDSuyiPlatformPosId.getFrequency() || zN) {
                            aVar.b(aDSuyiPlatformPosId.getFrequency());
                            aVar.a(0);
                        } else if (aVar.c() >= aDSuyiPlatformPosId.getFrequency()) {
                            aDSuyiPlatformPosId.setFrequencyFinished(true);
                            long jH = aVar.h();
                            if (jH == 0) {
                                aDSuyiPlatformPosId.setFrequencyFinishTime(cn.admobiletop.adsuyi.a.m.e.b());
                            } else {
                                aDSuyiPlatformPosId.setFrequencyFinishTime(jH);
                            }
                        }
                    }
                }
            }
        }
    }

    public final boolean k(List<String> list, List<String> list2) {
        if (list == list2) {
            return true;
        }
        if (list == null || list2 == null || list.size() != list2.size()) {
            return false;
        }
        Iterator<String> it = list.iterator();
        Iterator<String> it2 = list2.iterator();
        while (it.hasNext() && it2.hasNext()) {
            String next = it.next();
            String next2 = it2.next();
            if (next == null) {
                if (next2 != null) {
                    return false;
                }
            } else if (!next.equals(next2)) {
                return false;
            }
        }
        return (it.hasNext() || it2.hasNext()) ? false : true;
    }

    public final void m(cn.admobiletop.adsuyi.a.f.b.a aVar) {
        ArrayList arrayList = new ArrayList();
        ContentValues contentValues = new ContentValues();
        contentValues.put("pos_id", aVar.f());
        contentValues.put("platform_pos_id", aVar.e());
        contentValues.put("fre_date", aVar.d());
        contentValues.put("fre_count", Integer.valueOf(aVar.c()));
        contentValues.put("total_count", Integer.valueOf(aVar.g()));
        if (aVar.c() % aVar.g() == 0) {
            contentValues.put("update_time", Long.valueOf(cn.admobiletop.adsuyi.a.m.e.b()));
            aVar.a(cn.admobiletop.adsuyi.a.m.e.b());
        } else {
            contentValues.put("update_time", Long.valueOf(aVar.h()));
        }
        arrayList.add(contentValues);
        h.b().a("frequency", arrayList);
    }

    public final boolean n(String str, List<ADSuyiPlatformPosId> list) {
        List<String> listA = a(list);
        List<String> listA2 = d.a().a(str);
        if (listA2 == null || listA2.size() == 0) {
            d.a().a(str, listA);
            return false;
        }
        if (k(listA, listA2)) {
            return false;
        }
        d.a().a(str, listA);
        return true;
    }

    public boolean a(ADSuyiPosId aDSuyiPosId) {
        if (aDSuyiPosId == null || aDSuyiPosId.getPlatformPosIdList() == null || aDSuyiPosId.getPlatformPosIdList().isEmpty() || !aDSuyiPosId.needFrequency()) {
            return false;
        }
        Map<String, cn.admobiletop.adsuyi.a.f.b.a> map = this.f3245c.get(aDSuyiPosId.getPosId());
        this.f3246d = map;
        return map == null;
    }

    public void a(ADSuyiPosId aDSuyiPosId, a aVar) {
        i(aDSuyiPosId.getPosId(), aDSuyiPosId.getPlatformPosIdList(), aVar);
    }

    public final List<String> a(List<ADSuyiPlatformPosId> list) {
        ArrayList arrayList = new ArrayList();
        Iterator<ADSuyiPlatformPosId> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getPlatformPosId());
        }
        return arrayList;
    }

    public void a() {
        this.f3245c.clear();
    }

    public void a(String str, List<ADSuyiPlatformPosId> list) {
        Map<String, cn.admobiletop.adsuyi.a.f.b.a> map = this.f3245c.get(str);
        if (map != null) {
            for (ADSuyiPlatformPosId aDSuyiPlatformPosId : list) {
                cn.admobiletop.adsuyi.a.f.b.a aVar = map.get(aDSuyiPlatformPosId.getPlatformPosId());
                if (aVar != null && aVar.c() >= aDSuyiPlatformPosId.getFrequency()) {
                    aDSuyiPlatformPosId.setFrequencyFinished(true);
                    long jH = aVar.h();
                    if (jH != 0) {
                        aDSuyiPlatformPosId.setFrequencyFinishTime(jH);
                    }
                }
            }
        }
    }
}
