package com.alibaba.android.arouter.routes;

import com.alibaba.android.arouter.facade.enums.RouteType;
import com.alibaba.android.arouter.facade.model.RouteMeta;
import com.alibaba.android.arouter.facade.template.IRouteGroup;
import com.chinavisionary.microtang.open.LiveCheckActivity;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class ARouter$$Group$$live_check implements IRouteGroup {
    @Override // com.alibaba.android.arouter.facade.template.IRouteGroup
    public void loadInto(Map<String, RouteMeta> map) {
        map.put("/live_check/live_check", RouteMeta.build(RouteType.ACTIVITY, LiveCheckActivity.class, "/live_check/live_check", "live_check", new HashMap<String, Integer>() { // from class: com.alibaba.android.arouter.routes.ARouter$$Group$$live_check.1
            {
                put("isShowAlert", 0);
                put("isFinish", 0);
                put("showDate", 8);
                put("key", 8);
            }
        }, -1, Integer.MIN_VALUE));
    }
}
