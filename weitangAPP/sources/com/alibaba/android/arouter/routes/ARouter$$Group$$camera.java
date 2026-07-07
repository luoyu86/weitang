package com.alibaba.android.arouter.routes;

import c.e.b.c.d.d;
import com.alibaba.android.arouter.facade.enums.RouteType;
import com.alibaba.android.arouter.facade.model.RouteMeta;
import com.alibaba.android.arouter.facade.template.IRouteGroup;
import com.chinavisionary.core.photo.photopicker.camera.CameraActivity;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class ARouter$$Group$$camera implements IRouteGroup {
    @Override // com.alibaba.android.arouter.facade.template.IRouteGroup
    public void loadInto(Map<String, RouteMeta> map) {
        map.put("/camera/rout", RouteMeta.build(RouteType.ACTIVITY, CameraActivity.class, "/camera/rout", d.SOURCE_TYPE_CAMERA, new HashMap<String, Integer>() { // from class: com.alibaba.android.arouter.routes.ARouter$$Group$$camera.1
            {
                put("isShowChangeBtn", 0);
            }
        }, -1, Integer.MIN_VALUE));
    }
}
