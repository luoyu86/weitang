package c.e.c.w.b;

import android.content.Context;
import c.e.a.a.b;
import c.e.a.d.x;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.map.vo.MapItemVo;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class a {
    public List<MapItemVo> getMapList(Context context) {
        ArrayList arrayList = new ArrayList();
        b.getInstance().getInstallAppPackName(context);
        MapItemVo mapItemVo = new MapItemVo();
        mapItemVo.setName(x.getString(R.string.title_baidu_map));
        mapItemVo.setType(2);
        arrayList.add(mapItemVo);
        MapItemVo mapItemVo2 = new MapItemVo();
        mapItemVo2.setName(x.getString(R.string.title_gd_map));
        mapItemVo2.setType(1);
        arrayList.add(mapItemVo2);
        if (arrayList.isEmpty()) {
            MapItemVo mapItemVo3 = new MapItemVo();
            mapItemVo3.setName(x.getString(R.string.title_tip_map));
            mapItemVo3.setType(3);
            arrayList.add(mapItemVo3);
        }
        MapItemVo mapItemVo4 = new MapItemVo();
        mapItemVo4.setName(x.getString(R.string.title_cancel));
        mapItemVo4.setType(3);
        arrayList.add(mapItemVo4);
        return arrayList;
    }
}
