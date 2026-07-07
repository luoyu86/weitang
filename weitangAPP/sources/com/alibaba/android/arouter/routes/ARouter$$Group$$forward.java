package com.alibaba.android.arouter.routes;

import com.alibaba.android.arouter.facade.enums.RouteType;
import com.alibaba.android.arouter.facade.model.RouteMeta;
import com.alibaba.android.arouter.facade.template.IRouteGroup;
import com.chinavisionary.microtang.base.ForwardActivity;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class ARouter$$Group$$forward implements IRouteGroup {
    @Override // com.alibaba.android.arouter.facade.template.IRouteGroup
    public void loadInto(Map<String, RouteMeta> map) {
        map.put("/forward/forward", RouteMeta.build(RouteType.ACTIVITY, ForwardActivity.class, "/forward/forward", "forward", new HashMap<String, Integer>() { // from class: com.alibaba.android.arouter.routes.ARouter$$Group$$forward.1
            {
                put("forwardType", 3);
                put("href", 8);
                put("title", 8);
            }
        }, -1, Integer.MIN_VALUE));
    }
}
