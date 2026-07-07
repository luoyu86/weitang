package com.alibaba.android.arouter.routes;

import com.alibaba.android.arouter.facade.enums.RouteType;
import com.alibaba.android.arouter.facade.model.RouteMeta;
import com.alibaba.android.arouter.facade.template.IRouteGroup;
import com.chinavisionary.microtang.main.fragments.AppAlertFragment;
import com.taobao.accs.common.Constants;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class ARouter$$Group$$message implements IRouteGroup {
    @Override // com.alibaba.android.arouter.facade.template.IRouteGroup
    public void loadInto(Map<String, RouteMeta> map) {
        map.put("/message/window", RouteMeta.build(RouteType.FRAGMENT, AppAlertFragment.class, "/message/window", Constants.SHARED_MESSAGE_ID_FILE, null, -1, Integer.MIN_VALUE));
    }
}
