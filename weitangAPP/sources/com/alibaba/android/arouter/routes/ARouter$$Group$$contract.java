package com.alibaba.android.arouter.routes;

import com.alibaba.android.arouter.facade.enums.RouteType;
import com.alibaba.android.arouter.facade.model.RouteMeta;
import com.alibaba.android.arouter.facade.template.IRouteGroup;
import com.chinavisionary.microtang.contract.ContractActivity;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class ARouter$$Group$$contract implements IRouteGroup {
    @Override // com.alibaba.android.arouter.facade.template.IRouteGroup
    public void loadInto(Map<String, RouteMeta> map) {
        map.put("/contract/contract", RouteMeta.build(RouteType.ACTIVITY, ContractActivity.class, "/contract/contract", "contract", null, -1, Integer.MIN_VALUE));
    }
}
