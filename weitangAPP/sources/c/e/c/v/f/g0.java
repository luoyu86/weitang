package c.e.c.v.f;

import com.chinavisionary.microtang.main.vo.CityItemVo;
import com.chinavisionary.microtang.repair.vo.RepairLeftVo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class g0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, List<RepairLeftVo>> f1957a = new HashMap();

    public void addProjectVoToMap(String str, List<RepairLeftVo> list) {
        if (c.e.a.d.x.isNotNull(str) && c.e.a.d.o.isNotEmpty(list)) {
            this.f1957a.put(str, list);
        }
    }

    public List<String> getCityKey(List<CityItemVo> list) {
        ArrayList arrayList = new ArrayList();
        if (c.e.a.d.o.isNotEmpty(list)) {
            for (CityItemVo cityItemVo : list) {
                if (cityItemVo != null && c.e.a.d.x.isNotNull(cityItemVo.getKey())) {
                    arrayList.add(cityItemVo.getKey());
                }
            }
        }
        return arrayList;
    }

    public List<RepairLeftVo> getProjectList(String str) {
        if (c.e.a.d.x.isNotNull(str) && this.f1957a.containsKey(str)) {
            return this.f1957a.get(str);
        }
        return null;
    }

    public void unSelectProject(String str) {
        if (this.f1957a.isEmpty()) {
            Iterator<Map.Entry<String, List<RepairLeftVo>>> it = this.f1957a.entrySet().iterator();
            while (it.hasNext()) {
                List<RepairLeftVo> value = it.next().getValue();
                if (c.e.a.d.o.isNotEmpty(value)) {
                    for (RepairLeftVo repairLeftVo : value) {
                        if (repairLeftVo != null) {
                            repairLeftVo.setSelect(c.e.a.d.x.isNotNull(str) && str.equals(repairLeftVo.getKey()));
                        }
                    }
                }
            }
        }
    }
}
