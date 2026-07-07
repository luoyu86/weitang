package com.alibaba.android.arouter.routes;

import com.alibaba.android.arouter.facade.enums.RouteType;
import com.alibaba.android.arouter.facade.model.RouteMeta;
import com.alibaba.android.arouter.facade.template.IRouteGroup;
import com.chinavisionary.microtang.auth.IDAuthActivity;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class ARouter$$Group$$id_auth implements IRouteGroup {
    @Override // com.alibaba.android.arouter.facade.template.IRouteGroup
    public void loadInto(Map<String, RouteMeta> map) {
        map.put("/id_auth/id_auth", RouteMeta.build(RouteType.ACTIVITY, IDAuthActivity.class, "/id_auth/id_auth", "id_auth", null, -1, Integer.MIN_VALUE));
    }
}
