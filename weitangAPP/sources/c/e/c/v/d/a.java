package c.e.c.v.d;

import c.e.a.d.o;
import c.e.a.d.x;
import com.chinavisionary.microtang.main.vo.CityItemVo;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class a {
    public void selectCurrentCity(int i2, List<CityItemVo> list) {
        if (!o.isNotEmpty(list) || i2 >= list.size()) {
            return;
        }
        int size = list.size();
        int i3 = 0;
        while (i3 < size) {
            list.get(i3).setSelect(i3 == i2);
            i3++;
        }
    }

    public void setupSelectCity(String str, List<CityItemVo> list) {
        if (o.isNotEmpty(list) && x.isNotNull(str)) {
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                list.get(i2).setSelect(str.equals(list.get(i2).getKey()));
            }
        }
    }
}
