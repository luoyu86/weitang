package com.alibaba.android.arouter.routes;

import com.alibaba.android.arouter.facade.enums.RouteType;
import com.alibaba.android.arouter.facade.model.RouteMeta;
import com.alibaba.android.arouter.facade.template.IRouteGroup;
import com.chinavisionary.microtang.pre.ReserveListActivity;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class ARouter$$Group$$reserve_list implements IRouteGroup {
    @Override // com.alibaba.android.arouter.facade.template.IRouteGroup
    public void loadInto(Map<String, RouteMeta> map) {
        map.put("/reserve_list/reserve_list", RouteMeta.build(RouteType.ACTIVITY, ReserveListActivity.class, "/reserve_list/reserve_list", "reserve_list", null, -1, Integer.MIN_VALUE));
    }
}
