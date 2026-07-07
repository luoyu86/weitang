package com.alibaba.android.arouter.routes;

import com.alibaba.android.arouter.facade.enums.RouteType;
import com.alibaba.android.arouter.facade.model.RouteMeta;
import com.alibaba.android.arouter.facade.template.IRouteGroup;
import com.chinavisionary.microtang.bill.BillTabActivity;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class ARouter$$Group$$bill_tab implements IRouteGroup {
    @Override // com.alibaba.android.arouter.facade.template.IRouteGroup
    public void loadInto(Map<String, RouteMeta> map) {
        map.put("/bill_tab/bill_tab", RouteMeta.build(RouteType.ACTIVITY, BillTabActivity.class, "/bill_tab/bill_tab", "bill_tab", null, -1, Integer.MIN_VALUE));
    }
}
