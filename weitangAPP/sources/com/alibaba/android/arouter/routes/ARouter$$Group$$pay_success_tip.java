package com.alibaba.android.arouter.routes;

import com.alibaba.android.arouter.facade.enums.RouteType;
import com.alibaba.android.arouter.facade.model.RouteMeta;
import com.alibaba.android.arouter.facade.template.IRouteGroup;
import com.chinavisionary.microtang.main.activity.PaySuccessTipActivity;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class ARouter$$Group$$pay_success_tip implements IRouteGroup {
    @Override // com.alibaba.android.arouter.facade.template.IRouteGroup
    public void loadInto(Map<String, RouteMeta> map) {
        map.put("/pay_success_tip/pay_success_tip", RouteMeta.build(RouteType.ACTIVITY, PaySuccessTipActivity.class, "/pay_success_tip/pay_success_tip", "pay_success_tip", new HashMap<String, Integer>() { // from class: com.alibaba.android.arouter.routes.ARouter$$Group$$pay_success_tip.1
            {
                put("appletJsonKey", 8);
            }
        }, -1, Integer.MIN_VALUE));
    }
}
