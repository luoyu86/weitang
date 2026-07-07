package com.alibaba.android.arouter.routes;

import com.alibaba.android.arouter.facade.enums.RouteType;
import com.alibaba.android.arouter.facade.model.RouteMeta;
import com.alibaba.android.arouter.facade.template.IRouteGroup;
import com.chinavisionary.microtang.login.LoginActivity;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class ARouter$$Group$$login implements IRouteGroup {
    @Override // com.alibaba.android.arouter.facade.template.IRouteGroup
    public void loadInto(Map<String, RouteMeta> map) {
        map.put("/login/login", RouteMeta.build(RouteType.ACTIVITY, LoginActivity.class, "/login/login", "login", null, -1, Integer.MIN_VALUE));
    }
}
