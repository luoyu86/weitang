package com.alibaba.android.arouter.routes;

import com.alibaba.android.arouter.facade.enums.RouteType;
import com.alibaba.android.arouter.facade.model.RouteMeta;
import com.alibaba.android.arouter.facade.template.IRouteGroup;
import com.chinavisionary.microtang.web.WebViewActivity;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class ARouter$$Group$$webview implements IRouteGroup {
    @Override // com.alibaba.android.arouter.facade.template.IRouteGroup
    public void loadInto(Map<String, RouteMeta> map) {
        map.put("/webview/webview", RouteMeta.build(RouteType.ACTIVITY, WebViewActivity.class, "/webview/webview", "webview", new HashMap<String, Integer>() { // from class: com.alibaba.android.arouter.routes.ARouter$$Group$$webview.1
            {
                put("isFddContract", 0);
                put("payFeeType", 3);
                put("signUrl", 8);
                put("returnUrl", 8);
            }
        }, -1, Integer.MIN_VALUE));
    }
}
